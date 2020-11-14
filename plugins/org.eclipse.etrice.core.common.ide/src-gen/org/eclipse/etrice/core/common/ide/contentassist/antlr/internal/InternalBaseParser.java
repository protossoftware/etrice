package org.eclipse.etrice.core.common.ide.contentassist.antlr.internal;

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
import org.eclipse.etrice.core.common.services.BaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBaseParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_HEX", "RULE_INT", "RULE_STRING", "RULE_CC_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'mandatory'", "'false'", "'+'", "'-'", "'e'", "'E'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'", "'@'", "'('", "')'", "','", "'='", "'attribute'", "':'", "'{'", "'}'", "'.*'", "'['", "']'", "'.'", "'optional'", "'true'"
    };
    public static final int RULE_HEX=5;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int RULE_CC_STRING=8;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__17=17;
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
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalBaseParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBaseParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBaseParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBase.g"; }


    	private BaseGrammarAccess grammarAccess;

    	public void setGrammarAccess(BaseGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleAnnotation"
    // InternalBase.g:53:1: entryRuleAnnotation : ruleAnnotation EOF ;
    public final void entryRuleAnnotation() throws RecognitionException {
        try {
            // InternalBase.g:54:1: ( ruleAnnotation EOF )
            // InternalBase.g:55:1: ruleAnnotation EOF
            {
             before(grammarAccess.getAnnotationRule()); 
            pushFollow(FOLLOW_1);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getAnnotationRule()); 
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
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // InternalBase.g:62:1: ruleAnnotation : ( ( rule__Annotation__Group__0 ) ) ;
    public final void ruleAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:66:2: ( ( ( rule__Annotation__Group__0 ) ) )
            // InternalBase.g:67:2: ( ( rule__Annotation__Group__0 ) )
            {
            // InternalBase.g:67:2: ( ( rule__Annotation__Group__0 ) )
            // InternalBase.g:68:3: ( rule__Annotation__Group__0 )
            {
             before(grammarAccess.getAnnotationAccess().getGroup()); 
            // InternalBase.g:69:3: ( rule__Annotation__Group__0 )
            // InternalBase.g:69:4: rule__Annotation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Annotation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAnnotationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnnotation"


    // $ANTLR start "entryRuleKeyValue"
    // InternalBase.g:78:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // InternalBase.g:79:1: ( ruleKeyValue EOF )
            // InternalBase.g:80:1: ruleKeyValue EOF
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
    // InternalBase.g:87:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:91:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // InternalBase.g:92:2: ( ( rule__KeyValue__Group__0 ) )
            {
            // InternalBase.g:92:2: ( ( rule__KeyValue__Group__0 ) )
            // InternalBase.g:93:3: ( rule__KeyValue__Group__0 )
            {
             before(grammarAccess.getKeyValueAccess().getGroup()); 
            // InternalBase.g:94:3: ( rule__KeyValue__Group__0 )
            // InternalBase.g:94:4: rule__KeyValue__Group__0
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
    // InternalBase.g:103:1: entryRuleAnnotationTargetType : ruleAnnotationTargetType EOF ;
    public final void entryRuleAnnotationTargetType() throws RecognitionException {
        try {
            // InternalBase.g:104:1: ( ruleAnnotationTargetType EOF )
            // InternalBase.g:105:1: ruleAnnotationTargetType EOF
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
    // InternalBase.g:112:1: ruleAnnotationTargetType : ( RULE_ID ) ;
    public final void ruleAnnotationTargetType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:116:2: ( ( RULE_ID ) )
            // InternalBase.g:117:2: ( RULE_ID )
            {
            // InternalBase.g:117:2: ( RULE_ID )
            // InternalBase.g:118:3: RULE_ID
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
    // InternalBase.g:128:1: entryRuleAnnotationAttribute : ruleAnnotationAttribute EOF ;
    public final void entryRuleAnnotationAttribute() throws RecognitionException {
        try {
            // InternalBase.g:129:1: ( ruleAnnotationAttribute EOF )
            // InternalBase.g:130:1: ruleAnnotationAttribute EOF
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
    // InternalBase.g:137:1: ruleAnnotationAttribute : ( ( rule__AnnotationAttribute__Alternatives ) ) ;
    public final void ruleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:141:2: ( ( ( rule__AnnotationAttribute__Alternatives ) ) )
            // InternalBase.g:142:2: ( ( rule__AnnotationAttribute__Alternatives ) )
            {
            // InternalBase.g:142:2: ( ( rule__AnnotationAttribute__Alternatives ) )
            // InternalBase.g:143:3: ( rule__AnnotationAttribute__Alternatives )
            {
             before(grammarAccess.getAnnotationAttributeAccess().getAlternatives()); 
            // InternalBase.g:144:3: ( rule__AnnotationAttribute__Alternatives )
            // InternalBase.g:144:4: rule__AnnotationAttribute__Alternatives
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
    // InternalBase.g:153:1: entryRuleSimpleAnnotationAttribute : ruleSimpleAnnotationAttribute EOF ;
    public final void entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        try {
            // InternalBase.g:154:1: ( ruleSimpleAnnotationAttribute EOF )
            // InternalBase.g:155:1: ruleSimpleAnnotationAttribute EOF
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
    // InternalBase.g:162:1: ruleSimpleAnnotationAttribute : ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) ;
    public final void ruleSimpleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:166:2: ( ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) )
            // InternalBase.g:167:2: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            {
            // InternalBase.g:167:2: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            // InternalBase.g:168:3: ( rule__SimpleAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup()); 
            // InternalBase.g:169:3: ( rule__SimpleAnnotationAttribute__Group__0 )
            // InternalBase.g:169:4: rule__SimpleAnnotationAttribute__Group__0
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
    // InternalBase.g:178:1: entryRuleEnumAnnotationAttribute : ruleEnumAnnotationAttribute EOF ;
    public final void entryRuleEnumAnnotationAttribute() throws RecognitionException {
        try {
            // InternalBase.g:179:1: ( ruleEnumAnnotationAttribute EOF )
            // InternalBase.g:180:1: ruleEnumAnnotationAttribute EOF
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
    // InternalBase.g:187:1: ruleEnumAnnotationAttribute : ( ( rule__EnumAnnotationAttribute__Group__0 ) ) ;
    public final void ruleEnumAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:191:2: ( ( ( rule__EnumAnnotationAttribute__Group__0 ) ) )
            // InternalBase.g:192:2: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            {
            // InternalBase.g:192:2: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            // InternalBase.g:193:3: ( rule__EnumAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup()); 
            // InternalBase.g:194:3: ( rule__EnumAnnotationAttribute__Group__0 )
            // InternalBase.g:194:4: rule__EnumAnnotationAttribute__Group__0
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


    // $ANTLR start "entryRuleImportedFQN"
    // InternalBase.g:203:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // InternalBase.g:204:1: ( ruleImportedFQN EOF )
            // InternalBase.g:205:1: ruleImportedFQN EOF
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
    // InternalBase.g:212:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:216:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // InternalBase.g:217:2: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // InternalBase.g:217:2: ( ( rule__ImportedFQN__Group__0 ) )
            // InternalBase.g:218:3: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // InternalBase.g:219:3: ( rule__ImportedFQN__Group__0 )
            // InternalBase.g:219:4: rule__ImportedFQN__Group__0
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
    // InternalBase.g:228:1: entryRuleDocumentation : ruleDocumentation EOF ;
    public final void entryRuleDocumentation() throws RecognitionException {
        try {
            // InternalBase.g:229:1: ( ruleDocumentation EOF )
            // InternalBase.g:230:1: ruleDocumentation EOF
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
    // InternalBase.g:237:1: ruleDocumentation : ( ( rule__Documentation__Group__0 ) ) ;
    public final void ruleDocumentation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:241:2: ( ( ( rule__Documentation__Group__0 ) ) )
            // InternalBase.g:242:2: ( ( rule__Documentation__Group__0 ) )
            {
            // InternalBase.g:242:2: ( ( rule__Documentation__Group__0 ) )
            // InternalBase.g:243:3: ( rule__Documentation__Group__0 )
            {
             before(grammarAccess.getDocumentationAccess().getGroup()); 
            // InternalBase.g:244:3: ( rule__Documentation__Group__0 )
            // InternalBase.g:244:4: rule__Documentation__Group__0
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
    // InternalBase.g:253:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalBase.g:254:1: ( ruleLiteral EOF )
            // InternalBase.g:255:1: ruleLiteral EOF
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
    // InternalBase.g:262:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:266:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalBase.g:267:2: ( ( rule__Literal__Alternatives ) )
            {
            // InternalBase.g:267:2: ( ( rule__Literal__Alternatives ) )
            // InternalBase.g:268:3: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // InternalBase.g:269:3: ( rule__Literal__Alternatives )
            // InternalBase.g:269:4: rule__Literal__Alternatives
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
    // InternalBase.g:278:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // InternalBase.g:279:1: ( ruleBooleanLiteral EOF )
            // InternalBase.g:280:1: ruleBooleanLiteral EOF
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
    // InternalBase.g:287:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:291:2: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // InternalBase.g:292:2: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // InternalBase.g:292:2: ( ( rule__BooleanLiteral__Group__0 ) )
            // InternalBase.g:293:3: ( rule__BooleanLiteral__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            // InternalBase.g:294:3: ( rule__BooleanLiteral__Group__0 )
            // InternalBase.g:294:4: rule__BooleanLiteral__Group__0
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
    // InternalBase.g:303:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // InternalBase.g:304:1: ( ruleNumberLiteral EOF )
            // InternalBase.g:305:1: ruleNumberLiteral EOF
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
    // InternalBase.g:312:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Alternatives ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:316:2: ( ( ( rule__NumberLiteral__Alternatives ) ) )
            // InternalBase.g:317:2: ( ( rule__NumberLiteral__Alternatives ) )
            {
            // InternalBase.g:317:2: ( ( rule__NumberLiteral__Alternatives ) )
            // InternalBase.g:318:3: ( rule__NumberLiteral__Alternatives )
            {
             before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            // InternalBase.g:319:3: ( rule__NumberLiteral__Alternatives )
            // InternalBase.g:319:4: rule__NumberLiteral__Alternatives
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
    // InternalBase.g:328:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // InternalBase.g:329:1: ( ruleRealLiteral EOF )
            // InternalBase.g:330:1: ruleRealLiteral EOF
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
    // InternalBase.g:337:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:341:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // InternalBase.g:342:2: ( ( rule__RealLiteral__Group__0 ) )
            {
            // InternalBase.g:342:2: ( ( rule__RealLiteral__Group__0 ) )
            // InternalBase.g:343:3: ( rule__RealLiteral__Group__0 )
            {
             before(grammarAccess.getRealLiteralAccess().getGroup()); 
            // InternalBase.g:344:3: ( rule__RealLiteral__Group__0 )
            // InternalBase.g:344:4: rule__RealLiteral__Group__0
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
    // InternalBase.g:353:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // InternalBase.g:354:1: ( ruleIntLiteral EOF )
            // InternalBase.g:355:1: ruleIntLiteral EOF
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
    // InternalBase.g:362:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:366:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // InternalBase.g:367:2: ( ( rule__IntLiteral__Group__0 ) )
            {
            // InternalBase.g:367:2: ( ( rule__IntLiteral__Group__0 ) )
            // InternalBase.g:368:3: ( rule__IntLiteral__Group__0 )
            {
             before(grammarAccess.getIntLiteralAccess().getGroup()); 
            // InternalBase.g:369:3: ( rule__IntLiteral__Group__0 )
            // InternalBase.g:369:4: rule__IntLiteral__Group__0
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
    // InternalBase.g:378:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // InternalBase.g:379:1: ( ruleStringLiteral EOF )
            // InternalBase.g:380:1: ruleStringLiteral EOF
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
    // InternalBase.g:387:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:391:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // InternalBase.g:392:2: ( ( rule__StringLiteral__Group__0 ) )
            {
            // InternalBase.g:392:2: ( ( rule__StringLiteral__Group__0 ) )
            // InternalBase.g:393:3: ( rule__StringLiteral__Group__0 )
            {
             before(grammarAccess.getStringLiteralAccess().getGroup()); 
            // InternalBase.g:394:3: ( rule__StringLiteral__Group__0 )
            // InternalBase.g:394:4: rule__StringLiteral__Group__0
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
    // InternalBase.g:403:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // InternalBase.g:404:1: ( ruleInteger EOF )
            // InternalBase.g:405:1: ruleInteger EOF
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
    // InternalBase.g:412:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:416:2: ( ( ( rule__Integer__Alternatives ) ) )
            // InternalBase.g:417:2: ( ( rule__Integer__Alternatives ) )
            {
            // InternalBase.g:417:2: ( ( rule__Integer__Alternatives ) )
            // InternalBase.g:418:3: ( rule__Integer__Alternatives )
            {
             before(grammarAccess.getIntegerAccess().getAlternatives()); 
            // InternalBase.g:419:3: ( rule__Integer__Alternatives )
            // InternalBase.g:419:4: rule__Integer__Alternatives
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
    // InternalBase.g:428:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // InternalBase.g:429:1: ( ruleReal EOF )
            // InternalBase.g:430:1: ruleReal EOF
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
    // InternalBase.g:437:1: ruleReal : ( ( rule__Real__Alternatives ) ) ;
    public final void ruleReal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:441:2: ( ( ( rule__Real__Alternatives ) ) )
            // InternalBase.g:442:2: ( ( rule__Real__Alternatives ) )
            {
            // InternalBase.g:442:2: ( ( rule__Real__Alternatives ) )
            // InternalBase.g:443:3: ( rule__Real__Alternatives )
            {
             before(grammarAccess.getRealAccess().getAlternatives()); 
            // InternalBase.g:444:3: ( rule__Real__Alternatives )
            // InternalBase.g:444:4: rule__Real__Alternatives
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
    // InternalBase.g:453:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalBase.g:457:1: ( ruleDecimal EOF )
            // InternalBase.g:458:1: ruleDecimal EOF
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
    // InternalBase.g:468:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:473:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // InternalBase.g:474:2: ( ( rule__Decimal__Group__0 ) )
            {
            // InternalBase.g:474:2: ( ( rule__Decimal__Group__0 ) )
            // InternalBase.g:475:3: ( rule__Decimal__Group__0 )
            {
             before(grammarAccess.getDecimalAccess().getGroup()); 
            // InternalBase.g:476:3: ( rule__Decimal__Group__0 )
            // InternalBase.g:476:4: rule__Decimal__Group__0
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
    // InternalBase.g:486:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalBase.g:490:1: ( ruleDecimalExp EOF )
            // InternalBase.g:491:1: ruleDecimalExp EOF
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
    // InternalBase.g:501:1: ruleDecimalExp : ( ( rule__DecimalExp__Group__0 ) ) ;
    public final void ruleDecimalExp() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:506:2: ( ( ( rule__DecimalExp__Group__0 ) ) )
            // InternalBase.g:507:2: ( ( rule__DecimalExp__Group__0 ) )
            {
            // InternalBase.g:507:2: ( ( rule__DecimalExp__Group__0 ) )
            // InternalBase.g:508:3: ( rule__DecimalExp__Group__0 )
            {
             before(grammarAccess.getDecimalExpAccess().getGroup()); 
            // InternalBase.g:509:3: ( rule__DecimalExp__Group__0 )
            // InternalBase.g:509:4: rule__DecimalExp__Group__0
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
    // InternalBase.g:519:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalBase.g:520:1: ( ruleFQN EOF )
            // InternalBase.g:521:1: ruleFQN EOF
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
    // InternalBase.g:528:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:532:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalBase.g:533:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalBase.g:533:2: ( ( rule__FQN__Group__0 ) )
            // InternalBase.g:534:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalBase.g:535:3: ( rule__FQN__Group__0 )
            // InternalBase.g:535:4: rule__FQN__Group__0
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
    // InternalBase.g:544:1: ruleLiteralType : ( ( rule__LiteralType__Alternatives ) ) ;
    public final void ruleLiteralType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:548:1: ( ( ( rule__LiteralType__Alternatives ) ) )
            // InternalBase.g:549:2: ( ( rule__LiteralType__Alternatives ) )
            {
            // InternalBase.g:549:2: ( ( rule__LiteralType__Alternatives ) )
            // InternalBase.g:550:3: ( rule__LiteralType__Alternatives )
            {
             before(grammarAccess.getLiteralTypeAccess().getAlternatives()); 
            // InternalBase.g:551:3: ( rule__LiteralType__Alternatives )
            // InternalBase.g:551:4: rule__LiteralType__Alternatives
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
    // InternalBase.g:559:1: rule__AnnotationAttribute__Alternatives : ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) );
    public final void rule__AnnotationAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:563:1: ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==36) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==28) ) {
                    int LA1_3 = input.LA(3);

                    if ( (LA1_3==RULE_ID) ) {
                        int LA1_4 = input.LA(4);

                        if ( (LA1_4==29) ) {
                            int LA1_5 = input.LA(5);

                            if ( (LA1_5==30) ) {
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
            else if ( (LA1_0==13) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==28) ) {
                    int LA1_3 = input.LA(3);

                    if ( (LA1_3==RULE_ID) ) {
                        int LA1_4 = input.LA(4);

                        if ( (LA1_4==29) ) {
                            int LA1_5 = input.LA(5);

                            if ( (LA1_5==30) ) {
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
                    // InternalBase.g:564:2: ( ruleSimpleAnnotationAttribute )
                    {
                    // InternalBase.g:564:2: ( ruleSimpleAnnotationAttribute )
                    // InternalBase.g:565:3: ruleSimpleAnnotationAttribute
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
                    // InternalBase.g:570:2: ( ruleEnumAnnotationAttribute )
                    {
                    // InternalBase.g:570:2: ( ruleEnumAnnotationAttribute )
                    // InternalBase.g:571:3: ruleEnumAnnotationAttribute
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
    // InternalBase.g:580:1: rule__SimpleAnnotationAttribute__Alternatives_0 : ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__SimpleAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:584:1: ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==36) ) {
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
                    // InternalBase.g:585:2: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // InternalBase.g:585:2: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // InternalBase.g:586:3: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // InternalBase.g:587:3: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    // InternalBase.g:587:4: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0
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
                    // InternalBase.g:591:2: ( 'mandatory' )
                    {
                    // InternalBase.g:591:2: ( 'mandatory' )
                    // InternalBase.g:592:3: 'mandatory'
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
    // InternalBase.g:601:1: rule__EnumAnnotationAttribute__Alternatives_0 : ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__EnumAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:605:1: ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==36) ) {
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
                    // InternalBase.g:606:2: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // InternalBase.g:606:2: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // InternalBase.g:607:3: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // InternalBase.g:608:3: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    // InternalBase.g:608:4: rule__EnumAnnotationAttribute__OptionalAssignment_0_0
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
                    // InternalBase.g:612:2: ( 'mandatory' )
                    {
                    // InternalBase.g:612:2: ( 'mandatory' )
                    // InternalBase.g:613:3: 'mandatory'
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


    // $ANTLR start "rule__Literal__Alternatives"
    // InternalBase.g:622:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:626:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 14:
            case 37:
                {
                alt4=1;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case 15:
            case 16:
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
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalBase.g:627:2: ( ruleBooleanLiteral )
                    {
                    // InternalBase.g:627:2: ( ruleBooleanLiteral )
                    // InternalBase.g:628:3: ruleBooleanLiteral
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
                    // InternalBase.g:633:2: ( ruleNumberLiteral )
                    {
                    // InternalBase.g:633:2: ( ruleNumberLiteral )
                    // InternalBase.g:634:3: ruleNumberLiteral
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
                    // InternalBase.g:639:2: ( ruleStringLiteral )
                    {
                    // InternalBase.g:639:2: ( ruleStringLiteral )
                    // InternalBase.g:640:3: ruleStringLiteral
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
    // InternalBase.g:649:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:653:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            else if ( (LA5_0==37) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalBase.g:654:2: ( 'false' )
                    {
                    // InternalBase.g:654:2: ( 'false' )
                    // InternalBase.g:655:3: 'false'
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBase.g:660:2: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // InternalBase.g:660:2: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // InternalBase.g:661:3: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    // InternalBase.g:662:3: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // InternalBase.g:662:4: rule__BooleanLiteral__IsTrueAssignment_1_1
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
    // InternalBase.g:670:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:674:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
            int alt6=2;
            switch ( input.LA(1) ) {
            case 15:
                {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_INT) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==35) ) {
                        alt6=2;
                    }
                    else if ( (LA6_3==EOF||(LA6_3>=25 && LA6_3<=26)) ) {
                        alt6=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
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

                    if ( (LA6_3==35) ) {
                        alt6=2;
                    }
                    else if ( (LA6_3==EOF||(LA6_3>=25 && LA6_3<=26)) ) {
                        alt6=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA6_3 = input.LA(2);

                if ( (LA6_3==35) ) {
                    alt6=2;
                }
                else if ( (LA6_3==EOF||(LA6_3>=25 && LA6_3<=26)) ) {
                    alt6=1;
                }
                else {
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalBase.g:675:2: ( ruleIntLiteral )
                    {
                    // InternalBase.g:675:2: ( ruleIntLiteral )
                    // InternalBase.g:676:3: ruleIntLiteral
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
                    // InternalBase.g:681:2: ( ruleRealLiteral )
                    {
                    // InternalBase.g:681:2: ( ruleRealLiteral )
                    // InternalBase.g:682:3: ruleRealLiteral
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
    // InternalBase.g:691:1: rule__Integer__Alternatives : ( ( ( rule__Integer__Group_0__0 ) ) | ( RULE_HEX ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:695:1: ( ( ( rule__Integer__Group_0__0 ) ) | ( RULE_HEX ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_INT||(LA7_0>=15 && LA7_0<=16)) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_HEX) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalBase.g:696:2: ( ( rule__Integer__Group_0__0 ) )
                    {
                    // InternalBase.g:696:2: ( ( rule__Integer__Group_0__0 ) )
                    // InternalBase.g:697:3: ( rule__Integer__Group_0__0 )
                    {
                     before(grammarAccess.getIntegerAccess().getGroup_0()); 
                    // InternalBase.g:698:3: ( rule__Integer__Group_0__0 )
                    // InternalBase.g:698:4: rule__Integer__Group_0__0
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
                    // InternalBase.g:702:2: ( RULE_HEX )
                    {
                    // InternalBase.g:702:2: ( RULE_HEX )
                    // InternalBase.g:703:3: RULE_HEX
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
    // InternalBase.g:712:1: rule__Integer__Alternatives_0_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Integer__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:716:1: ( ( '+' ) | ( '-' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            else if ( (LA8_0==16) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalBase.g:717:2: ( '+' )
                    {
                    // InternalBase.g:717:2: ( '+' )
                    // InternalBase.g:718:3: '+'
                    {
                     before(grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBase.g:723:2: ( '-' )
                    {
                    // InternalBase.g:723:2: ( '-' )
                    // InternalBase.g:724:3: '-'
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
    // InternalBase.g:733:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:737:1: ( ( ruleDecimal ) | ( ruleDecimalExp ) )
            int alt9=2;
            switch ( input.LA(1) ) {
            case 15:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==RULE_INT) ) {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==35) ) {
                        int LA9_4 = input.LA(4);

                        if ( (LA9_4==RULE_INT) ) {
                            int LA9_5 = input.LA(5);

                            if ( (LA9_5==EOF||(LA9_5>=25 && LA9_5<=26)) ) {
                                alt9=1;
                            }
                            else if ( ((LA9_5>=17 && LA9_5<=18)) ) {
                                alt9=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==RULE_INT) ) {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==35) ) {
                        int LA9_4 = input.LA(4);

                        if ( (LA9_4==RULE_INT) ) {
                            int LA9_5 = input.LA(5);

                            if ( (LA9_5==EOF||(LA9_5>=25 && LA9_5<=26)) ) {
                                alt9=1;
                            }
                            else if ( ((LA9_5>=17 && LA9_5<=18)) ) {
                                alt9=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA9_3 = input.LA(2);

                if ( (LA9_3==35) ) {
                    int LA9_4 = input.LA(3);

                    if ( (LA9_4==RULE_INT) ) {
                        int LA9_5 = input.LA(4);

                        if ( (LA9_5==EOF||(LA9_5>=25 && LA9_5<=26)) ) {
                            alt9=1;
                        }
                        else if ( ((LA9_5>=17 && LA9_5<=18)) ) {
                            alt9=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalBase.g:738:2: ( ruleDecimal )
                    {
                    // InternalBase.g:738:2: ( ruleDecimal )
                    // InternalBase.g:739:3: ruleDecimal
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
                    // InternalBase.g:744:2: ( ruleDecimalExp )
                    {
                    // InternalBase.g:744:2: ( ruleDecimalExp )
                    // InternalBase.g:745:3: ruleDecimalExp
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
    // InternalBase.g:754:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:758:1: ( ( '+' ) | ( '-' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            else if ( (LA10_0==16) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalBase.g:759:2: ( '+' )
                    {
                    // InternalBase.g:759:2: ( '+' )
                    // InternalBase.g:760:3: '+'
                    {
                     before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBase.g:765:2: ( '-' )
                    {
                    // InternalBase.g:765:2: ( '-' )
                    // InternalBase.g:766:3: '-'
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
    // InternalBase.g:775:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:779:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalBase.g:780:2: ( '+' )
                    {
                    // InternalBase.g:780:2: ( '+' )
                    // InternalBase.g:781:3: '+'
                    {
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBase.g:786:2: ( '-' )
                    {
                    // InternalBase.g:786:2: ( '-' )
                    // InternalBase.g:787:3: '-'
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
    // InternalBase.g:796:1: rule__DecimalExp__Alternatives_4 : ( ( 'e' ) | ( 'E' ) );
    public final void rule__DecimalExp__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:800:1: ( ( 'e' ) | ( 'E' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            else if ( (LA12_0==18) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalBase.g:801:2: ( 'e' )
                    {
                    // InternalBase.g:801:2: ( 'e' )
                    // InternalBase.g:802:3: 'e'
                    {
                     before(grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBase.g:807:2: ( 'E' )
                    {
                    // InternalBase.g:807:2: ( 'E' )
                    // InternalBase.g:808:3: 'E'
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
    // InternalBase.g:817:1: rule__DecimalExp__Alternatives_5 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:821:1: ( ( '+' ) | ( '-' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==15) ) {
                alt13=1;
            }
            else if ( (LA13_0==16) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalBase.g:822:2: ( '+' )
                    {
                    // InternalBase.g:822:2: ( '+' )
                    // InternalBase.g:823:3: '+'
                    {
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBase.g:828:2: ( '-' )
                    {
                    // InternalBase.g:828:2: ( '-' )
                    // InternalBase.g:829:3: '-'
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
    // InternalBase.g:838:1: rule__LiteralType__Alternatives : ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) );
    public final void rule__LiteralType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:842:1: ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt14=1;
                }
                break;
            case 20:
                {
                alt14=2;
                }
                break;
            case 21:
                {
                alt14=3;
                }
                break;
            case 22:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalBase.g:843:2: ( ( 'ptBoolean' ) )
                    {
                    // InternalBase.g:843:2: ( ( 'ptBoolean' ) )
                    // InternalBase.g:844:3: ( 'ptBoolean' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                    // InternalBase.g:845:3: ( 'ptBoolean' )
                    // InternalBase.g:845:4: 'ptBoolean'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBase.g:849:2: ( ( 'ptInteger' ) )
                    {
                    // InternalBase.g:849:2: ( ( 'ptInteger' ) )
                    // InternalBase.g:850:3: ( 'ptInteger' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                    // InternalBase.g:851:3: ( 'ptInteger' )
                    // InternalBase.g:851:4: 'ptInteger'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBase.g:855:2: ( ( 'ptReal' ) )
                    {
                    // InternalBase.g:855:2: ( ( 'ptReal' ) )
                    // InternalBase.g:856:3: ( 'ptReal' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                    // InternalBase.g:857:3: ( 'ptReal' )
                    // InternalBase.g:857:4: 'ptReal'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBase.g:861:2: ( ( 'ptCharacter' ) )
                    {
                    // InternalBase.g:861:2: ( ( 'ptCharacter' ) )
                    // InternalBase.g:862:3: ( 'ptCharacter' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 
                    // InternalBase.g:863:3: ( 'ptCharacter' )
                    // InternalBase.g:863:4: 'ptCharacter'
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


    // $ANTLR start "rule__Annotation__Group__0"
    // InternalBase.g:871:1: rule__Annotation__Group__0 : rule__Annotation__Group__0__Impl rule__Annotation__Group__1 ;
    public final void rule__Annotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:875:1: ( rule__Annotation__Group__0__Impl rule__Annotation__Group__1 )
            // InternalBase.g:876:2: rule__Annotation__Group__0__Impl rule__Annotation__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Annotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Annotation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__0"


    // $ANTLR start "rule__Annotation__Group__0__Impl"
    // InternalBase.g:883:1: rule__Annotation__Group__0__Impl : ( '@' ) ;
    public final void rule__Annotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:887:1: ( ( '@' ) )
            // InternalBase.g:888:1: ( '@' )
            {
            // InternalBase.g:888:1: ( '@' )
            // InternalBase.g:889:2: '@'
            {
             before(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__0__Impl"


    // $ANTLR start "rule__Annotation__Group__1"
    // InternalBase.g:898:1: rule__Annotation__Group__1 : rule__Annotation__Group__1__Impl rule__Annotation__Group__2 ;
    public final void rule__Annotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:902:1: ( rule__Annotation__Group__1__Impl rule__Annotation__Group__2 )
            // InternalBase.g:903:2: rule__Annotation__Group__1__Impl rule__Annotation__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Annotation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Annotation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__1"


    // $ANTLR start "rule__Annotation__Group__1__Impl"
    // InternalBase.g:910:1: rule__Annotation__Group__1__Impl : ( ( rule__Annotation__TypeAssignment_1 ) ) ;
    public final void rule__Annotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:914:1: ( ( ( rule__Annotation__TypeAssignment_1 ) ) )
            // InternalBase.g:915:1: ( ( rule__Annotation__TypeAssignment_1 ) )
            {
            // InternalBase.g:915:1: ( ( rule__Annotation__TypeAssignment_1 ) )
            // InternalBase.g:916:2: ( rule__Annotation__TypeAssignment_1 )
            {
             before(grammarAccess.getAnnotationAccess().getTypeAssignment_1()); 
            // InternalBase.g:917:2: ( rule__Annotation__TypeAssignment_1 )
            // InternalBase.g:917:3: rule__Annotation__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Annotation__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAnnotationAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__1__Impl"


    // $ANTLR start "rule__Annotation__Group__2"
    // InternalBase.g:925:1: rule__Annotation__Group__2 : rule__Annotation__Group__2__Impl ;
    public final void rule__Annotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:929:1: ( rule__Annotation__Group__2__Impl )
            // InternalBase.g:930:2: rule__Annotation__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Annotation__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__2"


    // $ANTLR start "rule__Annotation__Group__2__Impl"
    // InternalBase.g:936:1: rule__Annotation__Group__2__Impl : ( ( rule__Annotation__Group_2__0 )? ) ;
    public final void rule__Annotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:940:1: ( ( ( rule__Annotation__Group_2__0 )? ) )
            // InternalBase.g:941:1: ( ( rule__Annotation__Group_2__0 )? )
            {
            // InternalBase.g:941:1: ( ( rule__Annotation__Group_2__0 )? )
            // InternalBase.g:942:2: ( rule__Annotation__Group_2__0 )?
            {
             before(grammarAccess.getAnnotationAccess().getGroup_2()); 
            // InternalBase.g:943:2: ( rule__Annotation__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBase.g:943:3: rule__Annotation__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Annotation__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAnnotationAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__2__Impl"


    // $ANTLR start "rule__Annotation__Group_2__0"
    // InternalBase.g:952:1: rule__Annotation__Group_2__0 : rule__Annotation__Group_2__0__Impl rule__Annotation__Group_2__1 ;
    public final void rule__Annotation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:956:1: ( rule__Annotation__Group_2__0__Impl rule__Annotation__Group_2__1 )
            // InternalBase.g:957:2: rule__Annotation__Group_2__0__Impl rule__Annotation__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__Annotation__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Annotation__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group_2__0"


    // $ANTLR start "rule__Annotation__Group_2__0__Impl"
    // InternalBase.g:964:1: rule__Annotation__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Annotation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:968:1: ( ( '(' ) )
            // InternalBase.g:969:1: ( '(' )
            {
            // InternalBase.g:969:1: ( '(' )
            // InternalBase.g:970:2: '('
            {
             before(grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group_2__0__Impl"


    // $ANTLR start "rule__Annotation__Group_2__1"
    // InternalBase.g:979:1: rule__Annotation__Group_2__1 : rule__Annotation__Group_2__1__Impl rule__Annotation__Group_2__2 ;
    public final void rule__Annotation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:983:1: ( rule__Annotation__Group_2__1__Impl rule__Annotation__Group_2__2 )
            // InternalBase.g:984:2: rule__Annotation__Group_2__1__Impl rule__Annotation__Group_2__2
            {
            pushFollow(FOLLOW_5);
            rule__Annotation__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Annotation__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group_2__1"


    // $ANTLR start "rule__Annotation__Group_2__1__Impl"
    // InternalBase.g:991:1: rule__Annotation__Group_2__1__Impl : ( ( rule__Annotation__AttributesAssignment_2_1 ) ) ;
    public final void rule__Annotation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:995:1: ( ( ( rule__Annotation__AttributesAssignment_2_1 ) ) )
            // InternalBase.g:996:1: ( ( rule__Annotation__AttributesAssignment_2_1 ) )
            {
            // InternalBase.g:996:1: ( ( rule__Annotation__AttributesAssignment_2_1 ) )
            // InternalBase.g:997:2: ( rule__Annotation__AttributesAssignment_2_1 )
            {
             before(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_1()); 
            // InternalBase.g:998:2: ( rule__Annotation__AttributesAssignment_2_1 )
            // InternalBase.g:998:3: rule__Annotation__AttributesAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Annotation__AttributesAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group_2__1__Impl"


    // $ANTLR start "rule__Annotation__Group_2__2"
    // InternalBase.g:1006:1: rule__Annotation__Group_2__2 : rule__Annotation__Group_2__2__Impl rule__Annotation__Group_2__3 ;
    public final void rule__Annotation__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1010:1: ( rule__Annotation__Group_2__2__Impl rule__Annotation__Group_2__3 )
            // InternalBase.g:1011:2: rule__Annotation__Group_2__2__Impl rule__Annotation__Group_2__3
            {
            pushFollow(FOLLOW_5);
            rule__Annotation__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Annotation__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group_2__2"


    // $ANTLR start "rule__Annotation__Group_2__2__Impl"
    // InternalBase.g:1018:1: rule__Annotation__Group_2__2__Impl : ( ( rule__Annotation__Group_2_2__0 )* ) ;
    public final void rule__Annotation__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1022:1: ( ( ( rule__Annotation__Group_2_2__0 )* ) )
            // InternalBase.g:1023:1: ( ( rule__Annotation__Group_2_2__0 )* )
            {
            // InternalBase.g:1023:1: ( ( rule__Annotation__Group_2_2__0 )* )
            // InternalBase.g:1024:2: ( rule__Annotation__Group_2_2__0 )*
            {
             before(grammarAccess.getAnnotationAccess().getGroup_2_2()); 
            // InternalBase.g:1025:2: ( rule__Annotation__Group_2_2__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBase.g:1025:3: rule__Annotation__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Annotation__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getAnnotationAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group_2__2__Impl"


    // $ANTLR start "rule__Annotation__Group_2__3"
    // InternalBase.g:1033:1: rule__Annotation__Group_2__3 : rule__Annotation__Group_2__3__Impl ;
    public final void rule__Annotation__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1037:1: ( rule__Annotation__Group_2__3__Impl )
            // InternalBase.g:1038:2: rule__Annotation__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Annotation__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group_2__3"


    // $ANTLR start "rule__Annotation__Group_2__3__Impl"
    // InternalBase.g:1044:1: rule__Annotation__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Annotation__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1048:1: ( ( ')' ) )
            // InternalBase.g:1049:1: ( ')' )
            {
            // InternalBase.g:1049:1: ( ')' )
            // InternalBase.g:1050:2: ')'
            {
             before(grammarAccess.getAnnotationAccess().getRightParenthesisKeyword_2_3()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getAnnotationAccess().getRightParenthesisKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group_2__3__Impl"


    // $ANTLR start "rule__Annotation__Group_2_2__0"
    // InternalBase.g:1060:1: rule__Annotation__Group_2_2__0 : rule__Annotation__Group_2_2__0__Impl rule__Annotation__Group_2_2__1 ;
    public final void rule__Annotation__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1064:1: ( rule__Annotation__Group_2_2__0__Impl rule__Annotation__Group_2_2__1 )
            // InternalBase.g:1065:2: rule__Annotation__Group_2_2__0__Impl rule__Annotation__Group_2_2__1
            {
            pushFollow(FOLLOW_3);
            rule__Annotation__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Annotation__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group_2_2__0"


    // $ANTLR start "rule__Annotation__Group_2_2__0__Impl"
    // InternalBase.g:1072:1: rule__Annotation__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Annotation__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1076:1: ( ( ',' ) )
            // InternalBase.g:1077:1: ( ',' )
            {
            // InternalBase.g:1077:1: ( ',' )
            // InternalBase.g:1078:2: ','
            {
             before(grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group_2_2__0__Impl"


    // $ANTLR start "rule__Annotation__Group_2_2__1"
    // InternalBase.g:1087:1: rule__Annotation__Group_2_2__1 : rule__Annotation__Group_2_2__1__Impl ;
    public final void rule__Annotation__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1091:1: ( rule__Annotation__Group_2_2__1__Impl )
            // InternalBase.g:1092:2: rule__Annotation__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Annotation__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group_2_2__1"


    // $ANTLR start "rule__Annotation__Group_2_2__1__Impl"
    // InternalBase.g:1098:1: rule__Annotation__Group_2_2__1__Impl : ( ( rule__Annotation__AttributesAssignment_2_2_1 ) ) ;
    public final void rule__Annotation__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1102:1: ( ( ( rule__Annotation__AttributesAssignment_2_2_1 ) ) )
            // InternalBase.g:1103:1: ( ( rule__Annotation__AttributesAssignment_2_2_1 ) )
            {
            // InternalBase.g:1103:1: ( ( rule__Annotation__AttributesAssignment_2_2_1 ) )
            // InternalBase.g:1104:2: ( rule__Annotation__AttributesAssignment_2_2_1 )
            {
             before(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_2_1()); 
            // InternalBase.g:1105:2: ( rule__Annotation__AttributesAssignment_2_2_1 )
            // InternalBase.g:1105:3: rule__Annotation__AttributesAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Annotation__AttributesAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group_2_2__1__Impl"


    // $ANTLR start "rule__KeyValue__Group__0"
    // InternalBase.g:1114:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1118:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // InternalBase.g:1119:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalBase.g:1126:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1130:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // InternalBase.g:1131:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // InternalBase.g:1131:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // InternalBase.g:1132:2: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // InternalBase.g:1133:2: ( rule__KeyValue__KeyAssignment_0 )
            // InternalBase.g:1133:3: rule__KeyValue__KeyAssignment_0
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
    // InternalBase.g:1141:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1145:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // InternalBase.g:1146:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
            {
            pushFollow(FOLLOW_8);
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
    // InternalBase.g:1153:1: rule__KeyValue__Group__1__Impl : ( '=' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1157:1: ( ( '=' ) )
            // InternalBase.g:1158:1: ( '=' )
            {
            // InternalBase.g:1158:1: ( '=' )
            // InternalBase.g:1159:2: '='
            {
             before(grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1()); 
            match(input,27,FOLLOW_2); 
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
    // InternalBase.g:1168:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1172:1: ( rule__KeyValue__Group__2__Impl )
            // InternalBase.g:1173:2: rule__KeyValue__Group__2__Impl
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
    // InternalBase.g:1179:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1183:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // InternalBase.g:1184:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // InternalBase.g:1184:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // InternalBase.g:1185:2: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // InternalBase.g:1186:2: ( rule__KeyValue__ValueAssignment_2 )
            // InternalBase.g:1186:3: rule__KeyValue__ValueAssignment_2
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
    // InternalBase.g:1195:1: rule__SimpleAnnotationAttribute__Group__0 : rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 ;
    public final void rule__SimpleAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1199:1: ( rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 )
            // InternalBase.g:1200:2: rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalBase.g:1207:1: rule__SimpleAnnotationAttribute__Group__0__Impl : ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1211:1: ( ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) )
            // InternalBase.g:1212:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            {
            // InternalBase.g:1212:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            // InternalBase.g:1213:2: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 
            // InternalBase.g:1214:2: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            // InternalBase.g:1214:3: rule__SimpleAnnotationAttribute__Alternatives_0
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
    // InternalBase.g:1222:1: rule__SimpleAnnotationAttribute__Group__1 : rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 ;
    public final void rule__SimpleAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1226:1: ( rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 )
            // InternalBase.g:1227:2: rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2
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
    // InternalBase.g:1234:1: rule__SimpleAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1238:1: ( ( 'attribute' ) )
            // InternalBase.g:1239:1: ( 'attribute' )
            {
            // InternalBase.g:1239:1: ( 'attribute' )
            // InternalBase.g:1240:2: 'attribute'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,28,FOLLOW_2); 
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
    // InternalBase.g:1249:1: rule__SimpleAnnotationAttribute__Group__2 : rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 ;
    public final void rule__SimpleAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1253:1: ( rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 )
            // InternalBase.g:1254:2: rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_10);
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
    // InternalBase.g:1261:1: rule__SimpleAnnotationAttribute__Group__2__Impl : ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1265:1: ( ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) )
            // InternalBase.g:1266:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            {
            // InternalBase.g:1266:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            // InternalBase.g:1267:2: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 
            // InternalBase.g:1268:2: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            // InternalBase.g:1268:3: rule__SimpleAnnotationAttribute__NameAssignment_2
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
    // InternalBase.g:1276:1: rule__SimpleAnnotationAttribute__Group__3 : rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 ;
    public final void rule__SimpleAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1280:1: ( rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 )
            // InternalBase.g:1281:2: rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_11);
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
    // InternalBase.g:1288:1: rule__SimpleAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1292:1: ( ( ':' ) )
            // InternalBase.g:1293:1: ( ':' )
            {
            // InternalBase.g:1293:1: ( ':' )
            // InternalBase.g:1294:2: ':'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalBase.g:1303:1: rule__SimpleAnnotationAttribute__Group__4 : rule__SimpleAnnotationAttribute__Group__4__Impl ;
    public final void rule__SimpleAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1307:1: ( rule__SimpleAnnotationAttribute__Group__4__Impl )
            // InternalBase.g:1308:2: rule__SimpleAnnotationAttribute__Group__4__Impl
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
    // InternalBase.g:1314:1: rule__SimpleAnnotationAttribute__Group__4__Impl : ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1318:1: ( ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) )
            // InternalBase.g:1319:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            {
            // InternalBase.g:1319:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            // InternalBase.g:1320:2: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 
            // InternalBase.g:1321:2: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            // InternalBase.g:1321:3: rule__SimpleAnnotationAttribute__TypeAssignment_4
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
    // InternalBase.g:1330:1: rule__EnumAnnotationAttribute__Group__0 : rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 ;
    public final void rule__EnumAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1334:1: ( rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 )
            // InternalBase.g:1335:2: rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalBase.g:1342:1: rule__EnumAnnotationAttribute__Group__0__Impl : ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1346:1: ( ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) )
            // InternalBase.g:1347:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            {
            // InternalBase.g:1347:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            // InternalBase.g:1348:2: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 
            // InternalBase.g:1349:2: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            // InternalBase.g:1349:3: rule__EnumAnnotationAttribute__Alternatives_0
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
    // InternalBase.g:1357:1: rule__EnumAnnotationAttribute__Group__1 : rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 ;
    public final void rule__EnumAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1361:1: ( rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 )
            // InternalBase.g:1362:2: rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2
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
    // InternalBase.g:1369:1: rule__EnumAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__EnumAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1373:1: ( ( 'attribute' ) )
            // InternalBase.g:1374:1: ( 'attribute' )
            {
            // InternalBase.g:1374:1: ( 'attribute' )
            // InternalBase.g:1375:2: 'attribute'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,28,FOLLOW_2); 
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
    // InternalBase.g:1384:1: rule__EnumAnnotationAttribute__Group__2 : rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 ;
    public final void rule__EnumAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1388:1: ( rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 )
            // InternalBase.g:1389:2: rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_10);
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
    // InternalBase.g:1396:1: rule__EnumAnnotationAttribute__Group__2__Impl : ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1400:1: ( ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) )
            // InternalBase.g:1401:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            {
            // InternalBase.g:1401:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            // InternalBase.g:1402:2: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 
            // InternalBase.g:1403:2: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            // InternalBase.g:1403:3: rule__EnumAnnotationAttribute__NameAssignment_2
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
    // InternalBase.g:1411:1: rule__EnumAnnotationAttribute__Group__3 : rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 ;
    public final void rule__EnumAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1415:1: ( rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 )
            // InternalBase.g:1416:2: rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_12);
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
    // InternalBase.g:1423:1: rule__EnumAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1427:1: ( ( ':' ) )
            // InternalBase.g:1428:1: ( ':' )
            {
            // InternalBase.g:1428:1: ( ':' )
            // InternalBase.g:1429:2: ':'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalBase.g:1438:1: rule__EnumAnnotationAttribute__Group__4 : rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 ;
    public final void rule__EnumAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1442:1: ( rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 )
            // InternalBase.g:1443:2: rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5
            {
            pushFollow(FOLLOW_13);
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
    // InternalBase.g:1450:1: rule__EnumAnnotationAttribute__Group__4__Impl : ( '{' ) ;
    public final void rule__EnumAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1454:1: ( ( '{' ) )
            // InternalBase.g:1455:1: ( '{' )
            {
            // InternalBase.g:1455:1: ( '{' )
            // InternalBase.g:1456:2: '{'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,30,FOLLOW_2); 
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
    // InternalBase.g:1465:1: rule__EnumAnnotationAttribute__Group__5 : rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 ;
    public final void rule__EnumAnnotationAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1469:1: ( rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 )
            // InternalBase.g:1470:2: rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6
            {
            pushFollow(FOLLOW_14);
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
    // InternalBase.g:1477:1: rule__EnumAnnotationAttribute__Group__5__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1481:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) )
            // InternalBase.g:1482:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            {
            // InternalBase.g:1482:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            // InternalBase.g:1483:2: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 
            // InternalBase.g:1484:2: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            // InternalBase.g:1484:3: rule__EnumAnnotationAttribute__ValuesAssignment_5
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
    // InternalBase.g:1492:1: rule__EnumAnnotationAttribute__Group__6 : rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 ;
    public final void rule__EnumAnnotationAttribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1496:1: ( rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 )
            // InternalBase.g:1497:2: rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7
            {
            pushFollow(FOLLOW_14);
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
    // InternalBase.g:1504:1: rule__EnumAnnotationAttribute__Group__6__Impl : ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) ;
    public final void rule__EnumAnnotationAttribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1508:1: ( ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) )
            // InternalBase.g:1509:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            {
            // InternalBase.g:1509:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            // InternalBase.g:1510:2: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 
            // InternalBase.g:1511:2: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==26) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalBase.g:1511:3: rule__EnumAnnotationAttribute__Group_6__0
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__EnumAnnotationAttribute__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalBase.g:1519:1: rule__EnumAnnotationAttribute__Group__7 : rule__EnumAnnotationAttribute__Group__7__Impl ;
    public final void rule__EnumAnnotationAttribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1523:1: ( rule__EnumAnnotationAttribute__Group__7__Impl )
            // InternalBase.g:1524:2: rule__EnumAnnotationAttribute__Group__7__Impl
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
    // InternalBase.g:1530:1: rule__EnumAnnotationAttribute__Group__7__Impl : ( '}' ) ;
    public final void rule__EnumAnnotationAttribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1534:1: ( ( '}' ) )
            // InternalBase.g:1535:1: ( '}' )
            {
            // InternalBase.g:1535:1: ( '}' )
            // InternalBase.g:1536:2: '}'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7()); 
            match(input,31,FOLLOW_2); 
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
    // InternalBase.g:1546:1: rule__EnumAnnotationAttribute__Group_6__0 : rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 ;
    public final void rule__EnumAnnotationAttribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1550:1: ( rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 )
            // InternalBase.g:1551:2: rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalBase.g:1558:1: rule__EnumAnnotationAttribute__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1562:1: ( ( ',' ) )
            // InternalBase.g:1563:1: ( ',' )
            {
            // InternalBase.g:1563:1: ( ',' )
            // InternalBase.g:1564:2: ','
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalBase.g:1573:1: rule__EnumAnnotationAttribute__Group_6__1 : rule__EnumAnnotationAttribute__Group_6__1__Impl ;
    public final void rule__EnumAnnotationAttribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1577:1: ( rule__EnumAnnotationAttribute__Group_6__1__Impl )
            // InternalBase.g:1578:2: rule__EnumAnnotationAttribute__Group_6__1__Impl
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
    // InternalBase.g:1584:1: rule__EnumAnnotationAttribute__Group_6__1__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1588:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) )
            // InternalBase.g:1589:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            {
            // InternalBase.g:1589:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            // InternalBase.g:1590:2: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 
            // InternalBase.g:1591:2: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            // InternalBase.g:1591:3: rule__EnumAnnotationAttribute__ValuesAssignment_6_1
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


    // $ANTLR start "rule__ImportedFQN__Group__0"
    // InternalBase.g:1600:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1604:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // InternalBase.g:1605:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalBase.g:1612:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1616:1: ( ( ruleFQN ) )
            // InternalBase.g:1617:1: ( ruleFQN )
            {
            // InternalBase.g:1617:1: ( ruleFQN )
            // InternalBase.g:1618:2: ruleFQN
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
    // InternalBase.g:1627:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1631:1: ( rule__ImportedFQN__Group__1__Impl )
            // InternalBase.g:1632:2: rule__ImportedFQN__Group__1__Impl
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
    // InternalBase.g:1638:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1642:1: ( ( ( '.*' )? ) )
            // InternalBase.g:1643:1: ( ( '.*' )? )
            {
            // InternalBase.g:1643:1: ( ( '.*' )? )
            // InternalBase.g:1644:2: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // InternalBase.g:1645:2: ( '.*' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==32) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalBase.g:1645:3: '.*'
                    {
                    match(input,32,FOLLOW_2); 

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
    // InternalBase.g:1654:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1658:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // InternalBase.g:1659:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalBase.g:1666:1: rule__Documentation__Group__0__Impl : ( () ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1670:1: ( ( () ) )
            // InternalBase.g:1671:1: ( () )
            {
            // InternalBase.g:1671:1: ( () )
            // InternalBase.g:1672:2: ()
            {
             before(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 
            // InternalBase.g:1673:2: ()
            // InternalBase.g:1673:3: 
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
    // InternalBase.g:1681:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1685:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // InternalBase.g:1686:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalBase.g:1693:1: rule__Documentation__Group__1__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1697:1: ( ( '[' ) )
            // InternalBase.g:1698:1: ( '[' )
            {
            // InternalBase.g:1698:1: ( '[' )
            // InternalBase.g:1699:2: '['
            {
             before(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalBase.g:1708:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl rule__Documentation__Group__3 ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1712:1: ( rule__Documentation__Group__2__Impl rule__Documentation__Group__3 )
            // InternalBase.g:1713:2: rule__Documentation__Group__2__Impl rule__Documentation__Group__3
            {
            pushFollow(FOLLOW_17);
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
    // InternalBase.g:1720:1: rule__Documentation__Group__2__Impl : ( ( rule__Documentation__LinesAssignment_2 )* ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1724:1: ( ( ( rule__Documentation__LinesAssignment_2 )* ) )
            // InternalBase.g:1725:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            {
            // InternalBase.g:1725:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            // InternalBase.g:1726:2: ( rule__Documentation__LinesAssignment_2 )*
            {
             before(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 
            // InternalBase.g:1727:2: ( rule__Documentation__LinesAssignment_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_STRING) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBase.g:1727:3: rule__Documentation__LinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Documentation__LinesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalBase.g:1735:1: rule__Documentation__Group__3 : rule__Documentation__Group__3__Impl ;
    public final void rule__Documentation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1739:1: ( rule__Documentation__Group__3__Impl )
            // InternalBase.g:1740:2: rule__Documentation__Group__3__Impl
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
    // InternalBase.g:1746:1: rule__Documentation__Group__3__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1750:1: ( ( ']' ) )
            // InternalBase.g:1751:1: ( ']' )
            {
            // InternalBase.g:1751:1: ( ']' )
            // InternalBase.g:1752:2: ']'
            {
             before(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3()); 
            match(input,34,FOLLOW_2); 
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
    // InternalBase.g:1762:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1766:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // InternalBase.g:1767:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalBase.g:1774:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1778:1: ( ( () ) )
            // InternalBase.g:1779:1: ( () )
            {
            // InternalBase.g:1779:1: ( () )
            // InternalBase.g:1780:2: ()
            {
             before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            // InternalBase.g:1781:2: ()
            // InternalBase.g:1781:3: 
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
    // InternalBase.g:1789:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1793:1: ( rule__BooleanLiteral__Group__1__Impl )
            // InternalBase.g:1794:2: rule__BooleanLiteral__Group__1__Impl
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
    // InternalBase.g:1800:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1804:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // InternalBase.g:1805:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // InternalBase.g:1805:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // InternalBase.g:1806:2: ( rule__BooleanLiteral__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            // InternalBase.g:1807:2: ( rule__BooleanLiteral__Alternatives_1 )
            // InternalBase.g:1807:3: rule__BooleanLiteral__Alternatives_1
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
    // InternalBase.g:1816:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1820:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // InternalBase.g:1821:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalBase.g:1828:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1832:1: ( ( () ) )
            // InternalBase.g:1833:1: ( () )
            {
            // InternalBase.g:1833:1: ( () )
            // InternalBase.g:1834:2: ()
            {
             before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            // InternalBase.g:1835:2: ()
            // InternalBase.g:1835:3: 
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
    // InternalBase.g:1843:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1847:1: ( rule__RealLiteral__Group__1__Impl )
            // InternalBase.g:1848:2: rule__RealLiteral__Group__1__Impl
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
    // InternalBase.g:1854:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1858:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // InternalBase.g:1859:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // InternalBase.g:1859:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // InternalBase.g:1860:2: ( rule__RealLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            // InternalBase.g:1861:2: ( rule__RealLiteral__ValueAssignment_1 )
            // InternalBase.g:1861:3: rule__RealLiteral__ValueAssignment_1
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
    // InternalBase.g:1870:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1874:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // InternalBase.g:1875:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalBase.g:1882:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1886:1: ( ( () ) )
            // InternalBase.g:1887:1: ( () )
            {
            // InternalBase.g:1887:1: ( () )
            // InternalBase.g:1888:2: ()
            {
             before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            // InternalBase.g:1889:2: ()
            // InternalBase.g:1889:3: 
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
    // InternalBase.g:1897:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1901:1: ( rule__IntLiteral__Group__1__Impl )
            // InternalBase.g:1902:2: rule__IntLiteral__Group__1__Impl
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
    // InternalBase.g:1908:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1912:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // InternalBase.g:1913:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // InternalBase.g:1913:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // InternalBase.g:1914:2: ( rule__IntLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            // InternalBase.g:1915:2: ( rule__IntLiteral__ValueAssignment_1 )
            // InternalBase.g:1915:3: rule__IntLiteral__ValueAssignment_1
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
    // InternalBase.g:1924:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1928:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // InternalBase.g:1929:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalBase.g:1936:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1940:1: ( ( () ) )
            // InternalBase.g:1941:1: ( () )
            {
            // InternalBase.g:1941:1: ( () )
            // InternalBase.g:1942:2: ()
            {
             before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            // InternalBase.g:1943:2: ()
            // InternalBase.g:1943:3: 
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
    // InternalBase.g:1951:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1955:1: ( rule__StringLiteral__Group__1__Impl )
            // InternalBase.g:1956:2: rule__StringLiteral__Group__1__Impl
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
    // InternalBase.g:1962:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1966:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // InternalBase.g:1967:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // InternalBase.g:1967:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // InternalBase.g:1968:2: ( rule__StringLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            // InternalBase.g:1969:2: ( rule__StringLiteral__ValueAssignment_1 )
            // InternalBase.g:1969:3: rule__StringLiteral__ValueAssignment_1
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
    // InternalBase.g:1978:1: rule__Integer__Group_0__0 : rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1 ;
    public final void rule__Integer__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1982:1: ( rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1 )
            // InternalBase.g:1983:2: rule__Integer__Group_0__0__Impl rule__Integer__Group_0__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalBase.g:1990:1: rule__Integer__Group_0__0__Impl : ( ( rule__Integer__Alternatives_0_0 )? ) ;
    public final void rule__Integer__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:1994:1: ( ( ( rule__Integer__Alternatives_0_0 )? ) )
            // InternalBase.g:1995:1: ( ( rule__Integer__Alternatives_0_0 )? )
            {
            // InternalBase.g:1995:1: ( ( rule__Integer__Alternatives_0_0 )? )
            // InternalBase.g:1996:2: ( rule__Integer__Alternatives_0_0 )?
            {
             before(grammarAccess.getIntegerAccess().getAlternatives_0_0()); 
            // InternalBase.g:1997:2: ( rule__Integer__Alternatives_0_0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=15 && LA20_0<=16)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBase.g:1997:3: rule__Integer__Alternatives_0_0
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
    // InternalBase.g:2005:1: rule__Integer__Group_0__1 : rule__Integer__Group_0__1__Impl ;
    public final void rule__Integer__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2009:1: ( rule__Integer__Group_0__1__Impl )
            // InternalBase.g:2010:2: rule__Integer__Group_0__1__Impl
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
    // InternalBase.g:2016:1: rule__Integer__Group_0__1__Impl : ( RULE_INT ) ;
    public final void rule__Integer__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2020:1: ( ( RULE_INT ) )
            // InternalBase.g:2021:1: ( RULE_INT )
            {
            // InternalBase.g:2021:1: ( RULE_INT )
            // InternalBase.g:2022:2: RULE_INT
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
    // InternalBase.g:2032:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2036:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // InternalBase.g:2037:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalBase.g:2044:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2048:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // InternalBase.g:2049:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // InternalBase.g:2049:1: ( ( rule__Decimal__Alternatives_0 )? )
            // InternalBase.g:2050:2: ( rule__Decimal__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            // InternalBase.g:2051:2: ( rule__Decimal__Alternatives_0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=15 && LA21_0<=16)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalBase.g:2051:3: rule__Decimal__Alternatives_0
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
    // InternalBase.g:2059:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2063:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // InternalBase.g:2064:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_22);
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
    // InternalBase.g:2071:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2075:1: ( ( RULE_INT ) )
            // InternalBase.g:2076:1: ( RULE_INT )
            {
            // InternalBase.g:2076:1: ( RULE_INT )
            // InternalBase.g:2077:2: RULE_INT
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
    // InternalBase.g:2086:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2090:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // InternalBase.g:2091:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
            {
            pushFollow(FOLLOW_23);
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
    // InternalBase.g:2098:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2102:1: ( ( '.' ) )
            // InternalBase.g:2103:1: ( '.' )
            {
            // InternalBase.g:2103:1: ( '.' )
            // InternalBase.g:2104:2: '.'
            {
             before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            match(input,35,FOLLOW_2); 
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
    // InternalBase.g:2113:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2117:1: ( rule__Decimal__Group__3__Impl )
            // InternalBase.g:2118:2: rule__Decimal__Group__3__Impl
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
    // InternalBase.g:2124:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2128:1: ( ( RULE_INT ) )
            // InternalBase.g:2129:1: ( RULE_INT )
            {
            // InternalBase.g:2129:1: ( RULE_INT )
            // InternalBase.g:2130:2: RULE_INT
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
    // InternalBase.g:2140:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2144:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // InternalBase.g:2145:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalBase.g:2152:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2156:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // InternalBase.g:2157:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // InternalBase.g:2157:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // InternalBase.g:2158:2: ( rule__DecimalExp__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            // InternalBase.g:2159:2: ( rule__DecimalExp__Alternatives_0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=15 && LA22_0<=16)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalBase.g:2159:3: rule__DecimalExp__Alternatives_0
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
    // InternalBase.g:2167:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2171:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // InternalBase.g:2172:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
            {
            pushFollow(FOLLOW_22);
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
    // InternalBase.g:2179:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2183:1: ( ( RULE_INT ) )
            // InternalBase.g:2184:1: ( RULE_INT )
            {
            // InternalBase.g:2184:1: ( RULE_INT )
            // InternalBase.g:2185:2: RULE_INT
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
    // InternalBase.g:2194:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2198:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // InternalBase.g:2199:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
            {
            pushFollow(FOLLOW_23);
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
    // InternalBase.g:2206:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2210:1: ( ( '.' ) )
            // InternalBase.g:2211:1: ( '.' )
            {
            // InternalBase.g:2211:1: ( '.' )
            // InternalBase.g:2212:2: '.'
            {
             before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            match(input,35,FOLLOW_2); 
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
    // InternalBase.g:2221:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2225:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // InternalBase.g:2226:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
            {
            pushFollow(FOLLOW_24);
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
    // InternalBase.g:2233:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2237:1: ( ( RULE_INT ) )
            // InternalBase.g:2238:1: ( RULE_INT )
            {
            // InternalBase.g:2238:1: ( RULE_INT )
            // InternalBase.g:2239:2: RULE_INT
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
    // InternalBase.g:2248:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5 ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2252:1: ( rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5 )
            // InternalBase.g:2253:2: rule__DecimalExp__Group__4__Impl rule__DecimalExp__Group__5
            {
            pushFollow(FOLLOW_21);
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
    // InternalBase.g:2260:1: rule__DecimalExp__Group__4__Impl : ( ( rule__DecimalExp__Alternatives_4 ) ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2264:1: ( ( ( rule__DecimalExp__Alternatives_4 ) ) )
            // InternalBase.g:2265:1: ( ( rule__DecimalExp__Alternatives_4 ) )
            {
            // InternalBase.g:2265:1: ( ( rule__DecimalExp__Alternatives_4 ) )
            // InternalBase.g:2266:2: ( rule__DecimalExp__Alternatives_4 )
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_4()); 
            // InternalBase.g:2267:2: ( rule__DecimalExp__Alternatives_4 )
            // InternalBase.g:2267:3: rule__DecimalExp__Alternatives_4
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
    // InternalBase.g:2275:1: rule__DecimalExp__Group__5 : rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6 ;
    public final void rule__DecimalExp__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2279:1: ( rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6 )
            // InternalBase.g:2280:2: rule__DecimalExp__Group__5__Impl rule__DecimalExp__Group__6
            {
            pushFollow(FOLLOW_21);
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
    // InternalBase.g:2287:1: rule__DecimalExp__Group__5__Impl : ( ( rule__DecimalExp__Alternatives_5 )? ) ;
    public final void rule__DecimalExp__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2291:1: ( ( ( rule__DecimalExp__Alternatives_5 )? ) )
            // InternalBase.g:2292:1: ( ( rule__DecimalExp__Alternatives_5 )? )
            {
            // InternalBase.g:2292:1: ( ( rule__DecimalExp__Alternatives_5 )? )
            // InternalBase.g:2293:2: ( rule__DecimalExp__Alternatives_5 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_5()); 
            // InternalBase.g:2294:2: ( rule__DecimalExp__Alternatives_5 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=15 && LA23_0<=16)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalBase.g:2294:3: rule__DecimalExp__Alternatives_5
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
    // InternalBase.g:2302:1: rule__DecimalExp__Group__6 : rule__DecimalExp__Group__6__Impl ;
    public final void rule__DecimalExp__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2306:1: ( rule__DecimalExp__Group__6__Impl )
            // InternalBase.g:2307:2: rule__DecimalExp__Group__6__Impl
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
    // InternalBase.g:2313:1: rule__DecimalExp__Group__6__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2317:1: ( ( RULE_INT ) )
            // InternalBase.g:2318:1: ( RULE_INT )
            {
            // InternalBase.g:2318:1: ( RULE_INT )
            // InternalBase.g:2319:2: RULE_INT
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
    // InternalBase.g:2329:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2333:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalBase.g:2334:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalBase.g:2341:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2345:1: ( ( RULE_ID ) )
            // InternalBase.g:2346:1: ( RULE_ID )
            {
            // InternalBase.g:2346:1: ( RULE_ID )
            // InternalBase.g:2347:2: RULE_ID
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
    // InternalBase.g:2356:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2360:1: ( rule__FQN__Group__1__Impl )
            // InternalBase.g:2361:2: rule__FQN__Group__1__Impl
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
    // InternalBase.g:2367:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2371:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalBase.g:2372:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalBase.g:2372:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalBase.g:2373:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalBase.g:2374:2: ( rule__FQN__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==35) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBase.g:2374:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalBase.g:2383:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2387:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalBase.g:2388:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
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
    // InternalBase.g:2395:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2399:1: ( ( '.' ) )
            // InternalBase.g:2400:1: ( '.' )
            {
            // InternalBase.g:2400:1: ( '.' )
            // InternalBase.g:2401:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,35,FOLLOW_2); 
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
    // InternalBase.g:2410:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2414:1: ( rule__FQN__Group_1__1__Impl )
            // InternalBase.g:2415:2: rule__FQN__Group_1__1__Impl
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
    // InternalBase.g:2421:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2425:1: ( ( RULE_ID ) )
            // InternalBase.g:2426:1: ( RULE_ID )
            {
            // InternalBase.g:2426:1: ( RULE_ID )
            // InternalBase.g:2427:2: RULE_ID
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


    // $ANTLR start "rule__Annotation__TypeAssignment_1"
    // InternalBase.g:2437:1: rule__Annotation__TypeAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__Annotation__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2441:1: ( ( ( ruleFQN ) ) )
            // InternalBase.g:2442:2: ( ( ruleFQN ) )
            {
            // InternalBase.g:2442:2: ( ( ruleFQN ) )
            // InternalBase.g:2443:3: ( ruleFQN )
            {
             before(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0()); 
            // InternalBase.g:2444:3: ( ruleFQN )
            // InternalBase.g:2445:4: ruleFQN
            {
             before(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeFQNParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeFQNParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__TypeAssignment_1"


    // $ANTLR start "rule__Annotation__AttributesAssignment_2_1"
    // InternalBase.g:2456:1: rule__Annotation__AttributesAssignment_2_1 : ( ruleKeyValue ) ;
    public final void rule__Annotation__AttributesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2460:1: ( ( ruleKeyValue ) )
            // InternalBase.g:2461:2: ( ruleKeyValue )
            {
            // InternalBase.g:2461:2: ( ruleKeyValue )
            // InternalBase.g:2462:3: ruleKeyValue
            {
             before(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__AttributesAssignment_2_1"


    // $ANTLR start "rule__Annotation__AttributesAssignment_2_2_1"
    // InternalBase.g:2471:1: rule__Annotation__AttributesAssignment_2_2_1 : ( ruleKeyValue ) ;
    public final void rule__Annotation__AttributesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2475:1: ( ( ruleKeyValue ) )
            // InternalBase.g:2476:2: ( ruleKeyValue )
            {
            // InternalBase.g:2476:2: ( ruleKeyValue )
            // InternalBase.g:2477:3: ruleKeyValue
            {
             before(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__AttributesAssignment_2_2_1"


    // $ANTLR start "rule__KeyValue__KeyAssignment_0"
    // InternalBase.g:2486:1: rule__KeyValue__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2490:1: ( ( RULE_ID ) )
            // InternalBase.g:2491:2: ( RULE_ID )
            {
            // InternalBase.g:2491:2: ( RULE_ID )
            // InternalBase.g:2492:3: RULE_ID
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
    // InternalBase.g:2501:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2505:1: ( ( ruleLiteral ) )
            // InternalBase.g:2506:2: ( ruleLiteral )
            {
            // InternalBase.g:2506:2: ( ruleLiteral )
            // InternalBase.g:2507:3: ruleLiteral
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
    // InternalBase.g:2516:1: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__SimpleAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2520:1: ( ( ( 'optional' ) ) )
            // InternalBase.g:2521:2: ( ( 'optional' ) )
            {
            // InternalBase.g:2521:2: ( ( 'optional' ) )
            // InternalBase.g:2522:3: ( 'optional' )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // InternalBase.g:2523:3: ( 'optional' )
            // InternalBase.g:2524:4: 'optional'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalBase.g:2535:1: rule__SimpleAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2539:1: ( ( RULE_ID ) )
            // InternalBase.g:2540:2: ( RULE_ID )
            {
            // InternalBase.g:2540:2: ( RULE_ID )
            // InternalBase.g:2541:3: RULE_ID
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
    // InternalBase.g:2550:1: rule__SimpleAnnotationAttribute__TypeAssignment_4 : ( ruleLiteralType ) ;
    public final void rule__SimpleAnnotationAttribute__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2554:1: ( ( ruleLiteralType ) )
            // InternalBase.g:2555:2: ( ruleLiteralType )
            {
            // InternalBase.g:2555:2: ( ruleLiteralType )
            // InternalBase.g:2556:3: ruleLiteralType
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
    // InternalBase.g:2565:1: rule__EnumAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__EnumAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2569:1: ( ( ( 'optional' ) ) )
            // InternalBase.g:2570:2: ( ( 'optional' ) )
            {
            // InternalBase.g:2570:2: ( ( 'optional' ) )
            // InternalBase.g:2571:3: ( 'optional' )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // InternalBase.g:2572:3: ( 'optional' )
            // InternalBase.g:2573:4: 'optional'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalBase.g:2584:1: rule__EnumAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EnumAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2588:1: ( ( RULE_ID ) )
            // InternalBase.g:2589:2: ( RULE_ID )
            {
            // InternalBase.g:2589:2: ( RULE_ID )
            // InternalBase.g:2590:3: RULE_ID
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
    // InternalBase.g:2599:1: rule__EnumAnnotationAttribute__ValuesAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2603:1: ( ( RULE_STRING ) )
            // InternalBase.g:2604:2: ( RULE_STRING )
            {
            // InternalBase.g:2604:2: ( RULE_STRING )
            // InternalBase.g:2605:3: RULE_STRING
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
    // InternalBase.g:2614:1: rule__EnumAnnotationAttribute__ValuesAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2618:1: ( ( RULE_STRING ) )
            // InternalBase.g:2619:2: ( RULE_STRING )
            {
            // InternalBase.g:2619:2: ( RULE_STRING )
            // InternalBase.g:2620:3: RULE_STRING
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


    // $ANTLR start "rule__Documentation__LinesAssignment_2"
    // InternalBase.g:2629:1: rule__Documentation__LinesAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Documentation__LinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2633:1: ( ( RULE_STRING ) )
            // InternalBase.g:2634:2: ( RULE_STRING )
            {
            // InternalBase.g:2634:2: ( RULE_STRING )
            // InternalBase.g:2635:3: RULE_STRING
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
    // InternalBase.g:2644:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2648:1: ( ( ( 'true' ) ) )
            // InternalBase.g:2649:2: ( ( 'true' ) )
            {
            // InternalBase.g:2649:2: ( ( 'true' ) )
            // InternalBase.g:2650:3: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            // InternalBase.g:2651:3: ( 'true' )
            // InternalBase.g:2652:4: 'true'
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            match(input,37,FOLLOW_2); 
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
    // InternalBase.g:2663:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2667:1: ( ( ruleReal ) )
            // InternalBase.g:2668:2: ( ruleReal )
            {
            // InternalBase.g:2668:2: ( ruleReal )
            // InternalBase.g:2669:3: ruleReal
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
    // InternalBase.g:2678:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2682:1: ( ( ruleInteger ) )
            // InternalBase.g:2683:2: ( ruleInteger )
            {
            // InternalBase.g:2683:2: ( ruleInteger )
            // InternalBase.g:2684:3: ruleInteger
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
    // InternalBase.g:2693:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBase.g:2697:1: ( ( RULE_STRING ) )
            // InternalBase.g:2698:2: ( RULE_STRING )
            {
            // InternalBase.g:2698:2: ( RULE_STRING )
            // InternalBase.g:2699:3: RULE_STRING
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
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000200001C0E0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000780000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000400000080L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000002000004000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000018060L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000800000002L});

}