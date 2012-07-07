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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_HEX", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'read-write'", "'model'", "'false'", "'+'", "'-'", "'SubSystemConfig'", "'{'", "'}'", "'dynamic configuration'", "'source'", "'file path'", "'polling rate'", "'ActorClassConfig'", "'ActorInstanceConfig'", "'/'", "'ProtocolClassConfig'", "'regular'", "'conjugate'", "'Port'", "'InterfaceItem'", "'Attr'", "'='", "'min'", "'max'", "'import'", "'from'", "'.*'", "'.'", "','", "'read-only'", "'true'"
    };
    public static final int T__42=42;
    public static final int RULE_ID=5;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=7;
    public static final int RULE_HEX=4;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=10;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:209:1: ruleActorInstanceConfig : ( ( rule__ActorInstanceConfig__UnorderedGroup ) ) ;
    public final void ruleActorInstanceConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:213:2: ( ( ( rule__ActorInstanceConfig__UnorderedGroup ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:214:1: ( ( rule__ActorInstanceConfig__UnorderedGroup ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:214:1: ( ( rule__ActorInstanceConfig__UnorderedGroup ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:215:1: ( rule__ActorInstanceConfig__UnorderedGroup )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:216:1: ( rule__ActorInstanceConfig__UnorderedGroup )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:216:2: rule__ActorInstanceConfig__UnorderedGroup
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup_in_ruleActorInstanceConfig394);
            rule__ActorInstanceConfig__UnorderedGroup();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup()); 
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
            case 17:
                {
                alt1=1;
                }
                break;
            case 24:
                {
                alt1=2;
                }
                break;
            case 19:
            case 25:
            case 31:
                {
                alt1=3;
                }
                break;
            case 27:
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


    // $ANTLR start "rule__AttrInstanceConfig__Alternatives_3_1_0_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:985:1: rule__AttrInstanceConfig__Alternatives_3_1_0_1 : ( ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) ) | ( 'read-write' ) );
    public final void rule__AttrInstanceConfig__Alternatives_3_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:989:1: ( ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) ) | ( 'read-write' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==41) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:990:1: ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:990:1: ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:991:1: ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyAssignment_3_1_0_1_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:992:1: ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:992:2: rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0_in_rule__AttrInstanceConfig__Alternatives_3_1_0_12009);
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:996:6: ( 'read-write' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:996:6: ( 'read-write' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:997:1: 'read-write'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttrInstanceConfigAccess().getReadWriteKeyword_3_1_0_1_1()); 
                    }
                    match(input,12,FOLLOW_12_in_rule__AttrInstanceConfig__Alternatives_3_1_0_12028); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttrInstanceConfigAccess().getReadWriteKeyword_3_1_0_1_1()); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1009:1: rule__Import__Alternatives_1 : ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) );
    public final void rule__Import__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1013:1: ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1014:1: ( ( rule__Import__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1014:1: ( ( rule__Import__Group_1_0__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1015:1: ( rule__Import__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getImportAccess().getGroup_1_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1016:1: ( rule__Import__Group_1_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1016:2: rule__Import__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_12062);
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1020:6: ( 'model' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1020:6: ( 'model' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1021:1: 'model'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getImportAccess().getModelKeyword_1_1()); 
                    }
                    match(input,13,FOLLOW_13_in_rule__Import__Alternatives_12081); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1033:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1037:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 14:
            case 42:
                {
                alt4=1;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case 15:
            case 16:
            case 39:
                {
                alt4=2;
                }
                break;
            case RULE_STRING:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1038:1: ( ruleBooleanLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1038:1: ( ruleBooleanLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1039:1: ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives2115);
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1044:6: ( ruleNumberLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1044:6: ( ruleNumberLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1045:1: ruleNumberLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives2132);
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1050:6: ( ruleStringLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1050:6: ( ruleStringLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1051:1: ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives2149);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1061:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1065:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            else if ( (LA5_0==42) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1066:1: ( 'false' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1066:1: ( 'false' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1067:1: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    }
                    match(input,14,FOLLOW_14_in_rule__BooleanLiteral__Alternatives_12182); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1074:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1074:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1075:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1076:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1076:2: rule__BooleanLiteral__IsTrueAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_12201);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1085:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1089:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
            int alt6=2;
            switch ( input.LA(1) ) {
            case 15:
                {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_INT) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==39) ) {
                        alt6=2;
                    }
                    else if ( (LA6_3==EOF||(LA6_3>=17 && LA6_3<=20)||(LA6_3>=24 && LA6_3<=25)||LA6_3==27||(LA6_3>=31 && LA6_3<=32)||(LA6_3>=34 && LA6_3<=35)||LA6_3==40) ) {
                        alt6=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_1==39) ) {
                    alt6=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==RULE_INT) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==39) ) {
                        alt6=2;
                    }
                    else if ( (LA6_3==EOF||(LA6_3>=17 && LA6_3<=20)||(LA6_3>=24 && LA6_3<=25)||LA6_3==27||(LA6_3>=31 && LA6_3<=32)||(LA6_3>=34 && LA6_3<=35)||LA6_3==40) ) {
                        alt6=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_2==39) ) {
                    alt6=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA6_3 = input.LA(2);

                if ( (LA6_3==39) ) {
                    alt6=2;
                }
                else if ( (LA6_3==EOF||(LA6_3>=17 && LA6_3<=20)||(LA6_3>=24 && LA6_3<=25)||LA6_3==27||(LA6_3>=31 && LA6_3<=32)||(LA6_3>=34 && LA6_3<=35)||LA6_3==40) ) {
                    alt6=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt6=1;
                }
                break;
            case 39:
                {
                alt6=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1090:1: ( ruleIntLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1090:1: ( ruleIntLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1091:1: ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives2234);
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1096:6: ( ruleRealLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1096:6: ( ruleRealLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1097:1: ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives2251);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1107:1: rule__Integer__Alternatives : ( ( ruleSignedInteger ) | ( ruleHexadecimal ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1111:1: ( ( ruleSignedInteger ) | ( ruleHexadecimal ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_INT||(LA7_0>=15 && LA7_0<=16)) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_HEX) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1112:1: ( ruleSignedInteger )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1112:1: ( ruleSignedInteger )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1113:1: ruleSignedInteger
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives2283);
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1118:6: ( ruleHexadecimal )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1118:6: ( ruleHexadecimal )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1119:1: ruleHexadecimal
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives2300);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1129:1: rule__SignedInteger__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__SignedInteger__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1133:1: ( ( '+' ) | ( '-' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            else if ( (LA8_0==16) ) {
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1134:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1134:1: ( '+' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1135:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__SignedInteger__Alternatives_02333); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1142:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1142:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1143:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__SignedInteger__Alternatives_02353); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1155:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1159:1: ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) )
            int alt9=4;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1160:1: ( ruleDecimal )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1160:1: ( ruleDecimal )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1161:1: ruleDecimal
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleDecimal_in_rule__Real__Alternatives2387);
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1166:6: ( ruleDotDecimal )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1166:6: ( ruleDotDecimal )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1167:1: ruleDotDecimal
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives2404);
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1172:6: ( ruleDecimalDot )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1172:6: ( ruleDecimalDot )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1173:1: ruleDecimalDot
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives2421);
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1178:6: ( ruleDecimalExp )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1178:6: ( ruleDecimalExp )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1179:1: ruleDecimalExp
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives2438);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1189:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1193:1: ( ( '+' ) | ( '-' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            else if ( (LA10_0==16) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1194:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1194:1: ( '+' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1195:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__Decimal__Alternatives_02471); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1202:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1202:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1203:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__Decimal__Alternatives_02491); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1215:1: rule__DotDecimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DotDecimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1219:1: ( ( '+' ) | ( '-' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==15) ) {
                alt11=1;
            }
            else if ( (LA11_0==16) ) {
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1220:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1220:1: ( '+' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1221:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__DotDecimal__Alternatives_02526); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1228:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1228:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1229:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__DotDecimal__Alternatives_02546); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1241:1: rule__DecimalDot__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalDot__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1245:1: ( ( '+' ) | ( '-' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==15) ) {
                alt12=1;
            }
            else if ( (LA12_0==16) ) {
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1246:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1246:1: ( '+' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1247:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__DecimalDot__Alternatives_02581); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1254:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1254:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1255:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__DecimalDot__Alternatives_02601); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1267:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1271:1: ( ( '+' ) | ( '-' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==15) ) {
                alt13=1;
            }
            else if ( (LA13_0==16) ) {
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1272:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1272:1: ( '+' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1273:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__DecimalExp__Alternatives_02636); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1280:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1280:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1281:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__DecimalExp__Alternatives_02656); if (state.failed) return ;
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


    // $ANTLR start "rule__DecimalExp__Alternatives_5"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1293:1: rule__DecimalExp__Alternatives_5 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1297:1: ( ( '+' ) | ( '-' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==15) ) {
                alt14=1;
            }
            else if ( (LA14_0==16) ) {
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1298:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1298:1: ( '+' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1299:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__DecimalExp__Alternatives_52691); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1306:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1306:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1307:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_5_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__DecimalExp__Alternatives_52711); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_5_1()); 
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
    // $ANTLR end "rule__DecimalExp__Alternatives_5"


    // $ANTLR start "rule__ConfigModel__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1321:1: rule__ConfigModel__Group__0 : rule__ConfigModel__Group__0__Impl rule__ConfigModel__Group__1 ;
    public final void rule__ConfigModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1325:1: ( rule__ConfigModel__Group__0__Impl rule__ConfigModel__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1326:2: rule__ConfigModel__Group__0__Impl rule__ConfigModel__Group__1
            {
            pushFollow(FOLLOW_rule__ConfigModel__Group__0__Impl_in_rule__ConfigModel__Group__02743);
            rule__ConfigModel__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConfigModel__Group__1_in_rule__ConfigModel__Group__02746);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1333:1: rule__ConfigModel__Group__0__Impl : ( ( rule__ConfigModel__ImportsAssignment_0 )* ) ;
    public final void rule__ConfigModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1337:1: ( ( ( rule__ConfigModel__ImportsAssignment_0 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1338:1: ( ( rule__ConfigModel__ImportsAssignment_0 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1338:1: ( ( rule__ConfigModel__ImportsAssignment_0 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1339:1: ( rule__ConfigModel__ImportsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getImportsAssignment_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1340:1: ( rule__ConfigModel__ImportsAssignment_0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==36) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1340:2: rule__ConfigModel__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__ConfigModel__ImportsAssignment_0_in_rule__ConfigModel__Group__0__Impl2773);
            	    rule__ConfigModel__ImportsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getImportsAssignment_0()); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1350:1: rule__ConfigModel__Group__1 : rule__ConfigModel__Group__1__Impl ;
    public final void rule__ConfigModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1354:1: ( rule__ConfigModel__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1355:2: rule__ConfigModel__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConfigModel__Group__1__Impl_in_rule__ConfigModel__Group__12804);
            rule__ConfigModel__Group__1__Impl();

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1361:1: rule__ConfigModel__Group__1__Impl : ( ( rule__ConfigModel__ConfigElementsAssignment_1 )* ) ;
    public final void rule__ConfigModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1365:1: ( ( ( rule__ConfigModel__ConfigElementsAssignment_1 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1366:1: ( ( rule__ConfigModel__ConfigElementsAssignment_1 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1366:1: ( ( rule__ConfigModel__ConfigElementsAssignment_1 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1367:1: ( rule__ConfigModel__ConfigElementsAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getConfigElementsAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1368:1: ( rule__ConfigModel__ConfigElementsAssignment_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==17||LA16_0==19||(LA16_0>=24 && LA16_0<=25)||LA16_0==27||LA16_0==31) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1368:2: rule__ConfigModel__ConfigElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__ConfigModel__ConfigElementsAssignment_1_in_rule__ConfigModel__Group__1__Impl2831);
            	    rule__ConfigModel__ConfigElementsAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getConfigElementsAssignment_1()); 
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


    // $ANTLR start "rule__SubSystemConfig__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1382:1: rule__SubSystemConfig__Group__0 : rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1 ;
    public final void rule__SubSystemConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1386:1: ( rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1387:2: rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__0__Impl_in_rule__SubSystemConfig__Group__02866);
            rule__SubSystemConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__1_in_rule__SubSystemConfig__Group__02869);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1394:1: rule__SubSystemConfig__Group__0__Impl : ( 'SubSystemConfig' ) ;
    public final void rule__SubSystemConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1398:1: ( ( 'SubSystemConfig' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1399:1: ( 'SubSystemConfig' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1399:1: ( 'SubSystemConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1400:1: 'SubSystemConfig'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemConfigKeyword_0()); 
            }
            match(input,17,FOLLOW_17_in_rule__SubSystemConfig__Group__0__Impl2897); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1413:1: rule__SubSystemConfig__Group__1 : rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2 ;
    public final void rule__SubSystemConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1417:1: ( rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1418:2: rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__1__Impl_in_rule__SubSystemConfig__Group__12928);
            rule__SubSystemConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__2_in_rule__SubSystemConfig__Group__12931);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1425:1: rule__SubSystemConfig__Group__1__Impl : ( ( rule__SubSystemConfig__SubSystemAssignment_1 ) ) ;
    public final void rule__SubSystemConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1429:1: ( ( ( rule__SubSystemConfig__SubSystemAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1430:1: ( ( rule__SubSystemConfig__SubSystemAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1430:1: ( ( rule__SubSystemConfig__SubSystemAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1431:1: ( rule__SubSystemConfig__SubSystemAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1432:1: ( rule__SubSystemConfig__SubSystemAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1432:2: rule__SubSystemConfig__SubSystemAssignment_1
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__SubSystemAssignment_1_in_rule__SubSystemConfig__Group__1__Impl2958);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1442:1: rule__SubSystemConfig__Group__2 : rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3 ;
    public final void rule__SubSystemConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1446:1: ( rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1447:2: rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__2__Impl_in_rule__SubSystemConfig__Group__22988);
            rule__SubSystemConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__3_in_rule__SubSystemConfig__Group__22991);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1454:1: rule__SubSystemConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__SubSystemConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1458:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1459:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1459:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1460:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,18,FOLLOW_18_in_rule__SubSystemConfig__Group__2__Impl3019); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1473:1: rule__SubSystemConfig__Group__3 : rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4 ;
    public final void rule__SubSystemConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1477:1: ( rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1478:2: rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__3__Impl_in_rule__SubSystemConfig__Group__33050);
            rule__SubSystemConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__4_in_rule__SubSystemConfig__Group__33053);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1485:1: rule__SubSystemConfig__Group__3__Impl : ( ( rule__SubSystemConfig__DynConfigAssignment_3 ) ) ;
    public final void rule__SubSystemConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1489:1: ( ( ( rule__SubSystemConfig__DynConfigAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1490:1: ( ( rule__SubSystemConfig__DynConfigAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1490:1: ( ( rule__SubSystemConfig__DynConfigAssignment_3 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1491:1: ( rule__SubSystemConfig__DynConfigAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getDynConfigAssignment_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1492:1: ( rule__SubSystemConfig__DynConfigAssignment_3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1492:2: rule__SubSystemConfig__DynConfigAssignment_3
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__DynConfigAssignment_3_in_rule__SubSystemConfig__Group__3__Impl3080);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1502:1: rule__SubSystemConfig__Group__4 : rule__SubSystemConfig__Group__4__Impl ;
    public final void rule__SubSystemConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1506:1: ( rule__SubSystemConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1507:2: rule__SubSystemConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__4__Impl_in_rule__SubSystemConfig__Group__43110);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1513:1: rule__SubSystemConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__SubSystemConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1517:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1518:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1518:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1519:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,19,FOLLOW_19_in_rule__SubSystemConfig__Group__4__Impl3138); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1542:1: rule__DynamicConfig__Group__0 : rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1 ;
    public final void rule__DynamicConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1546:1: ( rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1547:2: rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__0__Impl_in_rule__DynamicConfig__Group__03179);
            rule__DynamicConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group__1_in_rule__DynamicConfig__Group__03182);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1554:1: rule__DynamicConfig__Group__0__Impl : ( 'dynamic configuration' ) ;
    public final void rule__DynamicConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1558:1: ( ( 'dynamic configuration' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1559:1: ( 'dynamic configuration' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1559:1: ( 'dynamic configuration' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1560:1: 'dynamic configuration'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getDynamicConfigurationKeyword_0()); 
            }
            match(input,20,FOLLOW_20_in_rule__DynamicConfig__Group__0__Impl3210); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1573:1: rule__DynamicConfig__Group__1 : rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2 ;
    public final void rule__DynamicConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1577:1: ( rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1578:2: rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__1__Impl_in_rule__DynamicConfig__Group__13241);
            rule__DynamicConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group__2_in_rule__DynamicConfig__Group__13244);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1585:1: rule__DynamicConfig__Group__1__Impl : ( '{' ) ;
    public final void rule__DynamicConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1589:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1590:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1590:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1591:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,18,FOLLOW_18_in_rule__DynamicConfig__Group__1__Impl3272); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1604:1: rule__DynamicConfig__Group__2 : rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3 ;
    public final void rule__DynamicConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1608:1: ( rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1609:2: rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__2__Impl_in_rule__DynamicConfig__Group__23303);
            rule__DynamicConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group__3_in_rule__DynamicConfig__Group__23306);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1616:1: rule__DynamicConfig__Group__2__Impl : ( ( rule__DynamicConfig__UnorderedGroup_2 ) ) ;
    public final void rule__DynamicConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1620:1: ( ( ( rule__DynamicConfig__UnorderedGroup_2 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1621:1: ( ( rule__DynamicConfig__UnorderedGroup_2 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1621:1: ( ( rule__DynamicConfig__UnorderedGroup_2 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1622:1: ( rule__DynamicConfig__UnorderedGroup_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1623:1: ( rule__DynamicConfig__UnorderedGroup_2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1623:2: rule__DynamicConfig__UnorderedGroup_2
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2_in_rule__DynamicConfig__Group__2__Impl3333);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1633:1: rule__DynamicConfig__Group__3 : rule__DynamicConfig__Group__3__Impl ;
    public final void rule__DynamicConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1637:1: ( rule__DynamicConfig__Group__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1638:2: rule__DynamicConfig__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__3__Impl_in_rule__DynamicConfig__Group__33363);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1644:1: rule__DynamicConfig__Group__3__Impl : ( '}' ) ;
    public final void rule__DynamicConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1648:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1649:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1649:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1650:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,19,FOLLOW_19_in_rule__DynamicConfig__Group__3__Impl3391); if (state.failed) return ;
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


    // $ANTLR start "rule__DynamicConfig__Group_2_0__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1671:1: rule__DynamicConfig__Group_2_0__0 : rule__DynamicConfig__Group_2_0__0__Impl rule__DynamicConfig__Group_2_0__1 ;
    public final void rule__DynamicConfig__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1675:1: ( rule__DynamicConfig__Group_2_0__0__Impl rule__DynamicConfig__Group_2_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1676:2: rule__DynamicConfig__Group_2_0__0__Impl rule__DynamicConfig__Group_2_0__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0__0__Impl_in_rule__DynamicConfig__Group_2_0__03430);
            rule__DynamicConfig__Group_2_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0__1_in_rule__DynamicConfig__Group_2_0__03433);
            rule__DynamicConfig__Group_2_0__1();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0__0"


    // $ANTLR start "rule__DynamicConfig__Group_2_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1683:1: rule__DynamicConfig__Group_2_0__0__Impl : ( 'source' ) ;
    public final void rule__DynamicConfig__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1687:1: ( ( 'source' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1688:1: ( 'source' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1688:1: ( 'source' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1689:1: 'source'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getSourceKeyword_2_0_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__DynamicConfig__Group_2_0__0__Impl3461); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getSourceKeyword_2_0_0()); 
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
    // $ANTLR end "rule__DynamicConfig__Group_2_0__0__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_0__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1702:1: rule__DynamicConfig__Group_2_0__1 : rule__DynamicConfig__Group_2_0__1__Impl rule__DynamicConfig__Group_2_0__2 ;
    public final void rule__DynamicConfig__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1706:1: ( rule__DynamicConfig__Group_2_0__1__Impl rule__DynamicConfig__Group_2_0__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1707:2: rule__DynamicConfig__Group_2_0__1__Impl rule__DynamicConfig__Group_2_0__2
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0__1__Impl_in_rule__DynamicConfig__Group_2_0__13492);
            rule__DynamicConfig__Group_2_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0__2_in_rule__DynamicConfig__Group_2_0__13495);
            rule__DynamicConfig__Group_2_0__2();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0__1"


    // $ANTLR start "rule__DynamicConfig__Group_2_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1714:1: rule__DynamicConfig__Group_2_0__1__Impl : ( ( rule__DynamicConfig__SourceAssignment_2_0_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1718:1: ( ( ( rule__DynamicConfig__SourceAssignment_2_0_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1719:1: ( ( rule__DynamicConfig__SourceAssignment_2_0_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1719:1: ( ( rule__DynamicConfig__SourceAssignment_2_0_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1720:1: ( rule__DynamicConfig__SourceAssignment_2_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getSourceAssignment_2_0_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1721:1: ( rule__DynamicConfig__SourceAssignment_2_0_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1721:2: rule__DynamicConfig__SourceAssignment_2_0_1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__SourceAssignment_2_0_1_in_rule__DynamicConfig__Group_2_0__1__Impl3522);
            rule__DynamicConfig__SourceAssignment_2_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getSourceAssignment_2_0_1()); 
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
    // $ANTLR end "rule__DynamicConfig__Group_2_0__1__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_0__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1731:1: rule__DynamicConfig__Group_2_0__2 : rule__DynamicConfig__Group_2_0__2__Impl ;
    public final void rule__DynamicConfig__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1735:1: ( rule__DynamicConfig__Group_2_0__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1736:2: rule__DynamicConfig__Group_2_0__2__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0__2__Impl_in_rule__DynamicConfig__Group_2_0__23552);
            rule__DynamicConfig__Group_2_0__2__Impl();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0__2"


    // $ANTLR start "rule__DynamicConfig__Group_2_0__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1742:1: rule__DynamicConfig__Group_2_0__2__Impl : ( ( rule__DynamicConfig__Group_2_0_2__0 )? ) ;
    public final void rule__DynamicConfig__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1746:1: ( ( ( rule__DynamicConfig__Group_2_0_2__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1747:1: ( ( rule__DynamicConfig__Group_2_0_2__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1747:1: ( ( rule__DynamicConfig__Group_2_0_2__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1748:1: ( rule__DynamicConfig__Group_2_0_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1749:1: ( rule__DynamicConfig__Group_2_0_2__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==22) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1749:2: rule__DynamicConfig__Group_2_0_2__0
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_2__0_in_rule__DynamicConfig__Group_2_0__2__Impl3579);
                    rule__DynamicConfig__Group_2_0_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getGroup_2_0_2()); 
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
    // $ANTLR end "rule__DynamicConfig__Group_2_0__2__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_2__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1765:1: rule__DynamicConfig__Group_2_0_2__0 : rule__DynamicConfig__Group_2_0_2__0__Impl rule__DynamicConfig__Group_2_0_2__1 ;
    public final void rule__DynamicConfig__Group_2_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1769:1: ( rule__DynamicConfig__Group_2_0_2__0__Impl rule__DynamicConfig__Group_2_0_2__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1770:2: rule__DynamicConfig__Group_2_0_2__0__Impl rule__DynamicConfig__Group_2_0_2__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_2__0__Impl_in_rule__DynamicConfig__Group_2_0_2__03616);
            rule__DynamicConfig__Group_2_0_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_2__1_in_rule__DynamicConfig__Group_2_0_2__03619);
            rule__DynamicConfig__Group_2_0_2__1();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_2__0"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_2__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1777:1: rule__DynamicConfig__Group_2_0_2__0__Impl : ( 'file path' ) ;
    public final void rule__DynamicConfig__Group_2_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1781:1: ( ( 'file path' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1782:1: ( 'file path' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1782:1: ( 'file path' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1783:1: 'file path'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getFilePathKeyword_2_0_2_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__DynamicConfig__Group_2_0_2__0__Impl3647); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getFilePathKeyword_2_0_2_0()); 
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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_2__0__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_2__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1796:1: rule__DynamicConfig__Group_2_0_2__1 : rule__DynamicConfig__Group_2_0_2__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1800:1: ( rule__DynamicConfig__Group_2_0_2__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1801:2: rule__DynamicConfig__Group_2_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_2__1__Impl_in_rule__DynamicConfig__Group_2_0_2__13678);
            rule__DynamicConfig__Group_2_0_2__1__Impl();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_2__1"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_2__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1807:1: rule__DynamicConfig__Group_2_0_2__1__Impl : ( ( rule__DynamicConfig__FilePathAssignment_2_0_2_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1811:1: ( ( ( rule__DynamicConfig__FilePathAssignment_2_0_2_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1812:1: ( ( rule__DynamicConfig__FilePathAssignment_2_0_2_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1812:1: ( ( rule__DynamicConfig__FilePathAssignment_2_0_2_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1813:1: ( rule__DynamicConfig__FilePathAssignment_2_0_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getFilePathAssignment_2_0_2_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1814:1: ( rule__DynamicConfig__FilePathAssignment_2_0_2_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1814:2: rule__DynamicConfig__FilePathAssignment_2_0_2_1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__FilePathAssignment_2_0_2_1_in_rule__DynamicConfig__Group_2_0_2__1__Impl3705);
            rule__DynamicConfig__FilePathAssignment_2_0_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getFilePathAssignment_2_0_2_1()); 
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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_2__1__Impl"


    // $ANTLR start "rule__DynamicConfig__Group_2_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1828:1: rule__DynamicConfig__Group_2_1__0 : rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1 ;
    public final void rule__DynamicConfig__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1832:1: ( rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1833:2: rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_1__0__Impl_in_rule__DynamicConfig__Group_2_1__03739);
            rule__DynamicConfig__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_1__1_in_rule__DynamicConfig__Group_2_1__03742);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1840:1: rule__DynamicConfig__Group_2_1__0__Impl : ( 'polling rate' ) ;
    public final void rule__DynamicConfig__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1844:1: ( ( 'polling rate' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1845:1: ( 'polling rate' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1845:1: ( 'polling rate' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1846:1: 'polling rate'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getPollingRateKeyword_2_1_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__DynamicConfig__Group_2_1__0__Impl3770); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getPollingRateKeyword_2_1_0()); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1859:1: rule__DynamicConfig__Group_2_1__1 : rule__DynamicConfig__Group_2_1__1__Impl ;
    public final void rule__DynamicConfig__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1863:1: ( rule__DynamicConfig__Group_2_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1864:2: rule__DynamicConfig__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_1__1__Impl_in_rule__DynamicConfig__Group_2_1__13801);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1870:1: rule__DynamicConfig__Group_2_1__1__Impl : ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1874:1: ( ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1875:1: ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1875:1: ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1876:1: ( rule__DynamicConfig__PollingAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getPollingAssignment_2_1_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1877:1: ( rule__DynamicConfig__PollingAssignment_2_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1877:2: rule__DynamicConfig__PollingAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__PollingAssignment_2_1_1_in_rule__DynamicConfig__Group_2_1__1__Impl3828);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1891:1: rule__ActorClassConfig__Group__0 : rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1 ;
    public final void rule__ActorClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1895:1: ( rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1896:2: rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__0__Impl_in_rule__ActorClassConfig__Group__03862);
            rule__ActorClassConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__1_in_rule__ActorClassConfig__Group__03865);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1903:1: rule__ActorClassConfig__Group__0__Impl : ( 'ActorClassConfig' ) ;
    public final void rule__ActorClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1907:1: ( ( 'ActorClassConfig' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1908:1: ( 'ActorClassConfig' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1908:1: ( 'ActorClassConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1909:1: 'ActorClassConfig'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorClassConfigKeyword_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__ActorClassConfig__Group__0__Impl3893); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1922:1: rule__ActorClassConfig__Group__1 : rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2 ;
    public final void rule__ActorClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1926:1: ( rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1927:2: rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__1__Impl_in_rule__ActorClassConfig__Group__13924);
            rule__ActorClassConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__2_in_rule__ActorClassConfig__Group__13927);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1934:1: rule__ActorClassConfig__Group__1__Impl : ( ( rule__ActorClassConfig__ActorAssignment_1 ) ) ;
    public final void rule__ActorClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1938:1: ( ( ( rule__ActorClassConfig__ActorAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1939:1: ( ( rule__ActorClassConfig__ActorAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1939:1: ( ( rule__ActorClassConfig__ActorAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1940:1: ( rule__ActorClassConfig__ActorAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1941:1: ( rule__ActorClassConfig__ActorAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1941:2: rule__ActorClassConfig__ActorAssignment_1
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__ActorAssignment_1_in_rule__ActorClassConfig__Group__1__Impl3954);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1951:1: rule__ActorClassConfig__Group__2 : rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3 ;
    public final void rule__ActorClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1955:1: ( rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1956:2: rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__2__Impl_in_rule__ActorClassConfig__Group__23984);
            rule__ActorClassConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__3_in_rule__ActorClassConfig__Group__23987);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1963:1: rule__ActorClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__ActorClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1967:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1968:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1968:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1969:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,18,FOLLOW_18_in_rule__ActorClassConfig__Group__2__Impl4015); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1982:1: rule__ActorClassConfig__Group__3 : rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4 ;
    public final void rule__ActorClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1986:1: ( rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1987:2: rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__3__Impl_in_rule__ActorClassConfig__Group__34046);
            rule__ActorClassConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__4_in_rule__ActorClassConfig__Group__34049);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1994:1: rule__ActorClassConfig__Group__3__Impl : ( ( rule__ActorClassConfig__AttributesAssignment_3 )* ) ;
    public final void rule__ActorClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1998:1: ( ( ( rule__ActorClassConfig__AttributesAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1999:1: ( ( rule__ActorClassConfig__AttributesAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1999:1: ( ( rule__ActorClassConfig__AttributesAssignment_3 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2000:1: ( rule__ActorClassConfig__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getAttributesAssignment_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2001:1: ( rule__ActorClassConfig__AttributesAssignment_3 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==32) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2001:2: rule__ActorClassConfig__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__ActorClassConfig__AttributesAssignment_3_in_rule__ActorClassConfig__Group__3__Impl4076);
            	    rule__ActorClassConfig__AttributesAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2011:1: rule__ActorClassConfig__Group__4 : rule__ActorClassConfig__Group__4__Impl ;
    public final void rule__ActorClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2015:1: ( rule__ActorClassConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2016:2: rule__ActorClassConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__4__Impl_in_rule__ActorClassConfig__Group__44107);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2022:1: rule__ActorClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__ActorClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2026:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2027:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2027:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2028:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,19,FOLLOW_19_in_rule__ActorClassConfig__Group__4__Impl4135); if (state.failed) return ;
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


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2051:1: rule__ActorInstanceConfig__Group_0__0 : rule__ActorInstanceConfig__Group_0__0__Impl rule__ActorInstanceConfig__Group_0__1 ;
    public final void rule__ActorInstanceConfig__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2055:1: ( rule__ActorInstanceConfig__Group_0__0__Impl rule__ActorInstanceConfig__Group_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2056:2: rule__ActorInstanceConfig__Group_0__0__Impl rule__ActorInstanceConfig__Group_0__1
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__0__Impl_in_rule__ActorInstanceConfig__Group_0__04176);
            rule__ActorInstanceConfig__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__1_in_rule__ActorInstanceConfig__Group_0__04179);
            rule__ActorInstanceConfig__Group_0__1();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__0"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2063:1: rule__ActorInstanceConfig__Group_0__0__Impl : ( 'ActorInstanceConfig' ) ;
    public final void rule__ActorInstanceConfig__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2067:1: ( ( 'ActorInstanceConfig' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2068:1: ( 'ActorInstanceConfig' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2068:1: ( 'ActorInstanceConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2069:1: 'ActorInstanceConfig'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getActorInstanceConfigKeyword_0_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__ActorInstanceConfig__Group_0__0__Impl4207); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getActorInstanceConfigKeyword_0_0()); 
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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__0__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2082:1: rule__ActorInstanceConfig__Group_0__1 : rule__ActorInstanceConfig__Group_0__1__Impl rule__ActorInstanceConfig__Group_0__2 ;
    public final void rule__ActorInstanceConfig__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2086:1: ( rule__ActorInstanceConfig__Group_0__1__Impl rule__ActorInstanceConfig__Group_0__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2087:2: rule__ActorInstanceConfig__Group_0__1__Impl rule__ActorInstanceConfig__Group_0__2
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__1__Impl_in_rule__ActorInstanceConfig__Group_0__14238);
            rule__ActorInstanceConfig__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__2_in_rule__ActorInstanceConfig__Group_0__14241);
            rule__ActorInstanceConfig__Group_0__2();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__1"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2094:1: rule__ActorInstanceConfig__Group_0__1__Impl : ( ( rule__ActorInstanceConfig__RootAssignment_0_1 ) ) ;
    public final void rule__ActorInstanceConfig__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2098:1: ( ( ( rule__ActorInstanceConfig__RootAssignment_0_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2099:1: ( ( rule__ActorInstanceConfig__RootAssignment_0_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2099:1: ( ( rule__ActorInstanceConfig__RootAssignment_0_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2100:1: ( rule__ActorInstanceConfig__RootAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRootAssignment_0_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2101:1: ( rule__ActorInstanceConfig__RootAssignment_0_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2101:2: rule__ActorInstanceConfig__RootAssignment_0_1
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__RootAssignment_0_1_in_rule__ActorInstanceConfig__Group_0__1__Impl4268);
            rule__ActorInstanceConfig__RootAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getRootAssignment_0_1()); 
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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__1__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2111:1: rule__ActorInstanceConfig__Group_0__2 : rule__ActorInstanceConfig__Group_0__2__Impl rule__ActorInstanceConfig__Group_0__3 ;
    public final void rule__ActorInstanceConfig__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2115:1: ( rule__ActorInstanceConfig__Group_0__2__Impl rule__ActorInstanceConfig__Group_0__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2116:2: rule__ActorInstanceConfig__Group_0__2__Impl rule__ActorInstanceConfig__Group_0__3
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__2__Impl_in_rule__ActorInstanceConfig__Group_0__24298);
            rule__ActorInstanceConfig__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__3_in_rule__ActorInstanceConfig__Group_0__24301);
            rule__ActorInstanceConfig__Group_0__3();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__2"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2123:1: rule__ActorInstanceConfig__Group_0__2__Impl : ( '/' ) ;
    public final void rule__ActorInstanceConfig__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2127:1: ( ( '/' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2128:1: ( '/' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2128:1: ( '/' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2129:1: '/'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_0_2()); 
            }
            match(input,26,FOLLOW_26_in_rule__ActorInstanceConfig__Group_0__2__Impl4329); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_0_2()); 
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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__2__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2142:1: rule__ActorInstanceConfig__Group_0__3 : rule__ActorInstanceConfig__Group_0__3__Impl rule__ActorInstanceConfig__Group_0__4 ;
    public final void rule__ActorInstanceConfig__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2146:1: ( rule__ActorInstanceConfig__Group_0__3__Impl rule__ActorInstanceConfig__Group_0__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2147:2: rule__ActorInstanceConfig__Group_0__3__Impl rule__ActorInstanceConfig__Group_0__4
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__3__Impl_in_rule__ActorInstanceConfig__Group_0__34360);
            rule__ActorInstanceConfig__Group_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__4_in_rule__ActorInstanceConfig__Group_0__34363);
            rule__ActorInstanceConfig__Group_0__4();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__3"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2154:1: rule__ActorInstanceConfig__Group_0__3__Impl : ( ( rule__ActorInstanceConfig__PathAssignment_0_3 ) ) ;
    public final void rule__ActorInstanceConfig__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2158:1: ( ( ( rule__ActorInstanceConfig__PathAssignment_0_3 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2159:1: ( ( rule__ActorInstanceConfig__PathAssignment_0_3 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2159:1: ( ( rule__ActorInstanceConfig__PathAssignment_0_3 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2160:1: ( rule__ActorInstanceConfig__PathAssignment_0_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getPathAssignment_0_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2161:1: ( rule__ActorInstanceConfig__PathAssignment_0_3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2161:2: rule__ActorInstanceConfig__PathAssignment_0_3
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__PathAssignment_0_3_in_rule__ActorInstanceConfig__Group_0__3__Impl4390);
            rule__ActorInstanceConfig__PathAssignment_0_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getPathAssignment_0_3()); 
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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__3__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__4"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2171:1: rule__ActorInstanceConfig__Group_0__4 : rule__ActorInstanceConfig__Group_0__4__Impl rule__ActorInstanceConfig__Group_0__5 ;
    public final void rule__ActorInstanceConfig__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2175:1: ( rule__ActorInstanceConfig__Group_0__4__Impl rule__ActorInstanceConfig__Group_0__5 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2176:2: rule__ActorInstanceConfig__Group_0__4__Impl rule__ActorInstanceConfig__Group_0__5
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__4__Impl_in_rule__ActorInstanceConfig__Group_0__44420);
            rule__ActorInstanceConfig__Group_0__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__5_in_rule__ActorInstanceConfig__Group_0__44423);
            rule__ActorInstanceConfig__Group_0__5();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__4"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2183:1: rule__ActorInstanceConfig__Group_0__4__Impl : ( '{' ) ;
    public final void rule__ActorInstanceConfig__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2187:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2188:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2188:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2189:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getLeftCurlyBracketKeyword_0_4()); 
            }
            match(input,18,FOLLOW_18_in_rule__ActorInstanceConfig__Group_0__4__Impl4451); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getLeftCurlyBracketKeyword_0_4()); 
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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__4__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__5"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2202:1: rule__ActorInstanceConfig__Group_0__5 : rule__ActorInstanceConfig__Group_0__5__Impl ;
    public final void rule__ActorInstanceConfig__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2206:1: ( rule__ActorInstanceConfig__Group_0__5__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2207:2: rule__ActorInstanceConfig__Group_0__5__Impl
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__5__Impl_in_rule__ActorInstanceConfig__Group_0__54482);
            rule__ActorInstanceConfig__Group_0__5__Impl();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__5"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__5__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2213:1: rule__ActorInstanceConfig__Group_0__5__Impl : ( ( rule__ActorInstanceConfig__AttributesAssignment_0_5 )* ) ;
    public final void rule__ActorInstanceConfig__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2217:1: ( ( ( rule__ActorInstanceConfig__AttributesAssignment_0_5 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2218:1: ( ( rule__ActorInstanceConfig__AttributesAssignment_0_5 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2218:1: ( ( rule__ActorInstanceConfig__AttributesAssignment_0_5 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2219:1: ( rule__ActorInstanceConfig__AttributesAssignment_0_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_0_5()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2220:1: ( rule__ActorInstanceConfig__AttributesAssignment_0_5 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==32) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2220:2: rule__ActorInstanceConfig__AttributesAssignment_0_5
            	    {
            	    pushFollow(FOLLOW_rule__ActorInstanceConfig__AttributesAssignment_0_5_in_rule__ActorInstanceConfig__Group_0__5__Impl4509);
            	    rule__ActorInstanceConfig__AttributesAssignment_0_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_0_5()); 
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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__5__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2242:1: rule__ActorInstanceConfig__Group_1__0 : rule__ActorInstanceConfig__Group_1__0__Impl rule__ActorInstanceConfig__Group_1__1 ;
    public final void rule__ActorInstanceConfig__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2246:1: ( rule__ActorInstanceConfig__Group_1__0__Impl rule__ActorInstanceConfig__Group_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2247:2: rule__ActorInstanceConfig__Group_1__0__Impl rule__ActorInstanceConfig__Group_1__1
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_1__0__Impl_in_rule__ActorInstanceConfig__Group_1__04552);
            rule__ActorInstanceConfig__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_1__1_in_rule__ActorInstanceConfig__Group_1__04555);
            rule__ActorInstanceConfig__Group_1__1();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_1__0"


    // $ANTLR start "rule__ActorInstanceConfig__Group_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2254:1: rule__ActorInstanceConfig__Group_1__0__Impl : ( ( rule__ActorInstanceConfig__PortsAssignment_1_0 )* ) ;
    public final void rule__ActorInstanceConfig__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2258:1: ( ( ( rule__ActorInstanceConfig__PortsAssignment_1_0 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2259:1: ( ( rule__ActorInstanceConfig__PortsAssignment_1_0 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2259:1: ( ( rule__ActorInstanceConfig__PortsAssignment_1_0 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2260:1: ( rule__ActorInstanceConfig__PortsAssignment_1_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2261:1: ( rule__ActorInstanceConfig__PortsAssignment_1_0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==31) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2261:2: rule__ActorInstanceConfig__PortsAssignment_1_0
            	    {
            	    pushFollow(FOLLOW_rule__ActorInstanceConfig__PortsAssignment_1_0_in_rule__ActorInstanceConfig__Group_1__0__Impl4582);
            	    rule__ActorInstanceConfig__PortsAssignment_1_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_1_0()); 
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
    // $ANTLR end "rule__ActorInstanceConfig__Group_1__0__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__Group_1__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2271:1: rule__ActorInstanceConfig__Group_1__1 : rule__ActorInstanceConfig__Group_1__1__Impl ;
    public final void rule__ActorInstanceConfig__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2275:1: ( rule__ActorInstanceConfig__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2276:2: rule__ActorInstanceConfig__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_1__1__Impl_in_rule__ActorInstanceConfig__Group_1__14613);
            rule__ActorInstanceConfig__Group_1__1__Impl();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_1__1"


    // $ANTLR start "rule__ActorInstanceConfig__Group_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2282:1: rule__ActorInstanceConfig__Group_1__1__Impl : ( '}' ) ;
    public final void rule__ActorInstanceConfig__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2286:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2287:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2287:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2288:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRightCurlyBracketKeyword_1_1()); 
            }
            match(input,19,FOLLOW_19_in_rule__ActorInstanceConfig__Group_1__1__Impl4641); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getRightCurlyBracketKeyword_1_1()); 
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
    // $ANTLR end "rule__ActorInstanceConfig__Group_1__1__Impl"


    // $ANTLR start "rule__ProtocolClassConfig__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2305:1: rule__ProtocolClassConfig__Group__0 : rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1 ;
    public final void rule__ProtocolClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2309:1: ( rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2310:2: rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__0__Impl_in_rule__ProtocolClassConfig__Group__04676);
            rule__ProtocolClassConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__1_in_rule__ProtocolClassConfig__Group__04679);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2317:1: rule__ProtocolClassConfig__Group__0__Impl : ( 'ProtocolClassConfig' ) ;
    public final void rule__ProtocolClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2321:1: ( ( 'ProtocolClassConfig' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2322:1: ( 'ProtocolClassConfig' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2322:1: ( 'ProtocolClassConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2323:1: 'ProtocolClassConfig'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolClassConfigKeyword_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__ProtocolClassConfig__Group__0__Impl4707); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2336:1: rule__ProtocolClassConfig__Group__1 : rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2 ;
    public final void rule__ProtocolClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2340:1: ( rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2341:2: rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__1__Impl_in_rule__ProtocolClassConfig__Group__14738);
            rule__ProtocolClassConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__2_in_rule__ProtocolClassConfig__Group__14741);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2348:1: rule__ProtocolClassConfig__Group__1__Impl : ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2352:1: ( ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2353:1: ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2353:1: ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2354:1: ( rule__ProtocolClassConfig__ProtocolAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2355:1: ( rule__ProtocolClassConfig__ProtocolAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2355:2: rule__ProtocolClassConfig__ProtocolAssignment_1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__ProtocolAssignment_1_in_rule__ProtocolClassConfig__Group__1__Impl4768);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2365:1: rule__ProtocolClassConfig__Group__2 : rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3 ;
    public final void rule__ProtocolClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2369:1: ( rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2370:2: rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__2__Impl_in_rule__ProtocolClassConfig__Group__24798);
            rule__ProtocolClassConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__3_in_rule__ProtocolClassConfig__Group__24801);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2377:1: rule__ProtocolClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__ProtocolClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2381:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2382:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2382:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2383:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,18,FOLLOW_18_in_rule__ProtocolClassConfig__Group__2__Impl4829); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2396:1: rule__ProtocolClassConfig__Group__3 : rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4 ;
    public final void rule__ProtocolClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2400:1: ( rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2401:2: rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__3__Impl_in_rule__ProtocolClassConfig__Group__34860);
            rule__ProtocolClassConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__4_in_rule__ProtocolClassConfig__Group__34863);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2408:1: rule__ProtocolClassConfig__Group__3__Impl : ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) ) ;
    public final void rule__ProtocolClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2412:1: ( ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2413:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2413:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2414:1: ( rule__ProtocolClassConfig__UnorderedGroup_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2415:1: ( rule__ProtocolClassConfig__UnorderedGroup_3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2415:2: rule__ProtocolClassConfig__UnorderedGroup_3
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3_in_rule__ProtocolClassConfig__Group__3__Impl4890);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2425:1: rule__ProtocolClassConfig__Group__4 : rule__ProtocolClassConfig__Group__4__Impl ;
    public final void rule__ProtocolClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2429:1: ( rule__ProtocolClassConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2430:2: rule__ProtocolClassConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__4__Impl_in_rule__ProtocolClassConfig__Group__44920);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2436:1: rule__ProtocolClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__ProtocolClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2440:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2441:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2441:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2442:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,19,FOLLOW_19_in_rule__ProtocolClassConfig__Group__4__Impl4948); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2465:1: rule__ProtocolClassConfig__Group_3_0__0 : rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1 ;
    public final void rule__ProtocolClassConfig__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2469:1: ( rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2470:2: rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_0__0__Impl_in_rule__ProtocolClassConfig__Group_3_0__04989);
            rule__ProtocolClassConfig__Group_3_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_0__1_in_rule__ProtocolClassConfig__Group_3_0__04992);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2477:1: rule__ProtocolClassConfig__Group_3_0__0__Impl : ( 'regular' ) ;
    public final void rule__ProtocolClassConfig__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2481:1: ( ( 'regular' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2482:1: ( 'regular' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2482:1: ( 'regular' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2483:1: 'regular'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getRegularKeyword_3_0_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__ProtocolClassConfig__Group_3_0__0__Impl5020); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2496:1: rule__ProtocolClassConfig__Group_3_0__1 : rule__ProtocolClassConfig__Group_3_0__1__Impl ;
    public final void rule__ProtocolClassConfig__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2500:1: ( rule__ProtocolClassConfig__Group_3_0__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2501:2: rule__ProtocolClassConfig__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_0__1__Impl_in_rule__ProtocolClassConfig__Group_3_0__15051);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2507:1: rule__ProtocolClassConfig__Group_3_0__1__Impl : ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2511:1: ( ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2512:1: ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2512:1: ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2513:1: ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getRegularAssignment_3_0_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2514:1: ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2514:2: rule__ProtocolClassConfig__RegularAssignment_3_0_1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__RegularAssignment_3_0_1_in_rule__ProtocolClassConfig__Group_3_0__1__Impl5078);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2528:1: rule__ProtocolClassConfig__Group_3_1__0 : rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1 ;
    public final void rule__ProtocolClassConfig__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2532:1: ( rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2533:2: rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_1__0__Impl_in_rule__ProtocolClassConfig__Group_3_1__05112);
            rule__ProtocolClassConfig__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_1__1_in_rule__ProtocolClassConfig__Group_3_1__05115);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2540:1: rule__ProtocolClassConfig__Group_3_1__0__Impl : ( 'conjugate' ) ;
    public final void rule__ProtocolClassConfig__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2544:1: ( ( 'conjugate' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2545:1: ( 'conjugate' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2545:1: ( 'conjugate' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2546:1: 'conjugate'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getConjugateKeyword_3_1_0()); 
            }
            match(input,29,FOLLOW_29_in_rule__ProtocolClassConfig__Group_3_1__0__Impl5143); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2559:1: rule__ProtocolClassConfig__Group_3_1__1 : rule__ProtocolClassConfig__Group_3_1__1__Impl ;
    public final void rule__ProtocolClassConfig__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2563:1: ( rule__ProtocolClassConfig__Group_3_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2564:2: rule__ProtocolClassConfig__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_1__1__Impl_in_rule__ProtocolClassConfig__Group_3_1__15174);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2570:1: rule__ProtocolClassConfig__Group_3_1__1__Impl : ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2574:1: ( ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2575:1: ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2575:1: ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2576:1: ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getConjugatedAssignment_3_1_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2577:1: ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2577:2: rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1_in_rule__ProtocolClassConfig__Group_3_1__1__Impl5201);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2591:1: rule__PortClassConfig__Group__0 : rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1 ;
    public final void rule__PortClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2595:1: ( rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2596:2: rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__0__Impl_in_rule__PortClassConfig__Group__05235);
            rule__PortClassConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortClassConfig__Group__1_in_rule__PortClassConfig__Group__05238);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2603:1: rule__PortClassConfig__Group__0__Impl : ( () ) ;
    public final void rule__PortClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2607:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2608:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2608:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2609:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getPortClassConfigAction_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2610:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2612:1: 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2622:1: rule__PortClassConfig__Group__1 : rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2 ;
    public final void rule__PortClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2626:1: ( rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2627:2: rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__1__Impl_in_rule__PortClassConfig__Group__15296);
            rule__PortClassConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortClassConfig__Group__2_in_rule__PortClassConfig__Group__15299);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2634:1: rule__PortClassConfig__Group__1__Impl : ( 'Port' ) ;
    public final void rule__PortClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2638:1: ( ( 'Port' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2639:1: ( 'Port' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2639:1: ( 'Port' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2640:1: 'Port'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getPortKeyword_1()); 
            }
            match(input,30,FOLLOW_30_in_rule__PortClassConfig__Group__1__Impl5327); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2653:1: rule__PortClassConfig__Group__2 : rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3 ;
    public final void rule__PortClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2657:1: ( rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2658:2: rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__2__Impl_in_rule__PortClassConfig__Group__25358);
            rule__PortClassConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortClassConfig__Group__3_in_rule__PortClassConfig__Group__25361);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2665:1: rule__PortClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__PortClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2669:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2670:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2670:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2671:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,18,FOLLOW_18_in_rule__PortClassConfig__Group__2__Impl5389); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2684:1: rule__PortClassConfig__Group__3 : rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4 ;
    public final void rule__PortClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2688:1: ( rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2689:2: rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__3__Impl_in_rule__PortClassConfig__Group__35420);
            rule__PortClassConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortClassConfig__Group__4_in_rule__PortClassConfig__Group__35423);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2696:1: rule__PortClassConfig__Group__3__Impl : ( ( rule__PortClassConfig__AttributesAssignment_3 )* ) ;
    public final void rule__PortClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2700:1: ( ( ( rule__PortClassConfig__AttributesAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2701:1: ( ( rule__PortClassConfig__AttributesAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2701:1: ( ( rule__PortClassConfig__AttributesAssignment_3 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2702:1: ( rule__PortClassConfig__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getAttributesAssignment_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2703:1: ( rule__PortClassConfig__AttributesAssignment_3 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==32) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2703:2: rule__PortClassConfig__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PortClassConfig__AttributesAssignment_3_in_rule__PortClassConfig__Group__3__Impl5450);
            	    rule__PortClassConfig__AttributesAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2713:1: rule__PortClassConfig__Group__4 : rule__PortClassConfig__Group__4__Impl ;
    public final void rule__PortClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2717:1: ( rule__PortClassConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2718:2: rule__PortClassConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__4__Impl_in_rule__PortClassConfig__Group__45481);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2724:1: rule__PortClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__PortClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2728:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2729:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2729:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2730:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,19,FOLLOW_19_in_rule__PortClassConfig__Group__4__Impl5509); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2753:1: rule__PortInstanceConfig__Group__0 : rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1 ;
    public final void rule__PortInstanceConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2757:1: ( rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2758:2: rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__0__Impl_in_rule__PortInstanceConfig__Group__05550);
            rule__PortInstanceConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__1_in_rule__PortInstanceConfig__Group__05553);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2765:1: rule__PortInstanceConfig__Group__0__Impl : ( 'InterfaceItem' ) ;
    public final void rule__PortInstanceConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2769:1: ( ( 'InterfaceItem' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2770:1: ( 'InterfaceItem' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2770:1: ( 'InterfaceItem' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2771:1: 'InterfaceItem'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getInterfaceItemKeyword_0()); 
            }
            match(input,31,FOLLOW_31_in_rule__PortInstanceConfig__Group__0__Impl5581); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2784:1: rule__PortInstanceConfig__Group__1 : rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2 ;
    public final void rule__PortInstanceConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2788:1: ( rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2789:2: rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__1__Impl_in_rule__PortInstanceConfig__Group__15612);
            rule__PortInstanceConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__2_in_rule__PortInstanceConfig__Group__15615);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2796:1: rule__PortInstanceConfig__Group__1__Impl : ( ( rule__PortInstanceConfig__ItemAssignment_1 ) ) ;
    public final void rule__PortInstanceConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2800:1: ( ( ( rule__PortInstanceConfig__ItemAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2801:1: ( ( rule__PortInstanceConfig__ItemAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2801:1: ( ( rule__PortInstanceConfig__ItemAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2802:1: ( rule__PortInstanceConfig__ItemAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getItemAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2803:1: ( rule__PortInstanceConfig__ItemAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2803:2: rule__PortInstanceConfig__ItemAssignment_1
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__ItemAssignment_1_in_rule__PortInstanceConfig__Group__1__Impl5642);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2813:1: rule__PortInstanceConfig__Group__2 : rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3 ;
    public final void rule__PortInstanceConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2817:1: ( rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2818:2: rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__2__Impl_in_rule__PortInstanceConfig__Group__25672);
            rule__PortInstanceConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__3_in_rule__PortInstanceConfig__Group__25675);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2825:1: rule__PortInstanceConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__PortInstanceConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2829:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2830:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2830:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2831:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,18,FOLLOW_18_in_rule__PortInstanceConfig__Group__2__Impl5703); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2844:1: rule__PortInstanceConfig__Group__3 : rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4 ;
    public final void rule__PortInstanceConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2848:1: ( rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2849:2: rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__3__Impl_in_rule__PortInstanceConfig__Group__35734);
            rule__PortInstanceConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__4_in_rule__PortInstanceConfig__Group__35737);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2856:1: rule__PortInstanceConfig__Group__3__Impl : ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* ) ;
    public final void rule__PortInstanceConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2860:1: ( ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2861:1: ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2861:1: ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2862:1: ( rule__PortInstanceConfig__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getAttributesAssignment_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2863:1: ( rule__PortInstanceConfig__AttributesAssignment_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==32) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2863:2: rule__PortInstanceConfig__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PortInstanceConfig__AttributesAssignment_3_in_rule__PortInstanceConfig__Group__3__Impl5764);
            	    rule__PortInstanceConfig__AttributesAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2873:1: rule__PortInstanceConfig__Group__4 : rule__PortInstanceConfig__Group__4__Impl ;
    public final void rule__PortInstanceConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2877:1: ( rule__PortInstanceConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2878:2: rule__PortInstanceConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__4__Impl_in_rule__PortInstanceConfig__Group__45795);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2884:1: rule__PortInstanceConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__PortInstanceConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2888:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2889:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2889:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2890:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,19,FOLLOW_19_in_rule__PortInstanceConfig__Group__4__Impl5823); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2913:1: rule__AttrClassConfig__Group__0 : rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1 ;
    public final void rule__AttrClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2917:1: ( rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2918:2: rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__0__Impl_in_rule__AttrClassConfig__Group__05864);
            rule__AttrClassConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__1_in_rule__AttrClassConfig__Group__05867);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2925:1: rule__AttrClassConfig__Group__0__Impl : ( 'Attr' ) ;
    public final void rule__AttrClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2929:1: ( ( 'Attr' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2930:1: ( 'Attr' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2930:1: ( 'Attr' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2931:1: 'Attr'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttrKeyword_0()); 
            }
            match(input,32,FOLLOW_32_in_rule__AttrClassConfig__Group__0__Impl5895); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2944:1: rule__AttrClassConfig__Group__1 : rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2 ;
    public final void rule__AttrClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2948:1: ( rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2949:2: rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__1__Impl_in_rule__AttrClassConfig__Group__15926);
            rule__AttrClassConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__2_in_rule__AttrClassConfig__Group__15929);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2956:1: rule__AttrClassConfig__Group__1__Impl : ( ( rule__AttrClassConfig__AttributeAssignment_1 ) ) ;
    public final void rule__AttrClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2960:1: ( ( ( rule__AttrClassConfig__AttributeAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2961:1: ( ( rule__AttrClassConfig__AttributeAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2961:1: ( ( rule__AttrClassConfig__AttributeAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2962:1: ( rule__AttrClassConfig__AttributeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributeAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2963:1: ( rule__AttrClassConfig__AttributeAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2963:2: rule__AttrClassConfig__AttributeAssignment_1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__AttributeAssignment_1_in_rule__AttrClassConfig__Group__1__Impl5956);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2973:1: rule__AttrClassConfig__Group__2 : rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3 ;
    public final void rule__AttrClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2977:1: ( rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2978:2: rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__2__Impl_in_rule__AttrClassConfig__Group__25986);
            rule__AttrClassConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__3_in_rule__AttrClassConfig__Group__25989);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2985:1: rule__AttrClassConfig__Group__2__Impl : ( ( rule__AttrClassConfig__Group_2__0 )? ) ;
    public final void rule__AttrClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2989:1: ( ( ( rule__AttrClassConfig__Group_2__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2990:1: ( ( rule__AttrClassConfig__Group_2__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2990:1: ( ( rule__AttrClassConfig__Group_2__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2991:1: ( rule__AttrClassConfig__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2992:1: ( rule__AttrClassConfig__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2992:2: rule__AttrClassConfig__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__Group_2__0_in_rule__AttrClassConfig__Group__2__Impl6016);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3002:1: rule__AttrClassConfig__Group__3 : rule__AttrClassConfig__Group__3__Impl ;
    public final void rule__AttrClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3006:1: ( rule__AttrClassConfig__Group__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3007:2: rule__AttrClassConfig__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__3__Impl_in_rule__AttrClassConfig__Group__36047);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3013:1: rule__AttrClassConfig__Group__3__Impl : ( ( rule__AttrClassConfig__Group_3__0 )? ) ;
    public final void rule__AttrClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3017:1: ( ( ( rule__AttrClassConfig__Group_3__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3018:1: ( ( rule__AttrClassConfig__Group_3__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3018:1: ( ( rule__AttrClassConfig__Group_3__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3019:1: ( rule__AttrClassConfig__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3020:1: ( rule__AttrClassConfig__Group_3__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==18) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3020:2: rule__AttrClassConfig__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__0_in_rule__AttrClassConfig__Group__3__Impl6074);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3038:1: rule__AttrClassConfig__Group_2__0 : rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1 ;
    public final void rule__AttrClassConfig__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3042:1: ( rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3043:2: rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_2__0__Impl_in_rule__AttrClassConfig__Group_2__06113);
            rule__AttrClassConfig__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_2__1_in_rule__AttrClassConfig__Group_2__06116);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3050:1: rule__AttrClassConfig__Group_2__0__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3054:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3055:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3055:1: ( '=' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3056:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_2_0()); 
            }
            match(input,33,FOLLOW_33_in_rule__AttrClassConfig__Group_2__0__Impl6144); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3069:1: rule__AttrClassConfig__Group_2__1 : rule__AttrClassConfig__Group_2__1__Impl ;
    public final void rule__AttrClassConfig__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3073:1: ( rule__AttrClassConfig__Group_2__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3074:2: rule__AttrClassConfig__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_2__1__Impl_in_rule__AttrClassConfig__Group_2__16175);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3080:1: rule__AttrClassConfig__Group_2__1__Impl : ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) ) ;
    public final void rule__AttrClassConfig__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3084:1: ( ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3085:1: ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3085:1: ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3086:1: ( rule__AttrClassConfig__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getValueAssignment_2_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3087:1: ( rule__AttrClassConfig__ValueAssignment_2_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3087:2: rule__AttrClassConfig__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__ValueAssignment_2_1_in_rule__AttrClassConfig__Group_2__1__Impl6202);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3101:1: rule__AttrClassConfig__Group_3__0 : rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1 ;
    public final void rule__AttrClassConfig__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3105:1: ( rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3106:2: rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__0__Impl_in_rule__AttrClassConfig__Group_3__06236);
            rule__AttrClassConfig__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__1_in_rule__AttrClassConfig__Group_3__06239);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3113:1: rule__AttrClassConfig__Group_3__0__Impl : ( '{' ) ;
    public final void rule__AttrClassConfig__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3117:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3118:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3118:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3119:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getLeftCurlyBracketKeyword_3_0()); 
            }
            match(input,18,FOLLOW_18_in_rule__AttrClassConfig__Group_3__0__Impl6267); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3132:1: rule__AttrClassConfig__Group_3__1 : rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2 ;
    public final void rule__AttrClassConfig__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3136:1: ( rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3137:2: rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__1__Impl_in_rule__AttrClassConfig__Group_3__16298);
            rule__AttrClassConfig__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__2_in_rule__AttrClassConfig__Group_3__16301);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3144:1: rule__AttrClassConfig__Group_3__1__Impl : ( ( rule__AttrClassConfig__UnorderedGroup_3_1 ) ) ;
    public final void rule__AttrClassConfig__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3148:1: ( ( ( rule__AttrClassConfig__UnorderedGroup_3_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3149:1: ( ( rule__AttrClassConfig__UnorderedGroup_3_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3149:1: ( ( rule__AttrClassConfig__UnorderedGroup_3_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3150:1: ( rule__AttrClassConfig__UnorderedGroup_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3151:1: ( rule__AttrClassConfig__UnorderedGroup_3_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3151:2: rule__AttrClassConfig__UnorderedGroup_3_1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1_in_rule__AttrClassConfig__Group_3__1__Impl6328);
            rule__AttrClassConfig__UnorderedGroup_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1()); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3161:1: rule__AttrClassConfig__Group_3__2 : rule__AttrClassConfig__Group_3__2__Impl rule__AttrClassConfig__Group_3__3 ;
    public final void rule__AttrClassConfig__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3165:1: ( rule__AttrClassConfig__Group_3__2__Impl rule__AttrClassConfig__Group_3__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3166:2: rule__AttrClassConfig__Group_3__2__Impl rule__AttrClassConfig__Group_3__3
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__2__Impl_in_rule__AttrClassConfig__Group_3__26358);
            rule__AttrClassConfig__Group_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__3_in_rule__AttrClassConfig__Group_3__26361);
            rule__AttrClassConfig__Group_3__3();

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3173:1: rule__AttrClassConfig__Group_3__2__Impl : ( ( rule__AttrClassConfig__AttributesAssignment_3_2 )* ) ;
    public final void rule__AttrClassConfig__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3177:1: ( ( ( rule__AttrClassConfig__AttributesAssignment_3_2 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3178:1: ( ( rule__AttrClassConfig__AttributesAssignment_3_2 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3178:1: ( ( rule__AttrClassConfig__AttributesAssignment_3_2 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3179:1: ( rule__AttrClassConfig__AttributesAssignment_3_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributesAssignment_3_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3180:1: ( rule__AttrClassConfig__AttributesAssignment_3_2 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==32) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3180:2: rule__AttrClassConfig__AttributesAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_rule__AttrClassConfig__AttributesAssignment_3_2_in_rule__AttrClassConfig__Group_3__2__Impl6388);
            	    rule__AttrClassConfig__AttributesAssignment_3_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getAttributesAssignment_3_2()); 
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


    // $ANTLR start "rule__AttrClassConfig__Group_3__3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3190:1: rule__AttrClassConfig__Group_3__3 : rule__AttrClassConfig__Group_3__3__Impl ;
    public final void rule__AttrClassConfig__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3194:1: ( rule__AttrClassConfig__Group_3__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3195:2: rule__AttrClassConfig__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__3__Impl_in_rule__AttrClassConfig__Group_3__36419);
            rule__AttrClassConfig__Group_3__3__Impl();

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
    // $ANTLR end "rule__AttrClassConfig__Group_3__3"


    // $ANTLR start "rule__AttrClassConfig__Group_3__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3201:1: rule__AttrClassConfig__Group_3__3__Impl : ( '}' ) ;
    public final void rule__AttrClassConfig__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3205:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3206:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3206:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3207:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getRightCurlyBracketKeyword_3_3()); 
            }
            match(input,19,FOLLOW_19_in_rule__AttrClassConfig__Group_3__3__Impl6447); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getRightCurlyBracketKeyword_3_3()); 
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
    // $ANTLR end "rule__AttrClassConfig__Group_3__3__Impl"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_0__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3228:1: rule__AttrClassConfig__Group_3_1_0__0 : rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1 ;
    public final void rule__AttrClassConfig__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3232:1: ( rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3233:2: rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__0__Impl_in_rule__AttrClassConfig__Group_3_1_0__06486);
            rule__AttrClassConfig__Group_3_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__1_in_rule__AttrClassConfig__Group_3_1_0__06489);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3240:1: rule__AttrClassConfig__Group_3_1_0__0__Impl : ( 'min' ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3244:1: ( ( 'min' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3245:1: ( 'min' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3245:1: ( 'min' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3246:1: 'min'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMinKeyword_3_1_0_0()); 
            }
            match(input,34,FOLLOW_34_in_rule__AttrClassConfig__Group_3_1_0__0__Impl6517); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3259:1: rule__AttrClassConfig__Group_3_1_0__1 : rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2 ;
    public final void rule__AttrClassConfig__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3263:1: ( rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3264:2: rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__1__Impl_in_rule__AttrClassConfig__Group_3_1_0__16548);
            rule__AttrClassConfig__Group_3_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__2_in_rule__AttrClassConfig__Group_3_1_0__16551);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3271:1: rule__AttrClassConfig__Group_3_1_0__1__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3275:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3276:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3276:1: ( '=' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3277:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_0_1()); 
            }
            match(input,33,FOLLOW_33_in_rule__AttrClassConfig__Group_3_1_0__1__Impl6579); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3290:1: rule__AttrClassConfig__Group_3_1_0__2 : rule__AttrClassConfig__Group_3_1_0__2__Impl ;
    public final void rule__AttrClassConfig__Group_3_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3294:1: ( rule__AttrClassConfig__Group_3_1_0__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3295:2: rule__AttrClassConfig__Group_3_1_0__2__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__2__Impl_in_rule__AttrClassConfig__Group_3_1_0__26610);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3301:1: rule__AttrClassConfig__Group_3_1_0__2__Impl : ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3305:1: ( ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3306:1: ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3306:1: ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3307:1: ( rule__AttrClassConfig__MinAssignment_3_1_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMinAssignment_3_1_0_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3308:1: ( rule__AttrClassConfig__MinAssignment_3_1_0_2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3308:2: rule__AttrClassConfig__MinAssignment_3_1_0_2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__MinAssignment_3_1_0_2_in_rule__AttrClassConfig__Group_3_1_0__2__Impl6637);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3324:1: rule__AttrClassConfig__Group_3_1_1__0 : rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1 ;
    public final void rule__AttrClassConfig__Group_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3328:1: ( rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3329:2: rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__0__Impl_in_rule__AttrClassConfig__Group_3_1_1__06673);
            rule__AttrClassConfig__Group_3_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__1_in_rule__AttrClassConfig__Group_3_1_1__06676);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3336:1: rule__AttrClassConfig__Group_3_1_1__0__Impl : ( 'max' ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3340:1: ( ( 'max' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3341:1: ( 'max' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3341:1: ( 'max' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3342:1: 'max'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMaxKeyword_3_1_1_0()); 
            }
            match(input,35,FOLLOW_35_in_rule__AttrClassConfig__Group_3_1_1__0__Impl6704); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3355:1: rule__AttrClassConfig__Group_3_1_1__1 : rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2 ;
    public final void rule__AttrClassConfig__Group_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3359:1: ( rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3360:2: rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__1__Impl_in_rule__AttrClassConfig__Group_3_1_1__16735);
            rule__AttrClassConfig__Group_3_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__2_in_rule__AttrClassConfig__Group_3_1_1__16738);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3367:1: rule__AttrClassConfig__Group_3_1_1__1__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3371:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3372:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3372:1: ( '=' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3373:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_1_1()); 
            }
            match(input,33,FOLLOW_33_in_rule__AttrClassConfig__Group_3_1_1__1__Impl6766); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3386:1: rule__AttrClassConfig__Group_3_1_1__2 : rule__AttrClassConfig__Group_3_1_1__2__Impl ;
    public final void rule__AttrClassConfig__Group_3_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3390:1: ( rule__AttrClassConfig__Group_3_1_1__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3391:2: rule__AttrClassConfig__Group_3_1_1__2__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__2__Impl_in_rule__AttrClassConfig__Group_3_1_1__26797);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3397:1: rule__AttrClassConfig__Group_3_1_1__2__Impl : ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3401:1: ( ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3402:1: ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3402:1: ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3403:1: ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMaxAssignment_3_1_1_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3404:1: ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3404:2: rule__AttrClassConfig__MaxAssignment_3_1_1_2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__MaxAssignment_3_1_1_2_in_rule__AttrClassConfig__Group_3_1_1__2__Impl6824);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3420:1: rule__AttrInstanceConfig__Group__0 : rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1 ;
    public final void rule__AttrInstanceConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3424:1: ( rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3425:2: rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__0__Impl_in_rule__AttrInstanceConfig__Group__06860);
            rule__AttrInstanceConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__1_in_rule__AttrInstanceConfig__Group__06863);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3432:1: rule__AttrInstanceConfig__Group__0__Impl : ( 'Attr' ) ;
    public final void rule__AttrInstanceConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3436:1: ( ( 'Attr' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3437:1: ( 'Attr' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3437:1: ( 'Attr' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3438:1: 'Attr'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttrKeyword_0()); 
            }
            match(input,32,FOLLOW_32_in_rule__AttrInstanceConfig__Group__0__Impl6891); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3451:1: rule__AttrInstanceConfig__Group__1 : rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2 ;
    public final void rule__AttrInstanceConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3455:1: ( rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3456:2: rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__1__Impl_in_rule__AttrInstanceConfig__Group__16922);
            rule__AttrInstanceConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__2_in_rule__AttrInstanceConfig__Group__16925);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3463:1: rule__AttrInstanceConfig__Group__1__Impl : ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3467:1: ( ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3468:1: ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3468:1: ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3469:1: ( rule__AttrInstanceConfig__AttributeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3470:1: ( rule__AttrInstanceConfig__AttributeAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3470:2: rule__AttrInstanceConfig__AttributeAssignment_1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__AttributeAssignment_1_in_rule__AttrInstanceConfig__Group__1__Impl6952);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3480:1: rule__AttrInstanceConfig__Group__2 : rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3 ;
    public final void rule__AttrInstanceConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3484:1: ( rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3485:2: rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__2__Impl_in_rule__AttrInstanceConfig__Group__26982);
            rule__AttrInstanceConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__3_in_rule__AttrInstanceConfig__Group__26985);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3492:1: rule__AttrInstanceConfig__Group__2__Impl : ( ( rule__AttrInstanceConfig__Group_2__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3496:1: ( ( ( rule__AttrInstanceConfig__Group_2__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3497:1: ( ( rule__AttrInstanceConfig__Group_2__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3497:1: ( ( rule__AttrInstanceConfig__Group_2__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3498:1: ( rule__AttrInstanceConfig__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3499:1: ( rule__AttrInstanceConfig__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==33) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3499:2: rule__AttrInstanceConfig__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_2__0_in_rule__AttrInstanceConfig__Group__2__Impl7012);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3509:1: rule__AttrInstanceConfig__Group__3 : rule__AttrInstanceConfig__Group__3__Impl ;
    public final void rule__AttrInstanceConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3513:1: ( rule__AttrInstanceConfig__Group__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3514:2: rule__AttrInstanceConfig__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__3__Impl_in_rule__AttrInstanceConfig__Group__37043);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3520:1: rule__AttrInstanceConfig__Group__3__Impl : ( ( rule__AttrInstanceConfig__Group_3__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3524:1: ( ( ( rule__AttrInstanceConfig__Group_3__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3525:1: ( ( rule__AttrInstanceConfig__Group_3__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3525:1: ( ( rule__AttrInstanceConfig__Group_3__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3526:1: ( rule__AttrInstanceConfig__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_3()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3527:1: ( rule__AttrInstanceConfig__Group_3__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==18) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3527:2: rule__AttrInstanceConfig__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__0_in_rule__AttrInstanceConfig__Group__3__Impl7070);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3545:1: rule__AttrInstanceConfig__Group_2__0 : rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1 ;
    public final void rule__AttrInstanceConfig__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3549:1: ( rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3550:2: rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_2__0__Impl_in_rule__AttrInstanceConfig__Group_2__07109);
            rule__AttrInstanceConfig__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_2__1_in_rule__AttrInstanceConfig__Group_2__07112);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3557:1: rule__AttrInstanceConfig__Group_2__0__Impl : ( '=' ) ;
    public final void rule__AttrInstanceConfig__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3561:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3562:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3562:1: ( '=' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3563:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getEqualsSignKeyword_2_0()); 
            }
            match(input,33,FOLLOW_33_in_rule__AttrInstanceConfig__Group_2__0__Impl7140); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3576:1: rule__AttrInstanceConfig__Group_2__1 : rule__AttrInstanceConfig__Group_2__1__Impl ;
    public final void rule__AttrInstanceConfig__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3580:1: ( rule__AttrInstanceConfig__Group_2__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3581:2: rule__AttrInstanceConfig__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_2__1__Impl_in_rule__AttrInstanceConfig__Group_2__17171);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3587:1: rule__AttrInstanceConfig__Group_2__1__Impl : ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3591:1: ( ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3592:1: ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3592:1: ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3593:1: ( rule__AttrInstanceConfig__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getValueAssignment_2_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3594:1: ( rule__AttrInstanceConfig__ValueAssignment_2_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3594:2: rule__AttrInstanceConfig__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__ValueAssignment_2_1_in_rule__AttrInstanceConfig__Group_2__1__Impl7198);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3608:1: rule__AttrInstanceConfig__Group_3__0 : rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1 ;
    public final void rule__AttrInstanceConfig__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3612:1: ( rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3613:2: rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__0__Impl_in_rule__AttrInstanceConfig__Group_3__07232);
            rule__AttrInstanceConfig__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__1_in_rule__AttrInstanceConfig__Group_3__07235);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3620:1: rule__AttrInstanceConfig__Group_3__0__Impl : ( '{' ) ;
    public final void rule__AttrInstanceConfig__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3624:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3625:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3625:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3626:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getLeftCurlyBracketKeyword_3_0()); 
            }
            match(input,18,FOLLOW_18_in_rule__AttrInstanceConfig__Group_3__0__Impl7263); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3639:1: rule__AttrInstanceConfig__Group_3__1 : rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2 ;
    public final void rule__AttrInstanceConfig__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3643:1: ( rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3644:2: rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__1__Impl_in_rule__AttrInstanceConfig__Group_3__17294);
            rule__AttrInstanceConfig__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__2_in_rule__AttrInstanceConfig__Group_3__17297);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3651:1: rule__AttrInstanceConfig__Group_3__1__Impl : ( ( rule__AttrInstanceConfig__UnorderedGroup_3_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3655:1: ( ( ( rule__AttrInstanceConfig__UnorderedGroup_3_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3656:1: ( ( rule__AttrInstanceConfig__UnorderedGroup_3_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3656:1: ( ( rule__AttrInstanceConfig__UnorderedGroup_3_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3657:1: ( rule__AttrInstanceConfig__UnorderedGroup_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3658:1: ( rule__AttrInstanceConfig__UnorderedGroup_3_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3658:2: rule__AttrInstanceConfig__UnorderedGroup_3_1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__UnorderedGroup_3_1_in_rule__AttrInstanceConfig__Group_3__1__Impl7324);
            rule__AttrInstanceConfig__UnorderedGroup_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1()); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3668:1: rule__AttrInstanceConfig__Group_3__2 : rule__AttrInstanceConfig__Group_3__2__Impl ;
    public final void rule__AttrInstanceConfig__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3672:1: ( rule__AttrInstanceConfig__Group_3__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3673:2: rule__AttrInstanceConfig__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__2__Impl_in_rule__AttrInstanceConfig__Group_3__27354);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3679:1: rule__AttrInstanceConfig__Group_3__2__Impl : ( '}' ) ;
    public final void rule__AttrInstanceConfig__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3683:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3684:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3684:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3685:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getRightCurlyBracketKeyword_3_2()); 
            }
            match(input,19,FOLLOW_19_in_rule__AttrInstanceConfig__Group_3__2__Impl7382); if (state.failed) return ;
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


    // $ANTLR start "rule__AttrInstanceConfig__Group_3_1_0__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3704:1: rule__AttrInstanceConfig__Group_3_1_0__0 : rule__AttrInstanceConfig__Group_3_1_0__0__Impl rule__AttrInstanceConfig__Group_3_1_0__1 ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3708:1: ( rule__AttrInstanceConfig__Group_3_1_0__0__Impl rule__AttrInstanceConfig__Group_3_1_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3709:2: rule__AttrInstanceConfig__Group_3_1_0__0__Impl rule__AttrInstanceConfig__Group_3_1_0__1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__0__Impl_in_rule__AttrInstanceConfig__Group_3_1_0__07419);
            rule__AttrInstanceConfig__Group_3_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__1_in_rule__AttrInstanceConfig__Group_3_1_0__07422);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3716:1: rule__AttrInstanceConfig__Group_3_1_0__0__Impl : ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3720:1: ( ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3721:1: ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3721:1: ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3722:1: ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigAssignment_3_1_0_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3723:1: ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3723:2: rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0_in_rule__AttrInstanceConfig__Group_3_1_0__0__Impl7449);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3733:1: rule__AttrInstanceConfig__Group_3_1_0__1 : rule__AttrInstanceConfig__Group_3_1_0__1__Impl ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3737:1: ( rule__AttrInstanceConfig__Group_3_1_0__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3738:2: rule__AttrInstanceConfig__Group_3_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__1__Impl_in_rule__AttrInstanceConfig__Group_3_1_0__17479);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3744:1: rule__AttrInstanceConfig__Group_3_1_0__1__Impl : ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3748:1: ( ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3749:1: ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3749:1: ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3750:1: ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAlternatives_3_1_0_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3751:1: ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3751:2: rule__AttrInstanceConfig__Alternatives_3_1_0_1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Alternatives_3_1_0_1_in_rule__AttrInstanceConfig__Group_3_1_0__1__Impl7506);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3765:1: rule__RefPath__Group__0 : rule__RefPath__Group__0__Impl rule__RefPath__Group__1 ;
    public final void rule__RefPath__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3769:1: ( rule__RefPath__Group__0__Impl rule__RefPath__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3770:2: rule__RefPath__Group__0__Impl rule__RefPath__Group__1
            {
            pushFollow(FOLLOW_rule__RefPath__Group__0__Impl_in_rule__RefPath__Group__07540);
            rule__RefPath__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RefPath__Group__1_in_rule__RefPath__Group__07543);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3777:1: rule__RefPath__Group__0__Impl : ( ( rule__RefPath__RefsAssignment_0 ) ) ;
    public final void rule__RefPath__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3781:1: ( ( ( rule__RefPath__RefsAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3782:1: ( ( rule__RefPath__RefsAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3782:1: ( ( rule__RefPath__RefsAssignment_0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3783:1: ( rule__RefPath__RefsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsAssignment_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3784:1: ( rule__RefPath__RefsAssignment_0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3784:2: rule__RefPath__RefsAssignment_0
            {
            pushFollow(FOLLOW_rule__RefPath__RefsAssignment_0_in_rule__RefPath__Group__0__Impl7570);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3794:1: rule__RefPath__Group__1 : rule__RefPath__Group__1__Impl ;
    public final void rule__RefPath__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3798:1: ( rule__RefPath__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3799:2: rule__RefPath__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RefPath__Group__1__Impl_in_rule__RefPath__Group__17600);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3805:1: rule__RefPath__Group__1__Impl : ( ( rule__RefPath__Group_1__0 )* ) ;
    public final void rule__RefPath__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3809:1: ( ( ( rule__RefPath__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3810:1: ( ( rule__RefPath__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3810:1: ( ( rule__RefPath__Group_1__0 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3811:1: ( rule__RefPath__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getGroup_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3812:1: ( rule__RefPath__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==26) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3812:2: rule__RefPath__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__RefPath__Group_1__0_in_rule__RefPath__Group__1__Impl7627);
            	    rule__RefPath__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3826:1: rule__RefPath__Group_1__0 : rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1 ;
    public final void rule__RefPath__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3830:1: ( rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3831:2: rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1
            {
            pushFollow(FOLLOW_rule__RefPath__Group_1__0__Impl_in_rule__RefPath__Group_1__07662);
            rule__RefPath__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RefPath__Group_1__1_in_rule__RefPath__Group_1__07665);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3838:1: rule__RefPath__Group_1__0__Impl : ( '/' ) ;
    public final void rule__RefPath__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3842:1: ( ( '/' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3843:1: ( '/' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3843:1: ( '/' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3844:1: '/'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getSolidusKeyword_1_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__RefPath__Group_1__0__Impl7693); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3857:1: rule__RefPath__Group_1__1 : rule__RefPath__Group_1__1__Impl ;
    public final void rule__RefPath__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3861:1: ( rule__RefPath__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3862:2: rule__RefPath__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__RefPath__Group_1__1__Impl_in_rule__RefPath__Group_1__17724);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3868:1: rule__RefPath__Group_1__1__Impl : ( ( rule__RefPath__RefsAssignment_1_1 ) ) ;
    public final void rule__RefPath__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3872:1: ( ( ( rule__RefPath__RefsAssignment_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3873:1: ( ( rule__RefPath__RefsAssignment_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3873:1: ( ( rule__RefPath__RefsAssignment_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3874:1: ( rule__RefPath__RefsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsAssignment_1_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3875:1: ( rule__RefPath__RefsAssignment_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3875:2: rule__RefPath__RefsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RefPath__RefsAssignment_1_1_in_rule__RefPath__Group_1__1__Impl7751);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3889:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3893:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3894:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__07785);
            rule__Import__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__07788);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3901:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3905:1: ( ( 'import' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3906:1: ( 'import' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3906:1: ( 'import' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3907:1: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__Import__Group__0__Impl7816); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3920:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3924:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3925:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__17847);
            rule__Import__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Import__Group__2_in_rule__Import__Group__17850);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3932:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3936:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3937:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3937:1: ( ( rule__Import__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3938:1: ( rule__Import__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3939:1: ( rule__Import__Alternatives_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3939:2: rule__Import__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl7877);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3949:1: rule__Import__Group__2 : rule__Import__Group__2__Impl ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3953:1: ( rule__Import__Group__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3954:2: rule__Import__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__27907);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3960:1: rule__Import__Group__2__Impl : ( ( rule__Import__ImportURIAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3964:1: ( ( ( rule__Import__ImportURIAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3965:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3965:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3966:1: ( rule__Import__ImportURIAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportURIAssignment_2()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3967:1: ( rule__Import__ImportURIAssignment_2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3967:2: rule__Import__ImportURIAssignment_2
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl7934);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3983:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3987:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3988:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__07970);
            rule__Import__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__07973);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3995:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3999:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4000:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4000:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4001:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4002:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4002:2: rule__Import__ImportedNamespaceAssignment_1_0_0
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl8000);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4012:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4016:1: ( rule__Import__Group_1_0__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4017:2: rule__Import__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__18030);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4023:1: rule__Import__Group_1_0__1__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4027:1: ( ( 'from' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4028:1: ( 'from' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4028:1: ( 'from' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4029:1: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 
            }
            match(input,37,FOLLOW_37_in_rule__Import__Group_1_0__1__Impl8058); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4046:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4050:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4051:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__08093);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__08096);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4058:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4062:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4063:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4063:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4064:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl8123);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4075:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4079:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4080:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__18152);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4086:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4090:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4091:1: ( ( '.*' )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4091:1: ( ( '.*' )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4092:1: ( '.*' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4093:1: ( '.*' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==38) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4094:2: '.*'
                    {
                    match(input,38,FOLLOW_38_in_rule__ImportedFQN__Group__1__Impl8181); if (state.failed) return ;

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4109:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4113:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4114:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__08218);
            rule__FQN__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__08221);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4121:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4125:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4126:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4126:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4127:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl8248); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4138:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4142:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4143:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__18277);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4149:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4153:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4154:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4154:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4155:1: ( rule__FQN__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getGroup_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4156:1: ( rule__FQN__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==39) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4156:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl8304);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4170:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4174:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4175:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__08339);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__08342);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4182:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4186:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4187:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4187:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4188:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            }
            match(input,39,FOLLOW_39_in_rule__FQN__Group_1__0__Impl8370); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4201:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4205:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4206:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__18401);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4212:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4216:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4217:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4217:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4218:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl8428); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4233:1: rule__LiteralArray__Group__0 : rule__LiteralArray__Group__0__Impl rule__LiteralArray__Group__1 ;
    public final void rule__LiteralArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4237:1: ( rule__LiteralArray__Group__0__Impl rule__LiteralArray__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4238:2: rule__LiteralArray__Group__0__Impl rule__LiteralArray__Group__1
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group__0__Impl_in_rule__LiteralArray__Group__08461);
            rule__LiteralArray__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LiteralArray__Group__1_in_rule__LiteralArray__Group__08464);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4245:1: rule__LiteralArray__Group__0__Impl : ( ( rule__LiteralArray__LiteralsAssignment_0 ) ) ;
    public final void rule__LiteralArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4249:1: ( ( ( rule__LiteralArray__LiteralsAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4250:1: ( ( rule__LiteralArray__LiteralsAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4250:1: ( ( rule__LiteralArray__LiteralsAssignment_0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4251:1: ( rule__LiteralArray__LiteralsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4252:1: ( rule__LiteralArray__LiteralsAssignment_0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4252:2: rule__LiteralArray__LiteralsAssignment_0
            {
            pushFollow(FOLLOW_rule__LiteralArray__LiteralsAssignment_0_in_rule__LiteralArray__Group__0__Impl8491);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4262:1: rule__LiteralArray__Group__1 : rule__LiteralArray__Group__1__Impl ;
    public final void rule__LiteralArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4266:1: ( rule__LiteralArray__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4267:2: rule__LiteralArray__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group__1__Impl_in_rule__LiteralArray__Group__18521);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4273:1: rule__LiteralArray__Group__1__Impl : ( ( rule__LiteralArray__Group_1__0 )* ) ;
    public final void rule__LiteralArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4277:1: ( ( ( rule__LiteralArray__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4278:1: ( ( rule__LiteralArray__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4278:1: ( ( rule__LiteralArray__Group_1__0 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4279:1: ( rule__LiteralArray__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayAccess().getGroup_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4280:1: ( rule__LiteralArray__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==40) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4280:2: rule__LiteralArray__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__LiteralArray__Group_1__0_in_rule__LiteralArray__Group__1__Impl8548);
            	    rule__LiteralArray__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4294:1: rule__LiteralArray__Group_1__0 : rule__LiteralArray__Group_1__0__Impl rule__LiteralArray__Group_1__1 ;
    public final void rule__LiteralArray__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4298:1: ( rule__LiteralArray__Group_1__0__Impl rule__LiteralArray__Group_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4299:2: rule__LiteralArray__Group_1__0__Impl rule__LiteralArray__Group_1__1
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group_1__0__Impl_in_rule__LiteralArray__Group_1__08583);
            rule__LiteralArray__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LiteralArray__Group_1__1_in_rule__LiteralArray__Group_1__08586);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4306:1: rule__LiteralArray__Group_1__0__Impl : ( ',' ) ;
    public final void rule__LiteralArray__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4310:1: ( ( ',' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4311:1: ( ',' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4311:1: ( ',' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4312:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayAccess().getCommaKeyword_1_0()); 
            }
            match(input,40,FOLLOW_40_in_rule__LiteralArray__Group_1__0__Impl8614); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4325:1: rule__LiteralArray__Group_1__1 : rule__LiteralArray__Group_1__1__Impl ;
    public final void rule__LiteralArray__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4329:1: ( rule__LiteralArray__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4330:2: rule__LiteralArray__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group_1__1__Impl_in_rule__LiteralArray__Group_1__18645);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4336:1: rule__LiteralArray__Group_1__1__Impl : ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) ) ;
    public final void rule__LiteralArray__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4340:1: ( ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4341:1: ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4341:1: ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4342:1: ( rule__LiteralArray__LiteralsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_1_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4343:1: ( rule__LiteralArray__LiteralsAssignment_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4343:2: rule__LiteralArray__LiteralsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__LiteralArray__LiteralsAssignment_1_1_in_rule__LiteralArray__Group_1__1__Impl8672);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4357:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4361:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4362:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__08706);
            rule__BooleanLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__08709);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4369:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4373:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4374:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4374:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4375:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4376:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4378:1: 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4388:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4392:1: ( rule__BooleanLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4393:2: rule__BooleanLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__18767);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4399:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4403:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4404:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4404:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4405:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4406:1: ( rule__BooleanLiteral__Alternatives_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4406:2: rule__BooleanLiteral__Alternatives_1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl8794);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4420:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4424:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4425:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__08828);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__08831);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4432:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4436:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4437:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4437:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4438:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4439:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4441:1: 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4451:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4455:1: ( rule__RealLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4456:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__18889);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4462:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4466:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4467:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4467:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4468:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4469:1: ( rule__RealLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4469:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl8916);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4483:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4487:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4488:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__08950);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__08953);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4495:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4499:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4500:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4500:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4501:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4502:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4504:1: 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4514:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4518:1: ( rule__IntLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4519:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__19011);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4525:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4529:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4530:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4530:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4531:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4532:1: ( rule__IntLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4532:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl9038);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4546:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4550:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4551:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__09072);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__09075);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4558:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4562:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4563:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4563:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4564:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4565:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4567:1: 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4577:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4581:1: ( rule__StringLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4582:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__19133);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4588:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4592:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4593:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4593:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4594:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4595:1: ( rule__StringLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4595:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl9160);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4609:1: rule__SignedInteger__Group__0 : rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 ;
    public final void rule__SignedInteger__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4613:1: ( rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4614:2: rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__09194);
            rule__SignedInteger__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__09197);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4621:1: rule__SignedInteger__Group__0__Impl : ( ( rule__SignedInteger__Alternatives_0 )? ) ;
    public final void rule__SignedInteger__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4625:1: ( ( ( rule__SignedInteger__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4626:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4626:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4627:1: ( rule__SignedInteger__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignedIntegerAccess().getAlternatives_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4628:1: ( rule__SignedInteger__Alternatives_0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=15 && LA32_0<=16)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4628:2: rule__SignedInteger__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl9224);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4638:1: rule__SignedInteger__Group__1 : rule__SignedInteger__Group__1__Impl ;
    public final void rule__SignedInteger__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4642:1: ( rule__SignedInteger__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4643:2: rule__SignedInteger__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__19255);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4649:1: rule__SignedInteger__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__SignedInteger__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4653:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4654:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4654:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4655:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl9282); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4670:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4674:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4675:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__09315);
            rule__Decimal__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__09318);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4682:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4686:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4687:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4687:1: ( ( rule__Decimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4688:1: ( rule__Decimal__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4689:1: ( rule__Decimal__Alternatives_0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=15 && LA33_0<=16)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4689:2: rule__Decimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl9345);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4699:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4703:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4704:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__19376);
            rule__Decimal__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__19379);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4711:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4715:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4716:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4716:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4717:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl9406); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4728:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4732:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4733:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
            {
            pushFollow(FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__29435);
            rule__Decimal__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__29438);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4740:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4744:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4745:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4745:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4746:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            }
            match(input,39,FOLLOW_39_in_rule__Decimal__Group__2__Impl9466); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4759:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4763:1: ( rule__Decimal__Group__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4764:2: rule__Decimal__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__39497);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4770:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4774:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4775:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4775:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4776:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl9524); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4795:1: rule__DotDecimal__Group__0 : rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 ;
    public final void rule__DotDecimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4799:1: ( rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4800:2: rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__09561);
            rule__DotDecimal__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__09564);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4807:1: rule__DotDecimal__Group__0__Impl : ( ( rule__DotDecimal__Alternatives_0 )? ) ;
    public final void rule__DotDecimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4811:1: ( ( ( rule__DotDecimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4812:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4812:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4813:1: ( rule__DotDecimal__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDotDecimalAccess().getAlternatives_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4814:1: ( rule__DotDecimal__Alternatives_0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=15 && LA34_0<=16)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4814:2: rule__DotDecimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl9591);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4824:1: rule__DotDecimal__Group__1 : rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 ;
    public final void rule__DotDecimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4828:1: ( rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4829:2: rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__19622);
            rule__DotDecimal__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__19625);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4836:1: rule__DotDecimal__Group__1__Impl : ( '.' ) ;
    public final void rule__DotDecimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4840:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4841:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4841:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4842:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
            }
            match(input,39,FOLLOW_39_in_rule__DotDecimal__Group__1__Impl9653); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4855:1: rule__DotDecimal__Group__2 : rule__DotDecimal__Group__2__Impl ;
    public final void rule__DotDecimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4859:1: ( rule__DotDecimal__Group__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4860:2: rule__DotDecimal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__29684);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4866:1: rule__DotDecimal__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DotDecimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4870:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4871:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4871:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4872:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl9711); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4889:1: rule__DecimalDot__Group__0 : rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 ;
    public final void rule__DecimalDot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4893:1: ( rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4894:2: rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__09746);
            rule__DecimalDot__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__09749);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4901:1: rule__DecimalDot__Group__0__Impl : ( ( rule__DecimalDot__Alternatives_0 )? ) ;
    public final void rule__DecimalDot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4905:1: ( ( ( rule__DecimalDot__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4906:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4906:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4907:1: ( rule__DecimalDot__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalDotAccess().getAlternatives_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4908:1: ( rule__DecimalDot__Alternatives_0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=15 && LA35_0<=16)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4908:2: rule__DecimalDot__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl9776);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4918:1: rule__DecimalDot__Group__1 : rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 ;
    public final void rule__DecimalDot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4922:1: ( rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4923:2: rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__19807);
            rule__DecimalDot__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__19810);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4930:1: rule__DecimalDot__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalDot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4934:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4935:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4935:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4936:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl9837); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4947:1: rule__DecimalDot__Group__2 : rule__DecimalDot__Group__2__Impl ;
    public final void rule__DecimalDot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4951:1: ( rule__DecimalDot__Group__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4952:2: rule__DecimalDot__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__29866);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4958:1: rule__DecimalDot__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalDot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4962:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4963:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4963:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4964:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 
            }
            match(input,39,FOLLOW_39_in_rule__DecimalDot__Group__2__Impl9894); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4983:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4987:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4988:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__09931);
            rule__DecimalExp__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__09934);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4995:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4999:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5000:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5000:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5001:1: ( rule__DecimalExp__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5002:1: ( rule__DecimalExp__Alternatives_0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=15 && LA36_0<=16)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5002:2: rule__DecimalExp__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl9961);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5012:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5016:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5017:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__19992);
            rule__DecimalExp__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__19995);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5024:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5028:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5029:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5029:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5030:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl10022); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5041:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5045:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5046:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__210051);
            rule__DecimalExp__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__210054);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5053:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5057:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5058:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5058:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5059:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            }
            match(input,39,FOLLOW_39_in_rule__DecimalExp__Group__2__Impl10082); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5072:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5076:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5077:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__310113);
            rule__DecimalExp__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__310116);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5084:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5088:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5089:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5089:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5090:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl10143); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5101:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5 ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5105:1: ( rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5106:2: rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__410172);
            rule__DecimalExp__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalExp__Group__5_in_rule__DecimalExp__Group__410175);
            rule__DecimalExp__Group__5();

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5113:1: rule__DecimalExp__Group__4__Impl : ( RULE_ID ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5117:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5118:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5118:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5119:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getIDTerminalRuleCall_4()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DecimalExp__Group__4__Impl10202); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalExpAccess().getIDTerminalRuleCall_4()); 
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


    // $ANTLR start "rule__DecimalExp__Group__5"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5130:1: rule__DecimalExp__Group__5 : rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6 ;
    public final void rule__DecimalExp__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5134:1: ( rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5135:2: rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__5__Impl_in_rule__DecimalExp__Group__510231);
            rule__DecimalExp__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DecimalExp__Group__6_in_rule__DecimalExp__Group__510234);
            rule__DecimalExp__Group__6();

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
    // $ANTLR end "rule__DecimalExp__Group__5"


    // $ANTLR start "rule__DecimalExp__Group__5__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5142:1: rule__DecimalExp__Group__5__Impl : ( ( rule__DecimalExp__Alternatives_5 )? ) ;
    public final void rule__DecimalExp__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5146:1: ( ( ( rule__DecimalExp__Alternatives_5 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5147:1: ( ( rule__DecimalExp__Alternatives_5 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5147:1: ( ( rule__DecimalExp__Alternatives_5 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5148:1: ( rule__DecimalExp__Alternatives_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getAlternatives_5()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5149:1: ( rule__DecimalExp__Alternatives_5 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=15 && LA37_0<=16)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5149:2: rule__DecimalExp__Alternatives_5
                    {
                    pushFollow(FOLLOW_rule__DecimalExp__Alternatives_5_in_rule__DecimalExp__Group__5__Impl10261);
                    rule__DecimalExp__Alternatives_5();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalExpAccess().getAlternatives_5()); 
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
    // $ANTLR end "rule__DecimalExp__Group__5__Impl"


    // $ANTLR start "rule__DecimalExp__Group__6"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5159:1: rule__DecimalExp__Group__6 : rule__DecimalExp__Group__6__Impl ;
    public final void rule__DecimalExp__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5163:1: ( rule__DecimalExp__Group__6__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5164:2: rule__DecimalExp__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__6__Impl_in_rule__DecimalExp__Group__610292);
            rule__DecimalExp__Group__6__Impl();

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
    // $ANTLR end "rule__DecimalExp__Group__6"


    // $ANTLR start "rule__DecimalExp__Group__6__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5170:1: rule__DecimalExp__Group__6__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5174:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5175:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5175:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5176:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_6()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__6__Impl10319); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_6()); 
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
    // $ANTLR end "rule__DecimalExp__Group__6__Impl"


    // $ANTLR start "rule__DynamicConfig__UnorderedGroup_2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5202:1: rule__DynamicConfig__UnorderedGroup_2 : rule__DynamicConfig__UnorderedGroup_2__0 {...}?;
    public final void rule__DynamicConfig__UnorderedGroup_2() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2());
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5207:1: ( rule__DynamicConfig__UnorderedGroup_2__0 {...}?)
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5208:2: rule__DynamicConfig__UnorderedGroup_2__0 {...}?
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2__0_in_rule__DynamicConfig__UnorderedGroup_210363);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5219:1: rule__DynamicConfig__UnorderedGroup_2__Impl : ( ({...}? => ( ( ( rule__DynamicConfig__Group_2_0__0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) ) ;
    public final void rule__DynamicConfig__UnorderedGroup_2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5224:1: ( ( ({...}? => ( ( ( rule__DynamicConfig__Group_2_0__0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5225:3: ( ({...}? => ( ( ( rule__DynamicConfig__Group_2_0__0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5225:3: ( ({...}? => ( ( ( rule__DynamicConfig__Group_2_0__0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( LA38_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                alt38=1;
            }
            else if ( LA38_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5227:4: ({...}? => ( ( ( rule__DynamicConfig__Group_2_0__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5227:4: ({...}? => ( ( ( rule__DynamicConfig__Group_2_0__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5228:5: {...}? => ( ( ( rule__DynamicConfig__Group_2_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__DynamicConfig__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5228:110: ( ( ( rule__DynamicConfig__Group_2_0__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5229:6: ( ( rule__DynamicConfig__Group_2_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5235:6: ( ( rule__DynamicConfig__Group_2_0__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5237:7: ( rule__DynamicConfig__Group_2_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getGroup_2_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5238:7: ( rule__DynamicConfig__Group_2_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5238:8: rule__DynamicConfig__Group_2_0__0
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0__0_in_rule__DynamicConfig__UnorderedGroup_2__Impl10452);
                    rule__DynamicConfig__Group_2_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDynamicConfigAccess().getGroup_2_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5244:4: ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5244:4: ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5245:5: {...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__DynamicConfig__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5245:110: ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5246:6: ( ( rule__DynamicConfig__Group_2_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5252:6: ( ( rule__DynamicConfig__Group_2_1__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5254:7: ( rule__DynamicConfig__Group_2_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getGroup_2_1()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5255:7: ( rule__DynamicConfig__Group_2_1__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5255:8: rule__DynamicConfig__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__Group_2_1__0_in_rule__DynamicConfig__UnorderedGroup_2__Impl10543);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5270:1: rule__DynamicConfig__UnorderedGroup_2__0 : rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )? ;
    public final void rule__DynamicConfig__UnorderedGroup_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5274:1: ( rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5275:2: rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )?
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2__Impl_in_rule__DynamicConfig__UnorderedGroup_2__010602);
            rule__DynamicConfig__UnorderedGroup_2__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5276:2: ( rule__DynamicConfig__UnorderedGroup_2__1 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( LA39_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                alt39=1;
            }
            else if ( LA39_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5276:2: rule__DynamicConfig__UnorderedGroup_2__1
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2__1_in_rule__DynamicConfig__UnorderedGroup_2__010605);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5283:1: rule__DynamicConfig__UnorderedGroup_2__1 : rule__DynamicConfig__UnorderedGroup_2__Impl ;
    public final void rule__DynamicConfig__UnorderedGroup_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5287:1: ( rule__DynamicConfig__UnorderedGroup_2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5288:2: rule__DynamicConfig__UnorderedGroup_2__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2__Impl_in_rule__DynamicConfig__UnorderedGroup_2__110630);
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


    // $ANTLR start "rule__ActorInstanceConfig__UnorderedGroup"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5299:1: rule__ActorInstanceConfig__UnorderedGroup : rule__ActorInstanceConfig__UnorderedGroup__0 {...}?;
    public final void rule__ActorInstanceConfig__UnorderedGroup() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup());
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5304:1: ( rule__ActorInstanceConfig__UnorderedGroup__0 {...}?)
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5305:2: rule__ActorInstanceConfig__UnorderedGroup__0 {...}?
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__0_in_rule__ActorInstanceConfig__UnorderedGroup10658);
            rule__ActorInstanceConfig__UnorderedGroup__0();

            state._fsp--;
            if (state.failed) return ;
            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup()) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "rule__ActorInstanceConfig__UnorderedGroup", "getUnorderedGroupHelper().canLeave(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceConfig__UnorderedGroup"


    // $ANTLR start "rule__ActorInstanceConfig__UnorderedGroup__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5316:1: rule__ActorInstanceConfig__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) ) ) ) ;
    public final void rule__ActorInstanceConfig__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5321:1: ( ( ({...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5322:3: ( ({...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5322:3: ( ({...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( LA40_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0) ) {
                alt40=1;
            }
            else if ( (LA40_0==19||LA40_0==31) && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5324:4: ({...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5324:4: ({...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5325:5: {...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ActorInstanceConfig__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5325:114: ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5326:6: ( ( rule__ActorInstanceConfig__Group_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5332:6: ( ( rule__ActorInstanceConfig__Group_0__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5334:7: ( rule__ActorInstanceConfig__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getGroup_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5335:7: ( rule__ActorInstanceConfig__Group_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5335:8: rule__ActorInstanceConfig__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__0_in_rule__ActorInstanceConfig__UnorderedGroup__Impl10747);
                    rule__ActorInstanceConfig__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActorInstanceConfigAccess().getGroup_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5341:4: ({...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5341:4: ({...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5342:5: {...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ActorInstanceConfig__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5342:114: ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5343:6: ( ( rule__ActorInstanceConfig__Group_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5349:6: ( ( rule__ActorInstanceConfig__Group_1__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5351:7: ( rule__ActorInstanceConfig__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getGroup_1()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5352:7: ( rule__ActorInstanceConfig__Group_1__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5352:8: rule__ActorInstanceConfig__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_1__0_in_rule__ActorInstanceConfig__UnorderedGroup__Impl10838);
                    rule__ActorInstanceConfig__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActorInstanceConfigAccess().getGroup_1()); 
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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceConfig__UnorderedGroup__Impl"


    // $ANTLR start "rule__ActorInstanceConfig__UnorderedGroup__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5367:1: rule__ActorInstanceConfig__UnorderedGroup__0 : rule__ActorInstanceConfig__UnorderedGroup__Impl ( rule__ActorInstanceConfig__UnorderedGroup__1 )? ;
    public final void rule__ActorInstanceConfig__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5371:1: ( rule__ActorInstanceConfig__UnorderedGroup__Impl ( rule__ActorInstanceConfig__UnorderedGroup__1 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5372:2: rule__ActorInstanceConfig__UnorderedGroup__Impl ( rule__ActorInstanceConfig__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__Impl_in_rule__ActorInstanceConfig__UnorderedGroup__010897);
            rule__ActorInstanceConfig__UnorderedGroup__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5373:2: ( rule__ActorInstanceConfig__UnorderedGroup__1 )?
            int alt41=2;
            switch ( input.LA(1) ) {
                case 25:
                    {
                    int LA41_1 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0) ) {
                        alt41=1;
                    }
                    }
                    break;
                case 31:
                    {
                    int LA41_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1) ) {
                        alt41=1;
                    }
                    }
                    break;
                case 19:
                    {
                    int LA41_3 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1) ) {
                        alt41=1;
                    }
                    }
                    break;
            }

            switch (alt41) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5373:2: rule__ActorInstanceConfig__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__1_in_rule__ActorInstanceConfig__UnorderedGroup__010900);
                    rule__ActorInstanceConfig__UnorderedGroup__1();

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
    // $ANTLR end "rule__ActorInstanceConfig__UnorderedGroup__0"


    // $ANTLR start "rule__ActorInstanceConfig__UnorderedGroup__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5380:1: rule__ActorInstanceConfig__UnorderedGroup__1 : rule__ActorInstanceConfig__UnorderedGroup__Impl ;
    public final void rule__ActorInstanceConfig__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5384:1: ( rule__ActorInstanceConfig__UnorderedGroup__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5385:2: rule__ActorInstanceConfig__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__Impl_in_rule__ActorInstanceConfig__UnorderedGroup__110925);
            rule__ActorInstanceConfig__UnorderedGroup__Impl();

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
    // $ANTLR end "rule__ActorInstanceConfig__UnorderedGroup__1"


    // $ANTLR start "rule__ProtocolClassConfig__UnorderedGroup_3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5396:1: rule__ProtocolClassConfig__UnorderedGroup_3 : ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )? ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5401:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5402:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )?
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5402:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( LA42_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                alt42=1;
            }
            else if ( LA42_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5402:2: rule__ProtocolClassConfig__UnorderedGroup_3__0
                    {
                    pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__0_in_rule__ProtocolClassConfig__UnorderedGroup_310953);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5412:1: rule__ProtocolClassConfig__UnorderedGroup_3__Impl : ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) ) ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5417:1: ( ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5418:3: ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5418:3: ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( LA43_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                alt43=1;
            }
            else if ( LA43_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5420:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5420:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5421:5: {...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ProtocolClassConfig__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5421:116: ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5422:6: ( ( rule__ProtocolClassConfig__Group_3_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5428:6: ( ( rule__ProtocolClassConfig__Group_3_0__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5430:7: ( rule__ProtocolClassConfig__Group_3_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProtocolClassConfigAccess().getGroup_3_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5431:7: ( rule__ProtocolClassConfig__Group_3_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5431:8: rule__ProtocolClassConfig__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_0__0_in_rule__ProtocolClassConfig__UnorderedGroup_3__Impl11040);
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5437:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5437:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5438:5: {...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ProtocolClassConfig__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5438:116: ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5439:6: ( ( rule__ProtocolClassConfig__Group_3_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5445:6: ( ( rule__ProtocolClassConfig__Group_3_1__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5447:7: ( rule__ProtocolClassConfig__Group_3_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProtocolClassConfigAccess().getGroup_3_1()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5448:7: ( rule__ProtocolClassConfig__Group_3_1__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5448:8: rule__ProtocolClassConfig__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_1__0_in_rule__ProtocolClassConfig__UnorderedGroup_3__Impl11131);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5463:1: rule__ProtocolClassConfig__UnorderedGroup_3__0 : rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )? ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5467:1: ( rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5468:2: rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )?
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__Impl_in_rule__ProtocolClassConfig__UnorderedGroup_3__011190);
            rule__ProtocolClassConfig__UnorderedGroup_3__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5469:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( LA44_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                alt44=1;
            }
            else if ( LA44_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5469:2: rule__ProtocolClassConfig__UnorderedGroup_3__1
                    {
                    pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__1_in_rule__ProtocolClassConfig__UnorderedGroup_3__011193);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5476:1: rule__ProtocolClassConfig__UnorderedGroup_3__1 : rule__ProtocolClassConfig__UnorderedGroup_3__Impl ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5480:1: ( rule__ProtocolClassConfig__UnorderedGroup_3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5481:2: rule__ProtocolClassConfig__UnorderedGroup_3__Impl
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__Impl_in_rule__ProtocolClassConfig__UnorderedGroup_3__111218);
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


    // $ANTLR start "rule__AttrClassConfig__UnorderedGroup_3_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5492:1: rule__AttrClassConfig__UnorderedGroup_3_1 : ( rule__AttrClassConfig__UnorderedGroup_3_1__0 )? ;
    public final void rule__AttrClassConfig__UnorderedGroup_3_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1());
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5497:1: ( ( rule__AttrClassConfig__UnorderedGroup_3_1__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5498:2: ( rule__AttrClassConfig__UnorderedGroup_3_1__0 )?
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5498:2: ( rule__AttrClassConfig__UnorderedGroup_3_1__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( LA45_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                alt45=1;
            }
            else if ( LA45_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5498:2: rule__AttrClassConfig__UnorderedGroup_3_1__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__0_in_rule__AttrClassConfig__UnorderedGroup_3_111246);
                    rule__AttrClassConfig__UnorderedGroup_3_1__0();

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

            	getUnorderedGroupHelper().leave(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrClassConfig__UnorderedGroup_3_1"


    // $ANTLR start "rule__AttrClassConfig__UnorderedGroup_3_1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5508:1: rule__AttrClassConfig__UnorderedGroup_3_1__Impl : ( ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) ) ) ) ;
    public final void rule__AttrClassConfig__UnorderedGroup_3_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5513:1: ( ( ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5514:3: ( ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5514:3: ( ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( LA46_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                alt46=1;
            }
            else if ( LA46_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1) ) {
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5516:4: ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5516:4: ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5517:5: {...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__AttrClassConfig__UnorderedGroup_3_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5517:114: ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5518:6: ( ( rule__AttrClassConfig__Group_3_1_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5524:6: ( ( rule__AttrClassConfig__Group_3_1_0__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5526:7: ( rule__AttrClassConfig__Group_3_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5527:7: ( rule__AttrClassConfig__Group_3_1_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5527:8: rule__AttrClassConfig__Group_3_1_0__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__0_in_rule__AttrClassConfig__UnorderedGroup_3_1__Impl11333);
                    rule__AttrClassConfig__Group_3_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5533:4: ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5533:4: ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5534:5: {...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__AttrClassConfig__UnorderedGroup_3_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5534:114: ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5535:6: ( ( rule__AttrClassConfig__Group_3_1_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5541:6: ( ( rule__AttrClassConfig__Group_3_1_1__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5543:7: ( rule__AttrClassConfig__Group_3_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_1()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5544:7: ( rule__AttrClassConfig__Group_3_1_1__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5544:8: rule__AttrClassConfig__Group_3_1_1__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__0_in_rule__AttrClassConfig__UnorderedGroup_3_1__Impl11424);
                    rule__AttrClassConfig__Group_3_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_1()); 
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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrClassConfig__UnorderedGroup_3_1__Impl"


    // $ANTLR start "rule__AttrClassConfig__UnorderedGroup_3_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5559:1: rule__AttrClassConfig__UnorderedGroup_3_1__0 : rule__AttrClassConfig__UnorderedGroup_3_1__Impl ( rule__AttrClassConfig__UnorderedGroup_3_1__1 )? ;
    public final void rule__AttrClassConfig__UnorderedGroup_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5563:1: ( rule__AttrClassConfig__UnorderedGroup_3_1__Impl ( rule__AttrClassConfig__UnorderedGroup_3_1__1 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5564:2: rule__AttrClassConfig__UnorderedGroup_3_1__Impl ( rule__AttrClassConfig__UnorderedGroup_3_1__1 )?
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__Impl_in_rule__AttrClassConfig__UnorderedGroup_3_1__011483);
            rule__AttrClassConfig__UnorderedGroup_3_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5565:2: ( rule__AttrClassConfig__UnorderedGroup_3_1__1 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( LA47_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                alt47=1;
            }
            else if ( LA47_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5565:2: rule__AttrClassConfig__UnorderedGroup_3_1__1
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__1_in_rule__AttrClassConfig__UnorderedGroup_3_1__011486);
                    rule__AttrClassConfig__UnorderedGroup_3_1__1();

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
    // $ANTLR end "rule__AttrClassConfig__UnorderedGroup_3_1__0"


    // $ANTLR start "rule__AttrClassConfig__UnorderedGroup_3_1__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5572:1: rule__AttrClassConfig__UnorderedGroup_3_1__1 : rule__AttrClassConfig__UnorderedGroup_3_1__Impl ;
    public final void rule__AttrClassConfig__UnorderedGroup_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5576:1: ( rule__AttrClassConfig__UnorderedGroup_3_1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5577:2: rule__AttrClassConfig__UnorderedGroup_3_1__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__Impl_in_rule__AttrClassConfig__UnorderedGroup_3_1__111511);
            rule__AttrClassConfig__UnorderedGroup_3_1__Impl();

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
    // $ANTLR end "rule__AttrClassConfig__UnorderedGroup_3_1__1"


    // $ANTLR start "rule__AttrInstanceConfig__UnorderedGroup_3_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5588:1: rule__AttrInstanceConfig__UnorderedGroup_3_1 : ( rule__AttrInstanceConfig__UnorderedGroup_3_1__0 )? ;
    public final void rule__AttrInstanceConfig__UnorderedGroup_3_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1());
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5593:1: ( ( rule__AttrInstanceConfig__UnorderedGroup_3_1__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5594:2: ( rule__AttrInstanceConfig__UnorderedGroup_3_1__0 )?
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5594:2: ( rule__AttrInstanceConfig__UnorderedGroup_3_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( LA48_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                alt48=1;
            }
            else if ( LA48_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1(), 1) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5594:2: rule__AttrInstanceConfig__UnorderedGroup_3_1__0
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__UnorderedGroup_3_1__0_in_rule__AttrInstanceConfig__UnorderedGroup_3_111539);
                    rule__AttrInstanceConfig__UnorderedGroup_3_1__0();

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

            	getUnorderedGroupHelper().leave(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrInstanceConfig__UnorderedGroup_3_1"


    // $ANTLR start "rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5604:1: rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl : ( ({...}? => ( ( ( rule__AttrInstanceConfig__Group_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 ) ) ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) ) ) ) ) ;
    public final void rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5609:1: ( ( ({...}? => ( ( ( rule__AttrInstanceConfig__Group_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 ) ) ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) ) ) ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5610:3: ( ({...}? => ( ( ( rule__AttrInstanceConfig__Group_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 ) ) ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5610:3: ( ({...}? => ( ( ( rule__AttrInstanceConfig__Group_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 ) ) ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) ) ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( LA50_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                alt50=1;
            }
            else if ( LA50_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1(), 1) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5612:4: ({...}? => ( ( ( rule__AttrInstanceConfig__Group_3_1_0__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5612:4: ({...}? => ( ( ( rule__AttrInstanceConfig__Group_3_1_0__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5613:5: {...}? => ( ( ( rule__AttrInstanceConfig__Group_3_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1(), 0)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5613:117: ( ( ( rule__AttrInstanceConfig__Group_3_1_0__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5614:6: ( ( rule__AttrInstanceConfig__Group_3_1_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1(), 0);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5620:6: ( ( rule__AttrInstanceConfig__Group_3_1_0__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5622:7: ( rule__AttrInstanceConfig__Group_3_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1_0()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5623:7: ( rule__AttrInstanceConfig__Group_3_1_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5623:8: rule__AttrInstanceConfig__Group_3_1_0__0
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__0_in_rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl11626);
                    rule__AttrInstanceConfig__Group_3_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5629:4: ({...}? => ( ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 ) ) ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5629:4: ({...}? => ( ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 ) ) ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5630:5: {...}? => ( ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 ) ) ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1(), 1)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5630:117: ( ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 ) ) ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5631:6: ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 ) ) ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1(), 1);
                    selected = true;
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5637:6: ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 ) ) ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5638:6: ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 ) ) ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5638:6: ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5639:7: ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttrInstanceConfigAccess().getAttributesAssignment_3_1_1()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5640:7: ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5640:8: rule__AttrInstanceConfig__AttributesAssignment_3_1_1
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__AttributesAssignment_3_1_1_in_rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl11718);
                    rule__AttrInstanceConfig__AttributesAssignment_3_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttrInstanceConfigAccess().getAttributesAssignment_3_1_1()); 
                    }

                    }

                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5643:6: ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5644:7: ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttrInstanceConfigAccess().getAttributesAssignment_3_1_1()); 
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5645:7: ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==32) ) {
                            int LA49_2 = input.LA(2);

                            if ( (LA49_2==RULE_ID) ) {
                                int LA49_3 = input.LA(3);

                                if ( (synpred1_InternalConfig()) ) {
                                    alt49=1;
                                }


                            }


                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5645:8: ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )=> rule__AttrInstanceConfig__AttributesAssignment_3_1_1
                    	    {
                    	    pushFollow(FOLLOW_rule__AttrInstanceConfig__AttributesAssignment_3_1_1_in_rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl11762);
                    	    rule__AttrInstanceConfig__AttributesAssignment_3_1_1();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttrInstanceConfigAccess().getAttributesAssignment_3_1_1()); 
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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__UnorderedGroup_3_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5660:1: rule__AttrInstanceConfig__UnorderedGroup_3_1__0 : rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl ( rule__AttrInstanceConfig__UnorderedGroup_3_1__1 )? ;
    public final void rule__AttrInstanceConfig__UnorderedGroup_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5664:1: ( rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl ( rule__AttrInstanceConfig__UnorderedGroup_3_1__1 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5665:2: rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl ( rule__AttrInstanceConfig__UnorderedGroup_3_1__1 )?
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl_in_rule__AttrInstanceConfig__UnorderedGroup_3_1__011828);
            rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5666:2: ( rule__AttrInstanceConfig__UnorderedGroup_3_1__1 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( LA51_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                alt51=1;
            }
            else if ( LA51_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrInstanceConfigAccess().getUnorderedGroup_3_1(), 1) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5666:2: rule__AttrInstanceConfig__UnorderedGroup_3_1__1
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__UnorderedGroup_3_1__1_in_rule__AttrInstanceConfig__UnorderedGroup_3_1__011831);
                    rule__AttrInstanceConfig__UnorderedGroup_3_1__1();

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
    // $ANTLR end "rule__AttrInstanceConfig__UnorderedGroup_3_1__0"


    // $ANTLR start "rule__AttrInstanceConfig__UnorderedGroup_3_1__1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5673:1: rule__AttrInstanceConfig__UnorderedGroup_3_1__1 : rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl ;
    public final void rule__AttrInstanceConfig__UnorderedGroup_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5677:1: ( rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5678:2: rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl_in_rule__AttrInstanceConfig__UnorderedGroup_3_1__111856);
            rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl();

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
    // $ANTLR end "rule__AttrInstanceConfig__UnorderedGroup_3_1__1"


    // $ANTLR start "rule__ConfigModel__ImportsAssignment_0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5689:1: rule__ConfigModel__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__ConfigModel__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5693:1: ( ( ruleImport ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5694:1: ( ruleImport )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5694:1: ( ruleImport )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5695:1: ruleImport
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getImportsImportParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleImport_in_rule__ConfigModel__ImportsAssignment_011888);
            ruleImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getImportsImportParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__ConfigModel__ImportsAssignment_0"


    // $ANTLR start "rule__ConfigModel__ConfigElementsAssignment_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5704:1: rule__ConfigModel__ConfigElementsAssignment_1 : ( ruleConfigElement ) ;
    public final void rule__ConfigModel__ConfigElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5708:1: ( ( ruleConfigElement ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5709:1: ( ruleConfigElement )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5709:1: ( ruleConfigElement )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5710:1: ruleConfigElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getConfigElementsConfigElementParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleConfigElement_in_rule__ConfigModel__ConfigElementsAssignment_111919);
            ruleConfigElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelAccess().getConfigElementsConfigElementParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__ConfigModel__ConfigElementsAssignment_1"


    // $ANTLR start "rule__SubSystemConfig__SubSystemAssignment_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5719:1: rule__SubSystemConfig__SubSystemAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemConfig__SubSystemAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5723:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5724:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5724:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5725:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemClassCrossReference_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5726:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5727:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemClassIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubSystemConfig__SubSystemAssignment_111954); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5738:1: rule__SubSystemConfig__DynConfigAssignment_3 : ( ruleDynamicConfig ) ;
    public final void rule__SubSystemConfig__DynConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5742:1: ( ( ruleDynamicConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5743:1: ( ruleDynamicConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5743:1: ( ruleDynamicConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5744:1: ruleDynamicConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getDynConfigDynamicConfigParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleDynamicConfig_in_rule__SubSystemConfig__DynConfigAssignment_311989);
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


    // $ANTLR start "rule__DynamicConfig__SourceAssignment_2_0_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5753:1: rule__DynamicConfig__SourceAssignment_2_0_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__SourceAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5757:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5758:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5758:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5759:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getSourceSTRINGTerminalRuleCall_2_0_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DynamicConfig__SourceAssignment_2_0_112020); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getSourceSTRINGTerminalRuleCall_2_0_1_0()); 
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
    // $ANTLR end "rule__DynamicConfig__SourceAssignment_2_0_1"


    // $ANTLR start "rule__DynamicConfig__FilePathAssignment_2_0_2_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5768:1: rule__DynamicConfig__FilePathAssignment_2_0_2_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__FilePathAssignment_2_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5772:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5773:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5773:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5774:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getFilePathSTRINGTerminalRuleCall_2_0_2_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DynamicConfig__FilePathAssignment_2_0_2_112051); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getFilePathSTRINGTerminalRuleCall_2_0_2_1_0()); 
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
    // $ANTLR end "rule__DynamicConfig__FilePathAssignment_2_0_2_1"


    // $ANTLR start "rule__DynamicConfig__PollingAssignment_2_1_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5783:1: rule__DynamicConfig__PollingAssignment_2_1_1 : ( RULE_INT ) ;
    public final void rule__DynamicConfig__PollingAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5787:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5788:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5788:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5789:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getPollingINTTerminalRuleCall_2_1_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DynamicConfig__PollingAssignment_2_1_112082); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5798:1: rule__ActorClassConfig__ActorAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ActorClassConfig__ActorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5802:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5803:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5803:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5804:1: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorActorClassCrossReference_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5805:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5806:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorActorClassFQNParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_ruleFQN_in_rule__ActorClassConfig__ActorAssignment_112117);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5817:1: rule__ActorClassConfig__AttributesAssignment_3 : ( ruleAttrClassConfig ) ;
    public final void rule__ActorClassConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5821:1: ( ( ruleAttrClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5822:1: ( ruleAttrClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5822:1: ( ruleAttrClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5823:1: ruleAttrClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleAttrClassConfig_in_rule__ActorClassConfig__AttributesAssignment_312152);
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


    // $ANTLR start "rule__ActorInstanceConfig__RootAssignment_0_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5832:1: rule__ActorInstanceConfig__RootAssignment_0_1 : ( ( ruleFQN ) ) ;
    public final void rule__ActorInstanceConfig__RootAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5836:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5837:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5837:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5838:1: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRootSubSystemClassCrossReference_0_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5839:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5840:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRootSubSystemClassFQNParserRuleCall_0_1_0_1()); 
            }
            pushFollow(FOLLOW_ruleFQN_in_rule__ActorInstanceConfig__RootAssignment_0_112187);
            ruleFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getRootSubSystemClassFQNParserRuleCall_0_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getRootSubSystemClassCrossReference_0_1_0()); 
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
    // $ANTLR end "rule__ActorInstanceConfig__RootAssignment_0_1"


    // $ANTLR start "rule__ActorInstanceConfig__PathAssignment_0_3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5851:1: rule__ActorInstanceConfig__PathAssignment_0_3 : ( ruleRefPath ) ;
    public final void rule__ActorInstanceConfig__PathAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5855:1: ( ( ruleRefPath ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5856:1: ( ruleRefPath )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5856:1: ( ruleRefPath )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5857:1: ruleRefPath
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getPathRefPathParserRuleCall_0_3_0()); 
            }
            pushFollow(FOLLOW_ruleRefPath_in_rule__ActorInstanceConfig__PathAssignment_0_312222);
            ruleRefPath();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getPathRefPathParserRuleCall_0_3_0()); 
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
    // $ANTLR end "rule__ActorInstanceConfig__PathAssignment_0_3"


    // $ANTLR start "rule__ActorInstanceConfig__AttributesAssignment_0_5"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5866:1: rule__ActorInstanceConfig__AttributesAssignment_0_5 : ( ruleAttrInstanceConfig ) ;
    public final void rule__ActorInstanceConfig__AttributesAssignment_0_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5870:1: ( ( ruleAttrInstanceConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5871:1: ( ruleAttrInstanceConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5871:1: ( ruleAttrInstanceConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5872:1: ruleAttrInstanceConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_0_5_0()); 
            }
            pushFollow(FOLLOW_ruleAttrInstanceConfig_in_rule__ActorInstanceConfig__AttributesAssignment_0_512253);
            ruleAttrInstanceConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_0_5_0()); 
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
    // $ANTLR end "rule__ActorInstanceConfig__AttributesAssignment_0_5"


    // $ANTLR start "rule__ActorInstanceConfig__PortsAssignment_1_0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5881:1: rule__ActorInstanceConfig__PortsAssignment_1_0 : ( rulePortInstanceConfig ) ;
    public final void rule__ActorInstanceConfig__PortsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5885:1: ( ( rulePortInstanceConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5886:1: ( rulePortInstanceConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5886:1: ( rulePortInstanceConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5887:1: rulePortInstanceConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getPortsPortInstanceConfigParserRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_rulePortInstanceConfig_in_rule__ActorInstanceConfig__PortsAssignment_1_012284);
            rulePortInstanceConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getPortsPortInstanceConfigParserRuleCall_1_0_0()); 
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
    // $ANTLR end "rule__ActorInstanceConfig__PortsAssignment_1_0"


    // $ANTLR start "rule__ProtocolClassConfig__ProtocolAssignment_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5896:1: rule__ProtocolClassConfig__ProtocolAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ProtocolClassConfig__ProtocolAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5900:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5901:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5901:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5902:1: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassCrossReference_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5903:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5904:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassFQNParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_ruleFQN_in_rule__ProtocolClassConfig__ProtocolAssignment_112319);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5915:1: rule__ProtocolClassConfig__RegularAssignment_3_0_1 : ( rulePortClassConfig ) ;
    public final void rule__ProtocolClassConfig__RegularAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5919:1: ( ( rulePortClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5920:1: ( rulePortClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5920:1: ( rulePortClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5921:1: rulePortClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getRegularPortClassConfigParserRuleCall_3_0_1_0()); 
            }
            pushFollow(FOLLOW_rulePortClassConfig_in_rule__ProtocolClassConfig__RegularAssignment_3_0_112354);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5930:1: rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 : ( rulePortClassConfig ) ;
    public final void rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5934:1: ( ( rulePortClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5935:1: ( rulePortClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5935:1: ( rulePortClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5936:1: rulePortClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getConjugatedPortClassConfigParserRuleCall_3_1_1_0()); 
            }
            pushFollow(FOLLOW_rulePortClassConfig_in_rule__ProtocolClassConfig__ConjugatedAssignment_3_1_112385);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5945:1: rule__PortClassConfig__AttributesAssignment_3 : ( ruleAttrClassConfig ) ;
    public final void rule__PortClassConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5949:1: ( ( ruleAttrClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5950:1: ( ruleAttrClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5950:1: ( ruleAttrClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5951:1: ruleAttrClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleAttrClassConfig_in_rule__PortClassConfig__AttributesAssignment_312416);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5960:1: rule__PortInstanceConfig__ItemAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PortInstanceConfig__ItemAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5964:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5965:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5965:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5966:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemCrossReference_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5967:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5968:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PortInstanceConfig__ItemAssignment_112451); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5979:1: rule__PortInstanceConfig__AttributesAssignment_3 : ( ruleAttrInstanceConfig ) ;
    public final void rule__PortInstanceConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5983:1: ( ( ruleAttrInstanceConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5984:1: ( ruleAttrInstanceConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5984:1: ( ruleAttrInstanceConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5985:1: ruleAttrInstanceConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleAttrInstanceConfig_in_rule__PortInstanceConfig__AttributesAssignment_312486);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5994:1: rule__AttrClassConfig__AttributeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AttrClassConfig__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5998:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5999:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5999:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6000:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6001:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6002:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AttrClassConfig__AttributeAssignment_112521); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6013:1: rule__AttrClassConfig__ValueAssignment_2_1 : ( ruleLiteralArray ) ;
    public final void rule__AttrClassConfig__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6017:1: ( ( ruleLiteralArray ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6018:1: ( ruleLiteralArray )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6018:1: ( ruleLiteralArray )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6019:1: ruleLiteralArray
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleLiteralArray_in_rule__AttrClassConfig__ValueAssignment_2_112556);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6028:1: rule__AttrClassConfig__MinAssignment_3_1_0_2 : ( ruleNumberLiteral ) ;
    public final void rule__AttrClassConfig__MinAssignment_3_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6032:1: ( ( ruleNumberLiteral ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6033:1: ( ruleNumberLiteral )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6033:1: ( ruleNumberLiteral )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6034:1: ruleNumberLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMinNumberLiteralParserRuleCall_3_1_0_2_0()); 
            }
            pushFollow(FOLLOW_ruleNumberLiteral_in_rule__AttrClassConfig__MinAssignment_3_1_0_212587);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6043:1: rule__AttrClassConfig__MaxAssignment_3_1_1_2 : ( ruleNumberLiteral ) ;
    public final void rule__AttrClassConfig__MaxAssignment_3_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6047:1: ( ( ruleNumberLiteral ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6048:1: ( ruleNumberLiteral )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6048:1: ( ruleNumberLiteral )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6049:1: ruleNumberLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMaxNumberLiteralParserRuleCall_3_1_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleNumberLiteral_in_rule__AttrClassConfig__MaxAssignment_3_1_1_212618);
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


    // $ANTLR start "rule__AttrClassConfig__AttributesAssignment_3_2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6058:1: rule__AttrClassConfig__AttributesAssignment_3_2 : ( ruleAttrClassConfig ) ;
    public final void rule__AttrClassConfig__AttributesAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6062:1: ( ( ruleAttrClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6063:1: ( ruleAttrClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6063:1: ( ruleAttrClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6064:1: ruleAttrClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_2_0()); 
            }
            pushFollow(FOLLOW_ruleAttrClassConfig_in_rule__AttrClassConfig__AttributesAssignment_3_212649);
            ruleAttrClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_2_0()); 
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
    // $ANTLR end "rule__AttrClassConfig__AttributesAssignment_3_2"


    // $ANTLR start "rule__AttrInstanceConfig__AttributeAssignment_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6073:1: rule__AttrInstanceConfig__AttributeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AttrInstanceConfig__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6077:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6078:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6078:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6079:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6080:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6081:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AttrInstanceConfig__AttributeAssignment_112684); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6092:1: rule__AttrInstanceConfig__ValueAssignment_2_1 : ( ruleLiteralArray ) ;
    public final void rule__AttrInstanceConfig__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6096:1: ( ( ruleLiteralArray ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6097:1: ( ruleLiteralArray )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6097:1: ( ruleLiteralArray )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6098:1: ruleLiteralArray
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleLiteralArray_in_rule__AttrInstanceConfig__ValueAssignment_2_112719);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6107:1: rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 : ( ( 'dynamic configuration' ) ) ;
    public final void rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6111:1: ( ( ( 'dynamic configuration' ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6112:1: ( ( 'dynamic configuration' ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6112:1: ( ( 'dynamic configuration' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6113:1: ( 'dynamic configuration' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6114:1: ( 'dynamic configuration' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6115:1: 'dynamic configuration'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0_0()); 
            }
            match(input,20,FOLLOW_20_in_rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_012755); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6130:1: rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 : ( ( 'read-only' ) ) ;
    public final void rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6134:1: ( ( ( 'read-only' ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6135:1: ( ( 'read-only' ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6135:1: ( ( 'read-only' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6136:1: ( 'read-only' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadOnlyKeyword_3_1_0_1_0_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6137:1: ( 'read-only' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6138:1: 'read-only'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadOnlyKeyword_3_1_0_1_0_0()); 
            }
            match(input,41,FOLLOW_41_in_rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_012799); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadOnlyKeyword_3_1_0_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadOnlyKeyword_3_1_0_1_0_0()); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6153:1: rule__AttrInstanceConfig__AttributesAssignment_3_1_1 : ( ruleAttrInstanceConfig ) ;
    public final void rule__AttrInstanceConfig__AttributesAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6157:1: ( ( ruleAttrInstanceConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6158:1: ( ruleAttrInstanceConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6158:1: ( ruleAttrInstanceConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6159:1: ruleAttrInstanceConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleAttrInstanceConfig_in_rule__AttrInstanceConfig__AttributesAssignment_3_1_112838);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6168:1: rule__RefPath__RefsAssignment_0 : ( RULE_ID ) ;
    public final void rule__RefPath__RefsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6172:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6173:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6173:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6174:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_012869); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6183:1: rule__RefPath__RefsAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__RefPath__RefsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6187:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6188:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6188:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6189:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_1_112900); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6198:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6202:1: ( ( ruleImportedFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6203:1: ( ruleImportedFQN )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6203:1: ( ruleImportedFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6204:1: ruleImportedFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
            }
            pushFollow(FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_012931);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6213:1: rule__Import__ImportURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6217:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6218:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6218:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6219:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_212962); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6228:1: rule__LiteralArray__LiteralsAssignment_0 : ( ruleLiteral ) ;
    public final void rule__LiteralArray__LiteralsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6232:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6233:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6233:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6234:1: ruleLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_012993);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6243:1: rule__LiteralArray__LiteralsAssignment_1_1 : ( ruleLiteral ) ;
    public final void rule__LiteralArray__LiteralsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6247:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6248:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6248:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6249:1: ruleLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_1_113024);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6258:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6262:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6263:1: ( ( 'true' ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6263:1: ( ( 'true' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6264:1: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            }
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6265:1: ( 'true' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6266:1: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            }
            match(input,42,FOLLOW_42_in_rule__BooleanLiteral__IsTrueAssignment_1_113060); if (state.failed) return ;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6281:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6285:1: ( ( ruleReal ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6286:1: ( ruleReal )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6286:1: ( ruleReal )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6287:1: ruleReal
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_113099);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6296:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6300:1: ( ( ruleInteger ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6301:1: ( ruleInteger )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6301:1: ( ruleInteger )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6302:1: ruleInteger
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_113130);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6311:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6315:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6316:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6316:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6317:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_113161); if (state.failed) return ;
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
        // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5645:8: ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )
        // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5645:9: rule__AttrInstanceConfig__AttributesAssignment_3_1_1
        {
        pushFollow(FOLLOW_rule__AttrInstanceConfig__AttributesAssignment_3_1_1_in_synpred1_InternalConfig11759);
        rule__AttrInstanceConfig__AttributesAssignment_3_1_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalConfig

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


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\12\uffff";
    static final String DFA9_eofS =
        "\5\uffff\1\6\1\uffff\1\10\2\uffff";
    static final String DFA9_minS =
        "\3\6\1\47\1\uffff\1\6\1\uffff\1\5\2\uffff";
    static final String DFA9_maxS =
        "\4\47\1\uffff\1\50\1\uffff\1\50\2\uffff";
    static final String DFA9_acceptS =
        "\4\uffff\1\2\1\uffff\1\3\1\uffff\1\1\1\4";
    static final String DFA9_specialS =
        "\12\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\3\10\uffff\1\1\1\2\26\uffff\1\4",
            "\1\3\40\uffff\1\4",
            "\1\3\40\uffff\1\4",
            "\1\5",
            "",
            "\1\7\12\uffff\4\6\3\uffff\2\6\1\uffff\1\6\3\uffff\2\6\1\uffff"+
            "\2\6\4\uffff\1\6",
            "",
            "\1\11\13\uffff\4\10\3\uffff\2\10\1\uffff\1\10\3\uffff\2\10"+
            "\1\uffff\2\10\4\uffff\1\10",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1155:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );";
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
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup_in_ruleActorInstanceConfig394 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0_in_rule__AttrInstanceConfig__Alternatives_3_1_0_12009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__AttrInstanceConfig__Alternatives_3_1_0_12028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_12062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Import__Alternatives_12081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives2115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives2132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives2149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__BooleanLiteral__Alternatives_12182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_12201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives2234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives2283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives2300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__SignedInteger__Alternatives_02333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__SignedInteger__Alternatives_02353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_rule__Real__Alternatives2387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives2404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives2438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Decimal__Alternatives_02471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Decimal__Alternatives_02491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DotDecimal__Alternatives_02526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DotDecimal__Alternatives_02546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalDot__Alternatives_02581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalDot__Alternatives_02601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalExp__Alternatives_02636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalExp__Alternatives_02656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalExp__Alternatives_52691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalExp__Alternatives_52711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__0__Impl_in_rule__ConfigModel__Group__02743 = new BitSet(new long[]{0x000000008B0A0000L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__1_in_rule__ConfigModel__Group__02746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__ImportsAssignment_0_in_rule__ConfigModel__Group__0__Impl2773 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__1__Impl_in_rule__ConfigModel__Group__12804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__ConfigElementsAssignment_1_in_rule__ConfigModel__Group__1__Impl2831 = new BitSet(new long[]{0x000000008B0A0002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__0__Impl_in_rule__SubSystemConfig__Group__02866 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__1_in_rule__SubSystemConfig__Group__02869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__SubSystemConfig__Group__0__Impl2897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__1__Impl_in_rule__SubSystemConfig__Group__12928 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__2_in_rule__SubSystemConfig__Group__12931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__SubSystemAssignment_1_in_rule__SubSystemConfig__Group__1__Impl2958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__2__Impl_in_rule__SubSystemConfig__Group__22988 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__3_in_rule__SubSystemConfig__Group__22991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__SubSystemConfig__Group__2__Impl3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__3__Impl_in_rule__SubSystemConfig__Group__33050 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__4_in_rule__SubSystemConfig__Group__33053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__DynConfigAssignment_3_in_rule__SubSystemConfig__Group__3__Impl3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__4__Impl_in_rule__SubSystemConfig__Group__43110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__SubSystemConfig__Group__4__Impl3138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__0__Impl_in_rule__DynamicConfig__Group__03179 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__1_in_rule__DynamicConfig__Group__03182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__DynamicConfig__Group__0__Impl3210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__1__Impl_in_rule__DynamicConfig__Group__13241 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__2_in_rule__DynamicConfig__Group__13244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__DynamicConfig__Group__1__Impl3272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__2__Impl_in_rule__DynamicConfig__Group__23303 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__3_in_rule__DynamicConfig__Group__23306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2_in_rule__DynamicConfig__Group__2__Impl3333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__3__Impl_in_rule__DynamicConfig__Group__33363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__DynamicConfig__Group__3__Impl3391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0__0__Impl_in_rule__DynamicConfig__Group_2_0__03430 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0__1_in_rule__DynamicConfig__Group_2_0__03433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DynamicConfig__Group_2_0__0__Impl3461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0__1__Impl_in_rule__DynamicConfig__Group_2_0__13492 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0__2_in_rule__DynamicConfig__Group_2_0__13495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__SourceAssignment_2_0_1_in_rule__DynamicConfig__Group_2_0__1__Impl3522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0__2__Impl_in_rule__DynamicConfig__Group_2_0__23552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_2__0_in_rule__DynamicConfig__Group_2_0__2__Impl3579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_2__0__Impl_in_rule__DynamicConfig__Group_2_0_2__03616 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_2__1_in_rule__DynamicConfig__Group_2_0_2__03619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__DynamicConfig__Group_2_0_2__0__Impl3647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_2__1__Impl_in_rule__DynamicConfig__Group_2_0_2__13678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__FilePathAssignment_2_0_2_1_in_rule__DynamicConfig__Group_2_0_2__1__Impl3705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_1__0__Impl_in_rule__DynamicConfig__Group_2_1__03739 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_1__1_in_rule__DynamicConfig__Group_2_1__03742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__DynamicConfig__Group_2_1__0__Impl3770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_1__1__Impl_in_rule__DynamicConfig__Group_2_1__13801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__PollingAssignment_2_1_1_in_rule__DynamicConfig__Group_2_1__1__Impl3828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__0__Impl_in_rule__ActorClassConfig__Group__03862 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__1_in_rule__ActorClassConfig__Group__03865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ActorClassConfig__Group__0__Impl3893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__1__Impl_in_rule__ActorClassConfig__Group__13924 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__2_in_rule__ActorClassConfig__Group__13927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__ActorAssignment_1_in_rule__ActorClassConfig__Group__1__Impl3954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__2__Impl_in_rule__ActorClassConfig__Group__23984 = new BitSet(new long[]{0x0000000100080000L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__3_in_rule__ActorClassConfig__Group__23987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ActorClassConfig__Group__2__Impl4015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__3__Impl_in_rule__ActorClassConfig__Group__34046 = new BitSet(new long[]{0x0000000100080000L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__4_in_rule__ActorClassConfig__Group__34049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__AttributesAssignment_3_in_rule__ActorClassConfig__Group__3__Impl4076 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__4__Impl_in_rule__ActorClassConfig__Group__44107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ActorClassConfig__Group__4__Impl4135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__0__Impl_in_rule__ActorInstanceConfig__Group_0__04176 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__1_in_rule__ActorInstanceConfig__Group_0__04179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ActorInstanceConfig__Group_0__0__Impl4207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__1__Impl_in_rule__ActorInstanceConfig__Group_0__14238 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__2_in_rule__ActorInstanceConfig__Group_0__14241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__RootAssignment_0_1_in_rule__ActorInstanceConfig__Group_0__1__Impl4268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__2__Impl_in_rule__ActorInstanceConfig__Group_0__24298 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__3_in_rule__ActorInstanceConfig__Group_0__24301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ActorInstanceConfig__Group_0__2__Impl4329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__3__Impl_in_rule__ActorInstanceConfig__Group_0__34360 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__4_in_rule__ActorInstanceConfig__Group_0__34363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__PathAssignment_0_3_in_rule__ActorInstanceConfig__Group_0__3__Impl4390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__4__Impl_in_rule__ActorInstanceConfig__Group_0__44420 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__5_in_rule__ActorInstanceConfig__Group_0__44423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ActorInstanceConfig__Group_0__4__Impl4451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__5__Impl_in_rule__ActorInstanceConfig__Group_0__54482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__AttributesAssignment_0_5_in_rule__ActorInstanceConfig__Group_0__5__Impl4509 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_1__0__Impl_in_rule__ActorInstanceConfig__Group_1__04552 = new BitSet(new long[]{0x0000000082080000L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_1__1_in_rule__ActorInstanceConfig__Group_1__04555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__PortsAssignment_1_0_in_rule__ActorInstanceConfig__Group_1__0__Impl4582 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_1__1__Impl_in_rule__ActorInstanceConfig__Group_1__14613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ActorInstanceConfig__Group_1__1__Impl4641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__0__Impl_in_rule__ProtocolClassConfig__Group__04676 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__1_in_rule__ProtocolClassConfig__Group__04679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ProtocolClassConfig__Group__0__Impl4707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__1__Impl_in_rule__ProtocolClassConfig__Group__14738 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__2_in_rule__ProtocolClassConfig__Group__14741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__ProtocolAssignment_1_in_rule__ProtocolClassConfig__Group__1__Impl4768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__2__Impl_in_rule__ProtocolClassConfig__Group__24798 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__3_in_rule__ProtocolClassConfig__Group__24801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ProtocolClassConfig__Group__2__Impl4829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__3__Impl_in_rule__ProtocolClassConfig__Group__34860 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__4_in_rule__ProtocolClassConfig__Group__34863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3_in_rule__ProtocolClassConfig__Group__3__Impl4890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__4__Impl_in_rule__ProtocolClassConfig__Group__44920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ProtocolClassConfig__Group__4__Impl4948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_0__0__Impl_in_rule__ProtocolClassConfig__Group_3_0__04989 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_0__1_in_rule__ProtocolClassConfig__Group_3_0__04992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ProtocolClassConfig__Group_3_0__0__Impl5020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_0__1__Impl_in_rule__ProtocolClassConfig__Group_3_0__15051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__RegularAssignment_3_0_1_in_rule__ProtocolClassConfig__Group_3_0__1__Impl5078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_1__0__Impl_in_rule__ProtocolClassConfig__Group_3_1__05112 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_1__1_in_rule__ProtocolClassConfig__Group_3_1__05115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ProtocolClassConfig__Group_3_1__0__Impl5143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_1__1__Impl_in_rule__ProtocolClassConfig__Group_3_1__15174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1_in_rule__ProtocolClassConfig__Group_3_1__1__Impl5201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__0__Impl_in_rule__PortClassConfig__Group__05235 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__1_in_rule__PortClassConfig__Group__05238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__1__Impl_in_rule__PortClassConfig__Group__15296 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__2_in_rule__PortClassConfig__Group__15299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__PortClassConfig__Group__1__Impl5327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__2__Impl_in_rule__PortClassConfig__Group__25358 = new BitSet(new long[]{0x0000000100080000L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__3_in_rule__PortClassConfig__Group__25361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__PortClassConfig__Group__2__Impl5389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__3__Impl_in_rule__PortClassConfig__Group__35420 = new BitSet(new long[]{0x0000000100080000L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__4_in_rule__PortClassConfig__Group__35423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__AttributesAssignment_3_in_rule__PortClassConfig__Group__3__Impl5450 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__4__Impl_in_rule__PortClassConfig__Group__45481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PortClassConfig__Group__4__Impl5509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__0__Impl_in_rule__PortInstanceConfig__Group__05550 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__1_in_rule__PortInstanceConfig__Group__05553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__PortInstanceConfig__Group__0__Impl5581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__1__Impl_in_rule__PortInstanceConfig__Group__15612 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__2_in_rule__PortInstanceConfig__Group__15615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__ItemAssignment_1_in_rule__PortInstanceConfig__Group__1__Impl5642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__2__Impl_in_rule__PortInstanceConfig__Group__25672 = new BitSet(new long[]{0x0000000100080000L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__3_in_rule__PortInstanceConfig__Group__25675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__PortInstanceConfig__Group__2__Impl5703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__3__Impl_in_rule__PortInstanceConfig__Group__35734 = new BitSet(new long[]{0x0000000100080000L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__4_in_rule__PortInstanceConfig__Group__35737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__AttributesAssignment_3_in_rule__PortInstanceConfig__Group__3__Impl5764 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__4__Impl_in_rule__PortInstanceConfig__Group__45795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PortInstanceConfig__Group__4__Impl5823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__0__Impl_in_rule__AttrClassConfig__Group__05864 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__1_in_rule__AttrClassConfig__Group__05867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__AttrClassConfig__Group__0__Impl5895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__1__Impl_in_rule__AttrClassConfig__Group__15926 = new BitSet(new long[]{0x0000000200040000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__2_in_rule__AttrClassConfig__Group__15929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__AttributeAssignment_1_in_rule__AttrClassConfig__Group__1__Impl5956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__2__Impl_in_rule__AttrClassConfig__Group__25986 = new BitSet(new long[]{0x0000000200040000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__3_in_rule__AttrClassConfig__Group__25989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_2__0_in_rule__AttrClassConfig__Group__2__Impl6016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__3__Impl_in_rule__AttrClassConfig__Group__36047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__0_in_rule__AttrClassConfig__Group__3__Impl6074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_2__0__Impl_in_rule__AttrClassConfig__Group_2__06113 = new BitSet(new long[]{0x000004800001C0D0L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_2__1_in_rule__AttrClassConfig__Group_2__06116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__AttrClassConfig__Group_2__0__Impl6144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_2__1__Impl_in_rule__AttrClassConfig__Group_2__16175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__ValueAssignment_2_1_in_rule__AttrClassConfig__Group_2__1__Impl6202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__0__Impl_in_rule__AttrClassConfig__Group_3__06236 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__1_in_rule__AttrClassConfig__Group_3__06239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__AttrClassConfig__Group_3__0__Impl6267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__1__Impl_in_rule__AttrClassConfig__Group_3__16298 = new BitSet(new long[]{0x0000000100080000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__2_in_rule__AttrClassConfig__Group_3__16301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1_in_rule__AttrClassConfig__Group_3__1__Impl6328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__2__Impl_in_rule__AttrClassConfig__Group_3__26358 = new BitSet(new long[]{0x0000000100080000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__3_in_rule__AttrClassConfig__Group_3__26361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__AttributesAssignment_3_2_in_rule__AttrClassConfig__Group_3__2__Impl6388 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__3__Impl_in_rule__AttrClassConfig__Group_3__36419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AttrClassConfig__Group_3__3__Impl6447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__0__Impl_in_rule__AttrClassConfig__Group_3_1_0__06486 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__1_in_rule__AttrClassConfig__Group_3_1_0__06489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__AttrClassConfig__Group_3_1_0__0__Impl6517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__1__Impl_in_rule__AttrClassConfig__Group_3_1_0__16548 = new BitSet(new long[]{0x0000008000018050L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__2_in_rule__AttrClassConfig__Group_3_1_0__16551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__AttrClassConfig__Group_3_1_0__1__Impl6579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__2__Impl_in_rule__AttrClassConfig__Group_3_1_0__26610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__MinAssignment_3_1_0_2_in_rule__AttrClassConfig__Group_3_1_0__2__Impl6637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__0__Impl_in_rule__AttrClassConfig__Group_3_1_1__06673 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__1_in_rule__AttrClassConfig__Group_3_1_1__06676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AttrClassConfig__Group_3_1_1__0__Impl6704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__1__Impl_in_rule__AttrClassConfig__Group_3_1_1__16735 = new BitSet(new long[]{0x0000008000018050L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__2_in_rule__AttrClassConfig__Group_3_1_1__16738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__AttrClassConfig__Group_3_1_1__1__Impl6766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__2__Impl_in_rule__AttrClassConfig__Group_3_1_1__26797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__MaxAssignment_3_1_1_2_in_rule__AttrClassConfig__Group_3_1_1__2__Impl6824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__0__Impl_in_rule__AttrInstanceConfig__Group__06860 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__1_in_rule__AttrInstanceConfig__Group__06863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__AttrInstanceConfig__Group__0__Impl6891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__1__Impl_in_rule__AttrInstanceConfig__Group__16922 = new BitSet(new long[]{0x0000000200040000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__2_in_rule__AttrInstanceConfig__Group__16925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__AttributeAssignment_1_in_rule__AttrInstanceConfig__Group__1__Impl6952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__2__Impl_in_rule__AttrInstanceConfig__Group__26982 = new BitSet(new long[]{0x0000000200040000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__3_in_rule__AttrInstanceConfig__Group__26985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_2__0_in_rule__AttrInstanceConfig__Group__2__Impl7012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__3__Impl_in_rule__AttrInstanceConfig__Group__37043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__0_in_rule__AttrInstanceConfig__Group__3__Impl7070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_2__0__Impl_in_rule__AttrInstanceConfig__Group_2__07109 = new BitSet(new long[]{0x000004800001C0D0L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_2__1_in_rule__AttrInstanceConfig__Group_2__07112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__AttrInstanceConfig__Group_2__0__Impl7140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_2__1__Impl_in_rule__AttrInstanceConfig__Group_2__17171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__ValueAssignment_2_1_in_rule__AttrInstanceConfig__Group_2__1__Impl7198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__0__Impl_in_rule__AttrInstanceConfig__Group_3__07232 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__1_in_rule__AttrInstanceConfig__Group_3__07235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__AttrInstanceConfig__Group_3__0__Impl7263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__1__Impl_in_rule__AttrInstanceConfig__Group_3__17294 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__2_in_rule__AttrInstanceConfig__Group_3__17297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__UnorderedGroup_3_1_in_rule__AttrInstanceConfig__Group_3__1__Impl7324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__2__Impl_in_rule__AttrInstanceConfig__Group_3__27354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AttrInstanceConfig__Group_3__2__Impl7382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__0__Impl_in_rule__AttrInstanceConfig__Group_3_1_0__07419 = new BitSet(new long[]{0x0000020000001000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__1_in_rule__AttrInstanceConfig__Group_3_1_0__07422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0_in_rule__AttrInstanceConfig__Group_3_1_0__0__Impl7449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__1__Impl_in_rule__AttrInstanceConfig__Group_3_1_0__17479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Alternatives_3_1_0_1_in_rule__AttrInstanceConfig__Group_3_1_0__1__Impl7506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group__0__Impl_in_rule__RefPath__Group__07540 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__RefPath__Group__1_in_rule__RefPath__Group__07543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__RefsAssignment_0_in_rule__RefPath__Group__0__Impl7570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group__1__Impl_in_rule__RefPath__Group__17600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__0_in_rule__RefPath__Group__1__Impl7627 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__0__Impl_in_rule__RefPath__Group_1__07662 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__1_in_rule__RefPath__Group_1__07665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__RefPath__Group_1__0__Impl7693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__1__Impl_in_rule__RefPath__Group_1__17724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__RefsAssignment_1_1_in_rule__RefPath__Group_1__1__Impl7751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__07785 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__07788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Import__Group__0__Impl7816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__17847 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Import__Group__2_in_rule__Import__Group__17850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl7877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__27907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl7934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__07970 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__07973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl8000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__18030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Import__Group_1_0__1__Impl8058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__08093 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__08096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl8123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__18152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ImportedFQN__Group__1__Impl8181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__08218 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__08221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl8248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__18277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl8304 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__08339 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__08342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__FQN__Group_1__0__Impl8370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__18401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl8428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__0__Impl_in_rule__LiteralArray__Group__08461 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__1_in_rule__LiteralArray__Group__08464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__LiteralsAssignment_0_in_rule__LiteralArray__Group__0__Impl8491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__1__Impl_in_rule__LiteralArray__Group__18521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__0_in_rule__LiteralArray__Group__1__Impl8548 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__0__Impl_in_rule__LiteralArray__Group_1__08583 = new BitSet(new long[]{0x000004800001C0D0L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__1_in_rule__LiteralArray__Group_1__08586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__LiteralArray__Group_1__0__Impl8614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__1__Impl_in_rule__LiteralArray__Group_1__18645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__LiteralsAssignment_1_1_in_rule__LiteralArray__Group_1__1__Impl8672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__08706 = new BitSet(new long[]{0x0000040000004000L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__08709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__18767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl8794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__08828 = new BitSet(new long[]{0x0000008000018050L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__08831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__18889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl8916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__08950 = new BitSet(new long[]{0x0000000000018050L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__08953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__19011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl9038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__09072 = new BitSet(new long[]{0x000004800001C0D0L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__09075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__19133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl9160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__09194 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__09197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl9224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__19255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl9282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__09315 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__09318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl9345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__19376 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__19379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl9406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__29435 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__29438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Decimal__Group__2__Impl9466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__39497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl9524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__09561 = new BitSet(new long[]{0x0000008000018000L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__09564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl9591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__19622 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__19625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__DotDecimal__Group__1__Impl9653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__29684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl9711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__09746 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__09749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl9776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__19807 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__19810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl9837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__29866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__DecimalDot__Group__2__Impl9894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__09931 = new BitSet(new long[]{0x0000008000018050L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__09934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl9961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__19992 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__19995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl10022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__210051 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__210054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__DecimalExp__Group__2__Impl10082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__310113 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__310116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl10143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__410172 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__5_in_rule__DecimalExp__Group__410175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DecimalExp__Group__4__Impl10202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__5__Impl_in_rule__DecimalExp__Group__510231 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__6_in_rule__DecimalExp__Group__510234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Alternatives_5_in_rule__DecimalExp__Group__5__Impl10261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__6__Impl_in_rule__DecimalExp__Group__610292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__6__Impl10319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2__0_in_rule__DynamicConfig__UnorderedGroup_210363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0__0_in_rule__DynamicConfig__UnorderedGroup_2__Impl10452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_1__0_in_rule__DynamicConfig__UnorderedGroup_2__Impl10543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2__Impl_in_rule__DynamicConfig__UnorderedGroup_2__010602 = new BitSet(new long[]{0x0000000000A00002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2__1_in_rule__DynamicConfig__UnorderedGroup_2__010605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2__Impl_in_rule__DynamicConfig__UnorderedGroup_2__110630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__0_in_rule__ActorInstanceConfig__UnorderedGroup10658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__0_in_rule__ActorInstanceConfig__UnorderedGroup__Impl10747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_1__0_in_rule__ActorInstanceConfig__UnorderedGroup__Impl10838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__Impl_in_rule__ActorInstanceConfig__UnorderedGroup__010897 = new BitSet(new long[]{0x0000000082080002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__1_in_rule__ActorInstanceConfig__UnorderedGroup__010900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__Impl_in_rule__ActorInstanceConfig__UnorderedGroup__110925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__0_in_rule__ProtocolClassConfig__UnorderedGroup_310953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_0__0_in_rule__ProtocolClassConfig__UnorderedGroup_3__Impl11040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_1__0_in_rule__ProtocolClassConfig__UnorderedGroup_3__Impl11131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__Impl_in_rule__ProtocolClassConfig__UnorderedGroup_3__011190 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__1_in_rule__ProtocolClassConfig__UnorderedGroup_3__011193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__Impl_in_rule__ProtocolClassConfig__UnorderedGroup_3__111218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__0_in_rule__AttrClassConfig__UnorderedGroup_3_111246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__0_in_rule__AttrClassConfig__UnorderedGroup_3_1__Impl11333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__0_in_rule__AttrClassConfig__UnorderedGroup_3_1__Impl11424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__Impl_in_rule__AttrClassConfig__UnorderedGroup_3_1__011483 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__1_in_rule__AttrClassConfig__UnorderedGroup_3_1__011486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__Impl_in_rule__AttrClassConfig__UnorderedGroup_3_1__111511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__UnorderedGroup_3_1__0_in_rule__AttrInstanceConfig__UnorderedGroup_3_111539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1_0__0_in_rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl11626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__AttributesAssignment_3_1_1_in_rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl11718 = new BitSet(new long[]{0x0000000100100002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__AttributesAssignment_3_1_1_in_rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl11762 = new BitSet(new long[]{0x0000000100100002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl_in_rule__AttrInstanceConfig__UnorderedGroup_3_1__011828 = new BitSet(new long[]{0x0000000100100002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__UnorderedGroup_3_1__1_in_rule__AttrInstanceConfig__UnorderedGroup_3_1__011831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__UnorderedGroup_3_1__Impl_in_rule__AttrInstanceConfig__UnorderedGroup_3_1__111856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__ConfigModel__ImportsAssignment_011888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigElement_in_rule__ConfigModel__ConfigElementsAssignment_111919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubSystemConfig__SubSystemAssignment_111954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDynamicConfig_in_rule__SubSystemConfig__DynConfigAssignment_311989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DynamicConfig__SourceAssignment_2_0_112020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DynamicConfig__FilePathAssignment_2_0_2_112051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DynamicConfig__PollingAssignment_2_1_112082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ActorClassConfig__ActorAssignment_112117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_rule__ActorClassConfig__AttributesAssignment_312152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ActorInstanceConfig__RootAssignment_0_112187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefPath_in_rule__ActorInstanceConfig__PathAssignment_0_312222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_rule__ActorInstanceConfig__AttributesAssignment_0_512253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortInstanceConfig_in_rule__ActorInstanceConfig__PortsAssignment_1_012284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ProtocolClassConfig__ProtocolAssignment_112319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClassConfig_in_rule__ProtocolClassConfig__RegularAssignment_3_0_112354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClassConfig_in_rule__ProtocolClassConfig__ConjugatedAssignment_3_1_112385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_rule__PortClassConfig__AttributesAssignment_312416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PortInstanceConfig__ItemAssignment_112451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_rule__PortInstanceConfig__AttributesAssignment_312486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AttrClassConfig__AttributeAssignment_112521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralArray_in_rule__AttrClassConfig__ValueAssignment_2_112556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__AttrClassConfig__MinAssignment_3_1_0_212587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__AttrClassConfig__MaxAssignment_3_1_1_212618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_rule__AttrClassConfig__AttributesAssignment_3_212649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AttrInstanceConfig__AttributeAssignment_112684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralArray_in_rule__AttrInstanceConfig__ValueAssignment_2_112719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_012755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_012799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_rule__AttrInstanceConfig__AttributesAssignment_3_1_112838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_012869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_1_112900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_012931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_212962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_012993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_1_113024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__BooleanLiteral__IsTrueAssignment_1_113060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_113099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_113130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_113161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__AttributesAssignment_3_1_1_in_synpred1_InternalConfig11759 = new BitSet(new long[]{0x0000000000000002L});

}
