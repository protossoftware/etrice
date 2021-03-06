package org.eclipse.etrice.core.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConfigLexer extends Lexer {
    public static final int RULE_HEX=5;
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int RULE_CC_STRING=8;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
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
    public static final int T__62=62;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
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

    // delegates
    // delegators

    public InternalConfigLexer() {;} 
    public InternalConfigLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalConfigLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalConfig.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:11:7: ( 'conjugate' )
            // InternalConfig.g:11:9: 'conjugate'
            {
            match("conjugate"); 


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
            // InternalConfig.g:12:7: ( 'conjugated' )
            // InternalConfig.g:12:9: 'conjugated'
            {
            match("conjugated"); 


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
            // InternalConfig.g:13:7: ( 'write' )
            // InternalConfig.g:13:9: 'write'
            {
            match("write"); 


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
            // InternalConfig.g:14:7: ( 'mandatory' )
            // InternalConfig.g:14:9: 'mandatory'
            {
            match("mandatory"); 


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
            // InternalConfig.g:15:7: ( 'false' )
            // InternalConfig.g:15:9: 'false'
            {
            match("false"); 


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
            // InternalConfig.g:16:7: ( '+' )
            // InternalConfig.g:16:9: '+'
            {
            match('+'); 

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
            // InternalConfig.g:17:7: ( '-' )
            // InternalConfig.g:17:9: '-'
            {
            match('-'); 

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
            // InternalConfig.g:18:7: ( 'e' )
            // InternalConfig.g:18:9: 'e'
            {
            match('e'); 

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
            // InternalConfig.g:19:7: ( 'E' )
            // InternalConfig.g:19:9: 'E'
            {
            match('E'); 

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
            // InternalConfig.g:20:7: ( 'ptBoolean' )
            // InternalConfig.g:20:9: 'ptBoolean'
            {
            match("ptBoolean"); 


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
            // InternalConfig.g:21:7: ( 'ptInteger' )
            // InternalConfig.g:21:9: 'ptInteger'
            {
            match("ptInteger"); 


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
            // InternalConfig.g:22:7: ( 'ptReal' )
            // InternalConfig.g:22:9: 'ptReal'
            {
            match("ptReal"); 


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
            // InternalConfig.g:23:7: ( 'ptCharacter' )
            // InternalConfig.g:23:9: 'ptCharacter'
            {
            match("ptCharacter"); 


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
            // InternalConfig.g:24:7: ( 'ConfigModel' )
            // InternalConfig.g:24:9: 'ConfigModel'
            {
            match("ConfigModel"); 


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
            // InternalConfig.g:25:7: ( '{' )
            // InternalConfig.g:25:9: '{'
            {
            match('{'); 

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
            // InternalConfig.g:26:7: ( '}' )
            // InternalConfig.g:26:9: '}'
            {
            match('}'); 

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
            // InternalConfig.g:27:7: ( 'SubSystemConfig' )
            // InternalConfig.g:27:9: 'SubSystemConfig'
            {
            match("SubSystemConfig"); 


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
            // InternalConfig.g:28:7: ( '/' )
            // InternalConfig.g:28:9: '/'
            {
            match('/'); 

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
            // InternalConfig.g:29:7: ( 'dynamic configuration' )
            // InternalConfig.g:29:9: 'dynamic configuration'
            {
            match("dynamic configuration"); 


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
            // InternalConfig.g:30:7: ( 'file path' )
            // InternalConfig.g:30:9: 'file path'
            {
            match("file path"); 


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
            // InternalConfig.g:31:7: ( 'user import' )
            // InternalConfig.g:31:9: 'user import'
            {
            match("user import"); 


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
            // InternalConfig.g:32:7: ( 'user constructor' )
            // InternalConfig.g:32:9: 'user constructor'
            {
            match("user constructor"); 


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
            // InternalConfig.g:33:7: ( 'polling interval' )
            // InternalConfig.g:33:9: 'polling interval'
            {
            match("polling interval"); 


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
            // InternalConfig.g:34:7: ( 'ActorClassConfig' )
            // InternalConfig.g:34:9: 'ActorClassConfig'
            {
            match("ActorClassConfig"); 


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
            // InternalConfig.g:35:7: ( 'ActorInstanceConfig' )
            // InternalConfig.g:35:9: 'ActorInstanceConfig'
            {
            match("ActorInstanceConfig"); 


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
            // InternalConfig.g:36:7: ( 'ProtocolClassConfig' )
            // InternalConfig.g:36:9: 'ProtocolClassConfig'
            {
            match("ProtocolClassConfig"); 


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
            // InternalConfig.g:37:7: ( 'regular' )
            // InternalConfig.g:37:9: 'regular'
            {
            match("regular"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:38:7: ( 'Port' )
            // InternalConfig.g:38:9: 'Port'
            {
            match("Port"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:39:7: ( 'InterfaceItem' )
            // InternalConfig.g:39:9: 'InterfaceItem'
            {
            match("InterfaceItem"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:40:7: ( 'Attr' )
            // InternalConfig.g:40:9: 'Attr'
            {
            match("Attr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:41:7: ( '=' )
            // InternalConfig.g:41:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:42:7: ( 'min' )
            // InternalConfig.g:42:9: 'min'
            {
            match("min"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:43:7: ( 'max' )
            // InternalConfig.g:43:9: 'max'
            {
            match("max"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:44:7: ( ',' )
            // InternalConfig.g:44:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:45:7: ( '.' )
            // InternalConfig.g:45:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:46:7: ( ':' )
            // InternalConfig.g:46:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:47:7: ( 'attribute' )
            // InternalConfig.g:47:9: 'attribute'
            {
            match("attribute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:48:7: ( 'import' )
            // InternalConfig.g:48:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:49:7: ( 'from' )
            // InternalConfig.g:49:9: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:50:7: ( 'model' )
            // InternalConfig.g:50:9: 'model'
            {
            match("model"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:51:7: ( '.*' )
            // InternalConfig.g:51:9: '.*'
            {
            match(".*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:52:7: ( '[' )
            // InternalConfig.g:52:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:53:7: ( ']' )
            // InternalConfig.g:53:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:54:7: ( 's' )
            // InternalConfig.g:54:9: 's'
            {
            match('s'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:55:7: ( 'ms' )
            // InternalConfig.g:55:9: 'ms'
            {
            match("ms"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:56:7: ( 'us' )
            // InternalConfig.g:56:9: 'us'
            {
            match("us"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:57:7: ( 'ns' )
            // InternalConfig.g:57:9: 'ns'
            {
            match("ns"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:58:7: ( 'read' )
            // InternalConfig.g:58:9: 'read'
            {
            match("read"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:59:7: ( 'optional' )
            // InternalConfig.g:59:9: 'optional'
            {
            match("optional"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:60:7: ( 'true' )
            // InternalConfig.g:60:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalConfig.g:7321:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // InternalConfig.g:7321:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            // InternalConfig.g:7321:12: ( '0x' | '0X' )
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
                    // InternalConfig.g:7321:13: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // InternalConfig.g:7321:18: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // InternalConfig.g:7321:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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
            	    // InternalConfig.g:
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
            // InternalConfig.g:7323:16: ( '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\'' )
            // InternalConfig.g:7323:18: '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\''
            {
            match("'''"); 

            // InternalConfig.g:7323:27: ( options {greedy=false; } : . )*
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
            	    // InternalConfig.g:7323:55: .
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
            // InternalConfig.g:7325:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalConfig.g:7325:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalConfig.g:7325:11: ( '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='^') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalConfig.g:7325:11: '^'
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

            // InternalConfig.g:7325:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalConfig.g:
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
            // InternalConfig.g:7327:10: ( ( '0' .. '9' )+ )
            // InternalConfig.g:7327:12: ( '0' .. '9' )+
            {
            // InternalConfig.g:7327:12: ( '0' .. '9' )+
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
            	    // InternalConfig.g:7327:13: '0' .. '9'
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
            // InternalConfig.g:7329:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalConfig.g:7329:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalConfig.g:7329:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalConfig.g:7329:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalConfig.g:7329:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalConfig.g:7329:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalConfig.g:7329:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalConfig.g:7329:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalConfig.g:7329:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalConfig.g:7329:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalConfig.g:7329:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalConfig.g:7331:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalConfig.g:7331:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalConfig.g:7331:24: ( options {greedy=false; } : . )*
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
            	    // InternalConfig.g:7331:52: .
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
            // InternalConfig.g:7333:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalConfig.g:7333:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalConfig.g:7333:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalConfig.g:7333:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalConfig.g:7333:40: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalConfig.g:7333:41: ( '\\r' )? '\\n'
                    {
                    // InternalConfig.g:7333:41: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalConfig.g:7333:41: '\\r'
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
            // InternalConfig.g:7335:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalConfig.g:7335:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalConfig.g:7335:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalConfig.g:
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
            // InternalConfig.g:7337:16: ( . )
            // InternalConfig.g:7337:18: .
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
        // InternalConfig.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | RULE_HEX | RULE_CC_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt15=59;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // InternalConfig.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalConfig.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalConfig.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalConfig.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalConfig.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalConfig.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalConfig.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalConfig.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalConfig.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalConfig.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalConfig.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalConfig.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalConfig.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalConfig.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalConfig.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalConfig.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalConfig.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalConfig.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalConfig.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // InternalConfig.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // InternalConfig.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // InternalConfig.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // InternalConfig.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // InternalConfig.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // InternalConfig.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // InternalConfig.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // InternalConfig.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // InternalConfig.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // InternalConfig.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // InternalConfig.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // InternalConfig.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // InternalConfig.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // InternalConfig.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // InternalConfig.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // InternalConfig.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // InternalConfig.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // InternalConfig.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // InternalConfig.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // InternalConfig.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // InternalConfig.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // InternalConfig.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // InternalConfig.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // InternalConfig.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // InternalConfig.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // InternalConfig.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // InternalConfig.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // InternalConfig.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // InternalConfig.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // InternalConfig.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // InternalConfig.g:1:304: T__62
                {
                mT__62(); 

                }
                break;
            case 51 :
                // InternalConfig.g:1:310: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 52 :
                // InternalConfig.g:1:319: RULE_CC_STRING
                {
                mRULE_CC_STRING(); 

                }
                break;
            case 53 :
                // InternalConfig.g:1:334: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 54 :
                // InternalConfig.g:1:342: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 55 :
                // InternalConfig.g:1:351: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 56 :
                // InternalConfig.g:1:363: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 57 :
                // InternalConfig.g:1:379: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 58 :
                // InternalConfig.g:1:395: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 59 :
                // InternalConfig.g:1:403: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\4\52\2\uffff\1\65\1\66\2\52\2\uffff\1\52\1\77\6\52\2\uffff\1\113\1\uffff\2\52\2\uffff\1\121\3\52\1\126\2\50\2\uffff\1\50\2\uffff\1\52\1\uffff\4\52\1\140\3\52\4\uffff\3\52\2\uffff\1\52\3\uffff\1\52\1\155\6\52\5\uffff\2\52\3\uffff\1\167\2\52\2\uffff\1\130\2\uffff\3\52\1\176\1\177\1\52\1\uffff\14\52\1\uffff\11\52\1\uffff\2\52\1\uffff\3\52\2\uffff\3\52\1\u009e\12\52\1\u00a9\1\52\1\u00ab\1\52\1\u00ad\4\52\1\u00b2\1\52\1\u00b4\1\52\1\u00b6\1\u00b7\2\uffff\10\52\1\uffff\1\52\1\uffff\1\52\1\uffff\1\52\1\uffff\4\52\1\uffff\1\52\1\uffff\1\52\2\uffff\2\52\1\u00ce\5\52\2\uffff\6\52\1\u00da\5\52\1\uffff\10\52\1\u00e8\2\52\1\uffff\6\52\1\uffff\2\52\1\uffff\3\52\1\uffff\2\52\1\u00f8\1\u00fa\1\u00fb\1\u00fc\1\u00fd\7\52\1\u0105\1\uffff\1\u0106\4\uffff\7\52\2\uffff\1\u010e\1\u010f\5\52\2\uffff\11\52\1\u011e\4\52\1\uffff\1\u0123\3\52\1\uffff\1\u0127\2\52\1\uffff\4\52\1\u012e\1\u012f\2\uffff";
    static final String DFA15_eofS =
        "\u0130\uffff";
    static final String DFA15_minS =
        "\1\0\1\157\1\162\2\141\2\uffff\2\60\2\157\2\uffff\1\165\1\52\1\171\1\163\1\143\1\157\1\145\1\156\2\uffff\1\52\1\uffff\1\164\1\155\2\uffff\1\60\1\163\1\160\1\162\1\130\1\0\1\101\2\uffff\1\0\2\uffff\1\156\1\uffff\1\151\2\156\1\144\1\60\2\154\1\157\4\uffff\1\102\1\154\1\156\2\uffff\1\142\3\uffff\1\156\1\60\2\164\1\157\1\162\1\141\1\164\5\uffff\1\164\1\160\3\uffff\1\60\1\164\1\165\2\uffff\1\47\2\uffff\1\152\1\164\1\144\2\60\1\145\1\uffff\1\163\1\145\1\155\1\157\1\156\1\145\1\150\1\154\1\146\1\123\1\141\1\162\1\uffff\1\157\1\162\2\164\1\165\1\144\1\145\1\162\1\157\1\uffff\1\151\1\145\1\uffff\1\165\1\145\1\141\2\uffff\1\154\1\145\1\40\1\60\1\157\1\164\2\141\2\151\1\171\1\155\1\40\1\162\1\60\1\157\1\60\1\154\1\60\1\162\1\151\1\162\1\157\1\60\1\147\1\60\1\164\2\60\2\uffff\1\154\1\145\1\154\1\162\1\156\1\147\1\163\1\151\1\143\1\103\1\uffff\1\143\1\uffff\1\141\1\uffff\1\146\1\142\1\164\1\156\1\uffff\1\141\1\uffff\1\157\2\uffff\1\145\1\147\1\60\1\141\1\147\1\115\1\164\1\143\2\uffff\1\154\1\156\1\157\1\162\1\141\1\165\1\60\1\141\1\164\1\162\1\141\1\145\1\uffff\1\143\1\40\1\157\1\145\1\40\1\141\1\163\1\154\1\60\1\143\1\164\1\uffff\1\154\1\145\1\171\1\156\1\162\1\164\1\uffff\1\144\1\155\1\uffff\1\163\1\164\1\103\1\uffff\2\145\5\60\2\145\1\103\1\163\1\141\1\154\1\111\1\60\1\uffff\1\60\4\uffff\1\162\1\154\1\157\1\103\1\156\1\141\1\164\2\uffff\2\60\1\156\1\157\1\143\1\163\1\145\2\uffff\1\146\1\156\1\145\1\163\1\155\1\151\1\146\2\103\1\60\1\147\1\151\2\157\1\uffff\1\60\1\147\2\156\1\uffff\1\60\2\146\1\uffff\2\151\2\147\2\60\2\uffff";
    static final String DFA15_maxS =
        "\1\uffff\1\157\1\162\1\163\1\162\2\uffff\2\172\1\164\1\157\2\uffff\1\165\1\57\1\171\1\163\1\164\1\162\1\145\1\156\2\uffff\1\52\1\uffff\1\164\1\155\2\uffff\1\172\1\163\1\160\1\162\1\170\1\uffff\1\172\2\uffff\1\uffff\2\uffff\1\156\1\uffff\1\151\1\170\1\156\1\144\1\172\2\154\1\157\4\uffff\1\122\1\154\1\156\2\uffff\1\142\3\uffff\1\156\1\172\2\164\1\157\1\162\1\147\1\164\5\uffff\1\164\1\160\3\uffff\1\172\1\164\1\165\2\uffff\1\47\2\uffff\1\152\1\164\1\144\2\172\1\145\1\uffff\1\163\1\145\1\155\1\157\1\156\1\145\1\150\1\154\1\146\1\123\1\141\1\162\1\uffff\1\157\1\162\2\164\1\165\1\144\1\145\1\162\1\157\1\uffff\1\151\1\145\1\uffff\1\165\1\145\1\141\2\uffff\1\154\1\145\1\40\1\172\1\157\1\164\2\141\2\151\1\171\1\155\1\40\1\162\1\172\1\157\1\172\1\154\1\172\1\162\1\151\1\162\1\157\1\172\1\147\1\172\1\164\2\172\2\uffff\1\154\1\145\1\154\1\162\1\156\1\147\1\163\2\151\1\111\1\uffff\1\143\1\uffff\1\141\1\uffff\1\146\1\142\1\164\1\156\1\uffff\1\141\1\uffff\1\157\2\uffff\1\145\1\147\1\172\1\141\1\147\1\115\1\164\1\143\2\uffff\1\154\1\156\1\157\1\162\1\141\1\165\1\172\1\141\1\164\1\162\1\141\1\145\1\uffff\1\143\1\40\1\157\1\145\1\40\1\141\1\163\1\154\1\172\1\143\1\164\1\uffff\1\154\1\145\1\171\1\156\1\162\1\164\1\uffff\1\144\1\155\1\uffff\1\163\1\164\1\103\1\uffff\2\145\5\172\2\145\1\103\1\163\1\141\1\154\1\111\1\172\1\uffff\1\172\4\uffff\1\162\1\154\1\157\1\103\1\156\1\141\1\164\2\uffff\2\172\1\156\1\157\1\143\1\163\1\145\2\uffff\1\146\1\156\1\145\1\163\1\155\1\151\1\146\2\103\1\172\1\147\1\151\2\157\1\uffff\1\172\1\147\2\156\1\uffff\1\172\2\146\1\uffff\2\151\2\147\2\172\2\uffff";
    static final String DFA15_acceptS =
        "\5\uffff\1\6\1\7\4\uffff\1\17\1\20\10\uffff\1\37\1\42\1\uffff\1\44\2\uffff\1\52\1\53\7\uffff\1\65\1\66\1\uffff\1\72\1\73\1\uffff\1\65\10\uffff\1\6\1\7\1\10\1\11\3\uffff\1\17\1\20\1\uffff\1\70\1\71\1\22\10\uffff\1\37\1\42\1\51\1\43\1\44\2\uffff\1\52\1\53\1\54\3\uffff\1\63\1\66\1\uffff\1\67\1\72\6\uffff\1\55\14\uffff\1\56\11\uffff\1\57\2\uffff\1\64\3\uffff\1\41\1\40\35\uffff\1\24\1\47\12\uffff\1\36\1\uffff\1\34\1\uffff\1\60\4\uffff\1\62\1\uffff\1\3\1\uffff\1\50\1\5\10\uffff\1\25\1\26\14\uffff\1\14\13\uffff\1\46\6\uffff\1\27\2\uffff\1\23\3\uffff\1\33\17\uffff\1\61\1\uffff\1\1\1\4\1\12\1\13\7\uffff\1\45\1\2\7\uffff\1\15\1\16\16\uffff\1\35\4\uffff\1\21\3\uffff\1\30\6\uffff\1\31\1\32";
    static final String DFA15_specialS =
        "\1\1\41\uffff\1\0\3\uffff\1\2\u0109\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\50\2\47\2\50\1\47\22\50\1\47\1\50\1\46\4\50\1\42\3\50\1\5\1\26\1\6\1\27\1\16\1\41\11\45\1\30\2\50\1\25\3\50\1\21\1\44\1\12\1\44\1\10\3\44\1\24\6\44\1\22\2\44\1\15\7\44\1\33\1\50\1\34\1\43\1\44\1\50\1\31\1\44\1\1\1\17\1\7\1\4\2\44\1\32\3\44\1\3\1\36\1\37\1\11\1\44\1\23\1\35\1\40\1\20\1\44\1\2\3\44\1\13\1\50\1\14\uff82\50",
            "\1\51",
            "\1\53",
            "\1\54\7\uffff\1\55\5\uffff\1\56\3\uffff\1\57",
            "\1\60\7\uffff\1\61\10\uffff\1\62",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\70\4\uffff\1\67",
            "\1\71",
            "",
            "",
            "\1\74",
            "\1\75\4\uffff\1\76",
            "\1\100",
            "\1\101",
            "\1\102\20\uffff\1\103",
            "\1\105\2\uffff\1\104",
            "\1\106",
            "\1\107",
            "",
            "",
            "\1\112",
            "",
            "\1\115",
            "\1\116",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125\37\uffff\1\125",
            "\47\130\1\127\uffd8\130",
            "\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\0\130",
            "",
            "",
            "\1\132",
            "",
            "\1\133",
            "\1\134\11\uffff\1\135",
            "\1\136",
            "\1\137",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\141",
            "\1\142",
            "\1\143",
            "",
            "",
            "",
            "",
            "\1\144\1\147\5\uffff\1\145\10\uffff\1\146",
            "\1\150",
            "\1\151",
            "",
            "",
            "\1\152",
            "",
            "",
            "",
            "\1\153",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\154\25\52",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\163\5\uffff\1\162",
            "\1\164",
            "",
            "",
            "",
            "",
            "",
            "\1\165",
            "\1\166",
            "",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\170",
            "\1\171",
            "",
            "",
            "\1\172",
            "",
            "",
            "\1\173",
            "\1\174",
            "\1\175",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0080",
            "",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "",
            "\1\u0096",
            "\1\u0097",
            "",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "",
            "",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00aa",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00ac",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00b3",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00b5",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c1\5\uffff\1\u00c0",
            "\1\u00c2\5\uffff\1\u00c3",
            "",
            "\1\u00c4",
            "",
            "\1\u00c5",
            "",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "",
            "\1\u00ca",
            "",
            "\1\u00cb",
            "",
            "",
            "\1\u00cc",
            "\1\u00cd",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "",
            "",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00e9",
            "\1\u00ea",
            "",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "",
            "\1\u00f1",
            "\1\u00f2",
            "",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "",
            "\1\u00f6",
            "\1\u00f7",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\3\52\1\u00f9\26\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "",
            "",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "",
            "",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0128",
            "\1\u0129",
            "",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | RULE_HEX | RULE_CC_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_34 = input.LA(1);

                        s = -1;
                        if ( (LA15_34=='\'') ) {s = 87;}

                        else if ( ((LA15_34>='\u0000' && LA15_34<='&')||(LA15_34>='(' && LA15_34<='\uFFFF')) ) {s = 88;}

                        else s = 40;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_0 = input.LA(1);

                        s = -1;
                        if ( (LA15_0=='c') ) {s = 1;}

                        else if ( (LA15_0=='w') ) {s = 2;}

                        else if ( (LA15_0=='m') ) {s = 3;}

                        else if ( (LA15_0=='f') ) {s = 4;}

                        else if ( (LA15_0=='+') ) {s = 5;}

                        else if ( (LA15_0=='-') ) {s = 6;}

                        else if ( (LA15_0=='e') ) {s = 7;}

                        else if ( (LA15_0=='E') ) {s = 8;}

                        else if ( (LA15_0=='p') ) {s = 9;}

                        else if ( (LA15_0=='C') ) {s = 10;}

                        else if ( (LA15_0=='{') ) {s = 11;}

                        else if ( (LA15_0=='}') ) {s = 12;}

                        else if ( (LA15_0=='S') ) {s = 13;}

                        else if ( (LA15_0=='/') ) {s = 14;}

                        else if ( (LA15_0=='d') ) {s = 15;}

                        else if ( (LA15_0=='u') ) {s = 16;}

                        else if ( (LA15_0=='A') ) {s = 17;}

                        else if ( (LA15_0=='P') ) {s = 18;}

                        else if ( (LA15_0=='r') ) {s = 19;}

                        else if ( (LA15_0=='I') ) {s = 20;}

                        else if ( (LA15_0=='=') ) {s = 21;}

                        else if ( (LA15_0==',') ) {s = 22;}

                        else if ( (LA15_0=='.') ) {s = 23;}

                        else if ( (LA15_0==':') ) {s = 24;}

                        else if ( (LA15_0=='a') ) {s = 25;}

                        else if ( (LA15_0=='i') ) {s = 26;}

                        else if ( (LA15_0=='[') ) {s = 27;}

                        else if ( (LA15_0==']') ) {s = 28;}

                        else if ( (LA15_0=='s') ) {s = 29;}

                        else if ( (LA15_0=='n') ) {s = 30;}

                        else if ( (LA15_0=='o') ) {s = 31;}

                        else if ( (LA15_0=='t') ) {s = 32;}

                        else if ( (LA15_0=='0') ) {s = 33;}

                        else if ( (LA15_0=='\'') ) {s = 34;}

                        else if ( (LA15_0=='^') ) {s = 35;}

                        else if ( (LA15_0=='B'||LA15_0=='D'||(LA15_0>='F' && LA15_0<='H')||(LA15_0>='J' && LA15_0<='O')||(LA15_0>='Q' && LA15_0<='R')||(LA15_0>='T' && LA15_0<='Z')||LA15_0=='_'||LA15_0=='b'||(LA15_0>='g' && LA15_0<='h')||(LA15_0>='j' && LA15_0<='l')||LA15_0=='q'||LA15_0=='v'||(LA15_0>='x' && LA15_0<='z')) ) {s = 36;}

                        else if ( ((LA15_0>='1' && LA15_0<='9')) ) {s = 37;}

                        else if ( (LA15_0=='\"') ) {s = 38;}

                        else if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {s = 39;}

                        else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='#' && LA15_0<='&')||(LA15_0>='(' && LA15_0<='*')||(LA15_0>=';' && LA15_0<='<')||(LA15_0>='>' && LA15_0<='@')||LA15_0=='\\'||LA15_0=='`'||LA15_0=='|'||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_38 = input.LA(1);

                        s = -1;
                        if ( ((LA15_38>='\u0000' && LA15_38<='\uFFFF')) ) {s = 88;}

                        else s = 40;

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