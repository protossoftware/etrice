package org.eclipse.etrice.core.ui.contentassist.antlr.internal; 

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
import org.eclipse.etrice.core.services.ConfigGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalConfigParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_HEX", "RULE_ID", "RULE_INT", "RULE_EXP", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'write'", "'model'", "'false'", "'+'", "'-'", "'ConfigModel'", "'{'", "'}'", "'SubSystemConfig'", "'dynamic configuration'", "'file path'", "'user import'", "'user constructor'", "'polling timer [ms]'", "'ActorClassConfig'", "'ActorInstanceConfig'", "'/'", "'ProtocolClassConfig'", "'regular'", "'conjugate'", "'Port'", "'InterfaceItem'", "'Attr'", "'='", "'min'", "'max'", "'import'", "'from'", "'.*'", "'.'", "','", "'read'", "'true'"
    };
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
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
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
    public static final int T__45=45;
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


        public InternalConfigParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConfigParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConfigParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g"; }


     
     	private ConfigGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ConfigGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleConfigModel"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:60:1: entryRuleConfigModel : ruleConfigModel EOF ;
    public final void entryRuleConfigModel() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:61:1: ( ruleConfigModel EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:62:1: ruleConfigModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelRule()); 
            }
            pushFollow(FOLLOW_ruleConfigModel_in_entryRuleConfigModel61);
            ruleConfigModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfigModel68); if (state.failed) return ;

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
    // $ANTLR end "entryRuleConfigModel"


    // $ANTLR start "ruleConfigModel"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:69:1: ruleConfigModel : ( ( rule__ConfigModel__Group__0 ) ) ;
    public final void ruleConfigModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:73:2: ( ( ( rule__ConfigModel__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:74:1: ( ( rule__ConfigModel__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:74:1: ( ( rule__ConfigModel__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:75:1: ( rule__ConfigModel__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:76:1: ( rule__ConfigModel__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:76:2: rule__ConfigModel__Group__0
            {
            pushFollow(FOLLOW_rule__ConfigModel__Group__0_in_ruleConfigModel94);
            rule__ConfigModel__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleConfigModel"


    // $ANTLR start "entryRuleConfigElement"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:88:1: entryRuleConfigElement : ruleConfigElement EOF ;
    public final void entryRuleConfigElement() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:89:1: ( ruleConfigElement EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:90:1: ruleConfigElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigElementRule()); 
            }
            pushFollow(FOLLOW_ruleConfigElement_in_entryRuleConfigElement121);
            ruleConfigElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigElementRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfigElement128); if (state.failed) return ;

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
    // $ANTLR end "entryRuleConfigElement"


    // $ANTLR start "ruleConfigElement"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:97:1: ruleConfigElement : ( ( rule__ConfigElement__Alternatives ) ) ;
    public final void ruleConfigElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:101:2: ( ( ( rule__ConfigElement__Alternatives ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:102:1: ( ( rule__ConfigElement__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:102:1: ( ( rule__ConfigElement__Alternatives ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:103:1: ( rule__ConfigElement__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigElementAccess().getAlternatives()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:104:1: ( rule__ConfigElement__Alternatives )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:104:2: rule__ConfigElement__Alternatives
            {
            pushFollow(FOLLOW_rule__ConfigElement__Alternatives_in_ruleConfigElement154);
            rule__ConfigElement__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigElementAccess().getAlternatives()); 
            }

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
    // $ANTLR end "ruleConfigElement"


    // $ANTLR start "entryRuleSubSystemConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:116:1: entryRuleSubSystemConfig : ruleSubSystemConfig EOF ;
    public final void entryRuleSubSystemConfig() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:117:1: ( ruleSubSystemConfig EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:118:1: ruleSubSystemConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigRule()); 
            }
            pushFollow(FOLLOW_ruleSubSystemConfig_in_entryRuleSubSystemConfig181);
            ruleSubSystemConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemConfig188); if (state.failed) return ;

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
    // $ANTLR end "entryRuleSubSystemConfig"


    // $ANTLR start "ruleSubSystemConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:125:1: ruleSubSystemConfig : ( ( rule__SubSystemConfig__Group__0 ) ) ;
    public final void ruleSubSystemConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:129:2: ( ( ( rule__SubSystemConfig__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:130:1: ( ( rule__SubSystemConfig__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:130:1: ( ( rule__SubSystemConfig__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:131:1: ( rule__SubSystemConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:132:1: ( rule__SubSystemConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:132:2: rule__SubSystemConfig__Group__0
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__0_in_ruleSubSystemConfig214);
            rule__SubSystemConfig__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleSubSystemConfig"


    // $ANTLR start "entryRuleDynamicConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:144:1: entryRuleDynamicConfig : ruleDynamicConfig EOF ;
    public final void entryRuleDynamicConfig() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:145:1: ( ruleDynamicConfig EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:146:1: ruleDynamicConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigRule()); 
            }
            pushFollow(FOLLOW_ruleDynamicConfig_in_entryRuleDynamicConfig241);
            ruleDynamicConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDynamicConfig248); if (state.failed) return ;

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
    // $ANTLR end "entryRuleDynamicConfig"


    // $ANTLR start "ruleDynamicConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:153:1: ruleDynamicConfig : ( ( rule__DynamicConfig__Group__0 ) ) ;
    public final void ruleDynamicConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:157:2: ( ( ( rule__DynamicConfig__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:158:1: ( ( rule__DynamicConfig__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:158:1: ( ( rule__DynamicConfig__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:159:1: ( rule__DynamicConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:160:1: ( rule__DynamicConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:160:2: rule__DynamicConfig__Group__0
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__0_in_ruleDynamicConfig274);
            rule__DynamicConfig__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleDynamicConfig"


    // $ANTLR start "entryRuleActorClassConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:172:1: entryRuleActorClassConfig : ruleActorClassConfig EOF ;
    public final void entryRuleActorClassConfig() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:173:1: ( ruleActorClassConfig EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:174:1: ruleActorClassConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigRule()); 
            }
            pushFollow(FOLLOW_ruleActorClassConfig_in_entryRuleActorClassConfig301);
            ruleActorClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorClassConfigRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorClassConfig308); if (state.failed) return ;

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
    // $ANTLR end "entryRuleActorClassConfig"


    // $ANTLR start "ruleActorClassConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:181:1: ruleActorClassConfig : ( ( rule__ActorClassConfig__Group__0 ) ) ;
    public final void ruleActorClassConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:185:2: ( ( ( rule__ActorClassConfig__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:186:1: ( ( rule__ActorClassConfig__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:186:1: ( ( rule__ActorClassConfig__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:187:1: ( rule__ActorClassConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:188:1: ( rule__ActorClassConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:188:2: rule__ActorClassConfig__Group__0
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__0_in_ruleActorClassConfig334);
            rule__ActorClassConfig__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorClassConfigAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleActorClassConfig"


    // $ANTLR start "entryRuleActorInstanceConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:200:1: entryRuleActorInstanceConfig : ruleActorInstanceConfig EOF ;
    public final void entryRuleActorInstanceConfig() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:201:1: ( ruleActorInstanceConfig EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:202:1: ruleActorInstanceConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigRule()); 
            }
            pushFollow(FOLLOW_ruleActorInstanceConfig_in_entryRuleActorInstanceConfig361);
            ruleActorInstanceConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorInstanceConfig368); if (state.failed) return ;

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
    // $ANTLR end "entryRuleActorInstanceConfig"


    // $ANTLR start "ruleActorInstanceConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:209:1: ruleActorInstanceConfig : ( ( rule__ActorInstanceConfig__Group__0 ) ) ;
    public final void ruleActorInstanceConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:213:2: ( ( ( rule__ActorInstanceConfig__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:214:1: ( ( rule__ActorInstanceConfig__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:214:1: ( ( rule__ActorInstanceConfig__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:215:1: ( rule__ActorInstanceConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:216:1: ( rule__ActorInstanceConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:216:2: rule__ActorInstanceConfig__Group__0
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__0_in_ruleActorInstanceConfig394);
            rule__ActorInstanceConfig__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleActorInstanceConfig"


    // $ANTLR start "entryRuleProtocolClassConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:228:1: entryRuleProtocolClassConfig : ruleProtocolClassConfig EOF ;
    public final void entryRuleProtocolClassConfig() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:229:1: ( ruleProtocolClassConfig EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:230:1: ruleProtocolClassConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigRule()); 
            }
            pushFollow(FOLLOW_ruleProtocolClassConfig_in_entryRuleProtocolClassConfig421);
            ruleProtocolClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolClassConfig428); if (state.failed) return ;

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
    // $ANTLR end "entryRuleProtocolClassConfig"


    // $ANTLR start "ruleProtocolClassConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:237:1: ruleProtocolClassConfig : ( ( rule__ProtocolClassConfig__Group__0 ) ) ;
    public final void ruleProtocolClassConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:241:2: ( ( ( rule__ProtocolClassConfig__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:242:1: ( ( rule__ProtocolClassConfig__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:242:1: ( ( rule__ProtocolClassConfig__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:243:1: ( rule__ProtocolClassConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:244:1: ( rule__ProtocolClassConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:244:2: rule__ProtocolClassConfig__Group__0
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__0_in_ruleProtocolClassConfig454);
            rule__ProtocolClassConfig__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleProtocolClassConfig"


    // $ANTLR start "entryRulePortClassConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:256:1: entryRulePortClassConfig : rulePortClassConfig EOF ;
    public final void entryRulePortClassConfig() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:257:1: ( rulePortClassConfig EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:258:1: rulePortClassConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigRule()); 
            }
            pushFollow(FOLLOW_rulePortClassConfig_in_entryRulePortClassConfig481);
            rulePortClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortClassConfigRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePortClassConfig488); if (state.failed) return ;

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
    // $ANTLR end "entryRulePortClassConfig"


    // $ANTLR start "rulePortClassConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:265:1: rulePortClassConfig : ( ( rule__PortClassConfig__Group__0 ) ) ;
    public final void rulePortClassConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:269:2: ( ( ( rule__PortClassConfig__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:270:1: ( ( rule__PortClassConfig__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:270:1: ( ( rule__PortClassConfig__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:271:1: ( rule__PortClassConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:272:1: ( rule__PortClassConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:272:2: rule__PortClassConfig__Group__0
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__0_in_rulePortClassConfig514);
            rule__PortClassConfig__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortClassConfigAccess().getGroup()); 
            }

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
    // $ANTLR end "rulePortClassConfig"


    // $ANTLR start "entryRulePortInstanceConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:284:1: entryRulePortInstanceConfig : rulePortInstanceConfig EOF ;
    public final void entryRulePortInstanceConfig() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:285:1: ( rulePortInstanceConfig EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:286:1: rulePortInstanceConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigRule()); 
            }
            pushFollow(FOLLOW_rulePortInstanceConfig_in_entryRulePortInstanceConfig541);
            rulePortInstanceConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortInstanceConfigRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePortInstanceConfig548); if (state.failed) return ;

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
    // $ANTLR end "entryRulePortInstanceConfig"


    // $ANTLR start "rulePortInstanceConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:293:1: rulePortInstanceConfig : ( ( rule__PortInstanceConfig__Group__0 ) ) ;
    public final void rulePortInstanceConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:297:2: ( ( ( rule__PortInstanceConfig__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:298:1: ( ( rule__PortInstanceConfig__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:298:1: ( ( rule__PortInstanceConfig__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:299:1: ( rule__PortInstanceConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:300:1: ( rule__PortInstanceConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:300:2: rule__PortInstanceConfig__Group__0
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__0_in_rulePortInstanceConfig574);
            rule__PortInstanceConfig__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortInstanceConfigAccess().getGroup()); 
            }

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
    // $ANTLR end "rulePortInstanceConfig"


    // $ANTLR start "entryRuleAttrClassConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:314:1: entryRuleAttrClassConfig : ruleAttrClassConfig EOF ;
    public final void entryRuleAttrClassConfig() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:315:1: ( ruleAttrClassConfig EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:316:1: ruleAttrClassConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigRule()); 
            }
            pushFollow(FOLLOW_ruleAttrClassConfig_in_entryRuleAttrClassConfig603);
            ruleAttrClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrClassConfig610); if (state.failed) return ;

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
    // $ANTLR end "entryRuleAttrClassConfig"


    // $ANTLR start "ruleAttrClassConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:323:1: ruleAttrClassConfig : ( ( rule__AttrClassConfig__Group__0 ) ) ;
    public final void ruleAttrClassConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:327:2: ( ( ( rule__AttrClassConfig__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:328:1: ( ( rule__AttrClassConfig__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:328:1: ( ( rule__AttrClassConfig__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:329:1: ( rule__AttrClassConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:330:1: ( rule__AttrClassConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:330:2: rule__AttrClassConfig__Group__0
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__0_in_ruleAttrClassConfig636);
            rule__AttrClassConfig__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleAttrClassConfig"


    // $ANTLR start "entryRuleAttrInstanceConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:342:1: entryRuleAttrInstanceConfig : ruleAttrInstanceConfig EOF ;
    public final void entryRuleAttrInstanceConfig() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:343:1: ( ruleAttrInstanceConfig EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:344:1: ruleAttrInstanceConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigRule()); 
            }
            pushFollow(FOLLOW_ruleAttrInstanceConfig_in_entryRuleAttrInstanceConfig663);
            ruleAttrInstanceConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrInstanceConfig670); if (state.failed) return ;

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
    // $ANTLR end "entryRuleAttrInstanceConfig"


    // $ANTLR start "ruleAttrInstanceConfig"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:351:1: ruleAttrInstanceConfig : ( ( rule__AttrInstanceConfig__Group__0 ) ) ;
    public final void ruleAttrInstanceConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:355:2: ( ( ( rule__AttrInstanceConfig__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:356:1: ( ( rule__AttrInstanceConfig__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:356:1: ( ( rule__AttrInstanceConfig__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:357:1: ( rule__AttrInstanceConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:358:1: ( rule__AttrInstanceConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:358:2: rule__AttrInstanceConfig__Group__0
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__0_in_ruleAttrInstanceConfig696);
            rule__AttrInstanceConfig__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleAttrInstanceConfig"


    // $ANTLR start "entryRuleRefPath"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:370:1: entryRuleRefPath : ruleRefPath EOF ;
    public final void entryRuleRefPath() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:371:1: ( ruleRefPath EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:372:1: ruleRefPath EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathRule()); 
            }
            pushFollow(FOLLOW_ruleRefPath_in_entryRuleRefPath723);
            ruleRefPath();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefPathRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefPath730); if (state.failed) return ;

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
    // $ANTLR end "entryRuleRefPath"


    // $ANTLR start "ruleRefPath"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:379:1: ruleRefPath : ( ( rule__RefPath__Group__0 ) ) ;
    public final void ruleRefPath() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:383:2: ( ( ( rule__RefPath__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:384:1: ( ( rule__RefPath__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:384:1: ( ( rule__RefPath__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:385:1: ( rule__RefPath__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:386:1: ( rule__RefPath__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:386:2: rule__RefPath__Group__0
            {
            pushFollow(FOLLOW_rule__RefPath__Group__0_in_ruleRefPath756);
            rule__RefPath__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefPathAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleRefPath"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:398:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:399:1: ( ruleImport EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:400:1: ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport783);
            ruleImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport790); if (state.failed) return ;

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:407:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:411:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:412:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:412:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:413:1: ( rule__Import__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:414:1: ( rule__Import__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:414:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport816);
            rule__Import__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportedFQN"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:426:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:427:1: ( ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:428:1: ruleImportedFQN EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportedFQNRule()); 
            }
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN843);
            ruleImportedFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportedFQNRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN850); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:435:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:439:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:440:1: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:440:1: ( ( rule__ImportedFQN__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:441:1: ( rule__ImportedFQN__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportedFQNAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:442:1: ( rule__ImportedFQN__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:442:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN876);
            rule__ImportedFQN__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportedFQNAccess().getGroup()); 
            }

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


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:454:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:455:1: ( ruleFQN EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:456:1: ruleFQN EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNRule()); 
            }
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN903);
            ruleFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFQNRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN910); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:463:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:467:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:468:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:468:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:469:1: ( rule__FQN__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:470:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:470:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN936);
            rule__FQN__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFQNAccess().getGroup()); 
            }

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


    // $ANTLR start "entryRuleLiteralArray"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:482:1: entryRuleLiteralArray : ruleLiteralArray EOF ;
    public final void entryRuleLiteralArray() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:483:1: ( ruleLiteralArray EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:484:1: ruleLiteralArray EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayRule()); 
            }
            pushFollow(FOLLOW_ruleLiteralArray_in_entryRuleLiteralArray963);
            ruleLiteralArray();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralArrayRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralArray970); if (state.failed) return ;

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
    // $ANTLR end "entryRuleLiteralArray"


    // $ANTLR start "ruleLiteralArray"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:491:1: ruleLiteralArray : ( ( rule__LiteralArray__Group__0 ) ) ;
    public final void ruleLiteralArray() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:495:2: ( ( ( rule__LiteralArray__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:496:1: ( ( rule__LiteralArray__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:496:1: ( ( rule__LiteralArray__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:497:1: ( rule__LiteralArray__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:498:1: ( rule__LiteralArray__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:498:2: rule__LiteralArray__Group__0
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group__0_in_ruleLiteralArray996);
            rule__LiteralArray__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralArrayAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleLiteralArray"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:510:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:511:1: ( ruleLiteral EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:512:1: ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1023);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1030); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:519:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:523:2: ( ( ( rule__Literal__Alternatives ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:524:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:524:1: ( ( rule__Literal__Alternatives ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:525:1: ( rule__Literal__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getAlternatives()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:526:1: ( rule__Literal__Alternatives )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:526:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral1056);
            rule__Literal__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getAlternatives()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:538:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:539:1: ( ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:540:1: ruleBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral1083);
            ruleBooleanLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral1090); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:547:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:551:2: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:552:1: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:552:1: ( ( rule__BooleanLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:553:1: ( rule__BooleanLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:554:1: ( rule__BooleanLiteral__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:554:2: rule__BooleanLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral1116);
            rule__BooleanLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:566:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:567:1: ( ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:568:1: ruleNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1143);
            ruleNumberLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral1150); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:575:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Alternatives ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:579:2: ( ( ( rule__NumberLiteral__Alternatives ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:580:1: ( ( rule__NumberLiteral__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:580:1: ( ( rule__NumberLiteral__Alternatives ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:581:1: ( rule__NumberLiteral__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:582:1: ( rule__NumberLiteral__Alternatives )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:582:2: rule__NumberLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral1176);
            rule__NumberLiteral__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:594:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:595:1: ( ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:596:1: ruleRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1203);
            ruleRealLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral1210); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:603:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:607:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:608:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:608:1: ( ( rule__RealLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:609:1: ( rule__RealLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:610:1: ( rule__RealLiteral__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:610:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral1236);
            rule__RealLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralAccess().getGroup()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:622:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:623:1: ( ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:624:1: ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral1263);
            ruleIntLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral1270); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:631:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:635:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:636:1: ( ( rule__IntLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:636:1: ( ( rule__IntLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:637:1: ( rule__IntLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:638:1: ( rule__IntLiteral__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:638:2: rule__IntLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral1296);
            rule__IntLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralAccess().getGroup()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:650:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:651:1: ( ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:652:1: ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1323);
            ruleStringLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral1330); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:659:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:663:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:664:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:664:1: ( ( rule__StringLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:665:1: ( rule__StringLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:666:1: ( rule__StringLiteral__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:666:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral1356);
            rule__StringLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralAccess().getGroup()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:678:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:679:1: ( ruleInteger EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:680:1: ruleInteger EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerRule()); 
            }
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger1383);
            ruleInteger();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger1390); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:687:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:691:2: ( ( ( rule__Integer__Alternatives ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:692:1: ( ( rule__Integer__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:692:1: ( ( rule__Integer__Alternatives ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:693:1: ( rule__Integer__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerAccess().getAlternatives()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:694:1: ( rule__Integer__Alternatives )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:694:2: rule__Integer__Alternatives
            {
            pushFollow(FOLLOW_rule__Integer__Alternatives_in_ruleInteger1416);
            rule__Integer__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerAccess().getAlternatives()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:706:1: entryRuleSignedInteger : ruleSignedInteger EOF ;
    public final void entryRuleSignedInteger() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:710:1: ( ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:711:1: ruleSignedInteger EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignedIntegerRule()); 
            }
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger1448);
            ruleSignedInteger();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSignedIntegerRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger1455); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:721:1: ruleSignedInteger : ( ( rule__SignedInteger__Group__0 ) ) ;
    public final void ruleSignedInteger() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:726:2: ( ( ( rule__SignedInteger__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:727:1: ( ( rule__SignedInteger__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:727:1: ( ( rule__SignedInteger__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:728:1: ( rule__SignedInteger__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignedIntegerAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:729:1: ( rule__SignedInteger__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:729:2: rule__SignedInteger__Group__0
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger1485);
            rule__SignedInteger__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSignedIntegerAccess().getGroup()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:742:1: entryRuleHexadecimal : ruleHexadecimal EOF ;
    public final void entryRuleHexadecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:746:1: ( ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:747:1: ruleHexadecimal EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexadecimalRule()); 
            }
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal1517);
            ruleHexadecimal();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexadecimalRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal1524); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:757:1: ruleHexadecimal : ( RULE_HEX ) ;
    public final void ruleHexadecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:762:2: ( ( RULE_HEX ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:763:1: ( RULE_HEX )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:763:1: ( RULE_HEX )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:764:1: RULE_HEX
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 
            }
            match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal1554); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:778:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:779:1: ( ruleReal EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:780:1: ruleReal EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealRule()); 
            }
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal1580);
            ruleReal();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal1587); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:787:1: ruleReal : ( ( rule__Real__Alternatives ) ) ;
    public final void ruleReal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:791:2: ( ( ( rule__Real__Alternatives ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:792:1: ( ( rule__Real__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:792:1: ( ( rule__Real__Alternatives ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:793:1: ( rule__Real__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealAccess().getAlternatives()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:794:1: ( rule__Real__Alternatives )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:794:2: rule__Real__Alternatives
            {
            pushFollow(FOLLOW_rule__Real__Alternatives_in_ruleReal1613);
            rule__Real__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealAccess().getAlternatives()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:806:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:810:1: ( ruleDecimal EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:811:1: ruleDecimal EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalRule()); 
            }
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal1645);
            ruleDecimal();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal1652); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:821:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:826:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:827:1: ( ( rule__Decimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:827:1: ( ( rule__Decimal__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:828:1: ( rule__Decimal__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:829:1: ( rule__Decimal__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:829:2: rule__Decimal__Group__0
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1682);
            rule__Decimal__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalAccess().getGroup()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:842:1: entryRuleDotDecimal : ruleDotDecimal EOF ;
    public final void entryRuleDotDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:846:1: ( ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:847:1: ruleDotDecimal EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDotDecimalRule()); 
            }
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1714);
            ruleDotDecimal();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDotDecimalRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal1721); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:857:1: ruleDotDecimal : ( ( rule__DotDecimal__Group__0 ) ) ;
    public final void ruleDotDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:862:2: ( ( ( rule__DotDecimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:863:1: ( ( rule__DotDecimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:863:1: ( ( rule__DotDecimal__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:864:1: ( rule__DotDecimal__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDotDecimalAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:865:1: ( rule__DotDecimal__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:865:2: rule__DotDecimal__Group__0
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1751);
            rule__DotDecimal__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDotDecimalAccess().getGroup()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:878:1: entryRuleDecimalDot : ruleDecimalDot EOF ;
    public final void entryRuleDecimalDot() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:882:1: ( ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:883:1: ruleDecimalDot EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalDotRule()); 
            }
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1783);
            ruleDecimalDot();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalDotRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot1790); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:893:1: ruleDecimalDot : ( ( rule__DecimalDot__Group__0 ) ) ;
    public final void ruleDecimalDot() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:898:2: ( ( ( rule__DecimalDot__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:899:1: ( ( rule__DecimalDot__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:899:1: ( ( rule__DecimalDot__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:900:1: ( rule__DecimalDot__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalDotAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:901:1: ( rule__DecimalDot__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:901:2: rule__DecimalDot__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1820);
            rule__DecimalDot__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalDotAccess().getGroup()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:914:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:918:1: ( ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:919:1: ruleDecimalExp EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpRule()); 
            }
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1852);
            ruleDecimalExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalExpRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp1859); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:929:1: ruleDecimalExp : ( ( rule__DecimalExp__Group__0 ) ) ;
    public final void ruleDecimalExp() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:934:2: ( ( ( rule__DecimalExp__Group__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:935:1: ( ( rule__DecimalExp__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:935:1: ( ( rule__DecimalExp__Group__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:936:1: ( rule__DecimalExp__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:937:1: ( rule__DecimalExp__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:937:2: rule__DecimalExp__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1889);
            rule__DecimalExp__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalExpAccess().getGroup()); 
            }

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


    // $ANTLR start "rule__ConfigElement__Alternatives"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:950:1: rule__ConfigElement__Alternatives : ( ( ruleSubSystemConfig ) | ( ruleActorClassConfig ) | ( ruleActorInstanceConfig ) | ( ruleProtocolClassConfig ) );
    public final void rule__ConfigElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:954:1: ( ( ruleSubSystemConfig ) | ( ruleActorClassConfig ) | ( ruleActorInstanceConfig ) | ( ruleProtocolClassConfig ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt1=1;
                }
                break;
            case 27:
                {
                alt1=2;
                }
                break;
            case 28:
                {
                alt1=3;
                }
                break;
            case 30:
                {
                alt1=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:955:1: ( ruleSubSystemConfig )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:955:1: ( ruleSubSystemConfig )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:956:1: ruleSubSystemConfig
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigElementAccess().getSubSystemConfigParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleSubSystemConfig_in_rule__ConfigElement__Alternatives1925);
                    ruleSubSystemConfig();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConfigElementAccess().getSubSystemConfigParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:961:6: ( ruleActorClassConfig )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:961:6: ( ruleActorClassConfig )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:962:1: ruleActorClassConfig
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigElementAccess().getActorClassConfigParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleActorClassConfig_in_rule__ConfigElement__Alternatives1942);
                    ruleActorClassConfig();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConfigElementAccess().getActorClassConfigParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:967:6: ( ruleActorInstanceConfig )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:967:6: ( ruleActorInstanceConfig )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:968:1: ruleActorInstanceConfig
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigElementAccess().getActorInstanceConfigParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleActorInstanceConfig_in_rule__ConfigElement__Alternatives1959);
                    ruleActorInstanceConfig();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConfigElementAccess().getActorInstanceConfigParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:973:6: ( ruleProtocolClassConfig )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:973:6: ( ruleProtocolClassConfig )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:974:1: ruleProtocolClassConfig
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigElementAccess().getProtocolClassConfigParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_ruleProtocolClassConfig_in_rule__ConfigElement__Alternatives1976);
                    ruleProtocolClassConfig();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConfigElementAccess().getProtocolClassConfigParserRuleCall_3()); 
                    }

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
    // $ANTLR end "rule__ConfigElement__Alternatives"


    // $ANTLR start "rule__DynamicConfig__Alternatives_2_0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:984:1: rule__DynamicConfig__Alternatives_2_0 : ( ( ( rule__DynamicConfig__Group_2_0_0__0 ) ) | ( ( rule__DynamicConfig__Group_2_0_1__0 ) ) );
    public final void rule__DynamicConfig__Alternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:988:1: ( ( ( rule__DynamicConfig__Group_2_0_0__0 ) ) | ( ( rule__DynamicConfig__Group_2_0_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==23) ) {
                alt2=1;
            }
            else if ( (LA2_0==24) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:989:1: ( ( rule__DynamicConfig__Group_2_0_0__0 ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:989:1: ( ( rule__DynamicConfig__Group_2_0_0__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:990:1: ( rule__DynamicConfig__Group_2_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:991:1: ( rule__DynamicConfig__Group_2_0_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:991:2: rule__DynamicConfig__Group_2_0_0__0
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_0__0_in_rule__DynamicConfig__Alternatives_2_02008);
                    rule__DynamicConfig__Group_2_0_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDynamicConfigAccess().getGroup_2_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:995:6: ( ( rule__DynamicConfig__Group_2_0_1__0 ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:995:6: ( ( rule__DynamicConfig__Group_2_0_1__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:996:1: ( rule__DynamicConfig__Group_2_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:997:1: ( rule__DynamicConfig__Group_2_0_1__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:997:2: rule__DynamicConfig__Group_2_0_1__0
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1__0_in_rule__DynamicConfig__Alternatives_2_02026);
                    rule__DynamicConfig__Group_2_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1()); 
                    }

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
    // $ANTLR end "rule__DynamicConfig__Alternatives_2_0"


    // $ANTLR start "rule__AttrInstanceConfig__Alternatives_3_1_0_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1007:1: rule__AttrInstanceConfig__Alternatives_3_1_0_1 : ( ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) ) | ( 'write' ) );
    public final void rule__AttrInstanceConfig__Alternatives_3_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1011:1: ( ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) ) | ( 'write' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==44) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1012:1: ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1012:1: ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1013:1: ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyAssignment_3_1_0_1_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1014:1: ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1014:2: rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0_in_rule__AttrInstanceConfig__Alternatives_3_1_0_12060);
                    rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyAssignment_3_1_0_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1018:6: ( 'write' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1018:6: ( 'write' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1019:1: 'write'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttrInstanceConfigAccess().getWriteKeyword_3_1_0_1_1()); 
                    }
                    match(input,13,FOLLOW_13_in_rule__AttrInstanceConfig__Alternatives_3_1_0_12079); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttrInstanceConfigAccess().getWriteKeyword_3_1_0_1_1()); 
                    }

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
    // $ANTLR end "rule__AttrInstanceConfig__Alternatives_3_1_0_1"


    // $ANTLR start "rule__Import__Alternatives_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1031:1: rule__Import__Alternatives_1 : ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) );
    public final void rule__Import__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1035:1: ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==14) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1036:1: ( ( rule__Import__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1036:1: ( ( rule__Import__Group_1_0__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1037:1: ( rule__Import__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getImportAccess().getGroup_1_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1038:1: ( rule__Import__Group_1_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1038:2: rule__Import__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_12113);
                    rule__Import__Group_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getImportAccess().getGroup_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1042:6: ( 'model' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1042:6: ( 'model' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1043:1: 'model'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getImportAccess().getModelKeyword_1_1()); 
                    }
                    match(input,14,FOLLOW_14_in_rule__Import__Alternatives_12132); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getImportAccess().getModelKeyword_1_1()); 
                    }

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
    // $ANTLR end "rule__Import__Alternatives_1"


    // $ANTLR start "rule__Literal__Alternatives"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1055:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1059:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 15:
            case 45:
                {
                alt5=1;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case 16:
            case 17:
            case 42:
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1060:1: ( ruleBooleanLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1060:1: ( ruleBooleanLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1061:1: ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives2166);
                    ruleBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1066:6: ( ruleNumberLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1066:6: ( ruleNumberLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1067:1: ruleNumberLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives2183);
                    ruleNumberLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1072:6: ( ruleStringLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1072:6: ( ruleStringLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1073:1: ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives2200);
                    ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                    }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1083:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1087:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            else if ( (LA6_0==45) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1088:1: ( 'false' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1088:1: ( 'false' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1089:1: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__BooleanLiteral__Alternatives_12233); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1096:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1096:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1097:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1098:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1098:2: rule__BooleanLiteral__IsTrueAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_12252);
                    rule__BooleanLiteral__IsTrueAssignment_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1107:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1111:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
            int alt7=2;
            switch ( input.LA(1) ) {
            case 16:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_INT) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==42) ) {
                        alt7=2;
                    }
                    else if ( (LA7_3==EOF||(LA7_3>=19 && LA7_3<=20)||(LA7_3>=34 && LA7_3<=35)||LA7_3==38||LA7_3==43) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA7_1==42) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==RULE_INT) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==42) ) {
                        alt7=2;
                    }
                    else if ( (LA7_3==EOF||(LA7_3>=19 && LA7_3<=20)||(LA7_3>=34 && LA7_3<=35)||LA7_3==38||LA7_3==43) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA7_2==42) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA7_3 = input.LA(2);

                if ( (LA7_3==42) ) {
                    alt7=2;
                }
                else if ( (LA7_3==EOF||(LA7_3>=19 && LA7_3<=20)||(LA7_3>=34 && LA7_3<=35)||LA7_3==38||LA7_3==43) ) {
                    alt7=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
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
            case 42:
                {
                alt7=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1112:1: ( ruleIntLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1112:1: ( ruleIntLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1113:1: ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives2285);
                    ruleIntLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1118:6: ( ruleRealLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1118:6: ( ruleRealLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1119:1: ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives2302);
                    ruleRealLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                    }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1129:1: rule__Integer__Alternatives : ( ( ruleSignedInteger ) | ( ruleHexadecimal ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1133:1: ( ( ruleSignedInteger ) | ( ruleHexadecimal ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_INT||(LA8_0>=16 && LA8_0<=17)) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_HEX) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1134:1: ( ruleSignedInteger )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1134:1: ( ruleSignedInteger )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1135:1: ruleSignedInteger
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives2334);
                    ruleSignedInteger();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1140:6: ( ruleHexadecimal )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1140:6: ( ruleHexadecimal )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1141:1: ruleHexadecimal
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives2351);
                    ruleHexadecimal();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                    }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1151:1: rule__SignedInteger__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__SignedInteger__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1155:1: ( ( '+' ) | ( '-' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            else if ( (LA9_0==17) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1156:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1156:1: ( '+' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1157:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__SignedInteger__Alternatives_02384); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1164:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1164:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1165:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__SignedInteger__Alternatives_02404); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                    }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1177:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1181:1: ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) )
            int alt10=4;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1182:1: ( ruleDecimal )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1182:1: ( ruleDecimal )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1183:1: ruleDecimal
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleDecimal_in_rule__Real__Alternatives2438);
                    ruleDecimal();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1188:6: ( ruleDotDecimal )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1188:6: ( ruleDotDecimal )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1189:1: ruleDotDecimal
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives2455);
                    ruleDotDecimal();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1194:6: ( ruleDecimalDot )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1194:6: ( ruleDecimalDot )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1195:1: ruleDecimalDot
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives2472);
                    ruleDecimalDot();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1200:6: ( ruleDecimalExp )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1200:6: ( ruleDecimalExp )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1201:1: ruleDecimalExp
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives2489);
                    ruleDecimalExp();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                    }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1211:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1215:1: ( ( '+' ) | ( '-' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            else if ( (LA11_0==17) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1216:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1216:1: ( '+' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1217:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__Decimal__Alternatives_02522); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1224:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1224:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1225:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__Decimal__Alternatives_02542); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1237:1: rule__DotDecimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DotDecimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1241:1: ( ( '+' ) | ( '-' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==16) ) {
                alt12=1;
            }
            else if ( (LA12_0==17) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1242:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1242:1: ( '+' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1243:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__DotDecimal__Alternatives_02577); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1250:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1250:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1251:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__DotDecimal__Alternatives_02597); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1263:1: rule__DecimalDot__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalDot__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1267:1: ( ( '+' ) | ( '-' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==16) ) {
                alt13=1;
            }
            else if ( (LA13_0==17) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1268:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1268:1: ( '+' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1269:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__DecimalDot__Alternatives_02632); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1276:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1276:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1277:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__DecimalDot__Alternatives_02652); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                    }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1289:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1293:1: ( ( '+' ) | ( '-' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==16) ) {
                alt14=1;
            }
            else if ( (LA14_0==17) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1294:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1294:1: ( '+' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1295:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__DecimalExp__Alternatives_02687); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1302:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1302:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1303:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__DecimalExp__Alternatives_02707); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                    }

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


    // $ANTLR start "rule__ConfigModel__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1317:1: rule__ConfigModel__Group__0 : rule__ConfigModel__Group__0__Impl rule__ConfigModel__Group__1 ;
    public final void rule__ConfigModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1321:1: ( rule__ConfigModel__Group__0__Impl rule__ConfigModel__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1322:2: rule__ConfigModel__Group__0__Impl rule__ConfigModel__Group__1
            {
            pushFollow(FOLLOW_rule__ConfigModel__Group__0__Impl_in_rule__ConfigModel__Group__02739);
            rule__ConfigModel__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConfigModel__Group__1_in_rule__ConfigModel__Group__02742);
            rule__ConfigModel__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ConfigModel__Group__0"


    // $ANTLR start "rule__ConfigModel__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1329:1: rule__ConfigModel__Group__0__Impl : ( 'ConfigModel' ) ;
    public final void rule__ConfigModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1333:1: ( ( 'ConfigModel' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1334:1: ( 'ConfigModel' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1334:1: ( 'ConfigModel' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1335:1: 'ConfigModel'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getConfigModelKeyword_0()); 
            }
            match(input,18,FOLLOW_18_in_rule__ConfigModel__Group__0__Impl2770); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getConfigModelKeyword_0()); 
            }

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
    // $ANTLR end "rule__ConfigModel__Group__0__Impl"


    // $ANTLR start "rule__ConfigModel__Group__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1348:1: rule__ConfigModel__Group__1 : rule__ConfigModel__Group__1__Impl rule__ConfigModel__Group__2 ;
    public final void rule__ConfigModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1352:1: ( rule__ConfigModel__Group__1__Impl rule__ConfigModel__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1353:2: rule__ConfigModel__Group__1__Impl rule__ConfigModel__Group__2
            {
            pushFollow(FOLLOW_rule__ConfigModel__Group__1__Impl_in_rule__ConfigModel__Group__12801);
            rule__ConfigModel__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConfigModel__Group__2_in_rule__ConfigModel__Group__12804);
            rule__ConfigModel__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ConfigModel__Group__1"


    // $ANTLR start "rule__ConfigModel__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1360:1: rule__ConfigModel__Group__1__Impl : ( ( rule__ConfigModel__NameAssignment_1 ) ) ;
    public final void rule__ConfigModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1364:1: ( ( ( rule__ConfigModel__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1365:1: ( ( rule__ConfigModel__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1365:1: ( ( rule__ConfigModel__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1366:1: ( rule__ConfigModel__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1367:1: ( rule__ConfigModel__NameAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1367:2: rule__ConfigModel__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ConfigModel__NameAssignment_1_in_rule__ConfigModel__Group__1__Impl2831);
            rule__ConfigModel__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getNameAssignment_1()); 
            }

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
    // $ANTLR end "rule__ConfigModel__Group__1__Impl"


    // $ANTLR start "rule__ConfigModel__Group__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1377:1: rule__ConfigModel__Group__2 : rule__ConfigModel__Group__2__Impl rule__ConfigModel__Group__3 ;
    public final void rule__ConfigModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1381:1: ( rule__ConfigModel__Group__2__Impl rule__ConfigModel__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1382:2: rule__ConfigModel__Group__2__Impl rule__ConfigModel__Group__3
            {
            pushFollow(FOLLOW_rule__ConfigModel__Group__2__Impl_in_rule__ConfigModel__Group__22861);
            rule__ConfigModel__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConfigModel__Group__3_in_rule__ConfigModel__Group__22864);
            rule__ConfigModel__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ConfigModel__Group__2"


    // $ANTLR start "rule__ConfigModel__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1389:1: rule__ConfigModel__Group__2__Impl : ( '{' ) ;
    public final void rule__ConfigModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1393:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1394:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1394:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1395:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,19,FOLLOW_19_in_rule__ConfigModel__Group__2__Impl2892); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getLeftCurlyBracketKeyword_2()); 
            }

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
    // $ANTLR end "rule__ConfigModel__Group__2__Impl"


    // $ANTLR start "rule__ConfigModel__Group__3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1408:1: rule__ConfigModel__Group__3 : rule__ConfigModel__Group__3__Impl rule__ConfigModel__Group__4 ;
    public final void rule__ConfigModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1412:1: ( rule__ConfigModel__Group__3__Impl rule__ConfigModel__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1413:2: rule__ConfigModel__Group__3__Impl rule__ConfigModel__Group__4
            {
            pushFollow(FOLLOW_rule__ConfigModel__Group__3__Impl_in_rule__ConfigModel__Group__32923);
            rule__ConfigModel__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConfigModel__Group__4_in_rule__ConfigModel__Group__32926);
            rule__ConfigModel__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ConfigModel__Group__3"


    // $ANTLR start "rule__ConfigModel__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1420:1: rule__ConfigModel__Group__3__Impl : ( ( rule__ConfigModel__ImportsAssignment_3 )* ) ;
    public final void rule__ConfigModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1424:1: ( ( ( rule__ConfigModel__ImportsAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1425:1: ( ( rule__ConfigModel__ImportsAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1425:1: ( ( rule__ConfigModel__ImportsAssignment_3 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1426:1: ( rule__ConfigModel__ImportsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getImportsAssignment_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1427:1: ( rule__ConfigModel__ImportsAssignment_3 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==39) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1427:2: rule__ConfigModel__ImportsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__ConfigModel__ImportsAssignment_3_in_rule__ConfigModel__Group__3__Impl2953);
            	    rule__ConfigModel__ImportsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getImportsAssignment_3()); 
            }

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
    // $ANTLR end "rule__ConfigModel__Group__3__Impl"


    // $ANTLR start "rule__ConfigModel__Group__4"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1437:1: rule__ConfigModel__Group__4 : rule__ConfigModel__Group__4__Impl rule__ConfigModel__Group__5 ;
    public final void rule__ConfigModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1441:1: ( rule__ConfigModel__Group__4__Impl rule__ConfigModel__Group__5 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1442:2: rule__ConfigModel__Group__4__Impl rule__ConfigModel__Group__5
            {
            pushFollow(FOLLOW_rule__ConfigModel__Group__4__Impl_in_rule__ConfigModel__Group__42984);
            rule__ConfigModel__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConfigModel__Group__5_in_rule__ConfigModel__Group__42987);
            rule__ConfigModel__Group__5();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ConfigModel__Group__4"


    // $ANTLR start "rule__ConfigModel__Group__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1449:1: rule__ConfigModel__Group__4__Impl : ( ( rule__ConfigModel__ConfigElementsAssignment_4 )* ) ;
    public final void rule__ConfigModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1453:1: ( ( ( rule__ConfigModel__ConfigElementsAssignment_4 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1454:1: ( ( rule__ConfigModel__ConfigElementsAssignment_4 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1454:1: ( ( rule__ConfigModel__ConfigElementsAssignment_4 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1455:1: ( rule__ConfigModel__ConfigElementsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getConfigElementsAssignment_4()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1456:1: ( rule__ConfigModel__ConfigElementsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==21||(LA16_0>=27 && LA16_0<=28)||LA16_0==30) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1456:2: rule__ConfigModel__ConfigElementsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__ConfigModel__ConfigElementsAssignment_4_in_rule__ConfigModel__Group__4__Impl3014);
            	    rule__ConfigModel__ConfigElementsAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getConfigElementsAssignment_4()); 
            }

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
    // $ANTLR end "rule__ConfigModel__Group__4__Impl"


    // $ANTLR start "rule__ConfigModel__Group__5"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1466:1: rule__ConfigModel__Group__5 : rule__ConfigModel__Group__5__Impl ;
    public final void rule__ConfigModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1470:1: ( rule__ConfigModel__Group__5__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1471:2: rule__ConfigModel__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ConfigModel__Group__5__Impl_in_rule__ConfigModel__Group__53045);
            rule__ConfigModel__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ConfigModel__Group__5"


    // $ANTLR start "rule__ConfigModel__Group__5__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1477:1: rule__ConfigModel__Group__5__Impl : ( '}' ) ;
    public final void rule__ConfigModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1481:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1482:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1482:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1483:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,20,FOLLOW_20_in_rule__ConfigModel__Group__5__Impl3073); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getRightCurlyBracketKeyword_5()); 
            }

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
    // $ANTLR end "rule__ConfigModel__Group__5__Impl"


    // $ANTLR start "rule__SubSystemConfig__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1508:1: rule__SubSystemConfig__Group__0 : rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1 ;
    public final void rule__SubSystemConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1512:1: ( rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1513:2: rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__0__Impl_in_rule__SubSystemConfig__Group__03116);
            rule__SubSystemConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__1_in_rule__SubSystemConfig__Group__03119);
            rule__SubSystemConfig__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__SubSystemConfig__Group__0"


    // $ANTLR start "rule__SubSystemConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1520:1: rule__SubSystemConfig__Group__0__Impl : ( 'SubSystemConfig' ) ;
    public final void rule__SubSystemConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1524:1: ( ( 'SubSystemConfig' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1525:1: ( 'SubSystemConfig' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1525:1: ( 'SubSystemConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1526:1: 'SubSystemConfig'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemConfigKeyword_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__SubSystemConfig__Group__0__Impl3147); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getSubSystemConfigKeyword_0()); 
            }

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
    // $ANTLR end "rule__SubSystemConfig__Group__0__Impl"


    // $ANTLR start "rule__SubSystemConfig__Group__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1539:1: rule__SubSystemConfig__Group__1 : rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2 ;
    public final void rule__SubSystemConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1543:1: ( rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1544:2: rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__1__Impl_in_rule__SubSystemConfig__Group__13178);
            rule__SubSystemConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__2_in_rule__SubSystemConfig__Group__13181);
            rule__SubSystemConfig__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__SubSystemConfig__Group__1"


    // $ANTLR start "rule__SubSystemConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1551:1: rule__SubSystemConfig__Group__1__Impl : ( ( rule__SubSystemConfig__SubSystemAssignment_1 ) ) ;
    public final void rule__SubSystemConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1555:1: ( ( ( rule__SubSystemConfig__SubSystemAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1556:1: ( ( rule__SubSystemConfig__SubSystemAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1556:1: ( ( rule__SubSystemConfig__SubSystemAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1557:1: ( rule__SubSystemConfig__SubSystemAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1558:1: ( rule__SubSystemConfig__SubSystemAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1558:2: rule__SubSystemConfig__SubSystemAssignment_1
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__SubSystemAssignment_1_in_rule__SubSystemConfig__Group__1__Impl3208);
            rule__SubSystemConfig__SubSystemAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getSubSystemAssignment_1()); 
            }

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
    // $ANTLR end "rule__SubSystemConfig__Group__1__Impl"


    // $ANTLR start "rule__SubSystemConfig__Group__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1568:1: rule__SubSystemConfig__Group__2 : rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3 ;
    public final void rule__SubSystemConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1572:1: ( rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1573:2: rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__2__Impl_in_rule__SubSystemConfig__Group__23238);
            rule__SubSystemConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__3_in_rule__SubSystemConfig__Group__23241);
            rule__SubSystemConfig__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__SubSystemConfig__Group__2"


    // $ANTLR start "rule__SubSystemConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1580:1: rule__SubSystemConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__SubSystemConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1584:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1585:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1585:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1586:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,19,FOLLOW_19_in_rule__SubSystemConfig__Group__2__Impl3269); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }

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
    // $ANTLR end "rule__SubSystemConfig__Group__2__Impl"


    // $ANTLR start "rule__SubSystemConfig__Group__3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1599:1: rule__SubSystemConfig__Group__3 : rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4 ;
    public final void rule__SubSystemConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1603:1: ( rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1604:2: rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__3__Impl_in_rule__SubSystemConfig__Group__33300);
            rule__SubSystemConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__4_in_rule__SubSystemConfig__Group__33303);
            rule__SubSystemConfig__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__SubSystemConfig__Group__3"


    // $ANTLR start "rule__SubSystemConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1611:1: rule__SubSystemConfig__Group__3__Impl : ( ( rule__SubSystemConfig__DynConfigAssignment_3 ) ) ;
    public final void rule__SubSystemConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1615:1: ( ( ( rule__SubSystemConfig__DynConfigAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1616:1: ( ( rule__SubSystemConfig__DynConfigAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1616:1: ( ( rule__SubSystemConfig__DynConfigAssignment_3 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1617:1: ( rule__SubSystemConfig__DynConfigAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getDynConfigAssignment_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1618:1: ( rule__SubSystemConfig__DynConfigAssignment_3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1618:2: rule__SubSystemConfig__DynConfigAssignment_3
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__DynConfigAssignment_3_in_rule__SubSystemConfig__Group__3__Impl3330);
            rule__SubSystemConfig__DynConfigAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getDynConfigAssignment_3()); 
            }

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
    // $ANTLR end "rule__SubSystemConfig__Group__3__Impl"


    // $ANTLR start "rule__SubSystemConfig__Group__4"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1628:1: rule__SubSystemConfig__Group__4 : rule__SubSystemConfig__Group__4__Impl ;
    public final void rule__SubSystemConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1632:1: ( rule__SubSystemConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1633:2: rule__SubSystemConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__4__Impl_in_rule__SubSystemConfig__Group__43360);
            rule__SubSystemConfig__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__SubSystemConfig__Group__4"


    // $ANTLR start "rule__SubSystemConfig__Group__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1639:1: rule__SubSystemConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__SubSystemConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1643:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1644:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1644:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1645:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,20,FOLLOW_20_in_rule__SubSystemConfig__Group__4__Impl3388); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getRightCurlyBracketKeyword_4()); 
            }

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
    // $ANTLR end "rule__SubSystemConfig__Group__4__Impl"


    // $ANTLR start "rule__DynamicConfig__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1668:1: rule__DynamicConfig__Group__0 : rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1 ;
    public final void rule__DynamicConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1672:1: ( rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1673:2: rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__0__Impl_in_rule__DynamicConfig__Group__03429);
            rule__DynamicConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group__1_in_rule__DynamicConfig__Group__03432);
            rule__DynamicConfig__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group__0"


    // $ANTLR start "rule__DynamicConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1680:1: rule__DynamicConfig__Group__0__Impl : ( 'dynamic configuration' ) ;
    public final void rule__DynamicConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1684:1: ( ( 'dynamic configuration' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1685:1: ( 'dynamic configuration' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1685:1: ( 'dynamic configuration' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1686:1: 'dynamic configuration'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getDynamicConfigurationKeyword_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__DynamicConfig__Group__0__Impl3460); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getDynamicConfigurationKeyword_0()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group__0__Impl"


    // $ANTLR start "rule__DynamicConfig__Group__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1699:1: rule__DynamicConfig__Group__1 : rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2 ;
    public final void rule__DynamicConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1703:1: ( rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1704:2: rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__1__Impl_in_rule__DynamicConfig__Group__13491);
            rule__DynamicConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group__2_in_rule__DynamicConfig__Group__13494);
            rule__DynamicConfig__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group__1"


    // $ANTLR start "rule__DynamicConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1711:1: rule__DynamicConfig__Group__1__Impl : ( '{' ) ;
    public final void rule__DynamicConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1715:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1716:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1716:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1717:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,19,FOLLOW_19_in_rule__DynamicConfig__Group__1__Impl3522); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getLeftCurlyBracketKeyword_1()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group__1__Impl"


    // $ANTLR start "rule__DynamicConfig__Group__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1730:1: rule__DynamicConfig__Group__2 : rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3 ;
    public final void rule__DynamicConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1734:1: ( rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1735:2: rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__2__Impl_in_rule__DynamicConfig__Group__23553);
            rule__DynamicConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group__3_in_rule__DynamicConfig__Group__23556);
            rule__DynamicConfig__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group__2"


    // $ANTLR start "rule__DynamicConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1742:1: rule__DynamicConfig__Group__2__Impl : ( ( rule__DynamicConfig__UnorderedGroup_2 ) ) ;
    public final void rule__DynamicConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1746:1: ( ( ( rule__DynamicConfig__UnorderedGroup_2 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1747:1: ( ( rule__DynamicConfig__UnorderedGroup_2 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1747:1: ( ( rule__DynamicConfig__UnorderedGroup_2 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1748:1: ( rule__DynamicConfig__UnorderedGroup_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1749:1: ( rule__DynamicConfig__UnorderedGroup_2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1749:2: rule__DynamicConfig__UnorderedGroup_2
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2_in_rule__DynamicConfig__Group__2__Impl3583);
            rule__DynamicConfig__UnorderedGroup_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group__2__Impl"


    // $ANTLR start "rule__DynamicConfig__Group__3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1759:1: rule__DynamicConfig__Group__3 : rule__DynamicConfig__Group__3__Impl ;
    public final void rule__DynamicConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1763:1: ( rule__DynamicConfig__Group__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1764:2: rule__DynamicConfig__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__3__Impl_in_rule__DynamicConfig__Group__33613);
            rule__DynamicConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group__3"


    // $ANTLR start "rule__DynamicConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1770:1: rule__DynamicConfig__Group__3__Impl : ( '}' ) ;
    public final void rule__DynamicConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1774:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1775:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1775:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1776:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,20,FOLLOW_20_in_rule__DynamicConfig__Group__3__Impl3641); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getRightCurlyBracketKeyword_3()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group__3__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_0__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1797:1: rule__DynamicConfig__Group_2_0_0__0 : rule__DynamicConfig__Group_2_0_0__0__Impl rule__DynamicConfig__Group_2_0_0__1 ;
    public final void rule__DynamicConfig__Group_2_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1801:1: ( rule__DynamicConfig__Group_2_0_0__0__Impl rule__DynamicConfig__Group_2_0_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1802:2: rule__DynamicConfig__Group_2_0_0__0__Impl rule__DynamicConfig__Group_2_0_0__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_0__0__Impl_in_rule__DynamicConfig__Group_2_0_0__03680);
            rule__DynamicConfig__Group_2_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_0__1_in_rule__DynamicConfig__Group_2_0_0__03683);
            rule__DynamicConfig__Group_2_0_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_0__0"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1809:1: rule__DynamicConfig__Group_2_0_0__0__Impl : ( 'file path' ) ;
    public final void rule__DynamicConfig__Group_2_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1813:1: ( ( 'file path' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1814:1: ( 'file path' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1814:1: ( 'file path' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1815:1: 'file path'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getFilePathKeyword_2_0_0_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__DynamicConfig__Group_2_0_0__0__Impl3711); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getFilePathKeyword_2_0_0_0()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_0__0__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_0__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1828:1: rule__DynamicConfig__Group_2_0_0__1 : rule__DynamicConfig__Group_2_0_0__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1832:1: ( rule__DynamicConfig__Group_2_0_0__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1833:2: rule__DynamicConfig__Group_2_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_0__1__Impl_in_rule__DynamicConfig__Group_2_0_0__13742);
            rule__DynamicConfig__Group_2_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_0__1"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1839:1: rule__DynamicConfig__Group_2_0_0__1__Impl : ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1843:1: ( ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1844:1: ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1844:1: ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1845:1: ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getFilePathAssignment_2_0_0_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1846:1: ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1846:2: rule__DynamicConfig__FilePathAssignment_2_0_0_1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__FilePathAssignment_2_0_0_1_in_rule__DynamicConfig__Group_2_0_0__1__Impl3769);
            rule__DynamicConfig__FilePathAssignment_2_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getFilePathAssignment_2_0_0_1()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_0__1__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1860:1: rule__DynamicConfig__Group_2_0_1__0 : rule__DynamicConfig__Group_2_0_1__0__Impl rule__DynamicConfig__Group_2_0_1__1 ;
    public final void rule__DynamicConfig__Group_2_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1864:1: ( rule__DynamicConfig__Group_2_0_1__0__Impl rule__DynamicConfig__Group_2_0_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1865:2: rule__DynamicConfig__Group_2_0_1__0__Impl rule__DynamicConfig__Group_2_0_1__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1__0__Impl_in_rule__DynamicConfig__Group_2_0_1__03803);
            rule__DynamicConfig__Group_2_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1__1_in_rule__DynamicConfig__Group_2_0_1__03806);
            rule__DynamicConfig__Group_2_0_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1__0"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1872:1: rule__DynamicConfig__Group_2_0_1__0__Impl : ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1876:1: ( ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1877:1: ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1877:1: ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1878:1: ( rule__DynamicConfig__Group_2_0_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1879:1: ( rule__DynamicConfig__Group_2_0_1_0__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1879:2: rule__DynamicConfig__Group_2_0_1_0__0
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_0__0_in_rule__DynamicConfig__Group_2_0_1__0__Impl3833);
            rule__DynamicConfig__Group_2_0_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_0()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1__0__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1889:1: rule__DynamicConfig__Group_2_0_1__1 : rule__DynamicConfig__Group_2_0_1__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1893:1: ( rule__DynamicConfig__Group_2_0_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1894:2: rule__DynamicConfig__Group_2_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1__1__Impl_in_rule__DynamicConfig__Group_2_0_1__13863);
            rule__DynamicConfig__Group_2_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1__1"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1900:1: rule__DynamicConfig__Group_2_0_1__1__Impl : ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1904:1: ( ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1905:1: ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1905:1: ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1906:1: ( rule__DynamicConfig__Group_2_0_1_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1907:1: ( rule__DynamicConfig__Group_2_0_1_1__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1907:2: rule__DynamicConfig__Group_2_0_1_1__0
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_1__0_in_rule__DynamicConfig__Group_2_0_1__1__Impl3890);
            rule__DynamicConfig__Group_2_0_1_1__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_1()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1__1__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1_0__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1921:1: rule__DynamicConfig__Group_2_0_1_0__0 : rule__DynamicConfig__Group_2_0_1_0__0__Impl rule__DynamicConfig__Group_2_0_1_0__1 ;
    public final void rule__DynamicConfig__Group_2_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1925:1: ( rule__DynamicConfig__Group_2_0_1_0__0__Impl rule__DynamicConfig__Group_2_0_1_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1926:2: rule__DynamicConfig__Group_2_0_1_0__0__Impl rule__DynamicConfig__Group_2_0_1_0__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_0__0__Impl_in_rule__DynamicConfig__Group_2_0_1_0__03924);
            rule__DynamicConfig__Group_2_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_0__1_in_rule__DynamicConfig__Group_2_0_1_0__03927);
            rule__DynamicConfig__Group_2_0_1_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1_0__0"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1933:1: rule__DynamicConfig__Group_2_0_1_0__0__Impl : ( 'user import' ) ;
    public final void rule__DynamicConfig__Group_2_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1937:1: ( ( 'user import' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1938:1: ( 'user import' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1938:1: ( 'user import' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1939:1: 'user import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserImportKeyword_2_0_1_0_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__DynamicConfig__Group_2_0_1_0__0__Impl3955); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getUserImportKeyword_2_0_1_0_0()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1_0__0__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1_0__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1952:1: rule__DynamicConfig__Group_2_0_1_0__1 : rule__DynamicConfig__Group_2_0_1_0__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1956:1: ( rule__DynamicConfig__Group_2_0_1_0__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1957:2: rule__DynamicConfig__Group_2_0_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_0__1__Impl_in_rule__DynamicConfig__Group_2_0_1_0__13986);
            rule__DynamicConfig__Group_2_0_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1_0__1"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1963:1: rule__DynamicConfig__Group_2_0_1_0__1__Impl : ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1967:1: ( ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1968:1: ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1968:1: ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1969:1: ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserCode1Assignment_2_0_1_0_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1970:1: ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1970:2: rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1_in_rule__DynamicConfig__Group_2_0_1_0__1__Impl4013);
            rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getUserCode1Assignment_2_0_1_0_1()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1_0__1__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1984:1: rule__DynamicConfig__Group_2_0_1_1__0 : rule__DynamicConfig__Group_2_0_1_1__0__Impl rule__DynamicConfig__Group_2_0_1_1__1 ;
    public final void rule__DynamicConfig__Group_2_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1988:1: ( rule__DynamicConfig__Group_2_0_1_1__0__Impl rule__DynamicConfig__Group_2_0_1_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1989:2: rule__DynamicConfig__Group_2_0_1_1__0__Impl rule__DynamicConfig__Group_2_0_1_1__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_1__0__Impl_in_rule__DynamicConfig__Group_2_0_1_1__04047);
            rule__DynamicConfig__Group_2_0_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_1__1_in_rule__DynamicConfig__Group_2_0_1_1__04050);
            rule__DynamicConfig__Group_2_0_1_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1_1__0"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1996:1: rule__DynamicConfig__Group_2_0_1_1__0__Impl : ( 'user constructor' ) ;
    public final void rule__DynamicConfig__Group_2_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2000:1: ( ( 'user constructor' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2001:1: ( 'user constructor' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2001:1: ( 'user constructor' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2002:1: 'user constructor'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserConstructorKeyword_2_0_1_1_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__DynamicConfig__Group_2_0_1_1__0__Impl4078); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getUserConstructorKeyword_2_0_1_1_0()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1_1__0__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1_1__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2015:1: rule__DynamicConfig__Group_2_0_1_1__1 : rule__DynamicConfig__Group_2_0_1_1__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2019:1: ( rule__DynamicConfig__Group_2_0_1_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2020:2: rule__DynamicConfig__Group_2_0_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_1__1__Impl_in_rule__DynamicConfig__Group_2_0_1_1__14109);
            rule__DynamicConfig__Group_2_0_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1_1__1"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2026:1: rule__DynamicConfig__Group_2_0_1_1__1__Impl : ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2030:1: ( ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2031:1: ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2031:1: ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2032:1: ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserCode2Assignment_2_0_1_1_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2033:1: ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2033:2: rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1_in_rule__DynamicConfig__Group_2_0_1_1__1__Impl4136);
            rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getUserCode2Assignment_2_0_1_1_1()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1_1__1__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2047:1: rule__DynamicConfig__Group_2_1__0 : rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1 ;
    public final void rule__DynamicConfig__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2051:1: ( rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2052:2: rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_1__0__Impl_in_rule__DynamicConfig__Group_2_1__04170);
            rule__DynamicConfig__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_1__1_in_rule__DynamicConfig__Group_2_1__04173);
            rule__DynamicConfig__Group_2_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group_2_1__0"


    // $ANTLR start "rule__DynamicConfig__Group_2_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2059:1: rule__DynamicConfig__Group_2_1__0__Impl : ( 'polling timer [ms]' ) ;
    public final void rule__DynamicConfig__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2063:1: ( ( 'polling timer [ms]' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2064:1: ( 'polling timer [ms]' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2064:1: ( 'polling timer [ms]' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2065:1: 'polling timer [ms]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getPollingTimerMsKeyword_2_1_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__DynamicConfig__Group_2_1__0__Impl4201); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getPollingTimerMsKeyword_2_1_0()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group_2_1__0__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_1__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2078:1: rule__DynamicConfig__Group_2_1__1 : rule__DynamicConfig__Group_2_1__1__Impl ;
    public final void rule__DynamicConfig__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2082:1: ( rule__DynamicConfig__Group_2_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2083:2: rule__DynamicConfig__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_1__1__Impl_in_rule__DynamicConfig__Group_2_1__14232);
            rule__DynamicConfig__Group_2_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__Group_2_1__1"


    // $ANTLR start "rule__DynamicConfig__Group_2_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2089:1: rule__DynamicConfig__Group_2_1__1__Impl : ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2093:1: ( ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2094:1: ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2094:1: ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2095:1: ( rule__DynamicConfig__PollingAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getPollingAssignment_2_1_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2096:1: ( rule__DynamicConfig__PollingAssignment_2_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2096:2: rule__DynamicConfig__PollingAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__PollingAssignment_2_1_1_in_rule__DynamicConfig__Group_2_1__1__Impl4259);
            rule__DynamicConfig__PollingAssignment_2_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getPollingAssignment_2_1_1()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__Group_2_1__1__Impl"


    // $ANTLR start "rule__ActorClassConfig__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2110:1: rule__ActorClassConfig__Group__0 : rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1 ;
    public final void rule__ActorClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2114:1: ( rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2115:2: rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__0__Impl_in_rule__ActorClassConfig__Group__04293);
            rule__ActorClassConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__1_in_rule__ActorClassConfig__Group__04296);
            rule__ActorClassConfig__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorClassConfig__Group__0"


    // $ANTLR start "rule__ActorClassConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2122:1: rule__ActorClassConfig__Group__0__Impl : ( 'ActorClassConfig' ) ;
    public final void rule__ActorClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2126:1: ( ( 'ActorClassConfig' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2127:1: ( 'ActorClassConfig' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2127:1: ( 'ActorClassConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2128:1: 'ActorClassConfig'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorClassConfigKeyword_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__ActorClassConfig__Group__0__Impl4324); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorClassConfigAccess().getActorClassConfigKeyword_0()); 
            }

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
    // $ANTLR end "rule__ActorClassConfig__Group__0__Impl"


    // $ANTLR start "rule__ActorClassConfig__Group__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2141:1: rule__ActorClassConfig__Group__1 : rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2 ;
    public final void rule__ActorClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2145:1: ( rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2146:2: rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__1__Impl_in_rule__ActorClassConfig__Group__14355);
            rule__ActorClassConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__2_in_rule__ActorClassConfig__Group__14358);
            rule__ActorClassConfig__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorClassConfig__Group__1"


    // $ANTLR start "rule__ActorClassConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2153:1: rule__ActorClassConfig__Group__1__Impl : ( ( rule__ActorClassConfig__ActorAssignment_1 ) ) ;
    public final void rule__ActorClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2157:1: ( ( ( rule__ActorClassConfig__ActorAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2158:1: ( ( rule__ActorClassConfig__ActorAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2158:1: ( ( rule__ActorClassConfig__ActorAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2159:1: ( rule__ActorClassConfig__ActorAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2160:1: ( rule__ActorClassConfig__ActorAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2160:2: rule__ActorClassConfig__ActorAssignment_1
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__ActorAssignment_1_in_rule__ActorClassConfig__Group__1__Impl4385);
            rule__ActorClassConfig__ActorAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorClassConfigAccess().getActorAssignment_1()); 
            }

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
    // $ANTLR end "rule__ActorClassConfig__Group__1__Impl"


    // $ANTLR start "rule__ActorClassConfig__Group__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2170:1: rule__ActorClassConfig__Group__2 : rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3 ;
    public final void rule__ActorClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2174:1: ( rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2175:2: rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__2__Impl_in_rule__ActorClassConfig__Group__24415);
            rule__ActorClassConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__3_in_rule__ActorClassConfig__Group__24418);
            rule__ActorClassConfig__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorClassConfig__Group__2"


    // $ANTLR start "rule__ActorClassConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2182:1: rule__ActorClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__ActorClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2186:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2187:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2187:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2188:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,19,FOLLOW_19_in_rule__ActorClassConfig__Group__2__Impl4446); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }

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
    // $ANTLR end "rule__ActorClassConfig__Group__2__Impl"


    // $ANTLR start "rule__ActorClassConfig__Group__3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2201:1: rule__ActorClassConfig__Group__3 : rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4 ;
    public final void rule__ActorClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2205:1: ( rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2206:2: rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__3__Impl_in_rule__ActorClassConfig__Group__34477);
            rule__ActorClassConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__4_in_rule__ActorClassConfig__Group__34480);
            rule__ActorClassConfig__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorClassConfig__Group__3"


    // $ANTLR start "rule__ActorClassConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2213:1: rule__ActorClassConfig__Group__3__Impl : ( ( rule__ActorClassConfig__AttributesAssignment_3 )* ) ;
    public final void rule__ActorClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2217:1: ( ( ( rule__ActorClassConfig__AttributesAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2218:1: ( ( rule__ActorClassConfig__AttributesAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2218:1: ( ( rule__ActorClassConfig__AttributesAssignment_3 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2219:1: ( rule__ActorClassConfig__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getAttributesAssignment_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2220:1: ( rule__ActorClassConfig__AttributesAssignment_3 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==35) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2220:2: rule__ActorClassConfig__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__ActorClassConfig__AttributesAssignment_3_in_rule__ActorClassConfig__Group__3__Impl4507);
            	    rule__ActorClassConfig__AttributesAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorClassConfigAccess().getAttributesAssignment_3()); 
            }

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
    // $ANTLR end "rule__ActorClassConfig__Group__3__Impl"


    // $ANTLR start "rule__ActorClassConfig__Group__4"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2230:1: rule__ActorClassConfig__Group__4 : rule__ActorClassConfig__Group__4__Impl ;
    public final void rule__ActorClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2234:1: ( rule__ActorClassConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2235:2: rule__ActorClassConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__4__Impl_in_rule__ActorClassConfig__Group__44538);
            rule__ActorClassConfig__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorClassConfig__Group__4"


    // $ANTLR start "rule__ActorClassConfig__Group__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2241:1: rule__ActorClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__ActorClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2245:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2246:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2246:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2247:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,20,FOLLOW_20_in_rule__ActorClassConfig__Group__4__Impl4566); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            }

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
    // $ANTLR end "rule__ActorClassConfig__Group__4__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2270:1: rule__ActorInstanceConfig__Group__0 : rule__ActorInstanceConfig__Group__0__Impl rule__ActorInstanceConfig__Group__1 ;
    public final void rule__ActorInstanceConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2274:1: ( rule__ActorInstanceConfig__Group__0__Impl rule__ActorInstanceConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2275:2: rule__ActorInstanceConfig__Group__0__Impl rule__ActorInstanceConfig__Group__1
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__0__Impl_in_rule__ActorInstanceConfig__Group__04607);
            rule__ActorInstanceConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__1_in_rule__ActorInstanceConfig__Group__04610);
            rule__ActorInstanceConfig__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__0"


    // $ANTLR start "rule__ActorInstanceConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2282:1: rule__ActorInstanceConfig__Group__0__Impl : ( 'ActorInstanceConfig' ) ;
    public final void rule__ActorInstanceConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2286:1: ( ( 'ActorInstanceConfig' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2287:1: ( 'ActorInstanceConfig' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2287:1: ( 'ActorInstanceConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2288:1: 'ActorInstanceConfig'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getActorInstanceConfigKeyword_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__ActorInstanceConfig__Group__0__Impl4638); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getActorInstanceConfigKeyword_0()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__0__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2301:1: rule__ActorInstanceConfig__Group__1 : rule__ActorInstanceConfig__Group__1__Impl rule__ActorInstanceConfig__Group__2 ;
    public final void rule__ActorInstanceConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2305:1: ( rule__ActorInstanceConfig__Group__1__Impl rule__ActorInstanceConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2306:2: rule__ActorInstanceConfig__Group__1__Impl rule__ActorInstanceConfig__Group__2
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__1__Impl_in_rule__ActorInstanceConfig__Group__14669);
            rule__ActorInstanceConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__2_in_rule__ActorInstanceConfig__Group__14672);
            rule__ActorInstanceConfig__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__1"


    // $ANTLR start "rule__ActorInstanceConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2313:1: rule__ActorInstanceConfig__Group__1__Impl : ( ( rule__ActorInstanceConfig__RootAssignment_1 ) ) ;
    public final void rule__ActorInstanceConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2317:1: ( ( ( rule__ActorInstanceConfig__RootAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2318:1: ( ( rule__ActorInstanceConfig__RootAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2318:1: ( ( rule__ActorInstanceConfig__RootAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2319:1: ( rule__ActorInstanceConfig__RootAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRootAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2320:1: ( rule__ActorInstanceConfig__RootAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2320:2: rule__ActorInstanceConfig__RootAssignment_1
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__RootAssignment_1_in_rule__ActorInstanceConfig__Group__1__Impl4699);
            rule__ActorInstanceConfig__RootAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getRootAssignment_1()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__1__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2330:1: rule__ActorInstanceConfig__Group__2 : rule__ActorInstanceConfig__Group__2__Impl rule__ActorInstanceConfig__Group__3 ;
    public final void rule__ActorInstanceConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2334:1: ( rule__ActorInstanceConfig__Group__2__Impl rule__ActorInstanceConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2335:2: rule__ActorInstanceConfig__Group__2__Impl rule__ActorInstanceConfig__Group__3
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__2__Impl_in_rule__ActorInstanceConfig__Group__24729);
            rule__ActorInstanceConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__3_in_rule__ActorInstanceConfig__Group__24732);
            rule__ActorInstanceConfig__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__2"


    // $ANTLR start "rule__ActorInstanceConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2342:1: rule__ActorInstanceConfig__Group__2__Impl : ( '/' ) ;
    public final void rule__ActorInstanceConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2346:1: ( ( '/' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2347:1: ( '/' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2347:1: ( '/' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2348:1: '/'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_2()); 
            }
            match(input,29,FOLLOW_29_in_rule__ActorInstanceConfig__Group__2__Impl4760); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_2()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__2__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group__3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2361:1: rule__ActorInstanceConfig__Group__3 : rule__ActorInstanceConfig__Group__3__Impl rule__ActorInstanceConfig__Group__4 ;
    public final void rule__ActorInstanceConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2365:1: ( rule__ActorInstanceConfig__Group__3__Impl rule__ActorInstanceConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2366:2: rule__ActorInstanceConfig__Group__3__Impl rule__ActorInstanceConfig__Group__4
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__3__Impl_in_rule__ActorInstanceConfig__Group__34791);
            rule__ActorInstanceConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__4_in_rule__ActorInstanceConfig__Group__34794);
            rule__ActorInstanceConfig__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__3"


    // $ANTLR start "rule__ActorInstanceConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2373:1: rule__ActorInstanceConfig__Group__3__Impl : ( ( rule__ActorInstanceConfig__SubSystemAssignment_3 ) ) ;
    public final void rule__ActorInstanceConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2377:1: ( ( ( rule__ActorInstanceConfig__SubSystemAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2378:1: ( ( rule__ActorInstanceConfig__SubSystemAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2378:1: ( ( rule__ActorInstanceConfig__SubSystemAssignment_3 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2379:1: ( rule__ActorInstanceConfig__SubSystemAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getSubSystemAssignment_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2380:1: ( rule__ActorInstanceConfig__SubSystemAssignment_3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2380:2: rule__ActorInstanceConfig__SubSystemAssignment_3
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__SubSystemAssignment_3_in_rule__ActorInstanceConfig__Group__3__Impl4821);
            rule__ActorInstanceConfig__SubSystemAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getSubSystemAssignment_3()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__3__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group__4"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2390:1: rule__ActorInstanceConfig__Group__4 : rule__ActorInstanceConfig__Group__4__Impl rule__ActorInstanceConfig__Group__5 ;
    public final void rule__ActorInstanceConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2394:1: ( rule__ActorInstanceConfig__Group__4__Impl rule__ActorInstanceConfig__Group__5 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2395:2: rule__ActorInstanceConfig__Group__4__Impl rule__ActorInstanceConfig__Group__5
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__4__Impl_in_rule__ActorInstanceConfig__Group__44851);
            rule__ActorInstanceConfig__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__5_in_rule__ActorInstanceConfig__Group__44854);
            rule__ActorInstanceConfig__Group__5();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__4"


    // $ANTLR start "rule__ActorInstanceConfig__Group__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2402:1: rule__ActorInstanceConfig__Group__4__Impl : ( '/' ) ;
    public final void rule__ActorInstanceConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2406:1: ( ( '/' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2407:1: ( '/' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2407:1: ( '/' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2408:1: '/'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_4()); 
            }
            match(input,29,FOLLOW_29_in_rule__ActorInstanceConfig__Group__4__Impl4882); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_4()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__4__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group__5"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2421:1: rule__ActorInstanceConfig__Group__5 : rule__ActorInstanceConfig__Group__5__Impl rule__ActorInstanceConfig__Group__6 ;
    public final void rule__ActorInstanceConfig__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2425:1: ( rule__ActorInstanceConfig__Group__5__Impl rule__ActorInstanceConfig__Group__6 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2426:2: rule__ActorInstanceConfig__Group__5__Impl rule__ActorInstanceConfig__Group__6
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__5__Impl_in_rule__ActorInstanceConfig__Group__54913);
            rule__ActorInstanceConfig__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__6_in_rule__ActorInstanceConfig__Group__54916);
            rule__ActorInstanceConfig__Group__6();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__5"


    // $ANTLR start "rule__ActorInstanceConfig__Group__5__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2433:1: rule__ActorInstanceConfig__Group__5__Impl : ( ( rule__ActorInstanceConfig__PathAssignment_5 ) ) ;
    public final void rule__ActorInstanceConfig__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2437:1: ( ( ( rule__ActorInstanceConfig__PathAssignment_5 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2438:1: ( ( rule__ActorInstanceConfig__PathAssignment_5 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2438:1: ( ( rule__ActorInstanceConfig__PathAssignment_5 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2439:1: ( rule__ActorInstanceConfig__PathAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getPathAssignment_5()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2440:1: ( rule__ActorInstanceConfig__PathAssignment_5 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2440:2: rule__ActorInstanceConfig__PathAssignment_5
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__PathAssignment_5_in_rule__ActorInstanceConfig__Group__5__Impl4943);
            rule__ActorInstanceConfig__PathAssignment_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getPathAssignment_5()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__5__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group__6"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2450:1: rule__ActorInstanceConfig__Group__6 : rule__ActorInstanceConfig__Group__6__Impl rule__ActorInstanceConfig__Group__7 ;
    public final void rule__ActorInstanceConfig__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2454:1: ( rule__ActorInstanceConfig__Group__6__Impl rule__ActorInstanceConfig__Group__7 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2455:2: rule__ActorInstanceConfig__Group__6__Impl rule__ActorInstanceConfig__Group__7
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__6__Impl_in_rule__ActorInstanceConfig__Group__64973);
            rule__ActorInstanceConfig__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__7_in_rule__ActorInstanceConfig__Group__64976);
            rule__ActorInstanceConfig__Group__7();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__6"


    // $ANTLR start "rule__ActorInstanceConfig__Group__6__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2462:1: rule__ActorInstanceConfig__Group__6__Impl : ( '{' ) ;
    public final void rule__ActorInstanceConfig__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2466:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2467:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2467:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2468:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getLeftCurlyBracketKeyword_6()); 
            }
            match(input,19,FOLLOW_19_in_rule__ActorInstanceConfig__Group__6__Impl5004); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getLeftCurlyBracketKeyword_6()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__6__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group__7"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2481:1: rule__ActorInstanceConfig__Group__7 : rule__ActorInstanceConfig__Group__7__Impl rule__ActorInstanceConfig__Group__8 ;
    public final void rule__ActorInstanceConfig__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2485:1: ( rule__ActorInstanceConfig__Group__7__Impl rule__ActorInstanceConfig__Group__8 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2486:2: rule__ActorInstanceConfig__Group__7__Impl rule__ActorInstanceConfig__Group__8
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__7__Impl_in_rule__ActorInstanceConfig__Group__75035);
            rule__ActorInstanceConfig__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__8_in_rule__ActorInstanceConfig__Group__75038);
            rule__ActorInstanceConfig__Group__8();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__7"


    // $ANTLR start "rule__ActorInstanceConfig__Group__7__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2493:1: rule__ActorInstanceConfig__Group__7__Impl : ( ( rule__ActorInstanceConfig__UnorderedGroup_7 ) ) ;
    public final void rule__ActorInstanceConfig__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2497:1: ( ( ( rule__ActorInstanceConfig__UnorderedGroup_7 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2498:1: ( ( rule__ActorInstanceConfig__UnorderedGroup_7 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2498:1: ( ( rule__ActorInstanceConfig__UnorderedGroup_7 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2499:1: ( rule__ActorInstanceConfig__UnorderedGroup_7 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2500:1: ( rule__ActorInstanceConfig__UnorderedGroup_7 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2500:2: rule__ActorInstanceConfig__UnorderedGroup_7
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup_7_in_rule__ActorInstanceConfig__Group__7__Impl5065);
            rule__ActorInstanceConfig__UnorderedGroup_7();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__7__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group__8"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2510:1: rule__ActorInstanceConfig__Group__8 : rule__ActorInstanceConfig__Group__8__Impl ;
    public final void rule__ActorInstanceConfig__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2514:1: ( rule__ActorInstanceConfig__Group__8__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2515:2: rule__ActorInstanceConfig__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group__8__Impl_in_rule__ActorInstanceConfig__Group__85095);
            rule__ActorInstanceConfig__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__8"


    // $ANTLR start "rule__ActorInstanceConfig__Group__8__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2521:1: rule__ActorInstanceConfig__Group__8__Impl : ( '}' ) ;
    public final void rule__ActorInstanceConfig__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2525:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2526:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2526:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2527:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRightCurlyBracketKeyword_8()); 
            }
            match(input,20,FOLLOW_20_in_rule__ActorInstanceConfig__Group__8__Impl5123); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getRightCurlyBracketKeyword_8()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__Group__8__Impl"


    // $ANTLR start "rule__ProtocolClassConfig__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2558:1: rule__ProtocolClassConfig__Group__0 : rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1 ;
    public final void rule__ProtocolClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2562:1: ( rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2563:2: rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__0__Impl_in_rule__ProtocolClassConfig__Group__05172);
            rule__ProtocolClassConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__1_in_rule__ProtocolClassConfig__Group__05175);
            rule__ProtocolClassConfig__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__0"


    // $ANTLR start "rule__ProtocolClassConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2570:1: rule__ProtocolClassConfig__Group__0__Impl : ( 'ProtocolClassConfig' ) ;
    public final void rule__ProtocolClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2574:1: ( ( 'ProtocolClassConfig' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2575:1: ( 'ProtocolClassConfig' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2575:1: ( 'ProtocolClassConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2576:1: 'ProtocolClassConfig'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolClassConfigKeyword_0()); 
            }
            match(input,30,FOLLOW_30_in_rule__ProtocolClassConfig__Group__0__Impl5203); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getProtocolClassConfigKeyword_0()); 
            }

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__0__Impl"


    // $ANTLR start "rule__ProtocolClassConfig__Group__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2589:1: rule__ProtocolClassConfig__Group__1 : rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2 ;
    public final void rule__ProtocolClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2593:1: ( rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2594:2: rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__1__Impl_in_rule__ProtocolClassConfig__Group__15234);
            rule__ProtocolClassConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__2_in_rule__ProtocolClassConfig__Group__15237);
            rule__ProtocolClassConfig__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__1"


    // $ANTLR start "rule__ProtocolClassConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2601:1: rule__ProtocolClassConfig__Group__1__Impl : ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2605:1: ( ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2606:1: ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2606:1: ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2607:1: ( rule__ProtocolClassConfig__ProtocolAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2608:1: ( rule__ProtocolClassConfig__ProtocolAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2608:2: rule__ProtocolClassConfig__ProtocolAssignment_1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__ProtocolAssignment_1_in_rule__ProtocolClassConfig__Group__1__Impl5264);
            rule__ProtocolClassConfig__ProtocolAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getProtocolAssignment_1()); 
            }

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__1__Impl"


    // $ANTLR start "rule__ProtocolClassConfig__Group__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2618:1: rule__ProtocolClassConfig__Group__2 : rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3 ;
    public final void rule__ProtocolClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2622:1: ( rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2623:2: rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__2__Impl_in_rule__ProtocolClassConfig__Group__25294);
            rule__ProtocolClassConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__3_in_rule__ProtocolClassConfig__Group__25297);
            rule__ProtocolClassConfig__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__2"


    // $ANTLR start "rule__ProtocolClassConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2630:1: rule__ProtocolClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__ProtocolClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2634:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2635:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2635:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2636:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,19,FOLLOW_19_in_rule__ProtocolClassConfig__Group__2__Impl5325); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__2__Impl"


    // $ANTLR start "rule__ProtocolClassConfig__Group__3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2649:1: rule__ProtocolClassConfig__Group__3 : rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4 ;
    public final void rule__ProtocolClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2653:1: ( rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2654:2: rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__3__Impl_in_rule__ProtocolClassConfig__Group__35356);
            rule__ProtocolClassConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__4_in_rule__ProtocolClassConfig__Group__35359);
            rule__ProtocolClassConfig__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__3"


    // $ANTLR start "rule__ProtocolClassConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2661:1: rule__ProtocolClassConfig__Group__3__Impl : ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) ) ;
    public final void rule__ProtocolClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2665:1: ( ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2666:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2666:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2667:1: ( rule__ProtocolClassConfig__UnorderedGroup_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2668:1: ( rule__ProtocolClassConfig__UnorderedGroup_3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2668:2: rule__ProtocolClassConfig__UnorderedGroup_3
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3_in_rule__ProtocolClassConfig__Group__3__Impl5386);
            rule__ProtocolClassConfig__UnorderedGroup_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3()); 
            }

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__3__Impl"


    // $ANTLR start "rule__ProtocolClassConfig__Group__4"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2678:1: rule__ProtocolClassConfig__Group__4 : rule__ProtocolClassConfig__Group__4__Impl ;
    public final void rule__ProtocolClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2682:1: ( rule__ProtocolClassConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2683:2: rule__ProtocolClassConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__4__Impl_in_rule__ProtocolClassConfig__Group__45416);
            rule__ProtocolClassConfig__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__4"


    // $ANTLR start "rule__ProtocolClassConfig__Group__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2689:1: rule__ProtocolClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__ProtocolClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2693:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2694:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2694:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2695:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,20,FOLLOW_20_in_rule__ProtocolClassConfig__Group__4__Impl5444); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            }

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__4__Impl"


    // $ANTLR start "rule__ProtocolClassConfig__Group_3_0__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2718:1: rule__ProtocolClassConfig__Group_3_0__0 : rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1 ;
    public final void rule__ProtocolClassConfig__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2722:1: ( rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2723:2: rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_0__0__Impl_in_rule__ProtocolClassConfig__Group_3_0__05485);
            rule__ProtocolClassConfig__Group_3_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_0__1_in_rule__ProtocolClassConfig__Group_3_0__05488);
            rule__ProtocolClassConfig__Group_3_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ProtocolClassConfig__Group_3_0__0"


    // $ANTLR start "rule__ProtocolClassConfig__Group_3_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2730:1: rule__ProtocolClassConfig__Group_3_0__0__Impl : ( 'regular' ) ;
    public final void rule__ProtocolClassConfig__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2734:1: ( ( 'regular' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2735:1: ( 'regular' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2735:1: ( 'regular' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2736:1: 'regular'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getRegularKeyword_3_0_0()); 
            }
            match(input,31,FOLLOW_31_in_rule__ProtocolClassConfig__Group_3_0__0__Impl5516); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getRegularKeyword_3_0_0()); 
            }

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
    // $ANTLR end "rule__ProtocolClassConfig__Group_3_0__0__Impl"


    // $ANTLR start "rule__ProtocolClassConfig__Group_3_0__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2749:1: rule__ProtocolClassConfig__Group_3_0__1 : rule__ProtocolClassConfig__Group_3_0__1__Impl ;
    public final void rule__ProtocolClassConfig__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2753:1: ( rule__ProtocolClassConfig__Group_3_0__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2754:2: rule__ProtocolClassConfig__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_0__1__Impl_in_rule__ProtocolClassConfig__Group_3_0__15547);
            rule__ProtocolClassConfig__Group_3_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ProtocolClassConfig__Group_3_0__1"


    // $ANTLR start "rule__ProtocolClassConfig__Group_3_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2760:1: rule__ProtocolClassConfig__Group_3_0__1__Impl : ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2764:1: ( ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2765:1: ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2765:1: ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2766:1: ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getRegularAssignment_3_0_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2767:1: ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2767:2: rule__ProtocolClassConfig__RegularAssignment_3_0_1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__RegularAssignment_3_0_1_in_rule__ProtocolClassConfig__Group_3_0__1__Impl5574);
            rule__ProtocolClassConfig__RegularAssignment_3_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getRegularAssignment_3_0_1()); 
            }

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
    // $ANTLR end "rule__ProtocolClassConfig__Group_3_0__1__Impl"


    // $ANTLR start "rule__ProtocolClassConfig__Group_3_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2781:1: rule__ProtocolClassConfig__Group_3_1__0 : rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1 ;
    public final void rule__ProtocolClassConfig__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2785:1: ( rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2786:2: rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_1__0__Impl_in_rule__ProtocolClassConfig__Group_3_1__05608);
            rule__ProtocolClassConfig__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_1__1_in_rule__ProtocolClassConfig__Group_3_1__05611);
            rule__ProtocolClassConfig__Group_3_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ProtocolClassConfig__Group_3_1__0"


    // $ANTLR start "rule__ProtocolClassConfig__Group_3_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2793:1: rule__ProtocolClassConfig__Group_3_1__0__Impl : ( 'conjugate' ) ;
    public final void rule__ProtocolClassConfig__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2797:1: ( ( 'conjugate' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2798:1: ( 'conjugate' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2798:1: ( 'conjugate' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2799:1: 'conjugate'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getConjugateKeyword_3_1_0()); 
            }
            match(input,32,FOLLOW_32_in_rule__ProtocolClassConfig__Group_3_1__0__Impl5639); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getConjugateKeyword_3_1_0()); 
            }

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
    // $ANTLR end "rule__ProtocolClassConfig__Group_3_1__0__Impl"


    // $ANTLR start "rule__ProtocolClassConfig__Group_3_1__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2812:1: rule__ProtocolClassConfig__Group_3_1__1 : rule__ProtocolClassConfig__Group_3_1__1__Impl ;
    public final void rule__ProtocolClassConfig__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2816:1: ( rule__ProtocolClassConfig__Group_3_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2817:2: rule__ProtocolClassConfig__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_1__1__Impl_in_rule__ProtocolClassConfig__Group_3_1__15670);
            rule__ProtocolClassConfig__Group_3_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ProtocolClassConfig__Group_3_1__1"


    // $ANTLR start "rule__ProtocolClassConfig__Group_3_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2823:1: rule__ProtocolClassConfig__Group_3_1__1__Impl : ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2827:1: ( ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2828:1: ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2828:1: ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2829:1: ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getConjugatedAssignment_3_1_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2830:1: ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2830:2: rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1_in_rule__ProtocolClassConfig__Group_3_1__1__Impl5697);
            rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getConjugatedAssignment_3_1_1()); 
            }

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
    // $ANTLR end "rule__ProtocolClassConfig__Group_3_1__1__Impl"


    // $ANTLR start "rule__PortClassConfig__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2844:1: rule__PortClassConfig__Group__0 : rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1 ;
    public final void rule__PortClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2848:1: ( rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2849:2: rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__0__Impl_in_rule__PortClassConfig__Group__05731);
            rule__PortClassConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortClassConfig__Group__1_in_rule__PortClassConfig__Group__05734);
            rule__PortClassConfig__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__PortClassConfig__Group__0"


    // $ANTLR start "rule__PortClassConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2856:1: rule__PortClassConfig__Group__0__Impl : ( () ) ;
    public final void rule__PortClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2860:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2861:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2861:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2862:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getPortClassConfigAction_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2863:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2865:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortClassConfigAccess().getPortClassConfigAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortClassConfig__Group__0__Impl"


    // $ANTLR start "rule__PortClassConfig__Group__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2875:1: rule__PortClassConfig__Group__1 : rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2 ;
    public final void rule__PortClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2879:1: ( rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2880:2: rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__1__Impl_in_rule__PortClassConfig__Group__15792);
            rule__PortClassConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortClassConfig__Group__2_in_rule__PortClassConfig__Group__15795);
            rule__PortClassConfig__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__PortClassConfig__Group__1"


    // $ANTLR start "rule__PortClassConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2887:1: rule__PortClassConfig__Group__1__Impl : ( 'Port' ) ;
    public final void rule__PortClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2891:1: ( ( 'Port' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2892:1: ( 'Port' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2892:1: ( 'Port' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2893:1: 'Port'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getPortKeyword_1()); 
            }
            match(input,33,FOLLOW_33_in_rule__PortClassConfig__Group__1__Impl5823); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortClassConfigAccess().getPortKeyword_1()); 
            }

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
    // $ANTLR end "rule__PortClassConfig__Group__1__Impl"


    // $ANTLR start "rule__PortClassConfig__Group__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2906:1: rule__PortClassConfig__Group__2 : rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3 ;
    public final void rule__PortClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2910:1: ( rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2911:2: rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__2__Impl_in_rule__PortClassConfig__Group__25854);
            rule__PortClassConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortClassConfig__Group__3_in_rule__PortClassConfig__Group__25857);
            rule__PortClassConfig__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__PortClassConfig__Group__2"


    // $ANTLR start "rule__PortClassConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2918:1: rule__PortClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__PortClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2922:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2923:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2923:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2924:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,19,FOLLOW_19_in_rule__PortClassConfig__Group__2__Impl5885); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }

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
    // $ANTLR end "rule__PortClassConfig__Group__2__Impl"


    // $ANTLR start "rule__PortClassConfig__Group__3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2937:1: rule__PortClassConfig__Group__3 : rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4 ;
    public final void rule__PortClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2941:1: ( rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2942:2: rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__3__Impl_in_rule__PortClassConfig__Group__35916);
            rule__PortClassConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortClassConfig__Group__4_in_rule__PortClassConfig__Group__35919);
            rule__PortClassConfig__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__PortClassConfig__Group__3"


    // $ANTLR start "rule__PortClassConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2949:1: rule__PortClassConfig__Group__3__Impl : ( ( rule__PortClassConfig__AttributesAssignment_3 )* ) ;
    public final void rule__PortClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2953:1: ( ( ( rule__PortClassConfig__AttributesAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2954:1: ( ( rule__PortClassConfig__AttributesAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2954:1: ( ( rule__PortClassConfig__AttributesAssignment_3 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2955:1: ( rule__PortClassConfig__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getAttributesAssignment_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2956:1: ( rule__PortClassConfig__AttributesAssignment_3 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==35) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2956:2: rule__PortClassConfig__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PortClassConfig__AttributesAssignment_3_in_rule__PortClassConfig__Group__3__Impl5946);
            	    rule__PortClassConfig__AttributesAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortClassConfigAccess().getAttributesAssignment_3()); 
            }

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
    // $ANTLR end "rule__PortClassConfig__Group__3__Impl"


    // $ANTLR start "rule__PortClassConfig__Group__4"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2966:1: rule__PortClassConfig__Group__4 : rule__PortClassConfig__Group__4__Impl ;
    public final void rule__PortClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2970:1: ( rule__PortClassConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2971:2: rule__PortClassConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__4__Impl_in_rule__PortClassConfig__Group__45977);
            rule__PortClassConfig__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__PortClassConfig__Group__4"


    // $ANTLR start "rule__PortClassConfig__Group__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2977:1: rule__PortClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__PortClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2981:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2982:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2982:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2983:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,20,FOLLOW_20_in_rule__PortClassConfig__Group__4__Impl6005); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            }

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
    // $ANTLR end "rule__PortClassConfig__Group__4__Impl"


    // $ANTLR start "rule__PortInstanceConfig__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3006:1: rule__PortInstanceConfig__Group__0 : rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1 ;
    public final void rule__PortInstanceConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3010:1: ( rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3011:2: rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__0__Impl_in_rule__PortInstanceConfig__Group__06046);
            rule__PortInstanceConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__1_in_rule__PortInstanceConfig__Group__06049);
            rule__PortInstanceConfig__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__PortInstanceConfig__Group__0"


    // $ANTLR start "rule__PortInstanceConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3018:1: rule__PortInstanceConfig__Group__0__Impl : ( 'InterfaceItem' ) ;
    public final void rule__PortInstanceConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3022:1: ( ( 'InterfaceItem' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3023:1: ( 'InterfaceItem' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3023:1: ( 'InterfaceItem' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3024:1: 'InterfaceItem'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getInterfaceItemKeyword_0()); 
            }
            match(input,34,FOLLOW_34_in_rule__PortInstanceConfig__Group__0__Impl6077); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortInstanceConfigAccess().getInterfaceItemKeyword_0()); 
            }

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
    // $ANTLR end "rule__PortInstanceConfig__Group__0__Impl"


    // $ANTLR start "rule__PortInstanceConfig__Group__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3037:1: rule__PortInstanceConfig__Group__1 : rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2 ;
    public final void rule__PortInstanceConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3041:1: ( rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3042:2: rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__1__Impl_in_rule__PortInstanceConfig__Group__16108);
            rule__PortInstanceConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__2_in_rule__PortInstanceConfig__Group__16111);
            rule__PortInstanceConfig__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__PortInstanceConfig__Group__1"


    // $ANTLR start "rule__PortInstanceConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3049:1: rule__PortInstanceConfig__Group__1__Impl : ( ( rule__PortInstanceConfig__ItemAssignment_1 ) ) ;
    public final void rule__PortInstanceConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3053:1: ( ( ( rule__PortInstanceConfig__ItemAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3054:1: ( ( rule__PortInstanceConfig__ItemAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3054:1: ( ( rule__PortInstanceConfig__ItemAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3055:1: ( rule__PortInstanceConfig__ItemAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getItemAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3056:1: ( rule__PortInstanceConfig__ItemAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3056:2: rule__PortInstanceConfig__ItemAssignment_1
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__ItemAssignment_1_in_rule__PortInstanceConfig__Group__1__Impl6138);
            rule__PortInstanceConfig__ItemAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortInstanceConfigAccess().getItemAssignment_1()); 
            }

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
    // $ANTLR end "rule__PortInstanceConfig__Group__1__Impl"


    // $ANTLR start "rule__PortInstanceConfig__Group__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3066:1: rule__PortInstanceConfig__Group__2 : rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3 ;
    public final void rule__PortInstanceConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3070:1: ( rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3071:2: rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__2__Impl_in_rule__PortInstanceConfig__Group__26168);
            rule__PortInstanceConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__3_in_rule__PortInstanceConfig__Group__26171);
            rule__PortInstanceConfig__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__PortInstanceConfig__Group__2"


    // $ANTLR start "rule__PortInstanceConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3078:1: rule__PortInstanceConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__PortInstanceConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3082:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3083:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3083:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3084:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,19,FOLLOW_19_in_rule__PortInstanceConfig__Group__2__Impl6199); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortInstanceConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }

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
    // $ANTLR end "rule__PortInstanceConfig__Group__2__Impl"


    // $ANTLR start "rule__PortInstanceConfig__Group__3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3097:1: rule__PortInstanceConfig__Group__3 : rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4 ;
    public final void rule__PortInstanceConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3101:1: ( rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3102:2: rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__3__Impl_in_rule__PortInstanceConfig__Group__36230);
            rule__PortInstanceConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__4_in_rule__PortInstanceConfig__Group__36233);
            rule__PortInstanceConfig__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__PortInstanceConfig__Group__3"


    // $ANTLR start "rule__PortInstanceConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3109:1: rule__PortInstanceConfig__Group__3__Impl : ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* ) ;
    public final void rule__PortInstanceConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3113:1: ( ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3114:1: ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3114:1: ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3115:1: ( rule__PortInstanceConfig__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getAttributesAssignment_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3116:1: ( rule__PortInstanceConfig__AttributesAssignment_3 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==35) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3116:2: rule__PortInstanceConfig__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PortInstanceConfig__AttributesAssignment_3_in_rule__PortInstanceConfig__Group__3__Impl6260);
            	    rule__PortInstanceConfig__AttributesAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortInstanceConfigAccess().getAttributesAssignment_3()); 
            }

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
    // $ANTLR end "rule__PortInstanceConfig__Group__3__Impl"


    // $ANTLR start "rule__PortInstanceConfig__Group__4"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3126:1: rule__PortInstanceConfig__Group__4 : rule__PortInstanceConfig__Group__4__Impl ;
    public final void rule__PortInstanceConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3130:1: ( rule__PortInstanceConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3131:2: rule__PortInstanceConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__4__Impl_in_rule__PortInstanceConfig__Group__46291);
            rule__PortInstanceConfig__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__PortInstanceConfig__Group__4"


    // $ANTLR start "rule__PortInstanceConfig__Group__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3137:1: rule__PortInstanceConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__PortInstanceConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3141:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3142:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3142:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3143:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,20,FOLLOW_20_in_rule__PortInstanceConfig__Group__4__Impl6319); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortInstanceConfigAccess().getRightCurlyBracketKeyword_4()); 
            }

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
    // $ANTLR end "rule__PortInstanceConfig__Group__4__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3166:1: rule__AttrClassConfig__Group__0 : rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1 ;
    public final void rule__AttrClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3170:1: ( rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3171:2: rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__0__Impl_in_rule__AttrClassConfig__Group__06360);
            rule__AttrClassConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__1_in_rule__AttrClassConfig__Group__06363);
            rule__AttrClassConfig__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group__0"


    // $ANTLR start "rule__AttrClassConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3178:1: rule__AttrClassConfig__Group__0__Impl : ( 'Attr' ) ;
    public final void rule__AttrClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3182:1: ( ( 'Attr' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3183:1: ( 'Attr' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3183:1: ( 'Attr' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3184:1: 'Attr'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttrKeyword_0()); 
            }
            match(input,35,FOLLOW_35_in_rule__AttrClassConfig__Group__0__Impl6391); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getAttrKeyword_0()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group__0__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3197:1: rule__AttrClassConfig__Group__1 : rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2 ;
    public final void rule__AttrClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3201:1: ( rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3202:2: rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__1__Impl_in_rule__AttrClassConfig__Group__16422);
            rule__AttrClassConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__2_in_rule__AttrClassConfig__Group__16425);
            rule__AttrClassConfig__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group__1"


    // $ANTLR start "rule__AttrClassConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3209:1: rule__AttrClassConfig__Group__1__Impl : ( ( rule__AttrClassConfig__AttributeAssignment_1 ) ) ;
    public final void rule__AttrClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3213:1: ( ( ( rule__AttrClassConfig__AttributeAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3214:1: ( ( rule__AttrClassConfig__AttributeAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3214:1: ( ( rule__AttrClassConfig__AttributeAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3215:1: ( rule__AttrClassConfig__AttributeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributeAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3216:1: ( rule__AttrClassConfig__AttributeAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3216:2: rule__AttrClassConfig__AttributeAssignment_1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__AttributeAssignment_1_in_rule__AttrClassConfig__Group__1__Impl6452);
            rule__AttrClassConfig__AttributeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getAttributeAssignment_1()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group__1__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3226:1: rule__AttrClassConfig__Group__2 : rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3 ;
    public final void rule__AttrClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3230:1: ( rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3231:2: rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__2__Impl_in_rule__AttrClassConfig__Group__26482);
            rule__AttrClassConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__3_in_rule__AttrClassConfig__Group__26485);
            rule__AttrClassConfig__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group__2"


    // $ANTLR start "rule__AttrClassConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3238:1: rule__AttrClassConfig__Group__2__Impl : ( ( rule__AttrClassConfig__Group_2__0 )? ) ;
    public final void rule__AttrClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3242:1: ( ( ( rule__AttrClassConfig__Group_2__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3243:1: ( ( rule__AttrClassConfig__Group_2__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3243:1: ( ( rule__AttrClassConfig__Group_2__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3244:1: ( rule__AttrClassConfig__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3245:1: ( rule__AttrClassConfig__Group_2__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==36) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3245:2: rule__AttrClassConfig__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__Group_2__0_in_rule__AttrClassConfig__Group__2__Impl6512);
                    rule__AttrClassConfig__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getGroup_2()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group__2__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group__3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3255:1: rule__AttrClassConfig__Group__3 : rule__AttrClassConfig__Group__3__Impl ;
    public final void rule__AttrClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3259:1: ( rule__AttrClassConfig__Group__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3260:2: rule__AttrClassConfig__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__3__Impl_in_rule__AttrClassConfig__Group__36543);
            rule__AttrClassConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group__3"


    // $ANTLR start "rule__AttrClassConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3266:1: rule__AttrClassConfig__Group__3__Impl : ( ( rule__AttrClassConfig__Group_3__0 )? ) ;
    public final void rule__AttrClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3270:1: ( ( ( rule__AttrClassConfig__Group_3__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3271:1: ( ( rule__AttrClassConfig__Group_3__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3271:1: ( ( rule__AttrClassConfig__Group_3__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3272:1: ( rule__AttrClassConfig__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3273:1: ( rule__AttrClassConfig__Group_3__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3273:2: rule__AttrClassConfig__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__0_in_rule__AttrClassConfig__Group__3__Impl6570);
                    rule__AttrClassConfig__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getGroup_3()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group__3__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_2__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3291:1: rule__AttrClassConfig__Group_2__0 : rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1 ;
    public final void rule__AttrClassConfig__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3295:1: ( rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3296:2: rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_2__0__Impl_in_rule__AttrClassConfig__Group_2__06609);
            rule__AttrClassConfig__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_2__1_in_rule__AttrClassConfig__Group_2__06612);
            rule__AttrClassConfig__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_2__0"


    // $ANTLR start "rule__AttrClassConfig__Group_2__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3303:1: rule__AttrClassConfig__Group_2__0__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3307:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3308:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3308:1: ( '=' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3309:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_2_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__AttrClassConfig__Group_2__0__Impl6640); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_2_0()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_2__0__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_2__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3322:1: rule__AttrClassConfig__Group_2__1 : rule__AttrClassConfig__Group_2__1__Impl ;
    public final void rule__AttrClassConfig__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3326:1: ( rule__AttrClassConfig__Group_2__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3327:2: rule__AttrClassConfig__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_2__1__Impl_in_rule__AttrClassConfig__Group_2__16671);
            rule__AttrClassConfig__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_2__1"


    // $ANTLR start "rule__AttrClassConfig__Group_2__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3333:1: rule__AttrClassConfig__Group_2__1__Impl : ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) ) ;
    public final void rule__AttrClassConfig__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3337:1: ( ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3338:1: ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3338:1: ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3339:1: ( rule__AttrClassConfig__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getValueAssignment_2_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3340:1: ( rule__AttrClassConfig__ValueAssignment_2_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3340:2: rule__AttrClassConfig__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__ValueAssignment_2_1_in_rule__AttrClassConfig__Group_2__1__Impl6698);
            rule__AttrClassConfig__ValueAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getValueAssignment_2_1()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_2__1__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_3__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3354:1: rule__AttrClassConfig__Group_3__0 : rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1 ;
    public final void rule__AttrClassConfig__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3358:1: ( rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3359:2: rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__0__Impl_in_rule__AttrClassConfig__Group_3__06732);
            rule__AttrClassConfig__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__1_in_rule__AttrClassConfig__Group_3__06735);
            rule__AttrClassConfig__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_3__0"


    // $ANTLR start "rule__AttrClassConfig__Group_3__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3366:1: rule__AttrClassConfig__Group_3__0__Impl : ( '{' ) ;
    public final void rule__AttrClassConfig__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3370:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3371:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3371:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3372:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getLeftCurlyBracketKeyword_3_0()); 
            }
            match(input,19,FOLLOW_19_in_rule__AttrClassConfig__Group_3__0__Impl6763); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getLeftCurlyBracketKeyword_3_0()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_3__0__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_3__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3385:1: rule__AttrClassConfig__Group_3__1 : rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2 ;
    public final void rule__AttrClassConfig__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3389:1: ( rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3390:2: rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__1__Impl_in_rule__AttrClassConfig__Group_3__16794);
            rule__AttrClassConfig__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__2_in_rule__AttrClassConfig__Group_3__16797);
            rule__AttrClassConfig__Group_3__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_3__1"


    // $ANTLR start "rule__AttrClassConfig__Group_3__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3397:1: rule__AttrClassConfig__Group_3__1__Impl : ( ( rule__AttrClassConfig__Group_3_1__0 ) ) ;
    public final void rule__AttrClassConfig__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3401:1: ( ( ( rule__AttrClassConfig__Group_3_1__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3402:1: ( ( rule__AttrClassConfig__Group_3_1__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3402:1: ( ( rule__AttrClassConfig__Group_3_1__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3403:1: ( rule__AttrClassConfig__Group_3_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_3_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3404:1: ( rule__AttrClassConfig__Group_3_1__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3404:2: rule__AttrClassConfig__Group_3_1__0
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1__0_in_rule__AttrClassConfig__Group_3__1__Impl6824);
            rule__AttrClassConfig__Group_3_1__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getGroup_3_1()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_3__1__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_3__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3414:1: rule__AttrClassConfig__Group_3__2 : rule__AttrClassConfig__Group_3__2__Impl ;
    public final void rule__AttrClassConfig__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3418:1: ( rule__AttrClassConfig__Group_3__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3419:2: rule__AttrClassConfig__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__2__Impl_in_rule__AttrClassConfig__Group_3__26854);
            rule__AttrClassConfig__Group_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_3__2"


    // $ANTLR start "rule__AttrClassConfig__Group_3__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3425:1: rule__AttrClassConfig__Group_3__2__Impl : ( '}' ) ;
    public final void rule__AttrClassConfig__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3429:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3430:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3430:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3431:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getRightCurlyBracketKeyword_3_2()); 
            }
            match(input,20,FOLLOW_20_in_rule__AttrClassConfig__Group_3__2__Impl6882); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getRightCurlyBracketKeyword_3_2()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_3__2__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3450:1: rule__AttrClassConfig__Group_3_1__0 : rule__AttrClassConfig__Group_3_1__0__Impl rule__AttrClassConfig__Group_3_1__1 ;
    public final void rule__AttrClassConfig__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3454:1: ( rule__AttrClassConfig__Group_3_1__0__Impl rule__AttrClassConfig__Group_3_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3455:2: rule__AttrClassConfig__Group_3_1__0__Impl rule__AttrClassConfig__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1__0__Impl_in_rule__AttrClassConfig__Group_3_1__06919);
            rule__AttrClassConfig__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1__1_in_rule__AttrClassConfig__Group_3_1__06922);
            rule__AttrClassConfig__Group_3_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1__0"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3462:1: rule__AttrClassConfig__Group_3_1__0__Impl : ( ( rule__AttrClassConfig__Group_3_1_0__0 )? ) ;
    public final void rule__AttrClassConfig__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3466:1: ( ( ( rule__AttrClassConfig__Group_3_1_0__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3467:1: ( ( rule__AttrClassConfig__Group_3_1_0__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3467:1: ( ( rule__AttrClassConfig__Group_3_1_0__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3468:1: ( rule__AttrClassConfig__Group_3_1_0__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3469:1: ( rule__AttrClassConfig__Group_3_1_0__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==37) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3469:2: rule__AttrClassConfig__Group_3_1_0__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__0_in_rule__AttrClassConfig__Group_3_1__0__Impl6949);
                    rule__AttrClassConfig__Group_3_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_0()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1__0__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3479:1: rule__AttrClassConfig__Group_3_1__1 : rule__AttrClassConfig__Group_3_1__1__Impl rule__AttrClassConfig__Group_3_1__2 ;
    public final void rule__AttrClassConfig__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3483:1: ( rule__AttrClassConfig__Group_3_1__1__Impl rule__AttrClassConfig__Group_3_1__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3484:2: rule__AttrClassConfig__Group_3_1__1__Impl rule__AttrClassConfig__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1__1__Impl_in_rule__AttrClassConfig__Group_3_1__16980);
            rule__AttrClassConfig__Group_3_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1__2_in_rule__AttrClassConfig__Group_3_1__16983);
            rule__AttrClassConfig__Group_3_1__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1__1"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3491:1: rule__AttrClassConfig__Group_3_1__1__Impl : ( ( rule__AttrClassConfig__Group_3_1_1__0 )? ) ;
    public final void rule__AttrClassConfig__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3495:1: ( ( ( rule__AttrClassConfig__Group_3_1_1__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3496:1: ( ( rule__AttrClassConfig__Group_3_1_1__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3496:1: ( ( rule__AttrClassConfig__Group_3_1_1__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3497:1: ( rule__AttrClassConfig__Group_3_1_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3498:1: ( rule__AttrClassConfig__Group_3_1_1__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==38) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3498:2: rule__AttrClassConfig__Group_3_1_1__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__0_in_rule__AttrClassConfig__Group_3_1__1__Impl7010);
                    rule__AttrClassConfig__Group_3_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_1()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1__1__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3508:1: rule__AttrClassConfig__Group_3_1__2 : rule__AttrClassConfig__Group_3_1__2__Impl ;
    public final void rule__AttrClassConfig__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3512:1: ( rule__AttrClassConfig__Group_3_1__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3513:2: rule__AttrClassConfig__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1__2__Impl_in_rule__AttrClassConfig__Group_3_1__27041);
            rule__AttrClassConfig__Group_3_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1__2"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3519:1: rule__AttrClassConfig__Group_3_1__2__Impl : ( ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )* ) ;
    public final void rule__AttrClassConfig__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3523:1: ( ( ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3524:1: ( ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3524:1: ( ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3525:1: ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributesAssignment_3_1_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3526:1: ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==35) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3526:2: rule__AttrClassConfig__AttributesAssignment_3_1_2
            	    {
            	    pushFollow(FOLLOW_rule__AttrClassConfig__AttributesAssignment_3_1_2_in_rule__AttrClassConfig__Group_3_1__2__Impl7068);
            	    rule__AttrClassConfig__AttributesAssignment_3_1_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getAttributesAssignment_3_1_2()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1__2__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_0__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3542:1: rule__AttrClassConfig__Group_3_1_0__0 : rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1 ;
    public final void rule__AttrClassConfig__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3546:1: ( rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3547:2: rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__0__Impl_in_rule__AttrClassConfig__Group_3_1_0__07105);
            rule__AttrClassConfig__Group_3_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__1_in_rule__AttrClassConfig__Group_3_1_0__07108);
            rule__AttrClassConfig__Group_3_1_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_0__0"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3554:1: rule__AttrClassConfig__Group_3_1_0__0__Impl : ( 'min' ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3558:1: ( ( 'min' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3559:1: ( 'min' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3559:1: ( 'min' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3560:1: 'min'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMinKeyword_3_1_0_0()); 
            }
            match(input,37,FOLLOW_37_in_rule__AttrClassConfig__Group_3_1_0__0__Impl7136); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getMinKeyword_3_1_0_0()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_0__0__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_0__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3573:1: rule__AttrClassConfig__Group_3_1_0__1 : rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2 ;
    public final void rule__AttrClassConfig__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3577:1: ( rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3578:2: rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__1__Impl_in_rule__AttrClassConfig__Group_3_1_0__17167);
            rule__AttrClassConfig__Group_3_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__2_in_rule__AttrClassConfig__Group_3_1_0__17170);
            rule__AttrClassConfig__Group_3_1_0__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_0__1"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3585:1: rule__AttrClassConfig__Group_3_1_0__1__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3589:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3590:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3590:1: ( '=' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3591:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_0_1()); 
            }
            match(input,36,FOLLOW_36_in_rule__AttrClassConfig__Group_3_1_0__1__Impl7198); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_0_1()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_0__1__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_0__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3604:1: rule__AttrClassConfig__Group_3_1_0__2 : rule__AttrClassConfig__Group_3_1_0__2__Impl ;
    public final void rule__AttrClassConfig__Group_3_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3608:1: ( rule__AttrClassConfig__Group_3_1_0__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3609:2: rule__AttrClassConfig__Group_3_1_0__2__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__2__Impl_in_rule__AttrClassConfig__Group_3_1_0__27229);
            rule__AttrClassConfig__Group_3_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_0__2"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_0__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3615:1: rule__AttrClassConfig__Group_3_1_0__2__Impl : ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3619:1: ( ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3620:1: ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3620:1: ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3621:1: ( rule__AttrClassConfig__MinAssignment_3_1_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMinAssignment_3_1_0_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3622:1: ( rule__AttrClassConfig__MinAssignment_3_1_0_2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3622:2: rule__AttrClassConfig__MinAssignment_3_1_0_2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__MinAssignment_3_1_0_2_in_rule__AttrClassConfig__Group_3_1_0__2__Impl7256);
            rule__AttrClassConfig__MinAssignment_3_1_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getMinAssignment_3_1_0_2()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_0__2__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3638:1: rule__AttrClassConfig__Group_3_1_1__0 : rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1 ;
    public final void rule__AttrClassConfig__Group_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3642:1: ( rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3643:2: rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__0__Impl_in_rule__AttrClassConfig__Group_3_1_1__07292);
            rule__AttrClassConfig__Group_3_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__1_in_rule__AttrClassConfig__Group_3_1_1__07295);
            rule__AttrClassConfig__Group_3_1_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_1__0"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3650:1: rule__AttrClassConfig__Group_3_1_1__0__Impl : ( 'max' ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3654:1: ( ( 'max' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3655:1: ( 'max' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3655:1: ( 'max' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3656:1: 'max'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMaxKeyword_3_1_1_0()); 
            }
            match(input,38,FOLLOW_38_in_rule__AttrClassConfig__Group_3_1_1__0__Impl7323); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getMaxKeyword_3_1_1_0()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_1__0__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_1__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3669:1: rule__AttrClassConfig__Group_3_1_1__1 : rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2 ;
    public final void rule__AttrClassConfig__Group_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3673:1: ( rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3674:2: rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__1__Impl_in_rule__AttrClassConfig__Group_3_1_1__17354);
            rule__AttrClassConfig__Group_3_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__2_in_rule__AttrClassConfig__Group_3_1_1__17357);
            rule__AttrClassConfig__Group_3_1_1__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_1__1"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3681:1: rule__AttrClassConfig__Group_3_1_1__1__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3685:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3686:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3686:1: ( '=' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3687:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_1_1()); 
            }
            match(input,36,FOLLOW_36_in_rule__AttrClassConfig__Group_3_1_1__1__Impl7385); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_1_1()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_1__1__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_1__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3700:1: rule__AttrClassConfig__Group_3_1_1__2 : rule__AttrClassConfig__Group_3_1_1__2__Impl ;
    public final void rule__AttrClassConfig__Group_3_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3704:1: ( rule__AttrClassConfig__Group_3_1_1__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3705:2: rule__AttrClassConfig__Group_3_1_1__2__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__2__Impl_in_rule__AttrClassConfig__Group_3_1_1__27416);
            rule__AttrClassConfig__Group_3_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_1__2"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_1__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3711:1: rule__AttrClassConfig__Group_3_1_1__2__Impl : ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3715:1: ( ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3716:1: ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3716:1: ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3717:1: ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMaxAssignment_3_1_1_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3718:1: ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3718:2: rule__AttrClassConfig__MaxAssignment_3_1_1_2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__MaxAssignment_3_1_1_2_in_rule__AttrClassConfig__Group_3_1_1__2__Impl7443);
            rule__AttrClassConfig__MaxAssignment_3_1_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getMaxAssignment_3_1_1_2()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_1__2__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3734:1: rule__AttrInstanceConfig__Group__0 : rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1 ;
    public final void rule__AttrInstanceConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3738:1: ( rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3739:2: rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__0__Impl_in_rule__AttrInstanceConfig__Group__07479);
            rule__AttrInstanceConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__1_in_rule__AttrInstanceConfig__Group__07482);
            rule__AttrInstanceConfig__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrInstanceConfig__Group__0"


    // $ANTLR start "rule__AttrInstanceConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3746:1: rule__AttrInstanceConfig__Group__0__Impl : ( 'Attr' ) ;
    public final void rule__AttrInstanceConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3750:1: ( ( 'Attr' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3751:1: ( 'Attr' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3751:1: ( 'Attr' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3752:1: 'Attr'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttrKeyword_0()); 
            }
            match(input,35,FOLLOW_35_in_rule__AttrInstanceConfig__Group__0__Impl7510); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getAttrKeyword_0()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__Group__0__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3765:1: rule__AttrInstanceConfig__Group__1 : rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2 ;
    public final void rule__AttrInstanceConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3769:1: ( rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3770:2: rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__1__Impl_in_rule__AttrInstanceConfig__Group__17541);
            rule__AttrInstanceConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__2_in_rule__AttrInstanceConfig__Group__17544);
            rule__AttrInstanceConfig__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrInstanceConfig__Group__1"


    // $ANTLR start "rule__AttrInstanceConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3777:1: rule__AttrInstanceConfig__Group__1__Impl : ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3781:1: ( ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3782:1: ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3782:1: ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3783:1: ( rule__AttrInstanceConfig__AttributeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3784:1: ( rule__AttrInstanceConfig__AttributeAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3784:2: rule__AttrInstanceConfig__AttributeAssignment_1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__AttributeAssignment_1_in_rule__AttrInstanceConfig__Group__1__Impl7571);
            rule__AttrInstanceConfig__AttributeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getAttributeAssignment_1()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__Group__1__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3794:1: rule__AttrInstanceConfig__Group__2 : rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3 ;
    public final void rule__AttrInstanceConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3798:1: ( rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3799:2: rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__2__Impl_in_rule__AttrInstanceConfig__Group__27601);
            rule__AttrInstanceConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__3_in_rule__AttrInstanceConfig__Group__27604);
            rule__AttrInstanceConfig__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrInstanceConfig__Group__2"


    // $ANTLR start "rule__AttrInstanceConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3806:1: rule__AttrInstanceConfig__Group__2__Impl : ( ( rule__AttrInstanceConfig__Group_2__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3810:1: ( ( ( rule__AttrInstanceConfig__Group_2__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3811:1: ( ( rule__AttrInstanceConfig__Group_2__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3811:1: ( ( rule__AttrInstanceConfig__Group_2__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3812:1: ( rule__AttrInstanceConfig__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3813:1: ( rule__AttrInstanceConfig__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==36) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3813:2: rule__AttrInstanceConfig__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_2__0_in_rule__AttrInstanceConfig__Group__2__Impl7631);
                    rule__AttrInstanceConfig__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getGroup_2()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__Group__2__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group__3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3823:1: rule__AttrInstanceConfig__Group__3 : rule__AttrInstanceConfig__Group__3__Impl ;
    public final void rule__AttrInstanceConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3827:1: ( rule__AttrInstanceConfig__Group__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3828:2: rule__AttrInstanceConfig__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__3__Impl_in_rule__AttrInstanceConfig__Group__37662);
            rule__AttrInstanceConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrInstanceConfig__Group__3"


    // $ANTLR start "rule__AttrInstanceConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3834:1: rule__AttrInstanceConfig__Group__3__Impl : ( ( rule__AttrInstanceConfig__Group_3__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3838:1: ( ( ( rule__AttrInstanceConfig__Group_3__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3839:1: ( ( rule__AttrInstanceConfig__Group_3__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3839:1: ( ( rule__AttrInstanceConfig__Group_3__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3840:1: ( rule__AttrInstanceConfig__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3841:1: ( rule__AttrInstanceConfig__Group_3__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==19) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3841:2: rule__AttrInstanceConfig__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__0_in_rule__AttrInstanceConfig__Group__3__Impl7689);
                    rule__AttrInstanceConfig__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getGroup_3()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__Group__3__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group_2__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3859:1: rule__AttrInstanceConfig__Group_2__0 : rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1 ;
    public final void rule__AttrInstanceConfig__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3863:1: ( rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3864:2: rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_2__0__Impl_in_rule__AttrInstanceConfig__Group_2__07728);
            rule__AttrInstanceConfig__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_2__1_in_rule__AttrInstanceConfig__Group_2__07731);
            rule__AttrInstanceConfig__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_2__0"


    // $ANTLR start "rule__AttrInstanceConfig__Group_2__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3871:1: rule__AttrInstanceConfig__Group_2__0__Impl : ( '=' ) ;
    public final void rule__AttrInstanceConfig__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3875:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3876:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3876:1: ( '=' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3877:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getEqualsSignKeyword_2_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__AttrInstanceConfig__Group_2__0__Impl7759); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getEqualsSignKeyword_2_0()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_2__0__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group_2__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3890:1: rule__AttrInstanceConfig__Group_2__1 : rule__AttrInstanceConfig__Group_2__1__Impl ;
    public final void rule__AttrInstanceConfig__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3894:1: ( rule__AttrInstanceConfig__Group_2__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3895:2: rule__AttrInstanceConfig__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_2__1__Impl_in_rule__AttrInstanceConfig__Group_2__17790);
            rule__AttrInstanceConfig__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_2__1"


    // $ANTLR start "rule__AttrInstanceConfig__Group_2__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3901:1: rule__AttrInstanceConfig__Group_2__1__Impl : ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3905:1: ( ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3906:1: ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3906:1: ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3907:1: ( rule__AttrInstanceConfig__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getValueAssignment_2_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3908:1: ( rule__AttrInstanceConfig__ValueAssignment_2_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3908:2: rule__AttrInstanceConfig__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__ValueAssignment_2_1_in_rule__AttrInstanceConfig__Group_2__1__Impl7817);
            rule__AttrInstanceConfig__ValueAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getValueAssignment_2_1()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_2__1__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3922:1: rule__AttrInstanceConfig__Group_3__0 : rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1 ;
    public final void rule__AttrInstanceConfig__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3926:1: ( rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3927:2: rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__0__Impl_in_rule__AttrInstanceConfig__Group_3__07851);
            rule__AttrInstanceConfig__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__1_in_rule__AttrInstanceConfig__Group_3__07854);
            rule__AttrInstanceConfig__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3__0"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3934:1: rule__AttrInstanceConfig__Group_3__0__Impl : ( '{' ) ;
    public final void rule__AttrInstanceConfig__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3938:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3939:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3939:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3940:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getLeftCurlyBracketKeyword_3_0()); 
            }
            match(input,19,FOLLOW_19_in_rule__AttrInstanceConfig__Group_3__0__Impl7882); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getLeftCurlyBracketKeyword_3_0()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3__0__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3953:1: rule__AttrInstanceConfig__Group_3__1 : rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2 ;
    public final void rule__AttrInstanceConfig__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3957:1: ( rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3958:2: rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__1__Impl_in_rule__AttrInstanceConfig__Group_3__17913);
            rule__AttrInstanceConfig__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__2_in_rule__AttrInstanceConfig__Group_3__17916);
            rule__AttrInstanceConfig__Group_3__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3__1"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3965:1: rule__AttrInstanceConfig__Group_3__1__Impl : ( ( rule__AttrInstanceConfig__Group_3_1__0 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3969:1: ( ( ( rule__AttrInstanceConfig__Group_3_1__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3970:1: ( ( rule__AttrInstanceConfig__Group_3_1__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3970:1: ( ( rule__AttrInstanceConfig__Group_3_1__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3971:1: ( rule__AttrInstanceConfig__Group_3_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3972:1: ( rule__AttrInstanceConfig__Group_3_1__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3972:2: rule__AttrInstanceConfig__Group_3_1__0
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1__0_in_rule__AttrInstanceConfig__Group_3__1__Impl7943);
            rule__AttrInstanceConfig__Group_3_1__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3__1__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3982:1: rule__AttrInstanceConfig__Group_3__2 : rule__AttrInstanceConfig__Group_3__2__Impl ;
    public final void rule__AttrInstanceConfig__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3986:1: ( rule__AttrInstanceConfig__Group_3__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3987:2: rule__AttrInstanceConfig__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__2__Impl_in_rule__AttrInstanceConfig__Group_3__27973);
            rule__AttrInstanceConfig__Group_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3__2"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3993:1: rule__AttrInstanceConfig__Group_3__2__Impl : ( '}' ) ;
    public final void rule__AttrInstanceConfig__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3997:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3998:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3998:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3999:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getRightCurlyBracketKeyword_3_2()); 
            }
            match(input,20,FOLLOW_20_in_rule__AttrInstanceConfig__Group_3__2__Impl8001); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getRightCurlyBracketKeyword_3_2()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3__2__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4018:1: rule__AttrInstanceConfig__Group_3_1__0 : rule__AttrInstanceConfig__Group_3_1__0__Impl rule__AttrInstanceConfig__Group_3_1__1 ;
    public final void rule__AttrInstanceConfig__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4022:1: ( rule__AttrInstanceConfig__Group_3_1__0__Impl rule__AttrInstanceConfig__Group_3_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4023:2: rule__AttrInstanceConfig__Group_3_1__0__Impl rule__AttrInstanceConfig__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1__0__Impl_in_rule__AttrInstanceConfig__Group_3_1__08038);
            rule__AttrInstanceConfig__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1__1_in_rule__AttrInstanceConfig__Group_3_1__08041);
            rule__AttrInstanceConfig__Group_3_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3_1__0"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4030:1: rule__AttrInstanceConfig__Group_3_1__0__Impl : ( ( rule__AttrInstanceConfig__Group_3_1_0__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4034:1: ( ( ( rule__AttrInstanceConfig__Group_3_1_0__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4035:1: ( ( rule__AttrInstanceConfig__Group_3_1_0__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4035:1: ( ( rule__AttrInstanceConfig__Group_3_1_0__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4036:1: ( rule__AttrInstanceConfig__Group_3_1_0__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4037:1: ( rule__AttrInstanceConfig__Group_3_1_0__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==22) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4037:2: rule__AttrInstanceConfig__Group_3_1_0__0
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__0_in_rule__AttrInstanceConfig__Group_3_1__0__Impl8068);
                    rule__AttrInstanceConfig__Group_3_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1_0()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3_1__0__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3_1__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4047:1: rule__AttrInstanceConfig__Group_3_1__1 : rule__AttrInstanceConfig__Group_3_1__1__Impl ;
    public final void rule__AttrInstanceConfig__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4051:1: ( rule__AttrInstanceConfig__Group_3_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4052:2: rule__AttrInstanceConfig__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1__1__Impl_in_rule__AttrInstanceConfig__Group_3_1__18099);
            rule__AttrInstanceConfig__Group_3_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3_1__1"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4058:1: rule__AttrInstanceConfig__Group_3_1__1__Impl : ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) ;
    public final void rule__AttrInstanceConfig__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4062:1: ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4063:1: ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4063:1: ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4064:1: ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributesAssignment_3_1_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4065:1: ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==35) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4065:2: rule__AttrInstanceConfig__AttributesAssignment_3_1_1
            	    {
            	    pushFollow(FOLLOW_rule__AttrInstanceConfig__AttributesAssignment_3_1_1_in_rule__AttrInstanceConfig__Group_3_1__1__Impl8126);
            	    rule__AttrInstanceConfig__AttributesAssignment_3_1_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getAttributesAssignment_3_1_1()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3_1__1__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3_1_0__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4079:1: rule__AttrInstanceConfig__Group_3_1_0__0 : rule__AttrInstanceConfig__Group_3_1_0__0__Impl rule__AttrInstanceConfig__Group_3_1_0__1 ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4083:1: ( rule__AttrInstanceConfig__Group_3_1_0__0__Impl rule__AttrInstanceConfig__Group_3_1_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4084:2: rule__AttrInstanceConfig__Group_3_1_0__0__Impl rule__AttrInstanceConfig__Group_3_1_0__1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__0__Impl_in_rule__AttrInstanceConfig__Group_3_1_0__08161);
            rule__AttrInstanceConfig__Group_3_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__1_in_rule__AttrInstanceConfig__Group_3_1_0__08164);
            rule__AttrInstanceConfig__Group_3_1_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3_1_0__0"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3_1_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4091:1: rule__AttrInstanceConfig__Group_3_1_0__0__Impl : ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4095:1: ( ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4096:1: ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4096:1: ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4097:1: ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigAssignment_3_1_0_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4098:1: ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4098:2: rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0_in_rule__AttrInstanceConfig__Group_3_1_0__0__Impl8191);
            rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getDynConfigAssignment_3_1_0_0()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3_1_0__0__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3_1_0__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4108:1: rule__AttrInstanceConfig__Group_3_1_0__1 : rule__AttrInstanceConfig__Group_3_1_0__1__Impl ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4112:1: ( rule__AttrInstanceConfig__Group_3_1_0__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4113:2: rule__AttrInstanceConfig__Group_3_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__1__Impl_in_rule__AttrInstanceConfig__Group_3_1_0__18221);
            rule__AttrInstanceConfig__Group_3_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3_1_0__1"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3_1_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4119:1: rule__AttrInstanceConfig__Group_3_1_0__1__Impl : ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4123:1: ( ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4124:1: ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4124:1: ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4125:1: ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAlternatives_3_1_0_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4126:1: ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4126:2: rule__AttrInstanceConfig__Alternatives_3_1_0_1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Alternatives_3_1_0_1_in_rule__AttrInstanceConfig__Group_3_1_0__1__Impl8248);
            rule__AttrInstanceConfig__Alternatives_3_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getAlternatives_3_1_0_1()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3_1_0__1__Impl"


    // $ANTLR start "rule__RefPath__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4140:1: rule__RefPath__Group__0 : rule__RefPath__Group__0__Impl rule__RefPath__Group__1 ;
    public final void rule__RefPath__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4144:1: ( rule__RefPath__Group__0__Impl rule__RefPath__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4145:2: rule__RefPath__Group__0__Impl rule__RefPath__Group__1
            {
            pushFollow(FOLLOW_rule__RefPath__Group__0__Impl_in_rule__RefPath__Group__08282);
            rule__RefPath__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RefPath__Group__1_in_rule__RefPath__Group__08285);
            rule__RefPath__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__RefPath__Group__0"


    // $ANTLR start "rule__RefPath__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4152:1: rule__RefPath__Group__0__Impl : ( ( rule__RefPath__RefsAssignment_0 ) ) ;
    public final void rule__RefPath__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4156:1: ( ( ( rule__RefPath__RefsAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4157:1: ( ( rule__RefPath__RefsAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4157:1: ( ( rule__RefPath__RefsAssignment_0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4158:1: ( rule__RefPath__RefsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsAssignment_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4159:1: ( rule__RefPath__RefsAssignment_0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4159:2: rule__RefPath__RefsAssignment_0
            {
            pushFollow(FOLLOW_rule__RefPath__RefsAssignment_0_in_rule__RefPath__Group__0__Impl8312);
            rule__RefPath__RefsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefPathAccess().getRefsAssignment_0()); 
            }

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
    // $ANTLR end "rule__RefPath__Group__0__Impl"


    // $ANTLR start "rule__RefPath__Group__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4169:1: rule__RefPath__Group__1 : rule__RefPath__Group__1__Impl ;
    public final void rule__RefPath__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4173:1: ( rule__RefPath__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4174:2: rule__RefPath__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RefPath__Group__1__Impl_in_rule__RefPath__Group__18342);
            rule__RefPath__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__RefPath__Group__1"


    // $ANTLR start "rule__RefPath__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4180:1: rule__RefPath__Group__1__Impl : ( ( rule__RefPath__Group_1__0 )* ) ;
    public final void rule__RefPath__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4184:1: ( ( ( rule__RefPath__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4185:1: ( ( rule__RefPath__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4185:1: ( ( rule__RefPath__Group_1__0 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4186:1: ( rule__RefPath__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getGroup_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4187:1: ( rule__RefPath__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==29) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4187:2: rule__RefPath__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__RefPath__Group_1__0_in_rule__RefPath__Group__1__Impl8369);
            	    rule__RefPath__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefPathAccess().getGroup_1()); 
            }

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
    // $ANTLR end "rule__RefPath__Group__1__Impl"


    // $ANTLR start "rule__RefPath__Group_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4201:1: rule__RefPath__Group_1__0 : rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1 ;
    public final void rule__RefPath__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4205:1: ( rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4206:2: rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1
            {
            pushFollow(FOLLOW_rule__RefPath__Group_1__0__Impl_in_rule__RefPath__Group_1__08404);
            rule__RefPath__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RefPath__Group_1__1_in_rule__RefPath__Group_1__08407);
            rule__RefPath__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__RefPath__Group_1__0"


    // $ANTLR start "rule__RefPath__Group_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4213:1: rule__RefPath__Group_1__0__Impl : ( '/' ) ;
    public final void rule__RefPath__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4217:1: ( ( '/' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4218:1: ( '/' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4218:1: ( '/' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4219:1: '/'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getSolidusKeyword_1_0()); 
            }
            match(input,29,FOLLOW_29_in_rule__RefPath__Group_1__0__Impl8435); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefPathAccess().getSolidusKeyword_1_0()); 
            }

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
    // $ANTLR end "rule__RefPath__Group_1__0__Impl"


    // $ANTLR start "rule__RefPath__Group_1__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4232:1: rule__RefPath__Group_1__1 : rule__RefPath__Group_1__1__Impl ;
    public final void rule__RefPath__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4236:1: ( rule__RefPath__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4237:2: rule__RefPath__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__RefPath__Group_1__1__Impl_in_rule__RefPath__Group_1__18466);
            rule__RefPath__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__RefPath__Group_1__1"


    // $ANTLR start "rule__RefPath__Group_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4243:1: rule__RefPath__Group_1__1__Impl : ( ( rule__RefPath__RefsAssignment_1_1 ) ) ;
    public final void rule__RefPath__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4247:1: ( ( ( rule__RefPath__RefsAssignment_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4248:1: ( ( rule__RefPath__RefsAssignment_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4248:1: ( ( rule__RefPath__RefsAssignment_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4249:1: ( rule__RefPath__RefsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsAssignment_1_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4250:1: ( rule__RefPath__RefsAssignment_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4250:2: rule__RefPath__RefsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RefPath__RefsAssignment_1_1_in_rule__RefPath__Group_1__1__Impl8493);
            rule__RefPath__RefsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefPathAccess().getRefsAssignment_1_1()); 
            }

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
    // $ANTLR end "rule__RefPath__Group_1__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4264:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4268:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4269:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__08527);
            rule__Import__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__08530);
            rule__Import__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4276:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4280:1: ( ( 'import' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4281:1: ( 'import' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4281:1: ( 'import' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4282:1: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }
            match(input,39,FOLLOW_39_in_rule__Import__Group__0__Impl8558); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }

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
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4295:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4299:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4300:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__18589);
            rule__Import__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Import__Group__2_in_rule__Import__Group__18592);
            rule__Import__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4307:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4311:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4312:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4312:1: ( ( rule__Import__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4313:1: ( rule__Import__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4314:1: ( rule__Import__Alternatives_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4314:2: rule__Import__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl8619);
            rule__Import__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getAlternatives_1()); 
            }

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
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4324:1: rule__Import__Group__2 : rule__Import__Group__2__Impl ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4328:1: ( rule__Import__Group__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4329:2: rule__Import__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__28649);
            rule__Import__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Import__Group__2"


    // $ANTLR start "rule__Import__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4335:1: rule__Import__Group__2__Impl : ( ( rule__Import__ImportURIAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4339:1: ( ( ( rule__Import__ImportURIAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4340:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4340:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4341:1: ( rule__Import__ImportURIAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportURIAssignment_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4342:1: ( rule__Import__ImportURIAssignment_2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4342:2: rule__Import__ImportURIAssignment_2
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl8676);
            rule__Import__ImportURIAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportURIAssignment_2()); 
            }

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
    // $ANTLR end "rule__Import__Group__2__Impl"


    // $ANTLR start "rule__Import__Group_1_0__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4358:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4362:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4363:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__08712);
            rule__Import__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__08715);
            rule__Import__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Import__Group_1_0__0"


    // $ANTLR start "rule__Import__Group_1_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4370:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4374:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4375:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4375:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4376:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4377:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4377:2: rule__Import__ImportedNamespaceAssignment_1_0_0
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl8742);
            rule__Import__ImportedNamespaceAssignment_1_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            }

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
    // $ANTLR end "rule__Import__Group_1_0__0__Impl"


    // $ANTLR start "rule__Import__Group_1_0__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4387:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4391:1: ( rule__Import__Group_1_0__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4392:2: rule__Import__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__18772);
            rule__Import__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Import__Group_1_0__1"


    // $ANTLR start "rule__Import__Group_1_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4398:1: rule__Import__Group_1_0__1__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4402:1: ( ( 'from' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4403:1: ( 'from' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4403:1: ( 'from' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4404:1: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 
            }
            match(input,40,FOLLOW_40_in_rule__Import__Group_1_0__1__Impl8800); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 
            }

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
    // $ANTLR end "rule__Import__Group_1_0__1__Impl"


    // $ANTLR start "rule__ImportedFQN__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4421:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4425:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4426:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__08835);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__08838);
            rule__ImportedFQN__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4433:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4437:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4438:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4438:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4439:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl8865);
            ruleFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4450:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4454:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4455:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__18894);
            rule__ImportedFQN__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4461:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4465:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4466:1: ( ( '.*' )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4466:1: ( ( '.*' )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4467:1: ( '.*' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4468:1: ( '.*' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==41) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4469:2: '.*'
                    {
                    match(input,41,FOLLOW_41_in_rule__ImportedFQN__Group__1__Impl8923); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            }

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


    // $ANTLR start "rule__FQN__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4484:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4488:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4489:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__08960);
            rule__FQN__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__08963);
            rule__FQN__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4496:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4500:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4501:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4501:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4502:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl8990); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4513:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4517:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4518:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__19019);
            rule__FQN__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4524:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4528:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4529:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4529:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4530:1: ( rule__FQN__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getGroup_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4531:1: ( rule__FQN__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==42) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4531:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl9046);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFQNAccess().getGroup_1()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4545:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4549:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4550:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__09081);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__09084);
            rule__FQN__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4557:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4561:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4562:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4562:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4563:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            }
            match(input,42,FOLLOW_42_in_rule__FQN__Group_1__0__Impl9112); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4576:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4580:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4581:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__19143);
            rule__FQN__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4587:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4591:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4592:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4592:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4593:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl9170); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            }

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


    // $ANTLR start "rule__LiteralArray__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4608:1: rule__LiteralArray__Group__0 : rule__LiteralArray__Group__0__Impl rule__LiteralArray__Group__1 ;
    public final void rule__LiteralArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4612:1: ( rule__LiteralArray__Group__0__Impl rule__LiteralArray__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4613:2: rule__LiteralArray__Group__0__Impl rule__LiteralArray__Group__1
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group__0__Impl_in_rule__LiteralArray__Group__09203);
            rule__LiteralArray__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LiteralArray__Group__1_in_rule__LiteralArray__Group__09206);
            rule__LiteralArray__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__LiteralArray__Group__0"


    // $ANTLR start "rule__LiteralArray__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4620:1: rule__LiteralArray__Group__0__Impl : ( ( rule__LiteralArray__LiteralsAssignment_0 ) ) ;
    public final void rule__LiteralArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4624:1: ( ( ( rule__LiteralArray__LiteralsAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4625:1: ( ( rule__LiteralArray__LiteralsAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4625:1: ( ( rule__LiteralArray__LiteralsAssignment_0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4626:1: ( rule__LiteralArray__LiteralsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4627:1: ( rule__LiteralArray__LiteralsAssignment_0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4627:2: rule__LiteralArray__LiteralsAssignment_0
            {
            pushFollow(FOLLOW_rule__LiteralArray__LiteralsAssignment_0_in_rule__LiteralArray__Group__0__Impl9233);
            rule__LiteralArray__LiteralsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_0()); 
            }

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
    // $ANTLR end "rule__LiteralArray__Group__0__Impl"


    // $ANTLR start "rule__LiteralArray__Group__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4637:1: rule__LiteralArray__Group__1 : rule__LiteralArray__Group__1__Impl ;
    public final void rule__LiteralArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4641:1: ( rule__LiteralArray__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4642:2: rule__LiteralArray__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group__1__Impl_in_rule__LiteralArray__Group__19263);
            rule__LiteralArray__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__LiteralArray__Group__1"


    // $ANTLR start "rule__LiteralArray__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4648:1: rule__LiteralArray__Group__1__Impl : ( ( rule__LiteralArray__Group_1__0 )* ) ;
    public final void rule__LiteralArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4652:1: ( ( ( rule__LiteralArray__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4653:1: ( ( rule__LiteralArray__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4653:1: ( ( rule__LiteralArray__Group_1__0 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4654:1: ( rule__LiteralArray__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayAccess().getGroup_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4655:1: ( rule__LiteralArray__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==43) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4655:2: rule__LiteralArray__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__LiteralArray__Group_1__0_in_rule__LiteralArray__Group__1__Impl9290);
            	    rule__LiteralArray__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralArrayAccess().getGroup_1()); 
            }

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
    // $ANTLR end "rule__LiteralArray__Group__1__Impl"


    // $ANTLR start "rule__LiteralArray__Group_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4669:1: rule__LiteralArray__Group_1__0 : rule__LiteralArray__Group_1__0__Impl rule__LiteralArray__Group_1__1 ;
    public final void rule__LiteralArray__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4673:1: ( rule__LiteralArray__Group_1__0__Impl rule__LiteralArray__Group_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4674:2: rule__LiteralArray__Group_1__0__Impl rule__LiteralArray__Group_1__1
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group_1__0__Impl_in_rule__LiteralArray__Group_1__09325);
            rule__LiteralArray__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LiteralArray__Group_1__1_in_rule__LiteralArray__Group_1__09328);
            rule__LiteralArray__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__LiteralArray__Group_1__0"


    // $ANTLR start "rule__LiteralArray__Group_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4681:1: rule__LiteralArray__Group_1__0__Impl : ( ',' ) ;
    public final void rule__LiteralArray__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4685:1: ( ( ',' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4686:1: ( ',' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4686:1: ( ',' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4687:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayAccess().getCommaKeyword_1_0()); 
            }
            match(input,43,FOLLOW_43_in_rule__LiteralArray__Group_1__0__Impl9356); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralArrayAccess().getCommaKeyword_1_0()); 
            }

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
    // $ANTLR end "rule__LiteralArray__Group_1__0__Impl"


    // $ANTLR start "rule__LiteralArray__Group_1__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4700:1: rule__LiteralArray__Group_1__1 : rule__LiteralArray__Group_1__1__Impl ;
    public final void rule__LiteralArray__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4704:1: ( rule__LiteralArray__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4705:2: rule__LiteralArray__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group_1__1__Impl_in_rule__LiteralArray__Group_1__19387);
            rule__LiteralArray__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__LiteralArray__Group_1__1"


    // $ANTLR start "rule__LiteralArray__Group_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4711:1: rule__LiteralArray__Group_1__1__Impl : ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) ) ;
    public final void rule__LiteralArray__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4715:1: ( ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4716:1: ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4716:1: ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4717:1: ( rule__LiteralArray__LiteralsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_1_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4718:1: ( rule__LiteralArray__LiteralsAssignment_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4718:2: rule__LiteralArray__LiteralsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__LiteralArray__LiteralsAssignment_1_1_in_rule__LiteralArray__Group_1__1__Impl9414);
            rule__LiteralArray__LiteralsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_1_1()); 
            }

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
    // $ANTLR end "rule__LiteralArray__Group_1__1__Impl"


    // $ANTLR start "rule__BooleanLiteral__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4732:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4736:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4737:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__09448);
            rule__BooleanLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__09451);
            rule__BooleanLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4744:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4748:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4749:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4749:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4750:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4751:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4753:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4763:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4767:1: ( rule__BooleanLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4768:2: rule__BooleanLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__19509);
            rule__BooleanLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4774:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4778:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4779:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4779:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4780:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4781:1: ( rule__BooleanLiteral__Alternatives_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4781:2: rule__BooleanLiteral__Alternatives_1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl9536);
            rule__BooleanLiteral__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4795:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4799:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4800:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__09570);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__09573);
            rule__RealLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4807:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4811:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4812:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4812:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4813:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4814:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4816:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4826:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4830:1: ( rule__RealLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4831:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__19631);
            rule__RealLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4837:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4841:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4842:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4842:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4843:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4844:1: ( rule__RealLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4844:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl9658);
            rule__RealLiteral__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4858:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4862:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4863:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__09692);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__09695);
            rule__IntLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4870:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4874:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4875:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4875:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4876:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4877:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4879:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4889:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4893:1: ( rule__IntLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4894:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__19753);
            rule__IntLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4900:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4904:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4905:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4905:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4906:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4907:1: ( rule__IntLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4907:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl9780);
            rule__IntLiteral__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4921:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4925:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4926:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__09814);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__09817);
            rule__StringLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4933:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4937:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4938:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4938:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4939:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4940:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4942:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4952:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4956:1: ( rule__StringLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4957:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__19875);
            rule__StringLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4963:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4967:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4968:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4968:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4969:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4970:1: ( rule__StringLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4970:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl9902);
            rule__StringLiteral__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4984:1: rule__SignedInteger__Group__0 : rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 ;
    public final void rule__SignedInteger__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4988:1: ( rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4989:2: rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__09936);
            rule__SignedInteger__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__09939);
            rule__SignedInteger__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4996:1: rule__SignedInteger__Group__0__Impl : ( ( rule__SignedInteger__Alternatives_0 )? ) ;
    public final void rule__SignedInteger__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5000:1: ( ( ( rule__SignedInteger__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5001:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5001:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5002:1: ( rule__SignedInteger__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignedIntegerAccess().getAlternatives_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5003:1: ( rule__SignedInteger__Alternatives_0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=16 && LA33_0<=17)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5003:2: rule__SignedInteger__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl9966);
                    rule__SignedInteger__Alternatives_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSignedIntegerAccess().getAlternatives_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5013:1: rule__SignedInteger__Group__1 : rule__SignedInteger__Group__1__Impl ;
    public final void rule__SignedInteger__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5017:1: ( rule__SignedInteger__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5018:2: rule__SignedInteger__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__19997);
            rule__SignedInteger__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5024:1: rule__SignedInteger__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__SignedInteger__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5028:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5029:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5029:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5030:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl10024); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5045:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5049:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5050:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__010057);
            rule__Decimal__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__010060);
            rule__Decimal__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5057:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5061:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5062:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5062:1: ( ( rule__Decimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5063:1: ( rule__Decimal__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5064:1: ( rule__Decimal__Alternatives_0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=16 && LA34_0<=17)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5064:2: rule__Decimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl10087);
                    rule__Decimal__Alternatives_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5074:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5078:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5079:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__110118);
            rule__Decimal__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__110121);
            rule__Decimal__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5086:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5090:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5091:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5091:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5092:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl10148); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5103:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5107:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5108:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
            {
            pushFollow(FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__210177);
            rule__Decimal__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__210180);
            rule__Decimal__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5115:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5119:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5120:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5120:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5121:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            }
            match(input,42,FOLLOW_42_in_rule__Decimal__Group__2__Impl10208); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5134:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5138:1: ( rule__Decimal__Group__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5139:2: rule__Decimal__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__310239);
            rule__Decimal__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5145:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5149:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5150:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5150:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5151:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl10266); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5170:1: rule__DotDecimal__Group__0 : rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 ;
    public final void rule__DotDecimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5174:1: ( rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5175:2: rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__010303);
            rule__DotDecimal__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__010306);
            rule__DotDecimal__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5182:1: rule__DotDecimal__Group__0__Impl : ( ( rule__DotDecimal__Alternatives_0 )? ) ;
    public final void rule__DotDecimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5186:1: ( ( ( rule__DotDecimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5187:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5187:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5188:1: ( rule__DotDecimal__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDotDecimalAccess().getAlternatives_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5189:1: ( rule__DotDecimal__Alternatives_0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=16 && LA35_0<=17)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5189:2: rule__DotDecimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl10333);
                    rule__DotDecimal__Alternatives_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDotDecimalAccess().getAlternatives_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5199:1: rule__DotDecimal__Group__1 : rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 ;
    public final void rule__DotDecimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5203:1: ( rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5204:2: rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__110364);
            rule__DotDecimal__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__110367);
            rule__DotDecimal__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5211:1: rule__DotDecimal__Group__1__Impl : ( '.' ) ;
    public final void rule__DotDecimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5215:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5216:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5216:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5217:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
            }
            match(input,42,FOLLOW_42_in_rule__DotDecimal__Group__1__Impl10395); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5230:1: rule__DotDecimal__Group__2 : rule__DotDecimal__Group__2__Impl ;
    public final void rule__DotDecimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5234:1: ( rule__DotDecimal__Group__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5235:2: rule__DotDecimal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__210426);
            rule__DotDecimal__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5241:1: rule__DotDecimal__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DotDecimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5245:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5246:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5246:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5247:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl10453); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5264:1: rule__DecimalDot__Group__0 : rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 ;
    public final void rule__DecimalDot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5268:1: ( rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5269:2: rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__010488);
            rule__DecimalDot__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__010491);
            rule__DecimalDot__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5276:1: rule__DecimalDot__Group__0__Impl : ( ( rule__DecimalDot__Alternatives_0 )? ) ;
    public final void rule__DecimalDot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5280:1: ( ( ( rule__DecimalDot__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5281:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5281:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5282:1: ( rule__DecimalDot__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalDotAccess().getAlternatives_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5283:1: ( rule__DecimalDot__Alternatives_0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=16 && LA36_0<=17)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5283:2: rule__DecimalDot__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl10518);
                    rule__DecimalDot__Alternatives_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalDotAccess().getAlternatives_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5293:1: rule__DecimalDot__Group__1 : rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 ;
    public final void rule__DecimalDot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5297:1: ( rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5298:2: rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__110549);
            rule__DecimalDot__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__110552);
            rule__DecimalDot__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5305:1: rule__DecimalDot__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalDot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5309:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5310:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5310:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5311:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl10579); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5322:1: rule__DecimalDot__Group__2 : rule__DecimalDot__Group__2__Impl ;
    public final void rule__DecimalDot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5326:1: ( rule__DecimalDot__Group__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5327:2: rule__DecimalDot__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__210608);
            rule__DecimalDot__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5333:1: rule__DecimalDot__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalDot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5337:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5338:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5338:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5339:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 
            }
            match(input,42,FOLLOW_42_in_rule__DecimalDot__Group__2__Impl10636); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5358:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5362:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5363:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__010673);
            rule__DecimalExp__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__010676);
            rule__DecimalExp__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5370:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5374:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5375:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5375:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5376:1: ( rule__DecimalExp__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5377:1: ( rule__DecimalExp__Alternatives_0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=16 && LA37_0<=17)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5377:2: rule__DecimalExp__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl10703);
                    rule__DecimalExp__Alternatives_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5387:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5391:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5392:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__110734);
            rule__DecimalExp__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__110737);
            rule__DecimalExp__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5399:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5403:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5404:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5404:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5405:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl10764); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5416:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5420:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5421:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__210793);
            rule__DecimalExp__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__210796);
            rule__DecimalExp__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5428:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5432:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5433:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5433:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5434:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            }
            match(input,42,FOLLOW_42_in_rule__DecimalExp__Group__2__Impl10824); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5447:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5451:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5452:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__310855);
            rule__DecimalExp__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__310858);
            rule__DecimalExp__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5459:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5463:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5464:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5464:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5465:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl10885); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5476:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5480:1: ( rule__DecimalExp__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5481:2: rule__DecimalExp__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__410914);
            rule__DecimalExp__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5487:1: rule__DecimalExp__Group__4__Impl : ( RULE_EXP ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5491:1: ( ( RULE_EXP ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5492:1: ( RULE_EXP )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5492:1: ( RULE_EXP )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5493:1: RULE_EXP
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 
            }
            match(input,RULE_EXP,FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl10941); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 
            }

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


    // $ANTLR start "rule__DynamicConfig__UnorderedGroup_2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5515:1: rule__DynamicConfig__UnorderedGroup_2 : rule__DynamicConfig__UnorderedGroup_2__0 {...}?;
    public final void rule__DynamicConfig__UnorderedGroup_2() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2());
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5520:1: ( rule__DynamicConfig__UnorderedGroup_2__0 {...}?)
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5521:2: rule__DynamicConfig__UnorderedGroup_2__0 {...}?
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2__0_in_rule__DynamicConfig__UnorderedGroup_210981);
            rule__DynamicConfig__UnorderedGroup_2__0();

            state._fsp--;
            if (state.failed) return ;
            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2()) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "rule__DynamicConfig__UnorderedGroup_2", "getUnorderedGroupHelper().canLeave(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DynamicConfig__UnorderedGroup_2"


    // $ANTLR start "rule__DynamicConfig__UnorderedGroup_2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5532:1: rule__DynamicConfig__UnorderedGroup_2__Impl : ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) ) ;
    public final void rule__DynamicConfig__UnorderedGroup_2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5537:1: ( ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5538:3: ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5538:3: ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( LA38_0 >=23 && LA38_0<=24 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                alt38=1;
            }
            else if ( LA38_0 ==26 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5540:4: ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5540:4: ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5541:5: {...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__DynamicConfig__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5541:110: ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5542:6: ( ( rule__DynamicConfig__Alternatives_2_0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5548:6: ( ( rule__DynamicConfig__Alternatives_2_0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5550:7: ( rule__DynamicConfig__Alternatives_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getAlternatives_2_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5551:7: ( rule__DynamicConfig__Alternatives_2_0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5551:8: rule__DynamicConfig__Alternatives_2_0
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__Alternatives_2_0_in_rule__DynamicConfig__UnorderedGroup_2__Impl11070);
                    rule__DynamicConfig__Alternatives_2_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDynamicConfigAccess().getAlternatives_2_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5557:4: ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5557:4: ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5558:5: {...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__DynamicConfig__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5558:110: ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5559:6: ( ( rule__DynamicConfig__Group_2_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5565:6: ( ( rule__DynamicConfig__Group_2_1__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5567:7: ( rule__DynamicConfig__Group_2_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getGroup_2_1()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5568:7: ( rule__DynamicConfig__Group_2_1__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5568:8: rule__DynamicConfig__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__Group_2_1__0_in_rule__DynamicConfig__UnorderedGroup_2__Impl11161);
                    rule__DynamicConfig__Group_2_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDynamicConfigAccess().getGroup_2_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DynamicConfig__UnorderedGroup_2__Impl"


    // $ANTLR start "rule__DynamicConfig__UnorderedGroup_2__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5583:1: rule__DynamicConfig__UnorderedGroup_2__0 : rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )? ;
    public final void rule__DynamicConfig__UnorderedGroup_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5587:1: ( rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5588:2: rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )?
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2__Impl_in_rule__DynamicConfig__UnorderedGroup_2__011220);
            rule__DynamicConfig__UnorderedGroup_2__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5589:2: ( rule__DynamicConfig__UnorderedGroup_2__1 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( LA39_0 >=23 && LA39_0<=24 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                alt39=1;
            }
            else if ( LA39_0 ==26 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5589:2: rule__DynamicConfig__UnorderedGroup_2__1
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2__1_in_rule__DynamicConfig__UnorderedGroup_2__011223);
                    rule__DynamicConfig__UnorderedGroup_2__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

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
    // $ANTLR end "rule__DynamicConfig__UnorderedGroup_2__0"


    // $ANTLR start "rule__DynamicConfig__UnorderedGroup_2__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5596:1: rule__DynamicConfig__UnorderedGroup_2__1 : rule__DynamicConfig__UnorderedGroup_2__Impl ;
    public final void rule__DynamicConfig__UnorderedGroup_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5600:1: ( rule__DynamicConfig__UnorderedGroup_2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5601:2: rule__DynamicConfig__UnorderedGroup_2__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2__Impl_in_rule__DynamicConfig__UnorderedGroup_2__111248);
            rule__DynamicConfig__UnorderedGroup_2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__DynamicConfig__UnorderedGroup_2__1"


    // $ANTLR start "rule__ActorInstanceConfig__UnorderedGroup_7"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5612:1: rule__ActorInstanceConfig__UnorderedGroup_7 : ( rule__ActorInstanceConfig__UnorderedGroup_7__0 )? ;
    public final void rule__ActorInstanceConfig__UnorderedGroup_7() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7());
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5617:1: ( ( rule__ActorInstanceConfig__UnorderedGroup_7__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5618:2: ( rule__ActorInstanceConfig__UnorderedGroup_7__0 )?
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5618:2: ( rule__ActorInstanceConfig__UnorderedGroup_7__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( LA40_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0) ) {
                alt40=1;
            }
            else if ( LA40_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5618:2: rule__ActorInstanceConfig__UnorderedGroup_7__0
                    {
                    pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup_7__0_in_rule__ActorInstanceConfig__UnorderedGroup_711276);
                    rule__ActorInstanceConfig__UnorderedGroup_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceConfig__UnorderedGroup_7"


    // $ANTLR start "rule__ActorInstanceConfig__UnorderedGroup_7__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5628:1: rule__ActorInstanceConfig__UnorderedGroup_7__Impl : ( ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) ) ) ;
    public final void rule__ActorInstanceConfig__UnorderedGroup_7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5633:1: ( ( ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5634:3: ( ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5634:3: ( ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( LA43_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0) ) {
                alt43=1;
            }
            else if ( LA43_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5636:4: ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5636:4: ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5637:5: {...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ActorInstanceConfig__UnorderedGroup_7__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5637:116: ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5638:6: ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5644:6: ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5645:6: ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5645:6: ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5646:7: ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_7_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5647:7: ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5647:8: rule__ActorInstanceConfig__AttributesAssignment_7_0
                    {
                    pushFollow(FOLLOW_rule__ActorInstanceConfig__AttributesAssignment_7_0_in_rule__ActorInstanceConfig__UnorderedGroup_7__Impl11364);
                    rule__ActorInstanceConfig__AttributesAssignment_7_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_7_0()); 
                    }

                    }

                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5650:6: ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5651:7: ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_7_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5652:7: ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==35) ) {
                            int LA41_1 = input.LA(2);

                            if ( (LA41_1==RULE_ID) ) {
                                int LA41_3 = input.LA(3);

                                if ( (synpred1_InternalConfig()) ) {
                                    alt41=1;
                                }


                            }


                        }


                        switch (alt41) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5652:8: ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0
                    	    {
                    	    pushFollow(FOLLOW_rule__ActorInstanceConfig__AttributesAssignment_7_0_in_rule__ActorInstanceConfig__UnorderedGroup_7__Impl11408);
                    	    rule__ActorInstanceConfig__AttributesAssignment_7_0();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_7_0()); 
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5658:4: ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5658:4: ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5659:5: {...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ActorInstanceConfig__UnorderedGroup_7__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5659:116: ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5660:6: ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5666:6: ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5667:6: ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5667:6: ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5668:7: ( rule__ActorInstanceConfig__PortsAssignment_7_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_7_1()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5669:7: ( rule__ActorInstanceConfig__PortsAssignment_7_1 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5669:8: rule__ActorInstanceConfig__PortsAssignment_7_1
                    {
                    pushFollow(FOLLOW_rule__ActorInstanceConfig__PortsAssignment_7_1_in_rule__ActorInstanceConfig__UnorderedGroup_7__Impl11507);
                    rule__ActorInstanceConfig__PortsAssignment_7_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_7_1()); 
                    }

                    }

                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5672:6: ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5673:7: ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_7_1()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5674:7: ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==34) ) {
                            int LA42_2 = input.LA(2);

                            if ( (synpred2_InternalConfig()) ) {
                                alt42=1;
                            }


                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5674:8: ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1
                    	    {
                    	    pushFollow(FOLLOW_rule__ActorInstanceConfig__PortsAssignment_7_1_in_rule__ActorInstanceConfig__UnorderedGroup_7__Impl11551);
                    	    rule__ActorInstanceConfig__PortsAssignment_7_1();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_7_1()); 
                    }

                    }


                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceConfig__UnorderedGroup_7__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__UnorderedGroup_7__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5689:1: rule__ActorInstanceConfig__UnorderedGroup_7__0 : rule__ActorInstanceConfig__UnorderedGroup_7__Impl ( rule__ActorInstanceConfig__UnorderedGroup_7__1 )? ;
    public final void rule__ActorInstanceConfig__UnorderedGroup_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5693:1: ( rule__ActorInstanceConfig__UnorderedGroup_7__Impl ( rule__ActorInstanceConfig__UnorderedGroup_7__1 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5694:2: rule__ActorInstanceConfig__UnorderedGroup_7__Impl ( rule__ActorInstanceConfig__UnorderedGroup_7__1 )?
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup_7__Impl_in_rule__ActorInstanceConfig__UnorderedGroup_7__011617);
            rule__ActorInstanceConfig__UnorderedGroup_7__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5695:2: ( rule__ActorInstanceConfig__UnorderedGroup_7__1 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( LA44_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0) ) {
                alt44=1;
            }
            else if ( LA44_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5695:2: rule__ActorInstanceConfig__UnorderedGroup_7__1
                    {
                    pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup_7__1_in_rule__ActorInstanceConfig__UnorderedGroup_7__011620);
                    rule__ActorInstanceConfig__UnorderedGroup_7__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

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
    // $ANTLR end "rule__ActorInstanceConfig__UnorderedGroup_7__0"


    // $ANTLR start "rule__ActorInstanceConfig__UnorderedGroup_7__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5702:1: rule__ActorInstanceConfig__UnorderedGroup_7__1 : rule__ActorInstanceConfig__UnorderedGroup_7__Impl ;
    public final void rule__ActorInstanceConfig__UnorderedGroup_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5706:1: ( rule__ActorInstanceConfig__UnorderedGroup_7__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5707:2: rule__ActorInstanceConfig__UnorderedGroup_7__Impl
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup_7__Impl_in_rule__ActorInstanceConfig__UnorderedGroup_7__111645);
            rule__ActorInstanceConfig__UnorderedGroup_7__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ActorInstanceConfig__UnorderedGroup_7__1"


    // $ANTLR start "rule__ProtocolClassConfig__UnorderedGroup_3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5718:1: rule__ProtocolClassConfig__UnorderedGroup_3 : ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )? ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5723:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5724:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )?
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5724:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( LA45_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                alt45=1;
            }
            else if ( LA45_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5724:2: rule__ProtocolClassConfig__UnorderedGroup_3__0
                    {
                    pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__0_in_rule__ProtocolClassConfig__UnorderedGroup_311673);
                    rule__ProtocolClassConfig__UnorderedGroup_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProtocolClassConfig__UnorderedGroup_3"


    // $ANTLR start "rule__ProtocolClassConfig__UnorderedGroup_3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5734:1: rule__ProtocolClassConfig__UnorderedGroup_3__Impl : ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) ) ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5739:1: ( ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5740:3: ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5740:3: ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( LA46_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                alt46=1;
            }
            else if ( LA46_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5742:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5742:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5743:5: {...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ProtocolClassConfig__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5743:116: ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5744:6: ( ( rule__ProtocolClassConfig__Group_3_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5750:6: ( ( rule__ProtocolClassConfig__Group_3_0__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5752:7: ( rule__ProtocolClassConfig__Group_3_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProtocolClassConfigAccess().getGroup_3_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5753:7: ( rule__ProtocolClassConfig__Group_3_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5753:8: rule__ProtocolClassConfig__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_0__0_in_rule__ProtocolClassConfig__UnorderedGroup_3__Impl11760);
                    rule__ProtocolClassConfig__Group_3_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getProtocolClassConfigAccess().getGroup_3_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5759:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5759:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5760:5: {...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ProtocolClassConfig__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5760:116: ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5761:6: ( ( rule__ProtocolClassConfig__Group_3_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5767:6: ( ( rule__ProtocolClassConfig__Group_3_1__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5769:7: ( rule__ProtocolClassConfig__Group_3_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProtocolClassConfigAccess().getGroup_3_1()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5770:7: ( rule__ProtocolClassConfig__Group_3_1__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5770:8: rule__ProtocolClassConfig__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_1__0_in_rule__ProtocolClassConfig__UnorderedGroup_3__Impl11851);
                    rule__ProtocolClassConfig__Group_3_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getProtocolClassConfigAccess().getGroup_3_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProtocolClassConfig__UnorderedGroup_3__Impl"


    // $ANTLR start "rule__ProtocolClassConfig__UnorderedGroup_3__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5785:1: rule__ProtocolClassConfig__UnorderedGroup_3__0 : rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )? ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5789:1: ( rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5790:2: rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )?
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__Impl_in_rule__ProtocolClassConfig__UnorderedGroup_3__011910);
            rule__ProtocolClassConfig__UnorderedGroup_3__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5791:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( LA47_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                alt47=1;
            }
            else if ( LA47_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5791:2: rule__ProtocolClassConfig__UnorderedGroup_3__1
                    {
                    pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__1_in_rule__ProtocolClassConfig__UnorderedGroup_3__011913);
                    rule__ProtocolClassConfig__UnorderedGroup_3__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

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
    // $ANTLR end "rule__ProtocolClassConfig__UnorderedGroup_3__0"


    // $ANTLR start "rule__ProtocolClassConfig__UnorderedGroup_3__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5798:1: rule__ProtocolClassConfig__UnorderedGroup_3__1 : rule__ProtocolClassConfig__UnorderedGroup_3__Impl ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5802:1: ( rule__ProtocolClassConfig__UnorderedGroup_3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5803:2: rule__ProtocolClassConfig__UnorderedGroup_3__Impl
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__Impl_in_rule__ProtocolClassConfig__UnorderedGroup_3__111938);
            rule__ProtocolClassConfig__UnorderedGroup_3__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ProtocolClassConfig__UnorderedGroup_3__1"


    // $ANTLR start "rule__ConfigModel__NameAssignment_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5814:1: rule__ConfigModel__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__ConfigModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5818:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5819:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5819:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5820:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getNameFQNParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleFQN_in_rule__ConfigModel__NameAssignment_111970);
            ruleFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getNameFQNParserRuleCall_1_0()); 
            }

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
    // $ANTLR end "rule__ConfigModel__NameAssignment_1"


    // $ANTLR start "rule__ConfigModel__ImportsAssignment_3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5829:1: rule__ConfigModel__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__ConfigModel__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5833:1: ( ( ruleImport ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5834:1: ( ruleImport )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5834:1: ( ruleImport )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5835:1: ruleImport
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getImportsImportParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleImport_in_rule__ConfigModel__ImportsAssignment_312001);
            ruleImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getImportsImportParserRuleCall_3_0()); 
            }

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
    // $ANTLR end "rule__ConfigModel__ImportsAssignment_3"


    // $ANTLR start "rule__ConfigModel__ConfigElementsAssignment_4"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5844:1: rule__ConfigModel__ConfigElementsAssignment_4 : ( ruleConfigElement ) ;
    public final void rule__ConfigModel__ConfigElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5848:1: ( ( ruleConfigElement ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5849:1: ( ruleConfigElement )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5849:1: ( ruleConfigElement )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5850:1: ruleConfigElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getConfigElementsConfigElementParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_ruleConfigElement_in_rule__ConfigModel__ConfigElementsAssignment_412032);
            ruleConfigElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getConfigElementsConfigElementParserRuleCall_4_0()); 
            }

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
    // $ANTLR end "rule__ConfigModel__ConfigElementsAssignment_4"


    // $ANTLR start "rule__SubSystemConfig__SubSystemAssignment_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5859:1: rule__SubSystemConfig__SubSystemAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemConfig__SubSystemAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5863:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5864:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5864:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5865:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemClassCrossReference_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5866:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5867:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemClassIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubSystemConfig__SubSystemAssignment_112067); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemClassIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemClassCrossReference_1_0()); 
            }

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
    // $ANTLR end "rule__SubSystemConfig__SubSystemAssignment_1"


    // $ANTLR start "rule__SubSystemConfig__DynConfigAssignment_3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5878:1: rule__SubSystemConfig__DynConfigAssignment_3 : ( ruleDynamicConfig ) ;
    public final void rule__SubSystemConfig__DynConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5882:1: ( ( ruleDynamicConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5883:1: ( ruleDynamicConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5883:1: ( ruleDynamicConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5884:1: ruleDynamicConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getDynConfigDynamicConfigParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleDynamicConfig_in_rule__SubSystemConfig__DynConfigAssignment_312102);
            ruleDynamicConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getDynConfigDynamicConfigParserRuleCall_3_0()); 
            }

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
    // $ANTLR end "rule__SubSystemConfig__DynConfigAssignment_3"


    // $ANTLR start "rule__DynamicConfig__FilePathAssignment_2_0_0_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5893:1: rule__DynamicConfig__FilePathAssignment_2_0_0_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__FilePathAssignment_2_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5897:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5898:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5898:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5899:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getFilePathSTRINGTerminalRuleCall_2_0_0_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DynamicConfig__FilePathAssignment_2_0_0_112133); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getFilePathSTRINGTerminalRuleCall_2_0_0_1_0()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__FilePathAssignment_2_0_0_1"


    // $ANTLR start "rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5908:1: rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5912:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5913:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5913:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5914:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserCode1STRINGTerminalRuleCall_2_0_1_0_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DynamicConfig__UserCode1Assignment_2_0_1_0_112164); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getUserCode1STRINGTerminalRuleCall_2_0_1_0_1_0()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1"


    // $ANTLR start "rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5923:1: rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5927:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5928:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5928:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5929:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserCode2STRINGTerminalRuleCall_2_0_1_1_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DynamicConfig__UserCode2Assignment_2_0_1_1_112195); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getUserCode2STRINGTerminalRuleCall_2_0_1_1_1_0()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1"


    // $ANTLR start "rule__DynamicConfig__PollingAssignment_2_1_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5938:1: rule__DynamicConfig__PollingAssignment_2_1_1 : ( RULE_INT ) ;
    public final void rule__DynamicConfig__PollingAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5942:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5943:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5943:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5944:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getPollingINTTerminalRuleCall_2_1_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DynamicConfig__PollingAssignment_2_1_112226); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getPollingINTTerminalRuleCall_2_1_1_0()); 
            }

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
    // $ANTLR end "rule__DynamicConfig__PollingAssignment_2_1_1"


    // $ANTLR start "rule__ActorClassConfig__ActorAssignment_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5953:1: rule__ActorClassConfig__ActorAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ActorClassConfig__ActorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5957:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5958:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5958:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5959:1: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorActorClassCrossReference_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5960:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5961:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorActorClassFQNParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_ruleFQN_in_rule__ActorClassConfig__ActorAssignment_112261);
            ruleFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorClassConfigAccess().getActorActorClassFQNParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorClassConfigAccess().getActorActorClassCrossReference_1_0()); 
            }

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
    // $ANTLR end "rule__ActorClassConfig__ActorAssignment_1"


    // $ANTLR start "rule__ActorClassConfig__AttributesAssignment_3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5972:1: rule__ActorClassConfig__AttributesAssignment_3 : ( ruleAttrClassConfig ) ;
    public final void rule__ActorClassConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5976:1: ( ( ruleAttrClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5977:1: ( ruleAttrClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5977:1: ( ruleAttrClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5978:1: ruleAttrClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleAttrClassConfig_in_rule__ActorClassConfig__AttributesAssignment_312296);
            ruleAttrClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            }

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
    // $ANTLR end "rule__ActorClassConfig__AttributesAssignment_3"


    // $ANTLR start "rule__ActorInstanceConfig__RootAssignment_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5987:1: rule__ActorInstanceConfig__RootAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ActorInstanceConfig__RootAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5991:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5992:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5992:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5993:1: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRootLogicalSystemCrossReference_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5994:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5995:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRootLogicalSystemFQNParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_ruleFQN_in_rule__ActorInstanceConfig__RootAssignment_112331);
            ruleFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getRootLogicalSystemFQNParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getRootLogicalSystemCrossReference_1_0()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__RootAssignment_1"


    // $ANTLR start "rule__ActorInstanceConfig__SubSystemAssignment_3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6006:1: rule__ActorInstanceConfig__SubSystemAssignment_3 : ( ( ruleFQN ) ) ;
    public final void rule__ActorInstanceConfig__SubSystemAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6010:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6011:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6011:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6012:1: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getSubSystemSubSystemRefCrossReference_3_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6013:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6014:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getSubSystemSubSystemRefFQNParserRuleCall_3_0_1()); 
            }
            pushFollow(FOLLOW_ruleFQN_in_rule__ActorInstanceConfig__SubSystemAssignment_312370);
            ruleFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getSubSystemSubSystemRefFQNParserRuleCall_3_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getSubSystemSubSystemRefCrossReference_3_0()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__SubSystemAssignment_3"


    // $ANTLR start "rule__ActorInstanceConfig__PathAssignment_5"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6025:1: rule__ActorInstanceConfig__PathAssignment_5 : ( ruleRefPath ) ;
    public final void rule__ActorInstanceConfig__PathAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6029:1: ( ( ruleRefPath ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6030:1: ( ruleRefPath )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6030:1: ( ruleRefPath )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6031:1: ruleRefPath
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getPathRefPathParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_ruleRefPath_in_rule__ActorInstanceConfig__PathAssignment_512405);
            ruleRefPath();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getPathRefPathParserRuleCall_5_0()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__PathAssignment_5"


    // $ANTLR start "rule__ActorInstanceConfig__AttributesAssignment_7_0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6040:1: rule__ActorInstanceConfig__AttributesAssignment_7_0 : ( ruleAttrInstanceConfig ) ;
    public final void rule__ActorInstanceConfig__AttributesAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6044:1: ( ( ruleAttrInstanceConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6045:1: ( ruleAttrInstanceConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6045:1: ( ruleAttrInstanceConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6046:1: ruleAttrInstanceConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_7_0_0()); 
            }
            pushFollow(FOLLOW_ruleAttrInstanceConfig_in_rule__ActorInstanceConfig__AttributesAssignment_7_012436);
            ruleAttrInstanceConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_7_0_0()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__AttributesAssignment_7_0"


    // $ANTLR start "rule__ActorInstanceConfig__PortsAssignment_7_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6055:1: rule__ActorInstanceConfig__PortsAssignment_7_1 : ( rulePortInstanceConfig ) ;
    public final void rule__ActorInstanceConfig__PortsAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6059:1: ( ( rulePortInstanceConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6060:1: ( rulePortInstanceConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6060:1: ( rulePortInstanceConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6061:1: rulePortInstanceConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getPortsPortInstanceConfigParserRuleCall_7_1_0()); 
            }
            pushFollow(FOLLOW_rulePortInstanceConfig_in_rule__ActorInstanceConfig__PortsAssignment_7_112467);
            rulePortInstanceConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getPortsPortInstanceConfigParserRuleCall_7_1_0()); 
            }

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
    // $ANTLR end "rule__ActorInstanceConfig__PortsAssignment_7_1"


    // $ANTLR start "rule__ProtocolClassConfig__ProtocolAssignment_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6070:1: rule__ProtocolClassConfig__ProtocolAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ProtocolClassConfig__ProtocolAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6074:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6075:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6075:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6076:1: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassCrossReference_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6077:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6078:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassFQNParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_ruleFQN_in_rule__ProtocolClassConfig__ProtocolAssignment_112502);
            ruleFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassFQNParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassCrossReference_1_0()); 
            }

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
    // $ANTLR end "rule__ProtocolClassConfig__ProtocolAssignment_1"


    // $ANTLR start "rule__ProtocolClassConfig__RegularAssignment_3_0_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6089:1: rule__ProtocolClassConfig__RegularAssignment_3_0_1 : ( rulePortClassConfig ) ;
    public final void rule__ProtocolClassConfig__RegularAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6093:1: ( ( rulePortClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6094:1: ( rulePortClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6094:1: ( rulePortClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6095:1: rulePortClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getRegularPortClassConfigParserRuleCall_3_0_1_0()); 
            }
            pushFollow(FOLLOW_rulePortClassConfig_in_rule__ProtocolClassConfig__RegularAssignment_3_0_112537);
            rulePortClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getRegularPortClassConfigParserRuleCall_3_0_1_0()); 
            }

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
    // $ANTLR end "rule__ProtocolClassConfig__RegularAssignment_3_0_1"


    // $ANTLR start "rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6104:1: rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 : ( rulePortClassConfig ) ;
    public final void rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6108:1: ( ( rulePortClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6109:1: ( rulePortClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6109:1: ( rulePortClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6110:1: rulePortClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getConjugatedPortClassConfigParserRuleCall_3_1_1_0()); 
            }
            pushFollow(FOLLOW_rulePortClassConfig_in_rule__ProtocolClassConfig__ConjugatedAssignment_3_1_112568);
            rulePortClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getConjugatedPortClassConfigParserRuleCall_3_1_1_0()); 
            }

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
    // $ANTLR end "rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1"


    // $ANTLR start "rule__PortClassConfig__AttributesAssignment_3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6119:1: rule__PortClassConfig__AttributesAssignment_3 : ( ruleAttrClassConfig ) ;
    public final void rule__PortClassConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6123:1: ( ( ruleAttrClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6124:1: ( ruleAttrClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6124:1: ( ruleAttrClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6125:1: ruleAttrClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleAttrClassConfig_in_rule__PortClassConfig__AttributesAssignment_312599);
            ruleAttrClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            }

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
    // $ANTLR end "rule__PortClassConfig__AttributesAssignment_3"


    // $ANTLR start "rule__PortInstanceConfig__ItemAssignment_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6134:1: rule__PortInstanceConfig__ItemAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PortInstanceConfig__ItemAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6138:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6139:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6139:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6140:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemCrossReference_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6141:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6142:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PortInstanceConfig__ItemAssignment_112634); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemCrossReference_1_0()); 
            }

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
    // $ANTLR end "rule__PortInstanceConfig__ItemAssignment_1"


    // $ANTLR start "rule__PortInstanceConfig__AttributesAssignment_3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6153:1: rule__PortInstanceConfig__AttributesAssignment_3 : ( ruleAttrInstanceConfig ) ;
    public final void rule__PortInstanceConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6157:1: ( ( ruleAttrInstanceConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6158:1: ( ruleAttrInstanceConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6158:1: ( ruleAttrInstanceConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6159:1: ruleAttrInstanceConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleAttrInstanceConfig_in_rule__PortInstanceConfig__AttributesAssignment_312669);
            ruleAttrInstanceConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_0()); 
            }

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
    // $ANTLR end "rule__PortInstanceConfig__AttributesAssignment_3"


    // $ANTLR start "rule__AttrClassConfig__AttributeAssignment_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6168:1: rule__AttrClassConfig__AttributeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AttrClassConfig__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6172:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6173:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6173:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6174:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6175:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6176:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AttrClassConfig__AttributeAssignment_112704); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__AttributeAssignment_1"


    // $ANTLR start "rule__AttrClassConfig__ValueAssignment_2_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6187:1: rule__AttrClassConfig__ValueAssignment_2_1 : ( ruleLiteralArray ) ;
    public final void rule__AttrClassConfig__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6191:1: ( ( ruleLiteralArray ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6192:1: ( ruleLiteralArray )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6192:1: ( ruleLiteralArray )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6193:1: ruleLiteralArray
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleLiteralArray_in_rule__AttrClassConfig__ValueAssignment_2_112739);
            ruleLiteralArray();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__ValueAssignment_2_1"


    // $ANTLR start "rule__AttrClassConfig__MinAssignment_3_1_0_2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6202:1: rule__AttrClassConfig__MinAssignment_3_1_0_2 : ( ruleNumberLiteral ) ;
    public final void rule__AttrClassConfig__MinAssignment_3_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6206:1: ( ( ruleNumberLiteral ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6207:1: ( ruleNumberLiteral )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6207:1: ( ruleNumberLiteral )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6208:1: ruleNumberLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMinNumberLiteralParserRuleCall_3_1_0_2_0()); 
            }
            pushFollow(FOLLOW_ruleNumberLiteral_in_rule__AttrClassConfig__MinAssignment_3_1_0_212770);
            ruleNumberLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getMinNumberLiteralParserRuleCall_3_1_0_2_0()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__MinAssignment_3_1_0_2"


    // $ANTLR start "rule__AttrClassConfig__MaxAssignment_3_1_1_2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6217:1: rule__AttrClassConfig__MaxAssignment_3_1_1_2 : ( ruleNumberLiteral ) ;
    public final void rule__AttrClassConfig__MaxAssignment_3_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6221:1: ( ( ruleNumberLiteral ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6222:1: ( ruleNumberLiteral )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6222:1: ( ruleNumberLiteral )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6223:1: ruleNumberLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMaxNumberLiteralParserRuleCall_3_1_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleNumberLiteral_in_rule__AttrClassConfig__MaxAssignment_3_1_1_212801);
            ruleNumberLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getMaxNumberLiteralParserRuleCall_3_1_1_2_0()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__MaxAssignment_3_1_1_2"


    // $ANTLR start "rule__AttrClassConfig__AttributesAssignment_3_1_2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6232:1: rule__AttrClassConfig__AttributesAssignment_3_1_2 : ( ruleAttrClassConfig ) ;
    public final void rule__AttrClassConfig__AttributesAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6236:1: ( ( ruleAttrClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6237:1: ( ruleAttrClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6237:1: ( ruleAttrClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6238:1: ruleAttrClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleAttrClassConfig_in_rule__AttrClassConfig__AttributesAssignment_3_1_212832);
            ruleAttrClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_1_2_0()); 
            }

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
    // $ANTLR end "rule__AttrClassConfig__AttributesAssignment_3_1_2"


    // $ANTLR start "rule__AttrInstanceConfig__AttributeAssignment_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6247:1: rule__AttrInstanceConfig__AttributeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AttrInstanceConfig__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6251:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6252:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6252:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6253:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6254:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6255:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AttrInstanceConfig__AttributeAssignment_112867); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__AttributeAssignment_1"


    // $ANTLR start "rule__AttrInstanceConfig__ValueAssignment_2_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6266:1: rule__AttrInstanceConfig__ValueAssignment_2_1 : ( ruleLiteralArray ) ;
    public final void rule__AttrInstanceConfig__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6270:1: ( ( ruleLiteralArray ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6271:1: ( ruleLiteralArray )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6271:1: ( ruleLiteralArray )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6272:1: ruleLiteralArray
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleLiteralArray_in_rule__AttrInstanceConfig__ValueAssignment_2_112902);
            ruleLiteralArray();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__ValueAssignment_2_1"


    // $ANTLR start "rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6281:1: rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 : ( ( 'dynamic configuration' ) ) ;
    public final void rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6285:1: ( ( ( 'dynamic configuration' ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6286:1: ( ( 'dynamic configuration' ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6286:1: ( ( 'dynamic configuration' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6287:1: ( 'dynamic configuration' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6288:1: ( 'dynamic configuration' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6289:1: 'dynamic configuration'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_012938); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0_0()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0"


    // $ANTLR start "rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6304:1: rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 : ( ( 'read' ) ) ;
    public final void rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6308:1: ( ( ( 'read' ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6309:1: ( ( 'read' ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6309:1: ( ( 'read' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6310:1: ( 'read' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadKeyword_3_1_0_1_0_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6311:1: ( 'read' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6312:1: 'read'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadKeyword_3_1_0_1_0_0()); 
            }
            match(input,44,FOLLOW_44_in_rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_012982); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadKeyword_3_1_0_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadKeyword_3_1_0_1_0_0()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0"


    // $ANTLR start "rule__AttrInstanceConfig__AttributesAssignment_3_1_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6327:1: rule__AttrInstanceConfig__AttributesAssignment_3_1_1 : ( ruleAttrInstanceConfig ) ;
    public final void rule__AttrInstanceConfig__AttributesAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6331:1: ( ( ruleAttrInstanceConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6332:1: ( ruleAttrInstanceConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6332:1: ( ruleAttrInstanceConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6333:1: ruleAttrInstanceConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleAttrInstanceConfig_in_rule__AttrInstanceConfig__AttributesAssignment_3_1_113021);
            ruleAttrInstanceConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_1_1_0()); 
            }

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
    // $ANTLR end "rule__AttrInstanceConfig__AttributesAssignment_3_1_1"


    // $ANTLR start "rule__RefPath__RefsAssignment_0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6342:1: rule__RefPath__RefsAssignment_0 : ( RULE_ID ) ;
    public final void rule__RefPath__RefsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6346:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6347:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6347:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6348:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_013052); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_0_0()); 
            }

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
    // $ANTLR end "rule__RefPath__RefsAssignment_0"


    // $ANTLR start "rule__RefPath__RefsAssignment_1_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6357:1: rule__RefPath__RefsAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__RefPath__RefsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6361:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6362:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6362:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6363:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_1_113083); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_1_1_0()); 
            }

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
    // $ANTLR end "rule__RefPath__RefsAssignment_1_1"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1_0_0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6372:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6376:1: ( ( ruleImportedFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6377:1: ( ruleImportedFQN )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6377:1: ( ruleImportedFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6378:1: ruleImportedFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
            }
            pushFollow(FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_013114);
            ruleImportedFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
            }

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
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1_0_0"


    // $ANTLR start "rule__Import__ImportURIAssignment_2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6387:1: rule__Import__ImportURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6391:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6392:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6392:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6393:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_213145); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            }

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
    // $ANTLR end "rule__Import__ImportURIAssignment_2"


    // $ANTLR start "rule__LiteralArray__LiteralsAssignment_0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6402:1: rule__LiteralArray__LiteralsAssignment_0 : ( ruleLiteral ) ;
    public final void rule__LiteralArray__LiteralsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6406:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6407:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6407:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6408:1: ruleLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_013176);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_0_0()); 
            }

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
    // $ANTLR end "rule__LiteralArray__LiteralsAssignment_0"


    // $ANTLR start "rule__LiteralArray__LiteralsAssignment_1_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6417:1: rule__LiteralArray__LiteralsAssignment_1_1 : ( ruleLiteral ) ;
    public final void rule__LiteralArray__LiteralsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6421:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6422:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6422:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6423:1: ruleLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_1_113207);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_1_1_0()); 
            }

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
    // $ANTLR end "rule__LiteralArray__LiteralsAssignment_1_1"


    // $ANTLR start "rule__BooleanLiteral__IsTrueAssignment_1_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6432:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6436:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6437:1: ( ( 'true' ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6437:1: ( ( 'true' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6438:1: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6439:1: ( 'true' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6440:1: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            }
            match(input,45,FOLLOW_45_in_rule__BooleanLiteral__IsTrueAssignment_1_113243); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6455:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6459:1: ( ( ruleReal ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6460:1: ( ruleReal )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6460:1: ( ruleReal )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6461:1: ruleReal
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_113282);
            ruleReal();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6470:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6474:1: ( ( ruleInteger ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6475:1: ( ruleInteger )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6475:1: ( ruleInteger )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6476:1: ruleInteger
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_113313);
            ruleInteger();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            }

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6485:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6489:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6490:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6490:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6491:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_113344); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            }

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

    // $ANTLR start synpred1_InternalConfig
    public final void synpred1_InternalConfig_fragment() throws RecognitionException {   
        // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5652:8: ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )
        // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5652:9: rule__ActorInstanceConfig__AttributesAssignment_7_0
        {
        pushFollow(FOLLOW_rule__ActorInstanceConfig__AttributesAssignment_7_0_in_synpred1_InternalConfig11405);
        rule__ActorInstanceConfig__AttributesAssignment_7_0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalConfig

    // $ANTLR start synpred2_InternalConfig
    public final void synpred2_InternalConfig_fragment() throws RecognitionException {   
        // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5674:8: ( rule__ActorInstanceConfig__PortsAssignment_7_1 )
        // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5674:9: rule__ActorInstanceConfig__PortsAssignment_7_1
        {
        pushFollow(FOLLOW_rule__ActorInstanceConfig__PortsAssignment_7_1_in_synpred2_InternalConfig11548);
        rule__ActorInstanceConfig__PortsAssignment_7_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalConfig

    // Delegated rules

    public final boolean synpred1_InternalConfig() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalConfig_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalConfig() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalConfig_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\12\uffff";
    static final String DFA10_eofS =
        "\5\uffff\1\6\1\uffff\1\11\2\uffff";
    static final String DFA10_minS =
        "\3\6\1\52\1\uffff\1\6\1\uffff\1\7\2\uffff";
    static final String DFA10_maxS =
        "\4\52\1\uffff\1\53\1\uffff\1\53\2\uffff";
    static final String DFA10_acceptS =
        "\4\uffff\1\2\1\uffff\1\3\1\uffff\1\4\1\1";
    static final String DFA10_specialS =
        "\12\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\3\11\uffff\1\1\1\2\30\uffff\1\4",
            "\1\3\43\uffff\1\4",
            "\1\3\43\uffff\1\4",
            "\1\5",
            "",
            "\1\7\14\uffff\2\6\15\uffff\2\6\2\uffff\1\6\4\uffff\1\6",
            "",
            "\1\10\13\uffff\2\11\15\uffff\2\11\2\uffff\1\11\4\uffff\1\11",
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
            return "1177:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleConfigModel_in_entryRuleConfigModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfigModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__0_in_ruleConfigModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigElement_in_entryRuleConfigElement121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfigElement128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigElement__Alternatives_in_ruleConfigElement154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemConfig_in_entryRuleSubSystemConfig181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemConfig188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__0_in_ruleSubSystemConfig214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDynamicConfig_in_entryRuleDynamicConfig241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDynamicConfig248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__0_in_ruleDynamicConfig274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClassConfig_in_entryRuleActorClassConfig301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorClassConfig308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__0_in_ruleActorClassConfig334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstanceConfig_in_entryRuleActorInstanceConfig361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorInstanceConfig368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__0_in_ruleActorInstanceConfig394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolClassConfig_in_entryRuleProtocolClassConfig421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProtocolClassConfig428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__0_in_ruleProtocolClassConfig454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClassConfig_in_entryRulePortClassConfig481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortClassConfig488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__0_in_rulePortClassConfig514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortInstanceConfig_in_entryRulePortInstanceConfig541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortInstanceConfig548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__0_in_rulePortInstanceConfig574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_entryRuleAttrClassConfig603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttrClassConfig610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__0_in_ruleAttrClassConfig636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_entryRuleAttrInstanceConfig663 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttrInstanceConfig670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__0_in_ruleAttrInstanceConfig696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefPath_in_entryRuleRefPath723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefPath730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group__0_in_ruleRefPath756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralArray_in_entryRuleLiteralArray963 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralArray970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__0_in_ruleLiteralArray996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral1083 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral1236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral1263 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1323 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger1383 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integer__Alternatives_in_ruleInteger1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger1448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal1517 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal1554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal1580 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal1587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Real__Alternatives_in_ruleReal1613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal1645 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemConfig_in_rule__ConfigElement__Alternatives1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClassConfig_in_rule__ConfigElement__Alternatives1942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstanceConfig_in_rule__ConfigElement__Alternatives1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolClassConfig_in_rule__ConfigElement__Alternatives1976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_0__0_in_rule__DynamicConfig__Alternatives_2_02008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1__0_in_rule__DynamicConfig__Alternatives_2_02026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0_in_rule__AttrInstanceConfig__Alternatives_3_1_0_12060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__AttrInstanceConfig__Alternatives_3_1_0_12079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_12113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Import__Alternatives_12132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives2166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives2183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives2200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__BooleanLiteral__Alternatives_12233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_12252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives2351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__SignedInteger__Alternatives_02384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__SignedInteger__Alternatives_02404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_rule__Real__Alternatives2438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives2455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives2472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives2489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Decimal__Alternatives_02522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Decimal__Alternatives_02542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DotDecimal__Alternatives_02577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DotDecimal__Alternatives_02597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalDot__Alternatives_02632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DecimalDot__Alternatives_02652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalExp__Alternatives_02687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DecimalExp__Alternatives_02707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__0__Impl_in_rule__ConfigModel__Group__02739 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__1_in_rule__ConfigModel__Group__02742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ConfigModel__Group__0__Impl2770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__1__Impl_in_rule__ConfigModel__Group__12801 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__2_in_rule__ConfigModel__Group__12804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__NameAssignment_1_in_rule__ConfigModel__Group__1__Impl2831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__2__Impl_in_rule__ConfigModel__Group__22861 = new BitSet(new long[]{0x0000008058300000L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__3_in_rule__ConfigModel__Group__22864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ConfigModel__Group__2__Impl2892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__3__Impl_in_rule__ConfigModel__Group__32923 = new BitSet(new long[]{0x0000008058300000L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__4_in_rule__ConfigModel__Group__32926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__ImportsAssignment_3_in_rule__ConfigModel__Group__3__Impl2953 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__4__Impl_in_rule__ConfigModel__Group__42984 = new BitSet(new long[]{0x0000008058300000L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__5_in_rule__ConfigModel__Group__42987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__ConfigElementsAssignment_4_in_rule__ConfigModel__Group__4__Impl3014 = new BitSet(new long[]{0x0000000058200002L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__5__Impl_in_rule__ConfigModel__Group__53045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ConfigModel__Group__5__Impl3073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__0__Impl_in_rule__SubSystemConfig__Group__03116 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__1_in_rule__SubSystemConfig__Group__03119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__SubSystemConfig__Group__0__Impl3147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__1__Impl_in_rule__SubSystemConfig__Group__13178 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__2_in_rule__SubSystemConfig__Group__13181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__SubSystemAssignment_1_in_rule__SubSystemConfig__Group__1__Impl3208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__2__Impl_in_rule__SubSystemConfig__Group__23238 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__3_in_rule__SubSystemConfig__Group__23241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__SubSystemConfig__Group__2__Impl3269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__3__Impl_in_rule__SubSystemConfig__Group__33300 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__4_in_rule__SubSystemConfig__Group__33303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__DynConfigAssignment_3_in_rule__SubSystemConfig__Group__3__Impl3330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__4__Impl_in_rule__SubSystemConfig__Group__43360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__SubSystemConfig__Group__4__Impl3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__0__Impl_in_rule__DynamicConfig__Group__03429 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__1_in_rule__DynamicConfig__Group__03432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__DynamicConfig__Group__0__Impl3460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__1__Impl_in_rule__DynamicConfig__Group__13491 = new BitSet(new long[]{0x0000000005800000L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__2_in_rule__DynamicConfig__Group__13494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__DynamicConfig__Group__1__Impl3522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__2__Impl_in_rule__DynamicConfig__Group__23553 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__3_in_rule__DynamicConfig__Group__23556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2_in_rule__DynamicConfig__Group__2__Impl3583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__3__Impl_in_rule__DynamicConfig__Group__33613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__DynamicConfig__Group__3__Impl3641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_0__0__Impl_in_rule__DynamicConfig__Group_2_0_0__03680 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_0__1_in_rule__DynamicConfig__Group_2_0_0__03683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__DynamicConfig__Group_2_0_0__0__Impl3711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_0__1__Impl_in_rule__DynamicConfig__Group_2_0_0__13742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__FilePathAssignment_2_0_0_1_in_rule__DynamicConfig__Group_2_0_0__1__Impl3769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1__0__Impl_in_rule__DynamicConfig__Group_2_0_1__03803 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1__1_in_rule__DynamicConfig__Group_2_0_1__03806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_0__0_in_rule__DynamicConfig__Group_2_0_1__0__Impl3833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1__1__Impl_in_rule__DynamicConfig__Group_2_0_1__13863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_1__0_in_rule__DynamicConfig__Group_2_0_1__1__Impl3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_0__0__Impl_in_rule__DynamicConfig__Group_2_0_1_0__03924 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_0__1_in_rule__DynamicConfig__Group_2_0_1_0__03927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__DynamicConfig__Group_2_0_1_0__0__Impl3955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_0__1__Impl_in_rule__DynamicConfig__Group_2_0_1_0__13986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1_in_rule__DynamicConfig__Group_2_0_1_0__1__Impl4013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_1__0__Impl_in_rule__DynamicConfig__Group_2_0_1_1__04047 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_1__1_in_rule__DynamicConfig__Group_2_0_1_1__04050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__DynamicConfig__Group_2_0_1_1__0__Impl4078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_1__1__Impl_in_rule__DynamicConfig__Group_2_0_1_1__14109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1_in_rule__DynamicConfig__Group_2_0_1_1__1__Impl4136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_1__0__Impl_in_rule__DynamicConfig__Group_2_1__04170 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_1__1_in_rule__DynamicConfig__Group_2_1__04173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__DynamicConfig__Group_2_1__0__Impl4201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_1__1__Impl_in_rule__DynamicConfig__Group_2_1__14232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__PollingAssignment_2_1_1_in_rule__DynamicConfig__Group_2_1__1__Impl4259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__0__Impl_in_rule__ActorClassConfig__Group__04293 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__1_in_rule__ActorClassConfig__Group__04296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ActorClassConfig__Group__0__Impl4324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__1__Impl_in_rule__ActorClassConfig__Group__14355 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__2_in_rule__ActorClassConfig__Group__14358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__ActorAssignment_1_in_rule__ActorClassConfig__Group__1__Impl4385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__2__Impl_in_rule__ActorClassConfig__Group__24415 = new BitSet(new long[]{0x0000000800100000L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__3_in_rule__ActorClassConfig__Group__24418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ActorClassConfig__Group__2__Impl4446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__3__Impl_in_rule__ActorClassConfig__Group__34477 = new BitSet(new long[]{0x0000000800100000L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__4_in_rule__ActorClassConfig__Group__34480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__AttributesAssignment_3_in_rule__ActorClassConfig__Group__3__Impl4507 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__4__Impl_in_rule__ActorClassConfig__Group__44538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ActorClassConfig__Group__4__Impl4566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__0__Impl_in_rule__ActorInstanceConfig__Group__04607 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__1_in_rule__ActorInstanceConfig__Group__04610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ActorInstanceConfig__Group__0__Impl4638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__1__Impl_in_rule__ActorInstanceConfig__Group__14669 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__2_in_rule__ActorInstanceConfig__Group__14672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__RootAssignment_1_in_rule__ActorInstanceConfig__Group__1__Impl4699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__2__Impl_in_rule__ActorInstanceConfig__Group__24729 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__3_in_rule__ActorInstanceConfig__Group__24732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ActorInstanceConfig__Group__2__Impl4760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__3__Impl_in_rule__ActorInstanceConfig__Group__34791 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__4_in_rule__ActorInstanceConfig__Group__34794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__SubSystemAssignment_3_in_rule__ActorInstanceConfig__Group__3__Impl4821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__4__Impl_in_rule__ActorInstanceConfig__Group__44851 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__5_in_rule__ActorInstanceConfig__Group__44854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ActorInstanceConfig__Group__4__Impl4882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__5__Impl_in_rule__ActorInstanceConfig__Group__54913 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__6_in_rule__ActorInstanceConfig__Group__54916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__PathAssignment_5_in_rule__ActorInstanceConfig__Group__5__Impl4943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__6__Impl_in_rule__ActorInstanceConfig__Group__64973 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__7_in_rule__ActorInstanceConfig__Group__64976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ActorInstanceConfig__Group__6__Impl5004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__7__Impl_in_rule__ActorInstanceConfig__Group__75035 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__8_in_rule__ActorInstanceConfig__Group__75038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup_7_in_rule__ActorInstanceConfig__Group__7__Impl5065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group__8__Impl_in_rule__ActorInstanceConfig__Group__85095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ActorInstanceConfig__Group__8__Impl5123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__0__Impl_in_rule__ProtocolClassConfig__Group__05172 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__1_in_rule__ProtocolClassConfig__Group__05175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ProtocolClassConfig__Group__0__Impl5203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__1__Impl_in_rule__ProtocolClassConfig__Group__15234 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__2_in_rule__ProtocolClassConfig__Group__15237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__ProtocolAssignment_1_in_rule__ProtocolClassConfig__Group__1__Impl5264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__2__Impl_in_rule__ProtocolClassConfig__Group__25294 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__3_in_rule__ProtocolClassConfig__Group__25297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ProtocolClassConfig__Group__2__Impl5325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__3__Impl_in_rule__ProtocolClassConfig__Group__35356 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__4_in_rule__ProtocolClassConfig__Group__35359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3_in_rule__ProtocolClassConfig__Group__3__Impl5386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__4__Impl_in_rule__ProtocolClassConfig__Group__45416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ProtocolClassConfig__Group__4__Impl5444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_0__0__Impl_in_rule__ProtocolClassConfig__Group_3_0__05485 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_0__1_in_rule__ProtocolClassConfig__Group_3_0__05488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ProtocolClassConfig__Group_3_0__0__Impl5516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_0__1__Impl_in_rule__ProtocolClassConfig__Group_3_0__15547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__RegularAssignment_3_0_1_in_rule__ProtocolClassConfig__Group_3_0__1__Impl5574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_1__0__Impl_in_rule__ProtocolClassConfig__Group_3_1__05608 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_1__1_in_rule__ProtocolClassConfig__Group_3_1__05611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ProtocolClassConfig__Group_3_1__0__Impl5639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_1__1__Impl_in_rule__ProtocolClassConfig__Group_3_1__15670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1_in_rule__ProtocolClassConfig__Group_3_1__1__Impl5697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__0__Impl_in_rule__PortClassConfig__Group__05731 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__1_in_rule__PortClassConfig__Group__05734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__1__Impl_in_rule__PortClassConfig__Group__15792 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__2_in_rule__PortClassConfig__Group__15795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__PortClassConfig__Group__1__Impl5823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__2__Impl_in_rule__PortClassConfig__Group__25854 = new BitSet(new long[]{0x0000000800100000L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__3_in_rule__PortClassConfig__Group__25857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PortClassConfig__Group__2__Impl5885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__3__Impl_in_rule__PortClassConfig__Group__35916 = new BitSet(new long[]{0x0000000800100000L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__4_in_rule__PortClassConfig__Group__35919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__AttributesAssignment_3_in_rule__PortClassConfig__Group__3__Impl5946 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__4__Impl_in_rule__PortClassConfig__Group__45977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__PortClassConfig__Group__4__Impl6005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__0__Impl_in_rule__PortInstanceConfig__Group__06046 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__1_in_rule__PortInstanceConfig__Group__06049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__PortInstanceConfig__Group__0__Impl6077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__1__Impl_in_rule__PortInstanceConfig__Group__16108 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__2_in_rule__PortInstanceConfig__Group__16111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__ItemAssignment_1_in_rule__PortInstanceConfig__Group__1__Impl6138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__2__Impl_in_rule__PortInstanceConfig__Group__26168 = new BitSet(new long[]{0x0000000800100000L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__3_in_rule__PortInstanceConfig__Group__26171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PortInstanceConfig__Group__2__Impl6199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__3__Impl_in_rule__PortInstanceConfig__Group__36230 = new BitSet(new long[]{0x0000000800100000L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__4_in_rule__PortInstanceConfig__Group__36233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__AttributesAssignment_3_in_rule__PortInstanceConfig__Group__3__Impl6260 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__4__Impl_in_rule__PortInstanceConfig__Group__46291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__PortInstanceConfig__Group__4__Impl6319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__0__Impl_in_rule__AttrClassConfig__Group__06360 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__1_in_rule__AttrClassConfig__Group__06363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AttrClassConfig__Group__0__Impl6391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__1__Impl_in_rule__AttrClassConfig__Group__16422 = new BitSet(new long[]{0x0000001000080000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__2_in_rule__AttrClassConfig__Group__16425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__AttributeAssignment_1_in_rule__AttrClassConfig__Group__1__Impl6452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__2__Impl_in_rule__AttrClassConfig__Group__26482 = new BitSet(new long[]{0x0000001000080000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__3_in_rule__AttrClassConfig__Group__26485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_2__0_in_rule__AttrClassConfig__Group__2__Impl6512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__3__Impl_in_rule__AttrClassConfig__Group__36543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__0_in_rule__AttrClassConfig__Group__3__Impl6570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_2__0__Impl_in_rule__AttrClassConfig__Group_2__06609 = new BitSet(new long[]{0x0000240000038150L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_2__1_in_rule__AttrClassConfig__Group_2__06612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__AttrClassConfig__Group_2__0__Impl6640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_2__1__Impl_in_rule__AttrClassConfig__Group_2__16671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__ValueAssignment_2_1_in_rule__AttrClassConfig__Group_2__1__Impl6698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__0__Impl_in_rule__AttrClassConfig__Group_3__06732 = new BitSet(new long[]{0x0000006800000000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__1_in_rule__AttrClassConfig__Group_3__06735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AttrClassConfig__Group_3__0__Impl6763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__1__Impl_in_rule__AttrClassConfig__Group_3__16794 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__2_in_rule__AttrClassConfig__Group_3__16797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1__0_in_rule__AttrClassConfig__Group_3__1__Impl6824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__2__Impl_in_rule__AttrClassConfig__Group_3__26854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__AttrClassConfig__Group_3__2__Impl6882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1__0__Impl_in_rule__AttrClassConfig__Group_3_1__06919 = new BitSet(new long[]{0x0000006800000000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1__1_in_rule__AttrClassConfig__Group_3_1__06922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__0_in_rule__AttrClassConfig__Group_3_1__0__Impl6949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1__1__Impl_in_rule__AttrClassConfig__Group_3_1__16980 = new BitSet(new long[]{0x0000006800000000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1__2_in_rule__AttrClassConfig__Group_3_1__16983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__0_in_rule__AttrClassConfig__Group_3_1__1__Impl7010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1__2__Impl_in_rule__AttrClassConfig__Group_3_1__27041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__AttributesAssignment_3_1_2_in_rule__AttrClassConfig__Group_3_1__2__Impl7068 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__0__Impl_in_rule__AttrClassConfig__Group_3_1_0__07105 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__1_in_rule__AttrClassConfig__Group_3_1_0__07108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__AttrClassConfig__Group_3_1_0__0__Impl7136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__1__Impl_in_rule__AttrClassConfig__Group_3_1_0__17167 = new BitSet(new long[]{0x0000040000030050L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__2_in_rule__AttrClassConfig__Group_3_1_0__17170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__AttrClassConfig__Group_3_1_0__1__Impl7198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__2__Impl_in_rule__AttrClassConfig__Group_3_1_0__27229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__MinAssignment_3_1_0_2_in_rule__AttrClassConfig__Group_3_1_0__2__Impl7256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__0__Impl_in_rule__AttrClassConfig__Group_3_1_1__07292 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__1_in_rule__AttrClassConfig__Group_3_1_1__07295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__AttrClassConfig__Group_3_1_1__0__Impl7323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__1__Impl_in_rule__AttrClassConfig__Group_3_1_1__17354 = new BitSet(new long[]{0x0000040000030050L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__2_in_rule__AttrClassConfig__Group_3_1_1__17357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__AttrClassConfig__Group_3_1_1__1__Impl7385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__2__Impl_in_rule__AttrClassConfig__Group_3_1_1__27416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__MaxAssignment_3_1_1_2_in_rule__AttrClassConfig__Group_3_1_1__2__Impl7443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__0__Impl_in_rule__AttrInstanceConfig__Group__07479 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__1_in_rule__AttrInstanceConfig__Group__07482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AttrInstanceConfig__Group__0__Impl7510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__1__Impl_in_rule__AttrInstanceConfig__Group__17541 = new BitSet(new long[]{0x0000001000080000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__2_in_rule__AttrInstanceConfig__Group__17544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__AttributeAssignment_1_in_rule__AttrInstanceConfig__Group__1__Impl7571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__2__Impl_in_rule__AttrInstanceConfig__Group__27601 = new BitSet(new long[]{0x0000001000080000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__3_in_rule__AttrInstanceConfig__Group__27604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_2__0_in_rule__AttrInstanceConfig__Group__2__Impl7631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__3__Impl_in_rule__AttrInstanceConfig__Group__37662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__0_in_rule__AttrInstanceConfig__Group__3__Impl7689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_2__0__Impl_in_rule__AttrInstanceConfig__Group_2__07728 = new BitSet(new long[]{0x0000240000038150L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_2__1_in_rule__AttrInstanceConfig__Group_2__07731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__AttrInstanceConfig__Group_2__0__Impl7759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_2__1__Impl_in_rule__AttrInstanceConfig__Group_2__17790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__ValueAssignment_2_1_in_rule__AttrInstanceConfig__Group_2__1__Impl7817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__0__Impl_in_rule__AttrInstanceConfig__Group_3__07851 = new BitSet(new long[]{0x0000000800400000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__1_in_rule__AttrInstanceConfig__Group_3__07854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AttrInstanceConfig__Group_3__0__Impl7882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__1__Impl_in_rule__AttrInstanceConfig__Group_3__17913 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__2_in_rule__AttrInstanceConfig__Group_3__17916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1__0_in_rule__AttrInstanceConfig__Group_3__1__Impl7943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__2__Impl_in_rule__AttrInstanceConfig__Group_3__27973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__AttrInstanceConfig__Group_3__2__Impl8001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1__0__Impl_in_rule__AttrInstanceConfig__Group_3_1__08038 = new BitSet(new long[]{0x0000000800400000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1__1_in_rule__AttrInstanceConfig__Group_3_1__08041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__0_in_rule__AttrInstanceConfig__Group_3_1__0__Impl8068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1__1__Impl_in_rule__AttrInstanceConfig__Group_3_1__18099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__AttributesAssignment_3_1_1_in_rule__AttrInstanceConfig__Group_3_1__1__Impl8126 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__0__Impl_in_rule__AttrInstanceConfig__Group_3_1_0__08161 = new BitSet(new long[]{0x0000100000002000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__1_in_rule__AttrInstanceConfig__Group_3_1_0__08164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0_in_rule__AttrInstanceConfig__Group_3_1_0__0__Impl8191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__1__Impl_in_rule__AttrInstanceConfig__Group_3_1_0__18221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Alternatives_3_1_0_1_in_rule__AttrInstanceConfig__Group_3_1_0__1__Impl8248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group__0__Impl_in_rule__RefPath__Group__08282 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__RefPath__Group__1_in_rule__RefPath__Group__08285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__RefsAssignment_0_in_rule__RefPath__Group__0__Impl8312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group__1__Impl_in_rule__RefPath__Group__18342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__0_in_rule__RefPath__Group__1__Impl8369 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__0__Impl_in_rule__RefPath__Group_1__08404 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__1_in_rule__RefPath__Group_1__08407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__RefPath__Group_1__0__Impl8435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__1__Impl_in_rule__RefPath__Group_1__18466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__RefsAssignment_1_1_in_rule__RefPath__Group_1__1__Impl8493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__08527 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__08530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Import__Group__0__Impl8558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__18589 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Import__Group__2_in_rule__Import__Group__18592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl8619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__28649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl8676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__08712 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__08715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl8742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__18772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Import__Group_1_0__1__Impl8800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__08835 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__08838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl8865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__18894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ImportedFQN__Group__1__Impl8923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__08960 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__08963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl8990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__19019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl9046 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__09081 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__09084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__FQN__Group_1__0__Impl9112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__19143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl9170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__0__Impl_in_rule__LiteralArray__Group__09203 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__1_in_rule__LiteralArray__Group__09206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__LiteralsAssignment_0_in_rule__LiteralArray__Group__0__Impl9233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__1__Impl_in_rule__LiteralArray__Group__19263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__0_in_rule__LiteralArray__Group__1__Impl9290 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__0__Impl_in_rule__LiteralArray__Group_1__09325 = new BitSet(new long[]{0x0000240000038150L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__1_in_rule__LiteralArray__Group_1__09328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__LiteralArray__Group_1__0__Impl9356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__1__Impl_in_rule__LiteralArray__Group_1__19387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__LiteralsAssignment_1_1_in_rule__LiteralArray__Group_1__1__Impl9414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__09448 = new BitSet(new long[]{0x0000200000008000L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__09451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__19509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl9536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__09570 = new BitSet(new long[]{0x0000040000030050L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__09573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__19631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl9658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__09692 = new BitSet(new long[]{0x0000000000030050L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__09695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__19753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl9780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__09814 = new BitSet(new long[]{0x0000240000038150L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__09817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__19875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl9902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__09936 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__09939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl9966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__19997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl10024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__010057 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__010060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl10087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__110118 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__110121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl10148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__210177 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__210180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__Decimal__Group__2__Impl10208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__310239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl10266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__010303 = new BitSet(new long[]{0x0000040000030000L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__010306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl10333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__110364 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__110367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__DotDecimal__Group__1__Impl10395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__210426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl10453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__010488 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__010491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl10518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__110549 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__110552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl10579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__210608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__DecimalDot__Group__2__Impl10636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__010673 = new BitSet(new long[]{0x0000040000030050L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__010676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl10703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__110734 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__110737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl10764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__210793 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__210796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__DecimalExp__Group__2__Impl10824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__310855 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__310858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl10885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__410914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl10941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2__0_in_rule__DynamicConfig__UnorderedGroup_210981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Alternatives_2_0_in_rule__DynamicConfig__UnorderedGroup_2__Impl11070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_1__0_in_rule__DynamicConfig__UnorderedGroup_2__Impl11161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2__Impl_in_rule__DynamicConfig__UnorderedGroup_2__011220 = new BitSet(new long[]{0x0000000005800002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2__1_in_rule__DynamicConfig__UnorderedGroup_2__011223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2__Impl_in_rule__DynamicConfig__UnorderedGroup_2__111248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup_7__0_in_rule__ActorInstanceConfig__UnorderedGroup_711276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__AttributesAssignment_7_0_in_rule__ActorInstanceConfig__UnorderedGroup_7__Impl11364 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__AttributesAssignment_7_0_in_rule__ActorInstanceConfig__UnorderedGroup_7__Impl11408 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__PortsAssignment_7_1_in_rule__ActorInstanceConfig__UnorderedGroup_7__Impl11507 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__PortsAssignment_7_1_in_rule__ActorInstanceConfig__UnorderedGroup_7__Impl11551 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup_7__Impl_in_rule__ActorInstanceConfig__UnorderedGroup_7__011617 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup_7__1_in_rule__ActorInstanceConfig__UnorderedGroup_7__011620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup_7__Impl_in_rule__ActorInstanceConfig__UnorderedGroup_7__111645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__0_in_rule__ProtocolClassConfig__UnorderedGroup_311673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_0__0_in_rule__ProtocolClassConfig__UnorderedGroup_3__Impl11760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_1__0_in_rule__ProtocolClassConfig__UnorderedGroup_3__Impl11851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__Impl_in_rule__ProtocolClassConfig__UnorderedGroup_3__011910 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__1_in_rule__ProtocolClassConfig__UnorderedGroup_3__011913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__Impl_in_rule__ProtocolClassConfig__UnorderedGroup_3__111938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ConfigModel__NameAssignment_111970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__ConfigModel__ImportsAssignment_312001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigElement_in_rule__ConfigModel__ConfigElementsAssignment_412032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubSystemConfig__SubSystemAssignment_112067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDynamicConfig_in_rule__SubSystemConfig__DynConfigAssignment_312102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DynamicConfig__FilePathAssignment_2_0_0_112133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DynamicConfig__UserCode1Assignment_2_0_1_0_112164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DynamicConfig__UserCode2Assignment_2_0_1_1_112195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DynamicConfig__PollingAssignment_2_1_112226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ActorClassConfig__ActorAssignment_112261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_rule__ActorClassConfig__AttributesAssignment_312296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ActorInstanceConfig__RootAssignment_112331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ActorInstanceConfig__SubSystemAssignment_312370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefPath_in_rule__ActorInstanceConfig__PathAssignment_512405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_rule__ActorInstanceConfig__AttributesAssignment_7_012436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortInstanceConfig_in_rule__ActorInstanceConfig__PortsAssignment_7_112467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ProtocolClassConfig__ProtocolAssignment_112502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClassConfig_in_rule__ProtocolClassConfig__RegularAssignment_3_0_112537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClassConfig_in_rule__ProtocolClassConfig__ConjugatedAssignment_3_1_112568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_rule__PortClassConfig__AttributesAssignment_312599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PortInstanceConfig__ItemAssignment_112634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_rule__PortInstanceConfig__AttributesAssignment_312669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AttrClassConfig__AttributeAssignment_112704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralArray_in_rule__AttrClassConfig__ValueAssignment_2_112739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__AttrClassConfig__MinAssignment_3_1_0_212770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__AttrClassConfig__MaxAssignment_3_1_1_212801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_rule__AttrClassConfig__AttributesAssignment_3_1_212832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AttrInstanceConfig__AttributeAssignment_112867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralArray_in_rule__AttrInstanceConfig__ValueAssignment_2_112902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_012938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_012982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_rule__AttrInstanceConfig__AttributesAssignment_3_1_113021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_013052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_1_113083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_013114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_213145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_013176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_1_113207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__BooleanLiteral__IsTrueAssignment_1_113243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_113282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_113313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_113344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__AttributesAssignment_7_0_in_synpred1_InternalConfig11405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__PortsAssignment_7_1_in_synpred2_InternalConfig11548 = new BitSet(new long[]{0x0000000000000002L});

}
