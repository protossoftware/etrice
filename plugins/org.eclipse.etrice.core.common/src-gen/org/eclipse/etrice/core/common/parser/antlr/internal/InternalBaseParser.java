package org.eclipse.etrice.core.common.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.etrice.core.common.services.BaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBaseParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_HEX", "RULE_EXP", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "','", "'false'", "'true'", "'+'", "'-'", "'.'"
    };
    public static final int RULE_ID=8;
    public static final int RULE_EXP=7;
    public static final int RULE_HEX=6;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_INT=5;
    public static final int RULE_WS=11;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;

    // delegates
    // delegators


        public InternalBaseParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBaseParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBaseParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g"; }



     	private BaseGrammarAccess grammarAccess;
     	
        public InternalBaseParser(TokenStream input, BaseGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "LiteralArray";	
       	}
       	
       	@Override
       	protected BaseGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleLiteralArray"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:67:1: entryRuleLiteralArray returns [EObject current=null] : iv_ruleLiteralArray= ruleLiteralArray EOF ;
    public final EObject entryRuleLiteralArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralArray = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:68:2: (iv_ruleLiteralArray= ruleLiteralArray EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:69:2: iv_ruleLiteralArray= ruleLiteralArray EOF
            {
             newCompositeNode(grammarAccess.getLiteralArrayRule()); 
            pushFollow(FOLLOW_ruleLiteralArray_in_entryRuleLiteralArray75);
            iv_ruleLiteralArray=ruleLiteralArray();

            state._fsp--;

             current =iv_ruleLiteralArray; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralArray85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralArray"


    // $ANTLR start "ruleLiteralArray"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:76:1: ruleLiteralArray returns [EObject current=null] : ( ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )* ) ;
    public final EObject ruleLiteralArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_literals_0_0 = null;

        EObject lv_literals_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:79:28: ( ( ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )* ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:80:1: ( ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )* )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:80:1: ( ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )* )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:80:2: ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )*
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:80:2: ( (lv_literals_0_0= ruleLiteral ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:81:1: (lv_literals_0_0= ruleLiteral )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:81:1: (lv_literals_0_0= ruleLiteral )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:82:3: lv_literals_0_0= ruleLiteral
            {
             
            	        newCompositeNode(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteral_in_ruleLiteralArray131);
            lv_literals_0_0=ruleLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLiteralArrayRule());
            	        }
                   		add(
                   			current, 
                   			"literals",
                    		lv_literals_0_0, 
                    		"Literal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:98:2: (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:98:4: otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) )
            	    {
            	    otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleLiteralArray144); 

            	        	newLeafNode(otherlv_1, grammarAccess.getLiteralArrayAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:102:1: ( (lv_literals_2_0= ruleLiteral ) )
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:103:1: (lv_literals_2_0= ruleLiteral )
            	    {
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:103:1: (lv_literals_2_0= ruleLiteral )
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:104:3: lv_literals_2_0= ruleLiteral
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLiteral_in_ruleLiteralArray165);
            	    lv_literals_2_0=ruleLiteral();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLiteralArrayRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"literals",
            	            		lv_literals_2_0, 
            	            		"Literal");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "ruleLiteralArray"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:128:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:129:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:130:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral203);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral213); 

            }

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:137:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:140:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:141:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:141:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 14:
            case 15:
                {
                alt2=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 16:
            case 17:
            case 18:
                {
                alt2=2;
                }
                break;
            case RULE_STRING:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:142:5: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral260);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:152:5: this_NumberLiteral_1= ruleNumberLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleLiteral287);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:162:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral314);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:178:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:179:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:180:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral349);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral359); 

            }

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:187:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:190:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:191:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:191:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:191:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:191:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:192:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:197:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:197:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleBooleanLiteral406); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:202:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:202:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:203:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:203:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:204:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,15,FOLLOW_15_in_ruleBooleanLiteral430); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:225:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:226:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:227:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral480);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral490); 

            }

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:234:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:237:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:238:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:238:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt4=2;
            switch ( input.LA(1) ) {
            case 16:
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==18) ) {
                    alt4=2;
                }
                else if ( (LA4_1==RULE_INT) ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3==18) ) {
                        alt4=2;
                    }
                    else if ( (LA4_3==EOF||LA4_3==13) ) {
                        alt4=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==RULE_INT) ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3==18) ) {
                        alt4=2;
                    }
                    else if ( (LA4_3==EOF||LA4_3==13) ) {
                        alt4=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA4_2==18) ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA4_3 = input.LA(2);

                if ( (LA4_3==18) ) {
                    alt4=2;
                }
                else if ( (LA4_3==EOF||LA4_3==13) ) {
                    alt4=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt4=1;
                }
                break;
            case 18:
                {
                alt4=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:239:5: this_IntLiteral_0= ruleIntLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntLiteral_in_ruleNumberLiteral537);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;

                     
                            current = this_IntLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:249:5: this_RealLiteral_1= ruleRealLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumberLiteral564);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:265:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:266:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:267:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral599);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral609); 

            }

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:274:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:277:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:278:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:278:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:278:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:278:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:279:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:284:2: ( (lv_value_1_0= ruleReal ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:285:1: (lv_value_1_0= ruleReal )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:285:1: (lv_value_1_0= ruleReal )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:286:3: lv_value_1_0= ruleReal
            {
             
            	        newCompositeNode(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReal_in_ruleRealLiteral664);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:310:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:311:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:312:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral700);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral710); 

            }

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:319:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:322:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:323:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:323:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:323:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:323:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:324:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:329:2: ( (lv_value_1_0= ruleInteger ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:330:1: (lv_value_1_0= ruleInteger )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:330:1: (lv_value_1_0= ruleInteger )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:331:3: lv_value_1_0= ruleInteger
            {
             
            	        newCompositeNode(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInteger_in_ruleIntLiteral765);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:355:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:356:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:357:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral801);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral811); 

            }

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:364:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:367:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:368:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:368:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:368:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:368:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:369:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:374:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:375:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:375:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:376:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral862); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:400:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:401:2: (iv_ruleInteger= ruleInteger EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:402:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger904);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger915); 

            }

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:409:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_SignedInteger_0 = null;

        AntlrDatatypeRuleToken this_Hexadecimal_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:412:28: ( (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:413:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:413:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT||(LA5_0>=16 && LA5_0<=17)) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_HEX) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:414:5: this_SignedInteger_0= ruleSignedInteger
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSignedInteger_in_ruleInteger962);
                    this_SignedInteger_0=ruleSignedInteger();

                    state._fsp--;


                    		current.merge(this_SignedInteger_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:426:5: this_Hexadecimal_1= ruleHexadecimal
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleHexadecimal_in_ruleInteger995);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:444:1: entryRuleSignedInteger returns [String current=null] : iv_ruleSignedInteger= ruleSignedInteger EOF ;
    public final String entryRuleSignedInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInteger = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:448:2: (iv_ruleSignedInteger= ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:449:2: iv_ruleSignedInteger= ruleSignedInteger EOF
            {
             newCompositeNode(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger1047);
            iv_ruleSignedInteger=ruleSignedInteger();

            state._fsp--;

             current =iv_ruleSignedInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger1058); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:459:1: ruleSignedInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:463:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:464:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:464:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:464:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:464:2: (kw= '+' | kw= '-' )?
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:465:2: kw= '+'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSignedInteger1101); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:472:2: kw= '-'
                    {
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleSignedInteger1120); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSignedInteger1137); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:495:1: entryRuleHexadecimal returns [String current=null] : iv_ruleHexadecimal= ruleHexadecimal EOF ;
    public final String entryRuleHexadecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHexadecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:499:2: (iv_ruleHexadecimal= ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:500:2: iv_ruleHexadecimal= ruleHexadecimal EOF
            {
             newCompositeNode(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal1193);
            iv_ruleHexadecimal=ruleHexadecimal();

            state._fsp--;

             current =iv_ruleHexadecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal1204); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:510:1: ruleHexadecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_HEX_0= RULE_HEX ;
    public final AntlrDatatypeRuleToken ruleHexadecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:514:28: (this_HEX_0= RULE_HEX )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:515:5: this_HEX_0= RULE_HEX
            {
            this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal1247); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:533:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:534:2: (iv_ruleReal= ruleReal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:535:2: iv_ruleReal= ruleReal EOF
            {
             newCompositeNode(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal1296);
            iv_ruleReal=ruleReal();

            state._fsp--;

             current =iv_ruleReal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal1307); 

            }

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:542:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DotDecimal_1 = null;

        AntlrDatatypeRuleToken this_DecimalDot_2 = null;

        AntlrDatatypeRuleToken this_DecimalExp_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:545:28: ( (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:546:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:546:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            int alt7=4;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:547:5: this_Decimal_0= ruleDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDecimal_in_ruleReal1354);
                    this_Decimal_0=ruleDecimal();

                    state._fsp--;


                    		current.merge(this_Decimal_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:559:5: this_DotDecimal_1= ruleDotDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDotDecimal_in_ruleReal1387);
                    this_DotDecimal_1=ruleDotDecimal();

                    state._fsp--;


                    		current.merge(this_DotDecimal_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:571:5: this_DecimalDot_2= ruleDecimalDot
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalDot_in_ruleReal1420);
                    this_DecimalDot_2=ruleDecimalDot();

                    state._fsp--;


                    		current.merge(this_DecimalDot_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:583:5: this_DecimalExp_3= ruleDecimalExp
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDecimalExp_in_ruleReal1453);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:601:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:605:2: (iv_ruleDecimal= ruleDecimal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:606:2: iv_ruleDecimal= ruleDecimal EOF
            {
             newCompositeNode(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal1505);
            iv_ruleDecimal=ruleDecimal();

            state._fsp--;

             current =iv_ruleDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal1516); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:616:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:620:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:621:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:621:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:621:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:621:2: (kw= '+' | kw= '-' )?
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            else if ( (LA8_0==17) ) {
                alt8=2;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:622:2: kw= '+'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleDecimal1559); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:629:2: kw= '-'
                    {
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleDecimal1578); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal1595); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,18,FOLLOW_18_in_ruleDecimal1613); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal1628); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:665:1: entryRuleDotDecimal returns [String current=null] : iv_ruleDotDecimal= ruleDotDecimal EOF ;
    public final String entryRuleDotDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDotDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:669:2: (iv_ruleDotDecimal= ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:670:2: iv_ruleDotDecimal= ruleDotDecimal EOF
            {
             newCompositeNode(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1684);
            iv_ruleDotDecimal=ruleDotDecimal();

            state._fsp--;

             current =iv_ruleDotDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal1695); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:680:1: ruleDotDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDotDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_3=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:684:28: ( ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:685:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:685:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:685:2: (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:685:2: (kw= '+' | kw= '-' )?
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            else if ( (LA9_0==17) ) {
                alt9=2;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:686:2: kw= '+'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleDotDecimal1738); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:693:2: kw= '-'
                    {
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleDotDecimal1757); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,18,FOLLOW_18_in_ruleDotDecimal1772); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDotDecimal1787); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:722:1: entryRuleDecimalDot returns [String current=null] : iv_ruleDecimalDot= ruleDecimalDot EOF ;
    public final String entryRuleDecimalDot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalDot = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:726:2: (iv_ruleDecimalDot= ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:727:2: iv_ruleDecimalDot= ruleDecimalDot EOF
            {
             newCompositeNode(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1843);
            iv_ruleDecimalDot=ruleDecimalDot();

            state._fsp--;

             current =iv_ruleDecimalDot.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot1854); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:737:1: ruleDecimalDot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) ;
    public final AntlrDatatypeRuleToken ruleDecimalDot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:741:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:742:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:742:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:742:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.'
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:742:2: (kw= '+' | kw= '-' )?
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) ) {
                alt10=1;
            }
            else if ( (LA10_0==17) ) {
                alt10=2;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:743:2: kw= '+'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleDecimalDot1897); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:750:2: kw= '-'
                    {
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleDecimalDot1916); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalDot1933); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,18,FOLLOW_18_in_ruleDecimalDot1951); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:779:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:783:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:784:2: iv_ruleDecimalExp= ruleDecimalExp EOF
            {
             newCompositeNode(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp2002);
            iv_ruleDecimalExp=ruleDecimalExp();

            state._fsp--;

             current =iv_ruleDecimalExp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp2013); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:794:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_EXP_5=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:798:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:799:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:799:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:799:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:799:2: (kw= '+' | kw= '-' )?
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            else if ( (LA11_0==17) ) {
                alt11=2;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:800:2: kw= '+'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleDecimalExp2056); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:807:2: kw= '-'
                    {
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleDecimalExp2075); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp2092); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,18,FOLLOW_18_in_ruleDecimalExp2110); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp2125); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            this_EXP_5=(Token)match(input,RULE_EXP,FOLLOW_RULE_EXP_in_ruleDecimalExp2145); 

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

    // Delegated rules


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\12\uffff";
    static final String DFA7_eofS =
        "\5\uffff\1\7\1\10\3\uffff";
    static final String DFA7_minS =
        "\3\5\1\22\1\uffff\1\5\1\7\3\uffff";
    static final String DFA7_maxS =
        "\4\22\1\uffff\2\15\3\uffff";
    static final String DFA7_acceptS =
        "\4\uffff\1\2\2\uffff\1\3\1\1\1\4";
    static final String DFA7_specialS =
        "\12\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\3\12\uffff\1\1\1\2\1\4",
            "\1\3\14\uffff\1\4",
            "\1\3\14\uffff\1\4",
            "\1\5",
            "",
            "\1\6\7\uffff\1\7",
            "\1\11\5\uffff\1\10",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "546:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )";
        }
    }
 

    public static final BitSet FOLLOW_ruleLiteralArray_in_entryRuleLiteralArray75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralArray85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleLiteralArray131 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleLiteralArray144 = new BitSet(new long[]{0x000000000007C070L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleLiteralArray165 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleLiteral287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral349 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleBooleanLiteral406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleBooleanLiteral430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_ruleNumberLiteral537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumberLiteral564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_ruleRealLiteral664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral700 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_ruleIntLiteral765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral801 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger904 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_ruleInteger962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_ruleInteger995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger1047 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSignedInteger1101 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_17_in_ruleSignedInteger1120 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSignedInteger1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal1193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal1296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_ruleReal1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_ruleReal1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_ruleReal1420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_ruleReal1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal1505 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDecimal1559 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_17_in_ruleDecimal1578 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal1595 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDecimal1613 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDotDecimal1738 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_17_in_ruleDotDecimal1757 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDotDecimal1772 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDotDecimal1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot1854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDecimalDot1897 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_17_in_ruleDecimalDot1916 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalDot1933 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDecimalDot1951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp2002 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDecimalExp2056 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_17_in_ruleDecimalExp2075 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp2092 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDecimalExp2110 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp2125 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_EXP_in_ruleDecimalExp2145 = new BitSet(new long[]{0x0000000000000002L});

}