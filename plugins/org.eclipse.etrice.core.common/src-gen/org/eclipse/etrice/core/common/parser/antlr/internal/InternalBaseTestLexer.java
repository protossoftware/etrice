package org.eclipse.etrice.core.common.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBaseTestLexer extends Lexer {
    public static final int RULE_HEX=7;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int RULE_CC_STRING=8;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalBaseTestLexer() {;} 
    public InternalBaseTestLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBaseTestLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalBaseTest.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:11:7: ( '@' )
            // InternalBaseTest.g:11:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:12:7: ( '(' )
            // InternalBaseTest.g:12:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:13:7: ( ',' )
            // InternalBaseTest.g:13:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:14:7: ( ')' )
            // InternalBaseTest.g:14:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:15:7: ( '=' )
            // InternalBaseTest.g:15:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:16:7: ( 'AnnotationType' )
            // InternalBaseTest.g:16:9: 'AnnotationType'
            {
            match("AnnotationType"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:17:7: ( '{' )
            // InternalBaseTest.g:17:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:18:7: ( 'target' )
            // InternalBaseTest.g:18:9: 'target'
            {
            match("target"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:19:7: ( '}' )
            // InternalBaseTest.g:19:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:20:7: ( 'optional' )
            // InternalBaseTest.g:20:9: 'optional'
            {
            match("optional"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:21:7: ( 'mandatory' )
            // InternalBaseTest.g:21:9: 'mandatory'
            {
            match("mandatory"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:22:7: ( 'attribute' )
            // InternalBaseTest.g:22:9: 'attribute'
            {
            match("attribute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:23:7: ( ':' )
            // InternalBaseTest.g:23:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:24:7: ( '.*' )
            // InternalBaseTest.g:24:9: '.*'
            {
            match(".*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:25:7: ( '[' )
            // InternalBaseTest.g:25:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:26:7: ( ']' )
            // InternalBaseTest.g:26:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:27:7: ( 'false' )
            // InternalBaseTest.g:27:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:28:7: ( 'true' )
            // InternalBaseTest.g:28:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:29:7: ( '+' )
            // InternalBaseTest.g:29:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:30:7: ( '-' )
            // InternalBaseTest.g:30:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:31:7: ( '.' )
            // InternalBaseTest.g:31:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:32:7: ( 'e' )
            // InternalBaseTest.g:32:9: 'e'
            {
            match('e'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:33:7: ( 'E' )
            // InternalBaseTest.g:33:9: 'E'
            {
            match('E'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:34:7: ( 'ptBoolean' )
            // InternalBaseTest.g:34:9: 'ptBoolean'
            {
            match("ptBoolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:35:7: ( 'ptInteger' )
            // InternalBaseTest.g:35:9: 'ptInteger'
            {
            match("ptInteger"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:36:7: ( 'ptReal' )
            // InternalBaseTest.g:36:9: 'ptReal'
            {
            match("ptReal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:37:7: ( 'ptCharacter' )
            // InternalBaseTest.g:37:9: 'ptCharacter'
            {
            match("ptCharacter"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:1398:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // InternalBaseTest.g:1398:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            // InternalBaseTest.g:1398:12: ( '0x' | '0X' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='0') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='x') ) {
                    alt1=1;
                }
                else if ( (LA1_1=='X') ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalBaseTest.g:1398:13: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // InternalBaseTest.g:1398:18: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // InternalBaseTest.g:1398:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='F')||(LA2_0>='a' && LA2_0<='f')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBaseTest.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_CC_STRING"
    public final void mRULE_CC_STRING() throws RecognitionException {
        try {
            int _type = RULE_CC_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:1400:16: ( '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\'' )
            // InternalBaseTest.g:1400:18: '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\''
            {
            match("'''"); 

            // InternalBaseTest.g:1400:27: ( options {greedy=false; } : . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\'') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='\'') ) {
                        int LA3_3 = input.LA(3);

                        if ( (LA3_3=='\'') ) {
                            alt3=2;
                        }
                        else if ( ((LA3_3>='\u0000' && LA3_3<='&')||(LA3_3>='(' && LA3_3<='\uFFFF')) ) {
                            alt3=1;
                        }


                    }
                    else if ( ((LA3_1>='\u0000' && LA3_1<='&')||(LA3_1>='(' && LA3_1<='\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBaseTest.g:1400:55: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match("'''"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CC_STRING"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:1402:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalBaseTest.g:1402:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalBaseTest.g:1402:11: ( '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='^') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBaseTest.g:1402:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalBaseTest.g:1402:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBaseTest.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:1404:10: ( ( '0' .. '9' )+ )
            // InternalBaseTest.g:1404:12: ( '0' .. '9' )+
            {
            // InternalBaseTest.g:1404:12: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBaseTest.g:1404:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:1406:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalBaseTest.g:1406:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalBaseTest.g:1406:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\"') ) {
                alt9=1;
            }
            else if ( (LA9_0=='\'') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalBaseTest.g:1406:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalBaseTest.g:1406:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalBaseTest.g:1406:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBaseTest.g:1406:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalBaseTest.g:1406:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalBaseTest.g:1406:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalBaseTest.g:1406:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBaseTest.g:1406:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:1408:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalBaseTest.g:1408:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalBaseTest.g:1408:24: ( options {greedy=false; } : . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='*') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='/') ) {
                        alt10=2;
                    }
                    else if ( ((LA10_1>='\u0000' && LA10_1<='.')||(LA10_1>='0' && LA10_1<='\uFFFF')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<=')')||(LA10_0>='+' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalBaseTest.g:1408:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:1410:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalBaseTest.g:1410:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalBaseTest.g:1410:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBaseTest.g:1410:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalBaseTest.g:1410:40: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalBaseTest.g:1410:41: ( '\\r' )? '\\n'
                    {
                    // InternalBaseTest.g:1410:41: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalBaseTest.g:1410:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:1412:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalBaseTest.g:1412:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalBaseTest.g:1412:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalBaseTest.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBaseTest.g:1414:16: ( . )
            // InternalBaseTest.g:1414:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalBaseTest.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | RULE_HEX | RULE_CC_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt15=36;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // InternalBaseTest.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalBaseTest.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalBaseTest.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalBaseTest.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalBaseTest.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalBaseTest.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalBaseTest.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalBaseTest.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalBaseTest.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalBaseTest.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalBaseTest.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalBaseTest.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalBaseTest.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalBaseTest.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalBaseTest.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalBaseTest.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalBaseTest.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalBaseTest.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalBaseTest.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // InternalBaseTest.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // InternalBaseTest.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // InternalBaseTest.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // InternalBaseTest.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // InternalBaseTest.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // InternalBaseTest.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // InternalBaseTest.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // InternalBaseTest.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // InternalBaseTest.g:1:172: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 29 :
                // InternalBaseTest.g:1:181: RULE_CC_STRING
                {
                mRULE_CC_STRING(); 

                }
                break;
            case 30 :
                // InternalBaseTest.g:1:196: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 31 :
                // InternalBaseTest.g:1:204: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 32 :
                // InternalBaseTest.g:1:213: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 33 :
                // InternalBaseTest.g:1:225: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 34 :
                // InternalBaseTest.g:1:241: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 35 :
                // InternalBaseTest.g:1:257: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 36 :
                // InternalBaseTest.g:1:265: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\6\uffff\1\46\1\uffff\1\46\1\uffff\3\46\1\uffff\1\60\2\uffff\1\46\2\uffff\1\66\1\67\1\46\1\72\2\37\2\uffff\2\37\7\uffff\1\46\2\uffff\2\46\1\uffff\3\46\5\uffff\1\46\4\uffff\1\46\2\uffff\1\74\4\uffff\13\46\1\uffff\2\46\1\131\12\46\1\uffff\3\46\1\147\5\46\1\155\3\46\1\uffff\2\46\1\163\2\46\1\uffff\5\46\1\uffff\2\46\1\175\6\46\1\uffff\1\u0084\1\u0085\1\u0086\1\u0087\2\46\4\uffff\2\46\1\u008c\1\46\1\uffff\1\46\1\u008f\1\uffff";
    static final String DFA15_eofS =
        "\u0090\uffff";
    static final String DFA15_minS =
        "\1\0\5\uffff\1\156\1\uffff\1\141\1\uffff\1\160\1\141\1\164\1\uffff\1\52\2\uffff\1\141\2\uffff\2\60\1\164\1\130\1\0\1\101\2\uffff\1\0\1\52\7\uffff\1\156\2\uffff\1\162\1\165\1\uffff\1\164\1\156\1\164\5\uffff\1\154\4\uffff\1\102\2\uffff\1\47\4\uffff\1\157\1\147\1\145\1\151\1\144\1\162\1\163\1\157\1\156\1\145\1\150\1\uffff\1\164\1\145\1\60\1\157\1\141\1\151\1\145\1\157\1\164\3\141\1\164\1\uffff\1\156\1\164\1\142\1\60\1\154\1\145\1\154\1\162\1\164\1\60\1\141\1\157\1\165\1\uffff\1\145\1\147\1\60\1\141\1\151\1\uffff\1\154\1\162\1\164\1\141\1\145\1\uffff\1\143\1\157\1\60\1\171\1\145\1\156\1\162\1\164\1\156\1\uffff\4\60\1\145\1\124\4\uffff\1\162\1\171\1\60\1\160\1\uffff\1\145\1\60\1\uffff";
    static final String DFA15_maxS =
        "\1\uffff\5\uffff\1\156\1\uffff\1\162\1\uffff\1\160\1\141\1\164\1\uffff\1\52\2\uffff\1\141\2\uffff\2\172\1\164\1\170\1\uffff\1\172\2\uffff\1\uffff\1\57\7\uffff\1\156\2\uffff\1\162\1\165\1\uffff\1\164\1\156\1\164\5\uffff\1\154\4\uffff\1\122\2\uffff\1\47\4\uffff\1\157\1\147\1\145\1\151\1\144\1\162\1\163\1\157\1\156\1\145\1\150\1\uffff\1\164\1\145\1\172\1\157\1\141\1\151\1\145\1\157\1\164\3\141\1\164\1\uffff\1\156\1\164\1\142\1\172\1\154\1\145\1\154\1\162\1\164\1\172\1\141\1\157\1\165\1\uffff\1\145\1\147\1\172\1\141\1\151\1\uffff\1\154\1\162\1\164\1\141\1\145\1\uffff\1\143\1\157\1\172\1\171\1\145\1\156\1\162\1\164\1\156\1\uffff\4\172\1\145\1\124\4\uffff\1\162\1\171\1\172\1\160\1\uffff\1\145\1\172\1\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\uffff\1\11\3\uffff\1\15\1\uffff\1\17\1\20\1\uffff\1\23\1\24\6\uffff\1\36\1\37\2\uffff\1\43\1\44\1\1\1\2\1\3\1\4\1\5\1\uffff\1\36\1\7\2\uffff\1\11\3\uffff\1\15\1\16\1\25\1\17\1\20\1\uffff\1\23\1\24\1\26\1\27\1\uffff\1\34\1\37\1\uffff\1\40\1\41\1\42\1\43\13\uffff\1\35\15\uffff\1\22\15\uffff\1\21\5\uffff\1\10\5\uffff\1\32\11\uffff\1\12\6\uffff\1\13\1\14\1\30\1\31\4\uffff\1\33\2\uffff\1\6";
    static final String DFA15_specialS =
        "\1\1\27\uffff\1\0\3\uffff\1\2\163\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\37\2\36\2\37\1\36\22\37\1\36\1\37\1\34\4\37\1\30\1\2\1\4\1\37\1\22\1\3\1\23\1\16\1\35\1\27\11\33\1\15\2\37\1\5\2\37\1\1\1\6\3\32\1\25\25\32\1\17\1\37\1\20\1\31\1\32\1\37\1\14\3\32\1\24\1\21\6\32\1\13\1\32\1\12\1\26\3\32\1\10\6\32\1\7\1\37\1\11\uff82\37",
            "",
            "",
            "",
            "",
            "",
            "\1\45",
            "",
            "\1\50\20\uffff\1\51",
            "",
            "\1\53",
            "\1\54",
            "\1\55",
            "",
            "\1\57",
            "",
            "",
            "\1\63",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\70",
            "\1\71\37\uffff\1\71",
            "\47\74\1\73\uffd8\74",
            "\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "\0\74",
            "\1\75\4\uffff\1\76",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\100",
            "",
            "",
            "\1\101",
            "\1\102",
            "",
            "\1\103",
            "\1\104",
            "\1\105",
            "",
            "",
            "",
            "",
            "",
            "\1\106",
            "",
            "",
            "",
            "",
            "\1\107\1\112\5\uffff\1\110\10\uffff\1\111",
            "",
            "",
            "\1\113",
            "",
            "",
            "",
            "",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "",
            "\1\127",
            "\1\130",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "",
            "\1\144",
            "\1\145",
            "\1\146",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\156",
            "\1\157",
            "\1\160",
            "",
            "\1\161",
            "\1\162",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\164",
            "\1\165",
            "",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "",
            "\1\173",
            "\1\174",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0088",
            "\1\u0089",
            "",
            "",
            "",
            "",
            "\1\u008a",
            "\1\u008b",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u008d",
            "",
            "\1\u008e",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | RULE_HEX | RULE_CC_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_24 = input.LA(1);

                        s = -1;
                        if ( (LA15_24=='\'') ) {s = 59;}

                        else if ( ((LA15_24>='\u0000' && LA15_24<='&')||(LA15_24>='(' && LA15_24<='\uFFFF')) ) {s = 60;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_0 = input.LA(1);

                        s = -1;
                        if ( (LA15_0=='@') ) {s = 1;}

                        else if ( (LA15_0=='(') ) {s = 2;}

                        else if ( (LA15_0==',') ) {s = 3;}

                        else if ( (LA15_0==')') ) {s = 4;}

                        else if ( (LA15_0=='=') ) {s = 5;}

                        else if ( (LA15_0=='A') ) {s = 6;}

                        else if ( (LA15_0=='{') ) {s = 7;}

                        else if ( (LA15_0=='t') ) {s = 8;}

                        else if ( (LA15_0=='}') ) {s = 9;}

                        else if ( (LA15_0=='o') ) {s = 10;}

                        else if ( (LA15_0=='m') ) {s = 11;}

                        else if ( (LA15_0=='a') ) {s = 12;}

                        else if ( (LA15_0==':') ) {s = 13;}

                        else if ( (LA15_0=='.') ) {s = 14;}

                        else if ( (LA15_0=='[') ) {s = 15;}

                        else if ( (LA15_0==']') ) {s = 16;}

                        else if ( (LA15_0=='f') ) {s = 17;}

                        else if ( (LA15_0=='+') ) {s = 18;}

                        else if ( (LA15_0=='-') ) {s = 19;}

                        else if ( (LA15_0=='e') ) {s = 20;}

                        else if ( (LA15_0=='E') ) {s = 21;}

                        else if ( (LA15_0=='p') ) {s = 22;}

                        else if ( (LA15_0=='0') ) {s = 23;}

                        else if ( (LA15_0=='\'') ) {s = 24;}

                        else if ( (LA15_0=='^') ) {s = 25;}

                        else if ( ((LA15_0>='B' && LA15_0<='D')||(LA15_0>='F' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='b' && LA15_0<='d')||(LA15_0>='g' && LA15_0<='l')||LA15_0=='n'||(LA15_0>='q' && LA15_0<='s')||(LA15_0>='u' && LA15_0<='z')) ) {s = 26;}

                        else if ( ((LA15_0>='1' && LA15_0<='9')) ) {s = 27;}

                        else if ( (LA15_0=='\"') ) {s = 28;}

                        else if ( (LA15_0=='/') ) {s = 29;}

                        else if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {s = 30;}

                        else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='#' && LA15_0<='&')||LA15_0=='*'||(LA15_0>=';' && LA15_0<='<')||(LA15_0>='>' && LA15_0<='?')||LA15_0=='\\'||LA15_0=='`'||LA15_0=='|'||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {s = 31;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_28 = input.LA(1);

                        s = -1;
                        if ( ((LA15_28>='\u0000' && LA15_28<='\uFFFF')) ) {s = 60;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}