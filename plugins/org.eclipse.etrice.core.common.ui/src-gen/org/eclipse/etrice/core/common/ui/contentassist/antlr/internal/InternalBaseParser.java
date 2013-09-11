package org.eclipse.etrice.core.common.ui.contentassist.antlr.internal; 

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
import org.eclipse.etrice.core.common.services.BaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBaseParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_HEX", "RULE_INT", "RULE_EXP", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'false'", "'+'", "'-'", "','", "'.'", "'true'"
    };
    public static final int RULE_ID=8;
    public static final int RULE_EXP=6;
    public static final int RULE_STRING=7;
    public static final int RULE_HEX=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_INT=5;
    public static final int RULE_WS=11;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;

    // delegates
    // delegators


        public InternalBaseParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBaseParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBaseParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g"; }


     
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




    // $ANTLR start "entryRuleLiteralArray"
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:60:1: entryRuleLiteralArray : ruleLiteralArray EOF ;
    public final void entryRuleLiteralArray() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:61:1: ( ruleLiteralArray EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:62:1: ruleLiteralArray EOF
            {
             before(grammarAccess.getLiteralArrayRule()); 
            pushFollow(FOLLOW_ruleLiteralArray_in_entryRuleLiteralArray61);
            ruleLiteralArray();

            state._fsp--;

             after(grammarAccess.getLiteralArrayRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralArray68); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:69:1: ruleLiteralArray : ( ( rule__LiteralArray__Group__0 ) ) ;
    public final void ruleLiteralArray() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:73:2: ( ( ( rule__LiteralArray__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:74:1: ( ( rule__LiteralArray__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:74:1: ( ( rule__LiteralArray__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:75:1: ( rule__LiteralArray__Group__0 )
            {
             before(grammarAccess.getLiteralArrayAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:76:1: ( rule__LiteralArray__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:76:2: rule__LiteralArray__Group__0
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group__0_in_ruleLiteralArray94);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:88:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:89:1: ( ruleLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:90:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral121);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral128); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:97:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:101:2: ( ( ( rule__Literal__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:102:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:102:1: ( ( rule__Literal__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:103:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:104:1: ( rule__Literal__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:104:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral154);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:116:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:117:1: ( ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:118:1: ruleBooleanLiteral EOF
            {
             before(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral181);
            ruleBooleanLiteral();

            state._fsp--;

             after(grammarAccess.getBooleanLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral188); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:125:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:129:2: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:130:1: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:130:1: ( ( rule__BooleanLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:131:1: ( rule__BooleanLiteral__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:132:1: ( rule__BooleanLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:132:2: rule__BooleanLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral214);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:144:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:145:1: ( ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:146:1: ruleNumberLiteral EOF
            {
             before(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral241);
            ruleNumberLiteral();

            state._fsp--;

             after(grammarAccess.getNumberLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral248); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:153:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Alternatives ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:157:2: ( ( ( rule__NumberLiteral__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:158:1: ( ( rule__NumberLiteral__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:158:1: ( ( rule__NumberLiteral__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:159:1: ( rule__NumberLiteral__Alternatives )
            {
             before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:160:1: ( rule__NumberLiteral__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:160:2: rule__NumberLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral274);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:172:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:173:1: ( ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:174:1: ruleRealLiteral EOF
            {
             before(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral301);
            ruleRealLiteral();

            state._fsp--;

             after(grammarAccess.getRealLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral308); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:181:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:185:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:186:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:186:1: ( ( rule__RealLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:187:1: ( rule__RealLiteral__Group__0 )
            {
             before(grammarAccess.getRealLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:188:1: ( rule__RealLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:188:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral334);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:200:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:201:1: ( ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:202:1: ruleIntLiteral EOF
            {
             before(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral361);
            ruleIntLiteral();

            state._fsp--;

             after(grammarAccess.getIntLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral368); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:209:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:213:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:214:1: ( ( rule__IntLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:214:1: ( ( rule__IntLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:215:1: ( rule__IntLiteral__Group__0 )
            {
             before(grammarAccess.getIntLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:216:1: ( rule__IntLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:216:2: rule__IntLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral394);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:228:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:229:1: ( ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:230:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral421);
            ruleStringLiteral();

            state._fsp--;

             after(grammarAccess.getStringLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral428); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:237:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:241:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:242:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:242:1: ( ( rule__StringLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:243:1: ( rule__StringLiteral__Group__0 )
            {
             before(grammarAccess.getStringLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:244:1: ( rule__StringLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:244:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral454);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:256:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:257:1: ( ruleInteger EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:258:1: ruleInteger EOF
            {
             before(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger481);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger488); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:265:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:269:2: ( ( ( rule__Integer__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:270:1: ( ( rule__Integer__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:270:1: ( ( rule__Integer__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:271:1: ( rule__Integer__Alternatives )
            {
             before(grammarAccess.getIntegerAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:272:1: ( rule__Integer__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:272:2: rule__Integer__Alternatives
            {
            pushFollow(FOLLOW_rule__Integer__Alternatives_in_ruleInteger514);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:284:1: entryRuleSignedInteger : ruleSignedInteger EOF ;
    public final void entryRuleSignedInteger() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:288:1: ( ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:289:1: ruleSignedInteger EOF
            {
             before(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger546);
            ruleSignedInteger();

            state._fsp--;

             after(grammarAccess.getSignedIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger553); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:299:1: ruleSignedInteger : ( ( rule__SignedInteger__Group__0 ) ) ;
    public final void ruleSignedInteger() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:304:2: ( ( ( rule__SignedInteger__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:305:1: ( ( rule__SignedInteger__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:305:1: ( ( rule__SignedInteger__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:306:1: ( rule__SignedInteger__Group__0 )
            {
             before(grammarAccess.getSignedIntegerAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:307:1: ( rule__SignedInteger__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:307:2: rule__SignedInteger__Group__0
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger583);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:320:1: entryRuleHexadecimal : ruleHexadecimal EOF ;
    public final void entryRuleHexadecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:324:1: ( ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:325:1: ruleHexadecimal EOF
            {
             before(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal615);
            ruleHexadecimal();

            state._fsp--;

             after(grammarAccess.getHexadecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal622); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:335:1: ruleHexadecimal : ( RULE_HEX ) ;
    public final void ruleHexadecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:340:2: ( ( RULE_HEX ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:341:1: ( RULE_HEX )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:341:1: ( RULE_HEX )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:342:1: RULE_HEX
            {
             before(grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 
            match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal652); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:356:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:357:1: ( ruleReal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:358:1: ruleReal EOF
            {
             before(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal678);
            ruleReal();

            state._fsp--;

             after(grammarAccess.getRealRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal685); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:365:1: ruleReal : ( ( rule__Real__Alternatives ) ) ;
    public final void ruleReal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:369:2: ( ( ( rule__Real__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:370:1: ( ( rule__Real__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:370:1: ( ( rule__Real__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:371:1: ( rule__Real__Alternatives )
            {
             before(grammarAccess.getRealAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:372:1: ( rule__Real__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:372:2: rule__Real__Alternatives
            {
            pushFollow(FOLLOW_rule__Real__Alternatives_in_ruleReal711);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:384:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:388:1: ( ruleDecimal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:389:1: ruleDecimal EOF
            {
             before(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal743);
            ruleDecimal();

            state._fsp--;

             after(grammarAccess.getDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal750); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:399:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:404:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:405:1: ( ( rule__Decimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:405:1: ( ( rule__Decimal__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:406:1: ( rule__Decimal__Group__0 )
            {
             before(grammarAccess.getDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:407:1: ( rule__Decimal__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:407:2: rule__Decimal__Group__0
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0_in_ruleDecimal780);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:420:1: entryRuleDotDecimal : ruleDotDecimal EOF ;
    public final void entryRuleDotDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:424:1: ( ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:425:1: ruleDotDecimal EOF
            {
             before(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal812);
            ruleDotDecimal();

            state._fsp--;

             after(grammarAccess.getDotDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal819); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:435:1: ruleDotDecimal : ( ( rule__DotDecimal__Group__0 ) ) ;
    public final void ruleDotDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:440:2: ( ( ( rule__DotDecimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:441:1: ( ( rule__DotDecimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:441:1: ( ( rule__DotDecimal__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:442:1: ( rule__DotDecimal__Group__0 )
            {
             before(grammarAccess.getDotDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:443:1: ( rule__DotDecimal__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:443:2: rule__DotDecimal__Group__0
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal849);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:456:1: entryRuleDecimalDot : ruleDecimalDot EOF ;
    public final void entryRuleDecimalDot() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:460:1: ( ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:461:1: ruleDecimalDot EOF
            {
             before(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot881);
            ruleDecimalDot();

            state._fsp--;

             after(grammarAccess.getDecimalDotRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot888); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:471:1: ruleDecimalDot : ( ( rule__DecimalDot__Group__0 ) ) ;
    public final void ruleDecimalDot() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:476:2: ( ( ( rule__DecimalDot__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:477:1: ( ( rule__DecimalDot__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:477:1: ( ( rule__DecimalDot__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:478:1: ( rule__DecimalDot__Group__0 )
            {
             before(grammarAccess.getDecimalDotAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:479:1: ( rule__DecimalDot__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:479:2: rule__DecimalDot__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot918);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:492:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:496:1: ( ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:497:1: ruleDecimalExp EOF
            {
             before(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp950);
            ruleDecimalExp();

            state._fsp--;

             after(grammarAccess.getDecimalExpRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp957); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:507:1: ruleDecimalExp : ( ( rule__DecimalExp__Group__0 ) ) ;
    public final void ruleDecimalExp() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:512:2: ( ( ( rule__DecimalExp__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:513:1: ( ( rule__DecimalExp__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:513:1: ( ( rule__DecimalExp__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:514:1: ( rule__DecimalExp__Group__0 )
            {
             before(grammarAccess.getDecimalExpAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:515:1: ( rule__DecimalExp__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:515:2: rule__DecimalExp__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp987);
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


    // $ANTLR start "rule__Literal__Alternatives"
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:528:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:532:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 13:
            case 18:
                {
                alt1=1;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case 14:
            case 15:
            case 17:
                {
                alt1=2;
                }
                break;
            case RULE_STRING:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:533:1: ( ruleBooleanLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:533:1: ( ruleBooleanLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:534:1: ruleBooleanLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives1023);
                    ruleBooleanLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:539:6: ( ruleNumberLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:539:6: ( ruleNumberLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:540:1: ruleNumberLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives1040);
                    ruleNumberLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:545:6: ( ruleStringLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:545:6: ( ruleStringLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:546:1: ruleStringLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives1057);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:556:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:560:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:561:1: ( 'false' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:561:1: ( 'false' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:562:1: 'false'
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    match(input,13,FOLLOW_13_in_rule__BooleanLiteral__Alternatives_11090); 
                     after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:569:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:569:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:570:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:571:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:571:2: rule__BooleanLiteral__IsTrueAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_11109);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:580:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:584:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
            int alt3=2;
            switch ( input.LA(1) ) {
            case 14:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==17) ) {
                    alt3=2;
                }
                else if ( (LA3_1==RULE_INT) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==17) ) {
                        alt3=2;
                    }
                    else if ( (LA3_3==EOF||LA3_3==16) ) {
                        alt3=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==RULE_INT) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==17) ) {
                        alt3=2;
                    }
                    else if ( (LA3_3==EOF||LA3_3==16) ) {
                        alt3=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_2==17) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3==17) ) {
                    alt3=2;
                }
                else if ( (LA3_3==EOF||LA3_3==16) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt3=1;
                }
                break;
            case 17:
                {
                alt3=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:585:1: ( ruleIntLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:585:1: ( ruleIntLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:586:1: ruleIntLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives1142);
                    ruleIntLiteral();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:591:6: ( ruleRealLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:591:6: ( ruleRealLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:592:1: ruleRealLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives1159);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:602:1: rule__Integer__Alternatives : ( ( ruleSignedInteger ) | ( ruleHexadecimal ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:606:1: ( ( ruleSignedInteger ) | ( ruleHexadecimal ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_INT||(LA4_0>=14 && LA4_0<=15)) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_HEX) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:607:1: ( ruleSignedInteger )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:607:1: ( ruleSignedInteger )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:608:1: ruleSignedInteger
                    {
                     before(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives1191);
                    ruleSignedInteger();

                    state._fsp--;

                     after(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:613:6: ( ruleHexadecimal )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:613:6: ( ruleHexadecimal )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:614:1: ruleHexadecimal
                    {
                     before(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives1208);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:624:1: rule__SignedInteger__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__SignedInteger__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:628:1: ( ( '+' ) | ( '-' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            else if ( (LA5_0==15) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:629:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:629:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:630:1: '+'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__SignedInteger__Alternatives_01241); 
                     after(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:637:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:637:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:638:1: '-'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__SignedInteger__Alternatives_01261); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:650:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:654:1: ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) )
            int alt6=4;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:655:1: ( ruleDecimal )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:655:1: ( ruleDecimal )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:656:1: ruleDecimal
                    {
                     before(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDecimal_in_rule__Real__Alternatives1295);
                    ruleDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:661:6: ( ruleDotDecimal )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:661:6: ( ruleDotDecimal )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:662:1: ruleDotDecimal
                    {
                     before(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives1312);
                    ruleDotDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:667:6: ( ruleDecimalDot )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:667:6: ( ruleDecimalDot )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:668:1: ruleDecimalDot
                    {
                     before(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives1329);
                    ruleDecimalDot();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:673:6: ( ruleDecimalExp )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:673:6: ( ruleDecimalExp )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:674:1: ruleDecimalExp
                    {
                     before(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives1346);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:684:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:688:1: ( ( '+' ) | ( '-' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            else if ( (LA7_0==15) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:689:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:689:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:690:1: '+'
                    {
                     before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__Decimal__Alternatives_01379); 
                     after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:697:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:697:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:698:1: '-'
                    {
                     before(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__Decimal__Alternatives_01399); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:710:1: rule__DotDecimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DotDecimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:714:1: ( ( '+' ) | ( '-' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==14) ) {
                alt8=1;
            }
            else if ( (LA8_0==15) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:715:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:715:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:716:1: '+'
                    {
                     before(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__DotDecimal__Alternatives_01434); 
                     after(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:723:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:723:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:724:1: '-'
                    {
                     before(grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__DotDecimal__Alternatives_01454); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:736:1: rule__DecimalDot__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalDot__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:740:1: ( ( '+' ) | ( '-' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==14) ) {
                alt9=1;
            }
            else if ( (LA9_0==15) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:741:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:741:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:742:1: '+'
                    {
                     before(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__DecimalDot__Alternatives_01489); 
                     after(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:749:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:749:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:750:1: '-'
                    {
                     before(grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__DecimalDot__Alternatives_01509); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:762:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:766:1: ( ( '+' ) | ( '-' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==14) ) {
                alt10=1;
            }
            else if ( (LA10_0==15) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:767:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:767:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:768:1: '+'
                    {
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__DecimalExp__Alternatives_01544); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:775:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:775:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:776:1: '-'
                    {
                     before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__DecimalExp__Alternatives_01564); 
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


    // $ANTLR start "rule__LiteralArray__Group__0"
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:790:1: rule__LiteralArray__Group__0 : rule__LiteralArray__Group__0__Impl rule__LiteralArray__Group__1 ;
    public final void rule__LiteralArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:794:1: ( rule__LiteralArray__Group__0__Impl rule__LiteralArray__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:795:2: rule__LiteralArray__Group__0__Impl rule__LiteralArray__Group__1
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group__0__Impl_in_rule__LiteralArray__Group__01596);
            rule__LiteralArray__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LiteralArray__Group__1_in_rule__LiteralArray__Group__01599);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:802:1: rule__LiteralArray__Group__0__Impl : ( ( rule__LiteralArray__LiteralsAssignment_0 ) ) ;
    public final void rule__LiteralArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:806:1: ( ( ( rule__LiteralArray__LiteralsAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:807:1: ( ( rule__LiteralArray__LiteralsAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:807:1: ( ( rule__LiteralArray__LiteralsAssignment_0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:808:1: ( rule__LiteralArray__LiteralsAssignment_0 )
            {
             before(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:809:1: ( rule__LiteralArray__LiteralsAssignment_0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:809:2: rule__LiteralArray__LiteralsAssignment_0
            {
            pushFollow(FOLLOW_rule__LiteralArray__LiteralsAssignment_0_in_rule__LiteralArray__Group__0__Impl1626);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:819:1: rule__LiteralArray__Group__1 : rule__LiteralArray__Group__1__Impl ;
    public final void rule__LiteralArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:823:1: ( rule__LiteralArray__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:824:2: rule__LiteralArray__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group__1__Impl_in_rule__LiteralArray__Group__11656);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:830:1: rule__LiteralArray__Group__1__Impl : ( ( rule__LiteralArray__Group_1__0 )* ) ;
    public final void rule__LiteralArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:834:1: ( ( ( rule__LiteralArray__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:835:1: ( ( rule__LiteralArray__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:835:1: ( ( rule__LiteralArray__Group_1__0 )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:836:1: ( rule__LiteralArray__Group_1__0 )*
            {
             before(grammarAccess.getLiteralArrayAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:837:1: ( rule__LiteralArray__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==16) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:837:2: rule__LiteralArray__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__LiteralArray__Group_1__0_in_rule__LiteralArray__Group__1__Impl1683);
            	    rule__LiteralArray__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:851:1: rule__LiteralArray__Group_1__0 : rule__LiteralArray__Group_1__0__Impl rule__LiteralArray__Group_1__1 ;
    public final void rule__LiteralArray__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:855:1: ( rule__LiteralArray__Group_1__0__Impl rule__LiteralArray__Group_1__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:856:2: rule__LiteralArray__Group_1__0__Impl rule__LiteralArray__Group_1__1
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group_1__0__Impl_in_rule__LiteralArray__Group_1__01718);
            rule__LiteralArray__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LiteralArray__Group_1__1_in_rule__LiteralArray__Group_1__01721);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:863:1: rule__LiteralArray__Group_1__0__Impl : ( ',' ) ;
    public final void rule__LiteralArray__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:867:1: ( ( ',' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:868:1: ( ',' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:868:1: ( ',' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:869:1: ','
            {
             before(grammarAccess.getLiteralArrayAccess().getCommaKeyword_1_0()); 
            match(input,16,FOLLOW_16_in_rule__LiteralArray__Group_1__0__Impl1749); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:882:1: rule__LiteralArray__Group_1__1 : rule__LiteralArray__Group_1__1__Impl ;
    public final void rule__LiteralArray__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:886:1: ( rule__LiteralArray__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:887:2: rule__LiteralArray__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__LiteralArray__Group_1__1__Impl_in_rule__LiteralArray__Group_1__11780);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:893:1: rule__LiteralArray__Group_1__1__Impl : ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) ) ;
    public final void rule__LiteralArray__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:897:1: ( ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:898:1: ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:898:1: ( ( rule__LiteralArray__LiteralsAssignment_1_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:899:1: ( rule__LiteralArray__LiteralsAssignment_1_1 )
            {
             before(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_1_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:900:1: ( rule__LiteralArray__LiteralsAssignment_1_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:900:2: rule__LiteralArray__LiteralsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__LiteralArray__LiteralsAssignment_1_1_in_rule__LiteralArray__Group_1__1__Impl1807);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:914:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:918:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:919:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__01841);
            rule__BooleanLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__01844);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:926:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:930:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:931:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:931:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:932:1: ()
            {
             before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:933:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:935:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:945:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:949:1: ( rule__BooleanLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:950:2: rule__BooleanLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__11902);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:956:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:960:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:961:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:961:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:962:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:963:1: ( rule__BooleanLiteral__Alternatives_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:963:2: rule__BooleanLiteral__Alternatives_1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl1929);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:977:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:981:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:982:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__01963);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__01966);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:989:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:993:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:994:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:994:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:995:1: ()
            {
             before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:996:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:998:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1008:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1012:1: ( rule__RealLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1013:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__12024);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1019:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1023:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1024:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1024:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1025:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1026:1: ( rule__RealLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1026:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl2051);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1040:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1044:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1045:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__02085);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__02088);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1052:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1056:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1057:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1057:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1058:1: ()
            {
             before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1059:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1061:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1071:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1075:1: ( rule__IntLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1076:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__12146);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1082:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1086:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1087:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1087:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1088:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1089:1: ( rule__IntLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1089:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl2173);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1103:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1107:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1108:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__02207);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__02210);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1115:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1119:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1120:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1120:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1121:1: ()
            {
             before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1122:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1124:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1134:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1138:1: ( rule__StringLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1139:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__12268);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1145:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1149:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1150:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1150:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1151:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1152:1: ( rule__StringLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1152:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl2295);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1166:1: rule__SignedInteger__Group__0 : rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 ;
    public final void rule__SignedInteger__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1170:1: ( rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1171:2: rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__02329);
            rule__SignedInteger__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__02332);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1178:1: rule__SignedInteger__Group__0__Impl : ( ( rule__SignedInteger__Alternatives_0 )? ) ;
    public final void rule__SignedInteger__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1182:1: ( ( ( rule__SignedInteger__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1183:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1183:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1184:1: ( rule__SignedInteger__Alternatives_0 )?
            {
             before(grammarAccess.getSignedIntegerAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1185:1: ( rule__SignedInteger__Alternatives_0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=14 && LA12_0<=15)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1185:2: rule__SignedInteger__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl2359);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1195:1: rule__SignedInteger__Group__1 : rule__SignedInteger__Group__1__Impl ;
    public final void rule__SignedInteger__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1199:1: ( rule__SignedInteger__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1200:2: rule__SignedInteger__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__12390);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1206:1: rule__SignedInteger__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__SignedInteger__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1210:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1211:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1211:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1212:1: RULE_INT
            {
             before(grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl2417); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1227:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1231:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1232:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__02450);
            rule__Decimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__02453);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1239:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1243:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1244:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1244:1: ( ( rule__Decimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1245:1: ( rule__Decimal__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1246:1: ( rule__Decimal__Alternatives_0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=14 && LA13_0<=15)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1246:2: rule__Decimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl2480);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1256:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1260:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1261:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__12511);
            rule__Decimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__12514);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1268:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1272:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1273:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1273:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1274:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl2541); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1285:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1289:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1290:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
            {
            pushFollow(FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__22570);
            rule__Decimal__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__22573);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1297:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1301:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1302:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1302:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1303:1: '.'
            {
             before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            match(input,17,FOLLOW_17_in_rule__Decimal__Group__2__Impl2601); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1316:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1320:1: ( rule__Decimal__Group__3__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1321:2: rule__Decimal__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__32632);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1327:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1331:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1332:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1332:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1333:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl2659); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1352:1: rule__DotDecimal__Group__0 : rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 ;
    public final void rule__DotDecimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1356:1: ( rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1357:2: rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__02696);
            rule__DotDecimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__02699);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1364:1: rule__DotDecimal__Group__0__Impl : ( ( rule__DotDecimal__Alternatives_0 )? ) ;
    public final void rule__DotDecimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1368:1: ( ( ( rule__DotDecimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1369:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1369:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1370:1: ( rule__DotDecimal__Alternatives_0 )?
            {
             before(grammarAccess.getDotDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1371:1: ( rule__DotDecimal__Alternatives_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=14 && LA14_0<=15)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1371:2: rule__DotDecimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl2726);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1381:1: rule__DotDecimal__Group__1 : rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 ;
    public final void rule__DotDecimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1385:1: ( rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1386:2: rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__12757);
            rule__DotDecimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__12760);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1393:1: rule__DotDecimal__Group__1__Impl : ( '.' ) ;
    public final void rule__DotDecimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1397:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1398:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1398:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1399:1: '.'
            {
             before(grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
            match(input,17,FOLLOW_17_in_rule__DotDecimal__Group__1__Impl2788); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1412:1: rule__DotDecimal__Group__2 : rule__DotDecimal__Group__2__Impl ;
    public final void rule__DotDecimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1416:1: ( rule__DotDecimal__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1417:2: rule__DotDecimal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__22819);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1423:1: rule__DotDecimal__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DotDecimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1427:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1428:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1428:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1429:1: RULE_INT
            {
             before(grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl2846); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1446:1: rule__DecimalDot__Group__0 : rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 ;
    public final void rule__DecimalDot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1450:1: ( rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1451:2: rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__02881);
            rule__DecimalDot__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__02884);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1458:1: rule__DecimalDot__Group__0__Impl : ( ( rule__DecimalDot__Alternatives_0 )? ) ;
    public final void rule__DecimalDot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1462:1: ( ( ( rule__DecimalDot__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1463:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1463:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1464:1: ( rule__DecimalDot__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalDotAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1465:1: ( rule__DecimalDot__Alternatives_0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=14 && LA15_0<=15)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1465:2: rule__DecimalDot__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl2911);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1475:1: rule__DecimalDot__Group__1 : rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 ;
    public final void rule__DecimalDot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1479:1: ( rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1480:2: rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__12942);
            rule__DecimalDot__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__12945);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1487:1: rule__DecimalDot__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalDot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1491:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1492:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1492:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1493:1: RULE_INT
            {
             before(grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl2972); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1504:1: rule__DecimalDot__Group__2 : rule__DecimalDot__Group__2__Impl ;
    public final void rule__DecimalDot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1508:1: ( rule__DecimalDot__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1509:2: rule__DecimalDot__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__23001);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1515:1: rule__DecimalDot__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalDot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1519:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1520:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1520:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1521:1: '.'
            {
             before(grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 
            match(input,17,FOLLOW_17_in_rule__DecimalDot__Group__2__Impl3029); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1540:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1544:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1545:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__03066);
            rule__DecimalExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__03069);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1552:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1556:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1557:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1557:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1558:1: ( rule__DecimalExp__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1559:1: ( rule__DecimalExp__Alternatives_0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=14 && LA16_0<=15)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1559:2: rule__DecimalExp__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl3096);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1569:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1573:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1574:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__13127);
            rule__DecimalExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__13130);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1581:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1585:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1586:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1586:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1587:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl3157); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1598:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1602:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1603:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__23186);
            rule__DecimalExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__23189);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1610:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1614:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1615:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1615:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1616:1: '.'
            {
             before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            match(input,17,FOLLOW_17_in_rule__DecimalExp__Group__2__Impl3217); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1629:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1633:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1634:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__33248);
            rule__DecimalExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__33251);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1641:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1645:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1646:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1646:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1647:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl3278); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1658:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1662:1: ( rule__DecimalExp__Group__4__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1663:2: rule__DecimalExp__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__43307);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1669:1: rule__DecimalExp__Group__4__Impl : ( RULE_EXP ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1673:1: ( ( RULE_EXP ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1674:1: ( RULE_EXP )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1674:1: ( RULE_EXP )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1675:1: RULE_EXP
            {
             before(grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 
            match(input,RULE_EXP,FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl3334); 
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


    // $ANTLR start "rule__LiteralArray__LiteralsAssignment_0"
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1697:1: rule__LiteralArray__LiteralsAssignment_0 : ( ruleLiteral ) ;
    public final void rule__LiteralArray__LiteralsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1701:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1702:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1702:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1703:1: ruleLiteral
            {
             before(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_03378);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1712:1: rule__LiteralArray__LiteralsAssignment_1_1 : ( ruleLiteral ) ;
    public final void rule__LiteralArray__LiteralsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1716:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1717:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1717:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1718:1: ruleLiteral
            {
             before(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_1_13409);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1727:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1731:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1732:1: ( ( 'true' ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1732:1: ( ( 'true' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1733:1: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1734:1: ( 'true' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1735:1: 'true'
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            match(input,18,FOLLOW_18_in_rule__BooleanLiteral__IsTrueAssignment_1_13445); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1750:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1754:1: ( ( ruleReal ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1755:1: ( ruleReal )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1755:1: ( ruleReal )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1756:1: ruleReal
            {
             before(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_13484);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1765:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1769:1: ( ( ruleInteger ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1770:1: ( ruleInteger )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1770:1: ( ruleInteger )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1771:1: ruleInteger
            {
             before(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_13515);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1780:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1784:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1785:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1785:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1786:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_13546); 
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


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\12\uffff";
    static final String DFA6_eofS =
        "\5\uffff\1\7\1\11\3\uffff";
    static final String DFA6_minS =
        "\3\5\1\21\1\uffff\1\5\1\6\3\uffff";
    static final String DFA6_maxS =
        "\4\21\1\uffff\2\20\3\uffff";
    static final String DFA6_acceptS =
        "\4\uffff\1\2\2\uffff\1\3\1\4\1\1";
    static final String DFA6_specialS =
        "\12\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\3\10\uffff\1\1\1\2\1\uffff\1\4",
            "\1\3\13\uffff\1\4",
            "\1\3\13\uffff\1\4",
            "\1\5",
            "",
            "\1\6\12\uffff\1\7",
            "\1\10\11\uffff\1\11",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "650:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleLiteralArray_in_entryRuleLiteralArray61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralArray68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__0_in_ruleLiteralArray94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integer__Alternatives_in_ruleInteger514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Real__Alternatives_in_ruleReal711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal743 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0_in_ruleDecimal780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal812 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot881 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp950 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__BooleanLiteral__Alternatives_11090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_11109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__SignedInteger__Alternatives_01241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__SignedInteger__Alternatives_01261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_rule__Real__Alternatives1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Decimal__Alternatives_01379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Decimal__Alternatives_01399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__DotDecimal__Alternatives_01434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DotDecimal__Alternatives_01454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__DecimalDot__Alternatives_01489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalDot__Alternatives_01509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__DecimalExp__Alternatives_01544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalExp__Alternatives_01564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__0__Impl_in_rule__LiteralArray__Group__01596 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__1_in_rule__LiteralArray__Group__01599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__LiteralsAssignment_0_in_rule__LiteralArray__Group__0__Impl1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group__1__Impl_in_rule__LiteralArray__Group__11656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__0_in_rule__LiteralArray__Group__1__Impl1683 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__0__Impl_in_rule__LiteralArray__Group_1__01718 = new BitSet(new long[]{0x000000000006E0B0L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__1_in_rule__LiteralArray__Group_1__01721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__LiteralArray__Group_1__0__Impl1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__Group_1__1__Impl_in_rule__LiteralArray__Group_1__11780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralArray__LiteralsAssignment_1_1_in_rule__LiteralArray__Group_1__1__Impl1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__01841 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__01844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__11902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__01963 = new BitSet(new long[]{0x000000000002C030L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__01966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__12024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__02085 = new BitSet(new long[]{0x000000000000C030L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__02088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__12146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__02207 = new BitSet(new long[]{0x000000000006E0B0L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__02210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__12268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl2295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__02329 = new BitSet(new long[]{0x000000000000C020L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__02332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__12390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__02450 = new BitSet(new long[]{0x000000000000C020L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__02453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl2480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__12511 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__12514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl2541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__22570 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__22573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Decimal__Group__2__Impl2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__32632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl2659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__02696 = new BitSet(new long[]{0x000000000002C000L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__02699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl2726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__12757 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__12760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DotDecimal__Group__1__Impl2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__22819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl2846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__02881 = new BitSet(new long[]{0x000000000000C020L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__02884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__12942 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__12945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl2972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__23001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DecimalDot__Group__2__Impl3029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__03066 = new BitSet(new long[]{0x000000000002C030L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__03069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl3096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__13127 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__13130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__23186 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__23189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DecimalExp__Group__2__Impl3217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__33248 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__33251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl3278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__43307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl3334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_03378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__LiteralArray__LiteralsAssignment_1_13409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__BooleanLiteral__IsTrueAssignment_1_13445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_13484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_13515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_13546 = new BitSet(new long[]{0x0000000000000002L});

}