package org.eclipse.etrice.core.etmap.ui.contentassist.antlr.internal; 

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
import org.eclipse.etrice.core.etmap.services.ETMapGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalETMapParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "'MappingModel'", "'{'", "'}'", "'Mapping'", "'->'", "'SubSystemMapping'", "'ActorInstanceMapping'", "'/'", "'import'", "'from'", "'.*'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalETMapParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalETMapParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalETMapParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g"; }


     
     	private ETMapGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ETMapGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleMappingModel"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:60:1: entryRuleMappingModel : ruleMappingModel EOF ;
    public final void entryRuleMappingModel() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:61:1: ( ruleMappingModel EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:62:1: ruleMappingModel EOF
            {
             before(grammarAccess.getMappingModelRule()); 
            pushFollow(FOLLOW_ruleMappingModel_in_entryRuleMappingModel61);
            ruleMappingModel();

            state._fsp--;

             after(grammarAccess.getMappingModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingModel68); 

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
    // $ANTLR end "entryRuleMappingModel"


    // $ANTLR start "ruleMappingModel"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:69:1: ruleMappingModel : ( ( rule__MappingModel__Group__0 ) ) ;
    public final void ruleMappingModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:73:2: ( ( ( rule__MappingModel__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:74:1: ( ( rule__MappingModel__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:74:1: ( ( rule__MappingModel__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:75:1: ( rule__MappingModel__Group__0 )
            {
             before(grammarAccess.getMappingModelAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:76:1: ( rule__MappingModel__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:76:2: rule__MappingModel__Group__0
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__0_in_ruleMappingModel94);
            rule__MappingModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMappingModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMappingModel"


    // $ANTLR start "entryRuleMapping"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:88:1: entryRuleMapping : ruleMapping EOF ;
    public final void entryRuleMapping() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:89:1: ( ruleMapping EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:90:1: ruleMapping EOF
            {
             before(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_ruleMapping_in_entryRuleMapping121);
            ruleMapping();

            state._fsp--;

             after(grammarAccess.getMappingRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapping128); 

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
    // $ANTLR end "entryRuleMapping"


    // $ANTLR start "ruleMapping"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:97:1: ruleMapping : ( ( rule__Mapping__Group__0 ) ) ;
    public final void ruleMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:101:2: ( ( ( rule__Mapping__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:102:1: ( ( rule__Mapping__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:102:1: ( ( rule__Mapping__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:103:1: ( rule__Mapping__Group__0 )
            {
             before(grammarAccess.getMappingAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:104:1: ( rule__Mapping__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:104:2: rule__Mapping__Group__0
            {
            pushFollow(FOLLOW_rule__Mapping__Group__0_in_ruleMapping154);
            rule__Mapping__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMappingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMapping"


    // $ANTLR start "entryRuleSubSystemMapping"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:116:1: entryRuleSubSystemMapping : ruleSubSystemMapping EOF ;
    public final void entryRuleSubSystemMapping() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:117:1: ( ruleSubSystemMapping EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:118:1: ruleSubSystemMapping EOF
            {
             before(grammarAccess.getSubSystemMappingRule()); 
            pushFollow(FOLLOW_ruleSubSystemMapping_in_entryRuleSubSystemMapping181);
            ruleSubSystemMapping();

            state._fsp--;

             after(grammarAccess.getSubSystemMappingRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemMapping188); 

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
    // $ANTLR end "entryRuleSubSystemMapping"


    // $ANTLR start "ruleSubSystemMapping"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:125:1: ruleSubSystemMapping : ( ( rule__SubSystemMapping__Group__0 ) ) ;
    public final void ruleSubSystemMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:129:2: ( ( ( rule__SubSystemMapping__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:130:1: ( ( rule__SubSystemMapping__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:130:1: ( ( rule__SubSystemMapping__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:131:1: ( rule__SubSystemMapping__Group__0 )
            {
             before(grammarAccess.getSubSystemMappingAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:132:1: ( rule__SubSystemMapping__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:132:2: rule__SubSystemMapping__Group__0
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__0_in_ruleSubSystemMapping214);
            rule__SubSystemMapping__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSubSystemMappingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSubSystemMapping"


    // $ANTLR start "entryRuleActorInstanceMapping"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:144:1: entryRuleActorInstanceMapping : ruleActorInstanceMapping EOF ;
    public final void entryRuleActorInstanceMapping() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:145:1: ( ruleActorInstanceMapping EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:146:1: ruleActorInstanceMapping EOF
            {
             before(grammarAccess.getActorInstanceMappingRule()); 
            pushFollow(FOLLOW_ruleActorInstanceMapping_in_entryRuleActorInstanceMapping241);
            ruleActorInstanceMapping();

            state._fsp--;

             after(grammarAccess.getActorInstanceMappingRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorInstanceMapping248); 

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
    // $ANTLR end "entryRuleActorInstanceMapping"


    // $ANTLR start "ruleActorInstanceMapping"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:153:1: ruleActorInstanceMapping : ( ( rule__ActorInstanceMapping__Group__0 ) ) ;
    public final void ruleActorInstanceMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:157:2: ( ( ( rule__ActorInstanceMapping__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:158:1: ( ( rule__ActorInstanceMapping__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:158:1: ( ( rule__ActorInstanceMapping__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:159:1: ( rule__ActorInstanceMapping__Group__0 )
            {
             before(grammarAccess.getActorInstanceMappingAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:160:1: ( rule__ActorInstanceMapping__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:160:2: rule__ActorInstanceMapping__Group__0
            {
            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group__0_in_ruleActorInstanceMapping274);
            rule__ActorInstanceMapping__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActorInstanceMappingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleActorInstanceMapping"


    // $ANTLR start "entryRuleRefPath"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:172:1: entryRuleRefPath : ruleRefPath EOF ;
    public final void entryRuleRefPath() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:173:1: ( ruleRefPath EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:174:1: ruleRefPath EOF
            {
             before(grammarAccess.getRefPathRule()); 
            pushFollow(FOLLOW_ruleRefPath_in_entryRuleRefPath301);
            ruleRefPath();

            state._fsp--;

             after(grammarAccess.getRefPathRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefPath308); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:181:1: ruleRefPath : ( ( rule__RefPath__Group__0 ) ) ;
    public final void ruleRefPath() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:185:2: ( ( ( rule__RefPath__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:186:1: ( ( rule__RefPath__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:186:1: ( ( rule__RefPath__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:187:1: ( rule__RefPath__Group__0 )
            {
             before(grammarAccess.getRefPathAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:188:1: ( rule__RefPath__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:188:2: rule__RefPath__Group__0
            {
            pushFollow(FOLLOW_rule__RefPath__Group__0_in_ruleRefPath334);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:200:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:201:1: ( ruleImport EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:202:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport361);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport368); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:209:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:213:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:214:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:214:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:215:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:216:1: ( rule__Import__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:216:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport394);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:228:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:229:1: ( ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:230:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN421);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN428); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:237:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:241:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:242:1: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:242:1: ( ( rule__ImportedFQN__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:243:1: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:244:1: ( rule__ImportedFQN__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:244:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN454);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:256:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:257:1: ( ruleFQN EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:258:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN481);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN488); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:265:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:269:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:270:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:270:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:271:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:272:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:272:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN514);
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


    // $ANTLR start "rule__Import__Alternatives_1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:284:1: rule__Import__Alternatives_1 : ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) );
    public final void rule__Import__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:288:1: ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==11) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:289:1: ( ( rule__Import__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:289:1: ( ( rule__Import__Group_1_0__0 ) )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:290:1: ( rule__Import__Group_1_0__0 )
                    {
                     before(grammarAccess.getImportAccess().getGroup_1_0()); 
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:291:1: ( rule__Import__Group_1_0__0 )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:291:2: rule__Import__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_1550);
                    rule__Import__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getImportAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:295:6: ( 'model' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:295:6: ( 'model' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:296:1: 'model'
                    {
                     before(grammarAccess.getImportAccess().getModelKeyword_1_1()); 
                    match(input,11,FOLLOW_11_in_rule__Import__Alternatives_1569); 
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


    // $ANTLR start "rule__MappingModel__Group__0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:310:1: rule__MappingModel__Group__0 : rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1 ;
    public final void rule__MappingModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:314:1: ( rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:315:2: rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__0__Impl_in_rule__MappingModel__Group__0601);
            rule__MappingModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__1_in_rule__MappingModel__Group__0604);
            rule__MappingModel__Group__1();

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
    // $ANTLR end "rule__MappingModel__Group__0"


    // $ANTLR start "rule__MappingModel__Group__0__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:322:1: rule__MappingModel__Group__0__Impl : ( 'MappingModel' ) ;
    public final void rule__MappingModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:326:1: ( ( 'MappingModel' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:327:1: ( 'MappingModel' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:327:1: ( 'MappingModel' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:328:1: 'MappingModel'
            {
             before(grammarAccess.getMappingModelAccess().getMappingModelKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__MappingModel__Group__0__Impl632); 
             after(grammarAccess.getMappingModelAccess().getMappingModelKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__Group__0__Impl"


    // $ANTLR start "rule__MappingModel__Group__1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:341:1: rule__MappingModel__Group__1 : rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2 ;
    public final void rule__MappingModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:345:1: ( rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:346:2: rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__1__Impl_in_rule__MappingModel__Group__1663);
            rule__MappingModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__2_in_rule__MappingModel__Group__1666);
            rule__MappingModel__Group__2();

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
    // $ANTLR end "rule__MappingModel__Group__1"


    // $ANTLR start "rule__MappingModel__Group__1__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:353:1: rule__MappingModel__Group__1__Impl : ( ( rule__MappingModel__NameAssignment_1 ) ) ;
    public final void rule__MappingModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:357:1: ( ( ( rule__MappingModel__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:358:1: ( ( rule__MappingModel__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:358:1: ( ( rule__MappingModel__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:359:1: ( rule__MappingModel__NameAssignment_1 )
            {
             before(grammarAccess.getMappingModelAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:360:1: ( rule__MappingModel__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:360:2: rule__MappingModel__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__MappingModel__NameAssignment_1_in_rule__MappingModel__Group__1__Impl693);
            rule__MappingModel__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMappingModelAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__Group__1__Impl"


    // $ANTLR start "rule__MappingModel__Group__2"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:370:1: rule__MappingModel__Group__2 : rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3 ;
    public final void rule__MappingModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:374:1: ( rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:375:2: rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__2__Impl_in_rule__MappingModel__Group__2723);
            rule__MappingModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__3_in_rule__MappingModel__Group__2726);
            rule__MappingModel__Group__3();

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
    // $ANTLR end "rule__MappingModel__Group__2"


    // $ANTLR start "rule__MappingModel__Group__2__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:382:1: rule__MappingModel__Group__2__Impl : ( '{' ) ;
    public final void rule__MappingModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:386:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:387:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:387:1: ( '{' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:388:1: '{'
            {
             before(grammarAccess.getMappingModelAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__MappingModel__Group__2__Impl754); 
             after(grammarAccess.getMappingModelAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__Group__2__Impl"


    // $ANTLR start "rule__MappingModel__Group__3"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:401:1: rule__MappingModel__Group__3 : rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4 ;
    public final void rule__MappingModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:405:1: ( rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:406:2: rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__3__Impl_in_rule__MappingModel__Group__3785);
            rule__MappingModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__4_in_rule__MappingModel__Group__3788);
            rule__MappingModel__Group__4();

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
    // $ANTLR end "rule__MappingModel__Group__3"


    // $ANTLR start "rule__MappingModel__Group__3__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:413:1: rule__MappingModel__Group__3__Impl : ( ( rule__MappingModel__ImportsAssignment_3 )* ) ;
    public final void rule__MappingModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:417:1: ( ( ( rule__MappingModel__ImportsAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:418:1: ( ( rule__MappingModel__ImportsAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:418:1: ( ( rule__MappingModel__ImportsAssignment_3 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:419:1: ( rule__MappingModel__ImportsAssignment_3 )*
            {
             before(grammarAccess.getMappingModelAccess().getImportsAssignment_3()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:420:1: ( rule__MappingModel__ImportsAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==20) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:420:2: rule__MappingModel__ImportsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__MappingModel__ImportsAssignment_3_in_rule__MappingModel__Group__3__Impl815);
            	    rule__MappingModel__ImportsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getMappingModelAccess().getImportsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__Group__3__Impl"


    // $ANTLR start "rule__MappingModel__Group__4"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:430:1: rule__MappingModel__Group__4 : rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5 ;
    public final void rule__MappingModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:434:1: ( rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:435:2: rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__4__Impl_in_rule__MappingModel__Group__4846);
            rule__MappingModel__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__5_in_rule__MappingModel__Group__4849);
            rule__MappingModel__Group__5();

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
    // $ANTLR end "rule__MappingModel__Group__4"


    // $ANTLR start "rule__MappingModel__Group__4__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:442:1: rule__MappingModel__Group__4__Impl : ( ( rule__MappingModel__MappingsAssignment_4 )* ) ;
    public final void rule__MappingModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:446:1: ( ( ( rule__MappingModel__MappingsAssignment_4 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:447:1: ( ( rule__MappingModel__MappingsAssignment_4 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:447:1: ( ( rule__MappingModel__MappingsAssignment_4 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:448:1: ( rule__MappingModel__MappingsAssignment_4 )*
            {
             before(grammarAccess.getMappingModelAccess().getMappingsAssignment_4()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:449:1: ( rule__MappingModel__MappingsAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:449:2: rule__MappingModel__MappingsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__MappingModel__MappingsAssignment_4_in_rule__MappingModel__Group__4__Impl876);
            	    rule__MappingModel__MappingsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getMappingModelAccess().getMappingsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__Group__4__Impl"


    // $ANTLR start "rule__MappingModel__Group__5"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:459:1: rule__MappingModel__Group__5 : rule__MappingModel__Group__5__Impl ;
    public final void rule__MappingModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:463:1: ( rule__MappingModel__Group__5__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:464:2: rule__MappingModel__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__5__Impl_in_rule__MappingModel__Group__5907);
            rule__MappingModel__Group__5__Impl();

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
    // $ANTLR end "rule__MappingModel__Group__5"


    // $ANTLR start "rule__MappingModel__Group__5__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:470:1: rule__MappingModel__Group__5__Impl : ( '}' ) ;
    public final void rule__MappingModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:474:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:475:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:475:1: ( '}' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:476:1: '}'
            {
             before(grammarAccess.getMappingModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,14,FOLLOW_14_in_rule__MappingModel__Group__5__Impl935); 
             after(grammarAccess.getMappingModelAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__Group__5__Impl"


    // $ANTLR start "rule__Mapping__Group__0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:501:1: rule__Mapping__Group__0 : rule__Mapping__Group__0__Impl rule__Mapping__Group__1 ;
    public final void rule__Mapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:505:1: ( rule__Mapping__Group__0__Impl rule__Mapping__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:506:2: rule__Mapping__Group__0__Impl rule__Mapping__Group__1
            {
            pushFollow(FOLLOW_rule__Mapping__Group__0__Impl_in_rule__Mapping__Group__0978);
            rule__Mapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__1_in_rule__Mapping__Group__0981);
            rule__Mapping__Group__1();

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
    // $ANTLR end "rule__Mapping__Group__0"


    // $ANTLR start "rule__Mapping__Group__0__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:513:1: rule__Mapping__Group__0__Impl : ( 'Mapping' ) ;
    public final void rule__Mapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:517:1: ( ( 'Mapping' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:518:1: ( 'Mapping' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:518:1: ( 'Mapping' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:519:1: 'Mapping'
            {
             before(grammarAccess.getMappingAccess().getMappingKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__Mapping__Group__0__Impl1009); 
             after(grammarAccess.getMappingAccess().getMappingKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Group__0__Impl"


    // $ANTLR start "rule__Mapping__Group__1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:532:1: rule__Mapping__Group__1 : rule__Mapping__Group__1__Impl rule__Mapping__Group__2 ;
    public final void rule__Mapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:536:1: ( rule__Mapping__Group__1__Impl rule__Mapping__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:537:2: rule__Mapping__Group__1__Impl rule__Mapping__Group__2
            {
            pushFollow(FOLLOW_rule__Mapping__Group__1__Impl_in_rule__Mapping__Group__11040);
            rule__Mapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__2_in_rule__Mapping__Group__11043);
            rule__Mapping__Group__2();

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
    // $ANTLR end "rule__Mapping__Group__1"


    // $ANTLR start "rule__Mapping__Group__1__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:544:1: rule__Mapping__Group__1__Impl : ( ( rule__Mapping__LogicalSysAssignment_1 ) ) ;
    public final void rule__Mapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:548:1: ( ( ( rule__Mapping__LogicalSysAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:549:1: ( ( rule__Mapping__LogicalSysAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:549:1: ( ( rule__Mapping__LogicalSysAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:550:1: ( rule__Mapping__LogicalSysAssignment_1 )
            {
             before(grammarAccess.getMappingAccess().getLogicalSysAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:551:1: ( rule__Mapping__LogicalSysAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:551:2: rule__Mapping__LogicalSysAssignment_1
            {
            pushFollow(FOLLOW_rule__Mapping__LogicalSysAssignment_1_in_rule__Mapping__Group__1__Impl1070);
            rule__Mapping__LogicalSysAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMappingAccess().getLogicalSysAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Group__1__Impl"


    // $ANTLR start "rule__Mapping__Group__2"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:561:1: rule__Mapping__Group__2 : rule__Mapping__Group__2__Impl rule__Mapping__Group__3 ;
    public final void rule__Mapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:565:1: ( rule__Mapping__Group__2__Impl rule__Mapping__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:566:2: rule__Mapping__Group__2__Impl rule__Mapping__Group__3
            {
            pushFollow(FOLLOW_rule__Mapping__Group__2__Impl_in_rule__Mapping__Group__21100);
            rule__Mapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__3_in_rule__Mapping__Group__21103);
            rule__Mapping__Group__3();

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
    // $ANTLR end "rule__Mapping__Group__2"


    // $ANTLR start "rule__Mapping__Group__2__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:573:1: rule__Mapping__Group__2__Impl : ( '->' ) ;
    public final void rule__Mapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:577:1: ( ( '->' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:578:1: ( '->' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:578:1: ( '->' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:579:1: '->'
            {
             before(grammarAccess.getMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,16,FOLLOW_16_in_rule__Mapping__Group__2__Impl1131); 
             after(grammarAccess.getMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Group__2__Impl"


    // $ANTLR start "rule__Mapping__Group__3"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:592:1: rule__Mapping__Group__3 : rule__Mapping__Group__3__Impl rule__Mapping__Group__4 ;
    public final void rule__Mapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:596:1: ( rule__Mapping__Group__3__Impl rule__Mapping__Group__4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:597:2: rule__Mapping__Group__3__Impl rule__Mapping__Group__4
            {
            pushFollow(FOLLOW_rule__Mapping__Group__3__Impl_in_rule__Mapping__Group__31162);
            rule__Mapping__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__4_in_rule__Mapping__Group__31165);
            rule__Mapping__Group__4();

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
    // $ANTLR end "rule__Mapping__Group__3"


    // $ANTLR start "rule__Mapping__Group__3__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:604:1: rule__Mapping__Group__3__Impl : ( ( rule__Mapping__PhysicalSysAssignment_3 ) ) ;
    public final void rule__Mapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:608:1: ( ( ( rule__Mapping__PhysicalSysAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:609:1: ( ( rule__Mapping__PhysicalSysAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:609:1: ( ( rule__Mapping__PhysicalSysAssignment_3 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:610:1: ( rule__Mapping__PhysicalSysAssignment_3 )
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysAssignment_3()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:611:1: ( rule__Mapping__PhysicalSysAssignment_3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:611:2: rule__Mapping__PhysicalSysAssignment_3
            {
            pushFollow(FOLLOW_rule__Mapping__PhysicalSysAssignment_3_in_rule__Mapping__Group__3__Impl1192);
            rule__Mapping__PhysicalSysAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMappingAccess().getPhysicalSysAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Group__3__Impl"


    // $ANTLR start "rule__Mapping__Group__4"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:621:1: rule__Mapping__Group__4 : rule__Mapping__Group__4__Impl rule__Mapping__Group__5 ;
    public final void rule__Mapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:625:1: ( rule__Mapping__Group__4__Impl rule__Mapping__Group__5 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:626:2: rule__Mapping__Group__4__Impl rule__Mapping__Group__5
            {
            pushFollow(FOLLOW_rule__Mapping__Group__4__Impl_in_rule__Mapping__Group__41222);
            rule__Mapping__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__5_in_rule__Mapping__Group__41225);
            rule__Mapping__Group__5();

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
    // $ANTLR end "rule__Mapping__Group__4"


    // $ANTLR start "rule__Mapping__Group__4__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:633:1: rule__Mapping__Group__4__Impl : ( '{' ) ;
    public final void rule__Mapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:637:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:638:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:638:1: ( '{' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:639:1: '{'
            {
             before(grammarAccess.getMappingAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,13,FOLLOW_13_in_rule__Mapping__Group__4__Impl1253); 
             after(grammarAccess.getMappingAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Group__4__Impl"


    // $ANTLR start "rule__Mapping__Group__5"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:652:1: rule__Mapping__Group__5 : rule__Mapping__Group__5__Impl rule__Mapping__Group__6 ;
    public final void rule__Mapping__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:656:1: ( rule__Mapping__Group__5__Impl rule__Mapping__Group__6 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:657:2: rule__Mapping__Group__5__Impl rule__Mapping__Group__6
            {
            pushFollow(FOLLOW_rule__Mapping__Group__5__Impl_in_rule__Mapping__Group__51284);
            rule__Mapping__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__6_in_rule__Mapping__Group__51287);
            rule__Mapping__Group__6();

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
    // $ANTLR end "rule__Mapping__Group__5"


    // $ANTLR start "rule__Mapping__Group__5__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:664:1: rule__Mapping__Group__5__Impl : ( ( rule__Mapping__SubsysMappingsAssignment_5 )* ) ;
    public final void rule__Mapping__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:668:1: ( ( ( rule__Mapping__SubsysMappingsAssignment_5 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:669:1: ( ( rule__Mapping__SubsysMappingsAssignment_5 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:669:1: ( ( rule__Mapping__SubsysMappingsAssignment_5 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:670:1: ( rule__Mapping__SubsysMappingsAssignment_5 )*
            {
             before(grammarAccess.getMappingAccess().getSubsysMappingsAssignment_5()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:671:1: ( rule__Mapping__SubsysMappingsAssignment_5 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:671:2: rule__Mapping__SubsysMappingsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__Mapping__SubsysMappingsAssignment_5_in_rule__Mapping__Group__5__Impl1314);
            	    rule__Mapping__SubsysMappingsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getMappingAccess().getSubsysMappingsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Group__5__Impl"


    // $ANTLR start "rule__Mapping__Group__6"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:681:1: rule__Mapping__Group__6 : rule__Mapping__Group__6__Impl ;
    public final void rule__Mapping__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:685:1: ( rule__Mapping__Group__6__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:686:2: rule__Mapping__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__Mapping__Group__6__Impl_in_rule__Mapping__Group__61345);
            rule__Mapping__Group__6__Impl();

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
    // $ANTLR end "rule__Mapping__Group__6"


    // $ANTLR start "rule__Mapping__Group__6__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:692:1: rule__Mapping__Group__6__Impl : ( '}' ) ;
    public final void rule__Mapping__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:696:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:697:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:697:1: ( '}' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:698:1: '}'
            {
             before(grammarAccess.getMappingAccess().getRightCurlyBracketKeyword_6()); 
            match(input,14,FOLLOW_14_in_rule__Mapping__Group__6__Impl1373); 
             after(grammarAccess.getMappingAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Group__6__Impl"


    // $ANTLR start "rule__SubSystemMapping__Group__0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:725:1: rule__SubSystemMapping__Group__0 : rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1 ;
    public final void rule__SubSystemMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:729:1: ( rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:730:2: rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__0__Impl_in_rule__SubSystemMapping__Group__01418);
            rule__SubSystemMapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group__1_in_rule__SubSystemMapping__Group__01421);
            rule__SubSystemMapping__Group__1();

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
    // $ANTLR end "rule__SubSystemMapping__Group__0"


    // $ANTLR start "rule__SubSystemMapping__Group__0__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:737:1: rule__SubSystemMapping__Group__0__Impl : ( 'SubSystemMapping' ) ;
    public final void rule__SubSystemMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:741:1: ( ( 'SubSystemMapping' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:742:1: ( 'SubSystemMapping' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:742:1: ( 'SubSystemMapping' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:743:1: 'SubSystemMapping'
            {
             before(grammarAccess.getSubSystemMappingAccess().getSubSystemMappingKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__SubSystemMapping__Group__0__Impl1449); 
             after(grammarAccess.getSubSystemMappingAccess().getSubSystemMappingKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemMapping__Group__0__Impl"


    // $ANTLR start "rule__SubSystemMapping__Group__1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:756:1: rule__SubSystemMapping__Group__1 : rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2 ;
    public final void rule__SubSystemMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:760:1: ( rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:761:2: rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__1__Impl_in_rule__SubSystemMapping__Group__11480);
            rule__SubSystemMapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group__2_in_rule__SubSystemMapping__Group__11483);
            rule__SubSystemMapping__Group__2();

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
    // $ANTLR end "rule__SubSystemMapping__Group__1"


    // $ANTLR start "rule__SubSystemMapping__Group__1__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:768:1: rule__SubSystemMapping__Group__1__Impl : ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) ) ;
    public final void rule__SubSystemMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:772:1: ( ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:773:1: ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:773:1: ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:774:1: ( rule__SubSystemMapping__LogicalSubSysAssignment_1 )
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:775:1: ( rule__SubSystemMapping__LogicalSubSysAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:775:2: rule__SubSystemMapping__LogicalSubSysAssignment_1
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__LogicalSubSysAssignment_1_in_rule__SubSystemMapping__Group__1__Impl1510);
            rule__SubSystemMapping__LogicalSubSysAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemMapping__Group__1__Impl"


    // $ANTLR start "rule__SubSystemMapping__Group__2"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:785:1: rule__SubSystemMapping__Group__2 : rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3 ;
    public final void rule__SubSystemMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:789:1: ( rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:790:2: rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__2__Impl_in_rule__SubSystemMapping__Group__21540);
            rule__SubSystemMapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group__3_in_rule__SubSystemMapping__Group__21543);
            rule__SubSystemMapping__Group__3();

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
    // $ANTLR end "rule__SubSystemMapping__Group__2"


    // $ANTLR start "rule__SubSystemMapping__Group__2__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:797:1: rule__SubSystemMapping__Group__2__Impl : ( '->' ) ;
    public final void rule__SubSystemMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:801:1: ( ( '->' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:802:1: ( '->' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:802:1: ( '->' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:803:1: '->'
            {
             before(grammarAccess.getSubSystemMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,16,FOLLOW_16_in_rule__SubSystemMapping__Group__2__Impl1571); 
             after(grammarAccess.getSubSystemMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemMapping__Group__2__Impl"


    // $ANTLR start "rule__SubSystemMapping__Group__3"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:816:1: rule__SubSystemMapping__Group__3 : rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4 ;
    public final void rule__SubSystemMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:820:1: ( rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:821:2: rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__3__Impl_in_rule__SubSystemMapping__Group__31602);
            rule__SubSystemMapping__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group__4_in_rule__SubSystemMapping__Group__31605);
            rule__SubSystemMapping__Group__4();

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
    // $ANTLR end "rule__SubSystemMapping__Group__3"


    // $ANTLR start "rule__SubSystemMapping__Group__3__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:828:1: rule__SubSystemMapping__Group__3__Impl : ( ( rule__SubSystemMapping__NodeAssignment_3 ) ) ;
    public final void rule__SubSystemMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:832:1: ( ( ( rule__SubSystemMapping__NodeAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:833:1: ( ( rule__SubSystemMapping__NodeAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:833:1: ( ( rule__SubSystemMapping__NodeAssignment_3 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:834:1: ( rule__SubSystemMapping__NodeAssignment_3 )
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeAssignment_3()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:835:1: ( rule__SubSystemMapping__NodeAssignment_3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:835:2: rule__SubSystemMapping__NodeAssignment_3
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__NodeAssignment_3_in_rule__SubSystemMapping__Group__3__Impl1632);
            rule__SubSystemMapping__NodeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSubSystemMappingAccess().getNodeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemMapping__Group__3__Impl"


    // $ANTLR start "rule__SubSystemMapping__Group__4"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:845:1: rule__SubSystemMapping__Group__4 : rule__SubSystemMapping__Group__4__Impl ;
    public final void rule__SubSystemMapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:849:1: ( rule__SubSystemMapping__Group__4__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:850:2: rule__SubSystemMapping__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__4__Impl_in_rule__SubSystemMapping__Group__41662);
            rule__SubSystemMapping__Group__4__Impl();

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
    // $ANTLR end "rule__SubSystemMapping__Group__4"


    // $ANTLR start "rule__SubSystemMapping__Group__4__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:856:1: rule__SubSystemMapping__Group__4__Impl : ( ( rule__SubSystemMapping__Group_4__0 )? ) ;
    public final void rule__SubSystemMapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:860:1: ( ( ( rule__SubSystemMapping__Group_4__0 )? ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:861:1: ( ( rule__SubSystemMapping__Group_4__0 )? )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:861:1: ( ( rule__SubSystemMapping__Group_4__0 )? )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:862:1: ( rule__SubSystemMapping__Group_4__0 )?
            {
             before(grammarAccess.getSubSystemMappingAccess().getGroup_4()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:863:1: ( rule__SubSystemMapping__Group_4__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:863:2: rule__SubSystemMapping__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__0_in_rule__SubSystemMapping__Group__4__Impl1689);
                    rule__SubSystemMapping__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubSystemMappingAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemMapping__Group__4__Impl"


    // $ANTLR start "rule__SubSystemMapping__Group_4__0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:883:1: rule__SubSystemMapping__Group_4__0 : rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1 ;
    public final void rule__SubSystemMapping__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:887:1: ( rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:888:2: rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__0__Impl_in_rule__SubSystemMapping__Group_4__01730);
            rule__SubSystemMapping__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__1_in_rule__SubSystemMapping__Group_4__01733);
            rule__SubSystemMapping__Group_4__1();

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
    // $ANTLR end "rule__SubSystemMapping__Group_4__0"


    // $ANTLR start "rule__SubSystemMapping__Group_4__0__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:895:1: rule__SubSystemMapping__Group_4__0__Impl : ( '{' ) ;
    public final void rule__SubSystemMapping__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:899:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:900:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:900:1: ( '{' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:901:1: '{'
            {
             before(grammarAccess.getSubSystemMappingAccess().getLeftCurlyBracketKeyword_4_0()); 
            match(input,13,FOLLOW_13_in_rule__SubSystemMapping__Group_4__0__Impl1761); 
             after(grammarAccess.getSubSystemMappingAccess().getLeftCurlyBracketKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemMapping__Group_4__0__Impl"


    // $ANTLR start "rule__SubSystemMapping__Group_4__1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:914:1: rule__SubSystemMapping__Group_4__1 : rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2 ;
    public final void rule__SubSystemMapping__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:918:1: ( rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:919:2: rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__1__Impl_in_rule__SubSystemMapping__Group_4__11792);
            rule__SubSystemMapping__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__2_in_rule__SubSystemMapping__Group_4__11795);
            rule__SubSystemMapping__Group_4__2();

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
    // $ANTLR end "rule__SubSystemMapping__Group_4__1"


    // $ANTLR start "rule__SubSystemMapping__Group_4__1__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:926:1: rule__SubSystemMapping__Group_4__1__Impl : ( ( rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1 )* ) ;
    public final void rule__SubSystemMapping__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:930:1: ( ( ( rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:931:1: ( ( rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:931:1: ( ( rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:932:1: ( rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1 )*
            {
             before(grammarAccess.getSubSystemMappingAccess().getActorInstanceMappingsAssignment_4_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:933:1: ( rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:933:2: rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1_in_rule__SubSystemMapping__Group_4__1__Impl1822);
            	    rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getSubSystemMappingAccess().getActorInstanceMappingsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemMapping__Group_4__1__Impl"


    // $ANTLR start "rule__SubSystemMapping__Group_4__2"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:943:1: rule__SubSystemMapping__Group_4__2 : rule__SubSystemMapping__Group_4__2__Impl ;
    public final void rule__SubSystemMapping__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:947:1: ( rule__SubSystemMapping__Group_4__2__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:948:2: rule__SubSystemMapping__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__2__Impl_in_rule__SubSystemMapping__Group_4__21853);
            rule__SubSystemMapping__Group_4__2__Impl();

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
    // $ANTLR end "rule__SubSystemMapping__Group_4__2"


    // $ANTLR start "rule__SubSystemMapping__Group_4__2__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:954:1: rule__SubSystemMapping__Group_4__2__Impl : ( '}' ) ;
    public final void rule__SubSystemMapping__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:958:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:959:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:959:1: ( '}' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:960:1: '}'
            {
             before(grammarAccess.getSubSystemMappingAccess().getRightCurlyBracketKeyword_4_2()); 
            match(input,14,FOLLOW_14_in_rule__SubSystemMapping__Group_4__2__Impl1881); 
             after(grammarAccess.getSubSystemMappingAccess().getRightCurlyBracketKeyword_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemMapping__Group_4__2__Impl"


    // $ANTLR start "rule__ActorInstanceMapping__Group__0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:979:1: rule__ActorInstanceMapping__Group__0 : rule__ActorInstanceMapping__Group__0__Impl rule__ActorInstanceMapping__Group__1 ;
    public final void rule__ActorInstanceMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:983:1: ( rule__ActorInstanceMapping__Group__0__Impl rule__ActorInstanceMapping__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:984:2: rule__ActorInstanceMapping__Group__0__Impl rule__ActorInstanceMapping__Group__1
            {
            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group__0__Impl_in_rule__ActorInstanceMapping__Group__01918);
            rule__ActorInstanceMapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group__1_in_rule__ActorInstanceMapping__Group__01921);
            rule__ActorInstanceMapping__Group__1();

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
    // $ANTLR end "rule__ActorInstanceMapping__Group__0"


    // $ANTLR start "rule__ActorInstanceMapping__Group__0__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:991:1: rule__ActorInstanceMapping__Group__0__Impl : ( 'ActorInstanceMapping' ) ;
    public final void rule__ActorInstanceMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:995:1: ( ( 'ActorInstanceMapping' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:996:1: ( 'ActorInstanceMapping' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:996:1: ( 'ActorInstanceMapping' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:997:1: 'ActorInstanceMapping'
            {
             before(grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__ActorInstanceMapping__Group__0__Impl1949); 
             after(grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceMapping__Group__0__Impl"


    // $ANTLR start "rule__ActorInstanceMapping__Group__1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1010:1: rule__ActorInstanceMapping__Group__1 : rule__ActorInstanceMapping__Group__1__Impl rule__ActorInstanceMapping__Group__2 ;
    public final void rule__ActorInstanceMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1014:1: ( rule__ActorInstanceMapping__Group__1__Impl rule__ActorInstanceMapping__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1015:2: rule__ActorInstanceMapping__Group__1__Impl rule__ActorInstanceMapping__Group__2
            {
            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group__1__Impl_in_rule__ActorInstanceMapping__Group__11980);
            rule__ActorInstanceMapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group__2_in_rule__ActorInstanceMapping__Group__11983);
            rule__ActorInstanceMapping__Group__2();

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
    // $ANTLR end "rule__ActorInstanceMapping__Group__1"


    // $ANTLR start "rule__ActorInstanceMapping__Group__1__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1022:1: rule__ActorInstanceMapping__Group__1__Impl : ( ( rule__ActorInstanceMapping__PathAssignment_1 ) ) ;
    public final void rule__ActorInstanceMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1026:1: ( ( ( rule__ActorInstanceMapping__PathAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1027:1: ( ( rule__ActorInstanceMapping__PathAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1027:1: ( ( rule__ActorInstanceMapping__PathAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1028:1: ( rule__ActorInstanceMapping__PathAssignment_1 )
            {
             before(grammarAccess.getActorInstanceMappingAccess().getPathAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1029:1: ( rule__ActorInstanceMapping__PathAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1029:2: rule__ActorInstanceMapping__PathAssignment_1
            {
            pushFollow(FOLLOW_rule__ActorInstanceMapping__PathAssignment_1_in_rule__ActorInstanceMapping__Group__1__Impl2010);
            rule__ActorInstanceMapping__PathAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getActorInstanceMappingAccess().getPathAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceMapping__Group__1__Impl"


    // $ANTLR start "rule__ActorInstanceMapping__Group__2"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1039:1: rule__ActorInstanceMapping__Group__2 : rule__ActorInstanceMapping__Group__2__Impl rule__ActorInstanceMapping__Group__3 ;
    public final void rule__ActorInstanceMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1043:1: ( rule__ActorInstanceMapping__Group__2__Impl rule__ActorInstanceMapping__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1044:2: rule__ActorInstanceMapping__Group__2__Impl rule__ActorInstanceMapping__Group__3
            {
            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group__2__Impl_in_rule__ActorInstanceMapping__Group__22040);
            rule__ActorInstanceMapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group__3_in_rule__ActorInstanceMapping__Group__22043);
            rule__ActorInstanceMapping__Group__3();

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
    // $ANTLR end "rule__ActorInstanceMapping__Group__2"


    // $ANTLR start "rule__ActorInstanceMapping__Group__2__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1051:1: rule__ActorInstanceMapping__Group__2__Impl : ( '->' ) ;
    public final void rule__ActorInstanceMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1055:1: ( ( '->' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1056:1: ( '->' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1056:1: ( '->' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1057:1: '->'
            {
             before(grammarAccess.getActorInstanceMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,16,FOLLOW_16_in_rule__ActorInstanceMapping__Group__2__Impl2071); 
             after(grammarAccess.getActorInstanceMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceMapping__Group__2__Impl"


    // $ANTLR start "rule__ActorInstanceMapping__Group__3"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1070:1: rule__ActorInstanceMapping__Group__3 : rule__ActorInstanceMapping__Group__3__Impl rule__ActorInstanceMapping__Group__4 ;
    public final void rule__ActorInstanceMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1074:1: ( rule__ActorInstanceMapping__Group__3__Impl rule__ActorInstanceMapping__Group__4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1075:2: rule__ActorInstanceMapping__Group__3__Impl rule__ActorInstanceMapping__Group__4
            {
            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group__3__Impl_in_rule__ActorInstanceMapping__Group__32102);
            rule__ActorInstanceMapping__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group__4_in_rule__ActorInstanceMapping__Group__32105);
            rule__ActorInstanceMapping__Group__4();

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
    // $ANTLR end "rule__ActorInstanceMapping__Group__3"


    // $ANTLR start "rule__ActorInstanceMapping__Group__3__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1082:1: rule__ActorInstanceMapping__Group__3__Impl : ( ( rule__ActorInstanceMapping__ThreadAssignment_3 ) ) ;
    public final void rule__ActorInstanceMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1086:1: ( ( ( rule__ActorInstanceMapping__ThreadAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1087:1: ( ( rule__ActorInstanceMapping__ThreadAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1087:1: ( ( rule__ActorInstanceMapping__ThreadAssignment_3 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1088:1: ( rule__ActorInstanceMapping__ThreadAssignment_3 )
            {
             before(grammarAccess.getActorInstanceMappingAccess().getThreadAssignment_3()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1089:1: ( rule__ActorInstanceMapping__ThreadAssignment_3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1089:2: rule__ActorInstanceMapping__ThreadAssignment_3
            {
            pushFollow(FOLLOW_rule__ActorInstanceMapping__ThreadAssignment_3_in_rule__ActorInstanceMapping__Group__3__Impl2132);
            rule__ActorInstanceMapping__ThreadAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getActorInstanceMappingAccess().getThreadAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceMapping__Group__3__Impl"


    // $ANTLR start "rule__ActorInstanceMapping__Group__4"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1099:1: rule__ActorInstanceMapping__Group__4 : rule__ActorInstanceMapping__Group__4__Impl ;
    public final void rule__ActorInstanceMapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1103:1: ( rule__ActorInstanceMapping__Group__4__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1104:2: rule__ActorInstanceMapping__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group__4__Impl_in_rule__ActorInstanceMapping__Group__42162);
            rule__ActorInstanceMapping__Group__4__Impl();

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
    // $ANTLR end "rule__ActorInstanceMapping__Group__4"


    // $ANTLR start "rule__ActorInstanceMapping__Group__4__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1110:1: rule__ActorInstanceMapping__Group__4__Impl : ( ( rule__ActorInstanceMapping__Group_4__0 )? ) ;
    public final void rule__ActorInstanceMapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1114:1: ( ( ( rule__ActorInstanceMapping__Group_4__0 )? ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1115:1: ( ( rule__ActorInstanceMapping__Group_4__0 )? )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1115:1: ( ( rule__ActorInstanceMapping__Group_4__0 )? )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1116:1: ( rule__ActorInstanceMapping__Group_4__0 )?
            {
             before(grammarAccess.getActorInstanceMappingAccess().getGroup_4()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1117:1: ( rule__ActorInstanceMapping__Group_4__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1117:2: rule__ActorInstanceMapping__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__ActorInstanceMapping__Group_4__0_in_rule__ActorInstanceMapping__Group__4__Impl2189);
                    rule__ActorInstanceMapping__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActorInstanceMappingAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceMapping__Group__4__Impl"


    // $ANTLR start "rule__ActorInstanceMapping__Group_4__0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1137:1: rule__ActorInstanceMapping__Group_4__0 : rule__ActorInstanceMapping__Group_4__0__Impl rule__ActorInstanceMapping__Group_4__1 ;
    public final void rule__ActorInstanceMapping__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1141:1: ( rule__ActorInstanceMapping__Group_4__0__Impl rule__ActorInstanceMapping__Group_4__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1142:2: rule__ActorInstanceMapping__Group_4__0__Impl rule__ActorInstanceMapping__Group_4__1
            {
            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group_4__0__Impl_in_rule__ActorInstanceMapping__Group_4__02230);
            rule__ActorInstanceMapping__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group_4__1_in_rule__ActorInstanceMapping__Group_4__02233);
            rule__ActorInstanceMapping__Group_4__1();

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
    // $ANTLR end "rule__ActorInstanceMapping__Group_4__0"


    // $ANTLR start "rule__ActorInstanceMapping__Group_4__0__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1149:1: rule__ActorInstanceMapping__Group_4__0__Impl : ( '{' ) ;
    public final void rule__ActorInstanceMapping__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1153:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1154:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1154:1: ( '{' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1155:1: '{'
            {
             before(grammarAccess.getActorInstanceMappingAccess().getLeftCurlyBracketKeyword_4_0()); 
            match(input,13,FOLLOW_13_in_rule__ActorInstanceMapping__Group_4__0__Impl2261); 
             after(grammarAccess.getActorInstanceMappingAccess().getLeftCurlyBracketKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceMapping__Group_4__0__Impl"


    // $ANTLR start "rule__ActorInstanceMapping__Group_4__1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1168:1: rule__ActorInstanceMapping__Group_4__1 : rule__ActorInstanceMapping__Group_4__1__Impl rule__ActorInstanceMapping__Group_4__2 ;
    public final void rule__ActorInstanceMapping__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1172:1: ( rule__ActorInstanceMapping__Group_4__1__Impl rule__ActorInstanceMapping__Group_4__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1173:2: rule__ActorInstanceMapping__Group_4__1__Impl rule__ActorInstanceMapping__Group_4__2
            {
            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group_4__1__Impl_in_rule__ActorInstanceMapping__Group_4__12292);
            rule__ActorInstanceMapping__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group_4__2_in_rule__ActorInstanceMapping__Group_4__12295);
            rule__ActorInstanceMapping__Group_4__2();

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
    // $ANTLR end "rule__ActorInstanceMapping__Group_4__1"


    // $ANTLR start "rule__ActorInstanceMapping__Group_4__1__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1180:1: rule__ActorInstanceMapping__Group_4__1__Impl : ( ( rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1 )* ) ;
    public final void rule__ActorInstanceMapping__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1184:1: ( ( ( rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1185:1: ( ( rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1185:1: ( ( rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1186:1: ( rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1 )*
            {
             before(grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingsAssignment_4_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1187:1: ( rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1187:2: rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1_in_rule__ActorInstanceMapping__Group_4__1__Impl2322);
            	    rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceMapping__Group_4__1__Impl"


    // $ANTLR start "rule__ActorInstanceMapping__Group_4__2"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1197:1: rule__ActorInstanceMapping__Group_4__2 : rule__ActorInstanceMapping__Group_4__2__Impl ;
    public final void rule__ActorInstanceMapping__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1201:1: ( rule__ActorInstanceMapping__Group_4__2__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1202:2: rule__ActorInstanceMapping__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__ActorInstanceMapping__Group_4__2__Impl_in_rule__ActorInstanceMapping__Group_4__22353);
            rule__ActorInstanceMapping__Group_4__2__Impl();

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
    // $ANTLR end "rule__ActorInstanceMapping__Group_4__2"


    // $ANTLR start "rule__ActorInstanceMapping__Group_4__2__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1208:1: rule__ActorInstanceMapping__Group_4__2__Impl : ( '}' ) ;
    public final void rule__ActorInstanceMapping__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1212:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1213:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1213:1: ( '}' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1214:1: '}'
            {
             before(grammarAccess.getActorInstanceMappingAccess().getRightCurlyBracketKeyword_4_2()); 
            match(input,14,FOLLOW_14_in_rule__ActorInstanceMapping__Group_4__2__Impl2381); 
             after(grammarAccess.getActorInstanceMappingAccess().getRightCurlyBracketKeyword_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceMapping__Group_4__2__Impl"


    // $ANTLR start "rule__RefPath__Group__0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1233:1: rule__RefPath__Group__0 : rule__RefPath__Group__0__Impl rule__RefPath__Group__1 ;
    public final void rule__RefPath__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1237:1: ( rule__RefPath__Group__0__Impl rule__RefPath__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1238:2: rule__RefPath__Group__0__Impl rule__RefPath__Group__1
            {
            pushFollow(FOLLOW_rule__RefPath__Group__0__Impl_in_rule__RefPath__Group__02418);
            rule__RefPath__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RefPath__Group__1_in_rule__RefPath__Group__02421);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1245:1: rule__RefPath__Group__0__Impl : ( ( rule__RefPath__RefsAssignment_0 ) ) ;
    public final void rule__RefPath__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1249:1: ( ( ( rule__RefPath__RefsAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1250:1: ( ( rule__RefPath__RefsAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1250:1: ( ( rule__RefPath__RefsAssignment_0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1251:1: ( rule__RefPath__RefsAssignment_0 )
            {
             before(grammarAccess.getRefPathAccess().getRefsAssignment_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1252:1: ( rule__RefPath__RefsAssignment_0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1252:2: rule__RefPath__RefsAssignment_0
            {
            pushFollow(FOLLOW_rule__RefPath__RefsAssignment_0_in_rule__RefPath__Group__0__Impl2448);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1262:1: rule__RefPath__Group__1 : rule__RefPath__Group__1__Impl ;
    public final void rule__RefPath__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1266:1: ( rule__RefPath__Group__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1267:2: rule__RefPath__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RefPath__Group__1__Impl_in_rule__RefPath__Group__12478);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1273:1: rule__RefPath__Group__1__Impl : ( ( rule__RefPath__Group_1__0 )* ) ;
    public final void rule__RefPath__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1277:1: ( ( ( rule__RefPath__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1278:1: ( ( rule__RefPath__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1278:1: ( ( rule__RefPath__Group_1__0 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1279:1: ( rule__RefPath__Group_1__0 )*
            {
             before(grammarAccess.getRefPathAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1280:1: ( rule__RefPath__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1280:2: rule__RefPath__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__RefPath__Group_1__0_in_rule__RefPath__Group__1__Impl2505);
            	    rule__RefPath__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1294:1: rule__RefPath__Group_1__0 : rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1 ;
    public final void rule__RefPath__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1298:1: ( rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1299:2: rule__RefPath__Group_1__0__Impl rule__RefPath__Group_1__1
            {
            pushFollow(FOLLOW_rule__RefPath__Group_1__0__Impl_in_rule__RefPath__Group_1__02540);
            rule__RefPath__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RefPath__Group_1__1_in_rule__RefPath__Group_1__02543);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1306:1: rule__RefPath__Group_1__0__Impl : ( '/' ) ;
    public final void rule__RefPath__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1310:1: ( ( '/' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1311:1: ( '/' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1311:1: ( '/' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1312:1: '/'
            {
             before(grammarAccess.getRefPathAccess().getSolidusKeyword_1_0()); 
            match(input,19,FOLLOW_19_in_rule__RefPath__Group_1__0__Impl2571); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1325:1: rule__RefPath__Group_1__1 : rule__RefPath__Group_1__1__Impl ;
    public final void rule__RefPath__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1329:1: ( rule__RefPath__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1330:2: rule__RefPath__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__RefPath__Group_1__1__Impl_in_rule__RefPath__Group_1__12602);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1336:1: rule__RefPath__Group_1__1__Impl : ( ( rule__RefPath__RefsAssignment_1_1 ) ) ;
    public final void rule__RefPath__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1340:1: ( ( ( rule__RefPath__RefsAssignment_1_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1341:1: ( ( rule__RefPath__RefsAssignment_1_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1341:1: ( ( rule__RefPath__RefsAssignment_1_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1342:1: ( rule__RefPath__RefsAssignment_1_1 )
            {
             before(grammarAccess.getRefPathAccess().getRefsAssignment_1_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1343:1: ( rule__RefPath__RefsAssignment_1_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1343:2: rule__RefPath__RefsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RefPath__RefsAssignment_1_1_in_rule__RefPath__Group_1__1__Impl2629);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1357:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1361:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1362:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02663);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02666);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1369:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1373:1: ( ( 'import' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1374:1: ( 'import' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1374:1: ( 'import' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1375:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__Import__Group__0__Impl2694); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1388:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1392:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1393:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12725);
            rule__Import__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__2_in_rule__Import__Group__12728);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1400:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1404:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1405:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1405:1: ( ( rule__Import__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1406:1: ( rule__Import__Alternatives_1 )
            {
             before(grammarAccess.getImportAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1407:1: ( rule__Import__Alternatives_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1407:2: rule__Import__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl2755);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1417:1: rule__Import__Group__2 : rule__Import__Group__2__Impl ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1421:1: ( rule__Import__Group__2__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1422:2: rule__Import__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__22785);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1428:1: rule__Import__Group__2__Impl : ( ( rule__Import__ImportURIAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1432:1: ( ( ( rule__Import__ImportURIAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1433:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1433:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1434:1: ( rule__Import__ImportURIAssignment_2 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_2()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1435:1: ( rule__Import__ImportURIAssignment_2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1435:2: rule__Import__ImportURIAssignment_2
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl2812);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1451:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1455:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1456:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__02848);
            rule__Import__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__02851);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1463:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1467:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1468:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1468:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1469:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1470:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1470:2: rule__Import__ImportedNamespaceAssignment_1_0_0
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl2878);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1480:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1484:1: ( rule__Import__Group_1_0__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1485:2: rule__Import__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__12908);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1491:1: rule__Import__Group_1_0__1__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1495:1: ( ( 'from' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1496:1: ( 'from' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1496:1: ( 'from' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1497:1: 'from'
            {
             before(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 
            match(input,21,FOLLOW_21_in_rule__Import__Group_1_0__1__Impl2936); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1514:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1518:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1519:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__02971);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__02974);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1526:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1530:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1531:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1531:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1532:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl3001);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1543:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1547:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1548:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__13030);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1554:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1558:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1559:1: ( ( '.*' )? )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1559:1: ( ( '.*' )? )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1560:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1561:1: ( '.*' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1562:2: '.*'
                    {
                    match(input,22,FOLLOW_22_in_rule__ImportedFQN__Group__1__Impl3059); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1577:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1581:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1582:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__03096);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__03099);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1589:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1593:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1594:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1594:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1595:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl3126); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1606:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1610:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1611:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__13155);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1617:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1621:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1622:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1622:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1623:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1624:1: ( rule__FQN__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1624:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl3182);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1638:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1642:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1643:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__03217);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__03220);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1650:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1654:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1655:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1655:1: ( '.' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1656:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,23,FOLLOW_23_in_rule__FQN__Group_1__0__Impl3248); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1669:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1673:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1674:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__13279);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1680:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1684:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1685:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1685:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1686:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl3306); 
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


    // $ANTLR start "rule__MappingModel__NameAssignment_1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1702:1: rule__MappingModel__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__MappingModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1706:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1707:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1707:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1708:1: ruleFQN
            {
             before(grammarAccess.getMappingModelAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__MappingModel__NameAssignment_13344);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getMappingModelAccess().getNameFQNParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__NameAssignment_1"


    // $ANTLR start "rule__MappingModel__ImportsAssignment_3"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1717:1: rule__MappingModel__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__MappingModel__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1721:1: ( ( ruleImport ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1722:1: ( ruleImport )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1722:1: ( ruleImport )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1723:1: ruleImport
            {
             before(grammarAccess.getMappingModelAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__MappingModel__ImportsAssignment_33375);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getMappingModelAccess().getImportsImportParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__ImportsAssignment_3"


    // $ANTLR start "rule__MappingModel__MappingsAssignment_4"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1732:1: rule__MappingModel__MappingsAssignment_4 : ( ruleMapping ) ;
    public final void rule__MappingModel__MappingsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1736:1: ( ( ruleMapping ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1737:1: ( ruleMapping )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1737:1: ( ruleMapping )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1738:1: ruleMapping
            {
             before(grammarAccess.getMappingModelAccess().getMappingsMappingParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleMapping_in_rule__MappingModel__MappingsAssignment_43406);
            ruleMapping();

            state._fsp--;

             after(grammarAccess.getMappingModelAccess().getMappingsMappingParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__MappingsAssignment_4"


    // $ANTLR start "rule__Mapping__LogicalSysAssignment_1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1747:1: rule__Mapping__LogicalSysAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__Mapping__LogicalSysAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1751:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1752:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1752:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1753:1: ( ruleFQN )
            {
             before(grammarAccess.getMappingAccess().getLogicalSysLogicalSystemCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1754:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1755:1: ruleFQN
            {
             before(grammarAccess.getMappingAccess().getLogicalSysLogicalSystemFQNParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__Mapping__LogicalSysAssignment_13441);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getMappingAccess().getLogicalSysLogicalSystemFQNParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getMappingAccess().getLogicalSysLogicalSystemCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__LogicalSysAssignment_1"


    // $ANTLR start "rule__Mapping__PhysicalSysAssignment_3"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1766:1: rule__Mapping__PhysicalSysAssignment_3 : ( ( ruleFQN ) ) ;
    public final void rule__Mapping__PhysicalSysAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1770:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1771:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1771:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1772:1: ( ruleFQN )
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysPhysicalSystemCrossReference_3_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1773:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1774:1: ruleFQN
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysPhysicalSystemFQNParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__Mapping__PhysicalSysAssignment_33480);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getMappingAccess().getPhysicalSysPhysicalSystemFQNParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getMappingAccess().getPhysicalSysPhysicalSystemCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__PhysicalSysAssignment_3"


    // $ANTLR start "rule__Mapping__SubsysMappingsAssignment_5"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1785:1: rule__Mapping__SubsysMappingsAssignment_5 : ( ruleSubSystemMapping ) ;
    public final void rule__Mapping__SubsysMappingsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1789:1: ( ( ruleSubSystemMapping ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1790:1: ( ruleSubSystemMapping )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1790:1: ( ruleSubSystemMapping )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1791:1: ruleSubSystemMapping
            {
             before(grammarAccess.getMappingAccess().getSubsysMappingsSubSystemMappingParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSubSystemMapping_in_rule__Mapping__SubsysMappingsAssignment_53515);
            ruleSubSystemMapping();

            state._fsp--;

             after(grammarAccess.getMappingAccess().getSubsysMappingsSubSystemMappingParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__SubsysMappingsAssignment_5"


    // $ANTLR start "rule__SubSystemMapping__LogicalSubSysAssignment_1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1800:1: rule__SubSystemMapping__LogicalSubSysAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemMapping__LogicalSubSysAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1804:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1805:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1805:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1806:1: ( RULE_ID )
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1807:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1808:1: RULE_ID
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubSystemMapping__LogicalSubSysAssignment_13550); 
             after(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemMapping__LogicalSubSysAssignment_1"


    // $ANTLR start "rule__SubSystemMapping__NodeAssignment_3"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1819:1: rule__SubSystemMapping__NodeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemMapping__NodeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1823:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1824:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1824:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1825:1: ( RULE_ID )
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeNodeRefCrossReference_3_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1826:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1827:1: RULE_ID
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeNodeRefIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubSystemMapping__NodeAssignment_33589); 
             after(grammarAccess.getSubSystemMappingAccess().getNodeNodeRefIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getSubSystemMappingAccess().getNodeNodeRefCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemMapping__NodeAssignment_3"


    // $ANTLR start "rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1838:1: rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1 : ( ruleActorInstanceMapping ) ;
    public final void rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1842:1: ( ( ruleActorInstanceMapping ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1843:1: ( ruleActorInstanceMapping )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1843:1: ( ruleActorInstanceMapping )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1844:1: ruleActorInstanceMapping
            {
             before(grammarAccess.getSubSystemMappingAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleActorInstanceMapping_in_rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_13624);
            ruleActorInstanceMapping();

            state._fsp--;

             after(grammarAccess.getSubSystemMappingAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1"


    // $ANTLR start "rule__ActorInstanceMapping__PathAssignment_1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1853:1: rule__ActorInstanceMapping__PathAssignment_1 : ( ruleRefPath ) ;
    public final void rule__ActorInstanceMapping__PathAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1857:1: ( ( ruleRefPath ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1858:1: ( ruleRefPath )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1858:1: ( ruleRefPath )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1859:1: ruleRefPath
            {
             before(grammarAccess.getActorInstanceMappingAccess().getPathRefPathParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleRefPath_in_rule__ActorInstanceMapping__PathAssignment_13655);
            ruleRefPath();

            state._fsp--;

             after(grammarAccess.getActorInstanceMappingAccess().getPathRefPathParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceMapping__PathAssignment_1"


    // $ANTLR start "rule__ActorInstanceMapping__ThreadAssignment_3"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1868:1: rule__ActorInstanceMapping__ThreadAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__ActorInstanceMapping__ThreadAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1872:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1873:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1873:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1874:1: ( RULE_ID )
            {
             before(grammarAccess.getActorInstanceMappingAccess().getThreadThreadCrossReference_3_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1875:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1876:1: RULE_ID
            {
             before(grammarAccess.getActorInstanceMappingAccess().getThreadThreadIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ActorInstanceMapping__ThreadAssignment_33690); 
             after(grammarAccess.getActorInstanceMappingAccess().getThreadThreadIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getActorInstanceMappingAccess().getThreadThreadCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceMapping__ThreadAssignment_3"


    // $ANTLR start "rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1887:1: rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1 : ( ruleActorInstanceMapping ) ;
    public final void rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1891:1: ( ( ruleActorInstanceMapping ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1892:1: ( ruleActorInstanceMapping )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1892:1: ( ruleActorInstanceMapping )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1893:1: ruleActorInstanceMapping
            {
             before(grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleActorInstanceMapping_in_rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_13725);
            ruleActorInstanceMapping();

            state._fsp--;

             after(grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1"


    // $ANTLR start "rule__RefPath__RefsAssignment_0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1902:1: rule__RefPath__RefsAssignment_0 : ( RULE_ID ) ;
    public final void rule__RefPath__RefsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1906:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1907:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1907:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1908:1: RULE_ID
            {
             before(grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_03756); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1917:1: rule__RefPath__RefsAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__RefPath__RefsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1921:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1922:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1922:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1923:1: RULE_ID
            {
             before(grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_1_13787); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1932:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1936:1: ( ( ruleImportedFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1937:1: ( ruleImportedFQN )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1937:1: ( ruleImportedFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1938:1: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_03818);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1947:1: rule__Import__ImportURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1951:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1952:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1952:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1953:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_23849); 
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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleMappingModel_in_entryRuleMappingModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__0_in_ruleMappingModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_entryRuleMapping121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapping128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__0_in_ruleMapping154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemMapping_in_entryRuleSubSystemMapping181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemMapping188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__0_in_ruleSubSystemMapping214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstanceMapping_in_entryRuleActorInstanceMapping241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorInstanceMapping248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group__0_in_ruleActorInstanceMapping274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefPath_in_entryRuleRefPath301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefPath308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group__0_in_ruleRefPath334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Import__Alternatives_1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__0__Impl_in_rule__MappingModel__Group__0601 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__1_in_rule__MappingModel__Group__0604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__MappingModel__Group__0__Impl632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__1__Impl_in_rule__MappingModel__Group__1663 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__2_in_rule__MappingModel__Group__1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__NameAssignment_1_in_rule__MappingModel__Group__1__Impl693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__2__Impl_in_rule__MappingModel__Group__2723 = new BitSet(new long[]{0x000000000010C000L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__3_in_rule__MappingModel__Group__2726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__MappingModel__Group__2__Impl754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__3__Impl_in_rule__MappingModel__Group__3785 = new BitSet(new long[]{0x000000000010C000L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__4_in_rule__MappingModel__Group__3788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__ImportsAssignment_3_in_rule__MappingModel__Group__3__Impl815 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__4__Impl_in_rule__MappingModel__Group__4846 = new BitSet(new long[]{0x000000000010C000L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__5_in_rule__MappingModel__Group__4849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__MappingsAssignment_4_in_rule__MappingModel__Group__4__Impl876 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__5__Impl_in_rule__MappingModel__Group__5907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__MappingModel__Group__5__Impl935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__0__Impl_in_rule__Mapping__Group__0978 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Mapping__Group__1_in_rule__Mapping__Group__0981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Mapping__Group__0__Impl1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__1__Impl_in_rule__Mapping__Group__11040 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Mapping__Group__2_in_rule__Mapping__Group__11043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__LogicalSysAssignment_1_in_rule__Mapping__Group__1__Impl1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__2__Impl_in_rule__Mapping__Group__21100 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Mapping__Group__3_in_rule__Mapping__Group__21103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Mapping__Group__2__Impl1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__3__Impl_in_rule__Mapping__Group__31162 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Mapping__Group__4_in_rule__Mapping__Group__31165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__PhysicalSysAssignment_3_in_rule__Mapping__Group__3__Impl1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__4__Impl_in_rule__Mapping__Group__41222 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_rule__Mapping__Group__5_in_rule__Mapping__Group__41225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Mapping__Group__4__Impl1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__5__Impl_in_rule__Mapping__Group__51284 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_rule__Mapping__Group__6_in_rule__Mapping__Group__51287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__SubsysMappingsAssignment_5_in_rule__Mapping__Group__5__Impl1314 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__6__Impl_in_rule__Mapping__Group__61345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Mapping__Group__6__Impl1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__0__Impl_in_rule__SubSystemMapping__Group__01418 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__1_in_rule__SubSystemMapping__Group__01421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__SubSystemMapping__Group__0__Impl1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__1__Impl_in_rule__SubSystemMapping__Group__11480 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__2_in_rule__SubSystemMapping__Group__11483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__LogicalSubSysAssignment_1_in_rule__SubSystemMapping__Group__1__Impl1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__2__Impl_in_rule__SubSystemMapping__Group__21540 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__3_in_rule__SubSystemMapping__Group__21543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__SubSystemMapping__Group__2__Impl1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__3__Impl_in_rule__SubSystemMapping__Group__31602 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__4_in_rule__SubSystemMapping__Group__31605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__NodeAssignment_3_in_rule__SubSystemMapping__Group__3__Impl1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__4__Impl_in_rule__SubSystemMapping__Group__41662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__0_in_rule__SubSystemMapping__Group__4__Impl1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__0__Impl_in_rule__SubSystemMapping__Group_4__01730 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__1_in_rule__SubSystemMapping__Group_4__01733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__SubSystemMapping__Group_4__0__Impl1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__1__Impl_in_rule__SubSystemMapping__Group_4__11792 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__2_in_rule__SubSystemMapping__Group_4__11795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_1_in_rule__SubSystemMapping__Group_4__1__Impl1822 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__2__Impl_in_rule__SubSystemMapping__Group_4__21853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__SubSystemMapping__Group_4__2__Impl1881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group__0__Impl_in_rule__ActorInstanceMapping__Group__01918 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group__1_in_rule__ActorInstanceMapping__Group__01921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ActorInstanceMapping__Group__0__Impl1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group__1__Impl_in_rule__ActorInstanceMapping__Group__11980 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group__2_in_rule__ActorInstanceMapping__Group__11983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__PathAssignment_1_in_rule__ActorInstanceMapping__Group__1__Impl2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group__2__Impl_in_rule__ActorInstanceMapping__Group__22040 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group__3_in_rule__ActorInstanceMapping__Group__22043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ActorInstanceMapping__Group__2__Impl2071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group__3__Impl_in_rule__ActorInstanceMapping__Group__32102 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group__4_in_rule__ActorInstanceMapping__Group__32105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__ThreadAssignment_3_in_rule__ActorInstanceMapping__Group__3__Impl2132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group__4__Impl_in_rule__ActorInstanceMapping__Group__42162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group_4__0_in_rule__ActorInstanceMapping__Group__4__Impl2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group_4__0__Impl_in_rule__ActorInstanceMapping__Group_4__02230 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group_4__1_in_rule__ActorInstanceMapping__Group_4__02233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ActorInstanceMapping__Group_4__0__Impl2261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group_4__1__Impl_in_rule__ActorInstanceMapping__Group_4__12292 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group_4__2_in_rule__ActorInstanceMapping__Group_4__12295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_1_in_rule__ActorInstanceMapping__Group_4__1__Impl2322 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__ActorInstanceMapping__Group_4__2__Impl_in_rule__ActorInstanceMapping__Group_4__22353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ActorInstanceMapping__Group_4__2__Impl2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group__0__Impl_in_rule__RefPath__Group__02418 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__RefPath__Group__1_in_rule__RefPath__Group__02421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__RefsAssignment_0_in_rule__RefPath__Group__0__Impl2448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group__1__Impl_in_rule__RefPath__Group__12478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__0_in_rule__RefPath__Group__1__Impl2505 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__0__Impl_in_rule__RefPath__Group_1__02540 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__1_in_rule__RefPath__Group_1__02543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__RefPath__Group_1__0__Impl2571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__Group_1__1__Impl_in_rule__RefPath__Group_1__12602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RefPath__RefsAssignment_1_1_in_rule__RefPath__Group_1__1__Impl2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02663 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Import__Group__0__Impl2694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12725 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Import__Group__2_in_rule__Import__Group__12728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__22785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl2812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__02848 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__02851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl2878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__12908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Import__Group_1_0__1__Impl2936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__02971 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__02974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl3001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__13030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ImportedFQN__Group__1__Impl3059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__03096 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__03099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl3126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__13155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl3182 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__03217 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__03220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__FQN__Group_1__0__Impl3248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__13279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl3306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__MappingModel__NameAssignment_13344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__MappingModel__ImportsAssignment_33375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_rule__MappingModel__MappingsAssignment_43406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Mapping__LogicalSysAssignment_13441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Mapping__PhysicalSysAssignment_33480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemMapping_in_rule__Mapping__SubsysMappingsAssignment_53515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubSystemMapping__LogicalSubSysAssignment_13550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubSystemMapping__NodeAssignment_33589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstanceMapping_in_rule__SubSystemMapping__ActorInstanceMappingsAssignment_4_13624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefPath_in_rule__ActorInstanceMapping__PathAssignment_13655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ActorInstanceMapping__ThreadAssignment_33690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstanceMapping_in_rule__ActorInstanceMapping__ActorInstanceMappingsAssignment_4_13725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_03756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RefPath__RefsAssignment_1_13787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_03818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_23849 = new BitSet(new long[]{0x0000000000000002L});

}