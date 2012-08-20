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

@SuppressWarnings("all")
public class InternalConfigParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_HEX", "RULE_ID", "RULE_INT", "RULE_EXP", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'write'", "'model'", "'false'", "'+'", "'-'", "'SubSystemConfig'", "'{'", "'}'", "'dynamic configuration'", "'file path'", "'user import'", "'user constructor'", "'polling timer [ms]'", "'ActorClassConfig'", "'ActorInstanceConfig'", "'/'", "'ProtocolClassConfig'", "'regular'", "'conjugate'", "'Port'", "'InterfaceItem'", "'Attr'", "'='", "'min'", "'max'", "'import'", "'from'", "'.*'", "'.'", "','", "'read'", "'true'"
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
             before(grammarAccess.getConfigModelRule()); 
            pushFollow(FOLLOW_ruleConfigModel_in_entryRuleConfigModel61);
            ruleConfigModel();

            state._fsp--;

             after(grammarAccess.getConfigModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfigModel68); 

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
             before(grammarAccess.getConfigModelAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:76:1: ( rule__ConfigModel__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:76:2: rule__ConfigModel__Group__0
            {
            pushFollow(FOLLOW_rule__ConfigModel__Group__0_in_ruleConfigModel94);
            rule__ConfigModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConfigModelAccess().getGroup()); 

            }


            }

        }
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
             before(grammarAccess.getConfigElementRule()); 
            pushFollow(FOLLOW_ruleConfigElement_in_entryRuleConfigElement121);
            ruleConfigElement();

            state._fsp--;

             after(grammarAccess.getConfigElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfigElement128); 

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
             before(grammarAccess.getConfigElementAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:104:1: ( rule__ConfigElement__Alternatives )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:104:2: rule__ConfigElement__Alternatives
            {
            pushFollow(FOLLOW_rule__ConfigElement__Alternatives_in_ruleConfigElement154);
            rule__ConfigElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConfigElementAccess().getAlternatives()); 

            }


            }

        }
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
             before(grammarAccess.getSubSystemConfigRule()); 
            pushFollow(FOLLOW_ruleSubSystemConfig_in_entryRuleSubSystemConfig181);
            ruleSubSystemConfig();

            state._fsp--;

             after(grammarAccess.getSubSystemConfigRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemConfig188); 

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
             before(grammarAccess.getSubSystemConfigAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:132:1: ( rule__SubSystemConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:132:2: rule__SubSystemConfig__Group__0
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__0_in_ruleSubSystemConfig214);
            rule__SubSystemConfig__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSubSystemConfigAccess().getGroup()); 

            }


            }

        }
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
             before(grammarAccess.getDynamicConfigRule()); 
            pushFollow(FOLLOW_ruleDynamicConfig_in_entryRuleDynamicConfig241);
            ruleDynamicConfig();

            state._fsp--;

             after(grammarAccess.getDynamicConfigRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDynamicConfig248); 

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
             before(grammarAccess.getDynamicConfigAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:160:1: ( rule__DynamicConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:160:2: rule__DynamicConfig__Group__0
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__0_in_ruleDynamicConfig274);
            rule__DynamicConfig__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDynamicConfigAccess().getGroup()); 

            }


            }

        }
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
             before(grammarAccess.getActorClassConfigRule()); 
            pushFollow(FOLLOW_ruleActorClassConfig_in_entryRuleActorClassConfig301);
            ruleActorClassConfig();

            state._fsp--;

             after(grammarAccess.getActorClassConfigRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorClassConfig308); 

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
             before(grammarAccess.getActorClassConfigAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:188:1: ( rule__ActorClassConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:188:2: rule__ActorClassConfig__Group__0
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__0_in_ruleActorClassConfig334);
            rule__ActorClassConfig__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActorClassConfigAccess().getGroup()); 

            }


            }

        }
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
             before(grammarAccess.getActorInstanceConfigRule()); 
            pushFollow(FOLLOW_ruleActorInstanceConfig_in_entryRuleActorInstanceConfig361);
            ruleActorInstanceConfig();

            state._fsp--;

             after(grammarAccess.getActorInstanceConfigRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorInstanceConfig368); 

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
             before(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:216:1: ( rule__ActorInstanceConfig__UnorderedGroup )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:216:2: rule__ActorInstanceConfig__UnorderedGroup
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup_in_ruleActorInstanceConfig394);
            rule__ActorInstanceConfig__UnorderedGroup();

            state._fsp--;


            }

             after(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup()); 

            }


            }

        }
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
             before(grammarAccess.getProtocolClassConfigRule()); 
            pushFollow(FOLLOW_ruleProtocolClassConfig_in_entryRuleProtocolClassConfig421);
            ruleProtocolClassConfig();

            state._fsp--;

             after(grammarAccess.getProtocolClassConfigRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolClassConfig428); 

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
             before(grammarAccess.getProtocolClassConfigAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:244:1: ( rule__ProtocolClassConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:244:2: rule__ProtocolClassConfig__Group__0
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__0_in_ruleProtocolClassConfig454);
            rule__ProtocolClassConfig__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProtocolClassConfigAccess().getGroup()); 

            }


            }

        }
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
             before(grammarAccess.getPortClassConfigRule()); 
            pushFollow(FOLLOW_rulePortClassConfig_in_entryRulePortClassConfig481);
            rulePortClassConfig();

            state._fsp--;

             after(grammarAccess.getPortClassConfigRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortClassConfig488); 

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
             before(grammarAccess.getPortClassConfigAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:272:1: ( rule__PortClassConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:272:2: rule__PortClassConfig__Group__0
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__0_in_rulePortClassConfig514);
            rule__PortClassConfig__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPortClassConfigAccess().getGroup()); 

            }


            }

        }
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
             before(grammarAccess.getPortInstanceConfigRule()); 
            pushFollow(FOLLOW_rulePortInstanceConfig_in_entryRulePortInstanceConfig541);
            rulePortInstanceConfig();

            state._fsp--;

             after(grammarAccess.getPortInstanceConfigRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortInstanceConfig548); 

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
             before(grammarAccess.getPortInstanceConfigAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:300:1: ( rule__PortInstanceConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:300:2: rule__PortInstanceConfig__Group__0
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__0_in_rulePortInstanceConfig574);
            rule__PortInstanceConfig__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPortInstanceConfigAccess().getGroup()); 

            }


            }

        }
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
             before(grammarAccess.getAttrClassConfigRule()); 
            pushFollow(FOLLOW_ruleAttrClassConfig_in_entryRuleAttrClassConfig603);
            ruleAttrClassConfig();

            state._fsp--;

             after(grammarAccess.getAttrClassConfigRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrClassConfig610); 

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
             before(grammarAccess.getAttrClassConfigAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:330:1: ( rule__AttrClassConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:330:2: rule__AttrClassConfig__Group__0
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__0_in_ruleAttrClassConfig636);
            rule__AttrClassConfig__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttrClassConfigAccess().getGroup()); 

            }


            }

        }
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
             before(grammarAccess.getAttrInstanceConfigRule()); 
            pushFollow(FOLLOW_ruleAttrInstanceConfig_in_entryRuleAttrInstanceConfig663);
            ruleAttrInstanceConfig();

            state._fsp--;

             after(grammarAccess.getAttrInstanceConfigRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrInstanceConfig670); 

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
             before(grammarAccess.getAttrInstanceConfigAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:358:1: ( rule__AttrInstanceConfig__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:358:2: rule__AttrInstanceConfig__Group__0
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__0_in_ruleAttrInstanceConfig696);
            rule__AttrInstanceConfig__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttrInstanceConfigAccess().getGroup()); 

            }


            }

        }
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
             before(grammarAccess.getRefPathRule()); 
            pushFollow(FOLLOW_ruleRefPath_in_entryRuleRefPath723);
            ruleRefPath();

            state._fsp--;

             after(grammarAccess.getRefPathRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefPath730); 

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
             before(grammarAccess.getRefPathAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:386:1: ( rule__RefPath__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:386:2: rule__RefPath__Group__0
            {
            pushFollow(FOLLOW_rule__RefPath__Group__0_in_ruleRefPath756);
            rule__RefPath__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRefPathAccess().getGroup()); 

            }


            }

        }
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
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport783);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport790); 

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
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:414:1: ( rule__Import__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:414:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport816);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
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
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN843);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN850); 

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
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:442:1: ( rule__ImportedFQN__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:442:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN876);
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


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:454:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:455:1: ( ruleFQN EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:456:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN903);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN910); 

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
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:470:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:470:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN936);
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


    // $ANTLR start "entryRuleLiteralArray"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:482:1: entryRuleLiteralArray : ruleLiteralArray EOF ;
    public final void entryRuleLiteralArray() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:483:1: ( ruleLiteralArray EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:484:1: ruleLiteralArray EOF
            {
             before(grammarAccess.getLiteralArrayRule()); 
            pushFollow(FOLLOW_ruleLiteralArray_in_entryRuleLiteralArray963);
            ruleLiteralArray();

            state._fsp--;

             after(grammarAccess.getLiteralArrayRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralArray970); 

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
             before(grammarAccess.getLiteralArrayAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:498:1: ( rule__LiteralArray__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:498:2: rule__LiteralArray__Group__0
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group__0_in_ruleLiteralArray996);
            rule__LiteralArray__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLiteralArrayAccess().getGroup()); 

            }


            }

        }
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
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1023);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1030); 

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
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:526:1: ( rule__Literal__Alternatives )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:526:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral1056);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:538:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:539:1: ( ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:540:1: ruleBooleanLiteral EOF
            {
             before(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral1083);
            ruleBooleanLiteral();

            state._fsp--;

             after(grammarAccess.getBooleanLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral1090); 

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
             before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:554:1: ( rule__BooleanLiteral__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:554:2: rule__BooleanLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral1116);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:566:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:567:1: ( ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:568:1: ruleNumberLiteral EOF
            {
             before(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1143);
            ruleNumberLiteral();

            state._fsp--;

             after(grammarAccess.getNumberLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral1150); 

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
             before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:582:1: ( rule__NumberLiteral__Alternatives )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:582:2: rule__NumberLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral1176);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:594:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:595:1: ( ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:596:1: ruleRealLiteral EOF
            {
             before(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1203);
            ruleRealLiteral();

            state._fsp--;

             after(grammarAccess.getRealLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral1210); 

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
             before(grammarAccess.getRealLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:610:1: ( rule__RealLiteral__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:610:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral1236);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:622:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:623:1: ( ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:624:1: ruleIntLiteral EOF
            {
             before(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral1263);
            ruleIntLiteral();

            state._fsp--;

             after(grammarAccess.getIntLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral1270); 

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
             before(grammarAccess.getIntLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:638:1: ( rule__IntLiteral__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:638:2: rule__IntLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral1296);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:650:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:651:1: ( ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:652:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1323);
            ruleStringLiteral();

            state._fsp--;

             after(grammarAccess.getStringLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral1330); 

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
             before(grammarAccess.getStringLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:666:1: ( rule__StringLiteral__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:666:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral1356);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:678:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:679:1: ( ruleInteger EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:680:1: ruleInteger EOF
            {
             before(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger1383);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger1390); 

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
             before(grammarAccess.getIntegerAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:694:1: ( rule__Integer__Alternatives )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:694:2: rule__Integer__Alternatives
            {
            pushFollow(FOLLOW_rule__Integer__Alternatives_in_ruleInteger1416);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:706:1: entryRuleSignedInteger : ruleSignedInteger EOF ;
    public final void entryRuleSignedInteger() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:710:1: ( ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:711:1: ruleSignedInteger EOF
            {
             before(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger1448);
            ruleSignedInteger();

            state._fsp--;

             after(grammarAccess.getSignedIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger1455); 

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
             before(grammarAccess.getSignedIntegerAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:729:1: ( rule__SignedInteger__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:729:2: rule__SignedInteger__Group__0
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger1485);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:742:1: entryRuleHexadecimal : ruleHexadecimal EOF ;
    public final void entryRuleHexadecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:746:1: ( ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:747:1: ruleHexadecimal EOF
            {
             before(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal1517);
            ruleHexadecimal();

            state._fsp--;

             after(grammarAccess.getHexadecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal1524); 

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
             before(grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 
            match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal1554); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:778:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:779:1: ( ruleReal EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:780:1: ruleReal EOF
            {
             before(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal1580);
            ruleReal();

            state._fsp--;

             after(grammarAccess.getRealRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal1587); 

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
             before(grammarAccess.getRealAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:794:1: ( rule__Real__Alternatives )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:794:2: rule__Real__Alternatives
            {
            pushFollow(FOLLOW_rule__Real__Alternatives_in_ruleReal1613);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:806:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:810:1: ( ruleDecimal EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:811:1: ruleDecimal EOF
            {
             before(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal1645);
            ruleDecimal();

            state._fsp--;

             after(grammarAccess.getDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal1652); 

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
             before(grammarAccess.getDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:829:1: ( rule__Decimal__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:829:2: rule__Decimal__Group__0
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1682);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:842:1: entryRuleDotDecimal : ruleDotDecimal EOF ;
    public final void entryRuleDotDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:846:1: ( ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:847:1: ruleDotDecimal EOF
            {
             before(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1714);
            ruleDotDecimal();

            state._fsp--;

             after(grammarAccess.getDotDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal1721); 

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
             before(grammarAccess.getDotDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:865:1: ( rule__DotDecimal__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:865:2: rule__DotDecimal__Group__0
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1751);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:878:1: entryRuleDecimalDot : ruleDecimalDot EOF ;
    public final void entryRuleDecimalDot() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:882:1: ( ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:883:1: ruleDecimalDot EOF
            {
             before(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1783);
            ruleDecimalDot();

            state._fsp--;

             after(grammarAccess.getDecimalDotRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot1790); 

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
             before(grammarAccess.getDecimalDotAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:901:1: ( rule__DecimalDot__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:901:2: rule__DecimalDot__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1820);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:914:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:918:1: ( ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:919:1: ruleDecimalExp EOF
            {
             before(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1852);
            ruleDecimalExp();

            state._fsp--;

             after(grammarAccess.getDecimalExpRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp1859); 

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
             before(grammarAccess.getDecimalExpAccess().getGroup()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:937:1: ( rule__DecimalExp__Group__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:937:2: rule__DecimalExp__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1889);
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


    // $ANTLR start "rule__ConfigElement__Alternatives"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:950:1: rule__ConfigElement__Alternatives : ( ( ruleSubSystemConfig ) | ( ruleActorClassConfig ) | ( ruleActorInstanceConfig ) | ( ruleProtocolClassConfig ) );
    public final void rule__ConfigElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:954:1: ( ( ruleSubSystemConfig ) | ( ruleActorClassConfig ) | ( ruleActorInstanceConfig ) | ( ruleProtocolClassConfig ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt1=1;
                }
                break;
            case 26:
                {
                alt1=2;
                }
                break;
            case 20:
            case 27:
            case 33:
                {
                alt1=3;
                }
                break;
            case 29:
                {
                alt1=4;
                }
                break;
            default:
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
                     before(grammarAccess.getConfigElementAccess().getSubSystemConfigParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSubSystemConfig_in_rule__ConfigElement__Alternatives1925);
                    ruleSubSystemConfig();

                    state._fsp--;

                     after(grammarAccess.getConfigElementAccess().getSubSystemConfigParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:961:6: ( ruleActorClassConfig )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:961:6: ( ruleActorClassConfig )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:962:1: ruleActorClassConfig
                    {
                     before(grammarAccess.getConfigElementAccess().getActorClassConfigParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleActorClassConfig_in_rule__ConfigElement__Alternatives1942);
                    ruleActorClassConfig();

                    state._fsp--;

                     after(grammarAccess.getConfigElementAccess().getActorClassConfigParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:967:6: ( ruleActorInstanceConfig )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:967:6: ( ruleActorInstanceConfig )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:968:1: ruleActorInstanceConfig
                    {
                     before(grammarAccess.getConfigElementAccess().getActorInstanceConfigParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleActorInstanceConfig_in_rule__ConfigElement__Alternatives1959);
                    ruleActorInstanceConfig();

                    state._fsp--;

                     after(grammarAccess.getConfigElementAccess().getActorInstanceConfigParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:973:6: ( ruleProtocolClassConfig )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:973:6: ( ruleProtocolClassConfig )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:974:1: ruleProtocolClassConfig
                    {
                     before(grammarAccess.getConfigElementAccess().getProtocolClassConfigParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleProtocolClassConfig_in_rule__ConfigElement__Alternatives1976);
                    ruleProtocolClassConfig();

                    state._fsp--;

                     after(grammarAccess.getConfigElementAccess().getProtocolClassConfigParserRuleCall_3()); 

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

            if ( (LA2_0==22) ) {
                alt2=1;
            }
            else if ( (LA2_0==23) ) {
                alt2=2;
            }
            else {
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
                     before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_0()); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:991:1: ( rule__DynamicConfig__Group_2_0_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:991:2: rule__DynamicConfig__Group_2_0_0__0
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_0__0_in_rule__DynamicConfig__Alternatives_2_02008);
                    rule__DynamicConfig__Group_2_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDynamicConfigAccess().getGroup_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:995:6: ( ( rule__DynamicConfig__Group_2_0_1__0 ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:995:6: ( ( rule__DynamicConfig__Group_2_0_1__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:996:1: ( rule__DynamicConfig__Group_2_0_1__0 )
                    {
                     before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1()); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:997:1: ( rule__DynamicConfig__Group_2_0_1__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:997:2: rule__DynamicConfig__Group_2_0_1__0
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1__0_in_rule__DynamicConfig__Alternatives_2_02026);
                    rule__DynamicConfig__Group_2_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1()); 

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


    // $ANTLR start "rule__AttrInstanceConfig__Alternatives_3_1_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1007:1: rule__AttrInstanceConfig__Alternatives_3_1_1 : ( ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0 ) ) | ( 'write' ) );
    public final void rule__AttrInstanceConfig__Alternatives_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1011:1: ( ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0 ) ) | ( 'write' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==43) ) {
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1012:1: ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0 ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1012:1: ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1013:1: ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0 )
                    {
                     before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyAssignment_3_1_1_0()); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1014:1: ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1014:2: rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0_in_rule__AttrInstanceConfig__Alternatives_3_1_12060);
                    rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyAssignment_3_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1018:6: ( 'write' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1018:6: ( 'write' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1019:1: 'write'
                    {
                     before(grammarAccess.getAttrInstanceConfigAccess().getWriteKeyword_3_1_1_1()); 
                    match(input,13,FOLLOW_13_in_rule__AttrInstanceConfig__Alternatives_3_1_12079); 
                     after(grammarAccess.getAttrInstanceConfigAccess().getWriteKeyword_3_1_1_1()); 

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
    // $ANTLR end "rule__AttrInstanceConfig__Alternatives_3_1_1"


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
                     before(grammarAccess.getImportAccess().getGroup_1_0()); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1038:1: ( rule__Import__Group_1_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1038:2: rule__Import__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_12113);
                    rule__Import__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getImportAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1042:6: ( 'model' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1042:6: ( 'model' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1043:1: 'model'
                    {
                     before(grammarAccess.getImportAccess().getModelKeyword_1_1()); 
                    match(input,14,FOLLOW_14_in_rule__Import__Alternatives_12132); 
                     after(grammarAccess.getImportAccess().getModelKeyword_1_1()); 

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
            case 44:
                {
                alt5=1;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case 16:
            case 17:
            case 41:
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1060:1: ( ruleBooleanLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1060:1: ( ruleBooleanLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1061:1: ruleBooleanLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives2166);
                    ruleBooleanLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1066:6: ( ruleNumberLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1066:6: ( ruleNumberLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1067:1: ruleNumberLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives2183);
                    ruleNumberLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1072:6: ( ruleStringLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1072:6: ( ruleStringLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1073:1: ruleStringLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives2200);
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
            else if ( (LA6_0==44) ) {
                alt6=2;
            }
            else {
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
                     before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    match(input,15,FOLLOW_15_in_rule__BooleanLiteral__Alternatives_12233); 
                     after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1096:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1096:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1097:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1098:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1098:2: rule__BooleanLiteral__IsTrueAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_12252);
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

                    if ( (LA7_3==41) ) {
                        alt7=2;
                    }
                    else if ( (LA7_3==EOF||(LA7_3>=18 && LA7_3<=20)||(LA7_3>=26 && LA7_3<=27)||LA7_3==29||(LA7_3>=33 && LA7_3<=34)||(LA7_3>=36 && LA7_3<=37)||LA7_3==42) ) {
                        alt7=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA7_1==41) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==41) ) {
                    alt7=2;
                }
                else if ( (LA7_2==RULE_INT) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==41) ) {
                        alt7=2;
                    }
                    else if ( (LA7_3==EOF||(LA7_3>=18 && LA7_3<=20)||(LA7_3>=26 && LA7_3<=27)||LA7_3==29||(LA7_3>=33 && LA7_3<=34)||(LA7_3>=36 && LA7_3<=37)||LA7_3==42) ) {
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

                if ( (LA7_3==41) ) {
                    alt7=2;
                }
                else if ( (LA7_3==EOF||(LA7_3>=18 && LA7_3<=20)||(LA7_3>=26 && LA7_3<=27)||LA7_3==29||(LA7_3>=33 && LA7_3<=34)||(LA7_3>=36 && LA7_3<=37)||LA7_3==42) ) {
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
            case 41:
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1112:1: ( ruleIntLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1112:1: ( ruleIntLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1113:1: ruleIntLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives2285);
                    ruleIntLiteral();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1118:6: ( ruleRealLiteral )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1118:6: ( ruleRealLiteral )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1119:1: ruleRealLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives2302);
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
                     before(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives2334);
                    ruleSignedInteger();

                    state._fsp--;

                     after(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1140:6: ( ruleHexadecimal )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1140:6: ( ruleHexadecimal )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1141:1: ruleHexadecimal
                    {
                     before(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives2351);
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
                     before(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__SignedInteger__Alternatives_02384); 
                     after(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1164:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1164:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1165:1: '-'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__SignedInteger__Alternatives_02404); 
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
                     before(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDecimal_in_rule__Real__Alternatives2438);
                    ruleDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1188:6: ( ruleDotDecimal )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1188:6: ( ruleDotDecimal )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1189:1: ruleDotDecimal
                    {
                     before(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives2455);
                    ruleDotDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1194:6: ( ruleDecimalDot )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1194:6: ( ruleDecimalDot )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1195:1: ruleDecimalDot
                    {
                     before(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives2472);
                    ruleDecimalDot();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1200:6: ( ruleDecimalExp )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1200:6: ( ruleDecimalExp )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1201:1: ruleDecimalExp
                    {
                     before(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives2489);
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
                     before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__Decimal__Alternatives_02522); 
                     after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1224:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1224:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1225:1: '-'
                    {
                     before(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__Decimal__Alternatives_02542); 
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
                     before(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__DotDecimal__Alternatives_02577); 
                     after(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1250:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1250:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1251:1: '-'
                    {
                     before(grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__DotDecimal__Alternatives_02597); 
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
                     before(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__DecimalDot__Alternatives_02632); 
                     after(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1276:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1276:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1277:1: '-'
                    {
                     before(grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__DecimalDot__Alternatives_02652); 
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
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__DecimalExp__Alternatives_02687); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1302:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1302:6: ( '-' )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1303:1: '-'
                    {
                     before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__DecimalExp__Alternatives_02707); 
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

            pushFollow(FOLLOW_rule__ConfigModel__Group__1_in_rule__ConfigModel__Group__02742);
            rule__ConfigModel__Group__1();

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
    // $ANTLR end "rule__ConfigModel__Group__0"


    // $ANTLR start "rule__ConfigModel__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1329:1: rule__ConfigModel__Group__0__Impl : ( ( rule__ConfigModel__ImportsAssignment_0 )* ) ;
    public final void rule__ConfigModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1333:1: ( ( ( rule__ConfigModel__ImportsAssignment_0 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1334:1: ( ( rule__ConfigModel__ImportsAssignment_0 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1334:1: ( ( rule__ConfigModel__ImportsAssignment_0 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1335:1: ( rule__ConfigModel__ImportsAssignment_0 )*
            {
             before(grammarAccess.getConfigModelAccess().getImportsAssignment_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1336:1: ( rule__ConfigModel__ImportsAssignment_0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==38) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1336:2: rule__ConfigModel__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__ConfigModel__ImportsAssignment_0_in_rule__ConfigModel__Group__0__Impl2769);
            	    rule__ConfigModel__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getConfigModelAccess().getImportsAssignment_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1346:1: rule__ConfigModel__Group__1 : rule__ConfigModel__Group__1__Impl ;
    public final void rule__ConfigModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1350:1: ( rule__ConfigModel__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1351:2: rule__ConfigModel__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConfigModel__Group__1__Impl_in_rule__ConfigModel__Group__12800);
            rule__ConfigModel__Group__1__Impl();

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
    // $ANTLR end "rule__ConfigModel__Group__1"


    // $ANTLR start "rule__ConfigModel__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1357:1: rule__ConfigModel__Group__1__Impl : ( ( rule__ConfigModel__ConfigElementsAssignment_1 )* ) ;
    public final void rule__ConfigModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1361:1: ( ( ( rule__ConfigModel__ConfigElementsAssignment_1 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1362:1: ( ( rule__ConfigModel__ConfigElementsAssignment_1 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1362:1: ( ( rule__ConfigModel__ConfigElementsAssignment_1 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1363:1: ( rule__ConfigModel__ConfigElementsAssignment_1 )*
            {
             before(grammarAccess.getConfigModelAccess().getConfigElementsAssignment_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1364:1: ( rule__ConfigModel__ConfigElementsAssignment_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==18||LA16_0==20||(LA16_0>=26 && LA16_0<=27)||LA16_0==29||LA16_0==33) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1364:2: rule__ConfigModel__ConfigElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__ConfigModel__ConfigElementsAssignment_1_in_rule__ConfigModel__Group__1__Impl2827);
            	    rule__ConfigModel__ConfigElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getConfigModelAccess().getConfigElementsAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1378:1: rule__SubSystemConfig__Group__0 : rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1 ;
    public final void rule__SubSystemConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1382:1: ( rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1383:2: rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__0__Impl_in_rule__SubSystemConfig__Group__02862);
            rule__SubSystemConfig__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemConfig__Group__1_in_rule__SubSystemConfig__Group__02865);
            rule__SubSystemConfig__Group__1();

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
    // $ANTLR end "rule__SubSystemConfig__Group__0"


    // $ANTLR start "rule__SubSystemConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1390:1: rule__SubSystemConfig__Group__0__Impl : ( 'SubSystemConfig' ) ;
    public final void rule__SubSystemConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1394:1: ( ( 'SubSystemConfig' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1395:1: ( 'SubSystemConfig' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1395:1: ( 'SubSystemConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1396:1: 'SubSystemConfig'
            {
             before(grammarAccess.getSubSystemConfigAccess().getSubSystemConfigKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__SubSystemConfig__Group__0__Impl2893); 
             after(grammarAccess.getSubSystemConfigAccess().getSubSystemConfigKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1409:1: rule__SubSystemConfig__Group__1 : rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2 ;
    public final void rule__SubSystemConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1413:1: ( rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1414:2: rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__1__Impl_in_rule__SubSystemConfig__Group__12924);
            rule__SubSystemConfig__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemConfig__Group__2_in_rule__SubSystemConfig__Group__12927);
            rule__SubSystemConfig__Group__2();

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
    // $ANTLR end "rule__SubSystemConfig__Group__1"


    // $ANTLR start "rule__SubSystemConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1421:1: rule__SubSystemConfig__Group__1__Impl : ( ( rule__SubSystemConfig__SubSystemAssignment_1 ) ) ;
    public final void rule__SubSystemConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1425:1: ( ( ( rule__SubSystemConfig__SubSystemAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1426:1: ( ( rule__SubSystemConfig__SubSystemAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1426:1: ( ( rule__SubSystemConfig__SubSystemAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1427:1: ( rule__SubSystemConfig__SubSystemAssignment_1 )
            {
             before(grammarAccess.getSubSystemConfigAccess().getSubSystemAssignment_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1428:1: ( rule__SubSystemConfig__SubSystemAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1428:2: rule__SubSystemConfig__SubSystemAssignment_1
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__SubSystemAssignment_1_in_rule__SubSystemConfig__Group__1__Impl2954);
            rule__SubSystemConfig__SubSystemAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSubSystemConfigAccess().getSubSystemAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1438:1: rule__SubSystemConfig__Group__2 : rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3 ;
    public final void rule__SubSystemConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1442:1: ( rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1443:2: rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__2__Impl_in_rule__SubSystemConfig__Group__22984);
            rule__SubSystemConfig__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemConfig__Group__3_in_rule__SubSystemConfig__Group__22987);
            rule__SubSystemConfig__Group__3();

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
    // $ANTLR end "rule__SubSystemConfig__Group__2"


    // $ANTLR start "rule__SubSystemConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1450:1: rule__SubSystemConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__SubSystemConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1454:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1455:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1455:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1456:1: '{'
            {
             before(grammarAccess.getSubSystemConfigAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,19,FOLLOW_19_in_rule__SubSystemConfig__Group__2__Impl3015); 
             after(grammarAccess.getSubSystemConfigAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1469:1: rule__SubSystemConfig__Group__3 : rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4 ;
    public final void rule__SubSystemConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1473:1: ( rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1474:2: rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__3__Impl_in_rule__SubSystemConfig__Group__33046);
            rule__SubSystemConfig__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemConfig__Group__4_in_rule__SubSystemConfig__Group__33049);
            rule__SubSystemConfig__Group__4();

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
    // $ANTLR end "rule__SubSystemConfig__Group__3"


    // $ANTLR start "rule__SubSystemConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1481:1: rule__SubSystemConfig__Group__3__Impl : ( ( rule__SubSystemConfig__DynConfigAssignment_3 ) ) ;
    public final void rule__SubSystemConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1485:1: ( ( ( rule__SubSystemConfig__DynConfigAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1486:1: ( ( rule__SubSystemConfig__DynConfigAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1486:1: ( ( rule__SubSystemConfig__DynConfigAssignment_3 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1487:1: ( rule__SubSystemConfig__DynConfigAssignment_3 )
            {
             before(grammarAccess.getSubSystemConfigAccess().getDynConfigAssignment_3()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1488:1: ( rule__SubSystemConfig__DynConfigAssignment_3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1488:2: rule__SubSystemConfig__DynConfigAssignment_3
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__DynConfigAssignment_3_in_rule__SubSystemConfig__Group__3__Impl3076);
            rule__SubSystemConfig__DynConfigAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSubSystemConfigAccess().getDynConfigAssignment_3()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1498:1: rule__SubSystemConfig__Group__4 : rule__SubSystemConfig__Group__4__Impl ;
    public final void rule__SubSystemConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1502:1: ( rule__SubSystemConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1503:2: rule__SubSystemConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SubSystemConfig__Group__4__Impl_in_rule__SubSystemConfig__Group__43106);
            rule__SubSystemConfig__Group__4__Impl();

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
    // $ANTLR end "rule__SubSystemConfig__Group__4"


    // $ANTLR start "rule__SubSystemConfig__Group__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1509:1: rule__SubSystemConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__SubSystemConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1513:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1514:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1514:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1515:1: '}'
            {
             before(grammarAccess.getSubSystemConfigAccess().getRightCurlyBracketKeyword_4()); 
            match(input,20,FOLLOW_20_in_rule__SubSystemConfig__Group__4__Impl3134); 
             after(grammarAccess.getSubSystemConfigAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1538:1: rule__DynamicConfig__Group__0 : rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1 ;
    public final void rule__DynamicConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1542:1: ( rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1543:2: rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__0__Impl_in_rule__DynamicConfig__Group__03175);
            rule__DynamicConfig__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DynamicConfig__Group__1_in_rule__DynamicConfig__Group__03178);
            rule__DynamicConfig__Group__1();

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
    // $ANTLR end "rule__DynamicConfig__Group__0"


    // $ANTLR start "rule__DynamicConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1550:1: rule__DynamicConfig__Group__0__Impl : ( 'dynamic configuration' ) ;
    public final void rule__DynamicConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1554:1: ( ( 'dynamic configuration' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1555:1: ( 'dynamic configuration' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1555:1: ( 'dynamic configuration' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1556:1: 'dynamic configuration'
            {
             before(grammarAccess.getDynamicConfigAccess().getDynamicConfigurationKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__DynamicConfig__Group__0__Impl3206); 
             after(grammarAccess.getDynamicConfigAccess().getDynamicConfigurationKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1569:1: rule__DynamicConfig__Group__1 : rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2 ;
    public final void rule__DynamicConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1573:1: ( rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1574:2: rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__1__Impl_in_rule__DynamicConfig__Group__13237);
            rule__DynamicConfig__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DynamicConfig__Group__2_in_rule__DynamicConfig__Group__13240);
            rule__DynamicConfig__Group__2();

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
    // $ANTLR end "rule__DynamicConfig__Group__1"


    // $ANTLR start "rule__DynamicConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1581:1: rule__DynamicConfig__Group__1__Impl : ( '{' ) ;
    public final void rule__DynamicConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1585:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1586:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1586:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1587:1: '{'
            {
             before(grammarAccess.getDynamicConfigAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,19,FOLLOW_19_in_rule__DynamicConfig__Group__1__Impl3268); 
             after(grammarAccess.getDynamicConfigAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1600:1: rule__DynamicConfig__Group__2 : rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3 ;
    public final void rule__DynamicConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1604:1: ( rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1605:2: rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__2__Impl_in_rule__DynamicConfig__Group__23299);
            rule__DynamicConfig__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DynamicConfig__Group__3_in_rule__DynamicConfig__Group__23302);
            rule__DynamicConfig__Group__3();

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
    // $ANTLR end "rule__DynamicConfig__Group__2"


    // $ANTLR start "rule__DynamicConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1612:1: rule__DynamicConfig__Group__2__Impl : ( ( rule__DynamicConfig__UnorderedGroup_2 ) ) ;
    public final void rule__DynamicConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1616:1: ( ( ( rule__DynamicConfig__UnorderedGroup_2 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1617:1: ( ( rule__DynamicConfig__UnorderedGroup_2 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1617:1: ( ( rule__DynamicConfig__UnorderedGroup_2 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1618:1: ( rule__DynamicConfig__UnorderedGroup_2 )
            {
             before(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1619:1: ( rule__DynamicConfig__UnorderedGroup_2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1619:2: rule__DynamicConfig__UnorderedGroup_2
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2_in_rule__DynamicConfig__Group__2__Impl3329);
            rule__DynamicConfig__UnorderedGroup_2();

            state._fsp--;


            }

             after(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1629:1: rule__DynamicConfig__Group__3 : rule__DynamicConfig__Group__3__Impl ;
    public final void rule__DynamicConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1633:1: ( rule__DynamicConfig__Group__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1634:2: rule__DynamicConfig__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group__3__Impl_in_rule__DynamicConfig__Group__33359);
            rule__DynamicConfig__Group__3__Impl();

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
    // $ANTLR end "rule__DynamicConfig__Group__3"


    // $ANTLR start "rule__DynamicConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1640:1: rule__DynamicConfig__Group__3__Impl : ( '}' ) ;
    public final void rule__DynamicConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1644:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1645:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1645:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1646:1: '}'
            {
             before(grammarAccess.getDynamicConfigAccess().getRightCurlyBracketKeyword_3()); 
            match(input,20,FOLLOW_20_in_rule__DynamicConfig__Group__3__Impl3387); 
             after(grammarAccess.getDynamicConfigAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1667:1: rule__DynamicConfig__Group_2_0_0__0 : rule__DynamicConfig__Group_2_0_0__0__Impl rule__DynamicConfig__Group_2_0_0__1 ;
    public final void rule__DynamicConfig__Group_2_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1671:1: ( rule__DynamicConfig__Group_2_0_0__0__Impl rule__DynamicConfig__Group_2_0_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1672:2: rule__DynamicConfig__Group_2_0_0__0__Impl rule__DynamicConfig__Group_2_0_0__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_0__0__Impl_in_rule__DynamicConfig__Group_2_0_0__03426);
            rule__DynamicConfig__Group_2_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_0__1_in_rule__DynamicConfig__Group_2_0_0__03429);
            rule__DynamicConfig__Group_2_0_0__1();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_0__0"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1679:1: rule__DynamicConfig__Group_2_0_0__0__Impl : ( 'file path' ) ;
    public final void rule__DynamicConfig__Group_2_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1683:1: ( ( 'file path' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1684:1: ( 'file path' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1684:1: ( 'file path' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1685:1: 'file path'
            {
             before(grammarAccess.getDynamicConfigAccess().getFilePathKeyword_2_0_0_0()); 
            match(input,22,FOLLOW_22_in_rule__DynamicConfig__Group_2_0_0__0__Impl3457); 
             after(grammarAccess.getDynamicConfigAccess().getFilePathKeyword_2_0_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1698:1: rule__DynamicConfig__Group_2_0_0__1 : rule__DynamicConfig__Group_2_0_0__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1702:1: ( rule__DynamicConfig__Group_2_0_0__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1703:2: rule__DynamicConfig__Group_2_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_0__1__Impl_in_rule__DynamicConfig__Group_2_0_0__13488);
            rule__DynamicConfig__Group_2_0_0__1__Impl();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_0__1"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1709:1: rule__DynamicConfig__Group_2_0_0__1__Impl : ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1713:1: ( ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1714:1: ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1714:1: ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1715:1: ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 )
            {
             before(grammarAccess.getDynamicConfigAccess().getFilePathAssignment_2_0_0_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1716:1: ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1716:2: rule__DynamicConfig__FilePathAssignment_2_0_0_1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__FilePathAssignment_2_0_0_1_in_rule__DynamicConfig__Group_2_0_0__1__Impl3515);
            rule__DynamicConfig__FilePathAssignment_2_0_0_1();

            state._fsp--;


            }

             after(grammarAccess.getDynamicConfigAccess().getFilePathAssignment_2_0_0_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1730:1: rule__DynamicConfig__Group_2_0_1__0 : rule__DynamicConfig__Group_2_0_1__0__Impl rule__DynamicConfig__Group_2_0_1__1 ;
    public final void rule__DynamicConfig__Group_2_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1734:1: ( rule__DynamicConfig__Group_2_0_1__0__Impl rule__DynamicConfig__Group_2_0_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1735:2: rule__DynamicConfig__Group_2_0_1__0__Impl rule__DynamicConfig__Group_2_0_1__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1__0__Impl_in_rule__DynamicConfig__Group_2_0_1__03549);
            rule__DynamicConfig__Group_2_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1__1_in_rule__DynamicConfig__Group_2_0_1__03552);
            rule__DynamicConfig__Group_2_0_1__1();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1__0"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1742:1: rule__DynamicConfig__Group_2_0_1__0__Impl : ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1746:1: ( ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1747:1: ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1747:1: ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1748:1: ( rule__DynamicConfig__Group_2_0_1_0__0 )
            {
             before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1749:1: ( rule__DynamicConfig__Group_2_0_1_0__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1749:2: rule__DynamicConfig__Group_2_0_1_0__0
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_0__0_in_rule__DynamicConfig__Group_2_0_1__0__Impl3579);
            rule__DynamicConfig__Group_2_0_1_0__0();

            state._fsp--;


            }

             after(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1759:1: rule__DynamicConfig__Group_2_0_1__1 : rule__DynamicConfig__Group_2_0_1__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1763:1: ( rule__DynamicConfig__Group_2_0_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1764:2: rule__DynamicConfig__Group_2_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1__1__Impl_in_rule__DynamicConfig__Group_2_0_1__13609);
            rule__DynamicConfig__Group_2_0_1__1__Impl();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1__1"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1770:1: rule__DynamicConfig__Group_2_0_1__1__Impl : ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1774:1: ( ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1775:1: ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1775:1: ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1776:1: ( rule__DynamicConfig__Group_2_0_1_1__0 )
            {
             before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1777:1: ( rule__DynamicConfig__Group_2_0_1_1__0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1777:2: rule__DynamicConfig__Group_2_0_1_1__0
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_1__0_in_rule__DynamicConfig__Group_2_0_1__1__Impl3636);
            rule__DynamicConfig__Group_2_0_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1791:1: rule__DynamicConfig__Group_2_0_1_0__0 : rule__DynamicConfig__Group_2_0_1_0__0__Impl rule__DynamicConfig__Group_2_0_1_0__1 ;
    public final void rule__DynamicConfig__Group_2_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1795:1: ( rule__DynamicConfig__Group_2_0_1_0__0__Impl rule__DynamicConfig__Group_2_0_1_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1796:2: rule__DynamicConfig__Group_2_0_1_0__0__Impl rule__DynamicConfig__Group_2_0_1_0__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_0__0__Impl_in_rule__DynamicConfig__Group_2_0_1_0__03670);
            rule__DynamicConfig__Group_2_0_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_0__1_in_rule__DynamicConfig__Group_2_0_1_0__03673);
            rule__DynamicConfig__Group_2_0_1_0__1();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1_0__0"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1803:1: rule__DynamicConfig__Group_2_0_1_0__0__Impl : ( 'user import' ) ;
    public final void rule__DynamicConfig__Group_2_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1807:1: ( ( 'user import' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1808:1: ( 'user import' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1808:1: ( 'user import' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1809:1: 'user import'
            {
             before(grammarAccess.getDynamicConfigAccess().getUserImportKeyword_2_0_1_0_0()); 
            match(input,23,FOLLOW_23_in_rule__DynamicConfig__Group_2_0_1_0__0__Impl3701); 
             after(grammarAccess.getDynamicConfigAccess().getUserImportKeyword_2_0_1_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1822:1: rule__DynamicConfig__Group_2_0_1_0__1 : rule__DynamicConfig__Group_2_0_1_0__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1826:1: ( rule__DynamicConfig__Group_2_0_1_0__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1827:2: rule__DynamicConfig__Group_2_0_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_0__1__Impl_in_rule__DynamicConfig__Group_2_0_1_0__13732);
            rule__DynamicConfig__Group_2_0_1_0__1__Impl();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1_0__1"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1833:1: rule__DynamicConfig__Group_2_0_1_0__1__Impl : ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1837:1: ( ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1838:1: ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1838:1: ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1839:1: ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 )
            {
             before(grammarAccess.getDynamicConfigAccess().getUserCode1Assignment_2_0_1_0_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1840:1: ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1840:2: rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1_in_rule__DynamicConfig__Group_2_0_1_0__1__Impl3759);
            rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1();

            state._fsp--;


            }

             after(grammarAccess.getDynamicConfigAccess().getUserCode1Assignment_2_0_1_0_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1854:1: rule__DynamicConfig__Group_2_0_1_1__0 : rule__DynamicConfig__Group_2_0_1_1__0__Impl rule__DynamicConfig__Group_2_0_1_1__1 ;
    public final void rule__DynamicConfig__Group_2_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1858:1: ( rule__DynamicConfig__Group_2_0_1_1__0__Impl rule__DynamicConfig__Group_2_0_1_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1859:2: rule__DynamicConfig__Group_2_0_1_1__0__Impl rule__DynamicConfig__Group_2_0_1_1__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_1__0__Impl_in_rule__DynamicConfig__Group_2_0_1_1__03793);
            rule__DynamicConfig__Group_2_0_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_1__1_in_rule__DynamicConfig__Group_2_0_1_1__03796);
            rule__DynamicConfig__Group_2_0_1_1__1();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1_1__0"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1866:1: rule__DynamicConfig__Group_2_0_1_1__0__Impl : ( 'user constructor' ) ;
    public final void rule__DynamicConfig__Group_2_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1870:1: ( ( 'user constructor' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1871:1: ( 'user constructor' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1871:1: ( 'user constructor' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1872:1: 'user constructor'
            {
             before(grammarAccess.getDynamicConfigAccess().getUserConstructorKeyword_2_0_1_1_0()); 
            match(input,24,FOLLOW_24_in_rule__DynamicConfig__Group_2_0_1_1__0__Impl3824); 
             after(grammarAccess.getDynamicConfigAccess().getUserConstructorKeyword_2_0_1_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1885:1: rule__DynamicConfig__Group_2_0_1_1__1 : rule__DynamicConfig__Group_2_0_1_1__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1889:1: ( rule__DynamicConfig__Group_2_0_1_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1890:2: rule__DynamicConfig__Group_2_0_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_0_1_1__1__Impl_in_rule__DynamicConfig__Group_2_0_1_1__13855);
            rule__DynamicConfig__Group_2_0_1_1__1__Impl();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_0_1_1__1"


    // $ANTLR start "rule__DynamicConfig__Group_2_0_1_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1896:1: rule__DynamicConfig__Group_2_0_1_1__1__Impl : ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1900:1: ( ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1901:1: ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1901:1: ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1902:1: ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 )
            {
             before(grammarAccess.getDynamicConfigAccess().getUserCode2Assignment_2_0_1_1_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1903:1: ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1903:2: rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1_in_rule__DynamicConfig__Group_2_0_1_1__1__Impl3882);
            rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDynamicConfigAccess().getUserCode2Assignment_2_0_1_1_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1917:1: rule__DynamicConfig__Group_2_1__0 : rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1 ;
    public final void rule__DynamicConfig__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1921:1: ( rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1922:2: rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_1__0__Impl_in_rule__DynamicConfig__Group_2_1__03916);
            rule__DynamicConfig__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_1__1_in_rule__DynamicConfig__Group_2_1__03919);
            rule__DynamicConfig__Group_2_1__1();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_1__0"


    // $ANTLR start "rule__DynamicConfig__Group_2_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1929:1: rule__DynamicConfig__Group_2_1__0__Impl : ( 'polling timer [ms]' ) ;
    public final void rule__DynamicConfig__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1933:1: ( ( 'polling timer [ms]' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1934:1: ( 'polling timer [ms]' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1934:1: ( 'polling timer [ms]' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1935:1: 'polling timer [ms]'
            {
             before(grammarAccess.getDynamicConfigAccess().getPollingTimerMsKeyword_2_1_0()); 
            match(input,25,FOLLOW_25_in_rule__DynamicConfig__Group_2_1__0__Impl3947); 
             after(grammarAccess.getDynamicConfigAccess().getPollingTimerMsKeyword_2_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1948:1: rule__DynamicConfig__Group_2_1__1 : rule__DynamicConfig__Group_2_1__1__Impl ;
    public final void rule__DynamicConfig__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1952:1: ( rule__DynamicConfig__Group_2_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1953:2: rule__DynamicConfig__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__Group_2_1__1__Impl_in_rule__DynamicConfig__Group_2_1__13978);
            rule__DynamicConfig__Group_2_1__1__Impl();

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
    // $ANTLR end "rule__DynamicConfig__Group_2_1__1"


    // $ANTLR start "rule__DynamicConfig__Group_2_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1959:1: rule__DynamicConfig__Group_2_1__1__Impl : ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1963:1: ( ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1964:1: ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1964:1: ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1965:1: ( rule__DynamicConfig__PollingAssignment_2_1_1 )
            {
             before(grammarAccess.getDynamicConfigAccess().getPollingAssignment_2_1_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1966:1: ( rule__DynamicConfig__PollingAssignment_2_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1966:2: rule__DynamicConfig__PollingAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__DynamicConfig__PollingAssignment_2_1_1_in_rule__DynamicConfig__Group_2_1__1__Impl4005);
            rule__DynamicConfig__PollingAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDynamicConfigAccess().getPollingAssignment_2_1_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1980:1: rule__ActorClassConfig__Group__0 : rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1 ;
    public final void rule__ActorClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1984:1: ( rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1985:2: rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__0__Impl_in_rule__ActorClassConfig__Group__04039);
            rule__ActorClassConfig__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorClassConfig__Group__1_in_rule__ActorClassConfig__Group__04042);
            rule__ActorClassConfig__Group__1();

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
    // $ANTLR end "rule__ActorClassConfig__Group__0"


    // $ANTLR start "rule__ActorClassConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1992:1: rule__ActorClassConfig__Group__0__Impl : ( 'ActorClassConfig' ) ;
    public final void rule__ActorClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1996:1: ( ( 'ActorClassConfig' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1997:1: ( 'ActorClassConfig' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1997:1: ( 'ActorClassConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:1998:1: 'ActorClassConfig'
            {
             before(grammarAccess.getActorClassConfigAccess().getActorClassConfigKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__ActorClassConfig__Group__0__Impl4070); 
             after(grammarAccess.getActorClassConfigAccess().getActorClassConfigKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2011:1: rule__ActorClassConfig__Group__1 : rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2 ;
    public final void rule__ActorClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2015:1: ( rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2016:2: rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__1__Impl_in_rule__ActorClassConfig__Group__14101);
            rule__ActorClassConfig__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorClassConfig__Group__2_in_rule__ActorClassConfig__Group__14104);
            rule__ActorClassConfig__Group__2();

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
    // $ANTLR end "rule__ActorClassConfig__Group__1"


    // $ANTLR start "rule__ActorClassConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2023:1: rule__ActorClassConfig__Group__1__Impl : ( ( rule__ActorClassConfig__ActorAssignment_1 ) ) ;
    public final void rule__ActorClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2027:1: ( ( ( rule__ActorClassConfig__ActorAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2028:1: ( ( rule__ActorClassConfig__ActorAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2028:1: ( ( rule__ActorClassConfig__ActorAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2029:1: ( rule__ActorClassConfig__ActorAssignment_1 )
            {
             before(grammarAccess.getActorClassConfigAccess().getActorAssignment_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2030:1: ( rule__ActorClassConfig__ActorAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2030:2: rule__ActorClassConfig__ActorAssignment_1
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__ActorAssignment_1_in_rule__ActorClassConfig__Group__1__Impl4131);
            rule__ActorClassConfig__ActorAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getActorClassConfigAccess().getActorAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2040:1: rule__ActorClassConfig__Group__2 : rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3 ;
    public final void rule__ActorClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2044:1: ( rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2045:2: rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__2__Impl_in_rule__ActorClassConfig__Group__24161);
            rule__ActorClassConfig__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorClassConfig__Group__3_in_rule__ActorClassConfig__Group__24164);
            rule__ActorClassConfig__Group__3();

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
    // $ANTLR end "rule__ActorClassConfig__Group__2"


    // $ANTLR start "rule__ActorClassConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2052:1: rule__ActorClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__ActorClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2056:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2057:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2057:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2058:1: '{'
            {
             before(grammarAccess.getActorClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,19,FOLLOW_19_in_rule__ActorClassConfig__Group__2__Impl4192); 
             after(grammarAccess.getActorClassConfigAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2071:1: rule__ActorClassConfig__Group__3 : rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4 ;
    public final void rule__ActorClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2075:1: ( rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2076:2: rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__3__Impl_in_rule__ActorClassConfig__Group__34223);
            rule__ActorClassConfig__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorClassConfig__Group__4_in_rule__ActorClassConfig__Group__34226);
            rule__ActorClassConfig__Group__4();

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
    // $ANTLR end "rule__ActorClassConfig__Group__3"


    // $ANTLR start "rule__ActorClassConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2083:1: rule__ActorClassConfig__Group__3__Impl : ( ( rule__ActorClassConfig__AttributesAssignment_3 )* ) ;
    public final void rule__ActorClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2087:1: ( ( ( rule__ActorClassConfig__AttributesAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2088:1: ( ( rule__ActorClassConfig__AttributesAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2088:1: ( ( rule__ActorClassConfig__AttributesAssignment_3 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2089:1: ( rule__ActorClassConfig__AttributesAssignment_3 )*
            {
             before(grammarAccess.getActorClassConfigAccess().getAttributesAssignment_3()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2090:1: ( rule__ActorClassConfig__AttributesAssignment_3 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==34) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2090:2: rule__ActorClassConfig__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__ActorClassConfig__AttributesAssignment_3_in_rule__ActorClassConfig__Group__3__Impl4253);
            	    rule__ActorClassConfig__AttributesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getActorClassConfigAccess().getAttributesAssignment_3()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2100:1: rule__ActorClassConfig__Group__4 : rule__ActorClassConfig__Group__4__Impl ;
    public final void rule__ActorClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2104:1: ( rule__ActorClassConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2105:2: rule__ActorClassConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ActorClassConfig__Group__4__Impl_in_rule__ActorClassConfig__Group__44284);
            rule__ActorClassConfig__Group__4__Impl();

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
    // $ANTLR end "rule__ActorClassConfig__Group__4"


    // $ANTLR start "rule__ActorClassConfig__Group__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2111:1: rule__ActorClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__ActorClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2115:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2116:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2116:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2117:1: '}'
            {
             before(grammarAccess.getActorClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            match(input,20,FOLLOW_20_in_rule__ActorClassConfig__Group__4__Impl4312); 
             after(grammarAccess.getActorClassConfigAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2140:1: rule__ActorInstanceConfig__Group_0__0 : rule__ActorInstanceConfig__Group_0__0__Impl rule__ActorInstanceConfig__Group_0__1 ;
    public final void rule__ActorInstanceConfig__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2144:1: ( rule__ActorInstanceConfig__Group_0__0__Impl rule__ActorInstanceConfig__Group_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2145:2: rule__ActorInstanceConfig__Group_0__0__Impl rule__ActorInstanceConfig__Group_0__1
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__0__Impl_in_rule__ActorInstanceConfig__Group_0__04353);
            rule__ActorInstanceConfig__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__1_in_rule__ActorInstanceConfig__Group_0__04356);
            rule__ActorInstanceConfig__Group_0__1();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__0"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2152:1: rule__ActorInstanceConfig__Group_0__0__Impl : ( 'ActorInstanceConfig' ) ;
    public final void rule__ActorInstanceConfig__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2156:1: ( ( 'ActorInstanceConfig' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2157:1: ( 'ActorInstanceConfig' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2157:1: ( 'ActorInstanceConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2158:1: 'ActorInstanceConfig'
            {
             before(grammarAccess.getActorInstanceConfigAccess().getActorInstanceConfigKeyword_0_0()); 
            match(input,27,FOLLOW_27_in_rule__ActorInstanceConfig__Group_0__0__Impl4384); 
             after(grammarAccess.getActorInstanceConfigAccess().getActorInstanceConfigKeyword_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2171:1: rule__ActorInstanceConfig__Group_0__1 : rule__ActorInstanceConfig__Group_0__1__Impl rule__ActorInstanceConfig__Group_0__2 ;
    public final void rule__ActorInstanceConfig__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2175:1: ( rule__ActorInstanceConfig__Group_0__1__Impl rule__ActorInstanceConfig__Group_0__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2176:2: rule__ActorInstanceConfig__Group_0__1__Impl rule__ActorInstanceConfig__Group_0__2
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__1__Impl_in_rule__ActorInstanceConfig__Group_0__14415);
            rule__ActorInstanceConfig__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__2_in_rule__ActorInstanceConfig__Group_0__14418);
            rule__ActorInstanceConfig__Group_0__2();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__1"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2183:1: rule__ActorInstanceConfig__Group_0__1__Impl : ( ( rule__ActorInstanceConfig__RootAssignment_0_1 ) ) ;
    public final void rule__ActorInstanceConfig__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2187:1: ( ( ( rule__ActorInstanceConfig__RootAssignment_0_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2188:1: ( ( rule__ActorInstanceConfig__RootAssignment_0_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2188:1: ( ( rule__ActorInstanceConfig__RootAssignment_0_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2189:1: ( rule__ActorInstanceConfig__RootAssignment_0_1 )
            {
             before(grammarAccess.getActorInstanceConfigAccess().getRootAssignment_0_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2190:1: ( rule__ActorInstanceConfig__RootAssignment_0_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2190:2: rule__ActorInstanceConfig__RootAssignment_0_1
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__RootAssignment_0_1_in_rule__ActorInstanceConfig__Group_0__1__Impl4445);
            rule__ActorInstanceConfig__RootAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getActorInstanceConfigAccess().getRootAssignment_0_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2200:1: rule__ActorInstanceConfig__Group_0__2 : rule__ActorInstanceConfig__Group_0__2__Impl rule__ActorInstanceConfig__Group_0__3 ;
    public final void rule__ActorInstanceConfig__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2204:1: ( rule__ActorInstanceConfig__Group_0__2__Impl rule__ActorInstanceConfig__Group_0__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2205:2: rule__ActorInstanceConfig__Group_0__2__Impl rule__ActorInstanceConfig__Group_0__3
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__2__Impl_in_rule__ActorInstanceConfig__Group_0__24475);
            rule__ActorInstanceConfig__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__3_in_rule__ActorInstanceConfig__Group_0__24478);
            rule__ActorInstanceConfig__Group_0__3();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__2"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2212:1: rule__ActorInstanceConfig__Group_0__2__Impl : ( '/' ) ;
    public final void rule__ActorInstanceConfig__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2216:1: ( ( '/' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2217:1: ( '/' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2217:1: ( '/' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2218:1: '/'
            {
             before(grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_0_2()); 
            match(input,28,FOLLOW_28_in_rule__ActorInstanceConfig__Group_0__2__Impl4506); 
             after(grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_0_2()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2231:1: rule__ActorInstanceConfig__Group_0__3 : rule__ActorInstanceConfig__Group_0__3__Impl rule__ActorInstanceConfig__Group_0__4 ;
    public final void rule__ActorInstanceConfig__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2235:1: ( rule__ActorInstanceConfig__Group_0__3__Impl rule__ActorInstanceConfig__Group_0__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2236:2: rule__ActorInstanceConfig__Group_0__3__Impl rule__ActorInstanceConfig__Group_0__4
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__3__Impl_in_rule__ActorInstanceConfig__Group_0__34537);
            rule__ActorInstanceConfig__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__4_in_rule__ActorInstanceConfig__Group_0__34540);
            rule__ActorInstanceConfig__Group_0__4();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__3"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2243:1: rule__ActorInstanceConfig__Group_0__3__Impl : ( ( rule__ActorInstanceConfig__PathAssignment_0_3 ) ) ;
    public final void rule__ActorInstanceConfig__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2247:1: ( ( ( rule__ActorInstanceConfig__PathAssignment_0_3 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2248:1: ( ( rule__ActorInstanceConfig__PathAssignment_0_3 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2248:1: ( ( rule__ActorInstanceConfig__PathAssignment_0_3 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2249:1: ( rule__ActorInstanceConfig__PathAssignment_0_3 )
            {
             before(grammarAccess.getActorInstanceConfigAccess().getPathAssignment_0_3()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2250:1: ( rule__ActorInstanceConfig__PathAssignment_0_3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2250:2: rule__ActorInstanceConfig__PathAssignment_0_3
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__PathAssignment_0_3_in_rule__ActorInstanceConfig__Group_0__3__Impl4567);
            rule__ActorInstanceConfig__PathAssignment_0_3();

            state._fsp--;


            }

             after(grammarAccess.getActorInstanceConfigAccess().getPathAssignment_0_3()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2260:1: rule__ActorInstanceConfig__Group_0__4 : rule__ActorInstanceConfig__Group_0__4__Impl rule__ActorInstanceConfig__Group_0__5 ;
    public final void rule__ActorInstanceConfig__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2264:1: ( rule__ActorInstanceConfig__Group_0__4__Impl rule__ActorInstanceConfig__Group_0__5 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2265:2: rule__ActorInstanceConfig__Group_0__4__Impl rule__ActorInstanceConfig__Group_0__5
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__4__Impl_in_rule__ActorInstanceConfig__Group_0__44597);
            rule__ActorInstanceConfig__Group_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__5_in_rule__ActorInstanceConfig__Group_0__44600);
            rule__ActorInstanceConfig__Group_0__5();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__4"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2272:1: rule__ActorInstanceConfig__Group_0__4__Impl : ( '{' ) ;
    public final void rule__ActorInstanceConfig__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2276:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2277:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2277:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2278:1: '{'
            {
             before(grammarAccess.getActorInstanceConfigAccess().getLeftCurlyBracketKeyword_0_4()); 
            match(input,19,FOLLOW_19_in_rule__ActorInstanceConfig__Group_0__4__Impl4628); 
             after(grammarAccess.getActorInstanceConfigAccess().getLeftCurlyBracketKeyword_0_4()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2291:1: rule__ActorInstanceConfig__Group_0__5 : rule__ActorInstanceConfig__Group_0__5__Impl ;
    public final void rule__ActorInstanceConfig__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2295:1: ( rule__ActorInstanceConfig__Group_0__5__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2296:2: rule__ActorInstanceConfig__Group_0__5__Impl
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__5__Impl_in_rule__ActorInstanceConfig__Group_0__54659);
            rule__ActorInstanceConfig__Group_0__5__Impl();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_0__5"


    // $ANTLR start "rule__ActorInstanceConfig__Group_0__5__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2302:1: rule__ActorInstanceConfig__Group_0__5__Impl : ( ( rule__ActorInstanceConfig__AttributesAssignment_0_5 )* ) ;
    public final void rule__ActorInstanceConfig__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2306:1: ( ( ( rule__ActorInstanceConfig__AttributesAssignment_0_5 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2307:1: ( ( rule__ActorInstanceConfig__AttributesAssignment_0_5 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2307:1: ( ( rule__ActorInstanceConfig__AttributesAssignment_0_5 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2308:1: ( rule__ActorInstanceConfig__AttributesAssignment_0_5 )*
            {
             before(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_0_5()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2309:1: ( rule__ActorInstanceConfig__AttributesAssignment_0_5 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==34) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2309:2: rule__ActorInstanceConfig__AttributesAssignment_0_5
            	    {
            	    pushFollow(FOLLOW_rule__ActorInstanceConfig__AttributesAssignment_0_5_in_rule__ActorInstanceConfig__Group_0__5__Impl4686);
            	    rule__ActorInstanceConfig__AttributesAssignment_0_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_0_5()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2331:1: rule__ActorInstanceConfig__Group_1__0 : rule__ActorInstanceConfig__Group_1__0__Impl rule__ActorInstanceConfig__Group_1__1 ;
    public final void rule__ActorInstanceConfig__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2335:1: ( rule__ActorInstanceConfig__Group_1__0__Impl rule__ActorInstanceConfig__Group_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2336:2: rule__ActorInstanceConfig__Group_1__0__Impl rule__ActorInstanceConfig__Group_1__1
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_1__0__Impl_in_rule__ActorInstanceConfig__Group_1__04729);
            rule__ActorInstanceConfig__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_1__1_in_rule__ActorInstanceConfig__Group_1__04732);
            rule__ActorInstanceConfig__Group_1__1();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_1__0"


    // $ANTLR start "rule__ActorInstanceConfig__Group_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2343:1: rule__ActorInstanceConfig__Group_1__0__Impl : ( ( rule__ActorInstanceConfig__PortsAssignment_1_0 )* ) ;
    public final void rule__ActorInstanceConfig__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2347:1: ( ( ( rule__ActorInstanceConfig__PortsAssignment_1_0 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2348:1: ( ( rule__ActorInstanceConfig__PortsAssignment_1_0 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2348:1: ( ( rule__ActorInstanceConfig__PortsAssignment_1_0 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2349:1: ( rule__ActorInstanceConfig__PortsAssignment_1_0 )*
            {
             before(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_1_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2350:1: ( rule__ActorInstanceConfig__PortsAssignment_1_0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==33) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2350:2: rule__ActorInstanceConfig__PortsAssignment_1_0
            	    {
            	    pushFollow(FOLLOW_rule__ActorInstanceConfig__PortsAssignment_1_0_in_rule__ActorInstanceConfig__Group_1__0__Impl4759);
            	    rule__ActorInstanceConfig__PortsAssignment_1_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2360:1: rule__ActorInstanceConfig__Group_1__1 : rule__ActorInstanceConfig__Group_1__1__Impl ;
    public final void rule__ActorInstanceConfig__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2364:1: ( rule__ActorInstanceConfig__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2365:2: rule__ActorInstanceConfig__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_1__1__Impl_in_rule__ActorInstanceConfig__Group_1__14790);
            rule__ActorInstanceConfig__Group_1__1__Impl();

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
    // $ANTLR end "rule__ActorInstanceConfig__Group_1__1"


    // $ANTLR start "rule__ActorInstanceConfig__Group_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2371:1: rule__ActorInstanceConfig__Group_1__1__Impl : ( '}' ) ;
    public final void rule__ActorInstanceConfig__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2375:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2376:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2376:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2377:1: '}'
            {
             before(grammarAccess.getActorInstanceConfigAccess().getRightCurlyBracketKeyword_1_1()); 
            match(input,20,FOLLOW_20_in_rule__ActorInstanceConfig__Group_1__1__Impl4818); 
             after(grammarAccess.getActorInstanceConfigAccess().getRightCurlyBracketKeyword_1_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2394:1: rule__ProtocolClassConfig__Group__0 : rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1 ;
    public final void rule__ProtocolClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2398:1: ( rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2399:2: rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__0__Impl_in_rule__ProtocolClassConfig__Group__04853);
            rule__ProtocolClassConfig__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__1_in_rule__ProtocolClassConfig__Group__04856);
            rule__ProtocolClassConfig__Group__1();

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__0"


    // $ANTLR start "rule__ProtocolClassConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2406:1: rule__ProtocolClassConfig__Group__0__Impl : ( 'ProtocolClassConfig' ) ;
    public final void rule__ProtocolClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2410:1: ( ( 'ProtocolClassConfig' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2411:1: ( 'ProtocolClassConfig' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2411:1: ( 'ProtocolClassConfig' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2412:1: 'ProtocolClassConfig'
            {
             before(grammarAccess.getProtocolClassConfigAccess().getProtocolClassConfigKeyword_0()); 
            match(input,29,FOLLOW_29_in_rule__ProtocolClassConfig__Group__0__Impl4884); 
             after(grammarAccess.getProtocolClassConfigAccess().getProtocolClassConfigKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2425:1: rule__ProtocolClassConfig__Group__1 : rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2 ;
    public final void rule__ProtocolClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2429:1: ( rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2430:2: rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__1__Impl_in_rule__ProtocolClassConfig__Group__14915);
            rule__ProtocolClassConfig__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__2_in_rule__ProtocolClassConfig__Group__14918);
            rule__ProtocolClassConfig__Group__2();

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__1"


    // $ANTLR start "rule__ProtocolClassConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2437:1: rule__ProtocolClassConfig__Group__1__Impl : ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2441:1: ( ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2442:1: ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2442:1: ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2443:1: ( rule__ProtocolClassConfig__ProtocolAssignment_1 )
            {
             before(grammarAccess.getProtocolClassConfigAccess().getProtocolAssignment_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2444:1: ( rule__ProtocolClassConfig__ProtocolAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2444:2: rule__ProtocolClassConfig__ProtocolAssignment_1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__ProtocolAssignment_1_in_rule__ProtocolClassConfig__Group__1__Impl4945);
            rule__ProtocolClassConfig__ProtocolAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getProtocolClassConfigAccess().getProtocolAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2454:1: rule__ProtocolClassConfig__Group__2 : rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3 ;
    public final void rule__ProtocolClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2458:1: ( rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2459:2: rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__2__Impl_in_rule__ProtocolClassConfig__Group__24975);
            rule__ProtocolClassConfig__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__3_in_rule__ProtocolClassConfig__Group__24978);
            rule__ProtocolClassConfig__Group__3();

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__2"


    // $ANTLR start "rule__ProtocolClassConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2466:1: rule__ProtocolClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__ProtocolClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2470:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2471:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2471:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2472:1: '{'
            {
             before(grammarAccess.getProtocolClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,19,FOLLOW_19_in_rule__ProtocolClassConfig__Group__2__Impl5006); 
             after(grammarAccess.getProtocolClassConfigAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2485:1: rule__ProtocolClassConfig__Group__3 : rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4 ;
    public final void rule__ProtocolClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2489:1: ( rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2490:2: rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__3__Impl_in_rule__ProtocolClassConfig__Group__35037);
            rule__ProtocolClassConfig__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__4_in_rule__ProtocolClassConfig__Group__35040);
            rule__ProtocolClassConfig__Group__4();

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__3"


    // $ANTLR start "rule__ProtocolClassConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2497:1: rule__ProtocolClassConfig__Group__3__Impl : ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) ) ;
    public final void rule__ProtocolClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2501:1: ( ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2502:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2502:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2503:1: ( rule__ProtocolClassConfig__UnorderedGroup_3 )
            {
             before(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2504:1: ( rule__ProtocolClassConfig__UnorderedGroup_3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2504:2: rule__ProtocolClassConfig__UnorderedGroup_3
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3_in_rule__ProtocolClassConfig__Group__3__Impl5067);
            rule__ProtocolClassConfig__UnorderedGroup_3();

            state._fsp--;


            }

             after(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2514:1: rule__ProtocolClassConfig__Group__4 : rule__ProtocolClassConfig__Group__4__Impl ;
    public final void rule__ProtocolClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2518:1: ( rule__ProtocolClassConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2519:2: rule__ProtocolClassConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group__4__Impl_in_rule__ProtocolClassConfig__Group__45097);
            rule__ProtocolClassConfig__Group__4__Impl();

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
    // $ANTLR end "rule__ProtocolClassConfig__Group__4"


    // $ANTLR start "rule__ProtocolClassConfig__Group__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2525:1: rule__ProtocolClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__ProtocolClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2529:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2530:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2530:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2531:1: '}'
            {
             before(grammarAccess.getProtocolClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            match(input,20,FOLLOW_20_in_rule__ProtocolClassConfig__Group__4__Impl5125); 
             after(grammarAccess.getProtocolClassConfigAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2554:1: rule__ProtocolClassConfig__Group_3_0__0 : rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1 ;
    public final void rule__ProtocolClassConfig__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2558:1: ( rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2559:2: rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_0__0__Impl_in_rule__ProtocolClassConfig__Group_3_0__05166);
            rule__ProtocolClassConfig__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_0__1_in_rule__ProtocolClassConfig__Group_3_0__05169);
            rule__ProtocolClassConfig__Group_3_0__1();

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
    // $ANTLR end "rule__ProtocolClassConfig__Group_3_0__0"


    // $ANTLR start "rule__ProtocolClassConfig__Group_3_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2566:1: rule__ProtocolClassConfig__Group_3_0__0__Impl : ( 'regular' ) ;
    public final void rule__ProtocolClassConfig__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2570:1: ( ( 'regular' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2571:1: ( 'regular' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2571:1: ( 'regular' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2572:1: 'regular'
            {
             before(grammarAccess.getProtocolClassConfigAccess().getRegularKeyword_3_0_0()); 
            match(input,30,FOLLOW_30_in_rule__ProtocolClassConfig__Group_3_0__0__Impl5197); 
             after(grammarAccess.getProtocolClassConfigAccess().getRegularKeyword_3_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2585:1: rule__ProtocolClassConfig__Group_3_0__1 : rule__ProtocolClassConfig__Group_3_0__1__Impl ;
    public final void rule__ProtocolClassConfig__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2589:1: ( rule__ProtocolClassConfig__Group_3_0__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2590:2: rule__ProtocolClassConfig__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_0__1__Impl_in_rule__ProtocolClassConfig__Group_3_0__15228);
            rule__ProtocolClassConfig__Group_3_0__1__Impl();

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
    // $ANTLR end "rule__ProtocolClassConfig__Group_3_0__1"


    // $ANTLR start "rule__ProtocolClassConfig__Group_3_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2596:1: rule__ProtocolClassConfig__Group_3_0__1__Impl : ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2600:1: ( ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2601:1: ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2601:1: ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2602:1: ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 )
            {
             before(grammarAccess.getProtocolClassConfigAccess().getRegularAssignment_3_0_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2603:1: ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2603:2: rule__ProtocolClassConfig__RegularAssignment_3_0_1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__RegularAssignment_3_0_1_in_rule__ProtocolClassConfig__Group_3_0__1__Impl5255);
            rule__ProtocolClassConfig__RegularAssignment_3_0_1();

            state._fsp--;


            }

             after(grammarAccess.getProtocolClassConfigAccess().getRegularAssignment_3_0_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2617:1: rule__ProtocolClassConfig__Group_3_1__0 : rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1 ;
    public final void rule__ProtocolClassConfig__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2621:1: ( rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2622:2: rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_1__0__Impl_in_rule__ProtocolClassConfig__Group_3_1__05289);
            rule__ProtocolClassConfig__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_1__1_in_rule__ProtocolClassConfig__Group_3_1__05292);
            rule__ProtocolClassConfig__Group_3_1__1();

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
    // $ANTLR end "rule__ProtocolClassConfig__Group_3_1__0"


    // $ANTLR start "rule__ProtocolClassConfig__Group_3_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2629:1: rule__ProtocolClassConfig__Group_3_1__0__Impl : ( 'conjugate' ) ;
    public final void rule__ProtocolClassConfig__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2633:1: ( ( 'conjugate' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2634:1: ( 'conjugate' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2634:1: ( 'conjugate' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2635:1: 'conjugate'
            {
             before(grammarAccess.getProtocolClassConfigAccess().getConjugateKeyword_3_1_0()); 
            match(input,31,FOLLOW_31_in_rule__ProtocolClassConfig__Group_3_1__0__Impl5320); 
             after(grammarAccess.getProtocolClassConfigAccess().getConjugateKeyword_3_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2648:1: rule__ProtocolClassConfig__Group_3_1__1 : rule__ProtocolClassConfig__Group_3_1__1__Impl ;
    public final void rule__ProtocolClassConfig__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2652:1: ( rule__ProtocolClassConfig__Group_3_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2653:2: rule__ProtocolClassConfig__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_1__1__Impl_in_rule__ProtocolClassConfig__Group_3_1__15351);
            rule__ProtocolClassConfig__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__ProtocolClassConfig__Group_3_1__1"


    // $ANTLR start "rule__ProtocolClassConfig__Group_3_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2659:1: rule__ProtocolClassConfig__Group_3_1__1__Impl : ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2663:1: ( ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2664:1: ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2664:1: ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2665:1: ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 )
            {
             before(grammarAccess.getProtocolClassConfigAccess().getConjugatedAssignment_3_1_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2666:1: ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2666:2: rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1_in_rule__ProtocolClassConfig__Group_3_1__1__Impl5378);
            rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getProtocolClassConfigAccess().getConjugatedAssignment_3_1_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2680:1: rule__PortClassConfig__Group__0 : rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1 ;
    public final void rule__PortClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2684:1: ( rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2685:2: rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__0__Impl_in_rule__PortClassConfig__Group__05412);
            rule__PortClassConfig__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortClassConfig__Group__1_in_rule__PortClassConfig__Group__05415);
            rule__PortClassConfig__Group__1();

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
    // $ANTLR end "rule__PortClassConfig__Group__0"


    // $ANTLR start "rule__PortClassConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2692:1: rule__PortClassConfig__Group__0__Impl : ( () ) ;
    public final void rule__PortClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2696:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2697:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2697:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2698:1: ()
            {
             before(grammarAccess.getPortClassConfigAccess().getPortClassConfigAction_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2699:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2701:1: 
            {
            }

             after(grammarAccess.getPortClassConfigAccess().getPortClassConfigAction_0()); 

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2711:1: rule__PortClassConfig__Group__1 : rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2 ;
    public final void rule__PortClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2715:1: ( rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2716:2: rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__1__Impl_in_rule__PortClassConfig__Group__15473);
            rule__PortClassConfig__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortClassConfig__Group__2_in_rule__PortClassConfig__Group__15476);
            rule__PortClassConfig__Group__2();

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
    // $ANTLR end "rule__PortClassConfig__Group__1"


    // $ANTLR start "rule__PortClassConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2723:1: rule__PortClassConfig__Group__1__Impl : ( 'Port' ) ;
    public final void rule__PortClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2727:1: ( ( 'Port' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2728:1: ( 'Port' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2728:1: ( 'Port' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2729:1: 'Port'
            {
             before(grammarAccess.getPortClassConfigAccess().getPortKeyword_1()); 
            match(input,32,FOLLOW_32_in_rule__PortClassConfig__Group__1__Impl5504); 
             after(grammarAccess.getPortClassConfigAccess().getPortKeyword_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2742:1: rule__PortClassConfig__Group__2 : rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3 ;
    public final void rule__PortClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2746:1: ( rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2747:2: rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__2__Impl_in_rule__PortClassConfig__Group__25535);
            rule__PortClassConfig__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortClassConfig__Group__3_in_rule__PortClassConfig__Group__25538);
            rule__PortClassConfig__Group__3();

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
    // $ANTLR end "rule__PortClassConfig__Group__2"


    // $ANTLR start "rule__PortClassConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2754:1: rule__PortClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__PortClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2758:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2759:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2759:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2760:1: '{'
            {
             before(grammarAccess.getPortClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,19,FOLLOW_19_in_rule__PortClassConfig__Group__2__Impl5566); 
             after(grammarAccess.getPortClassConfigAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2773:1: rule__PortClassConfig__Group__3 : rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4 ;
    public final void rule__PortClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2777:1: ( rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2778:2: rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__3__Impl_in_rule__PortClassConfig__Group__35597);
            rule__PortClassConfig__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortClassConfig__Group__4_in_rule__PortClassConfig__Group__35600);
            rule__PortClassConfig__Group__4();

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
    // $ANTLR end "rule__PortClassConfig__Group__3"


    // $ANTLR start "rule__PortClassConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2785:1: rule__PortClassConfig__Group__3__Impl : ( ( rule__PortClassConfig__AttributesAssignment_3 )* ) ;
    public final void rule__PortClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2789:1: ( ( ( rule__PortClassConfig__AttributesAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2790:1: ( ( rule__PortClassConfig__AttributesAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2790:1: ( ( rule__PortClassConfig__AttributesAssignment_3 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2791:1: ( rule__PortClassConfig__AttributesAssignment_3 )*
            {
             before(grammarAccess.getPortClassConfigAccess().getAttributesAssignment_3()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2792:1: ( rule__PortClassConfig__AttributesAssignment_3 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==34) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2792:2: rule__PortClassConfig__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PortClassConfig__AttributesAssignment_3_in_rule__PortClassConfig__Group__3__Impl5627);
            	    rule__PortClassConfig__AttributesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getPortClassConfigAccess().getAttributesAssignment_3()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2802:1: rule__PortClassConfig__Group__4 : rule__PortClassConfig__Group__4__Impl ;
    public final void rule__PortClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2806:1: ( rule__PortClassConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2807:2: rule__PortClassConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PortClassConfig__Group__4__Impl_in_rule__PortClassConfig__Group__45658);
            rule__PortClassConfig__Group__4__Impl();

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
    // $ANTLR end "rule__PortClassConfig__Group__4"


    // $ANTLR start "rule__PortClassConfig__Group__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2813:1: rule__PortClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__PortClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2817:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2818:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2818:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2819:1: '}'
            {
             before(grammarAccess.getPortClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            match(input,20,FOLLOW_20_in_rule__PortClassConfig__Group__4__Impl5686); 
             after(grammarAccess.getPortClassConfigAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2842:1: rule__PortInstanceConfig__Group__0 : rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1 ;
    public final void rule__PortInstanceConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2846:1: ( rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2847:2: rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__0__Impl_in_rule__PortInstanceConfig__Group__05727);
            rule__PortInstanceConfig__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__1_in_rule__PortInstanceConfig__Group__05730);
            rule__PortInstanceConfig__Group__1();

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
    // $ANTLR end "rule__PortInstanceConfig__Group__0"


    // $ANTLR start "rule__PortInstanceConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2854:1: rule__PortInstanceConfig__Group__0__Impl : ( 'InterfaceItem' ) ;
    public final void rule__PortInstanceConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2858:1: ( ( 'InterfaceItem' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2859:1: ( 'InterfaceItem' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2859:1: ( 'InterfaceItem' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2860:1: 'InterfaceItem'
            {
             before(grammarAccess.getPortInstanceConfigAccess().getInterfaceItemKeyword_0()); 
            match(input,33,FOLLOW_33_in_rule__PortInstanceConfig__Group__0__Impl5758); 
             after(grammarAccess.getPortInstanceConfigAccess().getInterfaceItemKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2873:1: rule__PortInstanceConfig__Group__1 : rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2 ;
    public final void rule__PortInstanceConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2877:1: ( rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2878:2: rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__1__Impl_in_rule__PortInstanceConfig__Group__15789);
            rule__PortInstanceConfig__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__2_in_rule__PortInstanceConfig__Group__15792);
            rule__PortInstanceConfig__Group__2();

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
    // $ANTLR end "rule__PortInstanceConfig__Group__1"


    // $ANTLR start "rule__PortInstanceConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2885:1: rule__PortInstanceConfig__Group__1__Impl : ( ( rule__PortInstanceConfig__ItemAssignment_1 ) ) ;
    public final void rule__PortInstanceConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2889:1: ( ( ( rule__PortInstanceConfig__ItemAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2890:1: ( ( rule__PortInstanceConfig__ItemAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2890:1: ( ( rule__PortInstanceConfig__ItemAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2891:1: ( rule__PortInstanceConfig__ItemAssignment_1 )
            {
             before(grammarAccess.getPortInstanceConfigAccess().getItemAssignment_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2892:1: ( rule__PortInstanceConfig__ItemAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2892:2: rule__PortInstanceConfig__ItemAssignment_1
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__ItemAssignment_1_in_rule__PortInstanceConfig__Group__1__Impl5819);
            rule__PortInstanceConfig__ItemAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPortInstanceConfigAccess().getItemAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2902:1: rule__PortInstanceConfig__Group__2 : rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3 ;
    public final void rule__PortInstanceConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2906:1: ( rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2907:2: rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__2__Impl_in_rule__PortInstanceConfig__Group__25849);
            rule__PortInstanceConfig__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__3_in_rule__PortInstanceConfig__Group__25852);
            rule__PortInstanceConfig__Group__3();

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
    // $ANTLR end "rule__PortInstanceConfig__Group__2"


    // $ANTLR start "rule__PortInstanceConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2914:1: rule__PortInstanceConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__PortInstanceConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2918:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2919:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2919:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2920:1: '{'
            {
             before(grammarAccess.getPortInstanceConfigAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,19,FOLLOW_19_in_rule__PortInstanceConfig__Group__2__Impl5880); 
             after(grammarAccess.getPortInstanceConfigAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2933:1: rule__PortInstanceConfig__Group__3 : rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4 ;
    public final void rule__PortInstanceConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2937:1: ( rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2938:2: rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__3__Impl_in_rule__PortInstanceConfig__Group__35911);
            rule__PortInstanceConfig__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__4_in_rule__PortInstanceConfig__Group__35914);
            rule__PortInstanceConfig__Group__4();

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
    // $ANTLR end "rule__PortInstanceConfig__Group__3"


    // $ANTLR start "rule__PortInstanceConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2945:1: rule__PortInstanceConfig__Group__3__Impl : ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* ) ;
    public final void rule__PortInstanceConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2949:1: ( ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2950:1: ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2950:1: ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2951:1: ( rule__PortInstanceConfig__AttributesAssignment_3 )*
            {
             before(grammarAccess.getPortInstanceConfigAccess().getAttributesAssignment_3()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2952:1: ( rule__PortInstanceConfig__AttributesAssignment_3 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==34) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2952:2: rule__PortInstanceConfig__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PortInstanceConfig__AttributesAssignment_3_in_rule__PortInstanceConfig__Group__3__Impl5941);
            	    rule__PortInstanceConfig__AttributesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getPortInstanceConfigAccess().getAttributesAssignment_3()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2962:1: rule__PortInstanceConfig__Group__4 : rule__PortInstanceConfig__Group__4__Impl ;
    public final void rule__PortInstanceConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2966:1: ( rule__PortInstanceConfig__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2967:2: rule__PortInstanceConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PortInstanceConfig__Group__4__Impl_in_rule__PortInstanceConfig__Group__45972);
            rule__PortInstanceConfig__Group__4__Impl();

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
    // $ANTLR end "rule__PortInstanceConfig__Group__4"


    // $ANTLR start "rule__PortInstanceConfig__Group__4__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2973:1: rule__PortInstanceConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__PortInstanceConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2977:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2978:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2978:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:2979:1: '}'
            {
             before(grammarAccess.getPortInstanceConfigAccess().getRightCurlyBracketKeyword_4()); 
            match(input,20,FOLLOW_20_in_rule__PortInstanceConfig__Group__4__Impl6000); 
             after(grammarAccess.getPortInstanceConfigAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3002:1: rule__AttrClassConfig__Group__0 : rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1 ;
    public final void rule__AttrClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3006:1: ( rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3007:2: rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__0__Impl_in_rule__AttrClassConfig__Group__06041);
            rule__AttrClassConfig__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrClassConfig__Group__1_in_rule__AttrClassConfig__Group__06044);
            rule__AttrClassConfig__Group__1();

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
    // $ANTLR end "rule__AttrClassConfig__Group__0"


    // $ANTLR start "rule__AttrClassConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3014:1: rule__AttrClassConfig__Group__0__Impl : ( 'Attr' ) ;
    public final void rule__AttrClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3018:1: ( ( 'Attr' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3019:1: ( 'Attr' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3019:1: ( 'Attr' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3020:1: 'Attr'
            {
             before(grammarAccess.getAttrClassConfigAccess().getAttrKeyword_0()); 
            match(input,34,FOLLOW_34_in_rule__AttrClassConfig__Group__0__Impl6072); 
             after(grammarAccess.getAttrClassConfigAccess().getAttrKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3033:1: rule__AttrClassConfig__Group__1 : rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2 ;
    public final void rule__AttrClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3037:1: ( rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3038:2: rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__1__Impl_in_rule__AttrClassConfig__Group__16103);
            rule__AttrClassConfig__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrClassConfig__Group__2_in_rule__AttrClassConfig__Group__16106);
            rule__AttrClassConfig__Group__2();

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
    // $ANTLR end "rule__AttrClassConfig__Group__1"


    // $ANTLR start "rule__AttrClassConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3045:1: rule__AttrClassConfig__Group__1__Impl : ( ( rule__AttrClassConfig__AttributeAssignment_1 ) ) ;
    public final void rule__AttrClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3049:1: ( ( ( rule__AttrClassConfig__AttributeAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3050:1: ( ( rule__AttrClassConfig__AttributeAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3050:1: ( ( rule__AttrClassConfig__AttributeAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3051:1: ( rule__AttrClassConfig__AttributeAssignment_1 )
            {
             before(grammarAccess.getAttrClassConfigAccess().getAttributeAssignment_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3052:1: ( rule__AttrClassConfig__AttributeAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3052:2: rule__AttrClassConfig__AttributeAssignment_1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__AttributeAssignment_1_in_rule__AttrClassConfig__Group__1__Impl6133);
            rule__AttrClassConfig__AttributeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAttrClassConfigAccess().getAttributeAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3062:1: rule__AttrClassConfig__Group__2 : rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3 ;
    public final void rule__AttrClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3066:1: ( rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3067:2: rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__2__Impl_in_rule__AttrClassConfig__Group__26163);
            rule__AttrClassConfig__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrClassConfig__Group__3_in_rule__AttrClassConfig__Group__26166);
            rule__AttrClassConfig__Group__3();

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
    // $ANTLR end "rule__AttrClassConfig__Group__2"


    // $ANTLR start "rule__AttrClassConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3074:1: rule__AttrClassConfig__Group__2__Impl : ( ( rule__AttrClassConfig__Group_2__0 )? ) ;
    public final void rule__AttrClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3078:1: ( ( ( rule__AttrClassConfig__Group_2__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3079:1: ( ( rule__AttrClassConfig__Group_2__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3079:1: ( ( rule__AttrClassConfig__Group_2__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3080:1: ( rule__AttrClassConfig__Group_2__0 )?
            {
             before(grammarAccess.getAttrClassConfigAccess().getGroup_2()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3081:1: ( rule__AttrClassConfig__Group_2__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==35) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3081:2: rule__AttrClassConfig__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__Group_2__0_in_rule__AttrClassConfig__Group__2__Impl6193);
                    rule__AttrClassConfig__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttrClassConfigAccess().getGroup_2()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3091:1: rule__AttrClassConfig__Group__3 : rule__AttrClassConfig__Group__3__Impl ;
    public final void rule__AttrClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3095:1: ( rule__AttrClassConfig__Group__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3096:2: rule__AttrClassConfig__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group__3__Impl_in_rule__AttrClassConfig__Group__36224);
            rule__AttrClassConfig__Group__3__Impl();

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
    // $ANTLR end "rule__AttrClassConfig__Group__3"


    // $ANTLR start "rule__AttrClassConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3102:1: rule__AttrClassConfig__Group__3__Impl : ( ( rule__AttrClassConfig__Group_3__0 )? ) ;
    public final void rule__AttrClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3106:1: ( ( ( rule__AttrClassConfig__Group_3__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3107:1: ( ( rule__AttrClassConfig__Group_3__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3107:1: ( ( rule__AttrClassConfig__Group_3__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3108:1: ( rule__AttrClassConfig__Group_3__0 )?
            {
             before(grammarAccess.getAttrClassConfigAccess().getGroup_3()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3109:1: ( rule__AttrClassConfig__Group_3__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==19) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3109:2: rule__AttrClassConfig__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__0_in_rule__AttrClassConfig__Group__3__Impl6251);
                    rule__AttrClassConfig__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttrClassConfigAccess().getGroup_3()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3127:1: rule__AttrClassConfig__Group_2__0 : rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1 ;
    public final void rule__AttrClassConfig__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3131:1: ( rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3132:2: rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_2__0__Impl_in_rule__AttrClassConfig__Group_2__06290);
            rule__AttrClassConfig__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrClassConfig__Group_2__1_in_rule__AttrClassConfig__Group_2__06293);
            rule__AttrClassConfig__Group_2__1();

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
    // $ANTLR end "rule__AttrClassConfig__Group_2__0"


    // $ANTLR start "rule__AttrClassConfig__Group_2__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3139:1: rule__AttrClassConfig__Group_2__0__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3143:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3144:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3144:1: ( '=' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3145:1: '='
            {
             before(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_2_0()); 
            match(input,35,FOLLOW_35_in_rule__AttrClassConfig__Group_2__0__Impl6321); 
             after(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3158:1: rule__AttrClassConfig__Group_2__1 : rule__AttrClassConfig__Group_2__1__Impl ;
    public final void rule__AttrClassConfig__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3162:1: ( rule__AttrClassConfig__Group_2__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3163:2: rule__AttrClassConfig__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_2__1__Impl_in_rule__AttrClassConfig__Group_2__16352);
            rule__AttrClassConfig__Group_2__1__Impl();

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
    // $ANTLR end "rule__AttrClassConfig__Group_2__1"


    // $ANTLR start "rule__AttrClassConfig__Group_2__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3169:1: rule__AttrClassConfig__Group_2__1__Impl : ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) ) ;
    public final void rule__AttrClassConfig__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3173:1: ( ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3174:1: ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3174:1: ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3175:1: ( rule__AttrClassConfig__ValueAssignment_2_1 )
            {
             before(grammarAccess.getAttrClassConfigAccess().getValueAssignment_2_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3176:1: ( rule__AttrClassConfig__ValueAssignment_2_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3176:2: rule__AttrClassConfig__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__ValueAssignment_2_1_in_rule__AttrClassConfig__Group_2__1__Impl6379);
            rule__AttrClassConfig__ValueAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getAttrClassConfigAccess().getValueAssignment_2_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3190:1: rule__AttrClassConfig__Group_3__0 : rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1 ;
    public final void rule__AttrClassConfig__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3194:1: ( rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3195:2: rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__0__Impl_in_rule__AttrClassConfig__Group_3__06413);
            rule__AttrClassConfig__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__1_in_rule__AttrClassConfig__Group_3__06416);
            rule__AttrClassConfig__Group_3__1();

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
    // $ANTLR end "rule__AttrClassConfig__Group_3__0"


    // $ANTLR start "rule__AttrClassConfig__Group_3__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3202:1: rule__AttrClassConfig__Group_3__0__Impl : ( '{' ) ;
    public final void rule__AttrClassConfig__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3206:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3207:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3207:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3208:1: '{'
            {
             before(grammarAccess.getAttrClassConfigAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,19,FOLLOW_19_in_rule__AttrClassConfig__Group_3__0__Impl6444); 
             after(grammarAccess.getAttrClassConfigAccess().getLeftCurlyBracketKeyword_3_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3221:1: rule__AttrClassConfig__Group_3__1 : rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2 ;
    public final void rule__AttrClassConfig__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3225:1: ( rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3226:2: rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__1__Impl_in_rule__AttrClassConfig__Group_3__16475);
            rule__AttrClassConfig__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__2_in_rule__AttrClassConfig__Group_3__16478);
            rule__AttrClassConfig__Group_3__2();

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
    // $ANTLR end "rule__AttrClassConfig__Group_3__1"


    // $ANTLR start "rule__AttrClassConfig__Group_3__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3233:1: rule__AttrClassConfig__Group_3__1__Impl : ( ( rule__AttrClassConfig__UnorderedGroup_3_1 ) ) ;
    public final void rule__AttrClassConfig__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3237:1: ( ( ( rule__AttrClassConfig__UnorderedGroup_3_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3238:1: ( ( rule__AttrClassConfig__UnorderedGroup_3_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3238:1: ( ( rule__AttrClassConfig__UnorderedGroup_3_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3239:1: ( rule__AttrClassConfig__UnorderedGroup_3_1 )
            {
             before(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3240:1: ( rule__AttrClassConfig__UnorderedGroup_3_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3240:2: rule__AttrClassConfig__UnorderedGroup_3_1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1_in_rule__AttrClassConfig__Group_3__1__Impl6505);
            rule__AttrClassConfig__UnorderedGroup_3_1();

            state._fsp--;


            }

             after(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3250:1: rule__AttrClassConfig__Group_3__2 : rule__AttrClassConfig__Group_3__2__Impl rule__AttrClassConfig__Group_3__3 ;
    public final void rule__AttrClassConfig__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3254:1: ( rule__AttrClassConfig__Group_3__2__Impl rule__AttrClassConfig__Group_3__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3255:2: rule__AttrClassConfig__Group_3__2__Impl rule__AttrClassConfig__Group_3__3
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__2__Impl_in_rule__AttrClassConfig__Group_3__26535);
            rule__AttrClassConfig__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__3_in_rule__AttrClassConfig__Group_3__26538);
            rule__AttrClassConfig__Group_3__3();

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
    // $ANTLR end "rule__AttrClassConfig__Group_3__2"


    // $ANTLR start "rule__AttrClassConfig__Group_3__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3262:1: rule__AttrClassConfig__Group_3__2__Impl : ( ( rule__AttrClassConfig__AttributesAssignment_3_2 )* ) ;
    public final void rule__AttrClassConfig__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3266:1: ( ( ( rule__AttrClassConfig__AttributesAssignment_3_2 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3267:1: ( ( rule__AttrClassConfig__AttributesAssignment_3_2 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3267:1: ( ( rule__AttrClassConfig__AttributesAssignment_3_2 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3268:1: ( rule__AttrClassConfig__AttributesAssignment_3_2 )*
            {
             before(grammarAccess.getAttrClassConfigAccess().getAttributesAssignment_3_2()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3269:1: ( rule__AttrClassConfig__AttributesAssignment_3_2 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==34) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3269:2: rule__AttrClassConfig__AttributesAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_rule__AttrClassConfig__AttributesAssignment_3_2_in_rule__AttrClassConfig__Group_3__2__Impl6565);
            	    rule__AttrClassConfig__AttributesAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getAttrClassConfigAccess().getAttributesAssignment_3_2()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3279:1: rule__AttrClassConfig__Group_3__3 : rule__AttrClassConfig__Group_3__3__Impl ;
    public final void rule__AttrClassConfig__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3283:1: ( rule__AttrClassConfig__Group_3__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3284:2: rule__AttrClassConfig__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3__3__Impl_in_rule__AttrClassConfig__Group_3__36596);
            rule__AttrClassConfig__Group_3__3__Impl();

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
    // $ANTLR end "rule__AttrClassConfig__Group_3__3"


    // $ANTLR start "rule__AttrClassConfig__Group_3__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3290:1: rule__AttrClassConfig__Group_3__3__Impl : ( '}' ) ;
    public final void rule__AttrClassConfig__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3294:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3295:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3295:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3296:1: '}'
            {
             before(grammarAccess.getAttrClassConfigAccess().getRightCurlyBracketKeyword_3_3()); 
            match(input,20,FOLLOW_20_in_rule__AttrClassConfig__Group_3__3__Impl6624); 
             after(grammarAccess.getAttrClassConfigAccess().getRightCurlyBracketKeyword_3_3()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3317:1: rule__AttrClassConfig__Group_3_1_0__0 : rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1 ;
    public final void rule__AttrClassConfig__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3321:1: ( rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3322:2: rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__0__Impl_in_rule__AttrClassConfig__Group_3_1_0__06663);
            rule__AttrClassConfig__Group_3_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__1_in_rule__AttrClassConfig__Group_3_1_0__06666);
            rule__AttrClassConfig__Group_3_1_0__1();

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_0__0"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3329:1: rule__AttrClassConfig__Group_3_1_0__0__Impl : ( 'min' ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3333:1: ( ( 'min' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3334:1: ( 'min' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3334:1: ( 'min' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3335:1: 'min'
            {
             before(grammarAccess.getAttrClassConfigAccess().getMinKeyword_3_1_0_0()); 
            match(input,36,FOLLOW_36_in_rule__AttrClassConfig__Group_3_1_0__0__Impl6694); 
             after(grammarAccess.getAttrClassConfigAccess().getMinKeyword_3_1_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3348:1: rule__AttrClassConfig__Group_3_1_0__1 : rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2 ;
    public final void rule__AttrClassConfig__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3352:1: ( rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3353:2: rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__1__Impl_in_rule__AttrClassConfig__Group_3_1_0__16725);
            rule__AttrClassConfig__Group_3_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__2_in_rule__AttrClassConfig__Group_3_1_0__16728);
            rule__AttrClassConfig__Group_3_1_0__2();

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_0__1"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3360:1: rule__AttrClassConfig__Group_3_1_0__1__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3364:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3365:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3365:1: ( '=' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3366:1: '='
            {
             before(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_0_1()); 
            match(input,35,FOLLOW_35_in_rule__AttrClassConfig__Group_3_1_0__1__Impl6756); 
             after(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_0_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3379:1: rule__AttrClassConfig__Group_3_1_0__2 : rule__AttrClassConfig__Group_3_1_0__2__Impl ;
    public final void rule__AttrClassConfig__Group_3_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3383:1: ( rule__AttrClassConfig__Group_3_1_0__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3384:2: rule__AttrClassConfig__Group_3_1_0__2__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__2__Impl_in_rule__AttrClassConfig__Group_3_1_0__26787);
            rule__AttrClassConfig__Group_3_1_0__2__Impl();

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_0__2"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_0__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3390:1: rule__AttrClassConfig__Group_3_1_0__2__Impl : ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3394:1: ( ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3395:1: ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3395:1: ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3396:1: ( rule__AttrClassConfig__MinAssignment_3_1_0_2 )
            {
             before(grammarAccess.getAttrClassConfigAccess().getMinAssignment_3_1_0_2()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3397:1: ( rule__AttrClassConfig__MinAssignment_3_1_0_2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3397:2: rule__AttrClassConfig__MinAssignment_3_1_0_2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__MinAssignment_3_1_0_2_in_rule__AttrClassConfig__Group_3_1_0__2__Impl6814);
            rule__AttrClassConfig__MinAssignment_3_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getAttrClassConfigAccess().getMinAssignment_3_1_0_2()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3413:1: rule__AttrClassConfig__Group_3_1_1__0 : rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1 ;
    public final void rule__AttrClassConfig__Group_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3417:1: ( rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3418:2: rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__0__Impl_in_rule__AttrClassConfig__Group_3_1_1__06850);
            rule__AttrClassConfig__Group_3_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__1_in_rule__AttrClassConfig__Group_3_1_1__06853);
            rule__AttrClassConfig__Group_3_1_1__1();

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_1__0"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3425:1: rule__AttrClassConfig__Group_3_1_1__0__Impl : ( 'max' ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3429:1: ( ( 'max' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3430:1: ( 'max' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3430:1: ( 'max' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3431:1: 'max'
            {
             before(grammarAccess.getAttrClassConfigAccess().getMaxKeyword_3_1_1_0()); 
            match(input,37,FOLLOW_37_in_rule__AttrClassConfig__Group_3_1_1__0__Impl6881); 
             after(grammarAccess.getAttrClassConfigAccess().getMaxKeyword_3_1_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3444:1: rule__AttrClassConfig__Group_3_1_1__1 : rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2 ;
    public final void rule__AttrClassConfig__Group_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3448:1: ( rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3449:2: rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__1__Impl_in_rule__AttrClassConfig__Group_3_1_1__16912);
            rule__AttrClassConfig__Group_3_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__2_in_rule__AttrClassConfig__Group_3_1_1__16915);
            rule__AttrClassConfig__Group_3_1_1__2();

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_1__1"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3456:1: rule__AttrClassConfig__Group_3_1_1__1__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3460:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3461:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3461:1: ( '=' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3462:1: '='
            {
             before(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_1_1()); 
            match(input,35,FOLLOW_35_in_rule__AttrClassConfig__Group_3_1_1__1__Impl6943); 
             after(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_1_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3475:1: rule__AttrClassConfig__Group_3_1_1__2 : rule__AttrClassConfig__Group_3_1_1__2__Impl ;
    public final void rule__AttrClassConfig__Group_3_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3479:1: ( rule__AttrClassConfig__Group_3_1_1__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3480:2: rule__AttrClassConfig__Group_3_1_1__2__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__2__Impl_in_rule__AttrClassConfig__Group_3_1_1__26974);
            rule__AttrClassConfig__Group_3_1_1__2__Impl();

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
    // $ANTLR end "rule__AttrClassConfig__Group_3_1_1__2"


    // $ANTLR start "rule__AttrClassConfig__Group_3_1_1__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3486:1: rule__AttrClassConfig__Group_3_1_1__2__Impl : ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3490:1: ( ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3491:1: ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3491:1: ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3492:1: ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 )
            {
             before(grammarAccess.getAttrClassConfigAccess().getMaxAssignment_3_1_1_2()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3493:1: ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3493:2: rule__AttrClassConfig__MaxAssignment_3_1_1_2
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__MaxAssignment_3_1_1_2_in_rule__AttrClassConfig__Group_3_1_1__2__Impl7001);
            rule__AttrClassConfig__MaxAssignment_3_1_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAttrClassConfigAccess().getMaxAssignment_3_1_1_2()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3509:1: rule__AttrInstanceConfig__Group__0 : rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1 ;
    public final void rule__AttrInstanceConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3513:1: ( rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3514:2: rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__0__Impl_in_rule__AttrInstanceConfig__Group__07037);
            rule__AttrInstanceConfig__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__1_in_rule__AttrInstanceConfig__Group__07040);
            rule__AttrInstanceConfig__Group__1();

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
    // $ANTLR end "rule__AttrInstanceConfig__Group__0"


    // $ANTLR start "rule__AttrInstanceConfig__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3521:1: rule__AttrInstanceConfig__Group__0__Impl : ( 'Attr' ) ;
    public final void rule__AttrInstanceConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3525:1: ( ( 'Attr' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3526:1: ( 'Attr' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3526:1: ( 'Attr' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3527:1: 'Attr'
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getAttrKeyword_0()); 
            match(input,34,FOLLOW_34_in_rule__AttrInstanceConfig__Group__0__Impl7068); 
             after(grammarAccess.getAttrInstanceConfigAccess().getAttrKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3540:1: rule__AttrInstanceConfig__Group__1 : rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2 ;
    public final void rule__AttrInstanceConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3544:1: ( rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3545:2: rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__1__Impl_in_rule__AttrInstanceConfig__Group__17099);
            rule__AttrInstanceConfig__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__2_in_rule__AttrInstanceConfig__Group__17102);
            rule__AttrInstanceConfig__Group__2();

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
    // $ANTLR end "rule__AttrInstanceConfig__Group__1"


    // $ANTLR start "rule__AttrInstanceConfig__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3552:1: rule__AttrInstanceConfig__Group__1__Impl : ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3556:1: ( ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3557:1: ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3557:1: ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3558:1: ( rule__AttrInstanceConfig__AttributeAssignment_1 )
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAssignment_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3559:1: ( rule__AttrInstanceConfig__AttributeAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3559:2: rule__AttrInstanceConfig__AttributeAssignment_1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__AttributeAssignment_1_in_rule__AttrInstanceConfig__Group__1__Impl7129);
            rule__AttrInstanceConfig__AttributeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAttrInstanceConfigAccess().getAttributeAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3569:1: rule__AttrInstanceConfig__Group__2 : rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3 ;
    public final void rule__AttrInstanceConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3573:1: ( rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3574:2: rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__2__Impl_in_rule__AttrInstanceConfig__Group__27159);
            rule__AttrInstanceConfig__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__3_in_rule__AttrInstanceConfig__Group__27162);
            rule__AttrInstanceConfig__Group__3();

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
    // $ANTLR end "rule__AttrInstanceConfig__Group__2"


    // $ANTLR start "rule__AttrInstanceConfig__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3581:1: rule__AttrInstanceConfig__Group__2__Impl : ( ( rule__AttrInstanceConfig__Group_2__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3585:1: ( ( ( rule__AttrInstanceConfig__Group_2__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3586:1: ( ( rule__AttrInstanceConfig__Group_2__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3586:1: ( ( rule__AttrInstanceConfig__Group_2__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3587:1: ( rule__AttrInstanceConfig__Group_2__0 )?
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getGroup_2()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3588:1: ( rule__AttrInstanceConfig__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==35) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3588:2: rule__AttrInstanceConfig__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_2__0_in_rule__AttrInstanceConfig__Group__2__Impl7189);
                    rule__AttrInstanceConfig__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttrInstanceConfigAccess().getGroup_2()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3598:1: rule__AttrInstanceConfig__Group__3 : rule__AttrInstanceConfig__Group__3__Impl ;
    public final void rule__AttrInstanceConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3602:1: ( rule__AttrInstanceConfig__Group__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3603:2: rule__AttrInstanceConfig__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group__3__Impl_in_rule__AttrInstanceConfig__Group__37220);
            rule__AttrInstanceConfig__Group__3__Impl();

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
    // $ANTLR end "rule__AttrInstanceConfig__Group__3"


    // $ANTLR start "rule__AttrInstanceConfig__Group__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3609:1: rule__AttrInstanceConfig__Group__3__Impl : ( ( rule__AttrInstanceConfig__Group_3__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3613:1: ( ( ( rule__AttrInstanceConfig__Group_3__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3614:1: ( ( rule__AttrInstanceConfig__Group_3__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3614:1: ( ( rule__AttrInstanceConfig__Group_3__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3615:1: ( rule__AttrInstanceConfig__Group_3__0 )?
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getGroup_3()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3616:1: ( rule__AttrInstanceConfig__Group_3__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==19) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3616:2: rule__AttrInstanceConfig__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__0_in_rule__AttrInstanceConfig__Group__3__Impl7247);
                    rule__AttrInstanceConfig__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttrInstanceConfigAccess().getGroup_3()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3634:1: rule__AttrInstanceConfig__Group_2__0 : rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1 ;
    public final void rule__AttrInstanceConfig__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3638:1: ( rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3639:2: rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_2__0__Impl_in_rule__AttrInstanceConfig__Group_2__07286);
            rule__AttrInstanceConfig__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_2__1_in_rule__AttrInstanceConfig__Group_2__07289);
            rule__AttrInstanceConfig__Group_2__1();

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_2__0"


    // $ANTLR start "rule__AttrInstanceConfig__Group_2__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3646:1: rule__AttrInstanceConfig__Group_2__0__Impl : ( '=' ) ;
    public final void rule__AttrInstanceConfig__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3650:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3651:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3651:1: ( '=' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3652:1: '='
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getEqualsSignKeyword_2_0()); 
            match(input,35,FOLLOW_35_in_rule__AttrInstanceConfig__Group_2__0__Impl7317); 
             after(grammarAccess.getAttrInstanceConfigAccess().getEqualsSignKeyword_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3665:1: rule__AttrInstanceConfig__Group_2__1 : rule__AttrInstanceConfig__Group_2__1__Impl ;
    public final void rule__AttrInstanceConfig__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3669:1: ( rule__AttrInstanceConfig__Group_2__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3670:2: rule__AttrInstanceConfig__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_2__1__Impl_in_rule__AttrInstanceConfig__Group_2__17348);
            rule__AttrInstanceConfig__Group_2__1__Impl();

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_2__1"


    // $ANTLR start "rule__AttrInstanceConfig__Group_2__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3676:1: rule__AttrInstanceConfig__Group_2__1__Impl : ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3680:1: ( ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3681:1: ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3681:1: ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3682:1: ( rule__AttrInstanceConfig__ValueAssignment_2_1 )
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getValueAssignment_2_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3683:1: ( rule__AttrInstanceConfig__ValueAssignment_2_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3683:2: rule__AttrInstanceConfig__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__ValueAssignment_2_1_in_rule__AttrInstanceConfig__Group_2__1__Impl7375);
            rule__AttrInstanceConfig__ValueAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getAttrInstanceConfigAccess().getValueAssignment_2_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3697:1: rule__AttrInstanceConfig__Group_3__0 : rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1 ;
    public final void rule__AttrInstanceConfig__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3701:1: ( rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3702:2: rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__0__Impl_in_rule__AttrInstanceConfig__Group_3__07409);
            rule__AttrInstanceConfig__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__1_in_rule__AttrInstanceConfig__Group_3__07412);
            rule__AttrInstanceConfig__Group_3__1();

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3__0"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3709:1: rule__AttrInstanceConfig__Group_3__0__Impl : ( '{' ) ;
    public final void rule__AttrInstanceConfig__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3713:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3714:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3714:1: ( '{' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3715:1: '{'
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,19,FOLLOW_19_in_rule__AttrInstanceConfig__Group_3__0__Impl7440); 
             after(grammarAccess.getAttrInstanceConfigAccess().getLeftCurlyBracketKeyword_3_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3728:1: rule__AttrInstanceConfig__Group_3__1 : rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2 ;
    public final void rule__AttrInstanceConfig__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3732:1: ( rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3733:2: rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__1__Impl_in_rule__AttrInstanceConfig__Group_3__17471);
            rule__AttrInstanceConfig__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__2_in_rule__AttrInstanceConfig__Group_3__17474);
            rule__AttrInstanceConfig__Group_3__2();

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3__1"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3740:1: rule__AttrInstanceConfig__Group_3__1__Impl : ( ( rule__AttrInstanceConfig__Group_3_1__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3744:1: ( ( ( rule__AttrInstanceConfig__Group_3_1__0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3745:1: ( ( rule__AttrInstanceConfig__Group_3_1__0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3745:1: ( ( rule__AttrInstanceConfig__Group_3_1__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3746:1: ( rule__AttrInstanceConfig__Group_3_1__0 )?
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3747:1: ( rule__AttrInstanceConfig__Group_3_1__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==21) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3747:2: rule__AttrInstanceConfig__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1__0_in_rule__AttrInstanceConfig__Group_3__1__Impl7501);
                    rule__AttrInstanceConfig__Group_3_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3757:1: rule__AttrInstanceConfig__Group_3__2 : rule__AttrInstanceConfig__Group_3__2__Impl rule__AttrInstanceConfig__Group_3__3 ;
    public final void rule__AttrInstanceConfig__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3761:1: ( rule__AttrInstanceConfig__Group_3__2__Impl rule__AttrInstanceConfig__Group_3__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3762:2: rule__AttrInstanceConfig__Group_3__2__Impl rule__AttrInstanceConfig__Group_3__3
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__2__Impl_in_rule__AttrInstanceConfig__Group_3__27532);
            rule__AttrInstanceConfig__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__3_in_rule__AttrInstanceConfig__Group_3__27535);
            rule__AttrInstanceConfig__Group_3__3();

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3__2"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3769:1: rule__AttrInstanceConfig__Group_3__2__Impl : ( ( rule__AttrInstanceConfig__AttributesAssignment_3_2 )* ) ;
    public final void rule__AttrInstanceConfig__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3773:1: ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_2 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3774:1: ( ( rule__AttrInstanceConfig__AttributesAssignment_3_2 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3774:1: ( ( rule__AttrInstanceConfig__AttributesAssignment_3_2 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3775:1: ( rule__AttrInstanceConfig__AttributesAssignment_3_2 )*
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getAttributesAssignment_3_2()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3776:1: ( rule__AttrInstanceConfig__AttributesAssignment_3_2 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==34) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3776:2: rule__AttrInstanceConfig__AttributesAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_rule__AttrInstanceConfig__AttributesAssignment_3_2_in_rule__AttrInstanceConfig__Group_3__2__Impl7562);
            	    rule__AttrInstanceConfig__AttributesAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getAttrInstanceConfigAccess().getAttributesAssignment_3_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__AttrInstanceConfig__Group_3__3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3786:1: rule__AttrInstanceConfig__Group_3__3 : rule__AttrInstanceConfig__Group_3__3__Impl ;
    public final void rule__AttrInstanceConfig__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3790:1: ( rule__AttrInstanceConfig__Group_3__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3791:2: rule__AttrInstanceConfig__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3__3__Impl_in_rule__AttrInstanceConfig__Group_3__37593);
            rule__AttrInstanceConfig__Group_3__3__Impl();

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3__3"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3__3__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3797:1: rule__AttrInstanceConfig__Group_3__3__Impl : ( '}' ) ;
    public final void rule__AttrInstanceConfig__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3801:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3802:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3802:1: ( '}' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3803:1: '}'
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getRightCurlyBracketKeyword_3_3()); 
            match(input,20,FOLLOW_20_in_rule__AttrInstanceConfig__Group_3__3__Impl7621); 
             after(grammarAccess.getAttrInstanceConfigAccess().getRightCurlyBracketKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrInstanceConfig__Group_3__3__Impl"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3_1__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3824:1: rule__AttrInstanceConfig__Group_3_1__0 : rule__AttrInstanceConfig__Group_3_1__0__Impl rule__AttrInstanceConfig__Group_3_1__1 ;
    public final void rule__AttrInstanceConfig__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3828:1: ( rule__AttrInstanceConfig__Group_3_1__0__Impl rule__AttrInstanceConfig__Group_3_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3829:2: rule__AttrInstanceConfig__Group_3_1__0__Impl rule__AttrInstanceConfig__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1__0__Impl_in_rule__AttrInstanceConfig__Group_3_1__07660);
            rule__AttrInstanceConfig__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1__1_in_rule__AttrInstanceConfig__Group_3_1__07663);
            rule__AttrInstanceConfig__Group_3_1__1();

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3_1__0"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3836:1: rule__AttrInstanceConfig__Group_3_1__0__Impl : ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3840:1: ( ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3841:1: ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3841:1: ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3842:1: ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0 )
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigAssignment_3_1_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3843:1: ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3843:2: rule__AttrInstanceConfig__DynConfigAssignment_3_1_0
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_in_rule__AttrInstanceConfig__Group_3_1__0__Impl7690);
            rule__AttrInstanceConfig__DynConfigAssignment_3_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAttrInstanceConfigAccess().getDynConfigAssignment_3_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3853:1: rule__AttrInstanceConfig__Group_3_1__1 : rule__AttrInstanceConfig__Group_3_1__1__Impl ;
    public final void rule__AttrInstanceConfig__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3857:1: ( rule__AttrInstanceConfig__Group_3_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3858:2: rule__AttrInstanceConfig__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Group_3_1__1__Impl_in_rule__AttrInstanceConfig__Group_3_1__17720);
            rule__AttrInstanceConfig__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__AttrInstanceConfig__Group_3_1__1"


    // $ANTLR start "rule__AttrInstanceConfig__Group_3_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3864:1: rule__AttrInstanceConfig__Group_3_1__1__Impl : ( ( rule__AttrInstanceConfig__Alternatives_3_1_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3868:1: ( ( ( rule__AttrInstanceConfig__Alternatives_3_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3869:1: ( ( rule__AttrInstanceConfig__Alternatives_3_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3869:1: ( ( rule__AttrInstanceConfig__Alternatives_3_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3870:1: ( rule__AttrInstanceConfig__Alternatives_3_1_1 )
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getAlternatives_3_1_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3871:1: ( rule__AttrInstanceConfig__Alternatives_3_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3871:2: rule__AttrInstanceConfig__Alternatives_3_1_1
            {
            pushFollow(FOLLOW_rule__AttrInstanceConfig__Alternatives_3_1_1_in_rule__AttrInstanceConfig__Group_3_1__1__Impl7747);
            rule__AttrInstanceConfig__Alternatives_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAttrInstanceConfigAccess().getAlternatives_3_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__RefPath__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3885:1: rule__RefPath__Group__0 : rule__RefPath__Group__0__Impl rule__RefPath__Group__1 ;
    public final void rule__RefPath__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3889:1: ( rule__RefPath__Group__0__Impl rule__RefPath__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3890:2: rule__RefPath__Group__0__Impl rule__RefPath__Group__1
            {
            pushFollow(FOLLOW_rule__RefPath__Group__0__Impl_in_rule__RefPath__Group__07781);
            rule__RefPath__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RefPath__Group__1_in_rule__RefPath__Group__07784);
            rule__RefPath__Group__1();

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
    // $ANTLR end "rule__RefPath__Group__0"


    // $ANTLR start "rule__RefPath__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3897:1: rule__RefPath__Group__0__Impl : ( ( rule__RefPath__RefsAssignment_0 ) ) ;
    public final void rule__RefPath__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3901:1: ( ( ( rule__RefPath__RefsAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3902:1: ( ( rule__RefPath__RefsAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3902:1: ( ( rule__RefPath__RefsAssignment_0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3903:1: ( rule__RefPath__RefsAssignment_0 )
            {
             before(grammarAccess.getRefPathAccess().getRefsAssignment_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3904:1: ( rule__RefPath__RefsAssignment_0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3904:2: rule__RefPath__RefsAssignment_0
            {
            pushFollow(FOLLOW_rule__RefPath__RefsAssignment_0_in_rule__RefPath__Group__0__Impl7811);
            rule__RefPath__RefsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRefPathAccess().getRefsAssignment_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3914:1: rule__RefPath__Group__1 : rule__RefPath__Group__1__Impl ;
    public final void rule__RefPath__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3918:1: ( rule__RefPath__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3919:2: rule__RefPath__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RefPath__Group__1__Impl_in_rule__RefPath__Group__17841);
            rule__RefPath__Group__1__Impl();

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
    // $ANTLR end "rule__RefPath__Group__1"


    // $ANTLR start "rule__RefPath__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3925:1: rule__RefPath__Group__1__Impl : ( ( rule__RefPath__Group_1__0 )* ) ;
    public final void rule__RefPath__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3929:1: ( ( ( rule__RefPath__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3930:1: ( ( rule__RefPath__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3930:1: ( ( rule__RefPath__Group_1__0 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3931:1: ( rule__RefPath__Group_1__0 )*
            {
             before(grammarAccess.getRefPathAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3932:1: ( rule__RefPath__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==28) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3932:2: rule__RefPath__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__RefPath__Group_1__0_in_rule__RefPath__Group__1__Impl7868);
            	    rule__RefPath__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getRefPathAccess().getGroup_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3946:1: rule__RefPath__Group_1__0 : rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1 ;
    public final void rule__RefPath__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3950:1: ( rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3951:2: rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1
            {
            pushFollow(FOLLOW_rule__RefPath__Group_1__0__Impl_in_rule__RefPath__Group_1__07903);
            rule__RefPath__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RefPath__Group_1__1_in_rule__RefPath__Group_1__07906);
            rule__RefPath__Group_1__1();

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
    // $ANTLR end "rule__RefPath__Group_1__0"


    // $ANTLR start "rule__RefPath__Group_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3958:1: rule__RefPath__Group_1__0__Impl : ( '/' ) ;
    public final void rule__RefPath__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3962:1: ( ( '/' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3963:1: ( '/' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3963:1: ( '/' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3964:1: '/'
            {
             before(grammarAccess.getRefPathAccess().getSolidusKeyword_1_0()); 
            match(input,28,FOLLOW_28_in_rule__RefPath__Group_1__0__Impl7934); 
             after(grammarAccess.getRefPathAccess().getSolidusKeyword_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3977:1: rule__RefPath__Group_1__1 : rule__RefPath__Group_1__1__Impl ;
    public final void rule__RefPath__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3981:1: ( rule__RefPath__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3982:2: rule__RefPath__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__RefPath__Group_1__1__Impl_in_rule__RefPath__Group_1__17965);
            rule__RefPath__Group_1__1__Impl();

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
    // $ANTLR end "rule__RefPath__Group_1__1"


    // $ANTLR start "rule__RefPath__Group_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3988:1: rule__RefPath__Group_1__1__Impl : ( ( rule__RefPath__RefsAssignment_1_1 ) ) ;
    public final void rule__RefPath__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3992:1: ( ( ( rule__RefPath__RefsAssignment_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3993:1: ( ( rule__RefPath__RefsAssignment_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3993:1: ( ( rule__RefPath__RefsAssignment_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3994:1: ( rule__RefPath__RefsAssignment_1_1 )
            {
             before(grammarAccess.getRefPathAccess().getRefsAssignment_1_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3995:1: ( rule__RefPath__RefsAssignment_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:3995:2: rule__RefPath__RefsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RefPath__RefsAssignment_1_1_in_rule__RefPath__Group_1__1__Impl7992);
            rule__RefPath__RefsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getRefPathAccess().getRefsAssignment_1_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4009:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4013:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4014:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__08026);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__08029);
            rule__Import__Group__1();

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
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4021:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4025:1: ( ( 'import' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4026:1: ( 'import' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4026:1: ( 'import' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4027:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,38,FOLLOW_38_in_rule__Import__Group__0__Impl8057); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4040:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4044:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4045:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__18088);
            rule__Import__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__2_in_rule__Import__Group__18091);
            rule__Import__Group__2();

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
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4052:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4056:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4057:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4057:1: ( ( rule__Import__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4058:1: ( rule__Import__Alternatives_1 )
            {
             before(grammarAccess.getImportAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4059:1: ( rule__Import__Alternatives_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4059:2: rule__Import__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl8118);
            rule__Import__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getAlternatives_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4069:1: rule__Import__Group__2 : rule__Import__Group__2__Impl ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4073:1: ( rule__Import__Group__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4074:2: rule__Import__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__28148);
            rule__Import__Group__2__Impl();

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
    // $ANTLR end "rule__Import__Group__2"


    // $ANTLR start "rule__Import__Group__2__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4080:1: rule__Import__Group__2__Impl : ( ( rule__Import__ImportURIAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4084:1: ( ( ( rule__Import__ImportURIAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4085:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4085:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4086:1: ( rule__Import__ImportURIAssignment_2 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_2()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4087:1: ( rule__Import__ImportURIAssignment_2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4087:2: rule__Import__ImportURIAssignment_2
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl8175);
            rule__Import__ImportURIAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_2()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4103:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4107:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4108:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__08211);
            rule__Import__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__08214);
            rule__Import__Group_1_0__1();

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
    // $ANTLR end "rule__Import__Group_1_0__0"


    // $ANTLR start "rule__Import__Group_1_0__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4115:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4119:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4120:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4120:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4121:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4122:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4122:2: rule__Import__ImportedNamespaceAssignment_1_0_0
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl8241);
            rule__Import__ImportedNamespaceAssignment_1_0_0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4132:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4136:1: ( rule__Import__Group_1_0__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4137:2: rule__Import__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__18271);
            rule__Import__Group_1_0__1__Impl();

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
    // $ANTLR end "rule__Import__Group_1_0__1"


    // $ANTLR start "rule__Import__Group_1_0__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4143:1: rule__Import__Group_1_0__1__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4147:1: ( ( 'from' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4148:1: ( 'from' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4148:1: ( 'from' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4149:1: 'from'
            {
             before(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 
            match(input,39,FOLLOW_39_in_rule__Import__Group_1_0__1__Impl8299); 
             after(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4166:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4170:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4171:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__08334);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__08337);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4178:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4182:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4183:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4183:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4184:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl8364);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4195:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4199:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4200:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__18393);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4206:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4210:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4211:1: ( ( '.*' )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4211:1: ( ( '.*' )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4212:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4213:1: ( '.*' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==40) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4214:2: '.*'
                    {
                    match(input,40,FOLLOW_40_in_rule__ImportedFQN__Group__1__Impl8422); 

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


    // $ANTLR start "rule__FQN__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4229:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4233:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4234:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__08459);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__08462);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4241:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4245:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4246:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4246:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4247:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl8489); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4258:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4262:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4263:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__18518);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4269:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4273:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4274:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4274:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4275:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4276:1: ( rule__FQN__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==41) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4276:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl8545);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4290:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4294:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4295:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__08580);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__08583);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4302:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4306:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4307:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4307:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4308:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,41,FOLLOW_41_in_rule__FQN__Group_1__0__Impl8611); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4321:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4325:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4326:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__18642);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4332:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4336:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4337:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4337:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4338:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl8669); 
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


    // $ANTLR start "rule__LiteralArray__Group__0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4353:1: rule__LiteralArray__Group__0 : rule__LiteralArray__Group__0__Impl rule__LiteralArray__Group__1 ;
    public final void rule__LiteralArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4357:1: ( rule__LiteralArray__Group__0__Impl rule__LiteralArray__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4358:2: rule__LiteralArray__Group__0__Impl rule__LiteralArray__Group__1
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group__0__Impl_in_rule__LiteralArray__Group__08702);
            rule__LiteralArray__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LiteralArray__Group__1_in_rule__LiteralArray__Group__08705);
            rule__LiteralArray__Group__1();

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
    // $ANTLR end "rule__LiteralArray__Group__0"


    // $ANTLR start "rule__LiteralArray__Group__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4365:1: rule__LiteralArray__Group__0__Impl : ( ( rule__LiteralArray__LiteralsAssignment_0 ) ) ;
    public final void rule__LiteralArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4369:1: ( ( ( rule__LiteralArray__LiteralsAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4370:1: ( ( rule__LiteralArray__LiteralsAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4370:1: ( ( rule__LiteralArray__LiteralsAssignment_0 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4371:1: ( rule__LiteralArray__LiteralsAssignment_0 )
            {
             before(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4372:1: ( rule__LiteralArray__LiteralsAssignment_0 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4372:2: rule__LiteralArray__LiteralsAssignment_0
            {
            pushFollow(FOLLOW_rule__LiteralArray__LiteralsAssignment_0_in_rule__LiteralArray__Group__0__Impl8732);
            rule__LiteralArray__LiteralsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4382:1: rule__LiteralArray__Group__1 : rule__LiteralArray__Group__1__Impl ;
    public final void rule__LiteralArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4386:1: ( rule__LiteralArray__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4387:2: rule__LiteralArray__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group__1__Impl_in_rule__LiteralArray__Group__18762);
            rule__LiteralArray__Group__1__Impl();

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
    // $ANTLR end "rule__LiteralArray__Group__1"


    // $ANTLR start "rule__LiteralArray__Group__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4393:1: rule__LiteralArray__Group__1__Impl : ( ( rule__LiteralArray__Group_1__0 )* ) ;
    public final void rule__LiteralArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4397:1: ( ( ( rule__LiteralArray__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4398:1: ( ( rule__LiteralArray__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4398:1: ( ( rule__LiteralArray__Group_1__0 )* )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4399:1: ( rule__LiteralArray__Group_1__0 )*
            {
             before(grammarAccess.getLiteralArrayAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4400:1: ( rule__LiteralArray__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==42) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4400:2: rule__LiteralArray__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__LiteralArray__Group_1__0_in_rule__LiteralArray__Group__1__Impl8789);
            	    rule__LiteralArray__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getLiteralArrayAccess().getGroup_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4414:1: rule__LiteralArray__Group_1__0 : rule__LiteralArray__Group_1__0__Impl rule__LiteralArray__Group_1__1 ;
    public final void rule__LiteralArray__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4418:1: ( rule__LiteralArray__Group_1__0__Impl rule__LiteralArray__Group_1__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4419:2: rule__LiteralArray__Group_1__0__Impl rule__LiteralArray__Group_1__1
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group_1__0__Impl_in_rule__LiteralArray__Group_1__08824);
            rule__LiteralArray__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LiteralArray__Group_1__1_in_rule__LiteralArray__Group_1__08827);
            rule__LiteralArray__Group_1__1();

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
    // $ANTLR end "rule__LiteralArray__Group_1__0"


    // $ANTLR start "rule__LiteralArray__Group_1__0__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4426:1: rule__LiteralArray__Group_1__0__Impl : ( ',' ) ;
    public final void rule__LiteralArray__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4430:1: ( ( ',' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4431:1: ( ',' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4431:1: ( ',' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4432:1: ','
            {
             before(grammarAccess.getLiteralArrayAccess().getCommaKeyword_1_0()); 
            match(input,42,FOLLOW_42_in_rule__LiteralArray__Group_1__0__Impl8855); 
             after(grammarAccess.getLiteralArrayAccess().getCommaKeyword_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4445:1: rule__LiteralArray__Group_1__1 : rule__LiteralArray__Group_1__1__Impl ;
    public final void rule__LiteralArray__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4449:1: ( rule__LiteralArray__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4450:2: rule__LiteralArray__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group_1__1__Impl_in_rule__LiteralArray__Group_1__18886);
            rule__LiteralArray__Group_1__1__Impl();

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
    // $ANTLR end "rule__LiteralArray__Group_1__1"


    // $ANTLR start "rule__LiteralArray__Group_1__1__Impl"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4456:1: rule__LiteralArray__Group_1__1__Impl : ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) ) ;
    public final void rule__LiteralArray__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4460:1: ( ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4461:1: ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4461:1: ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4462:1: ( rule__LiteralArray__LiteralsAssignment_1_1 )
            {
             before(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_1_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4463:1: ( rule__LiteralArray__LiteralsAssignment_1_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4463:2: rule__LiteralArray__LiteralsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__LiteralArray__LiteralsAssignment_1_1_in_rule__LiteralArray__Group_1__1__Impl8913);
            rule__LiteralArray__LiteralsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_1_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4477:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4481:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4482:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__08947);
            rule__BooleanLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__08950);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4489:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4493:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4494:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4494:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4495:1: ()
            {
             before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4496:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4498:1: 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4508:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4512:1: ( rule__BooleanLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4513:2: rule__BooleanLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__19008);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4519:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4523:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4524:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4524:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4525:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4526:1: ( rule__BooleanLiteral__Alternatives_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4526:2: rule__BooleanLiteral__Alternatives_1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl9035);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4540:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4544:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4545:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__09069);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__09072);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4552:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4556:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4557:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4557:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4558:1: ()
            {
             before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4559:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4561:1: 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4571:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4575:1: ( rule__RealLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4576:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__19130);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4582:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4586:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4587:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4587:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4588:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4589:1: ( rule__RealLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4589:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl9157);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4603:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4607:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4608:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__09191);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__09194);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4615:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4619:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4620:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4620:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4621:1: ()
            {
             before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4622:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4624:1: 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4634:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4638:1: ( rule__IntLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4639:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__19252);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4645:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4649:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4650:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4650:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4651:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4652:1: ( rule__IntLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4652:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl9279);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4666:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4670:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4671:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__09313);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__09316);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4678:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4682:1: ( ( () ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4683:1: ( () )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4683:1: ( () )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4684:1: ()
            {
             before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4685:1: ()
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4687:1: 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4697:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4701:1: ( rule__StringLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4702:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__19374);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4708:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4712:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4713:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4713:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4714:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4715:1: ( rule__StringLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4715:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl9401);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4729:1: rule__SignedInteger__Group__0 : rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 ;
    public final void rule__SignedInteger__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4733:1: ( rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4734:2: rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__09435);
            rule__SignedInteger__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__09438);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4741:1: rule__SignedInteger__Group__0__Impl : ( ( rule__SignedInteger__Alternatives_0 )? ) ;
    public final void rule__SignedInteger__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4745:1: ( ( ( rule__SignedInteger__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4746:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4746:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4747:1: ( rule__SignedInteger__Alternatives_0 )?
            {
             before(grammarAccess.getSignedIntegerAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4748:1: ( rule__SignedInteger__Alternatives_0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=16 && LA33_0<=17)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4748:2: rule__SignedInteger__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl9465);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4758:1: rule__SignedInteger__Group__1 : rule__SignedInteger__Group__1__Impl ;
    public final void rule__SignedInteger__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4762:1: ( rule__SignedInteger__Group__1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4763:2: rule__SignedInteger__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__19496);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4769:1: rule__SignedInteger__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__SignedInteger__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4773:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4774:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4774:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4775:1: RULE_INT
            {
             before(grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl9523); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4790:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4794:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4795:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__09556);
            rule__Decimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__09559);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4802:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4806:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4807:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4807:1: ( ( rule__Decimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4808:1: ( rule__Decimal__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4809:1: ( rule__Decimal__Alternatives_0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=16 && LA34_0<=17)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4809:2: rule__Decimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl9586);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4819:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4823:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4824:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__19617);
            rule__Decimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__19620);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4831:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4835:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4836:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4836:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4837:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl9647); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4848:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4852:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4853:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
            {
            pushFollow(FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__29676);
            rule__Decimal__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__29679);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4860:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4864:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4865:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4865:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4866:1: '.'
            {
             before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            match(input,41,FOLLOW_41_in_rule__Decimal__Group__2__Impl9707); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4879:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4883:1: ( rule__Decimal__Group__3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4884:2: rule__Decimal__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__39738);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4890:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4894:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4895:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4895:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4896:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl9765); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4915:1: rule__DotDecimal__Group__0 : rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 ;
    public final void rule__DotDecimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4919:1: ( rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4920:2: rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__09802);
            rule__DotDecimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__09805);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4927:1: rule__DotDecimal__Group__0__Impl : ( ( rule__DotDecimal__Alternatives_0 )? ) ;
    public final void rule__DotDecimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4931:1: ( ( ( rule__DotDecimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4932:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4932:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4933:1: ( rule__DotDecimal__Alternatives_0 )?
            {
             before(grammarAccess.getDotDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4934:1: ( rule__DotDecimal__Alternatives_0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=16 && LA35_0<=17)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4934:2: rule__DotDecimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl9832);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4944:1: rule__DotDecimal__Group__1 : rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 ;
    public final void rule__DotDecimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4948:1: ( rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4949:2: rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__19863);
            rule__DotDecimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__19866);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4956:1: rule__DotDecimal__Group__1__Impl : ( '.' ) ;
    public final void rule__DotDecimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4960:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4961:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4961:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4962:1: '.'
            {
             before(grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
            match(input,41,FOLLOW_41_in_rule__DotDecimal__Group__1__Impl9894); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4975:1: rule__DotDecimal__Group__2 : rule__DotDecimal__Group__2__Impl ;
    public final void rule__DotDecimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4979:1: ( rule__DotDecimal__Group__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4980:2: rule__DotDecimal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__29925);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4986:1: rule__DotDecimal__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DotDecimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4990:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4991:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4991:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:4992:1: RULE_INT
            {
             before(grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl9952); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5009:1: rule__DecimalDot__Group__0 : rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 ;
    public final void rule__DecimalDot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5013:1: ( rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5014:2: rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__09987);
            rule__DecimalDot__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__09990);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5021:1: rule__DecimalDot__Group__0__Impl : ( ( rule__DecimalDot__Alternatives_0 )? ) ;
    public final void rule__DecimalDot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5025:1: ( ( ( rule__DecimalDot__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5026:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5026:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5027:1: ( rule__DecimalDot__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalDotAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5028:1: ( rule__DecimalDot__Alternatives_0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=16 && LA36_0<=17)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5028:2: rule__DecimalDot__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl10017);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5038:1: rule__DecimalDot__Group__1 : rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 ;
    public final void rule__DecimalDot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5042:1: ( rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5043:2: rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__110048);
            rule__DecimalDot__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__110051);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5050:1: rule__DecimalDot__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalDot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5054:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5055:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5055:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5056:1: RULE_INT
            {
             before(grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl10078); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5067:1: rule__DecimalDot__Group__2 : rule__DecimalDot__Group__2__Impl ;
    public final void rule__DecimalDot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5071:1: ( rule__DecimalDot__Group__2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5072:2: rule__DecimalDot__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__210107);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5078:1: rule__DecimalDot__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalDot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5082:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5083:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5083:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5084:1: '.'
            {
             before(grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 
            match(input,41,FOLLOW_41_in_rule__DecimalDot__Group__2__Impl10135); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5103:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5107:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5108:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__010172);
            rule__DecimalExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__010175);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5115:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5119:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5120:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5120:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5121:1: ( rule__DecimalExp__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5122:1: ( rule__DecimalExp__Alternatives_0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=16 && LA37_0<=17)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5122:2: rule__DecimalExp__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl10202);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5132:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5136:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5137:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__110233);
            rule__DecimalExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__110236);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5144:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5148:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5149:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5149:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5150:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl10263); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5161:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5165:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5166:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__210292);
            rule__DecimalExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__210295);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5173:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5177:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5178:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5178:1: ( '.' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5179:1: '.'
            {
             before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            match(input,41,FOLLOW_41_in_rule__DecimalExp__Group__2__Impl10323); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5192:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5196:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5197:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__310354);
            rule__DecimalExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__310357);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5204:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5208:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5209:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5209:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5210:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl10384); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5221:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5225:1: ( rule__DecimalExp__Group__4__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5226:2: rule__DecimalExp__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__410413);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5232:1: rule__DecimalExp__Group__4__Impl : ( RULE_EXP ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5236:1: ( ( RULE_EXP ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5237:1: ( RULE_EXP )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5237:1: ( RULE_EXP )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5238:1: RULE_EXP
            {
             before(grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 
            match(input,RULE_EXP,FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl10440); 
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


    // $ANTLR start "rule__DynamicConfig__UnorderedGroup_2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5260:1: rule__DynamicConfig__UnorderedGroup_2 : rule__DynamicConfig__UnorderedGroup_2__0 {...}?;
    public final void rule__DynamicConfig__UnorderedGroup_2() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2());
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5265:1: ( rule__DynamicConfig__UnorderedGroup_2__0 {...}?)
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5266:2: rule__DynamicConfig__UnorderedGroup_2__0 {...}?
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2__0_in_rule__DynamicConfig__UnorderedGroup_210480);
            rule__DynamicConfig__UnorderedGroup_2__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2()) ) {
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5277:1: rule__DynamicConfig__UnorderedGroup_2__Impl : ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) ) ;
    public final void rule__DynamicConfig__UnorderedGroup_2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5282:1: ( ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5283:3: ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5283:3: ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( LA38_0 >=22 && LA38_0<=23 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                alt38=1;
            }
            else if ( LA38_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5285:4: ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5285:4: ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5286:5: {...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                        throw new FailedPredicateException(input, "rule__DynamicConfig__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5286:110: ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5287:6: ( ( rule__DynamicConfig__Alternatives_2_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5293:6: ( ( rule__DynamicConfig__Alternatives_2_0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5295:7: ( rule__DynamicConfig__Alternatives_2_0 )
                    {
                     before(grammarAccess.getDynamicConfigAccess().getAlternatives_2_0()); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5296:7: ( rule__DynamicConfig__Alternatives_2_0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5296:8: rule__DynamicConfig__Alternatives_2_0
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__Alternatives_2_0_in_rule__DynamicConfig__UnorderedGroup_2__Impl10569);
                    rule__DynamicConfig__Alternatives_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDynamicConfigAccess().getAlternatives_2_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5302:4: ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5302:4: ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5303:5: {...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                        throw new FailedPredicateException(input, "rule__DynamicConfig__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5303:110: ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5304:6: ( ( rule__DynamicConfig__Group_2_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5310:6: ( ( rule__DynamicConfig__Group_2_1__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5312:7: ( rule__DynamicConfig__Group_2_1__0 )
                    {
                     before(grammarAccess.getDynamicConfigAccess().getGroup_2_1()); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5313:7: ( rule__DynamicConfig__Group_2_1__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5313:8: rule__DynamicConfig__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__Group_2_1__0_in_rule__DynamicConfig__UnorderedGroup_2__Impl10660);
                    rule__DynamicConfig__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDynamicConfigAccess().getGroup_2_1()); 

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5328:1: rule__DynamicConfig__UnorderedGroup_2__0 : rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )? ;
    public final void rule__DynamicConfig__UnorderedGroup_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5332:1: ( rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5333:2: rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )?
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2__Impl_in_rule__DynamicConfig__UnorderedGroup_2__010719);
            rule__DynamicConfig__UnorderedGroup_2__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5334:2: ( rule__DynamicConfig__UnorderedGroup_2__1 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( LA39_0 >=22 && LA39_0<=23 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                alt39=1;
            }
            else if ( LA39_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5334:2: rule__DynamicConfig__UnorderedGroup_2__1
                    {
                    pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2__1_in_rule__DynamicConfig__UnorderedGroup_2__010722);
                    rule__DynamicConfig__UnorderedGroup_2__1();

                    state._fsp--;


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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5341:1: rule__DynamicConfig__UnorderedGroup_2__1 : rule__DynamicConfig__UnorderedGroup_2__Impl ;
    public final void rule__DynamicConfig__UnorderedGroup_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5345:1: ( rule__DynamicConfig__UnorderedGroup_2__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5346:2: rule__DynamicConfig__UnorderedGroup_2__Impl
            {
            pushFollow(FOLLOW_rule__DynamicConfig__UnorderedGroup_2__Impl_in_rule__DynamicConfig__UnorderedGroup_2__110747);
            rule__DynamicConfig__UnorderedGroup_2__Impl();

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
    // $ANTLR end "rule__DynamicConfig__UnorderedGroup_2__1"


    // $ANTLR start "rule__ActorInstanceConfig__UnorderedGroup"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5357:1: rule__ActorInstanceConfig__UnorderedGroup : rule__ActorInstanceConfig__UnorderedGroup__0 {...}?;
    public final void rule__ActorInstanceConfig__UnorderedGroup() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup());
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5362:1: ( rule__ActorInstanceConfig__UnorderedGroup__0 {...}?)
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5363:2: rule__ActorInstanceConfig__UnorderedGroup__0 {...}?
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__0_in_rule__ActorInstanceConfig__UnorderedGroup10775);
            rule__ActorInstanceConfig__UnorderedGroup__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup()) ) {
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5374:1: rule__ActorInstanceConfig__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) ) ) ) ;
    public final void rule__ActorInstanceConfig__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5379:1: ( ( ({...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5380:3: ( ({...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5380:3: ( ({...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( LA40_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0) ) {
                alt40=1;
            }
            else if ( (LA40_0==20||LA40_0==33) && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5382:4: ({...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5382:4: ({...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5383:5: {...}? => ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__ActorInstanceConfig__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5383:114: ( ( ( rule__ActorInstanceConfig__Group_0__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5384:6: ( ( rule__ActorInstanceConfig__Group_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5390:6: ( ( rule__ActorInstanceConfig__Group_0__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5392:7: ( rule__ActorInstanceConfig__Group_0__0 )
                    {
                     before(grammarAccess.getActorInstanceConfigAccess().getGroup_0()); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5393:7: ( rule__ActorInstanceConfig__Group_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5393:8: rule__ActorInstanceConfig__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_0__0_in_rule__ActorInstanceConfig__UnorderedGroup__Impl10864);
                    rule__ActorInstanceConfig__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getActorInstanceConfigAccess().getGroup_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5399:4: ({...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5399:4: ({...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5400:5: {...}? => ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__ActorInstanceConfig__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5400:114: ( ( ( rule__ActorInstanceConfig__Group_1__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5401:6: ( ( rule__ActorInstanceConfig__Group_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5407:6: ( ( rule__ActorInstanceConfig__Group_1__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5409:7: ( rule__ActorInstanceConfig__Group_1__0 )
                    {
                     before(grammarAccess.getActorInstanceConfigAccess().getGroup_1()); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5410:7: ( rule__ActorInstanceConfig__Group_1__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5410:8: rule__ActorInstanceConfig__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ActorInstanceConfig__Group_1__0_in_rule__ActorInstanceConfig__UnorderedGroup__Impl10955);
                    rule__ActorInstanceConfig__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getActorInstanceConfigAccess().getGroup_1()); 

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5425:1: rule__ActorInstanceConfig__UnorderedGroup__0 : rule__ActorInstanceConfig__UnorderedGroup__Impl ( rule__ActorInstanceConfig__UnorderedGroup__1 )? ;
    public final void rule__ActorInstanceConfig__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5429:1: ( rule__ActorInstanceConfig__UnorderedGroup__Impl ( rule__ActorInstanceConfig__UnorderedGroup__1 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5430:2: rule__ActorInstanceConfig__UnorderedGroup__Impl ( rule__ActorInstanceConfig__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__Impl_in_rule__ActorInstanceConfig__UnorderedGroup__011014);
            rule__ActorInstanceConfig__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5431:2: ( rule__ActorInstanceConfig__UnorderedGroup__1 )?
            int alt41=2;
            switch ( input.LA(1) ) {
                case 27:
                    {
                    int LA41_1 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0) ) {
                        alt41=1;
                    }
                    }
                    break;
                case 33:
                    {
                    int LA41_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1) ) {
                        alt41=1;
                    }
                    }
                    break;
                case 20:
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
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5431:2: rule__ActorInstanceConfig__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__1_in_rule__ActorInstanceConfig__UnorderedGroup__011017);
                    rule__ActorInstanceConfig__UnorderedGroup__1();

                    state._fsp--;


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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5438:1: rule__ActorInstanceConfig__UnorderedGroup__1 : rule__ActorInstanceConfig__UnorderedGroup__Impl ;
    public final void rule__ActorInstanceConfig__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5442:1: ( rule__ActorInstanceConfig__UnorderedGroup__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5443:2: rule__ActorInstanceConfig__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__Impl_in_rule__ActorInstanceConfig__UnorderedGroup__111042);
            rule__ActorInstanceConfig__UnorderedGroup__Impl();

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
    // $ANTLR end "rule__ActorInstanceConfig__UnorderedGroup__1"


    // $ANTLR start "rule__ProtocolClassConfig__UnorderedGroup_3"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5454:1: rule__ProtocolClassConfig__UnorderedGroup_3 : ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )? ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5459:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5460:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )?
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5460:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( LA42_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                alt42=1;
            }
            else if ( LA42_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5460:2: rule__ProtocolClassConfig__UnorderedGroup_3__0
                    {
                    pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__0_in_rule__ProtocolClassConfig__UnorderedGroup_311070);
                    rule__ProtocolClassConfig__UnorderedGroup_3__0();

                    state._fsp--;


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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5470:1: rule__ProtocolClassConfig__UnorderedGroup_3__Impl : ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) ) ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5475:1: ( ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5476:3: ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5476:3: ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( LA43_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                alt43=1;
            }
            else if ( LA43_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5478:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5478:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5479:5: {...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                        throw new FailedPredicateException(input, "rule__ProtocolClassConfig__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5479:116: ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5480:6: ( ( rule__ProtocolClassConfig__Group_3_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5486:6: ( ( rule__ProtocolClassConfig__Group_3_0__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5488:7: ( rule__ProtocolClassConfig__Group_3_0__0 )
                    {
                     before(grammarAccess.getProtocolClassConfigAccess().getGroup_3_0()); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5489:7: ( rule__ProtocolClassConfig__Group_3_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5489:8: rule__ProtocolClassConfig__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_0__0_in_rule__ProtocolClassConfig__UnorderedGroup_3__Impl11157);
                    rule__ProtocolClassConfig__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getProtocolClassConfigAccess().getGroup_3_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5495:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5495:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5496:5: {...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                        throw new FailedPredicateException(input, "rule__ProtocolClassConfig__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5496:116: ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5497:6: ( ( rule__ProtocolClassConfig__Group_3_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5503:6: ( ( rule__ProtocolClassConfig__Group_3_1__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5505:7: ( rule__ProtocolClassConfig__Group_3_1__0 )
                    {
                     before(grammarAccess.getProtocolClassConfigAccess().getGroup_3_1()); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5506:7: ( rule__ProtocolClassConfig__Group_3_1__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5506:8: rule__ProtocolClassConfig__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__ProtocolClassConfig__Group_3_1__0_in_rule__ProtocolClassConfig__UnorderedGroup_3__Impl11248);
                    rule__ProtocolClassConfig__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getProtocolClassConfigAccess().getGroup_3_1()); 

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5521:1: rule__ProtocolClassConfig__UnorderedGroup_3__0 : rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )? ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5525:1: ( rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5526:2: rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )?
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__Impl_in_rule__ProtocolClassConfig__UnorderedGroup_3__011307);
            rule__ProtocolClassConfig__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5527:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( LA44_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                alt44=1;
            }
            else if ( LA44_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5527:2: rule__ProtocolClassConfig__UnorderedGroup_3__1
                    {
                    pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__1_in_rule__ProtocolClassConfig__UnorderedGroup_3__011310);
                    rule__ProtocolClassConfig__UnorderedGroup_3__1();

                    state._fsp--;


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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5534:1: rule__ProtocolClassConfig__UnorderedGroup_3__1 : rule__ProtocolClassConfig__UnorderedGroup_3__Impl ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5538:1: ( rule__ProtocolClassConfig__UnorderedGroup_3__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5539:2: rule__ProtocolClassConfig__UnorderedGroup_3__Impl
            {
            pushFollow(FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__Impl_in_rule__ProtocolClassConfig__UnorderedGroup_3__111335);
            rule__ProtocolClassConfig__UnorderedGroup_3__Impl();

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
    // $ANTLR end "rule__ProtocolClassConfig__UnorderedGroup_3__1"


    // $ANTLR start "rule__AttrClassConfig__UnorderedGroup_3_1"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5550:1: rule__AttrClassConfig__UnorderedGroup_3_1 : ( rule__AttrClassConfig__UnorderedGroup_3_1__0 )? ;
    public final void rule__AttrClassConfig__UnorderedGroup_3_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1());
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5555:1: ( ( rule__AttrClassConfig__UnorderedGroup_3_1__0 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5556:2: ( rule__AttrClassConfig__UnorderedGroup_3_1__0 )?
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5556:2: ( rule__AttrClassConfig__UnorderedGroup_3_1__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( LA45_0 ==36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                alt45=1;
            }
            else if ( LA45_0 ==37 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5556:2: rule__AttrClassConfig__UnorderedGroup_3_1__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__0_in_rule__AttrClassConfig__UnorderedGroup_3_111363);
                    rule__AttrClassConfig__UnorderedGroup_3_1__0();

                    state._fsp--;


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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5566:1: rule__AttrClassConfig__UnorderedGroup_3_1__Impl : ( ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) ) ) ) ;
    public final void rule__AttrClassConfig__UnorderedGroup_3_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5571:1: ( ( ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5572:3: ( ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5572:3: ( ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( LA46_0 ==36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                alt46=1;
            }
            else if ( LA46_0 ==37 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5574:4: ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5574:4: ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5575:5: {...}? => ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__AttrClassConfig__UnorderedGroup_3_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5575:114: ( ( ( rule__AttrClassConfig__Group_3_1_0__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5576:6: ( ( rule__AttrClassConfig__Group_3_1_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5582:6: ( ( rule__AttrClassConfig__Group_3_1_0__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5584:7: ( rule__AttrClassConfig__Group_3_1_0__0 )
                    {
                     before(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_0()); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5585:7: ( rule__AttrClassConfig__Group_3_1_0__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5585:8: rule__AttrClassConfig__Group_3_1_0__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_0__0_in_rule__AttrClassConfig__UnorderedGroup_3_1__Impl11450);
                    rule__AttrClassConfig__Group_3_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5591:4: ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5591:4: ({...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5592:5: {...}? => ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__AttrClassConfig__UnorderedGroup_3_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1)");
                    }
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5592:114: ( ( ( rule__AttrClassConfig__Group_3_1_1__0 ) ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5593:6: ( ( rule__AttrClassConfig__Group_3_1_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5599:6: ( ( rule__AttrClassConfig__Group_3_1_1__0 ) )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5601:7: ( rule__AttrClassConfig__Group_3_1_1__0 )
                    {
                     before(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_1()); 
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5602:7: ( rule__AttrClassConfig__Group_3_1_1__0 )
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5602:8: rule__AttrClassConfig__Group_3_1_1__0
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__Group_3_1_1__0_in_rule__AttrClassConfig__UnorderedGroup_3_1__Impl11541);
                    rule__AttrClassConfig__Group_3_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_1()); 

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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5617:1: rule__AttrClassConfig__UnorderedGroup_3_1__0 : rule__AttrClassConfig__UnorderedGroup_3_1__Impl ( rule__AttrClassConfig__UnorderedGroup_3_1__1 )? ;
    public final void rule__AttrClassConfig__UnorderedGroup_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5621:1: ( rule__AttrClassConfig__UnorderedGroup_3_1__Impl ( rule__AttrClassConfig__UnorderedGroup_3_1__1 )? )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5622:2: rule__AttrClassConfig__UnorderedGroup_3_1__Impl ( rule__AttrClassConfig__UnorderedGroup_3_1__1 )?
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__Impl_in_rule__AttrClassConfig__UnorderedGroup_3_1__011600);
            rule__AttrClassConfig__UnorderedGroup_3_1__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5623:2: ( rule__AttrClassConfig__UnorderedGroup_3_1__1 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( LA47_0 ==36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                alt47=1;
            }
            else if ( LA47_0 ==37 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5623:2: rule__AttrClassConfig__UnorderedGroup_3_1__1
                    {
                    pushFollow(FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__1_in_rule__AttrClassConfig__UnorderedGroup_3_1__011603);
                    rule__AttrClassConfig__UnorderedGroup_3_1__1();

                    state._fsp--;


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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5630:1: rule__AttrClassConfig__UnorderedGroup_3_1__1 : rule__AttrClassConfig__UnorderedGroup_3_1__Impl ;
    public final void rule__AttrClassConfig__UnorderedGroup_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5634:1: ( rule__AttrClassConfig__UnorderedGroup_3_1__Impl )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5635:2: rule__AttrClassConfig__UnorderedGroup_3_1__Impl
            {
            pushFollow(FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__Impl_in_rule__AttrClassConfig__UnorderedGroup_3_1__111628);
            rule__AttrClassConfig__UnorderedGroup_3_1__Impl();

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
    // $ANTLR end "rule__AttrClassConfig__UnorderedGroup_3_1__1"


    // $ANTLR start "rule__ConfigModel__ImportsAssignment_0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5646:1: rule__ConfigModel__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__ConfigModel__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5650:1: ( ( ruleImport ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5651:1: ( ruleImport )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5651:1: ( ruleImport )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5652:1: ruleImport
            {
             before(grammarAccess.getConfigModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__ConfigModel__ImportsAssignment_011660);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getConfigModelAccess().getImportsImportParserRuleCall_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5661:1: rule__ConfigModel__ConfigElementsAssignment_1 : ( ruleConfigElement ) ;
    public final void rule__ConfigModel__ConfigElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5665:1: ( ( ruleConfigElement ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5666:1: ( ruleConfigElement )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5666:1: ( ruleConfigElement )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5667:1: ruleConfigElement
            {
             before(grammarAccess.getConfigModelAccess().getConfigElementsConfigElementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleConfigElement_in_rule__ConfigModel__ConfigElementsAssignment_111691);
            ruleConfigElement();

            state._fsp--;

             after(grammarAccess.getConfigModelAccess().getConfigElementsConfigElementParserRuleCall_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5676:1: rule__SubSystemConfig__SubSystemAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemConfig__SubSystemAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5680:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5681:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5681:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5682:1: ( RULE_ID )
            {
             before(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemClassCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5683:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5684:1: RULE_ID
            {
             before(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemClassIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubSystemConfig__SubSystemAssignment_111726); 
             after(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemClassIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemClassCrossReference_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5695:1: rule__SubSystemConfig__DynConfigAssignment_3 : ( ruleDynamicConfig ) ;
    public final void rule__SubSystemConfig__DynConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5699:1: ( ( ruleDynamicConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5700:1: ( ruleDynamicConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5700:1: ( ruleDynamicConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5701:1: ruleDynamicConfig
            {
             before(grammarAccess.getSubSystemConfigAccess().getDynConfigDynamicConfigParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDynamicConfig_in_rule__SubSystemConfig__DynConfigAssignment_311761);
            ruleDynamicConfig();

            state._fsp--;

             after(grammarAccess.getSubSystemConfigAccess().getDynConfigDynamicConfigParserRuleCall_3_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5710:1: rule__DynamicConfig__FilePathAssignment_2_0_0_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__FilePathAssignment_2_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5714:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5715:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5715:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5716:1: RULE_STRING
            {
             before(grammarAccess.getDynamicConfigAccess().getFilePathSTRINGTerminalRuleCall_2_0_0_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DynamicConfig__FilePathAssignment_2_0_0_111792); 
             after(grammarAccess.getDynamicConfigAccess().getFilePathSTRINGTerminalRuleCall_2_0_0_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5725:1: rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5729:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5730:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5730:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5731:1: RULE_STRING
            {
             before(grammarAccess.getDynamicConfigAccess().getUserCode1STRINGTerminalRuleCall_2_0_1_0_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DynamicConfig__UserCode1Assignment_2_0_1_0_111823); 
             after(grammarAccess.getDynamicConfigAccess().getUserCode1STRINGTerminalRuleCall_2_0_1_0_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5740:1: rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5744:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5745:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5745:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5746:1: RULE_STRING
            {
             before(grammarAccess.getDynamicConfigAccess().getUserCode2STRINGTerminalRuleCall_2_0_1_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DynamicConfig__UserCode2Assignment_2_0_1_1_111854); 
             after(grammarAccess.getDynamicConfigAccess().getUserCode2STRINGTerminalRuleCall_2_0_1_1_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5755:1: rule__DynamicConfig__PollingAssignment_2_1_1 : ( RULE_INT ) ;
    public final void rule__DynamicConfig__PollingAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5759:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5760:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5760:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5761:1: RULE_INT
            {
             before(grammarAccess.getDynamicConfigAccess().getPollingINTTerminalRuleCall_2_1_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DynamicConfig__PollingAssignment_2_1_111885); 
             after(grammarAccess.getDynamicConfigAccess().getPollingINTTerminalRuleCall_2_1_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5770:1: rule__ActorClassConfig__ActorAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ActorClassConfig__ActorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5774:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5775:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5775:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5776:1: ( ruleFQN )
            {
             before(grammarAccess.getActorClassConfigAccess().getActorActorClassCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5777:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5778:1: ruleFQN
            {
             before(grammarAccess.getActorClassConfigAccess().getActorActorClassFQNParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__ActorClassConfig__ActorAssignment_111920);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getActorClassConfigAccess().getActorActorClassFQNParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getActorClassConfigAccess().getActorActorClassCrossReference_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5789:1: rule__ActorClassConfig__AttributesAssignment_3 : ( ruleAttrClassConfig ) ;
    public final void rule__ActorClassConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5793:1: ( ( ruleAttrClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5794:1: ( ruleAttrClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5794:1: ( ruleAttrClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5795:1: ruleAttrClassConfig
            {
             before(grammarAccess.getActorClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleAttrClassConfig_in_rule__ActorClassConfig__AttributesAssignment_311955);
            ruleAttrClassConfig();

            state._fsp--;

             after(grammarAccess.getActorClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5804:1: rule__ActorInstanceConfig__RootAssignment_0_1 : ( ( ruleFQN ) ) ;
    public final void rule__ActorInstanceConfig__RootAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5808:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5809:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5809:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5810:1: ( ruleFQN )
            {
             before(grammarAccess.getActorInstanceConfigAccess().getRootSubSystemClassCrossReference_0_1_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5811:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5812:1: ruleFQN
            {
             before(grammarAccess.getActorInstanceConfigAccess().getRootSubSystemClassFQNParserRuleCall_0_1_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__ActorInstanceConfig__RootAssignment_0_111990);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getActorInstanceConfigAccess().getRootSubSystemClassFQNParserRuleCall_0_1_0_1()); 

            }

             after(grammarAccess.getActorInstanceConfigAccess().getRootSubSystemClassCrossReference_0_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5823:1: rule__ActorInstanceConfig__PathAssignment_0_3 : ( ruleRefPath ) ;
    public final void rule__ActorInstanceConfig__PathAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5827:1: ( ( ruleRefPath ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5828:1: ( ruleRefPath )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5828:1: ( ruleRefPath )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5829:1: ruleRefPath
            {
             before(grammarAccess.getActorInstanceConfigAccess().getPathRefPathParserRuleCall_0_3_0()); 
            pushFollow(FOLLOW_ruleRefPath_in_rule__ActorInstanceConfig__PathAssignment_0_312025);
            ruleRefPath();

            state._fsp--;

             after(grammarAccess.getActorInstanceConfigAccess().getPathRefPathParserRuleCall_0_3_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5838:1: rule__ActorInstanceConfig__AttributesAssignment_0_5 : ( ruleAttrInstanceConfig ) ;
    public final void rule__ActorInstanceConfig__AttributesAssignment_0_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5842:1: ( ( ruleAttrInstanceConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5843:1: ( ruleAttrInstanceConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5843:1: ( ruleAttrInstanceConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5844:1: ruleAttrInstanceConfig
            {
             before(grammarAccess.getActorInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_0_5_0()); 
            pushFollow(FOLLOW_ruleAttrInstanceConfig_in_rule__ActorInstanceConfig__AttributesAssignment_0_512056);
            ruleAttrInstanceConfig();

            state._fsp--;

             after(grammarAccess.getActorInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_0_5_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5853:1: rule__ActorInstanceConfig__PortsAssignment_1_0 : ( rulePortInstanceConfig ) ;
    public final void rule__ActorInstanceConfig__PortsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5857:1: ( ( rulePortInstanceConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5858:1: ( rulePortInstanceConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5858:1: ( rulePortInstanceConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5859:1: rulePortInstanceConfig
            {
             before(grammarAccess.getActorInstanceConfigAccess().getPortsPortInstanceConfigParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_rulePortInstanceConfig_in_rule__ActorInstanceConfig__PortsAssignment_1_012087);
            rulePortInstanceConfig();

            state._fsp--;

             after(grammarAccess.getActorInstanceConfigAccess().getPortsPortInstanceConfigParserRuleCall_1_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5868:1: rule__ProtocolClassConfig__ProtocolAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ProtocolClassConfig__ProtocolAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5872:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5873:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5873:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5874:1: ( ruleFQN )
            {
             before(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5875:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5876:1: ruleFQN
            {
             before(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassFQNParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__ProtocolClassConfig__ProtocolAssignment_112122);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassFQNParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassCrossReference_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5887:1: rule__ProtocolClassConfig__RegularAssignment_3_0_1 : ( rulePortClassConfig ) ;
    public final void rule__ProtocolClassConfig__RegularAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5891:1: ( ( rulePortClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5892:1: ( rulePortClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5892:1: ( rulePortClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5893:1: rulePortClassConfig
            {
             before(grammarAccess.getProtocolClassConfigAccess().getRegularPortClassConfigParserRuleCall_3_0_1_0()); 
            pushFollow(FOLLOW_rulePortClassConfig_in_rule__ProtocolClassConfig__RegularAssignment_3_0_112157);
            rulePortClassConfig();

            state._fsp--;

             after(grammarAccess.getProtocolClassConfigAccess().getRegularPortClassConfigParserRuleCall_3_0_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5902:1: rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 : ( rulePortClassConfig ) ;
    public final void rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5906:1: ( ( rulePortClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5907:1: ( rulePortClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5907:1: ( rulePortClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5908:1: rulePortClassConfig
            {
             before(grammarAccess.getProtocolClassConfigAccess().getConjugatedPortClassConfigParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_rulePortClassConfig_in_rule__ProtocolClassConfig__ConjugatedAssignment_3_1_112188);
            rulePortClassConfig();

            state._fsp--;

             after(grammarAccess.getProtocolClassConfigAccess().getConjugatedPortClassConfigParserRuleCall_3_1_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5917:1: rule__PortClassConfig__AttributesAssignment_3 : ( ruleAttrClassConfig ) ;
    public final void rule__PortClassConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5921:1: ( ( ruleAttrClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5922:1: ( ruleAttrClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5922:1: ( ruleAttrClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5923:1: ruleAttrClassConfig
            {
             before(grammarAccess.getPortClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleAttrClassConfig_in_rule__PortClassConfig__AttributesAssignment_312219);
            ruleAttrClassConfig();

            state._fsp--;

             after(grammarAccess.getPortClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5932:1: rule__PortInstanceConfig__ItemAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PortInstanceConfig__ItemAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5936:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5937:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5937:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5938:1: ( RULE_ID )
            {
             before(grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5939:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5940:1: RULE_ID
            {
             before(grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PortInstanceConfig__ItemAssignment_112254); 
             after(grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemCrossReference_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5951:1: rule__PortInstanceConfig__AttributesAssignment_3 : ( ruleAttrInstanceConfig ) ;
    public final void rule__PortInstanceConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5955:1: ( ( ruleAttrInstanceConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5956:1: ( ruleAttrInstanceConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5956:1: ( ruleAttrInstanceConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5957:1: ruleAttrInstanceConfig
            {
             before(grammarAccess.getPortInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleAttrInstanceConfig_in_rule__PortInstanceConfig__AttributesAssignment_312289);
            ruleAttrInstanceConfig();

            state._fsp--;

             after(grammarAccess.getPortInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5966:1: rule__AttrClassConfig__AttributeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AttrClassConfig__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5970:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5971:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5971:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5972:1: ( RULE_ID )
            {
             before(grammarAccess.getAttrClassConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5973:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5974:1: RULE_ID
            {
             before(grammarAccess.getAttrClassConfigAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AttrClassConfig__AttributeAssignment_112324); 
             after(grammarAccess.getAttrClassConfigAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getAttrClassConfigAccess().getAttributeAttributeCrossReference_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5985:1: rule__AttrClassConfig__ValueAssignment_2_1 : ( ruleLiteralArray ) ;
    public final void rule__AttrClassConfig__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5989:1: ( ( ruleLiteralArray ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5990:1: ( ruleLiteralArray )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5990:1: ( ruleLiteralArray )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:5991:1: ruleLiteralArray
            {
             before(grammarAccess.getAttrClassConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleLiteralArray_in_rule__AttrClassConfig__ValueAssignment_2_112359);
            ruleLiteralArray();

            state._fsp--;

             after(grammarAccess.getAttrClassConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6000:1: rule__AttrClassConfig__MinAssignment_3_1_0_2 : ( ruleNumberLiteral ) ;
    public final void rule__AttrClassConfig__MinAssignment_3_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6004:1: ( ( ruleNumberLiteral ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6005:1: ( ruleNumberLiteral )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6005:1: ( ruleNumberLiteral )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6006:1: ruleNumberLiteral
            {
             before(grammarAccess.getAttrClassConfigAccess().getMinNumberLiteralParserRuleCall_3_1_0_2_0()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_rule__AttrClassConfig__MinAssignment_3_1_0_212390);
            ruleNumberLiteral();

            state._fsp--;

             after(grammarAccess.getAttrClassConfigAccess().getMinNumberLiteralParserRuleCall_3_1_0_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6015:1: rule__AttrClassConfig__MaxAssignment_3_1_1_2 : ( ruleNumberLiteral ) ;
    public final void rule__AttrClassConfig__MaxAssignment_3_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6019:1: ( ( ruleNumberLiteral ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6020:1: ( ruleNumberLiteral )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6020:1: ( ruleNumberLiteral )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6021:1: ruleNumberLiteral
            {
             before(grammarAccess.getAttrClassConfigAccess().getMaxNumberLiteralParserRuleCall_3_1_1_2_0()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_rule__AttrClassConfig__MaxAssignment_3_1_1_212421);
            ruleNumberLiteral();

            state._fsp--;

             after(grammarAccess.getAttrClassConfigAccess().getMaxNumberLiteralParserRuleCall_3_1_1_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6030:1: rule__AttrClassConfig__AttributesAssignment_3_2 : ( ruleAttrClassConfig ) ;
    public final void rule__AttrClassConfig__AttributesAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6034:1: ( ( ruleAttrClassConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6035:1: ( ruleAttrClassConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6035:1: ( ruleAttrClassConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6036:1: ruleAttrClassConfig
            {
             before(grammarAccess.getAttrClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_ruleAttrClassConfig_in_rule__AttrClassConfig__AttributesAssignment_3_212452);
            ruleAttrClassConfig();

            state._fsp--;

             after(grammarAccess.getAttrClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6045:1: rule__AttrInstanceConfig__AttributeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AttrInstanceConfig__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6049:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6050:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6050:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6051:1: ( RULE_ID )
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6052:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6053:1: RULE_ID
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AttrInstanceConfig__AttributeAssignment_112487); 
             after(grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeCrossReference_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6064:1: rule__AttrInstanceConfig__ValueAssignment_2_1 : ( ruleLiteralArray ) ;
    public final void rule__AttrInstanceConfig__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6068:1: ( ( ruleLiteralArray ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6069:1: ( ruleLiteralArray )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6069:1: ( ruleLiteralArray )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6070:1: ruleLiteralArray
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleLiteralArray_in_rule__AttrInstanceConfig__ValueAssignment_2_112522);
            ruleLiteralArray();

            state._fsp--;

             after(grammarAccess.getAttrInstanceConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__AttrInstanceConfig__DynConfigAssignment_3_1_0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6079:1: rule__AttrInstanceConfig__DynConfigAssignment_3_1_0 : ( ( 'dynamic configuration' ) ) ;
    public final void rule__AttrInstanceConfig__DynConfigAssignment_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6083:1: ( ( ( 'dynamic configuration' ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6084:1: ( ( 'dynamic configuration' ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6084:1: ( ( 'dynamic configuration' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6085:1: ( 'dynamic configuration' )
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6086:1: ( 'dynamic configuration' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6087:1: 'dynamic configuration'
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0()); 
            match(input,21,FOLLOW_21_in_rule__AttrInstanceConfig__DynConfigAssignment_3_1_012558); 
             after(grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0()); 

            }

             after(grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrInstanceConfig__DynConfigAssignment_3_1_0"


    // $ANTLR start "rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6102:1: rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0 : ( ( 'read' ) ) ;
    public final void rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6106:1: ( ( ( 'read' ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6107:1: ( ( 'read' ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6107:1: ( ( 'read' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6108:1: ( 'read' )
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadKeyword_3_1_1_0_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6109:1: ( 'read' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6110:1: 'read'
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadKeyword_3_1_1_0_0()); 
            match(input,43,FOLLOW_43_in_rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_012602); 
             after(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadKeyword_3_1_1_0_0()); 

            }

             after(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadKeyword_3_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0"


    // $ANTLR start "rule__AttrInstanceConfig__AttributesAssignment_3_2"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6125:1: rule__AttrInstanceConfig__AttributesAssignment_3_2 : ( ruleAttrInstanceConfig ) ;
    public final void rule__AttrInstanceConfig__AttributesAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6129:1: ( ( ruleAttrInstanceConfig ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6130:1: ( ruleAttrInstanceConfig )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6130:1: ( ruleAttrInstanceConfig )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6131:1: ruleAttrInstanceConfig
            {
             before(grammarAccess.getAttrInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_ruleAttrInstanceConfig_in_rule__AttrInstanceConfig__AttributesAssignment_3_212641);
            ruleAttrInstanceConfig();

            state._fsp--;

             after(grammarAccess.getAttrInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrInstanceConfig__AttributesAssignment_3_2"


    // $ANTLR start "rule__RefPath__RefsAssignment_0"
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6140:1: rule__RefPath__RefsAssignment_0 : ( RULE_ID ) ;
    public final void rule__RefPath__RefsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6144:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6145:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6145:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6146:1: RULE_ID
            {
             before(grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_012672); 
             after(grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6155:1: rule__RefPath__RefsAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__RefPath__RefsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6159:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6160:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6160:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6161:1: RULE_ID
            {
             before(grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_1_112703); 
             after(grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_1_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6170:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6174:1: ( ( ruleImportedFQN ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6175:1: ( ruleImportedFQN )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6175:1: ( ruleImportedFQN )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6176:1: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_012734);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6185:1: rule__Import__ImportURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6189:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6190:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6190:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6191:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_212765); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6200:1: rule__LiteralArray__LiteralsAssignment_0 : ( ruleLiteral ) ;
    public final void rule__LiteralArray__LiteralsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6204:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6205:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6205:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6206:1: ruleLiteral
            {
             before(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_012796);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6215:1: rule__LiteralArray__LiteralsAssignment_1_1 : ( ruleLiteral ) ;
    public final void rule__LiteralArray__LiteralsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6219:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6220:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6220:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6221:1: ruleLiteral
            {
             before(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_1_112827);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_1_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6230:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6234:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6235:1: ( ( 'true' ) )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6235:1: ( ( 'true' ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6236:1: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6237:1: ( 'true' )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6238:1: 'true'
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            match(input,44,FOLLOW_44_in_rule__BooleanLiteral__IsTrueAssignment_1_112863); 
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6253:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6257:1: ( ( ruleReal ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6258:1: ( ruleReal )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6258:1: ( ruleReal )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6259:1: ruleReal
            {
             before(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_112902);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6268:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6272:1: ( ( ruleInteger ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6273:1: ( ruleInteger )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6273:1: ( ruleInteger )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6274:1: ruleInteger
            {
             before(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_112933);
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
    // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6283:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6287:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6288:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6288:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.config.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalConfig.g:6289:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_112964); 
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
        "\5\uffff\1\7\1\11\3\uffff";
    static final String DFA10_minS =
        "\3\6\1\51\1\uffff\1\6\1\7\3\uffff";
    static final String DFA10_maxS =
        "\4\51\1\uffff\2\52\3\uffff";
    static final String DFA10_acceptS =
        "\4\uffff\1\2\2\uffff\1\3\1\4\1\1";
    static final String DFA10_specialS =
        "\12\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\3\11\uffff\1\1\1\2\27\uffff\1\4",
            "\1\3\42\uffff\1\4",
            "\1\3\42\uffff\1\4",
            "\1\5",
            "",
            "\1\6\13\uffff\3\7\5\uffff\2\7\1\uffff\1\7\3\uffff\2\7\1\uffff"+
            "\2\7\4\uffff\1\7",
            "\1\10\12\uffff\3\11\5\uffff\2\11\1\uffff\1\11\3\uffff\2\11"+
            "\1\uffff\2\11\4\uffff\1\11",
            "",
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
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_0__0_in_rule__DynamicConfig__Alternatives_2_02008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1__0_in_rule__DynamicConfig__Alternatives_2_02026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_0_in_rule__AttrInstanceConfig__Alternatives_3_1_12060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__AttrInstanceConfig__Alternatives_3_1_12079 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rule__ConfigModel__Group__0__Impl_in_rule__ConfigModel__Group__02739 = new BitSet(new long[]{0x000000022C140000L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__1_in_rule__ConfigModel__Group__02742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__ImportsAssignment_0_in_rule__ConfigModel__Group__0__Impl2769 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__Group__1__Impl_in_rule__ConfigModel__Group__12800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConfigModel__ConfigElementsAssignment_1_in_rule__ConfigModel__Group__1__Impl2827 = new BitSet(new long[]{0x000000022C140002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__0__Impl_in_rule__SubSystemConfig__Group__02862 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__1_in_rule__SubSystemConfig__Group__02865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__SubSystemConfig__Group__0__Impl2893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__1__Impl_in_rule__SubSystemConfig__Group__12924 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__2_in_rule__SubSystemConfig__Group__12927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__SubSystemAssignment_1_in_rule__SubSystemConfig__Group__1__Impl2954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__2__Impl_in_rule__SubSystemConfig__Group__22984 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__3_in_rule__SubSystemConfig__Group__22987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__SubSystemConfig__Group__2__Impl3015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__3__Impl_in_rule__SubSystemConfig__Group__33046 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__4_in_rule__SubSystemConfig__Group__33049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__DynConfigAssignment_3_in_rule__SubSystemConfig__Group__3__Impl3076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemConfig__Group__4__Impl_in_rule__SubSystemConfig__Group__43106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__SubSystemConfig__Group__4__Impl3134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__0__Impl_in_rule__DynamicConfig__Group__03175 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__1_in_rule__DynamicConfig__Group__03178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DynamicConfig__Group__0__Impl3206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__1__Impl_in_rule__DynamicConfig__Group__13237 = new BitSet(new long[]{0x0000000002C00000L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__2_in_rule__DynamicConfig__Group__13240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__DynamicConfig__Group__1__Impl3268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__2__Impl_in_rule__DynamicConfig__Group__23299 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__3_in_rule__DynamicConfig__Group__23302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2_in_rule__DynamicConfig__Group__2__Impl3329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group__3__Impl_in_rule__DynamicConfig__Group__33359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__DynamicConfig__Group__3__Impl3387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_0__0__Impl_in_rule__DynamicConfig__Group_2_0_0__03426 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_0__1_in_rule__DynamicConfig__Group_2_0_0__03429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__DynamicConfig__Group_2_0_0__0__Impl3457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_0__1__Impl_in_rule__DynamicConfig__Group_2_0_0__13488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__FilePathAssignment_2_0_0_1_in_rule__DynamicConfig__Group_2_0_0__1__Impl3515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1__0__Impl_in_rule__DynamicConfig__Group_2_0_1__03549 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1__1_in_rule__DynamicConfig__Group_2_0_1__03552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_0__0_in_rule__DynamicConfig__Group_2_0_1__0__Impl3579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1__1__Impl_in_rule__DynamicConfig__Group_2_0_1__13609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_1__0_in_rule__DynamicConfig__Group_2_0_1__1__Impl3636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_0__0__Impl_in_rule__DynamicConfig__Group_2_0_1_0__03670 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_0__1_in_rule__DynamicConfig__Group_2_0_1_0__03673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__DynamicConfig__Group_2_0_1_0__0__Impl3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_0__1__Impl_in_rule__DynamicConfig__Group_2_0_1_0__13732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1_in_rule__DynamicConfig__Group_2_0_1_0__1__Impl3759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_1__0__Impl_in_rule__DynamicConfig__Group_2_0_1_1__03793 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_1__1_in_rule__DynamicConfig__Group_2_0_1_1__03796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__DynamicConfig__Group_2_0_1_1__0__Impl3824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_0_1_1__1__Impl_in_rule__DynamicConfig__Group_2_0_1_1__13855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1_in_rule__DynamicConfig__Group_2_0_1_1__1__Impl3882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_1__0__Impl_in_rule__DynamicConfig__Group_2_1__03916 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_1__1_in_rule__DynamicConfig__Group_2_1__03919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__DynamicConfig__Group_2_1__0__Impl3947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_1__1__Impl_in_rule__DynamicConfig__Group_2_1__13978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__PollingAssignment_2_1_1_in_rule__DynamicConfig__Group_2_1__1__Impl4005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__0__Impl_in_rule__ActorClassConfig__Group__04039 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__1_in_rule__ActorClassConfig__Group__04042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ActorClassConfig__Group__0__Impl4070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__1__Impl_in_rule__ActorClassConfig__Group__14101 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__2_in_rule__ActorClassConfig__Group__14104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__ActorAssignment_1_in_rule__ActorClassConfig__Group__1__Impl4131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__2__Impl_in_rule__ActorClassConfig__Group__24161 = new BitSet(new long[]{0x0000000400100000L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__3_in_rule__ActorClassConfig__Group__24164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ActorClassConfig__Group__2__Impl4192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__3__Impl_in_rule__ActorClassConfig__Group__34223 = new BitSet(new long[]{0x0000000400100000L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__4_in_rule__ActorClassConfig__Group__34226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__AttributesAssignment_3_in_rule__ActorClassConfig__Group__3__Impl4253 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__ActorClassConfig__Group__4__Impl_in_rule__ActorClassConfig__Group__44284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ActorClassConfig__Group__4__Impl4312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__0__Impl_in_rule__ActorInstanceConfig__Group_0__04353 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__1_in_rule__ActorInstanceConfig__Group_0__04356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ActorInstanceConfig__Group_0__0__Impl4384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__1__Impl_in_rule__ActorInstanceConfig__Group_0__14415 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__2_in_rule__ActorInstanceConfig__Group_0__14418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__RootAssignment_0_1_in_rule__ActorInstanceConfig__Group_0__1__Impl4445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__2__Impl_in_rule__ActorInstanceConfig__Group_0__24475 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__3_in_rule__ActorInstanceConfig__Group_0__24478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ActorInstanceConfig__Group_0__2__Impl4506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__3__Impl_in_rule__ActorInstanceConfig__Group_0__34537 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__4_in_rule__ActorInstanceConfig__Group_0__34540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__PathAssignment_0_3_in_rule__ActorInstanceConfig__Group_0__3__Impl4567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__4__Impl_in_rule__ActorInstanceConfig__Group_0__44597 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__5_in_rule__ActorInstanceConfig__Group_0__44600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ActorInstanceConfig__Group_0__4__Impl4628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__5__Impl_in_rule__ActorInstanceConfig__Group_0__54659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__AttributesAssignment_0_5_in_rule__ActorInstanceConfig__Group_0__5__Impl4686 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_1__0__Impl_in_rule__ActorInstanceConfig__Group_1__04729 = new BitSet(new long[]{0x0000000208100000L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_1__1_in_rule__ActorInstanceConfig__Group_1__04732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__PortsAssignment_1_0_in_rule__ActorInstanceConfig__Group_1__0__Impl4759 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_1__1__Impl_in_rule__ActorInstanceConfig__Group_1__14790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ActorInstanceConfig__Group_1__1__Impl4818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__0__Impl_in_rule__ProtocolClassConfig__Group__04853 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__1_in_rule__ProtocolClassConfig__Group__04856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ProtocolClassConfig__Group__0__Impl4884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__1__Impl_in_rule__ProtocolClassConfig__Group__14915 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__2_in_rule__ProtocolClassConfig__Group__14918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__ProtocolAssignment_1_in_rule__ProtocolClassConfig__Group__1__Impl4945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__2__Impl_in_rule__ProtocolClassConfig__Group__24975 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__3_in_rule__ProtocolClassConfig__Group__24978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ProtocolClassConfig__Group__2__Impl5006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__3__Impl_in_rule__ProtocolClassConfig__Group__35037 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__4_in_rule__ProtocolClassConfig__Group__35040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3_in_rule__ProtocolClassConfig__Group__3__Impl5067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group__4__Impl_in_rule__ProtocolClassConfig__Group__45097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ProtocolClassConfig__Group__4__Impl5125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_0__0__Impl_in_rule__ProtocolClassConfig__Group_3_0__05166 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_0__1_in_rule__ProtocolClassConfig__Group_3_0__05169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ProtocolClassConfig__Group_3_0__0__Impl5197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_0__1__Impl_in_rule__ProtocolClassConfig__Group_3_0__15228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__RegularAssignment_3_0_1_in_rule__ProtocolClassConfig__Group_3_0__1__Impl5255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_1__0__Impl_in_rule__ProtocolClassConfig__Group_3_1__05289 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_1__1_in_rule__ProtocolClassConfig__Group_3_1__05292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ProtocolClassConfig__Group_3_1__0__Impl5320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_1__1__Impl_in_rule__ProtocolClassConfig__Group_3_1__15351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1_in_rule__ProtocolClassConfig__Group_3_1__1__Impl5378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__0__Impl_in_rule__PortClassConfig__Group__05412 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__1_in_rule__PortClassConfig__Group__05415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__1__Impl_in_rule__PortClassConfig__Group__15473 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__2_in_rule__PortClassConfig__Group__15476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__PortClassConfig__Group__1__Impl5504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__2__Impl_in_rule__PortClassConfig__Group__25535 = new BitSet(new long[]{0x0000000400100000L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__3_in_rule__PortClassConfig__Group__25538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PortClassConfig__Group__2__Impl5566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__3__Impl_in_rule__PortClassConfig__Group__35597 = new BitSet(new long[]{0x0000000400100000L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__4_in_rule__PortClassConfig__Group__35600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__AttributesAssignment_3_in_rule__PortClassConfig__Group__3__Impl5627 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__PortClassConfig__Group__4__Impl_in_rule__PortClassConfig__Group__45658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__PortClassConfig__Group__4__Impl5686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__0__Impl_in_rule__PortInstanceConfig__Group__05727 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__1_in_rule__PortInstanceConfig__Group__05730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__PortInstanceConfig__Group__0__Impl5758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__1__Impl_in_rule__PortInstanceConfig__Group__15789 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__2_in_rule__PortInstanceConfig__Group__15792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__ItemAssignment_1_in_rule__PortInstanceConfig__Group__1__Impl5819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__2__Impl_in_rule__PortInstanceConfig__Group__25849 = new BitSet(new long[]{0x0000000400100000L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__3_in_rule__PortInstanceConfig__Group__25852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PortInstanceConfig__Group__2__Impl5880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__3__Impl_in_rule__PortInstanceConfig__Group__35911 = new BitSet(new long[]{0x0000000400100000L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__4_in_rule__PortInstanceConfig__Group__35914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__AttributesAssignment_3_in_rule__PortInstanceConfig__Group__3__Impl5941 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__PortInstanceConfig__Group__4__Impl_in_rule__PortInstanceConfig__Group__45972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__PortInstanceConfig__Group__4__Impl6000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__0__Impl_in_rule__AttrClassConfig__Group__06041 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__1_in_rule__AttrClassConfig__Group__06044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__AttrClassConfig__Group__0__Impl6072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__1__Impl_in_rule__AttrClassConfig__Group__16103 = new BitSet(new long[]{0x0000000800080000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__2_in_rule__AttrClassConfig__Group__16106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__AttributeAssignment_1_in_rule__AttrClassConfig__Group__1__Impl6133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__2__Impl_in_rule__AttrClassConfig__Group__26163 = new BitSet(new long[]{0x0000000800080000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__3_in_rule__AttrClassConfig__Group__26166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_2__0_in_rule__AttrClassConfig__Group__2__Impl6193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group__3__Impl_in_rule__AttrClassConfig__Group__36224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__0_in_rule__AttrClassConfig__Group__3__Impl6251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_2__0__Impl_in_rule__AttrClassConfig__Group_2__06290 = new BitSet(new long[]{0x0000120000038150L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_2__1_in_rule__AttrClassConfig__Group_2__06293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AttrClassConfig__Group_2__0__Impl6321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_2__1__Impl_in_rule__AttrClassConfig__Group_2__16352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__ValueAssignment_2_1_in_rule__AttrClassConfig__Group_2__1__Impl6379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__0__Impl_in_rule__AttrClassConfig__Group_3__06413 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__1_in_rule__AttrClassConfig__Group_3__06416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AttrClassConfig__Group_3__0__Impl6444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__1__Impl_in_rule__AttrClassConfig__Group_3__16475 = new BitSet(new long[]{0x0000000400100000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__2_in_rule__AttrClassConfig__Group_3__16478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1_in_rule__AttrClassConfig__Group_3__1__Impl6505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__2__Impl_in_rule__AttrClassConfig__Group_3__26535 = new BitSet(new long[]{0x0000000400100000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__3_in_rule__AttrClassConfig__Group_3__26538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__AttributesAssignment_3_2_in_rule__AttrClassConfig__Group_3__2__Impl6565 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3__3__Impl_in_rule__AttrClassConfig__Group_3__36596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__AttrClassConfig__Group_3__3__Impl6624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__0__Impl_in_rule__AttrClassConfig__Group_3_1_0__06663 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__1_in_rule__AttrClassConfig__Group_3_1_0__06666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__AttrClassConfig__Group_3_1_0__0__Impl6694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__1__Impl_in_rule__AttrClassConfig__Group_3_1_0__16725 = new BitSet(new long[]{0x0000020000030050L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__2_in_rule__AttrClassConfig__Group_3_1_0__16728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AttrClassConfig__Group_3_1_0__1__Impl6756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__2__Impl_in_rule__AttrClassConfig__Group_3_1_0__26787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__MinAssignment_3_1_0_2_in_rule__AttrClassConfig__Group_3_1_0__2__Impl6814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__0__Impl_in_rule__AttrClassConfig__Group_3_1_1__06850 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__1_in_rule__AttrClassConfig__Group_3_1_1__06853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__AttrClassConfig__Group_3_1_1__0__Impl6881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__1__Impl_in_rule__AttrClassConfig__Group_3_1_1__16912 = new BitSet(new long[]{0x0000020000030050L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__2_in_rule__AttrClassConfig__Group_3_1_1__16915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AttrClassConfig__Group_3_1_1__1__Impl6943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__2__Impl_in_rule__AttrClassConfig__Group_3_1_1__26974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__MaxAssignment_3_1_1_2_in_rule__AttrClassConfig__Group_3_1_1__2__Impl7001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__0__Impl_in_rule__AttrInstanceConfig__Group__07037 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__1_in_rule__AttrInstanceConfig__Group__07040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__AttrInstanceConfig__Group__0__Impl7068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__1__Impl_in_rule__AttrInstanceConfig__Group__17099 = new BitSet(new long[]{0x0000000800080000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__2_in_rule__AttrInstanceConfig__Group__17102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__AttributeAssignment_1_in_rule__AttrInstanceConfig__Group__1__Impl7129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__2__Impl_in_rule__AttrInstanceConfig__Group__27159 = new BitSet(new long[]{0x0000000800080000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__3_in_rule__AttrInstanceConfig__Group__27162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_2__0_in_rule__AttrInstanceConfig__Group__2__Impl7189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group__3__Impl_in_rule__AttrInstanceConfig__Group__37220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__0_in_rule__AttrInstanceConfig__Group__3__Impl7247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_2__0__Impl_in_rule__AttrInstanceConfig__Group_2__07286 = new BitSet(new long[]{0x0000120000038150L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_2__1_in_rule__AttrInstanceConfig__Group_2__07289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AttrInstanceConfig__Group_2__0__Impl7317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_2__1__Impl_in_rule__AttrInstanceConfig__Group_2__17348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__ValueAssignment_2_1_in_rule__AttrInstanceConfig__Group_2__1__Impl7375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__0__Impl_in_rule__AttrInstanceConfig__Group_3__07409 = new BitSet(new long[]{0x0000000400300000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__1_in_rule__AttrInstanceConfig__Group_3__07412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AttrInstanceConfig__Group_3__0__Impl7440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__1__Impl_in_rule__AttrInstanceConfig__Group_3__17471 = new BitSet(new long[]{0x0000000400300000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__2_in_rule__AttrInstanceConfig__Group_3__17474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1__0_in_rule__AttrInstanceConfig__Group_3__1__Impl7501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__2__Impl_in_rule__AttrInstanceConfig__Group_3__27532 = new BitSet(new long[]{0x0000000400300000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__3_in_rule__AttrInstanceConfig__Group_3__27535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__AttributesAssignment_3_2_in_rule__AttrInstanceConfig__Group_3__2__Impl7562 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3__3__Impl_in_rule__AttrInstanceConfig__Group_3__37593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__AttrInstanceConfig__Group_3__3__Impl7621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1__0__Impl_in_rule__AttrInstanceConfig__Group_3_1__07660 = new BitSet(new long[]{0x0000080000002000L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1__1_in_rule__AttrInstanceConfig__Group_3_1__07663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_in_rule__AttrInstanceConfig__Group_3_1__0__Impl7690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Group_3_1__1__Impl_in_rule__AttrInstanceConfig__Group_3_1__17720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrInstanceConfig__Alternatives_3_1_1_in_rule__AttrInstanceConfig__Group_3_1__1__Impl7747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group__0__Impl_in_rule__RefPath__Group__07781 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__RefPath__Group__1_in_rule__RefPath__Group__07784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__RefsAssignment_0_in_rule__RefPath__Group__0__Impl7811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group__1__Impl_in_rule__RefPath__Group__17841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__0_in_rule__RefPath__Group__1__Impl7868 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__0__Impl_in_rule__RefPath__Group_1__07903 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__1_in_rule__RefPath__Group_1__07906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__RefPath__Group_1__0__Impl7934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__1__Impl_in_rule__RefPath__Group_1__17965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__RefsAssignment_1_1_in_rule__RefPath__Group_1__1__Impl7992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__08026 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__08029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Import__Group__0__Impl8057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__18088 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Import__Group__2_in_rule__Import__Group__18091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl8118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__28148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl8175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__08211 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__08214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl8241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__18271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Import__Group_1_0__1__Impl8299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__08334 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__08337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl8364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__18393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ImportedFQN__Group__1__Impl8422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__08459 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__08462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl8489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__18518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl8545 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__08580 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__08583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__FQN__Group_1__0__Impl8611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__18642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl8669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__0__Impl_in_rule__LiteralArray__Group__08702 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__1_in_rule__LiteralArray__Group__08705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__LiteralsAssignment_0_in_rule__LiteralArray__Group__0__Impl8732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__1__Impl_in_rule__LiteralArray__Group__18762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__0_in_rule__LiteralArray__Group__1__Impl8789 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__0__Impl_in_rule__LiteralArray__Group_1__08824 = new BitSet(new long[]{0x0000120000038150L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__1_in_rule__LiteralArray__Group_1__08827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__LiteralArray__Group_1__0__Impl8855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__1__Impl_in_rule__LiteralArray__Group_1__18886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__LiteralsAssignment_1_1_in_rule__LiteralArray__Group_1__1__Impl8913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__08947 = new BitSet(new long[]{0x0000100000008000L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__08950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__19008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl9035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__09069 = new BitSet(new long[]{0x0000020000030050L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__09072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__19130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl9157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__09191 = new BitSet(new long[]{0x0000000000030050L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__09194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__19252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl9279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__09313 = new BitSet(new long[]{0x0000120000038150L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__09316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__19374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl9401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__09435 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__09438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl9465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__19496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl9523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__09556 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__09559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl9586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__19617 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__19620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl9647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__29676 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__29679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Decimal__Group__2__Impl9707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__39738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl9765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__09802 = new BitSet(new long[]{0x0000020000030000L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__09805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl9832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__19863 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__19866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__DotDecimal__Group__1__Impl9894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__29925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl9952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__09987 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__09990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl10017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__110048 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__110051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl10078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__210107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__DecimalDot__Group__2__Impl10135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__010172 = new BitSet(new long[]{0x0000020000030050L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__010175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl10202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__110233 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__110236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl10263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__210292 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__210295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__DecimalExp__Group__2__Impl10323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__310354 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__310357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl10384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__410413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl10440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2__0_in_rule__DynamicConfig__UnorderedGroup_210480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Alternatives_2_0_in_rule__DynamicConfig__UnorderedGroup_2__Impl10569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__Group_2_1__0_in_rule__DynamicConfig__UnorderedGroup_2__Impl10660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2__Impl_in_rule__DynamicConfig__UnorderedGroup_2__010719 = new BitSet(new long[]{0x0000000002C00002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2__1_in_rule__DynamicConfig__UnorderedGroup_2__010722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DynamicConfig__UnorderedGroup_2__Impl_in_rule__DynamicConfig__UnorderedGroup_2__110747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__0_in_rule__ActorInstanceConfig__UnorderedGroup10775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_0__0_in_rule__ActorInstanceConfig__UnorderedGroup__Impl10864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__Group_1__0_in_rule__ActorInstanceConfig__UnorderedGroup__Impl10955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__Impl_in_rule__ActorInstanceConfig__UnorderedGroup__011014 = new BitSet(new long[]{0x0000000208100002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__1_in_rule__ActorInstanceConfig__UnorderedGroup__011017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceConfig__UnorderedGroup__Impl_in_rule__ActorInstanceConfig__UnorderedGroup__111042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__0_in_rule__ProtocolClassConfig__UnorderedGroup_311070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_0__0_in_rule__ProtocolClassConfig__UnorderedGroup_3__Impl11157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__Group_3_1__0_in_rule__ProtocolClassConfig__UnorderedGroup_3__Impl11248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__Impl_in_rule__ProtocolClassConfig__UnorderedGroup_3__011307 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__1_in_rule__ProtocolClassConfig__UnorderedGroup_3__011310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProtocolClassConfig__UnorderedGroup_3__Impl_in_rule__ProtocolClassConfig__UnorderedGroup_3__111335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__0_in_rule__AttrClassConfig__UnorderedGroup_3_111363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_0__0_in_rule__AttrClassConfig__UnorderedGroup_3_1__Impl11450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__Group_3_1_1__0_in_rule__AttrClassConfig__UnorderedGroup_3_1__Impl11541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__Impl_in_rule__AttrClassConfig__UnorderedGroup_3_1__011600 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__1_in_rule__AttrClassConfig__UnorderedGroup_3_1__011603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttrClassConfig__UnorderedGroup_3_1__Impl_in_rule__AttrClassConfig__UnorderedGroup_3_1__111628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__ConfigModel__ImportsAssignment_011660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigElement_in_rule__ConfigModel__ConfigElementsAssignment_111691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubSystemConfig__SubSystemAssignment_111726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDynamicConfig_in_rule__SubSystemConfig__DynConfigAssignment_311761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DynamicConfig__FilePathAssignment_2_0_0_111792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DynamicConfig__UserCode1Assignment_2_0_1_0_111823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DynamicConfig__UserCode2Assignment_2_0_1_1_111854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DynamicConfig__PollingAssignment_2_1_111885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ActorClassConfig__ActorAssignment_111920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_rule__ActorClassConfig__AttributesAssignment_311955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ActorInstanceConfig__RootAssignment_0_111990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefPath_in_rule__ActorInstanceConfig__PathAssignment_0_312025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_rule__ActorInstanceConfig__AttributesAssignment_0_512056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortInstanceConfig_in_rule__ActorInstanceConfig__PortsAssignment_1_012087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ProtocolClassConfig__ProtocolAssignment_112122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClassConfig_in_rule__ProtocolClassConfig__RegularAssignment_3_0_112157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClassConfig_in_rule__ProtocolClassConfig__ConjugatedAssignment_3_1_112188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_rule__PortClassConfig__AttributesAssignment_312219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PortInstanceConfig__ItemAssignment_112254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_rule__PortInstanceConfig__AttributesAssignment_312289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AttrClassConfig__AttributeAssignment_112324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralArray_in_rule__AttrClassConfig__ValueAssignment_2_112359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__AttrClassConfig__MinAssignment_3_1_0_212390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__AttrClassConfig__MaxAssignment_3_1_1_212421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_rule__AttrClassConfig__AttributesAssignment_3_212452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AttrInstanceConfig__AttributeAssignment_112487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralArray_in_rule__AttrInstanceConfig__ValueAssignment_2_112522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__AttrInstanceConfig__DynConfigAssignment_3_1_012558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_1_012602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_rule__AttrInstanceConfig__AttributesAssignment_3_212641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_012672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_1_112703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_012734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_212765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_012796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_1_112827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__BooleanLiteral__IsTrueAssignment_1_112863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_112902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_112933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_112964 = new BitSet(new long[]{0x0000000000000002L});

}
