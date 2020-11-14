package org.eclipse.etrice.core.etmap.ide.contentassist.antlr.internal;

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
import org.eclipse.etrice.core.etmap.services.ETMapGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalETMapParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_HEX", "RULE_INT", "RULE_STRING", "RULE_CC_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'mandatory'", "'false'", "'+'", "'-'", "'e'", "'E'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'", "'MappingModel'", "'{'", "'}'", "'Mapping'", "'->'", "'SubSystemMapping'", "'ThreadMapping'", "'='", "'attribute'", "':'", "','", "'import'", "'from'", "'model'", "'.*'", "'['", "']'", "'.'", "'optional'", "'true'"
    };
    public static final int RULE_HEX=5;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int RULE_CC_STRING=8;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__33=33;
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
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
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
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__42=42;
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
    // InternalETMap.g:53:1: entryRuleMappingModel : ruleMappingModel EOF ;
    public final void entryRuleMappingModel() throws RecognitionException {
        try {
            // InternalETMap.g:54:1: ( ruleMappingModel EOF )
            // InternalETMap.g:55:1: ruleMappingModel EOF
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
    // InternalETMap.g:62:1: ruleMappingModel : ( ( rule__MappingModel__Group__0 ) ) ;
    public final void ruleMappingModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:66:2: ( ( ( rule__MappingModel__Group__0 ) ) )
            // InternalETMap.g:67:2: ( ( rule__MappingModel__Group__0 ) )
            {
            // InternalETMap.g:67:2: ( ( rule__MappingModel__Group__0 ) )
            // InternalETMap.g:68:3: ( rule__MappingModel__Group__0 )
            {
             before(grammarAccess.getMappingModelAccess().getGroup()); 
            // InternalETMap.g:69:3: ( rule__MappingModel__Group__0 )
            // InternalETMap.g:69:4: rule__MappingModel__Group__0
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
    // InternalETMap.g:78:1: entryRuleMapping : ruleMapping EOF ;
    public final void entryRuleMapping() throws RecognitionException {
        try {
            // InternalETMap.g:79:1: ( ruleMapping EOF )
            // InternalETMap.g:80:1: ruleMapping EOF
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
    // InternalETMap.g:87:1: ruleMapping : ( ( rule__Mapping__Group__0 ) ) ;
    public final void ruleMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:91:2: ( ( ( rule__Mapping__Group__0 ) ) )
            // InternalETMap.g:92:2: ( ( rule__Mapping__Group__0 ) )
            {
            // InternalETMap.g:92:2: ( ( rule__Mapping__Group__0 ) )
            // InternalETMap.g:93:3: ( rule__Mapping__Group__0 )
            {
             before(grammarAccess.getMappingAccess().getGroup()); 
            // InternalETMap.g:94:3: ( rule__Mapping__Group__0 )
            // InternalETMap.g:94:4: rule__Mapping__Group__0
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
    // InternalETMap.g:103:1: entryRuleSubSystemMapping : ruleSubSystemMapping EOF ;
    public final void entryRuleSubSystemMapping() throws RecognitionException {
        try {
            // InternalETMap.g:104:1: ( ruleSubSystemMapping EOF )
            // InternalETMap.g:105:1: ruleSubSystemMapping EOF
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
    // InternalETMap.g:112:1: ruleSubSystemMapping : ( ( rule__SubSystemMapping__Group__0 ) ) ;
    public final void ruleSubSystemMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:116:2: ( ( ( rule__SubSystemMapping__Group__0 ) ) )
            // InternalETMap.g:117:2: ( ( rule__SubSystemMapping__Group__0 ) )
            {
            // InternalETMap.g:117:2: ( ( rule__SubSystemMapping__Group__0 ) )
            // InternalETMap.g:118:3: ( rule__SubSystemMapping__Group__0 )
            {
             before(grammarAccess.getSubSystemMappingAccess().getGroup()); 
            // InternalETMap.g:119:3: ( rule__SubSystemMapping__Group__0 )
            // InternalETMap.g:119:4: rule__SubSystemMapping__Group__0
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
    // InternalETMap.g:128:1: entryRuleThreadMapping : ruleThreadMapping EOF ;
    public final void entryRuleThreadMapping() throws RecognitionException {
        try {
            // InternalETMap.g:129:1: ( ruleThreadMapping EOF )
            // InternalETMap.g:130:1: ruleThreadMapping EOF
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
    // InternalETMap.g:137:1: ruleThreadMapping : ( ( rule__ThreadMapping__Group__0 ) ) ;
    public final void ruleThreadMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:141:2: ( ( ( rule__ThreadMapping__Group__0 ) ) )
            // InternalETMap.g:142:2: ( ( rule__ThreadMapping__Group__0 ) )
            {
            // InternalETMap.g:142:2: ( ( rule__ThreadMapping__Group__0 ) )
            // InternalETMap.g:143:3: ( rule__ThreadMapping__Group__0 )
            {
             before(grammarAccess.getThreadMappingAccess().getGroup()); 
            // InternalETMap.g:144:3: ( rule__ThreadMapping__Group__0 )
            // InternalETMap.g:144:4: rule__ThreadMapping__Group__0
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
    // InternalETMap.g:153:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // InternalETMap.g:154:1: ( ruleKeyValue EOF )
            // InternalETMap.g:155:1: ruleKeyValue EOF
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
    // InternalETMap.g:162:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:166:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // InternalETMap.g:167:2: ( ( rule__KeyValue__Group__0 ) )
            {
            // InternalETMap.g:167:2: ( ( rule__KeyValue__Group__0 ) )
            // InternalETMap.g:168:3: ( rule__KeyValue__Group__0 )
            {
             before(grammarAccess.getKeyValueAccess().getGroup()); 
            // InternalETMap.g:169:3: ( rule__KeyValue__Group__0 )
            // InternalETMap.g:169:4: rule__KeyValue__Group__0
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
    // InternalETMap.g:178:1: entryRuleAnnotationTargetType : ruleAnnotationTargetType EOF ;
    public final void entryRuleAnnotationTargetType() throws RecognitionException {
        try {
            // InternalETMap.g:179:1: ( ruleAnnotationTargetType EOF )
            // InternalETMap.g:180:1: ruleAnnotationTargetType EOF
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
    // InternalETMap.g:187:1: ruleAnnotationTargetType : ( RULE_ID ) ;
    public final void ruleAnnotationTargetType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:191:2: ( ( RULE_ID ) )
            // InternalETMap.g:192:2: ( RULE_ID )
            {
            // InternalETMap.g:192:2: ( RULE_ID )
            // InternalETMap.g:193:3: RULE_ID
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
    // InternalETMap.g:203:1: entryRuleAnnotationAttribute : ruleAnnotationAttribute EOF ;
    public final void entryRuleAnnotationAttribute() throws RecognitionException {
        try {
            // InternalETMap.g:204:1: ( ruleAnnotationAttribute EOF )
            // InternalETMap.g:205:1: ruleAnnotationAttribute EOF
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
    // InternalETMap.g:212:1: ruleAnnotationAttribute : ( ( rule__AnnotationAttribute__Alternatives ) ) ;
    public final void ruleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:216:2: ( ( ( rule__AnnotationAttribute__Alternatives ) ) )
            // InternalETMap.g:217:2: ( ( rule__AnnotationAttribute__Alternatives ) )
            {
            // InternalETMap.g:217:2: ( ( rule__AnnotationAttribute__Alternatives ) )
            // InternalETMap.g:218:3: ( rule__AnnotationAttribute__Alternatives )
            {
             before(grammarAccess.getAnnotationAttributeAccess().getAlternatives()); 
            // InternalETMap.g:219:3: ( rule__AnnotationAttribute__Alternatives )
            // InternalETMap.g:219:4: rule__AnnotationAttribute__Alternatives
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
    // InternalETMap.g:228:1: entryRuleSimpleAnnotationAttribute : ruleSimpleAnnotationAttribute EOF ;
    public final void entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        try {
            // InternalETMap.g:229:1: ( ruleSimpleAnnotationAttribute EOF )
            // InternalETMap.g:230:1: ruleSimpleAnnotationAttribute EOF
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
    // InternalETMap.g:237:1: ruleSimpleAnnotationAttribute : ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) ;
    public final void ruleSimpleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:241:2: ( ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) )
            // InternalETMap.g:242:2: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            {
            // InternalETMap.g:242:2: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            // InternalETMap.g:243:3: ( rule__SimpleAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup()); 
            // InternalETMap.g:244:3: ( rule__SimpleAnnotationAttribute__Group__0 )
            // InternalETMap.g:244:4: rule__SimpleAnnotationAttribute__Group__0
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
    // InternalETMap.g:253:1: entryRuleEnumAnnotationAttribute : ruleEnumAnnotationAttribute EOF ;
    public final void entryRuleEnumAnnotationAttribute() throws RecognitionException {
        try {
            // InternalETMap.g:254:1: ( ruleEnumAnnotationAttribute EOF )
            // InternalETMap.g:255:1: ruleEnumAnnotationAttribute EOF
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
    // InternalETMap.g:262:1: ruleEnumAnnotationAttribute : ( ( rule__EnumAnnotationAttribute__Group__0 ) ) ;
    public final void ruleEnumAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:266:2: ( ( ( rule__EnumAnnotationAttribute__Group__0 ) ) )
            // InternalETMap.g:267:2: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            {
            // InternalETMap.g:267:2: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            // InternalETMap.g:268:3: ( rule__EnumAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup()); 
            // InternalETMap.g:269:3: ( rule__EnumAnnotationAttribute__Group__0 )
            // InternalETMap.g:269:4: rule__EnumAnnotationAttribute__Group__0
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
    // InternalETMap.g:278:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalETMap.g:279:1: ( ruleImport EOF )
            // InternalETMap.g:280:1: ruleImport EOF
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
    // InternalETMap.g:287:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:291:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalETMap.g:292:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalETMap.g:292:2: ( ( rule__Import__Group__0 ) )
            // InternalETMap.g:293:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalETMap.g:294:3: ( rule__Import__Group__0 )
            // InternalETMap.g:294:4: rule__Import__Group__0
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
    // InternalETMap.g:303:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // InternalETMap.g:304:1: ( ruleImportedFQN EOF )
            // InternalETMap.g:305:1: ruleImportedFQN EOF
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
    // InternalETMap.g:312:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:316:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // InternalETMap.g:317:2: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // InternalETMap.g:317:2: ( ( rule__ImportedFQN__Group__0 ) )
            // InternalETMap.g:318:3: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // InternalETMap.g:319:3: ( rule__ImportedFQN__Group__0 )
            // InternalETMap.g:319:4: rule__ImportedFQN__Group__0
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
    // InternalETMap.g:328:1: entryRuleDocumentation : ruleDocumentation EOF ;
    public final void entryRuleDocumentation() throws RecognitionException {
        try {
            // InternalETMap.g:329:1: ( ruleDocumentation EOF )
            // InternalETMap.g:330:1: ruleDocumentation EOF
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
    // InternalETMap.g:337:1: ruleDocumentation : ( ( rule__Documentation__Group__0 ) ) ;
    public final void ruleDocumentation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:341:2: ( ( ( rule__Documentation__Group__0 ) ) )
            // InternalETMap.g:342:2: ( ( rule__Documentation__Group__0 ) )
            {
            // InternalETMap.g:342:2: ( ( rule__Documentation__Group__0 ) )
            // InternalETMap.g:343:3: ( rule__Documentation__Group__0 )
            {
             before(grammarAccess.getDocumentationAccess().getGroup()); 
            // InternalETMap.g:344:3: ( rule__Documentation__Group__0 )
            // InternalETMap.g:344:4: rule__Documentation__Group__0
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
    // InternalETMap.g:353:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalETMap.g:354:1: ( ruleLiteral EOF )
            // InternalETMap.g:355:1: ruleLiteral EOF
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
    // InternalETMap.g:362:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:366:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalETMap.g:367:2: ( ( rule__Literal__Alternatives ) )
            {
            // InternalETMap.g:367:2: ( ( rule__Literal__Alternatives ) )
            // InternalETMap.g:368:3: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // InternalETMap.g:369:3: ( rule__Literal__Alternatives )
            // InternalETMap.g:369:4: rule__Literal__Alternatives
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
    // InternalETMap.g:378:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // InternalETMap.g:379:1: ( ruleBooleanLiteral EOF )
            // InternalETMap.g:380:1: ruleBooleanLiteral EOF
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
    // InternalETMap.g:387:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:391:2: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // InternalETMap.g:392:2: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // InternalETMap.g:392:2: ( ( rule__BooleanLiteral__Group__0 ) )
            // InternalETMap.g:393:3: ( rule__BooleanLiteral__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            // InternalETMap.g:394:3: ( rule__BooleanLiteral__Group__0 )
            // InternalETMap.g:394:4: rule__BooleanLiteral__Group__0
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
    // InternalETMap.g:403:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // InternalETMap.g:404:1: ( ruleNumberLiteral EOF )
            // InternalETMap.g:405:1: ruleNumberLiteral EOF
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
    // InternalETMap.g:412:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Alternatives ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:416:2: ( ( ( rule__NumberLiteral__Alternatives ) ) )
            // InternalETMap.g:417:2: ( ( rule__NumberLiteral__Alternatives ) )
            {
            // InternalETMap.g:417:2: ( ( rule__NumberLiteral__Alternatives ) )
            // InternalETMap.g:418:3: ( rule__NumberLiteral__Alternatives )
            {
             before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            // InternalETMap.g:419:3: ( rule__NumberLiteral__Alternatives )
            // InternalETMap.g:419:4: rule__NumberLiteral__Alternatives
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
    // InternalETMap.g:428:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // InternalETMap.g:429:1: ( ruleRealLiteral EOF )
            // InternalETMap.g:430:1: ruleRealLiteral EOF
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
    // InternalETMap.g:437:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:441:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // InternalETMap.g:442:2: ( ( rule__RealLiteral__Group__0 ) )
            {
            // InternalETMap.g:442:2: ( ( rule__RealLiteral__Group__0 ) )
            // InternalETMap.g:443:3: ( rule__RealLiteral__Group__0 )
            {
             before(grammarAccess.getRealLiteralAccess().getGroup()); 
            // InternalETMap.g:444:3: ( rule__RealLiteral__Group__0 )
            // InternalETMap.g:444:4: rule__RealLiteral__Group__0
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
    // InternalETMap.g:453:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // InternalETMap.g:454:1: ( ruleIntLiteral EOF )
            // InternalETMap.g:455:1: ruleIntLiteral EOF
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
    // InternalETMap.g:462:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:466:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // InternalETMap.g:467:2: ( ( rule__IntLiteral__Group__0 ) )
            {
            // InternalETMap.g:467:2: ( ( rule__IntLiteral__Group__0 ) )
            // InternalETMap.g:468:3: ( rule__IntLiteral__Group__0 )
            {
             before(grammarAccess.getIntLiteralAccess().getGroup()); 
            // InternalETMap.g:469:3: ( rule__IntLiteral__Group__0 )
            // InternalETMap.g:469:4: rule__IntLiteral__Group__0
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
    // InternalETMap.g:478:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // InternalETMap.g:479:1: ( ruleStringLiteral EOF )
            // InternalETMap.g:480:1: ruleStringLiteral EOF
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
    // InternalETMap.g:487:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:491:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // InternalETMap.g:492:2: ( ( rule__StringLiteral__Group__0 ) )
            {
            // InternalETMap.g:492:2: ( ( rule__StringLiteral__Group__0 ) )
            // InternalETMap.g:493:3: ( rule__StringLiteral__Group__0 )
            {
             before(grammarAccess.getStringLiteralAccess().getGroup()); 
            // InternalETMap.g:494:3: ( rule__StringLiteral__Group__0 )
            // InternalETMap.g:494:4: rule__StringLiteral__Group__0
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
    // InternalETMap.g:503:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // InternalETMap.g:504:1: ( ruleInteger EOF )
            // InternalETMap.g:505:1: ruleInteger EOF
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
    // InternalETMap.g:512:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:516:2: ( ( ( rule__Integer__Alternatives ) ) )
            // InternalETMap.g:517:2: ( ( rule__Integer__Alternatives ) )
            {
            // InternalETMap.g:517:2: ( ( rule__Integer__Alternatives ) )
            // InternalETMap.g:518:3: ( rule__Integer__Alternatives )
            {
             before(grammarAccess.getIntegerAccess().getAlternatives()); 
            // InternalETMap.g:519:3: ( rule__Integer__Alternatives )
            // InternalETMap.g:519:4: rule__Integer__Alternatives
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
    // InternalETMap.g:528:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // InternalETMap.g:529:1: ( ruleReal EOF )
            // InternalETMap.g:530:1: ruleReal EOF
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
    // InternalETMap.g:537:1: ruleReal : ( ( rule__Real__Alternatives ) ) ;
    public final void ruleReal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:541:2: ( ( ( rule__Real__Alternatives ) ) )
            // InternalETMap.g:542:2: ( ( rule__Real__Alternatives ) )
            {
            // InternalETMap.g:542:2: ( ( rule__Real__Alternatives ) )
            // InternalETMap.g:543:3: ( rule__Real__Alternatives )
            {
             before(grammarAccess.getRealAccess().getAlternatives()); 
            // InternalETMap.g:544:3: ( rule__Real__Alternatives )
            // InternalETMap.g:544:4: rule__Real__Alternatives
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
    // InternalETMap.g:553:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalETMap.g:557:1: ( ruleDecimal EOF )
            // InternalETMap.g:558:1: ruleDecimal EOF
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
    // InternalETMap.g:568:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:573:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // InternalETMap.g:574:2: ( ( rule__Decimal__Group__0 ) )
            {
            // InternalETMap.g:574:2: ( ( rule__Decimal__Group__0 ) )
            // InternalETMap.g:575:3: ( rule__Decimal__Group__0 )
            {
             before(grammarAccess.getDecimalAccess().getGroup()); 
            // InternalETMap.g:576:3: ( rule__Decimal__Group__0 )
            // InternalETMap.g:576:4: rule__Decimal__Group__0
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
    // InternalETMap.g:586:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalETMap.g:590:1: ( ruleDecimalExp EOF )
            // InternalETMap.g:591:1: ruleDecimalExp EOF
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
    // InternalETMap.g:601:1: ruleDecimalExp : ( ( rule__DecimalExp__Group__0 ) ) ;
    public final void ruleDecimalExp() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:606:2: ( ( ( rule__DecimalExp__Group__0 ) ) )
            // InternalETMap.g:607:2: ( ( rule__DecimalExp__Group__0 ) )
            {
            // InternalETMap.g:607:2: ( ( rule__DecimalExp__Group__0 ) )
            // InternalETMap.g:608:3: ( rule__DecimalExp__Group__0 )
            {
             before(grammarAccess.getDecimalExpAccess().getGroup()); 
            // InternalETMap.g:609:3: ( rule__DecimalExp__Group__0 )
            // InternalETMap.g:609:4: rule__DecimalExp__Group__0
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
    // InternalETMap.g:619:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalETMap.g:620:1: ( ruleFQN EOF )
            // InternalETMap.g:621:1: ruleFQN EOF
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
    // InternalETMap.g:628:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:632:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalETMap.g:633:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalETMap.g:633:2: ( ( rule__FQN__Group__0 ) )
            // InternalETMap.g:634:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalETMap.g:635:3: ( rule__FQN__Group__0 )
            // InternalETMap.g:635:4: rule__FQN__Group__0
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
    // InternalETMap.g:644:1: ruleLiteralType : ( ( rule__LiteralType__Alternatives ) ) ;
    public final void ruleLiteralType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:648:1: ( ( ( rule__LiteralType__Alternatives ) ) )
            // InternalETMap.g:649:2: ( ( rule__LiteralType__Alternatives ) )
            {
            // InternalETMap.g:649:2: ( ( rule__LiteralType__Alternatives ) )
            // InternalETMap.g:650:3: ( rule__LiteralType__Alternatives )
            {
             before(grammarAccess.getLiteralTypeAccess().getAlternatives()); 
            // InternalETMap.g:651:3: ( rule__LiteralType__Alternatives )
            // InternalETMap.g:651:4: rule__LiteralType__Alternatives
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
    // InternalETMap.g:659:1: rule__AnnotationAttribute__Alternatives : ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) );
    public final void rule__AnnotationAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:663:1: ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==41) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==31) ) {
                    int LA1_3 = input.LA(3);

                    if ( (LA1_3==RULE_ID) ) {
                        int LA1_4 = input.LA(4);

                        if ( (LA1_4==32) ) {
                            int LA1_5 = input.LA(5);

                            if ( ((LA1_5>=19 && LA1_5<=22)) ) {
                                alt1=1;
                            }
                            else if ( (LA1_5==24) ) {
                                alt1=2;
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

                if ( (LA1_2==31) ) {
                    int LA1_3 = input.LA(3);

                    if ( (LA1_3==RULE_ID) ) {
                        int LA1_4 = input.LA(4);

                        if ( (LA1_4==32) ) {
                            int LA1_5 = input.LA(5);

                            if ( ((LA1_5>=19 && LA1_5<=22)) ) {
                                alt1=1;
                            }
                            else if ( (LA1_5==24) ) {
                                alt1=2;
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
                    // InternalETMap.g:664:2: ( ruleSimpleAnnotationAttribute )
                    {
                    // InternalETMap.g:664:2: ( ruleSimpleAnnotationAttribute )
                    // InternalETMap.g:665:3: ruleSimpleAnnotationAttribute
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
                    // InternalETMap.g:670:2: ( ruleEnumAnnotationAttribute )
                    {
                    // InternalETMap.g:670:2: ( ruleEnumAnnotationAttribute )
                    // InternalETMap.g:671:3: ruleEnumAnnotationAttribute
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
    // InternalETMap.g:680:1: rule__SimpleAnnotationAttribute__Alternatives_0 : ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__SimpleAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:684:1: ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==41) ) {
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
                    // InternalETMap.g:685:2: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // InternalETMap.g:685:2: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // InternalETMap.g:686:3: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // InternalETMap.g:687:3: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    // InternalETMap.g:687:4: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0
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
                    // InternalETMap.g:691:2: ( 'mandatory' )
                    {
                    // InternalETMap.g:691:2: ( 'mandatory' )
                    // InternalETMap.g:692:3: 'mandatory'
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,13,FOLLOW_2); 
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
    // InternalETMap.g:701:1: rule__EnumAnnotationAttribute__Alternatives_0 : ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__EnumAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:705:1: ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==41) ) {
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
                    // InternalETMap.g:706:2: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // InternalETMap.g:706:2: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // InternalETMap.g:707:3: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // InternalETMap.g:708:3: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    // InternalETMap.g:708:4: rule__EnumAnnotationAttribute__OptionalAssignment_0_0
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
                    // InternalETMap.g:712:2: ( 'mandatory' )
                    {
                    // InternalETMap.g:712:2: ( 'mandatory' )
                    // InternalETMap.g:713:3: 'mandatory'
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,13,FOLLOW_2); 
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
    // InternalETMap.g:722:1: rule__Import__Alternatives_1 : ( ( ( rule__Import__Group_1_0__0 ) ) | ( ( rule__Import__Group_1_1__0 ) ) );
    public final void rule__Import__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:726:1: ( ( ( rule__Import__Group_1_0__0 ) ) | ( ( rule__Import__Group_1_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==36) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalETMap.g:727:2: ( ( rule__Import__Group_1_0__0 ) )
                    {
                    // InternalETMap.g:727:2: ( ( rule__Import__Group_1_0__0 ) )
                    // InternalETMap.g:728:3: ( rule__Import__Group_1_0__0 )
                    {
                     before(grammarAccess.getImportAccess().getGroup_1_0()); 
                    // InternalETMap.g:729:3: ( rule__Import__Group_1_0__0 )
                    // InternalETMap.g:729:4: rule__Import__Group_1_0__0
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
                    // InternalETMap.g:733:2: ( ( rule__Import__Group_1_1__0 ) )
                    {
                    // InternalETMap.g:733:2: ( ( rule__Import__Group_1_1__0 ) )
                    // InternalETMap.g:734:3: ( rule__Import__Group_1_1__0 )
                    {
                     before(grammarAccess.getImportAccess().getGroup_1_1()); 
                    // InternalETMap.g:735:3: ( rule__Import__Group_1_1__0 )
                    // InternalETMap.g:735:4: rule__Import__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Import__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getImportAccess().getGroup_1_1()); 

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
    // InternalETMap.g:743:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:747:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 14:
            case 42:
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
                    // InternalETMap.g:748:2: ( ruleBooleanLiteral )
                    {
                    // InternalETMap.g:748:2: ( ruleBooleanLiteral )
                    // InternalETMap.g:749:3: ruleBooleanLiteral
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
                    // InternalETMap.g:754:2: ( ruleNumberLiteral )
                    {
                    // InternalETMap.g:754:2: ( ruleNumberLiteral )
                    // InternalETMap.g:755:3: ruleNumberLiteral
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
                    // InternalETMap.g:760:2: ( ruleStringLiteral )
                    {
                    // InternalETMap.g:760:2: ( ruleStringLiteral )
                    // InternalETMap.g:761:3: ruleStringLiteral
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
    // InternalETMap.g:770:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:774:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            else if ( (LA6_0==42) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalETMap.g:775:2: ( 'false' )
                    {
                    // InternalETMap.g:775:2: ( 'false' )
                    // InternalETMap.g:776:3: 'false'
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:781:2: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // InternalETMap.g:781:2: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // InternalETMap.g:782:3: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    // InternalETMap.g:783:3: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // InternalETMap.g:783:4: rule__BooleanLiteral__IsTrueAssignment_1_1
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
    // InternalETMap.g:791:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:795:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
            int alt7=2;
            switch ( input.LA(1) ) {
            case 15:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_INT) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==40) ) {
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

                    if ( (LA7_3==40) ) {
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

                if ( (LA7_3==40) ) {
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalETMap.g:796:2: ( ruleIntLiteral )
                    {
                    // InternalETMap.g:796:2: ( ruleIntLiteral )
                    // InternalETMap.g:797:3: ruleIntLiteral
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
                    // InternalETMap.g:802:2: ( ruleRealLiteral )
                    {
                    // InternalETMap.g:802:2: ( ruleRealLiteral )
                    // InternalETMap.g:803:3: ruleRealLiteral
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
    // InternalETMap.g:812:1: rule__Integer__Alternatives : ( ( ( rule__Integer__Group_0__0 ) ) | ( RULE_HEX ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:816:1: ( ( ( rule__Integer__Group_0__0 ) ) | ( RULE_HEX ) )
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
                    // InternalETMap.g:817:2: ( ( rule__Integer__Group_0__0 ) )
                    {
                    // InternalETMap.g:817:2: ( ( rule__Integer__Group_0__0 ) )
                    // InternalETMap.g:818:3: ( rule__Integer__Group_0__0 )
                    {
                     before(grammarAccess.getIntegerAccess().getGroup_0()); 
                    // InternalETMap.g:819:3: ( rule__Integer__Group_0__0 )
                    // InternalETMap.g:819:4: rule__Integer__Group_0__0
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
                    // InternalETMap.g:823:2: ( RULE_HEX )
                    {
                    // InternalETMap.g:823:2: ( RULE_HEX )
                    // InternalETMap.g:824:3: RULE_HEX
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
    // InternalETMap.g:833:1: rule__Integer__Alternatives_0_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Integer__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:837:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalETMap.g:838:2: ( '+' )
                    {
                    // InternalETMap.g:838:2: ( '+' )
                    // InternalETMap.g:839:3: '+'
                    {
                     before(grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:844:2: ( '-' )
                    {
                    // InternalETMap.g:844:2: ( '-' )
                    // InternalETMap.g:845:3: '-'
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
    // InternalETMap.g:854:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:858:1: ( ( ruleDecimal ) | ( ruleDecimalExp ) )
            int alt10=2;
            switch ( input.LA(1) ) {
            case 15:
                {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==RULE_INT) ) {
                    int LA10_3 = input.LA(3);

                    if ( (LA10_3==40) ) {
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

                    if ( (LA10_3==40) ) {
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

                if ( (LA10_3==40) ) {
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
                    // InternalETMap.g:859:2: ( ruleDecimal )
                    {
                    // InternalETMap.g:859:2: ( ruleDecimal )
                    // InternalETMap.g:860:3: ruleDecimal
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
                    // InternalETMap.g:865:2: ( ruleDecimalExp )
                    {
                    // InternalETMap.g:865:2: ( ruleDecimalExp )
                    // InternalETMap.g:866:3: ruleDecimalExp
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
    // InternalETMap.g:875:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:879:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalETMap.g:880:2: ( '+' )
                    {
                    // InternalETMap.g:880:2: ( '+' )
                    // InternalETMap.g:881:3: '+'
                    {
                     before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:886:2: ( '-' )
                    {
                    // InternalETMap.g:886:2: ( '-' )
                    // InternalETMap.g:887:3: '-'
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
    // InternalETMap.g:896:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:900:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalETMap.g:901:2: ( '+' )
                    {
                    // InternalETMap.g:901:2: ( '+' )
                    // InternalETMap.g:902:3: '+'
                    {
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:907:2: ( '-' )
                    {
                    // InternalETMap.g:907:2: ( '-' )
                    // InternalETMap.g:908:3: '-'
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
    // InternalETMap.g:917:1: rule__DecimalExp__Alternatives_4 : ( ( 'e' ) | ( 'E' ) );
    public final void rule__DecimalExp__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:921:1: ( ( 'e' ) | ( 'E' ) )
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
                    // InternalETMap.g:922:2: ( 'e' )
                    {
                    // InternalETMap.g:922:2: ( 'e' )
                    // InternalETMap.g:923:3: 'e'
                    {
                     before(grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:928:2: ( 'E' )
                    {
                    // InternalETMap.g:928:2: ( 'E' )
                    // InternalETMap.g:929:3: 'E'
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
    // InternalETMap.g:938:1: rule__DecimalExp__Alternatives_5 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:942:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalETMap.g:943:2: ( '+' )
                    {
                    // InternalETMap.g:943:2: ( '+' )
                    // InternalETMap.g:944:3: '+'
                    {
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:949:2: ( '-' )
                    {
                    // InternalETMap.g:949:2: ( '-' )
                    // InternalETMap.g:950:3: '-'
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
    // InternalETMap.g:959:1: rule__LiteralType__Alternatives : ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) );
    public final void rule__LiteralType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:963:1: ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) )
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
                    // InternalETMap.g:964:2: ( ( 'ptBoolean' ) )
                    {
                    // InternalETMap.g:964:2: ( ( 'ptBoolean' ) )
                    // InternalETMap.g:965:3: ( 'ptBoolean' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                    // InternalETMap.g:966:3: ( 'ptBoolean' )
                    // InternalETMap.g:966:4: 'ptBoolean'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:970:2: ( ( 'ptInteger' ) )
                    {
                    // InternalETMap.g:970:2: ( ( 'ptInteger' ) )
                    // InternalETMap.g:971:3: ( 'ptInteger' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                    // InternalETMap.g:972:3: ( 'ptInteger' )
                    // InternalETMap.g:972:4: 'ptInteger'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalETMap.g:976:2: ( ( 'ptReal' ) )
                    {
                    // InternalETMap.g:976:2: ( ( 'ptReal' ) )
                    // InternalETMap.g:977:3: ( 'ptReal' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                    // InternalETMap.g:978:3: ( 'ptReal' )
                    // InternalETMap.g:978:4: 'ptReal'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalETMap.g:982:2: ( ( 'ptCharacter' ) )
                    {
                    // InternalETMap.g:982:2: ( ( 'ptCharacter' ) )
                    // InternalETMap.g:983:3: ( 'ptCharacter' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 
                    // InternalETMap.g:984:3: ( 'ptCharacter' )
                    // InternalETMap.g:984:4: 'ptCharacter'
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
    // InternalETMap.g:992:1: rule__MappingModel__Group__0 : rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1 ;
    public final void rule__MappingModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:996:1: ( rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1 )
            // InternalETMap.g:997:2: rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1
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
    // InternalETMap.g:1004:1: rule__MappingModel__Group__0__Impl : ( 'MappingModel' ) ;
    public final void rule__MappingModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1008:1: ( ( 'MappingModel' ) )
            // InternalETMap.g:1009:1: ( 'MappingModel' )
            {
            // InternalETMap.g:1009:1: ( 'MappingModel' )
            // InternalETMap.g:1010:2: 'MappingModel'
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
    // InternalETMap.g:1019:1: rule__MappingModel__Group__1 : rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2 ;
    public final void rule__MappingModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1023:1: ( rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2 )
            // InternalETMap.g:1024:2: rule__MappingModel__Group__1__Impl rule__MappingModel__Group__2
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
    // InternalETMap.g:1031:1: rule__MappingModel__Group__1__Impl : ( ( rule__MappingModel__NameAssignment_1 ) ) ;
    public final void rule__MappingModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1035:1: ( ( ( rule__MappingModel__NameAssignment_1 ) ) )
            // InternalETMap.g:1036:1: ( ( rule__MappingModel__NameAssignment_1 ) )
            {
            // InternalETMap.g:1036:1: ( ( rule__MappingModel__NameAssignment_1 ) )
            // InternalETMap.g:1037:2: ( rule__MappingModel__NameAssignment_1 )
            {
             before(grammarAccess.getMappingModelAccess().getNameAssignment_1()); 
            // InternalETMap.g:1038:2: ( rule__MappingModel__NameAssignment_1 )
            // InternalETMap.g:1038:3: rule__MappingModel__NameAssignment_1
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
    // InternalETMap.g:1046:1: rule__MappingModel__Group__2 : rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3 ;
    public final void rule__MappingModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1050:1: ( rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3 )
            // InternalETMap.g:1051:2: rule__MappingModel__Group__2__Impl rule__MappingModel__Group__3
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
    // InternalETMap.g:1058:1: rule__MappingModel__Group__2__Impl : ( '{' ) ;
    public final void rule__MappingModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1062:1: ( ( '{' ) )
            // InternalETMap.g:1063:1: ( '{' )
            {
            // InternalETMap.g:1063:1: ( '{' )
            // InternalETMap.g:1064:2: '{'
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
    // InternalETMap.g:1073:1: rule__MappingModel__Group__3 : rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4 ;
    public final void rule__MappingModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1077:1: ( rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4 )
            // InternalETMap.g:1078:2: rule__MappingModel__Group__3__Impl rule__MappingModel__Group__4
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
    // InternalETMap.g:1085:1: rule__MappingModel__Group__3__Impl : ( ( rule__MappingModel__ImportsAssignment_3 )* ) ;
    public final void rule__MappingModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1089:1: ( ( ( rule__MappingModel__ImportsAssignment_3 )* ) )
            // InternalETMap.g:1090:1: ( ( rule__MappingModel__ImportsAssignment_3 )* )
            {
            // InternalETMap.g:1090:1: ( ( rule__MappingModel__ImportsAssignment_3 )* )
            // InternalETMap.g:1091:2: ( rule__MappingModel__ImportsAssignment_3 )*
            {
             before(grammarAccess.getMappingModelAccess().getImportsAssignment_3()); 
            // InternalETMap.g:1092:2: ( rule__MappingModel__ImportsAssignment_3 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==34) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalETMap.g:1092:3: rule__MappingModel__ImportsAssignment_3
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
    // InternalETMap.g:1100:1: rule__MappingModel__Group__4 : rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5 ;
    public final void rule__MappingModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1104:1: ( rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5 )
            // InternalETMap.g:1105:2: rule__MappingModel__Group__4__Impl rule__MappingModel__Group__5
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
    // InternalETMap.g:1112:1: rule__MappingModel__Group__4__Impl : ( ( rule__MappingModel__MappingsAssignment_4 )* ) ;
    public final void rule__MappingModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1116:1: ( ( ( rule__MappingModel__MappingsAssignment_4 )* ) )
            // InternalETMap.g:1117:1: ( ( rule__MappingModel__MappingsAssignment_4 )* )
            {
            // InternalETMap.g:1117:1: ( ( rule__MappingModel__MappingsAssignment_4 )* )
            // InternalETMap.g:1118:2: ( rule__MappingModel__MappingsAssignment_4 )*
            {
             before(grammarAccess.getMappingModelAccess().getMappingsAssignment_4()); 
            // InternalETMap.g:1119:2: ( rule__MappingModel__MappingsAssignment_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==26) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalETMap.g:1119:3: rule__MappingModel__MappingsAssignment_4
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
    // InternalETMap.g:1127:1: rule__MappingModel__Group__5 : rule__MappingModel__Group__5__Impl ;
    public final void rule__MappingModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1131:1: ( rule__MappingModel__Group__5__Impl )
            // InternalETMap.g:1132:2: rule__MappingModel__Group__5__Impl
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
    // InternalETMap.g:1138:1: rule__MappingModel__Group__5__Impl : ( '}' ) ;
    public final void rule__MappingModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1142:1: ( ( '}' ) )
            // InternalETMap.g:1143:1: ( '}' )
            {
            // InternalETMap.g:1143:1: ( '}' )
            // InternalETMap.g:1144:2: '}'
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
    // InternalETMap.g:1154:1: rule__Mapping__Group__0 : rule__Mapping__Group__0__Impl rule__Mapping__Group__1 ;
    public final void rule__Mapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1158:1: ( rule__Mapping__Group__0__Impl rule__Mapping__Group__1 )
            // InternalETMap.g:1159:2: rule__Mapping__Group__0__Impl rule__Mapping__Group__1
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
    // InternalETMap.g:1166:1: rule__Mapping__Group__0__Impl : ( 'Mapping' ) ;
    public final void rule__Mapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1170:1: ( ( 'Mapping' ) )
            // InternalETMap.g:1171:1: ( 'Mapping' )
            {
            // InternalETMap.g:1171:1: ( 'Mapping' )
            // InternalETMap.g:1172:2: 'Mapping'
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
    // InternalETMap.g:1181:1: rule__Mapping__Group__1 : rule__Mapping__Group__1__Impl rule__Mapping__Group__2 ;
    public final void rule__Mapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1185:1: ( rule__Mapping__Group__1__Impl rule__Mapping__Group__2 )
            // InternalETMap.g:1186:2: rule__Mapping__Group__1__Impl rule__Mapping__Group__2
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
    // InternalETMap.g:1193:1: rule__Mapping__Group__1__Impl : ( ( rule__Mapping__LogicalSysAssignment_1 ) ) ;
    public final void rule__Mapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1197:1: ( ( ( rule__Mapping__LogicalSysAssignment_1 ) ) )
            // InternalETMap.g:1198:1: ( ( rule__Mapping__LogicalSysAssignment_1 ) )
            {
            // InternalETMap.g:1198:1: ( ( rule__Mapping__LogicalSysAssignment_1 ) )
            // InternalETMap.g:1199:2: ( rule__Mapping__LogicalSysAssignment_1 )
            {
             before(grammarAccess.getMappingAccess().getLogicalSysAssignment_1()); 
            // InternalETMap.g:1200:2: ( rule__Mapping__LogicalSysAssignment_1 )
            // InternalETMap.g:1200:3: rule__Mapping__LogicalSysAssignment_1
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
    // InternalETMap.g:1208:1: rule__Mapping__Group__2 : rule__Mapping__Group__2__Impl rule__Mapping__Group__3 ;
    public final void rule__Mapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1212:1: ( rule__Mapping__Group__2__Impl rule__Mapping__Group__3 )
            // InternalETMap.g:1213:2: rule__Mapping__Group__2__Impl rule__Mapping__Group__3
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
    // InternalETMap.g:1220:1: rule__Mapping__Group__2__Impl : ( '->' ) ;
    public final void rule__Mapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1224:1: ( ( '->' ) )
            // InternalETMap.g:1225:1: ( '->' )
            {
            // InternalETMap.g:1225:1: ( '->' )
            // InternalETMap.g:1226:2: '->'
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
    // InternalETMap.g:1235:1: rule__Mapping__Group__3 : rule__Mapping__Group__3__Impl rule__Mapping__Group__4 ;
    public final void rule__Mapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1239:1: ( rule__Mapping__Group__3__Impl rule__Mapping__Group__4 )
            // InternalETMap.g:1240:2: rule__Mapping__Group__3__Impl rule__Mapping__Group__4
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
    // InternalETMap.g:1247:1: rule__Mapping__Group__3__Impl : ( ( rule__Mapping__PhysicalSysAssignment_3 ) ) ;
    public final void rule__Mapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1251:1: ( ( ( rule__Mapping__PhysicalSysAssignment_3 ) ) )
            // InternalETMap.g:1252:1: ( ( rule__Mapping__PhysicalSysAssignment_3 ) )
            {
            // InternalETMap.g:1252:1: ( ( rule__Mapping__PhysicalSysAssignment_3 ) )
            // InternalETMap.g:1253:2: ( rule__Mapping__PhysicalSysAssignment_3 )
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysAssignment_3()); 
            // InternalETMap.g:1254:2: ( rule__Mapping__PhysicalSysAssignment_3 )
            // InternalETMap.g:1254:3: rule__Mapping__PhysicalSysAssignment_3
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
    // InternalETMap.g:1262:1: rule__Mapping__Group__4 : rule__Mapping__Group__4__Impl rule__Mapping__Group__5 ;
    public final void rule__Mapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1266:1: ( rule__Mapping__Group__4__Impl rule__Mapping__Group__5 )
            // InternalETMap.g:1267:2: rule__Mapping__Group__4__Impl rule__Mapping__Group__5
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
    // InternalETMap.g:1274:1: rule__Mapping__Group__4__Impl : ( '{' ) ;
    public final void rule__Mapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1278:1: ( ( '{' ) )
            // InternalETMap.g:1279:1: ( '{' )
            {
            // InternalETMap.g:1279:1: ( '{' )
            // InternalETMap.g:1280:2: '{'
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
    // InternalETMap.g:1289:1: rule__Mapping__Group__5 : rule__Mapping__Group__5__Impl rule__Mapping__Group__6 ;
    public final void rule__Mapping__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1293:1: ( rule__Mapping__Group__5__Impl rule__Mapping__Group__6 )
            // InternalETMap.g:1294:2: rule__Mapping__Group__5__Impl rule__Mapping__Group__6
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
    // InternalETMap.g:1301:1: rule__Mapping__Group__5__Impl : ( ( rule__Mapping__SubsysMappingsAssignment_5 )* ) ;
    public final void rule__Mapping__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1305:1: ( ( ( rule__Mapping__SubsysMappingsAssignment_5 )* ) )
            // InternalETMap.g:1306:1: ( ( rule__Mapping__SubsysMappingsAssignment_5 )* )
            {
            // InternalETMap.g:1306:1: ( ( rule__Mapping__SubsysMappingsAssignment_5 )* )
            // InternalETMap.g:1307:2: ( rule__Mapping__SubsysMappingsAssignment_5 )*
            {
             before(grammarAccess.getMappingAccess().getSubsysMappingsAssignment_5()); 
            // InternalETMap.g:1308:2: ( rule__Mapping__SubsysMappingsAssignment_5 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==28) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalETMap.g:1308:3: rule__Mapping__SubsysMappingsAssignment_5
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
    // InternalETMap.g:1316:1: rule__Mapping__Group__6 : rule__Mapping__Group__6__Impl ;
    public final void rule__Mapping__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1320:1: ( rule__Mapping__Group__6__Impl )
            // InternalETMap.g:1321:2: rule__Mapping__Group__6__Impl
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
    // InternalETMap.g:1327:1: rule__Mapping__Group__6__Impl : ( '}' ) ;
    public final void rule__Mapping__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1331:1: ( ( '}' ) )
            // InternalETMap.g:1332:1: ( '}' )
            {
            // InternalETMap.g:1332:1: ( '}' )
            // InternalETMap.g:1333:2: '}'
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
    // InternalETMap.g:1343:1: rule__SubSystemMapping__Group__0 : rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1 ;
    public final void rule__SubSystemMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1347:1: ( rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1 )
            // InternalETMap.g:1348:2: rule__SubSystemMapping__Group__0__Impl rule__SubSystemMapping__Group__1
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
    // InternalETMap.g:1355:1: rule__SubSystemMapping__Group__0__Impl : ( 'SubSystemMapping' ) ;
    public final void rule__SubSystemMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1359:1: ( ( 'SubSystemMapping' ) )
            // InternalETMap.g:1360:1: ( 'SubSystemMapping' )
            {
            // InternalETMap.g:1360:1: ( 'SubSystemMapping' )
            // InternalETMap.g:1361:2: 'SubSystemMapping'
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
    // InternalETMap.g:1370:1: rule__SubSystemMapping__Group__1 : rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2 ;
    public final void rule__SubSystemMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1374:1: ( rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2 )
            // InternalETMap.g:1375:2: rule__SubSystemMapping__Group__1__Impl rule__SubSystemMapping__Group__2
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
    // InternalETMap.g:1382:1: rule__SubSystemMapping__Group__1__Impl : ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) ) ;
    public final void rule__SubSystemMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1386:1: ( ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) ) )
            // InternalETMap.g:1387:1: ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) )
            {
            // InternalETMap.g:1387:1: ( ( rule__SubSystemMapping__LogicalSubSysAssignment_1 ) )
            // InternalETMap.g:1388:2: ( rule__SubSystemMapping__LogicalSubSysAssignment_1 )
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysAssignment_1()); 
            // InternalETMap.g:1389:2: ( rule__SubSystemMapping__LogicalSubSysAssignment_1 )
            // InternalETMap.g:1389:3: rule__SubSystemMapping__LogicalSubSysAssignment_1
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
    // InternalETMap.g:1397:1: rule__SubSystemMapping__Group__2 : rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3 ;
    public final void rule__SubSystemMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1401:1: ( rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3 )
            // InternalETMap.g:1402:2: rule__SubSystemMapping__Group__2__Impl rule__SubSystemMapping__Group__3
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
    // InternalETMap.g:1409:1: rule__SubSystemMapping__Group__2__Impl : ( '->' ) ;
    public final void rule__SubSystemMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1413:1: ( ( '->' ) )
            // InternalETMap.g:1414:1: ( '->' )
            {
            // InternalETMap.g:1414:1: ( '->' )
            // InternalETMap.g:1415:2: '->'
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
    // InternalETMap.g:1424:1: rule__SubSystemMapping__Group__3 : rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4 ;
    public final void rule__SubSystemMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1428:1: ( rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4 )
            // InternalETMap.g:1429:2: rule__SubSystemMapping__Group__3__Impl rule__SubSystemMapping__Group__4
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
    // InternalETMap.g:1436:1: rule__SubSystemMapping__Group__3__Impl : ( ( rule__SubSystemMapping__NodeAssignment_3 ) ) ;
    public final void rule__SubSystemMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1440:1: ( ( ( rule__SubSystemMapping__NodeAssignment_3 ) ) )
            // InternalETMap.g:1441:1: ( ( rule__SubSystemMapping__NodeAssignment_3 ) )
            {
            // InternalETMap.g:1441:1: ( ( rule__SubSystemMapping__NodeAssignment_3 ) )
            // InternalETMap.g:1442:2: ( rule__SubSystemMapping__NodeAssignment_3 )
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeAssignment_3()); 
            // InternalETMap.g:1443:2: ( rule__SubSystemMapping__NodeAssignment_3 )
            // InternalETMap.g:1443:3: rule__SubSystemMapping__NodeAssignment_3
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
    // InternalETMap.g:1451:1: rule__SubSystemMapping__Group__4 : rule__SubSystemMapping__Group__4__Impl ;
    public final void rule__SubSystemMapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1455:1: ( rule__SubSystemMapping__Group__4__Impl )
            // InternalETMap.g:1456:2: rule__SubSystemMapping__Group__4__Impl
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
    // InternalETMap.g:1462:1: rule__SubSystemMapping__Group__4__Impl : ( ( rule__SubSystemMapping__Group_4__0 )? ) ;
    public final void rule__SubSystemMapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1466:1: ( ( ( rule__SubSystemMapping__Group_4__0 )? ) )
            // InternalETMap.g:1467:1: ( ( rule__SubSystemMapping__Group_4__0 )? )
            {
            // InternalETMap.g:1467:1: ( ( rule__SubSystemMapping__Group_4__0 )? )
            // InternalETMap.g:1468:2: ( rule__SubSystemMapping__Group_4__0 )?
            {
             before(grammarAccess.getSubSystemMappingAccess().getGroup_4()); 
            // InternalETMap.g:1469:2: ( rule__SubSystemMapping__Group_4__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==24) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalETMap.g:1469:3: rule__SubSystemMapping__Group_4__0
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
    // InternalETMap.g:1478:1: rule__SubSystemMapping__Group_4__0 : rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1 ;
    public final void rule__SubSystemMapping__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1482:1: ( rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1 )
            // InternalETMap.g:1483:2: rule__SubSystemMapping__Group_4__0__Impl rule__SubSystemMapping__Group_4__1
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
    // InternalETMap.g:1490:1: rule__SubSystemMapping__Group_4__0__Impl : ( '{' ) ;
    public final void rule__SubSystemMapping__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1494:1: ( ( '{' ) )
            // InternalETMap.g:1495:1: ( '{' )
            {
            // InternalETMap.g:1495:1: ( '{' )
            // InternalETMap.g:1496:2: '{'
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
    // InternalETMap.g:1505:1: rule__SubSystemMapping__Group_4__1 : rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2 ;
    public final void rule__SubSystemMapping__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1509:1: ( rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2 )
            // InternalETMap.g:1510:2: rule__SubSystemMapping__Group_4__1__Impl rule__SubSystemMapping__Group_4__2
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
    // InternalETMap.g:1517:1: rule__SubSystemMapping__Group_4__1__Impl : ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* ) ;
    public final void rule__SubSystemMapping__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1521:1: ( ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* ) )
            // InternalETMap.g:1522:1: ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* )
            {
            // InternalETMap.g:1522:1: ( ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )* )
            // InternalETMap.g:1523:2: ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )*
            {
             before(grammarAccess.getSubSystemMappingAccess().getThreadMappingsAssignment_4_1()); 
            // InternalETMap.g:1524:2: ( rule__SubSystemMapping__ThreadMappingsAssignment_4_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==29) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalETMap.g:1524:3: rule__SubSystemMapping__ThreadMappingsAssignment_4_1
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
    // InternalETMap.g:1532:1: rule__SubSystemMapping__Group_4__2 : rule__SubSystemMapping__Group_4__2__Impl ;
    public final void rule__SubSystemMapping__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1536:1: ( rule__SubSystemMapping__Group_4__2__Impl )
            // InternalETMap.g:1537:2: rule__SubSystemMapping__Group_4__2__Impl
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
    // InternalETMap.g:1543:1: rule__SubSystemMapping__Group_4__2__Impl : ( '}' ) ;
    public final void rule__SubSystemMapping__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1547:1: ( ( '}' ) )
            // InternalETMap.g:1548:1: ( '}' )
            {
            // InternalETMap.g:1548:1: ( '}' )
            // InternalETMap.g:1549:2: '}'
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
    // InternalETMap.g:1559:1: rule__ThreadMapping__Group__0 : rule__ThreadMapping__Group__0__Impl rule__ThreadMapping__Group__1 ;
    public final void rule__ThreadMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1563:1: ( rule__ThreadMapping__Group__0__Impl rule__ThreadMapping__Group__1 )
            // InternalETMap.g:1564:2: rule__ThreadMapping__Group__0__Impl rule__ThreadMapping__Group__1
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
    // InternalETMap.g:1571:1: rule__ThreadMapping__Group__0__Impl : ( 'ThreadMapping' ) ;
    public final void rule__ThreadMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1575:1: ( ( 'ThreadMapping' ) )
            // InternalETMap.g:1576:1: ( 'ThreadMapping' )
            {
            // InternalETMap.g:1576:1: ( 'ThreadMapping' )
            // InternalETMap.g:1577:2: 'ThreadMapping'
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
    // InternalETMap.g:1586:1: rule__ThreadMapping__Group__1 : rule__ThreadMapping__Group__1__Impl rule__ThreadMapping__Group__2 ;
    public final void rule__ThreadMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1590:1: ( rule__ThreadMapping__Group__1__Impl rule__ThreadMapping__Group__2 )
            // InternalETMap.g:1591:2: rule__ThreadMapping__Group__1__Impl rule__ThreadMapping__Group__2
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
    // InternalETMap.g:1598:1: rule__ThreadMapping__Group__1__Impl : ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) ) ;
    public final void rule__ThreadMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1602:1: ( ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) ) )
            // InternalETMap.g:1603:1: ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) )
            {
            // InternalETMap.g:1603:1: ( ( rule__ThreadMapping__LogicalThreadAssignment_1 ) )
            // InternalETMap.g:1604:2: ( rule__ThreadMapping__LogicalThreadAssignment_1 )
            {
             before(grammarAccess.getThreadMappingAccess().getLogicalThreadAssignment_1()); 
            // InternalETMap.g:1605:2: ( rule__ThreadMapping__LogicalThreadAssignment_1 )
            // InternalETMap.g:1605:3: rule__ThreadMapping__LogicalThreadAssignment_1
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
    // InternalETMap.g:1613:1: rule__ThreadMapping__Group__2 : rule__ThreadMapping__Group__2__Impl rule__ThreadMapping__Group__3 ;
    public final void rule__ThreadMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1617:1: ( rule__ThreadMapping__Group__2__Impl rule__ThreadMapping__Group__3 )
            // InternalETMap.g:1618:2: rule__ThreadMapping__Group__2__Impl rule__ThreadMapping__Group__3
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
    // InternalETMap.g:1625:1: rule__ThreadMapping__Group__2__Impl : ( '->' ) ;
    public final void rule__ThreadMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1629:1: ( ( '->' ) )
            // InternalETMap.g:1630:1: ( '->' )
            {
            // InternalETMap.g:1630:1: ( '->' )
            // InternalETMap.g:1631:2: '->'
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
    // InternalETMap.g:1640:1: rule__ThreadMapping__Group__3 : rule__ThreadMapping__Group__3__Impl ;
    public final void rule__ThreadMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1644:1: ( rule__ThreadMapping__Group__3__Impl )
            // InternalETMap.g:1645:2: rule__ThreadMapping__Group__3__Impl
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
    // InternalETMap.g:1651:1: rule__ThreadMapping__Group__3__Impl : ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) ) ;
    public final void rule__ThreadMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1655:1: ( ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) ) )
            // InternalETMap.g:1656:1: ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) )
            {
            // InternalETMap.g:1656:1: ( ( rule__ThreadMapping__PhysicalThreadAssignment_3 ) )
            // InternalETMap.g:1657:2: ( rule__ThreadMapping__PhysicalThreadAssignment_3 )
            {
             before(grammarAccess.getThreadMappingAccess().getPhysicalThreadAssignment_3()); 
            // InternalETMap.g:1658:2: ( rule__ThreadMapping__PhysicalThreadAssignment_3 )
            // InternalETMap.g:1658:3: rule__ThreadMapping__PhysicalThreadAssignment_3
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
    // InternalETMap.g:1667:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1671:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // InternalETMap.g:1672:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
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
    // InternalETMap.g:1679:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1683:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // InternalETMap.g:1684:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // InternalETMap.g:1684:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // InternalETMap.g:1685:2: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // InternalETMap.g:1686:2: ( rule__KeyValue__KeyAssignment_0 )
            // InternalETMap.g:1686:3: rule__KeyValue__KeyAssignment_0
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
    // InternalETMap.g:1694:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1698:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // InternalETMap.g:1699:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
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
    // InternalETMap.g:1706:1: rule__KeyValue__Group__1__Impl : ( '=' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1710:1: ( ( '=' ) )
            // InternalETMap.g:1711:1: ( '=' )
            {
            // InternalETMap.g:1711:1: ( '=' )
            // InternalETMap.g:1712:2: '='
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
    // InternalETMap.g:1721:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1725:1: ( rule__KeyValue__Group__2__Impl )
            // InternalETMap.g:1726:2: rule__KeyValue__Group__2__Impl
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
    // InternalETMap.g:1732:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1736:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // InternalETMap.g:1737:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // InternalETMap.g:1737:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // InternalETMap.g:1738:2: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // InternalETMap.g:1739:2: ( rule__KeyValue__ValueAssignment_2 )
            // InternalETMap.g:1739:3: rule__KeyValue__ValueAssignment_2
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
    // InternalETMap.g:1748:1: rule__SimpleAnnotationAttribute__Group__0 : rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 ;
    public final void rule__SimpleAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1752:1: ( rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 )
            // InternalETMap.g:1753:2: rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1
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
    // InternalETMap.g:1760:1: rule__SimpleAnnotationAttribute__Group__0__Impl : ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1764:1: ( ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) )
            // InternalETMap.g:1765:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            {
            // InternalETMap.g:1765:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            // InternalETMap.g:1766:2: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 
            // InternalETMap.g:1767:2: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            // InternalETMap.g:1767:3: rule__SimpleAnnotationAttribute__Alternatives_0
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
    // InternalETMap.g:1775:1: rule__SimpleAnnotationAttribute__Group__1 : rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 ;
    public final void rule__SimpleAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1779:1: ( rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 )
            // InternalETMap.g:1780:2: rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2
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
    // InternalETMap.g:1787:1: rule__SimpleAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1791:1: ( ( 'attribute' ) )
            // InternalETMap.g:1792:1: ( 'attribute' )
            {
            // InternalETMap.g:1792:1: ( 'attribute' )
            // InternalETMap.g:1793:2: 'attribute'
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
    // InternalETMap.g:1802:1: rule__SimpleAnnotationAttribute__Group__2 : rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 ;
    public final void rule__SimpleAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1806:1: ( rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 )
            // InternalETMap.g:1807:2: rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3
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
    // InternalETMap.g:1814:1: rule__SimpleAnnotationAttribute__Group__2__Impl : ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1818:1: ( ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) )
            // InternalETMap.g:1819:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            {
            // InternalETMap.g:1819:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            // InternalETMap.g:1820:2: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 
            // InternalETMap.g:1821:2: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            // InternalETMap.g:1821:3: rule__SimpleAnnotationAttribute__NameAssignment_2
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
    // InternalETMap.g:1829:1: rule__SimpleAnnotationAttribute__Group__3 : rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 ;
    public final void rule__SimpleAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1833:1: ( rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 )
            // InternalETMap.g:1834:2: rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4
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
    // InternalETMap.g:1841:1: rule__SimpleAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1845:1: ( ( ':' ) )
            // InternalETMap.g:1846:1: ( ':' )
            {
            // InternalETMap.g:1846:1: ( ':' )
            // InternalETMap.g:1847:2: ':'
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
    // InternalETMap.g:1856:1: rule__SimpleAnnotationAttribute__Group__4 : rule__SimpleAnnotationAttribute__Group__4__Impl ;
    public final void rule__SimpleAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1860:1: ( rule__SimpleAnnotationAttribute__Group__4__Impl )
            // InternalETMap.g:1861:2: rule__SimpleAnnotationAttribute__Group__4__Impl
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
    // InternalETMap.g:1867:1: rule__SimpleAnnotationAttribute__Group__4__Impl : ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1871:1: ( ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) )
            // InternalETMap.g:1872:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            {
            // InternalETMap.g:1872:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            // InternalETMap.g:1873:2: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 
            // InternalETMap.g:1874:2: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            // InternalETMap.g:1874:3: rule__SimpleAnnotationAttribute__TypeAssignment_4
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
    // InternalETMap.g:1883:1: rule__EnumAnnotationAttribute__Group__0 : rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 ;
    public final void rule__EnumAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1887:1: ( rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 )
            // InternalETMap.g:1888:2: rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1
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
    // InternalETMap.g:1895:1: rule__EnumAnnotationAttribute__Group__0__Impl : ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1899:1: ( ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) )
            // InternalETMap.g:1900:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            {
            // InternalETMap.g:1900:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            // InternalETMap.g:1901:2: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 
            // InternalETMap.g:1902:2: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            // InternalETMap.g:1902:3: rule__EnumAnnotationAttribute__Alternatives_0
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
    // InternalETMap.g:1910:1: rule__EnumAnnotationAttribute__Group__1 : rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 ;
    public final void rule__EnumAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1914:1: ( rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 )
            // InternalETMap.g:1915:2: rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2
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
    // InternalETMap.g:1922:1: rule__EnumAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__EnumAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1926:1: ( ( 'attribute' ) )
            // InternalETMap.g:1927:1: ( 'attribute' )
            {
            // InternalETMap.g:1927:1: ( 'attribute' )
            // InternalETMap.g:1928:2: 'attribute'
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
    // InternalETMap.g:1937:1: rule__EnumAnnotationAttribute__Group__2 : rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 ;
    public final void rule__EnumAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1941:1: ( rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 )
            // InternalETMap.g:1942:2: rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3
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
    // InternalETMap.g:1949:1: rule__EnumAnnotationAttribute__Group__2__Impl : ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1953:1: ( ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) )
            // InternalETMap.g:1954:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            {
            // InternalETMap.g:1954:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            // InternalETMap.g:1955:2: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 
            // InternalETMap.g:1956:2: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            // InternalETMap.g:1956:3: rule__EnumAnnotationAttribute__NameAssignment_2
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
    // InternalETMap.g:1964:1: rule__EnumAnnotationAttribute__Group__3 : rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 ;
    public final void rule__EnumAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1968:1: ( rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 )
            // InternalETMap.g:1969:2: rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4
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
    // InternalETMap.g:1976:1: rule__EnumAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1980:1: ( ( ':' ) )
            // InternalETMap.g:1981:1: ( ':' )
            {
            // InternalETMap.g:1981:1: ( ':' )
            // InternalETMap.g:1982:2: ':'
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
    // InternalETMap.g:1991:1: rule__EnumAnnotationAttribute__Group__4 : rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 ;
    public final void rule__EnumAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:1995:1: ( rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 )
            // InternalETMap.g:1996:2: rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5
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
    // InternalETMap.g:2003:1: rule__EnumAnnotationAttribute__Group__4__Impl : ( '{' ) ;
    public final void rule__EnumAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2007:1: ( ( '{' ) )
            // InternalETMap.g:2008:1: ( '{' )
            {
            // InternalETMap.g:2008:1: ( '{' )
            // InternalETMap.g:2009:2: '{'
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
    // InternalETMap.g:2018:1: rule__EnumAnnotationAttribute__Group__5 : rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 ;
    public final void rule__EnumAnnotationAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2022:1: ( rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 )
            // InternalETMap.g:2023:2: rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6
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
    // InternalETMap.g:2030:1: rule__EnumAnnotationAttribute__Group__5__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2034:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) )
            // InternalETMap.g:2035:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            {
            // InternalETMap.g:2035:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            // InternalETMap.g:2036:2: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 
            // InternalETMap.g:2037:2: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            // InternalETMap.g:2037:3: rule__EnumAnnotationAttribute__ValuesAssignment_5
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
    // InternalETMap.g:2045:1: rule__EnumAnnotationAttribute__Group__6 : rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 ;
    public final void rule__EnumAnnotationAttribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2049:1: ( rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 )
            // InternalETMap.g:2050:2: rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7
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
    // InternalETMap.g:2057:1: rule__EnumAnnotationAttribute__Group__6__Impl : ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) ;
    public final void rule__EnumAnnotationAttribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2061:1: ( ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) )
            // InternalETMap.g:2062:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            {
            // InternalETMap.g:2062:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            // InternalETMap.g:2063:2: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 
            // InternalETMap.g:2064:2: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==33) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalETMap.g:2064:3: rule__EnumAnnotationAttribute__Group_6__0
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
    // InternalETMap.g:2072:1: rule__EnumAnnotationAttribute__Group__7 : rule__EnumAnnotationAttribute__Group__7__Impl ;
    public final void rule__EnumAnnotationAttribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2076:1: ( rule__EnumAnnotationAttribute__Group__7__Impl )
            // InternalETMap.g:2077:2: rule__EnumAnnotationAttribute__Group__7__Impl
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
    // InternalETMap.g:2083:1: rule__EnumAnnotationAttribute__Group__7__Impl : ( '}' ) ;
    public final void rule__EnumAnnotationAttribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2087:1: ( ( '}' ) )
            // InternalETMap.g:2088:1: ( '}' )
            {
            // InternalETMap.g:2088:1: ( '}' )
            // InternalETMap.g:2089:2: '}'
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
    // InternalETMap.g:2099:1: rule__EnumAnnotationAttribute__Group_6__0 : rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 ;
    public final void rule__EnumAnnotationAttribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2103:1: ( rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 )
            // InternalETMap.g:2104:2: rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1
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
    // InternalETMap.g:2111:1: rule__EnumAnnotationAttribute__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2115:1: ( ( ',' ) )
            // InternalETMap.g:2116:1: ( ',' )
            {
            // InternalETMap.g:2116:1: ( ',' )
            // InternalETMap.g:2117:2: ','
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
    // InternalETMap.g:2126:1: rule__EnumAnnotationAttribute__Group_6__1 : rule__EnumAnnotationAttribute__Group_6__1__Impl ;
    public final void rule__EnumAnnotationAttribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2130:1: ( rule__EnumAnnotationAttribute__Group_6__1__Impl )
            // InternalETMap.g:2131:2: rule__EnumAnnotationAttribute__Group_6__1__Impl
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
    // InternalETMap.g:2137:1: rule__EnumAnnotationAttribute__Group_6__1__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2141:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) )
            // InternalETMap.g:2142:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            {
            // InternalETMap.g:2142:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            // InternalETMap.g:2143:2: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 
            // InternalETMap.g:2144:2: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            // InternalETMap.g:2144:3: rule__EnumAnnotationAttribute__ValuesAssignment_6_1
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
    // InternalETMap.g:2153:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2157:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalETMap.g:2158:2: rule__Import__Group__0__Impl rule__Import__Group__1
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
    // InternalETMap.g:2165:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2169:1: ( ( 'import' ) )
            // InternalETMap.g:2170:1: ( 'import' )
            {
            // InternalETMap.g:2170:1: ( 'import' )
            // InternalETMap.g:2171:2: 'import'
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
    // InternalETMap.g:2180:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2184:1: ( rule__Import__Group__1__Impl )
            // InternalETMap.g:2185:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalETMap.g:2191:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2195:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // InternalETMap.g:2196:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // InternalETMap.g:2196:1: ( ( rule__Import__Alternatives_1 ) )
            // InternalETMap.g:2197:2: ( rule__Import__Alternatives_1 )
            {
             before(grammarAccess.getImportAccess().getAlternatives_1()); 
            // InternalETMap.g:2198:2: ( rule__Import__Alternatives_1 )
            // InternalETMap.g:2198:3: rule__Import__Alternatives_1
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


    // $ANTLR start "rule__Import__Group_1_0__0"
    // InternalETMap.g:2207:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2211:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // InternalETMap.g:2212:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
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
    // InternalETMap.g:2219:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2223:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // InternalETMap.g:2224:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // InternalETMap.g:2224:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // InternalETMap.g:2225:2: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            // InternalETMap.g:2226:2: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // InternalETMap.g:2226:3: rule__Import__ImportedNamespaceAssignment_1_0_0
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
    // InternalETMap.g:2234:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2238:1: ( rule__Import__Group_1_0__1__Impl )
            // InternalETMap.g:2239:2: rule__Import__Group_1_0__1__Impl
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
    // InternalETMap.g:2245:1: rule__Import__Group_1_0__1__Impl : ( ( rule__Import__Group_1_0_1__0 )? ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2249:1: ( ( ( rule__Import__Group_1_0_1__0 )? ) )
            // InternalETMap.g:2250:1: ( ( rule__Import__Group_1_0_1__0 )? )
            {
            // InternalETMap.g:2250:1: ( ( rule__Import__Group_1_0_1__0 )? )
            // InternalETMap.g:2251:2: ( rule__Import__Group_1_0_1__0 )?
            {
             before(grammarAccess.getImportAccess().getGroup_1_0_1()); 
            // InternalETMap.g:2252:2: ( rule__Import__Group_1_0_1__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==35) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalETMap.g:2252:3: rule__Import__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Import__Group_1_0_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getImportAccess().getGroup_1_0_1()); 

            }


            }

        }
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
    // InternalETMap.g:2261:1: rule__Import__Group_1_0_1__0 : rule__Import__Group_1_0_1__0__Impl rule__Import__Group_1_0_1__1 ;
    public final void rule__Import__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2265:1: ( rule__Import__Group_1_0_1__0__Impl rule__Import__Group_1_0_1__1 )
            // InternalETMap.g:2266:2: rule__Import__Group_1_0_1__0__Impl rule__Import__Group_1_0_1__1
            {
            pushFollow(FOLLOW_18);
            rule__Import__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group_1_0_1__1();

            state._fsp--;


            }

        }
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
    // InternalETMap.g:2273:1: rule__Import__Group_1_0_1__0__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2277:1: ( ( 'from' ) )
            // InternalETMap.g:2278:1: ( 'from' )
            {
            // InternalETMap.g:2278:1: ( 'from' )
            // InternalETMap.g:2279:2: 'from'
            {
             before(grammarAccess.getImportAccess().getFromKeyword_1_0_1_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getFromKeyword_1_0_1_0()); 

            }


            }

        }
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
    // InternalETMap.g:2288:1: rule__Import__Group_1_0_1__1 : rule__Import__Group_1_0_1__1__Impl ;
    public final void rule__Import__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2292:1: ( rule__Import__Group_1_0_1__1__Impl )
            // InternalETMap.g:2293:2: rule__Import__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group_1_0_1__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalETMap.g:2299:1: rule__Import__Group_1_0_1__1__Impl : ( ( rule__Import__ImportURIAssignment_1_0_1_1 ) ) ;
    public final void rule__Import__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2303:1: ( ( ( rule__Import__ImportURIAssignment_1_0_1_1 ) ) )
            // InternalETMap.g:2304:1: ( ( rule__Import__ImportURIAssignment_1_0_1_1 ) )
            {
            // InternalETMap.g:2304:1: ( ( rule__Import__ImportURIAssignment_1_0_1_1 ) )
            // InternalETMap.g:2305:2: ( rule__Import__ImportURIAssignment_1_0_1_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1_0_1_1()); 
            // InternalETMap.g:2306:2: ( rule__Import__ImportURIAssignment_1_0_1_1 )
            // InternalETMap.g:2306:3: rule__Import__ImportURIAssignment_1_0_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ImportURIAssignment_1_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1_0_1_1()); 

            }


            }

        }
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
    // InternalETMap.g:2315:1: rule__Import__Group_1_1__0 : rule__Import__Group_1_1__0__Impl rule__Import__Group_1_1__1 ;
    public final void rule__Import__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2319:1: ( rule__Import__Group_1_1__0__Impl rule__Import__Group_1_1__1 )
            // InternalETMap.g:2320:2: rule__Import__Group_1_1__0__Impl rule__Import__Group_1_1__1
            {
            pushFollow(FOLLOW_18);
            rule__Import__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group_1_1__1();

            state._fsp--;


            }

        }
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
    // InternalETMap.g:2327:1: rule__Import__Group_1_1__0__Impl : ( 'model' ) ;
    public final void rule__Import__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2331:1: ( ( 'model' ) )
            // InternalETMap.g:2332:1: ( 'model' )
            {
            // InternalETMap.g:2332:1: ( 'model' )
            // InternalETMap.g:2333:2: 'model'
            {
             before(grammarAccess.getImportAccess().getModelKeyword_1_1_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getModelKeyword_1_1_0()); 

            }


            }

        }
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
    // InternalETMap.g:2342:1: rule__Import__Group_1_1__1 : rule__Import__Group_1_1__1__Impl ;
    public final void rule__Import__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2346:1: ( rule__Import__Group_1_1__1__Impl )
            // InternalETMap.g:2347:2: rule__Import__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalETMap.g:2353:1: rule__Import__Group_1_1__1__Impl : ( ( rule__Import__ImportURIAssignment_1_1_1 ) ) ;
    public final void rule__Import__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2357:1: ( ( ( rule__Import__ImportURIAssignment_1_1_1 ) ) )
            // InternalETMap.g:2358:1: ( ( rule__Import__ImportURIAssignment_1_1_1 ) )
            {
            // InternalETMap.g:2358:1: ( ( rule__Import__ImportURIAssignment_1_1_1 ) )
            // InternalETMap.g:2359:2: ( rule__Import__ImportURIAssignment_1_1_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1_1_1()); 
            // InternalETMap.g:2360:2: ( rule__Import__ImportURIAssignment_1_1_1 )
            // InternalETMap.g:2360:3: rule__Import__ImportURIAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ImportURIAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1_1_1()); 

            }


            }

        }
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
    // InternalETMap.g:2369:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2373:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // InternalETMap.g:2374:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
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
    // InternalETMap.g:2381:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2385:1: ( ( ruleFQN ) )
            // InternalETMap.g:2386:1: ( ruleFQN )
            {
            // InternalETMap.g:2386:1: ( ruleFQN )
            // InternalETMap.g:2387:2: ruleFQN
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
    // InternalETMap.g:2396:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2400:1: ( rule__ImportedFQN__Group__1__Impl )
            // InternalETMap.g:2401:2: rule__ImportedFQN__Group__1__Impl
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
    // InternalETMap.g:2407:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2411:1: ( ( ( '.*' )? ) )
            // InternalETMap.g:2412:1: ( ( '.*' )? )
            {
            // InternalETMap.g:2412:1: ( ( '.*' )? )
            // InternalETMap.g:2413:2: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // InternalETMap.g:2414:2: ( '.*' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==37) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalETMap.g:2414:3: '.*'
                    {
                    match(input,37,FOLLOW_2); 

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
    // InternalETMap.g:2423:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2427:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // InternalETMap.g:2428:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
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
    // InternalETMap.g:2435:1: rule__Documentation__Group__0__Impl : ( () ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2439:1: ( ( () ) )
            // InternalETMap.g:2440:1: ( () )
            {
            // InternalETMap.g:2440:1: ( () )
            // InternalETMap.g:2441:2: ()
            {
             before(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 
            // InternalETMap.g:2442:2: ()
            // InternalETMap.g:2442:3: 
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
    // InternalETMap.g:2450:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2454:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // InternalETMap.g:2455:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
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
    // InternalETMap.g:2462:1: rule__Documentation__Group__1__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2466:1: ( ( '[' ) )
            // InternalETMap.g:2467:1: ( '[' )
            {
            // InternalETMap.g:2467:1: ( '[' )
            // InternalETMap.g:2468:2: '['
            {
             before(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1()); 
            match(input,38,FOLLOW_2); 
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
    // InternalETMap.g:2477:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl rule__Documentation__Group__3 ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2481:1: ( rule__Documentation__Group__2__Impl rule__Documentation__Group__3 )
            // InternalETMap.g:2482:2: rule__Documentation__Group__2__Impl rule__Documentation__Group__3
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
    // InternalETMap.g:2489:1: rule__Documentation__Group__2__Impl : ( ( rule__Documentation__LinesAssignment_2 )* ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2493:1: ( ( ( rule__Documentation__LinesAssignment_2 )* ) )
            // InternalETMap.g:2494:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            {
            // InternalETMap.g:2494:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            // InternalETMap.g:2495:2: ( rule__Documentation__LinesAssignment_2 )*
            {
             before(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 
            // InternalETMap.g:2496:2: ( rule__Documentation__LinesAssignment_2 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_STRING) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalETMap.g:2496:3: rule__Documentation__LinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__Documentation__LinesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalETMap.g:2504:1: rule__Documentation__Group__3 : rule__Documentation__Group__3__Impl ;
    public final void rule__Documentation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2508:1: ( rule__Documentation__Group__3__Impl )
            // InternalETMap.g:2509:2: rule__Documentation__Group__3__Impl
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
    // InternalETMap.g:2515:1: rule__Documentation__Group__3__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2519:1: ( ( ']' ) )
            // InternalETMap.g:2520:1: ( ']' )
            {
            // InternalETMap.g:2520:1: ( ']' )
            // InternalETMap.g:2521:2: ']'
            {
             before(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3()); 
            match(input,39,FOLLOW_2); 
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
    // InternalETMap.g:2531:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2535:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // InternalETMap.g:2536:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
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
    // InternalETMap.g:2543:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2547:1: ( ( () ) )
            // InternalETMap.g:2548:1: ( () )
            {
            // InternalETMap.g:2548:1: ( () )
            // InternalETMap.g:2549:2: ()
            {
             before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            // InternalETMap.g:2550:2: ()
            // InternalETMap.g:2550:3: 
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
    // InternalETMap.g:2558:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2562:1: ( rule__BooleanLiteral__Group__1__Impl )
            // InternalETMap.g:2563:2: rule__BooleanLiteral__Group__1__Impl
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
    // InternalETMap.g:2569:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2573:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // InternalETMap.g:2574:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // InternalETMap.g:2574:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // InternalETMap.g:2575:2: ( rule__BooleanLiteral__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            // InternalETMap.g:2576:2: ( rule__BooleanLiteral__Alternatives_1 )
            // InternalETMap.g:2576:3: rule__BooleanLiteral__Alternatives_1
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
    // InternalETMap.g:2585:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2589:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // InternalETMap.g:2590:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
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
    // InternalETMap.g:2597:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2601:1: ( ( () ) )
            // InternalETMap.g:2602:1: ( () )
            {
            // InternalETMap.g:2602:1: ( () )
            // InternalETMap.g:2603:2: ()
            {
             before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            // InternalETMap.g:2604:2: ()
            // InternalETMap.g:2604:3: 
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
    // InternalETMap.g:2612:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2616:1: ( rule__RealLiteral__Group__1__Impl )
            // InternalETMap.g:2617:2: rule__RealLiteral__Group__1__Impl
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
    // InternalETMap.g:2623:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2627:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // InternalETMap.g:2628:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // InternalETMap.g:2628:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // InternalETMap.g:2629:2: ( rule__RealLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            // InternalETMap.g:2630:2: ( rule__RealLiteral__ValueAssignment_1 )
            // InternalETMap.g:2630:3: rule__RealLiteral__ValueAssignment_1
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
    // InternalETMap.g:2639:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2643:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // InternalETMap.g:2644:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
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
    // InternalETMap.g:2651:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2655:1: ( ( () ) )
            // InternalETMap.g:2656:1: ( () )
            {
            // InternalETMap.g:2656:1: ( () )
            // InternalETMap.g:2657:2: ()
            {
             before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            // InternalETMap.g:2658:2: ()
            // InternalETMap.g:2658:3: 
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
    // InternalETMap.g:2666:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2670:1: ( rule__IntLiteral__Group__1__Impl )
            // InternalETMap.g:2671:2: rule__IntLiteral__Group__1__Impl
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
    // InternalETMap.g:2677:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2681:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // InternalETMap.g:2682:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // InternalETMap.g:2682:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // InternalETMap.g:2683:2: ( rule__IntLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            // InternalETMap.g:2684:2: ( rule__IntLiteral__ValueAssignment_1 )
            // InternalETMap.g:2684:3: rule__IntLiteral__ValueAssignment_1
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
    // InternalETMap.g:2693:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2697:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // InternalETMap.g:2698:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
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
    // InternalETMap.g:2705:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2709:1: ( ( () ) )
            // InternalETMap.g:2710:1: ( () )
            {
            // InternalETMap.g:2710:1: ( () )
            // InternalETMap.g:2711:2: ()
            {
             before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            // InternalETMap.g:2712:2: ()
            // InternalETMap.g:2712:3: 
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
    // InternalETMap.g:2720:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2724:1: ( rule__StringLiteral__Group__1__Impl )
            // InternalETMap.g:2725:2: rule__StringLiteral__Group__1__Impl
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
    // InternalETMap.g:2731:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2735:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // InternalETMap.g:2736:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // InternalETMap.g:2736:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // InternalETMap.g:2737:2: ( rule__StringLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            // InternalETMap.g:2738:2: ( rule__StringLiteral__ValueAssignment_1 )
            // InternalETMap.g:2738:3: rule__StringLiteral__ValueAssignment_1
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
    // InternalETMap.g:2747:1: rule__Integer__Group_0__0 : rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1 ;
    public final void rule__Integer__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2751:1: ( rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1 )
            // InternalETMap.g:2752:2: rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1
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
    // InternalETMap.g:2759:1: rule__Integer__Group_0__0__Impl : ( ( rule__Integer__Alternatives_0_0 )? ) ;
    public final void rule__Integer__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2763:1: ( ( ( rule__Integer__Alternatives_0_0 )? ) )
            // InternalETMap.g:2764:1: ( ( rule__Integer__Alternatives_0_0 )? )
            {
            // InternalETMap.g:2764:1: ( ( rule__Integer__Alternatives_0_0 )? )
            // InternalETMap.g:2765:2: ( rule__Integer__Alternatives_0_0 )?
            {
             before(grammarAccess.getIntegerAccess().getAlternatives_0_0()); 
            // InternalETMap.g:2766:2: ( rule__Integer__Alternatives_0_0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=15 && LA25_0<=16)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalETMap.g:2766:3: rule__Integer__Alternatives_0_0
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
    // InternalETMap.g:2774:1: rule__Integer__Group_0__1 : rule__Integer__Group_0__1__Impl ;
    public final void rule__Integer__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2778:1: ( rule__Integer__Group_0__1__Impl )
            // InternalETMap.g:2779:2: rule__Integer__Group_0__1__Impl
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
    // InternalETMap.g:2785:1: rule__Integer__Group_0__1__Impl : ( RULE_INT ) ;
    public final void rule__Integer__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2789:1: ( ( RULE_INT ) )
            // InternalETMap.g:2790:1: ( RULE_INT )
            {
            // InternalETMap.g:2790:1: ( RULE_INT )
            // InternalETMap.g:2791:2: RULE_INT
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
    // InternalETMap.g:2801:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2805:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // InternalETMap.g:2806:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
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
    // InternalETMap.g:2813:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2817:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // InternalETMap.g:2818:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // InternalETMap.g:2818:1: ( ( rule__Decimal__Alternatives_0 )? )
            // InternalETMap.g:2819:2: ( rule__Decimal__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            // InternalETMap.g:2820:2: ( rule__Decimal__Alternatives_0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=15 && LA26_0<=16)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalETMap.g:2820:3: rule__Decimal__Alternatives_0
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
    // InternalETMap.g:2828:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2832:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // InternalETMap.g:2833:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
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
    // InternalETMap.g:2840:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2844:1: ( ( RULE_INT ) )
            // InternalETMap.g:2845:1: ( RULE_INT )
            {
            // InternalETMap.g:2845:1: ( RULE_INT )
            // InternalETMap.g:2846:2: RULE_INT
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
    // InternalETMap.g:2855:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2859:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // InternalETMap.g:2860:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
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
    // InternalETMap.g:2867:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2871:1: ( ( '.' ) )
            // InternalETMap.g:2872:1: ( '.' )
            {
            // InternalETMap.g:2872:1: ( '.' )
            // InternalETMap.g:2873:2: '.'
            {
             before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            match(input,40,FOLLOW_2); 
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
    // InternalETMap.g:2882:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2886:1: ( rule__Decimal__Group__3__Impl )
            // InternalETMap.g:2887:2: rule__Decimal__Group__3__Impl
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
    // InternalETMap.g:2893:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2897:1: ( ( RULE_INT ) )
            // InternalETMap.g:2898:1: ( RULE_INT )
            {
            // InternalETMap.g:2898:1: ( RULE_INT )
            // InternalETMap.g:2899:2: RULE_INT
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
    // InternalETMap.g:2909:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2913:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // InternalETMap.g:2914:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
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
    // InternalETMap.g:2921:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2925:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // InternalETMap.g:2926:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // InternalETMap.g:2926:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // InternalETMap.g:2927:2: ( rule__DecimalExp__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            // InternalETMap.g:2928:2: ( rule__DecimalExp__Alternatives_0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=15 && LA27_0<=16)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalETMap.g:2928:3: rule__DecimalExp__Alternatives_0
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
    // InternalETMap.g:2936:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2940:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // InternalETMap.g:2941:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
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
    // InternalETMap.g:2948:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2952:1: ( ( RULE_INT ) )
            // InternalETMap.g:2953:1: ( RULE_INT )
            {
            // InternalETMap.g:2953:1: ( RULE_INT )
            // InternalETMap.g:2954:2: RULE_INT
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
    // InternalETMap.g:2963:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2967:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // InternalETMap.g:2968:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
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
    // InternalETMap.g:2975:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2979:1: ( ( '.' ) )
            // InternalETMap.g:2980:1: ( '.' )
            {
            // InternalETMap.g:2980:1: ( '.' )
            // InternalETMap.g:2981:2: '.'
            {
             before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            match(input,40,FOLLOW_2); 
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
    // InternalETMap.g:2990:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:2994:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // InternalETMap.g:2995:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
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
    // InternalETMap.g:3002:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3006:1: ( ( RULE_INT ) )
            // InternalETMap.g:3007:1: ( RULE_INT )
            {
            // InternalETMap.g:3007:1: ( RULE_INT )
            // InternalETMap.g:3008:2: RULE_INT
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
    // InternalETMap.g:3017:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5 ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3021:1: ( rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5 )
            // InternalETMap.g:3022:2: rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5
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
    // InternalETMap.g:3029:1: rule__DecimalExp__Group__4__Impl : ( ( rule__DecimalExp__Alternatives_4 ) ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3033:1: ( ( ( rule__DecimalExp__Alternatives_4 ) ) )
            // InternalETMap.g:3034:1: ( ( rule__DecimalExp__Alternatives_4 ) )
            {
            // InternalETMap.g:3034:1: ( ( rule__DecimalExp__Alternatives_4 ) )
            // InternalETMap.g:3035:2: ( rule__DecimalExp__Alternatives_4 )
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_4()); 
            // InternalETMap.g:3036:2: ( rule__DecimalExp__Alternatives_4 )
            // InternalETMap.g:3036:3: rule__DecimalExp__Alternatives_4
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
    // InternalETMap.g:3044:1: rule__DecimalExp__Group__5 : rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6 ;
    public final void rule__DecimalExp__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3048:1: ( rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6 )
            // InternalETMap.g:3049:2: rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6
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
    // InternalETMap.g:3056:1: rule__DecimalExp__Group__5__Impl : ( ( rule__DecimalExp__Alternatives_5 )? ) ;
    public final void rule__DecimalExp__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3060:1: ( ( ( rule__DecimalExp__Alternatives_5 )? ) )
            // InternalETMap.g:3061:1: ( ( rule__DecimalExp__Alternatives_5 )? )
            {
            // InternalETMap.g:3061:1: ( ( rule__DecimalExp__Alternatives_5 )? )
            // InternalETMap.g:3062:2: ( rule__DecimalExp__Alternatives_5 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_5()); 
            // InternalETMap.g:3063:2: ( rule__DecimalExp__Alternatives_5 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=15 && LA28_0<=16)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalETMap.g:3063:3: rule__DecimalExp__Alternatives_5
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
    // InternalETMap.g:3071:1: rule__DecimalExp__Group__6 : rule__DecimalExp__Group__6__Impl ;
    public final void rule__DecimalExp__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3075:1: ( rule__DecimalExp__Group__6__Impl )
            // InternalETMap.g:3076:2: rule__DecimalExp__Group__6__Impl
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
    // InternalETMap.g:3082:1: rule__DecimalExp__Group__6__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3086:1: ( ( RULE_INT ) )
            // InternalETMap.g:3087:1: ( RULE_INT )
            {
            // InternalETMap.g:3087:1: ( RULE_INT )
            // InternalETMap.g:3088:2: RULE_INT
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
    // InternalETMap.g:3098:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3102:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalETMap.g:3103:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
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
    // InternalETMap.g:3110:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3114:1: ( ( RULE_ID ) )
            // InternalETMap.g:3115:1: ( RULE_ID )
            {
            // InternalETMap.g:3115:1: ( RULE_ID )
            // InternalETMap.g:3116:2: RULE_ID
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
    // InternalETMap.g:3125:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3129:1: ( rule__FQN__Group__1__Impl )
            // InternalETMap.g:3130:2: rule__FQN__Group__1__Impl
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
    // InternalETMap.g:3136:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3140:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalETMap.g:3141:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalETMap.g:3141:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalETMap.g:3142:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalETMap.g:3143:2: ( rule__FQN__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==40) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalETMap.g:3143:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_33);
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
    // InternalETMap.g:3152:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3156:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalETMap.g:3157:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
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
    // InternalETMap.g:3164:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3168:1: ( ( '.' ) )
            // InternalETMap.g:3169:1: ( '.' )
            {
            // InternalETMap.g:3169:1: ( '.' )
            // InternalETMap.g:3170:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,40,FOLLOW_2); 
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
    // InternalETMap.g:3179:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3183:1: ( rule__FQN__Group_1__1__Impl )
            // InternalETMap.g:3184:2: rule__FQN__Group_1__1__Impl
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
    // InternalETMap.g:3190:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3194:1: ( ( RULE_ID ) )
            // InternalETMap.g:3195:1: ( RULE_ID )
            {
            // InternalETMap.g:3195:1: ( RULE_ID )
            // InternalETMap.g:3196:2: RULE_ID
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
    // InternalETMap.g:3206:1: rule__MappingModel__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__MappingModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3210:1: ( ( ruleFQN ) )
            // InternalETMap.g:3211:2: ( ruleFQN )
            {
            // InternalETMap.g:3211:2: ( ruleFQN )
            // InternalETMap.g:3212:3: ruleFQN
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
    // InternalETMap.g:3221:1: rule__MappingModel__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__MappingModel__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3225:1: ( ( ruleImport ) )
            // InternalETMap.g:3226:2: ( ruleImport )
            {
            // InternalETMap.g:3226:2: ( ruleImport )
            // InternalETMap.g:3227:3: ruleImport
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
    // InternalETMap.g:3236:1: rule__MappingModel__MappingsAssignment_4 : ( ruleMapping ) ;
    public final void rule__MappingModel__MappingsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3240:1: ( ( ruleMapping ) )
            // InternalETMap.g:3241:2: ( ruleMapping )
            {
            // InternalETMap.g:3241:2: ( ruleMapping )
            // InternalETMap.g:3242:3: ruleMapping
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
    // InternalETMap.g:3251:1: rule__Mapping__LogicalSysAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__Mapping__LogicalSysAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3255:1: ( ( ( ruleFQN ) ) )
            // InternalETMap.g:3256:2: ( ( ruleFQN ) )
            {
            // InternalETMap.g:3256:2: ( ( ruleFQN ) )
            // InternalETMap.g:3257:3: ( ruleFQN )
            {
             before(grammarAccess.getMappingAccess().getLogicalSysLogicalSystemCrossReference_1_0()); 
            // InternalETMap.g:3258:3: ( ruleFQN )
            // InternalETMap.g:3259:4: ruleFQN
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
    // InternalETMap.g:3270:1: rule__Mapping__PhysicalSysAssignment_3 : ( ( ruleFQN ) ) ;
    public final void rule__Mapping__PhysicalSysAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3274:1: ( ( ( ruleFQN ) ) )
            // InternalETMap.g:3275:2: ( ( ruleFQN ) )
            {
            // InternalETMap.g:3275:2: ( ( ruleFQN ) )
            // InternalETMap.g:3276:3: ( ruleFQN )
            {
             before(grammarAccess.getMappingAccess().getPhysicalSysPhysicalSystemCrossReference_3_0()); 
            // InternalETMap.g:3277:3: ( ruleFQN )
            // InternalETMap.g:3278:4: ruleFQN
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
    // InternalETMap.g:3289:1: rule__Mapping__SubsysMappingsAssignment_5 : ( ruleSubSystemMapping ) ;
    public final void rule__Mapping__SubsysMappingsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3293:1: ( ( ruleSubSystemMapping ) )
            // InternalETMap.g:3294:2: ( ruleSubSystemMapping )
            {
            // InternalETMap.g:3294:2: ( ruleSubSystemMapping )
            // InternalETMap.g:3295:3: ruleSubSystemMapping
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
    // InternalETMap.g:3304:1: rule__SubSystemMapping__LogicalSubSysAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemMapping__LogicalSubSysAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3308:1: ( ( ( RULE_ID ) ) )
            // InternalETMap.g:3309:2: ( ( RULE_ID ) )
            {
            // InternalETMap.g:3309:2: ( ( RULE_ID ) )
            // InternalETMap.g:3310:3: ( RULE_ID )
            {
             before(grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefCrossReference_1_0()); 
            // InternalETMap.g:3311:3: ( RULE_ID )
            // InternalETMap.g:3312:4: RULE_ID
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
    // InternalETMap.g:3323:1: rule__SubSystemMapping__NodeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__SubSystemMapping__NodeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3327:1: ( ( ( RULE_ID ) ) )
            // InternalETMap.g:3328:2: ( ( RULE_ID ) )
            {
            // InternalETMap.g:3328:2: ( ( RULE_ID ) )
            // InternalETMap.g:3329:3: ( RULE_ID )
            {
             before(grammarAccess.getSubSystemMappingAccess().getNodeNodeRefCrossReference_3_0()); 
            // InternalETMap.g:3330:3: ( RULE_ID )
            // InternalETMap.g:3331:4: RULE_ID
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
    // InternalETMap.g:3342:1: rule__SubSystemMapping__ThreadMappingsAssignment_4_1 : ( ruleThreadMapping ) ;
    public final void rule__SubSystemMapping__ThreadMappingsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3346:1: ( ( ruleThreadMapping ) )
            // InternalETMap.g:3347:2: ( ruleThreadMapping )
            {
            // InternalETMap.g:3347:2: ( ruleThreadMapping )
            // InternalETMap.g:3348:3: ruleThreadMapping
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
    // InternalETMap.g:3357:1: rule__ThreadMapping__LogicalThreadAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ThreadMapping__LogicalThreadAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3361:1: ( ( ( RULE_ID ) ) )
            // InternalETMap.g:3362:2: ( ( RULE_ID ) )
            {
            // InternalETMap.g:3362:2: ( ( RULE_ID ) )
            // InternalETMap.g:3363:3: ( RULE_ID )
            {
             before(grammarAccess.getThreadMappingAccess().getLogicalThreadLogicalThreadCrossReference_1_0()); 
            // InternalETMap.g:3364:3: ( RULE_ID )
            // InternalETMap.g:3365:4: RULE_ID
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
    // InternalETMap.g:3376:1: rule__ThreadMapping__PhysicalThreadAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__ThreadMapping__PhysicalThreadAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3380:1: ( ( ( RULE_ID ) ) )
            // InternalETMap.g:3381:2: ( ( RULE_ID ) )
            {
            // InternalETMap.g:3381:2: ( ( RULE_ID ) )
            // InternalETMap.g:3382:3: ( RULE_ID )
            {
             before(grammarAccess.getThreadMappingAccess().getPhysicalThreadPhysicalThreadCrossReference_3_0()); 
            // InternalETMap.g:3383:3: ( RULE_ID )
            // InternalETMap.g:3384:4: RULE_ID
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
    // InternalETMap.g:3395:1: rule__KeyValue__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3399:1: ( ( RULE_ID ) )
            // InternalETMap.g:3400:2: ( RULE_ID )
            {
            // InternalETMap.g:3400:2: ( RULE_ID )
            // InternalETMap.g:3401:3: RULE_ID
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
    // InternalETMap.g:3410:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3414:1: ( ( ruleLiteral ) )
            // InternalETMap.g:3415:2: ( ruleLiteral )
            {
            // InternalETMap.g:3415:2: ( ruleLiteral )
            // InternalETMap.g:3416:3: ruleLiteral
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
    // InternalETMap.g:3425:1: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__SimpleAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3429:1: ( ( ( 'optional' ) ) )
            // InternalETMap.g:3430:2: ( ( 'optional' ) )
            {
            // InternalETMap.g:3430:2: ( ( 'optional' ) )
            // InternalETMap.g:3431:3: ( 'optional' )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // InternalETMap.g:3432:3: ( 'optional' )
            // InternalETMap.g:3433:4: 'optional'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalETMap.g:3444:1: rule__SimpleAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3448:1: ( ( RULE_ID ) )
            // InternalETMap.g:3449:2: ( RULE_ID )
            {
            // InternalETMap.g:3449:2: ( RULE_ID )
            // InternalETMap.g:3450:3: RULE_ID
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
    // InternalETMap.g:3459:1: rule__SimpleAnnotationAttribute__TypeAssignment_4 : ( ruleLiteralType ) ;
    public final void rule__SimpleAnnotationAttribute__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3463:1: ( ( ruleLiteralType ) )
            // InternalETMap.g:3464:2: ( ruleLiteralType )
            {
            // InternalETMap.g:3464:2: ( ruleLiteralType )
            // InternalETMap.g:3465:3: ruleLiteralType
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
    // InternalETMap.g:3474:1: rule__EnumAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__EnumAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3478:1: ( ( ( 'optional' ) ) )
            // InternalETMap.g:3479:2: ( ( 'optional' ) )
            {
            // InternalETMap.g:3479:2: ( ( 'optional' ) )
            // InternalETMap.g:3480:3: ( 'optional' )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // InternalETMap.g:3481:3: ( 'optional' )
            // InternalETMap.g:3482:4: 'optional'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalETMap.g:3493:1: rule__EnumAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EnumAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3497:1: ( ( RULE_ID ) )
            // InternalETMap.g:3498:2: ( RULE_ID )
            {
            // InternalETMap.g:3498:2: ( RULE_ID )
            // InternalETMap.g:3499:3: RULE_ID
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
    // InternalETMap.g:3508:1: rule__EnumAnnotationAttribute__ValuesAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3512:1: ( ( RULE_STRING ) )
            // InternalETMap.g:3513:2: ( RULE_STRING )
            {
            // InternalETMap.g:3513:2: ( RULE_STRING )
            // InternalETMap.g:3514:3: RULE_STRING
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
    // InternalETMap.g:3523:1: rule__EnumAnnotationAttribute__ValuesAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3527:1: ( ( RULE_STRING ) )
            // InternalETMap.g:3528:2: ( RULE_STRING )
            {
            // InternalETMap.g:3528:2: ( RULE_STRING )
            // InternalETMap.g:3529:3: RULE_STRING
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
    // InternalETMap.g:3538:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3542:1: ( ( ruleImportedFQN ) )
            // InternalETMap.g:3543:2: ( ruleImportedFQN )
            {
            // InternalETMap.g:3543:2: ( ruleImportedFQN )
            // InternalETMap.g:3544:3: ruleImportedFQN
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


    // $ANTLR start "rule__Import__ImportURIAssignment_1_0_1_1"
    // InternalETMap.g:3553:1: rule__Import__ImportURIAssignment_1_0_1_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3557:1: ( ( RULE_STRING ) )
            // InternalETMap.g:3558:2: ( RULE_STRING )
            {
            // InternalETMap.g:3558:2: ( RULE_STRING )
            // InternalETMap.g:3559:3: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0_1_1_0()); 

            }


            }

        }
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
    // InternalETMap.g:3568:1: rule__Import__ImportURIAssignment_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3572:1: ( ( RULE_STRING ) )
            // InternalETMap.g:3573:2: ( RULE_STRING )
            {
            // InternalETMap.g:3573:2: ( RULE_STRING )
            // InternalETMap.g:3574:3: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_1_1_0()); 

            }


            }

        }
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
    // InternalETMap.g:3583:1: rule__Documentation__LinesAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Documentation__LinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3587:1: ( ( RULE_STRING ) )
            // InternalETMap.g:3588:2: ( RULE_STRING )
            {
            // InternalETMap.g:3588:2: ( RULE_STRING )
            // InternalETMap.g:3589:3: RULE_STRING
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
    // InternalETMap.g:3598:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3602:1: ( ( ( 'true' ) ) )
            // InternalETMap.g:3603:2: ( ( 'true' ) )
            {
            // InternalETMap.g:3603:2: ( ( 'true' ) )
            // InternalETMap.g:3604:3: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            // InternalETMap.g:3605:3: ( 'true' )
            // InternalETMap.g:3606:4: 'true'
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            match(input,42,FOLLOW_2); 
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
    // InternalETMap.g:3617:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3621:1: ( ( ruleReal ) )
            // InternalETMap.g:3622:2: ( ruleReal )
            {
            // InternalETMap.g:3622:2: ( ruleReal )
            // InternalETMap.g:3623:3: ruleReal
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
    // InternalETMap.g:3632:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3636:1: ( ( ruleInteger ) )
            // InternalETMap.g:3637:2: ( ruleInteger )
            {
            // InternalETMap.g:3637:2: ( ruleInteger )
            // InternalETMap.g:3638:3: ruleInteger
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
    // InternalETMap.g:3647:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalETMap.g:3651:1: ( ( RULE_STRING ) )
            // InternalETMap.g:3652:2: ( RULE_STRING )
            {
            // InternalETMap.g:3652:2: ( RULE_STRING )
            // InternalETMap.g:3653:3: RULE_STRING
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
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000004000001C0E0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000780000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000040000004000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000018060L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000010000000002L});

}