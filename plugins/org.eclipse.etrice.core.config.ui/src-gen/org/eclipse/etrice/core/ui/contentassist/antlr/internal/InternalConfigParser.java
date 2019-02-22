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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_HEX", "RULE_INT", "RULE_STRING", "RULE_CC_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'conjugate'", "'conjugated'", "'write'", "'mandatory'", "'false'", "'+'", "'-'", "'e'", "'E'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'", "'ConfigModel'", "'{'", "'}'", "'SubSystemConfig'", "'/'", "'dynamic configuration'", "'file path'", "'user import'", "'user constructor'", "'polling interval'", "'ActorClassConfig'", "'ActorInstanceConfig'", "'ProtocolClassConfig'", "'regular'", "'Port'", "'InterfaceItem'", "'Attr'", "'='", "'min'", "'max'", "','", "'.'", "':'", "'attribute'", "'import'", "'from'", "'model'", "'.*'", "'['", "']'", "'s'", "'ms'", "'us'", "'ns'", "'read'", "'optional'", "'true'"
    };
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


        public InternalConfigParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConfigParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConfigParser.tokenNames; }
    public String getGrammarFileName() { return "InternalConfig.g"; }


     
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
    // InternalConfig.g:60:1: entryRuleConfigModel : ruleConfigModel EOF ;
    public final void entryRuleConfigModel() throws RecognitionException {
        try {
            // InternalConfig.g:61:1: ( ruleConfigModel EOF )
            // InternalConfig.g:62:1: ruleConfigModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleConfigModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigModelRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:69:1: ruleConfigModel : ( ( rule__ConfigModel__Group__0 ) ) ;
    public final void ruleConfigModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:73:2: ( ( ( rule__ConfigModel__Group__0 ) ) )
            // InternalConfig.g:74:1: ( ( rule__ConfigModel__Group__0 ) )
            {
            // InternalConfig.g:74:1: ( ( rule__ConfigModel__Group__0 ) )
            // InternalConfig.g:75:1: ( rule__ConfigModel__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getGroup()); 
            }
            // InternalConfig.g:76:1: ( rule__ConfigModel__Group__0 )
            // InternalConfig.g:76:2: rule__ConfigModel__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:88:1: entryRuleConfigElement : ruleConfigElement EOF ;
    public final void entryRuleConfigElement() throws RecognitionException {
        try {
            // InternalConfig.g:89:1: ( ruleConfigElement EOF )
            // InternalConfig.g:90:1: ruleConfigElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigElementRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleConfigElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigElementRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:97:1: ruleConfigElement : ( ( rule__ConfigElement__Alternatives ) ) ;
    public final void ruleConfigElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:101:2: ( ( ( rule__ConfigElement__Alternatives ) ) )
            // InternalConfig.g:102:1: ( ( rule__ConfigElement__Alternatives ) )
            {
            // InternalConfig.g:102:1: ( ( rule__ConfigElement__Alternatives ) )
            // InternalConfig.g:103:1: ( rule__ConfigElement__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigElementAccess().getAlternatives()); 
            }
            // InternalConfig.g:104:1: ( rule__ConfigElement__Alternatives )
            // InternalConfig.g:104:2: rule__ConfigElement__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:116:1: entryRuleSubSystemConfig : ruleSubSystemConfig EOF ;
    public final void entryRuleSubSystemConfig() throws RecognitionException {
        try {
            // InternalConfig.g:117:1: ( ruleSubSystemConfig EOF )
            // InternalConfig.g:118:1: ruleSubSystemConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSubSystemConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:125:1: ruleSubSystemConfig : ( ( rule__SubSystemConfig__Group__0 ) ) ;
    public final void ruleSubSystemConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:129:2: ( ( ( rule__SubSystemConfig__Group__0 ) ) )
            // InternalConfig.g:130:1: ( ( rule__SubSystemConfig__Group__0 ) )
            {
            // InternalConfig.g:130:1: ( ( rule__SubSystemConfig__Group__0 ) )
            // InternalConfig.g:131:1: ( rule__SubSystemConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getGroup()); 
            }
            // InternalConfig.g:132:1: ( rule__SubSystemConfig__Group__0 )
            // InternalConfig.g:132:2: rule__SubSystemConfig__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:144:1: entryRuleDynamicConfig : ruleDynamicConfig EOF ;
    public final void entryRuleDynamicConfig() throws RecognitionException {
        try {
            // InternalConfig.g:145:1: ( ruleDynamicConfig EOF )
            // InternalConfig.g:146:1: ruleDynamicConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDynamicConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:153:1: ruleDynamicConfig : ( ( rule__DynamicConfig__Group__0 ) ) ;
    public final void ruleDynamicConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:157:2: ( ( ( rule__DynamicConfig__Group__0 ) ) )
            // InternalConfig.g:158:1: ( ( rule__DynamicConfig__Group__0 ) )
            {
            // InternalConfig.g:158:1: ( ( rule__DynamicConfig__Group__0 ) )
            // InternalConfig.g:159:1: ( rule__DynamicConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getGroup()); 
            }
            // InternalConfig.g:160:1: ( rule__DynamicConfig__Group__0 )
            // InternalConfig.g:160:2: rule__DynamicConfig__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:172:1: entryRuleActorClassConfig : ruleActorClassConfig EOF ;
    public final void entryRuleActorClassConfig() throws RecognitionException {
        try {
            // InternalConfig.g:173:1: ( ruleActorClassConfig EOF )
            // InternalConfig.g:174:1: ruleActorClassConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleActorClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorClassConfigRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:181:1: ruleActorClassConfig : ( ( rule__ActorClassConfig__Group__0 ) ) ;
    public final void ruleActorClassConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:185:2: ( ( ( rule__ActorClassConfig__Group__0 ) ) )
            // InternalConfig.g:186:1: ( ( rule__ActorClassConfig__Group__0 ) )
            {
            // InternalConfig.g:186:1: ( ( rule__ActorClassConfig__Group__0 ) )
            // InternalConfig.g:187:1: ( rule__ActorClassConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getGroup()); 
            }
            // InternalConfig.g:188:1: ( rule__ActorClassConfig__Group__0 )
            // InternalConfig.g:188:2: rule__ActorClassConfig__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:200:1: entryRuleActorInstanceConfig : ruleActorInstanceConfig EOF ;
    public final void entryRuleActorInstanceConfig() throws RecognitionException {
        try {
            // InternalConfig.g:201:1: ( ruleActorInstanceConfig EOF )
            // InternalConfig.g:202:1: ruleActorInstanceConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleActorInstanceConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:209:1: ruleActorInstanceConfig : ( ( rule__ActorInstanceConfig__Group__0 ) ) ;
    public final void ruleActorInstanceConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:213:2: ( ( ( rule__ActorInstanceConfig__Group__0 ) ) )
            // InternalConfig.g:214:1: ( ( rule__ActorInstanceConfig__Group__0 ) )
            {
            // InternalConfig.g:214:1: ( ( rule__ActorInstanceConfig__Group__0 ) )
            // InternalConfig.g:215:1: ( rule__ActorInstanceConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getGroup()); 
            }
            // InternalConfig.g:216:1: ( rule__ActorInstanceConfig__Group__0 )
            // InternalConfig.g:216:2: rule__ActorInstanceConfig__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:228:1: entryRuleProtocolClassConfig : ruleProtocolClassConfig EOF ;
    public final void entryRuleProtocolClassConfig() throws RecognitionException {
        try {
            // InternalConfig.g:229:1: ( ruleProtocolClassConfig EOF )
            // InternalConfig.g:230:1: ruleProtocolClassConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleProtocolClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:237:1: ruleProtocolClassConfig : ( ( rule__ProtocolClassConfig__Group__0 ) ) ;
    public final void ruleProtocolClassConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:241:2: ( ( ( rule__ProtocolClassConfig__Group__0 ) ) )
            // InternalConfig.g:242:1: ( ( rule__ProtocolClassConfig__Group__0 ) )
            {
            // InternalConfig.g:242:1: ( ( rule__ProtocolClassConfig__Group__0 ) )
            // InternalConfig.g:243:1: ( rule__ProtocolClassConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getGroup()); 
            }
            // InternalConfig.g:244:1: ( rule__ProtocolClassConfig__Group__0 )
            // InternalConfig.g:244:2: rule__ProtocolClassConfig__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:256:1: entryRulePortClassConfig : rulePortClassConfig EOF ;
    public final void entryRulePortClassConfig() throws RecognitionException {
        try {
            // InternalConfig.g:257:1: ( rulePortClassConfig EOF )
            // InternalConfig.g:258:1: rulePortClassConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePortClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortClassConfigRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:265:1: rulePortClassConfig : ( ( rule__PortClassConfig__Group__0 ) ) ;
    public final void rulePortClassConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:269:2: ( ( ( rule__PortClassConfig__Group__0 ) ) )
            // InternalConfig.g:270:1: ( ( rule__PortClassConfig__Group__0 ) )
            {
            // InternalConfig.g:270:1: ( ( rule__PortClassConfig__Group__0 ) )
            // InternalConfig.g:271:1: ( rule__PortClassConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getGroup()); 
            }
            // InternalConfig.g:272:1: ( rule__PortClassConfig__Group__0 )
            // InternalConfig.g:272:2: rule__PortClassConfig__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:284:1: entryRulePortInstanceConfig : rulePortInstanceConfig EOF ;
    public final void entryRulePortInstanceConfig() throws RecognitionException {
        try {
            // InternalConfig.g:285:1: ( rulePortInstanceConfig EOF )
            // InternalConfig.g:286:1: rulePortInstanceConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePortInstanceConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPortInstanceConfigRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:293:1: rulePortInstanceConfig : ( ( rule__PortInstanceConfig__Group__0 ) ) ;
    public final void rulePortInstanceConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:297:2: ( ( ( rule__PortInstanceConfig__Group__0 ) ) )
            // InternalConfig.g:298:1: ( ( rule__PortInstanceConfig__Group__0 ) )
            {
            // InternalConfig.g:298:1: ( ( rule__PortInstanceConfig__Group__0 ) )
            // InternalConfig.g:299:1: ( rule__PortInstanceConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getGroup()); 
            }
            // InternalConfig.g:300:1: ( rule__PortInstanceConfig__Group__0 )
            // InternalConfig.g:300:2: rule__PortInstanceConfig__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:314:1: entryRuleAttrClassConfig : ruleAttrClassConfig EOF ;
    public final void entryRuleAttrClassConfig() throws RecognitionException {
        try {
            // InternalConfig.g:315:1: ( ruleAttrClassConfig EOF )
            // InternalConfig.g:316:1: ruleAttrClassConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAttrClassConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:323:1: ruleAttrClassConfig : ( ( rule__AttrClassConfig__Group__0 ) ) ;
    public final void ruleAttrClassConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:327:2: ( ( ( rule__AttrClassConfig__Group__0 ) ) )
            // InternalConfig.g:328:1: ( ( rule__AttrClassConfig__Group__0 ) )
            {
            // InternalConfig.g:328:1: ( ( rule__AttrClassConfig__Group__0 ) )
            // InternalConfig.g:329:1: ( rule__AttrClassConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup()); 
            }
            // InternalConfig.g:330:1: ( rule__AttrClassConfig__Group__0 )
            // InternalConfig.g:330:2: rule__AttrClassConfig__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:342:1: entryRuleAttrInstanceConfig : ruleAttrInstanceConfig EOF ;
    public final void entryRuleAttrInstanceConfig() throws RecognitionException {
        try {
            // InternalConfig.g:343:1: ( ruleAttrInstanceConfig EOF )
            // InternalConfig.g:344:1: ruleAttrInstanceConfig EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAttrInstanceConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:351:1: ruleAttrInstanceConfig : ( ( rule__AttrInstanceConfig__Group__0 ) ) ;
    public final void ruleAttrInstanceConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:355:2: ( ( ( rule__AttrInstanceConfig__Group__0 ) ) )
            // InternalConfig.g:356:1: ( ( rule__AttrInstanceConfig__Group__0 ) )
            {
            // InternalConfig.g:356:1: ( ( rule__AttrInstanceConfig__Group__0 ) )
            // InternalConfig.g:357:1: ( rule__AttrInstanceConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup()); 
            }
            // InternalConfig.g:358:1: ( rule__AttrInstanceConfig__Group__0 )
            // InternalConfig.g:358:2: rule__AttrInstanceConfig__Group__0
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleConfigValueArray"
    // InternalConfig.g:370:1: entryRuleConfigValueArray : ruleConfigValueArray EOF ;
    public final void entryRuleConfigValueArray() throws RecognitionException {
        try {
            // InternalConfig.g:371:1: ( ruleConfigValueArray EOF )
            // InternalConfig.g:372:1: ruleConfigValueArray EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleConfigValueArray();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueArrayRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleConfigValueArray"


    // $ANTLR start "ruleConfigValueArray"
    // InternalConfig.g:379:1: ruleConfigValueArray : ( ( rule__ConfigValueArray__Group__0 ) ) ;
    public final void ruleConfigValueArray() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:383:2: ( ( ( rule__ConfigValueArray__Group__0 ) ) )
            // InternalConfig.g:384:1: ( ( rule__ConfigValueArray__Group__0 ) )
            {
            // InternalConfig.g:384:1: ( ( rule__ConfigValueArray__Group__0 ) )
            // InternalConfig.g:385:1: ( rule__ConfigValueArray__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueArrayAccess().getGroup()); 
            }
            // InternalConfig.g:386:1: ( rule__ConfigValueArray__Group__0 )
            // InternalConfig.g:386:2: rule__ConfigValueArray__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConfigValueArray__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueArrayAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConfigValueArray"


    // $ANTLR start "entryRuleConfigValue"
    // InternalConfig.g:398:1: entryRuleConfigValue : ruleConfigValue EOF ;
    public final void entryRuleConfigValue() throws RecognitionException {
        try {
            // InternalConfig.g:399:1: ( ruleConfigValue EOF )
            // InternalConfig.g:400:1: ruleConfigValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleConfigValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleConfigValue"


    // $ANTLR start "ruleConfigValue"
    // InternalConfig.g:407:1: ruleConfigValue : ( ( rule__ConfigValue__Alternatives ) ) ;
    public final void ruleConfigValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:411:2: ( ( ( rule__ConfigValue__Alternatives ) ) )
            // InternalConfig.g:412:1: ( ( rule__ConfigValue__Alternatives ) )
            {
            // InternalConfig.g:412:1: ( ( rule__ConfigValue__Alternatives ) )
            // InternalConfig.g:413:1: ( rule__ConfigValue__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getAlternatives()); 
            }
            // InternalConfig.g:414:1: ( rule__ConfigValue__Alternatives )
            // InternalConfig.g:414:2: rule__ConfigValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ConfigValue__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConfigValue"


    // $ANTLR start "entryRuleLiteralConfigValue"
    // InternalConfig.g:426:1: entryRuleLiteralConfigValue : ruleLiteralConfigValue EOF ;
    public final void entryRuleLiteralConfigValue() throws RecognitionException {
        try {
            // InternalConfig.g:427:1: ( ruleLiteralConfigValue EOF )
            // InternalConfig.g:428:1: ruleLiteralConfigValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralConfigValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLiteralConfigValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralConfigValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleLiteralConfigValue"


    // $ANTLR start "ruleLiteralConfigValue"
    // InternalConfig.g:435:1: ruleLiteralConfigValue : ( ( rule__LiteralConfigValue__ValueAssignment ) ) ;
    public final void ruleLiteralConfigValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:439:2: ( ( ( rule__LiteralConfigValue__ValueAssignment ) ) )
            // InternalConfig.g:440:1: ( ( rule__LiteralConfigValue__ValueAssignment ) )
            {
            // InternalConfig.g:440:1: ( ( rule__LiteralConfigValue__ValueAssignment ) )
            // InternalConfig.g:441:1: ( rule__LiteralConfigValue__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralConfigValueAccess().getValueAssignment()); 
            }
            // InternalConfig.g:442:1: ( rule__LiteralConfigValue__ValueAssignment )
            // InternalConfig.g:442:2: rule__LiteralConfigValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__LiteralConfigValue__ValueAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralConfigValueAccess().getValueAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralConfigValue"


    // $ANTLR start "entryRuleEnumConfigValue"
    // InternalConfig.g:454:1: entryRuleEnumConfigValue : ruleEnumConfigValue EOF ;
    public final void entryRuleEnumConfigValue() throws RecognitionException {
        try {
            // InternalConfig.g:455:1: ( ruleEnumConfigValue EOF )
            // InternalConfig.g:456:1: ruleEnumConfigValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEnumConfigValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumConfigValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleEnumConfigValue"


    // $ANTLR start "ruleEnumConfigValue"
    // InternalConfig.g:463:1: ruleEnumConfigValue : ( ( rule__EnumConfigValue__Group__0 ) ) ;
    public final void ruleEnumConfigValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:467:2: ( ( ( rule__EnumConfigValue__Group__0 ) ) )
            // InternalConfig.g:468:1: ( ( rule__EnumConfigValue__Group__0 ) )
            {
            // InternalConfig.g:468:1: ( ( rule__EnumConfigValue__Group__0 ) )
            // InternalConfig.g:469:1: ( rule__EnumConfigValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueAccess().getGroup()); 
            }
            // InternalConfig.g:470:1: ( rule__EnumConfigValue__Group__0 )
            // InternalConfig.g:470:2: rule__EnumConfigValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EnumConfigValue__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumConfigValueAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumConfigValue"


    // $ANTLR start "entryRuleRefPath"
    // InternalConfig.g:482:1: entryRuleRefPath : ruleRefPath EOF ;
    public final void entryRuleRefPath() throws RecognitionException {
        try {
            // InternalConfig.g:483:1: ( ruleRefPath EOF )
            // InternalConfig.g:484:1: ruleRefPath EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRefPath();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefPathRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:491:1: ruleRefPath : ( ( rule__RefPath__Group__0 ) ) ;
    public final void ruleRefPath() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:495:2: ( ( ( rule__RefPath__Group__0 ) ) )
            // InternalConfig.g:496:1: ( ( rule__RefPath__Group__0 ) )
            {
            // InternalConfig.g:496:1: ( ( rule__RefPath__Group__0 ) )
            // InternalConfig.g:497:1: ( rule__RefPath__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getGroup()); 
            }
            // InternalConfig.g:498:1: ( rule__RefPath__Group__0 )
            // InternalConfig.g:498:2: rule__RefPath__Group__0
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleRefSegment"
    // InternalConfig.g:510:1: entryRuleRefSegment : ruleRefSegment EOF ;
    public final void entryRuleRefSegment() throws RecognitionException {
        try {
            // InternalConfig.g:511:1: ( ruleRefSegment EOF )
            // InternalConfig.g:512:1: ruleRefSegment EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefSegmentRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRefSegment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefSegmentRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleRefSegment"


    // $ANTLR start "ruleRefSegment"
    // InternalConfig.g:519:1: ruleRefSegment : ( ( rule__RefSegment__Group__0 ) ) ;
    public final void ruleRefSegment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:523:2: ( ( ( rule__RefSegment__Group__0 ) ) )
            // InternalConfig.g:524:1: ( ( rule__RefSegment__Group__0 ) )
            {
            // InternalConfig.g:524:1: ( ( rule__RefSegment__Group__0 ) )
            // InternalConfig.g:525:1: ( rule__RefSegment__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefSegmentAccess().getGroup()); 
            }
            // InternalConfig.g:526:1: ( rule__RefSegment__Group__0 )
            // InternalConfig.g:526:2: rule__RefSegment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RefSegment__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefSegmentAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRefSegment"


    // $ANTLR start "entryRuleKeyValue"
    // InternalConfig.g:540:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // InternalConfig.g:541:1: ( ruleKeyValue EOF )
            // InternalConfig.g:542:1: ruleKeyValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeyValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleKeyValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeyValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:549:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:553:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // InternalConfig.g:554:1: ( ( rule__KeyValue__Group__0 ) )
            {
            // InternalConfig.g:554:1: ( ( rule__KeyValue__Group__0 ) )
            // InternalConfig.g:555:1: ( rule__KeyValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeyValueAccess().getGroup()); 
            }
            // InternalConfig.g:556:1: ( rule__KeyValue__Group__0 )
            // InternalConfig.g:556:2: rule__KeyValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__KeyValue__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeyValueAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalConfig.g:570:1: entryRuleAnnotationTargetType : ruleAnnotationTargetType EOF ;
    public final void entryRuleAnnotationTargetType() throws RecognitionException {
        try {
            // InternalConfig.g:571:1: ( ruleAnnotationTargetType EOF )
            // InternalConfig.g:572:1: ruleAnnotationTargetType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAnnotationTargetTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAnnotationTargetType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAnnotationTargetTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:579:1: ruleAnnotationTargetType : ( RULE_ID ) ;
    public final void ruleAnnotationTargetType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:583:2: ( ( RULE_ID ) )
            // InternalConfig.g:584:1: ( RULE_ID )
            {
            // InternalConfig.g:584:1: ( RULE_ID )
            // InternalConfig.g:585:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAnnotationTargetTypeAccess().getIDTerminalRuleCall()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAnnotationTargetTypeAccess().getIDTerminalRuleCall()); 
            }

            }


            }

        }
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
    // InternalConfig.g:598:1: entryRuleAnnotationAttribute : ruleAnnotationAttribute EOF ;
    public final void entryRuleAnnotationAttribute() throws RecognitionException {
        try {
            // InternalConfig.g:599:1: ( ruleAnnotationAttribute EOF )
            // InternalConfig.g:600:1: ruleAnnotationAttribute EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAnnotationAttributeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAnnotationAttribute();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAnnotationAttributeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:607:1: ruleAnnotationAttribute : ( ( rule__AnnotationAttribute__Alternatives ) ) ;
    public final void ruleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:611:2: ( ( ( rule__AnnotationAttribute__Alternatives ) ) )
            // InternalConfig.g:612:1: ( ( rule__AnnotationAttribute__Alternatives ) )
            {
            // InternalConfig.g:612:1: ( ( rule__AnnotationAttribute__Alternatives ) )
            // InternalConfig.g:613:1: ( rule__AnnotationAttribute__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAnnotationAttributeAccess().getAlternatives()); 
            }
            // InternalConfig.g:614:1: ( rule__AnnotationAttribute__Alternatives )
            // InternalConfig.g:614:2: rule__AnnotationAttribute__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AnnotationAttribute__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAnnotationAttributeAccess().getAlternatives()); 
            }

            }


            }

        }
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
    // InternalConfig.g:626:1: entryRuleSimpleAnnotationAttribute : ruleSimpleAnnotationAttribute EOF ;
    public final void entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        try {
            // InternalConfig.g:627:1: ( ruleSimpleAnnotationAttribute EOF )
            // InternalConfig.g:628:1: ruleSimpleAnnotationAttribute EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSimpleAnnotationAttribute();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleAnnotationAttributeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:635:1: ruleSimpleAnnotationAttribute : ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) ;
    public final void ruleSimpleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:639:2: ( ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) )
            // InternalConfig.g:640:1: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            {
            // InternalConfig.g:640:1: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            // InternalConfig.g:641:1: ( rule__SimpleAnnotationAttribute__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup()); 
            }
            // InternalConfig.g:642:1: ( rule__SimpleAnnotationAttribute__Group__0 )
            // InternalConfig.g:642:2: rule__SimpleAnnotationAttribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleAnnotationAttribute__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup()); 
            }

            }


            }

        }
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
    // InternalConfig.g:654:1: entryRuleEnumAnnotationAttribute : ruleEnumAnnotationAttribute EOF ;
    public final void entryRuleEnumAnnotationAttribute() throws RecognitionException {
        try {
            // InternalConfig.g:655:1: ( ruleEnumAnnotationAttribute EOF )
            // InternalConfig.g:656:1: ruleEnumAnnotationAttribute EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEnumAnnotationAttribute();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:663:1: ruleEnumAnnotationAttribute : ( ( rule__EnumAnnotationAttribute__Group__0 ) ) ;
    public final void ruleEnumAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:667:2: ( ( ( rule__EnumAnnotationAttribute__Group__0 ) ) )
            // InternalConfig.g:668:1: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            {
            // InternalConfig.g:668:1: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            // InternalConfig.g:669:1: ( rule__EnumAnnotationAttribute__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup()); 
            }
            // InternalConfig.g:670:1: ( rule__EnumAnnotationAttribute__Group__0 )
            // InternalConfig.g:670:2: rule__EnumAnnotationAttribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleImport"
    // InternalConfig.g:682:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalConfig.g:683:1: ( ruleImport EOF )
            // InternalConfig.g:684:1: ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:691:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:695:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalConfig.g:696:1: ( ( rule__Import__Group__0 ) )
            {
            // InternalConfig.g:696:1: ( ( rule__Import__Group__0 ) )
            // InternalConfig.g:697:1: ( rule__Import__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getGroup()); 
            }
            // InternalConfig.g:698:1: ( rule__Import__Group__0 )
            // InternalConfig.g:698:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:710:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // InternalConfig.g:711:1: ( ruleImportedFQN EOF )
            // InternalConfig.g:712:1: ruleImportedFQN EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportedFQNRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleImportedFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportedFQNRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:719:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:723:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // InternalConfig.g:724:1: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // InternalConfig.g:724:1: ( ( rule__ImportedFQN__Group__0 ) )
            // InternalConfig.g:725:1: ( rule__ImportedFQN__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportedFQNAccess().getGroup()); 
            }
            // InternalConfig.g:726:1: ( rule__ImportedFQN__Group__0 )
            // InternalConfig.g:726:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleDocumentation"
    // InternalConfig.g:738:1: entryRuleDocumentation : ruleDocumentation EOF ;
    public final void entryRuleDocumentation() throws RecognitionException {
        try {
            // InternalConfig.g:739:1: ( ruleDocumentation EOF )
            // InternalConfig.g:740:1: ruleDocumentation EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDocumentationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDocumentation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDocumentationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:747:1: ruleDocumentation : ( ( rule__Documentation__Group__0 ) ) ;
    public final void ruleDocumentation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:751:2: ( ( ( rule__Documentation__Group__0 ) ) )
            // InternalConfig.g:752:1: ( ( rule__Documentation__Group__0 ) )
            {
            // InternalConfig.g:752:1: ( ( rule__Documentation__Group__0 ) )
            // InternalConfig.g:753:1: ( rule__Documentation__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDocumentationAccess().getGroup()); 
            }
            // InternalConfig.g:754:1: ( rule__Documentation__Group__0 )
            // InternalConfig.g:754:2: rule__Documentation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Documentation__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDocumentationAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleTIME"
    // InternalConfig.g:766:1: entryRuleTIME : ruleTIME EOF ;
    public final void entryRuleTIME() throws RecognitionException {
        try {
            // InternalConfig.g:767:1: ( ruleTIME EOF )
            // InternalConfig.g:768:1: ruleTIME EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTIMERule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTIME();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTIMERule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTIME"


    // $ANTLR start "ruleTIME"
    // InternalConfig.g:775:1: ruleTIME : ( ( rule__TIME__Alternatives ) ) ;
    public final void ruleTIME() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:779:2: ( ( ( rule__TIME__Alternatives ) ) )
            // InternalConfig.g:780:1: ( ( rule__TIME__Alternatives ) )
            {
            // InternalConfig.g:780:1: ( ( rule__TIME__Alternatives ) )
            // InternalConfig.g:781:1: ( rule__TIME__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTIMEAccess().getAlternatives()); 
            }
            // InternalConfig.g:782:1: ( rule__TIME__Alternatives )
            // InternalConfig.g:782:2: rule__TIME__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TIME__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTIMEAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTIME"


    // $ANTLR start "entryRuleLiteral"
    // InternalConfig.g:796:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalConfig.g:797:1: ( ruleLiteral EOF )
            // InternalConfig.g:798:1: ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:805:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:809:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalConfig.g:810:1: ( ( rule__Literal__Alternatives ) )
            {
            // InternalConfig.g:810:1: ( ( rule__Literal__Alternatives ) )
            // InternalConfig.g:811:1: ( rule__Literal__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getAlternatives()); 
            }
            // InternalConfig.g:812:1: ( rule__Literal__Alternatives )
            // InternalConfig.g:812:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:824:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // InternalConfig.g:825:1: ( ruleBooleanLiteral EOF )
            // InternalConfig.g:826:1: ruleBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBooleanLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:833:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:837:2: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // InternalConfig.g:838:1: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // InternalConfig.g:838:1: ( ( rule__BooleanLiteral__Group__0 ) )
            // InternalConfig.g:839:1: ( rule__BooleanLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            }
            // InternalConfig.g:840:1: ( rule__BooleanLiteral__Group__0 )
            // InternalConfig.g:840:2: rule__BooleanLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:852:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // InternalConfig.g:853:1: ( ruleNumberLiteral EOF )
            // InternalConfig.g:854:1: ruleNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleNumberLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:861:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Alternatives ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:865:2: ( ( ( rule__NumberLiteral__Alternatives ) ) )
            // InternalConfig.g:866:1: ( ( rule__NumberLiteral__Alternatives ) )
            {
            // InternalConfig.g:866:1: ( ( rule__NumberLiteral__Alternatives ) )
            // InternalConfig.g:867:1: ( rule__NumberLiteral__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            }
            // InternalConfig.g:868:1: ( rule__NumberLiteral__Alternatives )
            // InternalConfig.g:868:2: rule__NumberLiteral__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:880:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // InternalConfig.g:881:1: ( ruleRealLiteral EOF )
            // InternalConfig.g:882:1: ruleRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRealLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:889:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:893:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // InternalConfig.g:894:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // InternalConfig.g:894:1: ( ( rule__RealLiteral__Group__0 ) )
            // InternalConfig.g:895:1: ( rule__RealLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getGroup()); 
            }
            // InternalConfig.g:896:1: ( rule__RealLiteral__Group__0 )
            // InternalConfig.g:896:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:908:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // InternalConfig.g:909:1: ( ruleIntLiteral EOF )
            // InternalConfig.g:910:1: ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleIntLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:917:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:921:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // InternalConfig.g:922:1: ( ( rule__IntLiteral__Group__0 ) )
            {
            // InternalConfig.g:922:1: ( ( rule__IntLiteral__Group__0 ) )
            // InternalConfig.g:923:1: ( rule__IntLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getGroup()); 
            }
            // InternalConfig.g:924:1: ( rule__IntLiteral__Group__0 )
            // InternalConfig.g:924:2: rule__IntLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:936:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // InternalConfig.g:937:1: ( ruleStringLiteral EOF )
            // InternalConfig.g:938:1: ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStringLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:945:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:949:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // InternalConfig.g:950:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // InternalConfig.g:950:1: ( ( rule__StringLiteral__Group__0 ) )
            // InternalConfig.g:951:1: ( rule__StringLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getGroup()); 
            }
            // InternalConfig.g:952:1: ( rule__StringLiteral__Group__0 )
            // InternalConfig.g:952:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:964:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // InternalConfig.g:965:1: ( ruleInteger EOF )
            // InternalConfig.g:966:1: ruleInteger EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleInteger();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:973:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:977:2: ( ( ( rule__Integer__Alternatives ) ) )
            // InternalConfig.g:978:1: ( ( rule__Integer__Alternatives ) )
            {
            // InternalConfig.g:978:1: ( ( rule__Integer__Alternatives ) )
            // InternalConfig.g:979:1: ( rule__Integer__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerAccess().getAlternatives()); 
            }
            // InternalConfig.g:980:1: ( rule__Integer__Alternatives )
            // InternalConfig.g:980:2: rule__Integer__Alternatives
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleReal"
    // InternalConfig.g:992:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // InternalConfig.g:993:1: ( ruleReal EOF )
            // InternalConfig.g:994:1: ruleReal EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleReal();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:1001:1: ruleReal : ( ( rule__Real__Alternatives ) ) ;
    public final void ruleReal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1005:2: ( ( ( rule__Real__Alternatives ) ) )
            // InternalConfig.g:1006:1: ( ( rule__Real__Alternatives ) )
            {
            // InternalConfig.g:1006:1: ( ( rule__Real__Alternatives ) )
            // InternalConfig.g:1007:1: ( rule__Real__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealAccess().getAlternatives()); 
            }
            // InternalConfig.g:1008:1: ( rule__Real__Alternatives )
            // InternalConfig.g:1008:2: rule__Real__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1020:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalConfig.g:1024:1: ( ruleDecimal EOF )
            // InternalConfig.g:1025:1: ruleDecimal EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDecimal();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:1035:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1040:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // InternalConfig.g:1041:1: ( ( rule__Decimal__Group__0 ) )
            {
            // InternalConfig.g:1041:1: ( ( rule__Decimal__Group__0 ) )
            // InternalConfig.g:1042:1: ( rule__Decimal__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getGroup()); 
            }
            // InternalConfig.g:1043:1: ( rule__Decimal__Group__0 )
            // InternalConfig.g:1043:2: rule__Decimal__Group__0
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleDecimalExp"
    // InternalConfig.g:1056:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalConfig.g:1060:1: ( ruleDecimalExp EOF )
            // InternalConfig.g:1061:1: ruleDecimalExp EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDecimalExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalExpRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:1071:1: ruleDecimalExp : ( ( rule__DecimalExp__Group__0 ) ) ;
    public final void ruleDecimalExp() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1076:2: ( ( ( rule__DecimalExp__Group__0 ) ) )
            // InternalConfig.g:1077:1: ( ( rule__DecimalExp__Group__0 ) )
            {
            // InternalConfig.g:1077:1: ( ( rule__DecimalExp__Group__0 ) )
            // InternalConfig.g:1078:1: ( rule__DecimalExp__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getGroup()); 
            }
            // InternalConfig.g:1079:1: ( rule__DecimalExp__Group__0 )
            // InternalConfig.g:1079:2: rule__DecimalExp__Group__0
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleFQN"
    // InternalConfig.g:1092:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalConfig.g:1093:1: ( ruleFQN EOF )
            // InternalConfig.g:1094:1: ruleFQN EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFQNRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalConfig.g:1101:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1105:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalConfig.g:1106:1: ( ( rule__FQN__Group__0 ) )
            {
            // InternalConfig.g:1106:1: ( ( rule__FQN__Group__0 ) )
            // InternalConfig.g:1107:1: ( rule__FQN__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getGroup()); 
            }
            // InternalConfig.g:1108:1: ( rule__FQN__Group__0 )
            // InternalConfig.g:1108:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "ruleLiteralType"
    // InternalConfig.g:1121:1: ruleLiteralType : ( ( rule__LiteralType__Alternatives ) ) ;
    public final void ruleLiteralType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1125:1: ( ( ( rule__LiteralType__Alternatives ) ) )
            // InternalConfig.g:1126:1: ( ( rule__LiteralType__Alternatives ) )
            {
            // InternalConfig.g:1126:1: ( ( rule__LiteralType__Alternatives ) )
            // InternalConfig.g:1127:1: ( rule__LiteralType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeAccess().getAlternatives()); 
            }
            // InternalConfig.g:1128:1: ( rule__LiteralType__Alternatives )
            // InternalConfig.g:1128:2: rule__LiteralType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__LiteralType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralTypeAccess().getAlternatives()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__ConfigElement__Alternatives"
    // InternalConfig.g:1139:1: rule__ConfigElement__Alternatives : ( ( ruleSubSystemConfig ) | ( ruleActorClassConfig ) | ( ruleActorInstanceConfig ) | ( ruleProtocolClassConfig ) );
    public final void rule__ConfigElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1143:1: ( ( ruleSubSystemConfig ) | ( ruleActorClassConfig ) | ( ruleActorInstanceConfig ) | ( ruleProtocolClassConfig ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt1=1;
                }
                break;
            case 36:
                {
                alt1=2;
                }
                break;
            case 37:
                {
                alt1=3;
                }
                break;
            case 38:
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
                    // InternalConfig.g:1144:1: ( ruleSubSystemConfig )
                    {
                    // InternalConfig.g:1144:1: ( ruleSubSystemConfig )
                    // InternalConfig.g:1145:1: ruleSubSystemConfig
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigElementAccess().getSubSystemConfigParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalConfig.g:1150:6: ( ruleActorClassConfig )
                    {
                    // InternalConfig.g:1150:6: ( ruleActorClassConfig )
                    // InternalConfig.g:1151:1: ruleActorClassConfig
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigElementAccess().getActorClassConfigParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalConfig.g:1156:6: ( ruleActorInstanceConfig )
                    {
                    // InternalConfig.g:1156:6: ( ruleActorInstanceConfig )
                    // InternalConfig.g:1157:1: ruleActorInstanceConfig
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigElementAccess().getActorInstanceConfigParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalConfig.g:1162:6: ( ruleProtocolClassConfig )
                    {
                    // InternalConfig.g:1162:6: ( ruleProtocolClassConfig )
                    // InternalConfig.g:1163:1: ruleProtocolClassConfig
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigElementAccess().getProtocolClassConfigParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1173:1: rule__DynamicConfig__Alternatives_2_0 : ( ( ( rule__DynamicConfig__Group_2_0_0__0 ) ) | ( ( rule__DynamicConfig__Group_2_0_1__0 ) ) );
    public final void rule__DynamicConfig__Alternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1177:1: ( ( ( rule__DynamicConfig__Group_2_0_0__0 ) ) | ( ( rule__DynamicConfig__Group_2_0_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==32) ) {
                alt2=1;
            }
            else if ( (LA2_0==33) ) {
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
                    // InternalConfig.g:1178:1: ( ( rule__DynamicConfig__Group_2_0_0__0 ) )
                    {
                    // InternalConfig.g:1178:1: ( ( rule__DynamicConfig__Group_2_0_0__0 ) )
                    // InternalConfig.g:1179:1: ( rule__DynamicConfig__Group_2_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_0()); 
                    }
                    // InternalConfig.g:1180:1: ( rule__DynamicConfig__Group_2_0_0__0 )
                    // InternalConfig.g:1180:2: rule__DynamicConfig__Group_2_0_0__0
                    {
                    pushFollow(FOLLOW_2);
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
                    // InternalConfig.g:1184:6: ( ( rule__DynamicConfig__Group_2_0_1__0 ) )
                    {
                    // InternalConfig.g:1184:6: ( ( rule__DynamicConfig__Group_2_0_1__0 ) )
                    // InternalConfig.g:1185:1: ( rule__DynamicConfig__Group_2_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1()); 
                    }
                    // InternalConfig.g:1186:1: ( rule__DynamicConfig__Group_2_0_1__0 )
                    // InternalConfig.g:1186:2: rule__DynamicConfig__Group_2_0_1__0
                    {
                    pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__ProtocolClassConfig__Alternatives_3_1_0"
    // InternalConfig.g:1195:1: rule__ProtocolClassConfig__Alternatives_3_1_0 : ( ( 'conjugate' ) | ( 'conjugated' ) );
    public final void rule__ProtocolClassConfig__Alternatives_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1199:1: ( ( 'conjugate' ) | ( 'conjugated' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
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
                    // InternalConfig.g:1200:1: ( 'conjugate' )
                    {
                    // InternalConfig.g:1200:1: ( 'conjugate' )
                    // InternalConfig.g:1201:1: 'conjugate'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProtocolClassConfigAccess().getConjugateKeyword_3_1_0_0()); 
                    }
                    match(input,13,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getProtocolClassConfigAccess().getConjugateKeyword_3_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1208:6: ( 'conjugated' )
                    {
                    // InternalConfig.g:1208:6: ( 'conjugated' )
                    // InternalConfig.g:1209:1: 'conjugated'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProtocolClassConfigAccess().getConjugatedKeyword_3_1_0_1()); 
                    }
                    match(input,14,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getProtocolClassConfigAccess().getConjugatedKeyword_3_1_0_1()); 
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
    // $ANTLR end "rule__ProtocolClassConfig__Alternatives_3_1_0"


    // $ANTLR start "rule__AttrInstanceConfig__Alternatives_3_1_0_1"
    // InternalConfig.g:1222:1: rule__AttrInstanceConfig__Alternatives_3_1_0_1 : ( ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) ) | ( 'write' ) );
    public final void rule__AttrInstanceConfig__Alternatives_3_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1226:1: ( ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) ) | ( 'write' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==60) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
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
                    // InternalConfig.g:1227:1: ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) )
                    {
                    // InternalConfig.g:1227:1: ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) )
                    // InternalConfig.g:1228:1: ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyAssignment_3_1_0_1_0()); 
                    }
                    // InternalConfig.g:1229:1: ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 )
                    // InternalConfig.g:1229:2: rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0
                    {
                    pushFollow(FOLLOW_2);
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
                    // InternalConfig.g:1233:6: ( 'write' )
                    {
                    // InternalConfig.g:1233:6: ( 'write' )
                    // InternalConfig.g:1234:1: 'write'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttrInstanceConfigAccess().getWriteKeyword_3_1_0_1_1()); 
                    }
                    match(input,15,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__ConfigValue__Alternatives"
    // InternalConfig.g:1246:1: rule__ConfigValue__Alternatives : ( ( ruleLiteralConfigValue ) | ( ruleEnumConfigValue ) );
    public final void rule__ConfigValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1250:1: ( ( ruleLiteralConfigValue ) | ( ruleEnumConfigValue ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_HEX && LA5_0<=RULE_STRING)||(LA5_0>=17 && LA5_0<=19)||LA5_0==62) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
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
                    // InternalConfig.g:1251:1: ( ruleLiteralConfigValue )
                    {
                    // InternalConfig.g:1251:1: ( ruleLiteralConfigValue )
                    // InternalConfig.g:1252:1: ruleLiteralConfigValue
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigValueAccess().getLiteralConfigValueParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLiteralConfigValue();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConfigValueAccess().getLiteralConfigValueParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1257:6: ( ruleEnumConfigValue )
                    {
                    // InternalConfig.g:1257:6: ( ruleEnumConfigValue )
                    // InternalConfig.g:1258:1: ruleEnumConfigValue
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConfigValueAccess().getEnumConfigValueParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleEnumConfigValue();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConfigValueAccess().getEnumConfigValueParserRuleCall_1()); 
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
    // $ANTLR end "rule__ConfigValue__Alternatives"


    // $ANTLR start "rule__AnnotationAttribute__Alternatives"
    // InternalConfig.g:1269:1: rule__AnnotationAttribute__Alternatives : ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) );
    public final void rule__AnnotationAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1273:1: ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==61) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==49) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==RULE_ID) ) {
                        int LA6_4 = input.LA(4);

                        if ( (LA6_4==48) ) {
                            int LA6_5 = input.LA(5);

                            if ( ((LA6_5>=22 && LA6_5<=25)) ) {
                                alt6=1;
                            }
                            else if ( (LA6_5==27) ) {
                                alt6=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA6_0==16) ) {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==49) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==RULE_ID) ) {
                        int LA6_4 = input.LA(4);

                        if ( (LA6_4==48) ) {
                            int LA6_5 = input.LA(5);

                            if ( ((LA6_5>=22 && LA6_5<=25)) ) {
                                alt6=1;
                            }
                            else if ( (LA6_5==27) ) {
                                alt6=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalConfig.g:1274:1: ( ruleSimpleAnnotationAttribute )
                    {
                    // InternalConfig.g:1274:1: ( ruleSimpleAnnotationAttribute )
                    // InternalConfig.g:1275:1: ruleSimpleAnnotationAttribute
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleSimpleAnnotationAttribute();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1280:6: ( ruleEnumAnnotationAttribute )
                    {
                    // InternalConfig.g:1280:6: ( ruleEnumAnnotationAttribute )
                    // InternalConfig.g:1281:1: ruleEnumAnnotationAttribute
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleEnumAnnotationAttribute();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
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
    // $ANTLR end "rule__AnnotationAttribute__Alternatives"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Alternatives_0"
    // InternalConfig.g:1291:1: rule__SimpleAnnotationAttribute__Alternatives_0 : ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__SimpleAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1295:1: ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==61) ) {
                alt7=1;
            }
            else if ( (LA7_0==16) ) {
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
                    // InternalConfig.g:1296:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // InternalConfig.g:1296:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // InternalConfig.g:1297:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    }
                    // InternalConfig.g:1298:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    // InternalConfig.g:1298:2: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1302:6: ( 'mandatory' )
                    {
                    // InternalConfig.g:1302:6: ( 'mandatory' )
                    // InternalConfig.g:1303:1: 'mandatory'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    }
                    match(input,16,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
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
    // $ANTLR end "rule__SimpleAnnotationAttribute__Alternatives_0"


    // $ANTLR start "rule__EnumAnnotationAttribute__Alternatives_0"
    // InternalConfig.g:1315:1: rule__EnumAnnotationAttribute__Alternatives_0 : ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__EnumAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1319:1: ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==61) ) {
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
                    // InternalConfig.g:1320:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // InternalConfig.g:1320:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // InternalConfig.g:1321:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    }
                    // InternalConfig.g:1322:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    // InternalConfig.g:1322:2: rule__EnumAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EnumAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1326:6: ( 'mandatory' )
                    {
                    // InternalConfig.g:1326:6: ( 'mandatory' )
                    // InternalConfig.g:1327:1: 'mandatory'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    }
                    match(input,16,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
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
    // $ANTLR end "rule__EnumAnnotationAttribute__Alternatives_0"


    // $ANTLR start "rule__Import__Alternatives_1"
    // InternalConfig.g:1339:1: rule__Import__Alternatives_1 : ( ( ( rule__Import__Group_1_0__0 ) ) | ( ( rule__Import__Group_1_1__0 ) ) );
    public final void rule__Import__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1343:1: ( ( ( rule__Import__Group_1_0__0 ) ) | ( ( rule__Import__Group_1_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==52) ) {
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
                    // InternalConfig.g:1344:1: ( ( rule__Import__Group_1_0__0 ) )
                    {
                    // InternalConfig.g:1344:1: ( ( rule__Import__Group_1_0__0 ) )
                    // InternalConfig.g:1345:1: ( rule__Import__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getImportAccess().getGroup_1_0()); 
                    }
                    // InternalConfig.g:1346:1: ( rule__Import__Group_1_0__0 )
                    // InternalConfig.g:1346:2: rule__Import__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
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
                    // InternalConfig.g:1350:6: ( ( rule__Import__Group_1_1__0 ) )
                    {
                    // InternalConfig.g:1350:6: ( ( rule__Import__Group_1_1__0 ) )
                    // InternalConfig.g:1351:1: ( rule__Import__Group_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getImportAccess().getGroup_1_1()); 
                    }
                    // InternalConfig.g:1352:1: ( rule__Import__Group_1_1__0 )
                    // InternalConfig.g:1352:2: rule__Import__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Import__Group_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getImportAccess().getGroup_1_1()); 
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


    // $ANTLR start "rule__TIME__Alternatives"
    // InternalConfig.g:1361:1: rule__TIME__Alternatives : ( ( ( rule__TIME__Group_0__0 ) ) | ( ( rule__TIME__Group_1__0 ) ) | ( ( rule__TIME__Group_2__0 ) ) | ( ( rule__TIME__Group_3__0 ) ) );
    public final void rule__TIME__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1365:1: ( ( ( rule__TIME__Group_0__0 ) ) | ( ( rule__TIME__Group_1__0 ) ) | ( ( rule__TIME__Group_2__0 ) ) | ( ( rule__TIME__Group_3__0 ) ) )
            int alt10=4;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_INT) ) {
                switch ( input.LA(2) ) {
                case 57:
                    {
                    alt10=2;
                    }
                    break;
                case 59:
                    {
                    alt10=4;
                    }
                    break;
                case 56:
                    {
                    alt10=1;
                    }
                    break;
                case 58:
                    {
                    alt10=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalConfig.g:1366:1: ( ( rule__TIME__Group_0__0 ) )
                    {
                    // InternalConfig.g:1366:1: ( ( rule__TIME__Group_0__0 ) )
                    // InternalConfig.g:1367:1: ( rule__TIME__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTIMEAccess().getGroup_0()); 
                    }
                    // InternalConfig.g:1368:1: ( rule__TIME__Group_0__0 )
                    // InternalConfig.g:1368:2: rule__TIME__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TIME__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTIMEAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1372:6: ( ( rule__TIME__Group_1__0 ) )
                    {
                    // InternalConfig.g:1372:6: ( ( rule__TIME__Group_1__0 ) )
                    // InternalConfig.g:1373:1: ( rule__TIME__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTIMEAccess().getGroup_1()); 
                    }
                    // InternalConfig.g:1374:1: ( rule__TIME__Group_1__0 )
                    // InternalConfig.g:1374:2: rule__TIME__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TIME__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTIMEAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalConfig.g:1378:6: ( ( rule__TIME__Group_2__0 ) )
                    {
                    // InternalConfig.g:1378:6: ( ( rule__TIME__Group_2__0 ) )
                    // InternalConfig.g:1379:1: ( rule__TIME__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTIMEAccess().getGroup_2()); 
                    }
                    // InternalConfig.g:1380:1: ( rule__TIME__Group_2__0 )
                    // InternalConfig.g:1380:2: rule__TIME__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TIME__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTIMEAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalConfig.g:1384:6: ( ( rule__TIME__Group_3__0 ) )
                    {
                    // InternalConfig.g:1384:6: ( ( rule__TIME__Group_3__0 ) )
                    // InternalConfig.g:1385:1: ( rule__TIME__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTIMEAccess().getGroup_3()); 
                    }
                    // InternalConfig.g:1386:1: ( rule__TIME__Group_3__0 )
                    // InternalConfig.g:1386:2: rule__TIME__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TIME__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTIMEAccess().getGroup_3()); 
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
    // $ANTLR end "rule__TIME__Alternatives"


    // $ANTLR start "rule__Literal__Alternatives"
    // InternalConfig.g:1395:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1399:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 17:
            case 62:
                {
                alt11=1;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case 18:
            case 19:
                {
                alt11=2;
                }
                break;
            case RULE_STRING:
                {
                alt11=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalConfig.g:1400:1: ( ruleBooleanLiteral )
                    {
                    // InternalConfig.g:1400:1: ( ruleBooleanLiteral )
                    // InternalConfig.g:1401:1: ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalConfig.g:1406:6: ( ruleNumberLiteral )
                    {
                    // InternalConfig.g:1406:6: ( ruleNumberLiteral )
                    // InternalConfig.g:1407:1: ruleNumberLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalConfig.g:1412:6: ( ruleStringLiteral )
                    {
                    // InternalConfig.g:1412:6: ( ruleStringLiteral )
                    // InternalConfig.g:1413:1: ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1423:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1427:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            else if ( (LA12_0==62) ) {
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
                    // InternalConfig.g:1428:1: ( 'false' )
                    {
                    // InternalConfig.g:1428:1: ( 'false' )
                    // InternalConfig.g:1429:1: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    }
                    match(input,17,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1436:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // InternalConfig.g:1436:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // InternalConfig.g:1437:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    }
                    // InternalConfig.g:1438:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // InternalConfig.g:1438:2: rule__BooleanLiteral__IsTrueAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1447:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1451:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
            int alt13=2;
            switch ( input.LA(1) ) {
            case 18:
                {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==RULE_INT) ) {
                    int LA13_3 = input.LA(3);

                    if ( (LA13_3==EOF||(LA13_3>=27 && LA13_3<=28)||(LA13_3>=41 && LA13_3<=42)||(LA13_3>=45 && LA13_3<=46)) ) {
                        alt13=1;
                    }
                    else if ( (LA13_3==47) ) {
                        alt13=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==RULE_INT) ) {
                    int LA13_3 = input.LA(3);

                    if ( (LA13_3==EOF||(LA13_3>=27 && LA13_3<=28)||(LA13_3>=41 && LA13_3<=42)||(LA13_3>=45 && LA13_3<=46)) ) {
                        alt13=1;
                    }
                    else if ( (LA13_3==47) ) {
                        alt13=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA13_3 = input.LA(2);

                if ( (LA13_3==EOF||(LA13_3>=27 && LA13_3<=28)||(LA13_3>=41 && LA13_3<=42)||(LA13_3>=45 && LA13_3<=46)) ) {
                    alt13=1;
                }
                else if ( (LA13_3==47) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt13=1;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalConfig.g:1452:1: ( ruleIntLiteral )
                    {
                    // InternalConfig.g:1452:1: ( ruleIntLiteral )
                    // InternalConfig.g:1453:1: ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalConfig.g:1458:6: ( ruleRealLiteral )
                    {
                    // InternalConfig.g:1458:6: ( ruleRealLiteral )
                    // InternalConfig.g:1459:1: ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1469:1: rule__Integer__Alternatives : ( ( ( rule__Integer__Group_0__0 ) ) | ( RULE_HEX ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1473:1: ( ( ( rule__Integer__Group_0__0 ) ) | ( RULE_HEX ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_INT||(LA14_0>=18 && LA14_0<=19)) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_HEX) ) {
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
                    // InternalConfig.g:1474:1: ( ( rule__Integer__Group_0__0 ) )
                    {
                    // InternalConfig.g:1474:1: ( ( rule__Integer__Group_0__0 ) )
                    // InternalConfig.g:1475:1: ( rule__Integer__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIntegerAccess().getGroup_0()); 
                    }
                    // InternalConfig.g:1476:1: ( rule__Integer__Group_0__0 )
                    // InternalConfig.g:1476:2: rule__Integer__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Integer__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIntegerAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1480:6: ( RULE_HEX )
                    {
                    // InternalConfig.g:1480:6: ( RULE_HEX )
                    // InternalConfig.g:1481:1: RULE_HEX
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIntegerAccess().getHEXTerminalRuleCall_1()); 
                    }
                    match(input,RULE_HEX,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIntegerAccess().getHEXTerminalRuleCall_1()); 
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


    // $ANTLR start "rule__Integer__Alternatives_0_0"
    // InternalConfig.g:1491:1: rule__Integer__Alternatives_0_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Integer__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1495:1: ( ( '+' ) | ( '-' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            else if ( (LA15_0==19) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalConfig.g:1496:1: ( '+' )
                    {
                    // InternalConfig.g:1496:1: ( '+' )
                    // InternalConfig.g:1497:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 
                    }
                    match(input,18,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1504:6: ( '-' )
                    {
                    // InternalConfig.g:1504:6: ( '-' )
                    // InternalConfig.g:1505:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIntegerAccess().getHyphenMinusKeyword_0_0_1()); 
                    }
                    match(input,19,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIntegerAccess().getHyphenMinusKeyword_0_0_1()); 
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
    // $ANTLR end "rule__Integer__Alternatives_0_0"


    // $ANTLR start "rule__Real__Alternatives"
    // InternalConfig.g:1517:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1521:1: ( ( ruleDecimal ) | ( ruleDecimalExp ) )
            int alt16=2;
            switch ( input.LA(1) ) {
            case 18:
                {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==RULE_INT) ) {
                    int LA16_3 = input.LA(3);

                    if ( (LA16_3==47) ) {
                        int LA16_4 = input.LA(4);

                        if ( (LA16_4==RULE_INT) ) {
                            int LA16_5 = input.LA(5);

                            if ( ((LA16_5>=20 && LA16_5<=21)) ) {
                                alt16=2;
                            }
                            else if ( (LA16_5==EOF||(LA16_5>=27 && LA16_5<=28)||(LA16_5>=41 && LA16_5<=42)||(LA16_5>=45 && LA16_5<=46)) ) {
                                alt16=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 16, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 16, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA16_2 = input.LA(2);

                if ( (LA16_2==RULE_INT) ) {
                    int LA16_3 = input.LA(3);

                    if ( (LA16_3==47) ) {
                        int LA16_4 = input.LA(4);

                        if ( (LA16_4==RULE_INT) ) {
                            int LA16_5 = input.LA(5);

                            if ( ((LA16_5>=20 && LA16_5<=21)) ) {
                                alt16=2;
                            }
                            else if ( (LA16_5==EOF||(LA16_5>=27 && LA16_5<=28)||(LA16_5>=41 && LA16_5<=42)||(LA16_5>=45 && LA16_5<=46)) ) {
                                alt16=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 16, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 16, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA16_3 = input.LA(2);

                if ( (LA16_3==47) ) {
                    int LA16_4 = input.LA(3);

                    if ( (LA16_4==RULE_INT) ) {
                        int LA16_5 = input.LA(4);

                        if ( ((LA16_5>=20 && LA16_5<=21)) ) {
                            alt16=2;
                        }
                        else if ( (LA16_5==EOF||(LA16_5>=27 && LA16_5<=28)||(LA16_5>=41 && LA16_5<=42)||(LA16_5>=45 && LA16_5<=46)) ) {
                            alt16=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 16, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalConfig.g:1522:1: ( ruleDecimal )
                    {
                    // InternalConfig.g:1522:1: ( ruleDecimal )
                    // InternalConfig.g:1523:1: ruleDecimal
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalConfig.g:1528:6: ( ruleDecimalExp )
                    {
                    // InternalConfig.g:1528:6: ( ruleDecimalExp )
                    // InternalConfig.g:1529:1: ruleDecimalExp
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleDecimalExp();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_1()); 
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
    // InternalConfig.g:1539:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1543:1: ( ( '+' ) | ( '-' ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==18) ) {
                alt17=1;
            }
            else if ( (LA17_0==19) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalConfig.g:1544:1: ( '+' )
                    {
                    // InternalConfig.g:1544:1: ( '+' )
                    // InternalConfig.g:1545:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,18,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1552:6: ( '-' )
                    {
                    // InternalConfig.g:1552:6: ( '-' )
                    // InternalConfig.g:1553:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,19,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__DecimalExp__Alternatives_0"
    // InternalConfig.g:1565:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1569:1: ( ( '+' ) | ( '-' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==18) ) {
                alt18=1;
            }
            else if ( (LA18_0==19) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalConfig.g:1570:1: ( '+' )
                    {
                    // InternalConfig.g:1570:1: ( '+' )
                    // InternalConfig.g:1571:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,18,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1578:6: ( '-' )
                    {
                    // InternalConfig.g:1578:6: ( '-' )
                    // InternalConfig.g:1579:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,19,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__DecimalExp__Alternatives_4"
    // InternalConfig.g:1591:1: rule__DecimalExp__Alternatives_4 : ( ( 'e' ) | ( 'E' ) );
    public final void rule__DecimalExp__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1595:1: ( ( 'e' ) | ( 'E' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==20) ) {
                alt19=1;
            }
            else if ( (LA19_0==21) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalConfig.g:1596:1: ( 'e' )
                    {
                    // InternalConfig.g:1596:1: ( 'e' )
                    // InternalConfig.g:1597:1: 'e'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 
                    }
                    match(input,20,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1604:6: ( 'E' )
                    {
                    // InternalConfig.g:1604:6: ( 'E' )
                    // InternalConfig.g:1605:1: 'E'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalExpAccess().getEKeyword_4_1()); 
                    }
                    match(input,21,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalExpAccess().getEKeyword_4_1()); 
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
    // $ANTLR end "rule__DecimalExp__Alternatives_4"


    // $ANTLR start "rule__DecimalExp__Alternatives_5"
    // InternalConfig.g:1617:1: rule__DecimalExp__Alternatives_5 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1621:1: ( ( '+' ) | ( '-' ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==18) ) {
                alt20=1;
            }
            else if ( (LA20_0==19) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalConfig.g:1622:1: ( '+' )
                    {
                    // InternalConfig.g:1622:1: ( '+' )
                    // InternalConfig.g:1623:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                    }
                    match(input,18,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1630:6: ( '-' )
                    {
                    // InternalConfig.g:1630:6: ( '-' )
                    // InternalConfig.g:1631:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_5_1()); 
                    }
                    match(input,19,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__LiteralType__Alternatives"
    // InternalConfig.g:1643:1: rule__LiteralType__Alternatives : ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) );
    public final void rule__LiteralType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1647:1: ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) )
            int alt21=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt21=1;
                }
                break;
            case 23:
                {
                alt21=2;
                }
                break;
            case 24:
                {
                alt21=3;
                }
                break;
            case 25:
                {
                alt21=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalConfig.g:1648:1: ( ( 'ptBoolean' ) )
                    {
                    // InternalConfig.g:1648:1: ( ( 'ptBoolean' ) )
                    // InternalConfig.g:1649:1: ( 'ptBoolean' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                    }
                    // InternalConfig.g:1650:1: ( 'ptBoolean' )
                    // InternalConfig.g:1650:3: 'ptBoolean'
                    {
                    match(input,22,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1655:6: ( ( 'ptInteger' ) )
                    {
                    // InternalConfig.g:1655:6: ( ( 'ptInteger' ) )
                    // InternalConfig.g:1656:1: ( 'ptInteger' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                    }
                    // InternalConfig.g:1657:1: ( 'ptInteger' )
                    // InternalConfig.g:1657:3: 'ptInteger'
                    {
                    match(input,23,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalConfig.g:1662:6: ( ( 'ptReal' ) )
                    {
                    // InternalConfig.g:1662:6: ( ( 'ptReal' ) )
                    // InternalConfig.g:1663:1: ( 'ptReal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                    }
                    // InternalConfig.g:1664:1: ( 'ptReal' )
                    // InternalConfig.g:1664:3: 'ptReal'
                    {
                    match(input,24,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalConfig.g:1669:6: ( ( 'ptCharacter' ) )
                    {
                    // InternalConfig.g:1669:6: ( ( 'ptCharacter' ) )
                    // InternalConfig.g:1670:1: ( 'ptCharacter' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 
                    }
                    // InternalConfig.g:1671:1: ( 'ptCharacter' )
                    // InternalConfig.g:1671:3: 'ptCharacter'
                    {
                    match(input,25,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 
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
    // $ANTLR end "rule__LiteralType__Alternatives"


    // $ANTLR start "rule__ConfigModel__Group__0"
    // InternalConfig.g:1683:1: rule__ConfigModel__Group__0 : rule__ConfigModel__Group__0__Impl rule__ConfigModel__Group__1 ;
    public final void rule__ConfigModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1687:1: ( rule__ConfigModel__Group__0__Impl rule__ConfigModel__Group__1 )
            // InternalConfig.g:1688:2: rule__ConfigModel__Group__0__Impl rule__ConfigModel__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ConfigModel__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1695:1: rule__ConfigModel__Group__0__Impl : ( 'ConfigModel' ) ;
    public final void rule__ConfigModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1699:1: ( ( 'ConfigModel' ) )
            // InternalConfig.g:1700:1: ( 'ConfigModel' )
            {
            // InternalConfig.g:1700:1: ( 'ConfigModel' )
            // InternalConfig.g:1701:1: 'ConfigModel'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getConfigModelKeyword_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:1714:1: rule__ConfigModel__Group__1 : rule__ConfigModel__Group__1__Impl rule__ConfigModel__Group__2 ;
    public final void rule__ConfigModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1718:1: ( rule__ConfigModel__Group__1__Impl rule__ConfigModel__Group__2 )
            // InternalConfig.g:1719:2: rule__ConfigModel__Group__1__Impl rule__ConfigModel__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__ConfigModel__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1726:1: rule__ConfigModel__Group__1__Impl : ( ( rule__ConfigModel__NameAssignment_1 ) ) ;
    public final void rule__ConfigModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1730:1: ( ( ( rule__ConfigModel__NameAssignment_1 ) ) )
            // InternalConfig.g:1731:1: ( ( rule__ConfigModel__NameAssignment_1 ) )
            {
            // InternalConfig.g:1731:1: ( ( rule__ConfigModel__NameAssignment_1 ) )
            // InternalConfig.g:1732:1: ( rule__ConfigModel__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getNameAssignment_1()); 
            }
            // InternalConfig.g:1733:1: ( rule__ConfigModel__NameAssignment_1 )
            // InternalConfig.g:1733:2: rule__ConfigModel__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1743:1: rule__ConfigModel__Group__2 : rule__ConfigModel__Group__2__Impl rule__ConfigModel__Group__3 ;
    public final void rule__ConfigModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1747:1: ( rule__ConfigModel__Group__2__Impl rule__ConfigModel__Group__3 )
            // InternalConfig.g:1748:2: rule__ConfigModel__Group__2__Impl rule__ConfigModel__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__ConfigModel__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1755:1: rule__ConfigModel__Group__2__Impl : ( '{' ) ;
    public final void rule__ConfigModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1759:1: ( ( '{' ) )
            // InternalConfig.g:1760:1: ( '{' )
            {
            // InternalConfig.g:1760:1: ( '{' )
            // InternalConfig.g:1761:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:1774:1: rule__ConfigModel__Group__3 : rule__ConfigModel__Group__3__Impl rule__ConfigModel__Group__4 ;
    public final void rule__ConfigModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1778:1: ( rule__ConfigModel__Group__3__Impl rule__ConfigModel__Group__4 )
            // InternalConfig.g:1779:2: rule__ConfigModel__Group__3__Impl rule__ConfigModel__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__ConfigModel__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1786:1: rule__ConfigModel__Group__3__Impl : ( ( rule__ConfigModel__ImportsAssignment_3 )* ) ;
    public final void rule__ConfigModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1790:1: ( ( ( rule__ConfigModel__ImportsAssignment_3 )* ) )
            // InternalConfig.g:1791:1: ( ( rule__ConfigModel__ImportsAssignment_3 )* )
            {
            // InternalConfig.g:1791:1: ( ( rule__ConfigModel__ImportsAssignment_3 )* )
            // InternalConfig.g:1792:1: ( rule__ConfigModel__ImportsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getImportsAssignment_3()); 
            }
            // InternalConfig.g:1793:1: ( rule__ConfigModel__ImportsAssignment_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==50) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalConfig.g:1793:2: rule__ConfigModel__ImportsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__ConfigModel__ImportsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalConfig.g:1803:1: rule__ConfigModel__Group__4 : rule__ConfigModel__Group__4__Impl rule__ConfigModel__Group__5 ;
    public final void rule__ConfigModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1807:1: ( rule__ConfigModel__Group__4__Impl rule__ConfigModel__Group__5 )
            // InternalConfig.g:1808:2: rule__ConfigModel__Group__4__Impl rule__ConfigModel__Group__5
            {
            pushFollow(FOLLOW_5);
            rule__ConfigModel__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1815:1: rule__ConfigModel__Group__4__Impl : ( ( rule__ConfigModel__ConfigElementsAssignment_4 )* ) ;
    public final void rule__ConfigModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1819:1: ( ( ( rule__ConfigModel__ConfigElementsAssignment_4 )* ) )
            // InternalConfig.g:1820:1: ( ( rule__ConfigModel__ConfigElementsAssignment_4 )* )
            {
            // InternalConfig.g:1820:1: ( ( rule__ConfigModel__ConfigElementsAssignment_4 )* )
            // InternalConfig.g:1821:1: ( rule__ConfigModel__ConfigElementsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getConfigElementsAssignment_4()); 
            }
            // InternalConfig.g:1822:1: ( rule__ConfigModel__ConfigElementsAssignment_4 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==29||(LA23_0>=36 && LA23_0<=38)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalConfig.g:1822:2: rule__ConfigModel__ConfigElementsAssignment_4
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__ConfigModel__ConfigElementsAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalConfig.g:1832:1: rule__ConfigModel__Group__5 : rule__ConfigModel__Group__5__Impl ;
    public final void rule__ConfigModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1836:1: ( rule__ConfigModel__Group__5__Impl )
            // InternalConfig.g:1837:2: rule__ConfigModel__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1843:1: rule__ConfigModel__Group__5__Impl : ( '}' ) ;
    public final void rule__ConfigModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1847:1: ( ( '}' ) )
            // InternalConfig.g:1848:1: ( '}' )
            {
            // InternalConfig.g:1848:1: ( '}' )
            // InternalConfig.g:1849:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:1874:1: rule__SubSystemConfig__Group__0 : rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1 ;
    public final void rule__SubSystemConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1878:1: ( rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1 )
            // InternalConfig.g:1879:2: rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__SubSystemConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1886:1: rule__SubSystemConfig__Group__0__Impl : ( 'SubSystemConfig' ) ;
    public final void rule__SubSystemConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1890:1: ( ( 'SubSystemConfig' ) )
            // InternalConfig.g:1891:1: ( 'SubSystemConfig' )
            {
            // InternalConfig.g:1891:1: ( 'SubSystemConfig' )
            // InternalConfig.g:1892:1: 'SubSystemConfig'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemConfigKeyword_0()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:1905:1: rule__SubSystemConfig__Group__1 : rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2 ;
    public final void rule__SubSystemConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1909:1: ( rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2 )
            // InternalConfig.g:1910:2: rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__SubSystemConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1917:1: rule__SubSystemConfig__Group__1__Impl : ( ( rule__SubSystemConfig__RootAssignment_1 ) ) ;
    public final void rule__SubSystemConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1921:1: ( ( ( rule__SubSystemConfig__RootAssignment_1 ) ) )
            // InternalConfig.g:1922:1: ( ( rule__SubSystemConfig__RootAssignment_1 ) )
            {
            // InternalConfig.g:1922:1: ( ( rule__SubSystemConfig__RootAssignment_1 ) )
            // InternalConfig.g:1923:1: ( rule__SubSystemConfig__RootAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getRootAssignment_1()); 
            }
            // InternalConfig.g:1924:1: ( rule__SubSystemConfig__RootAssignment_1 )
            // InternalConfig.g:1924:2: rule__SubSystemConfig__RootAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SubSystemConfig__RootAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getRootAssignment_1()); 
            }

            }


            }

        }
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
    // InternalConfig.g:1934:1: rule__SubSystemConfig__Group__2 : rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3 ;
    public final void rule__SubSystemConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1938:1: ( rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3 )
            // InternalConfig.g:1939:2: rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__SubSystemConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1946:1: rule__SubSystemConfig__Group__2__Impl : ( '/' ) ;
    public final void rule__SubSystemConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1950:1: ( ( '/' ) )
            // InternalConfig.g:1951:1: ( '/' )
            {
            // InternalConfig.g:1951:1: ( '/' )
            // InternalConfig.g:1952:1: '/'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSolidusKeyword_2()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getSolidusKeyword_2()); 
            }

            }


            }

        }
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
    // InternalConfig.g:1965:1: rule__SubSystemConfig__Group__3 : rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4 ;
    public final void rule__SubSystemConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1969:1: ( rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4 )
            // InternalConfig.g:1970:2: rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__SubSystemConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1977:1: rule__SubSystemConfig__Group__3__Impl : ( ( rule__SubSystemConfig__SubSystemAssignment_3 ) ) ;
    public final void rule__SubSystemConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1981:1: ( ( ( rule__SubSystemConfig__SubSystemAssignment_3 ) ) )
            // InternalConfig.g:1982:1: ( ( rule__SubSystemConfig__SubSystemAssignment_3 ) )
            {
            // InternalConfig.g:1982:1: ( ( rule__SubSystemConfig__SubSystemAssignment_3 ) )
            // InternalConfig.g:1983:1: ( rule__SubSystemConfig__SubSystemAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemAssignment_3()); 
            }
            // InternalConfig.g:1984:1: ( rule__SubSystemConfig__SubSystemAssignment_3 )
            // InternalConfig.g:1984:2: rule__SubSystemConfig__SubSystemAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__SubSystemConfig__SubSystemAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getSubSystemAssignment_3()); 
            }

            }


            }

        }
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
    // InternalConfig.g:1994:1: rule__SubSystemConfig__Group__4 : rule__SubSystemConfig__Group__4__Impl rule__SubSystemConfig__Group__5 ;
    public final void rule__SubSystemConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:1998:1: ( rule__SubSystemConfig__Group__4__Impl rule__SubSystemConfig__Group__5 )
            // InternalConfig.g:1999:2: rule__SubSystemConfig__Group__4__Impl rule__SubSystemConfig__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__SubSystemConfig__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SubSystemConfig__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:2006:1: rule__SubSystemConfig__Group__4__Impl : ( '{' ) ;
    public final void rule__SubSystemConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2010:1: ( ( '{' ) )
            // InternalConfig.g:2011:1: ( '{' )
            {
            // InternalConfig.g:2011:1: ( '{' )
            // InternalConfig.g:2012:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getLeftCurlyBracketKeyword_4()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__SubSystemConfig__Group__5"
    // InternalConfig.g:2025:1: rule__SubSystemConfig__Group__5 : rule__SubSystemConfig__Group__5__Impl rule__SubSystemConfig__Group__6 ;
    public final void rule__SubSystemConfig__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2029:1: ( rule__SubSystemConfig__Group__5__Impl rule__SubSystemConfig__Group__6 )
            // InternalConfig.g:2030:2: rule__SubSystemConfig__Group__5__Impl rule__SubSystemConfig__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__SubSystemConfig__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SubSystemConfig__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemConfig__Group__5"


    // $ANTLR start "rule__SubSystemConfig__Group__5__Impl"
    // InternalConfig.g:2037:1: rule__SubSystemConfig__Group__5__Impl : ( ( rule__SubSystemConfig__DynConfigAssignment_5 ) ) ;
    public final void rule__SubSystemConfig__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2041:1: ( ( ( rule__SubSystemConfig__DynConfigAssignment_5 ) ) )
            // InternalConfig.g:2042:1: ( ( rule__SubSystemConfig__DynConfigAssignment_5 ) )
            {
            // InternalConfig.g:2042:1: ( ( rule__SubSystemConfig__DynConfigAssignment_5 ) )
            // InternalConfig.g:2043:1: ( rule__SubSystemConfig__DynConfigAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getDynConfigAssignment_5()); 
            }
            // InternalConfig.g:2044:1: ( rule__SubSystemConfig__DynConfigAssignment_5 )
            // InternalConfig.g:2044:2: rule__SubSystemConfig__DynConfigAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__SubSystemConfig__DynConfigAssignment_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getDynConfigAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemConfig__Group__5__Impl"


    // $ANTLR start "rule__SubSystemConfig__Group__6"
    // InternalConfig.g:2054:1: rule__SubSystemConfig__Group__6 : rule__SubSystemConfig__Group__6__Impl ;
    public final void rule__SubSystemConfig__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2058:1: ( rule__SubSystemConfig__Group__6__Impl )
            // InternalConfig.g:2059:2: rule__SubSystemConfig__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SubSystemConfig__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemConfig__Group__6"


    // $ANTLR start "rule__SubSystemConfig__Group__6__Impl"
    // InternalConfig.g:2065:1: rule__SubSystemConfig__Group__6__Impl : ( '}' ) ;
    public final void rule__SubSystemConfig__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2069:1: ( ( '}' ) )
            // InternalConfig.g:2070:1: ( '}' )
            {
            // InternalConfig.g:2070:1: ( '}' )
            // InternalConfig.g:2071:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getRightCurlyBracketKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemConfig__Group__6__Impl"


    // $ANTLR start "rule__DynamicConfig__Group__0"
    // InternalConfig.g:2098:1: rule__DynamicConfig__Group__0 : rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1 ;
    public final void rule__DynamicConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2102:1: ( rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1 )
            // InternalConfig.g:2103:2: rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__DynamicConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2110:1: rule__DynamicConfig__Group__0__Impl : ( 'dynamic configuration' ) ;
    public final void rule__DynamicConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2114:1: ( ( 'dynamic configuration' ) )
            // InternalConfig.g:2115:1: ( 'dynamic configuration' )
            {
            // InternalConfig.g:2115:1: ( 'dynamic configuration' )
            // InternalConfig.g:2116:1: 'dynamic configuration'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getDynamicConfigurationKeyword_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2129:1: rule__DynamicConfig__Group__1 : rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2 ;
    public final void rule__DynamicConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2133:1: ( rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2 )
            // InternalConfig.g:2134:2: rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__DynamicConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2141:1: rule__DynamicConfig__Group__1__Impl : ( '{' ) ;
    public final void rule__DynamicConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2145:1: ( ( '{' ) )
            // InternalConfig.g:2146:1: ( '{' )
            {
            // InternalConfig.g:2146:1: ( '{' )
            // InternalConfig.g:2147:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2160:1: rule__DynamicConfig__Group__2 : rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3 ;
    public final void rule__DynamicConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2164:1: ( rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3 )
            // InternalConfig.g:2165:2: rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__DynamicConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2172:1: rule__DynamicConfig__Group__2__Impl : ( ( rule__DynamicConfig__UnorderedGroup_2 ) ) ;
    public final void rule__DynamicConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2176:1: ( ( ( rule__DynamicConfig__UnorderedGroup_2 ) ) )
            // InternalConfig.g:2177:1: ( ( rule__DynamicConfig__UnorderedGroup_2 ) )
            {
            // InternalConfig.g:2177:1: ( ( rule__DynamicConfig__UnorderedGroup_2 ) )
            // InternalConfig.g:2178:1: ( rule__DynamicConfig__UnorderedGroup_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2()); 
            }
            // InternalConfig.g:2179:1: ( rule__DynamicConfig__UnorderedGroup_2 )
            // InternalConfig.g:2179:2: rule__DynamicConfig__UnorderedGroup_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2189:1: rule__DynamicConfig__Group__3 : rule__DynamicConfig__Group__3__Impl ;
    public final void rule__DynamicConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2193:1: ( rule__DynamicConfig__Group__3__Impl )
            // InternalConfig.g:2194:2: rule__DynamicConfig__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2200:1: rule__DynamicConfig__Group__3__Impl : ( '}' ) ;
    public final void rule__DynamicConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2204:1: ( ( '}' ) )
            // InternalConfig.g:2205:1: ( '}' )
            {
            // InternalConfig.g:2205:1: ( '}' )
            // InternalConfig.g:2206:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2227:1: rule__DynamicConfig__Group_2_0_0__0 : rule__DynamicConfig__Group_2_0_0__0__Impl rule__DynamicConfig__Group_2_0_0__1 ;
    public final void rule__DynamicConfig__Group_2_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2231:1: ( rule__DynamicConfig__Group_2_0_0__0__Impl rule__DynamicConfig__Group_2_0_0__1 )
            // InternalConfig.g:2232:2: rule__DynamicConfig__Group_2_0_0__0__Impl rule__DynamicConfig__Group_2_0_0__1
            {
            pushFollow(FOLLOW_12);
            rule__DynamicConfig__Group_2_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2239:1: rule__DynamicConfig__Group_2_0_0__0__Impl : ( 'file path' ) ;
    public final void rule__DynamicConfig__Group_2_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2243:1: ( ( 'file path' ) )
            // InternalConfig.g:2244:1: ( 'file path' )
            {
            // InternalConfig.g:2244:1: ( 'file path' )
            // InternalConfig.g:2245:1: 'file path'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getFilePathKeyword_2_0_0_0()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2258:1: rule__DynamicConfig__Group_2_0_0__1 : rule__DynamicConfig__Group_2_0_0__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2262:1: ( rule__DynamicConfig__Group_2_0_0__1__Impl )
            // InternalConfig.g:2263:2: rule__DynamicConfig__Group_2_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2269:1: rule__DynamicConfig__Group_2_0_0__1__Impl : ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2273:1: ( ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) ) )
            // InternalConfig.g:2274:1: ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) )
            {
            // InternalConfig.g:2274:1: ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) )
            // InternalConfig.g:2275:1: ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getFilePathAssignment_2_0_0_1()); 
            }
            // InternalConfig.g:2276:1: ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 )
            // InternalConfig.g:2276:2: rule__DynamicConfig__FilePathAssignment_2_0_0_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2290:1: rule__DynamicConfig__Group_2_0_1__0 : rule__DynamicConfig__Group_2_0_1__0__Impl rule__DynamicConfig__Group_2_0_1__1 ;
    public final void rule__DynamicConfig__Group_2_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2294:1: ( rule__DynamicConfig__Group_2_0_1__0__Impl rule__DynamicConfig__Group_2_0_1__1 )
            // InternalConfig.g:2295:2: rule__DynamicConfig__Group_2_0_1__0__Impl rule__DynamicConfig__Group_2_0_1__1
            {
            pushFollow(FOLLOW_13);
            rule__DynamicConfig__Group_2_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2302:1: rule__DynamicConfig__Group_2_0_1__0__Impl : ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2306:1: ( ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) ) )
            // InternalConfig.g:2307:1: ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) )
            {
            // InternalConfig.g:2307:1: ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) )
            // InternalConfig.g:2308:1: ( rule__DynamicConfig__Group_2_0_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_0()); 
            }
            // InternalConfig.g:2309:1: ( rule__DynamicConfig__Group_2_0_1_0__0 )
            // InternalConfig.g:2309:2: rule__DynamicConfig__Group_2_0_1_0__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2319:1: rule__DynamicConfig__Group_2_0_1__1 : rule__DynamicConfig__Group_2_0_1__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2323:1: ( rule__DynamicConfig__Group_2_0_1__1__Impl )
            // InternalConfig.g:2324:2: rule__DynamicConfig__Group_2_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2330:1: rule__DynamicConfig__Group_2_0_1__1__Impl : ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2334:1: ( ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) ) )
            // InternalConfig.g:2335:1: ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) )
            {
            // InternalConfig.g:2335:1: ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) )
            // InternalConfig.g:2336:1: ( rule__DynamicConfig__Group_2_0_1_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_1()); 
            }
            // InternalConfig.g:2337:1: ( rule__DynamicConfig__Group_2_0_1_1__0 )
            // InternalConfig.g:2337:2: rule__DynamicConfig__Group_2_0_1_1__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2351:1: rule__DynamicConfig__Group_2_0_1_0__0 : rule__DynamicConfig__Group_2_0_1_0__0__Impl rule__DynamicConfig__Group_2_0_1_0__1 ;
    public final void rule__DynamicConfig__Group_2_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2355:1: ( rule__DynamicConfig__Group_2_0_1_0__0__Impl rule__DynamicConfig__Group_2_0_1_0__1 )
            // InternalConfig.g:2356:2: rule__DynamicConfig__Group_2_0_1_0__0__Impl rule__DynamicConfig__Group_2_0_1_0__1
            {
            pushFollow(FOLLOW_12);
            rule__DynamicConfig__Group_2_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2363:1: rule__DynamicConfig__Group_2_0_1_0__0__Impl : ( 'user import' ) ;
    public final void rule__DynamicConfig__Group_2_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2367:1: ( ( 'user import' ) )
            // InternalConfig.g:2368:1: ( 'user import' )
            {
            // InternalConfig.g:2368:1: ( 'user import' )
            // InternalConfig.g:2369:1: 'user import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserImportKeyword_2_0_1_0_0()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2382:1: rule__DynamicConfig__Group_2_0_1_0__1 : rule__DynamicConfig__Group_2_0_1_0__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2386:1: ( rule__DynamicConfig__Group_2_0_1_0__1__Impl )
            // InternalConfig.g:2387:2: rule__DynamicConfig__Group_2_0_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2393:1: rule__DynamicConfig__Group_2_0_1_0__1__Impl : ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2397:1: ( ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) ) )
            // InternalConfig.g:2398:1: ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) )
            {
            // InternalConfig.g:2398:1: ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) )
            // InternalConfig.g:2399:1: ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserCode1Assignment_2_0_1_0_1()); 
            }
            // InternalConfig.g:2400:1: ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 )
            // InternalConfig.g:2400:2: rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2414:1: rule__DynamicConfig__Group_2_0_1_1__0 : rule__DynamicConfig__Group_2_0_1_1__0__Impl rule__DynamicConfig__Group_2_0_1_1__1 ;
    public final void rule__DynamicConfig__Group_2_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2418:1: ( rule__DynamicConfig__Group_2_0_1_1__0__Impl rule__DynamicConfig__Group_2_0_1_1__1 )
            // InternalConfig.g:2419:2: rule__DynamicConfig__Group_2_0_1_1__0__Impl rule__DynamicConfig__Group_2_0_1_1__1
            {
            pushFollow(FOLLOW_12);
            rule__DynamicConfig__Group_2_0_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2426:1: rule__DynamicConfig__Group_2_0_1_1__0__Impl : ( 'user constructor' ) ;
    public final void rule__DynamicConfig__Group_2_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2430:1: ( ( 'user constructor' ) )
            // InternalConfig.g:2431:1: ( 'user constructor' )
            {
            // InternalConfig.g:2431:1: ( 'user constructor' )
            // InternalConfig.g:2432:1: 'user constructor'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserConstructorKeyword_2_0_1_1_0()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2445:1: rule__DynamicConfig__Group_2_0_1_1__1 : rule__DynamicConfig__Group_2_0_1_1__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2449:1: ( rule__DynamicConfig__Group_2_0_1_1__1__Impl )
            // InternalConfig.g:2450:2: rule__DynamicConfig__Group_2_0_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2456:1: rule__DynamicConfig__Group_2_0_1_1__1__Impl : ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2460:1: ( ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) ) )
            // InternalConfig.g:2461:1: ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) )
            {
            // InternalConfig.g:2461:1: ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) )
            // InternalConfig.g:2462:1: ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserCode2Assignment_2_0_1_1_1()); 
            }
            // InternalConfig.g:2463:1: ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 )
            // InternalConfig.g:2463:2: rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2477:1: rule__DynamicConfig__Group_2_1__0 : rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1 ;
    public final void rule__DynamicConfig__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2481:1: ( rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1 )
            // InternalConfig.g:2482:2: rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1
            {
            pushFollow(FOLLOW_14);
            rule__DynamicConfig__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2489:1: rule__DynamicConfig__Group_2_1__0__Impl : ( 'polling interval' ) ;
    public final void rule__DynamicConfig__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2493:1: ( ( 'polling interval' ) )
            // InternalConfig.g:2494:1: ( 'polling interval' )
            {
            // InternalConfig.g:2494:1: ( 'polling interval' )
            // InternalConfig.g:2495:1: 'polling interval'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getPollingIntervalKeyword_2_1_0()); 
            }
            match(input,35,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getPollingIntervalKeyword_2_1_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:2508:1: rule__DynamicConfig__Group_2_1__1 : rule__DynamicConfig__Group_2_1__1__Impl ;
    public final void rule__DynamicConfig__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2512:1: ( rule__DynamicConfig__Group_2_1__1__Impl )
            // InternalConfig.g:2513:2: rule__DynamicConfig__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2519:1: rule__DynamicConfig__Group_2_1__1__Impl : ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2523:1: ( ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) ) )
            // InternalConfig.g:2524:1: ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) )
            {
            // InternalConfig.g:2524:1: ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) )
            // InternalConfig.g:2525:1: ( rule__DynamicConfig__PollingAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getPollingAssignment_2_1_1()); 
            }
            // InternalConfig.g:2526:1: ( rule__DynamicConfig__PollingAssignment_2_1_1 )
            // InternalConfig.g:2526:2: rule__DynamicConfig__PollingAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2540:1: rule__ActorClassConfig__Group__0 : rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1 ;
    public final void rule__ActorClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2544:1: ( rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1 )
            // InternalConfig.g:2545:2: rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ActorClassConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2552:1: rule__ActorClassConfig__Group__0__Impl : ( 'ActorClassConfig' ) ;
    public final void rule__ActorClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2556:1: ( ( 'ActorClassConfig' ) )
            // InternalConfig.g:2557:1: ( 'ActorClassConfig' )
            {
            // InternalConfig.g:2557:1: ( 'ActorClassConfig' )
            // InternalConfig.g:2558:1: 'ActorClassConfig'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorClassConfigKeyword_0()); 
            }
            match(input,36,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2571:1: rule__ActorClassConfig__Group__1 : rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2 ;
    public final void rule__ActorClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2575:1: ( rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2 )
            // InternalConfig.g:2576:2: rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__ActorClassConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2583:1: rule__ActorClassConfig__Group__1__Impl : ( ( rule__ActorClassConfig__ActorAssignment_1 ) ) ;
    public final void rule__ActorClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2587:1: ( ( ( rule__ActorClassConfig__ActorAssignment_1 ) ) )
            // InternalConfig.g:2588:1: ( ( rule__ActorClassConfig__ActorAssignment_1 ) )
            {
            // InternalConfig.g:2588:1: ( ( rule__ActorClassConfig__ActorAssignment_1 ) )
            // InternalConfig.g:2589:1: ( rule__ActorClassConfig__ActorAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorAssignment_1()); 
            }
            // InternalConfig.g:2590:1: ( rule__ActorClassConfig__ActorAssignment_1 )
            // InternalConfig.g:2590:2: rule__ActorClassConfig__ActorAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2600:1: rule__ActorClassConfig__Group__2 : rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3 ;
    public final void rule__ActorClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2604:1: ( rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3 )
            // InternalConfig.g:2605:2: rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__ActorClassConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2612:1: rule__ActorClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__ActorClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2616:1: ( ( '{' ) )
            // InternalConfig.g:2617:1: ( '{' )
            {
            // InternalConfig.g:2617:1: ( '{' )
            // InternalConfig.g:2618:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2631:1: rule__ActorClassConfig__Group__3 : rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4 ;
    public final void rule__ActorClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2635:1: ( rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4 )
            // InternalConfig.g:2636:2: rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4
            {
            pushFollow(FOLLOW_15);
            rule__ActorClassConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2643:1: rule__ActorClassConfig__Group__3__Impl : ( ( rule__ActorClassConfig__AttributesAssignment_3 )* ) ;
    public final void rule__ActorClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2647:1: ( ( ( rule__ActorClassConfig__AttributesAssignment_3 )* ) )
            // InternalConfig.g:2648:1: ( ( rule__ActorClassConfig__AttributesAssignment_3 )* )
            {
            // InternalConfig.g:2648:1: ( ( rule__ActorClassConfig__AttributesAssignment_3 )* )
            // InternalConfig.g:2649:1: ( rule__ActorClassConfig__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getAttributesAssignment_3()); 
            }
            // InternalConfig.g:2650:1: ( rule__ActorClassConfig__AttributesAssignment_3 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==42) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalConfig.g:2650:2: rule__ActorClassConfig__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__ActorClassConfig__AttributesAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalConfig.g:2660:1: rule__ActorClassConfig__Group__4 : rule__ActorClassConfig__Group__4__Impl ;
    public final void rule__ActorClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2664:1: ( rule__ActorClassConfig__Group__4__Impl )
            // InternalConfig.g:2665:2: rule__ActorClassConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2671:1: rule__ActorClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__ActorClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2675:1: ( ( '}' ) )
            // InternalConfig.g:2676:1: ( '}' )
            {
            // InternalConfig.g:2676:1: ( '}' )
            // InternalConfig.g:2677:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2700:1: rule__ActorInstanceConfig__Group__0 : rule__ActorInstanceConfig__Group__0__Impl rule__ActorInstanceConfig__Group__1 ;
    public final void rule__ActorInstanceConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2704:1: ( rule__ActorInstanceConfig__Group__0__Impl rule__ActorInstanceConfig__Group__1 )
            // InternalConfig.g:2705:2: rule__ActorInstanceConfig__Group__0__Impl rule__ActorInstanceConfig__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ActorInstanceConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2712:1: rule__ActorInstanceConfig__Group__0__Impl : ( 'ActorInstanceConfig' ) ;
    public final void rule__ActorInstanceConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2716:1: ( ( 'ActorInstanceConfig' ) )
            // InternalConfig.g:2717:1: ( 'ActorInstanceConfig' )
            {
            // InternalConfig.g:2717:1: ( 'ActorInstanceConfig' )
            // InternalConfig.g:2718:1: 'ActorInstanceConfig'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getActorInstanceConfigKeyword_0()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2731:1: rule__ActorInstanceConfig__Group__1 : rule__ActorInstanceConfig__Group__1__Impl rule__ActorInstanceConfig__Group__2 ;
    public final void rule__ActorInstanceConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2735:1: ( rule__ActorInstanceConfig__Group__1__Impl rule__ActorInstanceConfig__Group__2 )
            // InternalConfig.g:2736:2: rule__ActorInstanceConfig__Group__1__Impl rule__ActorInstanceConfig__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__ActorInstanceConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2743:1: rule__ActorInstanceConfig__Group__1__Impl : ( ( rule__ActorInstanceConfig__RootAssignment_1 ) ) ;
    public final void rule__ActorInstanceConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2747:1: ( ( ( rule__ActorInstanceConfig__RootAssignment_1 ) ) )
            // InternalConfig.g:2748:1: ( ( rule__ActorInstanceConfig__RootAssignment_1 ) )
            {
            // InternalConfig.g:2748:1: ( ( rule__ActorInstanceConfig__RootAssignment_1 ) )
            // InternalConfig.g:2749:1: ( rule__ActorInstanceConfig__RootAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRootAssignment_1()); 
            }
            // InternalConfig.g:2750:1: ( rule__ActorInstanceConfig__RootAssignment_1 )
            // InternalConfig.g:2750:2: rule__ActorInstanceConfig__RootAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2760:1: rule__ActorInstanceConfig__Group__2 : rule__ActorInstanceConfig__Group__2__Impl rule__ActorInstanceConfig__Group__3 ;
    public final void rule__ActorInstanceConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2764:1: ( rule__ActorInstanceConfig__Group__2__Impl rule__ActorInstanceConfig__Group__3 )
            // InternalConfig.g:2765:2: rule__ActorInstanceConfig__Group__2__Impl rule__ActorInstanceConfig__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__ActorInstanceConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2772:1: rule__ActorInstanceConfig__Group__2__Impl : ( '/' ) ;
    public final void rule__ActorInstanceConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2776:1: ( ( '/' ) )
            // InternalConfig.g:2777:1: ( '/' )
            {
            // InternalConfig.g:2777:1: ( '/' )
            // InternalConfig.g:2778:1: '/'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_2()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2791:1: rule__ActorInstanceConfig__Group__3 : rule__ActorInstanceConfig__Group__3__Impl rule__ActorInstanceConfig__Group__4 ;
    public final void rule__ActorInstanceConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2795:1: ( rule__ActorInstanceConfig__Group__3__Impl rule__ActorInstanceConfig__Group__4 )
            // InternalConfig.g:2796:2: rule__ActorInstanceConfig__Group__3__Impl rule__ActorInstanceConfig__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__ActorInstanceConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2803:1: rule__ActorInstanceConfig__Group__3__Impl : ( ( rule__ActorInstanceConfig__SubSystemAssignment_3 ) ) ;
    public final void rule__ActorInstanceConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2807:1: ( ( ( rule__ActorInstanceConfig__SubSystemAssignment_3 ) ) )
            // InternalConfig.g:2808:1: ( ( rule__ActorInstanceConfig__SubSystemAssignment_3 ) )
            {
            // InternalConfig.g:2808:1: ( ( rule__ActorInstanceConfig__SubSystemAssignment_3 ) )
            // InternalConfig.g:2809:1: ( rule__ActorInstanceConfig__SubSystemAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getSubSystemAssignment_3()); 
            }
            // InternalConfig.g:2810:1: ( rule__ActorInstanceConfig__SubSystemAssignment_3 )
            // InternalConfig.g:2810:2: rule__ActorInstanceConfig__SubSystemAssignment_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2820:1: rule__ActorInstanceConfig__Group__4 : rule__ActorInstanceConfig__Group__4__Impl rule__ActorInstanceConfig__Group__5 ;
    public final void rule__ActorInstanceConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2824:1: ( rule__ActorInstanceConfig__Group__4__Impl rule__ActorInstanceConfig__Group__5 )
            // InternalConfig.g:2825:2: rule__ActorInstanceConfig__Group__4__Impl rule__ActorInstanceConfig__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__ActorInstanceConfig__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2832:1: rule__ActorInstanceConfig__Group__4__Impl : ( '/' ) ;
    public final void rule__ActorInstanceConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2836:1: ( ( '/' ) )
            // InternalConfig.g:2837:1: ( '/' )
            {
            // InternalConfig.g:2837:1: ( '/' )
            // InternalConfig.g:2838:1: '/'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_4()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2851:1: rule__ActorInstanceConfig__Group__5 : rule__ActorInstanceConfig__Group__5__Impl rule__ActorInstanceConfig__Group__6 ;
    public final void rule__ActorInstanceConfig__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2855:1: ( rule__ActorInstanceConfig__Group__5__Impl rule__ActorInstanceConfig__Group__6 )
            // InternalConfig.g:2856:2: rule__ActorInstanceConfig__Group__5__Impl rule__ActorInstanceConfig__Group__6
            {
            pushFollow(FOLLOW_4);
            rule__ActorInstanceConfig__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2863:1: rule__ActorInstanceConfig__Group__5__Impl : ( ( rule__ActorInstanceConfig__PathAssignment_5 ) ) ;
    public final void rule__ActorInstanceConfig__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2867:1: ( ( ( rule__ActorInstanceConfig__PathAssignment_5 ) ) )
            // InternalConfig.g:2868:1: ( ( rule__ActorInstanceConfig__PathAssignment_5 ) )
            {
            // InternalConfig.g:2868:1: ( ( rule__ActorInstanceConfig__PathAssignment_5 ) )
            // InternalConfig.g:2869:1: ( rule__ActorInstanceConfig__PathAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getPathAssignment_5()); 
            }
            // InternalConfig.g:2870:1: ( rule__ActorInstanceConfig__PathAssignment_5 )
            // InternalConfig.g:2870:2: rule__ActorInstanceConfig__PathAssignment_5
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2880:1: rule__ActorInstanceConfig__Group__6 : rule__ActorInstanceConfig__Group__6__Impl rule__ActorInstanceConfig__Group__7 ;
    public final void rule__ActorInstanceConfig__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2884:1: ( rule__ActorInstanceConfig__Group__6__Impl rule__ActorInstanceConfig__Group__7 )
            // InternalConfig.g:2885:2: rule__ActorInstanceConfig__Group__6__Impl rule__ActorInstanceConfig__Group__7
            {
            pushFollow(FOLLOW_17);
            rule__ActorInstanceConfig__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2892:1: rule__ActorInstanceConfig__Group__6__Impl : ( '{' ) ;
    public final void rule__ActorInstanceConfig__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2896:1: ( ( '{' ) )
            // InternalConfig.g:2897:1: ( '{' )
            {
            // InternalConfig.g:2897:1: ( '{' )
            // InternalConfig.g:2898:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getLeftCurlyBracketKeyword_6()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2911:1: rule__ActorInstanceConfig__Group__7 : rule__ActorInstanceConfig__Group__7__Impl rule__ActorInstanceConfig__Group__8 ;
    public final void rule__ActorInstanceConfig__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2915:1: ( rule__ActorInstanceConfig__Group__7__Impl rule__ActorInstanceConfig__Group__8 )
            // InternalConfig.g:2916:2: rule__ActorInstanceConfig__Group__7__Impl rule__ActorInstanceConfig__Group__8
            {
            pushFollow(FOLLOW_10);
            rule__ActorInstanceConfig__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2923:1: rule__ActorInstanceConfig__Group__7__Impl : ( ( rule__ActorInstanceConfig__UnorderedGroup_7 ) ) ;
    public final void rule__ActorInstanceConfig__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2927:1: ( ( ( rule__ActorInstanceConfig__UnorderedGroup_7 ) ) )
            // InternalConfig.g:2928:1: ( ( rule__ActorInstanceConfig__UnorderedGroup_7 ) )
            {
            // InternalConfig.g:2928:1: ( ( rule__ActorInstanceConfig__UnorderedGroup_7 ) )
            // InternalConfig.g:2929:1: ( rule__ActorInstanceConfig__UnorderedGroup_7 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7()); 
            }
            // InternalConfig.g:2930:1: ( rule__ActorInstanceConfig__UnorderedGroup_7 )
            // InternalConfig.g:2930:2: rule__ActorInstanceConfig__UnorderedGroup_7
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2940:1: rule__ActorInstanceConfig__Group__8 : rule__ActorInstanceConfig__Group__8__Impl ;
    public final void rule__ActorInstanceConfig__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2944:1: ( rule__ActorInstanceConfig__Group__8__Impl )
            // InternalConfig.g:2945:2: rule__ActorInstanceConfig__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2951:1: rule__ActorInstanceConfig__Group__8__Impl : ( '}' ) ;
    public final void rule__ActorInstanceConfig__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2955:1: ( ( '}' ) )
            // InternalConfig.g:2956:1: ( '}' )
            {
            // InternalConfig.g:2956:1: ( '}' )
            // InternalConfig.g:2957:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRightCurlyBracketKeyword_8()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:2988:1: rule__ProtocolClassConfig__Group__0 : rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1 ;
    public final void rule__ProtocolClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:2992:1: ( rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1 )
            // InternalConfig.g:2993:2: rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ProtocolClassConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3000:1: rule__ProtocolClassConfig__Group__0__Impl : ( 'ProtocolClassConfig' ) ;
    public final void rule__ProtocolClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3004:1: ( ( 'ProtocolClassConfig' ) )
            // InternalConfig.g:3005:1: ( 'ProtocolClassConfig' )
            {
            // InternalConfig.g:3005:1: ( 'ProtocolClassConfig' )
            // InternalConfig.g:3006:1: 'ProtocolClassConfig'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolClassConfigKeyword_0()); 
            }
            match(input,38,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3019:1: rule__ProtocolClassConfig__Group__1 : rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2 ;
    public final void rule__ProtocolClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3023:1: ( rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2 )
            // InternalConfig.g:3024:2: rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__ProtocolClassConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3031:1: rule__ProtocolClassConfig__Group__1__Impl : ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3035:1: ( ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) ) )
            // InternalConfig.g:3036:1: ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) )
            {
            // InternalConfig.g:3036:1: ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) )
            // InternalConfig.g:3037:1: ( rule__ProtocolClassConfig__ProtocolAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolAssignment_1()); 
            }
            // InternalConfig.g:3038:1: ( rule__ProtocolClassConfig__ProtocolAssignment_1 )
            // InternalConfig.g:3038:2: rule__ProtocolClassConfig__ProtocolAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3048:1: rule__ProtocolClassConfig__Group__2 : rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3 ;
    public final void rule__ProtocolClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3052:1: ( rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3 )
            // InternalConfig.g:3053:2: rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__ProtocolClassConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3060:1: rule__ProtocolClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__ProtocolClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3064:1: ( ( '{' ) )
            // InternalConfig.g:3065:1: ( '{' )
            {
            // InternalConfig.g:3065:1: ( '{' )
            // InternalConfig.g:3066:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3079:1: rule__ProtocolClassConfig__Group__3 : rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4 ;
    public final void rule__ProtocolClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3083:1: ( rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4 )
            // InternalConfig.g:3084:2: rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__ProtocolClassConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3091:1: rule__ProtocolClassConfig__Group__3__Impl : ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) ) ;
    public final void rule__ProtocolClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3095:1: ( ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) ) )
            // InternalConfig.g:3096:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) )
            {
            // InternalConfig.g:3096:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) )
            // InternalConfig.g:3097:1: ( rule__ProtocolClassConfig__UnorderedGroup_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3()); 
            }
            // InternalConfig.g:3098:1: ( rule__ProtocolClassConfig__UnorderedGroup_3 )
            // InternalConfig.g:3098:2: rule__ProtocolClassConfig__UnorderedGroup_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3108:1: rule__ProtocolClassConfig__Group__4 : rule__ProtocolClassConfig__Group__4__Impl ;
    public final void rule__ProtocolClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3112:1: ( rule__ProtocolClassConfig__Group__4__Impl )
            // InternalConfig.g:3113:2: rule__ProtocolClassConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3119:1: rule__ProtocolClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__ProtocolClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3123:1: ( ( '}' ) )
            // InternalConfig.g:3124:1: ( '}' )
            {
            // InternalConfig.g:3124:1: ( '}' )
            // InternalConfig.g:3125:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3148:1: rule__ProtocolClassConfig__Group_3_0__0 : rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1 ;
    public final void rule__ProtocolClassConfig__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3152:1: ( rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1 )
            // InternalConfig.g:3153:2: rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1
            {
            pushFollow(FOLLOW_19);
            rule__ProtocolClassConfig__Group_3_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3160:1: rule__ProtocolClassConfig__Group_3_0__0__Impl : ( 'regular' ) ;
    public final void rule__ProtocolClassConfig__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3164:1: ( ( 'regular' ) )
            // InternalConfig.g:3165:1: ( 'regular' )
            {
            // InternalConfig.g:3165:1: ( 'regular' )
            // InternalConfig.g:3166:1: 'regular'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getRegularKeyword_3_0_0()); 
            }
            match(input,39,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3179:1: rule__ProtocolClassConfig__Group_3_0__1 : rule__ProtocolClassConfig__Group_3_0__1__Impl ;
    public final void rule__ProtocolClassConfig__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3183:1: ( rule__ProtocolClassConfig__Group_3_0__1__Impl )
            // InternalConfig.g:3184:2: rule__ProtocolClassConfig__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3190:1: rule__ProtocolClassConfig__Group_3_0__1__Impl : ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3194:1: ( ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) ) )
            // InternalConfig.g:3195:1: ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) )
            {
            // InternalConfig.g:3195:1: ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) )
            // InternalConfig.g:3196:1: ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getRegularAssignment_3_0_1()); 
            }
            // InternalConfig.g:3197:1: ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 )
            // InternalConfig.g:3197:2: rule__ProtocolClassConfig__RegularAssignment_3_0_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3211:1: rule__ProtocolClassConfig__Group_3_1__0 : rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1 ;
    public final void rule__ProtocolClassConfig__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3215:1: ( rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1 )
            // InternalConfig.g:3216:2: rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1
            {
            pushFollow(FOLLOW_19);
            rule__ProtocolClassConfig__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3223:1: rule__ProtocolClassConfig__Group_3_1__0__Impl : ( ( rule__ProtocolClassConfig__Alternatives_3_1_0 ) ) ;
    public final void rule__ProtocolClassConfig__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3227:1: ( ( ( rule__ProtocolClassConfig__Alternatives_3_1_0 ) ) )
            // InternalConfig.g:3228:1: ( ( rule__ProtocolClassConfig__Alternatives_3_1_0 ) )
            {
            // InternalConfig.g:3228:1: ( ( rule__ProtocolClassConfig__Alternatives_3_1_0 ) )
            // InternalConfig.g:3229:1: ( rule__ProtocolClassConfig__Alternatives_3_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getAlternatives_3_1_0()); 
            }
            // InternalConfig.g:3230:1: ( rule__ProtocolClassConfig__Alternatives_3_1_0 )
            // InternalConfig.g:3230:2: rule__ProtocolClassConfig__Alternatives_3_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ProtocolClassConfig__Alternatives_3_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProtocolClassConfigAccess().getAlternatives_3_1_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:3240:1: rule__ProtocolClassConfig__Group_3_1__1 : rule__ProtocolClassConfig__Group_3_1__1__Impl ;
    public final void rule__ProtocolClassConfig__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3244:1: ( rule__ProtocolClassConfig__Group_3_1__1__Impl )
            // InternalConfig.g:3245:2: rule__ProtocolClassConfig__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3251:1: rule__ProtocolClassConfig__Group_3_1__1__Impl : ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3255:1: ( ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) ) )
            // InternalConfig.g:3256:1: ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) )
            {
            // InternalConfig.g:3256:1: ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) )
            // InternalConfig.g:3257:1: ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getConjugatedAssignment_3_1_1()); 
            }
            // InternalConfig.g:3258:1: ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 )
            // InternalConfig.g:3258:2: rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3272:1: rule__PortClassConfig__Group__0 : rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1 ;
    public final void rule__PortClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3276:1: ( rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1 )
            // InternalConfig.g:3277:2: rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__PortClassConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3284:1: rule__PortClassConfig__Group__0__Impl : ( () ) ;
    public final void rule__PortClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3288:1: ( ( () ) )
            // InternalConfig.g:3289:1: ( () )
            {
            // InternalConfig.g:3289:1: ( () )
            // InternalConfig.g:3290:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getPortClassConfigAction_0()); 
            }
            // InternalConfig.g:3291:1: ()
            // InternalConfig.g:3293:1: 
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
    // InternalConfig.g:3303:1: rule__PortClassConfig__Group__1 : rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2 ;
    public final void rule__PortClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3307:1: ( rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2 )
            // InternalConfig.g:3308:2: rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__PortClassConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3315:1: rule__PortClassConfig__Group__1__Impl : ( 'Port' ) ;
    public final void rule__PortClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3319:1: ( ( 'Port' ) )
            // InternalConfig.g:3320:1: ( 'Port' )
            {
            // InternalConfig.g:3320:1: ( 'Port' )
            // InternalConfig.g:3321:1: 'Port'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getPortKeyword_1()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3334:1: rule__PortClassConfig__Group__2 : rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3 ;
    public final void rule__PortClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3338:1: ( rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3 )
            // InternalConfig.g:3339:2: rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__PortClassConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3346:1: rule__PortClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__PortClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3350:1: ( ( '{' ) )
            // InternalConfig.g:3351:1: ( '{' )
            {
            // InternalConfig.g:3351:1: ( '{' )
            // InternalConfig.g:3352:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3365:1: rule__PortClassConfig__Group__3 : rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4 ;
    public final void rule__PortClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3369:1: ( rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4 )
            // InternalConfig.g:3370:2: rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4
            {
            pushFollow(FOLLOW_15);
            rule__PortClassConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3377:1: rule__PortClassConfig__Group__3__Impl : ( ( rule__PortClassConfig__AttributesAssignment_3 )* ) ;
    public final void rule__PortClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3381:1: ( ( ( rule__PortClassConfig__AttributesAssignment_3 )* ) )
            // InternalConfig.g:3382:1: ( ( rule__PortClassConfig__AttributesAssignment_3 )* )
            {
            // InternalConfig.g:3382:1: ( ( rule__PortClassConfig__AttributesAssignment_3 )* )
            // InternalConfig.g:3383:1: ( rule__PortClassConfig__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getAttributesAssignment_3()); 
            }
            // InternalConfig.g:3384:1: ( rule__PortClassConfig__AttributesAssignment_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==42) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalConfig.g:3384:2: rule__PortClassConfig__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__PortClassConfig__AttributesAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalConfig.g:3394:1: rule__PortClassConfig__Group__4 : rule__PortClassConfig__Group__4__Impl ;
    public final void rule__PortClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3398:1: ( rule__PortClassConfig__Group__4__Impl )
            // InternalConfig.g:3399:2: rule__PortClassConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3405:1: rule__PortClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__PortClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3409:1: ( ( '}' ) )
            // InternalConfig.g:3410:1: ( '}' )
            {
            // InternalConfig.g:3410:1: ( '}' )
            // InternalConfig.g:3411:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3434:1: rule__PortInstanceConfig__Group__0 : rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1 ;
    public final void rule__PortInstanceConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3438:1: ( rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1 )
            // InternalConfig.g:3439:2: rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__PortInstanceConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3446:1: rule__PortInstanceConfig__Group__0__Impl : ( 'InterfaceItem' ) ;
    public final void rule__PortInstanceConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3450:1: ( ( 'InterfaceItem' ) )
            // InternalConfig.g:3451:1: ( 'InterfaceItem' )
            {
            // InternalConfig.g:3451:1: ( 'InterfaceItem' )
            // InternalConfig.g:3452:1: 'InterfaceItem'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getInterfaceItemKeyword_0()); 
            }
            match(input,41,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3465:1: rule__PortInstanceConfig__Group__1 : rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2 ;
    public final void rule__PortInstanceConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3469:1: ( rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2 )
            // InternalConfig.g:3470:2: rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__PortInstanceConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3477:1: rule__PortInstanceConfig__Group__1__Impl : ( ( rule__PortInstanceConfig__ItemAssignment_1 ) ) ;
    public final void rule__PortInstanceConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3481:1: ( ( ( rule__PortInstanceConfig__ItemAssignment_1 ) ) )
            // InternalConfig.g:3482:1: ( ( rule__PortInstanceConfig__ItemAssignment_1 ) )
            {
            // InternalConfig.g:3482:1: ( ( rule__PortInstanceConfig__ItemAssignment_1 ) )
            // InternalConfig.g:3483:1: ( rule__PortInstanceConfig__ItemAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getItemAssignment_1()); 
            }
            // InternalConfig.g:3484:1: ( rule__PortInstanceConfig__ItemAssignment_1 )
            // InternalConfig.g:3484:2: rule__PortInstanceConfig__ItemAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3494:1: rule__PortInstanceConfig__Group__2 : rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3 ;
    public final void rule__PortInstanceConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3498:1: ( rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3 )
            // InternalConfig.g:3499:2: rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__PortInstanceConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3506:1: rule__PortInstanceConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__PortInstanceConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3510:1: ( ( '{' ) )
            // InternalConfig.g:3511:1: ( '{' )
            {
            // InternalConfig.g:3511:1: ( '{' )
            // InternalConfig.g:3512:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3525:1: rule__PortInstanceConfig__Group__3 : rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4 ;
    public final void rule__PortInstanceConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3529:1: ( rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4 )
            // InternalConfig.g:3530:2: rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4
            {
            pushFollow(FOLLOW_15);
            rule__PortInstanceConfig__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3537:1: rule__PortInstanceConfig__Group__3__Impl : ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* ) ;
    public final void rule__PortInstanceConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3541:1: ( ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* ) )
            // InternalConfig.g:3542:1: ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* )
            {
            // InternalConfig.g:3542:1: ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* )
            // InternalConfig.g:3543:1: ( rule__PortInstanceConfig__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getAttributesAssignment_3()); 
            }
            // InternalConfig.g:3544:1: ( rule__PortInstanceConfig__AttributesAssignment_3 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==42) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalConfig.g:3544:2: rule__PortInstanceConfig__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__PortInstanceConfig__AttributesAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalConfig.g:3554:1: rule__PortInstanceConfig__Group__4 : rule__PortInstanceConfig__Group__4__Impl ;
    public final void rule__PortInstanceConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3558:1: ( rule__PortInstanceConfig__Group__4__Impl )
            // InternalConfig.g:3559:2: rule__PortInstanceConfig__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3565:1: rule__PortInstanceConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__PortInstanceConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3569:1: ( ( '}' ) )
            // InternalConfig.g:3570:1: ( '}' )
            {
            // InternalConfig.g:3570:1: ( '}' )
            // InternalConfig.g:3571:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3594:1: rule__AttrClassConfig__Group__0 : rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1 ;
    public final void rule__AttrClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3598:1: ( rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1 )
            // InternalConfig.g:3599:2: rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__AttrClassConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3606:1: rule__AttrClassConfig__Group__0__Impl : ( 'Attr' ) ;
    public final void rule__AttrClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3610:1: ( ( 'Attr' ) )
            // InternalConfig.g:3611:1: ( 'Attr' )
            {
            // InternalConfig.g:3611:1: ( 'Attr' )
            // InternalConfig.g:3612:1: 'Attr'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttrKeyword_0()); 
            }
            match(input,42,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3625:1: rule__AttrClassConfig__Group__1 : rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2 ;
    public final void rule__AttrClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3629:1: ( rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2 )
            // InternalConfig.g:3630:2: rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__AttrClassConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3637:1: rule__AttrClassConfig__Group__1__Impl : ( ( rule__AttrClassConfig__AttributeAssignment_1 ) ) ;
    public final void rule__AttrClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3641:1: ( ( ( rule__AttrClassConfig__AttributeAssignment_1 ) ) )
            // InternalConfig.g:3642:1: ( ( rule__AttrClassConfig__AttributeAssignment_1 ) )
            {
            // InternalConfig.g:3642:1: ( ( rule__AttrClassConfig__AttributeAssignment_1 ) )
            // InternalConfig.g:3643:1: ( rule__AttrClassConfig__AttributeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributeAssignment_1()); 
            }
            // InternalConfig.g:3644:1: ( rule__AttrClassConfig__AttributeAssignment_1 )
            // InternalConfig.g:3644:2: rule__AttrClassConfig__AttributeAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3654:1: rule__AttrClassConfig__Group__2 : rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3 ;
    public final void rule__AttrClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3658:1: ( rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3 )
            // InternalConfig.g:3659:2: rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__AttrClassConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3666:1: rule__AttrClassConfig__Group__2__Impl : ( ( rule__AttrClassConfig__Group_2__0 )? ) ;
    public final void rule__AttrClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3670:1: ( ( ( rule__AttrClassConfig__Group_2__0 )? ) )
            // InternalConfig.g:3671:1: ( ( rule__AttrClassConfig__Group_2__0 )? )
            {
            // InternalConfig.g:3671:1: ( ( rule__AttrClassConfig__Group_2__0 )? )
            // InternalConfig.g:3672:1: ( rule__AttrClassConfig__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_2()); 
            }
            // InternalConfig.g:3673:1: ( rule__AttrClassConfig__Group_2__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==43) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalConfig.g:3673:2: rule__AttrClassConfig__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3683:1: rule__AttrClassConfig__Group__3 : rule__AttrClassConfig__Group__3__Impl ;
    public final void rule__AttrClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3687:1: ( rule__AttrClassConfig__Group__3__Impl )
            // InternalConfig.g:3688:2: rule__AttrClassConfig__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3694:1: rule__AttrClassConfig__Group__3__Impl : ( ( rule__AttrClassConfig__Group_3__0 )? ) ;
    public final void rule__AttrClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3698:1: ( ( ( rule__AttrClassConfig__Group_3__0 )? ) )
            // InternalConfig.g:3699:1: ( ( rule__AttrClassConfig__Group_3__0 )? )
            {
            // InternalConfig.g:3699:1: ( ( rule__AttrClassConfig__Group_3__0 )? )
            // InternalConfig.g:3700:1: ( rule__AttrClassConfig__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_3()); 
            }
            // InternalConfig.g:3701:1: ( rule__AttrClassConfig__Group_3__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==27) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalConfig.g:3701:2: rule__AttrClassConfig__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3719:1: rule__AttrClassConfig__Group_2__0 : rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1 ;
    public final void rule__AttrClassConfig__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3723:1: ( rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1 )
            // InternalConfig.g:3724:2: rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1
            {
            pushFollow(FOLLOW_21);
            rule__AttrClassConfig__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3731:1: rule__AttrClassConfig__Group_2__0__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3735:1: ( ( '=' ) )
            // InternalConfig.g:3736:1: ( '=' )
            {
            // InternalConfig.g:3736:1: ( '=' )
            // InternalConfig.g:3737:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_2_0()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3750:1: rule__AttrClassConfig__Group_2__1 : rule__AttrClassConfig__Group_2__1__Impl ;
    public final void rule__AttrClassConfig__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3754:1: ( rule__AttrClassConfig__Group_2__1__Impl )
            // InternalConfig.g:3755:2: rule__AttrClassConfig__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3761:1: rule__AttrClassConfig__Group_2__1__Impl : ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) ) ;
    public final void rule__AttrClassConfig__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3765:1: ( ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) ) )
            // InternalConfig.g:3766:1: ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) )
            {
            // InternalConfig.g:3766:1: ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) )
            // InternalConfig.g:3767:1: ( rule__AttrClassConfig__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getValueAssignment_2_1()); 
            }
            // InternalConfig.g:3768:1: ( rule__AttrClassConfig__ValueAssignment_2_1 )
            // InternalConfig.g:3768:2: rule__AttrClassConfig__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3782:1: rule__AttrClassConfig__Group_3__0 : rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1 ;
    public final void rule__AttrClassConfig__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3786:1: ( rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1 )
            // InternalConfig.g:3787:2: rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1
            {
            pushFollow(FOLLOW_22);
            rule__AttrClassConfig__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3794:1: rule__AttrClassConfig__Group_3__0__Impl : ( '{' ) ;
    public final void rule__AttrClassConfig__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3798:1: ( ( '{' ) )
            // InternalConfig.g:3799:1: ( '{' )
            {
            // InternalConfig.g:3799:1: ( '{' )
            // InternalConfig.g:3800:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getLeftCurlyBracketKeyword_3_0()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3813:1: rule__AttrClassConfig__Group_3__1 : rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2 ;
    public final void rule__AttrClassConfig__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3817:1: ( rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2 )
            // InternalConfig.g:3818:2: rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2
            {
            pushFollow(FOLLOW_10);
            rule__AttrClassConfig__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3825:1: rule__AttrClassConfig__Group_3__1__Impl : ( ( rule__AttrClassConfig__Group_3_1__0 ) ) ;
    public final void rule__AttrClassConfig__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3829:1: ( ( ( rule__AttrClassConfig__Group_3_1__0 ) ) )
            // InternalConfig.g:3830:1: ( ( rule__AttrClassConfig__Group_3_1__0 ) )
            {
            // InternalConfig.g:3830:1: ( ( rule__AttrClassConfig__Group_3_1__0 ) )
            // InternalConfig.g:3831:1: ( rule__AttrClassConfig__Group_3_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_3_1()); 
            }
            // InternalConfig.g:3832:1: ( rule__AttrClassConfig__Group_3_1__0 )
            // InternalConfig.g:3832:2: rule__AttrClassConfig__Group_3_1__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3842:1: rule__AttrClassConfig__Group_3__2 : rule__AttrClassConfig__Group_3__2__Impl ;
    public final void rule__AttrClassConfig__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3846:1: ( rule__AttrClassConfig__Group_3__2__Impl )
            // InternalConfig.g:3847:2: rule__AttrClassConfig__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3853:1: rule__AttrClassConfig__Group_3__2__Impl : ( '}' ) ;
    public final void rule__AttrClassConfig__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3857:1: ( ( '}' ) )
            // InternalConfig.g:3858:1: ( '}' )
            {
            // InternalConfig.g:3858:1: ( '}' )
            // InternalConfig.g:3859:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getRightCurlyBracketKeyword_3_2()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:3878:1: rule__AttrClassConfig__Group_3_1__0 : rule__AttrClassConfig__Group_3_1__0__Impl rule__AttrClassConfig__Group_3_1__1 ;
    public final void rule__AttrClassConfig__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3882:1: ( rule__AttrClassConfig__Group_3_1__0__Impl rule__AttrClassConfig__Group_3_1__1 )
            // InternalConfig.g:3883:2: rule__AttrClassConfig__Group_3_1__0__Impl rule__AttrClassConfig__Group_3_1__1
            {
            pushFollow(FOLLOW_22);
            rule__AttrClassConfig__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3890:1: rule__AttrClassConfig__Group_3_1__0__Impl : ( ( rule__AttrClassConfig__Group_3_1_0__0 )? ) ;
    public final void rule__AttrClassConfig__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3894:1: ( ( ( rule__AttrClassConfig__Group_3_1_0__0 )? ) )
            // InternalConfig.g:3895:1: ( ( rule__AttrClassConfig__Group_3_1_0__0 )? )
            {
            // InternalConfig.g:3895:1: ( ( rule__AttrClassConfig__Group_3_1_0__0 )? )
            // InternalConfig.g:3896:1: ( rule__AttrClassConfig__Group_3_1_0__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_0()); 
            }
            // InternalConfig.g:3897:1: ( rule__AttrClassConfig__Group_3_1_0__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==44) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalConfig.g:3897:2: rule__AttrClassConfig__Group_3_1_0__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3907:1: rule__AttrClassConfig__Group_3_1__1 : rule__AttrClassConfig__Group_3_1__1__Impl rule__AttrClassConfig__Group_3_1__2 ;
    public final void rule__AttrClassConfig__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3911:1: ( rule__AttrClassConfig__Group_3_1__1__Impl rule__AttrClassConfig__Group_3_1__2 )
            // InternalConfig.g:3912:2: rule__AttrClassConfig__Group_3_1__1__Impl rule__AttrClassConfig__Group_3_1__2
            {
            pushFollow(FOLLOW_22);
            rule__AttrClassConfig__Group_3_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3919:1: rule__AttrClassConfig__Group_3_1__1__Impl : ( ( rule__AttrClassConfig__Group_3_1_1__0 )? ) ;
    public final void rule__AttrClassConfig__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3923:1: ( ( ( rule__AttrClassConfig__Group_3_1_1__0 )? ) )
            // InternalConfig.g:3924:1: ( ( rule__AttrClassConfig__Group_3_1_1__0 )? )
            {
            // InternalConfig.g:3924:1: ( ( rule__AttrClassConfig__Group_3_1_1__0 )? )
            // InternalConfig.g:3925:1: ( rule__AttrClassConfig__Group_3_1_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_1()); 
            }
            // InternalConfig.g:3926:1: ( rule__AttrClassConfig__Group_3_1_1__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==45) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalConfig.g:3926:2: rule__AttrClassConfig__Group_3_1_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3936:1: rule__AttrClassConfig__Group_3_1__2 : rule__AttrClassConfig__Group_3_1__2__Impl ;
    public final void rule__AttrClassConfig__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3940:1: ( rule__AttrClassConfig__Group_3_1__2__Impl )
            // InternalConfig.g:3941:2: rule__AttrClassConfig__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3947:1: rule__AttrClassConfig__Group_3_1__2__Impl : ( ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )* ) ;
    public final void rule__AttrClassConfig__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3951:1: ( ( ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )* ) )
            // InternalConfig.g:3952:1: ( ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )* )
            {
            // InternalConfig.g:3952:1: ( ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )* )
            // InternalConfig.g:3953:1: ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributesAssignment_3_1_2()); 
            }
            // InternalConfig.g:3954:1: ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==42) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalConfig.g:3954:2: rule__AttrClassConfig__AttributesAssignment_3_1_2
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__AttrClassConfig__AttributesAssignment_3_1_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalConfig.g:3970:1: rule__AttrClassConfig__Group_3_1_0__0 : rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1 ;
    public final void rule__AttrClassConfig__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3974:1: ( rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1 )
            // InternalConfig.g:3975:2: rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1
            {
            pushFollow(FOLLOW_23);
            rule__AttrClassConfig__Group_3_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:3982:1: rule__AttrClassConfig__Group_3_1_0__0__Impl : ( 'min' ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:3986:1: ( ( 'min' ) )
            // InternalConfig.g:3987:1: ( 'min' )
            {
            // InternalConfig.g:3987:1: ( 'min' )
            // InternalConfig.g:3988:1: 'min'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMinKeyword_3_1_0_0()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:4001:1: rule__AttrClassConfig__Group_3_1_0__1 : rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2 ;
    public final void rule__AttrClassConfig__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4005:1: ( rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2 )
            // InternalConfig.g:4006:2: rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2
            {
            pushFollow(FOLLOW_24);
            rule__AttrClassConfig__Group_3_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4013:1: rule__AttrClassConfig__Group_3_1_0__1__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4017:1: ( ( '=' ) )
            // InternalConfig.g:4018:1: ( '=' )
            {
            // InternalConfig.g:4018:1: ( '=' )
            // InternalConfig.g:4019:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_0_1()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:4032:1: rule__AttrClassConfig__Group_3_1_0__2 : rule__AttrClassConfig__Group_3_1_0__2__Impl ;
    public final void rule__AttrClassConfig__Group_3_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4036:1: ( rule__AttrClassConfig__Group_3_1_0__2__Impl )
            // InternalConfig.g:4037:2: rule__AttrClassConfig__Group_3_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4043:1: rule__AttrClassConfig__Group_3_1_0__2__Impl : ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4047:1: ( ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) ) )
            // InternalConfig.g:4048:1: ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) )
            {
            // InternalConfig.g:4048:1: ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) )
            // InternalConfig.g:4049:1: ( rule__AttrClassConfig__MinAssignment_3_1_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMinAssignment_3_1_0_2()); 
            }
            // InternalConfig.g:4050:1: ( rule__AttrClassConfig__MinAssignment_3_1_0_2 )
            // InternalConfig.g:4050:2: rule__AttrClassConfig__MinAssignment_3_1_0_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4066:1: rule__AttrClassConfig__Group_3_1_1__0 : rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1 ;
    public final void rule__AttrClassConfig__Group_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4070:1: ( rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1 )
            // InternalConfig.g:4071:2: rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1
            {
            pushFollow(FOLLOW_23);
            rule__AttrClassConfig__Group_3_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4078:1: rule__AttrClassConfig__Group_3_1_1__0__Impl : ( 'max' ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4082:1: ( ( 'max' ) )
            // InternalConfig.g:4083:1: ( 'max' )
            {
            // InternalConfig.g:4083:1: ( 'max' )
            // InternalConfig.g:4084:1: 'max'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMaxKeyword_3_1_1_0()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:4097:1: rule__AttrClassConfig__Group_3_1_1__1 : rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2 ;
    public final void rule__AttrClassConfig__Group_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4101:1: ( rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2 )
            // InternalConfig.g:4102:2: rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2
            {
            pushFollow(FOLLOW_24);
            rule__AttrClassConfig__Group_3_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4109:1: rule__AttrClassConfig__Group_3_1_1__1__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4113:1: ( ( '=' ) )
            // InternalConfig.g:4114:1: ( '=' )
            {
            // InternalConfig.g:4114:1: ( '=' )
            // InternalConfig.g:4115:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_1_1()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:4128:1: rule__AttrClassConfig__Group_3_1_1__2 : rule__AttrClassConfig__Group_3_1_1__2__Impl ;
    public final void rule__AttrClassConfig__Group_3_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4132:1: ( rule__AttrClassConfig__Group_3_1_1__2__Impl )
            // InternalConfig.g:4133:2: rule__AttrClassConfig__Group_3_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4139:1: rule__AttrClassConfig__Group_3_1_1__2__Impl : ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4143:1: ( ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) ) )
            // InternalConfig.g:4144:1: ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) )
            {
            // InternalConfig.g:4144:1: ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) )
            // InternalConfig.g:4145:1: ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMaxAssignment_3_1_1_2()); 
            }
            // InternalConfig.g:4146:1: ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 )
            // InternalConfig.g:4146:2: rule__AttrClassConfig__MaxAssignment_3_1_1_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4162:1: rule__AttrInstanceConfig__Group__0 : rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1 ;
    public final void rule__AttrInstanceConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4166:1: ( rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1 )
            // InternalConfig.g:4167:2: rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__AttrInstanceConfig__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4174:1: rule__AttrInstanceConfig__Group__0__Impl : ( 'Attr' ) ;
    public final void rule__AttrInstanceConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4178:1: ( ( 'Attr' ) )
            // InternalConfig.g:4179:1: ( 'Attr' )
            {
            // InternalConfig.g:4179:1: ( 'Attr' )
            // InternalConfig.g:4180:1: 'Attr'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttrKeyword_0()); 
            }
            match(input,42,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:4193:1: rule__AttrInstanceConfig__Group__1 : rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2 ;
    public final void rule__AttrInstanceConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4197:1: ( rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2 )
            // InternalConfig.g:4198:2: rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__AttrInstanceConfig__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4205:1: rule__AttrInstanceConfig__Group__1__Impl : ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4209:1: ( ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) ) )
            // InternalConfig.g:4210:1: ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) )
            {
            // InternalConfig.g:4210:1: ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) )
            // InternalConfig.g:4211:1: ( rule__AttrInstanceConfig__AttributeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAssignment_1()); 
            }
            // InternalConfig.g:4212:1: ( rule__AttrInstanceConfig__AttributeAssignment_1 )
            // InternalConfig.g:4212:2: rule__AttrInstanceConfig__AttributeAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4222:1: rule__AttrInstanceConfig__Group__2 : rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3 ;
    public final void rule__AttrInstanceConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4226:1: ( rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3 )
            // InternalConfig.g:4227:2: rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__AttrInstanceConfig__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4234:1: rule__AttrInstanceConfig__Group__2__Impl : ( ( rule__AttrInstanceConfig__Group_2__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4238:1: ( ( ( rule__AttrInstanceConfig__Group_2__0 )? ) )
            // InternalConfig.g:4239:1: ( ( rule__AttrInstanceConfig__Group_2__0 )? )
            {
            // InternalConfig.g:4239:1: ( ( rule__AttrInstanceConfig__Group_2__0 )? )
            // InternalConfig.g:4240:1: ( rule__AttrInstanceConfig__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_2()); 
            }
            // InternalConfig.g:4241:1: ( rule__AttrInstanceConfig__Group_2__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==43) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalConfig.g:4241:2: rule__AttrInstanceConfig__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4251:1: rule__AttrInstanceConfig__Group__3 : rule__AttrInstanceConfig__Group__3__Impl ;
    public final void rule__AttrInstanceConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4255:1: ( rule__AttrInstanceConfig__Group__3__Impl )
            // InternalConfig.g:4256:2: rule__AttrInstanceConfig__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4262:1: rule__AttrInstanceConfig__Group__3__Impl : ( ( rule__AttrInstanceConfig__Group_3__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4266:1: ( ( ( rule__AttrInstanceConfig__Group_3__0 )? ) )
            // InternalConfig.g:4267:1: ( ( rule__AttrInstanceConfig__Group_3__0 )? )
            {
            // InternalConfig.g:4267:1: ( ( rule__AttrInstanceConfig__Group_3__0 )? )
            // InternalConfig.g:4268:1: ( rule__AttrInstanceConfig__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_3()); 
            }
            // InternalConfig.g:4269:1: ( rule__AttrInstanceConfig__Group_3__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==27) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalConfig.g:4269:2: rule__AttrInstanceConfig__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4287:1: rule__AttrInstanceConfig__Group_2__0 : rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1 ;
    public final void rule__AttrInstanceConfig__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4291:1: ( rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1 )
            // InternalConfig.g:4292:2: rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1
            {
            pushFollow(FOLLOW_21);
            rule__AttrInstanceConfig__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4299:1: rule__AttrInstanceConfig__Group_2__0__Impl : ( '=' ) ;
    public final void rule__AttrInstanceConfig__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4303:1: ( ( '=' ) )
            // InternalConfig.g:4304:1: ( '=' )
            {
            // InternalConfig.g:4304:1: ( '=' )
            // InternalConfig.g:4305:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getEqualsSignKeyword_2_0()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:4318:1: rule__AttrInstanceConfig__Group_2__1 : rule__AttrInstanceConfig__Group_2__1__Impl ;
    public final void rule__AttrInstanceConfig__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4322:1: ( rule__AttrInstanceConfig__Group_2__1__Impl )
            // InternalConfig.g:4323:2: rule__AttrInstanceConfig__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4329:1: rule__AttrInstanceConfig__Group_2__1__Impl : ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4333:1: ( ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) ) )
            // InternalConfig.g:4334:1: ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) )
            {
            // InternalConfig.g:4334:1: ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) )
            // InternalConfig.g:4335:1: ( rule__AttrInstanceConfig__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getValueAssignment_2_1()); 
            }
            // InternalConfig.g:4336:1: ( rule__AttrInstanceConfig__ValueAssignment_2_1 )
            // InternalConfig.g:4336:2: rule__AttrInstanceConfig__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4350:1: rule__AttrInstanceConfig__Group_3__0 : rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1 ;
    public final void rule__AttrInstanceConfig__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4354:1: ( rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1 )
            // InternalConfig.g:4355:2: rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1
            {
            pushFollow(FOLLOW_25);
            rule__AttrInstanceConfig__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4362:1: rule__AttrInstanceConfig__Group_3__0__Impl : ( '{' ) ;
    public final void rule__AttrInstanceConfig__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4366:1: ( ( '{' ) )
            // InternalConfig.g:4367:1: ( '{' )
            {
            // InternalConfig.g:4367:1: ( '{' )
            // InternalConfig.g:4368:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getLeftCurlyBracketKeyword_3_0()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:4381:1: rule__AttrInstanceConfig__Group_3__1 : rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2 ;
    public final void rule__AttrInstanceConfig__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4385:1: ( rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2 )
            // InternalConfig.g:4386:2: rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2
            {
            pushFollow(FOLLOW_10);
            rule__AttrInstanceConfig__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4393:1: rule__AttrInstanceConfig__Group_3__1__Impl : ( ( rule__AttrInstanceConfig__Group_3_1__0 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4397:1: ( ( ( rule__AttrInstanceConfig__Group_3_1__0 ) ) )
            // InternalConfig.g:4398:1: ( ( rule__AttrInstanceConfig__Group_3_1__0 ) )
            {
            // InternalConfig.g:4398:1: ( ( rule__AttrInstanceConfig__Group_3_1__0 ) )
            // InternalConfig.g:4399:1: ( rule__AttrInstanceConfig__Group_3_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1()); 
            }
            // InternalConfig.g:4400:1: ( rule__AttrInstanceConfig__Group_3_1__0 )
            // InternalConfig.g:4400:2: rule__AttrInstanceConfig__Group_3_1__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4410:1: rule__AttrInstanceConfig__Group_3__2 : rule__AttrInstanceConfig__Group_3__2__Impl ;
    public final void rule__AttrInstanceConfig__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4414:1: ( rule__AttrInstanceConfig__Group_3__2__Impl )
            // InternalConfig.g:4415:2: rule__AttrInstanceConfig__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4421:1: rule__AttrInstanceConfig__Group_3__2__Impl : ( '}' ) ;
    public final void rule__AttrInstanceConfig__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4425:1: ( ( '}' ) )
            // InternalConfig.g:4426:1: ( '}' )
            {
            // InternalConfig.g:4426:1: ( '}' )
            // InternalConfig.g:4427:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getRightCurlyBracketKeyword_3_2()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:4446:1: rule__AttrInstanceConfig__Group_3_1__0 : rule__AttrInstanceConfig__Group_3_1__0__Impl rule__AttrInstanceConfig__Group_3_1__1 ;
    public final void rule__AttrInstanceConfig__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4450:1: ( rule__AttrInstanceConfig__Group_3_1__0__Impl rule__AttrInstanceConfig__Group_3_1__1 )
            // InternalConfig.g:4451:2: rule__AttrInstanceConfig__Group_3_1__0__Impl rule__AttrInstanceConfig__Group_3_1__1
            {
            pushFollow(FOLLOW_25);
            rule__AttrInstanceConfig__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4458:1: rule__AttrInstanceConfig__Group_3_1__0__Impl : ( ( rule__AttrInstanceConfig__Group_3_1_0__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4462:1: ( ( ( rule__AttrInstanceConfig__Group_3_1_0__0 )? ) )
            // InternalConfig.g:4463:1: ( ( rule__AttrInstanceConfig__Group_3_1_0__0 )? )
            {
            // InternalConfig.g:4463:1: ( ( rule__AttrInstanceConfig__Group_3_1_0__0 )? )
            // InternalConfig.g:4464:1: ( rule__AttrInstanceConfig__Group_3_1_0__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1_0()); 
            }
            // InternalConfig.g:4465:1: ( rule__AttrInstanceConfig__Group_3_1_0__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==31) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalConfig.g:4465:2: rule__AttrInstanceConfig__Group_3_1_0__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4475:1: rule__AttrInstanceConfig__Group_3_1__1 : rule__AttrInstanceConfig__Group_3_1__1__Impl ;
    public final void rule__AttrInstanceConfig__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4479:1: ( rule__AttrInstanceConfig__Group_3_1__1__Impl )
            // InternalConfig.g:4480:2: rule__AttrInstanceConfig__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4486:1: rule__AttrInstanceConfig__Group_3_1__1__Impl : ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) ;
    public final void rule__AttrInstanceConfig__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4490:1: ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) )
            // InternalConfig.g:4491:1: ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* )
            {
            // InternalConfig.g:4491:1: ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* )
            // InternalConfig.g:4492:1: ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributesAssignment_3_1_1()); 
            }
            // InternalConfig.g:4493:1: ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==42) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalConfig.g:4493:2: rule__AttrInstanceConfig__AttributesAssignment_3_1_1
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__AttrInstanceConfig__AttributesAssignment_3_1_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalConfig.g:4507:1: rule__AttrInstanceConfig__Group_3_1_0__0 : rule__AttrInstanceConfig__Group_3_1_0__0__Impl rule__AttrInstanceConfig__Group_3_1_0__1 ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4511:1: ( rule__AttrInstanceConfig__Group_3_1_0__0__Impl rule__AttrInstanceConfig__Group_3_1_0__1 )
            // InternalConfig.g:4512:2: rule__AttrInstanceConfig__Group_3_1_0__0__Impl rule__AttrInstanceConfig__Group_3_1_0__1
            {
            pushFollow(FOLLOW_26);
            rule__AttrInstanceConfig__Group_3_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4519:1: rule__AttrInstanceConfig__Group_3_1_0__0__Impl : ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4523:1: ( ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) ) )
            // InternalConfig.g:4524:1: ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) )
            {
            // InternalConfig.g:4524:1: ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) )
            // InternalConfig.g:4525:1: ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigAssignment_3_1_0_0()); 
            }
            // InternalConfig.g:4526:1: ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 )
            // InternalConfig.g:4526:2: rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4536:1: rule__AttrInstanceConfig__Group_3_1_0__1 : rule__AttrInstanceConfig__Group_3_1_0__1__Impl ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4540:1: ( rule__AttrInstanceConfig__Group_3_1_0__1__Impl )
            // InternalConfig.g:4541:2: rule__AttrInstanceConfig__Group_3_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4547:1: rule__AttrInstanceConfig__Group_3_1_0__1__Impl : ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4551:1: ( ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) ) )
            // InternalConfig.g:4552:1: ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) )
            {
            // InternalConfig.g:4552:1: ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) )
            // InternalConfig.g:4553:1: ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAlternatives_3_1_0_1()); 
            }
            // InternalConfig.g:4554:1: ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 )
            // InternalConfig.g:4554:2: rule__AttrInstanceConfig__Alternatives_3_1_0_1
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__ConfigValueArray__Group__0"
    // InternalConfig.g:4568:1: rule__ConfigValueArray__Group__0 : rule__ConfigValueArray__Group__0__Impl rule__ConfigValueArray__Group__1 ;
    public final void rule__ConfigValueArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4572:1: ( rule__ConfigValueArray__Group__0__Impl rule__ConfigValueArray__Group__1 )
            // InternalConfig.g:4573:2: rule__ConfigValueArray__Group__0__Impl rule__ConfigValueArray__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__ConfigValueArray__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ConfigValueArray__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigValueArray__Group__0"


    // $ANTLR start "rule__ConfigValueArray__Group__0__Impl"
    // InternalConfig.g:4580:1: rule__ConfigValueArray__Group__0__Impl : ( ( rule__ConfigValueArray__ValuesAssignment_0 ) ) ;
    public final void rule__ConfigValueArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4584:1: ( ( ( rule__ConfigValueArray__ValuesAssignment_0 ) ) )
            // InternalConfig.g:4585:1: ( ( rule__ConfigValueArray__ValuesAssignment_0 ) )
            {
            // InternalConfig.g:4585:1: ( ( rule__ConfigValueArray__ValuesAssignment_0 ) )
            // InternalConfig.g:4586:1: ( rule__ConfigValueArray__ValuesAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueArrayAccess().getValuesAssignment_0()); 
            }
            // InternalConfig.g:4587:1: ( rule__ConfigValueArray__ValuesAssignment_0 )
            // InternalConfig.g:4587:2: rule__ConfigValueArray__ValuesAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ConfigValueArray__ValuesAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueArrayAccess().getValuesAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigValueArray__Group__0__Impl"


    // $ANTLR start "rule__ConfigValueArray__Group__1"
    // InternalConfig.g:4597:1: rule__ConfigValueArray__Group__1 : rule__ConfigValueArray__Group__1__Impl ;
    public final void rule__ConfigValueArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4601:1: ( rule__ConfigValueArray__Group__1__Impl )
            // InternalConfig.g:4602:2: rule__ConfigValueArray__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigValueArray__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigValueArray__Group__1"


    // $ANTLR start "rule__ConfigValueArray__Group__1__Impl"
    // InternalConfig.g:4608:1: rule__ConfigValueArray__Group__1__Impl : ( ( rule__ConfigValueArray__Group_1__0 )* ) ;
    public final void rule__ConfigValueArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4612:1: ( ( ( rule__ConfigValueArray__Group_1__0 )* ) )
            // InternalConfig.g:4613:1: ( ( rule__ConfigValueArray__Group_1__0 )* )
            {
            // InternalConfig.g:4613:1: ( ( rule__ConfigValueArray__Group_1__0 )* )
            // InternalConfig.g:4614:1: ( rule__ConfigValueArray__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueArrayAccess().getGroup_1()); 
            }
            // InternalConfig.g:4615:1: ( rule__ConfigValueArray__Group_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==46) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalConfig.g:4615:2: rule__ConfigValueArray__Group_1__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__ConfigValueArray__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueArrayAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigValueArray__Group__1__Impl"


    // $ANTLR start "rule__ConfigValueArray__Group_1__0"
    // InternalConfig.g:4629:1: rule__ConfigValueArray__Group_1__0 : rule__ConfigValueArray__Group_1__0__Impl rule__ConfigValueArray__Group_1__1 ;
    public final void rule__ConfigValueArray__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4633:1: ( rule__ConfigValueArray__Group_1__0__Impl rule__ConfigValueArray__Group_1__1 )
            // InternalConfig.g:4634:2: rule__ConfigValueArray__Group_1__0__Impl rule__ConfigValueArray__Group_1__1
            {
            pushFollow(FOLLOW_21);
            rule__ConfigValueArray__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ConfigValueArray__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigValueArray__Group_1__0"


    // $ANTLR start "rule__ConfigValueArray__Group_1__0__Impl"
    // InternalConfig.g:4641:1: rule__ConfigValueArray__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ConfigValueArray__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4645:1: ( ( ',' ) )
            // InternalConfig.g:4646:1: ( ',' )
            {
            // InternalConfig.g:4646:1: ( ',' )
            // InternalConfig.g:4647:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueArrayAccess().getCommaKeyword_1_0()); 
            }
            match(input,46,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueArrayAccess().getCommaKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigValueArray__Group_1__0__Impl"


    // $ANTLR start "rule__ConfigValueArray__Group_1__1"
    // InternalConfig.g:4660:1: rule__ConfigValueArray__Group_1__1 : rule__ConfigValueArray__Group_1__1__Impl ;
    public final void rule__ConfigValueArray__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4664:1: ( rule__ConfigValueArray__Group_1__1__Impl )
            // InternalConfig.g:4665:2: rule__ConfigValueArray__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigValueArray__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigValueArray__Group_1__1"


    // $ANTLR start "rule__ConfigValueArray__Group_1__1__Impl"
    // InternalConfig.g:4671:1: rule__ConfigValueArray__Group_1__1__Impl : ( ( rule__ConfigValueArray__ValuesAssignment_1_1 ) ) ;
    public final void rule__ConfigValueArray__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4675:1: ( ( ( rule__ConfigValueArray__ValuesAssignment_1_1 ) ) )
            // InternalConfig.g:4676:1: ( ( rule__ConfigValueArray__ValuesAssignment_1_1 ) )
            {
            // InternalConfig.g:4676:1: ( ( rule__ConfigValueArray__ValuesAssignment_1_1 ) )
            // InternalConfig.g:4677:1: ( rule__ConfigValueArray__ValuesAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueArrayAccess().getValuesAssignment_1_1()); 
            }
            // InternalConfig.g:4678:1: ( rule__ConfigValueArray__ValuesAssignment_1_1 )
            // InternalConfig.g:4678:2: rule__ConfigValueArray__ValuesAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ConfigValueArray__ValuesAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueArrayAccess().getValuesAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigValueArray__Group_1__1__Impl"


    // $ANTLR start "rule__EnumConfigValue__Group__0"
    // InternalConfig.g:4692:1: rule__EnumConfigValue__Group__0 : rule__EnumConfigValue__Group__0__Impl rule__EnumConfigValue__Group__1 ;
    public final void rule__EnumConfigValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4696:1: ( rule__EnumConfigValue__Group__0__Impl rule__EnumConfigValue__Group__1 )
            // InternalConfig.g:4697:2: rule__EnumConfigValue__Group__0__Impl rule__EnumConfigValue__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__EnumConfigValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumConfigValue__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumConfigValue__Group__0"


    // $ANTLR start "rule__EnumConfigValue__Group__0__Impl"
    // InternalConfig.g:4704:1: rule__EnumConfigValue__Group__0__Impl : ( ( rule__EnumConfigValue__TypeAssignment_0 ) ) ;
    public final void rule__EnumConfigValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4708:1: ( ( ( rule__EnumConfigValue__TypeAssignment_0 ) ) )
            // InternalConfig.g:4709:1: ( ( rule__EnumConfigValue__TypeAssignment_0 ) )
            {
            // InternalConfig.g:4709:1: ( ( rule__EnumConfigValue__TypeAssignment_0 ) )
            // InternalConfig.g:4710:1: ( rule__EnumConfigValue__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueAccess().getTypeAssignment_0()); 
            }
            // InternalConfig.g:4711:1: ( rule__EnumConfigValue__TypeAssignment_0 )
            // InternalConfig.g:4711:2: rule__EnumConfigValue__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__EnumConfigValue__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumConfigValueAccess().getTypeAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumConfigValue__Group__0__Impl"


    // $ANTLR start "rule__EnumConfigValue__Group__1"
    // InternalConfig.g:4721:1: rule__EnumConfigValue__Group__1 : rule__EnumConfigValue__Group__1__Impl rule__EnumConfigValue__Group__2 ;
    public final void rule__EnumConfigValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4725:1: ( rule__EnumConfigValue__Group__1__Impl rule__EnumConfigValue__Group__2 )
            // InternalConfig.g:4726:2: rule__EnumConfigValue__Group__1__Impl rule__EnumConfigValue__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__EnumConfigValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumConfigValue__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumConfigValue__Group__1"


    // $ANTLR start "rule__EnumConfigValue__Group__1__Impl"
    // InternalConfig.g:4733:1: rule__EnumConfigValue__Group__1__Impl : ( '.' ) ;
    public final void rule__EnumConfigValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4737:1: ( ( '.' ) )
            // InternalConfig.g:4738:1: ( '.' )
            {
            // InternalConfig.g:4738:1: ( '.' )
            // InternalConfig.g:4739:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueAccess().getFullStopKeyword_1()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumConfigValueAccess().getFullStopKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumConfigValue__Group__1__Impl"


    // $ANTLR start "rule__EnumConfigValue__Group__2"
    // InternalConfig.g:4752:1: rule__EnumConfigValue__Group__2 : rule__EnumConfigValue__Group__2__Impl ;
    public final void rule__EnumConfigValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4756:1: ( rule__EnumConfigValue__Group__2__Impl )
            // InternalConfig.g:4757:2: rule__EnumConfigValue__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumConfigValue__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumConfigValue__Group__2"


    // $ANTLR start "rule__EnumConfigValue__Group__2__Impl"
    // InternalConfig.g:4763:1: rule__EnumConfigValue__Group__2__Impl : ( ( rule__EnumConfigValue__ValueAssignment_2 ) ) ;
    public final void rule__EnumConfigValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4767:1: ( ( ( rule__EnumConfigValue__ValueAssignment_2 ) ) )
            // InternalConfig.g:4768:1: ( ( rule__EnumConfigValue__ValueAssignment_2 ) )
            {
            // InternalConfig.g:4768:1: ( ( rule__EnumConfigValue__ValueAssignment_2 ) )
            // InternalConfig.g:4769:1: ( rule__EnumConfigValue__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueAccess().getValueAssignment_2()); 
            }
            // InternalConfig.g:4770:1: ( rule__EnumConfigValue__ValueAssignment_2 )
            // InternalConfig.g:4770:2: rule__EnumConfigValue__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EnumConfigValue__ValueAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumConfigValueAccess().getValueAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumConfigValue__Group__2__Impl"


    // $ANTLR start "rule__RefPath__Group__0"
    // InternalConfig.g:4786:1: rule__RefPath__Group__0 : rule__RefPath__Group__0__Impl rule__RefPath__Group__1 ;
    public final void rule__RefPath__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4790:1: ( rule__RefPath__Group__0__Impl rule__RefPath__Group__1 )
            // InternalConfig.g:4791:2: rule__RefPath__Group__0__Impl rule__RefPath__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__RefPath__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4798:1: rule__RefPath__Group__0__Impl : ( ( rule__RefPath__RefsAssignment_0 ) ) ;
    public final void rule__RefPath__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4802:1: ( ( ( rule__RefPath__RefsAssignment_0 ) ) )
            // InternalConfig.g:4803:1: ( ( rule__RefPath__RefsAssignment_0 ) )
            {
            // InternalConfig.g:4803:1: ( ( rule__RefPath__RefsAssignment_0 ) )
            // InternalConfig.g:4804:1: ( rule__RefPath__RefsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsAssignment_0()); 
            }
            // InternalConfig.g:4805:1: ( rule__RefPath__RefsAssignment_0 )
            // InternalConfig.g:4805:2: rule__RefPath__RefsAssignment_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4815:1: rule__RefPath__Group__1 : rule__RefPath__Group__1__Impl ;
    public final void rule__RefPath__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4819:1: ( rule__RefPath__Group__1__Impl )
            // InternalConfig.g:4820:2: rule__RefPath__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4826:1: rule__RefPath__Group__1__Impl : ( ( rule__RefPath__Group_1__0 )* ) ;
    public final void rule__RefPath__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4830:1: ( ( ( rule__RefPath__Group_1__0 )* ) )
            // InternalConfig.g:4831:1: ( ( rule__RefPath__Group_1__0 )* )
            {
            // InternalConfig.g:4831:1: ( ( rule__RefPath__Group_1__0 )* )
            // InternalConfig.g:4832:1: ( rule__RefPath__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getGroup_1()); 
            }
            // InternalConfig.g:4833:1: ( rule__RefPath__Group_1__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==30) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalConfig.g:4833:2: rule__RefPath__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__RefPath__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // InternalConfig.g:4847:1: rule__RefPath__Group_1__0 : rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1 ;
    public final void rule__RefPath__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4851:1: ( rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1 )
            // InternalConfig.g:4852:2: rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__RefPath__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4859:1: rule__RefPath__Group_1__0__Impl : ( '/' ) ;
    public final void rule__RefPath__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4863:1: ( ( '/' ) )
            // InternalConfig.g:4864:1: ( '/' )
            {
            // InternalConfig.g:4864:1: ( '/' )
            // InternalConfig.g:4865:1: '/'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getSolidusKeyword_1_0()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:4878:1: rule__RefPath__Group_1__1 : rule__RefPath__Group_1__1__Impl ;
    public final void rule__RefPath__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4882:1: ( rule__RefPath__Group_1__1__Impl )
            // InternalConfig.g:4883:2: rule__RefPath__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:4889:1: rule__RefPath__Group_1__1__Impl : ( ( rule__RefPath__RefsAssignment_1_1 ) ) ;
    public final void rule__RefPath__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4893:1: ( ( ( rule__RefPath__RefsAssignment_1_1 ) ) )
            // InternalConfig.g:4894:1: ( ( rule__RefPath__RefsAssignment_1_1 ) )
            {
            // InternalConfig.g:4894:1: ( ( rule__RefPath__RefsAssignment_1_1 ) )
            // InternalConfig.g:4895:1: ( rule__RefPath__RefsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsAssignment_1_1()); 
            }
            // InternalConfig.g:4896:1: ( rule__RefPath__RefsAssignment_1_1 )
            // InternalConfig.g:4896:2: rule__RefPath__RefsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__RefSegment__Group__0"
    // InternalConfig.g:4910:1: rule__RefSegment__Group__0 : rule__RefSegment__Group__0__Impl rule__RefSegment__Group__1 ;
    public final void rule__RefSegment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4914:1: ( rule__RefSegment__Group__0__Impl rule__RefSegment__Group__1 )
            // InternalConfig.g:4915:2: rule__RefSegment__Group__0__Impl rule__RefSegment__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__RefSegment__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RefSegment__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RefSegment__Group__0"


    // $ANTLR start "rule__RefSegment__Group__0__Impl"
    // InternalConfig.g:4922:1: rule__RefSegment__Group__0__Impl : ( ( rule__RefSegment__RefAssignment_0 ) ) ;
    public final void rule__RefSegment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4926:1: ( ( ( rule__RefSegment__RefAssignment_0 ) ) )
            // InternalConfig.g:4927:1: ( ( rule__RefSegment__RefAssignment_0 ) )
            {
            // InternalConfig.g:4927:1: ( ( rule__RefSegment__RefAssignment_0 ) )
            // InternalConfig.g:4928:1: ( rule__RefSegment__RefAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefSegmentAccess().getRefAssignment_0()); 
            }
            // InternalConfig.g:4929:1: ( rule__RefSegment__RefAssignment_0 )
            // InternalConfig.g:4929:2: rule__RefSegment__RefAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__RefSegment__RefAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefSegmentAccess().getRefAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RefSegment__Group__0__Impl"


    // $ANTLR start "rule__RefSegment__Group__1"
    // InternalConfig.g:4939:1: rule__RefSegment__Group__1 : rule__RefSegment__Group__1__Impl ;
    public final void rule__RefSegment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4943:1: ( rule__RefSegment__Group__1__Impl )
            // InternalConfig.g:4944:2: rule__RefSegment__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RefSegment__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RefSegment__Group__1"


    // $ANTLR start "rule__RefSegment__Group__1__Impl"
    // InternalConfig.g:4950:1: rule__RefSegment__Group__1__Impl : ( ( rule__RefSegment__Group_1__0 )? ) ;
    public final void rule__RefSegment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4954:1: ( ( ( rule__RefSegment__Group_1__0 )? ) )
            // InternalConfig.g:4955:1: ( ( rule__RefSegment__Group_1__0 )? )
            {
            // InternalConfig.g:4955:1: ( ( rule__RefSegment__Group_1__0 )? )
            // InternalConfig.g:4956:1: ( rule__RefSegment__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefSegmentAccess().getGroup_1()); 
            }
            // InternalConfig.g:4957:1: ( rule__RefSegment__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==48) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalConfig.g:4957:2: rule__RefSegment__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RefSegment__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefSegmentAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RefSegment__Group__1__Impl"


    // $ANTLR start "rule__RefSegment__Group_1__0"
    // InternalConfig.g:4971:1: rule__RefSegment__Group_1__0 : rule__RefSegment__Group_1__0__Impl rule__RefSegment__Group_1__1 ;
    public final void rule__RefSegment__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4975:1: ( rule__RefSegment__Group_1__0__Impl rule__RefSegment__Group_1__1 )
            // InternalConfig.g:4976:2: rule__RefSegment__Group_1__0__Impl rule__RefSegment__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__RefSegment__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RefSegment__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RefSegment__Group_1__0"


    // $ANTLR start "rule__RefSegment__Group_1__0__Impl"
    // InternalConfig.g:4983:1: rule__RefSegment__Group_1__0__Impl : ( ':' ) ;
    public final void rule__RefSegment__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:4987:1: ( ( ':' ) )
            // InternalConfig.g:4988:1: ( ':' )
            {
            // InternalConfig.g:4988:1: ( ':' )
            // InternalConfig.g:4989:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefSegmentAccess().getColonKeyword_1_0()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefSegmentAccess().getColonKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RefSegment__Group_1__0__Impl"


    // $ANTLR start "rule__RefSegment__Group_1__1"
    // InternalConfig.g:5002:1: rule__RefSegment__Group_1__1 : rule__RefSegment__Group_1__1__Impl ;
    public final void rule__RefSegment__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5006:1: ( rule__RefSegment__Group_1__1__Impl )
            // InternalConfig.g:5007:2: rule__RefSegment__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RefSegment__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RefSegment__Group_1__1"


    // $ANTLR start "rule__RefSegment__Group_1__1__Impl"
    // InternalConfig.g:5013:1: rule__RefSegment__Group_1__1__Impl : ( ( rule__RefSegment__IdxAssignment_1_1 ) ) ;
    public final void rule__RefSegment__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5017:1: ( ( ( rule__RefSegment__IdxAssignment_1_1 ) ) )
            // InternalConfig.g:5018:1: ( ( rule__RefSegment__IdxAssignment_1_1 ) )
            {
            // InternalConfig.g:5018:1: ( ( rule__RefSegment__IdxAssignment_1_1 ) )
            // InternalConfig.g:5019:1: ( rule__RefSegment__IdxAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefSegmentAccess().getIdxAssignment_1_1()); 
            }
            // InternalConfig.g:5020:1: ( rule__RefSegment__IdxAssignment_1_1 )
            // InternalConfig.g:5020:2: rule__RefSegment__IdxAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__RefSegment__IdxAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefSegmentAccess().getIdxAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RefSegment__Group_1__1__Impl"


    // $ANTLR start "rule__KeyValue__Group__0"
    // InternalConfig.g:5037:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5041:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // InternalConfig.g:5042:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__KeyValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__KeyValue__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5049:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5053:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // InternalConfig.g:5054:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // InternalConfig.g:5054:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // InternalConfig.g:5055:1: ( rule__KeyValue__KeyAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            }
            // InternalConfig.g:5056:1: ( rule__KeyValue__KeyAssignment_0 )
            // InternalConfig.g:5056:2: rule__KeyValue__KeyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__KeyValue__KeyAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5066:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5070:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // InternalConfig.g:5071:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
            {
            pushFollow(FOLLOW_32);
            rule__KeyValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__KeyValue__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5078:1: rule__KeyValue__Group__1__Impl : ( '=' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5082:1: ( ( '=' ) )
            // InternalConfig.g:5083:1: ( '=' )
            {
            // InternalConfig.g:5083:1: ( '=' )
            // InternalConfig.g:5084:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5097:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5101:1: ( rule__KeyValue__Group__2__Impl )
            // InternalConfig.g:5102:2: rule__KeyValue__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__KeyValue__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5108:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5112:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // InternalConfig.g:5113:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // InternalConfig.g:5113:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // InternalConfig.g:5114:1: ( rule__KeyValue__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            }
            // InternalConfig.g:5115:1: ( rule__KeyValue__ValueAssignment_2 )
            // InternalConfig.g:5115:2: rule__KeyValue__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__KeyValue__ValueAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5134:1: rule__SimpleAnnotationAttribute__Group__0 : rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 ;
    public final void rule__SimpleAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5138:1: ( rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 )
            // InternalConfig.g:5139:2: rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__SimpleAnnotationAttribute__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SimpleAnnotationAttribute__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5146:1: rule__SimpleAnnotationAttribute__Group__0__Impl : ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5150:1: ( ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) )
            // InternalConfig.g:5151:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            {
            // InternalConfig.g:5151:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            // InternalConfig.g:5152:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 
            }
            // InternalConfig.g:5153:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            // InternalConfig.g:5153:2: rule__SimpleAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleAnnotationAttribute__Alternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5163:1: rule__SimpleAnnotationAttribute__Group__1 : rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 ;
    public final void rule__SimpleAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5167:1: ( rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 )
            // InternalConfig.g:5168:2: rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__SimpleAnnotationAttribute__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SimpleAnnotationAttribute__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5175:1: rule__SimpleAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5179:1: ( ( 'attribute' ) )
            // InternalConfig.g:5180:1: ( 'attribute' )
            {
            // InternalConfig.g:5180:1: ( 'attribute' )
            // InternalConfig.g:5181:1: 'attribute'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5194:1: rule__SimpleAnnotationAttribute__Group__2 : rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 ;
    public final void rule__SimpleAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5198:1: ( rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 )
            // InternalConfig.g:5199:2: rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__SimpleAnnotationAttribute__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SimpleAnnotationAttribute__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5206:1: rule__SimpleAnnotationAttribute__Group__2__Impl : ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5210:1: ( ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) )
            // InternalConfig.g:5211:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            {
            // InternalConfig.g:5211:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            // InternalConfig.g:5212:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 
            }
            // InternalConfig.g:5213:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            // InternalConfig.g:5213:2: rule__SimpleAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__SimpleAnnotationAttribute__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5223:1: rule__SimpleAnnotationAttribute__Group__3 : rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 ;
    public final void rule__SimpleAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5227:1: ( rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 )
            // InternalConfig.g:5228:2: rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_34);
            rule__SimpleAnnotationAttribute__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SimpleAnnotationAttribute__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5235:1: rule__SimpleAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5239:1: ( ( ':' ) )
            // InternalConfig.g:5240:1: ( ':' )
            {
            // InternalConfig.g:5240:1: ( ':' )
            // InternalConfig.g:5241:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5254:1: rule__SimpleAnnotationAttribute__Group__4 : rule__SimpleAnnotationAttribute__Group__4__Impl ;
    public final void rule__SimpleAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5258:1: ( rule__SimpleAnnotationAttribute__Group__4__Impl )
            // InternalConfig.g:5259:2: rule__SimpleAnnotationAttribute__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleAnnotationAttribute__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5265:1: rule__SimpleAnnotationAttribute__Group__4__Impl : ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5269:1: ( ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) )
            // InternalConfig.g:5270:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            {
            // InternalConfig.g:5270:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            // InternalConfig.g:5271:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 
            }
            // InternalConfig.g:5272:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            // InternalConfig.g:5272:2: rule__SimpleAnnotationAttribute__TypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__SimpleAnnotationAttribute__TypeAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5292:1: rule__EnumAnnotationAttribute__Group__0 : rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 ;
    public final void rule__EnumAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5296:1: ( rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 )
            // InternalConfig.g:5297:2: rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__EnumAnnotationAttribute__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5304:1: rule__EnumAnnotationAttribute__Group__0__Impl : ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5308:1: ( ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) )
            // InternalConfig.g:5309:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            {
            // InternalConfig.g:5309:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            // InternalConfig.g:5310:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 
            }
            // InternalConfig.g:5311:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            // InternalConfig.g:5311:2: rule__EnumAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__Alternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5321:1: rule__EnumAnnotationAttribute__Group__1 : rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 ;
    public final void rule__EnumAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5325:1: ( rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 )
            // InternalConfig.g:5326:2: rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__EnumAnnotationAttribute__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5333:1: rule__EnumAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__EnumAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5337:1: ( ( 'attribute' ) )
            // InternalConfig.g:5338:1: ( 'attribute' )
            {
            // InternalConfig.g:5338:1: ( 'attribute' )
            // InternalConfig.g:5339:1: 'attribute'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5352:1: rule__EnumAnnotationAttribute__Group__2 : rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 ;
    public final void rule__EnumAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5356:1: ( rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 )
            // InternalConfig.g:5357:2: rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__EnumAnnotationAttribute__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5364:1: rule__EnumAnnotationAttribute__Group__2__Impl : ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5368:1: ( ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) )
            // InternalConfig.g:5369:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            {
            // InternalConfig.g:5369:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            // InternalConfig.g:5370:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 
            }
            // InternalConfig.g:5371:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            // InternalConfig.g:5371:2: rule__EnumAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5381:1: rule__EnumAnnotationAttribute__Group__3 : rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 ;
    public final void rule__EnumAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5385:1: ( rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 )
            // InternalConfig.g:5386:2: rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__EnumAnnotationAttribute__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5393:1: rule__EnumAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5397:1: ( ( ':' ) )
            // InternalConfig.g:5398:1: ( ':' )
            {
            // InternalConfig.g:5398:1: ( ':' )
            // InternalConfig.g:5399:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5412:1: rule__EnumAnnotationAttribute__Group__4 : rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 ;
    public final void rule__EnumAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5416:1: ( rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 )
            // InternalConfig.g:5417:2: rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__EnumAnnotationAttribute__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5424:1: rule__EnumAnnotationAttribute__Group__4__Impl : ( '{' ) ;
    public final void rule__EnumAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5428:1: ( ( '{' ) )
            // InternalConfig.g:5429:1: ( '{' )
            {
            // InternalConfig.g:5429:1: ( '{' )
            // InternalConfig.g:5430:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5443:1: rule__EnumAnnotationAttribute__Group__5 : rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 ;
    public final void rule__EnumAnnotationAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5447:1: ( rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 )
            // InternalConfig.g:5448:2: rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6
            {
            pushFollow(FOLLOW_35);
            rule__EnumAnnotationAttribute__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5455:1: rule__EnumAnnotationAttribute__Group__5__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5459:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) )
            // InternalConfig.g:5460:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            {
            // InternalConfig.g:5460:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            // InternalConfig.g:5461:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 
            }
            // InternalConfig.g:5462:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            // InternalConfig.g:5462:2: rule__EnumAnnotationAttribute__ValuesAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__ValuesAssignment_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5472:1: rule__EnumAnnotationAttribute__Group__6 : rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 ;
    public final void rule__EnumAnnotationAttribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5476:1: ( rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 )
            // InternalConfig.g:5477:2: rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7
            {
            pushFollow(FOLLOW_35);
            rule__EnumAnnotationAttribute__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5484:1: rule__EnumAnnotationAttribute__Group__6__Impl : ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) ;
    public final void rule__EnumAnnotationAttribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5488:1: ( ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) )
            // InternalConfig.g:5489:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            {
            // InternalConfig.g:5489:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            // InternalConfig.g:5490:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 
            }
            // InternalConfig.g:5491:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==46) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalConfig.g:5491:2: rule__EnumAnnotationAttribute__Group_6__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__EnumAnnotationAttribute__Group_6__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5501:1: rule__EnumAnnotationAttribute__Group__7 : rule__EnumAnnotationAttribute__Group__7__Impl ;
    public final void rule__EnumAnnotationAttribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5505:1: ( rule__EnumAnnotationAttribute__Group__7__Impl )
            // InternalConfig.g:5506:2: rule__EnumAnnotationAttribute__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5512:1: rule__EnumAnnotationAttribute__Group__7__Impl : ( '}' ) ;
    public final void rule__EnumAnnotationAttribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5516:1: ( ( '}' ) )
            // InternalConfig.g:5517:1: ( '}' )
            {
            // InternalConfig.g:5517:1: ( '}' )
            // InternalConfig.g:5518:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5547:1: rule__EnumAnnotationAttribute__Group_6__0 : rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 ;
    public final void rule__EnumAnnotationAttribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5551:1: ( rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 )
            // InternalConfig.g:5552:2: rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1
            {
            pushFollow(FOLLOW_12);
            rule__EnumAnnotationAttribute__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5559:1: rule__EnumAnnotationAttribute__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5563:1: ( ( ',' ) )
            // InternalConfig.g:5564:1: ( ',' )
            {
            // InternalConfig.g:5564:1: ( ',' )
            // InternalConfig.g:5565:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0()); 
            }
            match(input,46,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5578:1: rule__EnumAnnotationAttribute__Group_6__1 : rule__EnumAnnotationAttribute__Group_6__1__Impl ;
    public final void rule__EnumAnnotationAttribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5582:1: ( rule__EnumAnnotationAttribute__Group_6__1__Impl )
            // InternalConfig.g:5583:2: rule__EnumAnnotationAttribute__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5589:1: rule__EnumAnnotationAttribute__Group_6__1__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5593:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) )
            // InternalConfig.g:5594:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            {
            // InternalConfig.g:5594:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            // InternalConfig.g:5595:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 
            }
            // InternalConfig.g:5596:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            // InternalConfig.g:5596:2: rule__EnumAnnotationAttribute__ValuesAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__EnumAnnotationAttribute__ValuesAssignment_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__Import__Group__0"
    // InternalConfig.g:5610:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5614:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalConfig.g:5615:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__Import__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:5622:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5626:1: ( ( 'import' ) )
            // InternalConfig.g:5627:1: ( 'import' )
            {
            // InternalConfig.g:5627:1: ( 'import' )
            // InternalConfig.g:5628:1: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:5641:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5645:1: ( rule__Import__Group__1__Impl )
            // InternalConfig.g:5646:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5652:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5656:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // InternalConfig.g:5657:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // InternalConfig.g:5657:1: ( ( rule__Import__Alternatives_1 ) )
            // InternalConfig.g:5658:1: ( rule__Import__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getAlternatives_1()); 
            }
            // InternalConfig.g:5659:1: ( rule__Import__Alternatives_1 )
            // InternalConfig.g:5659:2: rule__Import__Alternatives_1
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__Import__Group_1_0__0"
    // InternalConfig.g:5673:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5677:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // InternalConfig.g:5678:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
            {
            pushFollow(FOLLOW_37);
            rule__Import__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:5685:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5689:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // InternalConfig.g:5690:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // InternalConfig.g:5690:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // InternalConfig.g:5691:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            }
            // InternalConfig.g:5692:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // InternalConfig.g:5692:2: rule__Import__ImportedNamespaceAssignment_1_0_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:5702:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5706:1: ( rule__Import__Group_1_0__1__Impl )
            // InternalConfig.g:5707:2: rule__Import__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:5713:1: rule__Import__Group_1_0__1__Impl : ( ( rule__Import__Group_1_0_1__0 )? ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5717:1: ( ( ( rule__Import__Group_1_0_1__0 )? ) )
            // InternalConfig.g:5718:1: ( ( rule__Import__Group_1_0_1__0 )? )
            {
            // InternalConfig.g:5718:1: ( ( rule__Import__Group_1_0_1__0 )? )
            // InternalConfig.g:5719:1: ( rule__Import__Group_1_0_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getGroup_1_0_1()); 
            }
            // InternalConfig.g:5720:1: ( rule__Import__Group_1_0_1__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==51) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalConfig.g:5720:2: rule__Import__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Import__Group_1_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getGroup_1_0_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__Import__Group_1_0_1__0"
    // InternalConfig.g:5734:1: rule__Import__Group_1_0_1__0 : rule__Import__Group_1_0_1__0__Impl rule__Import__Group_1_0_1__1 ;
    public final void rule__Import__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5738:1: ( rule__Import__Group_1_0_1__0__Impl rule__Import__Group_1_0_1__1 )
            // InternalConfig.g:5739:2: rule__Import__Group_1_0_1__0__Impl rule__Import__Group_1_0_1__1
            {
            pushFollow(FOLLOW_12);
            rule__Import__Group_1_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Import__Group_1_0_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_1_0_1__0"


    // $ANTLR start "rule__Import__Group_1_0_1__0__Impl"
    // InternalConfig.g:5746:1: rule__Import__Group_1_0_1__0__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5750:1: ( ( 'from' ) )
            // InternalConfig.g:5751:1: ( 'from' )
            {
            // InternalConfig.g:5751:1: ( 'from' )
            // InternalConfig.g:5752:1: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getFromKeyword_1_0_1_0()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getFromKeyword_1_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__Import__Group_1_0_1__1"
    // InternalConfig.g:5765:1: rule__Import__Group_1_0_1__1 : rule__Import__Group_1_0_1__1__Impl ;
    public final void rule__Import__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5769:1: ( rule__Import__Group_1_0_1__1__Impl )
            // InternalConfig.g:5770:2: rule__Import__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group_1_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_1_0_1__1"


    // $ANTLR start "rule__Import__Group_1_0_1__1__Impl"
    // InternalConfig.g:5776:1: rule__Import__Group_1_0_1__1__Impl : ( ( rule__Import__ImportURIAssignment_1_0_1_1 ) ) ;
    public final void rule__Import__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5780:1: ( ( ( rule__Import__ImportURIAssignment_1_0_1_1 ) ) )
            // InternalConfig.g:5781:1: ( ( rule__Import__ImportURIAssignment_1_0_1_1 ) )
            {
            // InternalConfig.g:5781:1: ( ( rule__Import__ImportURIAssignment_1_0_1_1 ) )
            // InternalConfig.g:5782:1: ( rule__Import__ImportURIAssignment_1_0_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportURIAssignment_1_0_1_1()); 
            }
            // InternalConfig.g:5783:1: ( rule__Import__ImportURIAssignment_1_0_1_1 )
            // InternalConfig.g:5783:2: rule__Import__ImportURIAssignment_1_0_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ImportURIAssignment_1_0_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportURIAssignment_1_0_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__Import__Group_1_1__0"
    // InternalConfig.g:5797:1: rule__Import__Group_1_1__0 : rule__Import__Group_1_1__0__Impl rule__Import__Group_1_1__1 ;
    public final void rule__Import__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5801:1: ( rule__Import__Group_1_1__0__Impl rule__Import__Group_1_1__1 )
            // InternalConfig.g:5802:2: rule__Import__Group_1_1__0__Impl rule__Import__Group_1_1__1
            {
            pushFollow(FOLLOW_12);
            rule__Import__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Import__Group_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_1_1__0"


    // $ANTLR start "rule__Import__Group_1_1__0__Impl"
    // InternalConfig.g:5809:1: rule__Import__Group_1_1__0__Impl : ( 'model' ) ;
    public final void rule__Import__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5813:1: ( ( 'model' ) )
            // InternalConfig.g:5814:1: ( 'model' )
            {
            // InternalConfig.g:5814:1: ( 'model' )
            // InternalConfig.g:5815:1: 'model'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getModelKeyword_1_1_0()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getModelKeyword_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_1_1__0__Impl"


    // $ANTLR start "rule__Import__Group_1_1__1"
    // InternalConfig.g:5828:1: rule__Import__Group_1_1__1 : rule__Import__Group_1_1__1__Impl ;
    public final void rule__Import__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5832:1: ( rule__Import__Group_1_1__1__Impl )
            // InternalConfig.g:5833:2: rule__Import__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_1_1__1"


    // $ANTLR start "rule__Import__Group_1_1__1__Impl"
    // InternalConfig.g:5839:1: rule__Import__Group_1_1__1__Impl : ( ( rule__Import__ImportURIAssignment_1_1_1 ) ) ;
    public final void rule__Import__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5843:1: ( ( ( rule__Import__ImportURIAssignment_1_1_1 ) ) )
            // InternalConfig.g:5844:1: ( ( rule__Import__ImportURIAssignment_1_1_1 ) )
            {
            // InternalConfig.g:5844:1: ( ( rule__Import__ImportURIAssignment_1_1_1 ) )
            // InternalConfig.g:5845:1: ( rule__Import__ImportURIAssignment_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportURIAssignment_1_1_1()); 
            }
            // InternalConfig.g:5846:1: ( rule__Import__ImportURIAssignment_1_1_1 )
            // InternalConfig.g:5846:2: rule__Import__ImportURIAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ImportURIAssignment_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportURIAssignment_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_1_1__1__Impl"


    // $ANTLR start "rule__ImportedFQN__Group__0"
    // InternalConfig.g:5860:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5864:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // InternalConfig.g:5865:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_38);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:5872:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5876:1: ( ( ruleFQN ) )
            // InternalConfig.g:5877:1: ( ruleFQN )
            {
            // InternalConfig.g:5877:1: ( ruleFQN )
            // InternalConfig.g:5878:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:5889:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5893:1: ( rule__ImportedFQN__Group__1__Impl )
            // InternalConfig.g:5894:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:5900:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5904:1: ( ( ( '.*' )? ) )
            // InternalConfig.g:5905:1: ( ( '.*' )? )
            {
            // InternalConfig.g:5905:1: ( ( '.*' )? )
            // InternalConfig.g:5906:1: ( '.*' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            }
            // InternalConfig.g:5907:1: ( '.*' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==53) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalConfig.g:5908:2: '.*'
                    {
                    match(input,53,FOLLOW_2); if (state.failed) return ;

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


    // $ANTLR start "rule__Documentation__Group__0"
    // InternalConfig.g:5923:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5927:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // InternalConfig.g:5928:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__Documentation__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Documentation__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5935:1: rule__Documentation__Group__0__Impl : ( () ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5939:1: ( ( () ) )
            // InternalConfig.g:5940:1: ( () )
            {
            // InternalConfig.g:5940:1: ( () )
            // InternalConfig.g:5941:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 
            }
            // InternalConfig.g:5942:1: ()
            // InternalConfig.g:5944:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 
            }

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
    // InternalConfig.g:5954:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5958:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // InternalConfig.g:5959:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
            {
            pushFollow(FOLLOW_40);
            rule__Documentation__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Documentation__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5966:1: rule__Documentation__Group__1__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5970:1: ( ( '[' ) )
            // InternalConfig.g:5971:1: ( '[' )
            {
            // InternalConfig.g:5971:1: ( '[' )
            // InternalConfig.g:5972:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1()); 
            }

            }


            }

        }
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
    // InternalConfig.g:5985:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl rule__Documentation__Group__3 ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:5989:1: ( rule__Documentation__Group__2__Impl rule__Documentation__Group__3 )
            // InternalConfig.g:5990:2: rule__Documentation__Group__2__Impl rule__Documentation__Group__3
            {
            pushFollow(FOLLOW_40);
            rule__Documentation__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Documentation__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:5997:1: rule__Documentation__Group__2__Impl : ( ( rule__Documentation__LinesAssignment_2 )* ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6001:1: ( ( ( rule__Documentation__LinesAssignment_2 )* ) )
            // InternalConfig.g:6002:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            {
            // InternalConfig.g:6002:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            // InternalConfig.g:6003:1: ( rule__Documentation__LinesAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 
            }
            // InternalConfig.g:6004:1: ( rule__Documentation__LinesAssignment_2 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_STRING) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalConfig.g:6004:2: rule__Documentation__LinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_41);
            	    rule__Documentation__LinesAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 
            }

            }


            }

        }
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
    // InternalConfig.g:6014:1: rule__Documentation__Group__3 : rule__Documentation__Group__3__Impl ;
    public final void rule__Documentation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6018:1: ( rule__Documentation__Group__3__Impl )
            // InternalConfig.g:6019:2: rule__Documentation__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Documentation__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalConfig.g:6025:1: rule__Documentation__Group__3__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6029:1: ( ( ']' ) )
            // InternalConfig.g:6030:1: ( ']' )
            {
            // InternalConfig.g:6030:1: ( ']' )
            // InternalConfig.g:6031:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__TIME__Group_0__0"
    // InternalConfig.g:6052:1: rule__TIME__Group_0__0 : rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1 ;
    public final void rule__TIME__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6056:1: ( rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1 )
            // InternalConfig.g:6057:2: rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1
            {
            pushFollow(FOLLOW_42);
            rule__TIME__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TIME__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_0__0"


    // $ANTLR start "rule__TIME__Group_0__0__Impl"
    // InternalConfig.g:6064:1: rule__TIME__Group_0__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6068:1: ( ( RULE_INT ) )
            // InternalConfig.g:6069:1: ( RULE_INT )
            {
            // InternalConfig.g:6069:1: ( RULE_INT )
            // InternalConfig.g:6070:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_0_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_0__0__Impl"


    // $ANTLR start "rule__TIME__Group_0__1"
    // InternalConfig.g:6081:1: rule__TIME__Group_0__1 : rule__TIME__Group_0__1__Impl ;
    public final void rule__TIME__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6085:1: ( rule__TIME__Group_0__1__Impl )
            // InternalConfig.g:6086:2: rule__TIME__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TIME__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_0__1"


    // $ANTLR start "rule__TIME__Group_0__1__Impl"
    // InternalConfig.g:6092:1: rule__TIME__Group_0__1__Impl : ( 's' ) ;
    public final void rule__TIME__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6096:1: ( ( 's' ) )
            // InternalConfig.g:6097:1: ( 's' )
            {
            // InternalConfig.g:6097:1: ( 's' )
            // InternalConfig.g:6098:1: 's'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTIMEAccess().getSKeyword_0_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTIMEAccess().getSKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_0__1__Impl"


    // $ANTLR start "rule__TIME__Group_1__0"
    // InternalConfig.g:6115:1: rule__TIME__Group_1__0 : rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1 ;
    public final void rule__TIME__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6119:1: ( rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1 )
            // InternalConfig.g:6120:2: rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1
            {
            pushFollow(FOLLOW_43);
            rule__TIME__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TIME__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_1__0"


    // $ANTLR start "rule__TIME__Group_1__0__Impl"
    // InternalConfig.g:6127:1: rule__TIME__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6131:1: ( ( RULE_INT ) )
            // InternalConfig.g:6132:1: ( RULE_INT )
            {
            // InternalConfig.g:6132:1: ( RULE_INT )
            // InternalConfig.g:6133:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_1__0__Impl"


    // $ANTLR start "rule__TIME__Group_1__1"
    // InternalConfig.g:6144:1: rule__TIME__Group_1__1 : rule__TIME__Group_1__1__Impl ;
    public final void rule__TIME__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6148:1: ( rule__TIME__Group_1__1__Impl )
            // InternalConfig.g:6149:2: rule__TIME__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TIME__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_1__1"


    // $ANTLR start "rule__TIME__Group_1__1__Impl"
    // InternalConfig.g:6155:1: rule__TIME__Group_1__1__Impl : ( 'ms' ) ;
    public final void rule__TIME__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6159:1: ( ( 'ms' ) )
            // InternalConfig.g:6160:1: ( 'ms' )
            {
            // InternalConfig.g:6160:1: ( 'ms' )
            // InternalConfig.g:6161:1: 'ms'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTIMEAccess().getMsKeyword_1_1()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTIMEAccess().getMsKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_1__1__Impl"


    // $ANTLR start "rule__TIME__Group_2__0"
    // InternalConfig.g:6178:1: rule__TIME__Group_2__0 : rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1 ;
    public final void rule__TIME__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6182:1: ( rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1 )
            // InternalConfig.g:6183:2: rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1
            {
            pushFollow(FOLLOW_44);
            rule__TIME__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TIME__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_2__0"


    // $ANTLR start "rule__TIME__Group_2__0__Impl"
    // InternalConfig.g:6190:1: rule__TIME__Group_2__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6194:1: ( ( RULE_INT ) )
            // InternalConfig.g:6195:1: ( RULE_INT )
            {
            // InternalConfig.g:6195:1: ( RULE_INT )
            // InternalConfig.g:6196:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_2_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_2__0__Impl"


    // $ANTLR start "rule__TIME__Group_2__1"
    // InternalConfig.g:6207:1: rule__TIME__Group_2__1 : rule__TIME__Group_2__1__Impl ;
    public final void rule__TIME__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6211:1: ( rule__TIME__Group_2__1__Impl )
            // InternalConfig.g:6212:2: rule__TIME__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TIME__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_2__1"


    // $ANTLR start "rule__TIME__Group_2__1__Impl"
    // InternalConfig.g:6218:1: rule__TIME__Group_2__1__Impl : ( 'us' ) ;
    public final void rule__TIME__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6222:1: ( ( 'us' ) )
            // InternalConfig.g:6223:1: ( 'us' )
            {
            // InternalConfig.g:6223:1: ( 'us' )
            // InternalConfig.g:6224:1: 'us'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTIMEAccess().getUsKeyword_2_1()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTIMEAccess().getUsKeyword_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_2__1__Impl"


    // $ANTLR start "rule__TIME__Group_3__0"
    // InternalConfig.g:6241:1: rule__TIME__Group_3__0 : rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1 ;
    public final void rule__TIME__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6245:1: ( rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1 )
            // InternalConfig.g:6246:2: rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1
            {
            pushFollow(FOLLOW_45);
            rule__TIME__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TIME__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_3__0"


    // $ANTLR start "rule__TIME__Group_3__0__Impl"
    // InternalConfig.g:6253:1: rule__TIME__Group_3__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6257:1: ( ( RULE_INT ) )
            // InternalConfig.g:6258:1: ( RULE_INT )
            {
            // InternalConfig.g:6258:1: ( RULE_INT )
            // InternalConfig.g:6259:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_3_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_3__0__Impl"


    // $ANTLR start "rule__TIME__Group_3__1"
    // InternalConfig.g:6270:1: rule__TIME__Group_3__1 : rule__TIME__Group_3__1__Impl ;
    public final void rule__TIME__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6274:1: ( rule__TIME__Group_3__1__Impl )
            // InternalConfig.g:6275:2: rule__TIME__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TIME__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_3__1"


    // $ANTLR start "rule__TIME__Group_3__1__Impl"
    // InternalConfig.g:6281:1: rule__TIME__Group_3__1__Impl : ( 'ns' ) ;
    public final void rule__TIME__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6285:1: ( ( 'ns' ) )
            // InternalConfig.g:6286:1: ( 'ns' )
            {
            // InternalConfig.g:6286:1: ( 'ns' )
            // InternalConfig.g:6287:1: 'ns'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTIMEAccess().getNsKeyword_3_1()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTIMEAccess().getNsKeyword_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_3__1__Impl"


    // $ANTLR start "rule__BooleanLiteral__Group__0"
    // InternalConfig.g:6306:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6310:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // InternalConfig.g:6311:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_46);
            rule__BooleanLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6318:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6322:1: ( ( () ) )
            // InternalConfig.g:6323:1: ( () )
            {
            // InternalConfig.g:6323:1: ( () )
            // InternalConfig.g:6324:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            }
            // InternalConfig.g:6325:1: ()
            // InternalConfig.g:6327:1: 
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
    // InternalConfig.g:6337:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6341:1: ( rule__BooleanLiteral__Group__1__Impl )
            // InternalConfig.g:6342:2: rule__BooleanLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6348:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6352:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // InternalConfig.g:6353:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // InternalConfig.g:6353:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // InternalConfig.g:6354:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            }
            // InternalConfig.g:6355:1: ( rule__BooleanLiteral__Alternatives_1 )
            // InternalConfig.g:6355:2: rule__BooleanLiteral__Alternatives_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6369:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6373:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // InternalConfig.g:6374:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6381:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6385:1: ( ( () ) )
            // InternalConfig.g:6386:1: ( () )
            {
            // InternalConfig.g:6386:1: ( () )
            // InternalConfig.g:6387:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            }
            // InternalConfig.g:6388:1: ()
            // InternalConfig.g:6390:1: 
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
    // InternalConfig.g:6400:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6404:1: ( rule__RealLiteral__Group__1__Impl )
            // InternalConfig.g:6405:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6411:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6415:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // InternalConfig.g:6416:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // InternalConfig.g:6416:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // InternalConfig.g:6417:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            }
            // InternalConfig.g:6418:1: ( rule__RealLiteral__ValueAssignment_1 )
            // InternalConfig.g:6418:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6432:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6436:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // InternalConfig.g:6437:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6444:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6448:1: ( ( () ) )
            // InternalConfig.g:6449:1: ( () )
            {
            // InternalConfig.g:6449:1: ( () )
            // InternalConfig.g:6450:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            }
            // InternalConfig.g:6451:1: ()
            // InternalConfig.g:6453:1: 
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
    // InternalConfig.g:6463:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6467:1: ( rule__IntLiteral__Group__1__Impl )
            // InternalConfig.g:6468:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6474:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6478:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // InternalConfig.g:6479:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // InternalConfig.g:6479:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // InternalConfig.g:6480:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            }
            // InternalConfig.g:6481:1: ( rule__IntLiteral__ValueAssignment_1 )
            // InternalConfig.g:6481:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6495:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6499:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // InternalConfig.g:6500:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6507:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6511:1: ( ( () ) )
            // InternalConfig.g:6512:1: ( () )
            {
            // InternalConfig.g:6512:1: ( () )
            // InternalConfig.g:6513:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            }
            // InternalConfig.g:6514:1: ()
            // InternalConfig.g:6516:1: 
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
    // InternalConfig.g:6526:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6530:1: ( rule__StringLiteral__Group__1__Impl )
            // InternalConfig.g:6531:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6537:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6541:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // InternalConfig.g:6542:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // InternalConfig.g:6542:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // InternalConfig.g:6543:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            }
            // InternalConfig.g:6544:1: ( rule__StringLiteral__ValueAssignment_1 )
            // InternalConfig.g:6544:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__Integer__Group_0__0"
    // InternalConfig.g:6558:1: rule__Integer__Group_0__0 : rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1 ;
    public final void rule__Integer__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6562:1: ( rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1 )
            // InternalConfig.g:6563:2: rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1
            {
            pushFollow(FOLLOW_47);
            rule__Integer__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Integer__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integer__Group_0__0"


    // $ANTLR start "rule__Integer__Group_0__0__Impl"
    // InternalConfig.g:6570:1: rule__Integer__Group_0__0__Impl : ( ( rule__Integer__Alternatives_0_0 )? ) ;
    public final void rule__Integer__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6574:1: ( ( ( rule__Integer__Alternatives_0_0 )? ) )
            // InternalConfig.g:6575:1: ( ( rule__Integer__Alternatives_0_0 )? )
            {
            // InternalConfig.g:6575:1: ( ( rule__Integer__Alternatives_0_0 )? )
            // InternalConfig.g:6576:1: ( rule__Integer__Alternatives_0_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerAccess().getAlternatives_0_0()); 
            }
            // InternalConfig.g:6577:1: ( rule__Integer__Alternatives_0_0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=18 && LA43_0<=19)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalConfig.g:6577:2: rule__Integer__Alternatives_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Integer__Alternatives_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerAccess().getAlternatives_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integer__Group_0__0__Impl"


    // $ANTLR start "rule__Integer__Group_0__1"
    // InternalConfig.g:6587:1: rule__Integer__Group_0__1 : rule__Integer__Group_0__1__Impl ;
    public final void rule__Integer__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6591:1: ( rule__Integer__Group_0__1__Impl )
            // InternalConfig.g:6592:2: rule__Integer__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Integer__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integer__Group_0__1"


    // $ANTLR start "rule__Integer__Group_0__1__Impl"
    // InternalConfig.g:6598:1: rule__Integer__Group_0__1__Impl : ( RULE_INT ) ;
    public final void rule__Integer__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6602:1: ( ( RULE_INT ) )
            // InternalConfig.g:6603:1: ( RULE_INT )
            {
            // InternalConfig.g:6603:1: ( RULE_INT )
            // InternalConfig.g:6604:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerAccess().getINTTerminalRuleCall_0_1()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerAccess().getINTTerminalRuleCall_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integer__Group_0__1__Impl"


    // $ANTLR start "rule__Decimal__Group__0"
    // InternalConfig.g:6619:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6623:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // InternalConfig.g:6624:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_47);
            rule__Decimal__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6631:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6635:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // InternalConfig.g:6636:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // InternalConfig.g:6636:1: ( ( rule__Decimal__Alternatives_0 )? )
            // InternalConfig.g:6637:1: ( rule__Decimal__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            }
            // InternalConfig.g:6638:1: ( rule__Decimal__Alternatives_0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=18 && LA44_0<=19)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalConfig.g:6638:2: rule__Decimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6648:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6652:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // InternalConfig.g:6653:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_29);
            rule__Decimal__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6660:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6664:1: ( ( RULE_INT ) )
            // InternalConfig.g:6665:1: ( RULE_INT )
            {
            // InternalConfig.g:6665:1: ( RULE_INT )
            // InternalConfig.g:6666:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:6677:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6681:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // InternalConfig.g:6682:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__Decimal__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6689:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6693:1: ( ( '.' ) )
            // InternalConfig.g:6694:1: ( '.' )
            {
            // InternalConfig.g:6694:1: ( '.' )
            // InternalConfig.g:6695:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:6708:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6712:1: ( rule__Decimal__Group__3__Impl )
            // InternalConfig.g:6713:2: rule__Decimal__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6719:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6723:1: ( ( RULE_INT ) )
            // InternalConfig.g:6724:1: ( RULE_INT )
            {
            // InternalConfig.g:6724:1: ( RULE_INT )
            // InternalConfig.g:6725:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__DecimalExp__Group__0"
    // InternalConfig.g:6744:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6748:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // InternalConfig.g:6749:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__DecimalExp__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6756:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6760:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // InternalConfig.g:6761:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // InternalConfig.g:6761:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // InternalConfig.g:6762:1: ( rule__DecimalExp__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            }
            // InternalConfig.g:6763:1: ( rule__DecimalExp__Alternatives_0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=18 && LA45_0<=19)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalConfig.g:6763:2: rule__DecimalExp__Alternatives_0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6773:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6777:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // InternalConfig.g:6778:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
            {
            pushFollow(FOLLOW_29);
            rule__DecimalExp__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6785:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6789:1: ( ( RULE_INT ) )
            // InternalConfig.g:6790:1: ( RULE_INT )
            {
            // InternalConfig.g:6790:1: ( RULE_INT )
            // InternalConfig.g:6791:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:6802:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6806:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // InternalConfig.g:6807:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__DecimalExp__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6814:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6818:1: ( ( '.' ) )
            // InternalConfig.g:6819:1: ( '.' )
            {
            // InternalConfig.g:6819:1: ( '.' )
            // InternalConfig.g:6820:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:6833:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6837:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // InternalConfig.g:6838:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
            {
            pushFollow(FOLLOW_48);
            rule__DecimalExp__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6845:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6849:1: ( ( RULE_INT ) )
            // InternalConfig.g:6850:1: ( RULE_INT )
            {
            // InternalConfig.g:6850:1: ( RULE_INT )
            // InternalConfig.g:6851:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:6862:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5 ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6866:1: ( rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5 )
            // InternalConfig.g:6867:2: rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5
            {
            pushFollow(FOLLOW_47);
            rule__DecimalExp__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6874:1: rule__DecimalExp__Group__4__Impl : ( ( rule__DecimalExp__Alternatives_4 ) ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6878:1: ( ( ( rule__DecimalExp__Alternatives_4 ) ) )
            // InternalConfig.g:6879:1: ( ( rule__DecimalExp__Alternatives_4 ) )
            {
            // InternalConfig.g:6879:1: ( ( rule__DecimalExp__Alternatives_4 ) )
            // InternalConfig.g:6880:1: ( rule__DecimalExp__Alternatives_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getAlternatives_4()); 
            }
            // InternalConfig.g:6881:1: ( rule__DecimalExp__Alternatives_4 )
            // InternalConfig.g:6881:2: rule__DecimalExp__Alternatives_4
            {
            pushFollow(FOLLOW_2);
            rule__DecimalExp__Alternatives_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalExpAccess().getAlternatives_4()); 
            }

            }


            }

        }
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
    // InternalConfig.g:6891:1: rule__DecimalExp__Group__5 : rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6 ;
    public final void rule__DecimalExp__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6895:1: ( rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6 )
            // InternalConfig.g:6896:2: rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6
            {
            pushFollow(FOLLOW_47);
            rule__DecimalExp__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6903:1: rule__DecimalExp__Group__5__Impl : ( ( rule__DecimalExp__Alternatives_5 )? ) ;
    public final void rule__DecimalExp__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6907:1: ( ( ( rule__DecimalExp__Alternatives_5 )? ) )
            // InternalConfig.g:6908:1: ( ( rule__DecimalExp__Alternatives_5 )? )
            {
            // InternalConfig.g:6908:1: ( ( rule__DecimalExp__Alternatives_5 )? )
            // InternalConfig.g:6909:1: ( rule__DecimalExp__Alternatives_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getAlternatives_5()); 
            }
            // InternalConfig.g:6910:1: ( rule__DecimalExp__Alternatives_5 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=18 && LA46_0<=19)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalConfig.g:6910:2: rule__DecimalExp__Alternatives_5
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6920:1: rule__DecimalExp__Group__6 : rule__DecimalExp__Group__6__Impl ;
    public final void rule__DecimalExp__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6924:1: ( rule__DecimalExp__Group__6__Impl )
            // InternalConfig.g:6925:2: rule__DecimalExp__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6931:1: rule__DecimalExp__Group__6__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6935:1: ( ( RULE_INT ) )
            // InternalConfig.g:6936:1: ( RULE_INT )
            {
            // InternalConfig.g:6936:1: ( RULE_INT )
            // InternalConfig.g:6937:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_6()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__FQN__Group__0"
    // InternalConfig.g:6962:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6966:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalConfig.g:6967:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__FQN__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:6974:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6978:1: ( ( RULE_ID ) )
            // InternalConfig.g:6979:1: ( RULE_ID )
            {
            // InternalConfig.g:6979:1: ( RULE_ID )
            // InternalConfig.g:6980:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:6991:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:6995:1: ( rule__FQN__Group__1__Impl )
            // InternalConfig.g:6996:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7002:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7006:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalConfig.g:7007:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalConfig.g:7007:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalConfig.g:7008:1: ( rule__FQN__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getGroup_1()); 
            }
            // InternalConfig.g:7009:1: ( rule__FQN__Group_1__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==47) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalConfig.g:7009:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_49);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop47;
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
    // InternalConfig.g:7023:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7027:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalConfig.g:7028:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7035:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7039:1: ( ( '.' ) )
            // InternalConfig.g:7040:1: ( '.' )
            {
            // InternalConfig.g:7040:1: ( '.' )
            // InternalConfig.g:7041:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:7054:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7058:1: ( rule__FQN__Group_1__1__Impl )
            // InternalConfig.g:7059:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7065:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7069:1: ( ( RULE_ID ) )
            // InternalConfig.g:7070:1: ( RULE_ID )
            {
            // InternalConfig.g:7070:1: ( RULE_ID )
            // InternalConfig.g:7071:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__DynamicConfig__UnorderedGroup_2"
    // InternalConfig.g:7087:1: rule__DynamicConfig__UnorderedGroup_2 : rule__DynamicConfig__UnorderedGroup_2__0 {...}?;
    public final void rule__DynamicConfig__UnorderedGroup_2() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2());
            
        try {
            // InternalConfig.g:7092:1: ( rule__DynamicConfig__UnorderedGroup_2__0 {...}?)
            // InternalConfig.g:7093:2: rule__DynamicConfig__UnorderedGroup_2__0 {...}?
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7104:1: rule__DynamicConfig__UnorderedGroup_2__Impl : ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) ) ;
    public final void rule__DynamicConfig__UnorderedGroup_2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // InternalConfig.g:7109:1: ( ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) ) )
            // InternalConfig.g:7110:3: ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) )
            {
            // InternalConfig.g:7110:3: ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( LA48_0 >= 32 && LA48_0 <= 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                alt48=1;
            }
            else if ( LA48_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalConfig.g:7112:4: ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) )
                    {
                    // InternalConfig.g:7112:4: ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) )
                    // InternalConfig.g:7113:5: {...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__DynamicConfig__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0)");
                    }
                    // InternalConfig.g:7113:110: ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) )
                    // InternalConfig.g:7114:6: ( ( rule__DynamicConfig__Alternatives_2_0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0);
                    selected = true;
                    // InternalConfig.g:7120:6: ( ( rule__DynamicConfig__Alternatives_2_0 ) )
                    // InternalConfig.g:7122:7: ( rule__DynamicConfig__Alternatives_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getAlternatives_2_0()); 
                    }
                    // InternalConfig.g:7123:7: ( rule__DynamicConfig__Alternatives_2_0 )
                    // InternalConfig.g:7123:8: rule__DynamicConfig__Alternatives_2_0
                    {
                    pushFollow(FOLLOW_2);
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
                    // InternalConfig.g:7129:4: ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) )
                    {
                    // InternalConfig.g:7129:4: ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) )
                    // InternalConfig.g:7130:5: {...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__DynamicConfig__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1)");
                    }
                    // InternalConfig.g:7130:110: ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) )
                    // InternalConfig.g:7131:6: ( ( rule__DynamicConfig__Group_2_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1);
                    selected = true;
                    // InternalConfig.g:7137:6: ( ( rule__DynamicConfig__Group_2_1__0 ) )
                    // InternalConfig.g:7139:7: ( rule__DynamicConfig__Group_2_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getGroup_2_1()); 
                    }
                    // InternalConfig.g:7140:7: ( rule__DynamicConfig__Group_2_1__0 )
                    // InternalConfig.g:7140:8: rule__DynamicConfig__Group_2_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7155:1: rule__DynamicConfig__UnorderedGroup_2__0 : rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )? ;
    public final void rule__DynamicConfig__UnorderedGroup_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7159:1: ( rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )? )
            // InternalConfig.g:7160:2: rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )?
            {
            pushFollow(FOLLOW_50);
            rule__DynamicConfig__UnorderedGroup_2__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalConfig.g:7161:2: ( rule__DynamicConfig__UnorderedGroup_2__1 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( LA49_0 >= 32 && LA49_0 <= 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                alt49=1;
            }
            else if ( LA49_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalConfig.g:7161:2: rule__DynamicConfig__UnorderedGroup_2__1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7168:1: rule__DynamicConfig__UnorderedGroup_2__1 : rule__DynamicConfig__UnorderedGroup_2__Impl ;
    public final void rule__DynamicConfig__UnorderedGroup_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7172:1: ( rule__DynamicConfig__UnorderedGroup_2__Impl )
            // InternalConfig.g:7173:2: rule__DynamicConfig__UnorderedGroup_2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7184:1: rule__ActorInstanceConfig__UnorderedGroup_7 : ( rule__ActorInstanceConfig__UnorderedGroup_7__0 )? ;
    public final void rule__ActorInstanceConfig__UnorderedGroup_7() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7());
            
        try {
            // InternalConfig.g:7189:1: ( ( rule__ActorInstanceConfig__UnorderedGroup_7__0 )? )
            // InternalConfig.g:7190:2: ( rule__ActorInstanceConfig__UnorderedGroup_7__0 )?
            {
            // InternalConfig.g:7190:2: ( rule__ActorInstanceConfig__UnorderedGroup_7__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( LA50_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0) ) {
                alt50=1;
            }
            else if ( LA50_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalConfig.g:7190:2: rule__ActorInstanceConfig__UnorderedGroup_7__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7200:1: rule__ActorInstanceConfig__UnorderedGroup_7__Impl : ( ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) ) ) ;
    public final void rule__ActorInstanceConfig__UnorderedGroup_7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // InternalConfig.g:7205:1: ( ( ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) ) ) )
            // InternalConfig.g:7206:3: ( ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) ) )
            {
            // InternalConfig.g:7206:3: ( ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( LA53_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0) ) {
                alt53=1;
            }
            else if ( LA53_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalConfig.g:7208:4: ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) )
                    {
                    // InternalConfig.g:7208:4: ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) )
                    // InternalConfig.g:7209:5: {...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ActorInstanceConfig__UnorderedGroup_7__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0)");
                    }
                    // InternalConfig.g:7209:116: ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) )
                    // InternalConfig.g:7210:6: ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0);
                    selected = true;
                    // InternalConfig.g:7216:6: ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) )
                    // InternalConfig.g:7217:6: ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* )
                    {
                    // InternalConfig.g:7217:6: ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) )
                    // InternalConfig.g:7218:7: ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_7_0()); 
                    }
                    // InternalConfig.g:7219:7: ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )
                    // InternalConfig.g:7219:8: rule__ActorInstanceConfig__AttributesAssignment_7_0
                    {
                    pushFollow(FOLLOW_16);
                    rule__ActorInstanceConfig__AttributesAssignment_7_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_7_0()); 
                    }

                    }

                    // InternalConfig.g:7222:6: ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* )
                    // InternalConfig.g:7223:7: ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_7_0()); 
                    }
                    // InternalConfig.g:7224:7: ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==42) ) {
                            int LA51_1 = input.LA(2);

                            if ( (LA51_1==RULE_ID) ) {
                                int LA51_3 = input.LA(3);

                                if ( (synpred1_InternalConfig()) ) {
                                    alt51=1;
                                }


                            }


                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalConfig.g:7224:8: ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0
                    	    {
                    	    pushFollow(FOLLOW_16);
                    	    rule__ActorInstanceConfig__AttributesAssignment_7_0();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop51;
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
                    // InternalConfig.g:7230:4: ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) )
                    {
                    // InternalConfig.g:7230:4: ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) )
                    // InternalConfig.g:7231:5: {...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ActorInstanceConfig__UnorderedGroup_7__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1)");
                    }
                    // InternalConfig.g:7231:116: ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) )
                    // InternalConfig.g:7232:6: ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1);
                    selected = true;
                    // InternalConfig.g:7238:6: ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) )
                    // InternalConfig.g:7239:6: ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* )
                    {
                    // InternalConfig.g:7239:6: ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) )
                    // InternalConfig.g:7240:7: ( rule__ActorInstanceConfig__PortsAssignment_7_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_7_1()); 
                    }
                    // InternalConfig.g:7241:7: ( rule__ActorInstanceConfig__PortsAssignment_7_1 )
                    // InternalConfig.g:7241:8: rule__ActorInstanceConfig__PortsAssignment_7_1
                    {
                    pushFollow(FOLLOW_51);
                    rule__ActorInstanceConfig__PortsAssignment_7_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_7_1()); 
                    }

                    }

                    // InternalConfig.g:7244:6: ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* )
                    // InternalConfig.g:7245:7: ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_7_1()); 
                    }
                    // InternalConfig.g:7246:7: ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==41) ) {
                            int LA52_2 = input.LA(2);

                            if ( (synpred2_InternalConfig()) ) {
                                alt52=1;
                            }


                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalConfig.g:7246:8: ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1
                    	    {
                    	    pushFollow(FOLLOW_51);
                    	    rule__ActorInstanceConfig__PortsAssignment_7_1();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop52;
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
    // InternalConfig.g:7261:1: rule__ActorInstanceConfig__UnorderedGroup_7__0 : rule__ActorInstanceConfig__UnorderedGroup_7__Impl ( rule__ActorInstanceConfig__UnorderedGroup_7__1 )? ;
    public final void rule__ActorInstanceConfig__UnorderedGroup_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7265:1: ( rule__ActorInstanceConfig__UnorderedGroup_7__Impl ( rule__ActorInstanceConfig__UnorderedGroup_7__1 )? )
            // InternalConfig.g:7266:2: rule__ActorInstanceConfig__UnorderedGroup_7__Impl ( rule__ActorInstanceConfig__UnorderedGroup_7__1 )?
            {
            pushFollow(FOLLOW_51);
            rule__ActorInstanceConfig__UnorderedGroup_7__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalConfig.g:7267:2: ( rule__ActorInstanceConfig__UnorderedGroup_7__1 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( LA54_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0) ) {
                alt54=1;
            }
            else if ( LA54_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalConfig.g:7267:2: rule__ActorInstanceConfig__UnorderedGroup_7__1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7274:1: rule__ActorInstanceConfig__UnorderedGroup_7__1 : rule__ActorInstanceConfig__UnorderedGroup_7__Impl ;
    public final void rule__ActorInstanceConfig__UnorderedGroup_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7278:1: ( rule__ActorInstanceConfig__UnorderedGroup_7__Impl )
            // InternalConfig.g:7279:2: rule__ActorInstanceConfig__UnorderedGroup_7__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7290:1: rule__ProtocolClassConfig__UnorderedGroup_3 : ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )? ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
            
        try {
            // InternalConfig.g:7295:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )? )
            // InternalConfig.g:7296:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )?
            {
            // InternalConfig.g:7296:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( LA55_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                alt55=1;
            }
            else if ( LA55_0 >= 13 && LA55_0 <= 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalConfig.g:7296:2: rule__ProtocolClassConfig__UnorderedGroup_3__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7306:1: rule__ProtocolClassConfig__UnorderedGroup_3__Impl : ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) ) ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // InternalConfig.g:7311:1: ( ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) ) )
            // InternalConfig.g:7312:3: ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) )
            {
            // InternalConfig.g:7312:3: ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( LA56_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                alt56=1;
            }
            else if ( LA56_0 >= 13 && LA56_0 <= 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalConfig.g:7314:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) )
                    {
                    // InternalConfig.g:7314:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) )
                    // InternalConfig.g:7315:5: {...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ProtocolClassConfig__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0)");
                    }
                    // InternalConfig.g:7315:116: ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) )
                    // InternalConfig.g:7316:6: ( ( rule__ProtocolClassConfig__Group_3_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0);
                    selected = true;
                    // InternalConfig.g:7322:6: ( ( rule__ProtocolClassConfig__Group_3_0__0 ) )
                    // InternalConfig.g:7324:7: ( rule__ProtocolClassConfig__Group_3_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProtocolClassConfigAccess().getGroup_3_0()); 
                    }
                    // InternalConfig.g:7325:7: ( rule__ProtocolClassConfig__Group_3_0__0 )
                    // InternalConfig.g:7325:8: rule__ProtocolClassConfig__Group_3_0__0
                    {
                    pushFollow(FOLLOW_2);
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
                    // InternalConfig.g:7331:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) )
                    {
                    // InternalConfig.g:7331:4: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) )
                    // InternalConfig.g:7332:5: {...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ProtocolClassConfig__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1)");
                    }
                    // InternalConfig.g:7332:116: ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) )
                    // InternalConfig.g:7333:6: ( ( rule__ProtocolClassConfig__Group_3_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1);
                    selected = true;
                    // InternalConfig.g:7339:6: ( ( rule__ProtocolClassConfig__Group_3_1__0 ) )
                    // InternalConfig.g:7341:7: ( rule__ProtocolClassConfig__Group_3_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProtocolClassConfigAccess().getGroup_3_1()); 
                    }
                    // InternalConfig.g:7342:7: ( rule__ProtocolClassConfig__Group_3_1__0 )
                    // InternalConfig.g:7342:8: rule__ProtocolClassConfig__Group_3_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7357:1: rule__ProtocolClassConfig__UnorderedGroup_3__0 : rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )? ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7361:1: ( rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )? )
            // InternalConfig.g:7362:2: rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )?
            {
            pushFollow(FOLLOW_52);
            rule__ProtocolClassConfig__UnorderedGroup_3__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalConfig.g:7363:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( LA57_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                alt57=1;
            }
            else if ( LA57_0 >= 13 && LA57_0 <= 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalConfig.g:7363:2: rule__ProtocolClassConfig__UnorderedGroup_3__1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7370:1: rule__ProtocolClassConfig__UnorderedGroup_3__1 : rule__ProtocolClassConfig__UnorderedGroup_3__Impl ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7374:1: ( rule__ProtocolClassConfig__UnorderedGroup_3__Impl )
            // InternalConfig.g:7375:2: rule__ProtocolClassConfig__UnorderedGroup_3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7386:1: rule__ConfigModel__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__ConfigModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7390:1: ( ( ruleFQN ) )
            // InternalConfig.g:7391:1: ( ruleFQN )
            {
            // InternalConfig.g:7391:1: ( ruleFQN )
            // InternalConfig.g:7392:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getNameFQNParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7401:1: rule__ConfigModel__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__ConfigModel__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7405:1: ( ( ruleImport ) )
            // InternalConfig.g:7406:1: ( ruleImport )
            {
            // InternalConfig.g:7406:1: ( ruleImport )
            // InternalConfig.g:7407:1: ruleImport
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getImportsImportParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7416:1: rule__ConfigModel__ConfigElementsAssignment_4 : ( ruleConfigElement ) ;
    public final void rule__ConfigModel__ConfigElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7420:1: ( ( ruleConfigElement ) )
            // InternalConfig.g:7421:1: ( ruleConfigElement )
            {
            // InternalConfig.g:7421:1: ( ruleConfigElement )
            // InternalConfig.g:7422:1: ruleConfigElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getConfigElementsConfigElementParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__SubSystemConfig__RootAssignment_1"
    // InternalConfig.g:7431:1: rule__SubSystemConfig__RootAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__SubSystemConfig__RootAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7435:1: ( ( ( ruleFQN ) ) )
            // InternalConfig.g:7436:1: ( ( ruleFQN ) )
            {
            // InternalConfig.g:7436:1: ( ( ruleFQN ) )
            // InternalConfig.g:7437:1: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getRootLogicalSystemCrossReference_1_0()); 
            }
            // InternalConfig.g:7438:1: ( ruleFQN )
            // InternalConfig.g:7439:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getRootLogicalSystemFQNParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getRootLogicalSystemFQNParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getRootLogicalSystemCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemConfig__RootAssignment_1"


    // $ANTLR start "rule__SubSystemConfig__SubSystemAssignment_3"
    // InternalConfig.g:7450:1: rule__SubSystemConfig__SubSystemAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemConfig__SubSystemAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7454:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:7455:1: ( ( RULE_ID ) )
            {
            // InternalConfig.g:7455:1: ( ( RULE_ID ) )
            // InternalConfig.g:7456:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemRefCrossReference_3_0()); 
            }
            // InternalConfig.g:7457:1: ( RULE_ID )
            // InternalConfig.g:7458:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemRefIDTerminalRuleCall_3_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemRefIDTerminalRuleCall_3_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemRefCrossReference_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemConfig__SubSystemAssignment_3"


    // $ANTLR start "rule__SubSystemConfig__DynConfigAssignment_5"
    // InternalConfig.g:7469:1: rule__SubSystemConfig__DynConfigAssignment_5 : ( ruleDynamicConfig ) ;
    public final void rule__SubSystemConfig__DynConfigAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7473:1: ( ( ruleDynamicConfig ) )
            // InternalConfig.g:7474:1: ( ruleDynamicConfig )
            {
            // InternalConfig.g:7474:1: ( ruleDynamicConfig )
            // InternalConfig.g:7475:1: ruleDynamicConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getDynConfigDynamicConfigParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDynamicConfig();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubSystemConfigAccess().getDynConfigDynamicConfigParserRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemConfig__DynConfigAssignment_5"


    // $ANTLR start "rule__DynamicConfig__FilePathAssignment_2_0_0_1"
    // InternalConfig.g:7484:1: rule__DynamicConfig__FilePathAssignment_2_0_0_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__FilePathAssignment_2_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7488:1: ( ( RULE_STRING ) )
            // InternalConfig.g:7489:1: ( RULE_STRING )
            {
            // InternalConfig.g:7489:1: ( RULE_STRING )
            // InternalConfig.g:7490:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getFilePathSTRINGTerminalRuleCall_2_0_0_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:7499:1: rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7503:1: ( ( RULE_STRING ) )
            // InternalConfig.g:7504:1: ( RULE_STRING )
            {
            // InternalConfig.g:7504:1: ( RULE_STRING )
            // InternalConfig.g:7505:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserCode1STRINGTerminalRuleCall_2_0_1_0_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:7514:1: rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7518:1: ( ( RULE_STRING ) )
            // InternalConfig.g:7519:1: ( RULE_STRING )
            {
            // InternalConfig.g:7519:1: ( RULE_STRING )
            // InternalConfig.g:7520:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserCode2STRINGTerminalRuleCall_2_0_1_1_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:7529:1: rule__DynamicConfig__PollingAssignment_2_1_1 : ( ruleTIME ) ;
    public final void rule__DynamicConfig__PollingAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7533:1: ( ( ruleTIME ) )
            // InternalConfig.g:7534:1: ( ruleTIME )
            {
            // InternalConfig.g:7534:1: ( ruleTIME )
            // InternalConfig.g:7535:1: ruleTIME
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getPollingTIMEParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTIME();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDynamicConfigAccess().getPollingTIMEParserRuleCall_2_1_1_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:7544:1: rule__ActorClassConfig__ActorAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ActorClassConfig__ActorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7548:1: ( ( ( ruleFQN ) ) )
            // InternalConfig.g:7549:1: ( ( ruleFQN ) )
            {
            // InternalConfig.g:7549:1: ( ( ruleFQN ) )
            // InternalConfig.g:7550:1: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorActorClassCrossReference_1_0()); 
            }
            // InternalConfig.g:7551:1: ( ruleFQN )
            // InternalConfig.g:7552:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorActorClassFQNParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7563:1: rule__ActorClassConfig__AttributesAssignment_3 : ( ruleAttrClassConfig ) ;
    public final void rule__ActorClassConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7567:1: ( ( ruleAttrClassConfig ) )
            // InternalConfig.g:7568:1: ( ruleAttrClassConfig )
            {
            // InternalConfig.g:7568:1: ( ruleAttrClassConfig )
            // InternalConfig.g:7569:1: ruleAttrClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7578:1: rule__ActorInstanceConfig__RootAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ActorInstanceConfig__RootAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7582:1: ( ( ( ruleFQN ) ) )
            // InternalConfig.g:7583:1: ( ( ruleFQN ) )
            {
            // InternalConfig.g:7583:1: ( ( ruleFQN ) )
            // InternalConfig.g:7584:1: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRootLogicalSystemCrossReference_1_0()); 
            }
            // InternalConfig.g:7585:1: ( ruleFQN )
            // InternalConfig.g:7586:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRootLogicalSystemFQNParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7597:1: rule__ActorInstanceConfig__SubSystemAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__ActorInstanceConfig__SubSystemAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7601:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:7602:1: ( ( RULE_ID ) )
            {
            // InternalConfig.g:7602:1: ( ( RULE_ID ) )
            // InternalConfig.g:7603:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getSubSystemSubSystemRefCrossReference_3_0()); 
            }
            // InternalConfig.g:7604:1: ( RULE_ID )
            // InternalConfig.g:7605:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getSubSystemSubSystemRefIDTerminalRuleCall_3_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActorInstanceConfigAccess().getSubSystemSubSystemRefIDTerminalRuleCall_3_0_1()); 
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
    // InternalConfig.g:7616:1: rule__ActorInstanceConfig__PathAssignment_5 : ( ruleRefPath ) ;
    public final void rule__ActorInstanceConfig__PathAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7620:1: ( ( ruleRefPath ) )
            // InternalConfig.g:7621:1: ( ruleRefPath )
            {
            // InternalConfig.g:7621:1: ( ruleRefPath )
            // InternalConfig.g:7622:1: ruleRefPath
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getPathRefPathParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7631:1: rule__ActorInstanceConfig__AttributesAssignment_7_0 : ( ruleAttrInstanceConfig ) ;
    public final void rule__ActorInstanceConfig__AttributesAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7635:1: ( ( ruleAttrInstanceConfig ) )
            // InternalConfig.g:7636:1: ( ruleAttrInstanceConfig )
            {
            // InternalConfig.g:7636:1: ( ruleAttrInstanceConfig )
            // InternalConfig.g:7637:1: ruleAttrInstanceConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_7_0_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7646:1: rule__ActorInstanceConfig__PortsAssignment_7_1 : ( rulePortInstanceConfig ) ;
    public final void rule__ActorInstanceConfig__PortsAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7650:1: ( ( rulePortInstanceConfig ) )
            // InternalConfig.g:7651:1: ( rulePortInstanceConfig )
            {
            // InternalConfig.g:7651:1: ( rulePortInstanceConfig )
            // InternalConfig.g:7652:1: rulePortInstanceConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getPortsPortInstanceConfigParserRuleCall_7_1_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7661:1: rule__ProtocolClassConfig__ProtocolAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ProtocolClassConfig__ProtocolAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7665:1: ( ( ( ruleFQN ) ) )
            // InternalConfig.g:7666:1: ( ( ruleFQN ) )
            {
            // InternalConfig.g:7666:1: ( ( ruleFQN ) )
            // InternalConfig.g:7667:1: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassCrossReference_1_0()); 
            }
            // InternalConfig.g:7668:1: ( ruleFQN )
            // InternalConfig.g:7669:1: ruleFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassFQNParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7680:1: rule__ProtocolClassConfig__RegularAssignment_3_0_1 : ( rulePortClassConfig ) ;
    public final void rule__ProtocolClassConfig__RegularAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7684:1: ( ( rulePortClassConfig ) )
            // InternalConfig.g:7685:1: ( rulePortClassConfig )
            {
            // InternalConfig.g:7685:1: ( rulePortClassConfig )
            // InternalConfig.g:7686:1: rulePortClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getRegularPortClassConfigParserRuleCall_3_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7695:1: rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 : ( rulePortClassConfig ) ;
    public final void rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7699:1: ( ( rulePortClassConfig ) )
            // InternalConfig.g:7700:1: ( rulePortClassConfig )
            {
            // InternalConfig.g:7700:1: ( rulePortClassConfig )
            // InternalConfig.g:7701:1: rulePortClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getConjugatedPortClassConfigParserRuleCall_3_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7710:1: rule__PortClassConfig__AttributesAssignment_3 : ( ruleAttrClassConfig ) ;
    public final void rule__PortClassConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7714:1: ( ( ruleAttrClassConfig ) )
            // InternalConfig.g:7715:1: ( ruleAttrClassConfig )
            {
            // InternalConfig.g:7715:1: ( ruleAttrClassConfig )
            // InternalConfig.g:7716:1: ruleAttrClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7725:1: rule__PortInstanceConfig__ItemAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PortInstanceConfig__ItemAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7729:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:7730:1: ( ( RULE_ID ) )
            {
            // InternalConfig.g:7730:1: ( ( RULE_ID ) )
            // InternalConfig.g:7731:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemCrossReference_1_0()); 
            }
            // InternalConfig.g:7732:1: ( RULE_ID )
            // InternalConfig.g:7733:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:7744:1: rule__PortInstanceConfig__AttributesAssignment_3 : ( ruleAttrInstanceConfig ) ;
    public final void rule__PortInstanceConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7748:1: ( ( ruleAttrInstanceConfig ) )
            // InternalConfig.g:7749:1: ( ruleAttrInstanceConfig )
            {
            // InternalConfig.g:7749:1: ( ruleAttrInstanceConfig )
            // InternalConfig.g:7750:1: ruleAttrInstanceConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7759:1: rule__AttrClassConfig__AttributeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AttrClassConfig__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7763:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:7764:1: ( ( RULE_ID ) )
            {
            // InternalConfig.g:7764:1: ( ( RULE_ID ) )
            // InternalConfig.g:7765:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            }
            // InternalConfig.g:7766:1: ( RULE_ID )
            // InternalConfig.g:7767:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:7778:1: rule__AttrClassConfig__ValueAssignment_2_1 : ( ruleConfigValueArray ) ;
    public final void rule__AttrClassConfig__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7782:1: ( ( ruleConfigValueArray ) )
            // InternalConfig.g:7783:1: ( ruleConfigValueArray )
            {
            // InternalConfig.g:7783:1: ( ruleConfigValueArray )
            // InternalConfig.g:7784:1: ruleConfigValueArray
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getValueConfigValueArrayParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConfigValueArray();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrClassConfigAccess().getValueConfigValueArrayParserRuleCall_2_1_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:7793:1: rule__AttrClassConfig__MinAssignment_3_1_0_2 : ( ruleNumberLiteral ) ;
    public final void rule__AttrClassConfig__MinAssignment_3_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7797:1: ( ( ruleNumberLiteral ) )
            // InternalConfig.g:7798:1: ( ruleNumberLiteral )
            {
            // InternalConfig.g:7798:1: ( ruleNumberLiteral )
            // InternalConfig.g:7799:1: ruleNumberLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMinNumberLiteralParserRuleCall_3_1_0_2_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7808:1: rule__AttrClassConfig__MaxAssignment_3_1_1_2 : ( ruleNumberLiteral ) ;
    public final void rule__AttrClassConfig__MaxAssignment_3_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7812:1: ( ( ruleNumberLiteral ) )
            // InternalConfig.g:7813:1: ( ruleNumberLiteral )
            {
            // InternalConfig.g:7813:1: ( ruleNumberLiteral )
            // InternalConfig.g:7814:1: ruleNumberLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMaxNumberLiteralParserRuleCall_3_1_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7823:1: rule__AttrClassConfig__AttributesAssignment_3_1_2 : ( ruleAttrClassConfig ) ;
    public final void rule__AttrClassConfig__AttributesAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7827:1: ( ( ruleAttrClassConfig ) )
            // InternalConfig.g:7828:1: ( ruleAttrClassConfig )
            {
            // InternalConfig.g:7828:1: ( ruleAttrClassConfig )
            // InternalConfig.g:7829:1: ruleAttrClassConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:7838:1: rule__AttrInstanceConfig__AttributeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AttrInstanceConfig__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7842:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:7843:1: ( ( RULE_ID ) )
            {
            // InternalConfig.g:7843:1: ( ( RULE_ID ) )
            // InternalConfig.g:7844:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            }
            // InternalConfig.g:7845:1: ( RULE_ID )
            // InternalConfig.g:7846:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:7857:1: rule__AttrInstanceConfig__ValueAssignment_2_1 : ( ruleConfigValueArray ) ;
    public final void rule__AttrInstanceConfig__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7861:1: ( ( ruleConfigValueArray ) )
            // InternalConfig.g:7862:1: ( ruleConfigValueArray )
            {
            // InternalConfig.g:7862:1: ( ruleConfigValueArray )
            // InternalConfig.g:7863:1: ruleConfigValueArray
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getValueConfigValueArrayParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConfigValueArray();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttrInstanceConfigAccess().getValueConfigValueArrayParserRuleCall_2_1_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:7872:1: rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 : ( ( 'dynamic configuration' ) ) ;
    public final void rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7876:1: ( ( ( 'dynamic configuration' ) ) )
            // InternalConfig.g:7877:1: ( ( 'dynamic configuration' ) )
            {
            // InternalConfig.g:7877:1: ( ( 'dynamic configuration' ) )
            // InternalConfig.g:7878:1: ( 'dynamic configuration' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0_0()); 
            }
            // InternalConfig.g:7879:1: ( 'dynamic configuration' )
            // InternalConfig.g:7880:1: 'dynamic configuration'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:7895:1: rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 : ( ( 'read' ) ) ;
    public final void rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7899:1: ( ( ( 'read' ) ) )
            // InternalConfig.g:7900:1: ( ( 'read' ) )
            {
            // InternalConfig.g:7900:1: ( ( 'read' ) )
            // InternalConfig.g:7901:1: ( 'read' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadKeyword_3_1_0_1_0_0()); 
            }
            // InternalConfig.g:7902:1: ( 'read' )
            // InternalConfig.g:7903:1: 'read'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadKeyword_3_1_0_1_0_0()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:7918:1: rule__AttrInstanceConfig__AttributesAssignment_3_1_1 : ( ruleAttrInstanceConfig ) ;
    public final void rule__AttrInstanceConfig__AttributesAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7922:1: ( ( ruleAttrInstanceConfig ) )
            // InternalConfig.g:7923:1: ( ruleAttrInstanceConfig )
            {
            // InternalConfig.g:7923:1: ( ruleAttrInstanceConfig )
            // InternalConfig.g:7924:1: ruleAttrInstanceConfig
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__ConfigValueArray__ValuesAssignment_0"
    // InternalConfig.g:7933:1: rule__ConfigValueArray__ValuesAssignment_0 : ( ruleConfigValue ) ;
    public final void rule__ConfigValueArray__ValuesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7937:1: ( ( ruleConfigValue ) )
            // InternalConfig.g:7938:1: ( ruleConfigValue )
            {
            // InternalConfig.g:7938:1: ( ruleConfigValue )
            // InternalConfig.g:7939:1: ruleConfigValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueArrayAccess().getValuesConfigValueParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConfigValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueArrayAccess().getValuesConfigValueParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigValueArray__ValuesAssignment_0"


    // $ANTLR start "rule__ConfigValueArray__ValuesAssignment_1_1"
    // InternalConfig.g:7948:1: rule__ConfigValueArray__ValuesAssignment_1_1 : ( ruleConfigValue ) ;
    public final void rule__ConfigValueArray__ValuesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7952:1: ( ( ruleConfigValue ) )
            // InternalConfig.g:7953:1: ( ruleConfigValue )
            {
            // InternalConfig.g:7953:1: ( ruleConfigValue )
            // InternalConfig.g:7954:1: ruleConfigValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueArrayAccess().getValuesConfigValueParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConfigValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConfigValueArrayAccess().getValuesConfigValueParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigValueArray__ValuesAssignment_1_1"


    // $ANTLR start "rule__LiteralConfigValue__ValueAssignment"
    // InternalConfig.g:7963:1: rule__LiteralConfigValue__ValueAssignment : ( ruleLiteral ) ;
    public final void rule__LiteralConfigValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7967:1: ( ( ruleLiteral ) )
            // InternalConfig.g:7968:1: ( ruleLiteral )
            {
            // InternalConfig.g:7968:1: ( ruleLiteral )
            // InternalConfig.g:7969:1: ruleLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralConfigValueAccess().getValueLiteralParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralConfigValueAccess().getValueLiteralParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralConfigValue__ValueAssignment"


    // $ANTLR start "rule__EnumConfigValue__TypeAssignment_0"
    // InternalConfig.g:7978:1: rule__EnumConfigValue__TypeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EnumConfigValue__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:7982:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:7983:1: ( ( RULE_ID ) )
            {
            // InternalConfig.g:7983:1: ( ( RULE_ID ) )
            // InternalConfig.g:7984:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueAccess().getTypeEnumerationTypeCrossReference_0_0()); 
            }
            // InternalConfig.g:7985:1: ( RULE_ID )
            // InternalConfig.g:7986:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueAccess().getTypeEnumerationTypeIDTerminalRuleCall_0_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumConfigValueAccess().getTypeEnumerationTypeIDTerminalRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumConfigValueAccess().getTypeEnumerationTypeCrossReference_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumConfigValue__TypeAssignment_0"


    // $ANTLR start "rule__EnumConfigValue__ValueAssignment_2"
    // InternalConfig.g:7997:1: rule__EnumConfigValue__ValueAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__EnumConfigValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8001:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:8002:1: ( ( RULE_ID ) )
            {
            // InternalConfig.g:8002:1: ( ( RULE_ID ) )
            // InternalConfig.g:8003:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueAccess().getValueEnumLiteralCrossReference_2_0()); 
            }
            // InternalConfig.g:8004:1: ( RULE_ID )
            // InternalConfig.g:8005:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueAccess().getValueEnumLiteralIDTerminalRuleCall_2_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumConfigValueAccess().getValueEnumLiteralIDTerminalRuleCall_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumConfigValueAccess().getValueEnumLiteralCrossReference_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumConfigValue__ValueAssignment_2"


    // $ANTLR start "rule__RefPath__RefsAssignment_0"
    // InternalConfig.g:8016:1: rule__RefPath__RefsAssignment_0 : ( ruleRefSegment ) ;
    public final void rule__RefPath__RefsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8020:1: ( ( ruleRefSegment ) )
            // InternalConfig.g:8021:1: ( ruleRefSegment )
            {
            // InternalConfig.g:8021:1: ( ruleRefSegment )
            // InternalConfig.g:8022:1: ruleRefSegment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRefSegment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:8031:1: rule__RefPath__RefsAssignment_1_1 : ( ruleRefSegment ) ;
    public final void rule__RefPath__RefsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8035:1: ( ( ruleRefSegment ) )
            // InternalConfig.g:8036:1: ( ruleRefSegment )
            {
            // InternalConfig.g:8036:1: ( ruleRefSegment )
            // InternalConfig.g:8037:1: ruleRefSegment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRefSegment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_1_1_0()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__RefSegment__RefAssignment_0"
    // InternalConfig.g:8046:1: rule__RefSegment__RefAssignment_0 : ( RULE_ID ) ;
    public final void rule__RefSegment__RefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8050:1: ( ( RULE_ID ) )
            // InternalConfig.g:8051:1: ( RULE_ID )
            {
            // InternalConfig.g:8051:1: ( RULE_ID )
            // InternalConfig.g:8052:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefSegmentAccess().getRefIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefSegmentAccess().getRefIDTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RefSegment__RefAssignment_0"


    // $ANTLR start "rule__RefSegment__IdxAssignment_1_1"
    // InternalConfig.g:8061:1: rule__RefSegment__IdxAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__RefSegment__IdxAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8065:1: ( ( RULE_INT ) )
            // InternalConfig.g:8066:1: ( RULE_INT )
            {
            // InternalConfig.g:8066:1: ( RULE_INT )
            // InternalConfig.g:8067:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefSegmentAccess().getIdxINTTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRefSegmentAccess().getIdxINTTerminalRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RefSegment__IdxAssignment_1_1"


    // $ANTLR start "rule__KeyValue__KeyAssignment_0"
    // InternalConfig.g:8079:1: rule__KeyValue__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8083:1: ( ( RULE_ID ) )
            // InternalConfig.g:8084:1: ( RULE_ID )
            {
            // InternalConfig.g:8084:1: ( RULE_ID )
            // InternalConfig.g:8085:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:8094:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8098:1: ( ( ruleLiteral ) )
            // InternalConfig.g:8099:1: ( ruleLiteral )
            {
            // InternalConfig.g:8099:1: ( ruleLiteral )
            // InternalConfig.g:8100:1: ruleLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:8115:1: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__SimpleAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8119:1: ( ( ( 'optional' ) ) )
            // InternalConfig.g:8120:1: ( ( 'optional' ) )
            {
            // InternalConfig.g:8120:1: ( ( 'optional' ) )
            // InternalConfig.g:8121:1: ( 'optional' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            }
            // InternalConfig.g:8122:1: ( 'optional' )
            // InternalConfig.g:8123:1: 'optional'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:8138:1: rule__SimpleAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8142:1: ( ( RULE_ID ) )
            // InternalConfig.g:8143:1: ( RULE_ID )
            {
            // InternalConfig.g:8143:1: ( RULE_ID )
            // InternalConfig.g:8144:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:8153:1: rule__SimpleAnnotationAttribute__TypeAssignment_4 : ( ruleLiteralType ) ;
    public final void rule__SimpleAnnotationAttribute__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8157:1: ( ( ruleLiteralType ) )
            // InternalConfig.g:8158:1: ( ruleLiteralType )
            {
            // InternalConfig.g:8158:1: ( ruleLiteralType )
            // InternalConfig.g:8159:1: ruleLiteralType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleLiteralType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:8168:1: rule__EnumAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__EnumAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8172:1: ( ( ( 'optional' ) ) )
            // InternalConfig.g:8173:1: ( ( 'optional' ) )
            {
            // InternalConfig.g:8173:1: ( ( 'optional' ) )
            // InternalConfig.g:8174:1: ( 'optional' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            }
            // InternalConfig.g:8175:1: ( 'optional' )
            // InternalConfig.g:8176:1: 'optional'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:8191:1: rule__EnumAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EnumAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8195:1: ( ( RULE_ID ) )
            // InternalConfig.g:8196:1: ( RULE_ID )
            {
            // InternalConfig.g:8196:1: ( RULE_ID )
            // InternalConfig.g:8197:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:8206:1: rule__EnumAnnotationAttribute__ValuesAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8210:1: ( ( RULE_STRING ) )
            // InternalConfig.g:8211:1: ( RULE_STRING )
            {
            // InternalConfig.g:8211:1: ( RULE_STRING )
            // InternalConfig.g:8212:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:8221:1: rule__EnumAnnotationAttribute__ValuesAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8225:1: ( ( RULE_STRING ) )
            // InternalConfig.g:8226:1: ( RULE_STRING )
            {
            // InternalConfig.g:8226:1: ( RULE_STRING )
            // InternalConfig.g:8227:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1_0_0"
    // InternalConfig.g:8236:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8240:1: ( ( ruleImportedFQN ) )
            // InternalConfig.g:8241:1: ( ruleImportedFQN )
            {
            // InternalConfig.g:8241:1: ( ruleImportedFQN )
            // InternalConfig.g:8242:1: ruleImportedFQN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
            }
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__Import__ImportURIAssignment_1_0_1_1"
    // InternalConfig.g:8251:1: rule__Import__ImportURIAssignment_1_0_1_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8255:1: ( ( RULE_STRING ) )
            // InternalConfig.g:8256:1: ( RULE_STRING )
            {
            // InternalConfig.g:8256:1: ( RULE_STRING )
            // InternalConfig.g:8257:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0_1_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportURIAssignment_1_0_1_1"


    // $ANTLR start "rule__Import__ImportURIAssignment_1_1_1"
    // InternalConfig.g:8266:1: rule__Import__ImportURIAssignment_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8270:1: ( ( RULE_STRING ) )
            // InternalConfig.g:8271:1: ( RULE_STRING )
            {
            // InternalConfig.g:8271:1: ( RULE_STRING )
            // InternalConfig.g:8272:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_1_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportURIAssignment_1_1_1"


    // $ANTLR start "rule__Documentation__LinesAssignment_2"
    // InternalConfig.g:8281:1: rule__Documentation__LinesAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Documentation__LinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8285:1: ( ( RULE_STRING ) )
            // InternalConfig.g:8286:1: ( RULE_STRING )
            {
            // InternalConfig.g:8286:1: ( RULE_STRING )
            // InternalConfig.g:8287:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            }

            }


            }

        }
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
    // InternalConfig.g:8298:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8302:1: ( ( ( 'true' ) ) )
            // InternalConfig.g:8303:1: ( ( 'true' ) )
            {
            // InternalConfig.g:8303:1: ( ( 'true' ) )
            // InternalConfig.g:8304:1: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            }
            // InternalConfig.g:8305:1: ( 'true' )
            // InternalConfig.g:8306:1: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
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
    // InternalConfig.g:8321:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8325:1: ( ( ruleReal ) )
            // InternalConfig.g:8326:1: ( ruleReal )
            {
            // InternalConfig.g:8326:1: ( ruleReal )
            // InternalConfig.g:8327:1: ruleReal
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:8336:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8340:1: ( ( ruleInteger ) )
            // InternalConfig.g:8341:1: ( ruleInteger )
            {
            // InternalConfig.g:8341:1: ( ruleInteger )
            // InternalConfig.g:8342:1: ruleInteger
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
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
    // InternalConfig.g:8351:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalConfig.g:8355:1: ( ( RULE_STRING ) )
            // InternalConfig.g:8356:1: ( RULE_STRING )
            {
            // InternalConfig.g:8356:1: ( RULE_STRING )
            // InternalConfig.g:8357:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
        // InternalConfig.g:7224:8: ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )
        // InternalConfig.g:7224:9: rule__ActorInstanceConfig__AttributesAssignment_7_0
        {
        pushFollow(FOLLOW_2);
        rule__ActorInstanceConfig__AttributesAssignment_7_0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalConfig

    // $ANTLR start synpred2_InternalConfig
    public final void synpred2_InternalConfig_fragment() throws RecognitionException {   
        // InternalConfig.g:7246:8: ( rule__ActorInstanceConfig__PortsAssignment_7_1 )
        // InternalConfig.g:7246:9: rule__ActorInstanceConfig__PortsAssignment_7_1
        {
        pushFollow(FOLLOW_2);
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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0004007030000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000007020000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000B00000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000008000006000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000080008000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x40000000000E00F0L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000340000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000000000C0060L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000040080000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x1000000000008000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x40000000000E00E0L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000400010000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0010000000000010L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0080000000000080L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x4000000000020000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x00000000000C0040L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000B00000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000008000006002L});

}
