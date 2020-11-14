package org.eclipse.etrice.core.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
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
    // InternalConfig.g:53:1: entryRuleConfigModel : ruleConfigModel EOF ;
    public final void entryRuleConfigModel() throws RecognitionException {
        try {
            // InternalConfig.g:54:1: ( ruleConfigModel EOF )
            // InternalConfig.g:55:1: ruleConfigModel EOF
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
    // InternalConfig.g:62:1: ruleConfigModel : ( ( rule__ConfigModel__Group__0 ) ) ;
    public final void ruleConfigModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:66:2: ( ( ( rule__ConfigModel__Group__0 ) ) )
            // InternalConfig.g:67:2: ( ( rule__ConfigModel__Group__0 ) )
            {
            // InternalConfig.g:67:2: ( ( rule__ConfigModel__Group__0 ) )
            // InternalConfig.g:68:3: ( rule__ConfigModel__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getGroup()); 
            }
            // InternalConfig.g:69:3: ( rule__ConfigModel__Group__0 )
            // InternalConfig.g:69:4: rule__ConfigModel__Group__0
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
    // InternalConfig.g:78:1: entryRuleConfigElement : ruleConfigElement EOF ;
    public final void entryRuleConfigElement() throws RecognitionException {
        try {
            // InternalConfig.g:79:1: ( ruleConfigElement EOF )
            // InternalConfig.g:80:1: ruleConfigElement EOF
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
    // InternalConfig.g:87:1: ruleConfigElement : ( ( rule__ConfigElement__Alternatives ) ) ;
    public final void ruleConfigElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:91:2: ( ( ( rule__ConfigElement__Alternatives ) ) )
            // InternalConfig.g:92:2: ( ( rule__ConfigElement__Alternatives ) )
            {
            // InternalConfig.g:92:2: ( ( rule__ConfigElement__Alternatives ) )
            // InternalConfig.g:93:3: ( rule__ConfigElement__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigElementAccess().getAlternatives()); 
            }
            // InternalConfig.g:94:3: ( rule__ConfigElement__Alternatives )
            // InternalConfig.g:94:4: rule__ConfigElement__Alternatives
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
    // InternalConfig.g:103:1: entryRuleSubSystemConfig : ruleSubSystemConfig EOF ;
    public final void entryRuleSubSystemConfig() throws RecognitionException {
        try {
            // InternalConfig.g:104:1: ( ruleSubSystemConfig EOF )
            // InternalConfig.g:105:1: ruleSubSystemConfig EOF
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
    // InternalConfig.g:112:1: ruleSubSystemConfig : ( ( rule__SubSystemConfig__Group__0 ) ) ;
    public final void ruleSubSystemConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:116:2: ( ( ( rule__SubSystemConfig__Group__0 ) ) )
            // InternalConfig.g:117:2: ( ( rule__SubSystemConfig__Group__0 ) )
            {
            // InternalConfig.g:117:2: ( ( rule__SubSystemConfig__Group__0 ) )
            // InternalConfig.g:118:3: ( rule__SubSystemConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getGroup()); 
            }
            // InternalConfig.g:119:3: ( rule__SubSystemConfig__Group__0 )
            // InternalConfig.g:119:4: rule__SubSystemConfig__Group__0
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
    // InternalConfig.g:128:1: entryRuleDynamicConfig : ruleDynamicConfig EOF ;
    public final void entryRuleDynamicConfig() throws RecognitionException {
        try {
            // InternalConfig.g:129:1: ( ruleDynamicConfig EOF )
            // InternalConfig.g:130:1: ruleDynamicConfig EOF
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
    // InternalConfig.g:137:1: ruleDynamicConfig : ( ( rule__DynamicConfig__Group__0 ) ) ;
    public final void ruleDynamicConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:141:2: ( ( ( rule__DynamicConfig__Group__0 ) ) )
            // InternalConfig.g:142:2: ( ( rule__DynamicConfig__Group__0 ) )
            {
            // InternalConfig.g:142:2: ( ( rule__DynamicConfig__Group__0 ) )
            // InternalConfig.g:143:3: ( rule__DynamicConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getGroup()); 
            }
            // InternalConfig.g:144:3: ( rule__DynamicConfig__Group__0 )
            // InternalConfig.g:144:4: rule__DynamicConfig__Group__0
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
    // InternalConfig.g:153:1: entryRuleActorClassConfig : ruleActorClassConfig EOF ;
    public final void entryRuleActorClassConfig() throws RecognitionException {
        try {
            // InternalConfig.g:154:1: ( ruleActorClassConfig EOF )
            // InternalConfig.g:155:1: ruleActorClassConfig EOF
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
    // InternalConfig.g:162:1: ruleActorClassConfig : ( ( rule__ActorClassConfig__Group__0 ) ) ;
    public final void ruleActorClassConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:166:2: ( ( ( rule__ActorClassConfig__Group__0 ) ) )
            // InternalConfig.g:167:2: ( ( rule__ActorClassConfig__Group__0 ) )
            {
            // InternalConfig.g:167:2: ( ( rule__ActorClassConfig__Group__0 ) )
            // InternalConfig.g:168:3: ( rule__ActorClassConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getGroup()); 
            }
            // InternalConfig.g:169:3: ( rule__ActorClassConfig__Group__0 )
            // InternalConfig.g:169:4: rule__ActorClassConfig__Group__0
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
    // InternalConfig.g:178:1: entryRuleActorInstanceConfig : ruleActorInstanceConfig EOF ;
    public final void entryRuleActorInstanceConfig() throws RecognitionException {
        try {
            // InternalConfig.g:179:1: ( ruleActorInstanceConfig EOF )
            // InternalConfig.g:180:1: ruleActorInstanceConfig EOF
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
    // InternalConfig.g:187:1: ruleActorInstanceConfig : ( ( rule__ActorInstanceConfig__Group__0 ) ) ;
    public final void ruleActorInstanceConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:191:2: ( ( ( rule__ActorInstanceConfig__Group__0 ) ) )
            // InternalConfig.g:192:2: ( ( rule__ActorInstanceConfig__Group__0 ) )
            {
            // InternalConfig.g:192:2: ( ( rule__ActorInstanceConfig__Group__0 ) )
            // InternalConfig.g:193:3: ( rule__ActorInstanceConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getGroup()); 
            }
            // InternalConfig.g:194:3: ( rule__ActorInstanceConfig__Group__0 )
            // InternalConfig.g:194:4: rule__ActorInstanceConfig__Group__0
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
    // InternalConfig.g:203:1: entryRuleProtocolClassConfig : ruleProtocolClassConfig EOF ;
    public final void entryRuleProtocolClassConfig() throws RecognitionException {
        try {
            // InternalConfig.g:204:1: ( ruleProtocolClassConfig EOF )
            // InternalConfig.g:205:1: ruleProtocolClassConfig EOF
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
    // InternalConfig.g:212:1: ruleProtocolClassConfig : ( ( rule__ProtocolClassConfig__Group__0 ) ) ;
    public final void ruleProtocolClassConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:216:2: ( ( ( rule__ProtocolClassConfig__Group__0 ) ) )
            // InternalConfig.g:217:2: ( ( rule__ProtocolClassConfig__Group__0 ) )
            {
            // InternalConfig.g:217:2: ( ( rule__ProtocolClassConfig__Group__0 ) )
            // InternalConfig.g:218:3: ( rule__ProtocolClassConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getGroup()); 
            }
            // InternalConfig.g:219:3: ( rule__ProtocolClassConfig__Group__0 )
            // InternalConfig.g:219:4: rule__ProtocolClassConfig__Group__0
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
    // InternalConfig.g:228:1: entryRulePortClassConfig : rulePortClassConfig EOF ;
    public final void entryRulePortClassConfig() throws RecognitionException {
        try {
            // InternalConfig.g:229:1: ( rulePortClassConfig EOF )
            // InternalConfig.g:230:1: rulePortClassConfig EOF
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
    // InternalConfig.g:237:1: rulePortClassConfig : ( ( rule__PortClassConfig__Group__0 ) ) ;
    public final void rulePortClassConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:241:2: ( ( ( rule__PortClassConfig__Group__0 ) ) )
            // InternalConfig.g:242:2: ( ( rule__PortClassConfig__Group__0 ) )
            {
            // InternalConfig.g:242:2: ( ( rule__PortClassConfig__Group__0 ) )
            // InternalConfig.g:243:3: ( rule__PortClassConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getGroup()); 
            }
            // InternalConfig.g:244:3: ( rule__PortClassConfig__Group__0 )
            // InternalConfig.g:244:4: rule__PortClassConfig__Group__0
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
    // InternalConfig.g:253:1: entryRulePortInstanceConfig : rulePortInstanceConfig EOF ;
    public final void entryRulePortInstanceConfig() throws RecognitionException {
        try {
            // InternalConfig.g:254:1: ( rulePortInstanceConfig EOF )
            // InternalConfig.g:255:1: rulePortInstanceConfig EOF
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
    // InternalConfig.g:262:1: rulePortInstanceConfig : ( ( rule__PortInstanceConfig__Group__0 ) ) ;
    public final void rulePortInstanceConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:266:2: ( ( ( rule__PortInstanceConfig__Group__0 ) ) )
            // InternalConfig.g:267:2: ( ( rule__PortInstanceConfig__Group__0 ) )
            {
            // InternalConfig.g:267:2: ( ( rule__PortInstanceConfig__Group__0 ) )
            // InternalConfig.g:268:3: ( rule__PortInstanceConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getGroup()); 
            }
            // InternalConfig.g:269:3: ( rule__PortInstanceConfig__Group__0 )
            // InternalConfig.g:269:4: rule__PortInstanceConfig__Group__0
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
    // InternalConfig.g:278:1: entryRuleAttrClassConfig : ruleAttrClassConfig EOF ;
    public final void entryRuleAttrClassConfig() throws RecognitionException {
        try {
            // InternalConfig.g:279:1: ( ruleAttrClassConfig EOF )
            // InternalConfig.g:280:1: ruleAttrClassConfig EOF
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
    // InternalConfig.g:287:1: ruleAttrClassConfig : ( ( rule__AttrClassConfig__Group__0 ) ) ;
    public final void ruleAttrClassConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:291:2: ( ( ( rule__AttrClassConfig__Group__0 ) ) )
            // InternalConfig.g:292:2: ( ( rule__AttrClassConfig__Group__0 ) )
            {
            // InternalConfig.g:292:2: ( ( rule__AttrClassConfig__Group__0 ) )
            // InternalConfig.g:293:3: ( rule__AttrClassConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup()); 
            }
            // InternalConfig.g:294:3: ( rule__AttrClassConfig__Group__0 )
            // InternalConfig.g:294:4: rule__AttrClassConfig__Group__0
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
    // InternalConfig.g:303:1: entryRuleAttrInstanceConfig : ruleAttrInstanceConfig EOF ;
    public final void entryRuleAttrInstanceConfig() throws RecognitionException {
        try {
            // InternalConfig.g:304:1: ( ruleAttrInstanceConfig EOF )
            // InternalConfig.g:305:1: ruleAttrInstanceConfig EOF
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
    // InternalConfig.g:312:1: ruleAttrInstanceConfig : ( ( rule__AttrInstanceConfig__Group__0 ) ) ;
    public final void ruleAttrInstanceConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:316:2: ( ( ( rule__AttrInstanceConfig__Group__0 ) ) )
            // InternalConfig.g:317:2: ( ( rule__AttrInstanceConfig__Group__0 ) )
            {
            // InternalConfig.g:317:2: ( ( rule__AttrInstanceConfig__Group__0 ) )
            // InternalConfig.g:318:3: ( rule__AttrInstanceConfig__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup()); 
            }
            // InternalConfig.g:319:3: ( rule__AttrInstanceConfig__Group__0 )
            // InternalConfig.g:319:4: rule__AttrInstanceConfig__Group__0
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
    // InternalConfig.g:328:1: entryRuleConfigValueArray : ruleConfigValueArray EOF ;
    public final void entryRuleConfigValueArray() throws RecognitionException {
        try {
            // InternalConfig.g:329:1: ( ruleConfigValueArray EOF )
            // InternalConfig.g:330:1: ruleConfigValueArray EOF
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
    // InternalConfig.g:337:1: ruleConfigValueArray : ( ( rule__ConfigValueArray__Group__0 ) ) ;
    public final void ruleConfigValueArray() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:341:2: ( ( ( rule__ConfigValueArray__Group__0 ) ) )
            // InternalConfig.g:342:2: ( ( rule__ConfigValueArray__Group__0 ) )
            {
            // InternalConfig.g:342:2: ( ( rule__ConfigValueArray__Group__0 ) )
            // InternalConfig.g:343:3: ( rule__ConfigValueArray__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueArrayAccess().getGroup()); 
            }
            // InternalConfig.g:344:3: ( rule__ConfigValueArray__Group__0 )
            // InternalConfig.g:344:4: rule__ConfigValueArray__Group__0
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
    // InternalConfig.g:353:1: entryRuleConfigValue : ruleConfigValue EOF ;
    public final void entryRuleConfigValue() throws RecognitionException {
        try {
            // InternalConfig.g:354:1: ( ruleConfigValue EOF )
            // InternalConfig.g:355:1: ruleConfigValue EOF
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
    // InternalConfig.g:362:1: ruleConfigValue : ( ( rule__ConfigValue__Alternatives ) ) ;
    public final void ruleConfigValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:366:2: ( ( ( rule__ConfigValue__Alternatives ) ) )
            // InternalConfig.g:367:2: ( ( rule__ConfigValue__Alternatives ) )
            {
            // InternalConfig.g:367:2: ( ( rule__ConfigValue__Alternatives ) )
            // InternalConfig.g:368:3: ( rule__ConfigValue__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueAccess().getAlternatives()); 
            }
            // InternalConfig.g:369:3: ( rule__ConfigValue__Alternatives )
            // InternalConfig.g:369:4: rule__ConfigValue__Alternatives
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
    // InternalConfig.g:378:1: entryRuleLiteralConfigValue : ruleLiteralConfigValue EOF ;
    public final void entryRuleLiteralConfigValue() throws RecognitionException {
        try {
            // InternalConfig.g:379:1: ( ruleLiteralConfigValue EOF )
            // InternalConfig.g:380:1: ruleLiteralConfigValue EOF
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
    // InternalConfig.g:387:1: ruleLiteralConfigValue : ( ( rule__LiteralConfigValue__ValueAssignment ) ) ;
    public final void ruleLiteralConfigValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:391:2: ( ( ( rule__LiteralConfigValue__ValueAssignment ) ) )
            // InternalConfig.g:392:2: ( ( rule__LiteralConfigValue__ValueAssignment ) )
            {
            // InternalConfig.g:392:2: ( ( rule__LiteralConfigValue__ValueAssignment ) )
            // InternalConfig.g:393:3: ( rule__LiteralConfigValue__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralConfigValueAccess().getValueAssignment()); 
            }
            // InternalConfig.g:394:3: ( rule__LiteralConfigValue__ValueAssignment )
            // InternalConfig.g:394:4: rule__LiteralConfigValue__ValueAssignment
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
    // InternalConfig.g:403:1: entryRuleEnumConfigValue : ruleEnumConfigValue EOF ;
    public final void entryRuleEnumConfigValue() throws RecognitionException {
        try {
            // InternalConfig.g:404:1: ( ruleEnumConfigValue EOF )
            // InternalConfig.g:405:1: ruleEnumConfigValue EOF
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
    // InternalConfig.g:412:1: ruleEnumConfigValue : ( ( rule__EnumConfigValue__Group__0 ) ) ;
    public final void ruleEnumConfigValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:416:2: ( ( ( rule__EnumConfigValue__Group__0 ) ) )
            // InternalConfig.g:417:2: ( ( rule__EnumConfigValue__Group__0 ) )
            {
            // InternalConfig.g:417:2: ( ( rule__EnumConfigValue__Group__0 ) )
            // InternalConfig.g:418:3: ( rule__EnumConfigValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueAccess().getGroup()); 
            }
            // InternalConfig.g:419:3: ( rule__EnumConfigValue__Group__0 )
            // InternalConfig.g:419:4: rule__EnumConfigValue__Group__0
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
    // InternalConfig.g:428:1: entryRuleRefPath : ruleRefPath EOF ;
    public final void entryRuleRefPath() throws RecognitionException {
        try {
            // InternalConfig.g:429:1: ( ruleRefPath EOF )
            // InternalConfig.g:430:1: ruleRefPath EOF
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
    // InternalConfig.g:437:1: ruleRefPath : ( ( rule__RefPath__Group__0 ) ) ;
    public final void ruleRefPath() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:441:2: ( ( ( rule__RefPath__Group__0 ) ) )
            // InternalConfig.g:442:2: ( ( rule__RefPath__Group__0 ) )
            {
            // InternalConfig.g:442:2: ( ( rule__RefPath__Group__0 ) )
            // InternalConfig.g:443:3: ( rule__RefPath__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getGroup()); 
            }
            // InternalConfig.g:444:3: ( rule__RefPath__Group__0 )
            // InternalConfig.g:444:4: rule__RefPath__Group__0
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
    // InternalConfig.g:453:1: entryRuleRefSegment : ruleRefSegment EOF ;
    public final void entryRuleRefSegment() throws RecognitionException {
        try {
            // InternalConfig.g:454:1: ( ruleRefSegment EOF )
            // InternalConfig.g:455:1: ruleRefSegment EOF
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
    // InternalConfig.g:462:1: ruleRefSegment : ( ( rule__RefSegment__Group__0 ) ) ;
    public final void ruleRefSegment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:466:2: ( ( ( rule__RefSegment__Group__0 ) ) )
            // InternalConfig.g:467:2: ( ( rule__RefSegment__Group__0 ) )
            {
            // InternalConfig.g:467:2: ( ( rule__RefSegment__Group__0 ) )
            // InternalConfig.g:468:3: ( rule__RefSegment__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefSegmentAccess().getGroup()); 
            }
            // InternalConfig.g:469:3: ( rule__RefSegment__Group__0 )
            // InternalConfig.g:469:4: rule__RefSegment__Group__0
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
    // InternalConfig.g:478:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // InternalConfig.g:479:1: ( ruleKeyValue EOF )
            // InternalConfig.g:480:1: ruleKeyValue EOF
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
    // InternalConfig.g:487:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:491:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // InternalConfig.g:492:2: ( ( rule__KeyValue__Group__0 ) )
            {
            // InternalConfig.g:492:2: ( ( rule__KeyValue__Group__0 ) )
            // InternalConfig.g:493:3: ( rule__KeyValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeyValueAccess().getGroup()); 
            }
            // InternalConfig.g:494:3: ( rule__KeyValue__Group__0 )
            // InternalConfig.g:494:4: rule__KeyValue__Group__0
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
    // InternalConfig.g:503:1: entryRuleAnnotationTargetType : ruleAnnotationTargetType EOF ;
    public final void entryRuleAnnotationTargetType() throws RecognitionException {
        try {
            // InternalConfig.g:504:1: ( ruleAnnotationTargetType EOF )
            // InternalConfig.g:505:1: ruleAnnotationTargetType EOF
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
    // InternalConfig.g:512:1: ruleAnnotationTargetType : ( RULE_ID ) ;
    public final void ruleAnnotationTargetType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:516:2: ( ( RULE_ID ) )
            // InternalConfig.g:517:2: ( RULE_ID )
            {
            // InternalConfig.g:517:2: ( RULE_ID )
            // InternalConfig.g:518:3: RULE_ID
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
    // InternalConfig.g:528:1: entryRuleAnnotationAttribute : ruleAnnotationAttribute EOF ;
    public final void entryRuleAnnotationAttribute() throws RecognitionException {
        try {
            // InternalConfig.g:529:1: ( ruleAnnotationAttribute EOF )
            // InternalConfig.g:530:1: ruleAnnotationAttribute EOF
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
    // InternalConfig.g:537:1: ruleAnnotationAttribute : ( ( rule__AnnotationAttribute__Alternatives ) ) ;
    public final void ruleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:541:2: ( ( ( rule__AnnotationAttribute__Alternatives ) ) )
            // InternalConfig.g:542:2: ( ( rule__AnnotationAttribute__Alternatives ) )
            {
            // InternalConfig.g:542:2: ( ( rule__AnnotationAttribute__Alternatives ) )
            // InternalConfig.g:543:3: ( rule__AnnotationAttribute__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAnnotationAttributeAccess().getAlternatives()); 
            }
            // InternalConfig.g:544:3: ( rule__AnnotationAttribute__Alternatives )
            // InternalConfig.g:544:4: rule__AnnotationAttribute__Alternatives
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
    // InternalConfig.g:553:1: entryRuleSimpleAnnotationAttribute : ruleSimpleAnnotationAttribute EOF ;
    public final void entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        try {
            // InternalConfig.g:554:1: ( ruleSimpleAnnotationAttribute EOF )
            // InternalConfig.g:555:1: ruleSimpleAnnotationAttribute EOF
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
    // InternalConfig.g:562:1: ruleSimpleAnnotationAttribute : ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) ;
    public final void ruleSimpleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:566:2: ( ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) )
            // InternalConfig.g:567:2: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            {
            // InternalConfig.g:567:2: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            // InternalConfig.g:568:3: ( rule__SimpleAnnotationAttribute__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup()); 
            }
            // InternalConfig.g:569:3: ( rule__SimpleAnnotationAttribute__Group__0 )
            // InternalConfig.g:569:4: rule__SimpleAnnotationAttribute__Group__0
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
    // InternalConfig.g:578:1: entryRuleEnumAnnotationAttribute : ruleEnumAnnotationAttribute EOF ;
    public final void entryRuleEnumAnnotationAttribute() throws RecognitionException {
        try {
            // InternalConfig.g:579:1: ( ruleEnumAnnotationAttribute EOF )
            // InternalConfig.g:580:1: ruleEnumAnnotationAttribute EOF
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
    // InternalConfig.g:587:1: ruleEnumAnnotationAttribute : ( ( rule__EnumAnnotationAttribute__Group__0 ) ) ;
    public final void ruleEnumAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:591:2: ( ( ( rule__EnumAnnotationAttribute__Group__0 ) ) )
            // InternalConfig.g:592:2: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            {
            // InternalConfig.g:592:2: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            // InternalConfig.g:593:3: ( rule__EnumAnnotationAttribute__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup()); 
            }
            // InternalConfig.g:594:3: ( rule__EnumAnnotationAttribute__Group__0 )
            // InternalConfig.g:594:4: rule__EnumAnnotationAttribute__Group__0
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
    // InternalConfig.g:603:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalConfig.g:604:1: ( ruleImport EOF )
            // InternalConfig.g:605:1: ruleImport EOF
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
    // InternalConfig.g:612:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:616:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalConfig.g:617:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalConfig.g:617:2: ( ( rule__Import__Group__0 ) )
            // InternalConfig.g:618:3: ( rule__Import__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getGroup()); 
            }
            // InternalConfig.g:619:3: ( rule__Import__Group__0 )
            // InternalConfig.g:619:4: rule__Import__Group__0
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
    // InternalConfig.g:628:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // InternalConfig.g:629:1: ( ruleImportedFQN EOF )
            // InternalConfig.g:630:1: ruleImportedFQN EOF
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
    // InternalConfig.g:637:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:641:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // InternalConfig.g:642:2: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // InternalConfig.g:642:2: ( ( rule__ImportedFQN__Group__0 ) )
            // InternalConfig.g:643:3: ( rule__ImportedFQN__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportedFQNAccess().getGroup()); 
            }
            // InternalConfig.g:644:3: ( rule__ImportedFQN__Group__0 )
            // InternalConfig.g:644:4: rule__ImportedFQN__Group__0
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
    // InternalConfig.g:653:1: entryRuleDocumentation : ruleDocumentation EOF ;
    public final void entryRuleDocumentation() throws RecognitionException {
        try {
            // InternalConfig.g:654:1: ( ruleDocumentation EOF )
            // InternalConfig.g:655:1: ruleDocumentation EOF
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
    // InternalConfig.g:662:1: ruleDocumentation : ( ( rule__Documentation__Group__0 ) ) ;
    public final void ruleDocumentation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:666:2: ( ( ( rule__Documentation__Group__0 ) ) )
            // InternalConfig.g:667:2: ( ( rule__Documentation__Group__0 ) )
            {
            // InternalConfig.g:667:2: ( ( rule__Documentation__Group__0 ) )
            // InternalConfig.g:668:3: ( rule__Documentation__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDocumentationAccess().getGroup()); 
            }
            // InternalConfig.g:669:3: ( rule__Documentation__Group__0 )
            // InternalConfig.g:669:4: rule__Documentation__Group__0
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
    // InternalConfig.g:678:1: entryRuleTIME : ruleTIME EOF ;
    public final void entryRuleTIME() throws RecognitionException {
        try {
            // InternalConfig.g:679:1: ( ruleTIME EOF )
            // InternalConfig.g:680:1: ruleTIME EOF
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
    // InternalConfig.g:687:1: ruleTIME : ( ( rule__TIME__Alternatives ) ) ;
    public final void ruleTIME() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:691:2: ( ( ( rule__TIME__Alternatives ) ) )
            // InternalConfig.g:692:2: ( ( rule__TIME__Alternatives ) )
            {
            // InternalConfig.g:692:2: ( ( rule__TIME__Alternatives ) )
            // InternalConfig.g:693:3: ( rule__TIME__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTIMEAccess().getAlternatives()); 
            }
            // InternalConfig.g:694:3: ( rule__TIME__Alternatives )
            // InternalConfig.g:694:4: rule__TIME__Alternatives
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
    // InternalConfig.g:703:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalConfig.g:704:1: ( ruleLiteral EOF )
            // InternalConfig.g:705:1: ruleLiteral EOF
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
    // InternalConfig.g:712:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:716:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalConfig.g:717:2: ( ( rule__Literal__Alternatives ) )
            {
            // InternalConfig.g:717:2: ( ( rule__Literal__Alternatives ) )
            // InternalConfig.g:718:3: ( rule__Literal__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getAlternatives()); 
            }
            // InternalConfig.g:719:3: ( rule__Literal__Alternatives )
            // InternalConfig.g:719:4: rule__Literal__Alternatives
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
    // InternalConfig.g:728:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // InternalConfig.g:729:1: ( ruleBooleanLiteral EOF )
            // InternalConfig.g:730:1: ruleBooleanLiteral EOF
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
    // InternalConfig.g:737:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:741:2: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // InternalConfig.g:742:2: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // InternalConfig.g:742:2: ( ( rule__BooleanLiteral__Group__0 ) )
            // InternalConfig.g:743:3: ( rule__BooleanLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            }
            // InternalConfig.g:744:3: ( rule__BooleanLiteral__Group__0 )
            // InternalConfig.g:744:4: rule__BooleanLiteral__Group__0
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
    // InternalConfig.g:753:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // InternalConfig.g:754:1: ( ruleNumberLiteral EOF )
            // InternalConfig.g:755:1: ruleNumberLiteral EOF
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
    // InternalConfig.g:762:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Alternatives ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:766:2: ( ( ( rule__NumberLiteral__Alternatives ) ) )
            // InternalConfig.g:767:2: ( ( rule__NumberLiteral__Alternatives ) )
            {
            // InternalConfig.g:767:2: ( ( rule__NumberLiteral__Alternatives ) )
            // InternalConfig.g:768:3: ( rule__NumberLiteral__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            }
            // InternalConfig.g:769:3: ( rule__NumberLiteral__Alternatives )
            // InternalConfig.g:769:4: rule__NumberLiteral__Alternatives
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
    // InternalConfig.g:778:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // InternalConfig.g:779:1: ( ruleRealLiteral EOF )
            // InternalConfig.g:780:1: ruleRealLiteral EOF
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
    // InternalConfig.g:787:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:791:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // InternalConfig.g:792:2: ( ( rule__RealLiteral__Group__0 ) )
            {
            // InternalConfig.g:792:2: ( ( rule__RealLiteral__Group__0 ) )
            // InternalConfig.g:793:3: ( rule__RealLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getGroup()); 
            }
            // InternalConfig.g:794:3: ( rule__RealLiteral__Group__0 )
            // InternalConfig.g:794:4: rule__RealLiteral__Group__0
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
    // InternalConfig.g:803:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // InternalConfig.g:804:1: ( ruleIntLiteral EOF )
            // InternalConfig.g:805:1: ruleIntLiteral EOF
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
    // InternalConfig.g:812:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:816:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // InternalConfig.g:817:2: ( ( rule__IntLiteral__Group__0 ) )
            {
            // InternalConfig.g:817:2: ( ( rule__IntLiteral__Group__0 ) )
            // InternalConfig.g:818:3: ( rule__IntLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getGroup()); 
            }
            // InternalConfig.g:819:3: ( rule__IntLiteral__Group__0 )
            // InternalConfig.g:819:4: rule__IntLiteral__Group__0
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
    // InternalConfig.g:828:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // InternalConfig.g:829:1: ( ruleStringLiteral EOF )
            // InternalConfig.g:830:1: ruleStringLiteral EOF
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
    // InternalConfig.g:837:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:841:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // InternalConfig.g:842:2: ( ( rule__StringLiteral__Group__0 ) )
            {
            // InternalConfig.g:842:2: ( ( rule__StringLiteral__Group__0 ) )
            // InternalConfig.g:843:3: ( rule__StringLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getGroup()); 
            }
            // InternalConfig.g:844:3: ( rule__StringLiteral__Group__0 )
            // InternalConfig.g:844:4: rule__StringLiteral__Group__0
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
    // InternalConfig.g:853:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // InternalConfig.g:854:1: ( ruleInteger EOF )
            // InternalConfig.g:855:1: ruleInteger EOF
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
    // InternalConfig.g:862:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:866:2: ( ( ( rule__Integer__Alternatives ) ) )
            // InternalConfig.g:867:2: ( ( rule__Integer__Alternatives ) )
            {
            // InternalConfig.g:867:2: ( ( rule__Integer__Alternatives ) )
            // InternalConfig.g:868:3: ( rule__Integer__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerAccess().getAlternatives()); 
            }
            // InternalConfig.g:869:3: ( rule__Integer__Alternatives )
            // InternalConfig.g:869:4: rule__Integer__Alternatives
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
    // InternalConfig.g:878:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // InternalConfig.g:879:1: ( ruleReal EOF )
            // InternalConfig.g:880:1: ruleReal EOF
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
    // InternalConfig.g:887:1: ruleReal : ( ( rule__Real__Alternatives ) ) ;
    public final void ruleReal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:891:2: ( ( ( rule__Real__Alternatives ) ) )
            // InternalConfig.g:892:2: ( ( rule__Real__Alternatives ) )
            {
            // InternalConfig.g:892:2: ( ( rule__Real__Alternatives ) )
            // InternalConfig.g:893:3: ( rule__Real__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealAccess().getAlternatives()); 
            }
            // InternalConfig.g:894:3: ( rule__Real__Alternatives )
            // InternalConfig.g:894:4: rule__Real__Alternatives
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
    // InternalConfig.g:903:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalConfig.g:907:1: ( ruleDecimal EOF )
            // InternalConfig.g:908:1: ruleDecimal EOF
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
    // InternalConfig.g:918:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:923:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // InternalConfig.g:924:2: ( ( rule__Decimal__Group__0 ) )
            {
            // InternalConfig.g:924:2: ( ( rule__Decimal__Group__0 ) )
            // InternalConfig.g:925:3: ( rule__Decimal__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getGroup()); 
            }
            // InternalConfig.g:926:3: ( rule__Decimal__Group__0 )
            // InternalConfig.g:926:4: rule__Decimal__Group__0
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
    // InternalConfig.g:936:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalConfig.g:940:1: ( ruleDecimalExp EOF )
            // InternalConfig.g:941:1: ruleDecimalExp EOF
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
    // InternalConfig.g:951:1: ruleDecimalExp : ( ( rule__DecimalExp__Group__0 ) ) ;
    public final void ruleDecimalExp() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:956:2: ( ( ( rule__DecimalExp__Group__0 ) ) )
            // InternalConfig.g:957:2: ( ( rule__DecimalExp__Group__0 ) )
            {
            // InternalConfig.g:957:2: ( ( rule__DecimalExp__Group__0 ) )
            // InternalConfig.g:958:3: ( rule__DecimalExp__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getGroup()); 
            }
            // InternalConfig.g:959:3: ( rule__DecimalExp__Group__0 )
            // InternalConfig.g:959:4: rule__DecimalExp__Group__0
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
    // InternalConfig.g:969:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalConfig.g:970:1: ( ruleFQN EOF )
            // InternalConfig.g:971:1: ruleFQN EOF
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
    // InternalConfig.g:978:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:982:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalConfig.g:983:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalConfig.g:983:2: ( ( rule__FQN__Group__0 ) )
            // InternalConfig.g:984:3: ( rule__FQN__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getGroup()); 
            }
            // InternalConfig.g:985:3: ( rule__FQN__Group__0 )
            // InternalConfig.g:985:4: rule__FQN__Group__0
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
    // InternalConfig.g:994:1: ruleLiteralType : ( ( rule__LiteralType__Alternatives ) ) ;
    public final void ruleLiteralType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:998:1: ( ( ( rule__LiteralType__Alternatives ) ) )
            // InternalConfig.g:999:2: ( ( rule__LiteralType__Alternatives ) )
            {
            // InternalConfig.g:999:2: ( ( rule__LiteralType__Alternatives ) )
            // InternalConfig.g:1000:3: ( rule__LiteralType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralTypeAccess().getAlternatives()); 
            }
            // InternalConfig.g:1001:3: ( rule__LiteralType__Alternatives )
            // InternalConfig.g:1001:4: rule__LiteralType__Alternatives
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
    // InternalConfig.g:1009:1: rule__ConfigElement__Alternatives : ( ( ruleSubSystemConfig ) | ( ruleActorClassConfig ) | ( ruleActorInstanceConfig ) | ( ruleProtocolClassConfig ) );
    public final void rule__ConfigElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1013:1: ( ( ruleSubSystemConfig ) | ( ruleActorClassConfig ) | ( ruleActorInstanceConfig ) | ( ruleProtocolClassConfig ) )
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
                    // InternalConfig.g:1014:2: ( ruleSubSystemConfig )
                    {
                    // InternalConfig.g:1014:2: ( ruleSubSystemConfig )
                    // InternalConfig.g:1015:3: ruleSubSystemConfig
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
                    // InternalConfig.g:1020:2: ( ruleActorClassConfig )
                    {
                    // InternalConfig.g:1020:2: ( ruleActorClassConfig )
                    // InternalConfig.g:1021:3: ruleActorClassConfig
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
                    // InternalConfig.g:1026:2: ( ruleActorInstanceConfig )
                    {
                    // InternalConfig.g:1026:2: ( ruleActorInstanceConfig )
                    // InternalConfig.g:1027:3: ruleActorInstanceConfig
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
                    // InternalConfig.g:1032:2: ( ruleProtocolClassConfig )
                    {
                    // InternalConfig.g:1032:2: ( ruleProtocolClassConfig )
                    // InternalConfig.g:1033:3: ruleProtocolClassConfig
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
    // InternalConfig.g:1042:1: rule__DynamicConfig__Alternatives_2_0 : ( ( ( rule__DynamicConfig__Group_2_0_0__0 ) ) | ( ( rule__DynamicConfig__Group_2_0_1__0 ) ) );
    public final void rule__DynamicConfig__Alternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1046:1: ( ( ( rule__DynamicConfig__Group_2_0_0__0 ) ) | ( ( rule__DynamicConfig__Group_2_0_1__0 ) ) )
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
                    // InternalConfig.g:1047:2: ( ( rule__DynamicConfig__Group_2_0_0__0 ) )
                    {
                    // InternalConfig.g:1047:2: ( ( rule__DynamicConfig__Group_2_0_0__0 ) )
                    // InternalConfig.g:1048:3: ( rule__DynamicConfig__Group_2_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_0()); 
                    }
                    // InternalConfig.g:1049:3: ( rule__DynamicConfig__Group_2_0_0__0 )
                    // InternalConfig.g:1049:4: rule__DynamicConfig__Group_2_0_0__0
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
                    // InternalConfig.g:1053:2: ( ( rule__DynamicConfig__Group_2_0_1__0 ) )
                    {
                    // InternalConfig.g:1053:2: ( ( rule__DynamicConfig__Group_2_0_1__0 ) )
                    // InternalConfig.g:1054:3: ( rule__DynamicConfig__Group_2_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1()); 
                    }
                    // InternalConfig.g:1055:3: ( rule__DynamicConfig__Group_2_0_1__0 )
                    // InternalConfig.g:1055:4: rule__DynamicConfig__Group_2_0_1__0
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
    // InternalConfig.g:1063:1: rule__ProtocolClassConfig__Alternatives_3_1_0 : ( ( 'conjugate' ) | ( 'conjugated' ) );
    public final void rule__ProtocolClassConfig__Alternatives_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1067:1: ( ( 'conjugate' ) | ( 'conjugated' ) )
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
                    // InternalConfig.g:1068:2: ( 'conjugate' )
                    {
                    // InternalConfig.g:1068:2: ( 'conjugate' )
                    // InternalConfig.g:1069:3: 'conjugate'
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
                    // InternalConfig.g:1074:2: ( 'conjugated' )
                    {
                    // InternalConfig.g:1074:2: ( 'conjugated' )
                    // InternalConfig.g:1075:3: 'conjugated'
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
    // InternalConfig.g:1084:1: rule__AttrInstanceConfig__Alternatives_3_1_0_1 : ( ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) ) | ( 'write' ) );
    public final void rule__AttrInstanceConfig__Alternatives_3_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1088:1: ( ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) ) | ( 'write' ) )
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
                    // InternalConfig.g:1089:2: ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) )
                    {
                    // InternalConfig.g:1089:2: ( ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 ) )
                    // InternalConfig.g:1090:3: ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyAssignment_3_1_0_1_0()); 
                    }
                    // InternalConfig.g:1091:3: ( rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 )
                    // InternalConfig.g:1091:4: rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0
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
                    // InternalConfig.g:1095:2: ( 'write' )
                    {
                    // InternalConfig.g:1095:2: ( 'write' )
                    // InternalConfig.g:1096:3: 'write'
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
    // InternalConfig.g:1105:1: rule__ConfigValue__Alternatives : ( ( ruleLiteralConfigValue ) | ( ruleEnumConfigValue ) );
    public final void rule__ConfigValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1109:1: ( ( ruleLiteralConfigValue ) | ( ruleEnumConfigValue ) )
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
                    // InternalConfig.g:1110:2: ( ruleLiteralConfigValue )
                    {
                    // InternalConfig.g:1110:2: ( ruleLiteralConfigValue )
                    // InternalConfig.g:1111:3: ruleLiteralConfigValue
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
                    // InternalConfig.g:1116:2: ( ruleEnumConfigValue )
                    {
                    // InternalConfig.g:1116:2: ( ruleEnumConfigValue )
                    // InternalConfig.g:1117:3: ruleEnumConfigValue
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
    // InternalConfig.g:1126:1: rule__AnnotationAttribute__Alternatives : ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) );
    public final void rule__AnnotationAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1130:1: ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) )
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
                    // InternalConfig.g:1131:2: ( ruleSimpleAnnotationAttribute )
                    {
                    // InternalConfig.g:1131:2: ( ruleSimpleAnnotationAttribute )
                    // InternalConfig.g:1132:3: ruleSimpleAnnotationAttribute
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
                    // InternalConfig.g:1137:2: ( ruleEnumAnnotationAttribute )
                    {
                    // InternalConfig.g:1137:2: ( ruleEnumAnnotationAttribute )
                    // InternalConfig.g:1138:3: ruleEnumAnnotationAttribute
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
    // InternalConfig.g:1147:1: rule__SimpleAnnotationAttribute__Alternatives_0 : ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__SimpleAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1151:1: ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
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
                    // InternalConfig.g:1152:2: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // InternalConfig.g:1152:2: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // InternalConfig.g:1153:3: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    }
                    // InternalConfig.g:1154:3: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    // InternalConfig.g:1154:4: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0
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
                    // InternalConfig.g:1158:2: ( 'mandatory' )
                    {
                    // InternalConfig.g:1158:2: ( 'mandatory' )
                    // InternalConfig.g:1159:3: 'mandatory'
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
    // InternalConfig.g:1168:1: rule__EnumAnnotationAttribute__Alternatives_0 : ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__EnumAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1172:1: ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
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
                    // InternalConfig.g:1173:2: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // InternalConfig.g:1173:2: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // InternalConfig.g:1174:3: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    }
                    // InternalConfig.g:1175:3: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    // InternalConfig.g:1175:4: rule__EnumAnnotationAttribute__OptionalAssignment_0_0
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
                    // InternalConfig.g:1179:2: ( 'mandatory' )
                    {
                    // InternalConfig.g:1179:2: ( 'mandatory' )
                    // InternalConfig.g:1180:3: 'mandatory'
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
    // InternalConfig.g:1189:1: rule__Import__Alternatives_1 : ( ( ( rule__Import__Group_1_0__0 ) ) | ( ( rule__Import__Group_1_1__0 ) ) );
    public final void rule__Import__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1193:1: ( ( ( rule__Import__Group_1_0__0 ) ) | ( ( rule__Import__Group_1_1__0 ) ) )
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
                    // InternalConfig.g:1194:2: ( ( rule__Import__Group_1_0__0 ) )
                    {
                    // InternalConfig.g:1194:2: ( ( rule__Import__Group_1_0__0 ) )
                    // InternalConfig.g:1195:3: ( rule__Import__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getImportAccess().getGroup_1_0()); 
                    }
                    // InternalConfig.g:1196:3: ( rule__Import__Group_1_0__0 )
                    // InternalConfig.g:1196:4: rule__Import__Group_1_0__0
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
                    // InternalConfig.g:1200:2: ( ( rule__Import__Group_1_1__0 ) )
                    {
                    // InternalConfig.g:1200:2: ( ( rule__Import__Group_1_1__0 ) )
                    // InternalConfig.g:1201:3: ( rule__Import__Group_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getImportAccess().getGroup_1_1()); 
                    }
                    // InternalConfig.g:1202:3: ( rule__Import__Group_1_1__0 )
                    // InternalConfig.g:1202:4: rule__Import__Group_1_1__0
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
    // InternalConfig.g:1210:1: rule__TIME__Alternatives : ( ( ( rule__TIME__Group_0__0 ) ) | ( ( rule__TIME__Group_1__0 ) ) | ( ( rule__TIME__Group_2__0 ) ) | ( ( rule__TIME__Group_3__0 ) ) );
    public final void rule__TIME__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1214:1: ( ( ( rule__TIME__Group_0__0 ) ) | ( ( rule__TIME__Group_1__0 ) ) | ( ( rule__TIME__Group_2__0 ) ) | ( ( rule__TIME__Group_3__0 ) ) )
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
                    // InternalConfig.g:1215:2: ( ( rule__TIME__Group_0__0 ) )
                    {
                    // InternalConfig.g:1215:2: ( ( rule__TIME__Group_0__0 ) )
                    // InternalConfig.g:1216:3: ( rule__TIME__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTIMEAccess().getGroup_0()); 
                    }
                    // InternalConfig.g:1217:3: ( rule__TIME__Group_0__0 )
                    // InternalConfig.g:1217:4: rule__TIME__Group_0__0
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
                    // InternalConfig.g:1221:2: ( ( rule__TIME__Group_1__0 ) )
                    {
                    // InternalConfig.g:1221:2: ( ( rule__TIME__Group_1__0 ) )
                    // InternalConfig.g:1222:3: ( rule__TIME__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTIMEAccess().getGroup_1()); 
                    }
                    // InternalConfig.g:1223:3: ( rule__TIME__Group_1__0 )
                    // InternalConfig.g:1223:4: rule__TIME__Group_1__0
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
                    // InternalConfig.g:1227:2: ( ( rule__TIME__Group_2__0 ) )
                    {
                    // InternalConfig.g:1227:2: ( ( rule__TIME__Group_2__0 ) )
                    // InternalConfig.g:1228:3: ( rule__TIME__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTIMEAccess().getGroup_2()); 
                    }
                    // InternalConfig.g:1229:3: ( rule__TIME__Group_2__0 )
                    // InternalConfig.g:1229:4: rule__TIME__Group_2__0
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
                    // InternalConfig.g:1233:2: ( ( rule__TIME__Group_3__0 ) )
                    {
                    // InternalConfig.g:1233:2: ( ( rule__TIME__Group_3__0 ) )
                    // InternalConfig.g:1234:3: ( rule__TIME__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTIMEAccess().getGroup_3()); 
                    }
                    // InternalConfig.g:1235:3: ( rule__TIME__Group_3__0 )
                    // InternalConfig.g:1235:4: rule__TIME__Group_3__0
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
    // InternalConfig.g:1243:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1247:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
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
                    // InternalConfig.g:1248:2: ( ruleBooleanLiteral )
                    {
                    // InternalConfig.g:1248:2: ( ruleBooleanLiteral )
                    // InternalConfig.g:1249:3: ruleBooleanLiteral
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
                    // InternalConfig.g:1254:2: ( ruleNumberLiteral )
                    {
                    // InternalConfig.g:1254:2: ( ruleNumberLiteral )
                    // InternalConfig.g:1255:3: ruleNumberLiteral
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
                    // InternalConfig.g:1260:2: ( ruleStringLiteral )
                    {
                    // InternalConfig.g:1260:2: ( ruleStringLiteral )
                    // InternalConfig.g:1261:3: ruleStringLiteral
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
    // InternalConfig.g:1270:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1274:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
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
                    // InternalConfig.g:1275:2: ( 'false' )
                    {
                    // InternalConfig.g:1275:2: ( 'false' )
                    // InternalConfig.g:1276:3: 'false'
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
                    // InternalConfig.g:1281:2: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // InternalConfig.g:1281:2: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // InternalConfig.g:1282:3: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    }
                    // InternalConfig.g:1283:3: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // InternalConfig.g:1283:4: rule__BooleanLiteral__IsTrueAssignment_1_1
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
    // InternalConfig.g:1291:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1295:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
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
                    // InternalConfig.g:1296:2: ( ruleIntLiteral )
                    {
                    // InternalConfig.g:1296:2: ( ruleIntLiteral )
                    // InternalConfig.g:1297:3: ruleIntLiteral
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
                    // InternalConfig.g:1302:2: ( ruleRealLiteral )
                    {
                    // InternalConfig.g:1302:2: ( ruleRealLiteral )
                    // InternalConfig.g:1303:3: ruleRealLiteral
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
    // InternalConfig.g:1312:1: rule__Integer__Alternatives : ( ( ( rule__Integer__Group_0__0 ) ) | ( RULE_HEX ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1316:1: ( ( ( rule__Integer__Group_0__0 ) ) | ( RULE_HEX ) )
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
                    // InternalConfig.g:1317:2: ( ( rule__Integer__Group_0__0 ) )
                    {
                    // InternalConfig.g:1317:2: ( ( rule__Integer__Group_0__0 ) )
                    // InternalConfig.g:1318:3: ( rule__Integer__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIntegerAccess().getGroup_0()); 
                    }
                    // InternalConfig.g:1319:3: ( rule__Integer__Group_0__0 )
                    // InternalConfig.g:1319:4: rule__Integer__Group_0__0
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
                    // InternalConfig.g:1323:2: ( RULE_HEX )
                    {
                    // InternalConfig.g:1323:2: ( RULE_HEX )
                    // InternalConfig.g:1324:3: RULE_HEX
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
    // InternalConfig.g:1333:1: rule__Integer__Alternatives_0_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Integer__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1337:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalConfig.g:1338:2: ( '+' )
                    {
                    // InternalConfig.g:1338:2: ( '+' )
                    // InternalConfig.g:1339:3: '+'
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
                    // InternalConfig.g:1344:2: ( '-' )
                    {
                    // InternalConfig.g:1344:2: ( '-' )
                    // InternalConfig.g:1345:3: '-'
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
    // InternalConfig.g:1354:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1358:1: ( ( ruleDecimal ) | ( ruleDecimalExp ) )
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
                    // InternalConfig.g:1359:2: ( ruleDecimal )
                    {
                    // InternalConfig.g:1359:2: ( ruleDecimal )
                    // InternalConfig.g:1360:3: ruleDecimal
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
                    // InternalConfig.g:1365:2: ( ruleDecimalExp )
                    {
                    // InternalConfig.g:1365:2: ( ruleDecimalExp )
                    // InternalConfig.g:1366:3: ruleDecimalExp
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
    // InternalConfig.g:1375:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1379:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalConfig.g:1380:2: ( '+' )
                    {
                    // InternalConfig.g:1380:2: ( '+' )
                    // InternalConfig.g:1381:3: '+'
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
                    // InternalConfig.g:1386:2: ( '-' )
                    {
                    // InternalConfig.g:1386:2: ( '-' )
                    // InternalConfig.g:1387:3: '-'
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
    // InternalConfig.g:1396:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1400:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalConfig.g:1401:2: ( '+' )
                    {
                    // InternalConfig.g:1401:2: ( '+' )
                    // InternalConfig.g:1402:3: '+'
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
                    // InternalConfig.g:1407:2: ( '-' )
                    {
                    // InternalConfig.g:1407:2: ( '-' )
                    // InternalConfig.g:1408:3: '-'
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
    // InternalConfig.g:1417:1: rule__DecimalExp__Alternatives_4 : ( ( 'e' ) | ( 'E' ) );
    public final void rule__DecimalExp__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1421:1: ( ( 'e' ) | ( 'E' ) )
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
                    // InternalConfig.g:1422:2: ( 'e' )
                    {
                    // InternalConfig.g:1422:2: ( 'e' )
                    // InternalConfig.g:1423:3: 'e'
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
                    // InternalConfig.g:1428:2: ( 'E' )
                    {
                    // InternalConfig.g:1428:2: ( 'E' )
                    // InternalConfig.g:1429:3: 'E'
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
    // InternalConfig.g:1438:1: rule__DecimalExp__Alternatives_5 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1442:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalConfig.g:1443:2: ( '+' )
                    {
                    // InternalConfig.g:1443:2: ( '+' )
                    // InternalConfig.g:1444:3: '+'
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
                    // InternalConfig.g:1449:2: ( '-' )
                    {
                    // InternalConfig.g:1449:2: ( '-' )
                    // InternalConfig.g:1450:3: '-'
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
    // InternalConfig.g:1459:1: rule__LiteralType__Alternatives : ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) );
    public final void rule__LiteralType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1463:1: ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) )
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
                    // InternalConfig.g:1464:2: ( ( 'ptBoolean' ) )
                    {
                    // InternalConfig.g:1464:2: ( ( 'ptBoolean' ) )
                    // InternalConfig.g:1465:3: ( 'ptBoolean' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                    }
                    // InternalConfig.g:1466:3: ( 'ptBoolean' )
                    // InternalConfig.g:1466:4: 'ptBoolean'
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
                    // InternalConfig.g:1470:2: ( ( 'ptInteger' ) )
                    {
                    // InternalConfig.g:1470:2: ( ( 'ptInteger' ) )
                    // InternalConfig.g:1471:3: ( 'ptInteger' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                    }
                    // InternalConfig.g:1472:3: ( 'ptInteger' )
                    // InternalConfig.g:1472:4: 'ptInteger'
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
                    // InternalConfig.g:1476:2: ( ( 'ptReal' ) )
                    {
                    // InternalConfig.g:1476:2: ( ( 'ptReal' ) )
                    // InternalConfig.g:1477:3: ( 'ptReal' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                    }
                    // InternalConfig.g:1478:3: ( 'ptReal' )
                    // InternalConfig.g:1478:4: 'ptReal'
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
                    // InternalConfig.g:1482:2: ( ( 'ptCharacter' ) )
                    {
                    // InternalConfig.g:1482:2: ( ( 'ptCharacter' ) )
                    // InternalConfig.g:1483:3: ( 'ptCharacter' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 
                    }
                    // InternalConfig.g:1484:3: ( 'ptCharacter' )
                    // InternalConfig.g:1484:4: 'ptCharacter'
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
    // InternalConfig.g:1492:1: rule__ConfigModel__Group__0 : rule__ConfigModel__Group__0__Impl rule__ConfigModel__Group__1 ;
    public final void rule__ConfigModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1496:1: ( rule__ConfigModel__Group__0__Impl rule__ConfigModel__Group__1 )
            // InternalConfig.g:1497:2: rule__ConfigModel__Group__0__Impl rule__ConfigModel__Group__1
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
    // InternalConfig.g:1504:1: rule__ConfigModel__Group__0__Impl : ( 'ConfigModel' ) ;
    public final void rule__ConfigModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1508:1: ( ( 'ConfigModel' ) )
            // InternalConfig.g:1509:1: ( 'ConfigModel' )
            {
            // InternalConfig.g:1509:1: ( 'ConfigModel' )
            // InternalConfig.g:1510:2: 'ConfigModel'
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
    // InternalConfig.g:1519:1: rule__ConfigModel__Group__1 : rule__ConfigModel__Group__1__Impl rule__ConfigModel__Group__2 ;
    public final void rule__ConfigModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1523:1: ( rule__ConfigModel__Group__1__Impl rule__ConfigModel__Group__2 )
            // InternalConfig.g:1524:2: rule__ConfigModel__Group__1__Impl rule__ConfigModel__Group__2
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
    // InternalConfig.g:1531:1: rule__ConfigModel__Group__1__Impl : ( ( rule__ConfigModel__NameAssignment_1 ) ) ;
    public final void rule__ConfigModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1535:1: ( ( ( rule__ConfigModel__NameAssignment_1 ) ) )
            // InternalConfig.g:1536:1: ( ( rule__ConfigModel__NameAssignment_1 ) )
            {
            // InternalConfig.g:1536:1: ( ( rule__ConfigModel__NameAssignment_1 ) )
            // InternalConfig.g:1537:2: ( rule__ConfigModel__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getNameAssignment_1()); 
            }
            // InternalConfig.g:1538:2: ( rule__ConfigModel__NameAssignment_1 )
            // InternalConfig.g:1538:3: rule__ConfigModel__NameAssignment_1
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
    // InternalConfig.g:1546:1: rule__ConfigModel__Group__2 : rule__ConfigModel__Group__2__Impl rule__ConfigModel__Group__3 ;
    public final void rule__ConfigModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1550:1: ( rule__ConfigModel__Group__2__Impl rule__ConfigModel__Group__3 )
            // InternalConfig.g:1551:2: rule__ConfigModel__Group__2__Impl rule__ConfigModel__Group__3
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
    // InternalConfig.g:1558:1: rule__ConfigModel__Group__2__Impl : ( '{' ) ;
    public final void rule__ConfigModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1562:1: ( ( '{' ) )
            // InternalConfig.g:1563:1: ( '{' )
            {
            // InternalConfig.g:1563:1: ( '{' )
            // InternalConfig.g:1564:2: '{'
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
    // InternalConfig.g:1573:1: rule__ConfigModel__Group__3 : rule__ConfigModel__Group__3__Impl rule__ConfigModel__Group__4 ;
    public final void rule__ConfigModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1577:1: ( rule__ConfigModel__Group__3__Impl rule__ConfigModel__Group__4 )
            // InternalConfig.g:1578:2: rule__ConfigModel__Group__3__Impl rule__ConfigModel__Group__4
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
    // InternalConfig.g:1585:1: rule__ConfigModel__Group__3__Impl : ( ( rule__ConfigModel__ImportsAssignment_3 )* ) ;
    public final void rule__ConfigModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1589:1: ( ( ( rule__ConfigModel__ImportsAssignment_3 )* ) )
            // InternalConfig.g:1590:1: ( ( rule__ConfigModel__ImportsAssignment_3 )* )
            {
            // InternalConfig.g:1590:1: ( ( rule__ConfigModel__ImportsAssignment_3 )* )
            // InternalConfig.g:1591:2: ( rule__ConfigModel__ImportsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getImportsAssignment_3()); 
            }
            // InternalConfig.g:1592:2: ( rule__ConfigModel__ImportsAssignment_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==50) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalConfig.g:1592:3: rule__ConfigModel__ImportsAssignment_3
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
    // InternalConfig.g:1600:1: rule__ConfigModel__Group__4 : rule__ConfigModel__Group__4__Impl rule__ConfigModel__Group__5 ;
    public final void rule__ConfigModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1604:1: ( rule__ConfigModel__Group__4__Impl rule__ConfigModel__Group__5 )
            // InternalConfig.g:1605:2: rule__ConfigModel__Group__4__Impl rule__ConfigModel__Group__5
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
    // InternalConfig.g:1612:1: rule__ConfigModel__Group__4__Impl : ( ( rule__ConfigModel__ConfigElementsAssignment_4 )* ) ;
    public final void rule__ConfigModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1616:1: ( ( ( rule__ConfigModel__ConfigElementsAssignment_4 )* ) )
            // InternalConfig.g:1617:1: ( ( rule__ConfigModel__ConfigElementsAssignment_4 )* )
            {
            // InternalConfig.g:1617:1: ( ( rule__ConfigModel__ConfigElementsAssignment_4 )* )
            // InternalConfig.g:1618:2: ( rule__ConfigModel__ConfigElementsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigModelAccess().getConfigElementsAssignment_4()); 
            }
            // InternalConfig.g:1619:2: ( rule__ConfigModel__ConfigElementsAssignment_4 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==29||(LA23_0>=36 && LA23_0<=38)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalConfig.g:1619:3: rule__ConfigModel__ConfigElementsAssignment_4
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
    // InternalConfig.g:1627:1: rule__ConfigModel__Group__5 : rule__ConfigModel__Group__5__Impl ;
    public final void rule__ConfigModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1631:1: ( rule__ConfigModel__Group__5__Impl )
            // InternalConfig.g:1632:2: rule__ConfigModel__Group__5__Impl
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
    // InternalConfig.g:1638:1: rule__ConfigModel__Group__5__Impl : ( '}' ) ;
    public final void rule__ConfigModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1642:1: ( ( '}' ) )
            // InternalConfig.g:1643:1: ( '}' )
            {
            // InternalConfig.g:1643:1: ( '}' )
            // InternalConfig.g:1644:2: '}'
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
    // InternalConfig.g:1654:1: rule__SubSystemConfig__Group__0 : rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1 ;
    public final void rule__SubSystemConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1658:1: ( rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1 )
            // InternalConfig.g:1659:2: rule__SubSystemConfig__Group__0__Impl rule__SubSystemConfig__Group__1
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
    // InternalConfig.g:1666:1: rule__SubSystemConfig__Group__0__Impl : ( 'SubSystemConfig' ) ;
    public final void rule__SubSystemConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1670:1: ( ( 'SubSystemConfig' ) )
            // InternalConfig.g:1671:1: ( 'SubSystemConfig' )
            {
            // InternalConfig.g:1671:1: ( 'SubSystemConfig' )
            // InternalConfig.g:1672:2: 'SubSystemConfig'
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
    // InternalConfig.g:1681:1: rule__SubSystemConfig__Group__1 : rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2 ;
    public final void rule__SubSystemConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1685:1: ( rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2 )
            // InternalConfig.g:1686:2: rule__SubSystemConfig__Group__1__Impl rule__SubSystemConfig__Group__2
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
    // InternalConfig.g:1693:1: rule__SubSystemConfig__Group__1__Impl : ( ( rule__SubSystemConfig__RootAssignment_1 ) ) ;
    public final void rule__SubSystemConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1697:1: ( ( ( rule__SubSystemConfig__RootAssignment_1 ) ) )
            // InternalConfig.g:1698:1: ( ( rule__SubSystemConfig__RootAssignment_1 ) )
            {
            // InternalConfig.g:1698:1: ( ( rule__SubSystemConfig__RootAssignment_1 ) )
            // InternalConfig.g:1699:2: ( rule__SubSystemConfig__RootAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getRootAssignment_1()); 
            }
            // InternalConfig.g:1700:2: ( rule__SubSystemConfig__RootAssignment_1 )
            // InternalConfig.g:1700:3: rule__SubSystemConfig__RootAssignment_1
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
    // InternalConfig.g:1708:1: rule__SubSystemConfig__Group__2 : rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3 ;
    public final void rule__SubSystemConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1712:1: ( rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3 )
            // InternalConfig.g:1713:2: rule__SubSystemConfig__Group__2__Impl rule__SubSystemConfig__Group__3
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
    // InternalConfig.g:1720:1: rule__SubSystemConfig__Group__2__Impl : ( '/' ) ;
    public final void rule__SubSystemConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1724:1: ( ( '/' ) )
            // InternalConfig.g:1725:1: ( '/' )
            {
            // InternalConfig.g:1725:1: ( '/' )
            // InternalConfig.g:1726:2: '/'
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
    // InternalConfig.g:1735:1: rule__SubSystemConfig__Group__3 : rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4 ;
    public final void rule__SubSystemConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1739:1: ( rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4 )
            // InternalConfig.g:1740:2: rule__SubSystemConfig__Group__3__Impl rule__SubSystemConfig__Group__4
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
    // InternalConfig.g:1747:1: rule__SubSystemConfig__Group__3__Impl : ( ( rule__SubSystemConfig__SubSystemAssignment_3 ) ) ;
    public final void rule__SubSystemConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1751:1: ( ( ( rule__SubSystemConfig__SubSystemAssignment_3 ) ) )
            // InternalConfig.g:1752:1: ( ( rule__SubSystemConfig__SubSystemAssignment_3 ) )
            {
            // InternalConfig.g:1752:1: ( ( rule__SubSystemConfig__SubSystemAssignment_3 ) )
            // InternalConfig.g:1753:2: ( rule__SubSystemConfig__SubSystemAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemAssignment_3()); 
            }
            // InternalConfig.g:1754:2: ( rule__SubSystemConfig__SubSystemAssignment_3 )
            // InternalConfig.g:1754:3: rule__SubSystemConfig__SubSystemAssignment_3
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
    // InternalConfig.g:1762:1: rule__SubSystemConfig__Group__4 : rule__SubSystemConfig__Group__4__Impl rule__SubSystemConfig__Group__5 ;
    public final void rule__SubSystemConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1766:1: ( rule__SubSystemConfig__Group__4__Impl rule__SubSystemConfig__Group__5 )
            // InternalConfig.g:1767:2: rule__SubSystemConfig__Group__4__Impl rule__SubSystemConfig__Group__5
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
    // InternalConfig.g:1774:1: rule__SubSystemConfig__Group__4__Impl : ( '{' ) ;
    public final void rule__SubSystemConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1778:1: ( ( '{' ) )
            // InternalConfig.g:1779:1: ( '{' )
            {
            // InternalConfig.g:1779:1: ( '{' )
            // InternalConfig.g:1780:2: '{'
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
    // InternalConfig.g:1789:1: rule__SubSystemConfig__Group__5 : rule__SubSystemConfig__Group__5__Impl rule__SubSystemConfig__Group__6 ;
    public final void rule__SubSystemConfig__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1793:1: ( rule__SubSystemConfig__Group__5__Impl rule__SubSystemConfig__Group__6 )
            // InternalConfig.g:1794:2: rule__SubSystemConfig__Group__5__Impl rule__SubSystemConfig__Group__6
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
    // InternalConfig.g:1801:1: rule__SubSystemConfig__Group__5__Impl : ( ( rule__SubSystemConfig__DynConfigAssignment_5 ) ) ;
    public final void rule__SubSystemConfig__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1805:1: ( ( ( rule__SubSystemConfig__DynConfigAssignment_5 ) ) )
            // InternalConfig.g:1806:1: ( ( rule__SubSystemConfig__DynConfigAssignment_5 ) )
            {
            // InternalConfig.g:1806:1: ( ( rule__SubSystemConfig__DynConfigAssignment_5 ) )
            // InternalConfig.g:1807:2: ( rule__SubSystemConfig__DynConfigAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getDynConfigAssignment_5()); 
            }
            // InternalConfig.g:1808:2: ( rule__SubSystemConfig__DynConfigAssignment_5 )
            // InternalConfig.g:1808:3: rule__SubSystemConfig__DynConfigAssignment_5
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
    // InternalConfig.g:1816:1: rule__SubSystemConfig__Group__6 : rule__SubSystemConfig__Group__6__Impl ;
    public final void rule__SubSystemConfig__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1820:1: ( rule__SubSystemConfig__Group__6__Impl )
            // InternalConfig.g:1821:2: rule__SubSystemConfig__Group__6__Impl
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
    // InternalConfig.g:1827:1: rule__SubSystemConfig__Group__6__Impl : ( '}' ) ;
    public final void rule__SubSystemConfig__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1831:1: ( ( '}' ) )
            // InternalConfig.g:1832:1: ( '}' )
            {
            // InternalConfig.g:1832:1: ( '}' )
            // InternalConfig.g:1833:2: '}'
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
    // InternalConfig.g:1843:1: rule__DynamicConfig__Group__0 : rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1 ;
    public final void rule__DynamicConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1847:1: ( rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1 )
            // InternalConfig.g:1848:2: rule__DynamicConfig__Group__0__Impl rule__DynamicConfig__Group__1
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
    // InternalConfig.g:1855:1: rule__DynamicConfig__Group__0__Impl : ( 'dynamic configuration' ) ;
    public final void rule__DynamicConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1859:1: ( ( 'dynamic configuration' ) )
            // InternalConfig.g:1860:1: ( 'dynamic configuration' )
            {
            // InternalConfig.g:1860:1: ( 'dynamic configuration' )
            // InternalConfig.g:1861:2: 'dynamic configuration'
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
    // InternalConfig.g:1870:1: rule__DynamicConfig__Group__1 : rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2 ;
    public final void rule__DynamicConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1874:1: ( rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2 )
            // InternalConfig.g:1875:2: rule__DynamicConfig__Group__1__Impl rule__DynamicConfig__Group__2
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
    // InternalConfig.g:1882:1: rule__DynamicConfig__Group__1__Impl : ( '{' ) ;
    public final void rule__DynamicConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1886:1: ( ( '{' ) )
            // InternalConfig.g:1887:1: ( '{' )
            {
            // InternalConfig.g:1887:1: ( '{' )
            // InternalConfig.g:1888:2: '{'
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
    // InternalConfig.g:1897:1: rule__DynamicConfig__Group__2 : rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3 ;
    public final void rule__DynamicConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1901:1: ( rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3 )
            // InternalConfig.g:1902:2: rule__DynamicConfig__Group__2__Impl rule__DynamicConfig__Group__3
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
    // InternalConfig.g:1909:1: rule__DynamicConfig__Group__2__Impl : ( ( rule__DynamicConfig__UnorderedGroup_2 ) ) ;
    public final void rule__DynamicConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1913:1: ( ( ( rule__DynamicConfig__UnorderedGroup_2 ) ) )
            // InternalConfig.g:1914:1: ( ( rule__DynamicConfig__UnorderedGroup_2 ) )
            {
            // InternalConfig.g:1914:1: ( ( rule__DynamicConfig__UnorderedGroup_2 ) )
            // InternalConfig.g:1915:2: ( rule__DynamicConfig__UnorderedGroup_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2()); 
            }
            // InternalConfig.g:1916:2: ( rule__DynamicConfig__UnorderedGroup_2 )
            // InternalConfig.g:1916:3: rule__DynamicConfig__UnorderedGroup_2
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
    // InternalConfig.g:1924:1: rule__DynamicConfig__Group__3 : rule__DynamicConfig__Group__3__Impl ;
    public final void rule__DynamicConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1928:1: ( rule__DynamicConfig__Group__3__Impl )
            // InternalConfig.g:1929:2: rule__DynamicConfig__Group__3__Impl
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
    // InternalConfig.g:1935:1: rule__DynamicConfig__Group__3__Impl : ( '}' ) ;
    public final void rule__DynamicConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1939:1: ( ( '}' ) )
            // InternalConfig.g:1940:1: ( '}' )
            {
            // InternalConfig.g:1940:1: ( '}' )
            // InternalConfig.g:1941:2: '}'
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
    // InternalConfig.g:1951:1: rule__DynamicConfig__Group_2_0_0__0 : rule__DynamicConfig__Group_2_0_0__0__Impl rule__DynamicConfig__Group_2_0_0__1 ;
    public final void rule__DynamicConfig__Group_2_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1955:1: ( rule__DynamicConfig__Group_2_0_0__0__Impl rule__DynamicConfig__Group_2_0_0__1 )
            // InternalConfig.g:1956:2: rule__DynamicConfig__Group_2_0_0__0__Impl rule__DynamicConfig__Group_2_0_0__1
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
    // InternalConfig.g:1963:1: rule__DynamicConfig__Group_2_0_0__0__Impl : ( 'file path' ) ;
    public final void rule__DynamicConfig__Group_2_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1967:1: ( ( 'file path' ) )
            // InternalConfig.g:1968:1: ( 'file path' )
            {
            // InternalConfig.g:1968:1: ( 'file path' )
            // InternalConfig.g:1969:2: 'file path'
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
    // InternalConfig.g:1978:1: rule__DynamicConfig__Group_2_0_0__1 : rule__DynamicConfig__Group_2_0_0__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1982:1: ( rule__DynamicConfig__Group_2_0_0__1__Impl )
            // InternalConfig.g:1983:2: rule__DynamicConfig__Group_2_0_0__1__Impl
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
    // InternalConfig.g:1989:1: rule__DynamicConfig__Group_2_0_0__1__Impl : ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:1993:1: ( ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) ) )
            // InternalConfig.g:1994:1: ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) )
            {
            // InternalConfig.g:1994:1: ( ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 ) )
            // InternalConfig.g:1995:2: ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getFilePathAssignment_2_0_0_1()); 
            }
            // InternalConfig.g:1996:2: ( rule__DynamicConfig__FilePathAssignment_2_0_0_1 )
            // InternalConfig.g:1996:3: rule__DynamicConfig__FilePathAssignment_2_0_0_1
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
    // InternalConfig.g:2005:1: rule__DynamicConfig__Group_2_0_1__0 : rule__DynamicConfig__Group_2_0_1__0__Impl rule__DynamicConfig__Group_2_0_1__1 ;
    public final void rule__DynamicConfig__Group_2_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2009:1: ( rule__DynamicConfig__Group_2_0_1__0__Impl rule__DynamicConfig__Group_2_0_1__1 )
            // InternalConfig.g:2010:2: rule__DynamicConfig__Group_2_0_1__0__Impl rule__DynamicConfig__Group_2_0_1__1
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
    // InternalConfig.g:2017:1: rule__DynamicConfig__Group_2_0_1__0__Impl : ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2021:1: ( ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) ) )
            // InternalConfig.g:2022:1: ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) )
            {
            // InternalConfig.g:2022:1: ( ( rule__DynamicConfig__Group_2_0_1_0__0 ) )
            // InternalConfig.g:2023:2: ( rule__DynamicConfig__Group_2_0_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_0()); 
            }
            // InternalConfig.g:2024:2: ( rule__DynamicConfig__Group_2_0_1_0__0 )
            // InternalConfig.g:2024:3: rule__DynamicConfig__Group_2_0_1_0__0
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
    // InternalConfig.g:2032:1: rule__DynamicConfig__Group_2_0_1__1 : rule__DynamicConfig__Group_2_0_1__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2036:1: ( rule__DynamicConfig__Group_2_0_1__1__Impl )
            // InternalConfig.g:2037:2: rule__DynamicConfig__Group_2_0_1__1__Impl
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
    // InternalConfig.g:2043:1: rule__DynamicConfig__Group_2_0_1__1__Impl : ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2047:1: ( ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) ) )
            // InternalConfig.g:2048:1: ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) )
            {
            // InternalConfig.g:2048:1: ( ( rule__DynamicConfig__Group_2_0_1_1__0 ) )
            // InternalConfig.g:2049:2: ( rule__DynamicConfig__Group_2_0_1_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_1()); 
            }
            // InternalConfig.g:2050:2: ( rule__DynamicConfig__Group_2_0_1_1__0 )
            // InternalConfig.g:2050:3: rule__DynamicConfig__Group_2_0_1_1__0
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
    // InternalConfig.g:2059:1: rule__DynamicConfig__Group_2_0_1_0__0 : rule__DynamicConfig__Group_2_0_1_0__0__Impl rule__DynamicConfig__Group_2_0_1_0__1 ;
    public final void rule__DynamicConfig__Group_2_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2063:1: ( rule__DynamicConfig__Group_2_0_1_0__0__Impl rule__DynamicConfig__Group_2_0_1_0__1 )
            // InternalConfig.g:2064:2: rule__DynamicConfig__Group_2_0_1_0__0__Impl rule__DynamicConfig__Group_2_0_1_0__1
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
    // InternalConfig.g:2071:1: rule__DynamicConfig__Group_2_0_1_0__0__Impl : ( 'user import' ) ;
    public final void rule__DynamicConfig__Group_2_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2075:1: ( ( 'user import' ) )
            // InternalConfig.g:2076:1: ( 'user import' )
            {
            // InternalConfig.g:2076:1: ( 'user import' )
            // InternalConfig.g:2077:2: 'user import'
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
    // InternalConfig.g:2086:1: rule__DynamicConfig__Group_2_0_1_0__1 : rule__DynamicConfig__Group_2_0_1_0__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2090:1: ( rule__DynamicConfig__Group_2_0_1_0__1__Impl )
            // InternalConfig.g:2091:2: rule__DynamicConfig__Group_2_0_1_0__1__Impl
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
    // InternalConfig.g:2097:1: rule__DynamicConfig__Group_2_0_1_0__1__Impl : ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2101:1: ( ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) ) )
            // InternalConfig.g:2102:1: ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) )
            {
            // InternalConfig.g:2102:1: ( ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 ) )
            // InternalConfig.g:2103:2: ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserCode1Assignment_2_0_1_0_1()); 
            }
            // InternalConfig.g:2104:2: ( rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 )
            // InternalConfig.g:2104:3: rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1
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
    // InternalConfig.g:2113:1: rule__DynamicConfig__Group_2_0_1_1__0 : rule__DynamicConfig__Group_2_0_1_1__0__Impl rule__DynamicConfig__Group_2_0_1_1__1 ;
    public final void rule__DynamicConfig__Group_2_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2117:1: ( rule__DynamicConfig__Group_2_0_1_1__0__Impl rule__DynamicConfig__Group_2_0_1_1__1 )
            // InternalConfig.g:2118:2: rule__DynamicConfig__Group_2_0_1_1__0__Impl rule__DynamicConfig__Group_2_0_1_1__1
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
    // InternalConfig.g:2125:1: rule__DynamicConfig__Group_2_0_1_1__0__Impl : ( 'user constructor' ) ;
    public final void rule__DynamicConfig__Group_2_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2129:1: ( ( 'user constructor' ) )
            // InternalConfig.g:2130:1: ( 'user constructor' )
            {
            // InternalConfig.g:2130:1: ( 'user constructor' )
            // InternalConfig.g:2131:2: 'user constructor'
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
    // InternalConfig.g:2140:1: rule__DynamicConfig__Group_2_0_1_1__1 : rule__DynamicConfig__Group_2_0_1_1__1__Impl ;
    public final void rule__DynamicConfig__Group_2_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2144:1: ( rule__DynamicConfig__Group_2_0_1_1__1__Impl )
            // InternalConfig.g:2145:2: rule__DynamicConfig__Group_2_0_1_1__1__Impl
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
    // InternalConfig.g:2151:1: rule__DynamicConfig__Group_2_0_1_1__1__Impl : ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2155:1: ( ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) ) )
            // InternalConfig.g:2156:1: ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) )
            {
            // InternalConfig.g:2156:1: ( ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 ) )
            // InternalConfig.g:2157:2: ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getUserCode2Assignment_2_0_1_1_1()); 
            }
            // InternalConfig.g:2158:2: ( rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 )
            // InternalConfig.g:2158:3: rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1
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
    // InternalConfig.g:2167:1: rule__DynamicConfig__Group_2_1__0 : rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1 ;
    public final void rule__DynamicConfig__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2171:1: ( rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1 )
            // InternalConfig.g:2172:2: rule__DynamicConfig__Group_2_1__0__Impl rule__DynamicConfig__Group_2_1__1
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
    // InternalConfig.g:2179:1: rule__DynamicConfig__Group_2_1__0__Impl : ( 'polling interval' ) ;
    public final void rule__DynamicConfig__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2183:1: ( ( 'polling interval' ) )
            // InternalConfig.g:2184:1: ( 'polling interval' )
            {
            // InternalConfig.g:2184:1: ( 'polling interval' )
            // InternalConfig.g:2185:2: 'polling interval'
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
    // InternalConfig.g:2194:1: rule__DynamicConfig__Group_2_1__1 : rule__DynamicConfig__Group_2_1__1__Impl ;
    public final void rule__DynamicConfig__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2198:1: ( rule__DynamicConfig__Group_2_1__1__Impl )
            // InternalConfig.g:2199:2: rule__DynamicConfig__Group_2_1__1__Impl
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
    // InternalConfig.g:2205:1: rule__DynamicConfig__Group_2_1__1__Impl : ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) ) ;
    public final void rule__DynamicConfig__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2209:1: ( ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) ) )
            // InternalConfig.g:2210:1: ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) )
            {
            // InternalConfig.g:2210:1: ( ( rule__DynamicConfig__PollingAssignment_2_1_1 ) )
            // InternalConfig.g:2211:2: ( rule__DynamicConfig__PollingAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDynamicConfigAccess().getPollingAssignment_2_1_1()); 
            }
            // InternalConfig.g:2212:2: ( rule__DynamicConfig__PollingAssignment_2_1_1 )
            // InternalConfig.g:2212:3: rule__DynamicConfig__PollingAssignment_2_1_1
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
    // InternalConfig.g:2221:1: rule__ActorClassConfig__Group__0 : rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1 ;
    public final void rule__ActorClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2225:1: ( rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1 )
            // InternalConfig.g:2226:2: rule__ActorClassConfig__Group__0__Impl rule__ActorClassConfig__Group__1
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
    // InternalConfig.g:2233:1: rule__ActorClassConfig__Group__0__Impl : ( 'ActorClassConfig' ) ;
    public final void rule__ActorClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2237:1: ( ( 'ActorClassConfig' ) )
            // InternalConfig.g:2238:1: ( 'ActorClassConfig' )
            {
            // InternalConfig.g:2238:1: ( 'ActorClassConfig' )
            // InternalConfig.g:2239:2: 'ActorClassConfig'
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
    // InternalConfig.g:2248:1: rule__ActorClassConfig__Group__1 : rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2 ;
    public final void rule__ActorClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2252:1: ( rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2 )
            // InternalConfig.g:2253:2: rule__ActorClassConfig__Group__1__Impl rule__ActorClassConfig__Group__2
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
    // InternalConfig.g:2260:1: rule__ActorClassConfig__Group__1__Impl : ( ( rule__ActorClassConfig__ActorAssignment_1 ) ) ;
    public final void rule__ActorClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2264:1: ( ( ( rule__ActorClassConfig__ActorAssignment_1 ) ) )
            // InternalConfig.g:2265:1: ( ( rule__ActorClassConfig__ActorAssignment_1 ) )
            {
            // InternalConfig.g:2265:1: ( ( rule__ActorClassConfig__ActorAssignment_1 ) )
            // InternalConfig.g:2266:2: ( rule__ActorClassConfig__ActorAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorAssignment_1()); 
            }
            // InternalConfig.g:2267:2: ( rule__ActorClassConfig__ActorAssignment_1 )
            // InternalConfig.g:2267:3: rule__ActorClassConfig__ActorAssignment_1
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
    // InternalConfig.g:2275:1: rule__ActorClassConfig__Group__2 : rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3 ;
    public final void rule__ActorClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2279:1: ( rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3 )
            // InternalConfig.g:2280:2: rule__ActorClassConfig__Group__2__Impl rule__ActorClassConfig__Group__3
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
    // InternalConfig.g:2287:1: rule__ActorClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__ActorClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2291:1: ( ( '{' ) )
            // InternalConfig.g:2292:1: ( '{' )
            {
            // InternalConfig.g:2292:1: ( '{' )
            // InternalConfig.g:2293:2: '{'
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
    // InternalConfig.g:2302:1: rule__ActorClassConfig__Group__3 : rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4 ;
    public final void rule__ActorClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2306:1: ( rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4 )
            // InternalConfig.g:2307:2: rule__ActorClassConfig__Group__3__Impl rule__ActorClassConfig__Group__4
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
    // InternalConfig.g:2314:1: rule__ActorClassConfig__Group__3__Impl : ( ( rule__ActorClassConfig__AttributesAssignment_3 )* ) ;
    public final void rule__ActorClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2318:1: ( ( ( rule__ActorClassConfig__AttributesAssignment_3 )* ) )
            // InternalConfig.g:2319:1: ( ( rule__ActorClassConfig__AttributesAssignment_3 )* )
            {
            // InternalConfig.g:2319:1: ( ( rule__ActorClassConfig__AttributesAssignment_3 )* )
            // InternalConfig.g:2320:2: ( rule__ActorClassConfig__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getAttributesAssignment_3()); 
            }
            // InternalConfig.g:2321:2: ( rule__ActorClassConfig__AttributesAssignment_3 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==42) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalConfig.g:2321:3: rule__ActorClassConfig__AttributesAssignment_3
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
    // InternalConfig.g:2329:1: rule__ActorClassConfig__Group__4 : rule__ActorClassConfig__Group__4__Impl ;
    public final void rule__ActorClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2333:1: ( rule__ActorClassConfig__Group__4__Impl )
            // InternalConfig.g:2334:2: rule__ActorClassConfig__Group__4__Impl
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
    // InternalConfig.g:2340:1: rule__ActorClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__ActorClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2344:1: ( ( '}' ) )
            // InternalConfig.g:2345:1: ( '}' )
            {
            // InternalConfig.g:2345:1: ( '}' )
            // InternalConfig.g:2346:2: '}'
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
    // InternalConfig.g:2356:1: rule__ActorInstanceConfig__Group__0 : rule__ActorInstanceConfig__Group__0__Impl rule__ActorInstanceConfig__Group__1 ;
    public final void rule__ActorInstanceConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2360:1: ( rule__ActorInstanceConfig__Group__0__Impl rule__ActorInstanceConfig__Group__1 )
            // InternalConfig.g:2361:2: rule__ActorInstanceConfig__Group__0__Impl rule__ActorInstanceConfig__Group__1
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
    // InternalConfig.g:2368:1: rule__ActorInstanceConfig__Group__0__Impl : ( 'ActorInstanceConfig' ) ;
    public final void rule__ActorInstanceConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2372:1: ( ( 'ActorInstanceConfig' ) )
            // InternalConfig.g:2373:1: ( 'ActorInstanceConfig' )
            {
            // InternalConfig.g:2373:1: ( 'ActorInstanceConfig' )
            // InternalConfig.g:2374:2: 'ActorInstanceConfig'
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
    // InternalConfig.g:2383:1: rule__ActorInstanceConfig__Group__1 : rule__ActorInstanceConfig__Group__1__Impl rule__ActorInstanceConfig__Group__2 ;
    public final void rule__ActorInstanceConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2387:1: ( rule__ActorInstanceConfig__Group__1__Impl rule__ActorInstanceConfig__Group__2 )
            // InternalConfig.g:2388:2: rule__ActorInstanceConfig__Group__1__Impl rule__ActorInstanceConfig__Group__2
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
    // InternalConfig.g:2395:1: rule__ActorInstanceConfig__Group__1__Impl : ( ( rule__ActorInstanceConfig__RootAssignment_1 ) ) ;
    public final void rule__ActorInstanceConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2399:1: ( ( ( rule__ActorInstanceConfig__RootAssignment_1 ) ) )
            // InternalConfig.g:2400:1: ( ( rule__ActorInstanceConfig__RootAssignment_1 ) )
            {
            // InternalConfig.g:2400:1: ( ( rule__ActorInstanceConfig__RootAssignment_1 ) )
            // InternalConfig.g:2401:2: ( rule__ActorInstanceConfig__RootAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRootAssignment_1()); 
            }
            // InternalConfig.g:2402:2: ( rule__ActorInstanceConfig__RootAssignment_1 )
            // InternalConfig.g:2402:3: rule__ActorInstanceConfig__RootAssignment_1
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
    // InternalConfig.g:2410:1: rule__ActorInstanceConfig__Group__2 : rule__ActorInstanceConfig__Group__2__Impl rule__ActorInstanceConfig__Group__3 ;
    public final void rule__ActorInstanceConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2414:1: ( rule__ActorInstanceConfig__Group__2__Impl rule__ActorInstanceConfig__Group__3 )
            // InternalConfig.g:2415:2: rule__ActorInstanceConfig__Group__2__Impl rule__ActorInstanceConfig__Group__3
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
    // InternalConfig.g:2422:1: rule__ActorInstanceConfig__Group__2__Impl : ( '/' ) ;
    public final void rule__ActorInstanceConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2426:1: ( ( '/' ) )
            // InternalConfig.g:2427:1: ( '/' )
            {
            // InternalConfig.g:2427:1: ( '/' )
            // InternalConfig.g:2428:2: '/'
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
    // InternalConfig.g:2437:1: rule__ActorInstanceConfig__Group__3 : rule__ActorInstanceConfig__Group__3__Impl rule__ActorInstanceConfig__Group__4 ;
    public final void rule__ActorInstanceConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2441:1: ( rule__ActorInstanceConfig__Group__3__Impl rule__ActorInstanceConfig__Group__4 )
            // InternalConfig.g:2442:2: rule__ActorInstanceConfig__Group__3__Impl rule__ActorInstanceConfig__Group__4
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
    // InternalConfig.g:2449:1: rule__ActorInstanceConfig__Group__3__Impl : ( ( rule__ActorInstanceConfig__SubSystemAssignment_3 ) ) ;
    public final void rule__ActorInstanceConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2453:1: ( ( ( rule__ActorInstanceConfig__SubSystemAssignment_3 ) ) )
            // InternalConfig.g:2454:1: ( ( rule__ActorInstanceConfig__SubSystemAssignment_3 ) )
            {
            // InternalConfig.g:2454:1: ( ( rule__ActorInstanceConfig__SubSystemAssignment_3 ) )
            // InternalConfig.g:2455:2: ( rule__ActorInstanceConfig__SubSystemAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getSubSystemAssignment_3()); 
            }
            // InternalConfig.g:2456:2: ( rule__ActorInstanceConfig__SubSystemAssignment_3 )
            // InternalConfig.g:2456:3: rule__ActorInstanceConfig__SubSystemAssignment_3
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
    // InternalConfig.g:2464:1: rule__ActorInstanceConfig__Group__4 : rule__ActorInstanceConfig__Group__4__Impl rule__ActorInstanceConfig__Group__5 ;
    public final void rule__ActorInstanceConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2468:1: ( rule__ActorInstanceConfig__Group__4__Impl rule__ActorInstanceConfig__Group__5 )
            // InternalConfig.g:2469:2: rule__ActorInstanceConfig__Group__4__Impl rule__ActorInstanceConfig__Group__5
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
    // InternalConfig.g:2476:1: rule__ActorInstanceConfig__Group__4__Impl : ( '/' ) ;
    public final void rule__ActorInstanceConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2480:1: ( ( '/' ) )
            // InternalConfig.g:2481:1: ( '/' )
            {
            // InternalConfig.g:2481:1: ( '/' )
            // InternalConfig.g:2482:2: '/'
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
    // InternalConfig.g:2491:1: rule__ActorInstanceConfig__Group__5 : rule__ActorInstanceConfig__Group__5__Impl rule__ActorInstanceConfig__Group__6 ;
    public final void rule__ActorInstanceConfig__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2495:1: ( rule__ActorInstanceConfig__Group__5__Impl rule__ActorInstanceConfig__Group__6 )
            // InternalConfig.g:2496:2: rule__ActorInstanceConfig__Group__5__Impl rule__ActorInstanceConfig__Group__6
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
    // InternalConfig.g:2503:1: rule__ActorInstanceConfig__Group__5__Impl : ( ( rule__ActorInstanceConfig__PathAssignment_5 ) ) ;
    public final void rule__ActorInstanceConfig__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2507:1: ( ( ( rule__ActorInstanceConfig__PathAssignment_5 ) ) )
            // InternalConfig.g:2508:1: ( ( rule__ActorInstanceConfig__PathAssignment_5 ) )
            {
            // InternalConfig.g:2508:1: ( ( rule__ActorInstanceConfig__PathAssignment_5 ) )
            // InternalConfig.g:2509:2: ( rule__ActorInstanceConfig__PathAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getPathAssignment_5()); 
            }
            // InternalConfig.g:2510:2: ( rule__ActorInstanceConfig__PathAssignment_5 )
            // InternalConfig.g:2510:3: rule__ActorInstanceConfig__PathAssignment_5
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
    // InternalConfig.g:2518:1: rule__ActorInstanceConfig__Group__6 : rule__ActorInstanceConfig__Group__6__Impl rule__ActorInstanceConfig__Group__7 ;
    public final void rule__ActorInstanceConfig__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2522:1: ( rule__ActorInstanceConfig__Group__6__Impl rule__ActorInstanceConfig__Group__7 )
            // InternalConfig.g:2523:2: rule__ActorInstanceConfig__Group__6__Impl rule__ActorInstanceConfig__Group__7
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
    // InternalConfig.g:2530:1: rule__ActorInstanceConfig__Group__6__Impl : ( '{' ) ;
    public final void rule__ActorInstanceConfig__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2534:1: ( ( '{' ) )
            // InternalConfig.g:2535:1: ( '{' )
            {
            // InternalConfig.g:2535:1: ( '{' )
            // InternalConfig.g:2536:2: '{'
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
    // InternalConfig.g:2545:1: rule__ActorInstanceConfig__Group__7 : rule__ActorInstanceConfig__Group__7__Impl rule__ActorInstanceConfig__Group__8 ;
    public final void rule__ActorInstanceConfig__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2549:1: ( rule__ActorInstanceConfig__Group__7__Impl rule__ActorInstanceConfig__Group__8 )
            // InternalConfig.g:2550:2: rule__ActorInstanceConfig__Group__7__Impl rule__ActorInstanceConfig__Group__8
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
    // InternalConfig.g:2557:1: rule__ActorInstanceConfig__Group__7__Impl : ( ( rule__ActorInstanceConfig__UnorderedGroup_7 ) ) ;
    public final void rule__ActorInstanceConfig__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2561:1: ( ( ( rule__ActorInstanceConfig__UnorderedGroup_7 ) ) )
            // InternalConfig.g:2562:1: ( ( rule__ActorInstanceConfig__UnorderedGroup_7 ) )
            {
            // InternalConfig.g:2562:1: ( ( rule__ActorInstanceConfig__UnorderedGroup_7 ) )
            // InternalConfig.g:2563:2: ( rule__ActorInstanceConfig__UnorderedGroup_7 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7()); 
            }
            // InternalConfig.g:2564:2: ( rule__ActorInstanceConfig__UnorderedGroup_7 )
            // InternalConfig.g:2564:3: rule__ActorInstanceConfig__UnorderedGroup_7
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
    // InternalConfig.g:2572:1: rule__ActorInstanceConfig__Group__8 : rule__ActorInstanceConfig__Group__8__Impl ;
    public final void rule__ActorInstanceConfig__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2576:1: ( rule__ActorInstanceConfig__Group__8__Impl )
            // InternalConfig.g:2577:2: rule__ActorInstanceConfig__Group__8__Impl
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
    // InternalConfig.g:2583:1: rule__ActorInstanceConfig__Group__8__Impl : ( '}' ) ;
    public final void rule__ActorInstanceConfig__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2587:1: ( ( '}' ) )
            // InternalConfig.g:2588:1: ( '}' )
            {
            // InternalConfig.g:2588:1: ( '}' )
            // InternalConfig.g:2589:2: '}'
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
    // InternalConfig.g:2599:1: rule__ProtocolClassConfig__Group__0 : rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1 ;
    public final void rule__ProtocolClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2603:1: ( rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1 )
            // InternalConfig.g:2604:2: rule__ProtocolClassConfig__Group__0__Impl rule__ProtocolClassConfig__Group__1
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
    // InternalConfig.g:2611:1: rule__ProtocolClassConfig__Group__0__Impl : ( 'ProtocolClassConfig' ) ;
    public final void rule__ProtocolClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2615:1: ( ( 'ProtocolClassConfig' ) )
            // InternalConfig.g:2616:1: ( 'ProtocolClassConfig' )
            {
            // InternalConfig.g:2616:1: ( 'ProtocolClassConfig' )
            // InternalConfig.g:2617:2: 'ProtocolClassConfig'
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
    // InternalConfig.g:2626:1: rule__ProtocolClassConfig__Group__1 : rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2 ;
    public final void rule__ProtocolClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2630:1: ( rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2 )
            // InternalConfig.g:2631:2: rule__ProtocolClassConfig__Group__1__Impl rule__ProtocolClassConfig__Group__2
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
    // InternalConfig.g:2638:1: rule__ProtocolClassConfig__Group__1__Impl : ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2642:1: ( ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) ) )
            // InternalConfig.g:2643:1: ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) )
            {
            // InternalConfig.g:2643:1: ( ( rule__ProtocolClassConfig__ProtocolAssignment_1 ) )
            // InternalConfig.g:2644:2: ( rule__ProtocolClassConfig__ProtocolAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolAssignment_1()); 
            }
            // InternalConfig.g:2645:2: ( rule__ProtocolClassConfig__ProtocolAssignment_1 )
            // InternalConfig.g:2645:3: rule__ProtocolClassConfig__ProtocolAssignment_1
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
    // InternalConfig.g:2653:1: rule__ProtocolClassConfig__Group__2 : rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3 ;
    public final void rule__ProtocolClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2657:1: ( rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3 )
            // InternalConfig.g:2658:2: rule__ProtocolClassConfig__Group__2__Impl rule__ProtocolClassConfig__Group__3
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
    // InternalConfig.g:2665:1: rule__ProtocolClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__ProtocolClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2669:1: ( ( '{' ) )
            // InternalConfig.g:2670:1: ( '{' )
            {
            // InternalConfig.g:2670:1: ( '{' )
            // InternalConfig.g:2671:2: '{'
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
    // InternalConfig.g:2680:1: rule__ProtocolClassConfig__Group__3 : rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4 ;
    public final void rule__ProtocolClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2684:1: ( rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4 )
            // InternalConfig.g:2685:2: rule__ProtocolClassConfig__Group__3__Impl rule__ProtocolClassConfig__Group__4
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
    // InternalConfig.g:2692:1: rule__ProtocolClassConfig__Group__3__Impl : ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) ) ;
    public final void rule__ProtocolClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2696:1: ( ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) ) )
            // InternalConfig.g:2697:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) )
            {
            // InternalConfig.g:2697:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3 ) )
            // InternalConfig.g:2698:2: ( rule__ProtocolClassConfig__UnorderedGroup_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3()); 
            }
            // InternalConfig.g:2699:2: ( rule__ProtocolClassConfig__UnorderedGroup_3 )
            // InternalConfig.g:2699:3: rule__ProtocolClassConfig__UnorderedGroup_3
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
    // InternalConfig.g:2707:1: rule__ProtocolClassConfig__Group__4 : rule__ProtocolClassConfig__Group__4__Impl ;
    public final void rule__ProtocolClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2711:1: ( rule__ProtocolClassConfig__Group__4__Impl )
            // InternalConfig.g:2712:2: rule__ProtocolClassConfig__Group__4__Impl
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
    // InternalConfig.g:2718:1: rule__ProtocolClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__ProtocolClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2722:1: ( ( '}' ) )
            // InternalConfig.g:2723:1: ( '}' )
            {
            // InternalConfig.g:2723:1: ( '}' )
            // InternalConfig.g:2724:2: '}'
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
    // InternalConfig.g:2734:1: rule__ProtocolClassConfig__Group_3_0__0 : rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1 ;
    public final void rule__ProtocolClassConfig__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2738:1: ( rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1 )
            // InternalConfig.g:2739:2: rule__ProtocolClassConfig__Group_3_0__0__Impl rule__ProtocolClassConfig__Group_3_0__1
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
    // InternalConfig.g:2746:1: rule__ProtocolClassConfig__Group_3_0__0__Impl : ( 'regular' ) ;
    public final void rule__ProtocolClassConfig__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2750:1: ( ( 'regular' ) )
            // InternalConfig.g:2751:1: ( 'regular' )
            {
            // InternalConfig.g:2751:1: ( 'regular' )
            // InternalConfig.g:2752:2: 'regular'
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
    // InternalConfig.g:2761:1: rule__ProtocolClassConfig__Group_3_0__1 : rule__ProtocolClassConfig__Group_3_0__1__Impl ;
    public final void rule__ProtocolClassConfig__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2765:1: ( rule__ProtocolClassConfig__Group_3_0__1__Impl )
            // InternalConfig.g:2766:2: rule__ProtocolClassConfig__Group_3_0__1__Impl
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
    // InternalConfig.g:2772:1: rule__ProtocolClassConfig__Group_3_0__1__Impl : ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2776:1: ( ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) ) )
            // InternalConfig.g:2777:1: ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) )
            {
            // InternalConfig.g:2777:1: ( ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 ) )
            // InternalConfig.g:2778:2: ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getRegularAssignment_3_0_1()); 
            }
            // InternalConfig.g:2779:2: ( rule__ProtocolClassConfig__RegularAssignment_3_0_1 )
            // InternalConfig.g:2779:3: rule__ProtocolClassConfig__RegularAssignment_3_0_1
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
    // InternalConfig.g:2788:1: rule__ProtocolClassConfig__Group_3_1__0 : rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1 ;
    public final void rule__ProtocolClassConfig__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2792:1: ( rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1 )
            // InternalConfig.g:2793:2: rule__ProtocolClassConfig__Group_3_1__0__Impl rule__ProtocolClassConfig__Group_3_1__1
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
    // InternalConfig.g:2800:1: rule__ProtocolClassConfig__Group_3_1__0__Impl : ( ( rule__ProtocolClassConfig__Alternatives_3_1_0 ) ) ;
    public final void rule__ProtocolClassConfig__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2804:1: ( ( ( rule__ProtocolClassConfig__Alternatives_3_1_0 ) ) )
            // InternalConfig.g:2805:1: ( ( rule__ProtocolClassConfig__Alternatives_3_1_0 ) )
            {
            // InternalConfig.g:2805:1: ( ( rule__ProtocolClassConfig__Alternatives_3_1_0 ) )
            // InternalConfig.g:2806:2: ( rule__ProtocolClassConfig__Alternatives_3_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getAlternatives_3_1_0()); 
            }
            // InternalConfig.g:2807:2: ( rule__ProtocolClassConfig__Alternatives_3_1_0 )
            // InternalConfig.g:2807:3: rule__ProtocolClassConfig__Alternatives_3_1_0
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
    // InternalConfig.g:2815:1: rule__ProtocolClassConfig__Group_3_1__1 : rule__ProtocolClassConfig__Group_3_1__1__Impl ;
    public final void rule__ProtocolClassConfig__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2819:1: ( rule__ProtocolClassConfig__Group_3_1__1__Impl )
            // InternalConfig.g:2820:2: rule__ProtocolClassConfig__Group_3_1__1__Impl
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
    // InternalConfig.g:2826:1: rule__ProtocolClassConfig__Group_3_1__1__Impl : ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) ) ;
    public final void rule__ProtocolClassConfig__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2830:1: ( ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) ) )
            // InternalConfig.g:2831:1: ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) )
            {
            // InternalConfig.g:2831:1: ( ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 ) )
            // InternalConfig.g:2832:2: ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getConjugatedAssignment_3_1_1()); 
            }
            // InternalConfig.g:2833:2: ( rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 )
            // InternalConfig.g:2833:3: rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1
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
    // InternalConfig.g:2842:1: rule__PortClassConfig__Group__0 : rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1 ;
    public final void rule__PortClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2846:1: ( rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1 )
            // InternalConfig.g:2847:2: rule__PortClassConfig__Group__0__Impl rule__PortClassConfig__Group__1
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
    // InternalConfig.g:2854:1: rule__PortClassConfig__Group__0__Impl : ( () ) ;
    public final void rule__PortClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2858:1: ( ( () ) )
            // InternalConfig.g:2859:1: ( () )
            {
            // InternalConfig.g:2859:1: ( () )
            // InternalConfig.g:2860:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getPortClassConfigAction_0()); 
            }
            // InternalConfig.g:2861:2: ()
            // InternalConfig.g:2861:3: 
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
    // InternalConfig.g:2869:1: rule__PortClassConfig__Group__1 : rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2 ;
    public final void rule__PortClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2873:1: ( rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2 )
            // InternalConfig.g:2874:2: rule__PortClassConfig__Group__1__Impl rule__PortClassConfig__Group__2
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
    // InternalConfig.g:2881:1: rule__PortClassConfig__Group__1__Impl : ( 'Port' ) ;
    public final void rule__PortClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2885:1: ( ( 'Port' ) )
            // InternalConfig.g:2886:1: ( 'Port' )
            {
            // InternalConfig.g:2886:1: ( 'Port' )
            // InternalConfig.g:2887:2: 'Port'
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
    // InternalConfig.g:2896:1: rule__PortClassConfig__Group__2 : rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3 ;
    public final void rule__PortClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2900:1: ( rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3 )
            // InternalConfig.g:2901:2: rule__PortClassConfig__Group__2__Impl rule__PortClassConfig__Group__3
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
    // InternalConfig.g:2908:1: rule__PortClassConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__PortClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2912:1: ( ( '{' ) )
            // InternalConfig.g:2913:1: ( '{' )
            {
            // InternalConfig.g:2913:1: ( '{' )
            // InternalConfig.g:2914:2: '{'
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
    // InternalConfig.g:2923:1: rule__PortClassConfig__Group__3 : rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4 ;
    public final void rule__PortClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2927:1: ( rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4 )
            // InternalConfig.g:2928:2: rule__PortClassConfig__Group__3__Impl rule__PortClassConfig__Group__4
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
    // InternalConfig.g:2935:1: rule__PortClassConfig__Group__3__Impl : ( ( rule__PortClassConfig__AttributesAssignment_3 )* ) ;
    public final void rule__PortClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2939:1: ( ( ( rule__PortClassConfig__AttributesAssignment_3 )* ) )
            // InternalConfig.g:2940:1: ( ( rule__PortClassConfig__AttributesAssignment_3 )* )
            {
            // InternalConfig.g:2940:1: ( ( rule__PortClassConfig__AttributesAssignment_3 )* )
            // InternalConfig.g:2941:2: ( rule__PortClassConfig__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortClassConfigAccess().getAttributesAssignment_3()); 
            }
            // InternalConfig.g:2942:2: ( rule__PortClassConfig__AttributesAssignment_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==42) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalConfig.g:2942:3: rule__PortClassConfig__AttributesAssignment_3
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
    // InternalConfig.g:2950:1: rule__PortClassConfig__Group__4 : rule__PortClassConfig__Group__4__Impl ;
    public final void rule__PortClassConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2954:1: ( rule__PortClassConfig__Group__4__Impl )
            // InternalConfig.g:2955:2: rule__PortClassConfig__Group__4__Impl
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
    // InternalConfig.g:2961:1: rule__PortClassConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__PortClassConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2965:1: ( ( '}' ) )
            // InternalConfig.g:2966:1: ( '}' )
            {
            // InternalConfig.g:2966:1: ( '}' )
            // InternalConfig.g:2967:2: '}'
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
    // InternalConfig.g:2977:1: rule__PortInstanceConfig__Group__0 : rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1 ;
    public final void rule__PortInstanceConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2981:1: ( rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1 )
            // InternalConfig.g:2982:2: rule__PortInstanceConfig__Group__0__Impl rule__PortInstanceConfig__Group__1
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
    // InternalConfig.g:2989:1: rule__PortInstanceConfig__Group__0__Impl : ( 'InterfaceItem' ) ;
    public final void rule__PortInstanceConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:2993:1: ( ( 'InterfaceItem' ) )
            // InternalConfig.g:2994:1: ( 'InterfaceItem' )
            {
            // InternalConfig.g:2994:1: ( 'InterfaceItem' )
            // InternalConfig.g:2995:2: 'InterfaceItem'
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
    // InternalConfig.g:3004:1: rule__PortInstanceConfig__Group__1 : rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2 ;
    public final void rule__PortInstanceConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3008:1: ( rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2 )
            // InternalConfig.g:3009:2: rule__PortInstanceConfig__Group__1__Impl rule__PortInstanceConfig__Group__2
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
    // InternalConfig.g:3016:1: rule__PortInstanceConfig__Group__1__Impl : ( ( rule__PortInstanceConfig__ItemAssignment_1 ) ) ;
    public final void rule__PortInstanceConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3020:1: ( ( ( rule__PortInstanceConfig__ItemAssignment_1 ) ) )
            // InternalConfig.g:3021:1: ( ( rule__PortInstanceConfig__ItemAssignment_1 ) )
            {
            // InternalConfig.g:3021:1: ( ( rule__PortInstanceConfig__ItemAssignment_1 ) )
            // InternalConfig.g:3022:2: ( rule__PortInstanceConfig__ItemAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getItemAssignment_1()); 
            }
            // InternalConfig.g:3023:2: ( rule__PortInstanceConfig__ItemAssignment_1 )
            // InternalConfig.g:3023:3: rule__PortInstanceConfig__ItemAssignment_1
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
    // InternalConfig.g:3031:1: rule__PortInstanceConfig__Group__2 : rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3 ;
    public final void rule__PortInstanceConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3035:1: ( rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3 )
            // InternalConfig.g:3036:2: rule__PortInstanceConfig__Group__2__Impl rule__PortInstanceConfig__Group__3
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
    // InternalConfig.g:3043:1: rule__PortInstanceConfig__Group__2__Impl : ( '{' ) ;
    public final void rule__PortInstanceConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3047:1: ( ( '{' ) )
            // InternalConfig.g:3048:1: ( '{' )
            {
            // InternalConfig.g:3048:1: ( '{' )
            // InternalConfig.g:3049:2: '{'
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
    // InternalConfig.g:3058:1: rule__PortInstanceConfig__Group__3 : rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4 ;
    public final void rule__PortInstanceConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3062:1: ( rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4 )
            // InternalConfig.g:3063:2: rule__PortInstanceConfig__Group__3__Impl rule__PortInstanceConfig__Group__4
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
    // InternalConfig.g:3070:1: rule__PortInstanceConfig__Group__3__Impl : ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* ) ;
    public final void rule__PortInstanceConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3074:1: ( ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* ) )
            // InternalConfig.g:3075:1: ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* )
            {
            // InternalConfig.g:3075:1: ( ( rule__PortInstanceConfig__AttributesAssignment_3 )* )
            // InternalConfig.g:3076:2: ( rule__PortInstanceConfig__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getAttributesAssignment_3()); 
            }
            // InternalConfig.g:3077:2: ( rule__PortInstanceConfig__AttributesAssignment_3 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==42) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalConfig.g:3077:3: rule__PortInstanceConfig__AttributesAssignment_3
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
    // InternalConfig.g:3085:1: rule__PortInstanceConfig__Group__4 : rule__PortInstanceConfig__Group__4__Impl ;
    public final void rule__PortInstanceConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3089:1: ( rule__PortInstanceConfig__Group__4__Impl )
            // InternalConfig.g:3090:2: rule__PortInstanceConfig__Group__4__Impl
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
    // InternalConfig.g:3096:1: rule__PortInstanceConfig__Group__4__Impl : ( '}' ) ;
    public final void rule__PortInstanceConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3100:1: ( ( '}' ) )
            // InternalConfig.g:3101:1: ( '}' )
            {
            // InternalConfig.g:3101:1: ( '}' )
            // InternalConfig.g:3102:2: '}'
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
    // InternalConfig.g:3112:1: rule__AttrClassConfig__Group__0 : rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1 ;
    public final void rule__AttrClassConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3116:1: ( rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1 )
            // InternalConfig.g:3117:2: rule__AttrClassConfig__Group__0__Impl rule__AttrClassConfig__Group__1
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
    // InternalConfig.g:3124:1: rule__AttrClassConfig__Group__0__Impl : ( 'Attr' ) ;
    public final void rule__AttrClassConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3128:1: ( ( 'Attr' ) )
            // InternalConfig.g:3129:1: ( 'Attr' )
            {
            // InternalConfig.g:3129:1: ( 'Attr' )
            // InternalConfig.g:3130:2: 'Attr'
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
    // InternalConfig.g:3139:1: rule__AttrClassConfig__Group__1 : rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2 ;
    public final void rule__AttrClassConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3143:1: ( rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2 )
            // InternalConfig.g:3144:2: rule__AttrClassConfig__Group__1__Impl rule__AttrClassConfig__Group__2
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
    // InternalConfig.g:3151:1: rule__AttrClassConfig__Group__1__Impl : ( ( rule__AttrClassConfig__AttributeAssignment_1 ) ) ;
    public final void rule__AttrClassConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3155:1: ( ( ( rule__AttrClassConfig__AttributeAssignment_1 ) ) )
            // InternalConfig.g:3156:1: ( ( rule__AttrClassConfig__AttributeAssignment_1 ) )
            {
            // InternalConfig.g:3156:1: ( ( rule__AttrClassConfig__AttributeAssignment_1 ) )
            // InternalConfig.g:3157:2: ( rule__AttrClassConfig__AttributeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributeAssignment_1()); 
            }
            // InternalConfig.g:3158:2: ( rule__AttrClassConfig__AttributeAssignment_1 )
            // InternalConfig.g:3158:3: rule__AttrClassConfig__AttributeAssignment_1
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
    // InternalConfig.g:3166:1: rule__AttrClassConfig__Group__2 : rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3 ;
    public final void rule__AttrClassConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3170:1: ( rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3 )
            // InternalConfig.g:3171:2: rule__AttrClassConfig__Group__2__Impl rule__AttrClassConfig__Group__3
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
    // InternalConfig.g:3178:1: rule__AttrClassConfig__Group__2__Impl : ( ( rule__AttrClassConfig__Group_2__0 )? ) ;
    public final void rule__AttrClassConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3182:1: ( ( ( rule__AttrClassConfig__Group_2__0 )? ) )
            // InternalConfig.g:3183:1: ( ( rule__AttrClassConfig__Group_2__0 )? )
            {
            // InternalConfig.g:3183:1: ( ( rule__AttrClassConfig__Group_2__0 )? )
            // InternalConfig.g:3184:2: ( rule__AttrClassConfig__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_2()); 
            }
            // InternalConfig.g:3185:2: ( rule__AttrClassConfig__Group_2__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==43) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalConfig.g:3185:3: rule__AttrClassConfig__Group_2__0
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
    // InternalConfig.g:3193:1: rule__AttrClassConfig__Group__3 : rule__AttrClassConfig__Group__3__Impl ;
    public final void rule__AttrClassConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3197:1: ( rule__AttrClassConfig__Group__3__Impl )
            // InternalConfig.g:3198:2: rule__AttrClassConfig__Group__3__Impl
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
    // InternalConfig.g:3204:1: rule__AttrClassConfig__Group__3__Impl : ( ( rule__AttrClassConfig__Group_3__0 )? ) ;
    public final void rule__AttrClassConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3208:1: ( ( ( rule__AttrClassConfig__Group_3__0 )? ) )
            // InternalConfig.g:3209:1: ( ( rule__AttrClassConfig__Group_3__0 )? )
            {
            // InternalConfig.g:3209:1: ( ( rule__AttrClassConfig__Group_3__0 )? )
            // InternalConfig.g:3210:2: ( rule__AttrClassConfig__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_3()); 
            }
            // InternalConfig.g:3211:2: ( rule__AttrClassConfig__Group_3__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==27) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalConfig.g:3211:3: rule__AttrClassConfig__Group_3__0
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
    // InternalConfig.g:3220:1: rule__AttrClassConfig__Group_2__0 : rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1 ;
    public final void rule__AttrClassConfig__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3224:1: ( rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1 )
            // InternalConfig.g:3225:2: rule__AttrClassConfig__Group_2__0__Impl rule__AttrClassConfig__Group_2__1
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
    // InternalConfig.g:3232:1: rule__AttrClassConfig__Group_2__0__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3236:1: ( ( '=' ) )
            // InternalConfig.g:3237:1: ( '=' )
            {
            // InternalConfig.g:3237:1: ( '=' )
            // InternalConfig.g:3238:2: '='
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
    // InternalConfig.g:3247:1: rule__AttrClassConfig__Group_2__1 : rule__AttrClassConfig__Group_2__1__Impl ;
    public final void rule__AttrClassConfig__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3251:1: ( rule__AttrClassConfig__Group_2__1__Impl )
            // InternalConfig.g:3252:2: rule__AttrClassConfig__Group_2__1__Impl
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
    // InternalConfig.g:3258:1: rule__AttrClassConfig__Group_2__1__Impl : ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) ) ;
    public final void rule__AttrClassConfig__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3262:1: ( ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) ) )
            // InternalConfig.g:3263:1: ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) )
            {
            // InternalConfig.g:3263:1: ( ( rule__AttrClassConfig__ValueAssignment_2_1 ) )
            // InternalConfig.g:3264:2: ( rule__AttrClassConfig__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getValueAssignment_2_1()); 
            }
            // InternalConfig.g:3265:2: ( rule__AttrClassConfig__ValueAssignment_2_1 )
            // InternalConfig.g:3265:3: rule__AttrClassConfig__ValueAssignment_2_1
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
    // InternalConfig.g:3274:1: rule__AttrClassConfig__Group_3__0 : rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1 ;
    public final void rule__AttrClassConfig__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3278:1: ( rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1 )
            // InternalConfig.g:3279:2: rule__AttrClassConfig__Group_3__0__Impl rule__AttrClassConfig__Group_3__1
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
    // InternalConfig.g:3286:1: rule__AttrClassConfig__Group_3__0__Impl : ( '{' ) ;
    public final void rule__AttrClassConfig__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3290:1: ( ( '{' ) )
            // InternalConfig.g:3291:1: ( '{' )
            {
            // InternalConfig.g:3291:1: ( '{' )
            // InternalConfig.g:3292:2: '{'
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
    // InternalConfig.g:3301:1: rule__AttrClassConfig__Group_3__1 : rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2 ;
    public final void rule__AttrClassConfig__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3305:1: ( rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2 )
            // InternalConfig.g:3306:2: rule__AttrClassConfig__Group_3__1__Impl rule__AttrClassConfig__Group_3__2
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
    // InternalConfig.g:3313:1: rule__AttrClassConfig__Group_3__1__Impl : ( ( rule__AttrClassConfig__Group_3_1__0 ) ) ;
    public final void rule__AttrClassConfig__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3317:1: ( ( ( rule__AttrClassConfig__Group_3_1__0 ) ) )
            // InternalConfig.g:3318:1: ( ( rule__AttrClassConfig__Group_3_1__0 ) )
            {
            // InternalConfig.g:3318:1: ( ( rule__AttrClassConfig__Group_3_1__0 ) )
            // InternalConfig.g:3319:2: ( rule__AttrClassConfig__Group_3_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_3_1()); 
            }
            // InternalConfig.g:3320:2: ( rule__AttrClassConfig__Group_3_1__0 )
            // InternalConfig.g:3320:3: rule__AttrClassConfig__Group_3_1__0
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
    // InternalConfig.g:3328:1: rule__AttrClassConfig__Group_3__2 : rule__AttrClassConfig__Group_3__2__Impl ;
    public final void rule__AttrClassConfig__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3332:1: ( rule__AttrClassConfig__Group_3__2__Impl )
            // InternalConfig.g:3333:2: rule__AttrClassConfig__Group_3__2__Impl
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
    // InternalConfig.g:3339:1: rule__AttrClassConfig__Group_3__2__Impl : ( '}' ) ;
    public final void rule__AttrClassConfig__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3343:1: ( ( '}' ) )
            // InternalConfig.g:3344:1: ( '}' )
            {
            // InternalConfig.g:3344:1: ( '}' )
            // InternalConfig.g:3345:2: '}'
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
    // InternalConfig.g:3355:1: rule__AttrClassConfig__Group_3_1__0 : rule__AttrClassConfig__Group_3_1__0__Impl rule__AttrClassConfig__Group_3_1__1 ;
    public final void rule__AttrClassConfig__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3359:1: ( rule__AttrClassConfig__Group_3_1__0__Impl rule__AttrClassConfig__Group_3_1__1 )
            // InternalConfig.g:3360:2: rule__AttrClassConfig__Group_3_1__0__Impl rule__AttrClassConfig__Group_3_1__1
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
    // InternalConfig.g:3367:1: rule__AttrClassConfig__Group_3_1__0__Impl : ( ( rule__AttrClassConfig__Group_3_1_0__0 )? ) ;
    public final void rule__AttrClassConfig__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3371:1: ( ( ( rule__AttrClassConfig__Group_3_1_0__0 )? ) )
            // InternalConfig.g:3372:1: ( ( rule__AttrClassConfig__Group_3_1_0__0 )? )
            {
            // InternalConfig.g:3372:1: ( ( rule__AttrClassConfig__Group_3_1_0__0 )? )
            // InternalConfig.g:3373:2: ( rule__AttrClassConfig__Group_3_1_0__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_0()); 
            }
            // InternalConfig.g:3374:2: ( rule__AttrClassConfig__Group_3_1_0__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==44) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalConfig.g:3374:3: rule__AttrClassConfig__Group_3_1_0__0
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
    // InternalConfig.g:3382:1: rule__AttrClassConfig__Group_3_1__1 : rule__AttrClassConfig__Group_3_1__1__Impl rule__AttrClassConfig__Group_3_1__2 ;
    public final void rule__AttrClassConfig__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3386:1: ( rule__AttrClassConfig__Group_3_1__1__Impl rule__AttrClassConfig__Group_3_1__2 )
            // InternalConfig.g:3387:2: rule__AttrClassConfig__Group_3_1__1__Impl rule__AttrClassConfig__Group_3_1__2
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
    // InternalConfig.g:3394:1: rule__AttrClassConfig__Group_3_1__1__Impl : ( ( rule__AttrClassConfig__Group_3_1_1__0 )? ) ;
    public final void rule__AttrClassConfig__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3398:1: ( ( ( rule__AttrClassConfig__Group_3_1_1__0 )? ) )
            // InternalConfig.g:3399:1: ( ( rule__AttrClassConfig__Group_3_1_1__0 )? )
            {
            // InternalConfig.g:3399:1: ( ( rule__AttrClassConfig__Group_3_1_1__0 )? )
            // InternalConfig.g:3400:2: ( rule__AttrClassConfig__Group_3_1_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_1()); 
            }
            // InternalConfig.g:3401:2: ( rule__AttrClassConfig__Group_3_1_1__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==45) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalConfig.g:3401:3: rule__AttrClassConfig__Group_3_1_1__0
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
    // InternalConfig.g:3409:1: rule__AttrClassConfig__Group_3_1__2 : rule__AttrClassConfig__Group_3_1__2__Impl ;
    public final void rule__AttrClassConfig__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3413:1: ( rule__AttrClassConfig__Group_3_1__2__Impl )
            // InternalConfig.g:3414:2: rule__AttrClassConfig__Group_3_1__2__Impl
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
    // InternalConfig.g:3420:1: rule__AttrClassConfig__Group_3_1__2__Impl : ( ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )* ) ;
    public final void rule__AttrClassConfig__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3424:1: ( ( ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )* ) )
            // InternalConfig.g:3425:1: ( ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )* )
            {
            // InternalConfig.g:3425:1: ( ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )* )
            // InternalConfig.g:3426:2: ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributesAssignment_3_1_2()); 
            }
            // InternalConfig.g:3427:2: ( rule__AttrClassConfig__AttributesAssignment_3_1_2 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==42) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalConfig.g:3427:3: rule__AttrClassConfig__AttributesAssignment_3_1_2
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
    // InternalConfig.g:3436:1: rule__AttrClassConfig__Group_3_1_0__0 : rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1 ;
    public final void rule__AttrClassConfig__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3440:1: ( rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1 )
            // InternalConfig.g:3441:2: rule__AttrClassConfig__Group_3_1_0__0__Impl rule__AttrClassConfig__Group_3_1_0__1
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
    // InternalConfig.g:3448:1: rule__AttrClassConfig__Group_3_1_0__0__Impl : ( 'min' ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3452:1: ( ( 'min' ) )
            // InternalConfig.g:3453:1: ( 'min' )
            {
            // InternalConfig.g:3453:1: ( 'min' )
            // InternalConfig.g:3454:2: 'min'
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
    // InternalConfig.g:3463:1: rule__AttrClassConfig__Group_3_1_0__1 : rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2 ;
    public final void rule__AttrClassConfig__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3467:1: ( rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2 )
            // InternalConfig.g:3468:2: rule__AttrClassConfig__Group_3_1_0__1__Impl rule__AttrClassConfig__Group_3_1_0__2
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
    // InternalConfig.g:3475:1: rule__AttrClassConfig__Group_3_1_0__1__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3479:1: ( ( '=' ) )
            // InternalConfig.g:3480:1: ( '=' )
            {
            // InternalConfig.g:3480:1: ( '=' )
            // InternalConfig.g:3481:2: '='
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
    // InternalConfig.g:3490:1: rule__AttrClassConfig__Group_3_1_0__2 : rule__AttrClassConfig__Group_3_1_0__2__Impl ;
    public final void rule__AttrClassConfig__Group_3_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3494:1: ( rule__AttrClassConfig__Group_3_1_0__2__Impl )
            // InternalConfig.g:3495:2: rule__AttrClassConfig__Group_3_1_0__2__Impl
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
    // InternalConfig.g:3501:1: rule__AttrClassConfig__Group_3_1_0__2__Impl : ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) ) ;
    public final void rule__AttrClassConfig__Group_3_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3505:1: ( ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) ) )
            // InternalConfig.g:3506:1: ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) )
            {
            // InternalConfig.g:3506:1: ( ( rule__AttrClassConfig__MinAssignment_3_1_0_2 ) )
            // InternalConfig.g:3507:2: ( rule__AttrClassConfig__MinAssignment_3_1_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMinAssignment_3_1_0_2()); 
            }
            // InternalConfig.g:3508:2: ( rule__AttrClassConfig__MinAssignment_3_1_0_2 )
            // InternalConfig.g:3508:3: rule__AttrClassConfig__MinAssignment_3_1_0_2
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
    // InternalConfig.g:3517:1: rule__AttrClassConfig__Group_3_1_1__0 : rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1 ;
    public final void rule__AttrClassConfig__Group_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3521:1: ( rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1 )
            // InternalConfig.g:3522:2: rule__AttrClassConfig__Group_3_1_1__0__Impl rule__AttrClassConfig__Group_3_1_1__1
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
    // InternalConfig.g:3529:1: rule__AttrClassConfig__Group_3_1_1__0__Impl : ( 'max' ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3533:1: ( ( 'max' ) )
            // InternalConfig.g:3534:1: ( 'max' )
            {
            // InternalConfig.g:3534:1: ( 'max' )
            // InternalConfig.g:3535:2: 'max'
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
    // InternalConfig.g:3544:1: rule__AttrClassConfig__Group_3_1_1__1 : rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2 ;
    public final void rule__AttrClassConfig__Group_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3548:1: ( rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2 )
            // InternalConfig.g:3549:2: rule__AttrClassConfig__Group_3_1_1__1__Impl rule__AttrClassConfig__Group_3_1_1__2
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
    // InternalConfig.g:3556:1: rule__AttrClassConfig__Group_3_1_1__1__Impl : ( '=' ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3560:1: ( ( '=' ) )
            // InternalConfig.g:3561:1: ( '=' )
            {
            // InternalConfig.g:3561:1: ( '=' )
            // InternalConfig.g:3562:2: '='
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
    // InternalConfig.g:3571:1: rule__AttrClassConfig__Group_3_1_1__2 : rule__AttrClassConfig__Group_3_1_1__2__Impl ;
    public final void rule__AttrClassConfig__Group_3_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3575:1: ( rule__AttrClassConfig__Group_3_1_1__2__Impl )
            // InternalConfig.g:3576:2: rule__AttrClassConfig__Group_3_1_1__2__Impl
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
    // InternalConfig.g:3582:1: rule__AttrClassConfig__Group_3_1_1__2__Impl : ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) ) ;
    public final void rule__AttrClassConfig__Group_3_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3586:1: ( ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) ) )
            // InternalConfig.g:3587:1: ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) )
            {
            // InternalConfig.g:3587:1: ( ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 ) )
            // InternalConfig.g:3588:2: ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getMaxAssignment_3_1_1_2()); 
            }
            // InternalConfig.g:3589:2: ( rule__AttrClassConfig__MaxAssignment_3_1_1_2 )
            // InternalConfig.g:3589:3: rule__AttrClassConfig__MaxAssignment_3_1_1_2
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
    // InternalConfig.g:3598:1: rule__AttrInstanceConfig__Group__0 : rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1 ;
    public final void rule__AttrInstanceConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3602:1: ( rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1 )
            // InternalConfig.g:3603:2: rule__AttrInstanceConfig__Group__0__Impl rule__AttrInstanceConfig__Group__1
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
    // InternalConfig.g:3610:1: rule__AttrInstanceConfig__Group__0__Impl : ( 'Attr' ) ;
    public final void rule__AttrInstanceConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3614:1: ( ( 'Attr' ) )
            // InternalConfig.g:3615:1: ( 'Attr' )
            {
            // InternalConfig.g:3615:1: ( 'Attr' )
            // InternalConfig.g:3616:2: 'Attr'
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
    // InternalConfig.g:3625:1: rule__AttrInstanceConfig__Group__1 : rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2 ;
    public final void rule__AttrInstanceConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3629:1: ( rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2 )
            // InternalConfig.g:3630:2: rule__AttrInstanceConfig__Group__1__Impl rule__AttrInstanceConfig__Group__2
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
    // InternalConfig.g:3637:1: rule__AttrInstanceConfig__Group__1__Impl : ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3641:1: ( ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) ) )
            // InternalConfig.g:3642:1: ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) )
            {
            // InternalConfig.g:3642:1: ( ( rule__AttrInstanceConfig__AttributeAssignment_1 ) )
            // InternalConfig.g:3643:2: ( rule__AttrInstanceConfig__AttributeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAssignment_1()); 
            }
            // InternalConfig.g:3644:2: ( rule__AttrInstanceConfig__AttributeAssignment_1 )
            // InternalConfig.g:3644:3: rule__AttrInstanceConfig__AttributeAssignment_1
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
    // InternalConfig.g:3652:1: rule__AttrInstanceConfig__Group__2 : rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3 ;
    public final void rule__AttrInstanceConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3656:1: ( rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3 )
            // InternalConfig.g:3657:2: rule__AttrInstanceConfig__Group__2__Impl rule__AttrInstanceConfig__Group__3
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
    // InternalConfig.g:3664:1: rule__AttrInstanceConfig__Group__2__Impl : ( ( rule__AttrInstanceConfig__Group_2__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3668:1: ( ( ( rule__AttrInstanceConfig__Group_2__0 )? ) )
            // InternalConfig.g:3669:1: ( ( rule__AttrInstanceConfig__Group_2__0 )? )
            {
            // InternalConfig.g:3669:1: ( ( rule__AttrInstanceConfig__Group_2__0 )? )
            // InternalConfig.g:3670:2: ( rule__AttrInstanceConfig__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_2()); 
            }
            // InternalConfig.g:3671:2: ( rule__AttrInstanceConfig__Group_2__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==43) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalConfig.g:3671:3: rule__AttrInstanceConfig__Group_2__0
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
    // InternalConfig.g:3679:1: rule__AttrInstanceConfig__Group__3 : rule__AttrInstanceConfig__Group__3__Impl ;
    public final void rule__AttrInstanceConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3683:1: ( rule__AttrInstanceConfig__Group__3__Impl )
            // InternalConfig.g:3684:2: rule__AttrInstanceConfig__Group__3__Impl
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
    // InternalConfig.g:3690:1: rule__AttrInstanceConfig__Group__3__Impl : ( ( rule__AttrInstanceConfig__Group_3__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3694:1: ( ( ( rule__AttrInstanceConfig__Group_3__0 )? ) )
            // InternalConfig.g:3695:1: ( ( rule__AttrInstanceConfig__Group_3__0 )? )
            {
            // InternalConfig.g:3695:1: ( ( rule__AttrInstanceConfig__Group_3__0 )? )
            // InternalConfig.g:3696:2: ( rule__AttrInstanceConfig__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_3()); 
            }
            // InternalConfig.g:3697:2: ( rule__AttrInstanceConfig__Group_3__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==27) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalConfig.g:3697:3: rule__AttrInstanceConfig__Group_3__0
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
    // InternalConfig.g:3706:1: rule__AttrInstanceConfig__Group_2__0 : rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1 ;
    public final void rule__AttrInstanceConfig__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3710:1: ( rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1 )
            // InternalConfig.g:3711:2: rule__AttrInstanceConfig__Group_2__0__Impl rule__AttrInstanceConfig__Group_2__1
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
    // InternalConfig.g:3718:1: rule__AttrInstanceConfig__Group_2__0__Impl : ( '=' ) ;
    public final void rule__AttrInstanceConfig__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3722:1: ( ( '=' ) )
            // InternalConfig.g:3723:1: ( '=' )
            {
            // InternalConfig.g:3723:1: ( '=' )
            // InternalConfig.g:3724:2: '='
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
    // InternalConfig.g:3733:1: rule__AttrInstanceConfig__Group_2__1 : rule__AttrInstanceConfig__Group_2__1__Impl ;
    public final void rule__AttrInstanceConfig__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3737:1: ( rule__AttrInstanceConfig__Group_2__1__Impl )
            // InternalConfig.g:3738:2: rule__AttrInstanceConfig__Group_2__1__Impl
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
    // InternalConfig.g:3744:1: rule__AttrInstanceConfig__Group_2__1__Impl : ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3748:1: ( ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) ) )
            // InternalConfig.g:3749:1: ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) )
            {
            // InternalConfig.g:3749:1: ( ( rule__AttrInstanceConfig__ValueAssignment_2_1 ) )
            // InternalConfig.g:3750:2: ( rule__AttrInstanceConfig__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getValueAssignment_2_1()); 
            }
            // InternalConfig.g:3751:2: ( rule__AttrInstanceConfig__ValueAssignment_2_1 )
            // InternalConfig.g:3751:3: rule__AttrInstanceConfig__ValueAssignment_2_1
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
    // InternalConfig.g:3760:1: rule__AttrInstanceConfig__Group_3__0 : rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1 ;
    public final void rule__AttrInstanceConfig__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3764:1: ( rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1 )
            // InternalConfig.g:3765:2: rule__AttrInstanceConfig__Group_3__0__Impl rule__AttrInstanceConfig__Group_3__1
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
    // InternalConfig.g:3772:1: rule__AttrInstanceConfig__Group_3__0__Impl : ( '{' ) ;
    public final void rule__AttrInstanceConfig__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3776:1: ( ( '{' ) )
            // InternalConfig.g:3777:1: ( '{' )
            {
            // InternalConfig.g:3777:1: ( '{' )
            // InternalConfig.g:3778:2: '{'
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
    // InternalConfig.g:3787:1: rule__AttrInstanceConfig__Group_3__1 : rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2 ;
    public final void rule__AttrInstanceConfig__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3791:1: ( rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2 )
            // InternalConfig.g:3792:2: rule__AttrInstanceConfig__Group_3__1__Impl rule__AttrInstanceConfig__Group_3__2
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
    // InternalConfig.g:3799:1: rule__AttrInstanceConfig__Group_3__1__Impl : ( ( rule__AttrInstanceConfig__Group_3_1__0 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3803:1: ( ( ( rule__AttrInstanceConfig__Group_3_1__0 ) ) )
            // InternalConfig.g:3804:1: ( ( rule__AttrInstanceConfig__Group_3_1__0 ) )
            {
            // InternalConfig.g:3804:1: ( ( rule__AttrInstanceConfig__Group_3_1__0 ) )
            // InternalConfig.g:3805:2: ( rule__AttrInstanceConfig__Group_3_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1()); 
            }
            // InternalConfig.g:3806:2: ( rule__AttrInstanceConfig__Group_3_1__0 )
            // InternalConfig.g:3806:3: rule__AttrInstanceConfig__Group_3_1__0
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
    // InternalConfig.g:3814:1: rule__AttrInstanceConfig__Group_3__2 : rule__AttrInstanceConfig__Group_3__2__Impl ;
    public final void rule__AttrInstanceConfig__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3818:1: ( rule__AttrInstanceConfig__Group_3__2__Impl )
            // InternalConfig.g:3819:2: rule__AttrInstanceConfig__Group_3__2__Impl
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
    // InternalConfig.g:3825:1: rule__AttrInstanceConfig__Group_3__2__Impl : ( '}' ) ;
    public final void rule__AttrInstanceConfig__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3829:1: ( ( '}' ) )
            // InternalConfig.g:3830:1: ( '}' )
            {
            // InternalConfig.g:3830:1: ( '}' )
            // InternalConfig.g:3831:2: '}'
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
    // InternalConfig.g:3841:1: rule__AttrInstanceConfig__Group_3_1__0 : rule__AttrInstanceConfig__Group_3_1__0__Impl rule__AttrInstanceConfig__Group_3_1__1 ;
    public final void rule__AttrInstanceConfig__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3845:1: ( rule__AttrInstanceConfig__Group_3_1__0__Impl rule__AttrInstanceConfig__Group_3_1__1 )
            // InternalConfig.g:3846:2: rule__AttrInstanceConfig__Group_3_1__0__Impl rule__AttrInstanceConfig__Group_3_1__1
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
    // InternalConfig.g:3853:1: rule__AttrInstanceConfig__Group_3_1__0__Impl : ( ( rule__AttrInstanceConfig__Group_3_1_0__0 )? ) ;
    public final void rule__AttrInstanceConfig__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3857:1: ( ( ( rule__AttrInstanceConfig__Group_3_1_0__0 )? ) )
            // InternalConfig.g:3858:1: ( ( rule__AttrInstanceConfig__Group_3_1_0__0 )? )
            {
            // InternalConfig.g:3858:1: ( ( rule__AttrInstanceConfig__Group_3_1_0__0 )? )
            // InternalConfig.g:3859:2: ( rule__AttrInstanceConfig__Group_3_1_0__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1_0()); 
            }
            // InternalConfig.g:3860:2: ( rule__AttrInstanceConfig__Group_3_1_0__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==31) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalConfig.g:3860:3: rule__AttrInstanceConfig__Group_3_1_0__0
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
    // InternalConfig.g:3868:1: rule__AttrInstanceConfig__Group_3_1__1 : rule__AttrInstanceConfig__Group_3_1__1__Impl ;
    public final void rule__AttrInstanceConfig__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3872:1: ( rule__AttrInstanceConfig__Group_3_1__1__Impl )
            // InternalConfig.g:3873:2: rule__AttrInstanceConfig__Group_3_1__1__Impl
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
    // InternalConfig.g:3879:1: rule__AttrInstanceConfig__Group_3_1__1__Impl : ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) ;
    public final void rule__AttrInstanceConfig__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3883:1: ( ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* ) )
            // InternalConfig.g:3884:1: ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* )
            {
            // InternalConfig.g:3884:1: ( ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )* )
            // InternalConfig.g:3885:2: ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributesAssignment_3_1_1()); 
            }
            // InternalConfig.g:3886:2: ( rule__AttrInstanceConfig__AttributesAssignment_3_1_1 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==42) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalConfig.g:3886:3: rule__AttrInstanceConfig__AttributesAssignment_3_1_1
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
    // InternalConfig.g:3895:1: rule__AttrInstanceConfig__Group_3_1_0__0 : rule__AttrInstanceConfig__Group_3_1_0__0__Impl rule__AttrInstanceConfig__Group_3_1_0__1 ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3899:1: ( rule__AttrInstanceConfig__Group_3_1_0__0__Impl rule__AttrInstanceConfig__Group_3_1_0__1 )
            // InternalConfig.g:3900:2: rule__AttrInstanceConfig__Group_3_1_0__0__Impl rule__AttrInstanceConfig__Group_3_1_0__1
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
    // InternalConfig.g:3907:1: rule__AttrInstanceConfig__Group_3_1_0__0__Impl : ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3911:1: ( ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) ) )
            // InternalConfig.g:3912:1: ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) )
            {
            // InternalConfig.g:3912:1: ( ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 ) )
            // InternalConfig.g:3913:2: ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigAssignment_3_1_0_0()); 
            }
            // InternalConfig.g:3914:2: ( rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 )
            // InternalConfig.g:3914:3: rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0
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
    // InternalConfig.g:3922:1: rule__AttrInstanceConfig__Group_3_1_0__1 : rule__AttrInstanceConfig__Group_3_1_0__1__Impl ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3926:1: ( rule__AttrInstanceConfig__Group_3_1_0__1__Impl )
            // InternalConfig.g:3927:2: rule__AttrInstanceConfig__Group_3_1_0__1__Impl
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
    // InternalConfig.g:3933:1: rule__AttrInstanceConfig__Group_3_1_0__1__Impl : ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) ) ;
    public final void rule__AttrInstanceConfig__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3937:1: ( ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) ) )
            // InternalConfig.g:3938:1: ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) )
            {
            // InternalConfig.g:3938:1: ( ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 ) )
            // InternalConfig.g:3939:2: ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAlternatives_3_1_0_1()); 
            }
            // InternalConfig.g:3940:2: ( rule__AttrInstanceConfig__Alternatives_3_1_0_1 )
            // InternalConfig.g:3940:3: rule__AttrInstanceConfig__Alternatives_3_1_0_1
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
    // InternalConfig.g:3949:1: rule__ConfigValueArray__Group__0 : rule__ConfigValueArray__Group__0__Impl rule__ConfigValueArray__Group__1 ;
    public final void rule__ConfigValueArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3953:1: ( rule__ConfigValueArray__Group__0__Impl rule__ConfigValueArray__Group__1 )
            // InternalConfig.g:3954:2: rule__ConfigValueArray__Group__0__Impl rule__ConfigValueArray__Group__1
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
    // InternalConfig.g:3961:1: rule__ConfigValueArray__Group__0__Impl : ( ( rule__ConfigValueArray__ValuesAssignment_0 ) ) ;
    public final void rule__ConfigValueArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3965:1: ( ( ( rule__ConfigValueArray__ValuesAssignment_0 ) ) )
            // InternalConfig.g:3966:1: ( ( rule__ConfigValueArray__ValuesAssignment_0 ) )
            {
            // InternalConfig.g:3966:1: ( ( rule__ConfigValueArray__ValuesAssignment_0 ) )
            // InternalConfig.g:3967:2: ( rule__ConfigValueArray__ValuesAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueArrayAccess().getValuesAssignment_0()); 
            }
            // InternalConfig.g:3968:2: ( rule__ConfigValueArray__ValuesAssignment_0 )
            // InternalConfig.g:3968:3: rule__ConfigValueArray__ValuesAssignment_0
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
    // InternalConfig.g:3976:1: rule__ConfigValueArray__Group__1 : rule__ConfigValueArray__Group__1__Impl ;
    public final void rule__ConfigValueArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3980:1: ( rule__ConfigValueArray__Group__1__Impl )
            // InternalConfig.g:3981:2: rule__ConfigValueArray__Group__1__Impl
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
    // InternalConfig.g:3987:1: rule__ConfigValueArray__Group__1__Impl : ( ( rule__ConfigValueArray__Group_1__0 )* ) ;
    public final void rule__ConfigValueArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:3991:1: ( ( ( rule__ConfigValueArray__Group_1__0 )* ) )
            // InternalConfig.g:3992:1: ( ( rule__ConfigValueArray__Group_1__0 )* )
            {
            // InternalConfig.g:3992:1: ( ( rule__ConfigValueArray__Group_1__0 )* )
            // InternalConfig.g:3993:2: ( rule__ConfigValueArray__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueArrayAccess().getGroup_1()); 
            }
            // InternalConfig.g:3994:2: ( rule__ConfigValueArray__Group_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==46) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalConfig.g:3994:3: rule__ConfigValueArray__Group_1__0
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
    // InternalConfig.g:4003:1: rule__ConfigValueArray__Group_1__0 : rule__ConfigValueArray__Group_1__0__Impl rule__ConfigValueArray__Group_1__1 ;
    public final void rule__ConfigValueArray__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4007:1: ( rule__ConfigValueArray__Group_1__0__Impl rule__ConfigValueArray__Group_1__1 )
            // InternalConfig.g:4008:2: rule__ConfigValueArray__Group_1__0__Impl rule__ConfigValueArray__Group_1__1
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
    // InternalConfig.g:4015:1: rule__ConfigValueArray__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ConfigValueArray__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4019:1: ( ( ',' ) )
            // InternalConfig.g:4020:1: ( ',' )
            {
            // InternalConfig.g:4020:1: ( ',' )
            // InternalConfig.g:4021:2: ','
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
    // InternalConfig.g:4030:1: rule__ConfigValueArray__Group_1__1 : rule__ConfigValueArray__Group_1__1__Impl ;
    public final void rule__ConfigValueArray__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4034:1: ( rule__ConfigValueArray__Group_1__1__Impl )
            // InternalConfig.g:4035:2: rule__ConfigValueArray__Group_1__1__Impl
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
    // InternalConfig.g:4041:1: rule__ConfigValueArray__Group_1__1__Impl : ( ( rule__ConfigValueArray__ValuesAssignment_1_1 ) ) ;
    public final void rule__ConfigValueArray__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4045:1: ( ( ( rule__ConfigValueArray__ValuesAssignment_1_1 ) ) )
            // InternalConfig.g:4046:1: ( ( rule__ConfigValueArray__ValuesAssignment_1_1 ) )
            {
            // InternalConfig.g:4046:1: ( ( rule__ConfigValueArray__ValuesAssignment_1_1 ) )
            // InternalConfig.g:4047:2: ( rule__ConfigValueArray__ValuesAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConfigValueArrayAccess().getValuesAssignment_1_1()); 
            }
            // InternalConfig.g:4048:2: ( rule__ConfigValueArray__ValuesAssignment_1_1 )
            // InternalConfig.g:4048:3: rule__ConfigValueArray__ValuesAssignment_1_1
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
    // InternalConfig.g:4057:1: rule__EnumConfigValue__Group__0 : rule__EnumConfigValue__Group__0__Impl rule__EnumConfigValue__Group__1 ;
    public final void rule__EnumConfigValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4061:1: ( rule__EnumConfigValue__Group__0__Impl rule__EnumConfigValue__Group__1 )
            // InternalConfig.g:4062:2: rule__EnumConfigValue__Group__0__Impl rule__EnumConfigValue__Group__1
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
    // InternalConfig.g:4069:1: rule__EnumConfigValue__Group__0__Impl : ( ( rule__EnumConfigValue__TypeAssignment_0 ) ) ;
    public final void rule__EnumConfigValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4073:1: ( ( ( rule__EnumConfigValue__TypeAssignment_0 ) ) )
            // InternalConfig.g:4074:1: ( ( rule__EnumConfigValue__TypeAssignment_0 ) )
            {
            // InternalConfig.g:4074:1: ( ( rule__EnumConfigValue__TypeAssignment_0 ) )
            // InternalConfig.g:4075:2: ( rule__EnumConfigValue__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueAccess().getTypeAssignment_0()); 
            }
            // InternalConfig.g:4076:2: ( rule__EnumConfigValue__TypeAssignment_0 )
            // InternalConfig.g:4076:3: rule__EnumConfigValue__TypeAssignment_0
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
    // InternalConfig.g:4084:1: rule__EnumConfigValue__Group__1 : rule__EnumConfigValue__Group__1__Impl rule__EnumConfigValue__Group__2 ;
    public final void rule__EnumConfigValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4088:1: ( rule__EnumConfigValue__Group__1__Impl rule__EnumConfigValue__Group__2 )
            // InternalConfig.g:4089:2: rule__EnumConfigValue__Group__1__Impl rule__EnumConfigValue__Group__2
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
    // InternalConfig.g:4096:1: rule__EnumConfigValue__Group__1__Impl : ( '.' ) ;
    public final void rule__EnumConfigValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4100:1: ( ( '.' ) )
            // InternalConfig.g:4101:1: ( '.' )
            {
            // InternalConfig.g:4101:1: ( '.' )
            // InternalConfig.g:4102:2: '.'
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
    // InternalConfig.g:4111:1: rule__EnumConfigValue__Group__2 : rule__EnumConfigValue__Group__2__Impl ;
    public final void rule__EnumConfigValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4115:1: ( rule__EnumConfigValue__Group__2__Impl )
            // InternalConfig.g:4116:2: rule__EnumConfigValue__Group__2__Impl
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
    // InternalConfig.g:4122:1: rule__EnumConfigValue__Group__2__Impl : ( ( rule__EnumConfigValue__ValueAssignment_2 ) ) ;
    public final void rule__EnumConfigValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4126:1: ( ( ( rule__EnumConfigValue__ValueAssignment_2 ) ) )
            // InternalConfig.g:4127:1: ( ( rule__EnumConfigValue__ValueAssignment_2 ) )
            {
            // InternalConfig.g:4127:1: ( ( rule__EnumConfigValue__ValueAssignment_2 ) )
            // InternalConfig.g:4128:2: ( rule__EnumConfigValue__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueAccess().getValueAssignment_2()); 
            }
            // InternalConfig.g:4129:2: ( rule__EnumConfigValue__ValueAssignment_2 )
            // InternalConfig.g:4129:3: rule__EnumConfigValue__ValueAssignment_2
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
    // InternalConfig.g:4138:1: rule__RefPath__Group__0 : rule__RefPath__Group__0__Impl rule__RefPath__Group__1 ;
    public final void rule__RefPath__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4142:1: ( rule__RefPath__Group__0__Impl rule__RefPath__Group__1 )
            // InternalConfig.g:4143:2: rule__RefPath__Group__0__Impl rule__RefPath__Group__1
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
    // InternalConfig.g:4150:1: rule__RefPath__Group__0__Impl : ( ( rule__RefPath__RefsAssignment_0 ) ) ;
    public final void rule__RefPath__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4154:1: ( ( ( rule__RefPath__RefsAssignment_0 ) ) )
            // InternalConfig.g:4155:1: ( ( rule__RefPath__RefsAssignment_0 ) )
            {
            // InternalConfig.g:4155:1: ( ( rule__RefPath__RefsAssignment_0 ) )
            // InternalConfig.g:4156:2: ( rule__RefPath__RefsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsAssignment_0()); 
            }
            // InternalConfig.g:4157:2: ( rule__RefPath__RefsAssignment_0 )
            // InternalConfig.g:4157:3: rule__RefPath__RefsAssignment_0
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
    // InternalConfig.g:4165:1: rule__RefPath__Group__1 : rule__RefPath__Group__1__Impl ;
    public final void rule__RefPath__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4169:1: ( rule__RefPath__Group__1__Impl )
            // InternalConfig.g:4170:2: rule__RefPath__Group__1__Impl
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
    // InternalConfig.g:4176:1: rule__RefPath__Group__1__Impl : ( ( rule__RefPath__Group_1__0 )* ) ;
    public final void rule__RefPath__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4180:1: ( ( ( rule__RefPath__Group_1__0 )* ) )
            // InternalConfig.g:4181:1: ( ( rule__RefPath__Group_1__0 )* )
            {
            // InternalConfig.g:4181:1: ( ( rule__RefPath__Group_1__0 )* )
            // InternalConfig.g:4182:2: ( rule__RefPath__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getGroup_1()); 
            }
            // InternalConfig.g:4183:2: ( rule__RefPath__Group_1__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==30) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalConfig.g:4183:3: rule__RefPath__Group_1__0
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
    // InternalConfig.g:4192:1: rule__RefPath__Group_1__0 : rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1 ;
    public final void rule__RefPath__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4196:1: ( rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1 )
            // InternalConfig.g:4197:2: rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1
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
    // InternalConfig.g:4204:1: rule__RefPath__Group_1__0__Impl : ( '/' ) ;
    public final void rule__RefPath__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4208:1: ( ( '/' ) )
            // InternalConfig.g:4209:1: ( '/' )
            {
            // InternalConfig.g:4209:1: ( '/' )
            // InternalConfig.g:4210:2: '/'
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
    // InternalConfig.g:4219:1: rule__RefPath__Group_1__1 : rule__RefPath__Group_1__1__Impl ;
    public final void rule__RefPath__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4223:1: ( rule__RefPath__Group_1__1__Impl )
            // InternalConfig.g:4224:2: rule__RefPath__Group_1__1__Impl
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
    // InternalConfig.g:4230:1: rule__RefPath__Group_1__1__Impl : ( ( rule__RefPath__RefsAssignment_1_1 ) ) ;
    public final void rule__RefPath__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4234:1: ( ( ( rule__RefPath__RefsAssignment_1_1 ) ) )
            // InternalConfig.g:4235:1: ( ( rule__RefPath__RefsAssignment_1_1 ) )
            {
            // InternalConfig.g:4235:1: ( ( rule__RefPath__RefsAssignment_1_1 ) )
            // InternalConfig.g:4236:2: ( rule__RefPath__RefsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefPathAccess().getRefsAssignment_1_1()); 
            }
            // InternalConfig.g:4237:2: ( rule__RefPath__RefsAssignment_1_1 )
            // InternalConfig.g:4237:3: rule__RefPath__RefsAssignment_1_1
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
    // InternalConfig.g:4246:1: rule__RefSegment__Group__0 : rule__RefSegment__Group__0__Impl rule__RefSegment__Group__1 ;
    public final void rule__RefSegment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4250:1: ( rule__RefSegment__Group__0__Impl rule__RefSegment__Group__1 )
            // InternalConfig.g:4251:2: rule__RefSegment__Group__0__Impl rule__RefSegment__Group__1
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
    // InternalConfig.g:4258:1: rule__RefSegment__Group__0__Impl : ( ( rule__RefSegment__RefAssignment_0 ) ) ;
    public final void rule__RefSegment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4262:1: ( ( ( rule__RefSegment__RefAssignment_0 ) ) )
            // InternalConfig.g:4263:1: ( ( rule__RefSegment__RefAssignment_0 ) )
            {
            // InternalConfig.g:4263:1: ( ( rule__RefSegment__RefAssignment_0 ) )
            // InternalConfig.g:4264:2: ( rule__RefSegment__RefAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefSegmentAccess().getRefAssignment_0()); 
            }
            // InternalConfig.g:4265:2: ( rule__RefSegment__RefAssignment_0 )
            // InternalConfig.g:4265:3: rule__RefSegment__RefAssignment_0
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
    // InternalConfig.g:4273:1: rule__RefSegment__Group__1 : rule__RefSegment__Group__1__Impl ;
    public final void rule__RefSegment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4277:1: ( rule__RefSegment__Group__1__Impl )
            // InternalConfig.g:4278:2: rule__RefSegment__Group__1__Impl
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
    // InternalConfig.g:4284:1: rule__RefSegment__Group__1__Impl : ( ( rule__RefSegment__Group_1__0 )? ) ;
    public final void rule__RefSegment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4288:1: ( ( ( rule__RefSegment__Group_1__0 )? ) )
            // InternalConfig.g:4289:1: ( ( rule__RefSegment__Group_1__0 )? )
            {
            // InternalConfig.g:4289:1: ( ( rule__RefSegment__Group_1__0 )? )
            // InternalConfig.g:4290:2: ( rule__RefSegment__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefSegmentAccess().getGroup_1()); 
            }
            // InternalConfig.g:4291:2: ( rule__RefSegment__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==48) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalConfig.g:4291:3: rule__RefSegment__Group_1__0
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
    // InternalConfig.g:4300:1: rule__RefSegment__Group_1__0 : rule__RefSegment__Group_1__0__Impl rule__RefSegment__Group_1__1 ;
    public final void rule__RefSegment__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4304:1: ( rule__RefSegment__Group_1__0__Impl rule__RefSegment__Group_1__1 )
            // InternalConfig.g:4305:2: rule__RefSegment__Group_1__0__Impl rule__RefSegment__Group_1__1
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
    // InternalConfig.g:4312:1: rule__RefSegment__Group_1__0__Impl : ( ':' ) ;
    public final void rule__RefSegment__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4316:1: ( ( ':' ) )
            // InternalConfig.g:4317:1: ( ':' )
            {
            // InternalConfig.g:4317:1: ( ':' )
            // InternalConfig.g:4318:2: ':'
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
    // InternalConfig.g:4327:1: rule__RefSegment__Group_1__1 : rule__RefSegment__Group_1__1__Impl ;
    public final void rule__RefSegment__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4331:1: ( rule__RefSegment__Group_1__1__Impl )
            // InternalConfig.g:4332:2: rule__RefSegment__Group_1__1__Impl
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
    // InternalConfig.g:4338:1: rule__RefSegment__Group_1__1__Impl : ( ( rule__RefSegment__IdxAssignment_1_1 ) ) ;
    public final void rule__RefSegment__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4342:1: ( ( ( rule__RefSegment__IdxAssignment_1_1 ) ) )
            // InternalConfig.g:4343:1: ( ( rule__RefSegment__IdxAssignment_1_1 ) )
            {
            // InternalConfig.g:4343:1: ( ( rule__RefSegment__IdxAssignment_1_1 ) )
            // InternalConfig.g:4344:2: ( rule__RefSegment__IdxAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRefSegmentAccess().getIdxAssignment_1_1()); 
            }
            // InternalConfig.g:4345:2: ( rule__RefSegment__IdxAssignment_1_1 )
            // InternalConfig.g:4345:3: rule__RefSegment__IdxAssignment_1_1
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
    // InternalConfig.g:4354:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4358:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // InternalConfig.g:4359:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
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
    // InternalConfig.g:4366:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4370:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // InternalConfig.g:4371:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // InternalConfig.g:4371:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // InternalConfig.g:4372:2: ( rule__KeyValue__KeyAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            }
            // InternalConfig.g:4373:2: ( rule__KeyValue__KeyAssignment_0 )
            // InternalConfig.g:4373:3: rule__KeyValue__KeyAssignment_0
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
    // InternalConfig.g:4381:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4385:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // InternalConfig.g:4386:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
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
    // InternalConfig.g:4393:1: rule__KeyValue__Group__1__Impl : ( '=' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4397:1: ( ( '=' ) )
            // InternalConfig.g:4398:1: ( '=' )
            {
            // InternalConfig.g:4398:1: ( '=' )
            // InternalConfig.g:4399:2: '='
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
    // InternalConfig.g:4408:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4412:1: ( rule__KeyValue__Group__2__Impl )
            // InternalConfig.g:4413:2: rule__KeyValue__Group__2__Impl
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
    // InternalConfig.g:4419:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4423:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // InternalConfig.g:4424:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // InternalConfig.g:4424:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // InternalConfig.g:4425:2: ( rule__KeyValue__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            }
            // InternalConfig.g:4426:2: ( rule__KeyValue__ValueAssignment_2 )
            // InternalConfig.g:4426:3: rule__KeyValue__ValueAssignment_2
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
    // InternalConfig.g:4435:1: rule__SimpleAnnotationAttribute__Group__0 : rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 ;
    public final void rule__SimpleAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4439:1: ( rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 )
            // InternalConfig.g:4440:2: rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1
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
    // InternalConfig.g:4447:1: rule__SimpleAnnotationAttribute__Group__0__Impl : ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4451:1: ( ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) )
            // InternalConfig.g:4452:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            {
            // InternalConfig.g:4452:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            // InternalConfig.g:4453:2: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 
            }
            // InternalConfig.g:4454:2: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            // InternalConfig.g:4454:3: rule__SimpleAnnotationAttribute__Alternatives_0
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
    // InternalConfig.g:4462:1: rule__SimpleAnnotationAttribute__Group__1 : rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 ;
    public final void rule__SimpleAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4466:1: ( rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 )
            // InternalConfig.g:4467:2: rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2
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
    // InternalConfig.g:4474:1: rule__SimpleAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4478:1: ( ( 'attribute' ) )
            // InternalConfig.g:4479:1: ( 'attribute' )
            {
            // InternalConfig.g:4479:1: ( 'attribute' )
            // InternalConfig.g:4480:2: 'attribute'
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
    // InternalConfig.g:4489:1: rule__SimpleAnnotationAttribute__Group__2 : rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 ;
    public final void rule__SimpleAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4493:1: ( rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 )
            // InternalConfig.g:4494:2: rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3
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
    // InternalConfig.g:4501:1: rule__SimpleAnnotationAttribute__Group__2__Impl : ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4505:1: ( ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) )
            // InternalConfig.g:4506:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            {
            // InternalConfig.g:4506:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            // InternalConfig.g:4507:2: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 
            }
            // InternalConfig.g:4508:2: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            // InternalConfig.g:4508:3: rule__SimpleAnnotationAttribute__NameAssignment_2
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
    // InternalConfig.g:4516:1: rule__SimpleAnnotationAttribute__Group__3 : rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 ;
    public final void rule__SimpleAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4520:1: ( rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 )
            // InternalConfig.g:4521:2: rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4
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
    // InternalConfig.g:4528:1: rule__SimpleAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4532:1: ( ( ':' ) )
            // InternalConfig.g:4533:1: ( ':' )
            {
            // InternalConfig.g:4533:1: ( ':' )
            // InternalConfig.g:4534:2: ':'
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
    // InternalConfig.g:4543:1: rule__SimpleAnnotationAttribute__Group__4 : rule__SimpleAnnotationAttribute__Group__4__Impl ;
    public final void rule__SimpleAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4547:1: ( rule__SimpleAnnotationAttribute__Group__4__Impl )
            // InternalConfig.g:4548:2: rule__SimpleAnnotationAttribute__Group__4__Impl
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
    // InternalConfig.g:4554:1: rule__SimpleAnnotationAttribute__Group__4__Impl : ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4558:1: ( ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) )
            // InternalConfig.g:4559:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            {
            // InternalConfig.g:4559:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            // InternalConfig.g:4560:2: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 
            }
            // InternalConfig.g:4561:2: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            // InternalConfig.g:4561:3: rule__SimpleAnnotationAttribute__TypeAssignment_4
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
    // InternalConfig.g:4570:1: rule__EnumAnnotationAttribute__Group__0 : rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 ;
    public final void rule__EnumAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4574:1: ( rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 )
            // InternalConfig.g:4575:2: rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1
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
    // InternalConfig.g:4582:1: rule__EnumAnnotationAttribute__Group__0__Impl : ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4586:1: ( ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) )
            // InternalConfig.g:4587:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            {
            // InternalConfig.g:4587:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            // InternalConfig.g:4588:2: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 
            }
            // InternalConfig.g:4589:2: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            // InternalConfig.g:4589:3: rule__EnumAnnotationAttribute__Alternatives_0
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
    // InternalConfig.g:4597:1: rule__EnumAnnotationAttribute__Group__1 : rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 ;
    public final void rule__EnumAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4601:1: ( rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 )
            // InternalConfig.g:4602:2: rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2
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
    // InternalConfig.g:4609:1: rule__EnumAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__EnumAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4613:1: ( ( 'attribute' ) )
            // InternalConfig.g:4614:1: ( 'attribute' )
            {
            // InternalConfig.g:4614:1: ( 'attribute' )
            // InternalConfig.g:4615:2: 'attribute'
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
    // InternalConfig.g:4624:1: rule__EnumAnnotationAttribute__Group__2 : rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 ;
    public final void rule__EnumAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4628:1: ( rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 )
            // InternalConfig.g:4629:2: rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3
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
    // InternalConfig.g:4636:1: rule__EnumAnnotationAttribute__Group__2__Impl : ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4640:1: ( ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) )
            // InternalConfig.g:4641:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            {
            // InternalConfig.g:4641:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            // InternalConfig.g:4642:2: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 
            }
            // InternalConfig.g:4643:2: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            // InternalConfig.g:4643:3: rule__EnumAnnotationAttribute__NameAssignment_2
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
    // InternalConfig.g:4651:1: rule__EnumAnnotationAttribute__Group__3 : rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 ;
    public final void rule__EnumAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4655:1: ( rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 )
            // InternalConfig.g:4656:2: rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4
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
    // InternalConfig.g:4663:1: rule__EnumAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4667:1: ( ( ':' ) )
            // InternalConfig.g:4668:1: ( ':' )
            {
            // InternalConfig.g:4668:1: ( ':' )
            // InternalConfig.g:4669:2: ':'
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
    // InternalConfig.g:4678:1: rule__EnumAnnotationAttribute__Group__4 : rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 ;
    public final void rule__EnumAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4682:1: ( rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 )
            // InternalConfig.g:4683:2: rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5
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
    // InternalConfig.g:4690:1: rule__EnumAnnotationAttribute__Group__4__Impl : ( '{' ) ;
    public final void rule__EnumAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4694:1: ( ( '{' ) )
            // InternalConfig.g:4695:1: ( '{' )
            {
            // InternalConfig.g:4695:1: ( '{' )
            // InternalConfig.g:4696:2: '{'
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
    // InternalConfig.g:4705:1: rule__EnumAnnotationAttribute__Group__5 : rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 ;
    public final void rule__EnumAnnotationAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4709:1: ( rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 )
            // InternalConfig.g:4710:2: rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6
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
    // InternalConfig.g:4717:1: rule__EnumAnnotationAttribute__Group__5__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4721:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) )
            // InternalConfig.g:4722:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            {
            // InternalConfig.g:4722:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            // InternalConfig.g:4723:2: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 
            }
            // InternalConfig.g:4724:2: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            // InternalConfig.g:4724:3: rule__EnumAnnotationAttribute__ValuesAssignment_5
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
    // InternalConfig.g:4732:1: rule__EnumAnnotationAttribute__Group__6 : rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 ;
    public final void rule__EnumAnnotationAttribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4736:1: ( rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 )
            // InternalConfig.g:4737:2: rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7
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
    // InternalConfig.g:4744:1: rule__EnumAnnotationAttribute__Group__6__Impl : ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) ;
    public final void rule__EnumAnnotationAttribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4748:1: ( ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) )
            // InternalConfig.g:4749:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            {
            // InternalConfig.g:4749:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            // InternalConfig.g:4750:2: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 
            }
            // InternalConfig.g:4751:2: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==46) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalConfig.g:4751:3: rule__EnumAnnotationAttribute__Group_6__0
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
    // InternalConfig.g:4759:1: rule__EnumAnnotationAttribute__Group__7 : rule__EnumAnnotationAttribute__Group__7__Impl ;
    public final void rule__EnumAnnotationAttribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4763:1: ( rule__EnumAnnotationAttribute__Group__7__Impl )
            // InternalConfig.g:4764:2: rule__EnumAnnotationAttribute__Group__7__Impl
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
    // InternalConfig.g:4770:1: rule__EnumAnnotationAttribute__Group__7__Impl : ( '}' ) ;
    public final void rule__EnumAnnotationAttribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4774:1: ( ( '}' ) )
            // InternalConfig.g:4775:1: ( '}' )
            {
            // InternalConfig.g:4775:1: ( '}' )
            // InternalConfig.g:4776:2: '}'
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
    // InternalConfig.g:4786:1: rule__EnumAnnotationAttribute__Group_6__0 : rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 ;
    public final void rule__EnumAnnotationAttribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4790:1: ( rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 )
            // InternalConfig.g:4791:2: rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1
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
    // InternalConfig.g:4798:1: rule__EnumAnnotationAttribute__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4802:1: ( ( ',' ) )
            // InternalConfig.g:4803:1: ( ',' )
            {
            // InternalConfig.g:4803:1: ( ',' )
            // InternalConfig.g:4804:2: ','
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
    // InternalConfig.g:4813:1: rule__EnumAnnotationAttribute__Group_6__1 : rule__EnumAnnotationAttribute__Group_6__1__Impl ;
    public final void rule__EnumAnnotationAttribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4817:1: ( rule__EnumAnnotationAttribute__Group_6__1__Impl )
            // InternalConfig.g:4818:2: rule__EnumAnnotationAttribute__Group_6__1__Impl
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
    // InternalConfig.g:4824:1: rule__EnumAnnotationAttribute__Group_6__1__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4828:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) )
            // InternalConfig.g:4829:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            {
            // InternalConfig.g:4829:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            // InternalConfig.g:4830:2: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 
            }
            // InternalConfig.g:4831:2: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            // InternalConfig.g:4831:3: rule__EnumAnnotationAttribute__ValuesAssignment_6_1
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
    // InternalConfig.g:4840:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4844:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalConfig.g:4845:2: rule__Import__Group__0__Impl rule__Import__Group__1
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
    // InternalConfig.g:4852:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4856:1: ( ( 'import' ) )
            // InternalConfig.g:4857:1: ( 'import' )
            {
            // InternalConfig.g:4857:1: ( 'import' )
            // InternalConfig.g:4858:2: 'import'
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
    // InternalConfig.g:4867:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4871:1: ( rule__Import__Group__1__Impl )
            // InternalConfig.g:4872:2: rule__Import__Group__1__Impl
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
    // InternalConfig.g:4878:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4882:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // InternalConfig.g:4883:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // InternalConfig.g:4883:1: ( ( rule__Import__Alternatives_1 ) )
            // InternalConfig.g:4884:2: ( rule__Import__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getAlternatives_1()); 
            }
            // InternalConfig.g:4885:2: ( rule__Import__Alternatives_1 )
            // InternalConfig.g:4885:3: rule__Import__Alternatives_1
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
    // InternalConfig.g:4894:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4898:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // InternalConfig.g:4899:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
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
    // InternalConfig.g:4906:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4910:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // InternalConfig.g:4911:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // InternalConfig.g:4911:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // InternalConfig.g:4912:2: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            }
            // InternalConfig.g:4913:2: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // InternalConfig.g:4913:3: rule__Import__ImportedNamespaceAssignment_1_0_0
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
    // InternalConfig.g:4921:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4925:1: ( rule__Import__Group_1_0__1__Impl )
            // InternalConfig.g:4926:2: rule__Import__Group_1_0__1__Impl
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
    // InternalConfig.g:4932:1: rule__Import__Group_1_0__1__Impl : ( ( rule__Import__Group_1_0_1__0 )? ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4936:1: ( ( ( rule__Import__Group_1_0_1__0 )? ) )
            // InternalConfig.g:4937:1: ( ( rule__Import__Group_1_0_1__0 )? )
            {
            // InternalConfig.g:4937:1: ( ( rule__Import__Group_1_0_1__0 )? )
            // InternalConfig.g:4938:2: ( rule__Import__Group_1_0_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getGroup_1_0_1()); 
            }
            // InternalConfig.g:4939:2: ( rule__Import__Group_1_0_1__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==51) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalConfig.g:4939:3: rule__Import__Group_1_0_1__0
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
    // InternalConfig.g:4948:1: rule__Import__Group_1_0_1__0 : rule__Import__Group_1_0_1__0__Impl rule__Import__Group_1_0_1__1 ;
    public final void rule__Import__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4952:1: ( rule__Import__Group_1_0_1__0__Impl rule__Import__Group_1_0_1__1 )
            // InternalConfig.g:4953:2: rule__Import__Group_1_0_1__0__Impl rule__Import__Group_1_0_1__1
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
    // InternalConfig.g:4960:1: rule__Import__Group_1_0_1__0__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4964:1: ( ( 'from' ) )
            // InternalConfig.g:4965:1: ( 'from' )
            {
            // InternalConfig.g:4965:1: ( 'from' )
            // InternalConfig.g:4966:2: 'from'
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
    // InternalConfig.g:4975:1: rule__Import__Group_1_0_1__1 : rule__Import__Group_1_0_1__1__Impl ;
    public final void rule__Import__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4979:1: ( rule__Import__Group_1_0_1__1__Impl )
            // InternalConfig.g:4980:2: rule__Import__Group_1_0_1__1__Impl
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
    // InternalConfig.g:4986:1: rule__Import__Group_1_0_1__1__Impl : ( ( rule__Import__ImportURIAssignment_1_0_1_1 ) ) ;
    public final void rule__Import__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:4990:1: ( ( ( rule__Import__ImportURIAssignment_1_0_1_1 ) ) )
            // InternalConfig.g:4991:1: ( ( rule__Import__ImportURIAssignment_1_0_1_1 ) )
            {
            // InternalConfig.g:4991:1: ( ( rule__Import__ImportURIAssignment_1_0_1_1 ) )
            // InternalConfig.g:4992:2: ( rule__Import__ImportURIAssignment_1_0_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportURIAssignment_1_0_1_1()); 
            }
            // InternalConfig.g:4993:2: ( rule__Import__ImportURIAssignment_1_0_1_1 )
            // InternalConfig.g:4993:3: rule__Import__ImportURIAssignment_1_0_1_1
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
    // InternalConfig.g:5002:1: rule__Import__Group_1_1__0 : rule__Import__Group_1_1__0__Impl rule__Import__Group_1_1__1 ;
    public final void rule__Import__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5006:1: ( rule__Import__Group_1_1__0__Impl rule__Import__Group_1_1__1 )
            // InternalConfig.g:5007:2: rule__Import__Group_1_1__0__Impl rule__Import__Group_1_1__1
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
    // InternalConfig.g:5014:1: rule__Import__Group_1_1__0__Impl : ( 'model' ) ;
    public final void rule__Import__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5018:1: ( ( 'model' ) )
            // InternalConfig.g:5019:1: ( 'model' )
            {
            // InternalConfig.g:5019:1: ( 'model' )
            // InternalConfig.g:5020:2: 'model'
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
    // InternalConfig.g:5029:1: rule__Import__Group_1_1__1 : rule__Import__Group_1_1__1__Impl ;
    public final void rule__Import__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5033:1: ( rule__Import__Group_1_1__1__Impl )
            // InternalConfig.g:5034:2: rule__Import__Group_1_1__1__Impl
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
    // InternalConfig.g:5040:1: rule__Import__Group_1_1__1__Impl : ( ( rule__Import__ImportURIAssignment_1_1_1 ) ) ;
    public final void rule__Import__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5044:1: ( ( ( rule__Import__ImportURIAssignment_1_1_1 ) ) )
            // InternalConfig.g:5045:1: ( ( rule__Import__ImportURIAssignment_1_1_1 ) )
            {
            // InternalConfig.g:5045:1: ( ( rule__Import__ImportURIAssignment_1_1_1 ) )
            // InternalConfig.g:5046:2: ( rule__Import__ImportURIAssignment_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportURIAssignment_1_1_1()); 
            }
            // InternalConfig.g:5047:2: ( rule__Import__ImportURIAssignment_1_1_1 )
            // InternalConfig.g:5047:3: rule__Import__ImportURIAssignment_1_1_1
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
    // InternalConfig.g:5056:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5060:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // InternalConfig.g:5061:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
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
    // InternalConfig.g:5068:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5072:1: ( ( ruleFQN ) )
            // InternalConfig.g:5073:1: ( ruleFQN )
            {
            // InternalConfig.g:5073:1: ( ruleFQN )
            // InternalConfig.g:5074:2: ruleFQN
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
    // InternalConfig.g:5083:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5087:1: ( rule__ImportedFQN__Group__1__Impl )
            // InternalConfig.g:5088:2: rule__ImportedFQN__Group__1__Impl
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
    // InternalConfig.g:5094:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5098:1: ( ( ( '.*' )? ) )
            // InternalConfig.g:5099:1: ( ( '.*' )? )
            {
            // InternalConfig.g:5099:1: ( ( '.*' )? )
            // InternalConfig.g:5100:2: ( '.*' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            }
            // InternalConfig.g:5101:2: ( '.*' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==53) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalConfig.g:5101:3: '.*'
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
    // InternalConfig.g:5110:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5114:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // InternalConfig.g:5115:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
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
    // InternalConfig.g:5122:1: rule__Documentation__Group__0__Impl : ( () ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5126:1: ( ( () ) )
            // InternalConfig.g:5127:1: ( () )
            {
            // InternalConfig.g:5127:1: ( () )
            // InternalConfig.g:5128:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 
            }
            // InternalConfig.g:5129:2: ()
            // InternalConfig.g:5129:3: 
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
    // InternalConfig.g:5137:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5141:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // InternalConfig.g:5142:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
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
    // InternalConfig.g:5149:1: rule__Documentation__Group__1__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5153:1: ( ( '[' ) )
            // InternalConfig.g:5154:1: ( '[' )
            {
            // InternalConfig.g:5154:1: ( '[' )
            // InternalConfig.g:5155:2: '['
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
    // InternalConfig.g:5164:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl rule__Documentation__Group__3 ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5168:1: ( rule__Documentation__Group__2__Impl rule__Documentation__Group__3 )
            // InternalConfig.g:5169:2: rule__Documentation__Group__2__Impl rule__Documentation__Group__3
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
    // InternalConfig.g:5176:1: rule__Documentation__Group__2__Impl : ( ( rule__Documentation__LinesAssignment_2 )* ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5180:1: ( ( ( rule__Documentation__LinesAssignment_2 )* ) )
            // InternalConfig.g:5181:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            {
            // InternalConfig.g:5181:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            // InternalConfig.g:5182:2: ( rule__Documentation__LinesAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 
            }
            // InternalConfig.g:5183:2: ( rule__Documentation__LinesAssignment_2 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_STRING) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalConfig.g:5183:3: rule__Documentation__LinesAssignment_2
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
    // InternalConfig.g:5191:1: rule__Documentation__Group__3 : rule__Documentation__Group__3__Impl ;
    public final void rule__Documentation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5195:1: ( rule__Documentation__Group__3__Impl )
            // InternalConfig.g:5196:2: rule__Documentation__Group__3__Impl
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
    // InternalConfig.g:5202:1: rule__Documentation__Group__3__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5206:1: ( ( ']' ) )
            // InternalConfig.g:5207:1: ( ']' )
            {
            // InternalConfig.g:5207:1: ( ']' )
            // InternalConfig.g:5208:2: ']'
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
    // InternalConfig.g:5218:1: rule__TIME__Group_0__0 : rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1 ;
    public final void rule__TIME__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5222:1: ( rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1 )
            // InternalConfig.g:5223:2: rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1
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
    // InternalConfig.g:5230:1: rule__TIME__Group_0__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5234:1: ( ( RULE_INT ) )
            // InternalConfig.g:5235:1: ( RULE_INT )
            {
            // InternalConfig.g:5235:1: ( RULE_INT )
            // InternalConfig.g:5236:2: RULE_INT
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
    // InternalConfig.g:5245:1: rule__TIME__Group_0__1 : rule__TIME__Group_0__1__Impl ;
    public final void rule__TIME__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5249:1: ( rule__TIME__Group_0__1__Impl )
            // InternalConfig.g:5250:2: rule__TIME__Group_0__1__Impl
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
    // InternalConfig.g:5256:1: rule__TIME__Group_0__1__Impl : ( 's' ) ;
    public final void rule__TIME__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5260:1: ( ( 's' ) )
            // InternalConfig.g:5261:1: ( 's' )
            {
            // InternalConfig.g:5261:1: ( 's' )
            // InternalConfig.g:5262:2: 's'
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
    // InternalConfig.g:5272:1: rule__TIME__Group_1__0 : rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1 ;
    public final void rule__TIME__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5276:1: ( rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1 )
            // InternalConfig.g:5277:2: rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1
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
    // InternalConfig.g:5284:1: rule__TIME__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5288:1: ( ( RULE_INT ) )
            // InternalConfig.g:5289:1: ( RULE_INT )
            {
            // InternalConfig.g:5289:1: ( RULE_INT )
            // InternalConfig.g:5290:2: RULE_INT
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
    // InternalConfig.g:5299:1: rule__TIME__Group_1__1 : rule__TIME__Group_1__1__Impl ;
    public final void rule__TIME__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5303:1: ( rule__TIME__Group_1__1__Impl )
            // InternalConfig.g:5304:2: rule__TIME__Group_1__1__Impl
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
    // InternalConfig.g:5310:1: rule__TIME__Group_1__1__Impl : ( 'ms' ) ;
    public final void rule__TIME__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5314:1: ( ( 'ms' ) )
            // InternalConfig.g:5315:1: ( 'ms' )
            {
            // InternalConfig.g:5315:1: ( 'ms' )
            // InternalConfig.g:5316:2: 'ms'
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
    // InternalConfig.g:5326:1: rule__TIME__Group_2__0 : rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1 ;
    public final void rule__TIME__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5330:1: ( rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1 )
            // InternalConfig.g:5331:2: rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1
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
    // InternalConfig.g:5338:1: rule__TIME__Group_2__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5342:1: ( ( RULE_INT ) )
            // InternalConfig.g:5343:1: ( RULE_INT )
            {
            // InternalConfig.g:5343:1: ( RULE_INT )
            // InternalConfig.g:5344:2: RULE_INT
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
    // InternalConfig.g:5353:1: rule__TIME__Group_2__1 : rule__TIME__Group_2__1__Impl ;
    public final void rule__TIME__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5357:1: ( rule__TIME__Group_2__1__Impl )
            // InternalConfig.g:5358:2: rule__TIME__Group_2__1__Impl
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
    // InternalConfig.g:5364:1: rule__TIME__Group_2__1__Impl : ( 'us' ) ;
    public final void rule__TIME__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5368:1: ( ( 'us' ) )
            // InternalConfig.g:5369:1: ( 'us' )
            {
            // InternalConfig.g:5369:1: ( 'us' )
            // InternalConfig.g:5370:2: 'us'
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
    // InternalConfig.g:5380:1: rule__TIME__Group_3__0 : rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1 ;
    public final void rule__TIME__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5384:1: ( rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1 )
            // InternalConfig.g:5385:2: rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1
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
    // InternalConfig.g:5392:1: rule__TIME__Group_3__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5396:1: ( ( RULE_INT ) )
            // InternalConfig.g:5397:1: ( RULE_INT )
            {
            // InternalConfig.g:5397:1: ( RULE_INT )
            // InternalConfig.g:5398:2: RULE_INT
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
    // InternalConfig.g:5407:1: rule__TIME__Group_3__1 : rule__TIME__Group_3__1__Impl ;
    public final void rule__TIME__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5411:1: ( rule__TIME__Group_3__1__Impl )
            // InternalConfig.g:5412:2: rule__TIME__Group_3__1__Impl
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
    // InternalConfig.g:5418:1: rule__TIME__Group_3__1__Impl : ( 'ns' ) ;
    public final void rule__TIME__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5422:1: ( ( 'ns' ) )
            // InternalConfig.g:5423:1: ( 'ns' )
            {
            // InternalConfig.g:5423:1: ( 'ns' )
            // InternalConfig.g:5424:2: 'ns'
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
    // InternalConfig.g:5434:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5438:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // InternalConfig.g:5439:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
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
    // InternalConfig.g:5446:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5450:1: ( ( () ) )
            // InternalConfig.g:5451:1: ( () )
            {
            // InternalConfig.g:5451:1: ( () )
            // InternalConfig.g:5452:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            }
            // InternalConfig.g:5453:2: ()
            // InternalConfig.g:5453:3: 
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
    // InternalConfig.g:5461:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5465:1: ( rule__BooleanLiteral__Group__1__Impl )
            // InternalConfig.g:5466:2: rule__BooleanLiteral__Group__1__Impl
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
    // InternalConfig.g:5472:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5476:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // InternalConfig.g:5477:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // InternalConfig.g:5477:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // InternalConfig.g:5478:2: ( rule__BooleanLiteral__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            }
            // InternalConfig.g:5479:2: ( rule__BooleanLiteral__Alternatives_1 )
            // InternalConfig.g:5479:3: rule__BooleanLiteral__Alternatives_1
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
    // InternalConfig.g:5488:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5492:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // InternalConfig.g:5493:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
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
    // InternalConfig.g:5500:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5504:1: ( ( () ) )
            // InternalConfig.g:5505:1: ( () )
            {
            // InternalConfig.g:5505:1: ( () )
            // InternalConfig.g:5506:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            }
            // InternalConfig.g:5507:2: ()
            // InternalConfig.g:5507:3: 
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
    // InternalConfig.g:5515:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5519:1: ( rule__RealLiteral__Group__1__Impl )
            // InternalConfig.g:5520:2: rule__RealLiteral__Group__1__Impl
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
    // InternalConfig.g:5526:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5530:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // InternalConfig.g:5531:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // InternalConfig.g:5531:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // InternalConfig.g:5532:2: ( rule__RealLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            }
            // InternalConfig.g:5533:2: ( rule__RealLiteral__ValueAssignment_1 )
            // InternalConfig.g:5533:3: rule__RealLiteral__ValueAssignment_1
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
    // InternalConfig.g:5542:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5546:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // InternalConfig.g:5547:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
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
    // InternalConfig.g:5554:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5558:1: ( ( () ) )
            // InternalConfig.g:5559:1: ( () )
            {
            // InternalConfig.g:5559:1: ( () )
            // InternalConfig.g:5560:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            }
            // InternalConfig.g:5561:2: ()
            // InternalConfig.g:5561:3: 
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
    // InternalConfig.g:5569:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5573:1: ( rule__IntLiteral__Group__1__Impl )
            // InternalConfig.g:5574:2: rule__IntLiteral__Group__1__Impl
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
    // InternalConfig.g:5580:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5584:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // InternalConfig.g:5585:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // InternalConfig.g:5585:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // InternalConfig.g:5586:2: ( rule__IntLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            }
            // InternalConfig.g:5587:2: ( rule__IntLiteral__ValueAssignment_1 )
            // InternalConfig.g:5587:3: rule__IntLiteral__ValueAssignment_1
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
    // InternalConfig.g:5596:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5600:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // InternalConfig.g:5601:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
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
    // InternalConfig.g:5608:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5612:1: ( ( () ) )
            // InternalConfig.g:5613:1: ( () )
            {
            // InternalConfig.g:5613:1: ( () )
            // InternalConfig.g:5614:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            }
            // InternalConfig.g:5615:2: ()
            // InternalConfig.g:5615:3: 
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
    // InternalConfig.g:5623:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5627:1: ( rule__StringLiteral__Group__1__Impl )
            // InternalConfig.g:5628:2: rule__StringLiteral__Group__1__Impl
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
    // InternalConfig.g:5634:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5638:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // InternalConfig.g:5639:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // InternalConfig.g:5639:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // InternalConfig.g:5640:2: ( rule__StringLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            }
            // InternalConfig.g:5641:2: ( rule__StringLiteral__ValueAssignment_1 )
            // InternalConfig.g:5641:3: rule__StringLiteral__ValueAssignment_1
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
    // InternalConfig.g:5650:1: rule__Integer__Group_0__0 : rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1 ;
    public final void rule__Integer__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5654:1: ( rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1 )
            // InternalConfig.g:5655:2: rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1
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
    // InternalConfig.g:5662:1: rule__Integer__Group_0__0__Impl : ( ( rule__Integer__Alternatives_0_0 )? ) ;
    public final void rule__Integer__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5666:1: ( ( ( rule__Integer__Alternatives_0_0 )? ) )
            // InternalConfig.g:5667:1: ( ( rule__Integer__Alternatives_0_0 )? )
            {
            // InternalConfig.g:5667:1: ( ( rule__Integer__Alternatives_0_0 )? )
            // InternalConfig.g:5668:2: ( rule__Integer__Alternatives_0_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerAccess().getAlternatives_0_0()); 
            }
            // InternalConfig.g:5669:2: ( rule__Integer__Alternatives_0_0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=18 && LA43_0<=19)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalConfig.g:5669:3: rule__Integer__Alternatives_0_0
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
    // InternalConfig.g:5677:1: rule__Integer__Group_0__1 : rule__Integer__Group_0__1__Impl ;
    public final void rule__Integer__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5681:1: ( rule__Integer__Group_0__1__Impl )
            // InternalConfig.g:5682:2: rule__Integer__Group_0__1__Impl
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
    // InternalConfig.g:5688:1: rule__Integer__Group_0__1__Impl : ( RULE_INT ) ;
    public final void rule__Integer__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5692:1: ( ( RULE_INT ) )
            // InternalConfig.g:5693:1: ( RULE_INT )
            {
            // InternalConfig.g:5693:1: ( RULE_INT )
            // InternalConfig.g:5694:2: RULE_INT
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
    // InternalConfig.g:5704:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5708:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // InternalConfig.g:5709:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
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
    // InternalConfig.g:5716:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5720:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // InternalConfig.g:5721:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // InternalConfig.g:5721:1: ( ( rule__Decimal__Alternatives_0 )? )
            // InternalConfig.g:5722:2: ( rule__Decimal__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            }
            // InternalConfig.g:5723:2: ( rule__Decimal__Alternatives_0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=18 && LA44_0<=19)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalConfig.g:5723:3: rule__Decimal__Alternatives_0
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
    // InternalConfig.g:5731:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5735:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // InternalConfig.g:5736:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
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
    // InternalConfig.g:5743:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5747:1: ( ( RULE_INT ) )
            // InternalConfig.g:5748:1: ( RULE_INT )
            {
            // InternalConfig.g:5748:1: ( RULE_INT )
            // InternalConfig.g:5749:2: RULE_INT
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
    // InternalConfig.g:5758:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5762:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // InternalConfig.g:5763:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
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
    // InternalConfig.g:5770:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5774:1: ( ( '.' ) )
            // InternalConfig.g:5775:1: ( '.' )
            {
            // InternalConfig.g:5775:1: ( '.' )
            // InternalConfig.g:5776:2: '.'
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
    // InternalConfig.g:5785:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5789:1: ( rule__Decimal__Group__3__Impl )
            // InternalConfig.g:5790:2: rule__Decimal__Group__3__Impl
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
    // InternalConfig.g:5796:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5800:1: ( ( RULE_INT ) )
            // InternalConfig.g:5801:1: ( RULE_INT )
            {
            // InternalConfig.g:5801:1: ( RULE_INT )
            // InternalConfig.g:5802:2: RULE_INT
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
    // InternalConfig.g:5812:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5816:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // InternalConfig.g:5817:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
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
    // InternalConfig.g:5824:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5828:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // InternalConfig.g:5829:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // InternalConfig.g:5829:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // InternalConfig.g:5830:2: ( rule__DecimalExp__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            }
            // InternalConfig.g:5831:2: ( rule__DecimalExp__Alternatives_0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=18 && LA45_0<=19)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalConfig.g:5831:3: rule__DecimalExp__Alternatives_0
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
    // InternalConfig.g:5839:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5843:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // InternalConfig.g:5844:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
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
    // InternalConfig.g:5851:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5855:1: ( ( RULE_INT ) )
            // InternalConfig.g:5856:1: ( RULE_INT )
            {
            // InternalConfig.g:5856:1: ( RULE_INT )
            // InternalConfig.g:5857:2: RULE_INT
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
    // InternalConfig.g:5866:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5870:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // InternalConfig.g:5871:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
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
    // InternalConfig.g:5878:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5882:1: ( ( '.' ) )
            // InternalConfig.g:5883:1: ( '.' )
            {
            // InternalConfig.g:5883:1: ( '.' )
            // InternalConfig.g:5884:2: '.'
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
    // InternalConfig.g:5893:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5897:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // InternalConfig.g:5898:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
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
    // InternalConfig.g:5905:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5909:1: ( ( RULE_INT ) )
            // InternalConfig.g:5910:1: ( RULE_INT )
            {
            // InternalConfig.g:5910:1: ( RULE_INT )
            // InternalConfig.g:5911:2: RULE_INT
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
    // InternalConfig.g:5920:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5 ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5924:1: ( rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5 )
            // InternalConfig.g:5925:2: rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5
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
    // InternalConfig.g:5932:1: rule__DecimalExp__Group__4__Impl : ( ( rule__DecimalExp__Alternatives_4 ) ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5936:1: ( ( ( rule__DecimalExp__Alternatives_4 ) ) )
            // InternalConfig.g:5937:1: ( ( rule__DecimalExp__Alternatives_4 ) )
            {
            // InternalConfig.g:5937:1: ( ( rule__DecimalExp__Alternatives_4 ) )
            // InternalConfig.g:5938:2: ( rule__DecimalExp__Alternatives_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getAlternatives_4()); 
            }
            // InternalConfig.g:5939:2: ( rule__DecimalExp__Alternatives_4 )
            // InternalConfig.g:5939:3: rule__DecimalExp__Alternatives_4
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
    // InternalConfig.g:5947:1: rule__DecimalExp__Group__5 : rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6 ;
    public final void rule__DecimalExp__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5951:1: ( rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6 )
            // InternalConfig.g:5952:2: rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6
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
    // InternalConfig.g:5959:1: rule__DecimalExp__Group__5__Impl : ( ( rule__DecimalExp__Alternatives_5 )? ) ;
    public final void rule__DecimalExp__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5963:1: ( ( ( rule__DecimalExp__Alternatives_5 )? ) )
            // InternalConfig.g:5964:1: ( ( rule__DecimalExp__Alternatives_5 )? )
            {
            // InternalConfig.g:5964:1: ( ( rule__DecimalExp__Alternatives_5 )? )
            // InternalConfig.g:5965:2: ( rule__DecimalExp__Alternatives_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalExpAccess().getAlternatives_5()); 
            }
            // InternalConfig.g:5966:2: ( rule__DecimalExp__Alternatives_5 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=18 && LA46_0<=19)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalConfig.g:5966:3: rule__DecimalExp__Alternatives_5
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
    // InternalConfig.g:5974:1: rule__DecimalExp__Group__6 : rule__DecimalExp__Group__6__Impl ;
    public final void rule__DecimalExp__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5978:1: ( rule__DecimalExp__Group__6__Impl )
            // InternalConfig.g:5979:2: rule__DecimalExp__Group__6__Impl
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
    // InternalConfig.g:5985:1: rule__DecimalExp__Group__6__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:5989:1: ( ( RULE_INT ) )
            // InternalConfig.g:5990:1: ( RULE_INT )
            {
            // InternalConfig.g:5990:1: ( RULE_INT )
            // InternalConfig.g:5991:2: RULE_INT
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
    // InternalConfig.g:6001:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6005:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalConfig.g:6006:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
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
    // InternalConfig.g:6013:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6017:1: ( ( RULE_ID ) )
            // InternalConfig.g:6018:1: ( RULE_ID )
            {
            // InternalConfig.g:6018:1: ( RULE_ID )
            // InternalConfig.g:6019:2: RULE_ID
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
    // InternalConfig.g:6028:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6032:1: ( rule__FQN__Group__1__Impl )
            // InternalConfig.g:6033:2: rule__FQN__Group__1__Impl
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
    // InternalConfig.g:6039:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6043:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalConfig.g:6044:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalConfig.g:6044:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalConfig.g:6045:2: ( rule__FQN__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFQNAccess().getGroup_1()); 
            }
            // InternalConfig.g:6046:2: ( rule__FQN__Group_1__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==47) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalConfig.g:6046:3: rule__FQN__Group_1__0
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
    // InternalConfig.g:6055:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6059:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalConfig.g:6060:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
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
    // InternalConfig.g:6067:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6071:1: ( ( '.' ) )
            // InternalConfig.g:6072:1: ( '.' )
            {
            // InternalConfig.g:6072:1: ( '.' )
            // InternalConfig.g:6073:2: '.'
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
    // InternalConfig.g:6082:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6086:1: ( rule__FQN__Group_1__1__Impl )
            // InternalConfig.g:6087:2: rule__FQN__Group_1__1__Impl
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
    // InternalConfig.g:6093:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6097:1: ( ( RULE_ID ) )
            // InternalConfig.g:6098:1: ( RULE_ID )
            {
            // InternalConfig.g:6098:1: ( RULE_ID )
            // InternalConfig.g:6099:2: RULE_ID
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
    // InternalConfig.g:6109:1: rule__DynamicConfig__UnorderedGroup_2 : rule__DynamicConfig__UnorderedGroup_2__0 {...}?;
    public final void rule__DynamicConfig__UnorderedGroup_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2());
        	
        try {
            // InternalConfig.g:6114:1: ( rule__DynamicConfig__UnorderedGroup_2__0 {...}?)
            // InternalConfig.g:6115:2: rule__DynamicConfig__UnorderedGroup_2__0 {...}?
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
    // InternalConfig.g:6123:1: rule__DynamicConfig__UnorderedGroup_2__Impl : ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) ) ;
    public final void rule__DynamicConfig__UnorderedGroup_2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalConfig.g:6128:1: ( ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) ) )
            // InternalConfig.g:6129:3: ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) )
            {
            // InternalConfig.g:6129:3: ( ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) ) | ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) ) )
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
                    // InternalConfig.g:6130:3: ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) )
                    {
                    // InternalConfig.g:6130:3: ({...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) ) )
                    // InternalConfig.g:6131:4: {...}? => ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__DynamicConfig__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0)");
                    }
                    // InternalConfig.g:6131:109: ( ( ( rule__DynamicConfig__Alternatives_2_0 ) ) )
                    // InternalConfig.g:6132:5: ( ( rule__DynamicConfig__Alternatives_2_0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0);
                    selected = true;
                    // InternalConfig.g:6138:5: ( ( rule__DynamicConfig__Alternatives_2_0 ) )
                    // InternalConfig.g:6139:6: ( rule__DynamicConfig__Alternatives_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getAlternatives_2_0()); 
                    }
                    // InternalConfig.g:6140:6: ( rule__DynamicConfig__Alternatives_2_0 )
                    // InternalConfig.g:6140:7: rule__DynamicConfig__Alternatives_2_0
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
                    // InternalConfig.g:6145:3: ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) )
                    {
                    // InternalConfig.g:6145:3: ({...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) ) )
                    // InternalConfig.g:6146:4: {...}? => ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__DynamicConfig__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1)");
                    }
                    // InternalConfig.g:6146:109: ( ( ( rule__DynamicConfig__Group_2_1__0 ) ) )
                    // InternalConfig.g:6147:5: ( ( rule__DynamicConfig__Group_2_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1);
                    selected = true;
                    // InternalConfig.g:6153:5: ( ( rule__DynamicConfig__Group_2_1__0 ) )
                    // InternalConfig.g:6154:6: ( rule__DynamicConfig__Group_2_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDynamicConfigAccess().getGroup_2_1()); 
                    }
                    // InternalConfig.g:6155:6: ( rule__DynamicConfig__Group_2_1__0 )
                    // InternalConfig.g:6155:7: rule__DynamicConfig__Group_2_1__0
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
    // InternalConfig.g:6168:1: rule__DynamicConfig__UnorderedGroup_2__0 : rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )? ;
    public final void rule__DynamicConfig__UnorderedGroup_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6172:1: ( rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )? )
            // InternalConfig.g:6173:2: rule__DynamicConfig__UnorderedGroup_2__Impl ( rule__DynamicConfig__UnorderedGroup_2__1 )?
            {
            pushFollow(FOLLOW_50);
            rule__DynamicConfig__UnorderedGroup_2__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalConfig.g:6174:2: ( rule__DynamicConfig__UnorderedGroup_2__1 )?
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
                    // InternalConfig.g:6174:2: rule__DynamicConfig__UnorderedGroup_2__1
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
    // InternalConfig.g:6180:1: rule__DynamicConfig__UnorderedGroup_2__1 : rule__DynamicConfig__UnorderedGroup_2__Impl ;
    public final void rule__DynamicConfig__UnorderedGroup_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6184:1: ( rule__DynamicConfig__UnorderedGroup_2__Impl )
            // InternalConfig.g:6185:2: rule__DynamicConfig__UnorderedGroup_2__Impl
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
    // InternalConfig.g:6192:1: rule__ActorInstanceConfig__UnorderedGroup_7 : ( rule__ActorInstanceConfig__UnorderedGroup_7__0 )? ;
    public final void rule__ActorInstanceConfig__UnorderedGroup_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7());
        	
        try {
            // InternalConfig.g:6197:1: ( ( rule__ActorInstanceConfig__UnorderedGroup_7__0 )? )
            // InternalConfig.g:6198:2: ( rule__ActorInstanceConfig__UnorderedGroup_7__0 )?
            {
            // InternalConfig.g:6198:2: ( rule__ActorInstanceConfig__UnorderedGroup_7__0 )?
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
                    // InternalConfig.g:6198:2: rule__ActorInstanceConfig__UnorderedGroup_7__0
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
    // InternalConfig.g:6206:1: rule__ActorInstanceConfig__UnorderedGroup_7__Impl : ( ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) ) ) ;
    public final void rule__ActorInstanceConfig__UnorderedGroup_7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalConfig.g:6211:1: ( ( ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) ) ) )
            // InternalConfig.g:6212:3: ( ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) ) )
            {
            // InternalConfig.g:6212:3: ( ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) ) )
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
                    // InternalConfig.g:6213:3: ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) )
                    {
                    // InternalConfig.g:6213:3: ({...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) ) )
                    // InternalConfig.g:6214:4: {...}? => ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ActorInstanceConfig__UnorderedGroup_7__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0)");
                    }
                    // InternalConfig.g:6214:115: ( ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) ) )
                    // InternalConfig.g:6215:5: ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0);
                    selected = true;
                    // InternalConfig.g:6221:5: ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* ) )
                    // InternalConfig.g:6222:6: ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) ) ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* )
                    {
                    // InternalConfig.g:6222:6: ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 ) )
                    // InternalConfig.g:6223:7: ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_7_0()); 
                    }
                    // InternalConfig.g:6224:7: ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )
                    // InternalConfig.g:6224:8: rule__ActorInstanceConfig__AttributesAssignment_7_0
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

                    // InternalConfig.g:6227:6: ( ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )* )
                    // InternalConfig.g:6228:7: ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_7_0()); 
                    }
                    // InternalConfig.g:6229:7: ( ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0 )*
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
                    	    // InternalConfig.g:6229:8: ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )=> rule__ActorInstanceConfig__AttributesAssignment_7_0
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
                    // InternalConfig.g:6235:3: ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) )
                    {
                    // InternalConfig.g:6235:3: ({...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) ) )
                    // InternalConfig.g:6236:4: {...}? => ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ActorInstanceConfig__UnorderedGroup_7__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1)");
                    }
                    // InternalConfig.g:6236:115: ( ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) ) )
                    // InternalConfig.g:6237:5: ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1);
                    selected = true;
                    // InternalConfig.g:6243:5: ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* ) )
                    // InternalConfig.g:6244:6: ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) ) ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* )
                    {
                    // InternalConfig.g:6244:6: ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 ) )
                    // InternalConfig.g:6245:7: ( rule__ActorInstanceConfig__PortsAssignment_7_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_7_1()); 
                    }
                    // InternalConfig.g:6246:7: ( rule__ActorInstanceConfig__PortsAssignment_7_1 )
                    // InternalConfig.g:6246:8: rule__ActorInstanceConfig__PortsAssignment_7_1
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

                    // InternalConfig.g:6249:6: ( ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )* )
                    // InternalConfig.g:6250:7: ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_7_1()); 
                    }
                    // InternalConfig.g:6251:7: ( ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1 )*
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
                    	    // InternalConfig.g:6251:8: ( rule__ActorInstanceConfig__PortsAssignment_7_1 )=> rule__ActorInstanceConfig__PortsAssignment_7_1
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
    // InternalConfig.g:6265:1: rule__ActorInstanceConfig__UnorderedGroup_7__0 : rule__ActorInstanceConfig__UnorderedGroup_7__Impl ( rule__ActorInstanceConfig__UnorderedGroup_7__1 )? ;
    public final void rule__ActorInstanceConfig__UnorderedGroup_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6269:1: ( rule__ActorInstanceConfig__UnorderedGroup_7__Impl ( rule__ActorInstanceConfig__UnorderedGroup_7__1 )? )
            // InternalConfig.g:6270:2: rule__ActorInstanceConfig__UnorderedGroup_7__Impl ( rule__ActorInstanceConfig__UnorderedGroup_7__1 )?
            {
            pushFollow(FOLLOW_51);
            rule__ActorInstanceConfig__UnorderedGroup_7__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalConfig.g:6271:2: ( rule__ActorInstanceConfig__UnorderedGroup_7__1 )?
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
                    // InternalConfig.g:6271:2: rule__ActorInstanceConfig__UnorderedGroup_7__1
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
    // InternalConfig.g:6277:1: rule__ActorInstanceConfig__UnorderedGroup_7__1 : rule__ActorInstanceConfig__UnorderedGroup_7__Impl ;
    public final void rule__ActorInstanceConfig__UnorderedGroup_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6281:1: ( rule__ActorInstanceConfig__UnorderedGroup_7__Impl )
            // InternalConfig.g:6282:2: rule__ActorInstanceConfig__UnorderedGroup_7__Impl
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
    // InternalConfig.g:6289:1: rule__ProtocolClassConfig__UnorderedGroup_3 : ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )? ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
        	
        try {
            // InternalConfig.g:6294:1: ( ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )? )
            // InternalConfig.g:6295:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )?
            {
            // InternalConfig.g:6295:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__0 )?
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
                    // InternalConfig.g:6295:2: rule__ProtocolClassConfig__UnorderedGroup_3__0
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
    // InternalConfig.g:6303:1: rule__ProtocolClassConfig__UnorderedGroup_3__Impl : ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) ) ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalConfig.g:6308:1: ( ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) ) )
            // InternalConfig.g:6309:3: ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) )
            {
            // InternalConfig.g:6309:3: ( ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) ) )
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
                    // InternalConfig.g:6310:3: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) )
                    {
                    // InternalConfig.g:6310:3: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) ) )
                    // InternalConfig.g:6311:4: {...}? => ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ProtocolClassConfig__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0)");
                    }
                    // InternalConfig.g:6311:115: ( ( ( rule__ProtocolClassConfig__Group_3_0__0 ) ) )
                    // InternalConfig.g:6312:5: ( ( rule__ProtocolClassConfig__Group_3_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0);
                    selected = true;
                    // InternalConfig.g:6318:5: ( ( rule__ProtocolClassConfig__Group_3_0__0 ) )
                    // InternalConfig.g:6319:6: ( rule__ProtocolClassConfig__Group_3_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProtocolClassConfigAccess().getGroup_3_0()); 
                    }
                    // InternalConfig.g:6320:6: ( rule__ProtocolClassConfig__Group_3_0__0 )
                    // InternalConfig.g:6320:7: rule__ProtocolClassConfig__Group_3_0__0
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
                    // InternalConfig.g:6325:3: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) )
                    {
                    // InternalConfig.g:6325:3: ({...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) ) )
                    // InternalConfig.g:6326:4: {...}? => ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ProtocolClassConfig__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1)");
                    }
                    // InternalConfig.g:6326:115: ( ( ( rule__ProtocolClassConfig__Group_3_1__0 ) ) )
                    // InternalConfig.g:6327:5: ( ( rule__ProtocolClassConfig__Group_3_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1);
                    selected = true;
                    // InternalConfig.g:6333:5: ( ( rule__ProtocolClassConfig__Group_3_1__0 ) )
                    // InternalConfig.g:6334:6: ( rule__ProtocolClassConfig__Group_3_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProtocolClassConfigAccess().getGroup_3_1()); 
                    }
                    // InternalConfig.g:6335:6: ( rule__ProtocolClassConfig__Group_3_1__0 )
                    // InternalConfig.g:6335:7: rule__ProtocolClassConfig__Group_3_1__0
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
    // InternalConfig.g:6348:1: rule__ProtocolClassConfig__UnorderedGroup_3__0 : rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )? ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6352:1: ( rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )? )
            // InternalConfig.g:6353:2: rule__ProtocolClassConfig__UnorderedGroup_3__Impl ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )?
            {
            pushFollow(FOLLOW_52);
            rule__ProtocolClassConfig__UnorderedGroup_3__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalConfig.g:6354:2: ( rule__ProtocolClassConfig__UnorderedGroup_3__1 )?
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
                    // InternalConfig.g:6354:2: rule__ProtocolClassConfig__UnorderedGroup_3__1
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
    // InternalConfig.g:6360:1: rule__ProtocolClassConfig__UnorderedGroup_3__1 : rule__ProtocolClassConfig__UnorderedGroup_3__Impl ;
    public final void rule__ProtocolClassConfig__UnorderedGroup_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6364:1: ( rule__ProtocolClassConfig__UnorderedGroup_3__Impl )
            // InternalConfig.g:6365:2: rule__ProtocolClassConfig__UnorderedGroup_3__Impl
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
    // InternalConfig.g:6372:1: rule__ConfigModel__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__ConfigModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6376:1: ( ( ruleFQN ) )
            // InternalConfig.g:6377:2: ( ruleFQN )
            {
            // InternalConfig.g:6377:2: ( ruleFQN )
            // InternalConfig.g:6378:3: ruleFQN
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
    // InternalConfig.g:6387:1: rule__ConfigModel__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__ConfigModel__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6391:1: ( ( ruleImport ) )
            // InternalConfig.g:6392:2: ( ruleImport )
            {
            // InternalConfig.g:6392:2: ( ruleImport )
            // InternalConfig.g:6393:3: ruleImport
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
    // InternalConfig.g:6402:1: rule__ConfigModel__ConfigElementsAssignment_4 : ( ruleConfigElement ) ;
    public final void rule__ConfigModel__ConfigElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6406:1: ( ( ruleConfigElement ) )
            // InternalConfig.g:6407:2: ( ruleConfigElement )
            {
            // InternalConfig.g:6407:2: ( ruleConfigElement )
            // InternalConfig.g:6408:3: ruleConfigElement
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
    // InternalConfig.g:6417:1: rule__SubSystemConfig__RootAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__SubSystemConfig__RootAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6421:1: ( ( ( ruleFQN ) ) )
            // InternalConfig.g:6422:2: ( ( ruleFQN ) )
            {
            // InternalConfig.g:6422:2: ( ( ruleFQN ) )
            // InternalConfig.g:6423:3: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getRootLogicalSystemCrossReference_1_0()); 
            }
            // InternalConfig.g:6424:3: ( ruleFQN )
            // InternalConfig.g:6425:4: ruleFQN
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
    // InternalConfig.g:6436:1: rule__SubSystemConfig__SubSystemAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemConfig__SubSystemAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6440:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:6441:2: ( ( RULE_ID ) )
            {
            // InternalConfig.g:6441:2: ( ( RULE_ID ) )
            // InternalConfig.g:6442:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemRefCrossReference_3_0()); 
            }
            // InternalConfig.g:6443:3: ( RULE_ID )
            // InternalConfig.g:6444:4: RULE_ID
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
    // InternalConfig.g:6455:1: rule__SubSystemConfig__DynConfigAssignment_5 : ( ruleDynamicConfig ) ;
    public final void rule__SubSystemConfig__DynConfigAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6459:1: ( ( ruleDynamicConfig ) )
            // InternalConfig.g:6460:2: ( ruleDynamicConfig )
            {
            // InternalConfig.g:6460:2: ( ruleDynamicConfig )
            // InternalConfig.g:6461:3: ruleDynamicConfig
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
    // InternalConfig.g:6470:1: rule__DynamicConfig__FilePathAssignment_2_0_0_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__FilePathAssignment_2_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6474:1: ( ( RULE_STRING ) )
            // InternalConfig.g:6475:2: ( RULE_STRING )
            {
            // InternalConfig.g:6475:2: ( RULE_STRING )
            // InternalConfig.g:6476:3: RULE_STRING
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
    // InternalConfig.g:6485:1: rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6489:1: ( ( RULE_STRING ) )
            // InternalConfig.g:6490:2: ( RULE_STRING )
            {
            // InternalConfig.g:6490:2: ( RULE_STRING )
            // InternalConfig.g:6491:3: RULE_STRING
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
    // InternalConfig.g:6500:1: rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6504:1: ( ( RULE_STRING ) )
            // InternalConfig.g:6505:2: ( RULE_STRING )
            {
            // InternalConfig.g:6505:2: ( RULE_STRING )
            // InternalConfig.g:6506:3: RULE_STRING
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
    // InternalConfig.g:6515:1: rule__DynamicConfig__PollingAssignment_2_1_1 : ( ruleTIME ) ;
    public final void rule__DynamicConfig__PollingAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6519:1: ( ( ruleTIME ) )
            // InternalConfig.g:6520:2: ( ruleTIME )
            {
            // InternalConfig.g:6520:2: ( ruleTIME )
            // InternalConfig.g:6521:3: ruleTIME
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
    // InternalConfig.g:6530:1: rule__ActorClassConfig__ActorAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ActorClassConfig__ActorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6534:1: ( ( ( ruleFQN ) ) )
            // InternalConfig.g:6535:2: ( ( ruleFQN ) )
            {
            // InternalConfig.g:6535:2: ( ( ruleFQN ) )
            // InternalConfig.g:6536:3: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorClassConfigAccess().getActorActorClassCrossReference_1_0()); 
            }
            // InternalConfig.g:6537:3: ( ruleFQN )
            // InternalConfig.g:6538:4: ruleFQN
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
    // InternalConfig.g:6549:1: rule__ActorClassConfig__AttributesAssignment_3 : ( ruleAttrClassConfig ) ;
    public final void rule__ActorClassConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6553:1: ( ( ruleAttrClassConfig ) )
            // InternalConfig.g:6554:2: ( ruleAttrClassConfig )
            {
            // InternalConfig.g:6554:2: ( ruleAttrClassConfig )
            // InternalConfig.g:6555:3: ruleAttrClassConfig
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
    // InternalConfig.g:6564:1: rule__ActorInstanceConfig__RootAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ActorInstanceConfig__RootAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6568:1: ( ( ( ruleFQN ) ) )
            // InternalConfig.g:6569:2: ( ( ruleFQN ) )
            {
            // InternalConfig.g:6569:2: ( ( ruleFQN ) )
            // InternalConfig.g:6570:3: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getRootLogicalSystemCrossReference_1_0()); 
            }
            // InternalConfig.g:6571:3: ( ruleFQN )
            // InternalConfig.g:6572:4: ruleFQN
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
    // InternalConfig.g:6583:1: rule__ActorInstanceConfig__SubSystemAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__ActorInstanceConfig__SubSystemAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6587:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:6588:2: ( ( RULE_ID ) )
            {
            // InternalConfig.g:6588:2: ( ( RULE_ID ) )
            // InternalConfig.g:6589:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActorInstanceConfigAccess().getSubSystemSubSystemRefCrossReference_3_0()); 
            }
            // InternalConfig.g:6590:3: ( RULE_ID )
            // InternalConfig.g:6591:4: RULE_ID
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
    // InternalConfig.g:6602:1: rule__ActorInstanceConfig__PathAssignment_5 : ( ruleRefPath ) ;
    public final void rule__ActorInstanceConfig__PathAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6606:1: ( ( ruleRefPath ) )
            // InternalConfig.g:6607:2: ( ruleRefPath )
            {
            // InternalConfig.g:6607:2: ( ruleRefPath )
            // InternalConfig.g:6608:3: ruleRefPath
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
    // InternalConfig.g:6617:1: rule__ActorInstanceConfig__AttributesAssignment_7_0 : ( ruleAttrInstanceConfig ) ;
    public final void rule__ActorInstanceConfig__AttributesAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6621:1: ( ( ruleAttrInstanceConfig ) )
            // InternalConfig.g:6622:2: ( ruleAttrInstanceConfig )
            {
            // InternalConfig.g:6622:2: ( ruleAttrInstanceConfig )
            // InternalConfig.g:6623:3: ruleAttrInstanceConfig
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
    // InternalConfig.g:6632:1: rule__ActorInstanceConfig__PortsAssignment_7_1 : ( rulePortInstanceConfig ) ;
    public final void rule__ActorInstanceConfig__PortsAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6636:1: ( ( rulePortInstanceConfig ) )
            // InternalConfig.g:6637:2: ( rulePortInstanceConfig )
            {
            // InternalConfig.g:6637:2: ( rulePortInstanceConfig )
            // InternalConfig.g:6638:3: rulePortInstanceConfig
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
    // InternalConfig.g:6647:1: rule__ProtocolClassConfig__ProtocolAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ProtocolClassConfig__ProtocolAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6651:1: ( ( ( ruleFQN ) ) )
            // InternalConfig.g:6652:2: ( ( ruleFQN ) )
            {
            // InternalConfig.g:6652:2: ( ( ruleFQN ) )
            // InternalConfig.g:6653:3: ( ruleFQN )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassCrossReference_1_0()); 
            }
            // InternalConfig.g:6654:3: ( ruleFQN )
            // InternalConfig.g:6655:4: ruleFQN
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
    // InternalConfig.g:6666:1: rule__ProtocolClassConfig__RegularAssignment_3_0_1 : ( rulePortClassConfig ) ;
    public final void rule__ProtocolClassConfig__RegularAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6670:1: ( ( rulePortClassConfig ) )
            // InternalConfig.g:6671:2: ( rulePortClassConfig )
            {
            // InternalConfig.g:6671:2: ( rulePortClassConfig )
            // InternalConfig.g:6672:3: rulePortClassConfig
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
    // InternalConfig.g:6681:1: rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1 : ( rulePortClassConfig ) ;
    public final void rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6685:1: ( ( rulePortClassConfig ) )
            // InternalConfig.g:6686:2: ( rulePortClassConfig )
            {
            // InternalConfig.g:6686:2: ( rulePortClassConfig )
            // InternalConfig.g:6687:3: rulePortClassConfig
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
    // InternalConfig.g:6696:1: rule__PortClassConfig__AttributesAssignment_3 : ( ruleAttrClassConfig ) ;
    public final void rule__PortClassConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6700:1: ( ( ruleAttrClassConfig ) )
            // InternalConfig.g:6701:2: ( ruleAttrClassConfig )
            {
            // InternalConfig.g:6701:2: ( ruleAttrClassConfig )
            // InternalConfig.g:6702:3: ruleAttrClassConfig
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
    // InternalConfig.g:6711:1: rule__PortInstanceConfig__ItemAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PortInstanceConfig__ItemAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6715:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:6716:2: ( ( RULE_ID ) )
            {
            // InternalConfig.g:6716:2: ( ( RULE_ID ) )
            // InternalConfig.g:6717:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemCrossReference_1_0()); 
            }
            // InternalConfig.g:6718:3: ( RULE_ID )
            // InternalConfig.g:6719:4: RULE_ID
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
    // InternalConfig.g:6730:1: rule__PortInstanceConfig__AttributesAssignment_3 : ( ruleAttrInstanceConfig ) ;
    public final void rule__PortInstanceConfig__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6734:1: ( ( ruleAttrInstanceConfig ) )
            // InternalConfig.g:6735:2: ( ruleAttrInstanceConfig )
            {
            // InternalConfig.g:6735:2: ( ruleAttrInstanceConfig )
            // InternalConfig.g:6736:3: ruleAttrInstanceConfig
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
    // InternalConfig.g:6745:1: rule__AttrClassConfig__AttributeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AttrClassConfig__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6749:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:6750:2: ( ( RULE_ID ) )
            {
            // InternalConfig.g:6750:2: ( ( RULE_ID ) )
            // InternalConfig.g:6751:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrClassConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            }
            // InternalConfig.g:6752:3: ( RULE_ID )
            // InternalConfig.g:6753:4: RULE_ID
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
    // InternalConfig.g:6764:1: rule__AttrClassConfig__ValueAssignment_2_1 : ( ruleConfigValueArray ) ;
    public final void rule__AttrClassConfig__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6768:1: ( ( ruleConfigValueArray ) )
            // InternalConfig.g:6769:2: ( ruleConfigValueArray )
            {
            // InternalConfig.g:6769:2: ( ruleConfigValueArray )
            // InternalConfig.g:6770:3: ruleConfigValueArray
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
    // InternalConfig.g:6779:1: rule__AttrClassConfig__MinAssignment_3_1_0_2 : ( ruleNumberLiteral ) ;
    public final void rule__AttrClassConfig__MinAssignment_3_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6783:1: ( ( ruleNumberLiteral ) )
            // InternalConfig.g:6784:2: ( ruleNumberLiteral )
            {
            // InternalConfig.g:6784:2: ( ruleNumberLiteral )
            // InternalConfig.g:6785:3: ruleNumberLiteral
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
    // InternalConfig.g:6794:1: rule__AttrClassConfig__MaxAssignment_3_1_1_2 : ( ruleNumberLiteral ) ;
    public final void rule__AttrClassConfig__MaxAssignment_3_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6798:1: ( ( ruleNumberLiteral ) )
            // InternalConfig.g:6799:2: ( ruleNumberLiteral )
            {
            // InternalConfig.g:6799:2: ( ruleNumberLiteral )
            // InternalConfig.g:6800:3: ruleNumberLiteral
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
    // InternalConfig.g:6809:1: rule__AttrClassConfig__AttributesAssignment_3_1_2 : ( ruleAttrClassConfig ) ;
    public final void rule__AttrClassConfig__AttributesAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6813:1: ( ( ruleAttrClassConfig ) )
            // InternalConfig.g:6814:2: ( ruleAttrClassConfig )
            {
            // InternalConfig.g:6814:2: ( ruleAttrClassConfig )
            // InternalConfig.g:6815:3: ruleAttrClassConfig
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
    // InternalConfig.g:6824:1: rule__AttrInstanceConfig__AttributeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AttrInstanceConfig__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6828:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:6829:2: ( ( RULE_ID ) )
            {
            // InternalConfig.g:6829:2: ( ( RULE_ID ) )
            // InternalConfig.g:6830:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            }
            // InternalConfig.g:6831:3: ( RULE_ID )
            // InternalConfig.g:6832:4: RULE_ID
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
    // InternalConfig.g:6843:1: rule__AttrInstanceConfig__ValueAssignment_2_1 : ( ruleConfigValueArray ) ;
    public final void rule__AttrInstanceConfig__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6847:1: ( ( ruleConfigValueArray ) )
            // InternalConfig.g:6848:2: ( ruleConfigValueArray )
            {
            // InternalConfig.g:6848:2: ( ruleConfigValueArray )
            // InternalConfig.g:6849:3: ruleConfigValueArray
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
    // InternalConfig.g:6858:1: rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0 : ( ( 'dynamic configuration' ) ) ;
    public final void rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6862:1: ( ( ( 'dynamic configuration' ) ) )
            // InternalConfig.g:6863:2: ( ( 'dynamic configuration' ) )
            {
            // InternalConfig.g:6863:2: ( ( 'dynamic configuration' ) )
            // InternalConfig.g:6864:3: ( 'dynamic configuration' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0_0()); 
            }
            // InternalConfig.g:6865:3: ( 'dynamic configuration' )
            // InternalConfig.g:6866:4: 'dynamic configuration'
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
    // InternalConfig.g:6877:1: rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0 : ( ( 'read' ) ) ;
    public final void rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6881:1: ( ( ( 'read' ) ) )
            // InternalConfig.g:6882:2: ( ( 'read' ) )
            {
            // InternalConfig.g:6882:2: ( ( 'read' ) )
            // InternalConfig.g:6883:3: ( 'read' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadKeyword_3_1_0_1_0_0()); 
            }
            // InternalConfig.g:6884:3: ( 'read' )
            // InternalConfig.g:6885:4: 'read'
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
    // InternalConfig.g:6896:1: rule__AttrInstanceConfig__AttributesAssignment_3_1_1 : ( ruleAttrInstanceConfig ) ;
    public final void rule__AttrInstanceConfig__AttributesAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6900:1: ( ( ruleAttrInstanceConfig ) )
            // InternalConfig.g:6901:2: ( ruleAttrInstanceConfig )
            {
            // InternalConfig.g:6901:2: ( ruleAttrInstanceConfig )
            // InternalConfig.g:6902:3: ruleAttrInstanceConfig
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
    // InternalConfig.g:6911:1: rule__ConfigValueArray__ValuesAssignment_0 : ( ruleConfigValue ) ;
    public final void rule__ConfigValueArray__ValuesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6915:1: ( ( ruleConfigValue ) )
            // InternalConfig.g:6916:2: ( ruleConfigValue )
            {
            // InternalConfig.g:6916:2: ( ruleConfigValue )
            // InternalConfig.g:6917:3: ruleConfigValue
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
    // InternalConfig.g:6926:1: rule__ConfigValueArray__ValuesAssignment_1_1 : ( ruleConfigValue ) ;
    public final void rule__ConfigValueArray__ValuesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6930:1: ( ( ruleConfigValue ) )
            // InternalConfig.g:6931:2: ( ruleConfigValue )
            {
            // InternalConfig.g:6931:2: ( ruleConfigValue )
            // InternalConfig.g:6932:3: ruleConfigValue
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
    // InternalConfig.g:6941:1: rule__LiteralConfigValue__ValueAssignment : ( ruleLiteral ) ;
    public final void rule__LiteralConfigValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6945:1: ( ( ruleLiteral ) )
            // InternalConfig.g:6946:2: ( ruleLiteral )
            {
            // InternalConfig.g:6946:2: ( ruleLiteral )
            // InternalConfig.g:6947:3: ruleLiteral
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
    // InternalConfig.g:6956:1: rule__EnumConfigValue__TypeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EnumConfigValue__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6960:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:6961:2: ( ( RULE_ID ) )
            {
            // InternalConfig.g:6961:2: ( ( RULE_ID ) )
            // InternalConfig.g:6962:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueAccess().getTypeEnumerationTypeCrossReference_0_0()); 
            }
            // InternalConfig.g:6963:3: ( RULE_ID )
            // InternalConfig.g:6964:4: RULE_ID
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
    // InternalConfig.g:6975:1: rule__EnumConfigValue__ValueAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__EnumConfigValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6979:1: ( ( ( RULE_ID ) ) )
            // InternalConfig.g:6980:2: ( ( RULE_ID ) )
            {
            // InternalConfig.g:6980:2: ( ( RULE_ID ) )
            // InternalConfig.g:6981:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumConfigValueAccess().getValueEnumLiteralCrossReference_2_0()); 
            }
            // InternalConfig.g:6982:3: ( RULE_ID )
            // InternalConfig.g:6983:4: RULE_ID
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
    // InternalConfig.g:6994:1: rule__RefPath__RefsAssignment_0 : ( ruleRefSegment ) ;
    public final void rule__RefPath__RefsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:6998:1: ( ( ruleRefSegment ) )
            // InternalConfig.g:6999:2: ( ruleRefSegment )
            {
            // InternalConfig.g:6999:2: ( ruleRefSegment )
            // InternalConfig.g:7000:3: ruleRefSegment
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
    // InternalConfig.g:7009:1: rule__RefPath__RefsAssignment_1_1 : ( ruleRefSegment ) ;
    public final void rule__RefPath__RefsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7013:1: ( ( ruleRefSegment ) )
            // InternalConfig.g:7014:2: ( ruleRefSegment )
            {
            // InternalConfig.g:7014:2: ( ruleRefSegment )
            // InternalConfig.g:7015:3: ruleRefSegment
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
    // InternalConfig.g:7024:1: rule__RefSegment__RefAssignment_0 : ( RULE_ID ) ;
    public final void rule__RefSegment__RefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7028:1: ( ( RULE_ID ) )
            // InternalConfig.g:7029:2: ( RULE_ID )
            {
            // InternalConfig.g:7029:2: ( RULE_ID )
            // InternalConfig.g:7030:3: RULE_ID
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
    // InternalConfig.g:7039:1: rule__RefSegment__IdxAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__RefSegment__IdxAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7043:1: ( ( RULE_INT ) )
            // InternalConfig.g:7044:2: ( RULE_INT )
            {
            // InternalConfig.g:7044:2: ( RULE_INT )
            // InternalConfig.g:7045:3: RULE_INT
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
    // InternalConfig.g:7054:1: rule__KeyValue__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7058:1: ( ( RULE_ID ) )
            // InternalConfig.g:7059:2: ( RULE_ID )
            {
            // InternalConfig.g:7059:2: ( RULE_ID )
            // InternalConfig.g:7060:3: RULE_ID
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
    // InternalConfig.g:7069:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7073:1: ( ( ruleLiteral ) )
            // InternalConfig.g:7074:2: ( ruleLiteral )
            {
            // InternalConfig.g:7074:2: ( ruleLiteral )
            // InternalConfig.g:7075:3: ruleLiteral
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
    // InternalConfig.g:7084:1: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__SimpleAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7088:1: ( ( ( 'optional' ) ) )
            // InternalConfig.g:7089:2: ( ( 'optional' ) )
            {
            // InternalConfig.g:7089:2: ( ( 'optional' ) )
            // InternalConfig.g:7090:3: ( 'optional' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            }
            // InternalConfig.g:7091:3: ( 'optional' )
            // InternalConfig.g:7092:4: 'optional'
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
    // InternalConfig.g:7103:1: rule__SimpleAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7107:1: ( ( RULE_ID ) )
            // InternalConfig.g:7108:2: ( RULE_ID )
            {
            // InternalConfig.g:7108:2: ( RULE_ID )
            // InternalConfig.g:7109:3: RULE_ID
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
    // InternalConfig.g:7118:1: rule__SimpleAnnotationAttribute__TypeAssignment_4 : ( ruleLiteralType ) ;
    public final void rule__SimpleAnnotationAttribute__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7122:1: ( ( ruleLiteralType ) )
            // InternalConfig.g:7123:2: ( ruleLiteralType )
            {
            // InternalConfig.g:7123:2: ( ruleLiteralType )
            // InternalConfig.g:7124:3: ruleLiteralType
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
    // InternalConfig.g:7133:1: rule__EnumAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__EnumAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7137:1: ( ( ( 'optional' ) ) )
            // InternalConfig.g:7138:2: ( ( 'optional' ) )
            {
            // InternalConfig.g:7138:2: ( ( 'optional' ) )
            // InternalConfig.g:7139:3: ( 'optional' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            }
            // InternalConfig.g:7140:3: ( 'optional' )
            // InternalConfig.g:7141:4: 'optional'
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
    // InternalConfig.g:7152:1: rule__EnumAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EnumAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7156:1: ( ( RULE_ID ) )
            // InternalConfig.g:7157:2: ( RULE_ID )
            {
            // InternalConfig.g:7157:2: ( RULE_ID )
            // InternalConfig.g:7158:3: RULE_ID
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
    // InternalConfig.g:7167:1: rule__EnumAnnotationAttribute__ValuesAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7171:1: ( ( RULE_STRING ) )
            // InternalConfig.g:7172:2: ( RULE_STRING )
            {
            // InternalConfig.g:7172:2: ( RULE_STRING )
            // InternalConfig.g:7173:3: RULE_STRING
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
    // InternalConfig.g:7182:1: rule__EnumAnnotationAttribute__ValuesAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7186:1: ( ( RULE_STRING ) )
            // InternalConfig.g:7187:2: ( RULE_STRING )
            {
            // InternalConfig.g:7187:2: ( RULE_STRING )
            // InternalConfig.g:7188:3: RULE_STRING
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
    // InternalConfig.g:7197:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7201:1: ( ( ruleImportedFQN ) )
            // InternalConfig.g:7202:2: ( ruleImportedFQN )
            {
            // InternalConfig.g:7202:2: ( ruleImportedFQN )
            // InternalConfig.g:7203:3: ruleImportedFQN
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
    // InternalConfig.g:7212:1: rule__Import__ImportURIAssignment_1_0_1_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7216:1: ( ( RULE_STRING ) )
            // InternalConfig.g:7217:2: ( RULE_STRING )
            {
            // InternalConfig.g:7217:2: ( RULE_STRING )
            // InternalConfig.g:7218:3: RULE_STRING
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
    // InternalConfig.g:7227:1: rule__Import__ImportURIAssignment_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7231:1: ( ( RULE_STRING ) )
            // InternalConfig.g:7232:2: ( RULE_STRING )
            {
            // InternalConfig.g:7232:2: ( RULE_STRING )
            // InternalConfig.g:7233:3: RULE_STRING
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
    // InternalConfig.g:7242:1: rule__Documentation__LinesAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Documentation__LinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7246:1: ( ( RULE_STRING ) )
            // InternalConfig.g:7247:2: ( RULE_STRING )
            {
            // InternalConfig.g:7247:2: ( RULE_STRING )
            // InternalConfig.g:7248:3: RULE_STRING
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
    // InternalConfig.g:7257:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7261:1: ( ( ( 'true' ) ) )
            // InternalConfig.g:7262:2: ( ( 'true' ) )
            {
            // InternalConfig.g:7262:2: ( ( 'true' ) )
            // InternalConfig.g:7263:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            }
            // InternalConfig.g:7264:3: ( 'true' )
            // InternalConfig.g:7265:4: 'true'
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
    // InternalConfig.g:7276:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7280:1: ( ( ruleReal ) )
            // InternalConfig.g:7281:2: ( ruleReal )
            {
            // InternalConfig.g:7281:2: ( ruleReal )
            // InternalConfig.g:7282:3: ruleReal
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
    // InternalConfig.g:7291:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7295:1: ( ( ruleInteger ) )
            // InternalConfig.g:7296:2: ( ruleInteger )
            {
            // InternalConfig.g:7296:2: ( ruleInteger )
            // InternalConfig.g:7297:3: ruleInteger
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
    // InternalConfig.g:7306:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalConfig.g:7310:1: ( ( RULE_STRING ) )
            // InternalConfig.g:7311:2: ( RULE_STRING )
            {
            // InternalConfig.g:7311:2: ( RULE_STRING )
            // InternalConfig.g:7312:3: RULE_STRING
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
        // InternalConfig.g:6229:8: ( rule__ActorInstanceConfig__AttributesAssignment_7_0 )
        // InternalConfig.g:6229:9: rule__ActorInstanceConfig__AttributesAssignment_7_0
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
        // InternalConfig.g:6251:8: ( rule__ActorInstanceConfig__PortsAssignment_7_1 )
        // InternalConfig.g:6251:9: rule__ActorInstanceConfig__PortsAssignment_7_1
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
