package org.eclipse.etrice.core.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConfigLexer extends Lexer {
    public static final int RULE_ID=5;
    public static final int RULE_EXP=7;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int RULE_HEX=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__44=44;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=8;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=11;

    // delegates
    // delegators

    public InternalConfigLexer() {;} 
    public InternalConfigLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalConfigLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:11:7: ( 'write' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:11:9: 'write'
            {
            match("write"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:12:7: ( 'model' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:12:9: 'model'
            {
            match("model"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:13:7: ( 'false' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:13:9: 'false'
            {
            match("false"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:14:7: ( '+' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:14:9: '+'
            {
            match('+'); 

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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:15:7: ( '-' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:15:9: '-'
            {
            match('-'); 

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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:16:7: ( 'SubSystemConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:16:9: 'SubSystemConfig'
            {
            match("SubSystemConfig"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:17:7: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:17:9: '{'
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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:18:7: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:18:9: '}'
            {
            match('}'); 

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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:19:7: ( 'dynamic configuration' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:19:9: 'dynamic configuration'
            {
            match("dynamic configuration"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:20:7: ( 'file path' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:20:9: 'file path'
            {
            match("file path"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:21:7: ( 'user import' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:21:9: 'user import'
            {
            match("user import"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:22:7: ( 'user constructor' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:22:9: 'user constructor'
            {
            match("user constructor"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:23:7: ( 'polling timer [ms]' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:23:9: 'polling timer [ms]'
            {
            match("polling timer [ms]"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:24:7: ( 'ActorClassConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:24:9: 'ActorClassConfig'
            {
            match("ActorClassConfig"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:25:7: ( 'ActorInstanceConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:25:9: 'ActorInstanceConfig'
            {
            match("ActorInstanceConfig"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:26:7: ( '/' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:26:9: '/'
            {
            match('/'); 

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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:27:7: ( 'ProtocolClassConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:27:9: 'ProtocolClassConfig'
            {
            match("ProtocolClassConfig"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:28:7: ( 'regular' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:28:9: 'regular'
            {
            match("regular"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:29:7: ( 'conjugate' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:29:9: 'conjugate'
            {
            match("conjugate"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:30:7: ( 'Port' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:30:9: 'Port'
            {
            match("Port"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:31:7: ( 'InterfaceItem' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:31:9: 'InterfaceItem'
            {
            match("InterfaceItem"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:32:7: ( 'Attr' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:32:9: 'Attr'
            {
            match("Attr"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:33:7: ( '=' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:33:9: '='
            {
            match('='); 

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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:34:7: ( 'min' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:34:9: 'min'
            {
            match("min"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:35:7: ( 'max' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:35:9: 'max'
            {
            match("max"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:36:7: ( 'import' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:36:9: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:37:7: ( 'from' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:37:9: 'from'
            {
            match("from"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:38:7: ( '.*' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:38:9: '.*'
            {
            match(".*"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:39:7: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:39:9: '.'
            {
            match('.'); 

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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:40:7: ( ',' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:40:9: ','
            {
            match(','); 

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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:41:7: ( 'read' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:41:9: 'read'
            {
            match("read"); 


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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:42:7: ( 'true' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:42:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "RULE_EXP"
    public final void mRULE_EXP() throws RecognitionException {
        try {
            int _type = RULE_EXP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6299:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6299:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6299:22: ( '+' | '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='+'||LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:
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

            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6299:33: ( '0' .. '9' )+
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
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6299:34: '0' .. '9'
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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6301:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6301:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6301:12: ( '0x' | '0X' )
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6301:13: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6301:18: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6301:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:
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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6303:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6303:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6303:11: ( '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='^') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6303:11: '^'
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

            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6303:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:
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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6305:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6305:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6305:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6305:13: '0' .. '9'
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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6307:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6307:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6307:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6307:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6307:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6307:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6307:66: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6307:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6307:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6307:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6307:137: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6309:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6309:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6309:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6309:52: .
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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6311:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6311:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6311:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6311:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6311:40: ( ( '\\r' )? '\\n' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\n'||LA14_0=='\r') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6311:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6311:41: ( '\\r' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='\r') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6311:41: '\\r'
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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6313:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6313:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6313:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:
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
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6315:16: ( . )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6315:18: .
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
        // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | RULE_EXP | RULE_HEX | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt16=41;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:202: RULE_EXP
                {
                mRULE_EXP(); 

                }
                break;
            case 34 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:211: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 35 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:220: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 36 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:228: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 37 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:237: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 38 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:249: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 39 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:265: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 40 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:281: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 41 :
                // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1:289: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\3\41\2\uffff\1\41\2\uffff\4\41\1\64\4\41\1\uffff\1\41"+
        "\1\75\1\uffff\2\41\1\103\1\37\2\uffff\2\37\2\uffff\1\41\1\uffff"+
        "\6\41\2\uffff\1\41\2\uffff\5\41\3\uffff\5\41\1\uffff\1\41\3\uffff"+
        "\1\41\1\uffff\1\100\4\uffff\2\41\1\135\1\136\23\41\2\uffff\2\41"+
        "\1\164\5\41\1\172\1\41\1\174\1\41\1\176\3\41\1\u0082\1\u0083\1\u0084"+
        "\1\u0085\2\uffff\2\41\1\uffff\2\41\1\uffff\1\41\1\uffff\1\41\1\uffff"+
        "\3\41\4\uffff\2\41\2\uffff\7\41\1\u009b\6\41\1\u00a2\2\41\1\uffff"+
        "\1\41\2\uffff\3\41\1\uffff\6\41\1\u00af\5\41\1\uffff\17\41\1\u00c4"+
        "\4\41\1\uffff\1\u00c9\3\41\1\uffff\1\u00cd\2\41\1\uffff\4\41\1\u00d4"+
        "\1\u00d5\2\uffff";
    static final String DFA16_eofS =
        "\u00d6\uffff";
    static final String DFA16_minS =
        "\1\0\1\162\2\141\2\uffff\1\165\2\uffff\1\171\1\163\1\157\1\143"+
        "\1\52\1\157\1\145\1\157\1\156\1\uffff\1\155\1\52\1\uffff\1\162\1"+
        "\53\1\130\1\101\2\uffff\2\0\2\uffff\1\151\1\uffff\1\144\1\156\1"+
        "\170\2\154\1\157\2\uffff\1\142\2\uffff\1\156\1\145\1\154\2\164\3"+
        "\uffff\1\157\1\162\1\141\1\156\1\164\1\uffff\1\160\3\uffff\1\165"+
        "\1\uffff\1\60\4\uffff\1\164\1\145\2\60\1\163\1\145\1\155\1\123\1"+
        "\141\1\162\1\154\1\157\1\162\2\164\1\165\1\144\1\152\1\145\1\157"+
        "\2\145\1\154\2\uffff\1\145\1\40\1\60\1\171\1\155\1\40\1\151\1\162"+
        "\1\60\1\157\1\60\1\154\1\60\1\165\2\162\4\60\2\uffff\1\163\1\151"+
        "\1\143\1\156\1\103\1\uffff\1\143\1\uffff\1\141\1\uffff\1\147\1\146"+
        "\1\164\4\uffff\1\164\1\143\2\uffff\1\147\1\154\1\156\1\157\1\162"+
        "\2\141\1\60\1\145\2\40\1\141\1\163\1\154\1\60\1\164\1\143\1\uffff"+
        "\1\155\2\uffff\1\163\1\164\1\103\1\uffff\2\145\1\103\1\163\1\141"+
        "\1\154\1\60\1\111\1\157\1\103\1\156\1\141\1\uffff\1\164\1\156\1"+
        "\157\1\143\1\163\1\145\1\146\1\156\1\145\1\163\1\155\1\151\1\146"+
        "\2\103\1\60\1\147\1\151\2\157\1\uffff\1\60\1\147\2\156\1\uffff\1"+
        "\60\2\146\1\uffff\2\151\2\147\2\60\2\uffff";
    static final String DFA16_maxS =
        "\1\uffff\1\162\1\157\1\162\2\uffff\1\165\2\uffff\1\171\1\163\1"+
        "\157\1\164\1\57\1\162\1\145\1\157\1\156\1\uffff\1\155\1\52\1\uffff"+
        "\1\162\1\71\1\170\1\172\2\uffff\2\uffff\2\uffff\1\151\1\uffff\1"+
        "\144\1\156\1\170\2\154\1\157\2\uffff\1\142\2\uffff\1\156\1\145\1"+
        "\154\2\164\3\uffff\1\157\1\162\1\147\1\156\1\164\1\uffff\1\160\3"+
        "\uffff\1\165\1\uffff\1\172\4\uffff\1\164\1\145\2\172\1\163\1\145"+
        "\1\155\1\123\1\141\1\162\1\154\1\157\1\162\2\164\1\165\1\144\1\152"+
        "\1\145\1\157\2\145\1\154\2\uffff\1\145\1\40\1\172\1\171\1\155\1"+
        "\40\1\151\1\162\1\172\1\157\1\172\1\154\1\172\1\165\2\162\4\172"+
        "\2\uffff\1\163\2\151\1\156\1\111\1\uffff\1\143\1\uffff\1\141\1\uffff"+
        "\1\147\1\146\1\164\4\uffff\1\164\1\143\2\uffff\1\147\1\154\1\156"+
        "\1\157\1\162\2\141\1\172\1\145\2\40\1\141\1\163\1\154\1\172\1\164"+
        "\1\143\1\uffff\1\155\2\uffff\1\163\1\164\1\103\1\uffff\2\145\1\103"+
        "\1\163\1\141\1\154\1\172\1\111\1\157\1\103\1\156\1\141\1\uffff\1"+
        "\164\1\156\1\157\1\143\1\163\1\145\1\146\1\156\1\145\1\163\1\155"+
        "\1\151\1\146\2\103\1\172\1\147\1\151\2\157\1\uffff\1\172\1\147\2"+
        "\156\1\uffff\1\172\2\146\1\uffff\2\151\2\147\2\172\2\uffff";
    static final String DFA16_acceptS =
        "\4\uffff\1\4\1\5\1\uffff\1\7\1\10\11\uffff\1\27\2\uffff\1\36\4"+
        "\uffff\1\43\1\44\2\uffff\1\50\1\51\1\uffff\1\43\6\uffff\1\4\1\5"+
        "\1\uffff\1\7\1\10\5\uffff\1\46\1\47\1\20\5\uffff\1\27\1\uffff\1"+
        "\34\1\35\1\36\1\uffff\1\41\1\uffff\1\42\1\44\1\45\1\50\27\uffff"+
        "\1\30\1\31\24\uffff\1\12\1\33\5\uffff\1\26\1\uffff\1\24\1\uffff"+
        "\1\37\3\uffff\1\40\1\1\1\2\1\3\2\uffff\1\13\1\14\21\uffff\1\32\1"+
        "\uffff\1\11\1\15\3\uffff\1\22\14\uffff\1\23\24\uffff\1\25\4\uffff"+
        "\1\6\3\uffff\1\16\6\uffff\1\17\1\21";
    static final String DFA16_specialS =
        "\1\0\33\uffff\1\2\1\1\u00b8\uffff}>";
    static final String[] DFA16_transitionS = {
            "\11\37\2\36\2\37\1\36\22\37\1\36\1\37\1\34\4\37\1\35\3\37\1"+
            "\4\1\25\1\5\1\24\1\15\1\30\11\33\3\37\1\22\3\37\1\14\3\32\1"+
            "\27\3\32\1\21\6\32\1\16\2\32\1\6\7\32\3\37\1\31\1\32\1\37\2"+
            "\32\1\20\1\11\1\27\1\3\2\32\1\23\3\32\1\2\2\32\1\13\1\32\1\17"+
            "\1\32\1\26\1\12\1\32\1\1\3\32\1\7\1\37\1\10\uff82\37",
            "\1\40",
            "\1\44\7\uffff\1\43\5\uffff\1\42",
            "\1\45\7\uffff\1\46\10\uffff\1\47",
            "",
            "",
            "\1\52",
            "",
            "",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60\20\uffff\1\61",
            "\1\62\4\uffff\1\63",
            "\1\66\2\uffff\1\65",
            "\1\67",
            "\1\70",
            "\1\71",
            "",
            "\1\73",
            "\1\74",
            "",
            "\1\77",
            "\1\100\1\uffff\1\100\2\uffff\12\101",
            "\1\102\37\uffff\1\102",
            "\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            "\0\104",
            "\0\104",
            "",
            "",
            "\1\106",
            "",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "",
            "",
            "\1\115",
            "",
            "",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "",
            "",
            "",
            "\1\123",
            "\1\124",
            "\1\126\5\uffff\1\125",
            "\1\127",
            "\1\130",
            "",
            "\1\131",
            "",
            "",
            "",
            "\1\132",
            "",
            "\12\101\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            "",
            "",
            "\1\133",
            "\1\134",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "",
            "",
            "\1\162",
            "\1\163",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\173",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\175",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            "\1\u0086",
            "\1\u0087",
            "\1\u0089\5\uffff\1\u0088",
            "\1\u008a",
            "\1\u008b\5\uffff\1\u008c",
            "",
            "\1\u008d",
            "",
            "\1\u008e",
            "",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "",
            "",
            "",
            "",
            "\1\u0092",
            "\1\u0093",
            "",
            "",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00a3",
            "\1\u00a4",
            "",
            "\1\u00a5",
            "",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00ce",
            "\1\u00cf",
            "",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | RULE_EXP | RULE_HEX | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_0 = input.LA(1);

                        s = -1;
                        if ( (LA16_0=='w') ) {s = 1;}

                        else if ( (LA16_0=='m') ) {s = 2;}

                        else if ( (LA16_0=='f') ) {s = 3;}

                        else if ( (LA16_0=='+') ) {s = 4;}

                        else if ( (LA16_0=='-') ) {s = 5;}

                        else if ( (LA16_0=='S') ) {s = 6;}

                        else if ( (LA16_0=='{') ) {s = 7;}

                        else if ( (LA16_0=='}') ) {s = 8;}

                        else if ( (LA16_0=='d') ) {s = 9;}

                        else if ( (LA16_0=='u') ) {s = 10;}

                        else if ( (LA16_0=='p') ) {s = 11;}

                        else if ( (LA16_0=='A') ) {s = 12;}

                        else if ( (LA16_0=='/') ) {s = 13;}

                        else if ( (LA16_0=='P') ) {s = 14;}

                        else if ( (LA16_0=='r') ) {s = 15;}

                        else if ( (LA16_0=='c') ) {s = 16;}

                        else if ( (LA16_0=='I') ) {s = 17;}

                        else if ( (LA16_0=='=') ) {s = 18;}

                        else if ( (LA16_0=='i') ) {s = 19;}

                        else if ( (LA16_0=='.') ) {s = 20;}

                        else if ( (LA16_0==',') ) {s = 21;}

                        else if ( (LA16_0=='t') ) {s = 22;}

                        else if ( (LA16_0=='E'||LA16_0=='e') ) {s = 23;}

                        else if ( (LA16_0=='0') ) {s = 24;}

                        else if ( (LA16_0=='^') ) {s = 25;}

                        else if ( ((LA16_0>='B' && LA16_0<='D')||(LA16_0>='F' && LA16_0<='H')||(LA16_0>='J' && LA16_0<='O')||(LA16_0>='Q' && LA16_0<='R')||(LA16_0>='T' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='b')||(LA16_0>='g' && LA16_0<='h')||(LA16_0>='j' && LA16_0<='l')||(LA16_0>='n' && LA16_0<='o')||LA16_0=='q'||LA16_0=='s'||LA16_0=='v'||(LA16_0>='x' && LA16_0<='z')) ) {s = 26;}

                        else if ( ((LA16_0>='1' && LA16_0<='9')) ) {s = 27;}

                        else if ( (LA16_0=='\"') ) {s = 28;}

                        else if ( (LA16_0=='\'') ) {s = 29;}

                        else if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {s = 30;}

                        else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='!'||(LA16_0>='#' && LA16_0<='&')||(LA16_0>='(' && LA16_0<='*')||(LA16_0>=':' && LA16_0<='<')||(LA16_0>='>' && LA16_0<='@')||(LA16_0>='[' && LA16_0<=']')||LA16_0=='`'||LA16_0=='|'||(LA16_0>='~' && LA16_0<='\uFFFF')) ) {s = 31;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_29 = input.LA(1);

                        s = -1;
                        if ( ((LA16_29>='\u0000' && LA16_29<='\uFFFF')) ) {s = 68;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_28 = input.LA(1);

                        s = -1;
                        if ( ((LA16_28>='\u0000' && LA16_28<='\uFFFF')) ) {s = 68;}

                        else s = 31;

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