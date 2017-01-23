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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_HEX", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'mandatory'", "'model'", "'false'", "'+'", "'-'", "'e'", "'E'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'", "'MappingModel'", "'{'", "'}'", "'Mapping'", "'->'", "'SubSystemMapping'", "'ThreadMapping'", "'='", "'attribute'", "':'", "','", "'import'", "'from'", "'.*'", "'['", "']'", "'.'", "'optional'", "'true'"
    };
    public static final int RULE_HEX=5;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalETMapParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalETMapParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalETMapParser.tokenNames; }
    public String getGrammarFileName() { return "InternalETMap.g"; }


     
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
    // InternalETMap.g:60:1: entryRuleMappingModel : ruleMappingModel EOF ;
    public final void entryRuleMappingModel() throws RecognitionException {
        try {
            // InternalETMap.g:61:1: ( ruleMappingModel EOF )
            // InternalETMap.g:62:1: ruleMappingModel EOF
            {
             before(grammarAccess.getMappingModelRule()); 
            pushFollow(FOLLOW_1);
            ruleMappingModel();

            state._fsp--;

             after(grammarAccess.getMappingModelRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:69:1: ruleMappingModel : ( ( rule__MappingModel__Group__0 ) ) ;
    public final void ruleMappingModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:73:2: ( ( ( rule__MappingModel__Group__0 ) ) )
            // InternalETMap.g:74:1: ( ( rule__MappingModel__Group__0 ) )
            {
            // InternalETMap.g:74:1: ( ( rule__MappingModel__Group__0 ) )
            // InternalETMap.g:75:1: ( rule__MappingModel__Group__0 )
            {
             before(grammarAccess.getMappingModelAccess().getGroup()); 
            // InternalETMap.g:76:1: ( rule__MappingModel__Group__0 )
            // InternalETMap.g:76:2: rule__MappingModel__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:88:1: entryRuleMapping : ruleMapping EOF ;
    public final void entryRuleMapping() throws RecognitionException {
        try {
            // InternalETMap.g:89:1: ( ruleMapping EOF )
            // InternalETMap.g:90:1: ruleMapping EOF
            {
             before(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_1);
            ruleMapping();

            state._fsp--;

             after(grammarAccess.getMappingRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:97:1: ruleMapping : ( ( rule__Mapping__Group__0 ) ) ;
    public final void ruleMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:101:2: ( ( ( rule__Mapping__Group__0 ) ) )
            // InternalETMap.g:102:1: ( ( rule__Mapping__Group__0 ) )
            {
            // InternalETMap.g:102:1: ( ( rule__Mapping__Group__0 ) )
            // InternalETMap.g:103:1: ( rule__Mapping__Group__0 )
            {
             before(grammarAccess.getMappingAccess().getGroup()); 
            // InternalETMap.g:104:1: ( rule__Mapping__Group__0 )
            // InternalETMap.g:104:2: rule__Mapping__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:116:1: entryRuleSubSystemMapping : ruleSubSystemMapping EOF ;
    public final void entryRuleSubSystemMapping() throws RecognitionException {
        try {
            // InternalETMap.g:117:1: ( ruleSubSystemMapping EOF )
            // InternalETMap.g:118:1: ruleSubSystemMapping EOF
            {
             before(grammarAccess.getSubSystemMappingRule()); 
            pushFollow(FOLLOW_1);
            ruleSubSystemMapping();

            state._fsp--;

             after(grammarAccess.getSubSystemMappingRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:125:1: ruleSubSystemMapping : ( ( rule__SubSystemMapping__Group__0 ) ) ;
    public final void ruleSubSystemMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:129:2: ( ( ( rule__SubSystemMapping__Group__0 ) ) )
            // InternalETMap.g:130:1: ( ( rule__SubSystemMapping__Group__0 ) )
            {
            // InternalETMap.g:130:1: ( ( rule__SubSystemMapping__Group__0 ) )
            // InternalETMap.g:131:1: ( rule__SubSystemMapping__Group__0 )
            {
             before(grammarAccess.getSubSystemMappingAccess().getGroup()); 
            // InternalETMap.g:132:1: ( rule__SubSystemMapping__Group__0 )
            // InternalETMap.g:132:2: rule__SubSystemMapping__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:144:1: entryRuleThreadMapping : ruleThreadMapping EOF ;
    public final void entryRuleThreadMapping() throws RecognitionException {
        try {
            // InternalETMap.g:145:1: ( ruleThreadMapping EOF )
            // InternalETMap.g:146:1: ruleThreadMapping EOF
            {
             before(grammarAccess.getThreadMappingRule()); 
            pushFollow(FOLLOW_1);
            ruleThreadMapping();

            state._fsp--;

             after(grammarAccess.getThreadMappingRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:153:1: ruleThreadMapping : ( ( rule__ThreadMapping__Group__0 ) ) ;
    public final void ruleThreadMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:157:2: ( ( ( rule__ThreadMapping__Group__0 ) ) )
            // InternalETMap.g:158:1: ( ( rule__ThreadMapping__Group__0 ) )
            {
            // InternalETMap.g:158:1: ( ( rule__ThreadMapping__Group__0 ) )
            // InternalETMap.g:159:1: ( rule__ThreadMapping__Group__0 )
            {
             before(grammarAccess.getThreadMappingAccess().getGroup()); 
            // InternalETMap.g:160:1: ( rule__ThreadMapping__Group__0 )
            // InternalETMap.g:160:2: rule__ThreadMapping__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:174:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // InternalETMap.g:175:1: ( ruleKeyValue EOF )
            // InternalETMap.g:176:1: ruleKeyValue EOF
            {
             before(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_1);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getKeyValueRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:183:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:187:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // InternalETMap.g:188:1: ( ( rule__KeyValue__Group__0 ) )
            {
            // InternalETMap.g:188:1: ( ( rule__KeyValue__Group__0 ) )
            // InternalETMap.g:189:1: ( rule__KeyValue__Group__0 )
            {
             before(grammarAccess.getKeyValueAccess().getGroup()); 
            // InternalETMap.g:190:1: ( rule__KeyValue__Group__0 )
            // InternalETMap.g:190:2: rule__KeyValue__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:204:1: entryRuleAnnotationTargetType : ruleAnnotationTargetType EOF ;
    public final void entryRuleAnnotationTargetType() throws RecognitionException {
        try {
            // InternalETMap.g:205:1: ( ruleAnnotationTargetType EOF )
            // InternalETMap.g:206:1: ruleAnnotationTargetType EOF
            {
             before(grammarAccess.getAnnotationTargetTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleAnnotationTargetType();

            state._fsp--;

             after(grammarAccess.getAnnotationTargetTypeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:213:1: ruleAnnotationTargetType : ( RULE_ID ) ;
    public final void ruleAnnotationTargetType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:217:2: ( ( RULE_ID ) )
            // InternalETMap.g:218:1: ( RULE_ID )
            {
            // InternalETMap.g:218:1: ( RULE_ID )
            // InternalETMap.g:219:1: RULE_ID
            {
             before(grammarAccess.getAnnotationTargetTypeAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalETMap.g:232:1: entryRuleAnnotationAttribute : ruleAnnotationAttribute EOF ;
    public final void entryRuleAnnotationAttribute() throws RecognitionException {
        try {
            // InternalETMap.g:233:1: ( ruleAnnotationAttribute EOF )
            // InternalETMap.g:234:1: ruleAnnotationAttribute EOF
            {
             before(grammarAccess.getAnnotationAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:241:1: ruleAnnotationAttribute : ( ( rule__AnnotationAttribute__Alternatives ) ) ;
    public final void ruleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:245:2: ( ( ( rule__AnnotationAttribute__Alternatives ) ) )
            // InternalETMap.g:246:1: ( ( rule__AnnotationAttribute__Alternatives ) )
            {
            // InternalETMap.g:246:1: ( ( rule__AnnotationAttribute__Alternatives ) )
            // InternalETMap.g:247:1: ( rule__AnnotationAttribute__Alternatives )
            {
             before(grammarAccess.getAnnotationAttributeAccess().getAlternatives()); 
            // InternalETMap.g:248:1: ( rule__AnnotationAttribute__Alternatives )
            // InternalETMap.g:248:2: rule__AnnotationAttribute__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:260:1: entryRuleSimpleAnnotationAttribute : ruleSimpleAnnotationAttribute EOF ;
    public final void entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        try {
            // InternalETMap.g:261:1: ( ruleSimpleAnnotationAttribute EOF )
            // InternalETMap.g:262:1: ruleSimpleAnnotationAttribute EOF
            {
             before(grammarAccess.getSimpleAnnotationAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleSimpleAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getSimpleAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:269:1: ruleSimpleAnnotationAttribute : ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) ;
    public final void ruleSimpleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:273:2: ( ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) )
            // InternalETMap.g:274:1: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            {
            // InternalETMap.g:274:1: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            // InternalETMap.g:275:1: ( rule__SimpleAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup()); 
            // InternalETMap.g:276:1: ( rule__SimpleAnnotationAttribute__Group__0 )
            // InternalETMap.g:276:2: rule__SimpleAnnotationAttribute__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:288:1: entryRuleEnumAnnotationAttribute : ruleEnumAnnotationAttribute EOF ;
    public final void entryRuleEnumAnnotationAttribute() throws RecognitionException {
        try {
            // InternalETMap.g:289:1: ( ruleEnumAnnotationAttribute EOF )
            // InternalETMap.g:290:1: ruleEnumAnnotationAttribute EOF
            {
             before(grammarAccess.getEnumAnnotationAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getEnumAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:297:1: ruleEnumAnnotationAttribute : ( ( rule__EnumAnnotationAttribute__Group__0 ) ) ;
    public final void ruleEnumAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:301:2: ( ( ( rule__EnumAnnotationAttribute__Group__0 ) ) )
            // InternalETMap.g:302:1: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            {
            // InternalETMap.g:302:1: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            // InternalETMap.g:303:1: ( rule__EnumAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup()); 
            // InternalETMap.g:304:1: ( rule__EnumAnnotationAttribute__Group__0 )
            // InternalETMap.g:304:2: rule__EnumAnnotationAttribute__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:316:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalETMap.g:317:1: ( ruleImport EOF )
            // InternalETMap.g:318:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:325:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:329:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalETMap.g:330:1: ( ( rule__Import__Group__0 ) )
            {
            // InternalETMap.g:330:1: ( ( rule__Import__Group__0 ) )
            // InternalETMap.g:331:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalETMap.g:332:1: ( rule__Import__Group__0 )
            // InternalETMap.g:332:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:344:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // InternalETMap.g:345:1: ( ruleImportedFQN EOF )
            // InternalETMap.g:346:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_1);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:353:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:357:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // InternalETMap.g:358:1: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // InternalETMap.g:358:1: ( ( rule__ImportedFQN__Group__0 ) )
            // InternalETMap.g:359:1: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // InternalETMap.g:360:1: ( rule__ImportedFQN__Group__0 )
            // InternalETMap.g:360:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:372:1: entryRuleDocumentation : ruleDocumentation EOF ;
    public final void entryRuleDocumentation() throws RecognitionException {
        try {
            // InternalETMap.g:373:1: ( ruleDocumentation EOF )
            // InternalETMap.g:374:1: ruleDocumentation EOF
            {
             before(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_1);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getDocumentationRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:381:1: ruleDocumentation : ( ( rule__Documentation__Group__0 ) ) ;
    public final void ruleDocumentation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:385:2: ( ( ( rule__Documentation__Group__0 ) ) )
            // InternalETMap.g:386:1: ( ( rule__Documentation__Group__0 ) )
            {
            // InternalETMap.g:386:1: ( ( rule__Documentation__Group__0 ) )
            // InternalETMap.g:387:1: ( rule__Documentation__Group__0 )
            {
             before(grammarAccess.getDocumentationAccess().getGroup()); 
            // InternalETMap.g:388:1: ( rule__Documentation__Group__0 )
            // InternalETMap.g:388:2: rule__Documentation__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:404:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalETMap.g:405:1: ( ruleLiteral EOF )
            // InternalETMap.g:406:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:413:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:417:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalETMap.g:418:1: ( ( rule__Literal__Alternatives ) )
            {
            // InternalETMap.g:418:1: ( ( rule__Literal__Alternatives ) )
            // InternalETMap.g:419:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // InternalETMap.g:420:1: ( rule__Literal__Alternatives )
            // InternalETMap.g:420:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:432:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // InternalETMap.g:433:1: ( ruleBooleanLiteral EOF )
            // InternalETMap.g:434:1: ruleBooleanLiteral EOF
            {
             before(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanLiteral();

            state._fsp--;

             after(grammarAccess.getBooleanLiteralRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:441:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:445:2: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // InternalETMap.g:446:1: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // InternalETMap.g:446:1: ( ( rule__BooleanLiteral__Group__0 ) )
            // InternalETMap.g:447:1: ( rule__BooleanLiteral__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            // InternalETMap.g:448:1: ( rule__BooleanLiteral__Group__0 )
            // InternalETMap.g:448:2: rule__BooleanLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:460:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // InternalETMap.g:461:1: ( ruleNumberLiteral EOF )
            // InternalETMap.g:462:1: ruleNumberLiteral EOF
            {
             before(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleNumberLiteral();

            state._fsp--;

             after(grammarAccess.getNumberLiteralRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:469:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Alternatives ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:473:2: ( ( ( rule__NumberLiteral__Alternatives ) ) )
            // InternalETMap.g:474:1: ( ( rule__NumberLiteral__Alternatives ) )
            {
            // InternalETMap.g:474:1: ( ( rule__NumberLiteral__Alternatives ) )
            // InternalETMap.g:475:1: ( rule__NumberLiteral__Alternatives )
            {
             before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            // InternalETMap.g:476:1: ( rule__NumberLiteral__Alternatives )
            // InternalETMap.g:476:2: rule__NumberLiteral__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:488:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // InternalETMap.g:489:1: ( ruleRealLiteral EOF )
            // InternalETMap.g:490:1: ruleRealLiteral EOF
            {
             before(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleRealLiteral();

            state._fsp--;

             after(grammarAccess.getRealLiteralRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:497:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:501:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // InternalETMap.g:502:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // InternalETMap.g:502:1: ( ( rule__RealLiteral__Group__0 ) )
            // InternalETMap.g:503:1: ( rule__RealLiteral__Group__0 )
            {
             before(grammarAccess.getRealLiteralAccess().getGroup()); 
            // InternalETMap.g:504:1: ( rule__RealLiteral__Group__0 )
            // InternalETMap.g:504:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:516:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // InternalETMap.g:517:1: ( ruleIntLiteral EOF )
            // InternalETMap.g:518:1: ruleIntLiteral EOF
            {
             before(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleIntLiteral();

            state._fsp--;

             after(grammarAccess.getIntLiteralRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:525:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:529:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // InternalETMap.g:530:1: ( ( rule__IntLiteral__Group__0 ) )
            {
            // InternalETMap.g:530:1: ( ( rule__IntLiteral__Group__0 ) )
            // InternalETMap.g:531:1: ( rule__IntLiteral__Group__0 )
            {
             before(grammarAccess.getIntLiteralAccess().getGroup()); 
            // InternalETMap.g:532:1: ( rule__IntLiteral__Group__0 )
            // InternalETMap.g:532:2: rule__IntLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:544:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // InternalETMap.g:545:1: ( ruleStringLiteral EOF )
            // InternalETMap.g:546:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleStringLiteral();

            state._fsp--;

             after(grammarAccess.getStringLiteralRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:553:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:557:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // InternalETMap.g:558:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // InternalETMap.g:558:1: ( ( rule__StringLiteral__Group__0 ) )
            // InternalETMap.g:559:1: ( rule__StringLiteral__Group__0 )
            {
             before(grammarAccess.getStringLiteralAccess().getGroup()); 
            // InternalETMap.g:560:1: ( rule__StringLiteral__Group__0 )
            // InternalETMap.g:560:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:572:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // InternalETMap.g:573:1: ( ruleInteger EOF )
            // InternalETMap.g:574:1: ruleInteger EOF
            {
             before(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_1);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getIntegerRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:581:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:585:2: ( ( ( rule__Integer__Alternatives ) ) )
            // InternalETMap.g:586:1: ( ( rule__Integer__Alternatives ) )
            {
            // InternalETMap.g:586:1: ( ( rule__Integer__Alternatives ) )
            // InternalETMap.g:587:1: ( rule__Integer__Alternatives )
            {
             before(grammarAccess.getIntegerAccess().getAlternatives()); 
            // InternalETMap.g:588:1: ( rule__Integer__Alternatives )
            // InternalETMap.g:588:2: rule__Integer__Alternatives
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleReal"
    // InternalETMap.g:600:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // InternalETMap.g:601:1: ( ruleReal EOF )
            // InternalETMap.g:602:1: ruleReal EOF
            {
             before(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_1);
            ruleReal();

            state._fsp--;

             after(grammarAccess.getRealRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:609:1: ruleReal : ( ( rule__Real__Alternatives ) ) ;
    public final void ruleReal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:613:2: ( ( ( rule__Real__Alternatives ) ) )
            // InternalETMap.g:614:1: ( ( rule__Real__Alternatives ) )
            {
            // InternalETMap.g:614:1: ( ( rule__Real__Alternatives ) )
            // InternalETMap.g:615:1: ( rule__Real__Alternatives )
            {
             before(grammarAccess.getRealAccess().getAlternatives()); 
            // InternalETMap.g:616:1: ( rule__Real__Alternatives )
            // InternalETMap.g:616:2: rule__Real__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:628:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalETMap.g:632:1: ( ruleDecimal EOF )
            // InternalETMap.g:633:1: ruleDecimal EOF
            {
             before(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_1);
            ruleDecimal();

            state._fsp--;

             after(grammarAccess.getDecimalRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:643:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:648:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // InternalETMap.g:649:1: ( ( rule__Decimal__Group__0 ) )
            {
            // InternalETMap.g:649:1: ( ( rule__Decimal__Group__0 ) )
            // InternalETMap.g:650:1: ( rule__Decimal__Group__0 )
            {
             before(grammarAccess.getDecimalAccess().getGroup()); 
            // InternalETMap.g:651:1: ( rule__Decimal__Group__0 )
            // InternalETMap.g:651:2: rule__Decimal__Group__0
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleDecimalExp"
    // InternalETMap.g:664:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalETMap.g:668:1: ( ruleDecimalExp EOF )
            // InternalETMap.g:669:1: ruleDecimalExp EOF
            {
             before(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_1);
            ruleDecimalExp();

            state._fsp--;

             after(grammarAccess.getDecimalExpRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:679:1: ruleDecimalExp : ( ( rule__DecimalExp__Group__0 ) ) ;
    public final void ruleDecimalExp() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:684:2: ( ( ( rule__DecimalExp__Group__0 ) ) )
            // InternalETMap.g:685:1: ( ( rule__DecimalExp__Group__0 ) )
            {
            // InternalETMap.g:685:1: ( ( rule__DecimalExp__Group__0 ) )
            // InternalETMap.g:686:1: ( rule__DecimalExp__Group__0 )
            {
             before(grammarAccess.getDecimalExpAccess().getGroup()); 
            // InternalETMap.g:687:1: ( rule__DecimalExp__Group__0 )
            // InternalETMap.g:687:2: rule__DecimalExp__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:700:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalETMap.g:701:1: ( ruleFQN EOF )
            // InternalETMap.g:702:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalETMap.g:709:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:713:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalETMap.g:714:1: ( ( rule__FQN__Group__0 ) )
            {
            // InternalETMap.g:714:1: ( ( rule__FQN__Group__0 ) )
            // InternalETMap.g:715:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalETMap.g:716:1: ( rule__FQN__Group__0 )
            // InternalETMap.g:716:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:729:1: ruleLiteralType : ( ( rule__LiteralType__Alternatives ) ) ;
    public final void ruleLiteralType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:733:1: ( ( ( rule__LiteralType__Alternatives ) ) )
            // InternalETMap.g:734:1: ( ( rule__LiteralType__Alternatives ) )
            {
            // InternalETMap.g:734:1: ( ( rule__LiteralType__Alternatives ) )
            // InternalETMap.g:735:1: ( rule__LiteralType__Alternatives )
            {
             before(grammarAccess.getLiteralTypeAccess().getAlternatives()); 
            // InternalETMap.g:736:1: ( rule__LiteralType__Alternatives )
            // InternalETMap.g:736:2: rule__LiteralType__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:748:1: rule__AnnotationAttribute__Alternatives : ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) );
    public final void rule__AnnotationAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:752:1: ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==40) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==31) ) {
                    int LA1_3 = input.LA(3);

                    if ( (LA1_3==RULE_ID) ) {
                        int LA1_4 = input.LA(4);

                        if ( (LA1_4==32) ) {
                            int LA1_5 = input.LA(5);

                            if ( (LA1_5==24) ) {
                                alt1=2;
                            }
                            else if ( ((LA1_5>=19 && LA1_5<=22)) ) {
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
            else if ( (LA1_0==12) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==31) ) {
                    int LA1_3 = input.LA(3);

                    if ( (LA1_3==RULE_ID) ) {
                        int LA1_4 = input.LA(4);

                        if ( (LA1_4==32) ) {
                            int LA1_5 = input.LA(5);

                            if ( (LA1_5==24) ) {
                                alt1=2;
                            }
                            else if ( ((LA1_5>=19 && LA1_5<=22)) ) {
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
                    // InternalETMap.g:753:1: ( ruleSimpleAnnotationAttribute )
                    {
                    // InternalETMap.g:753:1: ( ruleSimpleAnnotationAttribute )
                    // InternalETMap.g:754:1: ruleSimpleAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleSimpleAnnotationAttribute();

                    state._fsp--;

                     after(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:759:6: ( ruleEnumAnnotationAttribute )
                    {
                    // InternalETMap.g:759:6: ( ruleEnumAnnotationAttribute )
                    // InternalETMap.g:760:1: ruleEnumAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
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
    // InternalETMap.g:770:1: rule__SimpleAnnotationAttribute__Alternatives_0 : ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__SimpleAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:774:1: ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==40) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalETMap.g:775:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // InternalETMap.g:775:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // InternalETMap.g:776:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // InternalETMap.g:777:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    // InternalETMap.g:777:2: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:781:6: ( 'mandatory' )
                    {
                    // InternalETMap.g:781:6: ( 'mandatory' )
                    // InternalETMap.g:782:1: 'mandatory'
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,12,FOLLOW_2); 
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
    // InternalETMap.g:794:1: rule__EnumAnnotationAttribute__Alternatives_0 : ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__EnumAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:798:1: ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==40) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalETMap.g:799:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // InternalETMap.g:799:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // InternalETMap.g:800:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // InternalETMap.g:801:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    // InternalETMap.g:801:2: rule__EnumAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EnumAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:805:6: ( 'mandatory' )
                    {
                    // InternalETMap.g:805:6: ( 'mandatory' )
                    // InternalETMap.g:806:1: 'mandatory'
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,12,FOLLOW_2); 
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
    // InternalETMap.g:818:1: rule__Import__Alternatives_1 : ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) );
    public final void rule__Import__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:822:1: ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
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
                    // InternalETMap.g:823:1: ( ( rule__Import__Group_1_0__0 ) )
                    {
                    // InternalETMap.g:823:1: ( ( rule__Import__Group_1_0__0 ) )
                    // InternalETMap.g:824:1: ( rule__Import__Group_1_0__0 )
                    {
                     before(grammarAccess.getImportAccess().getGroup_1_0()); 
                    // InternalETMap.g:825:1: ( rule__Import__Group_1_0__0 )
                    // InternalETMap.g:825:2: rule__Import__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Import__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getImportAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:829:6: ( 'model' )
                    {
                    // InternalETMap.g:829:6: ( 'model' )
                    // InternalETMap.g:830:1: 'model'
                    {
                     before(grammarAccess.getImportAccess().getModelKeyword_1_1()); 
                    match(input,13,FOLLOW_2); 
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
    // InternalETMap.g:843:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:847:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 14:
            case 41:
                {
                alt5=1;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case 15:
            case 16:
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
                    // InternalETMap.g:848:1: ( ruleBooleanLiteral )
                    {
                    // InternalETMap.g:848:1: ( ruleBooleanLiteral )
                    // InternalETMap.g:849:1: ruleBooleanLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleBooleanLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:854:6: ( ruleNumberLiteral )
                    {
                    // InternalETMap.g:854:6: ( ruleNumberLiteral )
                    // InternalETMap.g:855:1: ruleNumberLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleNumberLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalETMap.g:860:6: ( ruleStringLiteral )
                    {
                    // InternalETMap.g:860:6: ( ruleStringLiteral )
                    // InternalETMap.g:861:1: ruleStringLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
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
    // InternalETMap.g:871:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:875:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            else if ( (LA6_0==41) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalETMap.g:876:1: ( 'false' )
                    {
                    // InternalETMap.g:876:1: ( 'false' )
                    // InternalETMap.g:877:1: 'false'
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:884:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // InternalETMap.g:884:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // InternalETMap.g:885:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    // InternalETMap.g:886:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // InternalETMap.g:886:2: rule__BooleanLiteral__IsTrueAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalETMap.g:895:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:899:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
            int alt7=2;
            switch ( input.LA(1) ) {
            case 15:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_INT) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==EOF) ) {
                        alt7=1;
                    }
                    else if ( (LA7_3==39) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
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

                if ( (LA7_2==RULE_INT) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==EOF) ) {
                        alt7=1;
                    }
                    else if ( (LA7_3==39) ) {
                        alt7=2;
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

                if ( (LA7_3==EOF) ) {
                    alt7=1;
                }
                else if ( (LA7_3==39) ) {
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalETMap.g:900:1: ( ruleIntLiteral )
                    {
                    // InternalETMap.g:900:1: ( ruleIntLiteral )
                    // InternalETMap.g:901:1: ruleIntLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleIntLiteral();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:906:6: ( ruleRealLiteral )
                    {
                    // InternalETMap.g:906:6: ( ruleRealLiteral )
                    // InternalETMap.g:907:1: ruleRealLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
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
    // InternalETMap.g:917:1: rule__Integer__Alternatives : ( ( ( rule__Integer__Group_0__0 ) ) | ( RULE_HEX ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:921:1: ( ( ( rule__Integer__Group_0__0 ) ) | ( RULE_HEX ) )
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
                    // InternalETMap.g:922:1: ( ( rule__Integer__Group_0__0 ) )
                    {
                    // InternalETMap.g:922:1: ( ( rule__Integer__Group_0__0 ) )
                    // InternalETMap.g:923:1: ( rule__Integer__Group_0__0 )
                    {
                     before(grammarAccess.getIntegerAccess().getGroup_0()); 
                    // InternalETMap.g:924:1: ( rule__Integer__Group_0__0 )
                    // InternalETMap.g:924:2: rule__Integer__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Integer__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIntegerAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:928:6: ( RULE_HEX )
                    {
                    // InternalETMap.g:928:6: ( RULE_HEX )
                    // InternalETMap.g:929:1: RULE_HEX
                    {
                     before(grammarAccess.getIntegerAccess().getHEXTerminalRuleCall_1()); 
                    match(input,RULE_HEX,FOLLOW_2); 
                     after(grammarAccess.getIntegerAccess().getHEXTerminalRuleCall_1()); 

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
    // InternalETMap.g:939:1: rule__Integer__Alternatives_0_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Integer__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:943:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalETMap.g:944:1: ( '+' )
                    {
                    // InternalETMap.g:944:1: ( '+' )
                    // InternalETMap.g:945:1: '+'
                    {
                     before(grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:952:6: ( '-' )
                    {
                    // InternalETMap.g:952:6: ( '-' )
                    // InternalETMap.g:953:1: '-'
                    {
                     before(grammarAccess.getIntegerAccess().getHyphenMinusKeyword_0_0_1()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getIntegerAccess().getHyphenMinusKeyword_0_0_1()); 

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
    // InternalETMap.g:965:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:969:1: ( ( ruleDecimal ) | ( ruleDecimalExp ) )
            int alt10=2;
            switch ( input.LA(1) ) {
            case 15:
                {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==RULE_INT) ) {
                    int LA10_3 = input.LA(3);

                    if ( (LA10_3==39) ) {
                        int LA10_4 = input.LA(4);

                        if ( (LA10_4==RULE_INT) ) {
                            int LA10_5 = input.LA(5);

                            if ( ((LA10_5>=17 && LA10_5<=18)) ) {
                                alt10=2;
                            }
                            else if ( (LA10_5==EOF) ) {
                                alt10=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 10, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 10, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA10_2 = input.LA(2);

                if ( (LA10_2==RULE_INT) ) {
                    int LA10_3 = input.LA(3);

                    if ( (LA10_3==39) ) {
                        int LA10_4 = input.LA(4);

                        if ( (LA10_4==RULE_INT) ) {
                            int LA10_5 = input.LA(5);

                            if ( ((LA10_5>=17 && LA10_5<=18)) ) {
                                alt10=2;
                            }
                            else if ( (LA10_5==EOF) ) {
                                alt10=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 10, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 10, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA10_3 = input.LA(2);

                if ( (LA10_3==39) ) {
                    int LA10_4 = input.LA(3);

                    if ( (LA10_4==RULE_INT) ) {
                        int LA10_5 = input.LA(4);

                        if ( ((LA10_5>=17 && LA10_5<=18)) ) {
                            alt10=2;
                        }
                        else if ( (LA10_5==EOF) ) {
                            alt10=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 10, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalETMap.g:970:1: ( ruleDecimal )
                    {
                    // InternalETMap.g:970:1: ( ruleDecimal )
                    // InternalETMap.g:971:1: ruleDecimal
                    {
                     before(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:976:6: ( ruleDecimalExp )
                    {
                    // InternalETMap.g:976:6: ( ruleDecimalExp )
                    // InternalETMap.g:977:1: ruleDecimalExp
                    {
                     before(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleDecimalExp();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_1()); 

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
    // InternalETMap.g:987:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:991:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalETMap.g:992:1: ( '+' )
                    {
                    // InternalETMap.g:992:1: ( '+' )
                    // InternalETMap.g:993:1: '+'
                    {
                     before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:1000:6: ( '-' )
                    {
                    // InternalETMap.g:1000:6: ( '-' )
                    // InternalETMap.g:1001:1: '-'
                    {
                     before(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_2); 
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


    // $ANTLR start "rule__DecimalExp__Alternatives_0"
    // InternalETMap.g:1013:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1017:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalETMap.g:1018:1: ( '+' )
                    {
                    // InternalETMap.g:1018:1: ( '+' )
                    // InternalETMap.g:1019:1: '+'
                    {
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:1026:6: ( '-' )
                    {
                    // InternalETMap.g:1026:6: ( '-' )
                    // InternalETMap.g:1027:1: '-'
                    {
                     before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_2); 
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


    // $ANTLR start "rule__DecimalExp__Alternatives_4"
    // InternalETMap.g:1039:1: rule__DecimalExp__Alternatives_4 : ( ( 'e' ) | ( 'E' ) );
    public final void rule__DecimalExp__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1043:1: ( ( 'e' ) | ( 'E' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) ) {
                alt13=1;
            }
            else if ( (LA13_0==18) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalETMap.g:1044:1: ( 'e' )
                    {
                    // InternalETMap.g:1044:1: ( 'e' )
                    // InternalETMap.g:1045:1: 'e'
                    {
                     before(grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:1052:6: ( 'E' )
                    {
                    // InternalETMap.g:1052:6: ( 'E' )
                    // InternalETMap.g:1053:1: 'E'
                    {
                     before(grammarAccess.getDecimalExpAccess().getEKeyword_4_1()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getDecimalExpAccess().getEKeyword_4_1()); 

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
    // InternalETMap.g:1065:1: rule__DecimalExp__Alternatives_5 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1069:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalETMap.g:1070:1: ( '+' )
                    {
                    // InternalETMap.g:1070:1: ( '+' )
                    // InternalETMap.g:1071:1: '+'
                    {
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:1078:6: ( '-' )
                    {
                    // InternalETMap.g:1078:6: ( '-' )
                    // InternalETMap.g:1079:1: '-'
                    {
                     before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_5_1()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_5_1()); 

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
    // InternalETMap.g:1091:1: rule__LiteralType__Alternatives : ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) );
    public final void rule__LiteralType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1095:1: ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt15=1;
                }
                break;
            case 20:
                {
                alt15=2;
                }
                break;
            case 21:
                {
                alt15=3;
                }
                break;
            case 22:
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
                    // InternalETMap.g:1096:1: ( ( 'ptBoolean' ) )
                    {
                    // InternalETMap.g:1096:1: ( ( 'ptBoolean' ) )
                    // InternalETMap.g:1097:1: ( 'ptBoolean' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                    // InternalETMap.g:1098:1: ( 'ptBoolean' )
                    // InternalETMap.g:1098:3: 'ptBoolean'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:1103:6: ( ( 'ptInteger' ) )
                    {
                    // InternalETMap.g:1103:6: ( ( 'ptInteger' ) )
                    // InternalETMap.g:1104:1: ( 'ptInteger' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                    // InternalETMap.g:1105:1: ( 'ptInteger' )
                    // InternalETMap.g:1105:3: 'ptInteger'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalETMap.g:1110:6: ( ( 'ptReal' ) )
                    {
                    // InternalETMap.g:1110:6: ( ( 'ptReal' ) )
                    // InternalETMap.g:1111:1: ( 'ptReal' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                    // InternalETMap.g:1112:1: ( 'ptReal' )
                    // InternalETMap.g:1112:3: 'ptReal'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalETMap.g:1117:6: ( ( 'ptCharacter' ) )
                    {
                    // InternalETMap.g:1117:6: ( ( 'ptCharacter' ) )
                    // InternalETMap.g:1118:1: ( 'ptCharacter' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 
                    // InternalETMap.g:1119:1: ( 'ptCharacter' )
                    // InternalETMap.g:1119:3: 'ptCharacter'
                    {
                    match(input,22,FOLLOW_2); 

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
    // InternalETMap.g:1131:1: rule__MappingModel__Group__0 : rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1 ;
    public final void rule__MappingModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1135:1: ( rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1 )
            // InternalETMap.g:1136:2: rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__MappingModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1143:1: rule__MappingModel__Group__0__Impl : ( 'MappingModel' ) ;
    public final void rule__MappingModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1147:1: ( ( 'MappingModel' ) )
            // InternalETMap.g:1148:1: ( 'MappingModel' )
            {
            // InternalETMap.g:1148:1: ( 'MappingModel' )
            // InternalETMap.g:1149:1: 'MappingModel'
            {
             before(grammarAccess.getMappingModelAccess().getMappingModelKeyword_0()); 
            match(input,23,FOLLOW_2); 
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
    // InternalETMap.g:1162:1: rule__MappingModel__Group__1 : rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2 ;
    public final void rule__MappingModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1166:1: ( rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2 )
            // InternalETMap.g:1167:2: rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__MappingModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1174:1: rule__MappingModel__Group__1__Impl : ( ( rule__MappingModel__NameAssignment_1 ) ) ;
    public final void rule__MappingModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1178:1: ( ( ( rule__MappingModel__NameAssignment_1 ) ) )
            // InternalETMap.g:1179:1: ( ( rule__MappingModel__NameAssignment_1 ) )
            {
            // InternalETMap.g:1179:1: ( ( rule__MappingModel__NameAssignment_1 ) )
            // InternalETMap.g:1180:1: ( rule__MappingModel__NameAssignment_1 )
            {
             before(grammarAccess.getMappingModelAccess().getNameAssignment_1()); 
            // InternalETMap.g:1181:1: ( rule__MappingModel__NameAssignment_1 )
            // InternalETMap.g:1181:2: rule__MappingModel__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1191:1: rule__MappingModel__Group__2 : rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3 ;
    public final void rule__MappingModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1195:1: ( rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3 )
            // InternalETMap.g:1196:2: rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__MappingModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1203:1: rule__MappingModel__Group__2__Impl : ( '{' ) ;
    public final void rule__MappingModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1207:1: ( ( '{' ) )
            // InternalETMap.g:1208:1: ( '{' )
            {
            // InternalETMap.g:1208:1: ( '{' )
            // InternalETMap.g:1209:1: '{'
            {
             before(grammarAccess.getMappingModelAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,24,FOLLOW_2); 
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
    // InternalETMap.g:1222:1: rule__MappingModel__Group__3 : rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4 ;
    public final void rule__MappingModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1226:1: ( rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4 )
            // InternalETMap.g:1227:2: rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__MappingModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1234:1: rule__MappingModel__Group__3__Impl : ( ( rule__MappingModel__ImportsAssignment_3 )* ) ;
    public final void rule__MappingModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1238:1: ( ( ( rule__MappingModel__ImportsAssignment_3 )* ) )
            // InternalETMap.g:1239:1: ( ( rule__MappingModel__ImportsAssignment_3 )* )
            {
            // InternalETMap.g:1239:1: ( ( rule__MappingModel__ImportsAssignment_3 )* )
            // InternalETMap.g:1240:1: ( rule__MappingModel__ImportsAssignment_3 )*
            {
             before(grammarAccess.getMappingModelAccess().getImportsAssignment_3()); 
            // InternalETMap.g:1241:1: ( rule__MappingModel__ImportsAssignment_3 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==34) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalETMap.g:1241:2: rule__MappingModel__ImportsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
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
    // InternalETMap.g:1251:1: rule__MappingModel__Group__4 : rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5 ;
    public final void rule__MappingModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1255:1: ( rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5 )
            // InternalETMap.g:1256:2: rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5
            {
            pushFollow(FOLLOW_5);
            rule__MappingModel__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1263:1: rule__MappingModel__Group__4__Impl : ( ( rule__MappingModel__MappingsAssignment_4 )* ) ;
    public final void rule__MappingModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1267:1: ( ( ( rule__MappingModel__MappingsAssignment_4 )* ) )
            // InternalETMap.g:1268:1: ( ( rule__MappingModel__MappingsAssignment_4 )* )
            {
            // InternalETMap.g:1268:1: ( ( rule__MappingModel__MappingsAssignment_4 )* )
            // InternalETMap.g:1269:1: ( rule__MappingModel__MappingsAssignment_4 )*
            {
             before(grammarAccess.getMappingModelAccess().getMappingsAssignment_4()); 
            // InternalETMap.g:1270:1: ( rule__MappingModel__MappingsAssignment_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==26) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalETMap.g:1270:2: rule__MappingModel__MappingsAssignment_4
            	    {
            	    pushFollow(FOLLOW_7);
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
    // InternalETMap.g:1280:1: rule__MappingModel__Group__5 : rule__MappingModel__Group__5__Impl ;
    public final void rule__MappingModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1284:1: ( rule__MappingModel__Group__5__Impl )
            // InternalETMap.g:1285:2: rule__MappingModel__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1291:1: rule__MappingModel__Group__5__Impl : ( '}' ) ;
    public final void rule__MappingModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1295:1: ( ( '}' ) )
            // InternalETMap.g:1296:1: ( '}' )
            {
            // InternalETMap.g:1296:1: ( '}' )
            // InternalETMap.g:1297:1: '}'
            {
             before(grammarAccess.getMappingModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,25,FOLLOW_2); 
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
    // InternalETMap.g:1322:1: rule__Mapping__Group__0 : rule__Mapping__Group__0__Impl rule__Mapping__Group__1 ;
    public final void rule__Mapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1326:1: ( rule__Mapping__Group__0__Impl rule__Mapping__Group__1 )
            // InternalETMap.g:1327:2: rule__Mapping__Group__0__Impl rule__Mapping__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Mapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1334:1: rule__Mapping__Group__0__Impl : ( 'Mapping' ) ;
    public final void rule__Mapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1338:1: ( ( 'Mapping' ) )
            // InternalETMap.g:1339:1: ( 'Mapping' )
            {
            // InternalETMap.g:1339:1: ( 'Mapping' )
            // InternalETMap.g:1340:1: 'Mapping'
            {
             before(grammarAccess.getMappingAccess().getMappingKeyword_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalETMap.g:1353:1: rule__Mapping__Group__1 : rule__Mapping__Group__1__Impl rule__Mapping__Group__2 ;
    public final void rule__Mapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1357:1: ( rule__Mapping__Group__1__Impl rule__Mapping__Group__2 )
            // InternalETMap.g:1358:2: rule__Mapping__Group__1__Impl rule__Mapping__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Mapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1365:1: rule__Mapping__Group__1__Impl : ( ( rule__Mapping__LogicalSysAssignment_1 ) ) ;
    public final void rule__Mapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1369:1: ( ( ( rule__Mapping__LogicalSysAssignment_1 ) ) )
            // InternalETMap.g:1370:1: ( ( rule__Mapping__LogicalSysAssignment_1 ) )
            {
            // InternalETMap.g:1370:1: ( ( rule__Mapping__LogicalSysAssignment_1 ) )
            // InternalETMap.g:1371:1: ( rule__Mapping__LogicalSysAssignment_1 )
            {
             before(grammarAccess.getMappingAccess().getLogicalSysAssignment_1()); 
            // InternalETMap.g:1372:1: ( rule__Mapping__LogicalSysAssignment_1 )
            // InternalETMap.g:1372:2: rule__Mapping__LogicalSysAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1382:1: rule__Mapping__Group__2 : rule__Mapping__Group__2__Impl rule__Mapping__Group__3 ;
    public final void rule__Mapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1386:1: ( rule__Mapping__Group__2__Impl rule__Mapping__Group__3 )
            // InternalETMap.g:1387:2: rule__Mapping__Group__2__Impl rule__Mapping__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__Mapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1394:1: rule__Mapping__Group__2__Impl : ( '->' ) ;
    public final void rule__Mapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1398:1: ( ( '->' ) )
            // InternalETMap.g:1399:1: ( '->' )
            {
            // InternalETMap.g:1399:1: ( '->' )
            // InternalETMap.g:1400:1: '->'
            {
             before(grammarAccess.getMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,27,FOLLOW_2); 
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
    // InternalETMap.g:1413:1: rule__Mapping__Group__3 : rule__Mapping__Group__3__Impl rule__Mapping__Group__4 ;
    public final void rule__Mapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1417:1: ( rule__Mapping__Group__3__Impl rule__Mapping__Group__4 )
            // InternalETMap.g:1418:2: rule__Mapping__Group__3__Impl rule__Mapping__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__Mapping__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1425:1: rule__Mapping__Group__3__Impl : ( ( rule__Mapping__PhysicalSysAssignment_3 ) ) ;
    public final void rule__Mapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1429:1: ( ( ( rule__Mapping__PhysicalSysAssignment_3 ) ) )
            // InternalETMap.g:1430:1: ( ( rule__Mapping__PhysicalSysAssignment_3 ) )
            {
            // InternalETMap.g:1430:1: ( ( rule__Mapping__PhysicalSysAssignment_3 ) )
            // InternalETMap.g:1431:1: ( rule__Mapping__PhysicalSysAssignment_3 )
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysAssignment_3()); 
            // InternalETMap.g:1432:1: ( rule__Mapping__PhysicalSysAssignment_3 )
            // InternalETMap.g:1432:2: rule__Mapping__PhysicalSysAssignment_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1442:1: rule__Mapping__Group__4 : rule__Mapping__Group__4__Impl rule__Mapping__Group__5 ;
    public final void rule__Mapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1446:1: ( rule__Mapping__Group__4__Impl rule__Mapping__Group__5 )
            // InternalETMap.g:1447:2: rule__Mapping__Group__4__Impl rule__Mapping__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__Mapping__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1454:1: rule__Mapping__Group__4__Impl : ( '{' ) ;
    public final void rule__Mapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1458:1: ( ( '{' ) )
            // InternalETMap.g:1459:1: ( '{' )
            {
            // InternalETMap.g:1459:1: ( '{' )
            // InternalETMap.g:1460:1: '{'
            {
             before(grammarAccess.getMappingAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,24,FOLLOW_2); 
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
    // InternalETMap.g:1473:1: rule__Mapping__Group__5 : rule__Mapping__Group__5__Impl rule__Mapping__Group__6 ;
    public final void rule__Mapping__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1477:1: ( rule__Mapping__Group__5__Impl rule__Mapping__Group__6 )
            // InternalETMap.g:1478:2: rule__Mapping__Group__5__Impl rule__Mapping__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__Mapping__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1485:1: rule__Mapping__Group__5__Impl : ( ( rule__Mapping__SubsysMappingsAssignment_5 )* ) ;
    public final void rule__Mapping__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1489:1: ( ( ( rule__Mapping__SubsysMappingsAssignment_5 )* ) )
            // InternalETMap.g:1490:1: ( ( rule__Mapping__SubsysMappingsAssignment_5 )* )
            {
            // InternalETMap.g:1490:1: ( ( rule__Mapping__SubsysMappingsAssignment_5 )* )
            // InternalETMap.g:1491:1: ( rule__Mapping__SubsysMappingsAssignment_5 )*
            {
             before(grammarAccess.getMappingAccess().getSubsysMappingsAssignment_5()); 
            // InternalETMap.g:1492:1: ( rule__Mapping__SubsysMappingsAssignment_5 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==28) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalETMap.g:1492:2: rule__Mapping__SubsysMappingsAssignment_5
            	    {
            	    pushFollow(FOLLOW_10);
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
    // InternalETMap.g:1502:1: rule__Mapping__Group__6 : rule__Mapping__Group__6__Impl ;
    public final void rule__Mapping__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1506:1: ( rule__Mapping__Group__6__Impl )
            // InternalETMap.g:1507:2: rule__Mapping__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1513:1: rule__Mapping__Group__6__Impl : ( '}' ) ;
    public final void rule__Mapping__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1517:1: ( ( '}' ) )
            // InternalETMap.g:1518:1: ( '}' )
            {
            // InternalETMap.g:1518:1: ( '}' )
            // InternalETMap.g:1519:1: '}'
            {
             before(grammarAccess.getMappingAccess().getRightCurlyBracketKeyword_6()); 
            match(input,25,FOLLOW_2); 
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
    // InternalETMap.g:1546:1: rule__SubSystemMapping__Group__0 : rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1 ;
    public final void rule__SubSystemMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1550:1: ( rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1 )
            // InternalETMap.g:1551:2: rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__SubSystemMapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1558:1: rule__SubSystemMapping__Group__0__Impl : ( 'SubSystemMapping' ) ;
    public final void rule__SubSystemMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1562:1: ( ( 'SubSystemMapping' ) )
            // InternalETMap.g:1563:1: ( 'SubSystemMapping' )
            {
            // InternalETMap.g:1563:1: ( 'SubSystemMapping' )
            // InternalETMap.g:1564:1: 'SubSystemMapping'
            {
             before(grammarAccess.getSubSystemMappingAccess().getSubSystemMappingKeyword_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalETMap.g:1577:1: rule__SubSystemMapping__Group__1 : rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2 ;
    public final void rule__SubSystemMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1581:1: ( rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2 )
            // InternalETMap.g:1582:2: rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__SubSystemMapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1589:1: rule__SubSystemMapping__Group__1__Impl : ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) ) ;
    public final void rule__SubSystemMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1593:1: ( ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) ) )
            // InternalETMap.g:1594:1: ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) )
            {
            // InternalETMap.g:1594:1: ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) )
            // InternalETMap.g:1595:1: ( rule__SubSystemMapping__LogicalSubSysAssignment_1 )
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysAssignment_1()); 
            // InternalETMap.g:1596:1: ( rule__SubSystemMapping__LogicalSubSysAssignment_1 )
            // InternalETMap.g:1596:2: rule__SubSystemMapping__LogicalSubSysAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1606:1: rule__SubSystemMapping__Group__2 : rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3 ;
    public final void rule__SubSystemMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1610:1: ( rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3 )
            // InternalETMap.g:1611:2: rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__SubSystemMapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1618:1: rule__SubSystemMapping__Group__2__Impl : ( '->' ) ;
    public final void rule__SubSystemMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1622:1: ( ( '->' ) )
            // InternalETMap.g:1623:1: ( '->' )
            {
            // InternalETMap.g:1623:1: ( '->' )
            // InternalETMap.g:1624:1: '->'
            {
             before(grammarAccess.getSubSystemMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,27,FOLLOW_2); 
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
    // InternalETMap.g:1637:1: rule__SubSystemMapping__Group__3 : rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4 ;
    public final void rule__SubSystemMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1641:1: ( rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4 )
            // InternalETMap.g:1642:2: rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__SubSystemMapping__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1649:1: rule__SubSystemMapping__Group__3__Impl : ( ( rule__SubSystemMapping__NodeAssignment_3 ) ) ;
    public final void rule__SubSystemMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1653:1: ( ( ( rule__SubSystemMapping__NodeAssignment_3 ) ) )
            // InternalETMap.g:1654:1: ( ( rule__SubSystemMapping__NodeAssignment_3 ) )
            {
            // InternalETMap.g:1654:1: ( ( rule__SubSystemMapping__NodeAssignment_3 ) )
            // InternalETMap.g:1655:1: ( rule__SubSystemMapping__NodeAssignment_3 )
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeAssignment_3()); 
            // InternalETMap.g:1656:1: ( rule__SubSystemMapping__NodeAssignment_3 )
            // InternalETMap.g:1656:2: rule__SubSystemMapping__NodeAssignment_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1666:1: rule__SubSystemMapping__Group__4 : rule__SubSystemMapping__Group__4__Impl ;
    public final void rule__SubSystemMapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1670:1: ( rule__SubSystemMapping__Group__4__Impl )
            // InternalETMap.g:1671:2: rule__SubSystemMapping__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1677:1: rule__SubSystemMapping__Group__4__Impl : ( ( rule__SubSystemMapping__Group_4__0 )? ) ;
    public final void rule__SubSystemMapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1681:1: ( ( ( rule__SubSystemMapping__Group_4__0 )? ) )
            // InternalETMap.g:1682:1: ( ( rule__SubSystemMapping__Group_4__0 )? )
            {
            // InternalETMap.g:1682:1: ( ( rule__SubSystemMapping__Group_4__0 )? )
            // InternalETMap.g:1683:1: ( rule__SubSystemMapping__Group_4__0 )?
            {
             before(grammarAccess.getSubSystemMappingAccess().getGroup_4()); 
            // InternalETMap.g:1684:1: ( rule__SubSystemMapping__Group_4__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==24) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalETMap.g:1684:2: rule__SubSystemMapping__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1704:1: rule__SubSystemMapping__Group_4__0 : rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1 ;
    public final void rule__SubSystemMapping__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1708:1: ( rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1 )
            // InternalETMap.g:1709:2: rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1
            {
            pushFollow(FOLLOW_11);
            rule__SubSystemMapping__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1716:1: rule__SubSystemMapping__Group_4__0__Impl : ( '{' ) ;
    public final void rule__SubSystemMapping__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1720:1: ( ( '{' ) )
            // InternalETMap.g:1721:1: ( '{' )
            {
            // InternalETMap.g:1721:1: ( '{' )
            // InternalETMap.g:1722:1: '{'
            {
             before(grammarAccess.getSubSystemMappingAccess().getLeftCurlyBracketKeyword_4_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalETMap.g:1735:1: rule__SubSystemMapping__Group_4__1 : rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2 ;
    public final void rule__SubSystemMapping__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1739:1: ( rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2 )
            // InternalETMap.g:1740:2: rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2
            {
            pushFollow(FOLLOW_11);
            rule__SubSystemMapping__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1747:1: rule__SubSystemMapping__Group_4__1__Impl : ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* ) ;
    public final void rule__SubSystemMapping__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1751:1: ( ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* ) )
            // InternalETMap.g:1752:1: ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* )
            {
            // InternalETMap.g:1752:1: ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* )
            // InternalETMap.g:1753:1: ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )*
            {
             before(grammarAccess.getSubSystemMappingAccess().getThreadMappingsAssignment_4_1()); 
            // InternalETMap.g:1754:1: ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==29) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalETMap.g:1754:2: rule__SubSystemMapping__ThreadMappingsAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_12);
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
    // InternalETMap.g:1764:1: rule__SubSystemMapping__Group_4__2 : rule__SubSystemMapping__Group_4__2__Impl ;
    public final void rule__SubSystemMapping__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1768:1: ( rule__SubSystemMapping__Group_4__2__Impl )
            // InternalETMap.g:1769:2: rule__SubSystemMapping__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1775:1: rule__SubSystemMapping__Group_4__2__Impl : ( '}' ) ;
    public final void rule__SubSystemMapping__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1779:1: ( ( '}' ) )
            // InternalETMap.g:1780:1: ( '}' )
            {
            // InternalETMap.g:1780:1: ( '}' )
            // InternalETMap.g:1781:1: '}'
            {
             before(grammarAccess.getSubSystemMappingAccess().getRightCurlyBracketKeyword_4_2()); 
            match(input,25,FOLLOW_2); 
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
    // InternalETMap.g:1800:1: rule__ThreadMapping__Group__0 : rule__ThreadMapping__Group__0__Impl rule__ThreadMapping__Group__1 ;
    public final void rule__ThreadMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1804:1: ( rule__ThreadMapping__Group__0__Impl rule__ThreadMapping__Group__1 )
            // InternalETMap.g:1805:2: rule__ThreadMapping__Group__0__Impl rule__ThreadMapping__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ThreadMapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1812:1: rule__ThreadMapping__Group__0__Impl : ( 'ThreadMapping' ) ;
    public final void rule__ThreadMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1816:1: ( ( 'ThreadMapping' ) )
            // InternalETMap.g:1817:1: ( 'ThreadMapping' )
            {
            // InternalETMap.g:1817:1: ( 'ThreadMapping' )
            // InternalETMap.g:1818:1: 'ThreadMapping'
            {
             before(grammarAccess.getThreadMappingAccess().getThreadMappingKeyword_0()); 
            match(input,29,FOLLOW_2); 
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
    // InternalETMap.g:1831:1: rule__ThreadMapping__Group__1 : rule__ThreadMapping__Group__1__Impl rule__ThreadMapping__Group__2 ;
    public final void rule__ThreadMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1835:1: ( rule__ThreadMapping__Group__1__Impl rule__ThreadMapping__Group__2 )
            // InternalETMap.g:1836:2: rule__ThreadMapping__Group__1__Impl rule__ThreadMapping__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__ThreadMapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1843:1: rule__ThreadMapping__Group__1__Impl : ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) ) ;
    public final void rule__ThreadMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1847:1: ( ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) ) )
            // InternalETMap.g:1848:1: ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) )
            {
            // InternalETMap.g:1848:1: ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) )
            // InternalETMap.g:1849:1: ( rule__ThreadMapping__LogicalThreadAssignment_1 )
            {
             before(grammarAccess.getThreadMappingAccess().getLogicalThreadAssignment_1()); 
            // InternalETMap.g:1850:1: ( rule__ThreadMapping__LogicalThreadAssignment_1 )
            // InternalETMap.g:1850:2: rule__ThreadMapping__LogicalThreadAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1860:1: rule__ThreadMapping__Group__2 : rule__ThreadMapping__Group__2__Impl rule__ThreadMapping__Group__3 ;
    public final void rule__ThreadMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1864:1: ( rule__ThreadMapping__Group__2__Impl rule__ThreadMapping__Group__3 )
            // InternalETMap.g:1865:2: rule__ThreadMapping__Group__2__Impl rule__ThreadMapping__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__ThreadMapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1872:1: rule__ThreadMapping__Group__2__Impl : ( '->' ) ;
    public final void rule__ThreadMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1876:1: ( ( '->' ) )
            // InternalETMap.g:1877:1: ( '->' )
            {
            // InternalETMap.g:1877:1: ( '->' )
            // InternalETMap.g:1878:1: '->'
            {
             before(grammarAccess.getThreadMappingAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,27,FOLLOW_2); 
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
    // InternalETMap.g:1891:1: rule__ThreadMapping__Group__3 : rule__ThreadMapping__Group__3__Impl ;
    public final void rule__ThreadMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1895:1: ( rule__ThreadMapping__Group__3__Impl )
            // InternalETMap.g:1896:2: rule__ThreadMapping__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1902:1: rule__ThreadMapping__Group__3__Impl : ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) ) ;
    public final void rule__ThreadMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1906:1: ( ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) ) )
            // InternalETMap.g:1907:1: ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) )
            {
            // InternalETMap.g:1907:1: ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) )
            // InternalETMap.g:1908:1: ( rule__ThreadMapping__PhysicalThreadAssignment_3 )
            {
             before(grammarAccess.getThreadMappingAccess().getPhysicalThreadAssignment_3()); 
            // InternalETMap.g:1909:1: ( rule__ThreadMapping__PhysicalThreadAssignment_3 )
            // InternalETMap.g:1909:2: rule__ThreadMapping__PhysicalThreadAssignment_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1930:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1934:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // InternalETMap.g:1935:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__KeyValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1942:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1946:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // InternalETMap.g:1947:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // InternalETMap.g:1947:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // InternalETMap.g:1948:1: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // InternalETMap.g:1949:1: ( rule__KeyValue__KeyAssignment_0 )
            // InternalETMap.g:1949:2: rule__KeyValue__KeyAssignment_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1959:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1963:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // InternalETMap.g:1964:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__KeyValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:1971:1: rule__KeyValue__Group__1__Impl : ( '=' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1975:1: ( ( '=' ) )
            // InternalETMap.g:1976:1: ( '=' )
            {
            // InternalETMap.g:1976:1: ( '=' )
            // InternalETMap.g:1977:1: '='
            {
             before(grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1()); 
            match(input,30,FOLLOW_2); 
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
    // InternalETMap.g:1990:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:1994:1: ( rule__KeyValue__Group__2__Impl )
            // InternalETMap.g:1995:2: rule__KeyValue__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2001:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2005:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // InternalETMap.g:2006:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // InternalETMap.g:2006:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // InternalETMap.g:2007:1: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // InternalETMap.g:2008:1: ( rule__KeyValue__ValueAssignment_2 )
            // InternalETMap.g:2008:2: rule__KeyValue__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2027:1: rule__SimpleAnnotationAttribute__Group__0 : rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 ;
    public final void rule__SimpleAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2031:1: ( rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 )
            // InternalETMap.g:2032:2: rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__SimpleAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2039:1: rule__SimpleAnnotationAttribute__Group__0__Impl : ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2043:1: ( ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) )
            // InternalETMap.g:2044:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            {
            // InternalETMap.g:2044:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            // InternalETMap.g:2045:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 
            // InternalETMap.g:2046:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            // InternalETMap.g:2046:2: rule__SimpleAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2056:1: rule__SimpleAnnotationAttribute__Group__1 : rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 ;
    public final void rule__SimpleAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2060:1: ( rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 )
            // InternalETMap.g:2061:2: rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__SimpleAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2068:1: rule__SimpleAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2072:1: ( ( 'attribute' ) )
            // InternalETMap.g:2073:1: ( 'attribute' )
            {
            // InternalETMap.g:2073:1: ( 'attribute' )
            // InternalETMap.g:2074:1: 'attribute'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,31,FOLLOW_2); 
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
    // InternalETMap.g:2087:1: rule__SimpleAnnotationAttribute__Group__2 : rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 ;
    public final void rule__SimpleAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2091:1: ( rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 )
            // InternalETMap.g:2092:2: rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__SimpleAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2099:1: rule__SimpleAnnotationAttribute__Group__2__Impl : ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2103:1: ( ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) )
            // InternalETMap.g:2104:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            {
            // InternalETMap.g:2104:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            // InternalETMap.g:2105:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 
            // InternalETMap.g:2106:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            // InternalETMap.g:2106:2: rule__SimpleAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2116:1: rule__SimpleAnnotationAttribute__Group__3 : rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 ;
    public final void rule__SimpleAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2120:1: ( rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 )
            // InternalETMap.g:2121:2: rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_17);
            rule__SimpleAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2128:1: rule__SimpleAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2132:1: ( ( ':' ) )
            // InternalETMap.g:2133:1: ( ':' )
            {
            // InternalETMap.g:2133:1: ( ':' )
            // InternalETMap.g:2134:1: ':'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,32,FOLLOW_2); 
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
    // InternalETMap.g:2147:1: rule__SimpleAnnotationAttribute__Group__4 : rule__SimpleAnnotationAttribute__Group__4__Impl ;
    public final void rule__SimpleAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2151:1: ( rule__SimpleAnnotationAttribute__Group__4__Impl )
            // InternalETMap.g:2152:2: rule__SimpleAnnotationAttribute__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2158:1: rule__SimpleAnnotationAttribute__Group__4__Impl : ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2162:1: ( ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) )
            // InternalETMap.g:2163:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            {
            // InternalETMap.g:2163:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            // InternalETMap.g:2164:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 
            // InternalETMap.g:2165:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            // InternalETMap.g:2165:2: rule__SimpleAnnotationAttribute__TypeAssignment_4
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2185:1: rule__EnumAnnotationAttribute__Group__0 : rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 ;
    public final void rule__EnumAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2189:1: ( rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 )
            // InternalETMap.g:2190:2: rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__EnumAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2197:1: rule__EnumAnnotationAttribute__Group__0__Impl : ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2201:1: ( ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) )
            // InternalETMap.g:2202:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            {
            // InternalETMap.g:2202:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            // InternalETMap.g:2203:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 
            // InternalETMap.g:2204:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            // InternalETMap.g:2204:2: rule__EnumAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2214:1: rule__EnumAnnotationAttribute__Group__1 : rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 ;
    public final void rule__EnumAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2218:1: ( rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 )
            // InternalETMap.g:2219:2: rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__EnumAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2226:1: rule__EnumAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__EnumAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2230:1: ( ( 'attribute' ) )
            // InternalETMap.g:2231:1: ( 'attribute' )
            {
            // InternalETMap.g:2231:1: ( 'attribute' )
            // InternalETMap.g:2232:1: 'attribute'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,31,FOLLOW_2); 
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
    // InternalETMap.g:2245:1: rule__EnumAnnotationAttribute__Group__2 : rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 ;
    public final void rule__EnumAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2249:1: ( rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 )
            // InternalETMap.g:2250:2: rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__EnumAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2257:1: rule__EnumAnnotationAttribute__Group__2__Impl : ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2261:1: ( ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) )
            // InternalETMap.g:2262:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            {
            // InternalETMap.g:2262:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            // InternalETMap.g:2263:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 
            // InternalETMap.g:2264:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            // InternalETMap.g:2264:2: rule__EnumAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2274:1: rule__EnumAnnotationAttribute__Group__3 : rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 ;
    public final void rule__EnumAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2278:1: ( rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 )
            // InternalETMap.g:2279:2: rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__EnumAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2286:1: rule__EnumAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2290:1: ( ( ':' ) )
            // InternalETMap.g:2291:1: ( ':' )
            {
            // InternalETMap.g:2291:1: ( ':' )
            // InternalETMap.g:2292:1: ':'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,32,FOLLOW_2); 
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
    // InternalETMap.g:2305:1: rule__EnumAnnotationAttribute__Group__4 : rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 ;
    public final void rule__EnumAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2309:1: ( rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 )
            // InternalETMap.g:2310:2: rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5
            {
            pushFollow(FOLLOW_18);
            rule__EnumAnnotationAttribute__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2317:1: rule__EnumAnnotationAttribute__Group__4__Impl : ( '{' ) ;
    public final void rule__EnumAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2321:1: ( ( '{' ) )
            // InternalETMap.g:2322:1: ( '{' )
            {
            // InternalETMap.g:2322:1: ( '{' )
            // InternalETMap.g:2323:1: '{'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,24,FOLLOW_2); 
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
    // InternalETMap.g:2336:1: rule__EnumAnnotationAttribute__Group__5 : rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 ;
    public final void rule__EnumAnnotationAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2340:1: ( rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 )
            // InternalETMap.g:2341:2: rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6
            {
            pushFollow(FOLLOW_19);
            rule__EnumAnnotationAttribute__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2348:1: rule__EnumAnnotationAttribute__Group__5__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2352:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) )
            // InternalETMap.g:2353:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            {
            // InternalETMap.g:2353:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            // InternalETMap.g:2354:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 
            // InternalETMap.g:2355:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            // InternalETMap.g:2355:2: rule__EnumAnnotationAttribute__ValuesAssignment_5
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2365:1: rule__EnumAnnotationAttribute__Group__6 : rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 ;
    public final void rule__EnumAnnotationAttribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2369:1: ( rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 )
            // InternalETMap.g:2370:2: rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7
            {
            pushFollow(FOLLOW_19);
            rule__EnumAnnotationAttribute__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2377:1: rule__EnumAnnotationAttribute__Group__6__Impl : ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) ;
    public final void rule__EnumAnnotationAttribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2381:1: ( ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) )
            // InternalETMap.g:2382:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            {
            // InternalETMap.g:2382:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            // InternalETMap.g:2383:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 
            // InternalETMap.g:2384:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==33) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalETMap.g:2384:2: rule__EnumAnnotationAttribute__Group_6__0
            	    {
            	    pushFollow(FOLLOW_20);
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
    // InternalETMap.g:2394:1: rule__EnumAnnotationAttribute__Group__7 : rule__EnumAnnotationAttribute__Group__7__Impl ;
    public final void rule__EnumAnnotationAttribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2398:1: ( rule__EnumAnnotationAttribute__Group__7__Impl )
            // InternalETMap.g:2399:2: rule__EnumAnnotationAttribute__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2405:1: rule__EnumAnnotationAttribute__Group__7__Impl : ( '}' ) ;
    public final void rule__EnumAnnotationAttribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2409:1: ( ( '}' ) )
            // InternalETMap.g:2410:1: ( '}' )
            {
            // InternalETMap.g:2410:1: ( '}' )
            // InternalETMap.g:2411:1: '}'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7()); 
            match(input,25,FOLLOW_2); 
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
    // InternalETMap.g:2440:1: rule__EnumAnnotationAttribute__Group_6__0 : rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 ;
    public final void rule__EnumAnnotationAttribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2444:1: ( rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 )
            // InternalETMap.g:2445:2: rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1
            {
            pushFollow(FOLLOW_18);
            rule__EnumAnnotationAttribute__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2452:1: rule__EnumAnnotationAttribute__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2456:1: ( ( ',' ) )
            // InternalETMap.g:2457:1: ( ',' )
            {
            // InternalETMap.g:2457:1: ( ',' )
            // InternalETMap.g:2458:1: ','
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0()); 
            match(input,33,FOLLOW_2); 
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
    // InternalETMap.g:2471:1: rule__EnumAnnotationAttribute__Group_6__1 : rule__EnumAnnotationAttribute__Group_6__1__Impl ;
    public final void rule__EnumAnnotationAttribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2475:1: ( rule__EnumAnnotationAttribute__Group_6__1__Impl )
            // InternalETMap.g:2476:2: rule__EnumAnnotationAttribute__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2482:1: rule__EnumAnnotationAttribute__Group_6__1__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2486:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) )
            // InternalETMap.g:2487:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            {
            // InternalETMap.g:2487:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            // InternalETMap.g:2488:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 
            // InternalETMap.g:2489:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            // InternalETMap.g:2489:2: rule__EnumAnnotationAttribute__ValuesAssignment_6_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2503:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2507:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalETMap.g:2508:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2515:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2519:1: ( ( 'import' ) )
            // InternalETMap.g:2520:1: ( 'import' )
            {
            // InternalETMap.g:2520:1: ( 'import' )
            // InternalETMap.g:2521:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,34,FOLLOW_2); 
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
    // InternalETMap.g:2534:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2538:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // InternalETMap.g:2539:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Import__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2546:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2550:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // InternalETMap.g:2551:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // InternalETMap.g:2551:1: ( ( rule__Import__Alternatives_1 ) )
            // InternalETMap.g:2552:1: ( rule__Import__Alternatives_1 )
            {
             before(grammarAccess.getImportAccess().getAlternatives_1()); 
            // InternalETMap.g:2553:1: ( rule__Import__Alternatives_1 )
            // InternalETMap.g:2553:2: rule__Import__Alternatives_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2563:1: rule__Import__Group__2 : rule__Import__Group__2__Impl ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2567:1: ( rule__Import__Group__2__Impl )
            // InternalETMap.g:2568:2: rule__Import__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2574:1: rule__Import__Group__2__Impl : ( ( rule__Import__ImportURIAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2578:1: ( ( ( rule__Import__ImportURIAssignment_2 ) ) )
            // InternalETMap.g:2579:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            {
            // InternalETMap.g:2579:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            // InternalETMap.g:2580:1: ( rule__Import__ImportURIAssignment_2 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_2()); 
            // InternalETMap.g:2581:1: ( rule__Import__ImportURIAssignment_2 )
            // InternalETMap.g:2581:2: rule__Import__ImportURIAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2597:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2601:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // InternalETMap.g:2602:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
            {
            pushFollow(FOLLOW_22);
            rule__Import__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2609:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2613:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // InternalETMap.g:2614:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // InternalETMap.g:2614:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // InternalETMap.g:2615:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            // InternalETMap.g:2616:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // InternalETMap.g:2616:2: rule__Import__ImportedNamespaceAssignment_1_0_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2626:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2630:1: ( rule__Import__Group_1_0__1__Impl )
            // InternalETMap.g:2631:2: rule__Import__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2637:1: rule__Import__Group_1_0__1__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2641:1: ( ( 'from' ) )
            // InternalETMap.g:2642:1: ( 'from' )
            {
            // InternalETMap.g:2642:1: ( 'from' )
            // InternalETMap.g:2643:1: 'from'
            {
             before(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 
            match(input,35,FOLLOW_2); 
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
    // InternalETMap.g:2660:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2664:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // InternalETMap.g:2665:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2672:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2676:1: ( ( ruleFQN ) )
            // InternalETMap.g:2677:1: ( ruleFQN )
            {
            // InternalETMap.g:2677:1: ( ruleFQN )
            // InternalETMap.g:2678:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2689:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2693:1: ( rule__ImportedFQN__Group__1__Impl )
            // InternalETMap.g:2694:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2700:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2704:1: ( ( ( '.*' )? ) )
            // InternalETMap.g:2705:1: ( ( '.*' )? )
            {
            // InternalETMap.g:2705:1: ( ( '.*' )? )
            // InternalETMap.g:2706:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // InternalETMap.g:2707:1: ( '.*' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==36) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalETMap.g:2708:2: '.*'
                    {
                    match(input,36,FOLLOW_2); 

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
    // InternalETMap.g:2723:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2727:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // InternalETMap.g:2728:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__Documentation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2735:1: rule__Documentation__Group__0__Impl : ( () ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2739:1: ( ( () ) )
            // InternalETMap.g:2740:1: ( () )
            {
            // InternalETMap.g:2740:1: ( () )
            // InternalETMap.g:2741:1: ()
            {
             before(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 
            // InternalETMap.g:2742:1: ()
            // InternalETMap.g:2744:1: 
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
    // InternalETMap.g:2754:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2758:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // InternalETMap.g:2759:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Documentation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2766:1: rule__Documentation__Group__1__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2770:1: ( ( '[' ) )
            // InternalETMap.g:2771:1: ( '[' )
            {
            // InternalETMap.g:2771:1: ( '[' )
            // InternalETMap.g:2772:1: '['
            {
             before(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1()); 
            match(input,37,FOLLOW_2); 
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
    // InternalETMap.g:2785:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl rule__Documentation__Group__3 ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2789:1: ( rule__Documentation__Group__2__Impl rule__Documentation__Group__3 )
            // InternalETMap.g:2790:2: rule__Documentation__Group__2__Impl rule__Documentation__Group__3
            {
            pushFollow(FOLLOW_25);
            rule__Documentation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2797:1: rule__Documentation__Group__2__Impl : ( ( rule__Documentation__LinesAssignment_2 )* ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2801:1: ( ( ( rule__Documentation__LinesAssignment_2 )* ) )
            // InternalETMap.g:2802:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            {
            // InternalETMap.g:2802:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            // InternalETMap.g:2803:1: ( rule__Documentation__LinesAssignment_2 )*
            {
             before(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 
            // InternalETMap.g:2804:1: ( rule__Documentation__LinesAssignment_2 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_STRING) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalETMap.g:2804:2: rule__Documentation__LinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_26);
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
    // InternalETMap.g:2814:1: rule__Documentation__Group__3 : rule__Documentation__Group__3__Impl ;
    public final void rule__Documentation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2818:1: ( rule__Documentation__Group__3__Impl )
            // InternalETMap.g:2819:2: rule__Documentation__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2825:1: rule__Documentation__Group__3__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2829:1: ( ( ']' ) )
            // InternalETMap.g:2830:1: ( ']' )
            {
            // InternalETMap.g:2830:1: ( ']' )
            // InternalETMap.g:2831:1: ']'
            {
             before(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3()); 
            match(input,38,FOLLOW_2); 
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
    // InternalETMap.g:2858:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2862:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // InternalETMap.g:2863:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__BooleanLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2870:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2874:1: ( ( () ) )
            // InternalETMap.g:2875:1: ( () )
            {
            // InternalETMap.g:2875:1: ( () )
            // InternalETMap.g:2876:1: ()
            {
             before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            // InternalETMap.g:2877:1: ()
            // InternalETMap.g:2879:1: 
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
    // InternalETMap.g:2889:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2893:1: ( rule__BooleanLiteral__Group__1__Impl )
            // InternalETMap.g:2894:2: rule__BooleanLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2900:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2904:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // InternalETMap.g:2905:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // InternalETMap.g:2905:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // InternalETMap.g:2906:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            // InternalETMap.g:2907:1: ( rule__BooleanLiteral__Alternatives_1 )
            // InternalETMap.g:2907:2: rule__BooleanLiteral__Alternatives_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2921:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2925:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // InternalETMap.g:2926:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2933:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2937:1: ( ( () ) )
            // InternalETMap.g:2938:1: ( () )
            {
            // InternalETMap.g:2938:1: ( () )
            // InternalETMap.g:2939:1: ()
            {
             before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            // InternalETMap.g:2940:1: ()
            // InternalETMap.g:2942:1: 
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
    // InternalETMap.g:2952:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2956:1: ( rule__RealLiteral__Group__1__Impl )
            // InternalETMap.g:2957:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2963:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2967:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // InternalETMap.g:2968:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // InternalETMap.g:2968:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // InternalETMap.g:2969:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            // InternalETMap.g:2970:1: ( rule__RealLiteral__ValueAssignment_1 )
            // InternalETMap.g:2970:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2984:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:2988:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // InternalETMap.g:2989:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:2996:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3000:1: ( ( () ) )
            // InternalETMap.g:3001:1: ( () )
            {
            // InternalETMap.g:3001:1: ( () )
            // InternalETMap.g:3002:1: ()
            {
             before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            // InternalETMap.g:3003:1: ()
            // InternalETMap.g:3005:1: 
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
    // InternalETMap.g:3015:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3019:1: ( rule__IntLiteral__Group__1__Impl )
            // InternalETMap.g:3020:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3026:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3030:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // InternalETMap.g:3031:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // InternalETMap.g:3031:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // InternalETMap.g:3032:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            // InternalETMap.g:3033:1: ( rule__IntLiteral__ValueAssignment_1 )
            // InternalETMap.g:3033:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3047:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3051:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // InternalETMap.g:3052:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3059:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3063:1: ( ( () ) )
            // InternalETMap.g:3064:1: ( () )
            {
            // InternalETMap.g:3064:1: ( () )
            // InternalETMap.g:3065:1: ()
            {
             before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            // InternalETMap.g:3066:1: ()
            // InternalETMap.g:3068:1: 
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
    // InternalETMap.g:3078:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3082:1: ( rule__StringLiteral__Group__1__Impl )
            // InternalETMap.g:3083:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3089:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3093:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // InternalETMap.g:3094:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // InternalETMap.g:3094:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // InternalETMap.g:3095:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            // InternalETMap.g:3096:1: ( rule__StringLiteral__ValueAssignment_1 )
            // InternalETMap.g:3096:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__Integer__Group_0__0"
    // InternalETMap.g:3110:1: rule__Integer__Group_0__0 : rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1 ;
    public final void rule__Integer__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3114:1: ( rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1 )
            // InternalETMap.g:3115:2: rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1
            {
            pushFollow(FOLLOW_29);
            rule__Integer__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Integer__Group_0__1();

            state._fsp--;


            }

        }
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
    // InternalETMap.g:3122:1: rule__Integer__Group_0__0__Impl : ( ( rule__Integer__Alternatives_0_0 )? ) ;
    public final void rule__Integer__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3126:1: ( ( ( rule__Integer__Alternatives_0_0 )? ) )
            // InternalETMap.g:3127:1: ( ( rule__Integer__Alternatives_0_0 )? )
            {
            // InternalETMap.g:3127:1: ( ( rule__Integer__Alternatives_0_0 )? )
            // InternalETMap.g:3128:1: ( rule__Integer__Alternatives_0_0 )?
            {
             before(grammarAccess.getIntegerAccess().getAlternatives_0_0()); 
            // InternalETMap.g:3129:1: ( rule__Integer__Alternatives_0_0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=15 && LA24_0<=16)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalETMap.g:3129:2: rule__Integer__Alternatives_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Integer__Alternatives_0_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntegerAccess().getAlternatives_0_0()); 

            }


            }

        }
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
    // InternalETMap.g:3139:1: rule__Integer__Group_0__1 : rule__Integer__Group_0__1__Impl ;
    public final void rule__Integer__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3143:1: ( rule__Integer__Group_0__1__Impl )
            // InternalETMap.g:3144:2: rule__Integer__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Integer__Group_0__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalETMap.g:3150:1: rule__Integer__Group_0__1__Impl : ( RULE_INT ) ;
    public final void rule__Integer__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3154:1: ( ( RULE_INT ) )
            // InternalETMap.g:3155:1: ( RULE_INT )
            {
            // InternalETMap.g:3155:1: ( RULE_INT )
            // InternalETMap.g:3156:1: RULE_INT
            {
             before(grammarAccess.getIntegerAccess().getINTTerminalRuleCall_0_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getIntegerAccess().getINTTerminalRuleCall_0_1()); 

            }


            }

        }
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
    // InternalETMap.g:3171:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3175:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // InternalETMap.g:3176:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__Decimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3183:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3187:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // InternalETMap.g:3188:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // InternalETMap.g:3188:1: ( ( rule__Decimal__Alternatives_0 )? )
            // InternalETMap.g:3189:1: ( rule__Decimal__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            // InternalETMap.g:3190:1: ( rule__Decimal__Alternatives_0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=15 && LA25_0<=16)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalETMap.g:3190:2: rule__Decimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3200:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3204:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // InternalETMap.g:3205:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_30);
            rule__Decimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3212:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3216:1: ( ( RULE_INT ) )
            // InternalETMap.g:3217:1: ( RULE_INT )
            {
            // InternalETMap.g:3217:1: ( RULE_INT )
            // InternalETMap.g:3218:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_2); 
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
    // InternalETMap.g:3229:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3233:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // InternalETMap.g:3234:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__Decimal__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3241:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3245:1: ( ( '.' ) )
            // InternalETMap.g:3246:1: ( '.' )
            {
            // InternalETMap.g:3246:1: ( '.' )
            // InternalETMap.g:3247:1: '.'
            {
             before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            match(input,39,FOLLOW_2); 
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
    // InternalETMap.g:3260:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3264:1: ( rule__Decimal__Group__3__Impl )
            // InternalETMap.g:3265:2: rule__Decimal__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3271:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3275:1: ( ( RULE_INT ) )
            // InternalETMap.g:3276:1: ( RULE_INT )
            {
            // InternalETMap.g:3276:1: ( RULE_INT )
            // InternalETMap.g:3277:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_2); 
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


    // $ANTLR start "rule__DecimalExp__Group__0"
    // InternalETMap.g:3296:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3300:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // InternalETMap.g:3301:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__DecimalExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3308:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3312:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // InternalETMap.g:3313:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // InternalETMap.g:3313:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // InternalETMap.g:3314:1: ( rule__DecimalExp__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            // InternalETMap.g:3315:1: ( rule__DecimalExp__Alternatives_0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=15 && LA26_0<=16)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalETMap.g:3315:2: rule__DecimalExp__Alternatives_0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3325:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3329:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // InternalETMap.g:3330:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
            {
            pushFollow(FOLLOW_30);
            rule__DecimalExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3337:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3341:1: ( ( RULE_INT ) )
            // InternalETMap.g:3342:1: ( RULE_INT )
            {
            // InternalETMap.g:3342:1: ( RULE_INT )
            // InternalETMap.g:3343:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_2); 
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
    // InternalETMap.g:3354:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3358:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // InternalETMap.g:3359:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__DecimalExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3366:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3370:1: ( ( '.' ) )
            // InternalETMap.g:3371:1: ( '.' )
            {
            // InternalETMap.g:3371:1: ( '.' )
            // InternalETMap.g:3372:1: '.'
            {
             before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            match(input,39,FOLLOW_2); 
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
    // InternalETMap.g:3385:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3389:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // InternalETMap.g:3390:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
            {
            pushFollow(FOLLOW_32);
            rule__DecimalExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3397:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3401:1: ( ( RULE_INT ) )
            // InternalETMap.g:3402:1: ( RULE_INT )
            {
            // InternalETMap.g:3402:1: ( RULE_INT )
            // InternalETMap.g:3403:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_2); 
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
    // InternalETMap.g:3414:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5 ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3418:1: ( rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5 )
            // InternalETMap.g:3419:2: rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5
            {
            pushFollow(FOLLOW_29);
            rule__DecimalExp__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DecimalExp__Group__5();

            state._fsp--;


            }

        }
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
    // InternalETMap.g:3426:1: rule__DecimalExp__Group__4__Impl : ( ( rule__DecimalExp__Alternatives_4 ) ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3430:1: ( ( ( rule__DecimalExp__Alternatives_4 ) ) )
            // InternalETMap.g:3431:1: ( ( rule__DecimalExp__Alternatives_4 ) )
            {
            // InternalETMap.g:3431:1: ( ( rule__DecimalExp__Alternatives_4 ) )
            // InternalETMap.g:3432:1: ( rule__DecimalExp__Alternatives_4 )
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_4()); 
            // InternalETMap.g:3433:1: ( rule__DecimalExp__Alternatives_4 )
            // InternalETMap.g:3433:2: rule__DecimalExp__Alternatives_4
            {
            pushFollow(FOLLOW_2);
            rule__DecimalExp__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getDecimalExpAccess().getAlternatives_4()); 

            }


            }

        }
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
    // InternalETMap.g:3443:1: rule__DecimalExp__Group__5 : rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6 ;
    public final void rule__DecimalExp__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3447:1: ( rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6 )
            // InternalETMap.g:3448:2: rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6
            {
            pushFollow(FOLLOW_29);
            rule__DecimalExp__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DecimalExp__Group__6();

            state._fsp--;


            }

        }
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
    // InternalETMap.g:3455:1: rule__DecimalExp__Group__5__Impl : ( ( rule__DecimalExp__Alternatives_5 )? ) ;
    public final void rule__DecimalExp__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3459:1: ( ( ( rule__DecimalExp__Alternatives_5 )? ) )
            // InternalETMap.g:3460:1: ( ( rule__DecimalExp__Alternatives_5 )? )
            {
            // InternalETMap.g:3460:1: ( ( rule__DecimalExp__Alternatives_5 )? )
            // InternalETMap.g:3461:1: ( rule__DecimalExp__Alternatives_5 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_5()); 
            // InternalETMap.g:3462:1: ( rule__DecimalExp__Alternatives_5 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=15 && LA27_0<=16)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalETMap.g:3462:2: rule__DecimalExp__Alternatives_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__DecimalExp__Alternatives_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDecimalExpAccess().getAlternatives_5()); 

            }


            }

        }
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
    // InternalETMap.g:3472:1: rule__DecimalExp__Group__6 : rule__DecimalExp__Group__6__Impl ;
    public final void rule__DecimalExp__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3476:1: ( rule__DecimalExp__Group__6__Impl )
            // InternalETMap.g:3477:2: rule__DecimalExp__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DecimalExp__Group__6__Impl();

            state._fsp--;


            }

        }
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
    // InternalETMap.g:3483:1: rule__DecimalExp__Group__6__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3487:1: ( ( RULE_INT ) )
            // InternalETMap.g:3488:1: ( RULE_INT )
            {
            // InternalETMap.g:3488:1: ( RULE_INT )
            // InternalETMap.g:3489:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_6()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_6()); 

            }


            }

        }
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
    // InternalETMap.g:3514:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3518:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalETMap.g:3519:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3526:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3530:1: ( ( RULE_ID ) )
            // InternalETMap.g:3531:1: ( RULE_ID )
            {
            // InternalETMap.g:3531:1: ( RULE_ID )
            // InternalETMap.g:3532:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalETMap.g:3543:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3547:1: ( rule__FQN__Group__1__Impl )
            // InternalETMap.g:3548:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3554:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3558:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalETMap.g:3559:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalETMap.g:3559:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalETMap.g:3560:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalETMap.g:3561:1: ( rule__FQN__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==39) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalETMap.g:3561:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalETMap.g:3575:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3579:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalETMap.g:3580:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3587:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3591:1: ( ( '.' ) )
            // InternalETMap.g:3592:1: ( '.' )
            {
            // InternalETMap.g:3592:1: ( '.' )
            // InternalETMap.g:3593:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,39,FOLLOW_2); 
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
    // InternalETMap.g:3606:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3610:1: ( rule__FQN__Group_1__1__Impl )
            // InternalETMap.g:3611:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3617:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3621:1: ( ( RULE_ID ) )
            // InternalETMap.g:3622:1: ( RULE_ID )
            {
            // InternalETMap.g:3622:1: ( RULE_ID )
            // InternalETMap.g:3623:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalETMap.g:3639:1: rule__MappingModel__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__MappingModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3643:1: ( ( ruleFQN ) )
            // InternalETMap.g:3644:1: ( ruleFQN )
            {
            // InternalETMap.g:3644:1: ( ruleFQN )
            // InternalETMap.g:3645:1: ruleFQN
            {
             before(grammarAccess.getMappingModelAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3654:1: rule__MappingModel__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__MappingModel__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3658:1: ( ( ruleImport ) )
            // InternalETMap.g:3659:1: ( ruleImport )
            {
            // InternalETMap.g:3659:1: ( ruleImport )
            // InternalETMap.g:3660:1: ruleImport
            {
             before(grammarAccess.getMappingModelAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3669:1: rule__MappingModel__MappingsAssignment_4 : ( ruleMapping ) ;
    public final void rule__MappingModel__MappingsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3673:1: ( ( ruleMapping ) )
            // InternalETMap.g:3674:1: ( ruleMapping )
            {
            // InternalETMap.g:3674:1: ( ruleMapping )
            // InternalETMap.g:3675:1: ruleMapping
            {
             before(grammarAccess.getMappingModelAccess().getMappingsMappingParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3684:1: rule__Mapping__LogicalSysAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__Mapping__LogicalSysAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3688:1: ( ( ( ruleFQN ) ) )
            // InternalETMap.g:3689:1: ( ( ruleFQN ) )
            {
            // InternalETMap.g:3689:1: ( ( ruleFQN ) )
            // InternalETMap.g:3690:1: ( ruleFQN )
            {
             before(grammarAccess.getMappingAccess().getLogicalSysLogicalSystemCrossReference_1_0()); 
            // InternalETMap.g:3691:1: ( ruleFQN )
            // InternalETMap.g:3692:1: ruleFQN
            {
             before(grammarAccess.getMappingAccess().getLogicalSysLogicalSystemFQNParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3703:1: rule__Mapping__PhysicalSysAssignment_3 : ( ( ruleFQN ) ) ;
    public final void rule__Mapping__PhysicalSysAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3707:1: ( ( ( ruleFQN ) ) )
            // InternalETMap.g:3708:1: ( ( ruleFQN ) )
            {
            // InternalETMap.g:3708:1: ( ( ruleFQN ) )
            // InternalETMap.g:3709:1: ( ruleFQN )
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysPhysicalSystemCrossReference_3_0()); 
            // InternalETMap.g:3710:1: ( ruleFQN )
            // InternalETMap.g:3711:1: ruleFQN
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysPhysicalSystemFQNParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3722:1: rule__Mapping__SubsysMappingsAssignment_5 : ( ruleSubSystemMapping ) ;
    public final void rule__Mapping__SubsysMappingsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3726:1: ( ( ruleSubSystemMapping ) )
            // InternalETMap.g:3727:1: ( ruleSubSystemMapping )
            {
            // InternalETMap.g:3727:1: ( ruleSubSystemMapping )
            // InternalETMap.g:3728:1: ruleSubSystemMapping
            {
             before(grammarAccess.getMappingAccess().getSubsysMappingsSubSystemMappingParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3737:1: rule__SubSystemMapping__LogicalSubSysAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemMapping__LogicalSubSysAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3741:1: ( ( ( RULE_ID ) ) )
            // InternalETMap.g:3742:1: ( ( RULE_ID ) )
            {
            // InternalETMap.g:3742:1: ( ( RULE_ID ) )
            // InternalETMap.g:3743:1: ( RULE_ID )
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefCrossReference_1_0()); 
            // InternalETMap.g:3744:1: ( RULE_ID )
            // InternalETMap.g:3745:1: RULE_ID
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalETMap.g:3756:1: rule__SubSystemMapping__NodeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemMapping__NodeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3760:1: ( ( ( RULE_ID ) ) )
            // InternalETMap.g:3761:1: ( ( RULE_ID ) )
            {
            // InternalETMap.g:3761:1: ( ( RULE_ID ) )
            // InternalETMap.g:3762:1: ( RULE_ID )
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeNodeRefCrossReference_3_0()); 
            // InternalETMap.g:3763:1: ( RULE_ID )
            // InternalETMap.g:3764:1: RULE_ID
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeNodeRefIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalETMap.g:3775:1: rule__SubSystemMapping__ThreadMappingsAssignment_4_1 : ( ruleThreadMapping ) ;
    public final void rule__SubSystemMapping__ThreadMappingsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3779:1: ( ( ruleThreadMapping ) )
            // InternalETMap.g:3780:1: ( ruleThreadMapping )
            {
            // InternalETMap.g:3780:1: ( ruleThreadMapping )
            // InternalETMap.g:3781:1: ruleThreadMapping
            {
             before(grammarAccess.getSubSystemMappingAccess().getThreadMappingsThreadMappingParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3790:1: rule__ThreadMapping__LogicalThreadAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ThreadMapping__LogicalThreadAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3794:1: ( ( ( RULE_ID ) ) )
            // InternalETMap.g:3795:1: ( ( RULE_ID ) )
            {
            // InternalETMap.g:3795:1: ( ( RULE_ID ) )
            // InternalETMap.g:3796:1: ( RULE_ID )
            {
             before(grammarAccess.getThreadMappingAccess().getLogicalThreadLogicalThreadCrossReference_1_0()); 
            // InternalETMap.g:3797:1: ( RULE_ID )
            // InternalETMap.g:3798:1: RULE_ID
            {
             before(grammarAccess.getThreadMappingAccess().getLogicalThreadLogicalThreadIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalETMap.g:3809:1: rule__ThreadMapping__PhysicalThreadAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__ThreadMapping__PhysicalThreadAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3813:1: ( ( ( RULE_ID ) ) )
            // InternalETMap.g:3814:1: ( ( RULE_ID ) )
            {
            // InternalETMap.g:3814:1: ( ( RULE_ID ) )
            // InternalETMap.g:3815:1: ( RULE_ID )
            {
             before(grammarAccess.getThreadMappingAccess().getPhysicalThreadPhysicalThreadCrossReference_3_0()); 
            // InternalETMap.g:3816:1: ( RULE_ID )
            // InternalETMap.g:3817:1: RULE_ID
            {
             before(grammarAccess.getThreadMappingAccess().getPhysicalThreadPhysicalThreadIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalETMap.g:3831:1: rule__KeyValue__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3835:1: ( ( RULE_ID ) )
            // InternalETMap.g:3836:1: ( RULE_ID )
            {
            // InternalETMap.g:3836:1: ( RULE_ID )
            // InternalETMap.g:3837:1: RULE_ID
            {
             before(grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalETMap.g:3846:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3850:1: ( ( ruleLiteral ) )
            // InternalETMap.g:3851:1: ( ruleLiteral )
            {
            // InternalETMap.g:3851:1: ( ruleLiteral )
            // InternalETMap.g:3852:1: ruleLiteral
            {
             before(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3867:1: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__SimpleAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3871:1: ( ( ( 'optional' ) ) )
            // InternalETMap.g:3872:1: ( ( 'optional' ) )
            {
            // InternalETMap.g:3872:1: ( ( 'optional' ) )
            // InternalETMap.g:3873:1: ( 'optional' )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // InternalETMap.g:3874:1: ( 'optional' )
            // InternalETMap.g:3875:1: 'optional'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,40,FOLLOW_2); 
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
    // InternalETMap.g:3890:1: rule__SimpleAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3894:1: ( ( RULE_ID ) )
            // InternalETMap.g:3895:1: ( RULE_ID )
            {
            // InternalETMap.g:3895:1: ( RULE_ID )
            // InternalETMap.g:3896:1: RULE_ID
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalETMap.g:3905:1: rule__SimpleAnnotationAttribute__TypeAssignment_4 : ( ruleLiteralType ) ;
    public final void rule__SimpleAnnotationAttribute__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3909:1: ( ( ruleLiteralType ) )
            // InternalETMap.g:3910:1: ( ruleLiteralType )
            {
            // InternalETMap.g:3910:1: ( ruleLiteralType )
            // InternalETMap.g:3911:1: ruleLiteralType
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:3920:1: rule__EnumAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__EnumAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3924:1: ( ( ( 'optional' ) ) )
            // InternalETMap.g:3925:1: ( ( 'optional' ) )
            {
            // InternalETMap.g:3925:1: ( ( 'optional' ) )
            // InternalETMap.g:3926:1: ( 'optional' )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // InternalETMap.g:3927:1: ( 'optional' )
            // InternalETMap.g:3928:1: 'optional'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,40,FOLLOW_2); 
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
    // InternalETMap.g:3943:1: rule__EnumAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EnumAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3947:1: ( ( RULE_ID ) )
            // InternalETMap.g:3948:1: ( RULE_ID )
            {
            // InternalETMap.g:3948:1: ( RULE_ID )
            // InternalETMap.g:3949:1: RULE_ID
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalETMap.g:3958:1: rule__EnumAnnotationAttribute__ValuesAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3962:1: ( ( RULE_STRING ) )
            // InternalETMap.g:3963:1: ( RULE_STRING )
            {
            // InternalETMap.g:3963:1: ( RULE_STRING )
            // InternalETMap.g:3964:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
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
    // InternalETMap.g:3973:1: rule__EnumAnnotationAttribute__ValuesAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3977:1: ( ( RULE_STRING ) )
            // InternalETMap.g:3978:1: ( RULE_STRING )
            {
            // InternalETMap.g:3978:1: ( RULE_STRING )
            // InternalETMap.g:3979:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
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
    // InternalETMap.g:3988:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:3992:1: ( ( ruleImportedFQN ) )
            // InternalETMap.g:3993:1: ( ruleImportedFQN )
            {
            // InternalETMap.g:3993:1: ( ruleImportedFQN )
            // InternalETMap.g:3994:1: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:4003:1: rule__Import__ImportURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:4007:1: ( ( RULE_STRING ) )
            // InternalETMap.g:4008:1: ( RULE_STRING )
            {
            // InternalETMap.g:4008:1: ( RULE_STRING )
            // InternalETMap.g:4009:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
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
    // InternalETMap.g:4018:1: rule__Documentation__LinesAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Documentation__LinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:4022:1: ( ( RULE_STRING ) )
            // InternalETMap.g:4023:1: ( RULE_STRING )
            {
            // InternalETMap.g:4023:1: ( RULE_STRING )
            // InternalETMap.g:4024:1: RULE_STRING
            {
             before(grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
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
    // InternalETMap.g:4035:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:4039:1: ( ( ( 'true' ) ) )
            // InternalETMap.g:4040:1: ( ( 'true' ) )
            {
            // InternalETMap.g:4040:1: ( ( 'true' ) )
            // InternalETMap.g:4041:1: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            // InternalETMap.g:4042:1: ( 'true' )
            // InternalETMap.g:4043:1: 'true'
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalETMap.g:4058:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:4062:1: ( ( ruleReal ) )
            // InternalETMap.g:4063:1: ( ruleReal )
            {
            // InternalETMap.g:4063:1: ( ruleReal )
            // InternalETMap.g:4064:1: ruleReal
            {
             before(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:4073:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:4077:1: ( ( ruleInteger ) )
            // InternalETMap.g:4078:1: ( ruleInteger )
            {
            // InternalETMap.g:4078:1: ( ruleInteger )
            // InternalETMap.g:4079:1: ruleInteger
            {
             before(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalETMap.g:4088:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalETMap.g:4092:1: ( ( RULE_STRING ) )
            // InternalETMap.g:4093:1: ( RULE_STRING )
            {
            // InternalETMap.g:4093:1: ( RULE_STRING )
            // InternalETMap.g:4094:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000406000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000002000001C0E0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000780000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000004000000080L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000020000004000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000018060L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000008000000002L});

}