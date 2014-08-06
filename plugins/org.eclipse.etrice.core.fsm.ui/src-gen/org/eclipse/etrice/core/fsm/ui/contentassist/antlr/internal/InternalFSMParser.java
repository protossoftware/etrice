package org.eclipse.etrice.core.fsm.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.etrice.core.fsm.services.FSMGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFSMParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_HEX", "RULE_INT", "RULE_EXP", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'mandatory'", "'false'", "'+'", "'-'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'", "'Hello'", "'!'", "'='", "'attribute'", "':'", "'{'", "'}'", "','", "'.*'", "'['", "']'", "'.'", "'optional'", "'true'"
    };
    public static final int RULE_EXP=7;
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=8;
    public static final int RULE_HEX=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public InternalFSMParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFSMParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFSMParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g"; }


     
     	private FSMGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(FSMGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleFSMModel"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:60:1: entryRuleFSMModel : ruleFSMModel EOF ;
    public final void entryRuleFSMModel() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:61:1: ( ruleFSMModel EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:62:1: ruleFSMModel EOF
            {
             before(grammarAccess.getFSMModelRule()); 
            pushFollow(FOLLOW_ruleFSMModel_in_entryRuleFSMModel61);
            ruleFSMModel();

            state._fsp--;

             after(grammarAccess.getFSMModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFSMModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFSMModel"


    // $ANTLR start "ruleFSMModel"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:69:1: ruleFSMModel : ( ( rule__FSMModel__GreetingsAssignment )* ) ;
    public final void ruleFSMModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:73:2: ( ( ( rule__FSMModel__GreetingsAssignment )* ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:74:1: ( ( rule__FSMModel__GreetingsAssignment )* )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:74:1: ( ( rule__FSMModel__GreetingsAssignment )* )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:75:1: ( rule__FSMModel__GreetingsAssignment )*
            {
             before(grammarAccess.getFSMModelAccess().getGreetingsAssignment()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:76:1: ( rule__FSMModel__GreetingsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==21) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:76:2: rule__FSMModel__GreetingsAssignment
            	    {
            	    pushFollow(FOLLOW_rule__FSMModel__GreetingsAssignment_in_ruleFSMModel94);
            	    rule__FSMModel__GreetingsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getFSMModelAccess().getGreetingsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFSMModel"


    // $ANTLR start "entryRuleGreeting"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:88:1: entryRuleGreeting : ruleGreeting EOF ;
    public final void entryRuleGreeting() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:89:1: ( ruleGreeting EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:90:1: ruleGreeting EOF
            {
             before(grammarAccess.getGreetingRule()); 
            pushFollow(FOLLOW_ruleGreeting_in_entryRuleGreeting122);
            ruleGreeting();

            state._fsp--;

             after(grammarAccess.getGreetingRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGreeting129); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGreeting"


    // $ANTLR start "ruleGreeting"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:97:1: ruleGreeting : ( ( rule__Greeting__Group__0 ) ) ;
    public final void ruleGreeting() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:101:2: ( ( ( rule__Greeting__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:102:1: ( ( rule__Greeting__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:102:1: ( ( rule__Greeting__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:103:1: ( rule__Greeting__Group__0 )
            {
             before(grammarAccess.getGreetingAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:104:1: ( rule__Greeting__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:104:2: rule__Greeting__Group__0
            {
            pushFollow(FOLLOW_rule__Greeting__Group__0_in_ruleGreeting155);
            rule__Greeting__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGreetingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGreeting"


    // $ANTLR start "entryRuleKeyValue"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:118:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:119:1: ( ruleKeyValue EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:120:1: ruleKeyValue EOF
            {
             before(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_ruleKeyValue_in_entryRuleKeyValue184);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getKeyValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValue191); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleKeyValue"


    // $ANTLR start "ruleKeyValue"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:127:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:131:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:132:1: ( ( rule__KeyValue__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:132:1: ( ( rule__KeyValue__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:133:1: ( rule__KeyValue__Group__0 )
            {
             before(grammarAccess.getKeyValueAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:134:1: ( rule__KeyValue__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:134:2: rule__KeyValue__Group__0
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__0_in_ruleKeyValue217);
            rule__KeyValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getKeyValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKeyValue"


    // $ANTLR start "entryRuleAnnotationTargetType"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:148:1: entryRuleAnnotationTargetType : ruleAnnotationTargetType EOF ;
    public final void entryRuleAnnotationTargetType() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:149:1: ( ruleAnnotationTargetType EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:150:1: ruleAnnotationTargetType EOF
            {
             before(grammarAccess.getAnnotationTargetTypeRule()); 
            pushFollow(FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType246);
            ruleAnnotationTargetType();

            state._fsp--;

             after(grammarAccess.getAnnotationTargetTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationTargetType253); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAnnotationTargetType"


    // $ANTLR start "ruleAnnotationTargetType"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:157:1: ruleAnnotationTargetType : ( RULE_ID ) ;
    public final void ruleAnnotationTargetType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:161:2: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:162:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:162:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:163:1: RULE_ID
            {
             before(grammarAccess.getAnnotationTargetTypeAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotationTargetType279); 
             after(grammarAccess.getAnnotationTargetTypeAccess().getIDTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnnotationTargetType"


    // $ANTLR start "entryRuleAnnotationAttribute"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:176:1: entryRuleAnnotationAttribute : ruleAnnotationAttribute EOF ;
    public final void entryRuleAnnotationAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:177:1: ( ruleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:178:1: ruleAnnotationAttribute EOF
            {
             before(grammarAccess.getAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute305);
            ruleAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationAttribute312); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAnnotationAttribute"


    // $ANTLR start "ruleAnnotationAttribute"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:185:1: ruleAnnotationAttribute : ( ( rule__AnnotationAttribute__Alternatives ) ) ;
    public final void ruleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:189:2: ( ( ( rule__AnnotationAttribute__Alternatives ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:190:1: ( ( rule__AnnotationAttribute__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:190:1: ( ( rule__AnnotationAttribute__Alternatives ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:191:1: ( rule__AnnotationAttribute__Alternatives )
            {
             before(grammarAccess.getAnnotationAttributeAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:192:1: ( rule__AnnotationAttribute__Alternatives )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:192:2: rule__AnnotationAttribute__Alternatives
            {
            pushFollow(FOLLOW_rule__AnnotationAttribute__Alternatives_in_ruleAnnotationAttribute338);
            rule__AnnotationAttribute__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAnnotationAttributeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnnotationAttribute"


    // $ANTLR start "entryRuleSimpleAnnotationAttribute"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:204:1: entryRuleSimpleAnnotationAttribute : ruleSimpleAnnotationAttribute EOF ;
    public final void entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:205:1: ( ruleSimpleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:206:1: ruleSimpleAnnotationAttribute EOF
            {
             before(grammarAccess.getSimpleAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute365);
            ruleSimpleAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getSimpleAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute372); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleAnnotationAttribute"


    // $ANTLR start "ruleSimpleAnnotationAttribute"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:213:1: ruleSimpleAnnotationAttribute : ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) ;
    public final void ruleSimpleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:217:2: ( ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:218:1: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:218:1: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:219:1: ( rule__SimpleAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:220:1: ( rule__SimpleAnnotationAttribute__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:220:2: rule__SimpleAnnotationAttribute__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__0_in_ruleSimpleAnnotationAttribute398);
            rule__SimpleAnnotationAttribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleAnnotationAttribute"


    // $ANTLR start "entryRuleEnumAnnotationAttribute"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:232:1: entryRuleEnumAnnotationAttribute : ruleEnumAnnotationAttribute EOF ;
    public final void entryRuleEnumAnnotationAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:233:1: ( ruleEnumAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:234:1: ruleEnumAnnotationAttribute EOF
            {
             before(grammarAccess.getEnumAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute425);
            ruleEnumAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getEnumAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute432); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumAnnotationAttribute"


    // $ANTLR start "ruleEnumAnnotationAttribute"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:241:1: ruleEnumAnnotationAttribute : ( ( rule__EnumAnnotationAttribute__Group__0 ) ) ;
    public final void ruleEnumAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:245:2: ( ( ( rule__EnumAnnotationAttribute__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:246:1: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:246:1: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:247:1: ( rule__EnumAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:248:1: ( rule__EnumAnnotationAttribute__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:248:2: rule__EnumAnnotationAttribute__Group__0
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__0_in_ruleEnumAnnotationAttribute458);
            rule__EnumAnnotationAttribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumAnnotationAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumAnnotationAttribute"


    // $ANTLR start "entryRuleImportedFQN"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:262:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:263:1: ( ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:264:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN487);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN494); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImportedFQN"


    // $ANTLR start "ruleImportedFQN"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:271:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:275:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:276:1: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:276:1: ( ( rule__ImportedFQN__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:277:1: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:278:1: ( rule__ImportedFQN__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:278:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN520);
            rule__ImportedFQN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportedFQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImportedFQN"


    // $ANTLR start "entryRuleDocumentation"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:290:1: entryRuleDocumentation : ruleDocumentation EOF ;
    public final void entryRuleDocumentation() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:291:1: ( ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:292:1: ruleDocumentation EOF
            {
             before(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation547);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getDocumentationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation554); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDocumentation"


    // $ANTLR start "ruleDocumentation"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:299:1: ruleDocumentation : ( ( rule__Documentation__Group__0 ) ) ;
    public final void ruleDocumentation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:303:2: ( ( ( rule__Documentation__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:304:1: ( ( rule__Documentation__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:304:1: ( ( rule__Documentation__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:305:1: ( rule__Documentation__Group__0 )
            {
             before(grammarAccess.getDocumentationAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:306:1: ( rule__Documentation__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:306:2: rule__Documentation__Group__0
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0_in_ruleDocumentation580);
            rule__Documentation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDocumentationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDocumentation"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:322:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:323:1: ( ruleLiteral EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:324:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral611);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral618); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:331:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:335:2: ( ( ( rule__Literal__Alternatives ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:336:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:336:1: ( ( rule__Literal__Alternatives ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:337:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:338:1: ( rule__Literal__Alternatives )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:338:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral644);
            rule__Literal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleBooleanLiteral"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:350:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:351:1: ( ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:352:1: ruleBooleanLiteral EOF
            {
             before(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral671);
            ruleBooleanLiteral();

            state._fsp--;

             after(grammarAccess.getBooleanLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral678); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:359:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:363:2: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:364:1: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:364:1: ( ( rule__BooleanLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:365:1: ( rule__BooleanLiteral__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:366:1: ( rule__BooleanLiteral__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:366:2: rule__BooleanLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral704);
            rule__BooleanLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBooleanLiteralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleNumberLiteral"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:378:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:379:1: ( ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:380:1: ruleNumberLiteral EOF
            {
             before(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral731);
            ruleNumberLiteral();

            state._fsp--;

             after(grammarAccess.getNumberLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral738); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:387:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Alternatives ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:391:2: ( ( ( rule__NumberLiteral__Alternatives ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:392:1: ( ( rule__NumberLiteral__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:392:1: ( ( rule__NumberLiteral__Alternatives ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:393:1: ( rule__NumberLiteral__Alternatives )
            {
             before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:394:1: ( rule__NumberLiteral__Alternatives )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:394:2: rule__NumberLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral764);
            rule__NumberLiteral__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNumberLiteralAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleRealLiteral"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:406:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:407:1: ( ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:408:1: ruleRealLiteral EOF
            {
             before(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral791);
            ruleRealLiteral();

            state._fsp--;

             after(grammarAccess.getRealLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral798); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRealLiteral"


    // $ANTLR start "ruleRealLiteral"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:415:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:419:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:420:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:420:1: ( ( rule__RealLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:421:1: ( rule__RealLiteral__Group__0 )
            {
             before(grammarAccess.getRealLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:422:1: ( rule__RealLiteral__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:422:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral824);
            rule__RealLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRealLiteralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRealLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:434:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:435:1: ( ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:436:1: ruleIntLiteral EOF
            {
             before(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral851);
            ruleIntLiteral();

            state._fsp--;

             after(grammarAccess.getIntLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral858); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntLiteral"


    // $ANTLR start "ruleIntLiteral"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:443:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:447:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:448:1: ( ( rule__IntLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:448:1: ( ( rule__IntLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:449:1: ( rule__IntLiteral__Group__0 )
            {
             before(grammarAccess.getIntLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:450:1: ( rule__IntLiteral__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:450:2: rule__IntLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral884);
            rule__IntLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntLiteralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:462:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:463:1: ( ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:464:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral911);
            ruleStringLiteral();

            state._fsp--;

             after(grammarAccess.getStringLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral918); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:471:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:475:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:476:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:476:1: ( ( rule__StringLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:477:1: ( rule__StringLiteral__Group__0 )
            {
             before(grammarAccess.getStringLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:478:1: ( rule__StringLiteral__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:478:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral944);
            rule__StringLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStringLiteralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleInteger"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:490:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:491:1: ( ruleInteger EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:492:1: ruleInteger EOF
            {
             before(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger971);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger978); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInteger"


    // $ANTLR start "ruleInteger"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:499:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:503:2: ( ( ( rule__Integer__Alternatives ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:504:1: ( ( rule__Integer__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:504:1: ( ( rule__Integer__Alternatives ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:505:1: ( rule__Integer__Alternatives )
            {
             before(grammarAccess.getIntegerAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:506:1: ( rule__Integer__Alternatives )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:506:2: rule__Integer__Alternatives
            {
            pushFollow(FOLLOW_rule__Integer__Alternatives_in_ruleInteger1004);
            rule__Integer__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIntegerAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInteger"


    // $ANTLR start "entryRuleSignedInteger"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:518:1: entryRuleSignedInteger : ruleSignedInteger EOF ;
    public final void entryRuleSignedInteger() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:522:1: ( ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:523:1: ruleSignedInteger EOF
            {
             before(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger1036);
            ruleSignedInteger();

            state._fsp--;

             after(grammarAccess.getSignedIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger1043); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleSignedInteger"


    // $ANTLR start "ruleSignedInteger"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:533:1: ruleSignedInteger : ( ( rule__SignedInteger__Group__0 ) ) ;
    public final void ruleSignedInteger() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:538:2: ( ( ( rule__SignedInteger__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:539:1: ( ( rule__SignedInteger__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:539:1: ( ( rule__SignedInteger__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:540:1: ( rule__SignedInteger__Group__0 )
            {
             before(grammarAccess.getSignedIntegerAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:541:1: ( rule__SignedInteger__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:541:2: rule__SignedInteger__Group__0
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger1073);
            rule__SignedInteger__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSignedIntegerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleSignedInteger"


    // $ANTLR start "entryRuleHexadecimal"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:554:1: entryRuleHexadecimal : ruleHexadecimal EOF ;
    public final void entryRuleHexadecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:558:1: ( ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:559:1: ruleHexadecimal EOF
            {
             before(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal1105);
            ruleHexadecimal();

            state._fsp--;

             after(grammarAccess.getHexadecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal1112); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleHexadecimal"


    // $ANTLR start "ruleHexadecimal"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:569:1: ruleHexadecimal : ( RULE_HEX ) ;
    public final void ruleHexadecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:574:2: ( ( RULE_HEX ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:575:1: ( RULE_HEX )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:575:1: ( RULE_HEX )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:576:1: RULE_HEX
            {
             before(grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 
            match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal1142); 
             after(grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleHexadecimal"


    // $ANTLR start "entryRuleReal"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:590:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:591:1: ( ruleReal EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:592:1: ruleReal EOF
            {
             before(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal1168);
            ruleReal();

            state._fsp--;

             after(grammarAccess.getRealRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal1175); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReal"


    // $ANTLR start "ruleReal"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:599:1: ruleReal : ( ( rule__Real__Alternatives ) ) ;
    public final void ruleReal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:603:2: ( ( ( rule__Real__Alternatives ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:604:1: ( ( rule__Real__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:604:1: ( ( rule__Real__Alternatives ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:605:1: ( rule__Real__Alternatives )
            {
             before(grammarAccess.getRealAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:606:1: ( rule__Real__Alternatives )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:606:2: rule__Real__Alternatives
            {
            pushFollow(FOLLOW_rule__Real__Alternatives_in_ruleReal1201);
            rule__Real__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRealAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReal"


    // $ANTLR start "entryRuleDecimal"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:618:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:622:1: ( ruleDecimal EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:623:1: ruleDecimal EOF
            {
             before(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal1233);
            ruleDecimal();

            state._fsp--;

             after(grammarAccess.getDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal1240); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleDecimal"


    // $ANTLR start "ruleDecimal"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:633:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:638:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:639:1: ( ( rule__Decimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:639:1: ( ( rule__Decimal__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:640:1: ( rule__Decimal__Group__0 )
            {
             before(grammarAccess.getDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:641:1: ( rule__Decimal__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:641:2: rule__Decimal__Group__0
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1270);
            rule__Decimal__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDecimalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleDecimal"


    // $ANTLR start "entryRuleDotDecimal"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:654:1: entryRuleDotDecimal : ruleDotDecimal EOF ;
    public final void entryRuleDotDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:658:1: ( ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:659:1: ruleDotDecimal EOF
            {
             before(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1302);
            ruleDotDecimal();

            state._fsp--;

             after(grammarAccess.getDotDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal1309); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleDotDecimal"


    // $ANTLR start "ruleDotDecimal"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:669:1: ruleDotDecimal : ( ( rule__DotDecimal__Group__0 ) ) ;
    public final void ruleDotDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:674:2: ( ( ( rule__DotDecimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:675:1: ( ( rule__DotDecimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:675:1: ( ( rule__DotDecimal__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:676:1: ( rule__DotDecimal__Group__0 )
            {
             before(grammarAccess.getDotDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:677:1: ( rule__DotDecimal__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:677:2: rule__DotDecimal__Group__0
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1339);
            rule__DotDecimal__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDotDecimalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleDotDecimal"


    // $ANTLR start "entryRuleDecimalDot"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:690:1: entryRuleDecimalDot : ruleDecimalDot EOF ;
    public final void entryRuleDecimalDot() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:694:1: ( ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:695:1: ruleDecimalDot EOF
            {
             before(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1371);
            ruleDecimalDot();

            state._fsp--;

             after(grammarAccess.getDecimalDotRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot1378); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleDecimalDot"


    // $ANTLR start "ruleDecimalDot"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:705:1: ruleDecimalDot : ( ( rule__DecimalDot__Group__0 ) ) ;
    public final void ruleDecimalDot() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:710:2: ( ( ( rule__DecimalDot__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:711:1: ( ( rule__DecimalDot__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:711:1: ( ( rule__DecimalDot__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:712:1: ( rule__DecimalDot__Group__0 )
            {
             before(grammarAccess.getDecimalDotAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:713:1: ( rule__DecimalDot__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:713:2: rule__DecimalDot__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1408);
            rule__DecimalDot__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDecimalDotAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleDecimalDot"


    // $ANTLR start "entryRuleDecimalExp"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:726:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:730:1: ( ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:731:1: ruleDecimalExp EOF
            {
             before(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1440);
            ruleDecimalExp();

            state._fsp--;

             after(grammarAccess.getDecimalExpRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp1447); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleDecimalExp"


    // $ANTLR start "ruleDecimalExp"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:741:1: ruleDecimalExp : ( ( rule__DecimalExp__Group__0 ) ) ;
    public final void ruleDecimalExp() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:746:2: ( ( ( rule__DecimalExp__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:747:1: ( ( rule__DecimalExp__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:747:1: ( ( rule__DecimalExp__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:748:1: ( rule__DecimalExp__Group__0 )
            {
             before(grammarAccess.getDecimalExpAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:749:1: ( rule__DecimalExp__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:749:2: rule__DecimalExp__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1477);
            rule__DecimalExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDecimalExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleDecimalExp"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:762:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:763:1: ( ruleFQN EOF )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:764:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1504);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1511); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:771:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:775:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:776:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:776:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:777:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:778:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:778:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN1537);
            rule__FQN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "ruleLiteralType"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:791:1: ruleLiteralType : ( ( rule__LiteralType__Alternatives ) ) ;
    public final void ruleLiteralType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:795:1: ( ( ( rule__LiteralType__Alternatives ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:796:1: ( ( rule__LiteralType__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:796:1: ( ( rule__LiteralType__Alternatives ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:797:1: ( rule__LiteralType__Alternatives )
            {
             before(grammarAccess.getLiteralTypeAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:798:1: ( rule__LiteralType__Alternatives )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:798:2: rule__LiteralType__Alternatives
            {
            pushFollow(FOLLOW_rule__LiteralType__Alternatives_in_ruleLiteralType1574);
            rule__LiteralType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralType"


    // $ANTLR start "rule__AnnotationAttribute__Alternatives"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:810:1: rule__AnnotationAttribute__Alternatives : ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) );
    public final void rule__AnnotationAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:814:1: ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==33) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==24) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==RULE_ID) ) {
                        int LA2_4 = input.LA(4);

                        if ( (LA2_4==25) ) {
                            int LA2_5 = input.LA(5);

                            if ( ((LA2_5>=17 && LA2_5<=20)) ) {
                                alt2=1;
                            }
                            else if ( (LA2_5==26) ) {
                                alt2=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 2, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==13) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==24) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==RULE_ID) ) {
                        int LA2_4 = input.LA(4);

                        if ( (LA2_4==25) ) {
                            int LA2_5 = input.LA(5);

                            if ( ((LA2_5>=17 && LA2_5<=20)) ) {
                                alt2=1;
                            }
                            else if ( (LA2_5==26) ) {
                                alt2=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 2, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:815:1: ( ruleSimpleAnnotationAttribute )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:815:1: ( ruleSimpleAnnotationAttribute )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:816:1: ruleSimpleAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1610);
                    ruleSimpleAnnotationAttribute();

                    state._fsp--;

                     after(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:821:6: ( ruleEnumAnnotationAttribute )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:821:6: ( ruleEnumAnnotationAttribute )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:822:1: ruleEnumAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1627);
                    ruleEnumAnnotationAttribute();

                    state._fsp--;

                     after(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AnnotationAttribute__Alternatives"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Alternatives_0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:832:1: rule__SimpleAnnotationAttribute__Alternatives_0 : ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__SimpleAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:836:1: ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==33) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:837:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:837:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:838:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:839:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:839:2: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__OptionalAssignment_0_0_in_rule__SimpleAnnotationAttribute__Alternatives_01659);
                    rule__SimpleAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:843:6: ( 'mandatory' )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:843:6: ( 'mandatory' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:844:1: 'mandatory'
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__SimpleAnnotationAttribute__Alternatives_01678); 
                     after(grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Alternatives_0"


    // $ANTLR start "rule__EnumAnnotationAttribute__Alternatives_0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:856:1: rule__EnumAnnotationAttribute__Alternatives_0 : ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__EnumAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:860:1: ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==33) ) {
                alt4=1;
            }
            else if ( (LA4_0==13) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:861:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:861:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:862:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:863:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:863:2: rule__EnumAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__EnumAnnotationAttribute__OptionalAssignment_0_0_in_rule__EnumAnnotationAttribute__Alternatives_01712);
                    rule__EnumAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:867:6: ( 'mandatory' )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:867:6: ( 'mandatory' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:868:1: 'mandatory'
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__EnumAnnotationAttribute__Alternatives_01731); 
                     after(grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Alternatives_0"


    // $ANTLR start "rule__Literal__Alternatives"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:882:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:886:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 14:
            case 34:
                {
                alt5=1;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case 15:
            case 16:
            case 32:
                {
                alt5=2;
                }
                break;
            case RULE_STRING:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:887:1: ( ruleBooleanLiteral )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:887:1: ( ruleBooleanLiteral )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:888:1: ruleBooleanLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives1767);
                    ruleBooleanLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:893:6: ( ruleNumberLiteral )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:893:6: ( ruleNumberLiteral )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:894:1: ruleNumberLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives1784);
                    ruleNumberLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:899:6: ( ruleStringLiteral )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:899:6: ( ruleStringLiteral )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:900:1: ruleStringLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives1801);
                    ruleStringLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__BooleanLiteral__Alternatives_1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:910:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:914:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            else if ( (LA6_0==34) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:915:1: ( 'false' )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:915:1: ( 'false' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:916:1: 'false'
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    match(input,14,FOLLOW_14_in_rule__BooleanLiteral__Alternatives_11834); 
                     after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:923:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:923:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:924:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:925:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:925:2: rule__BooleanLiteral__IsTrueAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_11853);
                    rule__BooleanLiteral__IsTrueAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Alternatives_1"


    // $ANTLR start "rule__NumberLiteral__Alternatives"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:934:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:938:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
            int alt7=2;
            switch ( input.LA(1) ) {
            case 15:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_INT) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==32) ) {
                        alt7=2;
                    }
                    else if ( (LA7_3==EOF) ) {
                        alt7=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA7_1==32) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==32) ) {
                    alt7=2;
                }
                else if ( (LA7_2==RULE_INT) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==32) ) {
                        alt7=2;
                    }
                    else if ( (LA7_3==EOF) ) {
                        alt7=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA7_3 = input.LA(2);

                if ( (LA7_3==32) ) {
                    alt7=2;
                }
                else if ( (LA7_3==EOF) ) {
                    alt7=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt7=1;
                }
                break;
            case 32:
                {
                alt7=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:939:1: ( ruleIntLiteral )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:939:1: ( ruleIntLiteral )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:940:1: ruleIntLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives1886);
                    ruleIntLiteral();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:945:6: ( ruleRealLiteral )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:945:6: ( ruleRealLiteral )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:946:1: ruleRealLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives1903);
                    ruleRealLiteral();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberLiteral__Alternatives"


    // $ANTLR start "rule__Integer__Alternatives"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:956:1: rule__Integer__Alternatives : ( ( ruleSignedInteger ) | ( ruleHexadecimal ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:960:1: ( ( ruleSignedInteger ) | ( ruleHexadecimal ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_INT||(LA8_0>=15 && LA8_0<=16)) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_HEX) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:961:1: ( ruleSignedInteger )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:961:1: ( ruleSignedInteger )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:962:1: ruleSignedInteger
                    {
                     before(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives1935);
                    ruleSignedInteger();

                    state._fsp--;

                     after(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:967:6: ( ruleHexadecimal )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:967:6: ( ruleHexadecimal )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:968:1: ruleHexadecimal
                    {
                     before(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives1952);
                    ruleHexadecimal();

                    state._fsp--;

                     after(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integer__Alternatives"


    // $ANTLR start "rule__SignedInteger__Alternatives_0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:978:1: rule__SignedInteger__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__SignedInteger__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:982:1: ( ( '+' ) | ( '-' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            else if ( (LA9_0==16) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:983:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:983:1: ( '+' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:984:1: '+'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__SignedInteger__Alternatives_01985); 
                     after(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:991:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:991:6: ( '-' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:992:1: '-'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__SignedInteger__Alternatives_02005); 
                     after(grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SignedInteger__Alternatives_0"


    // $ANTLR start "rule__Real__Alternatives"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1004:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1008:1: ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) )
            int alt10=4;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1009:1: ( ruleDecimal )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1009:1: ( ruleDecimal )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1010:1: ruleDecimal
                    {
                     before(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDecimal_in_rule__Real__Alternatives2039);
                    ruleDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1015:6: ( ruleDotDecimal )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1015:6: ( ruleDotDecimal )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1016:1: ruleDotDecimal
                    {
                     before(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives2056);
                    ruleDotDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1021:6: ( ruleDecimalDot )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1021:6: ( ruleDecimalDot )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1022:1: ruleDecimalDot
                    {
                     before(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives2073);
                    ruleDecimalDot();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1027:6: ( ruleDecimalExp )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1027:6: ( ruleDecimalExp )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1028:1: ruleDecimalExp
                    {
                     before(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives2090);
                    ruleDecimalExp();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Real__Alternatives"


    // $ANTLR start "rule__Decimal__Alternatives_0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1038:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1042:1: ( ( '+' ) | ( '-' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==15) ) {
                alt11=1;
            }
            else if ( (LA11_0==16) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1043:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1043:1: ( '+' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1044:1: '+'
                    {
                     before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__Decimal__Alternatives_02123); 
                     after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1051:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1051:6: ( '-' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1052:1: '-'
                    {
                     before(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__Decimal__Alternatives_02143); 
                     after(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Alternatives_0"


    // $ANTLR start "rule__DotDecimal__Alternatives_0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1064:1: rule__DotDecimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DotDecimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1068:1: ( ( '+' ) | ( '-' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==15) ) {
                alt12=1;
            }
            else if ( (LA12_0==16) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1069:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1069:1: ( '+' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1070:1: '+'
                    {
                     before(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__DotDecimal__Alternatives_02178); 
                     after(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1077:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1077:6: ( '-' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1078:1: '-'
                    {
                     before(grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__DotDecimal__Alternatives_02198); 
                     after(grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Alternatives_0"


    // $ANTLR start "rule__DecimalDot__Alternatives_0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1090:1: rule__DecimalDot__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalDot__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1094:1: ( ( '+' ) | ( '-' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==15) ) {
                alt13=1;
            }
            else if ( (LA13_0==16) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1095:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1095:1: ( '+' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1096:1: '+'
                    {
                     before(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__DecimalDot__Alternatives_02233); 
                     after(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1103:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1103:6: ( '-' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1104:1: '-'
                    {
                     before(grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__DecimalDot__Alternatives_02253); 
                     after(grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Alternatives_0"


    // $ANTLR start "rule__DecimalExp__Alternatives_0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1116:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1120:1: ( ( '+' ) | ( '-' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==15) ) {
                alt14=1;
            }
            else if ( (LA14_0==16) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1121:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1121:1: ( '+' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1122:1: '+'
                    {
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__DecimalExp__Alternatives_02288); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1129:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1129:6: ( '-' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1130:1: '-'
                    {
                     before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__DecimalExp__Alternatives_02308); 
                     after(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Alternatives_0"


    // $ANTLR start "rule__LiteralType__Alternatives"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1142:1: rule__LiteralType__Alternatives : ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) );
    public final void rule__LiteralType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1146:1: ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt15=1;
                }
                break;
            case 18:
                {
                alt15=2;
                }
                break;
            case 19:
                {
                alt15=3;
                }
                break;
            case 20:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1147:1: ( ( 'ptBoolean' ) )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1147:1: ( ( 'ptBoolean' ) )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1148:1: ( 'ptBoolean' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1149:1: ( 'ptBoolean' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1149:3: 'ptBoolean'
                    {
                    match(input,17,FOLLOW_17_in_rule__LiteralType__Alternatives2343); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1154:6: ( ( 'ptInteger' ) )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1154:6: ( ( 'ptInteger' ) )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1155:1: ( 'ptInteger' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1156:1: ( 'ptInteger' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1156:3: 'ptInteger'
                    {
                    match(input,18,FOLLOW_18_in_rule__LiteralType__Alternatives2364); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1161:6: ( ( 'ptReal' ) )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1161:6: ( ( 'ptReal' ) )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1162:1: ( 'ptReal' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1163:1: ( 'ptReal' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1163:3: 'ptReal'
                    {
                    match(input,19,FOLLOW_19_in_rule__LiteralType__Alternatives2385); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1168:6: ( ( 'ptCharacter' ) )
                    {
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1168:6: ( ( 'ptCharacter' ) )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1169:1: ( 'ptCharacter' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1170:1: ( 'ptCharacter' )
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1170:3: 'ptCharacter'
                    {
                    match(input,20,FOLLOW_20_in_rule__LiteralType__Alternatives2406); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralType__Alternatives"


    // $ANTLR start "rule__Greeting__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1182:1: rule__Greeting__Group__0 : rule__Greeting__Group__0__Impl rule__Greeting__Group__1 ;
    public final void rule__Greeting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1186:1: ( rule__Greeting__Group__0__Impl rule__Greeting__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1187:2: rule__Greeting__Group__0__Impl rule__Greeting__Group__1
            {
            pushFollow(FOLLOW_rule__Greeting__Group__0__Impl_in_rule__Greeting__Group__02439);
            rule__Greeting__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Greeting__Group__1_in_rule__Greeting__Group__02442);
            rule__Greeting__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greeting__Group__0"


    // $ANTLR start "rule__Greeting__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1194:1: rule__Greeting__Group__0__Impl : ( 'Hello' ) ;
    public final void rule__Greeting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1198:1: ( ( 'Hello' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1199:1: ( 'Hello' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1199:1: ( 'Hello' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1200:1: 'Hello'
            {
             before(grammarAccess.getGreetingAccess().getHelloKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__Greeting__Group__0__Impl2470); 
             after(grammarAccess.getGreetingAccess().getHelloKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greeting__Group__0__Impl"


    // $ANTLR start "rule__Greeting__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1213:1: rule__Greeting__Group__1 : rule__Greeting__Group__1__Impl rule__Greeting__Group__2 ;
    public final void rule__Greeting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1217:1: ( rule__Greeting__Group__1__Impl rule__Greeting__Group__2 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1218:2: rule__Greeting__Group__1__Impl rule__Greeting__Group__2
            {
            pushFollow(FOLLOW_rule__Greeting__Group__1__Impl_in_rule__Greeting__Group__12501);
            rule__Greeting__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Greeting__Group__2_in_rule__Greeting__Group__12504);
            rule__Greeting__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greeting__Group__1"


    // $ANTLR start "rule__Greeting__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1225:1: rule__Greeting__Group__1__Impl : ( ( rule__Greeting__NameAssignment_1 ) ) ;
    public final void rule__Greeting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1229:1: ( ( ( rule__Greeting__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1230:1: ( ( rule__Greeting__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1230:1: ( ( rule__Greeting__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1231:1: ( rule__Greeting__NameAssignment_1 )
            {
             before(grammarAccess.getGreetingAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1232:1: ( rule__Greeting__NameAssignment_1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1232:2: rule__Greeting__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Greeting__NameAssignment_1_in_rule__Greeting__Group__1__Impl2531);
            rule__Greeting__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGreetingAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greeting__Group__1__Impl"


    // $ANTLR start "rule__Greeting__Group__2"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1242:1: rule__Greeting__Group__2 : rule__Greeting__Group__2__Impl ;
    public final void rule__Greeting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1246:1: ( rule__Greeting__Group__2__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1247:2: rule__Greeting__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Greeting__Group__2__Impl_in_rule__Greeting__Group__22561);
            rule__Greeting__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greeting__Group__2"


    // $ANTLR start "rule__Greeting__Group__2__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1253:1: rule__Greeting__Group__2__Impl : ( '!' ) ;
    public final void rule__Greeting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1257:1: ( ( '!' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1258:1: ( '!' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1258:1: ( '!' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1259:1: '!'
            {
             before(grammarAccess.getGreetingAccess().getExclamationMarkKeyword_2()); 
            match(input,22,FOLLOW_22_in_rule__Greeting__Group__2__Impl2589); 
             after(grammarAccess.getGreetingAccess().getExclamationMarkKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greeting__Group__2__Impl"


    // $ANTLR start "rule__KeyValue__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1281:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1285:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1286:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__0__Impl_in_rule__KeyValue__Group__02629);
            rule__KeyValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeyValue__Group__1_in_rule__KeyValue__Group__02632);
            rule__KeyValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__0"


    // $ANTLR start "rule__KeyValue__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1293:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1297:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1298:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1298:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1299:1: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1300:1: ( rule__KeyValue__KeyAssignment_0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1300:2: rule__KeyValue__KeyAssignment_0
            {
            pushFollow(FOLLOW_rule__KeyValue__KeyAssignment_0_in_rule__KeyValue__Group__0__Impl2659);
            rule__KeyValue__KeyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__0__Impl"


    // $ANTLR start "rule__KeyValue__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1310:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1314:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1315:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__1__Impl_in_rule__KeyValue__Group__12689);
            rule__KeyValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeyValue__Group__2_in_rule__KeyValue__Group__12692);
            rule__KeyValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__1"


    // $ANTLR start "rule__KeyValue__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1322:1: rule__KeyValue__Group__1__Impl : ( '=' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1326:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1327:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1327:1: ( '=' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1328:1: '='
            {
             before(grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1()); 
            match(input,23,FOLLOW_23_in_rule__KeyValue__Group__1__Impl2720); 
             after(grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__1__Impl"


    // $ANTLR start "rule__KeyValue__Group__2"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1341:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1345:1: ( rule__KeyValue__Group__2__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1346:2: rule__KeyValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__2__Impl_in_rule__KeyValue__Group__22751);
            rule__KeyValue__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__2"


    // $ANTLR start "rule__KeyValue__Group__2__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1352:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1356:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1357:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1357:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1358:1: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1359:1: ( rule__KeyValue__ValueAssignment_2 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1359:2: rule__KeyValue__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__KeyValue__ValueAssignment_2_in_rule__KeyValue__Group__2__Impl2778);
            rule__KeyValue__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__2__Impl"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1378:1: rule__SimpleAnnotationAttribute__Group__0 : rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 ;
    public final void rule__SimpleAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1382:1: ( rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1383:2: rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__0__Impl_in_rule__SimpleAnnotationAttribute__Group__02817);
            rule__SimpleAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__1_in_rule__SimpleAnnotationAttribute__Group__02820);
            rule__SimpleAnnotationAttribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__0"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1390:1: rule__SimpleAnnotationAttribute__Group__0__Impl : ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1394:1: ( ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1395:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1395:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1396:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1397:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1397:2: rule__SimpleAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Alternatives_0_in_rule__SimpleAnnotationAttribute__Group__0__Impl2847);
            rule__SimpleAnnotationAttribute__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__0__Impl"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1407:1: rule__SimpleAnnotationAttribute__Group__1 : rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 ;
    public final void rule__SimpleAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1411:1: ( rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1412:2: rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__1__Impl_in_rule__SimpleAnnotationAttribute__Group__12877);
            rule__SimpleAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__2_in_rule__SimpleAnnotationAttribute__Group__12880);
            rule__SimpleAnnotationAttribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__1"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1419:1: rule__SimpleAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1423:1: ( ( 'attribute' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1424:1: ( 'attribute' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1424:1: ( 'attribute' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1425:1: 'attribute'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,24,FOLLOW_24_in_rule__SimpleAnnotationAttribute__Group__1__Impl2908); 
             after(grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__1__Impl"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__2"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1438:1: rule__SimpleAnnotationAttribute__Group__2 : rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 ;
    public final void rule__SimpleAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1442:1: ( rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1443:2: rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__2__Impl_in_rule__SimpleAnnotationAttribute__Group__22939);
            rule__SimpleAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__3_in_rule__SimpleAnnotationAttribute__Group__22942);
            rule__SimpleAnnotationAttribute__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__2"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__2__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1450:1: rule__SimpleAnnotationAttribute__Group__2__Impl : ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1454:1: ( ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1455:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1455:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1456:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1457:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1457:2: rule__SimpleAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__NameAssignment_2_in_rule__SimpleAnnotationAttribute__Group__2__Impl2969);
            rule__SimpleAnnotationAttribute__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__2__Impl"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__3"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1467:1: rule__SimpleAnnotationAttribute__Group__3 : rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 ;
    public final void rule__SimpleAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1471:1: ( rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1472:2: rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__3__Impl_in_rule__SimpleAnnotationAttribute__Group__32999);
            rule__SimpleAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__4_in_rule__SimpleAnnotationAttribute__Group__33002);
            rule__SimpleAnnotationAttribute__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__3"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__3__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1479:1: rule__SimpleAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1483:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1484:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1484:1: ( ':' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1485:1: ':'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,25,FOLLOW_25_in_rule__SimpleAnnotationAttribute__Group__3__Impl3030); 
             after(grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__3__Impl"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__4"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1498:1: rule__SimpleAnnotationAttribute__Group__4 : rule__SimpleAnnotationAttribute__Group__4__Impl ;
    public final void rule__SimpleAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1502:1: ( rule__SimpleAnnotationAttribute__Group__4__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1503:2: rule__SimpleAnnotationAttribute__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__4__Impl_in_rule__SimpleAnnotationAttribute__Group__43061);
            rule__SimpleAnnotationAttribute__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__4"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__4__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1509:1: rule__SimpleAnnotationAttribute__Group__4__Impl : ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1513:1: ( ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1514:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1514:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1515:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1516:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1516:2: rule__SimpleAnnotationAttribute__TypeAssignment_4
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__TypeAssignment_4_in_rule__SimpleAnnotationAttribute__Group__4__Impl3088);
            rule__SimpleAnnotationAttribute__TypeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__4__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1536:1: rule__EnumAnnotationAttribute__Group__0 : rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 ;
    public final void rule__EnumAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1540:1: ( rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1541:2: rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__0__Impl_in_rule__EnumAnnotationAttribute__Group__03128);
            rule__EnumAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__1_in_rule__EnumAnnotationAttribute__Group__03131);
            rule__EnumAnnotationAttribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__0"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1548:1: rule__EnumAnnotationAttribute__Group__0__Impl : ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1552:1: ( ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1553:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1553:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1554:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1555:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1555:2: rule__EnumAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Alternatives_0_in_rule__EnumAnnotationAttribute__Group__0__Impl3158);
            rule__EnumAnnotationAttribute__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__0__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1565:1: rule__EnumAnnotationAttribute__Group__1 : rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 ;
    public final void rule__EnumAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1569:1: ( rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1570:2: rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__1__Impl_in_rule__EnumAnnotationAttribute__Group__13188);
            rule__EnumAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__2_in_rule__EnumAnnotationAttribute__Group__13191);
            rule__EnumAnnotationAttribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__1"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1577:1: rule__EnumAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__EnumAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1581:1: ( ( 'attribute' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1582:1: ( 'attribute' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1582:1: ( 'attribute' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1583:1: 'attribute'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,24,FOLLOW_24_in_rule__EnumAnnotationAttribute__Group__1__Impl3219); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__1__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__2"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1596:1: rule__EnumAnnotationAttribute__Group__2 : rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 ;
    public final void rule__EnumAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1600:1: ( rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1601:2: rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__2__Impl_in_rule__EnumAnnotationAttribute__Group__23250);
            rule__EnumAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__3_in_rule__EnumAnnotationAttribute__Group__23253);
            rule__EnumAnnotationAttribute__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__2"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__2__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1608:1: rule__EnumAnnotationAttribute__Group__2__Impl : ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1612:1: ( ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1613:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1613:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1614:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1615:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1615:2: rule__EnumAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__NameAssignment_2_in_rule__EnumAnnotationAttribute__Group__2__Impl3280);
            rule__EnumAnnotationAttribute__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__2__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__3"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1625:1: rule__EnumAnnotationAttribute__Group__3 : rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 ;
    public final void rule__EnumAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1629:1: ( rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1630:2: rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__3__Impl_in_rule__EnumAnnotationAttribute__Group__33310);
            rule__EnumAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__4_in_rule__EnumAnnotationAttribute__Group__33313);
            rule__EnumAnnotationAttribute__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__3"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__3__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1637:1: rule__EnumAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1641:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1642:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1642:1: ( ':' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1643:1: ':'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,25,FOLLOW_25_in_rule__EnumAnnotationAttribute__Group__3__Impl3341); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__3__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__4"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1656:1: rule__EnumAnnotationAttribute__Group__4 : rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 ;
    public final void rule__EnumAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1660:1: ( rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1661:2: rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__4__Impl_in_rule__EnumAnnotationAttribute__Group__43372);
            rule__EnumAnnotationAttribute__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__5_in_rule__EnumAnnotationAttribute__Group__43375);
            rule__EnumAnnotationAttribute__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__4"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__4__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1668:1: rule__EnumAnnotationAttribute__Group__4__Impl : ( '{' ) ;
    public final void rule__EnumAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1672:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1673:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1673:1: ( '{' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1674:1: '{'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,26,FOLLOW_26_in_rule__EnumAnnotationAttribute__Group__4__Impl3403); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__4__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__5"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1687:1: rule__EnumAnnotationAttribute__Group__5 : rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 ;
    public final void rule__EnumAnnotationAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1691:1: ( rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1692:2: rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__5__Impl_in_rule__EnumAnnotationAttribute__Group__53434);
            rule__EnumAnnotationAttribute__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__6_in_rule__EnumAnnotationAttribute__Group__53437);
            rule__EnumAnnotationAttribute__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__5"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__5__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1699:1: rule__EnumAnnotationAttribute__Group__5__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1703:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1704:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1704:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1705:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1706:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1706:2: rule__EnumAnnotationAttribute__ValuesAssignment_5
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_5_in_rule__EnumAnnotationAttribute__Group__5__Impl3464);
            rule__EnumAnnotationAttribute__ValuesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__5__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__6"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1716:1: rule__EnumAnnotationAttribute__Group__6 : rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 ;
    public final void rule__EnumAnnotationAttribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1720:1: ( rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1721:2: rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__6__Impl_in_rule__EnumAnnotationAttribute__Group__63494);
            rule__EnumAnnotationAttribute__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__7_in_rule__EnumAnnotationAttribute__Group__63497);
            rule__EnumAnnotationAttribute__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__6"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__6__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1728:1: rule__EnumAnnotationAttribute__Group__6__Impl : ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) ;
    public final void rule__EnumAnnotationAttribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1732:1: ( ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1733:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1733:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1734:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1735:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==28) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1735:2: rule__EnumAnnotationAttribute__Group_6__0
            	    {
            	    pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__0_in_rule__EnumAnnotationAttribute__Group__6__Impl3524);
            	    rule__EnumAnnotationAttribute__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__6__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__7"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1745:1: rule__EnumAnnotationAttribute__Group__7 : rule__EnumAnnotationAttribute__Group__7__Impl ;
    public final void rule__EnumAnnotationAttribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1749:1: ( rule__EnumAnnotationAttribute__Group__7__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1750:2: rule__EnumAnnotationAttribute__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__7__Impl_in_rule__EnumAnnotationAttribute__Group__73555);
            rule__EnumAnnotationAttribute__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__7"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__7__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1756:1: rule__EnumAnnotationAttribute__Group__7__Impl : ( '}' ) ;
    public final void rule__EnumAnnotationAttribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1760:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1761:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1761:1: ( '}' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1762:1: '}'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7()); 
            match(input,27,FOLLOW_27_in_rule__EnumAnnotationAttribute__Group__7__Impl3583); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__7__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group_6__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1791:1: rule__EnumAnnotationAttribute__Group_6__0 : rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 ;
    public final void rule__EnumAnnotationAttribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1795:1: ( rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1796:2: rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__0__Impl_in_rule__EnumAnnotationAttribute__Group_6__03630);
            rule__EnumAnnotationAttribute__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__1_in_rule__EnumAnnotationAttribute__Group_6__03633);
            rule__EnumAnnotationAttribute__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group_6__0"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group_6__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1803:1: rule__EnumAnnotationAttribute__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1807:1: ( ( ',' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1808:1: ( ',' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1808:1: ( ',' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1809:1: ','
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0()); 
            match(input,28,FOLLOW_28_in_rule__EnumAnnotationAttribute__Group_6__0__Impl3661); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group_6__0__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group_6__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1822:1: rule__EnumAnnotationAttribute__Group_6__1 : rule__EnumAnnotationAttribute__Group_6__1__Impl ;
    public final void rule__EnumAnnotationAttribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1826:1: ( rule__EnumAnnotationAttribute__Group_6__1__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1827:2: rule__EnumAnnotationAttribute__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__1__Impl_in_rule__EnumAnnotationAttribute__Group_6__13692);
            rule__EnumAnnotationAttribute__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group_6__1"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group_6__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1833:1: rule__EnumAnnotationAttribute__Group_6__1__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1837:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1838:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1838:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1839:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1840:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1840:2: rule__EnumAnnotationAttribute__ValuesAssignment_6_1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_6_1_in_rule__EnumAnnotationAttribute__Group_6__1__Impl3719);
            rule__EnumAnnotationAttribute__ValuesAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group_6__1__Impl"


    // $ANTLR start "rule__ImportedFQN__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1856:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1860:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1861:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__03755);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__03758);
            rule__ImportedFQN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__0"


    // $ANTLR start "rule__ImportedFQN__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1868:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1872:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1873:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1873:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1874:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl3785);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__0__Impl"


    // $ANTLR start "rule__ImportedFQN__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1885:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1889:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1890:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__13814);
            rule__ImportedFQN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__1"


    // $ANTLR start "rule__ImportedFQN__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1896:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1900:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1901:1: ( ( '.*' )? )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1901:1: ( ( '.*' )? )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1902:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1903:1: ( '.*' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1904:2: '.*'
                    {
                    match(input,29,FOLLOW_29_in_rule__ImportedFQN__Group__1__Impl3843); 

                    }
                    break;

            }

             after(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__1__Impl"


    // $ANTLR start "rule__Documentation__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1919:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1923:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1924:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__03880);
            rule__Documentation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__03883);
            rule__Documentation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__0"


    // $ANTLR start "rule__Documentation__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1931:1: rule__Documentation__Group__0__Impl : ( () ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1935:1: ( ( () ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1936:1: ( () )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1936:1: ( () )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1937:1: ()
            {
             before(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1938:1: ()
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1940:1: 
            {
            }

             after(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__0__Impl"


    // $ANTLR start "rule__Documentation__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1950:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1954:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1955:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
            {
            pushFollow(FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__13941);
            rule__Documentation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__13944);
            rule__Documentation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__1"


    // $ANTLR start "rule__Documentation__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1962:1: rule__Documentation__Group__1__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1966:1: ( ( '[' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1967:1: ( '[' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1967:1: ( '[' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1968:1: '['
            {
             before(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__Documentation__Group__1__Impl3972); 
             after(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__1__Impl"


    // $ANTLR start "rule__Documentation__Group__2"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1981:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl rule__Documentation__Group__3 ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1985:1: ( rule__Documentation__Group__2__Impl rule__Documentation__Group__3 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1986:2: rule__Documentation__Group__2__Impl rule__Documentation__Group__3
            {
            pushFollow(FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__24003);
            rule__Documentation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__3_in_rule__Documentation__Group__24006);
            rule__Documentation__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__2"


    // $ANTLR start "rule__Documentation__Group__2__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1993:1: rule__Documentation__Group__2__Impl : ( ( rule__Documentation__LinesAssignment_2 )* ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1997:1: ( ( ( rule__Documentation__LinesAssignment_2 )* ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1998:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1998:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:1999:1: ( rule__Documentation__LinesAssignment_2 )*
            {
             before(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2000:1: ( rule__Documentation__LinesAssignment_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_STRING) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2000:2: rule__Documentation__LinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Documentation__LinesAssignment_2_in_rule__Documentation__Group__2__Impl4033);
            	    rule__Documentation__LinesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__2__Impl"


    // $ANTLR start "rule__Documentation__Group__3"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2010:1: rule__Documentation__Group__3 : rule__Documentation__Group__3__Impl ;
    public final void rule__Documentation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2014:1: ( rule__Documentation__Group__3__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2015:2: rule__Documentation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Documentation__Group__3__Impl_in_rule__Documentation__Group__34064);
            rule__Documentation__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__3"


    // $ANTLR start "rule__Documentation__Group__3__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2021:1: rule__Documentation__Group__3__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2025:1: ( ( ']' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2026:1: ( ']' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2026:1: ( ']' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2027:1: ']'
            {
             before(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3()); 
            match(input,31,FOLLOW_31_in_rule__Documentation__Group__3__Impl4092); 
             after(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__3__Impl"


    // $ANTLR start "rule__BooleanLiteral__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2054:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2058:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2059:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__04137);
            rule__BooleanLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__04140);
            rule__BooleanLiteral__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Group__0"


    // $ANTLR start "rule__BooleanLiteral__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2066:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2070:1: ( ( () ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2071:1: ( () )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2071:1: ( () )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2072:1: ()
            {
             before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2073:1: ()
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2075:1: 
            {
            }

             after(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Group__0__Impl"


    // $ANTLR start "rule__BooleanLiteral__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2085:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2089:1: ( rule__BooleanLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2090:2: rule__BooleanLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__14198);
            rule__BooleanLiteral__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Group__1"


    // $ANTLR start "rule__BooleanLiteral__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2096:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2100:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2101:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2101:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2102:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2103:1: ( rule__BooleanLiteral__Alternatives_1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2103:2: rule__BooleanLiteral__Alternatives_1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl4225);
            rule__BooleanLiteral__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Group__1__Impl"


    // $ANTLR start "rule__RealLiteral__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2117:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2121:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2122:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__04259);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__04262);
            rule__RealLiteral__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__0"


    // $ANTLR start "rule__RealLiteral__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2129:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2133:1: ( ( () ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2134:1: ( () )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2134:1: ( () )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2135:1: ()
            {
             before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2136:1: ()
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2138:1: 
            {
            }

             after(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__0__Impl"


    // $ANTLR start "rule__RealLiteral__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2148:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2152:1: ( rule__RealLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2153:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__14320);
            rule__RealLiteral__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__1"


    // $ANTLR start "rule__RealLiteral__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2159:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2163:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2164:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2164:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2165:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2166:1: ( rule__RealLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2166:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl4347);
            rule__RealLiteral__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__1__Impl"


    // $ANTLR start "rule__IntLiteral__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2180:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2184:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2185:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__04381);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__04384);
            rule__IntLiteral__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__Group__0"


    // $ANTLR start "rule__IntLiteral__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2192:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2196:1: ( ( () ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2197:1: ( () )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2197:1: ( () )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2198:1: ()
            {
             before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2199:1: ()
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2201:1: 
            {
            }

             after(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__Group__0__Impl"


    // $ANTLR start "rule__IntLiteral__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2211:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2215:1: ( rule__IntLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2216:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__14442);
            rule__IntLiteral__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__Group__1"


    // $ANTLR start "rule__IntLiteral__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2222:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2226:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2227:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2227:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2228:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2229:1: ( rule__IntLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2229:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl4469);
            rule__IntLiteral__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__Group__1__Impl"


    // $ANTLR start "rule__StringLiteral__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2243:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2247:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2248:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__04503);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__04506);
            rule__StringLiteral__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__0"


    // $ANTLR start "rule__StringLiteral__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2255:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2259:1: ( ( () ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2260:1: ( () )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2260:1: ( () )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2261:1: ()
            {
             before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2262:1: ()
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2264:1: 
            {
            }

             after(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__0__Impl"


    // $ANTLR start "rule__StringLiteral__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2274:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2278:1: ( rule__StringLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2279:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__14564);
            rule__StringLiteral__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__1"


    // $ANTLR start "rule__StringLiteral__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2285:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2289:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2290:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2290:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2291:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2292:1: ( rule__StringLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2292:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl4591);
            rule__StringLiteral__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__1__Impl"


    // $ANTLR start "rule__SignedInteger__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2306:1: rule__SignedInteger__Group__0 : rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 ;
    public final void rule__SignedInteger__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2310:1: ( rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2311:2: rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__04625);
            rule__SignedInteger__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__04628);
            rule__SignedInteger__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SignedInteger__Group__0"


    // $ANTLR start "rule__SignedInteger__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2318:1: rule__SignedInteger__Group__0__Impl : ( ( rule__SignedInteger__Alternatives_0 )? ) ;
    public final void rule__SignedInteger__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2322:1: ( ( ( rule__SignedInteger__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2323:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2323:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2324:1: ( rule__SignedInteger__Alternatives_0 )?
            {
             before(grammarAccess.getSignedIntegerAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2325:1: ( rule__SignedInteger__Alternatives_0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=15 && LA19_0<=16)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2325:2: rule__SignedInteger__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl4655);
                    rule__SignedInteger__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSignedIntegerAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SignedInteger__Group__0__Impl"


    // $ANTLR start "rule__SignedInteger__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2335:1: rule__SignedInteger__Group__1 : rule__SignedInteger__Group__1__Impl ;
    public final void rule__SignedInteger__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2339:1: ( rule__SignedInteger__Group__1__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2340:2: rule__SignedInteger__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__14686);
            rule__SignedInteger__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SignedInteger__Group__1"


    // $ANTLR start "rule__SignedInteger__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2346:1: rule__SignedInteger__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__SignedInteger__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2350:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2351:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2351:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2352:1: RULE_INT
            {
             before(grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl4713); 
             after(grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SignedInteger__Group__1__Impl"


    // $ANTLR start "rule__Decimal__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2367:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2371:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2372:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__04746);
            rule__Decimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__04749);
            rule__Decimal__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__0"


    // $ANTLR start "rule__Decimal__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2379:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2383:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2384:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2384:1: ( ( rule__Decimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2385:1: ( rule__Decimal__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2386:1: ( rule__Decimal__Alternatives_0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=15 && LA20_0<=16)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2386:2: rule__Decimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl4776);
                    rule__Decimal__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDecimalAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__0__Impl"


    // $ANTLR start "rule__Decimal__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2396:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2400:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2401:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__14807);
            rule__Decimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__14810);
            rule__Decimal__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__1"


    // $ANTLR start "rule__Decimal__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2408:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2412:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2413:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2413:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2414:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl4837); 
             after(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__1__Impl"


    // $ANTLR start "rule__Decimal__Group__2"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2425:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2429:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2430:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
            {
            pushFollow(FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__24866);
            rule__Decimal__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__24869);
            rule__Decimal__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__2"


    // $ANTLR start "rule__Decimal__Group__2__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2437:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2441:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2442:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2442:1: ( '.' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2443:1: '.'
            {
             before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__Decimal__Group__2__Impl4897); 
             after(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__2__Impl"


    // $ANTLR start "rule__Decimal__Group__3"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2456:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2460:1: ( rule__Decimal__Group__3__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2461:2: rule__Decimal__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__34928);
            rule__Decimal__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__3"


    // $ANTLR start "rule__Decimal__Group__3__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2467:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2471:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2472:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2472:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2473:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl4955); 
             after(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__3__Impl"


    // $ANTLR start "rule__DotDecimal__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2492:1: rule__DotDecimal__Group__0 : rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 ;
    public final void rule__DotDecimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2496:1: ( rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2497:2: rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__04992);
            rule__DotDecimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__04995);
            rule__DotDecimal__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Group__0"


    // $ANTLR start "rule__DotDecimal__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2504:1: rule__DotDecimal__Group__0__Impl : ( ( rule__DotDecimal__Alternatives_0 )? ) ;
    public final void rule__DotDecimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2508:1: ( ( ( rule__DotDecimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2509:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2509:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2510:1: ( rule__DotDecimal__Alternatives_0 )?
            {
             before(grammarAccess.getDotDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2511:1: ( rule__DotDecimal__Alternatives_0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=15 && LA21_0<=16)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2511:2: rule__DotDecimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl5022);
                    rule__DotDecimal__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDotDecimalAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Group__0__Impl"


    // $ANTLR start "rule__DotDecimal__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2521:1: rule__DotDecimal__Group__1 : rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 ;
    public final void rule__DotDecimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2525:1: ( rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2526:2: rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__15053);
            rule__DotDecimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__15056);
            rule__DotDecimal__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Group__1"


    // $ANTLR start "rule__DotDecimal__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2533:1: rule__DotDecimal__Group__1__Impl : ( '.' ) ;
    public final void rule__DotDecimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2537:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2538:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2538:1: ( '.' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2539:1: '.'
            {
             before(grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
            match(input,32,FOLLOW_32_in_rule__DotDecimal__Group__1__Impl5084); 
             after(grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Group__1__Impl"


    // $ANTLR start "rule__DotDecimal__Group__2"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2552:1: rule__DotDecimal__Group__2 : rule__DotDecimal__Group__2__Impl ;
    public final void rule__DotDecimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2556:1: ( rule__DotDecimal__Group__2__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2557:2: rule__DotDecimal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__25115);
            rule__DotDecimal__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Group__2"


    // $ANTLR start "rule__DotDecimal__Group__2__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2563:1: rule__DotDecimal__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DotDecimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2567:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2568:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2568:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2569:1: RULE_INT
            {
             before(grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl5142); 
             after(grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Group__2__Impl"


    // $ANTLR start "rule__DecimalDot__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2586:1: rule__DecimalDot__Group__0 : rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 ;
    public final void rule__DecimalDot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2590:1: ( rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2591:2: rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__05177);
            rule__DecimalDot__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__05180);
            rule__DecimalDot__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Group__0"


    // $ANTLR start "rule__DecimalDot__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2598:1: rule__DecimalDot__Group__0__Impl : ( ( rule__DecimalDot__Alternatives_0 )? ) ;
    public final void rule__DecimalDot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2602:1: ( ( ( rule__DecimalDot__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2603:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2603:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2604:1: ( rule__DecimalDot__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalDotAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2605:1: ( rule__DecimalDot__Alternatives_0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=15 && LA22_0<=16)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2605:2: rule__DecimalDot__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl5207);
                    rule__DecimalDot__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDecimalDotAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Group__0__Impl"


    // $ANTLR start "rule__DecimalDot__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2615:1: rule__DecimalDot__Group__1 : rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 ;
    public final void rule__DecimalDot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2619:1: ( rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2620:2: rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__15238);
            rule__DecimalDot__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__15241);
            rule__DecimalDot__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Group__1"


    // $ANTLR start "rule__DecimalDot__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2627:1: rule__DecimalDot__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalDot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2631:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2632:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2632:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2633:1: RULE_INT
            {
             before(grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl5268); 
             after(grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Group__1__Impl"


    // $ANTLR start "rule__DecimalDot__Group__2"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2644:1: rule__DecimalDot__Group__2 : rule__DecimalDot__Group__2__Impl ;
    public final void rule__DecimalDot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2648:1: ( rule__DecimalDot__Group__2__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2649:2: rule__DecimalDot__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__25297);
            rule__DecimalDot__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Group__2"


    // $ANTLR start "rule__DecimalDot__Group__2__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2655:1: rule__DecimalDot__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalDot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2659:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2660:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2660:1: ( '.' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2661:1: '.'
            {
             before(grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__DecimalDot__Group__2__Impl5325); 
             after(grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Group__2__Impl"


    // $ANTLR start "rule__DecimalExp__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2680:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2684:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2685:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__05362);
            rule__DecimalExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__05365);
            rule__DecimalExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__0"


    // $ANTLR start "rule__DecimalExp__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2692:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2696:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2697:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2697:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2698:1: ( rule__DecimalExp__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2699:1: ( rule__DecimalExp__Alternatives_0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=15 && LA23_0<=16)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2699:2: rule__DecimalExp__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl5392);
                    rule__DecimalExp__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__0__Impl"


    // $ANTLR start "rule__DecimalExp__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2709:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2713:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2714:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__15423);
            rule__DecimalExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__15426);
            rule__DecimalExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__1"


    // $ANTLR start "rule__DecimalExp__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2721:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2725:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2726:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2726:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2727:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl5453); 
             after(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__1__Impl"


    // $ANTLR start "rule__DecimalExp__Group__2"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2738:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2742:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2743:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__25482);
            rule__DecimalExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__25485);
            rule__DecimalExp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__2"


    // $ANTLR start "rule__DecimalExp__Group__2__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2750:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2754:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2755:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2755:1: ( '.' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2756:1: '.'
            {
             before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__DecimalExp__Group__2__Impl5513); 
             after(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__2__Impl"


    // $ANTLR start "rule__DecimalExp__Group__3"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2769:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2773:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2774:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__35544);
            rule__DecimalExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__35547);
            rule__DecimalExp__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__3"


    // $ANTLR start "rule__DecimalExp__Group__3__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2781:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2785:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2786:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2786:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2787:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl5574); 
             after(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__3__Impl"


    // $ANTLR start "rule__DecimalExp__Group__4"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2798:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2802:1: ( rule__DecimalExp__Group__4__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2803:2: rule__DecimalExp__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__45603);
            rule__DecimalExp__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__4"


    // $ANTLR start "rule__DecimalExp__Group__4__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2809:1: rule__DecimalExp__Group__4__Impl : ( RULE_EXP ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2813:1: ( ( RULE_EXP ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2814:1: ( RULE_EXP )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2814:1: ( RULE_EXP )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2815:1: RULE_EXP
            {
             before(grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 
            match(input,RULE_EXP,FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl5630); 
             after(grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__4__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2836:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2840:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2841:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__05669);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__05672);
            rule__FQN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__0"


    // $ANTLR start "rule__FQN__Group__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2848:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2852:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2853:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2853:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2854:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl5699); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__0__Impl"


    // $ANTLR start "rule__FQN__Group__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2865:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2869:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2870:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__15728);
            rule__FQN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__1"


    // $ANTLR start "rule__FQN__Group__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2876:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2880:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2881:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2881:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2882:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2883:1: ( rule__FQN__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==32) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2883:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl5755);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group_1__0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2897:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2901:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2902:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__05790);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__05793);
            rule__FQN__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__0"


    // $ANTLR start "rule__FQN__Group_1__0__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2909:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2913:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2914:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2914:1: ( '.' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2915:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,32,FOLLOW_32_in_rule__FQN__Group_1__0__Impl5821); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__0__Impl"


    // $ANTLR start "rule__FQN__Group_1__1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2928:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2932:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2933:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__15852);
            rule__FQN__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__1"


    // $ANTLR start "rule__FQN__Group_1__1__Impl"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2939:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2943:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2944:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2944:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2945:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl5879); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__1__Impl"


    // $ANTLR start "rule__FSMModel__GreetingsAssignment"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2961:1: rule__FSMModel__GreetingsAssignment : ( ruleGreeting ) ;
    public final void rule__FSMModel__GreetingsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2965:1: ( ( ruleGreeting ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2966:1: ( ruleGreeting )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2966:1: ( ruleGreeting )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2967:1: ruleGreeting
            {
             before(grammarAccess.getFSMModelAccess().getGreetingsGreetingParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleGreeting_in_rule__FSMModel__GreetingsAssignment5917);
            ruleGreeting();

            state._fsp--;

             after(grammarAccess.getFSMModelAccess().getGreetingsGreetingParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FSMModel__GreetingsAssignment"


    // $ANTLR start "rule__Greeting__NameAssignment_1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2976:1: rule__Greeting__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Greeting__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2980:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2981:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2981:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2982:1: RULE_ID
            {
             before(grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Greeting__NameAssignment_15948); 
             after(grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greeting__NameAssignment_1"


    // $ANTLR start "rule__KeyValue__KeyAssignment_0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2994:1: rule__KeyValue__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2998:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2999:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:2999:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3000:1: RULE_ID
            {
             before(grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__KeyValue__KeyAssignment_05982); 
             after(grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__KeyAssignment_0"


    // $ANTLR start "rule__KeyValue__ValueAssignment_2"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3009:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3013:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3014:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3014:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3015:1: ruleLiteral
            {
             before(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__KeyValue__ValueAssignment_26013);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__ValueAssignment_2"


    // $ANTLR start "rule__SimpleAnnotationAttribute__OptionalAssignment_0_0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3030:1: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__SimpleAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3034:1: ( ( ( 'optional' ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3035:1: ( ( 'optional' ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3035:1: ( ( 'optional' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3036:1: ( 'optional' )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3037:1: ( 'optional' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3038:1: 'optional'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,33,FOLLOW_33_in_rule__SimpleAnnotationAttribute__OptionalAssignment_0_06055); 
             after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 

            }

             after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__OptionalAssignment_0_0"


    // $ANTLR start "rule__SimpleAnnotationAttribute__NameAssignment_2"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3053:1: rule__SimpleAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3057:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3058:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3058:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3059:1: RULE_ID
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleAnnotationAttribute__NameAssignment_26094); 
             after(grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__NameAssignment_2"


    // $ANTLR start "rule__SimpleAnnotationAttribute__TypeAssignment_4"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3068:1: rule__SimpleAnnotationAttribute__TypeAssignment_4 : ( ruleLiteralType ) ;
    public final void rule__SimpleAnnotationAttribute__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3072:1: ( ( ruleLiteralType ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3073:1: ( ruleLiteralType )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3073:1: ( ruleLiteralType )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3074:1: ruleLiteralType
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleLiteralType_in_rule__SimpleAnnotationAttribute__TypeAssignment_46125);
            ruleLiteralType();

            state._fsp--;

             after(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__TypeAssignment_4"


    // $ANTLR start "rule__EnumAnnotationAttribute__OptionalAssignment_0_0"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3083:1: rule__EnumAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__EnumAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3087:1: ( ( ( 'optional' ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3088:1: ( ( 'optional' ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3088:1: ( ( 'optional' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3089:1: ( 'optional' )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3090:1: ( 'optional' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3091:1: 'optional'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,33,FOLLOW_33_in_rule__EnumAnnotationAttribute__OptionalAssignment_0_06161); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 

            }

             after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__OptionalAssignment_0_0"


    // $ANTLR start "rule__EnumAnnotationAttribute__NameAssignment_2"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3106:1: rule__EnumAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EnumAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3110:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3111:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3111:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3112:1: RULE_ID
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EnumAnnotationAttribute__NameAssignment_26200); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__NameAssignment_2"


    // $ANTLR start "rule__EnumAnnotationAttribute__ValuesAssignment_5"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3121:1: rule__EnumAnnotationAttribute__ValuesAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3125:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3126:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3126:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3127:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_56231); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__ValuesAssignment_5"


    // $ANTLR start "rule__EnumAnnotationAttribute__ValuesAssignment_6_1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3136:1: rule__EnumAnnotationAttribute__ValuesAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3140:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3141:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3141:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3142:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_6_16262); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__ValuesAssignment_6_1"


    // $ANTLR start "rule__Documentation__LinesAssignment_2"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3153:1: rule__Documentation__LinesAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Documentation__LinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3157:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3158:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3158:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3159:1: RULE_STRING
            {
             before(grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Documentation__LinesAssignment_26295); 
             after(grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__LinesAssignment_2"


    // $ANTLR start "rule__BooleanLiteral__IsTrueAssignment_1_1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3170:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3174:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3175:1: ( ( 'true' ) )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3175:1: ( ( 'true' ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3176:1: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3177:1: ( 'true' )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3178:1: 'true'
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            match(input,34,FOLLOW_34_in_rule__BooleanLiteral__IsTrueAssignment_1_16333); 
             after(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 

            }

             after(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__IsTrueAssignment_1_1"


    // $ANTLR start "rule__RealLiteral__ValueAssignment_1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3193:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3197:1: ( ( ruleReal ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3198:1: ( ruleReal )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3198:1: ( ruleReal )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3199:1: ruleReal
            {
             before(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_16372);
            ruleReal();

            state._fsp--;

             after(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__ValueAssignment_1"


    // $ANTLR start "rule__IntLiteral__ValueAssignment_1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3208:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3212:1: ( ( ruleInteger ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3213:1: ( ruleInteger )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3213:1: ( ruleInteger )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3214:1: ruleInteger
            {
             before(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_16403);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__ValueAssignment_1"


    // $ANTLR start "rule__StringLiteral__ValueAssignment_1"
    // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3223:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3227:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3228:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3228:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.fsm.ui/src-gen/org/eclipse/etrice/core/fsm/ui/contentassist/antlr/internal/InternalFSM.g:3229:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_16434); 
             after(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__ValueAssignment_1"

    // Delegated rules


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\12\uffff";
    static final String DFA10_eofS =
        "\5\uffff\1\6\1\uffff\1\10\2\uffff";
    static final String DFA10_minS =
        "\3\6\1\40\1\uffff\1\6\1\uffff\1\7\2\uffff";
    static final String DFA10_maxS =
        "\4\40\1\uffff\1\6\1\uffff\1\7\2\uffff";
    static final String DFA10_acceptS =
        "\4\uffff\1\2\1\uffff\1\3\1\uffff\1\1\1\4";
    static final String DFA10_specialS =
        "\12\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\3\10\uffff\1\1\1\2\17\uffff\1\4",
            "\1\3\31\uffff\1\4",
            "\1\3\31\uffff\1\4",
            "\1\5",
            "",
            "\1\7",
            "",
            "\1\11",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1004:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleFSMModel_in_entryRuleFSMModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFSMModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FSMModel__GreetingsAssignment_in_ruleFSMModel94 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleGreeting_in_entryRuleGreeting122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGreeting129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Greeting__Group__0_in_ruleGreeting155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_entryRuleKeyValue184 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValue191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__0_in_ruleKeyValue217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationTargetType253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotationTargetType279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute305 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationAttribute312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AnnotationAttribute__Alternatives_in_ruleAnnotationAttribute338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__0_in_ruleSimpleAnnotationAttribute398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__0_in_ruleEnumAnnotationAttribute458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0_in_ruleDocumentation580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral611 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral731 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral791 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral851 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger971 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integer__Alternatives_in_ruleInteger1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger1036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal1105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal1168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Real__Alternatives_in_ruleReal1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal1233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1371 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1504 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralType__Alternatives_in_ruleLiteralType1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__OptionalAssignment_0_0_in_rule__SimpleAnnotationAttribute__Alternatives_01659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__SimpleAnnotationAttribute__Alternatives_01678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__OptionalAssignment_0_0_in_rule__EnumAnnotationAttribute__Alternatives_01712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__EnumAnnotationAttribute__Alternatives_01731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives1801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__BooleanLiteral__Alternatives_11834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_11853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives1903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives1952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__SignedInteger__Alternatives_01985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__SignedInteger__Alternatives_02005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_rule__Real__Alternatives2039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives2056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives2090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Decimal__Alternatives_02123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Decimal__Alternatives_02143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DotDecimal__Alternatives_02178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DotDecimal__Alternatives_02198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalDot__Alternatives_02233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalDot__Alternatives_02253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalExp__Alternatives_02288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalExp__Alternatives_02308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__LiteralType__Alternatives2343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__LiteralType__Alternatives2364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__LiteralType__Alternatives2385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__LiteralType__Alternatives2406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Greeting__Group__0__Impl_in_rule__Greeting__Group__02439 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Greeting__Group__1_in_rule__Greeting__Group__02442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Greeting__Group__0__Impl2470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Greeting__Group__1__Impl_in_rule__Greeting__Group__12501 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Greeting__Group__2_in_rule__Greeting__Group__12504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Greeting__NameAssignment_1_in_rule__Greeting__Group__1__Impl2531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Greeting__Group__2__Impl_in_rule__Greeting__Group__22561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Greeting__Group__2__Impl2589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__0__Impl_in_rule__KeyValue__Group__02629 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__1_in_rule__KeyValue__Group__02632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__KeyAssignment_0_in_rule__KeyValue__Group__0__Impl2659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__1__Impl_in_rule__KeyValue__Group__12689 = new BitSet(new long[]{0x000000050001C160L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__2_in_rule__KeyValue__Group__12692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__KeyValue__Group__1__Impl2720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__2__Impl_in_rule__KeyValue__Group__22751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__ValueAssignment_2_in_rule__KeyValue__Group__2__Impl2778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__0__Impl_in_rule__SimpleAnnotationAttribute__Group__02817 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__1_in_rule__SimpleAnnotationAttribute__Group__02820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Alternatives_0_in_rule__SimpleAnnotationAttribute__Group__0__Impl2847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__1__Impl_in_rule__SimpleAnnotationAttribute__Group__12877 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__2_in_rule__SimpleAnnotationAttribute__Group__12880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__SimpleAnnotationAttribute__Group__1__Impl2908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__2__Impl_in_rule__SimpleAnnotationAttribute__Group__22939 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__3_in_rule__SimpleAnnotationAttribute__Group__22942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__NameAssignment_2_in_rule__SimpleAnnotationAttribute__Group__2__Impl2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__3__Impl_in_rule__SimpleAnnotationAttribute__Group__32999 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__4_in_rule__SimpleAnnotationAttribute__Group__33002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__SimpleAnnotationAttribute__Group__3__Impl3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__4__Impl_in_rule__SimpleAnnotationAttribute__Group__43061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__TypeAssignment_4_in_rule__SimpleAnnotationAttribute__Group__4__Impl3088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__0__Impl_in_rule__EnumAnnotationAttribute__Group__03128 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__1_in_rule__EnumAnnotationAttribute__Group__03131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Alternatives_0_in_rule__EnumAnnotationAttribute__Group__0__Impl3158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__1__Impl_in_rule__EnumAnnotationAttribute__Group__13188 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__2_in_rule__EnumAnnotationAttribute__Group__13191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__EnumAnnotationAttribute__Group__1__Impl3219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__2__Impl_in_rule__EnumAnnotationAttribute__Group__23250 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__3_in_rule__EnumAnnotationAttribute__Group__23253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__NameAssignment_2_in_rule__EnumAnnotationAttribute__Group__2__Impl3280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__3__Impl_in_rule__EnumAnnotationAttribute__Group__33310 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__4_in_rule__EnumAnnotationAttribute__Group__33313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__EnumAnnotationAttribute__Group__3__Impl3341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__4__Impl_in_rule__EnumAnnotationAttribute__Group__43372 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__5_in_rule__EnumAnnotationAttribute__Group__43375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__EnumAnnotationAttribute__Group__4__Impl3403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__5__Impl_in_rule__EnumAnnotationAttribute__Group__53434 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__6_in_rule__EnumAnnotationAttribute__Group__53437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_5_in_rule__EnumAnnotationAttribute__Group__5__Impl3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__6__Impl_in_rule__EnumAnnotationAttribute__Group__63494 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__7_in_rule__EnumAnnotationAttribute__Group__63497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__0_in_rule__EnumAnnotationAttribute__Group__6__Impl3524 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__7__Impl_in_rule__EnumAnnotationAttribute__Group__73555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__EnumAnnotationAttribute__Group__7__Impl3583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__0__Impl_in_rule__EnumAnnotationAttribute__Group_6__03630 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__1_in_rule__EnumAnnotationAttribute__Group_6__03633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__EnumAnnotationAttribute__Group_6__0__Impl3661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__1__Impl_in_rule__EnumAnnotationAttribute__Group_6__13692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_6_1_in_rule__EnumAnnotationAttribute__Group_6__1__Impl3719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__03755 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__03758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl3785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__13814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ImportedFQN__Group__1__Impl3843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__03880 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__03883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__13941 = new BitSet(new long[]{0x0000000080000100L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__13944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Documentation__Group__1__Impl3972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__24003 = new BitSet(new long[]{0x0000000080000100L});
    public static final BitSet FOLLOW_rule__Documentation__Group__3_in_rule__Documentation__Group__24006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__LinesAssignment_2_in_rule__Documentation__Group__2__Impl4033 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_rule__Documentation__Group__3__Impl_in_rule__Documentation__Group__34064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Documentation__Group__3__Impl4092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__04137 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__04140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__14198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl4225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__04259 = new BitSet(new long[]{0x0000000100018060L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__04262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__14320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl4347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__04381 = new BitSet(new long[]{0x0000000000018060L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__04384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__14442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl4469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__04503 = new BitSet(new long[]{0x000000050001C160L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__04506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__14564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl4591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__04625 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__04628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl4655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__14686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl4713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__04746 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__04749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl4776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__14807 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__14810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl4837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__24866 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__24869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Decimal__Group__2__Impl4897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__34928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl4955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__04992 = new BitSet(new long[]{0x0000000100018000L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__04995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl5022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__15053 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__15056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DotDecimal__Group__1__Impl5084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__25115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl5142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__05177 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__05180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl5207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__15238 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__15241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl5268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__25297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DecimalDot__Group__2__Impl5325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__05362 = new BitSet(new long[]{0x0000000100018060L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__05365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl5392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__15423 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__15426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl5453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__25482 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__25485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DecimalExp__Group__2__Impl5513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__35544 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__35547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl5574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__45603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl5630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__05669 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__05672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl5699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__15728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl5755 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__05790 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__05793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__FQN__Group_1__0__Impl5821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__15852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl5879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreeting_in_rule__FSMModel__GreetingsAssignment5917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Greeting__NameAssignment_15948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__KeyValue__KeyAssignment_05982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__KeyValue__ValueAssignment_26013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__SimpleAnnotationAttribute__OptionalAssignment_0_06055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleAnnotationAttribute__NameAssignment_26094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralType_in_rule__SimpleAnnotationAttribute__TypeAssignment_46125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__EnumAnnotationAttribute__OptionalAssignment_0_06161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EnumAnnotationAttribute__NameAssignment_26200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_56231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_6_16262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Documentation__LinesAssignment_26295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__BooleanLiteral__IsTrueAssignment_1_16333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_16372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_16403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_16434 = new BitSet(new long[]{0x0000000000000002L});

}