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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_HEX", "RULE_INT", "RULE_EXP", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'mandatory'", "'false'", "'+'", "'-'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'", "'@'", "'('", "')'", "','", "'='", "'attribute'", "':'", "'{'", "'}'", "'['", "']'", "'.'", "'optional'", "'true'"
    };
    public static final int RULE_EXP=7;
    public static final int RULE_ID=4;
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
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=11;

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




    // $ANTLR start "entryRuleAnnotation"
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:60:1: entryRuleAnnotation : ruleAnnotation EOF ;
    public final void entryRuleAnnotation() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:61:1: ( ruleAnnotation EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:62:1: ruleAnnotation EOF
            {
             before(grammarAccess.getAnnotationRule()); 
            pushFollow(FOLLOW_ruleAnnotation_in_entryRuleAnnotation61);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getAnnotationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotation68); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:69:1: ruleAnnotation : ( ( rule__Annotation__Group__0 ) ) ;
    public final void ruleAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:73:2: ( ( ( rule__Annotation__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:74:1: ( ( rule__Annotation__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:74:1: ( ( rule__Annotation__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:75:1: ( rule__Annotation__Group__0 )
            {
             before(grammarAccess.getAnnotationAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:76:1: ( rule__Annotation__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:76:2: rule__Annotation__Group__0
            {
            pushFollow(FOLLOW_rule__Annotation__Group__0_in_ruleAnnotation94);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:88:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:89:1: ( ruleKeyValue EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:90:1: ruleKeyValue EOF
            {
             before(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_ruleKeyValue_in_entryRuleKeyValue121);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getKeyValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValue128); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:97:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:101:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:102:1: ( ( rule__KeyValue__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:102:1: ( ( rule__KeyValue__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:103:1: ( rule__KeyValue__Group__0 )
            {
             before(grammarAccess.getKeyValueAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:104:1: ( rule__KeyValue__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:104:2: rule__KeyValue__Group__0
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__0_in_ruleKeyValue154);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:118:1: entryRuleAnnotationTargetType : ruleAnnotationTargetType EOF ;
    public final void entryRuleAnnotationTargetType() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:119:1: ( ruleAnnotationTargetType EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:120:1: ruleAnnotationTargetType EOF
            {
             before(grammarAccess.getAnnotationTargetTypeRule()); 
            pushFollow(FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType183);
            ruleAnnotationTargetType();

            state._fsp--;

             after(grammarAccess.getAnnotationTargetTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationTargetType190); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:127:1: ruleAnnotationTargetType : ( RULE_ID ) ;
    public final void ruleAnnotationTargetType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:131:2: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:132:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:132:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:133:1: RULE_ID
            {
             before(grammarAccess.getAnnotationTargetTypeAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotationTargetType216); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:146:1: entryRuleAnnotationAttribute : ruleAnnotationAttribute EOF ;
    public final void entryRuleAnnotationAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:147:1: ( ruleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:148:1: ruleAnnotationAttribute EOF
            {
             before(grammarAccess.getAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute242);
            ruleAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationAttribute249); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:155:1: ruleAnnotationAttribute : ( ( rule__AnnotationAttribute__Alternatives ) ) ;
    public final void ruleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:159:2: ( ( ( rule__AnnotationAttribute__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:160:1: ( ( rule__AnnotationAttribute__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:160:1: ( ( rule__AnnotationAttribute__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:161:1: ( rule__AnnotationAttribute__Alternatives )
            {
             before(grammarAccess.getAnnotationAttributeAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:162:1: ( rule__AnnotationAttribute__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:162:2: rule__AnnotationAttribute__Alternatives
            {
            pushFollow(FOLLOW_rule__AnnotationAttribute__Alternatives_in_ruleAnnotationAttribute275);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:174:1: entryRuleSimpleAnnotationAttribute : ruleSimpleAnnotationAttribute EOF ;
    public final void entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:175:1: ( ruleSimpleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:176:1: ruleSimpleAnnotationAttribute EOF
            {
             before(grammarAccess.getSimpleAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute302);
            ruleSimpleAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getSimpleAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute309); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:183:1: ruleSimpleAnnotationAttribute : ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) ;
    public final void ruleSimpleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:187:2: ( ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:188:1: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:188:1: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:189:1: ( rule__SimpleAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:190:1: ( rule__SimpleAnnotationAttribute__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:190:2: rule__SimpleAnnotationAttribute__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__0_in_ruleSimpleAnnotationAttribute335);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:202:1: entryRuleEnumAnnotationAttribute : ruleEnumAnnotationAttribute EOF ;
    public final void entryRuleEnumAnnotationAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:203:1: ( ruleEnumAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:204:1: ruleEnumAnnotationAttribute EOF
            {
             before(grammarAccess.getEnumAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute362);
            ruleEnumAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getEnumAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute369); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:211:1: ruleEnumAnnotationAttribute : ( ( rule__EnumAnnotationAttribute__Group__0 ) ) ;
    public final void ruleEnumAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:215:2: ( ( ( rule__EnumAnnotationAttribute__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:216:1: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:216:1: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:217:1: ( rule__EnumAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:218:1: ( rule__EnumAnnotationAttribute__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:218:2: rule__EnumAnnotationAttribute__Group__0
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__0_in_ruleEnumAnnotationAttribute395);
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


    // $ANTLR start "entryRuleDocumentation"
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:230:1: entryRuleDocumentation : ruleDocumentation EOF ;
    public final void entryRuleDocumentation() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:231:1: ( ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:232:1: ruleDocumentation EOF
            {
             before(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation422);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getDocumentationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation429); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:239:1: ruleDocumentation : ( ( rule__Documentation__Group__0 ) ) ;
    public final void ruleDocumentation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:243:2: ( ( ( rule__Documentation__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:244:1: ( ( rule__Documentation__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:244:1: ( ( rule__Documentation__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:245:1: ( rule__Documentation__Group__0 )
            {
             before(grammarAccess.getDocumentationAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:246:1: ( rule__Documentation__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:246:2: rule__Documentation__Group__0
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0_in_ruleDocumentation455);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:260:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:261:1: ( ruleLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:262:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral484);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral491); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:269:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:273:2: ( ( ( rule__Literal__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:274:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:274:1: ( ( rule__Literal__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:275:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:276:1: ( rule__Literal__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:276:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral517);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:288:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:289:1: ( ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:290:1: ruleBooleanLiteral EOF
            {
             before(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral544);
            ruleBooleanLiteral();

            state._fsp--;

             after(grammarAccess.getBooleanLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral551); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:297:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:301:2: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:302:1: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:302:1: ( ( rule__BooleanLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:303:1: ( rule__BooleanLiteral__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:304:1: ( rule__BooleanLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:304:2: rule__BooleanLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral577);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:316:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:317:1: ( ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:318:1: ruleNumberLiteral EOF
            {
             before(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral604);
            ruleNumberLiteral();

            state._fsp--;

             after(grammarAccess.getNumberLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral611); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:325:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Alternatives ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:329:2: ( ( ( rule__NumberLiteral__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:330:1: ( ( rule__NumberLiteral__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:330:1: ( ( rule__NumberLiteral__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:331:1: ( rule__NumberLiteral__Alternatives )
            {
             before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:332:1: ( rule__NumberLiteral__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:332:2: rule__NumberLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral637);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:344:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:345:1: ( ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:346:1: ruleRealLiteral EOF
            {
             before(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral664);
            ruleRealLiteral();

            state._fsp--;

             after(grammarAccess.getRealLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral671); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:353:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:357:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:358:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:358:1: ( ( rule__RealLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:359:1: ( rule__RealLiteral__Group__0 )
            {
             before(grammarAccess.getRealLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:360:1: ( rule__RealLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:360:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral697);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:372:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:373:1: ( ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:374:1: ruleIntLiteral EOF
            {
             before(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral724);
            ruleIntLiteral();

            state._fsp--;

             after(grammarAccess.getIntLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral731); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:381:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:385:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:386:1: ( ( rule__IntLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:386:1: ( ( rule__IntLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:387:1: ( rule__IntLiteral__Group__0 )
            {
             before(grammarAccess.getIntLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:388:1: ( rule__IntLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:388:2: rule__IntLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral757);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:400:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:401:1: ( ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:402:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral784);
            ruleStringLiteral();

            state._fsp--;

             after(grammarAccess.getStringLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral791); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:409:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:413:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:414:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:414:1: ( ( rule__StringLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:415:1: ( rule__StringLiteral__Group__0 )
            {
             before(grammarAccess.getStringLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:416:1: ( rule__StringLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:416:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral817);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:428:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:429:1: ( ruleInteger EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:430:1: ruleInteger EOF
            {
             before(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger844);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger851); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:437:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:441:2: ( ( ( rule__Integer__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:442:1: ( ( rule__Integer__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:442:1: ( ( rule__Integer__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:443:1: ( rule__Integer__Alternatives )
            {
             before(grammarAccess.getIntegerAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:444:1: ( rule__Integer__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:444:2: rule__Integer__Alternatives
            {
            pushFollow(FOLLOW_rule__Integer__Alternatives_in_ruleInteger877);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:456:1: entryRuleSignedInteger : ruleSignedInteger EOF ;
    public final void entryRuleSignedInteger() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:460:1: ( ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:461:1: ruleSignedInteger EOF
            {
             before(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger909);
            ruleSignedInteger();

            state._fsp--;

             after(grammarAccess.getSignedIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger916); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:471:1: ruleSignedInteger : ( ( rule__SignedInteger__Group__0 ) ) ;
    public final void ruleSignedInteger() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:476:2: ( ( ( rule__SignedInteger__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:477:1: ( ( rule__SignedInteger__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:477:1: ( ( rule__SignedInteger__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:478:1: ( rule__SignedInteger__Group__0 )
            {
             before(grammarAccess.getSignedIntegerAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:479:1: ( rule__SignedInteger__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:479:2: rule__SignedInteger__Group__0
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger946);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:492:1: entryRuleHexadecimal : ruleHexadecimal EOF ;
    public final void entryRuleHexadecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:496:1: ( ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:497:1: ruleHexadecimal EOF
            {
             before(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal978);
            ruleHexadecimal();

            state._fsp--;

             after(grammarAccess.getHexadecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal985); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:507:1: ruleHexadecimal : ( RULE_HEX ) ;
    public final void ruleHexadecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:512:2: ( ( RULE_HEX ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:513:1: ( RULE_HEX )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:513:1: ( RULE_HEX )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:514:1: RULE_HEX
            {
             before(grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 
            match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal1015); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:528:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:529:1: ( ruleReal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:530:1: ruleReal EOF
            {
             before(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal1041);
            ruleReal();

            state._fsp--;

             after(grammarAccess.getRealRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal1048); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:537:1: ruleReal : ( ( rule__Real__Alternatives ) ) ;
    public final void ruleReal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:541:2: ( ( ( rule__Real__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:542:1: ( ( rule__Real__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:542:1: ( ( rule__Real__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:543:1: ( rule__Real__Alternatives )
            {
             before(grammarAccess.getRealAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:544:1: ( rule__Real__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:544:2: rule__Real__Alternatives
            {
            pushFollow(FOLLOW_rule__Real__Alternatives_in_ruleReal1074);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:556:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:560:1: ( ruleDecimal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:561:1: ruleDecimal EOF
            {
             before(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal1106);
            ruleDecimal();

            state._fsp--;

             after(grammarAccess.getDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal1113); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:571:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:576:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:577:1: ( ( rule__Decimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:577:1: ( ( rule__Decimal__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:578:1: ( rule__Decimal__Group__0 )
            {
             before(grammarAccess.getDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:579:1: ( rule__Decimal__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:579:2: rule__Decimal__Group__0
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1143);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:592:1: entryRuleDotDecimal : ruleDotDecimal EOF ;
    public final void entryRuleDotDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:596:1: ( ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:597:1: ruleDotDecimal EOF
            {
             before(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1175);
            ruleDotDecimal();

            state._fsp--;

             after(grammarAccess.getDotDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal1182); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:607:1: ruleDotDecimal : ( ( rule__DotDecimal__Group__0 ) ) ;
    public final void ruleDotDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:612:2: ( ( ( rule__DotDecimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:613:1: ( ( rule__DotDecimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:613:1: ( ( rule__DotDecimal__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:614:1: ( rule__DotDecimal__Group__0 )
            {
             before(grammarAccess.getDotDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:615:1: ( rule__DotDecimal__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:615:2: rule__DotDecimal__Group__0
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1212);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:628:1: entryRuleDecimalDot : ruleDecimalDot EOF ;
    public final void entryRuleDecimalDot() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:632:1: ( ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:633:1: ruleDecimalDot EOF
            {
             before(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1244);
            ruleDecimalDot();

            state._fsp--;

             after(grammarAccess.getDecimalDotRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot1251); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:643:1: ruleDecimalDot : ( ( rule__DecimalDot__Group__0 ) ) ;
    public final void ruleDecimalDot() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:648:2: ( ( ( rule__DecimalDot__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:649:1: ( ( rule__DecimalDot__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:649:1: ( ( rule__DecimalDot__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:650:1: ( rule__DecimalDot__Group__0 )
            {
             before(grammarAccess.getDecimalDotAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:651:1: ( rule__DecimalDot__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:651:2: rule__DecimalDot__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1281);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:664:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:668:1: ( ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:669:1: ruleDecimalExp EOF
            {
             before(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1313);
            ruleDecimalExp();

            state._fsp--;

             after(grammarAccess.getDecimalExpRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp1320); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:679:1: ruleDecimalExp : ( ( rule__DecimalExp__Group__0 ) ) ;
    public final void ruleDecimalExp() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:684:2: ( ( ( rule__DecimalExp__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:685:1: ( ( rule__DecimalExp__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:685:1: ( ( rule__DecimalExp__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:686:1: ( rule__DecimalExp__Group__0 )
            {
             before(grammarAccess.getDecimalExpAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:687:1: ( rule__DecimalExp__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:687:2: rule__DecimalExp__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1350);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:700:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:701:1: ( ruleFQN EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:702:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1377);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1384); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:709:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:713:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:714:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:714:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:715:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:716:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:716:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN1410);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:729:1: ruleLiteralType : ( ( rule__LiteralType__Alternatives ) ) ;
    public final void ruleLiteralType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:733:1: ( ( ( rule__LiteralType__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:734:1: ( ( rule__LiteralType__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:734:1: ( ( rule__LiteralType__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:735:1: ( rule__LiteralType__Alternatives )
            {
             before(grammarAccess.getLiteralTypeAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:736:1: ( rule__LiteralType__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:736:2: rule__LiteralType__Alternatives
            {
            pushFollow(FOLLOW_rule__LiteralType__Alternatives_in_ruleLiteralType1447);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:748:1: rule__AnnotationAttribute__Alternatives : ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) );
    public final void rule__AnnotationAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:752:1: ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==33) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==26) ) {
                    int LA1_3 = input.LA(3);

                    if ( (LA1_3==RULE_ID) ) {
                        int LA1_4 = input.LA(4);

                        if ( (LA1_4==27) ) {
                            int LA1_5 = input.LA(5);

                            if ( ((LA1_5>=17 && LA1_5<=20)) ) {
                                alt1=1;
                            }
                            else if ( (LA1_5==28) ) {
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

                if ( (LA1_2==26) ) {
                    int LA1_3 = input.LA(3);

                    if ( (LA1_3==RULE_ID) ) {
                        int LA1_4 = input.LA(4);

                        if ( (LA1_4==27) ) {
                            int LA1_5 = input.LA(5);

                            if ( ((LA1_5>=17 && LA1_5<=20)) ) {
                                alt1=1;
                            }
                            else if ( (LA1_5==28) ) {
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:753:1: ( ruleSimpleAnnotationAttribute )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:753:1: ( ruleSimpleAnnotationAttribute )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:754:1: ruleSimpleAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1483);
                    ruleSimpleAnnotationAttribute();

                    state._fsp--;

                     after(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:759:6: ( ruleEnumAnnotationAttribute )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:759:6: ( ruleEnumAnnotationAttribute )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:760:1: ruleEnumAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1500);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:770:1: rule__SimpleAnnotationAttribute__Alternatives_0 : ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__SimpleAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:774:1: ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==33) ) {
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:775:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:775:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:776:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:777:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:777:2: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__OptionalAssignment_0_0_in_rule__SimpleAnnotationAttribute__Alternatives_01532);
                    rule__SimpleAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:781:6: ( 'mandatory' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:781:6: ( 'mandatory' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:782:1: 'mandatory'
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__SimpleAnnotationAttribute__Alternatives_01551); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:794:1: rule__EnumAnnotationAttribute__Alternatives_0 : ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__EnumAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:798:1: ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==33) ) {
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:799:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:799:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:800:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:801:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:801:2: rule__EnumAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__EnumAnnotationAttribute__OptionalAssignment_0_0_in_rule__EnumAnnotationAttribute__Alternatives_01585);
                    rule__EnumAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:805:6: ( 'mandatory' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:805:6: ( 'mandatory' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:806:1: 'mandatory'
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__EnumAnnotationAttribute__Alternatives_01604); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:818:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:822:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 14:
            case 34:
                {
                alt4=1;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case 15:
            case 16:
            case 32:
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:823:1: ( ruleBooleanLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:823:1: ( ruleBooleanLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:824:1: ruleBooleanLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives1638);
                    ruleBooleanLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:829:6: ( ruleNumberLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:829:6: ( ruleNumberLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:830:1: ruleNumberLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives1655);
                    ruleNumberLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:835:6: ( ruleStringLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:835:6: ( ruleStringLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:836:1: ruleStringLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives1672);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:846:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:850:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            else if ( (LA5_0==34) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:851:1: ( 'false' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:851:1: ( 'false' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:852:1: 'false'
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    match(input,14,FOLLOW_14_in_rule__BooleanLiteral__Alternatives_11705); 
                     after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:859:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:859:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:860:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:861:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:861:2: rule__BooleanLiteral__IsTrueAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_11724);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:870:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:874:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
            int alt6=2;
            switch ( input.LA(1) ) {
            case 15:
                {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_INT) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==32) ) {
                        alt6=2;
                    }
                    else if ( (LA6_3==EOF||(LA6_3>=23 && LA6_3<=24)) ) {
                        alt6=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_1==32) ) {
                    alt6=2;
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

                    if ( (LA6_3==32) ) {
                        alt6=2;
                    }
                    else if ( (LA6_3==EOF||(LA6_3>=23 && LA6_3<=24)) ) {
                        alt6=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_2==32) ) {
                    alt6=2;
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

                if ( (LA6_3==32) ) {
                    alt6=2;
                }
                else if ( (LA6_3==EOF||(LA6_3>=23 && LA6_3<=24)) ) {
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
            case 32:
                {
                alt6=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:875:1: ( ruleIntLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:875:1: ( ruleIntLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:876:1: ruleIntLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives1757);
                    ruleIntLiteral();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:881:6: ( ruleRealLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:881:6: ( ruleRealLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:882:1: ruleRealLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives1774);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:892:1: rule__Integer__Alternatives : ( ( ruleSignedInteger ) | ( ruleHexadecimal ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:896:1: ( ( ruleSignedInteger ) | ( ruleHexadecimal ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:897:1: ( ruleSignedInteger )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:897:1: ( ruleSignedInteger )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:898:1: ruleSignedInteger
                    {
                     before(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives1806);
                    ruleSignedInteger();

                    state._fsp--;

                     after(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:903:6: ( ruleHexadecimal )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:903:6: ( ruleHexadecimal )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:904:1: ruleHexadecimal
                    {
                     before(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives1823);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:914:1: rule__SignedInteger__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__SignedInteger__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:918:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:919:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:919:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:920:1: '+'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__SignedInteger__Alternatives_01856); 
                     after(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:927:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:927:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:928:1: '-'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__SignedInteger__Alternatives_01876); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:940:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:944:1: ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) )
            int alt9=4;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:945:1: ( ruleDecimal )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:945:1: ( ruleDecimal )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:946:1: ruleDecimal
                    {
                     before(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDecimal_in_rule__Real__Alternatives1910);
                    ruleDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:951:6: ( ruleDotDecimal )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:951:6: ( ruleDotDecimal )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:952:1: ruleDotDecimal
                    {
                     before(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives1927);
                    ruleDotDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:957:6: ( ruleDecimalDot )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:957:6: ( ruleDecimalDot )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:958:1: ruleDecimalDot
                    {
                     before(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives1944);
                    ruleDecimalDot();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:963:6: ( ruleDecimalExp )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:963:6: ( ruleDecimalExp )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:964:1: ruleDecimalExp
                    {
                     before(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives1961);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:974:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:978:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:979:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:979:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:980:1: '+'
                    {
                     before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__Decimal__Alternatives_01994); 
                     after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:987:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:987:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:988:1: '-'
                    {
                     before(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__Decimal__Alternatives_02014); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1000:1: rule__DotDecimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DotDecimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1004:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1005:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1005:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1006:1: '+'
                    {
                     before(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__DotDecimal__Alternatives_02049); 
                     after(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1013:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1013:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1014:1: '-'
                    {
                     before(grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__DotDecimal__Alternatives_02069); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1026:1: rule__DecimalDot__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalDot__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1030:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1031:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1031:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1032:1: '+'
                    {
                     before(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__DecimalDot__Alternatives_02104); 
                     after(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1039:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1039:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1040:1: '-'
                    {
                     before(grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__DecimalDot__Alternatives_02124); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1052:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1056:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1057:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1057:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1058:1: '+'
                    {
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__DecimalExp__Alternatives_02159); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1065:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1065:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1066:1: '-'
                    {
                     before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__DecimalExp__Alternatives_02179); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1078:1: rule__LiteralType__Alternatives : ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) );
    public final void rule__LiteralType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1082:1: ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt14=1;
                }
                break;
            case 18:
                {
                alt14=2;
                }
                break;
            case 19:
                {
                alt14=3;
                }
                break;
            case 20:
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1083:1: ( ( 'ptBoolean' ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1083:1: ( ( 'ptBoolean' ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1084:1: ( 'ptBoolean' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1085:1: ( 'ptBoolean' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1085:3: 'ptBoolean'
                    {
                    match(input,17,FOLLOW_17_in_rule__LiteralType__Alternatives2214); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1090:6: ( ( 'ptInteger' ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1090:6: ( ( 'ptInteger' ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1091:1: ( 'ptInteger' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1092:1: ( 'ptInteger' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1092:3: 'ptInteger'
                    {
                    match(input,18,FOLLOW_18_in_rule__LiteralType__Alternatives2235); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1097:6: ( ( 'ptReal' ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1097:6: ( ( 'ptReal' ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1098:1: ( 'ptReal' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1099:1: ( 'ptReal' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1099:3: 'ptReal'
                    {
                    match(input,19,FOLLOW_19_in_rule__LiteralType__Alternatives2256); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1104:6: ( ( 'ptCharacter' ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1104:6: ( ( 'ptCharacter' ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1105:1: ( 'ptCharacter' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1106:1: ( 'ptCharacter' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1106:3: 'ptCharacter'
                    {
                    match(input,20,FOLLOW_20_in_rule__LiteralType__Alternatives2277); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1118:1: rule__Annotation__Group__0 : rule__Annotation__Group__0__Impl rule__Annotation__Group__1 ;
    public final void rule__Annotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1122:1: ( rule__Annotation__Group__0__Impl rule__Annotation__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1123:2: rule__Annotation__Group__0__Impl rule__Annotation__Group__1
            {
            pushFollow(FOLLOW_rule__Annotation__Group__0__Impl_in_rule__Annotation__Group__02310);
            rule__Annotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group__1_in_rule__Annotation__Group__02313);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1130:1: rule__Annotation__Group__0__Impl : ( '@' ) ;
    public final void rule__Annotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1134:1: ( ( '@' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1135:1: ( '@' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1135:1: ( '@' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1136:1: '@'
            {
             before(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__Annotation__Group__0__Impl2341); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1149:1: rule__Annotation__Group__1 : rule__Annotation__Group__1__Impl rule__Annotation__Group__2 ;
    public final void rule__Annotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1153:1: ( rule__Annotation__Group__1__Impl rule__Annotation__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1154:2: rule__Annotation__Group__1__Impl rule__Annotation__Group__2
            {
            pushFollow(FOLLOW_rule__Annotation__Group__1__Impl_in_rule__Annotation__Group__12372);
            rule__Annotation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group__2_in_rule__Annotation__Group__12375);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1161:1: rule__Annotation__Group__1__Impl : ( ( rule__Annotation__TypeAssignment_1 ) ) ;
    public final void rule__Annotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1165:1: ( ( ( rule__Annotation__TypeAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1166:1: ( ( rule__Annotation__TypeAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1166:1: ( ( rule__Annotation__TypeAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1167:1: ( rule__Annotation__TypeAssignment_1 )
            {
             before(grammarAccess.getAnnotationAccess().getTypeAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1168:1: ( rule__Annotation__TypeAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1168:2: rule__Annotation__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__Annotation__TypeAssignment_1_in_rule__Annotation__Group__1__Impl2402);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1178:1: rule__Annotation__Group__2 : rule__Annotation__Group__2__Impl ;
    public final void rule__Annotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1182:1: ( rule__Annotation__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1183:2: rule__Annotation__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Annotation__Group__2__Impl_in_rule__Annotation__Group__22432);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1189:1: rule__Annotation__Group__2__Impl : ( ( rule__Annotation__Group_2__0 )? ) ;
    public final void rule__Annotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1193:1: ( ( ( rule__Annotation__Group_2__0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1194:1: ( ( rule__Annotation__Group_2__0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1194:1: ( ( rule__Annotation__Group_2__0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1195:1: ( rule__Annotation__Group_2__0 )?
            {
             before(grammarAccess.getAnnotationAccess().getGroup_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1196:1: ( rule__Annotation__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1196:2: rule__Annotation__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Annotation__Group_2__0_in_rule__Annotation__Group__2__Impl2459);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1212:1: rule__Annotation__Group_2__0 : rule__Annotation__Group_2__0__Impl rule__Annotation__Group_2__1 ;
    public final void rule__Annotation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1216:1: ( rule__Annotation__Group_2__0__Impl rule__Annotation__Group_2__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1217:2: rule__Annotation__Group_2__0__Impl rule__Annotation__Group_2__1
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2__0__Impl_in_rule__Annotation__Group_2__02496);
            rule__Annotation__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group_2__1_in_rule__Annotation__Group_2__02499);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1224:1: rule__Annotation__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Annotation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1228:1: ( ( '(' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1229:1: ( '(' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1229:1: ( '(' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1230:1: '('
            {
             before(grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,22,FOLLOW_22_in_rule__Annotation__Group_2__0__Impl2527); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1243:1: rule__Annotation__Group_2__1 : rule__Annotation__Group_2__1__Impl rule__Annotation__Group_2__2 ;
    public final void rule__Annotation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1247:1: ( rule__Annotation__Group_2__1__Impl rule__Annotation__Group_2__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1248:2: rule__Annotation__Group_2__1__Impl rule__Annotation__Group_2__2
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2__1__Impl_in_rule__Annotation__Group_2__12558);
            rule__Annotation__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group_2__2_in_rule__Annotation__Group_2__12561);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1255:1: rule__Annotation__Group_2__1__Impl : ( ( rule__Annotation__AttributesAssignment_2_1 ) ) ;
    public final void rule__Annotation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1259:1: ( ( ( rule__Annotation__AttributesAssignment_2_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1260:1: ( ( rule__Annotation__AttributesAssignment_2_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1260:1: ( ( rule__Annotation__AttributesAssignment_2_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1261:1: ( rule__Annotation__AttributesAssignment_2_1 )
            {
             before(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1262:1: ( rule__Annotation__AttributesAssignment_2_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1262:2: rule__Annotation__AttributesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Annotation__AttributesAssignment_2_1_in_rule__Annotation__Group_2__1__Impl2588);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1272:1: rule__Annotation__Group_2__2 : rule__Annotation__Group_2__2__Impl rule__Annotation__Group_2__3 ;
    public final void rule__Annotation__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1276:1: ( rule__Annotation__Group_2__2__Impl rule__Annotation__Group_2__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1277:2: rule__Annotation__Group_2__2__Impl rule__Annotation__Group_2__3
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2__2__Impl_in_rule__Annotation__Group_2__22618);
            rule__Annotation__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group_2__3_in_rule__Annotation__Group_2__22621);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1284:1: rule__Annotation__Group_2__2__Impl : ( ( rule__Annotation__Group_2_2__0 )* ) ;
    public final void rule__Annotation__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1288:1: ( ( ( rule__Annotation__Group_2_2__0 )* ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1289:1: ( ( rule__Annotation__Group_2_2__0 )* )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1289:1: ( ( rule__Annotation__Group_2_2__0 )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1290:1: ( rule__Annotation__Group_2_2__0 )*
            {
             before(grammarAccess.getAnnotationAccess().getGroup_2_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1291:1: ( rule__Annotation__Group_2_2__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==24) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1291:2: rule__Annotation__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Annotation__Group_2_2__0_in_rule__Annotation__Group_2__2__Impl2648);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1301:1: rule__Annotation__Group_2__3 : rule__Annotation__Group_2__3__Impl ;
    public final void rule__Annotation__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1305:1: ( rule__Annotation__Group_2__3__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1306:2: rule__Annotation__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2__3__Impl_in_rule__Annotation__Group_2__32679);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1312:1: rule__Annotation__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Annotation__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1316:1: ( ( ')' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1317:1: ( ')' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1317:1: ( ')' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1318:1: ')'
            {
             before(grammarAccess.getAnnotationAccess().getRightParenthesisKeyword_2_3()); 
            match(input,23,FOLLOW_23_in_rule__Annotation__Group_2__3__Impl2707); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1339:1: rule__Annotation__Group_2_2__0 : rule__Annotation__Group_2_2__0__Impl rule__Annotation__Group_2_2__1 ;
    public final void rule__Annotation__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1343:1: ( rule__Annotation__Group_2_2__0__Impl rule__Annotation__Group_2_2__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1344:2: rule__Annotation__Group_2_2__0__Impl rule__Annotation__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2_2__0__Impl_in_rule__Annotation__Group_2_2__02746);
            rule__Annotation__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group_2_2__1_in_rule__Annotation__Group_2_2__02749);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1351:1: rule__Annotation__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Annotation__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1355:1: ( ( ',' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1356:1: ( ',' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1356:1: ( ',' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1357:1: ','
            {
             before(grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0()); 
            match(input,24,FOLLOW_24_in_rule__Annotation__Group_2_2__0__Impl2777); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1370:1: rule__Annotation__Group_2_2__1 : rule__Annotation__Group_2_2__1__Impl ;
    public final void rule__Annotation__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1374:1: ( rule__Annotation__Group_2_2__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1375:2: rule__Annotation__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2_2__1__Impl_in_rule__Annotation__Group_2_2__12808);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1381:1: rule__Annotation__Group_2_2__1__Impl : ( ( rule__Annotation__AttributesAssignment_2_2_1 ) ) ;
    public final void rule__Annotation__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1385:1: ( ( ( rule__Annotation__AttributesAssignment_2_2_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1386:1: ( ( rule__Annotation__AttributesAssignment_2_2_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1386:1: ( ( rule__Annotation__AttributesAssignment_2_2_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1387:1: ( rule__Annotation__AttributesAssignment_2_2_1 )
            {
             before(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_2_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1388:1: ( rule__Annotation__AttributesAssignment_2_2_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1388:2: rule__Annotation__AttributesAssignment_2_2_1
            {
            pushFollow(FOLLOW_rule__Annotation__AttributesAssignment_2_2_1_in_rule__Annotation__Group_2_2__1__Impl2835);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1402:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1406:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1407:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__0__Impl_in_rule__KeyValue__Group__02869);
            rule__KeyValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeyValue__Group__1_in_rule__KeyValue__Group__02872);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1414:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1418:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1419:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1419:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1420:1: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1421:1: ( rule__KeyValue__KeyAssignment_0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1421:2: rule__KeyValue__KeyAssignment_0
            {
            pushFollow(FOLLOW_rule__KeyValue__KeyAssignment_0_in_rule__KeyValue__Group__0__Impl2899);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1431:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1435:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1436:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__1__Impl_in_rule__KeyValue__Group__12929);
            rule__KeyValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeyValue__Group__2_in_rule__KeyValue__Group__12932);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1443:1: rule__KeyValue__Group__1__Impl : ( '=' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1447:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1448:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1448:1: ( '=' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1449:1: '='
            {
             before(grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1()); 
            match(input,25,FOLLOW_25_in_rule__KeyValue__Group__1__Impl2960); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1462:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1466:1: ( rule__KeyValue__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1467:2: rule__KeyValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__2__Impl_in_rule__KeyValue__Group__22991);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1473:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1477:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1478:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1478:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1479:1: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1480:1: ( rule__KeyValue__ValueAssignment_2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1480:2: rule__KeyValue__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__KeyValue__ValueAssignment_2_in_rule__KeyValue__Group__2__Impl3018);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1499:1: rule__SimpleAnnotationAttribute__Group__0 : rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 ;
    public final void rule__SimpleAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1503:1: ( rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1504:2: rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__0__Impl_in_rule__SimpleAnnotationAttribute__Group__03057);
            rule__SimpleAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__1_in_rule__SimpleAnnotationAttribute__Group__03060);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1511:1: rule__SimpleAnnotationAttribute__Group__0__Impl : ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1515:1: ( ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1516:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1516:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1517:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1518:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1518:2: rule__SimpleAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Alternatives_0_in_rule__SimpleAnnotationAttribute__Group__0__Impl3087);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1528:1: rule__SimpleAnnotationAttribute__Group__1 : rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 ;
    public final void rule__SimpleAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1532:1: ( rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1533:2: rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__1__Impl_in_rule__SimpleAnnotationAttribute__Group__13117);
            rule__SimpleAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__2_in_rule__SimpleAnnotationAttribute__Group__13120);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1540:1: rule__SimpleAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1544:1: ( ( 'attribute' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1545:1: ( 'attribute' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1545:1: ( 'attribute' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1546:1: 'attribute'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__SimpleAnnotationAttribute__Group__1__Impl3148); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1559:1: rule__SimpleAnnotationAttribute__Group__2 : rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 ;
    public final void rule__SimpleAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1563:1: ( rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1564:2: rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__2__Impl_in_rule__SimpleAnnotationAttribute__Group__23179);
            rule__SimpleAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__3_in_rule__SimpleAnnotationAttribute__Group__23182);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1571:1: rule__SimpleAnnotationAttribute__Group__2__Impl : ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1575:1: ( ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1576:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1576:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1577:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1578:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1578:2: rule__SimpleAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__NameAssignment_2_in_rule__SimpleAnnotationAttribute__Group__2__Impl3209);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1588:1: rule__SimpleAnnotationAttribute__Group__3 : rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 ;
    public final void rule__SimpleAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1592:1: ( rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1593:2: rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__3__Impl_in_rule__SimpleAnnotationAttribute__Group__33239);
            rule__SimpleAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__4_in_rule__SimpleAnnotationAttribute__Group__33242);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1600:1: rule__SimpleAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1604:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1605:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1605:1: ( ':' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1606:1: ':'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,27,FOLLOW_27_in_rule__SimpleAnnotationAttribute__Group__3__Impl3270); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1619:1: rule__SimpleAnnotationAttribute__Group__4 : rule__SimpleAnnotationAttribute__Group__4__Impl ;
    public final void rule__SimpleAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1623:1: ( rule__SimpleAnnotationAttribute__Group__4__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1624:2: rule__SimpleAnnotationAttribute__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__4__Impl_in_rule__SimpleAnnotationAttribute__Group__43301);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1630:1: rule__SimpleAnnotationAttribute__Group__4__Impl : ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1634:1: ( ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1635:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1635:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1636:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1637:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1637:2: rule__SimpleAnnotationAttribute__TypeAssignment_4
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__TypeAssignment_4_in_rule__SimpleAnnotationAttribute__Group__4__Impl3328);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1657:1: rule__EnumAnnotationAttribute__Group__0 : rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 ;
    public final void rule__EnumAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1661:1: ( rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1662:2: rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__0__Impl_in_rule__EnumAnnotationAttribute__Group__03368);
            rule__EnumAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__1_in_rule__EnumAnnotationAttribute__Group__03371);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1669:1: rule__EnumAnnotationAttribute__Group__0__Impl : ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1673:1: ( ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1674:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1674:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1675:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1676:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1676:2: rule__EnumAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Alternatives_0_in_rule__EnumAnnotationAttribute__Group__0__Impl3398);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1686:1: rule__EnumAnnotationAttribute__Group__1 : rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 ;
    public final void rule__EnumAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1690:1: ( rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1691:2: rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__1__Impl_in_rule__EnumAnnotationAttribute__Group__13428);
            rule__EnumAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__2_in_rule__EnumAnnotationAttribute__Group__13431);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1698:1: rule__EnumAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__EnumAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1702:1: ( ( 'attribute' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1703:1: ( 'attribute' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1703:1: ( 'attribute' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1704:1: 'attribute'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__EnumAnnotationAttribute__Group__1__Impl3459); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1717:1: rule__EnumAnnotationAttribute__Group__2 : rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 ;
    public final void rule__EnumAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1721:1: ( rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1722:2: rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__2__Impl_in_rule__EnumAnnotationAttribute__Group__23490);
            rule__EnumAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__3_in_rule__EnumAnnotationAttribute__Group__23493);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1729:1: rule__EnumAnnotationAttribute__Group__2__Impl : ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1733:1: ( ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1734:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1734:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1735:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1736:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1736:2: rule__EnumAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__NameAssignment_2_in_rule__EnumAnnotationAttribute__Group__2__Impl3520);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1746:1: rule__EnumAnnotationAttribute__Group__3 : rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 ;
    public final void rule__EnumAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1750:1: ( rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1751:2: rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__3__Impl_in_rule__EnumAnnotationAttribute__Group__33550);
            rule__EnumAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__4_in_rule__EnumAnnotationAttribute__Group__33553);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1758:1: rule__EnumAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1762:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1763:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1763:1: ( ':' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1764:1: ':'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,27,FOLLOW_27_in_rule__EnumAnnotationAttribute__Group__3__Impl3581); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1777:1: rule__EnumAnnotationAttribute__Group__4 : rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 ;
    public final void rule__EnumAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1781:1: ( rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1782:2: rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__4__Impl_in_rule__EnumAnnotationAttribute__Group__43612);
            rule__EnumAnnotationAttribute__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__5_in_rule__EnumAnnotationAttribute__Group__43615);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1789:1: rule__EnumAnnotationAttribute__Group__4__Impl : ( '{' ) ;
    public final void rule__EnumAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1793:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1794:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1794:1: ( '{' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1795:1: '{'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__EnumAnnotationAttribute__Group__4__Impl3643); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1808:1: rule__EnumAnnotationAttribute__Group__5 : rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 ;
    public final void rule__EnumAnnotationAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1812:1: ( rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1813:2: rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__5__Impl_in_rule__EnumAnnotationAttribute__Group__53674);
            rule__EnumAnnotationAttribute__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__6_in_rule__EnumAnnotationAttribute__Group__53677);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1820:1: rule__EnumAnnotationAttribute__Group__5__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1824:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1825:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1825:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1826:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1827:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1827:2: rule__EnumAnnotationAttribute__ValuesAssignment_5
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_5_in_rule__EnumAnnotationAttribute__Group__5__Impl3704);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1837:1: rule__EnumAnnotationAttribute__Group__6 : rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 ;
    public final void rule__EnumAnnotationAttribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1841:1: ( rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1842:2: rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__6__Impl_in_rule__EnumAnnotationAttribute__Group__63734);
            rule__EnumAnnotationAttribute__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__7_in_rule__EnumAnnotationAttribute__Group__63737);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1849:1: rule__EnumAnnotationAttribute__Group__6__Impl : ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) ;
    public final void rule__EnumAnnotationAttribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1853:1: ( ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1854:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1854:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1855:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1856:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==24) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1856:2: rule__EnumAnnotationAttribute__Group_6__0
            	    {
            	    pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__0_in_rule__EnumAnnotationAttribute__Group__6__Impl3764);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1866:1: rule__EnumAnnotationAttribute__Group__7 : rule__EnumAnnotationAttribute__Group__7__Impl ;
    public final void rule__EnumAnnotationAttribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1870:1: ( rule__EnumAnnotationAttribute__Group__7__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1871:2: rule__EnumAnnotationAttribute__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__7__Impl_in_rule__EnumAnnotationAttribute__Group__73795);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1877:1: rule__EnumAnnotationAttribute__Group__7__Impl : ( '}' ) ;
    public final void rule__EnumAnnotationAttribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1881:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1882:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1882:1: ( '}' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1883:1: '}'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7()); 
            match(input,29,FOLLOW_29_in_rule__EnumAnnotationAttribute__Group__7__Impl3823); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1912:1: rule__EnumAnnotationAttribute__Group_6__0 : rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 ;
    public final void rule__EnumAnnotationAttribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1916:1: ( rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1917:2: rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__0__Impl_in_rule__EnumAnnotationAttribute__Group_6__03870);
            rule__EnumAnnotationAttribute__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__1_in_rule__EnumAnnotationAttribute__Group_6__03873);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1924:1: rule__EnumAnnotationAttribute__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1928:1: ( ( ',' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1929:1: ( ',' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1929:1: ( ',' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1930:1: ','
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0()); 
            match(input,24,FOLLOW_24_in_rule__EnumAnnotationAttribute__Group_6__0__Impl3901); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1943:1: rule__EnumAnnotationAttribute__Group_6__1 : rule__EnumAnnotationAttribute__Group_6__1__Impl ;
    public final void rule__EnumAnnotationAttribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1947:1: ( rule__EnumAnnotationAttribute__Group_6__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1948:2: rule__EnumAnnotationAttribute__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__1__Impl_in_rule__EnumAnnotationAttribute__Group_6__13932);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1954:1: rule__EnumAnnotationAttribute__Group_6__1__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1958:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1959:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1959:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1960:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1961:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1961:2: rule__EnumAnnotationAttribute__ValuesAssignment_6_1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_6_1_in_rule__EnumAnnotationAttribute__Group_6__1__Impl3959);
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


    // $ANTLR start "rule__Documentation__Group__0"
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1975:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1979:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1980:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__03993);
            rule__Documentation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__03996);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1987:1: rule__Documentation__Group__0__Impl : ( () ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1991:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1992:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1992:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1993:1: ()
            {
             before(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1994:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1996:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2006:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2010:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2011:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
            {
            pushFollow(FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__14054);
            rule__Documentation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__14057);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2018:1: rule__Documentation__Group__1__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2022:1: ( ( '[' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2023:1: ( '[' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2023:1: ( '[' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2024:1: '['
            {
             before(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__Documentation__Group__1__Impl4085); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2037:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl rule__Documentation__Group__3 ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2041:1: ( rule__Documentation__Group__2__Impl rule__Documentation__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2042:2: rule__Documentation__Group__2__Impl rule__Documentation__Group__3
            {
            pushFollow(FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__24116);
            rule__Documentation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__3_in_rule__Documentation__Group__24119);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2049:1: rule__Documentation__Group__2__Impl : ( ( rule__Documentation__LinesAssignment_2 )* ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2053:1: ( ( ( rule__Documentation__LinesAssignment_2 )* ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2054:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2054:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2055:1: ( rule__Documentation__LinesAssignment_2 )*
            {
             before(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2056:1: ( rule__Documentation__LinesAssignment_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_STRING) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2056:2: rule__Documentation__LinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Documentation__LinesAssignment_2_in_rule__Documentation__Group__2__Impl4146);
            	    rule__Documentation__LinesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2066:1: rule__Documentation__Group__3 : rule__Documentation__Group__3__Impl ;
    public final void rule__Documentation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2070:1: ( rule__Documentation__Group__3__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2071:2: rule__Documentation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Documentation__Group__3__Impl_in_rule__Documentation__Group__34177);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2077:1: rule__Documentation__Group__3__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2081:1: ( ( ']' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2082:1: ( ']' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2082:1: ( ']' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2083:1: ']'
            {
             before(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3()); 
            match(input,31,FOLLOW_31_in_rule__Documentation__Group__3__Impl4205); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2106:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2110:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2111:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__04246);
            rule__BooleanLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__04249);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2118:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2122:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2123:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2123:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2124:1: ()
            {
             before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2125:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2127:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2137:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2141:1: ( rule__BooleanLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2142:2: rule__BooleanLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__14307);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2148:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2152:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2153:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2153:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2154:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2155:1: ( rule__BooleanLiteral__Alternatives_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2155:2: rule__BooleanLiteral__Alternatives_1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl4334);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2169:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2173:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2174:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__04368);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__04371);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2181:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2185:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2186:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2186:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2187:1: ()
            {
             before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2188:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2190:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2200:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2204:1: ( rule__RealLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2205:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__14429);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2211:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2215:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2216:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2216:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2217:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2218:1: ( rule__RealLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2218:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl4456);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2232:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2236:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2237:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__04490);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__04493);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2244:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2248:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2249:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2249:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2250:1: ()
            {
             before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2251:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2253:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2263:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2267:1: ( rule__IntLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2268:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__14551);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2274:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2278:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2279:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2279:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2280:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2281:1: ( rule__IntLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2281:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl4578);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2295:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2299:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2300:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__04612);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__04615);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2307:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2311:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2312:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2312:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2313:1: ()
            {
             before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2314:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2316:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2326:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2330:1: ( rule__StringLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2331:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__14673);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2337:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2341:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2342:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2342:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2343:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2344:1: ( rule__StringLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2344:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl4700);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2358:1: rule__SignedInteger__Group__0 : rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 ;
    public final void rule__SignedInteger__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2362:1: ( rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2363:2: rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__04734);
            rule__SignedInteger__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__04737);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2370:1: rule__SignedInteger__Group__0__Impl : ( ( rule__SignedInteger__Alternatives_0 )? ) ;
    public final void rule__SignedInteger__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2374:1: ( ( ( rule__SignedInteger__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2375:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2375:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2376:1: ( rule__SignedInteger__Alternatives_0 )?
            {
             before(grammarAccess.getSignedIntegerAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2377:1: ( rule__SignedInteger__Alternatives_0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=15 && LA19_0<=16)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2377:2: rule__SignedInteger__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl4764);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2387:1: rule__SignedInteger__Group__1 : rule__SignedInteger__Group__1__Impl ;
    public final void rule__SignedInteger__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2391:1: ( rule__SignedInteger__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2392:2: rule__SignedInteger__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__14795);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2398:1: rule__SignedInteger__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__SignedInteger__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2402:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2403:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2403:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2404:1: RULE_INT
            {
             before(grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl4822); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2419:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2423:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2424:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__04855);
            rule__Decimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__04858);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2431:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2435:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2436:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2436:1: ( ( rule__Decimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2437:1: ( rule__Decimal__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2438:1: ( rule__Decimal__Alternatives_0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=15 && LA20_0<=16)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2438:2: rule__Decimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl4885);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2448:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2452:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2453:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__14916);
            rule__Decimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__14919);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2460:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2464:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2465:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2465:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2466:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl4946); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2477:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2481:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2482:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
            {
            pushFollow(FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__24975);
            rule__Decimal__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__24978);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2489:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2493:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2494:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2494:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2495:1: '.'
            {
             before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__Decimal__Group__2__Impl5006); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2508:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2512:1: ( rule__Decimal__Group__3__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2513:2: rule__Decimal__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__35037);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2519:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2523:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2524:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2524:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2525:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl5064); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2544:1: rule__DotDecimal__Group__0 : rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 ;
    public final void rule__DotDecimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2548:1: ( rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2549:2: rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__05101);
            rule__DotDecimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__05104);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2556:1: rule__DotDecimal__Group__0__Impl : ( ( rule__DotDecimal__Alternatives_0 )? ) ;
    public final void rule__DotDecimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2560:1: ( ( ( rule__DotDecimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2561:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2561:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2562:1: ( rule__DotDecimal__Alternatives_0 )?
            {
             before(grammarAccess.getDotDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2563:1: ( rule__DotDecimal__Alternatives_0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=15 && LA21_0<=16)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2563:2: rule__DotDecimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl5131);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2573:1: rule__DotDecimal__Group__1 : rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 ;
    public final void rule__DotDecimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2577:1: ( rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2578:2: rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__15162);
            rule__DotDecimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__15165);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2585:1: rule__DotDecimal__Group__1__Impl : ( '.' ) ;
    public final void rule__DotDecimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2589:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2590:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2590:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2591:1: '.'
            {
             before(grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
            match(input,32,FOLLOW_32_in_rule__DotDecimal__Group__1__Impl5193); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2604:1: rule__DotDecimal__Group__2 : rule__DotDecimal__Group__2__Impl ;
    public final void rule__DotDecimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2608:1: ( rule__DotDecimal__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2609:2: rule__DotDecimal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__25224);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2615:1: rule__DotDecimal__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DotDecimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2619:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2620:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2620:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2621:1: RULE_INT
            {
             before(grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl5251); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2638:1: rule__DecimalDot__Group__0 : rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 ;
    public final void rule__DecimalDot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2642:1: ( rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2643:2: rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__05286);
            rule__DecimalDot__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__05289);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2650:1: rule__DecimalDot__Group__0__Impl : ( ( rule__DecimalDot__Alternatives_0 )? ) ;
    public final void rule__DecimalDot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2654:1: ( ( ( rule__DecimalDot__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2655:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2655:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2656:1: ( rule__DecimalDot__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalDotAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2657:1: ( rule__DecimalDot__Alternatives_0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=15 && LA22_0<=16)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2657:2: rule__DecimalDot__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl5316);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2667:1: rule__DecimalDot__Group__1 : rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 ;
    public final void rule__DecimalDot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2671:1: ( rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2672:2: rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__15347);
            rule__DecimalDot__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__15350);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2679:1: rule__DecimalDot__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalDot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2683:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2684:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2684:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2685:1: RULE_INT
            {
             before(grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl5377); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2696:1: rule__DecimalDot__Group__2 : rule__DecimalDot__Group__2__Impl ;
    public final void rule__DecimalDot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2700:1: ( rule__DecimalDot__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2701:2: rule__DecimalDot__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__25406);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2707:1: rule__DecimalDot__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalDot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2711:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2712:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2712:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2713:1: '.'
            {
             before(grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__DecimalDot__Group__2__Impl5434); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2732:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2736:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2737:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__05471);
            rule__DecimalExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__05474);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2744:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2748:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2749:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2749:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2750:1: ( rule__DecimalExp__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2751:1: ( rule__DecimalExp__Alternatives_0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=15 && LA23_0<=16)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2751:2: rule__DecimalExp__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl5501);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2761:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2765:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2766:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__15532);
            rule__DecimalExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__15535);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2773:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2777:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2778:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2778:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2779:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl5562); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2790:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2794:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2795:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__25591);
            rule__DecimalExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__25594);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2802:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2806:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2807:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2807:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2808:1: '.'
            {
             before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__DecimalExp__Group__2__Impl5622); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2821:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2825:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2826:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__35653);
            rule__DecimalExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__35656);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2833:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2837:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2838:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2838:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2839:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl5683); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2850:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2854:1: ( rule__DecimalExp__Group__4__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2855:2: rule__DecimalExp__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__45712);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2861:1: rule__DecimalExp__Group__4__Impl : ( RULE_EXP ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2865:1: ( ( RULE_EXP ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2866:1: ( RULE_EXP )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2866:1: ( RULE_EXP )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2867:1: RULE_EXP
            {
             before(grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 
            match(input,RULE_EXP,FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl5739); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2888:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2892:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2893:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__05778);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__05781);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2900:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2904:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2905:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2905:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2906:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl5808); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2917:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2921:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2922:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__15837);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2928:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2932:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2933:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2933:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2934:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2935:1: ( rule__FQN__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==32) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2935:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl5864);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2949:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2953:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2954:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__05899);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__05902);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2961:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2965:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2966:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2966:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2967:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,32,FOLLOW_32_in_rule__FQN__Group_1__0__Impl5930); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2980:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2984:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2985:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__15961);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2991:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2995:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2996:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2996:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2997:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl5988); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3013:1: rule__Annotation__TypeAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__Annotation__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3017:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3018:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3018:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3019:1: ( ruleFQN )
            {
             before(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3020:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3021:1: ruleFQN
            {
             before(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeFQNParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__Annotation__TypeAssignment_16030);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3032:1: rule__Annotation__AttributesAssignment_2_1 : ( ruleKeyValue ) ;
    public final void rule__Annotation__AttributesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3036:1: ( ( ruleKeyValue ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3037:1: ( ruleKeyValue )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3037:1: ( ruleKeyValue )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3038:1: ruleKeyValue
            {
             before(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleKeyValue_in_rule__Annotation__AttributesAssignment_2_16065);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3047:1: rule__Annotation__AttributesAssignment_2_2_1 : ( ruleKeyValue ) ;
    public final void rule__Annotation__AttributesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3051:1: ( ( ruleKeyValue ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3052:1: ( ruleKeyValue )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3052:1: ( ruleKeyValue )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3053:1: ruleKeyValue
            {
             before(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_ruleKeyValue_in_rule__Annotation__AttributesAssignment_2_2_16096);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3062:1: rule__KeyValue__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3066:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3067:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3067:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3068:1: RULE_ID
            {
             before(grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__KeyValue__KeyAssignment_06127); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3077:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3081:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3082:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3082:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3083:1: ruleLiteral
            {
             before(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__KeyValue__ValueAssignment_26158);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3098:1: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__SimpleAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3102:1: ( ( ( 'optional' ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3103:1: ( ( 'optional' ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3103:1: ( ( 'optional' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3104:1: ( 'optional' )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3105:1: ( 'optional' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3106:1: 'optional'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,33,FOLLOW_33_in_rule__SimpleAnnotationAttribute__OptionalAssignment_0_06200); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3121:1: rule__SimpleAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3125:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3126:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3126:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3127:1: RULE_ID
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleAnnotationAttribute__NameAssignment_26239); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3136:1: rule__SimpleAnnotationAttribute__TypeAssignment_4 : ( ruleLiteralType ) ;
    public final void rule__SimpleAnnotationAttribute__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3140:1: ( ( ruleLiteralType ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3141:1: ( ruleLiteralType )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3141:1: ( ruleLiteralType )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3142:1: ruleLiteralType
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleLiteralType_in_rule__SimpleAnnotationAttribute__TypeAssignment_46270);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3151:1: rule__EnumAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__EnumAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3155:1: ( ( ( 'optional' ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3156:1: ( ( 'optional' ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3156:1: ( ( 'optional' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3157:1: ( 'optional' )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3158:1: ( 'optional' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3159:1: 'optional'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,33,FOLLOW_33_in_rule__EnumAnnotationAttribute__OptionalAssignment_0_06306); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3174:1: rule__EnumAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EnumAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3178:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3179:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3179:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3180:1: RULE_ID
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EnumAnnotationAttribute__NameAssignment_26345); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3189:1: rule__EnumAnnotationAttribute__ValuesAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3193:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3194:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3194:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3195:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_56376); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3204:1: rule__EnumAnnotationAttribute__ValuesAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3208:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3209:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3209:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3210:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_6_16407); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3219:1: rule__Documentation__LinesAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Documentation__LinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3223:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3224:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3224:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3225:1: RULE_STRING
            {
             before(grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Documentation__LinesAssignment_26438); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3236:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3240:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3241:1: ( ( 'true' ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3241:1: ( ( 'true' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3242:1: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3243:1: ( 'true' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3244:1: 'true'
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            match(input,34,FOLLOW_34_in_rule__BooleanLiteral__IsTrueAssignment_1_16476); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3259:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3263:1: ( ( ruleReal ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3264:1: ( ruleReal )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3264:1: ( ruleReal )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3265:1: ruleReal
            {
             before(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_16515);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3274:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3278:1: ( ( ruleInteger ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3279:1: ( ruleInteger )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3279:1: ( ruleInteger )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3280:1: ruleInteger
            {
             before(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_16546);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3289:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3293:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3294:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3294:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3295:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_16577); 
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


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\12\uffff";
    static final String DFA9_eofS =
        "\5\uffff\1\6\1\uffff\1\10\2\uffff";
    static final String DFA9_minS =
        "\3\6\1\40\1\uffff\1\6\1\uffff\1\7\2\uffff";
    static final String DFA9_maxS =
        "\4\40\1\uffff\1\30\1\uffff\1\30\2\uffff";
    static final String DFA9_acceptS =
        "\4\uffff\1\2\1\uffff\1\3\1\uffff\1\1\1\4";
    static final String DFA9_specialS =
        "\12\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\3\10\uffff\1\1\1\2\17\uffff\1\4",
            "\1\3\31\uffff\1\4",
            "\1\3\31\uffff\1\4",
            "\1\5",
            "",
            "\1\7\20\uffff\2\6",
            "",
            "\1\11\17\uffff\2\10",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "940:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleAnnotation_in_entryRuleAnnotation61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotation68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group__0_in_ruleAnnotation94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_entryRuleKeyValue121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValue128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__0_in_ruleKeyValue154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationTargetType190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotationTargetType216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationAttribute249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AnnotationAttribute__Alternatives_in_ruleAnnotationAttribute275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__0_in_ruleSimpleAnnotationAttribute335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__0_in_ruleEnumAnnotationAttribute395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0_in_ruleDocumentation455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral544 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral604 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger844 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integer__Alternatives_in_ruleInteger877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger909 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal1041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Real__Alternatives_in_ruleReal1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal1106 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1175 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1244 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1313 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1377 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralType__Alternatives_in_ruleLiteralType1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__OptionalAssignment_0_0_in_rule__SimpleAnnotationAttribute__Alternatives_01532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__SimpleAnnotationAttribute__Alternatives_01551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__OptionalAssignment_0_0_in_rule__EnumAnnotationAttribute__Alternatives_01585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__EnumAnnotationAttribute__Alternatives_01604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives1638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__BooleanLiteral__Alternatives_11705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_11724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__SignedInteger__Alternatives_01856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__SignedInteger__Alternatives_01876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_rule__Real__Alternatives1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Decimal__Alternatives_01994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Decimal__Alternatives_02014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DotDecimal__Alternatives_02049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DotDecimal__Alternatives_02069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalDot__Alternatives_02104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalDot__Alternatives_02124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalExp__Alternatives_02159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalExp__Alternatives_02179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__LiteralType__Alternatives2214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__LiteralType__Alternatives2235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__LiteralType__Alternatives2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__LiteralType__Alternatives2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group__0__Impl_in_rule__Annotation__Group__02310 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Annotation__Group__1_in_rule__Annotation__Group__02313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Annotation__Group__0__Impl2341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group__1__Impl_in_rule__Annotation__Group__12372 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Annotation__Group__2_in_rule__Annotation__Group__12375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__TypeAssignment_1_in_rule__Annotation__Group__1__Impl2402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group__2__Impl_in_rule__Annotation__Group__22432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__0_in_rule__Annotation__Group__2__Impl2459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__0__Impl_in_rule__Annotation__Group_2__02496 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__1_in_rule__Annotation__Group_2__02499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Annotation__Group_2__0__Impl2527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__1__Impl_in_rule__Annotation__Group_2__12558 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__2_in_rule__Annotation__Group_2__12561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__AttributesAssignment_2_1_in_rule__Annotation__Group_2__1__Impl2588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__2__Impl_in_rule__Annotation__Group_2__22618 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__3_in_rule__Annotation__Group_2__22621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2_2__0_in_rule__Annotation__Group_2__2__Impl2648 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__3__Impl_in_rule__Annotation__Group_2__32679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Annotation__Group_2__3__Impl2707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2_2__0__Impl_in_rule__Annotation__Group_2_2__02746 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2_2__1_in_rule__Annotation__Group_2_2__02749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Annotation__Group_2_2__0__Impl2777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2_2__1__Impl_in_rule__Annotation__Group_2_2__12808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__AttributesAssignment_2_2_1_in_rule__Annotation__Group_2_2__1__Impl2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__0__Impl_in_rule__KeyValue__Group__02869 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__1_in_rule__KeyValue__Group__02872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__KeyAssignment_0_in_rule__KeyValue__Group__0__Impl2899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__1__Impl_in_rule__KeyValue__Group__12929 = new BitSet(new long[]{0x000000050001C160L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__2_in_rule__KeyValue__Group__12932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__KeyValue__Group__1__Impl2960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__2__Impl_in_rule__KeyValue__Group__22991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__ValueAssignment_2_in_rule__KeyValue__Group__2__Impl3018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__0__Impl_in_rule__SimpleAnnotationAttribute__Group__03057 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__1_in_rule__SimpleAnnotationAttribute__Group__03060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Alternatives_0_in_rule__SimpleAnnotationAttribute__Group__0__Impl3087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__1__Impl_in_rule__SimpleAnnotationAttribute__Group__13117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__2_in_rule__SimpleAnnotationAttribute__Group__13120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SimpleAnnotationAttribute__Group__1__Impl3148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__2__Impl_in_rule__SimpleAnnotationAttribute__Group__23179 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__3_in_rule__SimpleAnnotationAttribute__Group__23182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__NameAssignment_2_in_rule__SimpleAnnotationAttribute__Group__2__Impl3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__3__Impl_in_rule__SimpleAnnotationAttribute__Group__33239 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__4_in_rule__SimpleAnnotationAttribute__Group__33242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__SimpleAnnotationAttribute__Group__3__Impl3270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__4__Impl_in_rule__SimpleAnnotationAttribute__Group__43301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__TypeAssignment_4_in_rule__SimpleAnnotationAttribute__Group__4__Impl3328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__0__Impl_in_rule__EnumAnnotationAttribute__Group__03368 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__1_in_rule__EnumAnnotationAttribute__Group__03371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Alternatives_0_in_rule__EnumAnnotationAttribute__Group__0__Impl3398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__1__Impl_in_rule__EnumAnnotationAttribute__Group__13428 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__2_in_rule__EnumAnnotationAttribute__Group__13431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__EnumAnnotationAttribute__Group__1__Impl3459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__2__Impl_in_rule__EnumAnnotationAttribute__Group__23490 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__3_in_rule__EnumAnnotationAttribute__Group__23493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__NameAssignment_2_in_rule__EnumAnnotationAttribute__Group__2__Impl3520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__3__Impl_in_rule__EnumAnnotationAttribute__Group__33550 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__4_in_rule__EnumAnnotationAttribute__Group__33553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__EnumAnnotationAttribute__Group__3__Impl3581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__4__Impl_in_rule__EnumAnnotationAttribute__Group__43612 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__5_in_rule__EnumAnnotationAttribute__Group__43615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__EnumAnnotationAttribute__Group__4__Impl3643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__5__Impl_in_rule__EnumAnnotationAttribute__Group__53674 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__6_in_rule__EnumAnnotationAttribute__Group__53677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_5_in_rule__EnumAnnotationAttribute__Group__5__Impl3704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__6__Impl_in_rule__EnumAnnotationAttribute__Group__63734 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__7_in_rule__EnumAnnotationAttribute__Group__63737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__0_in_rule__EnumAnnotationAttribute__Group__6__Impl3764 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__7__Impl_in_rule__EnumAnnotationAttribute__Group__73795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__EnumAnnotationAttribute__Group__7__Impl3823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__0__Impl_in_rule__EnumAnnotationAttribute__Group_6__03870 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__1_in_rule__EnumAnnotationAttribute__Group_6__03873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__EnumAnnotationAttribute__Group_6__0__Impl3901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__1__Impl_in_rule__EnumAnnotationAttribute__Group_6__13932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_6_1_in_rule__EnumAnnotationAttribute__Group_6__1__Impl3959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__03993 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__03996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__14054 = new BitSet(new long[]{0x0000000080000100L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__14057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Documentation__Group__1__Impl4085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__24116 = new BitSet(new long[]{0x0000000080000100L});
    public static final BitSet FOLLOW_rule__Documentation__Group__3_in_rule__Documentation__Group__24119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__LinesAssignment_2_in_rule__Documentation__Group__2__Impl4146 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_rule__Documentation__Group__3__Impl_in_rule__Documentation__Group__34177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Documentation__Group__3__Impl4205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__04246 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__04249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__14307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl4334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__04368 = new BitSet(new long[]{0x0000000100018060L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__04371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__14429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl4456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__04490 = new BitSet(new long[]{0x0000000000018060L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__04493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__14551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl4578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__04612 = new BitSet(new long[]{0x000000050001C160L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__04615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__14673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl4700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__04734 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__04737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl4764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__14795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl4822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__04855 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__04858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl4885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__14916 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__14919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl4946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__24975 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__24978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Decimal__Group__2__Impl5006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__35037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl5064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__05101 = new BitSet(new long[]{0x0000000100018000L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__05104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl5131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__15162 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__15165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DotDecimal__Group__1__Impl5193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__25224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl5251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__05286 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__05289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl5316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__15347 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__15350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl5377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__25406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DecimalDot__Group__2__Impl5434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__05471 = new BitSet(new long[]{0x0000000100018060L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__05474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl5501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__15532 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__15535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl5562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__25591 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__25594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DecimalExp__Group__2__Impl5622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__35653 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__35656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl5683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__45712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl5739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__05778 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__05781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl5808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__15837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl5864 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__05899 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__05902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__FQN__Group_1__0__Impl5930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__15961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl5988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Annotation__TypeAssignment_16030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_rule__Annotation__AttributesAssignment_2_16065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_rule__Annotation__AttributesAssignment_2_2_16096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__KeyValue__KeyAssignment_06127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__KeyValue__ValueAssignment_26158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__SimpleAnnotationAttribute__OptionalAssignment_0_06200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleAnnotationAttribute__NameAssignment_26239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralType_in_rule__SimpleAnnotationAttribute__TypeAssignment_46270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__EnumAnnotationAttribute__OptionalAssignment_0_06306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EnumAnnotationAttribute__NameAssignment_26345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_56376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_6_16407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Documentation__LinesAssignment_26438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__BooleanLiteral__IsTrueAssignment_1_16476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_16515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_16546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_16577 = new BitSet(new long[]{0x0000000000000002L});

}