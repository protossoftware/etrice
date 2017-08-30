package org.eclipse.etrice.core.common.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBaseLexer extends Lexer {
    public static final int RULE_HEX=7;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int RULE_CC_STRING=8;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__17=17;
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

    public InternalBaseLexer() {;} 
    public InternalBaseLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBaseLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalBase.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:11:7: ( '@' )
            // InternalBase.g:11:9: '@'
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
            // InternalBase.g:12:7: ( '(' )
            // InternalBase.g:12:9: '('
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
            // InternalBase.g:13:7: ( ',' )
            // InternalBase.g:13:9: ','
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
            // InternalBase.g:14:7: ( ')' )
            // InternalBase.g:14:9: ')'
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
            // InternalBase.g:15:7: ( '=' )
            // InternalBase.g:15:9: '='
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
            // InternalBase.g:16:7: ( 'optional' )
            // InternalBase.g:16:9: 'optional'
            {
            match("optional"); 


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
            // InternalBase.g:17:7: ( 'mandatory' )
            // InternalBase.g:17:9: 'mandatory'
            {
            match("mandatory"); 


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
            // InternalBase.g:18:7: ( 'attribute' )
            // InternalBase.g:18:9: 'attribute'
            {
            match("attribute"); 


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
            // InternalBase.g:19:7: ( ':' )
            // InternalBase.g:19:9: ':'
            {
            match(':'); 

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
            // InternalBase.g:20:7: ( '{' )
            // InternalBase.g:20:9: '{'
            {
            match('{'); 

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
            // InternalBase.g:21:7: ( '}' )
            // InternalBase.g:21:9: '}'
            {
            match('}'); 

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
            // InternalBase.g:22:7: ( '.*' )
            // InternalBase.g:22:9: '.*'
            {
            match(".*"); 


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
            // InternalBase.g:23:7: ( '[' )
            // InternalBase.g:23:9: '['
            {
            match('['); 

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
            // InternalBase.g:24:7: ( ']' )
            // InternalBase.g:24:9: ']'
            {
            match(']'); 

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
            // InternalBase.g:25:7: ( 'false' )
            // InternalBase.g:25:9: 'false'
            {
            match("false"); 


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
            // InternalBase.g:26:7: ( 'true' )
            // InternalBase.g:26:9: 'true'
            {
            match("true"); 


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
            // InternalBase.g:27:7: ( '+' )
            // InternalBase.g:27:9: '+'
            {
            match('+'); 

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
            // InternalBase.g:28:7: ( '-' )
            // InternalBase.g:28:9: '-'
            {
            match('-'); 

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
            // InternalBase.g:29:7: ( '.' )
            // InternalBase.g:29:9: '.'
            {
            match('.'); 

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
            // InternalBase.g:30:7: ( 'e' )
            // InternalBase.g:30:9: 'e'
            {
            match('e'); 

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
            // InternalBase.g:31:7: ( 'E' )
            // InternalBase.g:31:9: 'E'
            {
            match('E'); 

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
            // InternalBase.g:32:7: ( 'ptBoolean' )
            // InternalBase.g:32:9: 'ptBoolean'
            {
            match("ptBoolean"); 


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
            // InternalBase.g:33:7: ( 'ptInteger' )
            // InternalBase.g:33:9: 'ptInteger'
            {
            match("ptInteger"); 


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
            // InternalBase.g:34:7: ( 'ptReal' )
            // InternalBase.g:34:9: 'ptReal'
            {
            match("ptReal"); 


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
            // InternalBase.g:35:7: ( 'ptCharacter' )
            // InternalBase.g:35:9: 'ptCharacter'
            {
            match("ptCharacter"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:1181:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // InternalBase.g:1181:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            // InternalBase.g:1181:12: ( '0x' | '0X' )
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
                    // InternalBase.g:1181:13: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // InternalBase.g:1181:18: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // InternalBase.g:1181:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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
            	    // InternalBase.g:
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
            // InternalBase.g:1183:16: ( '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\'' )
            // InternalBase.g:1183:18: '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\''
            {
            match("'''"); 

            // InternalBase.g:1183:27: ( options {greedy=false; } : . )*
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
            	    // InternalBase.g:1183:55: .
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
            // InternalBase.g:1185:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalBase.g:1185:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalBase.g:1185:11: ( '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='^') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBase.g:1185:11: '^'
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

            // InternalBase.g:1185:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBase.g:
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
            // InternalBase.g:1187:10: ( ( '0' .. '9' )+ )
            // InternalBase.g:1187:12: ( '0' .. '9' )+
            {
            // InternalBase.g:1187:12: ( '0' .. '9' )+
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
            	    // InternalBase.g:1187:13: '0' .. '9'
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
            // InternalBase.g:1189:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalBase.g:1189:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalBase.g:1189:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalBase.g:1189:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalBase.g:1189:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalBase.g:1189:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBase.g:1189:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalBase.g:1189:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalBase.g:1189:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalBase.g:1189:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBase.g:1189:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalBase.g:1191:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalBase.g:1191:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalBase.g:1191:24: ( options {greedy=false; } : . )*
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
            	    // InternalBase.g:1191:52: .
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
            // InternalBase.g:1193:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalBase.g:1193:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalBase.g:1193:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBase.g:1193:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalBase.g:1193:40: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalBase.g:1193:41: ( '\\r' )? '\\n'
                    {
                    // InternalBase.g:1193:41: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalBase.g:1193:41: '\\r'
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
            // InternalBase.g:1195:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalBase.g:1195:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalBase.g:1195:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalBase.g:
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
            // InternalBase.g:1197:16: ( . )
            // InternalBase.g:1197:18: .
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
        // InternalBase.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | RULE_HEX | RULE_CC_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt15=34;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // InternalBase.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalBase.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalBase.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalBase.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalBase.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalBase.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalBase.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalBase.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalBase.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalBase.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalBase.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalBase.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalBase.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalBase.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalBase.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalBase.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalBase.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalBase.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalBase.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // InternalBase.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // InternalBase.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // InternalBase.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // InternalBase.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // InternalBase.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // InternalBase.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // InternalBase.g:1:160: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 27 :
                // InternalBase.g:1:169: RULE_CC_STRING
                {
                mRULE_CC_STRING(); 

                }
                break;
            case 28 :
                // InternalBase.g:1:184: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 29 :
                // InternalBase.g:1:192: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 30 :
                // InternalBase.g:1:201: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 31 :
                // InternalBase.g:1:213: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 32 :
                // InternalBase.g:1:229: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 33 :
                // InternalBase.g:1:245: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 34 :
                // InternalBase.g:1:253: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\6\uffff\3\45\3\uffff\1\54\2\uffff\2\45\2\uffff\1\63\1\64\1\45\1\67\2\36\2\uffff\2\36\7\uffff\1\45\1\uffff\2\45\7\uffff\2\45\4\uffff\1\45\2\uffff\1\71\4\uffff\11\45\1\uffff\4\45\1\124\7\45\1\134\1\uffff\7\45\1\uffff\2\45\1\146\6\45\1\uffff\1\45\1\156\5\45\1\uffff\1\164\1\165\1\166\1\167\1\45\4\uffff\1\45\1\172\1\uffff";
    static final String DFA15_eofS =
        "\173\uffff";
    static final String DFA15_minS =
        "\1\0\5\uffff\1\160\1\141\1\164\3\uffff\1\52\2\uffff\1\141\1\162\2\uffff\2\60\1\164\1\130\1\0\1\101\2\uffff\1\0\1\52\7\uffff\1\164\1\uffff\1\156\1\164\7\uffff\1\154\1\165\4\uffff\1\102\2\uffff\1\47\4\uffff\1\151\1\144\1\162\1\163\1\145\1\157\1\156\1\145\1\150\1\uffff\1\157\1\141\1\151\1\145\1\60\1\157\1\164\2\141\1\156\1\164\1\142\1\60\1\uffff\1\154\1\145\1\154\1\162\1\141\1\157\1\165\1\uffff\1\145\1\147\1\60\1\141\1\154\1\162\1\164\1\141\1\145\1\uffff\1\143\1\60\1\171\1\145\1\156\1\162\1\164\1\uffff\4\60\1\145\4\uffff\1\162\1\60\1\uffff";
    static final String DFA15_maxS =
        "\1\uffff\5\uffff\1\160\1\141\1\164\3\uffff\1\52\2\uffff\1\141\1\162\2\uffff\2\172\1\164\1\170\1\uffff\1\172\2\uffff\1\uffff\1\57\7\uffff\1\164\1\uffff\1\156\1\164\7\uffff\1\154\1\165\4\uffff\1\122\2\uffff\1\47\4\uffff\1\151\1\144\1\162\1\163\1\145\1\157\1\156\1\145\1\150\1\uffff\1\157\1\141\1\151\1\145\1\172\1\157\1\164\2\141\1\156\1\164\1\142\1\172\1\uffff\1\154\1\145\1\154\1\162\1\141\1\157\1\165\1\uffff\1\145\1\147\1\172\1\141\1\154\1\162\1\164\1\141\1\145\1\uffff\1\143\1\172\1\171\1\145\1\156\1\162\1\164\1\uffff\4\172\1\145\4\uffff\1\162\1\172\1\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\3\uffff\1\11\1\12\1\13\1\uffff\1\15\1\16\2\uffff\1\21\1\22\6\uffff\1\34\1\35\2\uffff\1\41\1\42\1\1\1\2\1\3\1\4\1\5\1\uffff\1\34\2\uffff\1\11\1\12\1\13\1\14\1\23\1\15\1\16\2\uffff\1\21\1\22\1\24\1\25\1\uffff\1\32\1\35\1\uffff\1\36\1\37\1\40\1\41\11\uffff\1\33\15\uffff\1\20\7\uffff\1\17\11\uffff\1\30\7\uffff\1\6\5\uffff\1\7\1\10\1\26\1\27\2\uffff\1\31";
    static final String DFA15_specialS =
        "\1\1\26\uffff\1\2\3\uffff\1\0\137\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\36\2\35\2\36\1\35\22\36\1\35\1\36\1\33\4\36\1\27\1\2\1\4\1\36\1\21\1\3\1\22\1\14\1\34\1\26\11\32\1\11\2\36\1\5\2\36\1\1\4\31\1\24\25\31\1\15\1\36\1\16\1\30\1\31\1\36\1\10\3\31\1\23\1\17\6\31\1\7\1\31\1\6\1\25\3\31\1\20\6\31\1\12\1\36\1\13\uff82\36",
            "",
            "",
            "",
            "",
            "",
            "\1\44",
            "\1\46",
            "\1\47",
            "",
            "",
            "",
            "\1\53",
            "",
            "",
            "\1\57",
            "\1\60",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\65",
            "\1\66\37\uffff\1\66",
            "\47\71\1\70\uffd8\71",
            "\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "\0\71",
            "\1\72\4\uffff\1\73",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\75",
            "",
            "\1\76",
            "\1\77",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\100",
            "\1\101",
            "",
            "",
            "",
            "",
            "\1\102\1\105\5\uffff\1\103\10\uffff\1\104",
            "",
            "",
            "\1\106",
            "",
            "",
            "",
            "",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
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
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "",
            "\1\155",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\170",
            "",
            "",
            "",
            "",
            "\1\171",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | RULE_HEX | RULE_CC_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_27 = input.LA(1);

                        s = -1;
                        if ( ((LA15_27>='\u0000' && LA15_27<='\uFFFF')) ) {s = 57;}

                        else s = 30;

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

                        else if ( (LA15_0=='o') ) {s = 6;}

                        else if ( (LA15_0=='m') ) {s = 7;}

                        else if ( (LA15_0=='a') ) {s = 8;}

                        else if ( (LA15_0==':') ) {s = 9;}

                        else if ( (LA15_0=='{') ) {s = 10;}

                        else if ( (LA15_0=='}') ) {s = 11;}

                        else if ( (LA15_0=='.') ) {s = 12;}

                        else if ( (LA15_0=='[') ) {s = 13;}

                        else if ( (LA15_0==']') ) {s = 14;}

                        else if ( (LA15_0=='f') ) {s = 15;}

                        else if ( (LA15_0=='t') ) {s = 16;}

                        else if ( (LA15_0=='+') ) {s = 17;}

                        else if ( (LA15_0=='-') ) {s = 18;}

                        else if ( (LA15_0=='e') ) {s = 19;}

                        else if ( (LA15_0=='E') ) {s = 20;}

                        else if ( (LA15_0=='p') ) {s = 21;}

                        else if ( (LA15_0=='0') ) {s = 22;}

                        else if ( (LA15_0=='\'') ) {s = 23;}

                        else if ( (LA15_0=='^') ) {s = 24;}

                        else if ( ((LA15_0>='A' && LA15_0<='D')||(LA15_0>='F' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='b' && LA15_0<='d')||(LA15_0>='g' && LA15_0<='l')||LA15_0=='n'||(LA15_0>='q' && LA15_0<='s')||(LA15_0>='u' && LA15_0<='z')) ) {s = 25;}

                        else if ( ((LA15_0>='1' && LA15_0<='9')) ) {s = 26;}

                        else if ( (LA15_0=='\"') ) {s = 27;}

                        else if ( (LA15_0=='/') ) {s = 28;}

                        else if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {s = 29;}

                        else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='#' && LA15_0<='&')||LA15_0=='*'||(LA15_0>=';' && LA15_0<='<')||(LA15_0>='>' && LA15_0<='?')||LA15_0=='\\'||LA15_0=='`'||LA15_0=='|'||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {s = 30;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_23 = input.LA(1);

                        s = -1;
                        if ( (LA15_23=='\'') ) {s = 56;}

                        else if ( ((LA15_23>='\u0000' && LA15_23<='&')||(LA15_23>='(' && LA15_23<='\uFFFF')) ) {s = 57;}

                        else s = 30;

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