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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "'MappingModel'", "'{'", "'}'", "'Mapping'", "'->'", "'SubSystemMapping'", "'ThreadMapping'", "'import'", "'from'", "'.*'", "'.'"
    };
    public static final int RULE_ID=4;
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


    // $ANTLR start "entryRuleThreadMapping"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:144:1: entryRuleThreadMapping : ruleThreadMapping EOF ;
    public final void entryRuleThreadMapping() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:145:1: ( ruleThreadMapping EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:146:1: ruleThreadMapping EOF
            {
             before(grammarAccess.getThreadMappingRule()); 
            pushFollow(FOLLOW_ruleThreadMapping_in_entryRuleThreadMapping241);
            ruleThreadMapping();

            state._fsp--;

             after(grammarAccess.getThreadMappingRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThreadMapping248); 

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
    // $ANTLR end "entryRuleThreadMapping"


    // $ANTLR start "ruleThreadMapping"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:153:1: ruleThreadMapping : ( ( rule__ThreadMapping__Group__0 ) ) ;
    public final void ruleThreadMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:157:2: ( ( ( rule__ThreadMapping__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:158:1: ( ( rule__ThreadMapping__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:158:1: ( ( rule__ThreadMapping__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:159:1: ( rule__ThreadMapping__Group__0 )
            {
             before(grammarAccess.getThreadMappingAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:160:1: ( rule__ThreadMapping__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:160:2: rule__ThreadMapping__Group__0
            {
            pushFollow(FOLLOW_rule__ThreadMapping__Group__0_in_ruleThreadMapping274);
            rule__ThreadMapping__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getThreadMappingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleThreadMapping"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:172:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:173:1: ( ruleImport EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:174:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport301);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport308); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:181:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:185:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:186:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:186:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:187:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:188:1: ( rule__Import__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:188:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport334);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:200:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:201:1: ( ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:202:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN361);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN368); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:209:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:213:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:214:1: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:214:1: ( ( rule__ImportedFQN__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:215:1: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:216:1: ( rule__ImportedFQN__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:216:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN394);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:228:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:229:1: ( ruleFQN EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:230:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN421);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN428); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:237:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:241:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:242:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:242:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:243:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:244:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:244:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN454);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:256:1: rule__Import__Alternatives_1 : ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) );
    public final void rule__Import__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:260:1: ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) )
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
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:261:1: ( ( rule__Import__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:261:1: ( ( rule__Import__Group_1_0__0 ) )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:262:1: ( rule__Import__Group_1_0__0 )
                    {
                     before(grammarAccess.getImportAccess().getGroup_1_0()); 
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:263:1: ( rule__Import__Group_1_0__0 )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:263:2: rule__Import__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_1490);
                    rule__Import__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getImportAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:267:6: ( 'model' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:267:6: ( 'model' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:268:1: 'model'
                    {
                     before(grammarAccess.getImportAccess().getModelKeyword_1_1()); 
                    match(input,11,FOLLOW_11_in_rule__Import__Alternatives_1509); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:282:1: rule__MappingModel__Group__0 : rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1 ;
    public final void rule__MappingModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:286:1: ( rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:287:2: rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__0__Impl_in_rule__MappingModel__Group__0541);
            rule__MappingModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__1_in_rule__MappingModel__Group__0544);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:294:1: rule__MappingModel__Group__0__Impl : ( 'MappingModel' ) ;
    public final void rule__MappingModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:298:1: ( ( 'MappingModel' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:299:1: ( 'MappingModel' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:299:1: ( 'MappingModel' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:300:1: 'MappingModel'
            {
             before(grammarAccess.getMappingModelAccess().getMappingModelKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__MappingModel__Group__0__Impl572); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:313:1: rule__MappingModel__Group__1 : rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2 ;
    public final void rule__MappingModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:317:1: ( rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:318:2: rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__1__Impl_in_rule__MappingModel__Group__1603);
            rule__MappingModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__2_in_rule__MappingModel__Group__1606);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:325:1: rule__MappingModel__Group__1__Impl : ( ( rule__MappingModel__NameAssignment_1 ) ) ;
    public final void rule__MappingModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:329:1: ( ( ( rule__MappingModel__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:330:1: ( ( rule__MappingModel__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:330:1: ( ( rule__MappingModel__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:331:1: ( rule__MappingModel__NameAssignment_1 )
            {
             before(grammarAccess.getMappingModelAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:332:1: ( rule__MappingModel__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:332:2: rule__MappingModel__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__MappingModel__NameAssignment_1_in_rule__MappingModel__Group__1__Impl633);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:342:1: rule__MappingModel__Group__2 : rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3 ;
    public final void rule__MappingModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:346:1: ( rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:347:2: rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__2__Impl_in_rule__MappingModel__Group__2663);
            rule__MappingModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__3_in_rule__MappingModel__Group__2666);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:354:1: rule__MappingModel__Group__2__Impl : ( '{' ) ;
    public final void rule__MappingModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:358:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:359:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:359:1: ( '{' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:360:1: '{'
            {
             before(grammarAccess.getMappingModelAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__MappingModel__Group__2__Impl694); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:373:1: rule__MappingModel__Group__3 : rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4 ;
    public final void rule__MappingModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:377:1: ( rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:378:2: rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__3__Impl_in_rule__MappingModel__Group__3725);
            rule__MappingModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__4_in_rule__MappingModel__Group__3728);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:385:1: rule__MappingModel__Group__3__Impl : ( ( rule__MappingModel__ImportsAssignment_3 )* ) ;
    public final void rule__MappingModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:389:1: ( ( ( rule__MappingModel__ImportsAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:390:1: ( ( rule__MappingModel__ImportsAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:390:1: ( ( rule__MappingModel__ImportsAssignment_3 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:391:1: ( rule__MappingModel__ImportsAssignment_3 )*
            {
             before(grammarAccess.getMappingModelAccess().getImportsAssignment_3()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:392:1: ( rule__MappingModel__ImportsAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:392:2: rule__MappingModel__ImportsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__MappingModel__ImportsAssignment_3_in_rule__MappingModel__Group__3__Impl755);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:402:1: rule__MappingModel__Group__4 : rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5 ;
    public final void rule__MappingModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:406:1: ( rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:407:2: rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__4__Impl_in_rule__MappingModel__Group__4786);
            rule__MappingModel__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__5_in_rule__MappingModel__Group__4789);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:414:1: rule__MappingModel__Group__4__Impl : ( ( rule__MappingModel__MappingsAssignment_4 )* ) ;
    public final void rule__MappingModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:418:1: ( ( ( rule__MappingModel__MappingsAssignment_4 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:419:1: ( ( rule__MappingModel__MappingsAssignment_4 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:419:1: ( ( rule__MappingModel__MappingsAssignment_4 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:420:1: ( rule__MappingModel__MappingsAssignment_4 )*
            {
             before(grammarAccess.getMappingModelAccess().getMappingsAssignment_4()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:421:1: ( rule__MappingModel__MappingsAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:421:2: rule__MappingModel__MappingsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__MappingModel__MappingsAssignment_4_in_rule__MappingModel__Group__4__Impl816);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:431:1: rule__MappingModel__Group__5 : rule__MappingModel__Group__5__Impl ;
    public final void rule__MappingModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:435:1: ( rule__MappingModel__Group__5__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:436:2: rule__MappingModel__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__5__Impl_in_rule__MappingModel__Group__5847);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:442:1: rule__MappingModel__Group__5__Impl : ( '}' ) ;
    public final void rule__MappingModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:446:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:447:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:447:1: ( '}' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:448:1: '}'
            {
             before(grammarAccess.getMappingModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,14,FOLLOW_14_in_rule__MappingModel__Group__5__Impl875); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:473:1: rule__Mapping__Group__0 : rule__Mapping__Group__0__Impl rule__Mapping__Group__1 ;
    public final void rule__Mapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:477:1: ( rule__Mapping__Group__0__Impl rule__Mapping__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:478:2: rule__Mapping__Group__0__Impl rule__Mapping__Group__1
            {
            pushFollow(FOLLOW_rule__Mapping__Group__0__Impl_in_rule__Mapping__Group__0918);
            rule__Mapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__1_in_rule__Mapping__Group__0921);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:485:1: rule__Mapping__Group__0__Impl : ( 'Mapping' ) ;
    public final void rule__Mapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:489:1: ( ( 'Mapping' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:490:1: ( 'Mapping' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:490:1: ( 'Mapping' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:491:1: 'Mapping'
            {
             before(grammarAccess.getMappingAccess().getMappingKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__Mapping__Group__0__Impl949); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:504:1: rule__Mapping__Group__1 : rule__Mapping__Group__1__Impl rule__Mapping__Group__2 ;
    public final void rule__Mapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:508:1: ( rule__Mapping__Group__1__Impl rule__Mapping__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:509:2: rule__Mapping__Group__1__Impl rule__Mapping__Group__2
            {
            pushFollow(FOLLOW_rule__Mapping__Group__1__Impl_in_rule__Mapping__Group__1980);
            rule__Mapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__2_in_rule__Mapping__Group__1983);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:516:1: rule__Mapping__Group__1__Impl : ( ( rule__Mapping__LogicalSysAssignment_1 ) ) ;
    public final void rule__Mapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:520:1: ( ( ( rule__Mapping__LogicalSysAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:521:1: ( ( rule__Mapping__LogicalSysAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:521:1: ( ( rule__Mapping__LogicalSysAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:522:1: ( rule__Mapping__LogicalSysAssignment_1 )
            {
             before(grammarAccess.getMappingAccess().getLogicalSysAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:523:1: ( rule__Mapping__LogicalSysAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:523:2: rule__Mapping__LogicalSysAssignment_1
            {
            pushFollow(FOLLOW_rule__Mapping__LogicalSysAssignment_1_in_rule__Mapping__Group__1__Impl1010);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:533:1: rule__Mapping__Group__2 : rule__Mapping__Group__2__Impl rule__Mapping__Group__3 ;
    public final void rule__Mapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:537:1: ( rule__Mapping__Group__2__Impl rule__Mapping__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:538:2: rule__Mapping__Group__2__Impl rule__Mapping__Group__3
            {
            pushFollow(FOLLOW_rule__Mapping__Group__2__Impl_in_rule__Mapping__Group__21040);
            rule__Mapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__3_in_rule__Mapping__Group__21043);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:545:1: rule__Mapping__Group__2__Impl : ( '->' ) ;
    public final void rule__Mapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:549:1: ( ( '->' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:550:1: ( '->' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:550:1: ( '->' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:551:1: '->'
            {
             before(grammarAccess.getMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,16,FOLLOW_16_in_rule__Mapping__Group__2__Impl1071); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:564:1: rule__Mapping__Group__3 : rule__Mapping__Group__3__Impl rule__Mapping__Group__4 ;
    public final void rule__Mapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:568:1: ( rule__Mapping__Group__3__Impl rule__Mapping__Group__4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:569:2: rule__Mapping__Group__3__Impl rule__Mapping__Group__4
            {
            pushFollow(FOLLOW_rule__Mapping__Group__3__Impl_in_rule__Mapping__Group__31102);
            rule__Mapping__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__4_in_rule__Mapping__Group__31105);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:576:1: rule__Mapping__Group__3__Impl : ( ( rule__Mapping__PhysicalSysAssignment_3 ) ) ;
    public final void rule__Mapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:580:1: ( ( ( rule__Mapping__PhysicalSysAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:581:1: ( ( rule__Mapping__PhysicalSysAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:581:1: ( ( rule__Mapping__PhysicalSysAssignment_3 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:582:1: ( rule__Mapping__PhysicalSysAssignment_3 )
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysAssignment_3()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:583:1: ( rule__Mapping__PhysicalSysAssignment_3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:583:2: rule__Mapping__PhysicalSysAssignment_3
            {
            pushFollow(FOLLOW_rule__Mapping__PhysicalSysAssignment_3_in_rule__Mapping__Group__3__Impl1132);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:593:1: rule__Mapping__Group__4 : rule__Mapping__Group__4__Impl rule__Mapping__Group__5 ;
    public final void rule__Mapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:597:1: ( rule__Mapping__Group__4__Impl rule__Mapping__Group__5 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:598:2: rule__Mapping__Group__4__Impl rule__Mapping__Group__5
            {
            pushFollow(FOLLOW_rule__Mapping__Group__4__Impl_in_rule__Mapping__Group__41162);
            rule__Mapping__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__5_in_rule__Mapping__Group__41165);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:605:1: rule__Mapping__Group__4__Impl : ( '{' ) ;
    public final void rule__Mapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:609:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:610:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:610:1: ( '{' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:611:1: '{'
            {
             before(grammarAccess.getMappingAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,13,FOLLOW_13_in_rule__Mapping__Group__4__Impl1193); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:624:1: rule__Mapping__Group__5 : rule__Mapping__Group__5__Impl rule__Mapping__Group__6 ;
    public final void rule__Mapping__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:628:1: ( rule__Mapping__Group__5__Impl rule__Mapping__Group__6 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:629:2: rule__Mapping__Group__5__Impl rule__Mapping__Group__6
            {
            pushFollow(FOLLOW_rule__Mapping__Group__5__Impl_in_rule__Mapping__Group__51224);
            rule__Mapping__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__6_in_rule__Mapping__Group__51227);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:636:1: rule__Mapping__Group__5__Impl : ( ( rule__Mapping__SubsysMappingsAssignment_5 )* ) ;
    public final void rule__Mapping__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:640:1: ( ( ( rule__Mapping__SubsysMappingsAssignment_5 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:641:1: ( ( rule__Mapping__SubsysMappingsAssignment_5 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:641:1: ( ( rule__Mapping__SubsysMappingsAssignment_5 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:642:1: ( rule__Mapping__SubsysMappingsAssignment_5 )*
            {
             before(grammarAccess.getMappingAccess().getSubsysMappingsAssignment_5()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:643:1: ( rule__Mapping__SubsysMappingsAssignment_5 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:643:2: rule__Mapping__SubsysMappingsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__Mapping__SubsysMappingsAssignment_5_in_rule__Mapping__Group__5__Impl1254);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:653:1: rule__Mapping__Group__6 : rule__Mapping__Group__6__Impl ;
    public final void rule__Mapping__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:657:1: ( rule__Mapping__Group__6__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:658:2: rule__Mapping__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__Mapping__Group__6__Impl_in_rule__Mapping__Group__61285);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:664:1: rule__Mapping__Group__6__Impl : ( '}' ) ;
    public final void rule__Mapping__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:668:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:669:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:669:1: ( '}' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:670:1: '}'
            {
             before(grammarAccess.getMappingAccess().getRightCurlyBracketKeyword_6()); 
            match(input,14,FOLLOW_14_in_rule__Mapping__Group__6__Impl1313); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:697:1: rule__SubSystemMapping__Group__0 : rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1 ;
    public final void rule__SubSystemMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:701:1: ( rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:702:2: rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__0__Impl_in_rule__SubSystemMapping__Group__01358);
            rule__SubSystemMapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group__1_in_rule__SubSystemMapping__Group__01361);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:709:1: rule__SubSystemMapping__Group__0__Impl : ( 'SubSystemMapping' ) ;
    public final void rule__SubSystemMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:713:1: ( ( 'SubSystemMapping' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:714:1: ( 'SubSystemMapping' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:714:1: ( 'SubSystemMapping' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:715:1: 'SubSystemMapping'
            {
             before(grammarAccess.getSubSystemMappingAccess().getSubSystemMappingKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__SubSystemMapping__Group__0__Impl1389); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:728:1: rule__SubSystemMapping__Group__1 : rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2 ;
    public final void rule__SubSystemMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:732:1: ( rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:733:2: rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__1__Impl_in_rule__SubSystemMapping__Group__11420);
            rule__SubSystemMapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group__2_in_rule__SubSystemMapping__Group__11423);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:740:1: rule__SubSystemMapping__Group__1__Impl : ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) ) ;
    public final void rule__SubSystemMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:744:1: ( ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:745:1: ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:745:1: ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:746:1: ( rule__SubSystemMapping__LogicalSubSysAssignment_1 )
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:747:1: ( rule__SubSystemMapping__LogicalSubSysAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:747:2: rule__SubSystemMapping__LogicalSubSysAssignment_1
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__LogicalSubSysAssignment_1_in_rule__SubSystemMapping__Group__1__Impl1450);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:757:1: rule__SubSystemMapping__Group__2 : rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3 ;
    public final void rule__SubSystemMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:761:1: ( rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:762:2: rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__2__Impl_in_rule__SubSystemMapping__Group__21480);
            rule__SubSystemMapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group__3_in_rule__SubSystemMapping__Group__21483);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:769:1: rule__SubSystemMapping__Group__2__Impl : ( '->' ) ;
    public final void rule__SubSystemMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:773:1: ( ( '->' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:774:1: ( '->' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:774:1: ( '->' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:775:1: '->'
            {
             before(grammarAccess.getSubSystemMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,16,FOLLOW_16_in_rule__SubSystemMapping__Group__2__Impl1511); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:788:1: rule__SubSystemMapping__Group__3 : rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4 ;
    public final void rule__SubSystemMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:792:1: ( rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:793:2: rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__3__Impl_in_rule__SubSystemMapping__Group__31542);
            rule__SubSystemMapping__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group__4_in_rule__SubSystemMapping__Group__31545);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:800:1: rule__SubSystemMapping__Group__3__Impl : ( ( rule__SubSystemMapping__NodeAssignment_3 ) ) ;
    public final void rule__SubSystemMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:804:1: ( ( ( rule__SubSystemMapping__NodeAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:805:1: ( ( rule__SubSystemMapping__NodeAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:805:1: ( ( rule__SubSystemMapping__NodeAssignment_3 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:806:1: ( rule__SubSystemMapping__NodeAssignment_3 )
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeAssignment_3()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:807:1: ( rule__SubSystemMapping__NodeAssignment_3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:807:2: rule__SubSystemMapping__NodeAssignment_3
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__NodeAssignment_3_in_rule__SubSystemMapping__Group__3__Impl1572);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:817:1: rule__SubSystemMapping__Group__4 : rule__SubSystemMapping__Group__4__Impl ;
    public final void rule__SubSystemMapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:821:1: ( rule__SubSystemMapping__Group__4__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:822:2: rule__SubSystemMapping__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__4__Impl_in_rule__SubSystemMapping__Group__41602);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:828:1: rule__SubSystemMapping__Group__4__Impl : ( ( rule__SubSystemMapping__Group_4__0 )? ) ;
    public final void rule__SubSystemMapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:832:1: ( ( ( rule__SubSystemMapping__Group_4__0 )? ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:833:1: ( ( rule__SubSystemMapping__Group_4__0 )? )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:833:1: ( ( rule__SubSystemMapping__Group_4__0 )? )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:834:1: ( rule__SubSystemMapping__Group_4__0 )?
            {
             before(grammarAccess.getSubSystemMappingAccess().getGroup_4()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:835:1: ( rule__SubSystemMapping__Group_4__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:835:2: rule__SubSystemMapping__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__0_in_rule__SubSystemMapping__Group__4__Impl1629);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:855:1: rule__SubSystemMapping__Group_4__0 : rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1 ;
    public final void rule__SubSystemMapping__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:859:1: ( rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:860:2: rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__0__Impl_in_rule__SubSystemMapping__Group_4__01670);
            rule__SubSystemMapping__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__1_in_rule__SubSystemMapping__Group_4__01673);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:867:1: rule__SubSystemMapping__Group_4__0__Impl : ( '{' ) ;
    public final void rule__SubSystemMapping__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:871:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:872:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:872:1: ( '{' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:873:1: '{'
            {
             before(grammarAccess.getSubSystemMappingAccess().getLeftCurlyBracketKeyword_4_0()); 
            match(input,13,FOLLOW_13_in_rule__SubSystemMapping__Group_4__0__Impl1701); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:886:1: rule__SubSystemMapping__Group_4__1 : rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2 ;
    public final void rule__SubSystemMapping__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:890:1: ( rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:891:2: rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__1__Impl_in_rule__SubSystemMapping__Group_4__11732);
            rule__SubSystemMapping__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__2_in_rule__SubSystemMapping__Group_4__11735);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:898:1: rule__SubSystemMapping__Group_4__1__Impl : ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* ) ;
    public final void rule__SubSystemMapping__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:902:1: ( ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:903:1: ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:903:1: ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:904:1: ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )*
            {
             before(grammarAccess.getSubSystemMappingAccess().getThreadMappingsAssignment_4_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:905:1: ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:905:2: rule__SubSystemMapping__ThreadMappingsAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_rule__SubSystemMapping__ThreadMappingsAssignment_4_1_in_rule__SubSystemMapping__Group_4__1__Impl1762);
            	    rule__SubSystemMapping__ThreadMappingsAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getSubSystemMappingAccess().getThreadMappingsAssignment_4_1()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:915:1: rule__SubSystemMapping__Group_4__2 : rule__SubSystemMapping__Group_4__2__Impl ;
    public final void rule__SubSystemMapping__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:919:1: ( rule__SubSystemMapping__Group_4__2__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:920:2: rule__SubSystemMapping__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__2__Impl_in_rule__SubSystemMapping__Group_4__21793);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:926:1: rule__SubSystemMapping__Group_4__2__Impl : ( '}' ) ;
    public final void rule__SubSystemMapping__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:930:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:931:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:931:1: ( '}' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:932:1: '}'
            {
             before(grammarAccess.getSubSystemMappingAccess().getRightCurlyBracketKeyword_4_2()); 
            match(input,14,FOLLOW_14_in_rule__SubSystemMapping__Group_4__2__Impl1821); 
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


    // $ANTLR start "rule__ThreadMapping__Group__0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:951:1: rule__ThreadMapping__Group__0 : rule__ThreadMapping__Group__0__Impl rule__ThreadMapping__Group__1 ;
    public final void rule__ThreadMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:955:1: ( rule__ThreadMapping__Group__0__Impl rule__ThreadMapping__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:956:2: rule__ThreadMapping__Group__0__Impl rule__ThreadMapping__Group__1
            {
            pushFollow(FOLLOW_rule__ThreadMapping__Group__0__Impl_in_rule__ThreadMapping__Group__01858);
            rule__ThreadMapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ThreadMapping__Group__1_in_rule__ThreadMapping__Group__01861);
            rule__ThreadMapping__Group__1();

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
    // $ANTLR end "rule__ThreadMapping__Group__0"


    // $ANTLR start "rule__ThreadMapping__Group__0__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:963:1: rule__ThreadMapping__Group__0__Impl : ( 'ThreadMapping' ) ;
    public final void rule__ThreadMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:967:1: ( ( 'ThreadMapping' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:968:1: ( 'ThreadMapping' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:968:1: ( 'ThreadMapping' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:969:1: 'ThreadMapping'
            {
             before(grammarAccess.getThreadMappingAccess().getThreadMappingKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__ThreadMapping__Group__0__Impl1889); 
             after(grammarAccess.getThreadMappingAccess().getThreadMappingKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThreadMapping__Group__0__Impl"


    // $ANTLR start "rule__ThreadMapping__Group__1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:982:1: rule__ThreadMapping__Group__1 : rule__ThreadMapping__Group__1__Impl rule__ThreadMapping__Group__2 ;
    public final void rule__ThreadMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:986:1: ( rule__ThreadMapping__Group__1__Impl rule__ThreadMapping__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:987:2: rule__ThreadMapping__Group__1__Impl rule__ThreadMapping__Group__2
            {
            pushFollow(FOLLOW_rule__ThreadMapping__Group__1__Impl_in_rule__ThreadMapping__Group__11920);
            rule__ThreadMapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ThreadMapping__Group__2_in_rule__ThreadMapping__Group__11923);
            rule__ThreadMapping__Group__2();

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
    // $ANTLR end "rule__ThreadMapping__Group__1"


    // $ANTLR start "rule__ThreadMapping__Group__1__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:994:1: rule__ThreadMapping__Group__1__Impl : ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) ) ;
    public final void rule__ThreadMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:998:1: ( ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:999:1: ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:999:1: ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1000:1: ( rule__ThreadMapping__LogicalThreadAssignment_1 )
            {
             before(grammarAccess.getThreadMappingAccess().getLogicalThreadAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1001:1: ( rule__ThreadMapping__LogicalThreadAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1001:2: rule__ThreadMapping__LogicalThreadAssignment_1
            {
            pushFollow(FOLLOW_rule__ThreadMapping__LogicalThreadAssignment_1_in_rule__ThreadMapping__Group__1__Impl1950);
            rule__ThreadMapping__LogicalThreadAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getThreadMappingAccess().getLogicalThreadAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThreadMapping__Group__1__Impl"


    // $ANTLR start "rule__ThreadMapping__Group__2"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1011:1: rule__ThreadMapping__Group__2 : rule__ThreadMapping__Group__2__Impl rule__ThreadMapping__Group__3 ;
    public final void rule__ThreadMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1015:1: ( rule__ThreadMapping__Group__2__Impl rule__ThreadMapping__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1016:2: rule__ThreadMapping__Group__2__Impl rule__ThreadMapping__Group__3
            {
            pushFollow(FOLLOW_rule__ThreadMapping__Group__2__Impl_in_rule__ThreadMapping__Group__21980);
            rule__ThreadMapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ThreadMapping__Group__3_in_rule__ThreadMapping__Group__21983);
            rule__ThreadMapping__Group__3();

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
    // $ANTLR end "rule__ThreadMapping__Group__2"


    // $ANTLR start "rule__ThreadMapping__Group__2__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1023:1: rule__ThreadMapping__Group__2__Impl : ( '->' ) ;
    public final void rule__ThreadMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1027:1: ( ( '->' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1028:1: ( '->' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1028:1: ( '->' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1029:1: '->'
            {
             before(grammarAccess.getThreadMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,16,FOLLOW_16_in_rule__ThreadMapping__Group__2__Impl2011); 
             after(grammarAccess.getThreadMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThreadMapping__Group__2__Impl"


    // $ANTLR start "rule__ThreadMapping__Group__3"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1042:1: rule__ThreadMapping__Group__3 : rule__ThreadMapping__Group__3__Impl ;
    public final void rule__ThreadMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1046:1: ( rule__ThreadMapping__Group__3__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1047:2: rule__ThreadMapping__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ThreadMapping__Group__3__Impl_in_rule__ThreadMapping__Group__32042);
            rule__ThreadMapping__Group__3__Impl();

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
    // $ANTLR end "rule__ThreadMapping__Group__3"


    // $ANTLR start "rule__ThreadMapping__Group__3__Impl"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1053:1: rule__ThreadMapping__Group__3__Impl : ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) ) ;
    public final void rule__ThreadMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1057:1: ( ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1058:1: ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1058:1: ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1059:1: ( rule__ThreadMapping__PhysicalThreadAssignment_3 )
            {
             before(grammarAccess.getThreadMappingAccess().getPhysicalThreadAssignment_3()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1060:1: ( rule__ThreadMapping__PhysicalThreadAssignment_3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1060:2: rule__ThreadMapping__PhysicalThreadAssignment_3
            {
            pushFollow(FOLLOW_rule__ThreadMapping__PhysicalThreadAssignment_3_in_rule__ThreadMapping__Group__3__Impl2069);
            rule__ThreadMapping__PhysicalThreadAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getThreadMappingAccess().getPhysicalThreadAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThreadMapping__Group__3__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1078:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1082:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1083:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02107);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02110);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1090:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1094:1: ( ( 'import' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1095:1: ( 'import' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1095:1: ( 'import' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1096:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__Import__Group__0__Impl2138); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1109:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1113:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1114:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12169);
            rule__Import__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__2_in_rule__Import__Group__12172);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1121:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1125:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1126:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1126:1: ( ( rule__Import__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1127:1: ( rule__Import__Alternatives_1 )
            {
             before(grammarAccess.getImportAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1128:1: ( rule__Import__Alternatives_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1128:2: rule__Import__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl2199);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1138:1: rule__Import__Group__2 : rule__Import__Group__2__Impl ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1142:1: ( rule__Import__Group__2__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1143:2: rule__Import__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__22229);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1149:1: rule__Import__Group__2__Impl : ( ( rule__Import__ImportURIAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1153:1: ( ( ( rule__Import__ImportURIAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1154:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1154:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1155:1: ( rule__Import__ImportURIAssignment_2 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_2()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1156:1: ( rule__Import__ImportURIAssignment_2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1156:2: rule__Import__ImportURIAssignment_2
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl2256);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1172:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1176:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1177:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__02292);
            rule__Import__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__02295);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1184:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1188:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1189:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1189:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1190:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1191:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1191:2: rule__Import__ImportedNamespaceAssignment_1_0_0
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl2322);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1201:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1205:1: ( rule__Import__Group_1_0__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1206:2: rule__Import__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__12352);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1212:1: rule__Import__Group_1_0__1__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1216:1: ( ( 'from' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1217:1: ( 'from' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1217:1: ( 'from' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1218:1: 'from'
            {
             before(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 
            match(input,20,FOLLOW_20_in_rule__Import__Group_1_0__1__Impl2380); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1235:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1239:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1240:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__02415);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__02418);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1247:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1251:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1252:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1252:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1253:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl2445);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1264:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1268:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1269:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__12474);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1275:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1279:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1280:1: ( ( '.*' )? )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1280:1: ( ( '.*' )? )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1281:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1282:1: ( '.*' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1283:2: '.*'
                    {
                    match(input,21,FOLLOW_21_in_rule__ImportedFQN__Group__1__Impl2503); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1298:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1302:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1303:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__02540);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__02543);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1310:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1314:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1315:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1315:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1316:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl2570); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1327:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1331:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1332:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__12599);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1338:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1342:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1343:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1343:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1344:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1345:1: ( rule__FQN__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1345:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl2626);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1359:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1363:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1364:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__02661);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__02664);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1371:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1375:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1376:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1376:1: ( '.' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1377:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,22,FOLLOW_22_in_rule__FQN__Group_1__0__Impl2692); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1390:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1394:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1395:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__12723);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1401:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1405:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1406:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1406:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1407:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl2750); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1423:1: rule__MappingModel__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__MappingModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1427:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1428:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1428:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1429:1: ruleFQN
            {
             before(grammarAccess.getMappingModelAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__MappingModel__NameAssignment_12788);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1438:1: rule__MappingModel__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__MappingModel__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1442:1: ( ( ruleImport ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1443:1: ( ruleImport )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1443:1: ( ruleImport )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1444:1: ruleImport
            {
             before(grammarAccess.getMappingModelAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__MappingModel__ImportsAssignment_32819);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1453:1: rule__MappingModel__MappingsAssignment_4 : ( ruleMapping ) ;
    public final void rule__MappingModel__MappingsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1457:1: ( ( ruleMapping ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1458:1: ( ruleMapping )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1458:1: ( ruleMapping )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1459:1: ruleMapping
            {
             before(grammarAccess.getMappingModelAccess().getMappingsMappingParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleMapping_in_rule__MappingModel__MappingsAssignment_42850);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1468:1: rule__Mapping__LogicalSysAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__Mapping__LogicalSysAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1472:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1473:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1473:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1474:1: ( ruleFQN )
            {
             before(grammarAccess.getMappingAccess().getLogicalSysLogicalSystemCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1475:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1476:1: ruleFQN
            {
             before(grammarAccess.getMappingAccess().getLogicalSysLogicalSystemFQNParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__Mapping__LogicalSysAssignment_12885);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1487:1: rule__Mapping__PhysicalSysAssignment_3 : ( ( ruleFQN ) ) ;
    public final void rule__Mapping__PhysicalSysAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1491:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1492:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1492:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1493:1: ( ruleFQN )
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysPhysicalSystemCrossReference_3_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1494:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1495:1: ruleFQN
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysPhysicalSystemFQNParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__Mapping__PhysicalSysAssignment_32924);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1506:1: rule__Mapping__SubsysMappingsAssignment_5 : ( ruleSubSystemMapping ) ;
    public final void rule__Mapping__SubsysMappingsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1510:1: ( ( ruleSubSystemMapping ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1511:1: ( ruleSubSystemMapping )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1511:1: ( ruleSubSystemMapping )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1512:1: ruleSubSystemMapping
            {
             before(grammarAccess.getMappingAccess().getSubsysMappingsSubSystemMappingParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSubSystemMapping_in_rule__Mapping__SubsysMappingsAssignment_52959);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1521:1: rule__SubSystemMapping__LogicalSubSysAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemMapping__LogicalSubSysAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1525:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1526:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1526:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1527:1: ( RULE_ID )
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1528:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1529:1: RULE_ID
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubSystemMapping__LogicalSubSysAssignment_12994); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1540:1: rule__SubSystemMapping__NodeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemMapping__NodeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1544:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1545:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1545:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1546:1: ( RULE_ID )
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeNodeRefCrossReference_3_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1547:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1548:1: RULE_ID
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeNodeRefIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubSystemMapping__NodeAssignment_33033); 
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


    // $ANTLR start "rule__SubSystemMapping__ThreadMappingsAssignment_4_1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1559:1: rule__SubSystemMapping__ThreadMappingsAssignment_4_1 : ( ruleThreadMapping ) ;
    public final void rule__SubSystemMapping__ThreadMappingsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1563:1: ( ( ruleThreadMapping ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1564:1: ( ruleThreadMapping )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1564:1: ( ruleThreadMapping )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1565:1: ruleThreadMapping
            {
             before(grammarAccess.getSubSystemMappingAccess().getThreadMappingsThreadMappingParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleThreadMapping_in_rule__SubSystemMapping__ThreadMappingsAssignment_4_13068);
            ruleThreadMapping();

            state._fsp--;

             after(grammarAccess.getSubSystemMappingAccess().getThreadMappingsThreadMappingParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubSystemMapping__ThreadMappingsAssignment_4_1"


    // $ANTLR start "rule__ThreadMapping__LogicalThreadAssignment_1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1574:1: rule__ThreadMapping__LogicalThreadAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ThreadMapping__LogicalThreadAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1578:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1579:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1579:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1580:1: ( RULE_ID )
            {
             before(grammarAccess.getThreadMappingAccess().getLogicalThreadLogicalThreadCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1581:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1582:1: RULE_ID
            {
             before(grammarAccess.getThreadMappingAccess().getLogicalThreadLogicalThreadIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ThreadMapping__LogicalThreadAssignment_13103); 
             after(grammarAccess.getThreadMappingAccess().getLogicalThreadLogicalThreadIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getThreadMappingAccess().getLogicalThreadLogicalThreadCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThreadMapping__LogicalThreadAssignment_1"


    // $ANTLR start "rule__ThreadMapping__PhysicalThreadAssignment_3"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1593:1: rule__ThreadMapping__PhysicalThreadAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__ThreadMapping__PhysicalThreadAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1597:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1598:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1598:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1599:1: ( RULE_ID )
            {
             before(grammarAccess.getThreadMappingAccess().getPhysicalThreadPhysThreadCrossReference_3_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1600:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1601:1: RULE_ID
            {
             before(grammarAccess.getThreadMappingAccess().getPhysicalThreadPhysThreadIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ThreadMapping__PhysicalThreadAssignment_33142); 
             after(grammarAccess.getThreadMappingAccess().getPhysicalThreadPhysThreadIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getThreadMappingAccess().getPhysicalThreadPhysThreadCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThreadMapping__PhysicalThreadAssignment_3"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1_0_0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1612:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1616:1: ( ( ruleImportedFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1617:1: ( ruleImportedFQN )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1617:1: ( ruleImportedFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1618:1: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_03177);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1627:1: rule__Import__ImportURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1631:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1632:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1632:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1633:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_23208); 
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
    public static final BitSet FOLLOW_ruleThreadMapping_in_entryRuleThreadMapping241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThreadMapping248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__0_in_ruleThreadMapping274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_1490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Import__Alternatives_1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__0__Impl_in_rule__MappingModel__Group__0541 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__1_in_rule__MappingModel__Group__0544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__MappingModel__Group__0__Impl572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__1__Impl_in_rule__MappingModel__Group__1603 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__2_in_rule__MappingModel__Group__1606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__NameAssignment_1_in_rule__MappingModel__Group__1__Impl633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__2__Impl_in_rule__MappingModel__Group__2663 = new BitSet(new long[]{0x000000000008C000L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__3_in_rule__MappingModel__Group__2666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__MappingModel__Group__2__Impl694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__3__Impl_in_rule__MappingModel__Group__3725 = new BitSet(new long[]{0x000000000008C000L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__4_in_rule__MappingModel__Group__3728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__ImportsAssignment_3_in_rule__MappingModel__Group__3__Impl755 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__4__Impl_in_rule__MappingModel__Group__4786 = new BitSet(new long[]{0x000000000008C000L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__5_in_rule__MappingModel__Group__4789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__MappingsAssignment_4_in_rule__MappingModel__Group__4__Impl816 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__5__Impl_in_rule__MappingModel__Group__5847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__MappingModel__Group__5__Impl875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__0__Impl_in_rule__Mapping__Group__0918 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Mapping__Group__1_in_rule__Mapping__Group__0921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Mapping__Group__0__Impl949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__1__Impl_in_rule__Mapping__Group__1980 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Mapping__Group__2_in_rule__Mapping__Group__1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__LogicalSysAssignment_1_in_rule__Mapping__Group__1__Impl1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__2__Impl_in_rule__Mapping__Group__21040 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Mapping__Group__3_in_rule__Mapping__Group__21043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Mapping__Group__2__Impl1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__3__Impl_in_rule__Mapping__Group__31102 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Mapping__Group__4_in_rule__Mapping__Group__31105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__PhysicalSysAssignment_3_in_rule__Mapping__Group__3__Impl1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__4__Impl_in_rule__Mapping__Group__41162 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_rule__Mapping__Group__5_in_rule__Mapping__Group__41165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Mapping__Group__4__Impl1193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__5__Impl_in_rule__Mapping__Group__51224 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_rule__Mapping__Group__6_in_rule__Mapping__Group__51227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__SubsysMappingsAssignment_5_in_rule__Mapping__Group__5__Impl1254 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__6__Impl_in_rule__Mapping__Group__61285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Mapping__Group__6__Impl1313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__0__Impl_in_rule__SubSystemMapping__Group__01358 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__1_in_rule__SubSystemMapping__Group__01361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__SubSystemMapping__Group__0__Impl1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__1__Impl_in_rule__SubSystemMapping__Group__11420 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__2_in_rule__SubSystemMapping__Group__11423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__LogicalSubSysAssignment_1_in_rule__SubSystemMapping__Group__1__Impl1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__2__Impl_in_rule__SubSystemMapping__Group__21480 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__3_in_rule__SubSystemMapping__Group__21483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__SubSystemMapping__Group__2__Impl1511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__3__Impl_in_rule__SubSystemMapping__Group__31542 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__4_in_rule__SubSystemMapping__Group__31545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__NodeAssignment_3_in_rule__SubSystemMapping__Group__3__Impl1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__4__Impl_in_rule__SubSystemMapping__Group__41602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__0_in_rule__SubSystemMapping__Group__4__Impl1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__0__Impl_in_rule__SubSystemMapping__Group_4__01670 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__1_in_rule__SubSystemMapping__Group_4__01673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__SubSystemMapping__Group_4__0__Impl1701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__1__Impl_in_rule__SubSystemMapping__Group_4__11732 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__2_in_rule__SubSystemMapping__Group_4__11735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__ThreadMappingsAssignment_4_1_in_rule__SubSystemMapping__Group_4__1__Impl1762 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__2__Impl_in_rule__SubSystemMapping__Group_4__21793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__SubSystemMapping__Group_4__2__Impl1821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__0__Impl_in_rule__ThreadMapping__Group__01858 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__1_in_rule__ThreadMapping__Group__01861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ThreadMapping__Group__0__Impl1889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__1__Impl_in_rule__ThreadMapping__Group__11920 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__2_in_rule__ThreadMapping__Group__11923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadMapping__LogicalThreadAssignment_1_in_rule__ThreadMapping__Group__1__Impl1950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__2__Impl_in_rule__ThreadMapping__Group__21980 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__3_in_rule__ThreadMapping__Group__21983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ThreadMapping__Group__2__Impl2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__3__Impl_in_rule__ThreadMapping__Group__32042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadMapping__PhysicalThreadAssignment_3_in_rule__ThreadMapping__Group__3__Impl2069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02107 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Import__Group__0__Impl2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12169 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Import__Group__2_in_rule__Import__Group__12172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl2199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__22229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__02292 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__02295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__12352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Import__Group_1_0__1__Impl2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__02415 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__02418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl2445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__12474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ImportedFQN__Group__1__Impl2503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__02540 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__02543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl2570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__12599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl2626 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__02661 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__02664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__FQN__Group_1__0__Impl2692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__12723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__MappingModel__NameAssignment_12788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__MappingModel__ImportsAssignment_32819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_rule__MappingModel__MappingsAssignment_42850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Mapping__LogicalSysAssignment_12885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Mapping__PhysicalSysAssignment_32924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemMapping_in_rule__Mapping__SubsysMappingsAssignment_52959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubSystemMapping__LogicalSubSysAssignment_12994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubSystemMapping__NodeAssignment_33033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThreadMapping_in_rule__SubSystemMapping__ThreadMappingsAssignment_4_13068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ThreadMapping__LogicalThreadAssignment_13103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ThreadMapping__PhysicalThreadAssignment_33142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_03177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_23208 = new BitSet(new long[]{0x0000000000000002L});

}