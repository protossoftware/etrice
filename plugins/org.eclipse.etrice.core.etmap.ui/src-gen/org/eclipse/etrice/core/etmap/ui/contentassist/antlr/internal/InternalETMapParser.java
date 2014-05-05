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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_HEX", "RULE_INT", "RULE_EXP", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'mandatory'", "'model'", "'false'", "'+'", "'-'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'", "'MappingModel'", "'{'", "'}'", "'Mapping'", "'->'", "'SubSystemMapping'", "'ThreadMapping'", "'='", "'attribute'", "':'", "','", "'import'", "'from'", "'.*'", "'['", "']'", "'.'", "'optional'", "'true'"
    };
    public static final int RULE_EXP=7;
    public static final int RULE_ID=4;
    public static final int T__40=40;
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
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=11;

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


    // $ANTLR start "entryRuleKeyValue"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:174:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:175:1: ( ruleKeyValue EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:176:1: ruleKeyValue EOF
            {
             before(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_ruleKeyValue_in_entryRuleKeyValue303);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getKeyValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValue310); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:183:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:187:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:188:1: ( ( rule__KeyValue__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:188:1: ( ( rule__KeyValue__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:189:1: ( rule__KeyValue__Group__0 )
            {
             before(grammarAccess.getKeyValueAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:190:1: ( rule__KeyValue__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:190:2: rule__KeyValue__Group__0
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__0_in_ruleKeyValue336);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:204:1: entryRuleAnnotationTargetType : ruleAnnotationTargetType EOF ;
    public final void entryRuleAnnotationTargetType() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:205:1: ( ruleAnnotationTargetType EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:206:1: ruleAnnotationTargetType EOF
            {
             before(grammarAccess.getAnnotationTargetTypeRule()); 
            pushFollow(FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType365);
            ruleAnnotationTargetType();

            state._fsp--;

             after(grammarAccess.getAnnotationTargetTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationTargetType372); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:213:1: ruleAnnotationTargetType : ( RULE_ID ) ;
    public final void ruleAnnotationTargetType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:217:2: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:218:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:218:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:219:1: RULE_ID
            {
             before(grammarAccess.getAnnotationTargetTypeAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotationTargetType398); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:232:1: entryRuleAnnotationAttribute : ruleAnnotationAttribute EOF ;
    public final void entryRuleAnnotationAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:233:1: ( ruleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:234:1: ruleAnnotationAttribute EOF
            {
             before(grammarAccess.getAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute424);
            ruleAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationAttribute431); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:241:1: ruleAnnotationAttribute : ( ( rule__AnnotationAttribute__Alternatives ) ) ;
    public final void ruleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:245:2: ( ( ( rule__AnnotationAttribute__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:246:1: ( ( rule__AnnotationAttribute__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:246:1: ( ( rule__AnnotationAttribute__Alternatives ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:247:1: ( rule__AnnotationAttribute__Alternatives )
            {
             before(grammarAccess.getAnnotationAttributeAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:248:1: ( rule__AnnotationAttribute__Alternatives )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:248:2: rule__AnnotationAttribute__Alternatives
            {
            pushFollow(FOLLOW_rule__AnnotationAttribute__Alternatives_in_ruleAnnotationAttribute457);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:260:1: entryRuleSimpleAnnotationAttribute : ruleSimpleAnnotationAttribute EOF ;
    public final void entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:261:1: ( ruleSimpleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:262:1: ruleSimpleAnnotationAttribute EOF
            {
             before(grammarAccess.getSimpleAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute484);
            ruleSimpleAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getSimpleAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute491); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:269:1: ruleSimpleAnnotationAttribute : ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) ;
    public final void ruleSimpleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:273:2: ( ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:274:1: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:274:1: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:275:1: ( rule__SimpleAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:276:1: ( rule__SimpleAnnotationAttribute__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:276:2: rule__SimpleAnnotationAttribute__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__0_in_ruleSimpleAnnotationAttribute517);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:288:1: entryRuleEnumAnnotationAttribute : ruleEnumAnnotationAttribute EOF ;
    public final void entryRuleEnumAnnotationAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:289:1: ( ruleEnumAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:290:1: ruleEnumAnnotationAttribute EOF
            {
             before(grammarAccess.getEnumAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute544);
            ruleEnumAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getEnumAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute551); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:297:1: ruleEnumAnnotationAttribute : ( ( rule__EnumAnnotationAttribute__Group__0 ) ) ;
    public final void ruleEnumAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:301:2: ( ( ( rule__EnumAnnotationAttribute__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:302:1: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:302:1: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:303:1: ( rule__EnumAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:304:1: ( rule__EnumAnnotationAttribute__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:304:2: rule__EnumAnnotationAttribute__Group__0
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__0_in_ruleEnumAnnotationAttribute577);
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


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:316:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:317:1: ( ruleImport EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:318:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport604);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport611); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:325:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:329:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:330:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:330:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:331:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:332:1: ( rule__Import__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:332:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport637);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:344:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:345:1: ( ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:346:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN664);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN671); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:353:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:357:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:358:1: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:358:1: ( ( rule__ImportedFQN__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:359:1: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:360:1: ( rule__ImportedFQN__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:360:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN697);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:372:1: entryRuleDocumentation : ruleDocumentation EOF ;
    public final void entryRuleDocumentation() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:373:1: ( ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:374:1: ruleDocumentation EOF
            {
             before(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation724);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getDocumentationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation731); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:381:1: ruleDocumentation : ( ( rule__Documentation__Group__0 ) ) ;
    public final void ruleDocumentation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:385:2: ( ( ( rule__Documentation__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:386:1: ( ( rule__Documentation__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:386:1: ( ( rule__Documentation__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:387:1: ( rule__Documentation__Group__0 )
            {
             before(grammarAccess.getDocumentationAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:388:1: ( rule__Documentation__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:388:2: rule__Documentation__Group__0
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0_in_ruleDocumentation757);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:404:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:405:1: ( ruleLiteral EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:406:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral788);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral795); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:413:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:417:2: ( ( ( rule__Literal__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:418:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:418:1: ( ( rule__Literal__Alternatives ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:419:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:420:1: ( rule__Literal__Alternatives )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:420:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral821);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:432:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:433:1: ( ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:434:1: ruleBooleanLiteral EOF
            {
             before(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral848);
            ruleBooleanLiteral();

            state._fsp--;

             after(grammarAccess.getBooleanLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral855); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:441:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:445:2: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:446:1: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:446:1: ( ( rule__BooleanLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:447:1: ( rule__BooleanLiteral__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:448:1: ( rule__BooleanLiteral__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:448:2: rule__BooleanLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral881);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:460:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:461:1: ( ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:462:1: ruleNumberLiteral EOF
            {
             before(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral908);
            ruleNumberLiteral();

            state._fsp--;

             after(grammarAccess.getNumberLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral915); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:469:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Alternatives ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:473:2: ( ( ( rule__NumberLiteral__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:474:1: ( ( rule__NumberLiteral__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:474:1: ( ( rule__NumberLiteral__Alternatives ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:475:1: ( rule__NumberLiteral__Alternatives )
            {
             before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:476:1: ( rule__NumberLiteral__Alternatives )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:476:2: rule__NumberLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral941);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:488:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:489:1: ( ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:490:1: ruleRealLiteral EOF
            {
             before(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral968);
            ruleRealLiteral();

            state._fsp--;

             after(grammarAccess.getRealLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral975); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:497:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:501:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:502:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:502:1: ( ( rule__RealLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:503:1: ( rule__RealLiteral__Group__0 )
            {
             before(grammarAccess.getRealLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:504:1: ( rule__RealLiteral__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:504:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral1001);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:516:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:517:1: ( ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:518:1: ruleIntLiteral EOF
            {
             before(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral1028);
            ruleIntLiteral();

            state._fsp--;

             after(grammarAccess.getIntLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral1035); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:525:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:529:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:530:1: ( ( rule__IntLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:530:1: ( ( rule__IntLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:531:1: ( rule__IntLiteral__Group__0 )
            {
             before(grammarAccess.getIntLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:532:1: ( rule__IntLiteral__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:532:2: rule__IntLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral1061);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:544:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:545:1: ( ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:546:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1088);
            ruleStringLiteral();

            state._fsp--;

             after(grammarAccess.getStringLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral1095); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:553:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:557:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:558:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:558:1: ( ( rule__StringLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:559:1: ( rule__StringLiteral__Group__0 )
            {
             before(grammarAccess.getStringLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:560:1: ( rule__StringLiteral__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:560:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral1121);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:572:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:573:1: ( ruleInteger EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:574:1: ruleInteger EOF
            {
             before(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger1148);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger1155); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:581:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:585:2: ( ( ( rule__Integer__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:586:1: ( ( rule__Integer__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:586:1: ( ( rule__Integer__Alternatives ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:587:1: ( rule__Integer__Alternatives )
            {
             before(grammarAccess.getIntegerAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:588:1: ( rule__Integer__Alternatives )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:588:2: rule__Integer__Alternatives
            {
            pushFollow(FOLLOW_rule__Integer__Alternatives_in_ruleInteger1181);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:600:1: entryRuleSignedInteger : ruleSignedInteger EOF ;
    public final void entryRuleSignedInteger() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:604:1: ( ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:605:1: ruleSignedInteger EOF
            {
             before(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger1213);
            ruleSignedInteger();

            state._fsp--;

             after(grammarAccess.getSignedIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger1220); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:615:1: ruleSignedInteger : ( ( rule__SignedInteger__Group__0 ) ) ;
    public final void ruleSignedInteger() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:620:2: ( ( ( rule__SignedInteger__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:621:1: ( ( rule__SignedInteger__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:621:1: ( ( rule__SignedInteger__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:622:1: ( rule__SignedInteger__Group__0 )
            {
             before(grammarAccess.getSignedIntegerAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:623:1: ( rule__SignedInteger__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:623:2: rule__SignedInteger__Group__0
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger1250);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:636:1: entryRuleHexadecimal : ruleHexadecimal EOF ;
    public final void entryRuleHexadecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:640:1: ( ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:641:1: ruleHexadecimal EOF
            {
             before(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal1282);
            ruleHexadecimal();

            state._fsp--;

             after(grammarAccess.getHexadecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal1289); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:651:1: ruleHexadecimal : ( RULE_HEX ) ;
    public final void ruleHexadecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:656:2: ( ( RULE_HEX ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:657:1: ( RULE_HEX )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:657:1: ( RULE_HEX )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:658:1: RULE_HEX
            {
             before(grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 
            match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal1319); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:672:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:673:1: ( ruleReal EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:674:1: ruleReal EOF
            {
             before(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal1345);
            ruleReal();

            state._fsp--;

             after(grammarAccess.getRealRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal1352); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:681:1: ruleReal : ( ( rule__Real__Alternatives ) ) ;
    public final void ruleReal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:685:2: ( ( ( rule__Real__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:686:1: ( ( rule__Real__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:686:1: ( ( rule__Real__Alternatives ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:687:1: ( rule__Real__Alternatives )
            {
             before(grammarAccess.getRealAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:688:1: ( rule__Real__Alternatives )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:688:2: rule__Real__Alternatives
            {
            pushFollow(FOLLOW_rule__Real__Alternatives_in_ruleReal1378);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:700:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:704:1: ( ruleDecimal EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:705:1: ruleDecimal EOF
            {
             before(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal1410);
            ruleDecimal();

            state._fsp--;

             after(grammarAccess.getDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal1417); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:715:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:720:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:721:1: ( ( rule__Decimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:721:1: ( ( rule__Decimal__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:722:1: ( rule__Decimal__Group__0 )
            {
             before(grammarAccess.getDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:723:1: ( rule__Decimal__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:723:2: rule__Decimal__Group__0
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1447);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:736:1: entryRuleDotDecimal : ruleDotDecimal EOF ;
    public final void entryRuleDotDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:740:1: ( ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:741:1: ruleDotDecimal EOF
            {
             before(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1479);
            ruleDotDecimal();

            state._fsp--;

             after(grammarAccess.getDotDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal1486); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:751:1: ruleDotDecimal : ( ( rule__DotDecimal__Group__0 ) ) ;
    public final void ruleDotDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:756:2: ( ( ( rule__DotDecimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:757:1: ( ( rule__DotDecimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:757:1: ( ( rule__DotDecimal__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:758:1: ( rule__DotDecimal__Group__0 )
            {
             before(grammarAccess.getDotDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:759:1: ( rule__DotDecimal__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:759:2: rule__DotDecimal__Group__0
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1516);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:772:1: entryRuleDecimalDot : ruleDecimalDot EOF ;
    public final void entryRuleDecimalDot() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:776:1: ( ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:777:1: ruleDecimalDot EOF
            {
             before(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1548);
            ruleDecimalDot();

            state._fsp--;

             after(grammarAccess.getDecimalDotRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot1555); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:787:1: ruleDecimalDot : ( ( rule__DecimalDot__Group__0 ) ) ;
    public final void ruleDecimalDot() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:792:2: ( ( ( rule__DecimalDot__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:793:1: ( ( rule__DecimalDot__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:793:1: ( ( rule__DecimalDot__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:794:1: ( rule__DecimalDot__Group__0 )
            {
             before(grammarAccess.getDecimalDotAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:795:1: ( rule__DecimalDot__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:795:2: rule__DecimalDot__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1585);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:808:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:812:1: ( ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:813:1: ruleDecimalExp EOF
            {
             before(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1617);
            ruleDecimalExp();

            state._fsp--;

             after(grammarAccess.getDecimalExpRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp1624); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:823:1: ruleDecimalExp : ( ( rule__DecimalExp__Group__0 ) ) ;
    public final void ruleDecimalExp() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:828:2: ( ( ( rule__DecimalExp__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:829:1: ( ( rule__DecimalExp__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:829:1: ( ( rule__DecimalExp__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:830:1: ( rule__DecimalExp__Group__0 )
            {
             before(grammarAccess.getDecimalExpAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:831:1: ( rule__DecimalExp__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:831:2: rule__DecimalExp__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1654);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:844:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:845:1: ( ruleFQN EOF )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:846:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1681);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1688); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:853:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:857:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:858:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:858:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:859:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:860:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:860:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN1714);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:873:1: ruleLiteralType : ( ( rule__LiteralType__Alternatives ) ) ;
    public final void ruleLiteralType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:877:1: ( ( ( rule__LiteralType__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:878:1: ( ( rule__LiteralType__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:878:1: ( ( rule__LiteralType__Alternatives ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:879:1: ( rule__LiteralType__Alternatives )
            {
             before(grammarAccess.getLiteralTypeAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:880:1: ( rule__LiteralType__Alternatives )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:880:2: rule__LiteralType__Alternatives
            {
            pushFollow(FOLLOW_rule__LiteralType__Alternatives_in_ruleLiteralType1751);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:892:1: rule__AnnotationAttribute__Alternatives : ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) );
    public final void rule__AnnotationAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:896:1: ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==39) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==30) ) {
                    int LA1_3 = input.LA(3);

                    if ( (LA1_3==RULE_ID) ) {
                        int LA1_4 = input.LA(4);

                        if ( (LA1_4==31) ) {
                            int LA1_5 = input.LA(5);

                            if ( (LA1_5==23) ) {
                                alt1=2;
                            }
                            else if ( ((LA1_5>=18 && LA1_5<=21)) ) {
                                alt1=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 1, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 1, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==13) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==30) ) {
                    int LA1_3 = input.LA(3);

                    if ( (LA1_3==RULE_ID) ) {
                        int LA1_4 = input.LA(4);

                        if ( (LA1_4==31) ) {
                            int LA1_5 = input.LA(5);

                            if ( (LA1_5==23) ) {
                                alt1=2;
                            }
                            else if ( ((LA1_5>=18 && LA1_5<=21)) ) {
                                alt1=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 1, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 1, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

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
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:897:1: ( ruleSimpleAnnotationAttribute )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:897:1: ( ruleSimpleAnnotationAttribute )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:898:1: ruleSimpleAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1787);
                    ruleSimpleAnnotationAttribute();

                    state._fsp--;

                     after(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:903:6: ( ruleEnumAnnotationAttribute )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:903:6: ( ruleEnumAnnotationAttribute )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:904:1: ruleEnumAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1804);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:914:1: rule__SimpleAnnotationAttribute__Alternatives_0 : ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__SimpleAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:918:1: ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==39) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:919:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:919:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:920:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:921:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:921:2: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__OptionalAssignment_0_0_in_rule__SimpleAnnotationAttribute__Alternatives_01836);
                    rule__SimpleAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:925:6: ( 'mandatory' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:925:6: ( 'mandatory' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:926:1: 'mandatory'
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__SimpleAnnotationAttribute__Alternatives_01855); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:938:1: rule__EnumAnnotationAttribute__Alternatives_0 : ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__EnumAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:942:1: ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==39) ) {
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
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:943:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:943:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:944:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:945:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:945:2: rule__EnumAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__EnumAnnotationAttribute__OptionalAssignment_0_0_in_rule__EnumAnnotationAttribute__Alternatives_01889);
                    rule__EnumAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:949:6: ( 'mandatory' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:949:6: ( 'mandatory' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:950:1: 'mandatory'
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__EnumAnnotationAttribute__Alternatives_01908); 
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


    // $ANTLR start "rule__Import__Alternatives_1"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:962:1: rule__Import__Alternatives_1 : ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) );
    public final void rule__Import__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:966:1: ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) )
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
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:967:1: ( ( rule__Import__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:967:1: ( ( rule__Import__Group_1_0__0 ) )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:968:1: ( rule__Import__Group_1_0__0 )
                    {
                     before(grammarAccess.getImportAccess().getGroup_1_0()); 
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:969:1: ( rule__Import__Group_1_0__0 )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:969:2: rule__Import__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_11942);
                    rule__Import__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getImportAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:973:6: ( 'model' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:973:6: ( 'model' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:974:1: 'model'
                    {
                     before(grammarAccess.getImportAccess().getModelKeyword_1_1()); 
                    match(input,14,FOLLOW_14_in_rule__Import__Alternatives_11961); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:987:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:991:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 15:
            case 40:
                {
                alt5=1;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case 16:
            case 17:
            case 38:
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
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:992:1: ( ruleBooleanLiteral )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:992:1: ( ruleBooleanLiteral )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:993:1: ruleBooleanLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives1996);
                    ruleBooleanLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:998:6: ( ruleNumberLiteral )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:998:6: ( ruleNumberLiteral )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:999:1: ruleNumberLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives2013);
                    ruleNumberLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1004:6: ( ruleStringLiteral )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1004:6: ( ruleStringLiteral )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1005:1: ruleStringLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives2030);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1015:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1019:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            else if ( (LA6_0==40) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1020:1: ( 'false' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1020:1: ( 'false' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1021:1: 'false'
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    match(input,15,FOLLOW_15_in_rule__BooleanLiteral__Alternatives_12063); 
                     after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1028:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1028:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1029:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1030:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1030:2: rule__BooleanLiteral__IsTrueAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_12082);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1039:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1043:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
            int alt7=2;
            switch ( input.LA(1) ) {
            case 16:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_INT) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==EOF) ) {
                        alt7=1;
                    }
                    else if ( (LA7_3==38) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA7_1==38) ) {
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

                if ( (LA7_2==RULE_INT) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==EOF) ) {
                        alt7=1;
                    }
                    else if ( (LA7_3==38) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA7_2==38) ) {
                    alt7=2;
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

                if ( (LA7_3==EOF) ) {
                    alt7=1;
                }
                else if ( (LA7_3==38) ) {
                    alt7=2;
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
            case 38:
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
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1044:1: ( ruleIntLiteral )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1044:1: ( ruleIntLiteral )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1045:1: ruleIntLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives2115);
                    ruleIntLiteral();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1050:6: ( ruleRealLiteral )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1050:6: ( ruleRealLiteral )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1051:1: ruleRealLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives2132);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1061:1: rule__Integer__Alternatives : ( ( ruleSignedInteger ) | ( ruleHexadecimal ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1065:1: ( ( ruleSignedInteger ) | ( ruleHexadecimal ) )
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
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1066:1: ( ruleSignedInteger )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1066:1: ( ruleSignedInteger )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1067:1: ruleSignedInteger
                    {
                     before(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives2164);
                    ruleSignedInteger();

                    state._fsp--;

                     after(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1072:6: ( ruleHexadecimal )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1072:6: ( ruleHexadecimal )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1073:1: ruleHexadecimal
                    {
                     before(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives2181);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1083:1: rule__SignedInteger__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__SignedInteger__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1087:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1088:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1088:1: ( '+' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1089:1: '+'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__SignedInteger__Alternatives_02214); 
                     after(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1096:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1096:6: ( '-' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1097:1: '-'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__SignedInteger__Alternatives_02234); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1109:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1113:1: ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) )
            int alt10=4;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1114:1: ( ruleDecimal )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1114:1: ( ruleDecimal )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1115:1: ruleDecimal
                    {
                     before(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDecimal_in_rule__Real__Alternatives2268);
                    ruleDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1120:6: ( ruleDotDecimal )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1120:6: ( ruleDotDecimal )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1121:1: ruleDotDecimal
                    {
                     before(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives2285);
                    ruleDotDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1126:6: ( ruleDecimalDot )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1126:6: ( ruleDecimalDot )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1127:1: ruleDecimalDot
                    {
                     before(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives2302);
                    ruleDecimalDot();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1132:6: ( ruleDecimalExp )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1132:6: ( ruleDecimalExp )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1133:1: ruleDecimalExp
                    {
                     before(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives2319);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1143:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1147:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1148:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1148:1: ( '+' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1149:1: '+'
                    {
                     before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__Decimal__Alternatives_02352); 
                     after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1156:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1156:6: ( '-' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1157:1: '-'
                    {
                     before(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__Decimal__Alternatives_02372); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1169:1: rule__DotDecimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DotDecimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1173:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1174:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1174:1: ( '+' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1175:1: '+'
                    {
                     before(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__DotDecimal__Alternatives_02407); 
                     after(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1182:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1182:6: ( '-' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1183:1: '-'
                    {
                     before(grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__DotDecimal__Alternatives_02427); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1195:1: rule__DecimalDot__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalDot__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1199:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1200:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1200:1: ( '+' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1201:1: '+'
                    {
                     before(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__DecimalDot__Alternatives_02462); 
                     after(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1208:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1208:6: ( '-' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1209:1: '-'
                    {
                     before(grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__DecimalDot__Alternatives_02482); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1221:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1225:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1226:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1226:1: ( '+' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1227:1: '+'
                    {
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__DecimalExp__Alternatives_02517); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1234:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1234:6: ( '-' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1235:1: '-'
                    {
                     before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__DecimalExp__Alternatives_02537); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1247:1: rule__LiteralType__Alternatives : ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) );
    public final void rule__LiteralType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1251:1: ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt15=1;
                }
                break;
            case 19:
                {
                alt15=2;
                }
                break;
            case 20:
                {
                alt15=3;
                }
                break;
            case 21:
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
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1252:1: ( ( 'ptBoolean' ) )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1252:1: ( ( 'ptBoolean' ) )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1253:1: ( 'ptBoolean' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1254:1: ( 'ptBoolean' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1254:3: 'ptBoolean'
                    {
                    match(input,18,FOLLOW_18_in_rule__LiteralType__Alternatives2572); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1259:6: ( ( 'ptInteger' ) )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1259:6: ( ( 'ptInteger' ) )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1260:1: ( 'ptInteger' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1261:1: ( 'ptInteger' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1261:3: 'ptInteger'
                    {
                    match(input,19,FOLLOW_19_in_rule__LiteralType__Alternatives2593); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1266:6: ( ( 'ptReal' ) )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1266:6: ( ( 'ptReal' ) )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1267:1: ( 'ptReal' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1268:1: ( 'ptReal' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1268:3: 'ptReal'
                    {
                    match(input,20,FOLLOW_20_in_rule__LiteralType__Alternatives2614); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1273:6: ( ( 'ptCharacter' ) )
                    {
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1273:6: ( ( 'ptCharacter' ) )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1274:1: ( 'ptCharacter' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1275:1: ( 'ptCharacter' )
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1275:3: 'ptCharacter'
                    {
                    match(input,21,FOLLOW_21_in_rule__LiteralType__Alternatives2635); 

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


    // $ANTLR start "rule__MappingModel__Group__0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1287:1: rule__MappingModel__Group__0 : rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1 ;
    public final void rule__MappingModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1291:1: ( rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1292:2: rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__0__Impl_in_rule__MappingModel__Group__02668);
            rule__MappingModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__1_in_rule__MappingModel__Group__02671);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1299:1: rule__MappingModel__Group__0__Impl : ( 'MappingModel' ) ;
    public final void rule__MappingModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1303:1: ( ( 'MappingModel' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1304:1: ( 'MappingModel' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1304:1: ( 'MappingModel' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1305:1: 'MappingModel'
            {
             before(grammarAccess.getMappingModelAccess().getMappingModelKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__MappingModel__Group__0__Impl2699); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1318:1: rule__MappingModel__Group__1 : rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2 ;
    public final void rule__MappingModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1322:1: ( rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1323:2: rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__1__Impl_in_rule__MappingModel__Group__12730);
            rule__MappingModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__2_in_rule__MappingModel__Group__12733);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1330:1: rule__MappingModel__Group__1__Impl : ( ( rule__MappingModel__NameAssignment_1 ) ) ;
    public final void rule__MappingModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1334:1: ( ( ( rule__MappingModel__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1335:1: ( ( rule__MappingModel__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1335:1: ( ( rule__MappingModel__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1336:1: ( rule__MappingModel__NameAssignment_1 )
            {
             before(grammarAccess.getMappingModelAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1337:1: ( rule__MappingModel__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1337:2: rule__MappingModel__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__MappingModel__NameAssignment_1_in_rule__MappingModel__Group__1__Impl2760);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1347:1: rule__MappingModel__Group__2 : rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3 ;
    public final void rule__MappingModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1351:1: ( rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1352:2: rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__2__Impl_in_rule__MappingModel__Group__22790);
            rule__MappingModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__3_in_rule__MappingModel__Group__22793);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1359:1: rule__MappingModel__Group__2__Impl : ( '{' ) ;
    public final void rule__MappingModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1363:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1364:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1364:1: ( '{' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1365:1: '{'
            {
             before(grammarAccess.getMappingModelAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,23,FOLLOW_23_in_rule__MappingModel__Group__2__Impl2821); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1378:1: rule__MappingModel__Group__3 : rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4 ;
    public final void rule__MappingModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1382:1: ( rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1383:2: rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__3__Impl_in_rule__MappingModel__Group__32852);
            rule__MappingModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__4_in_rule__MappingModel__Group__32855);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1390:1: rule__MappingModel__Group__3__Impl : ( ( rule__MappingModel__ImportsAssignment_3 )* ) ;
    public final void rule__MappingModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1394:1: ( ( ( rule__MappingModel__ImportsAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1395:1: ( ( rule__MappingModel__ImportsAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1395:1: ( ( rule__MappingModel__ImportsAssignment_3 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1396:1: ( rule__MappingModel__ImportsAssignment_3 )*
            {
             before(grammarAccess.getMappingModelAccess().getImportsAssignment_3()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1397:1: ( rule__MappingModel__ImportsAssignment_3 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==33) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1397:2: rule__MappingModel__ImportsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__MappingModel__ImportsAssignment_3_in_rule__MappingModel__Group__3__Impl2882);
            	    rule__MappingModel__ImportsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1407:1: rule__MappingModel__Group__4 : rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5 ;
    public final void rule__MappingModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1411:1: ( rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1412:2: rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__4__Impl_in_rule__MappingModel__Group__42913);
            rule__MappingModel__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MappingModel__Group__5_in_rule__MappingModel__Group__42916);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1419:1: rule__MappingModel__Group__4__Impl : ( ( rule__MappingModel__MappingsAssignment_4 )* ) ;
    public final void rule__MappingModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1423:1: ( ( ( rule__MappingModel__MappingsAssignment_4 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1424:1: ( ( rule__MappingModel__MappingsAssignment_4 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1424:1: ( ( rule__MappingModel__MappingsAssignment_4 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1425:1: ( rule__MappingModel__MappingsAssignment_4 )*
            {
             before(grammarAccess.getMappingModelAccess().getMappingsAssignment_4()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1426:1: ( rule__MappingModel__MappingsAssignment_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==25) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1426:2: rule__MappingModel__MappingsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__MappingModel__MappingsAssignment_4_in_rule__MappingModel__Group__4__Impl2943);
            	    rule__MappingModel__MappingsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1436:1: rule__MappingModel__Group__5 : rule__MappingModel__Group__5__Impl ;
    public final void rule__MappingModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1440:1: ( rule__MappingModel__Group__5__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1441:2: rule__MappingModel__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__MappingModel__Group__5__Impl_in_rule__MappingModel__Group__52974);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1447:1: rule__MappingModel__Group__5__Impl : ( '}' ) ;
    public final void rule__MappingModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1451:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1452:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1452:1: ( '}' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1453:1: '}'
            {
             before(grammarAccess.getMappingModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,24,FOLLOW_24_in_rule__MappingModel__Group__5__Impl3002); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1478:1: rule__Mapping__Group__0 : rule__Mapping__Group__0__Impl rule__Mapping__Group__1 ;
    public final void rule__Mapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1482:1: ( rule__Mapping__Group__0__Impl rule__Mapping__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1483:2: rule__Mapping__Group__0__Impl rule__Mapping__Group__1
            {
            pushFollow(FOLLOW_rule__Mapping__Group__0__Impl_in_rule__Mapping__Group__03045);
            rule__Mapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__1_in_rule__Mapping__Group__03048);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1490:1: rule__Mapping__Group__0__Impl : ( 'Mapping' ) ;
    public final void rule__Mapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1494:1: ( ( 'Mapping' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1495:1: ( 'Mapping' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1495:1: ( 'Mapping' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1496:1: 'Mapping'
            {
             before(grammarAccess.getMappingAccess().getMappingKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__Mapping__Group__0__Impl3076); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1509:1: rule__Mapping__Group__1 : rule__Mapping__Group__1__Impl rule__Mapping__Group__2 ;
    public final void rule__Mapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1513:1: ( rule__Mapping__Group__1__Impl rule__Mapping__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1514:2: rule__Mapping__Group__1__Impl rule__Mapping__Group__2
            {
            pushFollow(FOLLOW_rule__Mapping__Group__1__Impl_in_rule__Mapping__Group__13107);
            rule__Mapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__2_in_rule__Mapping__Group__13110);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1521:1: rule__Mapping__Group__1__Impl : ( ( rule__Mapping__LogicalSysAssignment_1 ) ) ;
    public final void rule__Mapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1525:1: ( ( ( rule__Mapping__LogicalSysAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1526:1: ( ( rule__Mapping__LogicalSysAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1526:1: ( ( rule__Mapping__LogicalSysAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1527:1: ( rule__Mapping__LogicalSysAssignment_1 )
            {
             before(grammarAccess.getMappingAccess().getLogicalSysAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1528:1: ( rule__Mapping__LogicalSysAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1528:2: rule__Mapping__LogicalSysAssignment_1
            {
            pushFollow(FOLLOW_rule__Mapping__LogicalSysAssignment_1_in_rule__Mapping__Group__1__Impl3137);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1538:1: rule__Mapping__Group__2 : rule__Mapping__Group__2__Impl rule__Mapping__Group__3 ;
    public final void rule__Mapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1542:1: ( rule__Mapping__Group__2__Impl rule__Mapping__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1543:2: rule__Mapping__Group__2__Impl rule__Mapping__Group__3
            {
            pushFollow(FOLLOW_rule__Mapping__Group__2__Impl_in_rule__Mapping__Group__23167);
            rule__Mapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__3_in_rule__Mapping__Group__23170);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1550:1: rule__Mapping__Group__2__Impl : ( '->' ) ;
    public final void rule__Mapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1554:1: ( ( '->' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1555:1: ( '->' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1555:1: ( '->' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1556:1: '->'
            {
             before(grammarAccess.getMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,26,FOLLOW_26_in_rule__Mapping__Group__2__Impl3198); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1569:1: rule__Mapping__Group__3 : rule__Mapping__Group__3__Impl rule__Mapping__Group__4 ;
    public final void rule__Mapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1573:1: ( rule__Mapping__Group__3__Impl rule__Mapping__Group__4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1574:2: rule__Mapping__Group__3__Impl rule__Mapping__Group__4
            {
            pushFollow(FOLLOW_rule__Mapping__Group__3__Impl_in_rule__Mapping__Group__33229);
            rule__Mapping__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__4_in_rule__Mapping__Group__33232);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1581:1: rule__Mapping__Group__3__Impl : ( ( rule__Mapping__PhysicalSysAssignment_3 ) ) ;
    public final void rule__Mapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1585:1: ( ( ( rule__Mapping__PhysicalSysAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1586:1: ( ( rule__Mapping__PhysicalSysAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1586:1: ( ( rule__Mapping__PhysicalSysAssignment_3 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1587:1: ( rule__Mapping__PhysicalSysAssignment_3 )
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysAssignment_3()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1588:1: ( rule__Mapping__PhysicalSysAssignment_3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1588:2: rule__Mapping__PhysicalSysAssignment_3
            {
            pushFollow(FOLLOW_rule__Mapping__PhysicalSysAssignment_3_in_rule__Mapping__Group__3__Impl3259);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1598:1: rule__Mapping__Group__4 : rule__Mapping__Group__4__Impl rule__Mapping__Group__5 ;
    public final void rule__Mapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1602:1: ( rule__Mapping__Group__4__Impl rule__Mapping__Group__5 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1603:2: rule__Mapping__Group__4__Impl rule__Mapping__Group__5
            {
            pushFollow(FOLLOW_rule__Mapping__Group__4__Impl_in_rule__Mapping__Group__43289);
            rule__Mapping__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__5_in_rule__Mapping__Group__43292);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1610:1: rule__Mapping__Group__4__Impl : ( '{' ) ;
    public final void rule__Mapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1614:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1615:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1615:1: ( '{' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1616:1: '{'
            {
             before(grammarAccess.getMappingAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,23,FOLLOW_23_in_rule__Mapping__Group__4__Impl3320); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1629:1: rule__Mapping__Group__5 : rule__Mapping__Group__5__Impl rule__Mapping__Group__6 ;
    public final void rule__Mapping__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1633:1: ( rule__Mapping__Group__5__Impl rule__Mapping__Group__6 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1634:2: rule__Mapping__Group__5__Impl rule__Mapping__Group__6
            {
            pushFollow(FOLLOW_rule__Mapping__Group__5__Impl_in_rule__Mapping__Group__53351);
            rule__Mapping__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mapping__Group__6_in_rule__Mapping__Group__53354);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1641:1: rule__Mapping__Group__5__Impl : ( ( rule__Mapping__SubsysMappingsAssignment_5 )* ) ;
    public final void rule__Mapping__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1645:1: ( ( ( rule__Mapping__SubsysMappingsAssignment_5 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1646:1: ( ( rule__Mapping__SubsysMappingsAssignment_5 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1646:1: ( ( rule__Mapping__SubsysMappingsAssignment_5 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1647:1: ( rule__Mapping__SubsysMappingsAssignment_5 )*
            {
             before(grammarAccess.getMappingAccess().getSubsysMappingsAssignment_5()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1648:1: ( rule__Mapping__SubsysMappingsAssignment_5 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==27) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1648:2: rule__Mapping__SubsysMappingsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__Mapping__SubsysMappingsAssignment_5_in_rule__Mapping__Group__5__Impl3381);
            	    rule__Mapping__SubsysMappingsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1658:1: rule__Mapping__Group__6 : rule__Mapping__Group__6__Impl ;
    public final void rule__Mapping__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1662:1: ( rule__Mapping__Group__6__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1663:2: rule__Mapping__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__Mapping__Group__6__Impl_in_rule__Mapping__Group__63412);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1669:1: rule__Mapping__Group__6__Impl : ( '}' ) ;
    public final void rule__Mapping__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1673:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1674:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1674:1: ( '}' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1675:1: '}'
            {
             before(grammarAccess.getMappingAccess().getRightCurlyBracketKeyword_6()); 
            match(input,24,FOLLOW_24_in_rule__Mapping__Group__6__Impl3440); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1702:1: rule__SubSystemMapping__Group__0 : rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1 ;
    public final void rule__SubSystemMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1706:1: ( rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1707:2: rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__0__Impl_in_rule__SubSystemMapping__Group__03485);
            rule__SubSystemMapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group__1_in_rule__SubSystemMapping__Group__03488);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1714:1: rule__SubSystemMapping__Group__0__Impl : ( 'SubSystemMapping' ) ;
    public final void rule__SubSystemMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1718:1: ( ( 'SubSystemMapping' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1719:1: ( 'SubSystemMapping' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1719:1: ( 'SubSystemMapping' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1720:1: 'SubSystemMapping'
            {
             before(grammarAccess.getSubSystemMappingAccess().getSubSystemMappingKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__SubSystemMapping__Group__0__Impl3516); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1733:1: rule__SubSystemMapping__Group__1 : rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2 ;
    public final void rule__SubSystemMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1737:1: ( rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1738:2: rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__1__Impl_in_rule__SubSystemMapping__Group__13547);
            rule__SubSystemMapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group__2_in_rule__SubSystemMapping__Group__13550);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1745:1: rule__SubSystemMapping__Group__1__Impl : ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) ) ;
    public final void rule__SubSystemMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1749:1: ( ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1750:1: ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1750:1: ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1751:1: ( rule__SubSystemMapping__LogicalSubSysAssignment_1 )
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1752:1: ( rule__SubSystemMapping__LogicalSubSysAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1752:2: rule__SubSystemMapping__LogicalSubSysAssignment_1
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__LogicalSubSysAssignment_1_in_rule__SubSystemMapping__Group__1__Impl3577);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1762:1: rule__SubSystemMapping__Group__2 : rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3 ;
    public final void rule__SubSystemMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1766:1: ( rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1767:2: rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__2__Impl_in_rule__SubSystemMapping__Group__23607);
            rule__SubSystemMapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group__3_in_rule__SubSystemMapping__Group__23610);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1774:1: rule__SubSystemMapping__Group__2__Impl : ( '->' ) ;
    public final void rule__SubSystemMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1778:1: ( ( '->' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1779:1: ( '->' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1779:1: ( '->' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1780:1: '->'
            {
             before(grammarAccess.getSubSystemMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,26,FOLLOW_26_in_rule__SubSystemMapping__Group__2__Impl3638); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1793:1: rule__SubSystemMapping__Group__3 : rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4 ;
    public final void rule__SubSystemMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1797:1: ( rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1798:2: rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__3__Impl_in_rule__SubSystemMapping__Group__33669);
            rule__SubSystemMapping__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group__4_in_rule__SubSystemMapping__Group__33672);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1805:1: rule__SubSystemMapping__Group__3__Impl : ( ( rule__SubSystemMapping__NodeAssignment_3 ) ) ;
    public final void rule__SubSystemMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1809:1: ( ( ( rule__SubSystemMapping__NodeAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1810:1: ( ( rule__SubSystemMapping__NodeAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1810:1: ( ( rule__SubSystemMapping__NodeAssignment_3 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1811:1: ( rule__SubSystemMapping__NodeAssignment_3 )
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeAssignment_3()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1812:1: ( rule__SubSystemMapping__NodeAssignment_3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1812:2: rule__SubSystemMapping__NodeAssignment_3
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__NodeAssignment_3_in_rule__SubSystemMapping__Group__3__Impl3699);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1822:1: rule__SubSystemMapping__Group__4 : rule__SubSystemMapping__Group__4__Impl ;
    public final void rule__SubSystemMapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1826:1: ( rule__SubSystemMapping__Group__4__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1827:2: rule__SubSystemMapping__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group__4__Impl_in_rule__SubSystemMapping__Group__43729);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1833:1: rule__SubSystemMapping__Group__4__Impl : ( ( rule__SubSystemMapping__Group_4__0 )? ) ;
    public final void rule__SubSystemMapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1837:1: ( ( ( rule__SubSystemMapping__Group_4__0 )? ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1838:1: ( ( rule__SubSystemMapping__Group_4__0 )? )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1838:1: ( ( rule__SubSystemMapping__Group_4__0 )? )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1839:1: ( rule__SubSystemMapping__Group_4__0 )?
            {
             before(grammarAccess.getSubSystemMappingAccess().getGroup_4()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1840:1: ( rule__SubSystemMapping__Group_4__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==23) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1840:2: rule__SubSystemMapping__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__0_in_rule__SubSystemMapping__Group__4__Impl3756);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1860:1: rule__SubSystemMapping__Group_4__0 : rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1 ;
    public final void rule__SubSystemMapping__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1864:1: ( rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1865:2: rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__0__Impl_in_rule__SubSystemMapping__Group_4__03797);
            rule__SubSystemMapping__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__1_in_rule__SubSystemMapping__Group_4__03800);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1872:1: rule__SubSystemMapping__Group_4__0__Impl : ( '{' ) ;
    public final void rule__SubSystemMapping__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1876:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1877:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1877:1: ( '{' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1878:1: '{'
            {
             before(grammarAccess.getSubSystemMappingAccess().getLeftCurlyBracketKeyword_4_0()); 
            match(input,23,FOLLOW_23_in_rule__SubSystemMapping__Group_4__0__Impl3828); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1891:1: rule__SubSystemMapping__Group_4__1 : rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2 ;
    public final void rule__SubSystemMapping__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1895:1: ( rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1896:2: rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__1__Impl_in_rule__SubSystemMapping__Group_4__13859);
            rule__SubSystemMapping__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__2_in_rule__SubSystemMapping__Group_4__13862);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1903:1: rule__SubSystemMapping__Group_4__1__Impl : ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* ) ;
    public final void rule__SubSystemMapping__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1907:1: ( ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1908:1: ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1908:1: ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1909:1: ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )*
            {
             before(grammarAccess.getSubSystemMappingAccess().getThreadMappingsAssignment_4_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1910:1: ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==28) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1910:2: rule__SubSystemMapping__ThreadMappingsAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_rule__SubSystemMapping__ThreadMappingsAssignment_4_1_in_rule__SubSystemMapping__Group_4__1__Impl3889);
            	    rule__SubSystemMapping__ThreadMappingsAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1920:1: rule__SubSystemMapping__Group_4__2 : rule__SubSystemMapping__Group_4__2__Impl ;
    public final void rule__SubSystemMapping__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1924:1: ( rule__SubSystemMapping__Group_4__2__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1925:2: rule__SubSystemMapping__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__SubSystemMapping__Group_4__2__Impl_in_rule__SubSystemMapping__Group_4__23920);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1931:1: rule__SubSystemMapping__Group_4__2__Impl : ( '}' ) ;
    public final void rule__SubSystemMapping__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1935:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1936:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1936:1: ( '}' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1937:1: '}'
            {
             before(grammarAccess.getSubSystemMappingAccess().getRightCurlyBracketKeyword_4_2()); 
            match(input,24,FOLLOW_24_in_rule__SubSystemMapping__Group_4__2__Impl3948); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1956:1: rule__ThreadMapping__Group__0 : rule__ThreadMapping__Group__0__Impl rule__ThreadMapping__Group__1 ;
    public final void rule__ThreadMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1960:1: ( rule__ThreadMapping__Group__0__Impl rule__ThreadMapping__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1961:2: rule__ThreadMapping__Group__0__Impl rule__ThreadMapping__Group__1
            {
            pushFollow(FOLLOW_rule__ThreadMapping__Group__0__Impl_in_rule__ThreadMapping__Group__03985);
            rule__ThreadMapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ThreadMapping__Group__1_in_rule__ThreadMapping__Group__03988);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1968:1: rule__ThreadMapping__Group__0__Impl : ( 'ThreadMapping' ) ;
    public final void rule__ThreadMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1972:1: ( ( 'ThreadMapping' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1973:1: ( 'ThreadMapping' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1973:1: ( 'ThreadMapping' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1974:1: 'ThreadMapping'
            {
             before(grammarAccess.getThreadMappingAccess().getThreadMappingKeyword_0()); 
            match(input,28,FOLLOW_28_in_rule__ThreadMapping__Group__0__Impl4016); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1987:1: rule__ThreadMapping__Group__1 : rule__ThreadMapping__Group__1__Impl rule__ThreadMapping__Group__2 ;
    public final void rule__ThreadMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1991:1: ( rule__ThreadMapping__Group__1__Impl rule__ThreadMapping__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1992:2: rule__ThreadMapping__Group__1__Impl rule__ThreadMapping__Group__2
            {
            pushFollow(FOLLOW_rule__ThreadMapping__Group__1__Impl_in_rule__ThreadMapping__Group__14047);
            rule__ThreadMapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ThreadMapping__Group__2_in_rule__ThreadMapping__Group__14050);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:1999:1: rule__ThreadMapping__Group__1__Impl : ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) ) ;
    public final void rule__ThreadMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2003:1: ( ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2004:1: ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2004:1: ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2005:1: ( rule__ThreadMapping__LogicalThreadAssignment_1 )
            {
             before(grammarAccess.getThreadMappingAccess().getLogicalThreadAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2006:1: ( rule__ThreadMapping__LogicalThreadAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2006:2: rule__ThreadMapping__LogicalThreadAssignment_1
            {
            pushFollow(FOLLOW_rule__ThreadMapping__LogicalThreadAssignment_1_in_rule__ThreadMapping__Group__1__Impl4077);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2016:1: rule__ThreadMapping__Group__2 : rule__ThreadMapping__Group__2__Impl rule__ThreadMapping__Group__3 ;
    public final void rule__ThreadMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2020:1: ( rule__ThreadMapping__Group__2__Impl rule__ThreadMapping__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2021:2: rule__ThreadMapping__Group__2__Impl rule__ThreadMapping__Group__3
            {
            pushFollow(FOLLOW_rule__ThreadMapping__Group__2__Impl_in_rule__ThreadMapping__Group__24107);
            rule__ThreadMapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ThreadMapping__Group__3_in_rule__ThreadMapping__Group__24110);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2028:1: rule__ThreadMapping__Group__2__Impl : ( '->' ) ;
    public final void rule__ThreadMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2032:1: ( ( '->' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2033:1: ( '->' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2033:1: ( '->' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2034:1: '->'
            {
             before(grammarAccess.getThreadMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,26,FOLLOW_26_in_rule__ThreadMapping__Group__2__Impl4138); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2047:1: rule__ThreadMapping__Group__3 : rule__ThreadMapping__Group__3__Impl ;
    public final void rule__ThreadMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2051:1: ( rule__ThreadMapping__Group__3__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2052:2: rule__ThreadMapping__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ThreadMapping__Group__3__Impl_in_rule__ThreadMapping__Group__34169);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2058:1: rule__ThreadMapping__Group__3__Impl : ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) ) ;
    public final void rule__ThreadMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2062:1: ( ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2063:1: ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2063:1: ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2064:1: ( rule__ThreadMapping__PhysicalThreadAssignment_3 )
            {
             before(grammarAccess.getThreadMappingAccess().getPhysicalThreadAssignment_3()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2065:1: ( rule__ThreadMapping__PhysicalThreadAssignment_3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2065:2: rule__ThreadMapping__PhysicalThreadAssignment_3
            {
            pushFollow(FOLLOW_rule__ThreadMapping__PhysicalThreadAssignment_3_in_rule__ThreadMapping__Group__3__Impl4196);
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


    // $ANTLR start "rule__KeyValue__Group__0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2086:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2090:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2091:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__0__Impl_in_rule__KeyValue__Group__04237);
            rule__KeyValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeyValue__Group__1_in_rule__KeyValue__Group__04240);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2098:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2102:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2103:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2103:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2104:1: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2105:1: ( rule__KeyValue__KeyAssignment_0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2105:2: rule__KeyValue__KeyAssignment_0
            {
            pushFollow(FOLLOW_rule__KeyValue__KeyAssignment_0_in_rule__KeyValue__Group__0__Impl4267);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2115:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2119:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2120:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__1__Impl_in_rule__KeyValue__Group__14297);
            rule__KeyValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeyValue__Group__2_in_rule__KeyValue__Group__14300);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2127:1: rule__KeyValue__Group__1__Impl : ( '=' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2131:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2132:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2132:1: ( '=' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2133:1: '='
            {
             before(grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1()); 
            match(input,29,FOLLOW_29_in_rule__KeyValue__Group__1__Impl4328); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2146:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2150:1: ( rule__KeyValue__Group__2__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2151:2: rule__KeyValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__2__Impl_in_rule__KeyValue__Group__24359);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2157:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2161:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2162:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2162:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2163:1: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2164:1: ( rule__KeyValue__ValueAssignment_2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2164:2: rule__KeyValue__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__KeyValue__ValueAssignment_2_in_rule__KeyValue__Group__2__Impl4386);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2183:1: rule__SimpleAnnotationAttribute__Group__0 : rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 ;
    public final void rule__SimpleAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2187:1: ( rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2188:2: rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__0__Impl_in_rule__SimpleAnnotationAttribute__Group__04425);
            rule__SimpleAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__1_in_rule__SimpleAnnotationAttribute__Group__04428);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2195:1: rule__SimpleAnnotationAttribute__Group__0__Impl : ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2199:1: ( ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2200:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2200:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2201:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2202:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2202:2: rule__SimpleAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Alternatives_0_in_rule__SimpleAnnotationAttribute__Group__0__Impl4455);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2212:1: rule__SimpleAnnotationAttribute__Group__1 : rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 ;
    public final void rule__SimpleAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2216:1: ( rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2217:2: rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__1__Impl_in_rule__SimpleAnnotationAttribute__Group__14485);
            rule__SimpleAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__2_in_rule__SimpleAnnotationAttribute__Group__14488);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2224:1: rule__SimpleAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2228:1: ( ( 'attribute' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2229:1: ( 'attribute' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2229:1: ( 'attribute' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2230:1: 'attribute'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__SimpleAnnotationAttribute__Group__1__Impl4516); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2243:1: rule__SimpleAnnotationAttribute__Group__2 : rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 ;
    public final void rule__SimpleAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2247:1: ( rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2248:2: rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__2__Impl_in_rule__SimpleAnnotationAttribute__Group__24547);
            rule__SimpleAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__3_in_rule__SimpleAnnotationAttribute__Group__24550);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2255:1: rule__SimpleAnnotationAttribute__Group__2__Impl : ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2259:1: ( ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2260:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2260:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2261:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2262:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2262:2: rule__SimpleAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__NameAssignment_2_in_rule__SimpleAnnotationAttribute__Group__2__Impl4577);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2272:1: rule__SimpleAnnotationAttribute__Group__3 : rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 ;
    public final void rule__SimpleAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2276:1: ( rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2277:2: rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__3__Impl_in_rule__SimpleAnnotationAttribute__Group__34607);
            rule__SimpleAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__4_in_rule__SimpleAnnotationAttribute__Group__34610);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2284:1: rule__SimpleAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2288:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2289:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2289:1: ( ':' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2290:1: ':'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,31,FOLLOW_31_in_rule__SimpleAnnotationAttribute__Group__3__Impl4638); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2303:1: rule__SimpleAnnotationAttribute__Group__4 : rule__SimpleAnnotationAttribute__Group__4__Impl ;
    public final void rule__SimpleAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2307:1: ( rule__SimpleAnnotationAttribute__Group__4__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2308:2: rule__SimpleAnnotationAttribute__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__4__Impl_in_rule__SimpleAnnotationAttribute__Group__44669);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2314:1: rule__SimpleAnnotationAttribute__Group__4__Impl : ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2318:1: ( ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2319:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2319:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2320:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2321:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2321:2: rule__SimpleAnnotationAttribute__TypeAssignment_4
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__TypeAssignment_4_in_rule__SimpleAnnotationAttribute__Group__4__Impl4696);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2341:1: rule__EnumAnnotationAttribute__Group__0 : rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 ;
    public final void rule__EnumAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2345:1: ( rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2346:2: rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__0__Impl_in_rule__EnumAnnotationAttribute__Group__04736);
            rule__EnumAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__1_in_rule__EnumAnnotationAttribute__Group__04739);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2353:1: rule__EnumAnnotationAttribute__Group__0__Impl : ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2357:1: ( ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2358:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2358:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2359:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2360:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2360:2: rule__EnumAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Alternatives_0_in_rule__EnumAnnotationAttribute__Group__0__Impl4766);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2370:1: rule__EnumAnnotationAttribute__Group__1 : rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 ;
    public final void rule__EnumAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2374:1: ( rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2375:2: rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__1__Impl_in_rule__EnumAnnotationAttribute__Group__14796);
            rule__EnumAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__2_in_rule__EnumAnnotationAttribute__Group__14799);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2382:1: rule__EnumAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__EnumAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2386:1: ( ( 'attribute' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2387:1: ( 'attribute' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2387:1: ( 'attribute' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2388:1: 'attribute'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__EnumAnnotationAttribute__Group__1__Impl4827); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2401:1: rule__EnumAnnotationAttribute__Group__2 : rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 ;
    public final void rule__EnumAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2405:1: ( rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2406:2: rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__2__Impl_in_rule__EnumAnnotationAttribute__Group__24858);
            rule__EnumAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__3_in_rule__EnumAnnotationAttribute__Group__24861);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2413:1: rule__EnumAnnotationAttribute__Group__2__Impl : ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2417:1: ( ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2418:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2418:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2419:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2420:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2420:2: rule__EnumAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__NameAssignment_2_in_rule__EnumAnnotationAttribute__Group__2__Impl4888);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2430:1: rule__EnumAnnotationAttribute__Group__3 : rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 ;
    public final void rule__EnumAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2434:1: ( rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2435:2: rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__3__Impl_in_rule__EnumAnnotationAttribute__Group__34918);
            rule__EnumAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__4_in_rule__EnumAnnotationAttribute__Group__34921);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2442:1: rule__EnumAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2446:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2447:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2447:1: ( ':' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2448:1: ':'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,31,FOLLOW_31_in_rule__EnumAnnotationAttribute__Group__3__Impl4949); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2461:1: rule__EnumAnnotationAttribute__Group__4 : rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 ;
    public final void rule__EnumAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2465:1: ( rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2466:2: rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__4__Impl_in_rule__EnumAnnotationAttribute__Group__44980);
            rule__EnumAnnotationAttribute__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__5_in_rule__EnumAnnotationAttribute__Group__44983);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2473:1: rule__EnumAnnotationAttribute__Group__4__Impl : ( '{' ) ;
    public final void rule__EnumAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2477:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2478:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2478:1: ( '{' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2479:1: '{'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,23,FOLLOW_23_in_rule__EnumAnnotationAttribute__Group__4__Impl5011); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2492:1: rule__EnumAnnotationAttribute__Group__5 : rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 ;
    public final void rule__EnumAnnotationAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2496:1: ( rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2497:2: rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__5__Impl_in_rule__EnumAnnotationAttribute__Group__55042);
            rule__EnumAnnotationAttribute__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__6_in_rule__EnumAnnotationAttribute__Group__55045);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2504:1: rule__EnumAnnotationAttribute__Group__5__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2508:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2509:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2509:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2510:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2511:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2511:2: rule__EnumAnnotationAttribute__ValuesAssignment_5
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_5_in_rule__EnumAnnotationAttribute__Group__5__Impl5072);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2521:1: rule__EnumAnnotationAttribute__Group__6 : rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 ;
    public final void rule__EnumAnnotationAttribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2525:1: ( rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2526:2: rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__6__Impl_in_rule__EnumAnnotationAttribute__Group__65102);
            rule__EnumAnnotationAttribute__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__7_in_rule__EnumAnnotationAttribute__Group__65105);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2533:1: rule__EnumAnnotationAttribute__Group__6__Impl : ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) ;
    public final void rule__EnumAnnotationAttribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2537:1: ( ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2538:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2538:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2539:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2540:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==32) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2540:2: rule__EnumAnnotationAttribute__Group_6__0
            	    {
            	    pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__0_in_rule__EnumAnnotationAttribute__Group__6__Impl5132);
            	    rule__EnumAnnotationAttribute__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2550:1: rule__EnumAnnotationAttribute__Group__7 : rule__EnumAnnotationAttribute__Group__7__Impl ;
    public final void rule__EnumAnnotationAttribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2554:1: ( rule__EnumAnnotationAttribute__Group__7__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2555:2: rule__EnumAnnotationAttribute__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__7__Impl_in_rule__EnumAnnotationAttribute__Group__75163);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2561:1: rule__EnumAnnotationAttribute__Group__7__Impl : ( '}' ) ;
    public final void rule__EnumAnnotationAttribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2565:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2566:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2566:1: ( '}' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2567:1: '}'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7()); 
            match(input,24,FOLLOW_24_in_rule__EnumAnnotationAttribute__Group__7__Impl5191); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2596:1: rule__EnumAnnotationAttribute__Group_6__0 : rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 ;
    public final void rule__EnumAnnotationAttribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2600:1: ( rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2601:2: rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__0__Impl_in_rule__EnumAnnotationAttribute__Group_6__05238);
            rule__EnumAnnotationAttribute__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__1_in_rule__EnumAnnotationAttribute__Group_6__05241);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2608:1: rule__EnumAnnotationAttribute__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2612:1: ( ( ',' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2613:1: ( ',' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2613:1: ( ',' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2614:1: ','
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0()); 
            match(input,32,FOLLOW_32_in_rule__EnumAnnotationAttribute__Group_6__0__Impl5269); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2627:1: rule__EnumAnnotationAttribute__Group_6__1 : rule__EnumAnnotationAttribute__Group_6__1__Impl ;
    public final void rule__EnumAnnotationAttribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2631:1: ( rule__EnumAnnotationAttribute__Group_6__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2632:2: rule__EnumAnnotationAttribute__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__1__Impl_in_rule__EnumAnnotationAttribute__Group_6__15300);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2638:1: rule__EnumAnnotationAttribute__Group_6__1__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2642:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2643:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2643:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2644:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2645:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2645:2: rule__EnumAnnotationAttribute__ValuesAssignment_6_1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_6_1_in_rule__EnumAnnotationAttribute__Group_6__1__Impl5327);
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


    // $ANTLR start "rule__Import__Group__0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2659:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2663:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2664:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__05361);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__05364);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2671:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2675:1: ( ( 'import' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2676:1: ( 'import' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2676:1: ( 'import' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2677:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,33,FOLLOW_33_in_rule__Import__Group__0__Impl5392); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2690:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2694:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2695:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__15423);
            rule__Import__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__2_in_rule__Import__Group__15426);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2702:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2706:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2707:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2707:1: ( ( rule__Import__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2708:1: ( rule__Import__Alternatives_1 )
            {
             before(grammarAccess.getImportAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2709:1: ( rule__Import__Alternatives_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2709:2: rule__Import__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl5453);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2719:1: rule__Import__Group__2 : rule__Import__Group__2__Impl ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2723:1: ( rule__Import__Group__2__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2724:2: rule__Import__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__25483);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2730:1: rule__Import__Group__2__Impl : ( ( rule__Import__ImportURIAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2734:1: ( ( ( rule__Import__ImportURIAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2735:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2735:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2736:1: ( rule__Import__ImportURIAssignment_2 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_2()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2737:1: ( rule__Import__ImportURIAssignment_2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2737:2: rule__Import__ImportURIAssignment_2
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl5510);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2753:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2757:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2758:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__05546);
            rule__Import__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__05549);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2765:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2769:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2770:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2770:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2771:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2772:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2772:2: rule__Import__ImportedNamespaceAssignment_1_0_0
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl5576);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2782:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2786:1: ( rule__Import__Group_1_0__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2787:2: rule__Import__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__15606);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2793:1: rule__Import__Group_1_0__1__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2797:1: ( ( 'from' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2798:1: ( 'from' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2798:1: ( 'from' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2799:1: 'from'
            {
             before(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 
            match(input,34,FOLLOW_34_in_rule__Import__Group_1_0__1__Impl5634); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2816:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2820:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2821:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__05669);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__05672);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2828:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2832:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2833:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2833:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2834:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl5699);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2845:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2849:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2850:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__15728);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2856:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2860:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2861:1: ( ( '.*' )? )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2861:1: ( ( '.*' )? )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2862:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2863:1: ( '.*' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==35) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2864:2: '.*'
                    {
                    match(input,35,FOLLOW_35_in_rule__ImportedFQN__Group__1__Impl5757); 

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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2879:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2883:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2884:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__05794);
            rule__Documentation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__05797);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2891:1: rule__Documentation__Group__0__Impl : ( () ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2895:1: ( ( () ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2896:1: ( () )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2896:1: ( () )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2897:1: ()
            {
             before(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2898:1: ()
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2900:1: 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2910:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2914:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2915:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
            {
            pushFollow(FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__15855);
            rule__Documentation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__15858);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2922:1: rule__Documentation__Group__1__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2926:1: ( ( '[' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2927:1: ( '[' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2927:1: ( '[' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2928:1: '['
            {
             before(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1()); 
            match(input,36,FOLLOW_36_in_rule__Documentation__Group__1__Impl5886); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2941:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl rule__Documentation__Group__3 ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2945:1: ( rule__Documentation__Group__2__Impl rule__Documentation__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2946:2: rule__Documentation__Group__2__Impl rule__Documentation__Group__3
            {
            pushFollow(FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__25917);
            rule__Documentation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__3_in_rule__Documentation__Group__25920);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2953:1: rule__Documentation__Group__2__Impl : ( ( rule__Documentation__LinesAssignment_2 )* ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2957:1: ( ( ( rule__Documentation__LinesAssignment_2 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2958:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2958:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2959:1: ( rule__Documentation__LinesAssignment_2 )*
            {
             before(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2960:1: ( rule__Documentation__LinesAssignment_2 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_STRING) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2960:2: rule__Documentation__LinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Documentation__LinesAssignment_2_in_rule__Documentation__Group__2__Impl5947);
            	    rule__Documentation__LinesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2970:1: rule__Documentation__Group__3 : rule__Documentation__Group__3__Impl ;
    public final void rule__Documentation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2974:1: ( rule__Documentation__Group__3__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2975:2: rule__Documentation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Documentation__Group__3__Impl_in_rule__Documentation__Group__35978);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2981:1: rule__Documentation__Group__3__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2985:1: ( ( ']' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2986:1: ( ']' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2986:1: ( ']' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:2987:1: ']'
            {
             before(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3()); 
            match(input,37,FOLLOW_37_in_rule__Documentation__Group__3__Impl6006); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3014:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3018:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3019:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__06051);
            rule__BooleanLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__06054);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3026:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3030:1: ( ( () ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3031:1: ( () )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3031:1: ( () )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3032:1: ()
            {
             before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3033:1: ()
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3035:1: 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3045:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3049:1: ( rule__BooleanLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3050:2: rule__BooleanLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__16112);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3056:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3060:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3061:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3061:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3062:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3063:1: ( rule__BooleanLiteral__Alternatives_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3063:2: rule__BooleanLiteral__Alternatives_1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl6139);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3077:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3081:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3082:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__06173);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__06176);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3089:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3093:1: ( ( () ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3094:1: ( () )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3094:1: ( () )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3095:1: ()
            {
             before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3096:1: ()
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3098:1: 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3108:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3112:1: ( rule__RealLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3113:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__16234);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3119:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3123:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3124:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3124:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3125:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3126:1: ( rule__RealLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3126:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl6261);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3140:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3144:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3145:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__06295);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__06298);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3152:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3156:1: ( ( () ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3157:1: ( () )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3157:1: ( () )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3158:1: ()
            {
             before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3159:1: ()
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3161:1: 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3171:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3175:1: ( rule__IntLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3176:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__16356);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3182:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3186:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3187:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3187:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3188:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3189:1: ( rule__IntLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3189:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl6383);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3203:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3207:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3208:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__06417);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__06420);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3215:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3219:1: ( ( () ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3220:1: ( () )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3220:1: ( () )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3221:1: ()
            {
             before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3222:1: ()
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3224:1: 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3234:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3238:1: ( rule__StringLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3239:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__16478);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3245:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3249:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3250:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3250:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3251:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3252:1: ( rule__StringLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3252:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl6505);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3266:1: rule__SignedInteger__Group__0 : rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 ;
    public final void rule__SignedInteger__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3270:1: ( rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3271:2: rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__06539);
            rule__SignedInteger__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__06542);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3278:1: rule__SignedInteger__Group__0__Impl : ( ( rule__SignedInteger__Alternatives_0 )? ) ;
    public final void rule__SignedInteger__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3282:1: ( ( ( rule__SignedInteger__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3283:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3283:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3284:1: ( rule__SignedInteger__Alternatives_0 )?
            {
             before(grammarAccess.getSignedIntegerAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3285:1: ( rule__SignedInteger__Alternatives_0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=16 && LA24_0<=17)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3285:2: rule__SignedInteger__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl6569);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3295:1: rule__SignedInteger__Group__1 : rule__SignedInteger__Group__1__Impl ;
    public final void rule__SignedInteger__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3299:1: ( rule__SignedInteger__Group__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3300:2: rule__SignedInteger__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__16600);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3306:1: rule__SignedInteger__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__SignedInteger__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3310:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3311:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3311:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3312:1: RULE_INT
            {
             before(grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl6627); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3327:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3331:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3332:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__06660);
            rule__Decimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__06663);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3339:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3343:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3344:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3344:1: ( ( rule__Decimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3345:1: ( rule__Decimal__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3346:1: ( rule__Decimal__Alternatives_0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=16 && LA25_0<=17)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3346:2: rule__Decimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl6690);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3356:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3360:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3361:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__16721);
            rule__Decimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__16724);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3368:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3372:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3373:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3373:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3374:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl6751); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3385:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3389:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3390:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
            {
            pushFollow(FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__26780);
            rule__Decimal__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__26783);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3397:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3401:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3402:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3402:1: ( '.' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3403:1: '.'
            {
             before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            match(input,38,FOLLOW_38_in_rule__Decimal__Group__2__Impl6811); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3416:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3420:1: ( rule__Decimal__Group__3__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3421:2: rule__Decimal__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__36842);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3427:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3431:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3432:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3432:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3433:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl6869); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3452:1: rule__DotDecimal__Group__0 : rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 ;
    public final void rule__DotDecimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3456:1: ( rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3457:2: rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__06906);
            rule__DotDecimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__06909);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3464:1: rule__DotDecimal__Group__0__Impl : ( ( rule__DotDecimal__Alternatives_0 )? ) ;
    public final void rule__DotDecimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3468:1: ( ( ( rule__DotDecimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3469:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3469:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3470:1: ( rule__DotDecimal__Alternatives_0 )?
            {
             before(grammarAccess.getDotDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3471:1: ( rule__DotDecimal__Alternatives_0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=16 && LA26_0<=17)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3471:2: rule__DotDecimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl6936);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3481:1: rule__DotDecimal__Group__1 : rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 ;
    public final void rule__DotDecimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3485:1: ( rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3486:2: rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__16967);
            rule__DotDecimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__16970);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3493:1: rule__DotDecimal__Group__1__Impl : ( '.' ) ;
    public final void rule__DotDecimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3497:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3498:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3498:1: ( '.' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3499:1: '.'
            {
             before(grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
            match(input,38,FOLLOW_38_in_rule__DotDecimal__Group__1__Impl6998); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3512:1: rule__DotDecimal__Group__2 : rule__DotDecimal__Group__2__Impl ;
    public final void rule__DotDecimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3516:1: ( rule__DotDecimal__Group__2__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3517:2: rule__DotDecimal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__27029);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3523:1: rule__DotDecimal__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DotDecimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3527:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3528:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3528:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3529:1: RULE_INT
            {
             before(grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl7056); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3546:1: rule__DecimalDot__Group__0 : rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 ;
    public final void rule__DecimalDot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3550:1: ( rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3551:2: rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__07091);
            rule__DecimalDot__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__07094);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3558:1: rule__DecimalDot__Group__0__Impl : ( ( rule__DecimalDot__Alternatives_0 )? ) ;
    public final void rule__DecimalDot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3562:1: ( ( ( rule__DecimalDot__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3563:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3563:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3564:1: ( rule__DecimalDot__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalDotAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3565:1: ( rule__DecimalDot__Alternatives_0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=16 && LA27_0<=17)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3565:2: rule__DecimalDot__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl7121);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3575:1: rule__DecimalDot__Group__1 : rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 ;
    public final void rule__DecimalDot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3579:1: ( rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3580:2: rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__17152);
            rule__DecimalDot__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__17155);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3587:1: rule__DecimalDot__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalDot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3591:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3592:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3592:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3593:1: RULE_INT
            {
             before(grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl7182); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3604:1: rule__DecimalDot__Group__2 : rule__DecimalDot__Group__2__Impl ;
    public final void rule__DecimalDot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3608:1: ( rule__DecimalDot__Group__2__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3609:2: rule__DecimalDot__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__27211);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3615:1: rule__DecimalDot__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalDot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3619:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3620:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3620:1: ( '.' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3621:1: '.'
            {
             before(grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 
            match(input,38,FOLLOW_38_in_rule__DecimalDot__Group__2__Impl7239); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3640:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3644:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3645:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__07276);
            rule__DecimalExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__07279);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3652:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3656:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3657:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3657:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3658:1: ( rule__DecimalExp__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3659:1: ( rule__DecimalExp__Alternatives_0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=16 && LA28_0<=17)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3659:2: rule__DecimalExp__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl7306);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3669:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3673:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3674:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__17337);
            rule__DecimalExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__17340);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3681:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3685:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3686:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3686:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3687:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl7367); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3698:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3702:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3703:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__27396);
            rule__DecimalExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__27399);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3710:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3714:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3715:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3715:1: ( '.' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3716:1: '.'
            {
             before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            match(input,38,FOLLOW_38_in_rule__DecimalExp__Group__2__Impl7427); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3729:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3733:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3734:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__37458);
            rule__DecimalExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__37461);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3741:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3745:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3746:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3746:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3747:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl7488); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3758:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3762:1: ( rule__DecimalExp__Group__4__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3763:2: rule__DecimalExp__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__47517);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3769:1: rule__DecimalExp__Group__4__Impl : ( RULE_EXP ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3773:1: ( ( RULE_EXP ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3774:1: ( RULE_EXP )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3774:1: ( RULE_EXP )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3775:1: RULE_EXP
            {
             before(grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 
            match(input,RULE_EXP,FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl7544); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3796:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3800:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3801:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__07583);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__07586);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3808:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3812:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3813:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3813:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3814:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl7613); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3825:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3829:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3830:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__17642);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3836:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3840:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3841:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3841:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3842:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3843:1: ( rule__FQN__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==38) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3843:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl7669);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3857:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3861:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3862:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__07704);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__07707);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3869:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3873:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3874:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3874:1: ( '.' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3875:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,38,FOLLOW_38_in_rule__FQN__Group_1__0__Impl7735); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3888:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3892:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3893:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__17766);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3899:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3903:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3904:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3904:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3905:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl7793); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3921:1: rule__MappingModel__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__MappingModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3925:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3926:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3926:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3927:1: ruleFQN
            {
             before(grammarAccess.getMappingModelAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__MappingModel__NameAssignment_17831);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3936:1: rule__MappingModel__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__MappingModel__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3940:1: ( ( ruleImport ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3941:1: ( ruleImport )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3941:1: ( ruleImport )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3942:1: ruleImport
            {
             before(grammarAccess.getMappingModelAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__MappingModel__ImportsAssignment_37862);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3951:1: rule__MappingModel__MappingsAssignment_4 : ( ruleMapping ) ;
    public final void rule__MappingModel__MappingsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3955:1: ( ( ruleMapping ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3956:1: ( ruleMapping )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3956:1: ( ruleMapping )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3957:1: ruleMapping
            {
             before(grammarAccess.getMappingModelAccess().getMappingsMappingParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleMapping_in_rule__MappingModel__MappingsAssignment_47893);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3966:1: rule__Mapping__LogicalSysAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__Mapping__LogicalSysAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3970:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3971:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3971:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3972:1: ( ruleFQN )
            {
             before(grammarAccess.getMappingAccess().getLogicalSysLogicalSystemCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3973:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3974:1: ruleFQN
            {
             before(grammarAccess.getMappingAccess().getLogicalSysLogicalSystemFQNParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__Mapping__LogicalSysAssignment_17928);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3985:1: rule__Mapping__PhysicalSysAssignment_3 : ( ( ruleFQN ) ) ;
    public final void rule__Mapping__PhysicalSysAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3989:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3990:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3990:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3991:1: ( ruleFQN )
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysPhysicalSystemCrossReference_3_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3992:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:3993:1: ruleFQN
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysPhysicalSystemFQNParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__Mapping__PhysicalSysAssignment_37967);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4004:1: rule__Mapping__SubsysMappingsAssignment_5 : ( ruleSubSystemMapping ) ;
    public final void rule__Mapping__SubsysMappingsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4008:1: ( ( ruleSubSystemMapping ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4009:1: ( ruleSubSystemMapping )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4009:1: ( ruleSubSystemMapping )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4010:1: ruleSubSystemMapping
            {
             before(grammarAccess.getMappingAccess().getSubsysMappingsSubSystemMappingParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSubSystemMapping_in_rule__Mapping__SubsysMappingsAssignment_58002);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4019:1: rule__SubSystemMapping__LogicalSubSysAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemMapping__LogicalSubSysAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4023:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4024:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4024:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4025:1: ( RULE_ID )
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4026:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4027:1: RULE_ID
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubSystemMapping__LogicalSubSysAssignment_18037); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4038:1: rule__SubSystemMapping__NodeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemMapping__NodeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4042:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4043:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4043:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4044:1: ( RULE_ID )
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeNodeRefCrossReference_3_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4045:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4046:1: RULE_ID
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeNodeRefIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubSystemMapping__NodeAssignment_38076); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4057:1: rule__SubSystemMapping__ThreadMappingsAssignment_4_1 : ( ruleThreadMapping ) ;
    public final void rule__SubSystemMapping__ThreadMappingsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4061:1: ( ( ruleThreadMapping ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4062:1: ( ruleThreadMapping )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4062:1: ( ruleThreadMapping )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4063:1: ruleThreadMapping
            {
             before(grammarAccess.getSubSystemMappingAccess().getThreadMappingsThreadMappingParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleThreadMapping_in_rule__SubSystemMapping__ThreadMappingsAssignment_4_18111);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4072:1: rule__ThreadMapping__LogicalThreadAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ThreadMapping__LogicalThreadAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4076:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4077:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4077:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4078:1: ( RULE_ID )
            {
             before(grammarAccess.getThreadMappingAccess().getLogicalThreadLogicalThreadCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4079:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4080:1: RULE_ID
            {
             before(grammarAccess.getThreadMappingAccess().getLogicalThreadLogicalThreadIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ThreadMapping__LogicalThreadAssignment_18146); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4091:1: rule__ThreadMapping__PhysicalThreadAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__ThreadMapping__PhysicalThreadAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4095:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4096:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4096:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4097:1: ( RULE_ID )
            {
             before(grammarAccess.getThreadMappingAccess().getPhysicalThreadPhysicalThreadCrossReference_3_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4098:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4099:1: RULE_ID
            {
             before(grammarAccess.getThreadMappingAccess().getPhysicalThreadPhysicalThreadIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ThreadMapping__PhysicalThreadAssignment_38185); 
             after(grammarAccess.getThreadMappingAccess().getPhysicalThreadPhysicalThreadIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getThreadMappingAccess().getPhysicalThreadPhysicalThreadCrossReference_3_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__KeyValue__KeyAssignment_0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4113:1: rule__KeyValue__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4117:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4118:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4118:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4119:1: RULE_ID
            {
             before(grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__KeyValue__KeyAssignment_08223); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4128:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4132:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4133:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4133:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4134:1: ruleLiteral
            {
             before(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__KeyValue__ValueAssignment_28254);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4149:1: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__SimpleAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4153:1: ( ( ( 'optional' ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4154:1: ( ( 'optional' ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4154:1: ( ( 'optional' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4155:1: ( 'optional' )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4156:1: ( 'optional' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4157:1: 'optional'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,39,FOLLOW_39_in_rule__SimpleAnnotationAttribute__OptionalAssignment_0_08296); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4172:1: rule__SimpleAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4176:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4177:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4177:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4178:1: RULE_ID
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleAnnotationAttribute__NameAssignment_28335); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4187:1: rule__SimpleAnnotationAttribute__TypeAssignment_4 : ( ruleLiteralType ) ;
    public final void rule__SimpleAnnotationAttribute__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4191:1: ( ( ruleLiteralType ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4192:1: ( ruleLiteralType )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4192:1: ( ruleLiteralType )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4193:1: ruleLiteralType
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleLiteralType_in_rule__SimpleAnnotationAttribute__TypeAssignment_48366);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4202:1: rule__EnumAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__EnumAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4206:1: ( ( ( 'optional' ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4207:1: ( ( 'optional' ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4207:1: ( ( 'optional' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4208:1: ( 'optional' )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4209:1: ( 'optional' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4210:1: 'optional'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,39,FOLLOW_39_in_rule__EnumAnnotationAttribute__OptionalAssignment_0_08402); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4225:1: rule__EnumAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EnumAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4229:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4230:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4230:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4231:1: RULE_ID
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EnumAnnotationAttribute__NameAssignment_28441); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4240:1: rule__EnumAnnotationAttribute__ValuesAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4244:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4245:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4245:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4246:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_58472); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4255:1: rule__EnumAnnotationAttribute__ValuesAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4259:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4260:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4260:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4261:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_6_18503); 
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


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1_0_0"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4270:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4274:1: ( ( ruleImportedFQN ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4275:1: ( ruleImportedFQN )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4275:1: ( ruleImportedFQN )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4276:1: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_08534);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4285:1: rule__Import__ImportURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4289:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4290:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4290:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4291:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_28565); 
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


    // $ANTLR start "rule__Documentation__LinesAssignment_2"
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4300:1: rule__Documentation__LinesAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Documentation__LinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4304:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4305:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4305:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4306:1: RULE_STRING
            {
             before(grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Documentation__LinesAssignment_28596); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4317:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4321:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4322:1: ( ( 'true' ) )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4322:1: ( ( 'true' ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4323:1: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4324:1: ( 'true' )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4325:1: 'true'
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            match(input,40,FOLLOW_40_in_rule__BooleanLiteral__IsTrueAssignment_1_18634); 
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4340:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4344:1: ( ( ruleReal ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4345:1: ( ruleReal )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4345:1: ( ruleReal )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4346:1: ruleReal
            {
             before(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_18673);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4355:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4359:1: ( ( ruleInteger ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4360:1: ( ruleInteger )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4360:1: ( ruleInteger )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4361:1: ruleInteger
            {
             before(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_18704);
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
    // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4370:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4374:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4375:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4375:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etmap.ui/src-gen/org/eclipse/etrice/core/etmap/ui/contentassist/antlr/internal/InternalETMap.g:4376:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_18735); 
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
        "\5\uffff\1\7\1\10\3\uffff";
    static final String DFA10_minS =
        "\3\6\1\46\1\uffff\1\6\1\7\3\uffff";
    static final String DFA10_maxS =
        "\4\46\1\uffff\1\6\1\7\3\uffff";
    static final String DFA10_acceptS =
        "\4\uffff\1\2\2\uffff\1\3\1\1\1\4";
    static final String DFA10_specialS =
        "\12\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\3\11\uffff\1\1\1\2\24\uffff\1\4",
            "\1\3\37\uffff\1\4",
            "\1\3\37\uffff\1\4",
            "\1\5",
            "",
            "\1\6",
            "\1\11",
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
            return "1109:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );";
        }
    }
 

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
    public static final BitSet FOLLOW_ruleKeyValue_in_entryRuleKeyValue303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValue310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__0_in_ruleKeyValue336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationTargetType372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotationTargetType398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute424 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationAttribute431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AnnotationAttribute__Alternatives_in_ruleAnnotationAttribute457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__0_in_ruleSimpleAnnotationAttribute517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute544 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__0_in_ruleEnumAnnotationAttribute577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport604 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0_in_ruleDocumentation757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral848 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral908 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral1028 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1088 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral1095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger1148 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integer__Alternatives_in_ruleInteger1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger1213 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal1282 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal1345 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Real__Alternatives_in_ruleReal1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal1410 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal1417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1479 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1548 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1617 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp1624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1681 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralType__Alternatives_in_ruleLiteralType1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__OptionalAssignment_0_0_in_rule__SimpleAnnotationAttribute__Alternatives_01836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__SimpleAnnotationAttribute__Alternatives_01855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__OptionalAssignment_0_0_in_rule__EnumAnnotationAttribute__Alternatives_01889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__EnumAnnotationAttribute__Alternatives_01908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_11942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Import__Alternatives_11961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__BooleanLiteral__Alternatives_12063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_12082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives2115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives2132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives2164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives2181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__SignedInteger__Alternatives_02214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__SignedInteger__Alternatives_02234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_rule__Real__Alternatives2268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives2319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Decimal__Alternatives_02352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Decimal__Alternatives_02372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DotDecimal__Alternatives_02407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DotDecimal__Alternatives_02427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalDot__Alternatives_02462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DecimalDot__Alternatives_02482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalExp__Alternatives_02517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DecimalExp__Alternatives_02537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__LiteralType__Alternatives2572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__LiteralType__Alternatives2593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__LiteralType__Alternatives2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__LiteralType__Alternatives2635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__0__Impl_in_rule__MappingModel__Group__02668 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__1_in_rule__MappingModel__Group__02671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__MappingModel__Group__0__Impl2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__1__Impl_in_rule__MappingModel__Group__12730 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__2_in_rule__MappingModel__Group__12733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__NameAssignment_1_in_rule__MappingModel__Group__1__Impl2760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__2__Impl_in_rule__MappingModel__Group__22790 = new BitSet(new long[]{0x0000000203000000L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__3_in_rule__MappingModel__Group__22793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MappingModel__Group__2__Impl2821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__3__Impl_in_rule__MappingModel__Group__32852 = new BitSet(new long[]{0x0000000203000000L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__4_in_rule__MappingModel__Group__32855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__ImportsAssignment_3_in_rule__MappingModel__Group__3__Impl2882 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__4__Impl_in_rule__MappingModel__Group__42913 = new BitSet(new long[]{0x0000000203000000L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__5_in_rule__MappingModel__Group__42916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MappingModel__MappingsAssignment_4_in_rule__MappingModel__Group__4__Impl2943 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__MappingModel__Group__5__Impl_in_rule__MappingModel__Group__52974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MappingModel__Group__5__Impl3002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__0__Impl_in_rule__Mapping__Group__03045 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Mapping__Group__1_in_rule__Mapping__Group__03048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Mapping__Group__0__Impl3076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__1__Impl_in_rule__Mapping__Group__13107 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Mapping__Group__2_in_rule__Mapping__Group__13110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__LogicalSysAssignment_1_in_rule__Mapping__Group__1__Impl3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__2__Impl_in_rule__Mapping__Group__23167 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Mapping__Group__3_in_rule__Mapping__Group__23170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Mapping__Group__2__Impl3198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__3__Impl_in_rule__Mapping__Group__33229 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Mapping__Group__4_in_rule__Mapping__Group__33232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__PhysicalSysAssignment_3_in_rule__Mapping__Group__3__Impl3259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__4__Impl_in_rule__Mapping__Group__43289 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_rule__Mapping__Group__5_in_rule__Mapping__Group__43292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Mapping__Group__4__Impl3320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__5__Impl_in_rule__Mapping__Group__53351 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_rule__Mapping__Group__6_in_rule__Mapping__Group__53354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mapping__SubsysMappingsAssignment_5_in_rule__Mapping__Group__5__Impl3381 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__Mapping__Group__6__Impl_in_rule__Mapping__Group__63412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Mapping__Group__6__Impl3440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__0__Impl_in_rule__SubSystemMapping__Group__03485 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__1_in_rule__SubSystemMapping__Group__03488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__SubSystemMapping__Group__0__Impl3516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__1__Impl_in_rule__SubSystemMapping__Group__13547 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__2_in_rule__SubSystemMapping__Group__13550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__LogicalSubSysAssignment_1_in_rule__SubSystemMapping__Group__1__Impl3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__2__Impl_in_rule__SubSystemMapping__Group__23607 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__3_in_rule__SubSystemMapping__Group__23610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SubSystemMapping__Group__2__Impl3638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__3__Impl_in_rule__SubSystemMapping__Group__33669 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__4_in_rule__SubSystemMapping__Group__33672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__NodeAssignment_3_in_rule__SubSystemMapping__Group__3__Impl3699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group__4__Impl_in_rule__SubSystemMapping__Group__43729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__0_in_rule__SubSystemMapping__Group__4__Impl3756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__0__Impl_in_rule__SubSystemMapping__Group_4__03797 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__1_in_rule__SubSystemMapping__Group_4__03800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SubSystemMapping__Group_4__0__Impl3828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__1__Impl_in_rule__SubSystemMapping__Group_4__13859 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__2_in_rule__SubSystemMapping__Group_4__13862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__ThreadMappingsAssignment_4_1_in_rule__SubSystemMapping__Group_4__1__Impl3889 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__SubSystemMapping__Group_4__2__Impl_in_rule__SubSystemMapping__Group_4__23920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__SubSystemMapping__Group_4__2__Impl3948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__0__Impl_in_rule__ThreadMapping__Group__03985 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__1_in_rule__ThreadMapping__Group__03988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ThreadMapping__Group__0__Impl4016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__1__Impl_in_rule__ThreadMapping__Group__14047 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__2_in_rule__ThreadMapping__Group__14050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadMapping__LogicalThreadAssignment_1_in_rule__ThreadMapping__Group__1__Impl4077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__2__Impl_in_rule__ThreadMapping__Group__24107 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__3_in_rule__ThreadMapping__Group__24110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ThreadMapping__Group__2__Impl4138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadMapping__Group__3__Impl_in_rule__ThreadMapping__Group__34169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadMapping__PhysicalThreadAssignment_3_in_rule__ThreadMapping__Group__3__Impl4196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__0__Impl_in_rule__KeyValue__Group__04237 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__1_in_rule__KeyValue__Group__04240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__KeyAssignment_0_in_rule__KeyValue__Group__0__Impl4267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__1__Impl_in_rule__KeyValue__Group__14297 = new BitSet(new long[]{0x0000014000038160L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__2_in_rule__KeyValue__Group__14300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__KeyValue__Group__1__Impl4328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__2__Impl_in_rule__KeyValue__Group__24359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__ValueAssignment_2_in_rule__KeyValue__Group__2__Impl4386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__0__Impl_in_rule__SimpleAnnotationAttribute__Group__04425 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__1_in_rule__SimpleAnnotationAttribute__Group__04428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Alternatives_0_in_rule__SimpleAnnotationAttribute__Group__0__Impl4455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__1__Impl_in_rule__SimpleAnnotationAttribute__Group__14485 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__2_in_rule__SimpleAnnotationAttribute__Group__14488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__SimpleAnnotationAttribute__Group__1__Impl4516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__2__Impl_in_rule__SimpleAnnotationAttribute__Group__24547 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__3_in_rule__SimpleAnnotationAttribute__Group__24550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__NameAssignment_2_in_rule__SimpleAnnotationAttribute__Group__2__Impl4577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__3__Impl_in_rule__SimpleAnnotationAttribute__Group__34607 = new BitSet(new long[]{0x00000000003C0000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__4_in_rule__SimpleAnnotationAttribute__Group__34610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__SimpleAnnotationAttribute__Group__3__Impl4638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__4__Impl_in_rule__SimpleAnnotationAttribute__Group__44669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__TypeAssignment_4_in_rule__SimpleAnnotationAttribute__Group__4__Impl4696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__0__Impl_in_rule__EnumAnnotationAttribute__Group__04736 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__1_in_rule__EnumAnnotationAttribute__Group__04739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Alternatives_0_in_rule__EnumAnnotationAttribute__Group__0__Impl4766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__1__Impl_in_rule__EnumAnnotationAttribute__Group__14796 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__2_in_rule__EnumAnnotationAttribute__Group__14799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EnumAnnotationAttribute__Group__1__Impl4827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__2__Impl_in_rule__EnumAnnotationAttribute__Group__24858 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__3_in_rule__EnumAnnotationAttribute__Group__24861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__NameAssignment_2_in_rule__EnumAnnotationAttribute__Group__2__Impl4888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__3__Impl_in_rule__EnumAnnotationAttribute__Group__34918 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__4_in_rule__EnumAnnotationAttribute__Group__34921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__EnumAnnotationAttribute__Group__3__Impl4949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__4__Impl_in_rule__EnumAnnotationAttribute__Group__44980 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__5_in_rule__EnumAnnotationAttribute__Group__44983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__EnumAnnotationAttribute__Group__4__Impl5011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__5__Impl_in_rule__EnumAnnotationAttribute__Group__55042 = new BitSet(new long[]{0x0000000101000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__6_in_rule__EnumAnnotationAttribute__Group__55045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_5_in_rule__EnumAnnotationAttribute__Group__5__Impl5072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__6__Impl_in_rule__EnumAnnotationAttribute__Group__65102 = new BitSet(new long[]{0x0000000101000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__7_in_rule__EnumAnnotationAttribute__Group__65105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__0_in_rule__EnumAnnotationAttribute__Group__6__Impl5132 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__7__Impl_in_rule__EnumAnnotationAttribute__Group__75163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__EnumAnnotationAttribute__Group__7__Impl5191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__0__Impl_in_rule__EnumAnnotationAttribute__Group_6__05238 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__1_in_rule__EnumAnnotationAttribute__Group_6__05241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__EnumAnnotationAttribute__Group_6__0__Impl5269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__1__Impl_in_rule__EnumAnnotationAttribute__Group_6__15300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_6_1_in_rule__EnumAnnotationAttribute__Group_6__1__Impl5327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__05361 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__05364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Import__Group__0__Impl5392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__15423 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Import__Group__2_in_rule__Import__Group__15426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl5453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__25483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl5510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__05546 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__05549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl5576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__15606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Import__Group_1_0__1__Impl5634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__05669 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__05672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl5699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__15728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ImportedFQN__Group__1__Impl5757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__05794 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__05797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__15855 = new BitSet(new long[]{0x0000002000000100L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__15858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Documentation__Group__1__Impl5886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__25917 = new BitSet(new long[]{0x0000002000000100L});
    public static final BitSet FOLLOW_rule__Documentation__Group__3_in_rule__Documentation__Group__25920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__LinesAssignment_2_in_rule__Documentation__Group__2__Impl5947 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_rule__Documentation__Group__3__Impl_in_rule__Documentation__Group__35978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Documentation__Group__3__Impl6006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__06051 = new BitSet(new long[]{0x0000010000008000L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__06054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__16112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl6139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__06173 = new BitSet(new long[]{0x0000004000030060L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__06176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__16234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl6261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__06295 = new BitSet(new long[]{0x0000000000030060L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__06298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__16356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl6383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__06417 = new BitSet(new long[]{0x0000014000038160L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__06420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__16478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl6505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__06539 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__06542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl6569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__16600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl6627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__06660 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__06663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl6690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__16721 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__16724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl6751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__26780 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__26783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Decimal__Group__2__Impl6811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__36842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl6869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__06906 = new BitSet(new long[]{0x0000004000030000L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__06909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl6936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__16967 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__16970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__DotDecimal__Group__1__Impl6998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__27029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl7056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__07091 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__07094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl7121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__17152 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__17155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl7182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__27211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__DecimalDot__Group__2__Impl7239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__07276 = new BitSet(new long[]{0x0000004000030060L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__07279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl7306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__17337 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__17340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl7367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__27396 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__27399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__DecimalExp__Group__2__Impl7427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__37458 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__37461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl7488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__47517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl7544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__07583 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__07586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl7613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__17642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl7669 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__07704 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__07707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__FQN__Group_1__0__Impl7735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__17766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl7793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__MappingModel__NameAssignment_17831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__MappingModel__ImportsAssignment_37862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_rule__MappingModel__MappingsAssignment_47893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Mapping__LogicalSysAssignment_17928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Mapping__PhysicalSysAssignment_37967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemMapping_in_rule__Mapping__SubsysMappingsAssignment_58002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubSystemMapping__LogicalSubSysAssignment_18037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubSystemMapping__NodeAssignment_38076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThreadMapping_in_rule__SubSystemMapping__ThreadMappingsAssignment_4_18111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ThreadMapping__LogicalThreadAssignment_18146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ThreadMapping__PhysicalThreadAssignment_38185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__KeyValue__KeyAssignment_08223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__KeyValue__ValueAssignment_28254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__SimpleAnnotationAttribute__OptionalAssignment_0_08296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleAnnotationAttribute__NameAssignment_28335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralType_in_rule__SimpleAnnotationAttribute__TypeAssignment_48366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__EnumAnnotationAttribute__OptionalAssignment_0_08402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EnumAnnotationAttribute__NameAssignment_28441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_58472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_6_18503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_08534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_28565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Documentation__LinesAssignment_28596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__BooleanLiteral__IsTrueAssignment_1_18634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_18673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_18704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_18735 = new BitSet(new long[]{0x0000000000000002L});

}