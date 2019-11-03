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
    // InternalRoom.g:77:1: ruleRoomModel returns [EObject current=null] : (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_imports_5_0= ruleImport ) )* ( (lv_annotationTypes_6_0= ruleAnnotationType ) )* ( (lv_roomClasses_7_0= ruleRoomClass ) )* otherlv_8= '}' ) ;
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
            // InternalRoom.g:80:28: ( (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_imports_5_0= ruleImport ) )* ( (lv_annotationTypes_6_0= ruleAnnotationType ) )* ( (lv_roomClasses_7_0= ruleRoomClass ) )* otherlv_8= '}' ) )
            // InternalRoom.g:81:1: (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_imports_5_0= ruleImport ) )* ( (lv_annotationTypes_6_0= ruleAnnotationType ) )* ( (lv_roomClasses_7_0= ruleRoomClass ) )* otherlv_8= '}' )
            {
            // InternalRoom.g:81:1: (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_imports_5_0= ruleImport ) )* ( (lv_annotationTypes_6_0= ruleAnnotationType ) )* ( (lv_roomClasses_7_0= ruleRoomClass ) )* otherlv_8= '}' )
            // InternalRoom.g:81:3: otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_imports_5_0= ruleImport ) )* ( (lv_annotationTypes_6_0= ruleAnnotationType ) )* ( (lv_roomClasses_7_0= ruleRoomClass ) )* otherlv_8= '}'
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
                
            // InternalRoom.g:125:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==109) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRoom.g:126:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:126:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:127:3: lv_annotations_4_0= ruleAnnotation
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

            // InternalRoom.g:143:3: ( (lv_imports_5_0= ruleImport ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==115) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRoom.g:144:1: (lv_imports_5_0= ruleImport )
            	    {
            	    // InternalRoom.g:144:1: (lv_imports_5_0= ruleImport )
            	    // InternalRoom.g:145:3: lv_imports_5_0= ruleImport
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

            // InternalRoom.g:161:3: ( (lv_annotationTypes_6_0= ruleAnnotationType ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==110) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalRoom.g:162:1: (lv_annotationTypes_6_0= ruleAnnotationType )
            	    {
            	    // InternalRoom.g:162:1: (lv_annotationTypes_6_0= ruleAnnotationType )
            	    // InternalRoom.g:163:3: lv_annotationTypes_6_0= ruleAnnotationType
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

            // InternalRoom.g:179:3: ( (lv_roomClasses_7_0= ruleRoomClass ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19||LA5_0==24||(LA5_0>=28 && LA5_0<=29)||LA5_0==43||LA5_0==49||(LA5_0>=55 && LA5_0<=56)||LA5_0==65||LA5_0==67||(LA5_0>=125 && LA5_0<=127)||LA5_0==129) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalRoom.g:180:1: (lv_roomClasses_7_0= ruleRoomClass )
            	    {
            	    // InternalRoom.g:180:1: (lv_roomClasses_7_0= ruleRoomClass )
            	    // InternalRoom.g:181:3: lv_roomClasses_7_0= ruleRoomClass
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
    // InternalRoom.g:209:1: entryRuleRoomClass returns [EObject current=null] : iv_ruleRoomClass= ruleRoomClass EOF ;
    public final EObject entryRuleRoomClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoomClass = null;


        try {
            // InternalRoom.g:210:2: (iv_ruleRoomClass= ruleRoomClass EOF )
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
    // InternalRoom.g:218:1: ruleRoomClass returns [EObject current=null] : (this_DataType_0= ruleDataType | this_GeneralProtocolClass_1= ruleGeneralProtocolClass | this_StructureClass_2= ruleStructureClass ) ;
    public final EObject ruleRoomClass() throws RecognitionException {
        EObject current = null;

        EObject this_DataType_0 = null;

        EObject this_GeneralProtocolClass_1 = null;

        EObject this_StructureClass_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:221:28: ( (this_DataType_0= ruleDataType | this_GeneralProtocolClass_1= ruleGeneralProtocolClass | this_StructureClass_2= ruleStructureClass ) )
            // InternalRoom.g:222:1: (this_DataType_0= ruleDataType | this_GeneralProtocolClass_1= ruleGeneralProtocolClass | this_StructureClass_2= ruleStructureClass )
            {
            // InternalRoom.g:222:1: (this_DataType_0= ruleDataType | this_GeneralProtocolClass_1= ruleGeneralProtocolClass | this_StructureClass_2= ruleStructureClass )
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
            case 125:
                {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==43) ) {
                    alt6=2;
                }
                else if ( ((LA6_2>=55 && LA6_2<=56)||(LA6_2>=125 && LA6_2<=127)||LA6_2==129) ) {
                    alt6=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }
                }
                break;
            case 126:
                {
                int LA6_3 = input.LA(2);

                if ( (LA6_3==43) ) {
                    alt6=2;
                }
                else if ( ((LA6_3>=55 && LA6_3<=56)||(LA6_3>=125 && LA6_3<=127)||LA6_3==129) ) {
                    alt6=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 3, input);

                    throw nvae;
                }
                }
                break;
            case 127:
                {
                int LA6_4 = input.LA(2);

                if ( (LA6_4==43) ) {
                    alt6=2;
                }
                else if ( ((LA6_4>=55 && LA6_4<=56)||(LA6_4>=125 && LA6_4<=127)||LA6_4==129) ) {
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
            case 49:
                {
                alt6=2;
                }
                break;
            case 55:
            case 56:
            case 65:
            case 67:
            case 129:
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
                    // InternalRoom.g:223:5: this_DataType_0= ruleDataType
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
                    // InternalRoom.g:233:5: this_GeneralProtocolClass_1= ruleGeneralProtocolClass
                    {
                     
                            newCompositeNode(grammarAccess.getRoomClassAccess().getGeneralProtocolClassParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_GeneralProtocolClass_1=ruleGeneralProtocolClass();

                    state._fsp--;

                     
                            current = this_GeneralProtocolClass_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalRoom.g:243:5: this_StructureClass_2= ruleStructureClass
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
    // InternalRoom.g:259:1: entryRuleStructureClass returns [EObject current=null] : iv_ruleStructureClass= ruleStructureClass EOF ;
    public final EObject entryRuleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructureClass = null;


        try {
            // InternalRoom.g:260:2: (iv_ruleStructureClass= ruleStructureClass EOF )
            // InternalRoom.g:261:2: iv_ruleStructureClass= ruleStructureClass EOF
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
    // InternalRoom.g:268:1: ruleStructureClass returns [EObject current=null] : (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) ;
    public final EObject ruleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorContainerClass_0 = null;

        EObject this_LogicalSystem_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:271:28: ( (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) )
            // InternalRoom.g:272:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            {
            // InternalRoom.g:272:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=55 && LA7_0<=56)||LA7_0==67||(LA7_0>=125 && LA7_0<=127)||LA7_0==129) ) {
                alt7=1;
            }
            else if ( (LA7_0==65) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalRoom.g:273:5: this_ActorContainerClass_0= ruleActorContainerClass
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
                    // InternalRoom.g:283:5: this_LogicalSystem_1= ruleLogicalSystem
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
    // InternalRoom.g:299:1: entryRuleActorContainerClass returns [EObject current=null] : iv_ruleActorContainerClass= ruleActorContainerClass EOF ;
    public final EObject entryRuleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorContainerClass = null;


        try {
            // InternalRoom.g:300:2: (iv_ruleActorContainerClass= ruleActorContainerClass EOF )
            // InternalRoom.g:301:2: iv_ruleActorContainerClass= ruleActorContainerClass EOF
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
    // InternalRoom.g:308:1: ruleActorContainerClass returns [EObject current=null] : (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) ;
    public final EObject ruleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorClass_0 = null;

        EObject this_SubSystemClass_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:311:28: ( (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) )
            // InternalRoom.g:312:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            {
            // InternalRoom.g:312:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=55 && LA8_0<=56)||(LA8_0>=125 && LA8_0<=127)||LA8_0==129) ) {
                alt8=1;
            }
            else if ( (LA8_0==67) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalRoom.g:313:5: this_ActorClass_0= ruleActorClass
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
                    // InternalRoom.g:323:5: this_SubSystemClass_1= ruleSubSystemClass
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
    // InternalRoom.g:339:1: entryRuleVarDecl returns [EObject current=null] : iv_ruleVarDecl= ruleVarDecl EOF ;
    public final EObject entryRuleVarDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDecl = null;


        try {
            // InternalRoom.g:340:2: (iv_ruleVarDecl= ruleVarDecl EOF )
            // InternalRoom.g:341:2: iv_ruleVarDecl= ruleVarDecl EOF
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
    // InternalRoom.g:348:1: ruleVarDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )? ) ;
    public final EObject ruleVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_varargs_3_0=null;
        EObject lv_refType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:351:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )? ) )
            // InternalRoom.g:352:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )? )
            {
            // InternalRoom.g:352:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )? )
            // InternalRoom.g:352:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )?
            {
            // InternalRoom.g:352:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalRoom.g:353:1: (lv_name_0_0= RULE_ID )
            {
            // InternalRoom.g:353:1: (lv_name_0_0= RULE_ID )
            // InternalRoom.g:354:3: lv_name_0_0= RULE_ID
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
                
            // InternalRoom.g:374:1: ( (lv_refType_2_0= ruleRefableType ) )
            // InternalRoom.g:375:1: (lv_refType_2_0= ruleRefableType )
            {
            // InternalRoom.g:375:1: (lv_refType_2_0= ruleRefableType )
            // InternalRoom.g:376:3: lv_refType_2_0= ruleRefableType
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

            // InternalRoom.g:392:2: ( (lv_varargs_3_0= 'varargs' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalRoom.g:393:1: (lv_varargs_3_0= 'varargs' )
                    {
                    // InternalRoom.g:393:1: (lv_varargs_3_0= 'varargs' )
                    // InternalRoom.g:394:3: lv_varargs_3_0= 'varargs'
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
    // InternalRoom.g:415:1: entryRuleMessageData returns [EObject current=null] : iv_ruleMessageData= ruleMessageData EOF ;
    public final EObject entryRuleMessageData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageData = null;


        try {
            // InternalRoom.g:416:2: (iv_ruleMessageData= ruleMessageData EOF )
            // InternalRoom.g:417:2: iv_ruleMessageData= ruleMessageData EOF
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
    // InternalRoom.g:424:1: ruleMessageData returns [EObject current=null] : ( ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) ) ) ;
    public final EObject ruleMessageData() throws RecognitionException {
        EObject current = null;

        Token lv_deprecatedName_0_0=null;
        Token otherlv_1=null;
        EObject lv_refType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:427:28: ( ( ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) ) ) )
            // InternalRoom.g:428:1: ( ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) ) )
            {
            // InternalRoom.g:428:1: ( ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) ) )
            // InternalRoom.g:428:2: ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) )
            {
            // InternalRoom.g:428:2: ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )?
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
                    // InternalRoom.g:428:3: ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':'
                    {
                    // InternalRoom.g:428:3: ( (lv_deprecatedName_0_0= RULE_ID ) )
                    // InternalRoom.g:429:1: (lv_deprecatedName_0_0= RULE_ID )
                    {
                    // InternalRoom.g:429:1: (lv_deprecatedName_0_0= RULE_ID )
                    // InternalRoom.g:430:3: lv_deprecatedName_0_0= RULE_ID
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

            // InternalRoom.g:450:3: ( (lv_refType_2_0= ruleRefableType ) )
            // InternalRoom.g:451:1: (lv_refType_2_0= ruleRefableType )
            {
            // InternalRoom.g:451:1: (lv_refType_2_0= ruleRefableType )
            // InternalRoom.g:452:3: lv_refType_2_0= ruleRefableType
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
    // InternalRoom.g:476:1: entryRuleRefableType returns [EObject current=null] : iv_ruleRefableType= ruleRefableType EOF ;
    public final EObject entryRuleRefableType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefableType = null;


        try {
            // InternalRoom.g:477:2: (iv_ruleRefableType= ruleRefableType EOF )
            // InternalRoom.g:478:2: iv_ruleRefableType= ruleRefableType EOF
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
    // InternalRoom.g:485:1: ruleRefableType returns [EObject current=null] : ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? ) ;
    public final EObject ruleRefableType() throws RecognitionException {
        EObject current = null;

        Token lv_ref_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:488:28: ( ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? ) )
            // InternalRoom.g:489:1: ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? )
            {
            // InternalRoom.g:489:1: ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? )
            // InternalRoom.g:489:2: ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )?
            {
            // InternalRoom.g:489:2: ( ( ruleFQN ) )
            // InternalRoom.g:490:1: ( ruleFQN )
            {
            // InternalRoom.g:490:1: ( ruleFQN )
            // InternalRoom.g:491:3: ruleFQN
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

            // InternalRoom.g:504:2: ( (lv_ref_1_0= 'ref' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalRoom.g:505:1: (lv_ref_1_0= 'ref' )
                    {
                    // InternalRoom.g:505:1: (lv_ref_1_0= 'ref' )
                    // InternalRoom.g:506:3: lv_ref_1_0= 'ref'
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
    // InternalRoom.g:527:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // InternalRoom.g:528:2: (iv_ruleDataType= ruleDataType EOF )
            // InternalRoom.g:529:2: iv_ruleDataType= ruleDataType EOF
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
    // InternalRoom.g:536:1: ruleDataType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_EnumerationType_1 = null;

        EObject this_ComplexType_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:539:28: ( (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType ) )
            // InternalRoom.g:540:1: (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType )
            {
            // InternalRoom.g:540:1: (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType )
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
                    // InternalRoom.g:541:5: this_PrimitiveType_0= rulePrimitiveType
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
                    // InternalRoom.g:551:5: this_EnumerationType_1= ruleEnumerationType
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
                    // InternalRoom.g:561:5: this_ComplexType_2= ruleComplexType
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
    // InternalRoom.g:577:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalRoom.g:578:2: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalRoom.g:579:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalRoom.g:586:1: ruleComplexType returns [EObject current=null] : (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataClass_0 = null;

        EObject this_ExternalType_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:589:28: ( (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) )
            // InternalRoom.g:590:1: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
            {
            // InternalRoom.g:590:1: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
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
                    // InternalRoom.g:591:5: this_DataClass_0= ruleDataClass
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
                    // InternalRoom.g:601:5: this_ExternalType_1= ruleExternalType
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
    // InternalRoom.g:617:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalRoom.g:618:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalRoom.g:619:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalRoom.g:626:1: rulePrimitiveType returns [EObject current=null] : (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:629:28: ( (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:630:1: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:630:1: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? )
            // InternalRoom.g:630:3: otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getPrimitiveTypeAccess().getPrimitiveTypeKeyword_0());
                
            // InternalRoom.g:634:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:635:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:635:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:636:3: lv_name_1_0= RULE_ID
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
                
            // InternalRoom.g:656:1: ( (lv_type_3_0= ruleLiteralType ) )
            // InternalRoom.g:657:1: (lv_type_3_0= ruleLiteralType )
            {
            // InternalRoom.g:657:1: (lv_type_3_0= ruleLiteralType )
            // InternalRoom.g:658:3: lv_type_3_0= ruleLiteralType
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
                
            // InternalRoom.g:678:1: ( (lv_targetName_5_0= RULE_STRING ) )
            // InternalRoom.g:679:1: (lv_targetName_5_0= RULE_STRING )
            {
            // InternalRoom.g:679:1: (lv_targetName_5_0= RULE_STRING )
            // InternalRoom.g:680:3: lv_targetName_5_0= RULE_STRING
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

            // InternalRoom.g:696:2: (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalRoom.g:696:4: otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,21,FOLLOW_3); 

                        	newLeafNode(otherlv_6, grammarAccess.getPrimitiveTypeAccess().getLeftParenthesisKeyword_6_0());
                        
                    // InternalRoom.g:700:1: ( (lv_castName_7_0= ruleFQN ) )
                    // InternalRoom.g:701:1: (lv_castName_7_0= ruleFQN )
                    {
                    // InternalRoom.g:701:1: (lv_castName_7_0= ruleFQN )
                    // InternalRoom.g:702:3: lv_castName_7_0= ruleFQN
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
                
            // InternalRoom.g:726:1: ( (lv_defaultValueLiteral_10_0= RULE_STRING ) )
            // InternalRoom.g:727:1: (lv_defaultValueLiteral_10_0= RULE_STRING )
            {
            // InternalRoom.g:727:1: (lv_defaultValueLiteral_10_0= RULE_STRING )
            // InternalRoom.g:728:3: lv_defaultValueLiteral_10_0= RULE_STRING
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

            // InternalRoom.g:744:2: ( (lv_docu_11_0= ruleDocumentation ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRoom.g:745:1: (lv_docu_11_0= ruleDocumentation )
                    {
                    // InternalRoom.g:745:1: (lv_docu_11_0= ruleDocumentation )
                    // InternalRoom.g:746:3: lv_docu_11_0= ruleDocumentation
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
    // InternalRoom.g:770:1: entryRuleEnumerationType returns [EObject current=null] : iv_ruleEnumerationType= ruleEnumerationType EOF ;
    public final EObject entryRuleEnumerationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationType = null;


        try {
            // InternalRoom.g:771:2: (iv_ruleEnumerationType= ruleEnumerationType EOF )
            // InternalRoom.g:772:2: iv_ruleEnumerationType= ruleEnumerationType EOF
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
    // InternalRoom.g:779:1: ruleEnumerationType returns [EObject current=null] : (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' ) ;
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
            // InternalRoom.g:782:28: ( (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' ) )
            // InternalRoom.g:783:1: (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' )
            {
            // InternalRoom.g:783:1: (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' )
            // InternalRoom.g:783:3: otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getEnumerationTypeAccess().getEnumerationKeyword_0());
                
            // InternalRoom.g:787:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:788:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:788:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:789:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:805:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalRoom.g:806:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:806:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:807:3: lv_docu_2_0= ruleDocumentation
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

            // InternalRoom.g:823:3: (otherlv_3= 'of' ( ( ruleFQN ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalRoom.g:823:5: otherlv_3= 'of' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getEnumerationTypeAccess().getOfKeyword_3_0());
                        
                    // InternalRoom.g:827:1: ( ( ruleFQN ) )
                    // InternalRoom.g:828:1: ( ruleFQN )
                    {
                    // InternalRoom.g:828:1: ( ruleFQN )
                    // InternalRoom.g:829:3: ruleFQN
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
                
            // InternalRoom.g:846:1: ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalRoom.g:846:2: ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )*
                    {
                    // InternalRoom.g:846:2: ( (lv_literals_6_0= ruleEnumLiteral ) )
                    // InternalRoom.g:847:1: (lv_literals_6_0= ruleEnumLiteral )
                    {
                    // InternalRoom.g:847:1: (lv_literals_6_0= ruleEnumLiteral )
                    // InternalRoom.g:848:3: lv_literals_6_0= ruleEnumLiteral
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

                    // InternalRoom.g:864:2: (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==26) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalRoom.g:864:4: otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) )
                    	    {
                    	    otherlv_7=(Token)match(input,26,FOLLOW_3); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getEnumerationTypeAccess().getCommaKeyword_5_1_0());
                    	        
                    	    // InternalRoom.g:868:1: ( (lv_literals_8_0= ruleEnumLiteral ) )
                    	    // InternalRoom.g:869:1: (lv_literals_8_0= ruleEnumLiteral )
                    	    {
                    	    // InternalRoom.g:869:1: (lv_literals_8_0= ruleEnumLiteral )
                    	    // InternalRoom.g:870:3: lv_literals_8_0= ruleEnumLiteral
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
    // InternalRoom.g:898:1: entryRuleEnumLiteral returns [EObject current=null] : iv_ruleEnumLiteral= ruleEnumLiteral EOF ;
    public final EObject entryRuleEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteral = null;


        try {
            // InternalRoom.g:899:2: (iv_ruleEnumLiteral= ruleEnumLiteral EOF )
            // InternalRoom.g:900:2: iv_ruleEnumLiteral= ruleEnumLiteral EOF
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
    // InternalRoom.g:907:1: ruleEnumLiteral returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? ) ;
    public final EObject ruleEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_literal_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:910:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? ) )
            // InternalRoom.g:911:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? )
            {
            // InternalRoom.g:911:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? )
            // InternalRoom.g:911:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )?
            {
            // InternalRoom.g:911:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalRoom.g:912:1: (lv_name_0_0= RULE_ID )
            {
            // InternalRoom.g:912:1: (lv_name_0_0= RULE_ID )
            // InternalRoom.g:913:3: lv_name_0_0= RULE_ID
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

            // InternalRoom.g:929:2: (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalRoom.g:929:4: otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) )
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_25); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumLiteralAccess().getEqualsSignKeyword_1_0());
                        
                    // InternalRoom.g:933:1: ( (lv_literal_2_0= ruleIntLiteral ) )
                    // InternalRoom.g:934:1: (lv_literal_2_0= ruleIntLiteral )
                    {
                    // InternalRoom.g:934:1: (lv_literal_2_0= ruleIntLiteral )
                    // InternalRoom.g:935:3: lv_literal_2_0= ruleIntLiteral
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
    // InternalRoom.g:959:1: entryRuleExternalType returns [EObject current=null] : iv_ruleExternalType= ruleExternalType EOF ;
    public final EObject entryRuleExternalType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalType = null;


        try {
            // InternalRoom.g:960:2: (iv_ruleExternalType= ruleExternalType EOF )
            // InternalRoom.g:961:2: iv_ruleExternalType= ruleExternalType EOF
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
    // InternalRoom.g:968:1: ruleExternalType returns [EObject current=null] : (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:971:28: ( (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:972:1: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:972:1: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? )
            // InternalRoom.g:972:3: otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalTypeAccess().getExternalTypeKeyword_0());
                
            // InternalRoom.g:976:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:977:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:977:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:978:3: lv_name_1_0= RULE_ID
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
                
            // InternalRoom.g:998:1: ( (lv_targetName_3_0= RULE_STRING ) )
            // InternalRoom.g:999:1: (lv_targetName_3_0= RULE_STRING )
            {
            // InternalRoom.g:999:1: (lv_targetName_3_0= RULE_STRING )
            // InternalRoom.g:1000:3: lv_targetName_3_0= RULE_STRING
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

            // InternalRoom.g:1016:2: (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRoom.g:1016:4: otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_15); 

                        	newLeafNode(otherlv_4, grammarAccess.getExternalTypeAccess().getDefaultKeyword_4_0());
                        
                    // InternalRoom.g:1020:1: ( (lv_defaultValueLiteral_5_0= RULE_STRING ) )
                    // InternalRoom.g:1021:1: (lv_defaultValueLiteral_5_0= RULE_STRING )
                    {
                    // InternalRoom.g:1021:1: (lv_defaultValueLiteral_5_0= RULE_STRING )
                    // InternalRoom.g:1022:3: lv_defaultValueLiteral_5_0= RULE_STRING
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

            // InternalRoom.g:1038:4: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==35) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalRoom.g:1039:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1039:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:1040:3: lv_docu_6_0= ruleDocumentation
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
    // InternalRoom.g:1064:1: entryRuleDataClass returns [EObject current=null] : iv_ruleDataClass= ruleDataClass EOF ;
    public final EObject entryRuleDataClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataClass = null;


        try {
            // InternalRoom.g:1065:2: (iv_ruleDataClass= ruleDataClass EOF )
            // InternalRoom.g:1066:2: iv_ruleDataClass= ruleDataClass EOF
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
    // InternalRoom.g:1073:1: ruleDataClass returns [EObject current=null] : (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' ) ;
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
            // InternalRoom.g:1076:28: ( (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' ) )
            // InternalRoom.g:1077:1: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' )
            {
            // InternalRoom.g:1077:1: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' )
            // InternalRoom.g:1077:3: otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getDataClassAccess().getDataClassKeyword_0());
                
            // InternalRoom.g:1081:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1082:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1082:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1083:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:1099:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==35) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalRoom.g:1100:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1100:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:1101:3: lv_docu_2_0= ruleDocumentation
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

            // InternalRoom.g:1117:3: (otherlv_3= 'extends' ( ( ruleFQN ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==30) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalRoom.g:1117:5: otherlv_3= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getDataClassAccess().getExtendsKeyword_3_0());
                        
                    // InternalRoom.g:1121:1: ( ( ruleFQN ) )
                    // InternalRoom.g:1122:1: ( ruleFQN )
                    {
                    // InternalRoom.g:1122:1: ( ruleFQN )
                    // InternalRoom.g:1123:3: ruleFQN
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
                
            // InternalRoom.g:1140:1: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==109) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalRoom.g:1141:1: (lv_annotations_6_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:1141:1: (lv_annotations_6_0= ruleAnnotation )
            	    // InternalRoom.g:1142:3: lv_annotations_6_0= ruleAnnotation
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

            // InternalRoom.g:1158:3: (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==31) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalRoom.g:1158:5: otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,31,FOLLOW_30); 

                        	newLeafNode(otherlv_7, grammarAccess.getDataClassAccess().getUsercode1Keyword_6_0());
                        
                    // InternalRoom.g:1162:1: ( (lv_userCode1_8_0= ruleDetailCode ) )
                    // InternalRoom.g:1163:1: (lv_userCode1_8_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1163:1: (lv_userCode1_8_0= ruleDetailCode )
                    // InternalRoom.g:1164:3: lv_userCode1_8_0= ruleDetailCode
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

            // InternalRoom.g:1180:4: (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==32) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRoom.g:1180:6: otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,32,FOLLOW_32); 

                        	newLeafNode(otherlv_9, grammarAccess.getDataClassAccess().getUsercode2Keyword_7_0());
                        
                    // InternalRoom.g:1184:1: ( (lv_userCode2_10_0= ruleDetailCode ) )
                    // InternalRoom.g:1185:1: (lv_userCode2_10_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1185:1: (lv_userCode2_10_0= ruleDetailCode )
                    // InternalRoom.g:1186:3: lv_userCode2_10_0= ruleDetailCode
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

            // InternalRoom.g:1202:4: (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalRoom.g:1202:6: otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,33,FOLLOW_34); 

                        	newLeafNode(otherlv_11, grammarAccess.getDataClassAccess().getUsercode3Keyword_8_0());
                        
                    // InternalRoom.g:1206:1: ( (lv_userCode3_12_0= ruleDetailCode ) )
                    // InternalRoom.g:1207:1: (lv_userCode3_12_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1207:1: (lv_userCode3_12_0= ruleDetailCode )
                    // InternalRoom.g:1208:3: lv_userCode3_12_0= ruleDetailCode
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

            // InternalRoom.g:1224:4: ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )*
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
            	    // InternalRoom.g:1224:5: ( (lv_operations_13_0= ruleStandardOperation ) )
            	    {
            	    // InternalRoom.g:1224:5: ( (lv_operations_13_0= ruleStandardOperation ) )
            	    // InternalRoom.g:1225:1: (lv_operations_13_0= ruleStandardOperation )
            	    {
            	    // InternalRoom.g:1225:1: (lv_operations_13_0= ruleStandardOperation )
            	    // InternalRoom.g:1226:3: lv_operations_13_0= ruleStandardOperation
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
            	    // InternalRoom.g:1243:6: ( (lv_structors_14_0= ruleClassStructor ) )
            	    {
            	    // InternalRoom.g:1243:6: ( (lv_structors_14_0= ruleClassStructor ) )
            	    // InternalRoom.g:1244:1: (lv_structors_14_0= ruleClassStructor )
            	    {
            	    // InternalRoom.g:1244:1: (lv_structors_14_0= ruleClassStructor )
            	    // InternalRoom.g:1245:3: lv_structors_14_0= ruleClassStructor
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
            	    // InternalRoom.g:1262:6: ( (lv_attributes_15_0= ruleAttribute ) )
            	    {
            	    // InternalRoom.g:1262:6: ( (lv_attributes_15_0= ruleAttribute ) )
            	    // InternalRoom.g:1263:1: (lv_attributes_15_0= ruleAttribute )
            	    {
            	    // InternalRoom.g:1263:1: (lv_attributes_15_0= ruleAttribute )
            	    // InternalRoom.g:1264:3: lv_attributes_15_0= ruleAttribute
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
    // InternalRoom.g:1292:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalRoom.g:1293:2: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalRoom.g:1294:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalRoom.g:1301:1: ruleAttribute returns [EObject current=null] : (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:1304:28: ( (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:1305:1: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:1305:1: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? )
            // InternalRoom.g:1305:3: otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttributeKeyword_0());
                
            // InternalRoom.g:1309:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1310:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1310:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1311:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:1327:2: (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==35) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalRoom.g:1327:4: otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,35,FOLLOW_37); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // InternalRoom.g:1331:1: ( (lv_size_3_0= RULE_INT ) )
                    // InternalRoom.g:1332:1: (lv_size_3_0= RULE_INT )
                    {
                    // InternalRoom.g:1332:1: (lv_size_3_0= RULE_INT )
                    // InternalRoom.g:1333:3: lv_size_3_0= RULE_INT
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
                
            // InternalRoom.g:1357:1: ( (lv_type_6_0= ruleRefableType ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalRoom.g:1358:1: (lv_type_6_0= ruleRefableType )
                    {
                    // InternalRoom.g:1358:1: (lv_type_6_0= ruleRefableType )
                    // InternalRoom.g:1359:3: lv_type_6_0= ruleRefableType
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

            // InternalRoom.g:1375:3: (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==27) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalRoom.g:1375:5: otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,27,FOLLOW_15); 

                        	newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getEqualsSignKeyword_5_0());
                        
                    // InternalRoom.g:1379:1: ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
                    // InternalRoom.g:1380:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
                    {
                    // InternalRoom.g:1380:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
                    // InternalRoom.g:1381:3: lv_defaultValueLiteral_8_0= RULE_STRING
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

            // InternalRoom.g:1397:4: ( (lv_docu_9_0= ruleDocumentation ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==35) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalRoom.g:1398:1: (lv_docu_9_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1398:1: (lv_docu_9_0= ruleDocumentation )
                    // InternalRoom.g:1399:3: lv_docu_9_0= ruleDocumentation
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
    // InternalRoom.g:1425:1: entryRuleStandardOperation returns [EObject current=null] : iv_ruleStandardOperation= ruleStandardOperation EOF ;
    public final EObject entryRuleStandardOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStandardOperation = null;


        try {
            // InternalRoom.g:1426:2: (iv_ruleStandardOperation= ruleStandardOperation EOF )
            // InternalRoom.g:1427:2: iv_ruleStandardOperation= ruleStandardOperation EOF
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
    // InternalRoom.g:1434:1: ruleStandardOperation returns [EObject current=null] : ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) ) ;
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
            // InternalRoom.g:1437:28: ( ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:1438:1: ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:1438:1: ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) )
            // InternalRoom.g:1438:2: ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) )
            {
            // InternalRoom.g:1438:2: ( (lv_override_0_0= 'override' ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==37) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalRoom.g:1439:1: (lv_override_0_0= 'override' )
                    {
                    // InternalRoom.g:1439:1: (lv_override_0_0= 'override' )
                    // InternalRoom.g:1440:3: lv_override_0_0= 'override'
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
                
            // InternalRoom.g:1457:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:1458:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:1458:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:1459:3: lv_name_2_0= RULE_ID
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
                
            // InternalRoom.g:1479:1: ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalRoom.g:1479:2: ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )*
                    {
                    // InternalRoom.g:1479:2: ( (lv_arguments_4_0= ruleVarDecl ) )
                    // InternalRoom.g:1480:1: (lv_arguments_4_0= ruleVarDecl )
                    {
                    // InternalRoom.g:1480:1: (lv_arguments_4_0= ruleVarDecl )
                    // InternalRoom.g:1481:3: lv_arguments_4_0= ruleVarDecl
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

                    // InternalRoom.g:1497:2: (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==26) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalRoom.g:1497:4: otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_5=(Token)match(input,26,FOLLOW_3); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getStandardOperationAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // InternalRoom.g:1501:1: ( (lv_arguments_6_0= ruleVarDecl ) )
                    	    // InternalRoom.g:1502:1: (lv_arguments_6_0= ruleVarDecl )
                    	    {
                    	    // InternalRoom.g:1502:1: (lv_arguments_6_0= ruleVarDecl )
                    	    // InternalRoom.g:1503:3: lv_arguments_6_0= ruleVarDecl
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
                
            // InternalRoom.g:1523:1: (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==16) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalRoom.g:1523:3: otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) )
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_46); 

                        	newLeafNode(otherlv_8, grammarAccess.getStandardOperationAccess().getColonKeyword_6_0());
                        
                    // InternalRoom.g:1527:1: (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) )
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
                            // InternalRoom.g:1527:3: otherlv_9= 'void'
                            {
                            otherlv_9=(Token)match(input,39,FOLLOW_47); 

                                	newLeafNode(otherlv_9, grammarAccess.getStandardOperationAccess().getVoidKeyword_6_1_0());
                                

                            }
                            break;
                        case 2 :
                            // InternalRoom.g:1532:6: ( (lv_returnType_10_0= ruleRefableType ) )
                            {
                            // InternalRoom.g:1532:6: ( (lv_returnType_10_0= ruleRefableType ) )
                            // InternalRoom.g:1533:1: (lv_returnType_10_0= ruleRefableType )
                            {
                            // InternalRoom.g:1533:1: (lv_returnType_10_0= ruleRefableType )
                            // InternalRoom.g:1534:3: lv_returnType_10_0= ruleRefableType
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

            // InternalRoom.g:1550:5: ( (lv_docu_11_0= ruleDocumentation ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==35) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalRoom.g:1551:1: (lv_docu_11_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1551:1: (lv_docu_11_0= ruleDocumentation )
                    // InternalRoom.g:1552:3: lv_docu_11_0= ruleDocumentation
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

            // InternalRoom.g:1568:3: ( (lv_detailCode_12_0= ruleDetailCode ) )
            // InternalRoom.g:1569:1: (lv_detailCode_12_0= ruleDetailCode )
            {
            // InternalRoom.g:1569:1: (lv_detailCode_12_0= ruleDetailCode )
            // InternalRoom.g:1570:3: lv_detailCode_12_0= ruleDetailCode
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
    // InternalRoom.g:1594:1: entryRulePortOperation returns [EObject current=null] : iv_rulePortOperation= rulePortOperation EOF ;
    public final EObject entryRulePortOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortOperation = null;


        try {
            // InternalRoom.g:1595:2: (iv_rulePortOperation= rulePortOperation EOF )
            // InternalRoom.g:1596:2: iv_rulePortOperation= rulePortOperation EOF
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
    // InternalRoom.g:1603:1: rulePortOperation returns [EObject current=null] : (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) ) ;
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
            // InternalRoom.g:1606:28: ( (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:1607:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:1607:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) )
            // InternalRoom.g:1607:3: otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getPortOperationAccess().getOperationKeyword_0());
                
            // InternalRoom.g:1611:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1612:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1612:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1613:3: lv_name_1_0= RULE_ID
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
                
            // InternalRoom.g:1633:1: ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalRoom.g:1633:2: ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    {
                    // InternalRoom.g:1633:2: ( (lv_arguments_3_0= ruleVarDecl ) )
                    // InternalRoom.g:1634:1: (lv_arguments_3_0= ruleVarDecl )
                    {
                    // InternalRoom.g:1634:1: (lv_arguments_3_0= ruleVarDecl )
                    // InternalRoom.g:1635:3: lv_arguments_3_0= ruleVarDecl
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

                    // InternalRoom.g:1651:2: (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==26) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalRoom.g:1651:4: otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_4=(Token)match(input,26,FOLLOW_3); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getPortOperationAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // InternalRoom.g:1655:1: ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    // InternalRoom.g:1656:1: (lv_arguments_5_0= ruleVarDecl )
                    	    {
                    	    // InternalRoom.g:1656:1: (lv_arguments_5_0= ruleVarDecl )
                    	    // InternalRoom.g:1657:3: lv_arguments_5_0= ruleVarDecl
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
                
            // InternalRoom.g:1677:1: ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )?
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
                    // InternalRoom.g:1677:2: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) )
                    {
                    // InternalRoom.g:1677:2: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) )
                    // InternalRoom.g:1677:4: otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) )
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_46); 

                        	newLeafNode(otherlv_7, grammarAccess.getPortOperationAccess().getColonKeyword_5_0_0());
                        
                    // InternalRoom.g:1681:1: (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) )
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
                            // InternalRoom.g:1681:3: otherlv_8= 'void'
                            {
                            otherlv_8=(Token)match(input,39,FOLLOW_47); 

                                	newLeafNode(otherlv_8, grammarAccess.getPortOperationAccess().getVoidKeyword_5_0_1_0());
                                

                            }
                            break;
                        case 2 :
                            // InternalRoom.g:1686:6: ( (lv_returnType_9_0= ruleRefableType ) )
                            {
                            // InternalRoom.g:1686:6: ( (lv_returnType_9_0= ruleRefableType ) )
                            // InternalRoom.g:1687:1: (lv_returnType_9_0= ruleRefableType )
                            {
                            // InternalRoom.g:1687:1: (lv_returnType_9_0= ruleRefableType )
                            // InternalRoom.g:1688:3: lv_returnType_9_0= ruleRefableType
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
                    // InternalRoom.g:1705:6: (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalRoom.g:1705:6: (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) )
                    // InternalRoom.g:1705:8: otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) )
                    {
                    otherlv_10=(Token)match(input,40,FOLLOW_3); 

                        	newLeafNode(otherlv_10, grammarAccess.getPortOperationAccess().getSendsKeyword_5_1_0());
                        
                    // InternalRoom.g:1709:1: ( (otherlv_11= RULE_ID ) )
                    // InternalRoom.g:1710:1: (otherlv_11= RULE_ID )
                    {
                    // InternalRoom.g:1710:1: (otherlv_11= RULE_ID )
                    // InternalRoom.g:1711:3: otherlv_11= RULE_ID
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

            // InternalRoom.g:1722:5: ( (lv_docu_12_0= ruleDocumentation ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==35) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalRoom.g:1723:1: (lv_docu_12_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1723:1: (lv_docu_12_0= ruleDocumentation )
                    // InternalRoom.g:1724:3: lv_docu_12_0= ruleDocumentation
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

            // InternalRoom.g:1740:3: ( (lv_detailCode_13_0= ruleDetailCode ) )
            // InternalRoom.g:1741:1: (lv_detailCode_13_0= ruleDetailCode )
            {
            // InternalRoom.g:1741:1: (lv_detailCode_13_0= ruleDetailCode )
            // InternalRoom.g:1742:3: lv_detailCode_13_0= ruleDetailCode
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
    // InternalRoom.g:1766:1: entryRuleClassStructor returns [EObject current=null] : iv_ruleClassStructor= ruleClassStructor EOF ;
    public final EObject entryRuleClassStructor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassStructor = null;


        try {
            // InternalRoom.g:1767:2: (iv_ruleClassStructor= ruleClassStructor EOF )
            // InternalRoom.g:1768:2: iv_ruleClassStructor= ruleClassStructor EOF
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
    // InternalRoom.g:1775:1: ruleClassStructor returns [EObject current=null] : ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleClassStructor() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        EObject lv_detailCode_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:1778:28: ( ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:1779:1: ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:1779:1: ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) )
            // InternalRoom.g:1779:2: ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) )
            {
            // InternalRoom.g:1779:2: ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) )
            // InternalRoom.g:1780:1: ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) )
            {
            // InternalRoom.g:1780:1: ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) )
            // InternalRoom.g:1781:1: (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' )
            {
            // InternalRoom.g:1781:1: (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' )
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
                    // InternalRoom.g:1782:3: lv_name_0_1= 'ctor'
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
                    // InternalRoom.g:1794:8: lv_name_0_2= 'dtor'
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

            // InternalRoom.g:1809:2: ( (lv_detailCode_1_0= ruleDetailCode ) )
            // InternalRoom.g:1810:1: (lv_detailCode_1_0= ruleDetailCode )
            {
            // InternalRoom.g:1810:1: (lv_detailCode_1_0= ruleDetailCode )
            // InternalRoom.g:1811:3: lv_detailCode_1_0= ruleDetailCode
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
    // InternalRoom.g:1835:1: entryRuleGeneralProtocolClass returns [EObject current=null] : iv_ruleGeneralProtocolClass= ruleGeneralProtocolClass EOF ;
    public final EObject entryRuleGeneralProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneralProtocolClass = null;


        try {
            // InternalRoom.g:1836:2: (iv_ruleGeneralProtocolClass= ruleGeneralProtocolClass EOF )
            // InternalRoom.g:1837:2: iv_ruleGeneralProtocolClass= ruleGeneralProtocolClass EOF
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
    // InternalRoom.g:1844:1: ruleGeneralProtocolClass returns [EObject current=null] : (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass ) ;
    public final EObject ruleGeneralProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject this_ProtocolClass_0 = null;

        EObject this_CompoundProtocolClass_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:1847:28: ( (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass ) )
            // InternalRoom.g:1848:1: (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass )
            {
            // InternalRoom.g:1848:1: (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==43||(LA46_0>=125 && LA46_0<=127)) ) {
                alt46=1;
            }
            else if ( (LA46_0==49) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalRoom.g:1849:5: this_ProtocolClass_0= ruleProtocolClass
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
                    // InternalRoom.g:1859:5: this_CompoundProtocolClass_1= ruleCompoundProtocolClass
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
    // InternalRoom.g:1875:1: entryRuleProtocolClass returns [EObject current=null] : iv_ruleProtocolClass= ruleProtocolClass EOF ;
    public final EObject entryRuleProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolClass = null;


        try {
            // InternalRoom.g:1876:2: (iv_ruleProtocolClass= ruleProtocolClass EOF )
            // InternalRoom.g:1877:2: iv_ruleProtocolClass= ruleProtocolClass EOF
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
    // InternalRoom.g:1884:1: ruleProtocolClass returns [EObject current=null] : ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' ) ;
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
            // InternalRoom.g:1887:28: ( ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' ) )
            // InternalRoom.g:1888:1: ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' )
            {
            // InternalRoom.g:1888:1: ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' )
            // InternalRoom.g:1888:2: ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}'
            {
            // InternalRoom.g:1888:2: ( (lv_commType_0_0= ruleCommunicationType ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=125 && LA47_0<=127)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalRoom.g:1889:1: (lv_commType_0_0= ruleCommunicationType )
                    {
                    // InternalRoom.g:1889:1: (lv_commType_0_0= ruleCommunicationType )
                    // InternalRoom.g:1890:3: lv_commType_0_0= ruleCommunicationType
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
                
            // InternalRoom.g:1910:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:1911:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:1911:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:1912:3: lv_name_2_0= RULE_ID
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

            // InternalRoom.g:1928:2: ( (lv_docu_3_0= ruleDocumentation ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==35) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalRoom.g:1929:1: (lv_docu_3_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1929:1: (lv_docu_3_0= ruleDocumentation )
                    // InternalRoom.g:1930:3: lv_docu_3_0= ruleDocumentation
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

            // InternalRoom.g:1946:3: (otherlv_4= 'extends' ( ( ruleFQN ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==30) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalRoom.g:1946:5: otherlv_4= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_4=(Token)match(input,30,FOLLOW_3); 

                        	newLeafNode(otherlv_4, grammarAccess.getProtocolClassAccess().getExtendsKeyword_4_0());
                        
                    // InternalRoom.g:1950:1: ( ( ruleFQN ) )
                    // InternalRoom.g:1951:1: ( ruleFQN )
                    {
                    // InternalRoom.g:1951:1: ( ruleFQN )
                    // InternalRoom.g:1952:3: ruleFQN
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
                
            // InternalRoom.g:1969:1: ( (lv_annotations_7_0= ruleAnnotation ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==109) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalRoom.g:1970:1: (lv_annotations_7_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:1970:1: (lv_annotations_7_0= ruleAnnotation )
            	    // InternalRoom.g:1971:3: lv_annotations_7_0= ruleAnnotation
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
            	    break loop50;
                }
            } while (true);

            // InternalRoom.g:1987:3: (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==31) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalRoom.g:1987:5: otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,31,FOLLOW_52); 

                        	newLeafNode(otherlv_8, grammarAccess.getProtocolClassAccess().getUsercode1Keyword_7_0());
                        
                    // InternalRoom.g:1991:1: ( (lv_userCode1_9_0= ruleDetailCode ) )
                    // InternalRoom.g:1992:1: (lv_userCode1_9_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1992:1: (lv_userCode1_9_0= ruleDetailCode )
                    // InternalRoom.g:1993:3: lv_userCode1_9_0= ruleDetailCode
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

            // InternalRoom.g:2009:4: (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==32) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalRoom.g:2009:6: otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,32,FOLLOW_54); 

                        	newLeafNode(otherlv_10, grammarAccess.getProtocolClassAccess().getUsercode2Keyword_8_0());
                        
                    // InternalRoom.g:2013:1: ( (lv_userCode2_11_0= ruleDetailCode ) )
                    // InternalRoom.g:2014:1: (lv_userCode2_11_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2014:1: (lv_userCode2_11_0= ruleDetailCode )
                    // InternalRoom.g:2015:3: lv_userCode2_11_0= ruleDetailCode
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

            // InternalRoom.g:2031:4: (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==33) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalRoom.g:2031:6: otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) )
                    {
                    otherlv_12=(Token)match(input,33,FOLLOW_56); 

                        	newLeafNode(otherlv_12, grammarAccess.getProtocolClassAccess().getUsercode3Keyword_9_0());
                        
                    // InternalRoom.g:2035:1: ( (lv_userCode3_13_0= ruleDetailCode ) )
                    // InternalRoom.g:2036:1: (lv_userCode3_13_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2036:1: (lv_userCode3_13_0= ruleDetailCode )
                    // InternalRoom.g:2037:3: lv_userCode3_13_0= ruleDetailCode
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

            // InternalRoom.g:2053:4: (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==44) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalRoom.g:2053:6: otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}'
                    {
                    otherlv_14=(Token)match(input,44,FOLLOW_5); 

                        	newLeafNode(otherlv_14, grammarAccess.getProtocolClassAccess().getIncomingKeyword_10_0());
                        
                    otherlv_15=(Token)match(input,14,FOLLOW_58); 

                        	newLeafNode(otherlv_15, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_10_1());
                        
                    // InternalRoom.g:2061:1: ( (lv_incomingMessages_16_0= ruleMessage ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( ((LA54_0>=51 && LA54_0<=52)) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // InternalRoom.g:2062:1: (lv_incomingMessages_16_0= ruleMessage )
                    	    {
                    	    // InternalRoom.g:2062:1: (lv_incomingMessages_16_0= ruleMessage )
                    	    // InternalRoom.g:2063:3: lv_incomingMessages_16_0= ruleMessage
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
                    	    break loop54;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,15,FOLLOW_59); 

                        	newLeafNode(otherlv_17, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_10_3());
                        

                    }
                    break;

            }

            // InternalRoom.g:2083:3: (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==45) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalRoom.g:2083:5: otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}'
                    {
                    otherlv_18=(Token)match(input,45,FOLLOW_5); 

                        	newLeafNode(otherlv_18, grammarAccess.getProtocolClassAccess().getOutgoingKeyword_11_0());
                        
                    otherlv_19=(Token)match(input,14,FOLLOW_58); 

                        	newLeafNode(otherlv_19, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_11_1());
                        
                    // InternalRoom.g:2091:1: ( (lv_outgoingMessages_20_0= ruleMessage ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( ((LA56_0>=51 && LA56_0<=52)) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalRoom.g:2092:1: (lv_outgoingMessages_20_0= ruleMessage )
                    	    {
                    	    // InternalRoom.g:2092:1: (lv_outgoingMessages_20_0= ruleMessage )
                    	    // InternalRoom.g:2093:3: lv_outgoingMessages_20_0= ruleMessage
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
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,15,FOLLOW_60); 

                        	newLeafNode(otherlv_21, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_11_3());
                        

                    }
                    break;

            }

            // InternalRoom.g:2113:3: (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==46) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalRoom.g:2113:5: otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) )
                    {
                    otherlv_22=(Token)match(input,46,FOLLOW_61); 

                        	newLeafNode(otherlv_22, grammarAccess.getProtocolClassAccess().getRegularKeyword_12_0());
                        
                    otherlv_23=(Token)match(input,47,FOLLOW_5); 

                        	newLeafNode(otherlv_23, grammarAccess.getProtocolClassAccess().getPortClassKeyword_12_1());
                        
                    // InternalRoom.g:2121:1: ( (lv_regular_24_0= rulePortClass ) )
                    // InternalRoom.g:2122:1: (lv_regular_24_0= rulePortClass )
                    {
                    // InternalRoom.g:2122:1: (lv_regular_24_0= rulePortClass )
                    // InternalRoom.g:2123:3: lv_regular_24_0= rulePortClass
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

            // InternalRoom.g:2139:4: (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==48) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalRoom.g:2139:6: otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) )
                    {
                    otherlv_25=(Token)match(input,48,FOLLOW_61); 

                        	newLeafNode(otherlv_25, grammarAccess.getProtocolClassAccess().getConjugatedKeyword_13_0());
                        
                    otherlv_26=(Token)match(input,47,FOLLOW_5); 

                        	newLeafNode(otherlv_26, grammarAccess.getProtocolClassAccess().getPortClassKeyword_13_1());
                        
                    // InternalRoom.g:2147:1: ( (lv_conjugated_27_0= rulePortClass ) )
                    // InternalRoom.g:2148:1: (lv_conjugated_27_0= rulePortClass )
                    {
                    // InternalRoom.g:2148:1: (lv_conjugated_27_0= rulePortClass )
                    // InternalRoom.g:2149:3: lv_conjugated_27_0= rulePortClass
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

            // InternalRoom.g:2165:4: ( (lv_semantics_28_0= ruleProtocolSemantics ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==106) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalRoom.g:2166:1: (lv_semantics_28_0= ruleProtocolSemantics )
                    {
                    // InternalRoom.g:2166:1: (lv_semantics_28_0= ruleProtocolSemantics )
                    // InternalRoom.g:2167:3: lv_semantics_28_0= ruleProtocolSemantics
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


    // $ANTLR start "entryRuleCompoundProtocolClass"
    // InternalRoom.g:2195:1: entryRuleCompoundProtocolClass returns [EObject current=null] : iv_ruleCompoundProtocolClass= ruleCompoundProtocolClass EOF ;
    public final EObject entryRuleCompoundProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundProtocolClass = null;


        try {
            // InternalRoom.g:2196:2: (iv_ruleCompoundProtocolClass= ruleCompoundProtocolClass EOF )
            // InternalRoom.g:2197:2: iv_ruleCompoundProtocolClass= ruleCompoundProtocolClass EOF
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
    // InternalRoom.g:2204:1: ruleCompoundProtocolClass returns [EObject current=null] : (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}' ) ;
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
            // InternalRoom.g:2207:28: ( (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}' ) )
            // InternalRoom.g:2208:1: (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}' )
            {
            // InternalRoom.g:2208:1: (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}' )
            // InternalRoom.g:2208:3: otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getCompoundProtocolClassAccess().getCompoundProtocolClassKeyword_0());
                
            // InternalRoom.g:2212:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:2213:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:2213:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:2214:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:2230:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==35) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalRoom.g:2231:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:2231:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:2232:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_65); 

                	newLeafNode(otherlv_3, grammarAccess.getCompoundProtocolClassAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:2252:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==109) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalRoom.g:2253:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:2253:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:2254:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompoundProtocolClassAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_65);
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
            	    break loop62;
                }
            } while (true);

            // InternalRoom.g:2270:3: ( (lv_subProtocols_5_0= ruleSubProtocol ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==50) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalRoom.g:2271:1: (lv_subProtocols_5_0= ruleSubProtocol )
            	    {
            	    // InternalRoom.g:2271:1: (lv_subProtocols_5_0= ruleSubProtocol )
            	    // InternalRoom.g:2272:3: lv_subProtocols_5_0= ruleSubProtocol
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompoundProtocolClassAccess().getSubProtocolsSubProtocolParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_66);
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
            	    break loop63;
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
    // InternalRoom.g:2300:1: entryRuleSubProtocol returns [EObject current=null] : iv_ruleSubProtocol= ruleSubProtocol EOF ;
    public final EObject entryRuleSubProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubProtocol = null;


        try {
            // InternalRoom.g:2301:2: (iv_ruleSubProtocol= ruleSubProtocol EOF )
            // InternalRoom.g:2302:2: iv_ruleSubProtocol= ruleSubProtocol EOF
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
    // InternalRoom.g:2309:1: ruleSubProtocol returns [EObject current=null] : (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSubProtocol() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:2312:28: ( (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // InternalRoom.g:2313:1: (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // InternalRoom.g:2313:1: (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // InternalRoom.g:2313:3: otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,50,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSubProtocolAccess().getSubProtocolKeyword_0());
                
            // InternalRoom.g:2317:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:2318:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:2318:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:2319:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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
                
            // InternalRoom.g:2339:1: ( ( ruleFQN ) )
            // InternalRoom.g:2340:1: ( ruleFQN )
            {
            // InternalRoom.g:2340:1: ( ruleFQN )
            // InternalRoom.g:2341:3: ruleFQN
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
    // InternalRoom.g:2362:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalRoom.g:2363:2: (iv_ruleMessage= ruleMessage EOF )
            // InternalRoom.g:2364:2: iv_ruleMessage= ruleMessage EOF
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
    // InternalRoom.g:2371:1: ruleMessage returns [EObject current=null] : ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:2374:28: ( ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:2375:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:2375:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            // InternalRoom.g:2375:2: ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:2375:2: ( (lv_priv_0_0= 'private' ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==51) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalRoom.g:2376:1: (lv_priv_0_0= 'private' )
                    {
                    // InternalRoom.g:2376:1: (lv_priv_0_0= 'private' )
                    // InternalRoom.g:2377:3: lv_priv_0_0= 'private'
                    {
                    lv_priv_0_0=(Token)match(input,51,FOLLOW_67); 

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
                
            // InternalRoom.g:2394:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:2395:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:2395:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:2396:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_68); 

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

            // InternalRoom.g:2412:2: (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==21) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalRoom.g:2412:4: otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_43); 

                        	newLeafNode(otherlv_3, grammarAccess.getMessageAccess().getLeftParenthesisKeyword_3_0());
                        
                    // InternalRoom.g:2416:1: ( (lv_data_4_0= ruleMessageData ) )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==RULE_ID) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // InternalRoom.g:2417:1: (lv_data_4_0= ruleMessageData )
                            {
                            // InternalRoom.g:2417:1: (lv_data_4_0= ruleMessageData )
                            // InternalRoom.g:2418:3: lv_data_4_0= ruleMessageData
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

                    otherlv_5=(Token)match(input,22,FOLLOW_69); 

                        	newLeafNode(otherlv_5, grammarAccess.getMessageAccess().getRightParenthesisKeyword_3_2());
                        

                    }
                    break;

            }

            // InternalRoom.g:2438:3: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==109) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalRoom.g:2439:1: (lv_annotations_6_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:2439:1: (lv_annotations_6_0= ruleAnnotation )
            	    // InternalRoom.g:2440:3: lv_annotations_6_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMessageAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_69);
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
            	    break loop67;
                }
            } while (true);

            // InternalRoom.g:2456:3: ( (lv_docu_7_0= ruleDocumentation ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==35) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalRoom.g:2457:1: (lv_docu_7_0= ruleDocumentation )
                    {
                    // InternalRoom.g:2457:1: (lv_docu_7_0= ruleDocumentation )
                    // InternalRoom.g:2458:3: lv_docu_7_0= ruleDocumentation
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
    // InternalRoom.g:2482:1: entryRulePortClass returns [EObject current=null] : iv_rulePortClass= rulePortClass EOF ;
    public final EObject entryRulePortClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortClass = null;


        try {
            // InternalRoom.g:2483:2: (iv_rulePortClass= rulePortClass EOF )
            // InternalRoom.g:2484:2: iv_rulePortClass= rulePortClass EOF
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
    // InternalRoom.g:2491:1: rulePortClass returns [EObject current=null] : ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' ) ;
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
            // InternalRoom.g:2494:28: ( ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' ) )
            // InternalRoom.g:2495:1: ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' )
            {
            // InternalRoom.g:2495:1: ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' )
            // InternalRoom.g:2495:2: () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}'
            {
            // InternalRoom.g:2495:2: ()
            // InternalRoom.g:2496:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPortClassAccess().getPortClassAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,14,FOLLOW_70); 

                	newLeafNode(otherlv_1, grammarAccess.getPortClassAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalRoom.g:2505:1: (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==53) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalRoom.g:2505:3: otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) )
                    {
                    otherlv_2=(Token)match(input,53,FOLLOW_71); 

                        	newLeafNode(otherlv_2, grammarAccess.getPortClassAccess().getUsercodeKeyword_2_0());
                        
                    // InternalRoom.g:2509:1: ( (lv_userCode_3_0= ruleDetailCode ) )
                    // InternalRoom.g:2510:1: (lv_userCode_3_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2510:1: (lv_userCode_3_0= ruleDetailCode )
                    // InternalRoom.g:2511:3: lv_userCode_3_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortClassAccess().getUserCodeDetailCodeParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_72);
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

            // InternalRoom.g:2527:4: ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )*
            loop70:
            do {
                int alt70=4;
                switch ( input.LA(1) ) {
                case 54:
                    {
                    alt70=1;
                    }
                    break;
                case 38:
                    {
                    alt70=2;
                    }
                    break;
                case 34:
                    {
                    alt70=3;
                    }
                    break;

                }

                switch (alt70) {
            	case 1 :
            	    // InternalRoom.g:2527:5: ( (lv_msgHandlers_4_0= ruleMessageHandler ) )
            	    {
            	    // InternalRoom.g:2527:5: ( (lv_msgHandlers_4_0= ruleMessageHandler ) )
            	    // InternalRoom.g:2528:1: (lv_msgHandlers_4_0= ruleMessageHandler )
            	    {
            	    // InternalRoom.g:2528:1: (lv_msgHandlers_4_0= ruleMessageHandler )
            	    // InternalRoom.g:2529:3: lv_msgHandlers_4_0= ruleMessageHandler
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getMsgHandlersMessageHandlerParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_72);
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
            	    // InternalRoom.g:2546:6: ( (lv_operations_5_0= rulePortOperation ) )
            	    {
            	    // InternalRoom.g:2546:6: ( (lv_operations_5_0= rulePortOperation ) )
            	    // InternalRoom.g:2547:1: (lv_operations_5_0= rulePortOperation )
            	    {
            	    // InternalRoom.g:2547:1: (lv_operations_5_0= rulePortOperation )
            	    // InternalRoom.g:2548:3: lv_operations_5_0= rulePortOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getOperationsPortOperationParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_72);
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
            	    // InternalRoom.g:2565:6: ( (lv_attributes_6_0= ruleAttribute ) )
            	    {
            	    // InternalRoom.g:2565:6: ( (lv_attributes_6_0= ruleAttribute ) )
            	    // InternalRoom.g:2566:1: (lv_attributes_6_0= ruleAttribute )
            	    {
            	    // InternalRoom.g:2566:1: (lv_attributes_6_0= ruleAttribute )
            	    // InternalRoom.g:2567:3: lv_attributes_6_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getAttributesAttributeParserRuleCall_3_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_72);
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
            	    break loop70;
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
    // InternalRoom.g:2595:1: entryRuleMessageHandler returns [EObject current=null] : iv_ruleMessageHandler= ruleMessageHandler EOF ;
    public final EObject entryRuleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageHandler = null;


        try {
            // InternalRoom.g:2596:2: (iv_ruleMessageHandler= ruleMessageHandler EOF )
            // InternalRoom.g:2597:2: iv_ruleMessageHandler= ruleMessageHandler EOF
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
    // InternalRoom.g:2604:1: ruleMessageHandler returns [EObject current=null] : (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler ) ;
    public final EObject ruleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject this_InMessageHandler_0 = null;

        EObject this_OutMessageHandler_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2607:28: ( (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler ) )
            // InternalRoom.g:2608:1: (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler )
            {
            // InternalRoom.g:2608:1: (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==54) ) {
                int LA71_1 = input.LA(2);

                if ( (LA71_1==45) ) {
                    alt71=2;
                }
                else if ( (LA71_1==44) ) {
                    alt71=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // InternalRoom.g:2609:5: this_InMessageHandler_0= ruleInMessageHandler
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
                    // InternalRoom.g:2619:5: this_OutMessageHandler_1= ruleOutMessageHandler
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
    // InternalRoom.g:2635:1: entryRuleInMessageHandler returns [EObject current=null] : iv_ruleInMessageHandler= ruleInMessageHandler EOF ;
    public final EObject entryRuleInMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInMessageHandler = null;


        try {
            // InternalRoom.g:2636:2: (iv_ruleInMessageHandler= ruleInMessageHandler EOF )
            // InternalRoom.g:2637:2: iv_ruleInMessageHandler= ruleInMessageHandler EOF
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
    // InternalRoom.g:2644:1: ruleInMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) ;
    public final EObject ruleInMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_detailCode_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2647:28: ( (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:2648:1: (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:2648:1: (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            // InternalRoom.g:2648:3: otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_73); 

                	newLeafNode(otherlv_0, grammarAccess.getInMessageHandlerAccess().getHandleKeyword_0());
                
            otherlv_1=(Token)match(input,44,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getInMessageHandlerAccess().getIncomingKeyword_1());
                
            // InternalRoom.g:2656:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:2657:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:2657:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:2658:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInMessageHandlerRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_48); 

            		newLeafNode(otherlv_2, grammarAccess.getInMessageHandlerAccess().getMsgMessageCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:2669:2: ( (lv_detailCode_3_0= ruleDetailCode ) )
            // InternalRoom.g:2670:1: (lv_detailCode_3_0= ruleDetailCode )
            {
            // InternalRoom.g:2670:1: (lv_detailCode_3_0= ruleDetailCode )
            // InternalRoom.g:2671:3: lv_detailCode_3_0= ruleDetailCode
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
    // InternalRoom.g:2695:1: entryRuleOutMessageHandler returns [EObject current=null] : iv_ruleOutMessageHandler= ruleOutMessageHandler EOF ;
    public final EObject entryRuleOutMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutMessageHandler = null;


        try {
            // InternalRoom.g:2696:2: (iv_ruleOutMessageHandler= ruleOutMessageHandler EOF )
            // InternalRoom.g:2697:2: iv_ruleOutMessageHandler= ruleOutMessageHandler EOF
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
    // InternalRoom.g:2704:1: ruleOutMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) ;
    public final EObject ruleOutMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_detailCode_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2707:28: ( (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:2708:1: (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:2708:1: (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            // InternalRoom.g:2708:3: otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_74); 

                	newLeafNode(otherlv_0, grammarAccess.getOutMessageHandlerAccess().getHandleKeyword_0());
                
            otherlv_1=(Token)match(input,45,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getOutMessageHandlerAccess().getOutgoingKeyword_1());
                
            // InternalRoom.g:2716:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:2717:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:2717:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:2718:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOutMessageHandlerRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_48); 

            		newLeafNode(otherlv_2, grammarAccess.getOutMessageHandlerAccess().getMsgMessageCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:2729:2: ( (lv_detailCode_3_0= ruleDetailCode ) )
            // InternalRoom.g:2730:1: (lv_detailCode_3_0= ruleDetailCode )
            {
            // InternalRoom.g:2730:1: (lv_detailCode_3_0= ruleDetailCode )
            // InternalRoom.g:2731:3: lv_detailCode_3_0= ruleDetailCode
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
    // InternalRoom.g:2755:1: entryRuleModelComponent returns [EObject current=null] : iv_ruleModelComponent= ruleModelComponent EOF ;
    public final EObject entryRuleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelComponent = null;


        try {
            // InternalRoom.g:2756:2: (iv_ruleModelComponent= ruleModelComponent EOF )
            // InternalRoom.g:2757:2: iv_ruleModelComponent= ruleModelComponent EOF
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
    // InternalRoom.g:2764:1: ruleModelComponent returns [EObject current=null] : this_ActorClass_0= ruleActorClass ;
    public final EObject ruleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject this_ActorClass_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2767:28: (this_ActorClass_0= ruleActorClass )
            // InternalRoom.g:2769:5: this_ActorClass_0= ruleActorClass
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
    // InternalRoom.g:2785:1: entryRuleActorClass returns [EObject current=null] : iv_ruleActorClass= ruleActorClass EOF ;
    public final EObject entryRuleActorClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClass = null;


        try {
            // InternalRoom.g:2786:2: (iv_ruleActorClass= ruleActorClass EOF )
            // InternalRoom.g:2787:2: iv_ruleActorClass= ruleActorClass EOF
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
    // InternalRoom.g:2794:1: ruleActorClass returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' ) ;
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
            // InternalRoom.g:2797:28: ( ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' ) )
            // InternalRoom.g:2798:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' )
            {
            // InternalRoom.g:2798:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' )
            // InternalRoom.g:2798:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}'
            {
            // InternalRoom.g:2798:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) )
            // InternalRoom.g:2800:1: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            {
            // InternalRoom.g:2800:1: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            // InternalRoom.g:2801:2: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            	
            // InternalRoom.g:2804:2: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            // InternalRoom.g:2805:3: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            {
            // InternalRoom.g:2805:3: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            loop72:
            do {
                int alt72=3;
                int LA72_0 = input.LA(1);

                if ( LA72_0 == 55 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0) ) {
                    alt72=1;
                }
                else if ( ( LA72_0 >= 125 && LA72_0 <= 127 || LA72_0 == 129 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1) ) {
                    alt72=2;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalRoom.g:2807:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    {
            	    // InternalRoom.g:2807:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    // InternalRoom.g:2808:5: {...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // InternalRoom.g:2808:107: ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    // InternalRoom.g:2809:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // InternalRoom.g:2812:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    // InternalRoom.g:2812:7: {...}? => ( (lv_abstract_1_0= 'abstract' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "true");
            	    }
            	    // InternalRoom.g:2812:16: ( (lv_abstract_1_0= 'abstract' ) )
            	    // InternalRoom.g:2813:1: (lv_abstract_1_0= 'abstract' )
            	    {
            	    // InternalRoom.g:2813:1: (lv_abstract_1_0= 'abstract' )
            	    // InternalRoom.g:2814:3: lv_abstract_1_0= 'abstract'
            	    {
            	    lv_abstract_1_0=(Token)match(input,55,FOLLOW_75); 

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
            	    // InternalRoom.g:2834:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    {
            	    // InternalRoom.g:2834:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    // InternalRoom.g:2835:5: {...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // InternalRoom.g:2835:107: ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    // InternalRoom.g:2836:6: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // InternalRoom.g:2839:6: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    // InternalRoom.g:2839:7: {...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "true");
            	    }
            	    // InternalRoom.g:2839:16: ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    // InternalRoom.g:2840:1: (lv_commType_2_0= ruleComponentCommunicationType )
            	    {
            	    // InternalRoom.g:2840:1: (lv_commType_2_0= ruleComponentCommunicationType )
            	    // InternalRoom.g:2841:3: lv_commType_2_0= ruleComponentCommunicationType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorClassAccess().getCommTypeComponentCommunicationTypeEnumRuleCall_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_75);
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
            	    break loop72;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            	

            }

            otherlv_3=(Token)match(input,56,FOLLOW_3); 

                	newLeafNode(otherlv_3, grammarAccess.getActorClassAccess().getActorClassKeyword_1());
                
            // InternalRoom.g:2875:1: ( (lv_name_4_0= RULE_ID ) )
            // InternalRoom.g:2876:1: (lv_name_4_0= RULE_ID )
            {
            // InternalRoom.g:2876:1: (lv_name_4_0= RULE_ID )
            // InternalRoom.g:2877:3: lv_name_4_0= RULE_ID
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

            // InternalRoom.g:2893:2: ( (lv_docu_5_0= ruleDocumentation ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==35) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalRoom.g:2894:1: (lv_docu_5_0= ruleDocumentation )
                    {
                    // InternalRoom.g:2894:1: (lv_docu_5_0= ruleDocumentation )
                    // InternalRoom.g:2895:3: lv_docu_5_0= ruleDocumentation
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

            // InternalRoom.g:2911:3: (otherlv_6= 'extends' ( ( ruleFQN ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==30) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalRoom.g:2911:5: otherlv_6= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_6=(Token)match(input,30,FOLLOW_3); 

                        	newLeafNode(otherlv_6, grammarAccess.getActorClassAccess().getExtendsKeyword_4_0());
                        
                    // InternalRoom.g:2915:1: ( ( ruleFQN ) )
                    // InternalRoom.g:2916:1: ( ruleFQN )
                    {
                    // InternalRoom.g:2916:1: ( ruleFQN )
                    // InternalRoom.g:2917:3: ruleFQN
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

            otherlv_8=(Token)match(input,14,FOLLOW_76); 

                	newLeafNode(otherlv_8, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_5());
                
            // InternalRoom.g:2934:1: ( (lv_annotations_9_0= ruleAnnotation ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==109) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalRoom.g:2935:1: (lv_annotations_9_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:2935:1: (lv_annotations_9_0= ruleAnnotation )
            	    // InternalRoom.g:2936:3: lv_annotations_9_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAnnotationsAnnotationParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_76);
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
            	    break loop75;
                }
            } while (true);

            // InternalRoom.g:2952:3: (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==57) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalRoom.g:2952:5: otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}'
                    {
                    otherlv_10=(Token)match(input,57,FOLLOW_5); 

                        	newLeafNode(otherlv_10, grammarAccess.getActorClassAccess().getInterfaceKeyword_7_0());
                        
                    otherlv_11=(Token)match(input,14,FOLLOW_77); 

                        	newLeafNode(otherlv_11, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_7_1());
                        
                    // InternalRoom.g:2960:1: ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )*
                    loop76:
                    do {
                        int alt76=3;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==63) ) {
                            alt76=1;
                        }
                        else if ( (LA76_0==48||LA76_0==60) ) {
                            alt76=2;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // InternalRoom.g:2960:2: ( (lv_serviceProvisionPoints_12_0= ruleSPP ) )
                    	    {
                    	    // InternalRoom.g:2960:2: ( (lv_serviceProvisionPoints_12_0= ruleSPP ) )
                    	    // InternalRoom.g:2961:1: (lv_serviceProvisionPoints_12_0= ruleSPP )
                    	    {
                    	    // InternalRoom.g:2961:1: (lv_serviceProvisionPoints_12_0= ruleSPP )
                    	    // InternalRoom.g:2962:3: lv_serviceProvisionPoints_12_0= ruleSPP
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceProvisionPointsSPPParserRuleCall_7_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_77);
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
                    	    // InternalRoom.g:2979:6: ( (lv_interfacePorts_13_0= rulePort ) )
                    	    {
                    	    // InternalRoom.g:2979:6: ( (lv_interfacePorts_13_0= rulePort ) )
                    	    // InternalRoom.g:2980:1: (lv_interfacePorts_13_0= rulePort )
                    	    {
                    	    // InternalRoom.g:2980:1: (lv_interfacePorts_13_0= rulePort )
                    	    // InternalRoom.g:2981:3: lv_interfacePorts_13_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getInterfacePortsPortParserRuleCall_7_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_77);
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
                    	    break loop76;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,15,FOLLOW_78); 

                        	newLeafNode(otherlv_14, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_7_3());
                        

                    }
                    break;

            }

            // InternalRoom.g:3001:3: (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==58) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalRoom.g:3001:5: otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}'
                    {
                    otherlv_15=(Token)match(input,58,FOLLOW_4); 

                        	newLeafNode(otherlv_15, grammarAccess.getActorClassAccess().getStructureKeyword_8_0());
                        
                    // InternalRoom.g:3005:1: ( (lv_structureDocu_16_0= ruleDocumentation ) )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==35) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // InternalRoom.g:3006:1: (lv_structureDocu_16_0= ruleDocumentation )
                            {
                            // InternalRoom.g:3006:1: (lv_structureDocu_16_0= ruleDocumentation )
                            // InternalRoom.g:3007:3: lv_structureDocu_16_0= ruleDocumentation
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

                    otherlv_17=(Token)match(input,14,FOLLOW_79); 

                        	newLeafNode(otherlv_17, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_8_2());
                        
                    // InternalRoom.g:3027:1: (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==31) ) {
                        alt79=1;
                    }
                    switch (alt79) {
                        case 1 :
                            // InternalRoom.g:3027:3: otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) )
                            {
                            otherlv_18=(Token)match(input,31,FOLLOW_80); 

                                	newLeafNode(otherlv_18, grammarAccess.getActorClassAccess().getUsercode1Keyword_8_3_0());
                                
                            // InternalRoom.g:3031:1: ( (lv_userCode1_19_0= ruleDetailCode ) )
                            // InternalRoom.g:3032:1: (lv_userCode1_19_0= ruleDetailCode )
                            {
                            // InternalRoom.g:3032:1: (lv_userCode1_19_0= ruleDetailCode )
                            // InternalRoom.g:3033:3: lv_userCode1_19_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode1DetailCodeParserRuleCall_8_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_81);
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

                    // InternalRoom.g:3049:4: (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==32) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // InternalRoom.g:3049:6: otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) )
                            {
                            otherlv_20=(Token)match(input,32,FOLLOW_82); 

                                	newLeafNode(otherlv_20, grammarAccess.getActorClassAccess().getUsercode2Keyword_8_4_0());
                                
                            // InternalRoom.g:3053:1: ( (lv_userCode2_21_0= ruleDetailCode ) )
                            // InternalRoom.g:3054:1: (lv_userCode2_21_0= ruleDetailCode )
                            {
                            // InternalRoom.g:3054:1: (lv_userCode2_21_0= ruleDetailCode )
                            // InternalRoom.g:3055:3: lv_userCode2_21_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode2DetailCodeParserRuleCall_8_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_83);
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

                    // InternalRoom.g:3071:4: (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==33) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalRoom.g:3071:6: otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) )
                            {
                            otherlv_22=(Token)match(input,33,FOLLOW_84); 

                                	newLeafNode(otherlv_22, grammarAccess.getActorClassAccess().getUsercode3Keyword_8_5_0());
                                
                            // InternalRoom.g:3075:1: ( (lv_userCode3_23_0= ruleDetailCode ) )
                            // InternalRoom.g:3076:1: (lv_userCode3_23_0= ruleDetailCode )
                            {
                            // InternalRoom.g:3076:1: (lv_userCode3_23_0= ruleDetailCode )
                            // InternalRoom.g:3077:3: lv_userCode3_23_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode3DetailCodeParserRuleCall_8_5_1_0()); 
                            	    
                            pushFollow(FOLLOW_85);
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

                    // InternalRoom.g:3093:4: ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )*
                    loop82:
                    do {
                        int alt82=9;
                        switch ( input.LA(1) ) {
                        case 75:
                            {
                            alt82=1;
                            }
                            break;
                        case 71:
                            {
                            alt82=2;
                            }
                            break;
                        case 64:
                            {
                            alt82=3;
                            }
                            break;
                        case 34:
                            {
                            alt82=4;
                            }
                            break;
                        case 78:
                        case 112:
                        case 128:
                            {
                            alt82=5;
                            }
                            break;
                        case 62:
                            {
                            alt82=6;
                            }
                            break;
                        case 48:
                        case 60:
                            {
                            alt82=7;
                            }
                            break;
                        case 61:
                            {
                            alt82=8;
                            }
                            break;

                        }

                        switch (alt82) {
                    	case 1 :
                    	    // InternalRoom.g:3093:5: ( (lv_connections_24_0= ruleLayerConnection ) )
                    	    {
                    	    // InternalRoom.g:3093:5: ( (lv_connections_24_0= ruleLayerConnection ) )
                    	    // InternalRoom.g:3094:1: (lv_connections_24_0= ruleLayerConnection )
                    	    {
                    	    // InternalRoom.g:3094:1: (lv_connections_24_0= ruleLayerConnection )
                    	    // InternalRoom.g:3095:3: lv_connections_24_0= ruleLayerConnection
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getConnectionsLayerConnectionParserRuleCall_8_6_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_85);
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
                    	    // InternalRoom.g:3112:6: ( (lv_bindings_25_0= ruleBinding ) )
                    	    {
                    	    // InternalRoom.g:3112:6: ( (lv_bindings_25_0= ruleBinding ) )
                    	    // InternalRoom.g:3113:1: (lv_bindings_25_0= ruleBinding )
                    	    {
                    	    // InternalRoom.g:3113:1: (lv_bindings_25_0= ruleBinding )
                    	    // InternalRoom.g:3114:3: lv_bindings_25_0= ruleBinding
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getBindingsBindingParserRuleCall_8_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_85);
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
                    	    // InternalRoom.g:3131:6: ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )
                    	    {
                    	    // InternalRoom.g:3131:6: ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )
                    	    // InternalRoom.g:3132:1: (lv_serviceImplementations_26_0= ruleServiceImplementation )
                    	    {
                    	    // InternalRoom.g:3132:1: (lv_serviceImplementations_26_0= ruleServiceImplementation )
                    	    // InternalRoom.g:3133:3: lv_serviceImplementations_26_0= ruleServiceImplementation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceImplementationsServiceImplementationParserRuleCall_8_6_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_85);
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
                    	    // InternalRoom.g:3150:6: ( (lv_attributes_27_0= ruleAttribute ) )
                    	    {
                    	    // InternalRoom.g:3150:6: ( (lv_attributes_27_0= ruleAttribute ) )
                    	    // InternalRoom.g:3151:1: (lv_attributes_27_0= ruleAttribute )
                    	    {
                    	    // InternalRoom.g:3151:1: (lv_attributes_27_0= ruleAttribute )
                    	    // InternalRoom.g:3152:3: lv_attributes_27_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAttributesAttributeParserRuleCall_8_6_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_85);
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
                    	    // InternalRoom.g:3169:6: ( (lv_actorRefs_28_0= ruleActorRef ) )
                    	    {
                    	    // InternalRoom.g:3169:6: ( (lv_actorRefs_28_0= ruleActorRef ) )
                    	    // InternalRoom.g:3170:1: (lv_actorRefs_28_0= ruleActorRef )
                    	    {
                    	    // InternalRoom.g:3170:1: (lv_actorRefs_28_0= ruleActorRef )
                    	    // InternalRoom.g:3171:3: lv_actorRefs_28_0= ruleActorRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getActorRefsActorRefParserRuleCall_8_6_4_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_85);
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
                    	    // InternalRoom.g:3188:6: ( (lv_serviceAccessPoints_29_0= ruleSAP ) )
                    	    {
                    	    // InternalRoom.g:3188:6: ( (lv_serviceAccessPoints_29_0= ruleSAP ) )
                    	    // InternalRoom.g:3189:1: (lv_serviceAccessPoints_29_0= ruleSAP )
                    	    {
                    	    // InternalRoom.g:3189:1: (lv_serviceAccessPoints_29_0= ruleSAP )
                    	    // InternalRoom.g:3190:3: lv_serviceAccessPoints_29_0= ruleSAP
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceAccessPointsSAPParserRuleCall_8_6_5_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_85);
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
                    	    // InternalRoom.g:3207:6: ( (lv_internalPorts_30_0= rulePort ) )
                    	    {
                    	    // InternalRoom.g:3207:6: ( (lv_internalPorts_30_0= rulePort ) )
                    	    // InternalRoom.g:3208:1: (lv_internalPorts_30_0= rulePort )
                    	    {
                    	    // InternalRoom.g:3208:1: (lv_internalPorts_30_0= rulePort )
                    	    // InternalRoom.g:3209:3: lv_internalPorts_30_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getInternalPortsPortParserRuleCall_8_6_6_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_85);
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
                    	    // InternalRoom.g:3226:6: ( (lv_externalPorts_31_0= ruleExternalPort ) )
                    	    {
                    	    // InternalRoom.g:3226:6: ( (lv_externalPorts_31_0= ruleExternalPort ) )
                    	    // InternalRoom.g:3227:1: (lv_externalPorts_31_0= ruleExternalPort )
                    	    {
                    	    // InternalRoom.g:3227:1: (lv_externalPorts_31_0= ruleExternalPort )
                    	    // InternalRoom.g:3228:3: lv_externalPorts_31_0= ruleExternalPort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getExternalPortsExternalPortParserRuleCall_8_6_7_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_85);
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
                    	    break loop82;
                        }
                    } while (true);

                    otherlv_32=(Token)match(input,15,FOLLOW_86); 

                        	newLeafNode(otherlv_32, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_8_7());
                        

                    }
                    break;

            }

            // InternalRoom.g:3248:3: (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==59) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalRoom.g:3248:5: otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}'
                    {
                    otherlv_33=(Token)match(input,59,FOLLOW_4); 

                        	newLeafNode(otherlv_33, grammarAccess.getActorClassAccess().getBehaviorKeyword_9_0());
                        
                    // InternalRoom.g:3252:1: ( (lv_behaviorDocu_34_0= ruleDocumentation ) )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==35) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // InternalRoom.g:3253:1: (lv_behaviorDocu_34_0= ruleDocumentation )
                            {
                            // InternalRoom.g:3253:1: (lv_behaviorDocu_34_0= ruleDocumentation )
                            // InternalRoom.g:3254:3: lv_behaviorDocu_34_0= ruleDocumentation
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

                    otherlv_35=(Token)match(input,14,FOLLOW_87); 

                        	newLeafNode(otherlv_35, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_9_2());
                        
                    // InternalRoom.g:3274:1: ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )*
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( (LA85_0==109) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // InternalRoom.g:3275:1: (lv_behaviorAnnotations_36_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:3275:1: (lv_behaviorAnnotations_36_0= ruleAnnotation )
                    	    // InternalRoom.g:3276:3: lv_behaviorAnnotations_36_0= ruleAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getBehaviorAnnotationsAnnotationParserRuleCall_9_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_87);
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
                    	    break loop85;
                        }
                    } while (true);

                    // InternalRoom.g:3292:3: ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )*
                    loop86:
                    do {
                        int alt86=3;
                        int LA86_0 = input.LA(1);

                        if ( ((LA86_0>=37 && LA86_0<=38)) ) {
                            alt86=1;
                        }
                        else if ( ((LA86_0>=41 && LA86_0<=42)) ) {
                            alt86=2;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // InternalRoom.g:3292:4: ( (lv_operations_37_0= ruleStandardOperation ) )
                    	    {
                    	    // InternalRoom.g:3292:4: ( (lv_operations_37_0= ruleStandardOperation ) )
                    	    // InternalRoom.g:3293:1: (lv_operations_37_0= ruleStandardOperation )
                    	    {
                    	    // InternalRoom.g:3293:1: (lv_operations_37_0= ruleStandardOperation )
                    	    // InternalRoom.g:3294:3: lv_operations_37_0= ruleStandardOperation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getOperationsStandardOperationParserRuleCall_9_4_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_88);
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
                    	    // InternalRoom.g:3311:6: ( (lv_structors_38_0= ruleClassStructor ) )
                    	    {
                    	    // InternalRoom.g:3311:6: ( (lv_structors_38_0= ruleClassStructor ) )
                    	    // InternalRoom.g:3312:1: (lv_structors_38_0= ruleClassStructor )
                    	    {
                    	    // InternalRoom.g:3312:1: (lv_structors_38_0= ruleClassStructor )
                    	    // InternalRoom.g:3313:3: lv_structors_38_0= ruleClassStructor
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getStructorsClassStructorParserRuleCall_9_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_88);
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
                    	    break loop86;
                        }
                    } while (true);

                    // InternalRoom.g:3329:4: ( (lv_stateMachine_39_0= ruleStateMachine ) )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==83) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // InternalRoom.g:3330:1: (lv_stateMachine_39_0= ruleStateMachine )
                            {
                            // InternalRoom.g:3330:1: (lv_stateMachine_39_0= ruleStateMachine )
                            // InternalRoom.g:3331:3: lv_stateMachine_39_0= ruleStateMachine
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
    // InternalRoom.g:3363:1: entryRuleInterfaceItem returns [EObject current=null] : iv_ruleInterfaceItem= ruleInterfaceItem EOF ;
    public final EObject entryRuleInterfaceItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceItem = null;


        try {
            // InternalRoom.g:3364:2: (iv_ruleInterfaceItem= ruleInterfaceItem EOF )
            // InternalRoom.g:3365:2: iv_ruleInterfaceItem= ruleInterfaceItem EOF
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
    // InternalRoom.g:3372:1: ruleInterfaceItem returns [EObject current=null] : (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP ) ;
    public final EObject ruleInterfaceItem() throws RecognitionException {
        EObject current = null;

        EObject this_Port_0 = null;

        EObject this_SAP_1 = null;

        EObject this_SPP_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3375:28: ( (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP ) )
            // InternalRoom.g:3376:1: (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP )
            {
            // InternalRoom.g:3376:1: (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP )
            int alt89=3;
            switch ( input.LA(1) ) {
            case 48:
            case 60:
                {
                alt89=1;
                }
                break;
            case 62:
                {
                alt89=2;
                }
                break;
            case 63:
                {
                alt89=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalRoom.g:3377:5: this_Port_0= rulePort
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
                    // InternalRoom.g:3387:5: this_SAP_1= ruleSAP
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
                    // InternalRoom.g:3397:5: this_SPP_2= ruleSPP
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
    // InternalRoom.g:3413:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // InternalRoom.g:3414:2: (iv_rulePort= rulePort EOF )
            // InternalRoom.g:3415:2: iv_rulePort= rulePort EOF
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
    // InternalRoom.g:3422:1: rulePort returns [EObject current=null] : ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:3425:28: ( ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3426:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3426:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            // InternalRoom.g:3426:2: ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:3426:2: ( (lv_conjugated_0_0= 'conjugated' ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==48) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalRoom.g:3427:1: (lv_conjugated_0_0= 'conjugated' )
                    {
                    // InternalRoom.g:3427:1: (lv_conjugated_0_0= 'conjugated' )
                    // InternalRoom.g:3428:3: lv_conjugated_0_0= 'conjugated'
                    {
                    lv_conjugated_0_0=(Token)match(input,48,FOLLOW_89); 

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
                
            // InternalRoom.g:3445:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:3446:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:3446:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:3447:3: lv_name_2_0= RULE_ID
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

            // InternalRoom.g:3463:2: ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==35) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalRoom.g:3464:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    {
                    // InternalRoom.g:3464:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    // InternalRoom.g:3465:3: lv_multiplicity_3_0= ruleMULTIPLICITY
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
                
            // InternalRoom.g:3485:1: ( ( ruleFQN ) )
            // InternalRoom.g:3486:1: ( ruleFQN )
            {
            // InternalRoom.g:3486:1: ( ruleFQN )
            // InternalRoom.g:3487:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPortRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPortAccess().getProtocolGeneralProtocolClassCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_69);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:3500:2: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==109) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalRoom.g:3501:1: (lv_annotations_6_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:3501:1: (lv_annotations_6_0= ruleAnnotation )
            	    // InternalRoom.g:3502:3: lv_annotations_6_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortAccess().getAnnotationsAnnotationParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_69);
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
            	    break loop92;
                }
            } while (true);

            // InternalRoom.g:3518:3: ( (lv_docu_7_0= ruleDocumentation ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==35) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalRoom.g:3519:1: (lv_docu_7_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3519:1: (lv_docu_7_0= ruleDocumentation )
                    // InternalRoom.g:3520:3: lv_docu_7_0= ruleDocumentation
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
    // InternalRoom.g:3544:1: entryRuleExternalPort returns [EObject current=null] : iv_ruleExternalPort= ruleExternalPort EOF ;
    public final EObject entryRuleExternalPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalPort = null;


        try {
            // InternalRoom.g:3545:2: (iv_ruleExternalPort= ruleExternalPort EOF )
            // InternalRoom.g:3546:2: iv_ruleExternalPort= ruleExternalPort EOF
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
    // InternalRoom.g:3553:1: ruleExternalPort returns [EObject current=null] : (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleExternalPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:3556:28: ( (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:3557:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:3557:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:3557:3: otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_89); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalPortAccess().getExternalKeyword_0());
                
            otherlv_1=(Token)match(input,60,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getExternalPortAccess().getPortKeyword_1());
                
            // InternalRoom.g:3565:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:3566:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:3566:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:3567:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:3586:1: entryRuleSAP returns [EObject current=null] : iv_ruleSAP= ruleSAP EOF ;
    public final EObject entryRuleSAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAP = null;


        try {
            // InternalRoom.g:3587:2: (iv_ruleSAP= ruleSAP EOF )
            // InternalRoom.g:3588:2: iv_ruleSAP= ruleSAP EOF
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
    // InternalRoom.g:3595:1: ruleSAP returns [EObject current=null] : (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSAP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3598:28: ( (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3599:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3599:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // InternalRoom.g:3599:3: otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,62,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSAPAccess().getSAPKeyword_0());
                
            // InternalRoom.g:3603:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3604:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3604:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3605:3: lv_name_1_0= RULE_ID
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
                
            // InternalRoom.g:3625:1: ( ( ruleFQN ) )
            // InternalRoom.g:3626:1: ( ruleFQN )
            {
            // InternalRoom.g:3626:1: ( ruleFQN )
            // InternalRoom.g:3627:3: ruleFQN
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

            // InternalRoom.g:3640:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==35) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalRoom.g:3641:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3641:1: (lv_docu_4_0= ruleDocumentation )
                    // InternalRoom.g:3642:3: lv_docu_4_0= ruleDocumentation
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
    // InternalRoom.g:3666:1: entryRuleSPP returns [EObject current=null] : iv_ruleSPP= ruleSPP EOF ;
    public final EObject entryRuleSPP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPP = null;


        try {
            // InternalRoom.g:3667:2: (iv_ruleSPP= ruleSPP EOF )
            // InternalRoom.g:3668:2: iv_ruleSPP= ruleSPP EOF
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
    // InternalRoom.g:3675:1: ruleSPP returns [EObject current=null] : (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSPP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3678:28: ( (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3679:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3679:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // InternalRoom.g:3679:3: otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,63,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSPPAccess().getSPPKeyword_0());
                
            // InternalRoom.g:3683:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3684:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3684:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3685:3: lv_name_1_0= RULE_ID
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
                
            // InternalRoom.g:3705:1: ( ( ruleFQN ) )
            // InternalRoom.g:3706:1: ( ruleFQN )
            {
            // InternalRoom.g:3706:1: ( ruleFQN )
            // InternalRoom.g:3707:3: ruleFQN
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

            // InternalRoom.g:3720:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==35) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalRoom.g:3721:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3721:1: (lv_docu_4_0= ruleDocumentation )
                    // InternalRoom.g:3722:3: lv_docu_4_0= ruleDocumentation
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
    // InternalRoom.g:3746:1: entryRuleServiceImplementation returns [EObject current=null] : iv_ruleServiceImplementation= ruleServiceImplementation EOF ;
    public final EObject entryRuleServiceImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceImplementation = null;


        try {
            // InternalRoom.g:3747:2: (iv_ruleServiceImplementation= ruleServiceImplementation EOF )
            // InternalRoom.g:3748:2: iv_ruleServiceImplementation= ruleServiceImplementation EOF
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
    // InternalRoom.g:3755:1: ruleServiceImplementation returns [EObject current=null] : (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleServiceImplementation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:3758:28: ( (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:3759:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:3759:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:3759:3: otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,64,FOLLOW_90); 

                	newLeafNode(otherlv_0, grammarAccess.getServiceImplementationAccess().getServiceImplementationKeyword_0());
                
            otherlv_1=(Token)match(input,25,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getServiceImplementationAccess().getOfKeyword_1());
                
            // InternalRoom.g:3767:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:3768:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:3768:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:3769:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:3788:1: entryRuleLogicalSystem returns [EObject current=null] : iv_ruleLogicalSystem= ruleLogicalSystem EOF ;
    public final EObject entryRuleLogicalSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalSystem = null;


        try {
            // InternalRoom.g:3789:2: (iv_ruleLogicalSystem= ruleLogicalSystem EOF )
            // InternalRoom.g:3790:2: iv_ruleLogicalSystem= ruleLogicalSystem EOF
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
    // InternalRoom.g:3797:1: ruleLogicalSystem returns [EObject current=null] : (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' ) ;
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
            // InternalRoom.g:3800:28: ( (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' ) )
            // InternalRoom.g:3801:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' )
            {
            // InternalRoom.g:3801:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' )
            // InternalRoom.g:3801:3: otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalSystemAccess().getLogicalSystemKeyword_0());
                
            // InternalRoom.g:3805:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3806:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3806:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3807:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:3823:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==35) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalRoom.g:3824:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3824:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:3825:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_91); 

                	newLeafNode(otherlv_3, grammarAccess.getLogicalSystemAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:3845:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==109) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalRoom.g:3846:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:3846:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:3847:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_91);
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
            	    break loop97;
                }
            } while (true);

            // InternalRoom.g:3863:3: ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )*
            loop98:
            do {
                int alt98=4;
                switch ( input.LA(1) ) {
                case 75:
                    {
                    alt98=1;
                    }
                    break;
                case 71:
                    {
                    alt98=2;
                    }
                    break;
                case 66:
                    {
                    alt98=3;
                    }
                    break;

                }

                switch (alt98) {
            	case 1 :
            	    // InternalRoom.g:3863:4: ( (lv_connections_5_0= ruleLayerConnection ) )
            	    {
            	    // InternalRoom.g:3863:4: ( (lv_connections_5_0= ruleLayerConnection ) )
            	    // InternalRoom.g:3864:1: (lv_connections_5_0= ruleLayerConnection )
            	    {
            	    // InternalRoom.g:3864:1: (lv_connections_5_0= ruleLayerConnection )
            	    // InternalRoom.g:3865:3: lv_connections_5_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getConnectionsLayerConnectionParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_92);
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
            	    // InternalRoom.g:3882:6: ( (lv_bindings_6_0= ruleBinding ) )
            	    {
            	    // InternalRoom.g:3882:6: ( (lv_bindings_6_0= ruleBinding ) )
            	    // InternalRoom.g:3883:1: (lv_bindings_6_0= ruleBinding )
            	    {
            	    // InternalRoom.g:3883:1: (lv_bindings_6_0= ruleBinding )
            	    // InternalRoom.g:3884:3: lv_bindings_6_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getBindingsBindingParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_92);
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
            	    // InternalRoom.g:3901:6: ( (lv_subSystems_7_0= ruleSubSystemRef ) )
            	    {
            	    // InternalRoom.g:3901:6: ( (lv_subSystems_7_0= ruleSubSystemRef ) )
            	    // InternalRoom.g:3902:1: (lv_subSystems_7_0= ruleSubSystemRef )
            	    {
            	    // InternalRoom.g:3902:1: (lv_subSystems_7_0= ruleSubSystemRef )
            	    // InternalRoom.g:3903:3: lv_subSystems_7_0= ruleSubSystemRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getSubSystemsSubSystemRefParserRuleCall_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_92);
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
            	    break loop98;
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
    // InternalRoom.g:3933:1: entryRuleSubSystemRef returns [EObject current=null] : iv_ruleSubSystemRef= ruleSubSystemRef EOF ;
    public final EObject entryRuleSubSystemRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemRef = null;


        try {
            // InternalRoom.g:3934:2: (iv_ruleSubSystemRef= ruleSubSystemRef EOF )
            // InternalRoom.g:3935:2: iv_ruleSubSystemRef= ruleSubSystemRef EOF
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
    // InternalRoom.g:3942:1: ruleSubSystemRef returns [EObject current=null] : (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSubSystemRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3945:28: ( (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3946:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3946:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // InternalRoom.g:3946:3: otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,66,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemRefAccess().getSubSystemRefKeyword_0());
                
            // InternalRoom.g:3950:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3951:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3951:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3952:3: lv_name_1_0= RULE_ID
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
                
            // InternalRoom.g:3972:1: ( ( ruleFQN ) )
            // InternalRoom.g:3973:1: ( ruleFQN )
            {
            // InternalRoom.g:3973:1: ( ruleFQN )
            // InternalRoom.g:3974:3: ruleFQN
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

            // InternalRoom.g:3987:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==35) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalRoom.g:3988:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3988:1: (lv_docu_4_0= ruleDocumentation )
                    // InternalRoom.g:3989:3: lv_docu_4_0= ruleDocumentation
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
    // InternalRoom.g:4013:1: entryRuleSubSystemClass returns [EObject current=null] : iv_ruleSubSystemClass= ruleSubSystemClass EOF ;
    public final EObject entryRuleSubSystemClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemClass = null;


        try {
            // InternalRoom.g:4014:2: (iv_ruleSubSystemClass= ruleSubSystemClass EOF )
            // InternalRoom.g:4015:2: iv_ruleSubSystemClass= ruleSubSystemClass EOF
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
    // InternalRoom.g:4022:1: ruleSubSystemClass returns [EObject current=null] : (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' ) ;
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
            // InternalRoom.g:4025:28: ( (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' ) )
            // InternalRoom.g:4026:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' )
            {
            // InternalRoom.g:4026:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' )
            // InternalRoom.g:4026:3: otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,67,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemClassAccess().getSubSystemClassKeyword_0());
                
            // InternalRoom.g:4030:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:4031:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:4031:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:4032:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:4048:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==35) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalRoom.g:4049:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:4049:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:4050:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_93); 

                	newLeafNode(otherlv_3, grammarAccess.getSubSystemClassAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:4070:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==109) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalRoom.g:4071:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:4071:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:4072:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_93);
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
            	    break loop101;
                }
            } while (true);

            // InternalRoom.g:4088:3: (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==31) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalRoom.g:4088:5: otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) )
                    {
                    otherlv_5=(Token)match(input,31,FOLLOW_94); 

                        	newLeafNode(otherlv_5, grammarAccess.getSubSystemClassAccess().getUsercode1Keyword_5_0());
                        
                    // InternalRoom.g:4092:1: ( (lv_userCode1_6_0= ruleDetailCode ) )
                    // InternalRoom.g:4093:1: (lv_userCode1_6_0= ruleDetailCode )
                    {
                    // InternalRoom.g:4093:1: (lv_userCode1_6_0= ruleDetailCode )
                    // InternalRoom.g:4094:3: lv_userCode1_6_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode1DetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_95);
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

            // InternalRoom.g:4110:4: (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==32) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalRoom.g:4110:6: otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,32,FOLLOW_96); 

                        	newLeafNode(otherlv_7, grammarAccess.getSubSystemClassAccess().getUsercode2Keyword_6_0());
                        
                    // InternalRoom.g:4114:1: ( (lv_userCode2_8_0= ruleDetailCode ) )
                    // InternalRoom.g:4115:1: (lv_userCode2_8_0= ruleDetailCode )
                    {
                    // InternalRoom.g:4115:1: (lv_userCode2_8_0= ruleDetailCode )
                    // InternalRoom.g:4116:3: lv_userCode2_8_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode2DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_97);
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

            // InternalRoom.g:4132:4: (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==33) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalRoom.g:4132:6: otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,33,FOLLOW_98); 

                        	newLeafNode(otherlv_9, grammarAccess.getSubSystemClassAccess().getUsercode3Keyword_7_0());
                        
                    // InternalRoom.g:4136:1: ( (lv_userCode3_10_0= ruleDetailCode ) )
                    // InternalRoom.g:4137:1: (lv_userCode3_10_0= ruleDetailCode )
                    {
                    // InternalRoom.g:4137:1: (lv_userCode3_10_0= ruleDetailCode )
                    // InternalRoom.g:4138:3: lv_userCode3_10_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode3DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_99);
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

            // InternalRoom.g:4154:4: ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )*
            loop105:
            do {
                int alt105=8;
                switch ( input.LA(1) ) {
                case 69:
                    {
                    alt105=1;
                    }
                    break;
                case 68:
                    {
                    alt105=2;
                    }
                    break;
                case 75:
                    {
                    alt105=3;
                    }
                    break;
                case 71:
                    {
                    alt105=4;
                    }
                    break;
                case 78:
                case 112:
                case 128:
                    {
                    alt105=5;
                    }
                    break;
                case 63:
                    {
                    alt105=6;
                    }
                    break;
                case 48:
                case 60:
                    {
                    alt105=7;
                    }
                    break;

                }

                switch (alt105) {
            	case 1 :
            	    // InternalRoom.g:4154:5: ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) )
            	    {
            	    // InternalRoom.g:4154:5: ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) )
            	    // InternalRoom.g:4155:1: (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping )
            	    {
            	    // InternalRoom.g:4155:1: (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping )
            	    // InternalRoom.g:4156:3: lv_actorInstanceMappings_11_0= ruleActorInstanceMapping
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_8_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_99);
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
            	    // InternalRoom.g:4173:6: ( (lv_threads_12_0= ruleLogicalThread ) )
            	    {
            	    // InternalRoom.g:4173:6: ( (lv_threads_12_0= ruleLogicalThread ) )
            	    // InternalRoom.g:4174:1: (lv_threads_12_0= ruleLogicalThread )
            	    {
            	    // InternalRoom.g:4174:1: (lv_threads_12_0= ruleLogicalThread )
            	    // InternalRoom.g:4175:3: lv_threads_12_0= ruleLogicalThread
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getThreadsLogicalThreadParserRuleCall_8_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_99);
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
            	    // InternalRoom.g:4192:6: ( (lv_connections_13_0= ruleLayerConnection ) )
            	    {
            	    // InternalRoom.g:4192:6: ( (lv_connections_13_0= ruleLayerConnection ) )
            	    // InternalRoom.g:4193:1: (lv_connections_13_0= ruleLayerConnection )
            	    {
            	    // InternalRoom.g:4193:1: (lv_connections_13_0= ruleLayerConnection )
            	    // InternalRoom.g:4194:3: lv_connections_13_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getConnectionsLayerConnectionParserRuleCall_8_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_99);
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
            	    // InternalRoom.g:4211:6: ( (lv_bindings_14_0= ruleBinding ) )
            	    {
            	    // InternalRoom.g:4211:6: ( (lv_bindings_14_0= ruleBinding ) )
            	    // InternalRoom.g:4212:1: (lv_bindings_14_0= ruleBinding )
            	    {
            	    // InternalRoom.g:4212:1: (lv_bindings_14_0= ruleBinding )
            	    // InternalRoom.g:4213:3: lv_bindings_14_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getBindingsBindingParserRuleCall_8_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_99);
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
            	    // InternalRoom.g:4230:6: ( (lv_actorRefs_15_0= ruleActorRef ) )
            	    {
            	    // InternalRoom.g:4230:6: ( (lv_actorRefs_15_0= ruleActorRef ) )
            	    // InternalRoom.g:4231:1: (lv_actorRefs_15_0= ruleActorRef )
            	    {
            	    // InternalRoom.g:4231:1: (lv_actorRefs_15_0= ruleActorRef )
            	    // InternalRoom.g:4232:3: lv_actorRefs_15_0= ruleActorRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getActorRefsActorRefParserRuleCall_8_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_99);
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
            	    // InternalRoom.g:4249:6: ( (lv_serviceProvisionPoints_16_0= ruleSPP ) )
            	    {
            	    // InternalRoom.g:4249:6: ( (lv_serviceProvisionPoints_16_0= ruleSPP ) )
            	    // InternalRoom.g:4250:1: (lv_serviceProvisionPoints_16_0= ruleSPP )
            	    {
            	    // InternalRoom.g:4250:1: (lv_serviceProvisionPoints_16_0= ruleSPP )
            	    // InternalRoom.g:4251:3: lv_serviceProvisionPoints_16_0= ruleSPP
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getServiceProvisionPointsSPPParserRuleCall_8_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_99);
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
            	    // InternalRoom.g:4268:6: ( (lv_relayPorts_17_0= rulePort ) )
            	    {
            	    // InternalRoom.g:4268:6: ( (lv_relayPorts_17_0= rulePort ) )
            	    // InternalRoom.g:4269:1: (lv_relayPorts_17_0= rulePort )
            	    {
            	    // InternalRoom.g:4269:1: (lv_relayPorts_17_0= rulePort )
            	    // InternalRoom.g:4270:3: lv_relayPorts_17_0= rulePort
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getRelayPortsPortParserRuleCall_8_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_99);
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
            	    break loop105;
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
    // InternalRoom.g:4298:1: entryRuleLogicalThread returns [EObject current=null] : iv_ruleLogicalThread= ruleLogicalThread EOF ;
    public final EObject entryRuleLogicalThread() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalThread = null;


        try {
            // InternalRoom.g:4299:2: (iv_ruleLogicalThread= ruleLogicalThread EOF )
            // InternalRoom.g:4300:2: iv_ruleLogicalThread= ruleLogicalThread EOF
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
    // InternalRoom.g:4307:1: ruleLogicalThread returns [EObject current=null] : (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleLogicalThread() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4310:28: ( (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:4311:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:4311:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:4311:3: otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalThreadAccess().getLogicalThreadKeyword_0());
                
            // InternalRoom.g:4315:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:4316:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:4316:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:4317:3: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:4341:1: entryRuleActorInstanceMapping returns [EObject current=null] : iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF ;
    public final EObject entryRuleActorInstanceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstanceMapping = null;


        try {
            // InternalRoom.g:4342:2: (iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF )
            // InternalRoom.g:4343:2: iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF
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
    // InternalRoom.g:4350:1: ruleActorInstanceMapping returns [EObject current=null] : (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) ;
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
            // InternalRoom.g:4353:28: ( (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) )
            // InternalRoom.g:4354:1: (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            {
            // InternalRoom.g:4354:1: (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            // InternalRoom.g:4354:3: otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,69,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingKeyword_0());
                
            // InternalRoom.g:4358:1: ( (lv_path_1_0= ruleRefPath ) )
            // InternalRoom.g:4359:1: (lv_path_1_0= ruleRefPath )
            {
            // InternalRoom.g:4359:1: (lv_path_1_0= ruleRefPath )
            // InternalRoom.g:4360:3: lv_path_1_0= ruleRefPath
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
                
            // InternalRoom.g:4380:1: ( (otherlv_3= RULE_ID ) )
            // InternalRoom.g:4381:1: (otherlv_3= RULE_ID )
            {
            // InternalRoom.g:4381:1: (otherlv_3= RULE_ID )
            // InternalRoom.g:4382:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorInstanceMappingRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_100); 

            		newLeafNode(otherlv_3, grammarAccess.getActorInstanceMappingAccess().getThreadLogicalThreadCrossReference_3_0()); 
            	

            }


            }

            // InternalRoom.g:4393:2: (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==14) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalRoom.g:4393:4: otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_101); 

                        	newLeafNode(otherlv_4, grammarAccess.getActorInstanceMappingAccess().getLeftCurlyBracketKeyword_4_0());
                        
                    // InternalRoom.g:4397:1: ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )*
                    loop106:
                    do {
                        int alt106=2;
                        int LA106_0 = input.LA(1);

                        if ( (LA106_0==69) ) {
                            alt106=1;
                        }


                        switch (alt106) {
                    	case 1 :
                    	    // InternalRoom.g:4398:1: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    {
                    	    // InternalRoom.g:4398:1: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    // InternalRoom.g:4399:3: lv_actorInstanceMappings_5_0= ruleActorInstanceMapping
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_101);
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
                    	    break loop106;
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
    // InternalRoom.g:4427:1: entryRuleRefPath returns [EObject current=null] : iv_ruleRefPath= ruleRefPath EOF ;
    public final EObject entryRuleRefPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefPath = null;


        try {
            // InternalRoom.g:4428:2: (iv_ruleRefPath= ruleRefPath EOF )
            // InternalRoom.g:4429:2: iv_ruleRefPath= ruleRefPath EOF
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
    // InternalRoom.g:4436:1: ruleRefPath returns [EObject current=null] : ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* ) ;
    public final EObject ruleRefPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_refs_0_0 = null;

        EObject lv_refs_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4439:28: ( ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* ) )
            // InternalRoom.g:4440:1: ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* )
            {
            // InternalRoom.g:4440:1: ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* )
            // InternalRoom.g:4440:2: ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )*
            {
            // InternalRoom.g:4440:2: ( (lv_refs_0_0= ruleRefSegment ) )
            // InternalRoom.g:4441:1: (lv_refs_0_0= ruleRefSegment )
            {
            // InternalRoom.g:4441:1: (lv_refs_0_0= ruleRefSegment )
            // InternalRoom.g:4442:3: lv_refs_0_0= ruleRefSegment
            {
             
            	        newCompositeNode(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_102);
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

            // InternalRoom.g:4458:2: (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==70) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // InternalRoom.g:4458:4: otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) )
            	    {
            	    otherlv_1=(Token)match(input,70,FOLLOW_3); 

            	        	newLeafNode(otherlv_1, grammarAccess.getRefPathAccess().getSolidusKeyword_1_0());
            	        
            	    // InternalRoom.g:4462:1: ( (lv_refs_2_0= ruleRefSegment ) )
            	    // InternalRoom.g:4463:1: (lv_refs_2_0= ruleRefSegment )
            	    {
            	    // InternalRoom.g:4463:1: (lv_refs_2_0= ruleRefSegment )
            	    // InternalRoom.g:4464:3: lv_refs_2_0= ruleRefSegment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_102);
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
            	    break loop108;
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
    // InternalRoom.g:4488:1: entryRuleRefSegment returns [EObject current=null] : iv_ruleRefSegment= ruleRefSegment EOF ;
    public final EObject entryRuleRefSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSegment = null;


        try {
            // InternalRoom.g:4489:2: (iv_ruleRefSegment= ruleRefSegment EOF )
            // InternalRoom.g:4490:2: iv_ruleRefSegment= ruleRefSegment EOF
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
    // InternalRoom.g:4497:1: ruleRefSegment returns [EObject current=null] : ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleRefSegment() throws RecognitionException {
        EObject current = null;

        Token lv_ref_0_0=null;
        Token otherlv_1=null;
        Token lv_idx_2_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4500:28: ( ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? ) )
            // InternalRoom.g:4501:1: ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? )
            {
            // InternalRoom.g:4501:1: ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? )
            // InternalRoom.g:4501:2: ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )?
            {
            // InternalRoom.g:4501:2: ( (lv_ref_0_0= RULE_ID ) )
            // InternalRoom.g:4502:1: (lv_ref_0_0= RULE_ID )
            {
            // InternalRoom.g:4502:1: (lv_ref_0_0= RULE_ID )
            // InternalRoom.g:4503:3: lv_ref_0_0= RULE_ID
            {
            lv_ref_0_0=(Token)match(input,RULE_ID,FOLLOW_103); 

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

            // InternalRoom.g:4519:2: (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==16) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalRoom.g:4519:4: otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_37); 

                        	newLeafNode(otherlv_1, grammarAccess.getRefSegmentAccess().getColonKeyword_1_0());
                        
                    // InternalRoom.g:4523:1: ( (lv_idx_2_0= RULE_INT ) )
                    // InternalRoom.g:4524:1: (lv_idx_2_0= RULE_INT )
                    {
                    // InternalRoom.g:4524:1: (lv_idx_2_0= RULE_INT )
                    // InternalRoom.g:4525:3: lv_idx_2_0= RULE_INT
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
    // InternalRoom.g:4549:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalRoom.g:4550:2: (iv_ruleBinding= ruleBinding EOF )
            // InternalRoom.g:4551:2: iv_ruleBinding= ruleBinding EOF
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
    // InternalRoom.g:4558:1: ruleBinding returns [EObject current=null] : (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_endpoint1_1_0 = null;

        EObject lv_endpoint2_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4561:28: ( (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) )
            // InternalRoom.g:4562:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            {
            // InternalRoom.g:4562:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            // InternalRoom.g:4562:3: otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            {
            otherlv_0=(Token)match(input,71,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getBindingAccess().getBindingKeyword_0());
                
            // InternalRoom.g:4566:1: ( (lv_endpoint1_1_0= ruleBindingEndPoint ) )
            // InternalRoom.g:4567:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            {
            // InternalRoom.g:4567:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            // InternalRoom.g:4568:3: lv_endpoint1_1_0= ruleBindingEndPoint
            {
             
            	        newCompositeNode(grammarAccess.getBindingAccess().getEndpoint1BindingEndPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_104);
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
                
            // InternalRoom.g:4588:1: ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            // InternalRoom.g:4589:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            {
            // InternalRoom.g:4589:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            // InternalRoom.g:4590:3: lv_endpoint2_3_0= ruleBindingEndPoint
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
    // InternalRoom.g:4614:1: entryRuleBindingEndPoint returns [EObject current=null] : iv_ruleBindingEndPoint= ruleBindingEndPoint EOF ;
    public final EObject entryRuleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingEndPoint = null;


        try {
            // InternalRoom.g:4615:2: (iv_ruleBindingEndPoint= ruleBindingEndPoint EOF )
            // InternalRoom.g:4616:2: iv_ruleBindingEndPoint= ruleBindingEndPoint EOF
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
    // InternalRoom.g:4623:1: ruleBindingEndPoint returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4626:28: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalRoom.g:4627:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalRoom.g:4627:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalRoom.g:4627:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalRoom.g:4627:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==RULE_ID) ) {
                int LA110_1 = input.LA(2);

                if ( (LA110_1==73) ) {
                    alt110=1;
                }
            }
            switch (alt110) {
                case 1 :
                    // InternalRoom.g:4627:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // InternalRoom.g:4627:3: ( (otherlv_0= RULE_ID ) )
                    // InternalRoom.g:4628:1: (otherlv_0= RULE_ID )
                    {
                    // InternalRoom.g:4628:1: (otherlv_0= RULE_ID )
                    // InternalRoom.g:4629:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBindingEndPointRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_105); 

                    		newLeafNode(otherlv_0, grammarAccess.getBindingEndPointAccess().getActorRefActorContainerRefCrossReference_0_0_0()); 
                    	

                    }


                    }

                    otherlv_1=(Token)match(input,73,FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getBindingEndPointAccess().getFullStopKeyword_0_1());
                        

                    }
                    break;

            }

            // InternalRoom.g:4644:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:4645:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:4645:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:4646:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBindingEndPointRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_106); 

            		newLeafNode(otherlv_2, grammarAccess.getBindingEndPointAccess().getPortPortCrossReference_1_0()); 
            	

            }


            }

            // InternalRoom.g:4657:2: (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==74) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalRoom.g:4657:4: otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,74,FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getBindingEndPointAccess().getSubKeyword_2_0());
                        
                    // InternalRoom.g:4661:1: ( (otherlv_4= RULE_ID ) )
                    // InternalRoom.g:4662:1: (otherlv_4= RULE_ID )
                    {
                    // InternalRoom.g:4662:1: (otherlv_4= RULE_ID )
                    // InternalRoom.g:4663:3: otherlv_4= RULE_ID
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
    // InternalRoom.g:4682:1: entryRuleLayerConnection returns [EObject current=null] : iv_ruleLayerConnection= ruleLayerConnection EOF ;
    public final EObject entryRuleLayerConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerConnection = null;


        try {
            // InternalRoom.g:4683:2: (iv_ruleLayerConnection= ruleLayerConnection EOF )
            // InternalRoom.g:4684:2: iv_ruleLayerConnection= ruleLayerConnection EOF
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
    // InternalRoom.g:4691:1: ruleLayerConnection returns [EObject current=null] : (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) ;
    public final EObject ruleLayerConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_from_1_0 = null;

        EObject lv_to_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4694:28: ( (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) )
            // InternalRoom.g:4695:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            {
            // InternalRoom.g:4695:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            // InternalRoom.g:4695:3: otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) )
            {
            otherlv_0=(Token)match(input,75,FOLLOW_107); 

                	newLeafNode(otherlv_0, grammarAccess.getLayerConnectionAccess().getLayerConnectionKeyword_0());
                
            // InternalRoom.g:4699:1: ( (lv_from_1_0= ruleSAPoint ) )
            // InternalRoom.g:4700:1: (lv_from_1_0= ruleSAPoint )
            {
            // InternalRoom.g:4700:1: (lv_from_1_0= ruleSAPoint )
            // InternalRoom.g:4701:3: lv_from_1_0= ruleSAPoint
            {
             
            	        newCompositeNode(grammarAccess.getLayerConnectionAccess().getFromSAPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_108);
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
                
            // InternalRoom.g:4721:1: ( (lv_to_3_0= ruleSPPoint ) )
            // InternalRoom.g:4722:1: (lv_to_3_0= ruleSPPoint )
            {
            // InternalRoom.g:4722:1: (lv_to_3_0= ruleSPPoint )
            // InternalRoom.g:4723:3: lv_to_3_0= ruleSPPoint
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
    // InternalRoom.g:4747:1: entryRuleSAPoint returns [EObject current=null] : iv_ruleSAPoint= ruleSAPoint EOF ;
    public final EObject entryRuleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPoint = null;


        try {
            // InternalRoom.g:4748:2: (iv_ruleSAPoint= ruleSAPoint EOF )
            // InternalRoom.g:4749:2: iv_ruleSAPoint= ruleSAPoint EOF
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
    // InternalRoom.g:4756:1: ruleSAPoint returns [EObject current=null] : (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) ;
    public final EObject ruleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject this_RefSAPoint_0 = null;

        EObject this_RelaySAPoint_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4759:28: ( (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) )
            // InternalRoom.g:4760:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            {
            // InternalRoom.g:4760:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==18) ) {
                alt112=1;
            }
            else if ( (LA112_0==77) ) {
                alt112=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }
            switch (alt112) {
                case 1 :
                    // InternalRoom.g:4761:5: this_RefSAPoint_0= ruleRefSAPoint
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
                    // InternalRoom.g:4771:5: this_RelaySAPoint_1= ruleRelaySAPoint
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
    // InternalRoom.g:4787:1: entryRuleRefSAPoint returns [EObject current=null] : iv_ruleRefSAPoint= ruleRefSAPoint EOF ;
    public final EObject entryRuleRefSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSAPoint = null;


        try {
            // InternalRoom.g:4788:2: (iv_ruleRefSAPoint= ruleRefSAPoint EOF )
            // InternalRoom.g:4789:2: iv_ruleRefSAPoint= ruleRefSAPoint EOF
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
    // InternalRoom.g:4796:1: ruleRefSAPoint returns [EObject current=null] : (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRefSAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4799:28: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:4800:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:4800:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:4800:3: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRefSAPointAccess().getRefKeyword_0());
                
            // InternalRoom.g:4804:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:4805:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:4805:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:4806:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:4825:1: entryRuleRelaySAPoint returns [EObject current=null] : iv_ruleRelaySAPoint= ruleRelaySAPoint EOF ;
    public final EObject entryRuleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelaySAPoint = null;


        try {
            // InternalRoom.g:4826:2: (iv_ruleRelaySAPoint= ruleRelaySAPoint EOF )
            // InternalRoom.g:4827:2: iv_ruleRelaySAPoint= ruleRelaySAPoint EOF
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
    // InternalRoom.g:4834:1: ruleRelaySAPoint returns [EObject current=null] : (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4837:28: ( (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:4838:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:4838:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:4838:3: otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,77,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRelaySAPointAccess().getRelay_sapKeyword_0());
                
            // InternalRoom.g:4842:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:4843:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:4843:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:4844:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:4863:1: entryRuleSPPoint returns [EObject current=null] : iv_ruleSPPoint= ruleSPPoint EOF ;
    public final EObject entryRuleSPPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPoint = null;


        try {
            // InternalRoom.g:4864:2: (iv_ruleSPPoint= ruleSPPoint EOF )
            // InternalRoom.g:4865:2: iv_ruleSPPoint= ruleSPPoint EOF
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
    // InternalRoom.g:4872:1: ruleSPPoint returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSPPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4875:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:4876:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:4876:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:4876:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:4876:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:4877:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:4877:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:4878:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPointRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_105); 

            		newLeafNode(otherlv_0, grammarAccess.getSPPointAccess().getRefActorContainerRefCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,73,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getSPPointAccess().getFullStopKeyword_1());
                
            // InternalRoom.g:4893:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:4894:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:4894:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:4895:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:4914:1: entryRuleActorRef returns [EObject current=null] : iv_ruleActorRef= ruleActorRef EOF ;
    public final EObject entryRuleActorRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorRef = null;


        try {
            // InternalRoom.g:4915:2: (iv_ruleActorRef= ruleActorRef EOF )
            // InternalRoom.g:4916:2: iv_ruleActorRef= ruleActorRef EOF
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
    // InternalRoom.g:4923:1: ruleActorRef returns [EObject current=null] : ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:4926:28: ( ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:4927:1: ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:4927:1: ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            // InternalRoom.g:4927:2: ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:4927:2: ( (lv_refType_0_0= ruleReferenceType ) )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==112||LA113_0==128) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // InternalRoom.g:4928:1: (lv_refType_0_0= ruleReferenceType )
                    {
                    // InternalRoom.g:4928:1: (lv_refType_0_0= ruleReferenceType )
                    // InternalRoom.g:4929:3: lv_refType_0_0= ruleReferenceType
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorRefAccess().getRefTypeReferenceTypeEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_109);
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
                
            // InternalRoom.g:4949:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:4950:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:4950:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:4951:3: lv_name_2_0= RULE_ID
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

            // InternalRoom.g:4967:2: ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==35) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalRoom.g:4968:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    {
                    // InternalRoom.g:4968:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    // InternalRoom.g:4969:3: lv_multiplicity_3_0= ruleMULTIPLICITY
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
                
            // InternalRoom.g:4989:1: ( ( ruleFQN ) )
            // InternalRoom.g:4990:1: ( ruleFQN )
            {
            // InternalRoom.g:4990:1: ( ruleFQN )
            // InternalRoom.g:4991:3: ruleFQN
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

            // InternalRoom.g:5004:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==35) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // InternalRoom.g:5005:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:5005:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:5006:3: lv_docu_6_0= ruleDocumentation
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
    // InternalRoom.g:5032:1: entryRuleMULTIPLICITY returns [String current=null] : iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF ;
    public final String entryRuleMULTIPLICITY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMULTIPLICITY = null;


        try {
            // InternalRoom.g:5033:2: (iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF )
            // InternalRoom.g:5034:2: iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF
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
    // InternalRoom.g:5041:1: ruleMULTIPLICITY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleMULTIPLICITY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5044:28: ( (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' ) )
            // InternalRoom.g:5045:1: (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' )
            {
            // InternalRoom.g:5045:1: (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' )
            // InternalRoom.g:5046:2: kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']'
            {
            kw=(Token)match(input,35,FOLLOW_110); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getMULTIPLICITYAccess().getLeftSquareBracketKeyword_0()); 
                
            // InternalRoom.g:5051:1: (kw= '*' | this_INT_2= RULE_INT )
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==79) ) {
                alt116=1;
            }
            else if ( (LA116_0==RULE_INT) ) {
                alt116=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;
            }
            switch (alt116) {
                case 1 :
                    // InternalRoom.g:5052:2: kw= '*'
                    {
                    kw=(Token)match(input,79,FOLLOW_38); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMULTIPLICITYAccess().getAsteriskKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:5058:10: this_INT_2= RULE_INT
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
    // InternalRoom.g:5079:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // InternalRoom.g:5080:2: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // InternalRoom.g:5081:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
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
    // InternalRoom.g:5088:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' | kw= 'State' | kw= 'Transition' | kw= 'RoomModel' ) ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5091:28: ( (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' | kw= 'State' | kw= 'Transition' | kw= 'RoomModel' ) )
            // InternalRoom.g:5092:1: (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' | kw= 'State' | kw= 'Transition' | kw= 'RoomModel' )
            {
            // InternalRoom.g:5092:1: (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' | kw= 'State' | kw= 'Transition' | kw= 'RoomModel' )
            int alt117=12;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt117=1;
                }
                break;
            case 56:
                {
                alt117=2;
                }
                break;
            case 80:
                {
                alt117=3;
                }
                break;
            case 43:
                {
                alt117=4;
                }
                break;
            case 49:
                {
                alt117=5;
                }
                break;
            case 67:
                {
                alt117=6;
                }
                break;
            case 65:
                {
                alt117=7;
                }
                break;
            case 60:
                {
                alt117=8;
                }
                break;
            case 52:
                {
                alt117=9;
                }
                break;
            case 81:
                {
                alt117=10;
                }
                break;
            case 82:
                {
                alt117=11;
                }
                break;
            case 13:
                {
                alt117=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }

            switch (alt117) {
                case 1 :
                    // InternalRoom.g:5093:2: kw= 'DataClass'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getDataClassKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:5100:2: kw= 'ActorClass'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getActorClassKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalRoom.g:5107:2: kw= 'ActorBehavior'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getActorBehaviorKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalRoom.g:5114:2: kw= 'ProtocolClass'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getProtocolClassKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalRoom.g:5121:2: kw= 'CompoundProtocolClass'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getCompoundProtocolClassKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalRoom.g:5128:2: kw= 'SubSystemClass'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getSubSystemClassKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalRoom.g:5135:2: kw= 'LogicalSystem'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getLogicalSystemKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalRoom.g:5142:2: kw= 'Port'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getPortKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalRoom.g:5149:2: kw= 'Message'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getMessageKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // InternalRoom.g:5156:2: kw= 'State'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getStateKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // InternalRoom.g:5163:2: kw= 'Transition'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getTransitionKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // InternalRoom.g:5170:2: kw= 'RoomModel'
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
    // InternalRoom.g:5185:1: entryRuleStateGraphNode returns [EObject current=null] : iv_ruleStateGraphNode= ruleStateGraphNode EOF ;
    public final EObject entryRuleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraphNode = null;


        try {
            // InternalRoom.g:5186:2: (iv_ruleStateGraphNode= ruleStateGraphNode EOF )
            // InternalRoom.g:5187:2: iv_ruleStateGraphNode= ruleStateGraphNode EOF
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
    // InternalRoom.g:5194:1: ruleStateGraphNode returns [EObject current=null] : (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) ;
    public final EObject ruleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_ChoicePoint_1 = null;

        EObject this_TrPoint_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:5197:28: ( (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) )
            // InternalRoom.g:5198:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            {
            // InternalRoom.g:5198:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            int alt118=3;
            switch ( input.LA(1) ) {
            case 81:
            case 88:
                {
                alt118=1;
                }
                break;
            case 93:
                {
                alt118=2;
                }
                break;
            case 89:
            case 90:
            case 91:
            case 92:
                {
                alt118=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;
            }

            switch (alt118) {
                case 1 :
                    // InternalRoom.g:5199:5: this_State_0= ruleState
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
                    // InternalRoom.g:5209:5: this_ChoicePoint_1= ruleChoicePoint
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
                    // InternalRoom.g:5219:5: this_TrPoint_2= ruleTrPoint
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
    // InternalRoom.g:5237:1: entryRuleStateGraph returns [EObject current=null] : iv_ruleStateGraph= ruleStateGraph EOF ;
    public final EObject entryRuleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraph = null;


        try {
            // InternalRoom.g:5238:2: (iv_ruleStateGraph= ruleStateGraph EOF )
            // InternalRoom.g:5239:2: iv_ruleStateGraph= ruleStateGraph EOF
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
    // InternalRoom.g:5246:1: ruleStateGraph returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) ;
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
            // InternalRoom.g:5249:28: ( ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) )
            // InternalRoom.g:5250:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            {
            // InternalRoom.g:5250:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            // InternalRoom.g:5250:2: () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}'
            {
            // InternalRoom.g:5250:2: ()
            // InternalRoom.g:5251:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateGraphAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,14,FOLLOW_111); 

                	newLeafNode(otherlv_1, grammarAccess.getStateGraphAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalRoom.g:5260:1: ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )*
            loop119:
            do {
                int alt119=6;
                switch ( input.LA(1) ) {
                case 81:
                case 88:
                    {
                    alt119=1;
                    }
                    break;
                case 89:
                case 90:
                case 91:
                case 92:
                    {
                    alt119=2;
                    }
                    break;
                case 93:
                    {
                    alt119=3;
                    }
                    break;
                case 82:
                    {
                    alt119=4;
                    }
                    break;
                case 100:
                    {
                    alt119=5;
                    }
                    break;

                }

                switch (alt119) {
            	case 1 :
            	    // InternalRoom.g:5260:2: ( (lv_states_2_0= ruleState ) )
            	    {
            	    // InternalRoom.g:5260:2: ( (lv_states_2_0= ruleState ) )
            	    // InternalRoom.g:5261:1: (lv_states_2_0= ruleState )
            	    {
            	    // InternalRoom.g:5261:1: (lv_states_2_0= ruleState )
            	    // InternalRoom.g:5262:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getStatesStateParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_111);
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
            	    // InternalRoom.g:5279:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    {
            	    // InternalRoom.g:5279:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    // InternalRoom.g:5280:1: (lv_trPoints_3_0= ruleTrPoint )
            	    {
            	    // InternalRoom.g:5280:1: (lv_trPoints_3_0= ruleTrPoint )
            	    // InternalRoom.g:5281:3: lv_trPoints_3_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTrPointsTrPointParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_111);
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
            	    // InternalRoom.g:5298:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    {
            	    // InternalRoom.g:5298:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    // InternalRoom.g:5299:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    {
            	    // InternalRoom.g:5299:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    // InternalRoom.g:5300:3: lv_chPoints_4_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getChPointsChoicePointParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_111);
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
            	    // InternalRoom.g:5317:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    {
            	    // InternalRoom.g:5317:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    // InternalRoom.g:5318:1: (lv_transitions_5_0= ruleTransition )
            	    {
            	    // InternalRoom.g:5318:1: (lv_transitions_5_0= ruleTransition )
            	    // InternalRoom.g:5319:3: lv_transitions_5_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTransitionsTransitionParserRuleCall_2_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_111);
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
            	    // InternalRoom.g:5336:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    {
            	    // InternalRoom.g:5336:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    // InternalRoom.g:5337:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    {
            	    // InternalRoom.g:5337:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    // InternalRoom.g:5338:3: lv_refinedTransitions_6_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_2_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_111);
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
            	    break loop119;
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
    // InternalRoom.g:5366:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // InternalRoom.g:5367:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // InternalRoom.g:5368:2: iv_ruleStateMachine= ruleStateMachine EOF
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
    // InternalRoom.g:5375:1: ruleStateMachine returns [EObject current=null] : ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) ;
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
            // InternalRoom.g:5378:28: ( ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) )
            // InternalRoom.g:5379:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            {
            // InternalRoom.g:5379:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            // InternalRoom.g:5379:2: () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}'
            {
            // InternalRoom.g:5379:2: ()
            // InternalRoom.g:5380:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateMachineAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,83,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getStateMachineAccess().getStateMachineKeyword_1());
                
            otherlv_2=(Token)match(input,14,FOLLOW_111); 

                	newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalRoom.g:5393:1: ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )*
            loop120:
            do {
                int alt120=6;
                switch ( input.LA(1) ) {
                case 81:
                case 88:
                    {
                    alt120=1;
                    }
                    break;
                case 89:
                case 90:
                case 91:
                case 92:
                    {
                    alt120=2;
                    }
                    break;
                case 93:
                    {
                    alt120=3;
                    }
                    break;
                case 82:
                    {
                    alt120=4;
                    }
                    break;
                case 100:
                    {
                    alt120=5;
                    }
                    break;

                }

                switch (alt120) {
            	case 1 :
            	    // InternalRoom.g:5393:2: ( (lv_states_3_0= ruleState ) )
            	    {
            	    // InternalRoom.g:5393:2: ( (lv_states_3_0= ruleState ) )
            	    // InternalRoom.g:5394:1: (lv_states_3_0= ruleState )
            	    {
            	    // InternalRoom.g:5394:1: (lv_states_3_0= ruleState )
            	    // InternalRoom.g:5395:3: lv_states_3_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_111);
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
            	    // InternalRoom.g:5412:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    {
            	    // InternalRoom.g:5412:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    // InternalRoom.g:5413:1: (lv_trPoints_4_0= ruleTrPoint )
            	    {
            	    // InternalRoom.g:5413:1: (lv_trPoints_4_0= ruleTrPoint )
            	    // InternalRoom.g:5414:3: lv_trPoints_4_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTrPointsTrPointParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_111);
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
            	    // InternalRoom.g:5431:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    {
            	    // InternalRoom.g:5431:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    // InternalRoom.g:5432:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    {
            	    // InternalRoom.g:5432:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    // InternalRoom.g:5433:3: lv_chPoints_5_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getChPointsChoicePointParserRuleCall_3_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_111);
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
            	    // InternalRoom.g:5450:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    {
            	    // InternalRoom.g:5450:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    // InternalRoom.g:5451:1: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // InternalRoom.g:5451:1: (lv_transitions_6_0= ruleTransition )
            	    // InternalRoom.g:5452:3: lv_transitions_6_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_3_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_111);
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
            	    // InternalRoom.g:5469:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    {
            	    // InternalRoom.g:5469:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    // InternalRoom.g:5470:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    {
            	    // InternalRoom.g:5470:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    // InternalRoom.g:5471:3: lv_refinedTransitions_7_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_3_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_111);
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
            	    break loop120;
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
    // InternalRoom.g:5499:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalRoom.g:5500:2: (iv_ruleState= ruleState EOF )
            // InternalRoom.g:5501:2: iv_ruleState= ruleState EOF
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
    // InternalRoom.g:5508:1: ruleState returns [EObject current=null] : (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleState_0 = null;

        EObject this_RefinedState_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:5511:28: ( (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) )
            // InternalRoom.g:5512:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            {
            // InternalRoom.g:5512:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==81) ) {
                alt121=1;
            }
            else if ( (LA121_0==88) ) {
                alt121=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }
            switch (alt121) {
                case 1 :
                    // InternalRoom.g:5513:5: this_SimpleState_0= ruleSimpleState
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
                    // InternalRoom.g:5523:5: this_RefinedState_1= ruleRefinedState
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
    // InternalRoom.g:5539:1: entryRuleSimpleState returns [EObject current=null] : iv_ruleSimpleState= ruleSimpleState EOF ;
    public final EObject entryRuleSimpleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleState = null;


        try {
            // InternalRoom.g:5540:2: (iv_ruleSimpleState= ruleSimpleState EOF )
            // InternalRoom.g:5541:2: iv_ruleSimpleState= ruleSimpleState EOF
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
    // InternalRoom.g:5548:1: ruleSimpleState returns [EObject current=null] : (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? ) ;
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
            // InternalRoom.g:5551:28: ( (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? ) )
            // InternalRoom.g:5552:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? )
            {
            // InternalRoom.g:5552:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? )
            // InternalRoom.g:5552:3: otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )?
            {
            otherlv_0=(Token)match(input,81,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleStateAccess().getStateKeyword_0());
                
            // InternalRoom.g:5556:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:5557:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:5557:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:5558:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_112); 

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

            // InternalRoom.g:5574:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==35) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalRoom.g:5575:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:5575:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:5576:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_100);
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

            // InternalRoom.g:5592:3: (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==14) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // InternalRoom.g:5592:5: otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}'
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_113); 

                        	newLeafNode(otherlv_3, grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // InternalRoom.g:5596:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
                    loop123:
                    do {
                        int alt123=2;
                        int LA123_0 = input.LA(1);

                        if ( (LA123_0==109) ) {
                            alt123=1;
                        }


                        switch (alt123) {
                    	case 1 :
                    	    // InternalRoom.g:5597:1: (lv_annotations_4_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:5597:1: (lv_annotations_4_0= ruleAnnotation )
                    	    // InternalRoom.g:5598:3: lv_annotations_4_0= ruleAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSimpleStateAccess().getAnnotationsAnnotationParserRuleCall_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_113);
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
                    	    break loop123;
                        }
                    } while (true);

                    // InternalRoom.g:5614:3: (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )?
                    int alt124=2;
                    int LA124_0 = input.LA(1);

                    if ( (LA124_0==84) ) {
                        alt124=1;
                    }
                    switch (alt124) {
                        case 1 :
                            // InternalRoom.g:5614:5: otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) )
                            {
                            otherlv_5=(Token)match(input,84,FOLLOW_114); 

                                	newLeafNode(otherlv_5, grammarAccess.getSimpleStateAccess().getEntryKeyword_3_2_0());
                                
                            // InternalRoom.g:5618:1: ( (lv_entryCode_6_0= ruleDetailCode ) )
                            // InternalRoom.g:5619:1: (lv_entryCode_6_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5619:1: (lv_entryCode_6_0= ruleDetailCode )
                            // InternalRoom.g:5620:3: lv_entryCode_6_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getEntryCodeDetailCodeParserRuleCall_3_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_115);
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

                    // InternalRoom.g:5636:4: (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )?
                    int alt125=2;
                    int LA125_0 = input.LA(1);

                    if ( (LA125_0==85) ) {
                        alt125=1;
                    }
                    switch (alt125) {
                        case 1 :
                            // InternalRoom.g:5636:6: otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) )
                            {
                            otherlv_7=(Token)match(input,85,FOLLOW_116); 

                                	newLeafNode(otherlv_7, grammarAccess.getSimpleStateAccess().getExitKeyword_3_3_0());
                                
                            // InternalRoom.g:5640:1: ( (lv_exitCode_8_0= ruleDetailCode ) )
                            // InternalRoom.g:5641:1: (lv_exitCode_8_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5641:1: (lv_exitCode_8_0= ruleDetailCode )
                            // InternalRoom.g:5642:3: lv_exitCode_8_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getExitCodeDetailCodeParserRuleCall_3_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_117);
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

                    // InternalRoom.g:5658:4: (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )?
                    int alt126=2;
                    int LA126_0 = input.LA(1);

                    if ( (LA126_0==86) ) {
                        alt126=1;
                    }
                    switch (alt126) {
                        case 1 :
                            // InternalRoom.g:5658:6: otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) )
                            {
                            otherlv_9=(Token)match(input,86,FOLLOW_118); 

                                	newLeafNode(otherlv_9, grammarAccess.getSimpleStateAccess().getDoKeyword_3_4_0());
                                
                            // InternalRoom.g:5662:1: ( (lv_doCode_10_0= ruleDetailCode ) )
                            // InternalRoom.g:5663:1: (lv_doCode_10_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5663:1: (lv_doCode_10_0= ruleDetailCode )
                            // InternalRoom.g:5664:3: lv_doCode_10_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDoCodeDetailCodeParserRuleCall_3_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_119);
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

                    // InternalRoom.g:5680:4: (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )?
                    int alt127=2;
                    int LA127_0 = input.LA(1);

                    if ( (LA127_0==87) ) {
                        alt127=1;
                    }
                    switch (alt127) {
                        case 1 :
                            // InternalRoom.g:5680:6: otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) )
                            {
                            otherlv_11=(Token)match(input,87,FOLLOW_5); 

                                	newLeafNode(otherlv_11, grammarAccess.getSimpleStateAccess().getSubgraphKeyword_3_5_0());
                                
                            // InternalRoom.g:5684:1: ( (lv_subgraph_12_0= ruleStateGraph ) )
                            // InternalRoom.g:5685:1: (lv_subgraph_12_0= ruleStateGraph )
                            {
                            // InternalRoom.g:5685:1: (lv_subgraph_12_0= ruleStateGraph )
                            // InternalRoom.g:5686:3: lv_subgraph_12_0= ruleStateGraph
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
    // InternalRoom.g:5714:1: entryRuleRefinedState returns [EObject current=null] : iv_ruleRefinedState= ruleRefinedState EOF ;
    public final EObject entryRuleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedState = null;


        try {
            // InternalRoom.g:5715:2: (iv_ruleRefinedState= ruleRefinedState EOF )
            // InternalRoom.g:5716:2: iv_ruleRefinedState= ruleRefinedState EOF
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
    // InternalRoom.g:5723:1: ruleRefinedState returns [EObject current=null] : (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' ) ;
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
            // InternalRoom.g:5726:28: ( (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' ) )
            // InternalRoom.g:5727:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )
            {
            // InternalRoom.g:5727:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )
            // InternalRoom.g:5727:3: otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,88,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedStateAccess().getRefinedStateKeyword_0());
                
            // InternalRoom.g:5731:1: ( ( ruleFQN ) )
            // InternalRoom.g:5732:1: ( ruleFQN )
            {
            // InternalRoom.g:5732:1: ( ruleFQN )
            // InternalRoom.g:5733:3: ruleFQN
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

            // InternalRoom.g:5746:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==35) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // InternalRoom.g:5747:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:5747:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:5748:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_113); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedStateAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:5768:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop130:
            do {
                int alt130=2;
                int LA130_0 = input.LA(1);

                if ( (LA130_0==109) ) {
                    alt130=1;
                }


                switch (alt130) {
            	case 1 :
            	    // InternalRoom.g:5769:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:5769:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:5770:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_113);
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
            	    break loop130;
                }
            } while (true);

            // InternalRoom.g:5786:3: (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )?
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==84) ) {
                alt131=1;
            }
            switch (alt131) {
                case 1 :
                    // InternalRoom.g:5786:5: otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) )
                    {
                    otherlv_5=(Token)match(input,84,FOLLOW_114); 

                        	newLeafNode(otherlv_5, grammarAccess.getRefinedStateAccess().getEntryKeyword_5_0());
                        
                    // InternalRoom.g:5790:1: ( (lv_entryCode_6_0= ruleDetailCode ) )
                    // InternalRoom.g:5791:1: (lv_entryCode_6_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5791:1: (lv_entryCode_6_0= ruleDetailCode )
                    // InternalRoom.g:5792:3: lv_entryCode_6_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getEntryCodeDetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_115);
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

            // InternalRoom.g:5808:4: (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )?
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==85) ) {
                alt132=1;
            }
            switch (alt132) {
                case 1 :
                    // InternalRoom.g:5808:6: otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,85,FOLLOW_116); 

                        	newLeafNode(otherlv_7, grammarAccess.getRefinedStateAccess().getExitKeyword_6_0());
                        
                    // InternalRoom.g:5812:1: ( (lv_exitCode_8_0= ruleDetailCode ) )
                    // InternalRoom.g:5813:1: (lv_exitCode_8_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5813:1: (lv_exitCode_8_0= ruleDetailCode )
                    // InternalRoom.g:5814:3: lv_exitCode_8_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getExitCodeDetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_117);
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

            // InternalRoom.g:5830:4: (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )?
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==86) ) {
                alt133=1;
            }
            switch (alt133) {
                case 1 :
                    // InternalRoom.g:5830:6: otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,86,FOLLOW_118); 

                        	newLeafNode(otherlv_9, grammarAccess.getRefinedStateAccess().getDoKeyword_7_0());
                        
                    // InternalRoom.g:5834:1: ( (lv_doCode_10_0= ruleDetailCode ) )
                    // InternalRoom.g:5835:1: (lv_doCode_10_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5835:1: (lv_doCode_10_0= ruleDetailCode )
                    // InternalRoom.g:5836:3: lv_doCode_10_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getDoCodeDetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_119);
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

            // InternalRoom.g:5852:4: (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==87) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // InternalRoom.g:5852:6: otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) )
                    {
                    otherlv_11=(Token)match(input,87,FOLLOW_5); 

                        	newLeafNode(otherlv_11, grammarAccess.getRefinedStateAccess().getSubgraphKeyword_8_0());
                        
                    // InternalRoom.g:5856:1: ( (lv_subgraph_12_0= ruleStateGraph ) )
                    // InternalRoom.g:5857:1: (lv_subgraph_12_0= ruleStateGraph )
                    {
                    // InternalRoom.g:5857:1: (lv_subgraph_12_0= ruleStateGraph )
                    // InternalRoom.g:5858:3: lv_subgraph_12_0= ruleStateGraph
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
    // InternalRoom.g:5886:1: entryRuleDetailCode returns [EObject current=null] : iv_ruleDetailCode= ruleDetailCode EOF ;
    public final EObject entryRuleDetailCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailCode = null;


        try {
            // InternalRoom.g:5887:2: (iv_ruleDetailCode= ruleDetailCode EOF )
            // InternalRoom.g:5888:2: iv_ruleDetailCode= ruleDetailCode EOF
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
    // InternalRoom.g:5895:1: ruleDetailCode returns [EObject current=null] : ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) ) ;
    public final EObject ruleDetailCode() throws RecognitionException {
        EObject current = null;

        Token lv_lines_1_0=null;
        Token lv_used_2_0=null;
        Token lv_lines_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5898:28: ( ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) ) )
            // InternalRoom.g:5899:1: ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) )
            {
            // InternalRoom.g:5899:1: ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) )
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==EOF||LA137_0==RULE_CC_STRING||LA137_0==15||(LA137_0>=32 && LA137_0<=34)||(LA137_0>=37 && LA137_0<=38)||(LA137_0>=41 && LA137_0<=42)||(LA137_0>=44 && LA137_0<=46)||LA137_0==48||LA137_0==54||(LA137_0>=60 && LA137_0<=64)||(LA137_0>=68 && LA137_0<=69)||LA137_0==71||LA137_0==75||LA137_0==78||LA137_0==83||(LA137_0>=85 && LA137_0<=87)||LA137_0==95||(LA137_0>=105 && LA137_0<=106)||LA137_0==112||LA137_0==128) ) {
                alt137=1;
            }
            else if ( (LA137_0==14) ) {
                alt137=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }
            switch (alt137) {
                case 1 :
                    // InternalRoom.g:5899:2: ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? )
                    {
                    // InternalRoom.g:5899:2: ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? )
                    // InternalRoom.g:5899:3: () ( (lv_lines_1_0= RULE_CC_STRING ) )?
                    {
                    // InternalRoom.g:5899:3: ()
                    // InternalRoom.g:5900:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getDetailCodeAccess().getDetailCodeAction_0_0(),
                                current);
                        

                    }

                    // InternalRoom.g:5905:2: ( (lv_lines_1_0= RULE_CC_STRING ) )?
                    int alt135=2;
                    int LA135_0 = input.LA(1);

                    if ( (LA135_0==RULE_CC_STRING) ) {
                        alt135=1;
                    }
                    switch (alt135) {
                        case 1 :
                            // InternalRoom.g:5906:1: (lv_lines_1_0= RULE_CC_STRING )
                            {
                            // InternalRoom.g:5906:1: (lv_lines_1_0= RULE_CC_STRING )
                            // InternalRoom.g:5907:3: lv_lines_1_0= RULE_CC_STRING
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
                    // InternalRoom.g:5924:6: ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' )
                    {
                    // InternalRoom.g:5924:6: ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' )
                    // InternalRoom.g:5924:7: ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}'
                    {
                    // InternalRoom.g:5924:7: ( (lv_used_2_0= '{' ) )
                    // InternalRoom.g:5925:1: (lv_used_2_0= '{' )
                    {
                    // InternalRoom.g:5925:1: (lv_used_2_0= '{' )
                    // InternalRoom.g:5926:3: lv_used_2_0= '{'
                    {
                    lv_used_2_0=(Token)match(input,14,FOLLOW_120); 

                            newLeafNode(lv_used_2_0, grammarAccess.getDetailCodeAccess().getUsedLeftCurlyBracketKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDetailCodeRule());
                    	        }
                           		setWithLastConsumed(current, "used", true, "{");
                    	    

                    }


                    }

                    // InternalRoom.g:5939:2: ( (lv_lines_3_0= RULE_STRING ) )*
                    loop136:
                    do {
                        int alt136=2;
                        int LA136_0 = input.LA(1);

                        if ( (LA136_0==RULE_STRING) ) {
                            alt136=1;
                        }


                        switch (alt136) {
                    	case 1 :
                    	    // InternalRoom.g:5940:1: (lv_lines_3_0= RULE_STRING )
                    	    {
                    	    // InternalRoom.g:5940:1: (lv_lines_3_0= RULE_STRING )
                    	    // InternalRoom.g:5941:3: lv_lines_3_0= RULE_STRING
                    	    {
                    	    lv_lines_3_0=(Token)match(input,RULE_STRING,FOLLOW_120); 

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
                    	    break loop136;
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
    // InternalRoom.g:5969:1: entryRuleTrPoint returns [EObject current=null] : iv_ruleTrPoint= ruleTrPoint EOF ;
    public final EObject entryRuleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPoint = null;


        try {
            // InternalRoom.g:5970:2: (iv_ruleTrPoint= ruleTrPoint EOF )
            // InternalRoom.g:5971:2: iv_ruleTrPoint= ruleTrPoint EOF
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
    // InternalRoom.g:5978:1: ruleTrPoint returns [EObject current=null] : (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) ;
    public final EObject ruleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionPoint_0 = null;

        EObject this_EntryPoint_1 = null;

        EObject this_ExitPoint_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:5981:28: ( (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) )
            // InternalRoom.g:5982:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            {
            // InternalRoom.g:5982:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            int alt138=3;
            switch ( input.LA(1) ) {
            case 89:
            case 90:
                {
                alt138=1;
                }
                break;
            case 91:
                {
                alt138=2;
                }
                break;
            case 92:
                {
                alt138=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 138, 0, input);

                throw nvae;
            }

            switch (alt138) {
                case 1 :
                    // InternalRoom.g:5983:5: this_TransitionPoint_0= ruleTransitionPoint
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
                    // InternalRoom.g:5993:5: this_EntryPoint_1= ruleEntryPoint
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
                    // InternalRoom.g:6003:5: this_ExitPoint_2= ruleExitPoint
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
    // InternalRoom.g:6019:1: entryRuleTransitionPoint returns [EObject current=null] : iv_ruleTransitionPoint= ruleTransitionPoint EOF ;
    public final EObject entryRuleTransitionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionPoint = null;


        try {
            // InternalRoom.g:6020:2: (iv_ruleTransitionPoint= ruleTransitionPoint EOF )
            // InternalRoom.g:6021:2: iv_ruleTransitionPoint= ruleTransitionPoint EOF
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
    // InternalRoom.g:6028:1: ruleTransitionPoint returns [EObject current=null] : ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTransitionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_handler_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:6031:28: ( ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalRoom.g:6032:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalRoom.g:6032:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalRoom.g:6032:2: ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalRoom.g:6032:2: ( (lv_handler_0_0= 'handler' ) )?
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==89) ) {
                alt139=1;
            }
            switch (alt139) {
                case 1 :
                    // InternalRoom.g:6033:1: (lv_handler_0_0= 'handler' )
                    {
                    // InternalRoom.g:6033:1: (lv_handler_0_0= 'handler' )
                    // InternalRoom.g:6034:3: lv_handler_0_0= 'handler'
                    {
                    lv_handler_0_0=(Token)match(input,89,FOLLOW_121); 

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
                
            // InternalRoom.g:6051:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:6052:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:6052:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:6053:3: lv_name_2_0= RULE_ID
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
    // InternalRoom.g:6077:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // InternalRoom.g:6078:2: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // InternalRoom.g:6079:2: iv_ruleEntryPoint= ruleEntryPoint EOF
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
    // InternalRoom.g:6086:1: ruleEntryPoint returns [EObject current=null] : (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:6089:28: ( (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:6090:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:6090:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:6090:3: otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,91,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getEntryPointAccess().getEntryPointKeyword_0());
                
            // InternalRoom.g:6094:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:6095:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:6095:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:6096:3: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:6120:1: entryRuleExitPoint returns [EObject current=null] : iv_ruleExitPoint= ruleExitPoint EOF ;
    public final EObject entryRuleExitPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPoint = null;


        try {
            // InternalRoom.g:6121:2: (iv_ruleExitPoint= ruleExitPoint EOF )
            // InternalRoom.g:6122:2: iv_ruleExitPoint= ruleExitPoint EOF
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
    // InternalRoom.g:6129:1: ruleExitPoint returns [EObject current=null] : (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:6132:28: ( (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:6133:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:6133:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:6133:3: otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,92,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getExitPointAccess().getExitPointKeyword_0());
                
            // InternalRoom.g:6137:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:6138:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:6138:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:6139:3: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:6163:1: entryRuleChoicePoint returns [EObject current=null] : iv_ruleChoicePoint= ruleChoicePoint EOF ;
    public final EObject entryRuleChoicePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicePoint = null;


        try {
            // InternalRoom.g:6164:2: (iv_ruleChoicePoint= ruleChoicePoint EOF )
            // InternalRoom.g:6165:2: iv_ruleChoicePoint= ruleChoicePoint EOF
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
    // InternalRoom.g:6172:1: ruleChoicePoint returns [EObject current=null] : (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) ;
    public final EObject ruleChoicePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6175:28: ( (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:6176:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:6176:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            // InternalRoom.g:6176:3: otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,93,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicePointAccess().getChoicePointKeyword_0());
                
            // InternalRoom.g:6180:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:6181:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:6181:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:6182:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:6198:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==35) ) {
                alt140=1;
            }
            switch (alt140) {
                case 1 :
                    // InternalRoom.g:6199:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6199:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:6200:3: lv_docu_2_0= ruleDocumentation
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
    // InternalRoom.g:6224:1: entryRuleTransitionBase returns [EObject current=null] : iv_ruleTransitionBase= ruleTransitionBase EOF ;
    public final EObject entryRuleTransitionBase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionBase = null;


        try {
            // InternalRoom.g:6225:2: (iv_ruleTransitionBase= ruleTransitionBase EOF )
            // InternalRoom.g:6226:2: iv_ruleTransitionBase= ruleTransitionBase EOF
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
    // InternalRoom.g:6233:1: ruleTransitionBase returns [EObject current=null] : (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition ) ;
    public final EObject ruleTransitionBase() throws RecognitionException {
        EObject current = null;

        EObject this_Transition_0 = null;

        EObject this_RefinedTransition_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6236:28: ( (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition ) )
            // InternalRoom.g:6237:1: (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition )
            {
            // InternalRoom.g:6237:1: (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition )
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==82) ) {
                alt141=1;
            }
            else if ( (LA141_0==100) ) {
                alt141=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;
            }
            switch (alt141) {
                case 1 :
                    // InternalRoom.g:6238:5: this_Transition_0= ruleTransition
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
                    // InternalRoom.g:6248:5: this_RefinedTransition_1= ruleRefinedTransition
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
    // InternalRoom.g:6264:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalRoom.g:6265:2: (iv_ruleTransition= ruleTransition EOF )
            // InternalRoom.g:6266:2: iv_ruleTransition= ruleTransition EOF
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
    // InternalRoom.g:6273:1: ruleTransition returns [EObject current=null] : (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_InitialTransition_0 = null;

        EObject this_NonInitialTransition_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6276:28: ( (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) )
            // InternalRoom.g:6277:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            {
            // InternalRoom.g:6277:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==82) ) {
                int LA142_1 = input.LA(2);

                if ( (LA142_1==RULE_ID) ) {
                    int LA142_2 = input.LA(3);

                    if ( (LA142_2==16) ) {
                        int LA142_3 = input.LA(4);

                        if ( (LA142_3==RULE_ID||(LA142_3>=101 && LA142_3<=102)) ) {
                            alt142=2;
                        }
                        else if ( (LA142_3==94) ) {
                            alt142=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 142, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 142, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA142_1==16) ) {
                    int LA142_3 = input.LA(3);

                    if ( (LA142_3==RULE_ID||(LA142_3>=101 && LA142_3<=102)) ) {
                        alt142=2;
                    }
                    else if ( (LA142_3==94) ) {
                        alt142=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 142, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 142, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 142, 0, input);

                throw nvae;
            }
            switch (alt142) {
                case 1 :
                    // InternalRoom.g:6278:5: this_InitialTransition_0= ruleInitialTransition
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
                    // InternalRoom.g:6288:5: this_NonInitialTransition_1= ruleNonInitialTransition
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
    // InternalRoom.g:6304:1: entryRuleNonInitialTransition returns [EObject current=null] : iv_ruleNonInitialTransition= ruleNonInitialTransition EOF ;
    public final EObject entryRuleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonInitialTransition = null;


        try {
            // InternalRoom.g:6305:2: (iv_ruleNonInitialTransition= ruleNonInitialTransition EOF )
            // InternalRoom.g:6306:2: iv_ruleNonInitialTransition= ruleNonInitialTransition EOF
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
    // InternalRoom.g:6313:1: ruleNonInitialTransition returns [EObject current=null] : (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) ;
    public final EObject ruleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionChainStartTransition_0 = null;

        EObject this_ContinuationTransition_1 = null;

        EObject this_CPBranchTransition_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6316:28: ( (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) )
            // InternalRoom.g:6317:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            {
            // InternalRoom.g:6317:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            int alt143=3;
            alt143 = dfa143.predict(input);
            switch (alt143) {
                case 1 :
                    // InternalRoom.g:6318:5: this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition
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
                    // InternalRoom.g:6328:5: this_ContinuationTransition_1= ruleContinuationTransition
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
                    // InternalRoom.g:6338:5: this_CPBranchTransition_2= ruleCPBranchTransition
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
    // InternalRoom.g:6354:1: entryRuleTransitionChainStartTransition returns [EObject current=null] : iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF ;
    public final EObject entryRuleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionChainStartTransition = null;


        try {
            // InternalRoom.g:6355:2: (iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF )
            // InternalRoom.g:6356:2: iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF
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
    // InternalRoom.g:6363:1: ruleTransitionChainStartTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) ;
    public final EObject ruleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_GuardedTransition_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6366:28: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) )
            // InternalRoom.g:6367:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            {
            // InternalRoom.g:6367:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            int alt144=2;
            alt144 = dfa144.predict(input);
            switch (alt144) {
                case 1 :
                    // InternalRoom.g:6368:5: this_TriggeredTransition_0= ruleTriggeredTransition
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
                    // InternalRoom.g:6378:5: this_GuardedTransition_1= ruleGuardedTransition
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
    // InternalRoom.g:6394:1: entryRuleInitialTransition returns [EObject current=null] : iv_ruleInitialTransition= ruleInitialTransition EOF ;
    public final EObject entryRuleInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialTransition = null;


        try {
            // InternalRoom.g:6395:2: (iv_ruleInitialTransition= ruleInitialTransition EOF )
            // InternalRoom.g:6396:2: iv_ruleInitialTransition= ruleInitialTransition EOF
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
    // InternalRoom.g:6403:1: ruleInitialTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) ;
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
            // InternalRoom.g:6406:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) )
            // InternalRoom.g:6407:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            {
            // InternalRoom.g:6407:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            // InternalRoom.g:6407:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            {
            otherlv_0=(Token)match(input,82,FOLLOW_122); 

                	newLeafNode(otherlv_0, grammarAccess.getInitialTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6411:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==RULE_ID) ) {
                alt145=1;
            }
            switch (alt145) {
                case 1 :
                    // InternalRoom.g:6412:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6412:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6413:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_123); 

                	newLeafNode(otherlv_2, grammarAccess.getInitialTransitionAccess().getColonKeyword_2());
                
            otherlv_3=(Token)match(input,94,FOLLOW_14); 

                	newLeafNode(otherlv_3, grammarAccess.getInitialTransitionAccess().getInitialKeyword_3());
                
            otherlv_4=(Token)match(input,20,FOLLOW_124); 

                	newLeafNode(otherlv_4, grammarAccess.getInitialTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6441:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6442:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6442:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6443:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_112);
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

            // InternalRoom.g:6459:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==35) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // InternalRoom.g:6460:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6460:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6461:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_100);
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

            // InternalRoom.g:6477:3: (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            int alt149=2;
            int LA149_0 = input.LA(1);

            if ( (LA149_0==14) ) {
                alt149=1;
            }
            switch (alt149) {
                case 1 :
                    // InternalRoom.g:6477:5: otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_125); 

                        	newLeafNode(otherlv_7, grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // InternalRoom.g:6481:1: ( (lv_annotations_8_0= ruleAnnotation ) )*
                    loop147:
                    do {
                        int alt147=2;
                        int LA147_0 = input.LA(1);

                        if ( (LA147_0==109) ) {
                            alt147=1;
                        }


                        switch (alt147) {
                    	case 1 :
                    	    // InternalRoom.g:6482:1: (lv_annotations_8_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:6482:1: (lv_annotations_8_0= ruleAnnotation )
                    	    // InternalRoom.g:6483:3: lv_annotations_8_0= ruleAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getAnnotationsAnnotationParserRuleCall_7_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_125);
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
                    	    break loop147;
                        }
                    } while (true);

                    // InternalRoom.g:6499:3: (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )?
                    int alt148=2;
                    int LA148_0 = input.LA(1);

                    if ( (LA148_0==95) ) {
                        alt148=1;
                    }
                    switch (alt148) {
                        case 1 :
                            // InternalRoom.g:6499:5: otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) )
                            {
                            otherlv_9=(Token)match(input,95,FOLLOW_126); 

                                	newLeafNode(otherlv_9, grammarAccess.getInitialTransitionAccess().getActionKeyword_7_2_0());
                                
                            // InternalRoom.g:6503:1: ( (lv_action_10_0= ruleDetailCode ) )
                            // InternalRoom.g:6504:1: (lv_action_10_0= ruleDetailCode )
                            {
                            // InternalRoom.g:6504:1: (lv_action_10_0= ruleDetailCode )
                            // InternalRoom.g:6505:3: lv_action_10_0= ruleDetailCode
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
    // InternalRoom.g:6533:1: entryRuleContinuationTransition returns [EObject current=null] : iv_ruleContinuationTransition= ruleContinuationTransition EOF ;
    public final EObject entryRuleContinuationTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuationTransition = null;


        try {
            // InternalRoom.g:6534:2: (iv_ruleContinuationTransition= ruleContinuationTransition EOF )
            // InternalRoom.g:6535:2: iv_ruleContinuationTransition= ruleContinuationTransition EOF
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
    // InternalRoom.g:6542:1: ruleContinuationTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) ;
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
            // InternalRoom.g:6545:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) )
            // InternalRoom.g:6546:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            {
            // InternalRoom.g:6546:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            // InternalRoom.g:6546:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            {
            otherlv_0=(Token)match(input,82,FOLLOW_122); 

                	newLeafNode(otherlv_0, grammarAccess.getContinuationTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6550:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==RULE_ID) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    // InternalRoom.g:6551:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6551:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6552:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_124); 

                	newLeafNode(otherlv_2, grammarAccess.getContinuationTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6572:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6573:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6573:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6574:3: lv_from_3_0= ruleTransitionTerminal
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

            otherlv_4=(Token)match(input,20,FOLLOW_124); 

                	newLeafNode(otherlv_4, grammarAccess.getContinuationTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6594:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6595:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6595:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6596:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_112);
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

            // InternalRoom.g:6612:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==35) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    // InternalRoom.g:6613:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6613:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6614:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_100);
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

            // InternalRoom.g:6630:3: (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            int alt154=2;
            int LA154_0 = input.LA(1);

            if ( (LA154_0==14) ) {
                alt154=1;
            }
            switch (alt154) {
                case 1 :
                    // InternalRoom.g:6630:5: otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_125); 

                        	newLeafNode(otherlv_7, grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // InternalRoom.g:6634:1: ( (lv_annotations_8_0= ruleAnnotation ) )*
                    loop152:
                    do {
                        int alt152=2;
                        int LA152_0 = input.LA(1);

                        if ( (LA152_0==109) ) {
                            alt152=1;
                        }


                        switch (alt152) {
                    	case 1 :
                    	    // InternalRoom.g:6635:1: (lv_annotations_8_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:6635:1: (lv_annotations_8_0= ruleAnnotation )
                    	    // InternalRoom.g:6636:3: lv_annotations_8_0= ruleAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getAnnotationsAnnotationParserRuleCall_7_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_125);
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
                    	    break loop152;
                        }
                    } while (true);

                    // InternalRoom.g:6652:3: (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )?
                    int alt153=2;
                    int LA153_0 = input.LA(1);

                    if ( (LA153_0==95) ) {
                        alt153=1;
                    }
                    switch (alt153) {
                        case 1 :
                            // InternalRoom.g:6652:5: otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) )
                            {
                            otherlv_9=(Token)match(input,95,FOLLOW_126); 

                                	newLeafNode(otherlv_9, grammarAccess.getContinuationTransitionAccess().getActionKeyword_7_2_0());
                                
                            // InternalRoom.g:6656:1: ( (lv_action_10_0= ruleDetailCode ) )
                            // InternalRoom.g:6657:1: (lv_action_10_0= ruleDetailCode )
                            {
                            // InternalRoom.g:6657:1: (lv_action_10_0= ruleDetailCode )
                            // InternalRoom.g:6658:3: lv_action_10_0= ruleDetailCode
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
    // InternalRoom.g:6686:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // InternalRoom.g:6687:2: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // InternalRoom.g:6688:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
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
    // InternalRoom.g:6695:1: ruleTriggeredTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' ) ;
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
            // InternalRoom.g:6698:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' ) )
            // InternalRoom.g:6699:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' )
            {
            // InternalRoom.g:6699:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' )
            // InternalRoom.g:6699:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_122); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggeredTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6703:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==RULE_ID) ) {
                alt155=1;
            }
            switch (alt155) {
                case 1 :
                    // InternalRoom.g:6704:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6704:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6705:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_124); 

                	newLeafNode(otherlv_2, grammarAccess.getTriggeredTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6725:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6726:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6726:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6727:3: lv_from_3_0= ruleTransitionTerminal
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

            otherlv_4=(Token)match(input,20,FOLLOW_124); 

                	newLeafNode(otherlv_4, grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6747:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6748:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6748:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6749:3: lv_to_5_0= ruleTransitionTerminal
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

            // InternalRoom.g:6765:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==35) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    // InternalRoom.g:6766:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6766:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6767:3: lv_docu_6_0= ruleDocumentation
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

            otherlv_7=(Token)match(input,14,FOLLOW_127); 

                	newLeafNode(otherlv_7, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,96,FOLLOW_5); 

                	newLeafNode(otherlv_8, grammarAccess.getTriggeredTransitionAccess().getTriggersKeyword_8());
                
            otherlv_9=(Token)match(input,14,FOLLOW_128); 

                	newLeafNode(otherlv_9, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_9());
                
            // InternalRoom.g:6795:1: ( (lv_annotations_10_0= ruleAnnotation ) )*
            loop157:
            do {
                int alt157=2;
                int LA157_0 = input.LA(1);

                if ( (LA157_0==109) ) {
                    alt157=1;
                }


                switch (alt157) {
            	case 1 :
            	    // InternalRoom.g:6796:1: (lv_annotations_10_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:6796:1: (lv_annotations_10_0= ruleAnnotation )
            	    // InternalRoom.g:6797:3: lv_annotations_10_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getAnnotationsAnnotationParserRuleCall_10_0()); 
            	    	    
            	    pushFollow(FOLLOW_128);
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
            	    break loop157;
                }
            } while (true);

            // InternalRoom.g:6813:3: ( (lv_triggers_11_0= ruleTrigger ) )
            // InternalRoom.g:6814:1: (lv_triggers_11_0= ruleTrigger )
            {
            // InternalRoom.g:6814:1: (lv_triggers_11_0= ruleTrigger )
            // InternalRoom.g:6815:3: lv_triggers_11_0= ruleTrigger
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_11_0()); 
            	    
            pushFollow(FOLLOW_129);
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

            // InternalRoom.g:6831:2: (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )*
            loop158:
            do {
                int alt158=2;
                int LA158_0 = input.LA(1);

                if ( (LA158_0==97) ) {
                    alt158=1;
                }


                switch (alt158) {
            	case 1 :
            	    // InternalRoom.g:6831:4: otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) )
            	    {
            	    otherlv_12=(Token)match(input,97,FOLLOW_128); 

            	        	newLeafNode(otherlv_12, grammarAccess.getTriggeredTransitionAccess().getOrKeyword_12_0());
            	        
            	    // InternalRoom.g:6835:1: ( (lv_triggers_13_0= ruleTrigger ) )
            	    // InternalRoom.g:6836:1: (lv_triggers_13_0= ruleTrigger )
            	    {
            	    // InternalRoom.g:6836:1: (lv_triggers_13_0= ruleTrigger )
            	    // InternalRoom.g:6837:3: lv_triggers_13_0= ruleTrigger
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_12_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_129);
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
            	    break loop158;
                }
            } while (true);

            otherlv_14=(Token)match(input,15,FOLLOW_130); 

                	newLeafNode(otherlv_14, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_13());
                
            // InternalRoom.g:6857:1: (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )?
            int alt159=2;
            int LA159_0 = input.LA(1);

            if ( (LA159_0==95) ) {
                alt159=1;
            }
            switch (alt159) {
                case 1 :
                    // InternalRoom.g:6857:3: otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) )
                    {
                    otherlv_15=(Token)match(input,95,FOLLOW_126); 

                        	newLeafNode(otherlv_15, grammarAccess.getTriggeredTransitionAccess().getActionKeyword_14_0());
                        
                    // InternalRoom.g:6861:1: ( (lv_action_16_0= ruleDetailCode ) )
                    // InternalRoom.g:6862:1: (lv_action_16_0= ruleDetailCode )
                    {
                    // InternalRoom.g:6862:1: (lv_action_16_0= ruleDetailCode )
                    // InternalRoom.g:6863:3: lv_action_16_0= ruleDetailCode
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
    // InternalRoom.g:6891:1: entryRuleGuardedTransition returns [EObject current=null] : iv_ruleGuardedTransition= ruleGuardedTransition EOF ;
    public final EObject entryRuleGuardedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardedTransition = null;


        try {
            // InternalRoom.g:6892:2: (iv_ruleGuardedTransition= ruleGuardedTransition EOF )
            // InternalRoom.g:6893:2: iv_ruleGuardedTransition= ruleGuardedTransition EOF
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
    // InternalRoom.g:6900:1: ruleGuardedTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) ;
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
            // InternalRoom.g:6903:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) )
            // InternalRoom.g:6904:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            {
            // InternalRoom.g:6904:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            // InternalRoom.g:6904:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_122); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardedTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6908:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( (LA160_0==RULE_ID) ) {
                alt160=1;
            }
            switch (alt160) {
                case 1 :
                    // InternalRoom.g:6909:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6909:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6910:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_124); 

                	newLeafNode(otherlv_2, grammarAccess.getGuardedTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6930:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6931:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6931:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6932:3: lv_from_3_0= ruleTransitionTerminal
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

            otherlv_4=(Token)match(input,20,FOLLOW_124); 

                	newLeafNode(otherlv_4, grammarAccess.getGuardedTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6952:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6953:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6953:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6954:3: lv_to_5_0= ruleTransitionTerminal
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

            // InternalRoom.g:6970:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt161=2;
            int LA161_0 = input.LA(1);

            if ( (LA161_0==35) ) {
                alt161=1;
            }
            switch (alt161) {
                case 1 :
                    // InternalRoom.g:6971:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6971:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6972:3: lv_docu_6_0= ruleDocumentation
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

            otherlv_7=(Token)match(input,14,FOLLOW_131); 

                	newLeafNode(otherlv_7, grammarAccess.getGuardedTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            // InternalRoom.g:6992:1: ( (lv_annotations_8_0= ruleAnnotation ) )*
            loop162:
            do {
                int alt162=2;
                int LA162_0 = input.LA(1);

                if ( (LA162_0==109) ) {
                    alt162=1;
                }


                switch (alt162) {
            	case 1 :
            	    // InternalRoom.g:6993:1: (lv_annotations_8_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:6993:1: (lv_annotations_8_0= ruleAnnotation )
            	    // InternalRoom.g:6994:3: lv_annotations_8_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getAnnotationsAnnotationParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_131);
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
            	    break loop162;
                }
            } while (true);

            otherlv_9=(Token)match(input,98,FOLLOW_132); 

                	newLeafNode(otherlv_9, grammarAccess.getGuardedTransitionAccess().getGuardKeyword_9());
                
            // InternalRoom.g:7014:1: ( (lv_guard_10_0= ruleDetailCode ) )
            // InternalRoom.g:7015:1: (lv_guard_10_0= ruleDetailCode )
            {
            // InternalRoom.g:7015:1: (lv_guard_10_0= ruleDetailCode )
            // InternalRoom.g:7016:3: lv_guard_10_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getGuardDetailCodeParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_130);
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

            // InternalRoom.g:7032:2: (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )?
            int alt163=2;
            int LA163_0 = input.LA(1);

            if ( (LA163_0==95) ) {
                alt163=1;
            }
            switch (alt163) {
                case 1 :
                    // InternalRoom.g:7032:4: otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,95,FOLLOW_126); 

                        	newLeafNode(otherlv_11, grammarAccess.getGuardedTransitionAccess().getActionKeyword_11_0());
                        
                    // InternalRoom.g:7036:1: ( (lv_action_12_0= ruleDetailCode ) )
                    // InternalRoom.g:7037:1: (lv_action_12_0= ruleDetailCode )
                    {
                    // InternalRoom.g:7037:1: (lv_action_12_0= ruleDetailCode )
                    // InternalRoom.g:7038:3: lv_action_12_0= ruleDetailCode
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
    // InternalRoom.g:7066:1: entryRuleCPBranchTransition returns [EObject current=null] : iv_ruleCPBranchTransition= ruleCPBranchTransition EOF ;
    public final EObject entryRuleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCPBranchTransition = null;


        try {
            // InternalRoom.g:7067:2: (iv_ruleCPBranchTransition= ruleCPBranchTransition EOF )
            // InternalRoom.g:7068:2: iv_ruleCPBranchTransition= ruleCPBranchTransition EOF
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
    // InternalRoom.g:7075:1: ruleCPBranchTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) ;
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
            // InternalRoom.g:7078:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) )
            // InternalRoom.g:7079:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            {
            // InternalRoom.g:7079:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            // InternalRoom.g:7079:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_122); 

                	newLeafNode(otherlv_0, grammarAccess.getCPBranchTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:7083:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt164=2;
            int LA164_0 = input.LA(1);

            if ( (LA164_0==RULE_ID) ) {
                alt164=1;
            }
            switch (alt164) {
                case 1 :
                    // InternalRoom.g:7084:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:7084:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:7085:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_124); 

                	newLeafNode(otherlv_2, grammarAccess.getCPBranchTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:7105:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:7106:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:7106:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:7107:3: lv_from_3_0= ruleTransitionTerminal
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

            otherlv_4=(Token)match(input,20,FOLLOW_124); 

                	newLeafNode(otherlv_4, grammarAccess.getCPBranchTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:7127:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:7128:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:7128:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:7129:3: lv_to_5_0= ruleTransitionTerminal
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

            // InternalRoom.g:7145:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt165=2;
            int LA165_0 = input.LA(1);

            if ( (LA165_0==35) ) {
                alt165=1;
            }
            switch (alt165) {
                case 1 :
                    // InternalRoom.g:7146:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:7146:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:7147:3: lv_docu_6_0= ruleDocumentation
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

            otherlv_7=(Token)match(input,14,FOLLOW_133); 

                	newLeafNode(otherlv_7, grammarAccess.getCPBranchTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            // InternalRoom.g:7167:1: ( (lv_annotations_8_0= ruleAnnotation ) )*
            loop166:
            do {
                int alt166=2;
                int LA166_0 = input.LA(1);

                if ( (LA166_0==109) ) {
                    alt166=1;
                }


                switch (alt166) {
            	case 1 :
            	    // InternalRoom.g:7168:1: (lv_annotations_8_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:7168:1: (lv_annotations_8_0= ruleAnnotation )
            	    // InternalRoom.g:7169:3: lv_annotations_8_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getAnnotationsAnnotationParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_133);
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
            	    break loop166;
                }
            } while (true);

            otherlv_9=(Token)match(input,99,FOLLOW_132); 

                	newLeafNode(otherlv_9, grammarAccess.getCPBranchTransitionAccess().getCondKeyword_9());
                
            // InternalRoom.g:7189:1: ( (lv_condition_10_0= ruleDetailCode ) )
            // InternalRoom.g:7190:1: (lv_condition_10_0= ruleDetailCode )
            {
            // InternalRoom.g:7190:1: (lv_condition_10_0= ruleDetailCode )
            // InternalRoom.g:7191:3: lv_condition_10_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getConditionDetailCodeParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_130);
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

            // InternalRoom.g:7207:2: (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )?
            int alt167=2;
            int LA167_0 = input.LA(1);

            if ( (LA167_0==95) ) {
                alt167=1;
            }
            switch (alt167) {
                case 1 :
                    // InternalRoom.g:7207:4: otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,95,FOLLOW_126); 

                        	newLeafNode(otherlv_11, grammarAccess.getCPBranchTransitionAccess().getActionKeyword_11_0());
                        
                    // InternalRoom.g:7211:1: ( (lv_action_12_0= ruleDetailCode ) )
                    // InternalRoom.g:7212:1: (lv_action_12_0= ruleDetailCode )
                    {
                    // InternalRoom.g:7212:1: (lv_action_12_0= ruleDetailCode )
                    // InternalRoom.g:7213:3: lv_action_12_0= ruleDetailCode
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
    // InternalRoom.g:7241:1: entryRuleRefinedTransition returns [EObject current=null] : iv_ruleRefinedTransition= ruleRefinedTransition EOF ;
    public final EObject entryRuleRefinedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedTransition = null;


        try {
            // InternalRoom.g:7242:2: (iv_ruleRefinedTransition= ruleRefinedTransition EOF )
            // InternalRoom.g:7243:2: iv_ruleRefinedTransition= ruleRefinedTransition EOF
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
    // InternalRoom.g:7250:1: ruleRefinedTransition returns [EObject current=null] : (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' ) ;
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
            // InternalRoom.g:7253:28: ( (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' ) )
            // InternalRoom.g:7254:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' )
            {
            // InternalRoom.g:7254:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' )
            // InternalRoom.g:7254:3: otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,100,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedTransitionAccess().getRefinedTransitionKeyword_0());
                
            // InternalRoom.g:7258:1: ( ( ruleFQN ) )
            // InternalRoom.g:7259:1: ( ruleFQN )
            {
            // InternalRoom.g:7259:1: ( ruleFQN )
            // InternalRoom.g:7260:3: ruleFQN
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

            // InternalRoom.g:7273:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt168=2;
            int LA168_0 = input.LA(1);

            if ( (LA168_0==35) ) {
                alt168=1;
            }
            switch (alt168) {
                case 1 :
                    // InternalRoom.g:7274:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:7274:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:7275:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_134); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedTransitionAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:7295:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop169:
            do {
                int alt169=2;
                int LA169_0 = input.LA(1);

                if ( (LA169_0==109) ) {
                    alt169=1;
                }


                switch (alt169) {
            	case 1 :
            	    // InternalRoom.g:7296:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:7296:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:7297:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_134);
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
            	    break loop169;
                }
            } while (true);

            otherlv_5=(Token)match(input,95,FOLLOW_126); 

                	newLeafNode(otherlv_5, grammarAccess.getRefinedTransitionAccess().getActionKeyword_5());
                
            // InternalRoom.g:7317:1: ( (lv_action_6_0= ruleDetailCode ) )
            // InternalRoom.g:7318:1: (lv_action_6_0= ruleDetailCode )
            {
            // InternalRoom.g:7318:1: (lv_action_6_0= ruleDetailCode )
            // InternalRoom.g:7319:3: lv_action_6_0= ruleDetailCode
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
    // InternalRoom.g:7347:1: entryRuleTransitionTerminal returns [EObject current=null] : iv_ruleTransitionTerminal= ruleTransitionTerminal EOF ;
    public final EObject entryRuleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionTerminal = null;


        try {
            // InternalRoom.g:7348:2: (iv_ruleTransitionTerminal= ruleTransitionTerminal EOF )
            // InternalRoom.g:7349:2: iv_ruleTransitionTerminal= ruleTransitionTerminal EOF
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
    // InternalRoom.g:7356:1: ruleTransitionTerminal returns [EObject current=null] : (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) ;
    public final EObject ruleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_StateTerminal_0 = null;

        EObject this_TrPointTerminal_1 = null;

        EObject this_SubStateTrPointTerminal_2 = null;

        EObject this_ChoicepointTerminal_3 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7359:28: ( (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) )
            // InternalRoom.g:7360:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            {
            // InternalRoom.g:7360:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            int alt170=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA170_1 = input.LA(2);

                if ( (LA170_1==EOF||(LA170_1>=14 && LA170_1<=15)||LA170_1==20||LA170_1==35||(LA170_1>=81 && LA170_1<=82)||(LA170_1>=88 && LA170_1<=93)||LA170_1==100) ) {
                    alt170=1;
                }
                else if ( (LA170_1==25) ) {
                    alt170=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 170, 1, input);

                    throw nvae;
                }
                }
                break;
            case 101:
                {
                alt170=2;
                }
                break;
            case 102:
                {
                alt170=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 170, 0, input);

                throw nvae;
            }

            switch (alt170) {
                case 1 :
                    // InternalRoom.g:7361:5: this_StateTerminal_0= ruleStateTerminal
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
                    // InternalRoom.g:7371:5: this_TrPointTerminal_1= ruleTrPointTerminal
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
                    // InternalRoom.g:7381:5: this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal
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
                    // InternalRoom.g:7391:5: this_ChoicepointTerminal_3= ruleChoicepointTerminal
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
    // InternalRoom.g:7407:1: entryRuleStateTerminal returns [EObject current=null] : iv_ruleStateTerminal= ruleStateTerminal EOF ;
    public final EObject entryRuleStateTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateTerminal = null;


        try {
            // InternalRoom.g:7408:2: (iv_ruleStateTerminal= ruleStateTerminal EOF )
            // InternalRoom.g:7409:2: iv_ruleStateTerminal= ruleStateTerminal EOF
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
    // InternalRoom.g:7416:1: ruleStateTerminal returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleStateTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7419:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalRoom.g:7420:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalRoom.g:7420:1: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7421:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7421:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:7422:3: otherlv_0= RULE_ID
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
    // InternalRoom.g:7441:1: entryRuleTrPointTerminal returns [EObject current=null] : iv_ruleTrPointTerminal= ruleTrPointTerminal EOF ;
    public final EObject entryRuleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPointTerminal = null;


        try {
            // InternalRoom.g:7442:2: (iv_ruleTrPointTerminal= ruleTrPointTerminal EOF )
            // InternalRoom.g:7443:2: iv_ruleTrPointTerminal= ruleTrPointTerminal EOF
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
    // InternalRoom.g:7450:1: ruleTrPointTerminal returns [EObject current=null] : (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7453:28: ( (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:7454:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:7454:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:7454:3: otherlv_0= 'my' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,101,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getTrPointTerminalAccess().getMyKeyword_0());
                
            // InternalRoom.g:7458:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:7459:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:7459:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:7460:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:7479:1: entryRuleSubStateTrPointTerminal returns [EObject current=null] : iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF ;
    public final EObject entryRuleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStateTrPointTerminal = null;


        try {
            // InternalRoom.g:7480:2: (iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF )
            // InternalRoom.g:7481:2: iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF
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
    // InternalRoom.g:7488:1: ruleSubStateTrPointTerminal returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7491:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:7492:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:7492:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:7492:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:7492:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7493:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7493:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:7494:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_90); 

            		newLeafNode(otherlv_0, grammarAccess.getSubStateTrPointTerminalAccess().getTrPointTrPointCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getSubStateTrPointTerminalAccess().getOfKeyword_1());
                
            // InternalRoom.g:7509:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7510:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7510:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7511:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:7530:1: entryRuleChoicepointTerminal returns [EObject current=null] : iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF ;
    public final EObject entryRuleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicepointTerminal = null;


        try {
            // InternalRoom.g:7531:2: (iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF )
            // InternalRoom.g:7532:2: iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF
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
    // InternalRoom.g:7539:1: ruleChoicepointTerminal returns [EObject current=null] : (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7542:28: ( (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:7543:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:7543:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:7543:3: otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,102,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicepointTerminalAccess().getCpKeyword_0());
                
            // InternalRoom.g:7547:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:7548:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:7548:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:7549:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:7568:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // InternalRoom.g:7569:2: (iv_ruleTrigger= ruleTrigger EOF )
            // InternalRoom.g:7570:2: iv_ruleTrigger= ruleTrigger EOF
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
    // InternalRoom.g:7577:1: ruleTrigger returns [EObject current=null] : (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) ;
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
            // InternalRoom.g:7580:28: ( (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) )
            // InternalRoom.g:7581:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            {
            // InternalRoom.g:7581:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            // InternalRoom.g:7581:3: otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>'
            {
            otherlv_0=(Token)match(input,103,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggerAccess().getLessThanSignKeyword_0());
                
            // InternalRoom.g:7585:1: ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) )
            // InternalRoom.g:7586:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            {
            // InternalRoom.g:7586:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            // InternalRoom.g:7587:3: lv_msgFromIfPairs_1_0= ruleMessageFromIf
            {
             
            	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_135);
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

            // InternalRoom.g:7603:2: (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )*
            loop171:
            do {
                int alt171=2;
                int LA171_0 = input.LA(1);

                if ( (LA171_0==104) ) {
                    alt171=1;
                }


                switch (alt171) {
            	case 1 :
            	    // InternalRoom.g:7603:4: otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    {
            	    otherlv_2=(Token)match(input,104,FOLLOW_3); 

            	        	newLeafNode(otherlv_2, grammarAccess.getTriggerAccess().getVerticalLineKeyword_2_0());
            	        
            	    // InternalRoom.g:7607:1: ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    // InternalRoom.g:7608:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    {
            	    // InternalRoom.g:7608:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    // InternalRoom.g:7609:3: lv_msgFromIfPairs_3_0= ruleMessageFromIf
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_135);
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
            	    break loop171;
                }
            } while (true);

            // InternalRoom.g:7625:4: ( (lv_guard_4_0= ruleGuard ) )?
            int alt172=2;
            int LA172_0 = input.LA(1);

            if ( (LA172_0==98) ) {
                alt172=1;
            }
            switch (alt172) {
                case 1 :
                    // InternalRoom.g:7626:1: (lv_guard_4_0= ruleGuard )
                    {
                    // InternalRoom.g:7626:1: (lv_guard_4_0= ruleGuard )
                    // InternalRoom.g:7627:3: lv_guard_4_0= ruleGuard
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggerAccess().getGuardGuardParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_136);
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
    // InternalRoom.g:7655:1: entryRuleMessageFromIf returns [EObject current=null] : iv_ruleMessageFromIf= ruleMessageFromIf EOF ;
    public final EObject entryRuleMessageFromIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageFromIf = null;


        try {
            // InternalRoom.g:7656:2: (iv_ruleMessageFromIf= ruleMessageFromIf EOF )
            // InternalRoom.g:7657:2: iv_ruleMessageFromIf= ruleMessageFromIf EOF
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
    // InternalRoom.g:7664:1: ruleMessageFromIf returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMessageFromIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7667:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:7668:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:7668:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:7668:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:7668:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7669:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7669:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:7670:3: otherlv_0= RULE_ID
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
                
            // InternalRoom.g:7685:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7686:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7686:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7687:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:7706:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // InternalRoom.g:7707:2: (iv_ruleGuard= ruleGuard EOF )
            // InternalRoom.g:7708:2: iv_ruleGuard= ruleGuard EOF
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
    // InternalRoom.g:7715:1: ruleGuard returns [EObject current=null] : (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_guard_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7718:28: ( (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:7719:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:7719:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            // InternalRoom.g:7719:3: otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,98,FOLLOW_48); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getGuardKeyword_0());
                
            // InternalRoom.g:7723:1: ( (lv_guard_1_0= ruleDetailCode ) )
            // InternalRoom.g:7724:1: (lv_guard_1_0= ruleDetailCode )
            {
            // InternalRoom.g:7724:1: (lv_guard_1_0= ruleDetailCode )
            // InternalRoom.g:7725:3: lv_guard_1_0= ruleDetailCode
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
    // InternalRoom.g:7749:1: entryRuleProtocolSemantics returns [EObject current=null] : iv_ruleProtocolSemantics= ruleProtocolSemantics EOF ;
    public final EObject entryRuleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSemantics = null;


        try {
            // InternalRoom.g:7750:2: (iv_ruleProtocolSemantics= ruleProtocolSemantics EOF )
            // InternalRoom.g:7751:2: iv_ruleProtocolSemantics= ruleProtocolSemantics EOF
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
    // InternalRoom.g:7758:1: ruleProtocolSemantics returns [EObject current=null] : ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) ;
    public final EObject ruleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_rules_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7761:28: ( ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) )
            // InternalRoom.g:7762:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            {
            // InternalRoom.g:7762:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            // InternalRoom.g:7762:2: () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}'
            {
            // InternalRoom.g:7762:2: ()
            // InternalRoom.g:7763:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getProtocolSemanticsAccess().getProtocolSemanticsAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,106,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getProtocolSemanticsAccess().getSemanticsKeyword_1());
                
            otherlv_2=(Token)match(input,14,FOLLOW_137); 

                	newLeafNode(otherlv_2, grammarAccess.getProtocolSemanticsAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalRoom.g:7776:1: ( (lv_rules_3_0= ruleSemanticsRule ) )*
            loop173:
            do {
                int alt173=2;
                int LA173_0 = input.LA(1);

                if ( ((LA173_0>=107 && LA173_0<=108)) ) {
                    alt173=1;
                }


                switch (alt173) {
            	case 1 :
            	    // InternalRoom.g:7777:1: (lv_rules_3_0= ruleSemanticsRule )
            	    {
            	    // InternalRoom.g:7777:1: (lv_rules_3_0= ruleSemanticsRule )
            	    // InternalRoom.g:7778:3: lv_rules_3_0= ruleSemanticsRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolSemanticsAccess().getRulesSemanticsRuleParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_137);
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
            	    break loop173;
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
    // InternalRoom.g:7806:1: entryRuleSemanticsRule returns [EObject current=null] : iv_ruleSemanticsRule= ruleSemanticsRule EOF ;
    public final EObject entryRuleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsRule = null;


        try {
            // InternalRoom.g:7807:2: (iv_ruleSemanticsRule= ruleSemanticsRule EOF )
            // InternalRoom.g:7808:2: iv_ruleSemanticsRule= ruleSemanticsRule EOF
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
    // InternalRoom.g:7815:1: ruleSemanticsRule returns [EObject current=null] : (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) ;
    public final EObject ruleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject this_InSemanticsRule_0 = null;

        EObject this_OutSemanticsRule_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7818:28: ( (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) )
            // InternalRoom.g:7819:1: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            {
            // InternalRoom.g:7819:1: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            int alt174=2;
            int LA174_0 = input.LA(1);

            if ( (LA174_0==107) ) {
                alt174=1;
            }
            else if ( (LA174_0==108) ) {
                alt174=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 174, 0, input);

                throw nvae;
            }
            switch (alt174) {
                case 1 :
                    // InternalRoom.g:7820:5: this_InSemanticsRule_0= ruleInSemanticsRule
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
                    // InternalRoom.g:7830:5: this_OutSemanticsRule_1= ruleOutSemanticsRule
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
    // InternalRoom.g:7846:1: entryRuleInSemanticsRule returns [EObject current=null] : iv_ruleInSemanticsRule= ruleInSemanticsRule EOF ;
    public final EObject entryRuleInSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInSemanticsRule = null;


        try {
            // InternalRoom.g:7847:2: (iv_ruleInSemanticsRule= ruleInSemanticsRule EOF )
            // InternalRoom.g:7848:2: iv_ruleInSemanticsRule= ruleInSemanticsRule EOF
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
    // InternalRoom.g:7855:1: ruleInSemanticsRule returns [EObject current=null] : (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // InternalRoom.g:7858:28: ( (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // InternalRoom.g:7859:1: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // InternalRoom.g:7859:1: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // InternalRoom.g:7859:3: otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,107,FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getInSemanticsRuleAccess().getInKeyword_0());
                
            otherlv_1=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getInSemanticsRuleAccess().getColonKeyword_1());
                
            // InternalRoom.g:7867:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7868:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7868:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7869:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInSemanticsRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_138); 

            		newLeafNode(otherlv_2, grammarAccess.getInSemanticsRuleAccess().getMsgEObjectCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:7880:2: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt177=2;
            int LA177_0 = input.LA(1);

            if ( (LA177_0==20) ) {
                alt177=1;
            }
            switch (alt177) {
                case 1 :
                    // InternalRoom.g:7880:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,20,FOLLOW_139); 

                        	newLeafNode(otherlv_3, grammarAccess.getInSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // InternalRoom.g:7884:1: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
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
                            // InternalRoom.g:7884:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // InternalRoom.g:7884:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7885:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7885:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // InternalRoom.g:7886:3: lv_followUps_4_0= ruleSemanticsRule
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
                            // InternalRoom.g:7903:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // InternalRoom.g:7903:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // InternalRoom.g:7903:8: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,21,FOLLOW_140); 

                                	newLeafNode(otherlv_5, grammarAccess.getInSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                                
                            // InternalRoom.g:7907:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7908:1: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7908:1: (lv_followUps_6_0= ruleSemanticsRule )
                            // InternalRoom.g:7909:3: lv_followUps_6_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_141);
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

                            // InternalRoom.g:7925:2: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
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
                            	    // InternalRoom.g:7925:4: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,26,FOLLOW_140); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getInSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	        
                            	    // InternalRoom.g:7929:1: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // InternalRoom.g:7930:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // InternalRoom.g:7930:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // InternalRoom.g:7931:3: lv_followUps_8_0= ruleSemanticsRule
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
                            	    if ( cnt175 >= 1 ) break loop175;
                                        EarlyExitException eee =
                                            new EarlyExitException(175, input);
                                        throw eee;
                                }
                                cnt175++;
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
    // InternalRoom.g:7959:1: entryRuleOutSemanticsRule returns [EObject current=null] : iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF ;
    public final EObject entryRuleOutSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutSemanticsRule = null;


        try {
            // InternalRoom.g:7960:2: (iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF )
            // InternalRoom.g:7961:2: iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF
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
    // InternalRoom.g:7968:1: ruleOutSemanticsRule returns [EObject current=null] : (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // InternalRoom.g:7971:28: ( (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // InternalRoom.g:7972:1: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // InternalRoom.g:7972:1: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // InternalRoom.g:7972:3: otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,108,FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getOutSemanticsRuleAccess().getOutKeyword_0());
                
            otherlv_1=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getOutSemanticsRuleAccess().getColonKeyword_1());
                
            // InternalRoom.g:7980:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7981:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7981:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7982:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOutSemanticsRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_138); 

            		newLeafNode(otherlv_2, grammarAccess.getOutSemanticsRuleAccess().getMsgEObjectCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:7993:2: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt180=2;
            int LA180_0 = input.LA(1);

            if ( (LA180_0==20) ) {
                alt180=1;
            }
            switch (alt180) {
                case 1 :
                    // InternalRoom.g:7993:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,20,FOLLOW_139); 

                        	newLeafNode(otherlv_3, grammarAccess.getOutSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // InternalRoom.g:7997:1: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt179=2;
                    int LA179_0 = input.LA(1);

                    if ( ((LA179_0>=107 && LA179_0<=108)) ) {
                        alt179=1;
                    }
                    else if ( (LA179_0==21) ) {
                        alt179=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 179, 0, input);

                        throw nvae;
                    }
                    switch (alt179) {
                        case 1 :
                            // InternalRoom.g:7997:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // InternalRoom.g:7997:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7998:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7998:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // InternalRoom.g:7999:3: lv_followUps_4_0= ruleSemanticsRule
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
                            // InternalRoom.g:8016:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // InternalRoom.g:8016:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // InternalRoom.g:8016:8: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,21,FOLLOW_140); 

                                	newLeafNode(otherlv_5, grammarAccess.getOutSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                                
                            // InternalRoom.g:8020:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // InternalRoom.g:8021:1: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:8021:1: (lv_followUps_6_0= ruleSemanticsRule )
                            // InternalRoom.g:8022:3: lv_followUps_6_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_141);
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

                            // InternalRoom.g:8038:2: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt178=0;
                            loop178:
                            do {
                                int alt178=2;
                                int LA178_0 = input.LA(1);

                                if ( (LA178_0==26) ) {
                                    alt178=1;
                                }


                                switch (alt178) {
                            	case 1 :
                            	    // InternalRoom.g:8038:4: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,26,FOLLOW_140); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getOutSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	        
                            	    // InternalRoom.g:8042:1: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // InternalRoom.g:8043:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // InternalRoom.g:8043:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // InternalRoom.g:8044:3: lv_followUps_8_0= ruleSemanticsRule
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
                            	    if ( cnt178 >= 1 ) break loop178;
                                        EarlyExitException eee =
                                            new EarlyExitException(178, input);
                                        throw eee;
                                }
                                cnt178++;
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
    // InternalRoom.g:8072:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalRoom.g:8073:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalRoom.g:8074:2: iv_ruleAnnotation= ruleAnnotation EOF
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
    // InternalRoom.g:8081:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) ;
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
            // InternalRoom.g:8084:28: ( (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) )
            // InternalRoom.g:8085:1: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            {
            // InternalRoom.g:8085:1: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            // InternalRoom.g:8085:3: otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,109,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
                
            // InternalRoom.g:8089:1: ( ( ruleFQN ) )
            // InternalRoom.g:8090:1: ( ruleFQN )
            {
            // InternalRoom.g:8090:1: ( ruleFQN )
            // InternalRoom.g:8091:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAnnotationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_142);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:8104:2: (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            int alt182=2;
            int LA182_0 = input.LA(1);

            if ( (LA182_0==21) ) {
                alt182=1;
            }
            switch (alt182) {
                case 1 :
                    // InternalRoom.g:8104:4: otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0());
                        
                    // InternalRoom.g:8108:1: ( (lv_attributes_3_0= ruleKeyValue ) )
                    // InternalRoom.g:8109:1: (lv_attributes_3_0= ruleKeyValue )
                    {
                    // InternalRoom.g:8109:1: (lv_attributes_3_0= ruleKeyValue )
                    // InternalRoom.g:8110:3: lv_attributes_3_0= ruleKeyValue
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

                    // InternalRoom.g:8126:2: (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )*
                    loop181:
                    do {
                        int alt181=2;
                        int LA181_0 = input.LA(1);

                        if ( (LA181_0==26) ) {
                            alt181=1;
                        }


                        switch (alt181) {
                    	case 1 :
                    	    // InternalRoom.g:8126:4: otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,26,FOLLOW_3); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // InternalRoom.g:8130:1: ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    // InternalRoom.g:8131:1: (lv_attributes_5_0= ruleKeyValue )
                    	    {
                    	    // InternalRoom.g:8131:1: (lv_attributes_5_0= ruleKeyValue )
                    	    // InternalRoom.g:8132:3: lv_attributes_5_0= ruleKeyValue
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
                    	    break loop181;
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
    // InternalRoom.g:8160:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalRoom.g:8161:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalRoom.g:8162:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalRoom.g:8169:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8172:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalRoom.g:8173:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalRoom.g:8173:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalRoom.g:8173:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalRoom.g:8173:2: ( (lv_key_0_0= RULE_ID ) )
            // InternalRoom.g:8174:1: (lv_key_0_0= RULE_ID )
            {
            // InternalRoom.g:8174:1: (lv_key_0_0= RULE_ID )
            // InternalRoom.g:8175:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_143); 

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

            otherlv_1=(Token)match(input,27,FOLLOW_144); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // InternalRoom.g:8195:1: ( (lv_value_2_0= ruleLiteral ) )
            // InternalRoom.g:8196:1: (lv_value_2_0= ruleLiteral )
            {
            // InternalRoom.g:8196:1: (lv_value_2_0= ruleLiteral )
            // InternalRoom.g:8197:3: lv_value_2_0= ruleLiteral
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
    // InternalRoom.g:8221:1: entryRuleAnnotationType returns [EObject current=null] : iv_ruleAnnotationType= ruleAnnotationType EOF ;
    public final EObject entryRuleAnnotationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationType = null;


        try {
            // InternalRoom.g:8222:2: (iv_ruleAnnotationType= ruleAnnotationType EOF )
            // InternalRoom.g:8223:2: iv_ruleAnnotationType= ruleAnnotationType EOF
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
    // InternalRoom.g:8230:1: ruleAnnotationType returns [EObject current=null] : (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' ) ;
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
            // InternalRoom.g:8233:28: ( (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' ) )
            // InternalRoom.g:8234:1: (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' )
            {
            // InternalRoom.g:8234:1: (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' )
            // InternalRoom.g:8234:3: otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,110,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationTypeAccess().getAnnotationTypeKeyword_0());
                
            // InternalRoom.g:8238:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:8239:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:8239:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:8240:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:8256:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt183=2;
            int LA183_0 = input.LA(1);

            if ( (LA183_0==35) ) {
                alt183=1;
            }
            switch (alt183) {
                case 1 :
                    // InternalRoom.g:8257:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:8257:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:8258:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_145); 

                	newLeafNode(otherlv_3, grammarAccess.getAnnotationTypeAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,111,FOLLOW_143); 

                	newLeafNode(otherlv_4, grammarAccess.getAnnotationTypeAccess().getTargetKeyword_4());
                
            otherlv_5=(Token)match(input,27,FOLLOW_146); 

                	newLeafNode(otherlv_5, grammarAccess.getAnnotationTypeAccess().getEqualsSignKeyword_5());
                
            // InternalRoom.g:8286:1: ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) )
            int alt185=2;
            int LA185_0 = input.LA(1);

            if ( (LA185_0==13||LA185_0==29||LA185_0==43||LA185_0==49||LA185_0==52||LA185_0==56||LA185_0==60||LA185_0==65||LA185_0==67||(LA185_0>=80 && LA185_0<=82)) ) {
                alt185=1;
            }
            else if ( (LA185_0==14) ) {
                alt185=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 185, 0, input);

                throw nvae;
            }
            switch (alt185) {
                case 1 :
                    // InternalRoom.g:8286:2: ( (lv_targets_6_0= ruleAnnotationTargetType ) )
                    {
                    // InternalRoom.g:8286:2: ( (lv_targets_6_0= ruleAnnotationTargetType ) )
                    // InternalRoom.g:8287:1: (lv_targets_6_0= ruleAnnotationTargetType )
                    {
                    // InternalRoom.g:8287:1: (lv_targets_6_0= ruleAnnotationTargetType )
                    // InternalRoom.g:8288:3: lv_targets_6_0= ruleAnnotationTargetType
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_0_0()); 
                    	    
                    pushFollow(FOLLOW_147);
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
                    // InternalRoom.g:8305:6: (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' )
                    {
                    // InternalRoom.g:8305:6: (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' )
                    // InternalRoom.g:8305:8: otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_148); 

                        	newLeafNode(otherlv_7, grammarAccess.getAnnotationTypeAccess().getLeftCurlyBracketKeyword_6_1_0());
                        
                    // InternalRoom.g:8309:1: ( (lv_targets_8_0= ruleAnnotationTargetType ) )
                    // InternalRoom.g:8310:1: (lv_targets_8_0= ruleAnnotationTargetType )
                    {
                    // InternalRoom.g:8310:1: (lv_targets_8_0= ruleAnnotationTargetType )
                    // InternalRoom.g:8311:3: lv_targets_8_0= ruleAnnotationTargetType
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

                    // InternalRoom.g:8327:2: (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )*
                    loop184:
                    do {
                        int alt184=2;
                        int LA184_0 = input.LA(1);

                        if ( (LA184_0==26) ) {
                            alt184=1;
                        }


                        switch (alt184) {
                    	case 1 :
                    	    // InternalRoom.g:8327:4: otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) )
                    	    {
                    	    otherlv_9=(Token)match(input,26,FOLLOW_148); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getAnnotationTypeAccess().getCommaKeyword_6_1_2_0());
                    	        
                    	    // InternalRoom.g:8331:1: ( (lv_targets_10_0= ruleAnnotationTargetType ) )
                    	    // InternalRoom.g:8332:1: (lv_targets_10_0= ruleAnnotationTargetType )
                    	    {
                    	    // InternalRoom.g:8332:1: (lv_targets_10_0= ruleAnnotationTargetType )
                    	    // InternalRoom.g:8333:3: lv_targets_10_0= ruleAnnotationTargetType
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
                    	    break loop184;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,15,FOLLOW_147); 

                        	newLeafNode(otherlv_11, grammarAccess.getAnnotationTypeAccess().getRightCurlyBracketKeyword_6_1_3());
                        

                    }


                    }
                    break;

            }

            // InternalRoom.g:8353:3: ( (lv_attributes_12_0= ruleAnnotationAttribute ) )*
            loop186:
            do {
                int alt186=2;
                int LA186_0 = input.LA(1);

                if ( ((LA186_0>=112 && LA186_0<=113)) ) {
                    alt186=1;
                }


                switch (alt186) {
            	case 1 :
            	    // InternalRoom.g:8354:1: (lv_attributes_12_0= ruleAnnotationAttribute )
            	    {
            	    // InternalRoom.g:8354:1: (lv_attributes_12_0= ruleAnnotationAttribute )
            	    // InternalRoom.g:8355:3: lv_attributes_12_0= ruleAnnotationAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getAttributesAnnotationAttributeParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_147);
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
            	    break loop186;
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
    // InternalRoom.g:8383:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // InternalRoom.g:8384:2: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // InternalRoom.g:8385:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
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
    // InternalRoom.g:8392:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8395:28: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // InternalRoom.g:8396:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // InternalRoom.g:8396:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt187=2;
            int LA187_0 = input.LA(1);

            if ( (LA187_0==112) ) {
                int LA187_1 = input.LA(2);

                if ( (LA187_1==114) ) {
                    int LA187_3 = input.LA(3);

                    if ( (LA187_3==RULE_ID) ) {
                        int LA187_4 = input.LA(4);

                        if ( (LA187_4==16) ) {
                            int LA187_5 = input.LA(5);

                            if ( ((LA187_5>=130 && LA187_5<=133)) ) {
                                alt187=1;
                            }
                            else if ( (LA187_5==14) ) {
                                alt187=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 187, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 187, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 187, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 187, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA187_0==113) ) {
                int LA187_2 = input.LA(2);

                if ( (LA187_2==114) ) {
                    int LA187_3 = input.LA(3);

                    if ( (LA187_3==RULE_ID) ) {
                        int LA187_4 = input.LA(4);

                        if ( (LA187_4==16) ) {
                            int LA187_5 = input.LA(5);

                            if ( ((LA187_5>=130 && LA187_5<=133)) ) {
                                alt187=1;
                            }
                            else if ( (LA187_5==14) ) {
                                alt187=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 187, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 187, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 187, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 187, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 187, 0, input);

                throw nvae;
            }
            switch (alt187) {
                case 1 :
                    // InternalRoom.g:8397:5: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
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
                    // InternalRoom.g:8407:5: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
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
    // InternalRoom.g:8423:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // InternalRoom.g:8424:2: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // InternalRoom.g:8425:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
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
    // InternalRoom.g:8432:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // InternalRoom.g:8435:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // InternalRoom.g:8436:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // InternalRoom.g:8436:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // InternalRoom.g:8436:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // InternalRoom.g:8436:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt188=2;
            int LA188_0 = input.LA(1);

            if ( (LA188_0==112) ) {
                alt188=1;
            }
            else if ( (LA188_0==113) ) {
                alt188=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 188, 0, input);

                throw nvae;
            }
            switch (alt188) {
                case 1 :
                    // InternalRoom.g:8436:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalRoom.g:8436:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalRoom.g:8437:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalRoom.g:8437:1: (lv_optional_0_0= 'optional' )
                    // InternalRoom.g:8438:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,112,FOLLOW_149); 

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
                    // InternalRoom.g:8452:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,113,FOLLOW_149); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,114,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalRoom.g:8460:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalRoom.g:8461:1: (lv_name_3_0= RULE_ID )
            {
            // InternalRoom.g:8461:1: (lv_name_3_0= RULE_ID )
            // InternalRoom.g:8462:3: lv_name_3_0= RULE_ID
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
                
            // InternalRoom.g:8482:1: ( (lv_type_5_0= ruleLiteralType ) )
            // InternalRoom.g:8483:1: (lv_type_5_0= ruleLiteralType )
            {
            // InternalRoom.g:8483:1: (lv_type_5_0= ruleLiteralType )
            // InternalRoom.g:8484:3: lv_type_5_0= ruleLiteralType
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
    // InternalRoom.g:8508:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // InternalRoom.g:8509:2: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // InternalRoom.g:8510:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
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
    // InternalRoom.g:8517:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // InternalRoom.g:8520:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // InternalRoom.g:8521:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // InternalRoom.g:8521:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // InternalRoom.g:8521:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // InternalRoom.g:8521:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt189=2;
            int LA189_0 = input.LA(1);

            if ( (LA189_0==112) ) {
                alt189=1;
            }
            else if ( (LA189_0==113) ) {
                alt189=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 189, 0, input);

                throw nvae;
            }
            switch (alt189) {
                case 1 :
                    // InternalRoom.g:8521:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalRoom.g:8521:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalRoom.g:8522:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalRoom.g:8522:1: (lv_optional_0_0= 'optional' )
                    // InternalRoom.g:8523:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,112,FOLLOW_149); 

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
                    // InternalRoom.g:8537:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,113,FOLLOW_149); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,114,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalRoom.g:8545:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalRoom.g:8546:1: (lv_name_3_0= RULE_ID )
            {
            // InternalRoom.g:8546:1: (lv_name_3_0= RULE_ID )
            // InternalRoom.g:8547:3: lv_name_3_0= RULE_ID
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
                
            // InternalRoom.g:8571:1: ( (lv_values_6_0= RULE_STRING ) )
            // InternalRoom.g:8572:1: (lv_values_6_0= RULE_STRING )
            {
            // InternalRoom.g:8572:1: (lv_values_6_0= RULE_STRING )
            // InternalRoom.g:8573:3: lv_values_6_0= RULE_STRING
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

            // InternalRoom.g:8589:2: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop190:
            do {
                int alt190=2;
                int LA190_0 = input.LA(1);

                if ( (LA190_0==26) ) {
                    alt190=1;
                }


                switch (alt190) {
            	case 1 :
            	    // InternalRoom.g:8589:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,26,FOLLOW_15); 

            	        	newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	        
            	    // InternalRoom.g:8593:1: ( (lv_values_8_0= RULE_STRING ) )
            	    // InternalRoom.g:8594:1: (lv_values_8_0= RULE_STRING )
            	    {
            	    // InternalRoom.g:8594:1: (lv_values_8_0= RULE_STRING )
            	    // InternalRoom.g:8595:3: lv_values_8_0= RULE_STRING
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
            	    break loop190;
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
    // InternalRoom.g:8623:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalRoom.g:8624:2: (iv_ruleImport= ruleImport EOF )
            // InternalRoom.g:8625:2: iv_ruleImport= ruleImport EOF
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
    // InternalRoom.g:8632:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) ) ) ;
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
            // InternalRoom.g:8635:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) ) ) )
            // InternalRoom.g:8636:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) ) )
            {
            // InternalRoom.g:8636:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) ) )
            // InternalRoom.g:8636:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) )
            {
            otherlv_0=(Token)match(input,115,FOLLOW_150); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalRoom.g:8640:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) )
            int alt192=2;
            int LA192_0 = input.LA(1);

            if ( (LA192_0==RULE_ID) ) {
                alt192=1;
            }
            else if ( (LA192_0==117) ) {
                alt192=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 192, 0, input);

                throw nvae;
            }
            switch (alt192) {
                case 1 :
                    // InternalRoom.g:8640:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? )
                    {
                    // InternalRoom.g:8640:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? )
                    // InternalRoom.g:8640:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )?
                    {
                    // InternalRoom.g:8640:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // InternalRoom.g:8641:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // InternalRoom.g:8641:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // InternalRoom.g:8642:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_151);
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

                    // InternalRoom.g:8658:2: (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )?
                    int alt191=2;
                    int LA191_0 = input.LA(1);

                    if ( (LA191_0==116) ) {
                        alt191=1;
                    }
                    switch (alt191) {
                        case 1 :
                            // InternalRoom.g:8658:4: otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) )
                            {
                            otherlv_2=(Token)match(input,116,FOLLOW_15); 

                                	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1_0());
                                
                            // InternalRoom.g:8662:1: ( (lv_importURI_3_0= RULE_STRING ) )
                            // InternalRoom.g:8663:1: (lv_importURI_3_0= RULE_STRING )
                            {
                            // InternalRoom.g:8663:1: (lv_importURI_3_0= RULE_STRING )
                            // InternalRoom.g:8664:3: lv_importURI_3_0= RULE_STRING
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
                    // InternalRoom.g:8681:6: (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) )
                    {
                    // InternalRoom.g:8681:6: (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) )
                    // InternalRoom.g:8681:8: otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,117,FOLLOW_15); 

                        	newLeafNode(otherlv_4, grammarAccess.getImportAccess().getModelKeyword_1_1_0());
                        
                    // InternalRoom.g:8685:1: ( (lv_importURI_5_0= RULE_STRING ) )
                    // InternalRoom.g:8686:1: (lv_importURI_5_0= RULE_STRING )
                    {
                    // InternalRoom.g:8686:1: (lv_importURI_5_0= RULE_STRING )
                    // InternalRoom.g:8687:3: lv_importURI_5_0= RULE_STRING
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
    // InternalRoom.g:8711:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalRoom.g:8712:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalRoom.g:8713:2: iv_ruleImportedFQN= ruleImportedFQN EOF
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
    // InternalRoom.g:8720:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8723:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // InternalRoom.g:8724:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // InternalRoom.g:8724:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // InternalRoom.g:8725:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_152);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalRoom.g:8735:1: (kw= '.*' )?
            int alt193=2;
            int LA193_0 = input.LA(1);

            if ( (LA193_0==118) ) {
                alt193=1;
            }
            switch (alt193) {
                case 1 :
                    // InternalRoom.g:8736:2: kw= '.*'
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
    // InternalRoom.g:8749:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // InternalRoom.g:8750:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // InternalRoom.g:8751:2: iv_ruleDocumentation= ruleDocumentation EOF
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
    // InternalRoom.g:8758:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:8761:28: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // InternalRoom.g:8762:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // InternalRoom.g:8762:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // InternalRoom.g:8762:2: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // InternalRoom.g:8762:2: ()
            // InternalRoom.g:8763:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,35,FOLLOW_153); 

                	newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
                
            // InternalRoom.g:8772:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop194:
            do {
                int alt194=2;
                int LA194_0 = input.LA(1);

                if ( (LA194_0==RULE_STRING) ) {
                    alt194=1;
                }


                switch (alt194) {
            	case 1 :
            	    // InternalRoom.g:8773:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // InternalRoom.g:8773:1: (lv_lines_2_0= RULE_STRING )
            	    // InternalRoom.g:8774:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_153); 

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
            	    break loop194;
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
    // InternalRoom.g:8806:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalRoom.g:8807:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalRoom.g:8808:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalRoom.g:8815:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8818:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // InternalRoom.g:8819:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // InternalRoom.g:8819:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt195=3;
            switch ( input.LA(1) ) {
            case 119:
            case 120:
                {
                alt195=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 121:
            case 122:
                {
                alt195=2;
                }
                break;
            case RULE_STRING:
                {
                alt195=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 195, 0, input);

                throw nvae;
            }

            switch (alt195) {
                case 1 :
                    // InternalRoom.g:8820:5: this_BooleanLiteral_0= ruleBooleanLiteral
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
                    // InternalRoom.g:8830:5: this_NumberLiteral_1= ruleNumberLiteral
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
                    // InternalRoom.g:8840:5: this_StringLiteral_2= ruleStringLiteral
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
    // InternalRoom.g:8856:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalRoom.g:8857:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalRoom.g:8858:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalRoom.g:8865:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:8868:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // InternalRoom.g:8869:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // InternalRoom.g:8869:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // InternalRoom.g:8869:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // InternalRoom.g:8869:2: ()
            // InternalRoom.g:8870:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:8875:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt196=2;
            int LA196_0 = input.LA(1);

            if ( (LA196_0==119) ) {
                alt196=1;
            }
            else if ( (LA196_0==120) ) {
                alt196=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 196, 0, input);

                throw nvae;
            }
            switch (alt196) {
                case 1 :
                    // InternalRoom.g:8875:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,119,FOLLOW_2); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:8880:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // InternalRoom.g:8880:6: ( (lv_isTrue_2_0= 'true' ) )
                    // InternalRoom.g:8881:1: (lv_isTrue_2_0= 'true' )
                    {
                    // InternalRoom.g:8881:1: (lv_isTrue_2_0= 'true' )
                    // InternalRoom.g:8882:3: lv_isTrue_2_0= 'true'
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
    // InternalRoom.g:8903:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalRoom.g:8904:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalRoom.g:8905:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
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
    // InternalRoom.g:8912:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8915:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalRoom.g:8916:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalRoom.g:8916:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt197=2;
            switch ( input.LA(1) ) {
            case 121:
                {
                int LA197_1 = input.LA(2);

                if ( (LA197_1==RULE_INT) ) {
                    int LA197_3 = input.LA(3);

                    if ( (LA197_3==EOF||LA197_3==22||LA197_3==26) ) {
                        alt197=1;
                    }
                    else if ( (LA197_3==73) ) {
                        alt197=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 197, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 197, 1, input);

                    throw nvae;
                }
                }
                break;
            case 122:
                {
                int LA197_2 = input.LA(2);

                if ( (LA197_2==RULE_INT) ) {
                    int LA197_3 = input.LA(3);

                    if ( (LA197_3==EOF||LA197_3==22||LA197_3==26) ) {
                        alt197=1;
                    }
                    else if ( (LA197_3==73) ) {
                        alt197=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 197, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 197, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA197_3 = input.LA(2);

                if ( (LA197_3==EOF||LA197_3==22||LA197_3==26) ) {
                    alt197=1;
                }
                else if ( (LA197_3==73) ) {
                    alt197=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 197, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt197=1;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 197, 0, input);

                throw nvae;
            }

            switch (alt197) {
                case 1 :
                    // InternalRoom.g:8917:5: this_IntLiteral_0= ruleIntLiteral
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
                    // InternalRoom.g:8927:5: this_RealLiteral_1= ruleRealLiteral
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
    // InternalRoom.g:8943:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalRoom.g:8944:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalRoom.g:8945:2: iv_ruleRealLiteral= ruleRealLiteral EOF
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
    // InternalRoom.g:8952:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8955:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // InternalRoom.g:8956:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // InternalRoom.g:8956:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // InternalRoom.g:8956:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // InternalRoom.g:8956:2: ()
            // InternalRoom.g:8957:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:8962:2: ( (lv_value_1_0= ruleReal ) )
            // InternalRoom.g:8963:1: (lv_value_1_0= ruleReal )
            {
            // InternalRoom.g:8963:1: (lv_value_1_0= ruleReal )
            // InternalRoom.g:8964:3: lv_value_1_0= ruleReal
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
    // InternalRoom.g:8988:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalRoom.g:8989:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalRoom.g:8990:2: iv_ruleIntLiteral= ruleIntLiteral EOF
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
    // InternalRoom.g:8997:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:9000:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // InternalRoom.g:9001:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // InternalRoom.g:9001:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // InternalRoom.g:9001:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // InternalRoom.g:9001:2: ()
            // InternalRoom.g:9002:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:9007:2: ( (lv_value_1_0= ruleInteger ) )
            // InternalRoom.g:9008:1: (lv_value_1_0= ruleInteger )
            {
            // InternalRoom.g:9008:1: (lv_value_1_0= ruleInteger )
            // InternalRoom.g:9009:3: lv_value_1_0= ruleInteger
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
    // InternalRoom.g:9033:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalRoom.g:9034:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalRoom.g:9035:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalRoom.g:9042:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:9045:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalRoom.g:9046:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalRoom.g:9046:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalRoom.g:9046:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalRoom.g:9046:2: ()
            // InternalRoom.g:9047:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:9052:2: ( (lv_value_1_0= RULE_STRING ) )
            // InternalRoom.g:9053:1: (lv_value_1_0= RULE_STRING )
            {
            // InternalRoom.g:9053:1: (lv_value_1_0= RULE_STRING )
            // InternalRoom.g:9054:3: lv_value_1_0= RULE_STRING
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
    // InternalRoom.g:9078:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // InternalRoom.g:9079:2: (iv_ruleInteger= ruleInteger EOF )
            // InternalRoom.g:9080:2: iv_ruleInteger= ruleInteger EOF
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
    // InternalRoom.g:9087:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_HEX_3=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:9090:28: ( ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) )
            // InternalRoom.g:9091:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            {
            // InternalRoom.g:9091:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            int alt199=2;
            int LA199_0 = input.LA(1);

            if ( (LA199_0==RULE_INT||(LA199_0>=121 && LA199_0<=122)) ) {
                alt199=1;
            }
            else if ( (LA199_0==RULE_HEX) ) {
                alt199=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 199, 0, input);

                throw nvae;
            }
            switch (alt199) {
                case 1 :
                    // InternalRoom.g:9091:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    {
                    // InternalRoom.g:9091:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    // InternalRoom.g:9091:3: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
                    {
                    // InternalRoom.g:9091:3: (kw= '+' | kw= '-' )?
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
                            // InternalRoom.g:9092:2: kw= '+'
                            {
                            kw=(Token)match(input,121,FOLLOW_37); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // InternalRoom.g:9099:2: kw= '-'
                            {
                            kw=(Token)match(input,122,FOLLOW_37); 

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
                    // InternalRoom.g:9112:10: this_HEX_3= RULE_HEX
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
    // InternalRoom.g:9127:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // InternalRoom.g:9128:2: (iv_ruleReal= ruleReal EOF )
            // InternalRoom.g:9129:2: iv_ruleReal= ruleReal EOF
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
    // InternalRoom.g:9136:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DecimalExp_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:9139:28: ( (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) )
            // InternalRoom.g:9140:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            {
            // InternalRoom.g:9140:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            int alt200=2;
            switch ( input.LA(1) ) {
            case 121:
                {
                int LA200_1 = input.LA(2);

                if ( (LA200_1==RULE_INT) ) {
                    int LA200_3 = input.LA(3);

                    if ( (LA200_3==73) ) {
                        int LA200_4 = input.LA(4);

                        if ( (LA200_4==RULE_INT) ) {
                            int LA200_5 = input.LA(5);

                            if ( (LA200_5==EOF||LA200_5==22||LA200_5==26) ) {
                                alt200=1;
                            }
                            else if ( ((LA200_5>=123 && LA200_5<=124)) ) {
                                alt200=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 200, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 200, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 200, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 200, 1, input);

                    throw nvae;
                }
                }
                break;
            case 122:
                {
                int LA200_2 = input.LA(2);

                if ( (LA200_2==RULE_INT) ) {
                    int LA200_3 = input.LA(3);

                    if ( (LA200_3==73) ) {
                        int LA200_4 = input.LA(4);

                        if ( (LA200_4==RULE_INT) ) {
                            int LA200_5 = input.LA(5);

                            if ( (LA200_5==EOF||LA200_5==22||LA200_5==26) ) {
                                alt200=1;
                            }
                            else if ( ((LA200_5>=123 && LA200_5<=124)) ) {
                                alt200=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 200, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 200, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 200, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 200, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA200_3 = input.LA(2);

                if ( (LA200_3==73) ) {
                    int LA200_4 = input.LA(3);

                    if ( (LA200_4==RULE_INT) ) {
                        int LA200_5 = input.LA(4);

                        if ( (LA200_5==EOF||LA200_5==22||LA200_5==26) ) {
                            alt200=1;
                        }
                        else if ( ((LA200_5>=123 && LA200_5<=124)) ) {
                            alt200=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 200, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 200, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 200, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 200, 0, input);

                throw nvae;
            }

            switch (alt200) {
                case 1 :
                    // InternalRoom.g:9141:5: this_Decimal_0= ruleDecimal
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
                    // InternalRoom.g:9153:5: this_DecimalExp_1= ruleDecimalExp
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
    // InternalRoom.g:9171:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalRoom.g:9175:2: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalRoom.g:9176:2: iv_ruleDecimal= ruleDecimal EOF
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
    // InternalRoom.g:9186:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalRoom.g:9190:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // InternalRoom.g:9191:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // InternalRoom.g:9191:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // InternalRoom.g:9191:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // InternalRoom.g:9191:2: (kw= '+' | kw= '-' )?
            int alt201=3;
            int LA201_0 = input.LA(1);

            if ( (LA201_0==121) ) {
                alt201=1;
            }
            else if ( (LA201_0==122) ) {
                alt201=2;
            }
            switch (alt201) {
                case 1 :
                    // InternalRoom.g:9192:2: kw= '+'
                    {
                    kw=(Token)match(input,121,FOLLOW_37); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9199:2: kw= '-'
                    {
                    kw=(Token)match(input,122,FOLLOW_37); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_105); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,73,FOLLOW_37); 

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
    // InternalRoom.g:9235:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalRoom.g:9239:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // InternalRoom.g:9240:2: iv_ruleDecimalExp= ruleDecimalExp EOF
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
    // InternalRoom.g:9250:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalRoom.g:9254:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            // InternalRoom.g:9255:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            {
            // InternalRoom.g:9255:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            // InternalRoom.g:9255:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT
            {
            // InternalRoom.g:9255:2: (kw= '+' | kw= '-' )?
            int alt202=3;
            int LA202_0 = input.LA(1);

            if ( (LA202_0==121) ) {
                alt202=1;
            }
            else if ( (LA202_0==122) ) {
                alt202=2;
            }
            switch (alt202) {
                case 1 :
                    // InternalRoom.g:9256:2: kw= '+'
                    {
                    kw=(Token)match(input,121,FOLLOW_37); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9263:2: kw= '-'
                    {
                    kw=(Token)match(input,122,FOLLOW_37); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_105); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,73,FOLLOW_37); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_154); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            // InternalRoom.g:9288:1: (kw= 'e' | kw= 'E' )
            int alt203=2;
            int LA203_0 = input.LA(1);

            if ( (LA203_0==123) ) {
                alt203=1;
            }
            else if ( (LA203_0==124) ) {
                alt203=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 203, 0, input);

                throw nvae;
            }
            switch (alt203) {
                case 1 :
                    // InternalRoom.g:9289:2: kw= 'e'
                    {
                    kw=(Token)match(input,123,FOLLOW_155); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9296:2: kw= 'E'
                    {
                    kw=(Token)match(input,124,FOLLOW_155); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_1()); 
                        

                    }
                    break;

            }

            // InternalRoom.g:9301:2: (kw= '+' | kw= '-' )?
            int alt204=3;
            int LA204_0 = input.LA(1);

            if ( (LA204_0==121) ) {
                alt204=1;
            }
            else if ( (LA204_0==122) ) {
                alt204=2;
            }
            switch (alt204) {
                case 1 :
                    // InternalRoom.g:9302:2: kw= '+'
                    {
                    kw=(Token)match(input,121,FOLLOW_37); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9309:2: kw= '-'
                    {
                    kw=(Token)match(input,122,FOLLOW_37); 

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
    // InternalRoom.g:9332:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalRoom.g:9333:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalRoom.g:9334:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalRoom.g:9341:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:9344:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalRoom.g:9345:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalRoom.g:9345:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalRoom.g:9345:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_156); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalRoom.g:9352:1: (kw= '.' this_ID_2= RULE_ID )*
            loop205:
            do {
                int alt205=2;
                int LA205_0 = input.LA(1);

                if ( (LA205_0==73) ) {
                    alt205=1;
                }


                switch (alt205) {
            	case 1 :
            	    // InternalRoom.g:9353:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,73,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_156); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop205;
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
    // InternalRoom.g:9373:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // InternalRoom.g:9375:28: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) ) )
            // InternalRoom.g:9376:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) )
            {
            // InternalRoom.g:9376:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) )
            int alt206=3;
            switch ( input.LA(1) ) {
            case 125:
                {
                alt206=1;
                }
                break;
            case 126:
                {
                alt206=2;
                }
                break;
            case 127:
                {
                alt206=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 206, 0, input);

                throw nvae;
            }

            switch (alt206) {
                case 1 :
                    // InternalRoom.g:9376:2: (enumLiteral_0= 'eventdriven' )
                    {
                    // InternalRoom.g:9376:2: (enumLiteral_0= 'eventdriven' )
                    // InternalRoom.g:9376:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,125,FOLLOW_2); 

                            current = grammarAccess.getCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9382:6: (enumLiteral_1= 'datadriven' )
                    {
                    // InternalRoom.g:9382:6: (enumLiteral_1= 'datadriven' )
                    // InternalRoom.g:9382:8: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,126,FOLLOW_2); 

                            current = grammarAccess.getCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9388:6: (enumLiteral_2= 'sync' )
                    {
                    // InternalRoom.g:9388:6: (enumLiteral_2= 'sync' )
                    // InternalRoom.g:9388:8: enumLiteral_2= 'sync'
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
    // InternalRoom.g:9398:1: ruleReferenceType returns [Enumerator current=null] : ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) ) ;
    public final Enumerator ruleReferenceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalRoom.g:9400:28: ( ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) ) )
            // InternalRoom.g:9401:1: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) )
            {
            // InternalRoom.g:9401:1: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) )
            int alt207=2;
            int LA207_0 = input.LA(1);

            if ( (LA207_0==128) ) {
                alt207=1;
            }
            else if ( (LA207_0==112) ) {
                alt207=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 207, 0, input);

                throw nvae;
            }
            switch (alt207) {
                case 1 :
                    // InternalRoom.g:9401:2: (enumLiteral_0= 'fixed' )
                    {
                    // InternalRoom.g:9401:2: (enumLiteral_0= 'fixed' )
                    // InternalRoom.g:9401:4: enumLiteral_0= 'fixed'
                    {
                    enumLiteral_0=(Token)match(input,128,FOLLOW_2); 

                            current = grammarAccess.getReferenceTypeAccess().getFIXEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getReferenceTypeAccess().getFIXEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9407:6: (enumLiteral_1= 'optional' )
                    {
                    // InternalRoom.g:9407:6: (enumLiteral_1= 'optional' )
                    // InternalRoom.g:9407:8: enumLiteral_1= 'optional'
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
    // InternalRoom.g:9419:1: ruleComponentCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) ;
    public final Enumerator ruleComponentCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalRoom.g:9421:28: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) )
            // InternalRoom.g:9422:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            {
            // InternalRoom.g:9422:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            int alt208=4;
            switch ( input.LA(1) ) {
            case 125:
                {
                alt208=1;
                }
                break;
            case 126:
                {
                alt208=2;
                }
                break;
            case 129:
                {
                alt208=3;
                }
                break;
            case 127:
                {
                alt208=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 208, 0, input);

                throw nvae;
            }

            switch (alt208) {
                case 1 :
                    // InternalRoom.g:9422:2: (enumLiteral_0= 'eventdriven' )
                    {
                    // InternalRoom.g:9422:2: (enumLiteral_0= 'eventdriven' )
                    // InternalRoom.g:9422:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,125,FOLLOW_2); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9428:6: (enumLiteral_1= 'datadriven' )
                    {
                    // InternalRoom.g:9428:6: (enumLiteral_1= 'datadriven' )
                    // InternalRoom.g:9428:8: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,126,FOLLOW_2); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9434:6: (enumLiteral_2= 'async' )
                    {
                    // InternalRoom.g:9434:6: (enumLiteral_2= 'async' )
                    // InternalRoom.g:9434:8: enumLiteral_2= 'async'
                    {
                    enumLiteral_2=(Token)match(input,129,FOLLOW_2); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalRoom.g:9440:6: (enumLiteral_3= 'sync' )
                    {
                    // InternalRoom.g:9440:6: (enumLiteral_3= 'sync' )
                    // InternalRoom.g:9440:8: enumLiteral_3= 'sync'
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
    // InternalRoom.g:9450:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalRoom.g:9452:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // InternalRoom.g:9453:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // InternalRoom.g:9453:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt209=4;
            switch ( input.LA(1) ) {
            case 130:
                {
                alt209=1;
                }
                break;
            case 131:
                {
                alt209=2;
                }
                break;
            case 132:
                {
                alt209=3;
                }
                break;
            case 133:
                {
                alt209=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 209, 0, input);

                throw nvae;
            }

            switch (alt209) {
                case 1 :
                    // InternalRoom.g:9453:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // InternalRoom.g:9453:2: (enumLiteral_0= 'ptBoolean' )
                    // InternalRoom.g:9453:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,130,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9459:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // InternalRoom.g:9459:6: (enumLiteral_1= 'ptInteger' )
                    // InternalRoom.g:9459:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,131,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9465:6: (enumLiteral_2= 'ptReal' )
                    {
                    // InternalRoom.g:9465:6: (enumLiteral_2= 'ptReal' )
                    // InternalRoom.g:9465:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,132,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalRoom.g:9471:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // InternalRoom.g:9471:6: (enumLiteral_3= 'ptCharacter' )
                    // InternalRoom.g:9471:8: enumLiteral_3= 'ptCharacter'
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


    protected DFA143 dfa143 = new DFA143(this);
    protected DFA144 dfa144 = new DFA144(this);
    static final String dfa_1s = "\101\uffff";
    static final String dfa_2s = "\13\uffff\1\21\7\uffff\2\21\1\uffff\1\21\3\uffff\1\21\46\uffff";
    static final String dfa_3s = "\1\122\1\4\1\20\1\4\1\24\4\4\2\24\1\16\2\4\1\24\1\5\1\17\1\uffff\1\4\2\16\1\5\1\16\1\4\2\uffff\1\16\1\17\2\4\1\17\1\33\1\5\2\26\2\6\3\26\1\4\1\17\1\6\1\33\1\26\1\5\2\6\2\26\2\6\3\26\2\6\1\26\1\6\1\26\4\6\1\26";
    static final String dfa_4s = "\1\122\2\20\1\146\1\31\2\4\1\146\1\4\2\24\1\144\2\4\1\24\1\44\1\155\1\uffff\1\4\2\144\1\44\1\144\1\4\2\uffff\1\144\1\155\2\4\1\155\1\33\1\172\2\32\2\6\1\111\2\32\1\4\1\155\1\6\1\33\1\174\3\172\2\32\2\6\1\111\2\32\2\6\1\32\1\6\1\174\2\172\2\6\1\32";
    static final String dfa_5s = "\21\uffff\1\2\6\uffff\1\1\1\3\47\uffff";
    static final String dfa_6s = "\101\uffff}>";
    static final String[] dfa_7s = {
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
            "\1\20\1\21\11\uffff\1\22\11\uffff\1\17\55\uffff\2\21\5\uffff\6\21\6\uffff\1\21",
            "\1\23",
            "\1\24",
            "\1\7",
            "\1\25\36\uffff\1\26",
            "\1\21\117\uffff\1\21\1\30\1\uffff\1\30\1\31\11\uffff\1\27",
            "",
            "\1\32",
            "\1\20\1\21\23\uffff\1\17\55\uffff\2\21\5\uffff\6\21\6\uffff\1\21",
            "\1\20\1\21\23\uffff\1\17\55\uffff\2\21\5\uffff\6\21\6\uffff\1\21",
            "\1\25\36\uffff\1\26",
            "\1\20\1\21\101\uffff\2\21\5\uffff\6\21\6\uffff\1\21",
            "\1\33",
            "",
            "",
            "\1\20\1\21\23\uffff\1\17\55\uffff\2\21\5\uffff\6\21\6\uffff\1\21",
            "\1\21\5\uffff\1\35\63\uffff\1\34\25\uffff\1\21\2\uffff\1\30\1\31\11\uffff\1\27",
            "\1\36",
            "\1\37",
            "\1\21\5\uffff\1\35\63\uffff\1\34\25\uffff\1\21\2\uffff\1\30\1\31\11\uffff\1\27",
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
            "\1\21\117\uffff\1\21\2\uffff\1\30\1\31\11\uffff\1\27",
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

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA143 extends DFA {

        public DFA143(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 143;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "6317:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )";
        }
    }
    static final String dfa_8s = "\31\uffff";
    static final String dfa_9s = "\1\122\1\4\1\20\1\4\1\24\4\4\2\24\1\16\2\4\1\24\1\5\1\140\1\4\2\16\1\5\1\16\2\uffff\1\16";
    static final String dfa_10s = "\1\122\2\20\1\146\1\31\2\4\1\146\1\4\2\24\1\43\2\4\1\24\1\44\1\155\1\4\2\43\1\44\1\16\2\uffff\1\43";
    static final String dfa_11s = "\26\uffff\1\1\1\2\1\uffff";
    static final String dfa_12s = "\31\uffff}>";
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
            "\1\20\12\uffff\1\21\11\uffff\1\17",
            "\1\22",
            "\1\23",
            "\1\7",
            "\1\24\36\uffff\1\25",
            "\1\26\1\uffff\1\27\12\uffff\1\27",
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

    class DFA144 extends DFA {

        public DFA144(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 144;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "6367:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000800004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0182080031088000L,0xE00860000000000AL,0x0000000000000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0182080031088000L,0xE00840000000000AL,0x0000000000000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0182080031088000L,0xE00040000000000AL,0x0000000000000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0182080031088000L,0xE00000000000000AL,0x0000000000000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000000003CL});
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
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000140L,0x0600000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000800800002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000840004000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040004000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000066780008000L,0x0000200000000000L});
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
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0001700380008000L,0x0000240000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x000170030000C080L,0x0000040000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0001700300008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x000170020000C080L,0x0000040000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0001700200008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x000170000000C080L,0x0000040000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0001700000008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0018000000008000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0001600000008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0001400000008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0001000000008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0004000000008000L,0x0000200000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0004000000008000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000800200002L,0x0000200000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000800000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0060066400008000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x004006640000C080L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0040066400008000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0180000000000000L,0xE000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0E00000000008000L,0x0000200000000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x9001000000008000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0C00000000008000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0xF001066780008000L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0xF00106670000C080L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0xF001066700008000L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0xF00106660000C080L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0xF001066600008000L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0xF00106640000C080L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0xF001066400008000L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0800000000008000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000066000008000L,0x0000200000080000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000066000008000L,0x0000000000080000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000008000L,0x0000200000000884L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000884L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x9001000380008000L,0x00012000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x900100030000C080L,0x00010000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x9001000300008000L,0x00010000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x900100020000C080L,0x00010000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x9001000200008000L,0x00010000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x900100000000C080L,0x00010000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x9001000000008000L,0x00010000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000020L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000040000L,0x0000000000002000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000000040L,0x0000000000008000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000008000L,0x000000103F060000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000800004002L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000008000L,0x0000200000F00000L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x000000000000C080L,0x0000000000E00000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000000000008000L,0x0000000000E00000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x000000000000C080L,0x0000000000C00000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000008000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x000000000000C080L,0x0000000000800000L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000000008000L,0x0000000000800000L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_123 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_124 = new BitSet(new long[]{0x0000000000000010L,0x0000006000000000L});
    public static final BitSet FOLLOW_125 = new BitSet(new long[]{0x0000000000008000L,0x0000200080000000L});
    public static final BitSet FOLLOW_126 = new BitSet(new long[]{0x000000000000C080L});
    public static final BitSet FOLLOW_127 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_128 = new BitSet(new long[]{0x0000000000000000L,0x0000208000000000L});
    public static final BitSet FOLLOW_129 = new BitSet(new long[]{0x0000000000008000L,0x0000000200000000L});
    public static final BitSet FOLLOW_130 = new BitSet(new long[]{0x0000000000008000L,0x0000000080000000L});
    public static final BitSet FOLLOW_131 = new BitSet(new long[]{0x0000000000000000L,0x0000200400000000L});
    public static final BitSet FOLLOW_132 = new BitSet(new long[]{0x000000000000C080L,0x0000000080000000L});
    public static final BitSet FOLLOW_133 = new BitSet(new long[]{0x0000000000000000L,0x0000200800000000L});
    public static final BitSet FOLLOW_134 = new BitSet(new long[]{0x0000000000000000L,0x0000200080000000L});
    public static final BitSet FOLLOW_135 = new BitSet(new long[]{0x0000000000000000L,0x0000030400000000L});
    public static final BitSet FOLLOW_136 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_137 = new BitSet(new long[]{0x0000000000008000L,0x0000180000000000L});
    public static final BitSet FOLLOW_138 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_139 = new BitSet(new long[]{0x0000000000200000L,0x0000180000000000L});
    public static final BitSet FOLLOW_140 = new BitSet(new long[]{0x0000000000000000L,0x0000180000000000L});
    public static final BitSet FOLLOW_141 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_142 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_143 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_144 = new BitSet(new long[]{0x0000000000000160L,0x0780000000000000L});
    public static final BitSet FOLLOW_145 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_146 = new BitSet(new long[]{0x1112080020006000L,0x000000000007000AL});
    public static final BitSet FOLLOW_147 = new BitSet(new long[]{0x0000000000008000L,0x0003000000000000L});
    public static final BitSet FOLLOW_148 = new BitSet(new long[]{0x1112080020002000L,0x000000000007000AL});
    public static final BitSet FOLLOW_149 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_150 = new BitSet(new long[]{0x0000000000000010L,0x0020000000000000L});
    public static final BitSet FOLLOW_151 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_152 = new BitSet(new long[]{0x0000000000000002L,0x0040000000000000L});
    public static final BitSet FOLLOW_153 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_154 = new BitSet(new long[]{0x0000000000000000L,0x1800000000000000L});
    public static final BitSet FOLLOW_155 = new BitSet(new long[]{0x0000000000000040L,0x0600000000000000L});
    public static final BitSet FOLLOW_156 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});

}
