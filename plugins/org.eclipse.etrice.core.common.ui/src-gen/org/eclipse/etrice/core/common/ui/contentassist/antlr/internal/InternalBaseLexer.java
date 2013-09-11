package org.eclipse.etrice.core.common.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBaseLexer extends Lexer {
    public static final int RULE_ID=8;
    public static final int RULE_EXP=6;
    public static final int RULE_STRING=7;
    public static final int RULE_HEX=4;
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

    public InternalBaseLexer() {;} 
    public InternalBaseLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBaseLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:11:7: ( 'false' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:11:9: 'false'
            {
            match("false"); 


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
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:12:7: ( '+' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:12:9: '+'
            {
            match('+'); 

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
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:13:7: ( '-' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:13:9: '-'
            {
            match('-'); 

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
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:14:7: ( ',' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:14:9: ','
            {
            match(','); 

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
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:15:7: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:15:9: '.'
            {
            match('.'); 

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
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:16:7: ( 'true' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:16:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "RULE_EXP"
    public final void mRULE_EXP() throws RecognitionException {
        try {
            int _type = RULE_EXP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1796:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1796:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1796:22: ( '+' | '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='+'||LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1796:33: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1796:34: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end "RULE_EXP"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1798:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1798:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1798:12: ( '0x' | '0X' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='0') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='x') ) {
                    alt3=1;
                }
                else if ( (LA3_1=='X') ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1798:13: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1798:18: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1798:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='F')||(LA4_0>='a' && LA4_0<='f')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1800:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1800:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1800:11: ( '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='^') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1800:11: '^'
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

            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1800:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:
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
            	    break loop6;
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
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1802:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1802:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1802:12: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1802:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1804:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1804:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1804:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\"') ) {
                alt10=1;
            }
            else if ( (LA10_0=='\'') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1804:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1804:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1804:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1804:66: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop8;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1804:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1804:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1804:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1804:137: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop9;
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
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1806:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1806:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1806:24: ( options {greedy=false; } : . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='*') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='/') ) {
                        alt11=2;
                    }
                    else if ( ((LA11_1>='\u0000' && LA11_1<='.')||(LA11_1>='0' && LA11_1<='\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<=')')||(LA11_0>='+' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1806:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
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
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1808:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1808:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1808:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1808:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop12;
                }
            } while (true);

            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1808:40: ( ( '\\r' )? '\\n' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\n'||LA14_0=='\r') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1808:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1808:41: ( '\\r' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='\r') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1808:41: '\\r'
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
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1810:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1810:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1810:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:
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
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1812:16: ( . )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1812:18: .
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
        // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | RULE_EXP | RULE_HEX | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt16=15;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:46: RULE_EXP
                {
                mRULE_EXP(); 

                }
                break;
            case 8 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:55: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 9 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:64: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 10 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:72: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 11 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:81: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 12 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:93: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 13 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:109: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 14 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:125: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 15 :
                // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1:133: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\1\22\4\uffff\2\22\1\33\1\20\2\uffff\3\20\2\uffff\1\22"+
        "\5\uffff\1\22\1\uffff\1\30\6\uffff\3\22\1\45\1\46\2\uffff";
    static final String DFA16_eofS =
        "\47\uffff";
    static final String DFA16_minS =
        "\1\0\1\141\4\uffff\1\162\1\53\1\130\1\101\2\uffff\2\0\1\52\2\uffff"+
        "\1\154\5\uffff\1\165\1\uffff\1\60\6\uffff\1\163\2\145\2\60\2\uffff";
    static final String DFA16_maxS =
        "\1\uffff\1\141\4\uffff\1\162\1\71\1\170\1\172\2\uffff\2\uffff\1"+
        "\57\2\uffff\1\154\5\uffff\1\165\1\uffff\1\172\6\uffff\1\163\2\145"+
        "\2\172\2\uffff";
    static final String DFA16_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\4\uffff\1\11\1\12\3\uffff\1\16\1\17\1"+
        "\uffff\1\11\1\2\1\3\1\4\1\5\1\uffff\1\7\1\uffff\1\10\1\12\1\13\1"+
        "\14\1\15\1\16\5\uffff\1\6\1\1";
    static final String DFA16_specialS =
        "\1\1\13\uffff\1\2\1\0\31\uffff}>";
    static final String[] DFA16_transitionS = {
            "\11\20\2\17\2\20\1\17\22\20\1\17\1\20\1\14\4\20\1\15\3\20\1"+
            "\2\1\4\1\3\1\5\1\16\1\10\11\13\7\20\4\12\1\7\25\12\3\20\1\11"+
            "\1\12\1\20\4\12\1\7\1\1\15\12\1\6\6\12\uff85\20",
            "\1\21",
            "",
            "",
            "",
            "",
            "\1\27",
            "\1\30\1\uffff\1\30\2\uffff\12\31",
            "\1\32\37\uffff\1\32",
            "\32\22\4\uffff\1\22\1\uffff\32\22",
            "",
            "",
            "\0\34",
            "\0\34",
            "\1\35\4\uffff\1\36",
            "",
            "",
            "\1\40",
            "",
            "",
            "",
            "",
            "",
            "\1\41",
            "",
            "\12\31\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\42",
            "\1\43",
            "\1\44",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | RULE_EXP | RULE_HEX | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_13 = input.LA(1);

                        s = -1;
                        if ( ((LA16_13>='\u0000' && LA16_13<='\uFFFF')) ) {s = 28;}

                        else s = 16;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_0 = input.LA(1);

                        s = -1;
                        if ( (LA16_0=='f') ) {s = 1;}

                        else if ( (LA16_0=='+') ) {s = 2;}

                        else if ( (LA16_0=='-') ) {s = 3;}

                        else if ( (LA16_0==',') ) {s = 4;}

                        else if ( (LA16_0=='.') ) {s = 5;}

                        else if ( (LA16_0=='t') ) {s = 6;}

                        else if ( (LA16_0=='E'||LA16_0=='e') ) {s = 7;}

                        else if ( (LA16_0=='0') ) {s = 8;}

                        else if ( (LA16_0=='^') ) {s = 9;}

                        else if ( ((LA16_0>='A' && LA16_0<='D')||(LA16_0>='F' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='d')||(LA16_0>='g' && LA16_0<='s')||(LA16_0>='u' && LA16_0<='z')) ) {s = 10;}

                        else if ( ((LA16_0>='1' && LA16_0<='9')) ) {s = 11;}

                        else if ( (LA16_0=='\"') ) {s = 12;}

                        else if ( (LA16_0=='\'') ) {s = 13;}

                        else if ( (LA16_0=='/') ) {s = 14;}

                        else if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {s = 15;}

                        else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='!'||(LA16_0>='#' && LA16_0<='&')||(LA16_0>='(' && LA16_0<='*')||(LA16_0>=':' && LA16_0<='@')||(LA16_0>='[' && LA16_0<=']')||LA16_0=='`'||(LA16_0>='{' && LA16_0<='\uFFFF')) ) {s = 16;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_12 = input.LA(1);

                        s = -1;
                        if ( ((LA16_12>='\u0000' && LA16_12<='\uFFFF')) ) {s = 28;}

                        else s = 16;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}