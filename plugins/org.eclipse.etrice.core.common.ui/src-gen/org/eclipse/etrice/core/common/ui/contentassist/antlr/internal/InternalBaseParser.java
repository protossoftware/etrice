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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:262:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:263:1: ( ruleLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:264:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral486);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral493); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:271:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:275:2: ( ( ( rule__Literal__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:276:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:276:1: ( ( rule__Literal__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:277:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:278:1: ( rule__Literal__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:278:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral519);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:290:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:291:1: ( ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:292:1: ruleBooleanLiteral EOF
            {
             before(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral546);
            ruleBooleanLiteral();

            state._fsp--;

             after(grammarAccess.getBooleanLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral553); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:299:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:303:2: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:304:1: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:304:1: ( ( rule__BooleanLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:305:1: ( rule__BooleanLiteral__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:306:1: ( rule__BooleanLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:306:2: rule__BooleanLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral579);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:318:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:319:1: ( ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:320:1: ruleNumberLiteral EOF
            {
             before(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral606);
            ruleNumberLiteral();

            state._fsp--;

             after(grammarAccess.getNumberLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral613); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:327:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Alternatives ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:331:2: ( ( ( rule__NumberLiteral__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:332:1: ( ( rule__NumberLiteral__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:332:1: ( ( rule__NumberLiteral__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:333:1: ( rule__NumberLiteral__Alternatives )
            {
             before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:334:1: ( rule__NumberLiteral__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:334:2: rule__NumberLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral639);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:346:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:347:1: ( ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:348:1: ruleRealLiteral EOF
            {
             before(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral666);
            ruleRealLiteral();

            state._fsp--;

             after(grammarAccess.getRealLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral673); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:355:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:359:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:360:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:360:1: ( ( rule__RealLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:361:1: ( rule__RealLiteral__Group__0 )
            {
             before(grammarAccess.getRealLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:362:1: ( rule__RealLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:362:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral699);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:374:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:375:1: ( ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:376:1: ruleIntLiteral EOF
            {
             before(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral726);
            ruleIntLiteral();

            state._fsp--;

             after(grammarAccess.getIntLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral733); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:383:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:387:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:388:1: ( ( rule__IntLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:388:1: ( ( rule__IntLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:389:1: ( rule__IntLiteral__Group__0 )
            {
             before(grammarAccess.getIntLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:390:1: ( rule__IntLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:390:2: rule__IntLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral759);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:402:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:403:1: ( ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:404:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral786);
            ruleStringLiteral();

            state._fsp--;

             after(grammarAccess.getStringLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral793); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:411:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:415:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:416:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:416:1: ( ( rule__StringLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:417:1: ( rule__StringLiteral__Group__0 )
            {
             before(grammarAccess.getStringLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:418:1: ( rule__StringLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:418:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral819);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:430:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:431:1: ( ruleInteger EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:432:1: ruleInteger EOF
            {
             before(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger846);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger853); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:439:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:443:2: ( ( ( rule__Integer__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:444:1: ( ( rule__Integer__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:444:1: ( ( rule__Integer__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:445:1: ( rule__Integer__Alternatives )
            {
             before(grammarAccess.getIntegerAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:446:1: ( rule__Integer__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:446:2: rule__Integer__Alternatives
            {
            pushFollow(FOLLOW_rule__Integer__Alternatives_in_ruleInteger879);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:458:1: entryRuleSignedInteger : ruleSignedInteger EOF ;
    public final void entryRuleSignedInteger() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:462:1: ( ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:463:1: ruleSignedInteger EOF
            {
             before(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger911);
            ruleSignedInteger();

            state._fsp--;

             after(grammarAccess.getSignedIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger918); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:473:1: ruleSignedInteger : ( ( rule__SignedInteger__Group__0 ) ) ;
    public final void ruleSignedInteger() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:478:2: ( ( ( rule__SignedInteger__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:479:1: ( ( rule__SignedInteger__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:479:1: ( ( rule__SignedInteger__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:480:1: ( rule__SignedInteger__Group__0 )
            {
             before(grammarAccess.getSignedIntegerAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:481:1: ( rule__SignedInteger__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:481:2: rule__SignedInteger__Group__0
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger948);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:494:1: entryRuleHexadecimal : ruleHexadecimal EOF ;
    public final void entryRuleHexadecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:498:1: ( ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:499:1: ruleHexadecimal EOF
            {
             before(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal980);
            ruleHexadecimal();

            state._fsp--;

             after(grammarAccess.getHexadecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal987); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:509:1: ruleHexadecimal : ( RULE_HEX ) ;
    public final void ruleHexadecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:514:2: ( ( RULE_HEX ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:515:1: ( RULE_HEX )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:515:1: ( RULE_HEX )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:516:1: RULE_HEX
            {
             before(grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 
            match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal1017); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:530:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:531:1: ( ruleReal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:532:1: ruleReal EOF
            {
             before(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal1043);
            ruleReal();

            state._fsp--;

             after(grammarAccess.getRealRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal1050); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:539:1: ruleReal : ( ( rule__Real__Alternatives ) ) ;
    public final void ruleReal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:543:2: ( ( ( rule__Real__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:544:1: ( ( rule__Real__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:544:1: ( ( rule__Real__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:545:1: ( rule__Real__Alternatives )
            {
             before(grammarAccess.getRealAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:546:1: ( rule__Real__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:546:2: rule__Real__Alternatives
            {
            pushFollow(FOLLOW_rule__Real__Alternatives_in_ruleReal1076);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:558:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:562:1: ( ruleDecimal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:563:1: ruleDecimal EOF
            {
             before(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal1108);
            ruleDecimal();

            state._fsp--;

             after(grammarAccess.getDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal1115); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:573:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:578:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:579:1: ( ( rule__Decimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:579:1: ( ( rule__Decimal__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:580:1: ( rule__Decimal__Group__0 )
            {
             before(grammarAccess.getDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:581:1: ( rule__Decimal__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:581:2: rule__Decimal__Group__0
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1145);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:594:1: entryRuleDotDecimal : ruleDotDecimal EOF ;
    public final void entryRuleDotDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:598:1: ( ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:599:1: ruleDotDecimal EOF
            {
             before(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1177);
            ruleDotDecimal();

            state._fsp--;

             after(grammarAccess.getDotDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal1184); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:609:1: ruleDotDecimal : ( ( rule__DotDecimal__Group__0 ) ) ;
    public final void ruleDotDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:614:2: ( ( ( rule__DotDecimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:615:1: ( ( rule__DotDecimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:615:1: ( ( rule__DotDecimal__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:616:1: ( rule__DotDecimal__Group__0 )
            {
             before(grammarAccess.getDotDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:617:1: ( rule__DotDecimal__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:617:2: rule__DotDecimal__Group__0
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1214);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:630:1: entryRuleDecimalDot : ruleDecimalDot EOF ;
    public final void entryRuleDecimalDot() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:634:1: ( ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:635:1: ruleDecimalDot EOF
            {
             before(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1246);
            ruleDecimalDot();

            state._fsp--;

             after(grammarAccess.getDecimalDotRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot1253); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:645:1: ruleDecimalDot : ( ( rule__DecimalDot__Group__0 ) ) ;
    public final void ruleDecimalDot() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:650:2: ( ( ( rule__DecimalDot__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:651:1: ( ( rule__DecimalDot__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:651:1: ( ( rule__DecimalDot__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:652:1: ( rule__DecimalDot__Group__0 )
            {
             before(grammarAccess.getDecimalDotAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:653:1: ( rule__DecimalDot__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:653:2: rule__DecimalDot__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1283);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:666:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:670:1: ( ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:671:1: ruleDecimalExp EOF
            {
             before(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1315);
            ruleDecimalExp();

            state._fsp--;

             after(grammarAccess.getDecimalExpRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp1322); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:681:1: ruleDecimalExp : ( ( rule__DecimalExp__Group__0 ) ) ;
    public final void ruleDecimalExp() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:686:2: ( ( ( rule__DecimalExp__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:687:1: ( ( rule__DecimalExp__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:687:1: ( ( rule__DecimalExp__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:688:1: ( rule__DecimalExp__Group__0 )
            {
             before(grammarAccess.getDecimalExpAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:689:1: ( rule__DecimalExp__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:689:2: rule__DecimalExp__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1352);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:702:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:703:1: ( ruleFQN EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:704:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1379);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1386); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:711:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:715:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:716:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:716:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:717:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:718:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:718:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN1412);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:731:1: ruleLiteralType : ( ( rule__LiteralType__Alternatives ) ) ;
    public final void ruleLiteralType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:735:1: ( ( ( rule__LiteralType__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:736:1: ( ( rule__LiteralType__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:736:1: ( ( rule__LiteralType__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:737:1: ( rule__LiteralType__Alternatives )
            {
             before(grammarAccess.getLiteralTypeAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:738:1: ( rule__LiteralType__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:738:2: rule__LiteralType__Alternatives
            {
            pushFollow(FOLLOW_rule__LiteralType__Alternatives_in_ruleLiteralType1449);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:750:1: rule__AnnotationAttribute__Alternatives : ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) );
    public final void rule__AnnotationAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:754:1: ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:755:1: ( ruleSimpleAnnotationAttribute )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:755:1: ( ruleSimpleAnnotationAttribute )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:756:1: ruleSimpleAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1485);
                    ruleSimpleAnnotationAttribute();

                    state._fsp--;

                     after(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:761:6: ( ruleEnumAnnotationAttribute )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:761:6: ( ruleEnumAnnotationAttribute )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:762:1: ruleEnumAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1502);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:772:1: rule__SimpleAnnotationAttribute__Alternatives_0 : ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__SimpleAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:776:1: ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:777:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:777:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:778:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:779:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:779:2: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__OptionalAssignment_0_0_in_rule__SimpleAnnotationAttribute__Alternatives_01534);
                    rule__SimpleAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:783:6: ( 'mandatory' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:783:6: ( 'mandatory' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:784:1: 'mandatory'
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__SimpleAnnotationAttribute__Alternatives_01553); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:796:1: rule__EnumAnnotationAttribute__Alternatives_0 : ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__EnumAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:800:1: ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:801:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:801:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:802:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:803:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:803:2: rule__EnumAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__EnumAnnotationAttribute__OptionalAssignment_0_0_in_rule__EnumAnnotationAttribute__Alternatives_01587);
                    rule__EnumAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:807:6: ( 'mandatory' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:807:6: ( 'mandatory' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:808:1: 'mandatory'
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__EnumAnnotationAttribute__Alternatives_01606); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:821:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:825:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:826:1: ( ruleBooleanLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:826:1: ( ruleBooleanLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:827:1: ruleBooleanLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives1641);
                    ruleBooleanLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:832:6: ( ruleNumberLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:832:6: ( ruleNumberLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:833:1: ruleNumberLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives1658);
                    ruleNumberLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:838:6: ( ruleStringLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:838:6: ( ruleStringLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:839:1: ruleStringLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives1675);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:849:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:853:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:854:1: ( 'false' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:854:1: ( 'false' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:855:1: 'false'
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    match(input,14,FOLLOW_14_in_rule__BooleanLiteral__Alternatives_11708); 
                     after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:862:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:862:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:863:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:864:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:864:2: rule__BooleanLiteral__IsTrueAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_11727);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:873:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:877:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:878:1: ( ruleIntLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:878:1: ( ruleIntLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:879:1: ruleIntLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives1760);
                    ruleIntLiteral();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:884:6: ( ruleRealLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:884:6: ( ruleRealLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:885:1: ruleRealLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives1777);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:895:1: rule__Integer__Alternatives : ( ( ruleSignedInteger ) | ( ruleHexadecimal ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:899:1: ( ( ruleSignedInteger ) | ( ruleHexadecimal ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:900:1: ( ruleSignedInteger )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:900:1: ( ruleSignedInteger )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:901:1: ruleSignedInteger
                    {
                     before(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives1809);
                    ruleSignedInteger();

                    state._fsp--;

                     after(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:906:6: ( ruleHexadecimal )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:906:6: ( ruleHexadecimal )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:907:1: ruleHexadecimal
                    {
                     before(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives1826);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:917:1: rule__SignedInteger__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__SignedInteger__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:921:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:922:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:922:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:923:1: '+'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__SignedInteger__Alternatives_01859); 
                     after(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:930:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:930:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:931:1: '-'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__SignedInteger__Alternatives_01879); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:943:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:947:1: ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) )
            int alt9=4;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:948:1: ( ruleDecimal )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:948:1: ( ruleDecimal )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:949:1: ruleDecimal
                    {
                     before(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDecimal_in_rule__Real__Alternatives1913);
                    ruleDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:954:6: ( ruleDotDecimal )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:954:6: ( ruleDotDecimal )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:955:1: ruleDotDecimal
                    {
                     before(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives1930);
                    ruleDotDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:960:6: ( ruleDecimalDot )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:960:6: ( ruleDecimalDot )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:961:1: ruleDecimalDot
                    {
                     before(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives1947);
                    ruleDecimalDot();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:966:6: ( ruleDecimalExp )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:966:6: ( ruleDecimalExp )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:967:1: ruleDecimalExp
                    {
                     before(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives1964);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:977:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:981:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:982:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:982:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:983:1: '+'
                    {
                     before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__Decimal__Alternatives_01997); 
                     after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:990:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:990:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:991:1: '-'
                    {
                     before(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__Decimal__Alternatives_02017); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1003:1: rule__DotDecimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DotDecimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1007:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1008:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1008:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1009:1: '+'
                    {
                     before(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__DotDecimal__Alternatives_02052); 
                     after(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1016:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1016:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1017:1: '-'
                    {
                     before(grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__DotDecimal__Alternatives_02072); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1029:1: rule__DecimalDot__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalDot__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1033:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1034:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1034:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1035:1: '+'
                    {
                     before(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__DecimalDot__Alternatives_02107); 
                     after(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1042:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1042:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1043:1: '-'
                    {
                     before(grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__DecimalDot__Alternatives_02127); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1055:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1059:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1060:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1060:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1061:1: '+'
                    {
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__DecimalExp__Alternatives_02162); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1068:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1068:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1069:1: '-'
                    {
                     before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__DecimalExp__Alternatives_02182); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1081:1: rule__LiteralType__Alternatives : ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) );
    public final void rule__LiteralType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1085:1: ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1086:1: ( ( 'ptBoolean' ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1086:1: ( ( 'ptBoolean' ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1087:1: ( 'ptBoolean' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1088:1: ( 'ptBoolean' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1088:3: 'ptBoolean'
                    {
                    match(input,17,FOLLOW_17_in_rule__LiteralType__Alternatives2217); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1093:6: ( ( 'ptInteger' ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1093:6: ( ( 'ptInteger' ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1094:1: ( 'ptInteger' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1095:1: ( 'ptInteger' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1095:3: 'ptInteger'
                    {
                    match(input,18,FOLLOW_18_in_rule__LiteralType__Alternatives2238); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1100:6: ( ( 'ptReal' ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1100:6: ( ( 'ptReal' ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1101:1: ( 'ptReal' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1102:1: ( 'ptReal' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1102:3: 'ptReal'
                    {
                    match(input,19,FOLLOW_19_in_rule__LiteralType__Alternatives2259); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1107:6: ( ( 'ptCharacter' ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1107:6: ( ( 'ptCharacter' ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1108:1: ( 'ptCharacter' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1109:1: ( 'ptCharacter' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1109:3: 'ptCharacter'
                    {
                    match(input,20,FOLLOW_20_in_rule__LiteralType__Alternatives2280); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1121:1: rule__Annotation__Group__0 : rule__Annotation__Group__0__Impl rule__Annotation__Group__1 ;
    public final void rule__Annotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1125:1: ( rule__Annotation__Group__0__Impl rule__Annotation__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1126:2: rule__Annotation__Group__0__Impl rule__Annotation__Group__1
            {
            pushFollow(FOLLOW_rule__Annotation__Group__0__Impl_in_rule__Annotation__Group__02313);
            rule__Annotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group__1_in_rule__Annotation__Group__02316);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1133:1: rule__Annotation__Group__0__Impl : ( '@' ) ;
    public final void rule__Annotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1137:1: ( ( '@' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1138:1: ( '@' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1138:1: ( '@' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1139:1: '@'
            {
             before(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__Annotation__Group__0__Impl2344); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1152:1: rule__Annotation__Group__1 : rule__Annotation__Group__1__Impl rule__Annotation__Group__2 ;
    public final void rule__Annotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1156:1: ( rule__Annotation__Group__1__Impl rule__Annotation__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1157:2: rule__Annotation__Group__1__Impl rule__Annotation__Group__2
            {
            pushFollow(FOLLOW_rule__Annotation__Group__1__Impl_in_rule__Annotation__Group__12375);
            rule__Annotation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group__2_in_rule__Annotation__Group__12378);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1164:1: rule__Annotation__Group__1__Impl : ( ( rule__Annotation__TypeAssignment_1 ) ) ;
    public final void rule__Annotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1168:1: ( ( ( rule__Annotation__TypeAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1169:1: ( ( rule__Annotation__TypeAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1169:1: ( ( rule__Annotation__TypeAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1170:1: ( rule__Annotation__TypeAssignment_1 )
            {
             before(grammarAccess.getAnnotationAccess().getTypeAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1171:1: ( rule__Annotation__TypeAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1171:2: rule__Annotation__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__Annotation__TypeAssignment_1_in_rule__Annotation__Group__1__Impl2405);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1181:1: rule__Annotation__Group__2 : rule__Annotation__Group__2__Impl ;
    public final void rule__Annotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1185:1: ( rule__Annotation__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1186:2: rule__Annotation__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Annotation__Group__2__Impl_in_rule__Annotation__Group__22435);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1192:1: rule__Annotation__Group__2__Impl : ( ( rule__Annotation__Group_2__0 )? ) ;
    public final void rule__Annotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1196:1: ( ( ( rule__Annotation__Group_2__0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1197:1: ( ( rule__Annotation__Group_2__0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1197:1: ( ( rule__Annotation__Group_2__0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1198:1: ( rule__Annotation__Group_2__0 )?
            {
             before(grammarAccess.getAnnotationAccess().getGroup_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1199:1: ( rule__Annotation__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1199:2: rule__Annotation__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Annotation__Group_2__0_in_rule__Annotation__Group__2__Impl2462);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1215:1: rule__Annotation__Group_2__0 : rule__Annotation__Group_2__0__Impl rule__Annotation__Group_2__1 ;
    public final void rule__Annotation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1219:1: ( rule__Annotation__Group_2__0__Impl rule__Annotation__Group_2__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1220:2: rule__Annotation__Group_2__0__Impl rule__Annotation__Group_2__1
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2__0__Impl_in_rule__Annotation__Group_2__02499);
            rule__Annotation__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group_2__1_in_rule__Annotation__Group_2__02502);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1227:1: rule__Annotation__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Annotation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1231:1: ( ( '(' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1232:1: ( '(' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1232:1: ( '(' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1233:1: '('
            {
             before(grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,22,FOLLOW_22_in_rule__Annotation__Group_2__0__Impl2530); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1246:1: rule__Annotation__Group_2__1 : rule__Annotation__Group_2__1__Impl rule__Annotation__Group_2__2 ;
    public final void rule__Annotation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1250:1: ( rule__Annotation__Group_2__1__Impl rule__Annotation__Group_2__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1251:2: rule__Annotation__Group_2__1__Impl rule__Annotation__Group_2__2
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2__1__Impl_in_rule__Annotation__Group_2__12561);
            rule__Annotation__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group_2__2_in_rule__Annotation__Group_2__12564);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1258:1: rule__Annotation__Group_2__1__Impl : ( ( rule__Annotation__AttributesAssignment_2_1 ) ) ;
    public final void rule__Annotation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1262:1: ( ( ( rule__Annotation__AttributesAssignment_2_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1263:1: ( ( rule__Annotation__AttributesAssignment_2_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1263:1: ( ( rule__Annotation__AttributesAssignment_2_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1264:1: ( rule__Annotation__AttributesAssignment_2_1 )
            {
             before(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1265:1: ( rule__Annotation__AttributesAssignment_2_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1265:2: rule__Annotation__AttributesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Annotation__AttributesAssignment_2_1_in_rule__Annotation__Group_2__1__Impl2591);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1275:1: rule__Annotation__Group_2__2 : rule__Annotation__Group_2__2__Impl rule__Annotation__Group_2__3 ;
    public final void rule__Annotation__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1279:1: ( rule__Annotation__Group_2__2__Impl rule__Annotation__Group_2__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1280:2: rule__Annotation__Group_2__2__Impl rule__Annotation__Group_2__3
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2__2__Impl_in_rule__Annotation__Group_2__22621);
            rule__Annotation__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group_2__3_in_rule__Annotation__Group_2__22624);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1287:1: rule__Annotation__Group_2__2__Impl : ( ( rule__Annotation__Group_2_2__0 )* ) ;
    public final void rule__Annotation__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1291:1: ( ( ( rule__Annotation__Group_2_2__0 )* ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1292:1: ( ( rule__Annotation__Group_2_2__0 )* )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1292:1: ( ( rule__Annotation__Group_2_2__0 )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1293:1: ( rule__Annotation__Group_2_2__0 )*
            {
             before(grammarAccess.getAnnotationAccess().getGroup_2_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1294:1: ( rule__Annotation__Group_2_2__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==24) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1294:2: rule__Annotation__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Annotation__Group_2_2__0_in_rule__Annotation__Group_2__2__Impl2651);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1304:1: rule__Annotation__Group_2__3 : rule__Annotation__Group_2__3__Impl ;
    public final void rule__Annotation__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1308:1: ( rule__Annotation__Group_2__3__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1309:2: rule__Annotation__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2__3__Impl_in_rule__Annotation__Group_2__32682);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1315:1: rule__Annotation__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Annotation__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1319:1: ( ( ')' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1320:1: ( ')' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1320:1: ( ')' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1321:1: ')'
            {
             before(grammarAccess.getAnnotationAccess().getRightParenthesisKeyword_2_3()); 
            match(input,23,FOLLOW_23_in_rule__Annotation__Group_2__3__Impl2710); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1342:1: rule__Annotation__Group_2_2__0 : rule__Annotation__Group_2_2__0__Impl rule__Annotation__Group_2_2__1 ;
    public final void rule__Annotation__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1346:1: ( rule__Annotation__Group_2_2__0__Impl rule__Annotation__Group_2_2__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1347:2: rule__Annotation__Group_2_2__0__Impl rule__Annotation__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2_2__0__Impl_in_rule__Annotation__Group_2_2__02749);
            rule__Annotation__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group_2_2__1_in_rule__Annotation__Group_2_2__02752);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1354:1: rule__Annotation__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Annotation__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1358:1: ( ( ',' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1359:1: ( ',' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1359:1: ( ',' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1360:1: ','
            {
             before(grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0()); 
            match(input,24,FOLLOW_24_in_rule__Annotation__Group_2_2__0__Impl2780); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1373:1: rule__Annotation__Group_2_2__1 : rule__Annotation__Group_2_2__1__Impl ;
    public final void rule__Annotation__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1377:1: ( rule__Annotation__Group_2_2__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1378:2: rule__Annotation__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2_2__1__Impl_in_rule__Annotation__Group_2_2__12811);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1384:1: rule__Annotation__Group_2_2__1__Impl : ( ( rule__Annotation__AttributesAssignment_2_2_1 ) ) ;
    public final void rule__Annotation__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1388:1: ( ( ( rule__Annotation__AttributesAssignment_2_2_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1389:1: ( ( rule__Annotation__AttributesAssignment_2_2_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1389:1: ( ( rule__Annotation__AttributesAssignment_2_2_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1390:1: ( rule__Annotation__AttributesAssignment_2_2_1 )
            {
             before(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_2_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1391:1: ( rule__Annotation__AttributesAssignment_2_2_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1391:2: rule__Annotation__AttributesAssignment_2_2_1
            {
            pushFollow(FOLLOW_rule__Annotation__AttributesAssignment_2_2_1_in_rule__Annotation__Group_2_2__1__Impl2838);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1405:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1409:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1410:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__0__Impl_in_rule__KeyValue__Group__02872);
            rule__KeyValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeyValue__Group__1_in_rule__KeyValue__Group__02875);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1417:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1421:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1422:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1422:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1423:1: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1424:1: ( rule__KeyValue__KeyAssignment_0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1424:2: rule__KeyValue__KeyAssignment_0
            {
            pushFollow(FOLLOW_rule__KeyValue__KeyAssignment_0_in_rule__KeyValue__Group__0__Impl2902);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1434:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1438:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1439:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__1__Impl_in_rule__KeyValue__Group__12932);
            rule__KeyValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeyValue__Group__2_in_rule__KeyValue__Group__12935);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1446:1: rule__KeyValue__Group__1__Impl : ( '=' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1450:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1451:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1451:1: ( '=' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1452:1: '='
            {
             before(grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1()); 
            match(input,25,FOLLOW_25_in_rule__KeyValue__Group__1__Impl2963); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1465:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1469:1: ( rule__KeyValue__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1470:2: rule__KeyValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__2__Impl_in_rule__KeyValue__Group__22994);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1476:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1480:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1481:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1481:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1482:1: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1483:1: ( rule__KeyValue__ValueAssignment_2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1483:2: rule__KeyValue__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__KeyValue__ValueAssignment_2_in_rule__KeyValue__Group__2__Impl3021);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1502:1: rule__SimpleAnnotationAttribute__Group__0 : rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 ;
    public final void rule__SimpleAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1506:1: ( rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1507:2: rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__0__Impl_in_rule__SimpleAnnotationAttribute__Group__03060);
            rule__SimpleAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__1_in_rule__SimpleAnnotationAttribute__Group__03063);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1514:1: rule__SimpleAnnotationAttribute__Group__0__Impl : ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1518:1: ( ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1519:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1519:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1520:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1521:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1521:2: rule__SimpleAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Alternatives_0_in_rule__SimpleAnnotationAttribute__Group__0__Impl3090);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1531:1: rule__SimpleAnnotationAttribute__Group__1 : rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 ;
    public final void rule__SimpleAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1535:1: ( rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1536:2: rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__1__Impl_in_rule__SimpleAnnotationAttribute__Group__13120);
            rule__SimpleAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__2_in_rule__SimpleAnnotationAttribute__Group__13123);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1543:1: rule__SimpleAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1547:1: ( ( 'attribute' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1548:1: ( 'attribute' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1548:1: ( 'attribute' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1549:1: 'attribute'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__SimpleAnnotationAttribute__Group__1__Impl3151); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1562:1: rule__SimpleAnnotationAttribute__Group__2 : rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 ;
    public final void rule__SimpleAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1566:1: ( rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1567:2: rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__2__Impl_in_rule__SimpleAnnotationAttribute__Group__23182);
            rule__SimpleAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__3_in_rule__SimpleAnnotationAttribute__Group__23185);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1574:1: rule__SimpleAnnotationAttribute__Group__2__Impl : ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1578:1: ( ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1579:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1579:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1580:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1581:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1581:2: rule__SimpleAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__NameAssignment_2_in_rule__SimpleAnnotationAttribute__Group__2__Impl3212);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1591:1: rule__SimpleAnnotationAttribute__Group__3 : rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 ;
    public final void rule__SimpleAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1595:1: ( rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1596:2: rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__3__Impl_in_rule__SimpleAnnotationAttribute__Group__33242);
            rule__SimpleAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__4_in_rule__SimpleAnnotationAttribute__Group__33245);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1603:1: rule__SimpleAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1607:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1608:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1608:1: ( ':' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1609:1: ':'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,27,FOLLOW_27_in_rule__SimpleAnnotationAttribute__Group__3__Impl3273); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1622:1: rule__SimpleAnnotationAttribute__Group__4 : rule__SimpleAnnotationAttribute__Group__4__Impl ;
    public final void rule__SimpleAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1626:1: ( rule__SimpleAnnotationAttribute__Group__4__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1627:2: rule__SimpleAnnotationAttribute__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__4__Impl_in_rule__SimpleAnnotationAttribute__Group__43304);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1633:1: rule__SimpleAnnotationAttribute__Group__4__Impl : ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1637:1: ( ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1638:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1638:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1639:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1640:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1640:2: rule__SimpleAnnotationAttribute__TypeAssignment_4
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__TypeAssignment_4_in_rule__SimpleAnnotationAttribute__Group__4__Impl3331);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1660:1: rule__EnumAnnotationAttribute__Group__0 : rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 ;
    public final void rule__EnumAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1664:1: ( rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1665:2: rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__0__Impl_in_rule__EnumAnnotationAttribute__Group__03371);
            rule__EnumAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__1_in_rule__EnumAnnotationAttribute__Group__03374);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1672:1: rule__EnumAnnotationAttribute__Group__0__Impl : ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1676:1: ( ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1677:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1677:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1678:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1679:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1679:2: rule__EnumAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Alternatives_0_in_rule__EnumAnnotationAttribute__Group__0__Impl3401);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1689:1: rule__EnumAnnotationAttribute__Group__1 : rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 ;
    public final void rule__EnumAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1693:1: ( rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1694:2: rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__1__Impl_in_rule__EnumAnnotationAttribute__Group__13431);
            rule__EnumAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__2_in_rule__EnumAnnotationAttribute__Group__13434);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1701:1: rule__EnumAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__EnumAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1705:1: ( ( 'attribute' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1706:1: ( 'attribute' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1706:1: ( 'attribute' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1707:1: 'attribute'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__EnumAnnotationAttribute__Group__1__Impl3462); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1720:1: rule__EnumAnnotationAttribute__Group__2 : rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 ;
    public final void rule__EnumAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1724:1: ( rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1725:2: rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__2__Impl_in_rule__EnumAnnotationAttribute__Group__23493);
            rule__EnumAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__3_in_rule__EnumAnnotationAttribute__Group__23496);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1732:1: rule__EnumAnnotationAttribute__Group__2__Impl : ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1736:1: ( ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1737:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1737:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1738:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1739:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1739:2: rule__EnumAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__NameAssignment_2_in_rule__EnumAnnotationAttribute__Group__2__Impl3523);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1749:1: rule__EnumAnnotationAttribute__Group__3 : rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 ;
    public final void rule__EnumAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1753:1: ( rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1754:2: rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__3__Impl_in_rule__EnumAnnotationAttribute__Group__33553);
            rule__EnumAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__4_in_rule__EnumAnnotationAttribute__Group__33556);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1761:1: rule__EnumAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1765:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1766:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1766:1: ( ':' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1767:1: ':'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,27,FOLLOW_27_in_rule__EnumAnnotationAttribute__Group__3__Impl3584); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1780:1: rule__EnumAnnotationAttribute__Group__4 : rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 ;
    public final void rule__EnumAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1784:1: ( rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1785:2: rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__4__Impl_in_rule__EnumAnnotationAttribute__Group__43615);
            rule__EnumAnnotationAttribute__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__5_in_rule__EnumAnnotationAttribute__Group__43618);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1792:1: rule__EnumAnnotationAttribute__Group__4__Impl : ( '{' ) ;
    public final void rule__EnumAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1796:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1797:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1797:1: ( '{' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1798:1: '{'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__EnumAnnotationAttribute__Group__4__Impl3646); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1811:1: rule__EnumAnnotationAttribute__Group__5 : rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 ;
    public final void rule__EnumAnnotationAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1815:1: ( rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1816:2: rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__5__Impl_in_rule__EnumAnnotationAttribute__Group__53677);
            rule__EnumAnnotationAttribute__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__6_in_rule__EnumAnnotationAttribute__Group__53680);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1823:1: rule__EnumAnnotationAttribute__Group__5__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1827:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1828:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1828:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1829:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1830:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1830:2: rule__EnumAnnotationAttribute__ValuesAssignment_5
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_5_in_rule__EnumAnnotationAttribute__Group__5__Impl3707);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1840:1: rule__EnumAnnotationAttribute__Group__6 : rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 ;
    public final void rule__EnumAnnotationAttribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1844:1: ( rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1845:2: rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__6__Impl_in_rule__EnumAnnotationAttribute__Group__63737);
            rule__EnumAnnotationAttribute__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__7_in_rule__EnumAnnotationAttribute__Group__63740);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1852:1: rule__EnumAnnotationAttribute__Group__6__Impl : ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) ;
    public final void rule__EnumAnnotationAttribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1856:1: ( ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1857:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1857:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1858:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1859:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==24) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1859:2: rule__EnumAnnotationAttribute__Group_6__0
            	    {
            	    pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__0_in_rule__EnumAnnotationAttribute__Group__6__Impl3767);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1869:1: rule__EnumAnnotationAttribute__Group__7 : rule__EnumAnnotationAttribute__Group__7__Impl ;
    public final void rule__EnumAnnotationAttribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1873:1: ( rule__EnumAnnotationAttribute__Group__7__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1874:2: rule__EnumAnnotationAttribute__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__7__Impl_in_rule__EnumAnnotationAttribute__Group__73798);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1880:1: rule__EnumAnnotationAttribute__Group__7__Impl : ( '}' ) ;
    public final void rule__EnumAnnotationAttribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1884:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1885:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1885:1: ( '}' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1886:1: '}'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7()); 
            match(input,29,FOLLOW_29_in_rule__EnumAnnotationAttribute__Group__7__Impl3826); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1915:1: rule__EnumAnnotationAttribute__Group_6__0 : rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 ;
    public final void rule__EnumAnnotationAttribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1919:1: ( rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1920:2: rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__0__Impl_in_rule__EnumAnnotationAttribute__Group_6__03873);
            rule__EnumAnnotationAttribute__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__1_in_rule__EnumAnnotationAttribute__Group_6__03876);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1927:1: rule__EnumAnnotationAttribute__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1931:1: ( ( ',' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1932:1: ( ',' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1932:1: ( ',' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1933:1: ','
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0()); 
            match(input,24,FOLLOW_24_in_rule__EnumAnnotationAttribute__Group_6__0__Impl3904); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1946:1: rule__EnumAnnotationAttribute__Group_6__1 : rule__EnumAnnotationAttribute__Group_6__1__Impl ;
    public final void rule__EnumAnnotationAttribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1950:1: ( rule__EnumAnnotationAttribute__Group_6__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1951:2: rule__EnumAnnotationAttribute__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__1__Impl_in_rule__EnumAnnotationAttribute__Group_6__13935);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1957:1: rule__EnumAnnotationAttribute__Group_6__1__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1961:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1962:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1962:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1963:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1964:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1964:2: rule__EnumAnnotationAttribute__ValuesAssignment_6_1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_6_1_in_rule__EnumAnnotationAttribute__Group_6__1__Impl3962);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1978:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1982:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1983:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__03996);
            rule__Documentation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__03999);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1990:1: rule__Documentation__Group__0__Impl : ( () ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1994:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1995:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1995:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1996:1: ()
            {
             before(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1997:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1999:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2009:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2013:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2014:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
            {
            pushFollow(FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__14057);
            rule__Documentation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__14060);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2021:1: rule__Documentation__Group__1__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2025:1: ( ( '[' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2026:1: ( '[' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2026:1: ( '[' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2027:1: '['
            {
             before(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__Documentation__Group__1__Impl4088); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2040:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl rule__Documentation__Group__3 ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2044:1: ( rule__Documentation__Group__2__Impl rule__Documentation__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2045:2: rule__Documentation__Group__2__Impl rule__Documentation__Group__3
            {
            pushFollow(FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__24119);
            rule__Documentation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__3_in_rule__Documentation__Group__24122);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2052:1: rule__Documentation__Group__2__Impl : ( ( rule__Documentation__LinesAssignment_2 )* ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2056:1: ( ( ( rule__Documentation__LinesAssignment_2 )* ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2057:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2057:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2058:1: ( rule__Documentation__LinesAssignment_2 )*
            {
             before(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2059:1: ( rule__Documentation__LinesAssignment_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_STRING) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2059:2: rule__Documentation__LinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Documentation__LinesAssignment_2_in_rule__Documentation__Group__2__Impl4149);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2069:1: rule__Documentation__Group__3 : rule__Documentation__Group__3__Impl ;
    public final void rule__Documentation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2073:1: ( rule__Documentation__Group__3__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2074:2: rule__Documentation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Documentation__Group__3__Impl_in_rule__Documentation__Group__34180);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2080:1: rule__Documentation__Group__3__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2084:1: ( ( ']' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2085:1: ( ']' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2085:1: ( ']' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2086:1: ']'
            {
             before(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3()); 
            match(input,31,FOLLOW_31_in_rule__Documentation__Group__3__Impl4208); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2113:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2117:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2118:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__04253);
            rule__BooleanLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__04256);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2125:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2129:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2130:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2130:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2131:1: ()
            {
             before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2132:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2134:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2144:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2148:1: ( rule__BooleanLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2149:2: rule__BooleanLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__14314);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2155:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2159:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2160:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2160:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2161:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2162:1: ( rule__BooleanLiteral__Alternatives_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2162:2: rule__BooleanLiteral__Alternatives_1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl4341);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2176:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2180:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2181:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__04375);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__04378);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2188:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2192:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2193:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2193:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2194:1: ()
            {
             before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2195:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2197:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2207:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2211:1: ( rule__RealLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2212:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__14436);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2218:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2222:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2223:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2223:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2224:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2225:1: ( rule__RealLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2225:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl4463);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2239:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2243:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2244:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__04497);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__04500);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2251:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2255:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2256:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2256:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2257:1: ()
            {
             before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2258:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2260:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2270:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2274:1: ( rule__IntLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2275:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__14558);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2281:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2285:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2286:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2286:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2287:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2288:1: ( rule__IntLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2288:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl4585);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2302:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2306:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2307:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__04619);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__04622);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2314:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2318:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2319:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2319:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2320:1: ()
            {
             before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2321:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2323:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2333:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2337:1: ( rule__StringLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2338:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__14680);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2344:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2348:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2349:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2349:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2350:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2351:1: ( rule__StringLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2351:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl4707);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2365:1: rule__SignedInteger__Group__0 : rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 ;
    public final void rule__SignedInteger__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2369:1: ( rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2370:2: rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__04741);
            rule__SignedInteger__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__04744);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2377:1: rule__SignedInteger__Group__0__Impl : ( ( rule__SignedInteger__Alternatives_0 )? ) ;
    public final void rule__SignedInteger__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2381:1: ( ( ( rule__SignedInteger__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2382:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2382:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2383:1: ( rule__SignedInteger__Alternatives_0 )?
            {
             before(grammarAccess.getSignedIntegerAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2384:1: ( rule__SignedInteger__Alternatives_0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=15 && LA19_0<=16)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2384:2: rule__SignedInteger__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl4771);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2394:1: rule__SignedInteger__Group__1 : rule__SignedInteger__Group__1__Impl ;
    public final void rule__SignedInteger__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2398:1: ( rule__SignedInteger__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2399:2: rule__SignedInteger__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__14802);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2405:1: rule__SignedInteger__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__SignedInteger__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2409:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2410:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2410:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2411:1: RULE_INT
            {
             before(grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl4829); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2426:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2430:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2431:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__04862);
            rule__Decimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__04865);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2438:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2442:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2443:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2443:1: ( ( rule__Decimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2444:1: ( rule__Decimal__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2445:1: ( rule__Decimal__Alternatives_0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=15 && LA20_0<=16)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2445:2: rule__Decimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl4892);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2455:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2459:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2460:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__14923);
            rule__Decimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__14926);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2467:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2471:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2472:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2472:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2473:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl4953); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2484:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2488:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2489:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
            {
            pushFollow(FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__24982);
            rule__Decimal__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__24985);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2496:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2500:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2501:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2501:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2502:1: '.'
            {
             before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__Decimal__Group__2__Impl5013); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2515:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2519:1: ( rule__Decimal__Group__3__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2520:2: rule__Decimal__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__35044);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2526:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2530:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2531:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2531:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2532:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl5071); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2551:1: rule__DotDecimal__Group__0 : rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 ;
    public final void rule__DotDecimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2555:1: ( rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2556:2: rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__05108);
            rule__DotDecimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__05111);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2563:1: rule__DotDecimal__Group__0__Impl : ( ( rule__DotDecimal__Alternatives_0 )? ) ;
    public final void rule__DotDecimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2567:1: ( ( ( rule__DotDecimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2568:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2568:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2569:1: ( rule__DotDecimal__Alternatives_0 )?
            {
             before(grammarAccess.getDotDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2570:1: ( rule__DotDecimal__Alternatives_0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=15 && LA21_0<=16)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2570:2: rule__DotDecimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl5138);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2580:1: rule__DotDecimal__Group__1 : rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 ;
    public final void rule__DotDecimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2584:1: ( rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2585:2: rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__15169);
            rule__DotDecimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__15172);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2592:1: rule__DotDecimal__Group__1__Impl : ( '.' ) ;
    public final void rule__DotDecimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2596:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2597:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2597:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2598:1: '.'
            {
             before(grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
            match(input,32,FOLLOW_32_in_rule__DotDecimal__Group__1__Impl5200); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2611:1: rule__DotDecimal__Group__2 : rule__DotDecimal__Group__2__Impl ;
    public final void rule__DotDecimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2615:1: ( rule__DotDecimal__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2616:2: rule__DotDecimal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__25231);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2622:1: rule__DotDecimal__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DotDecimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2626:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2627:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2627:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2628:1: RULE_INT
            {
             before(grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl5258); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2645:1: rule__DecimalDot__Group__0 : rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 ;
    public final void rule__DecimalDot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2649:1: ( rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2650:2: rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__05293);
            rule__DecimalDot__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__05296);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2657:1: rule__DecimalDot__Group__0__Impl : ( ( rule__DecimalDot__Alternatives_0 )? ) ;
    public final void rule__DecimalDot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2661:1: ( ( ( rule__DecimalDot__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2662:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2662:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2663:1: ( rule__DecimalDot__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalDotAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2664:1: ( rule__DecimalDot__Alternatives_0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=15 && LA22_0<=16)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2664:2: rule__DecimalDot__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl5323);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2674:1: rule__DecimalDot__Group__1 : rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 ;
    public final void rule__DecimalDot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2678:1: ( rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2679:2: rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__15354);
            rule__DecimalDot__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__15357);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2686:1: rule__DecimalDot__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalDot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2690:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2691:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2691:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2692:1: RULE_INT
            {
             before(grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl5384); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2703:1: rule__DecimalDot__Group__2 : rule__DecimalDot__Group__2__Impl ;
    public final void rule__DecimalDot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2707:1: ( rule__DecimalDot__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2708:2: rule__DecimalDot__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__25413);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2714:1: rule__DecimalDot__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalDot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2718:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2719:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2719:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2720:1: '.'
            {
             before(grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__DecimalDot__Group__2__Impl5441); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2739:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2743:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2744:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__05478);
            rule__DecimalExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__05481);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2751:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2755:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2756:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2756:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2757:1: ( rule__DecimalExp__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2758:1: ( rule__DecimalExp__Alternatives_0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=15 && LA23_0<=16)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2758:2: rule__DecimalExp__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl5508);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2768:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2772:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2773:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__15539);
            rule__DecimalExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__15542);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2780:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2784:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2785:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2785:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2786:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl5569); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2797:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2801:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2802:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__25598);
            rule__DecimalExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__25601);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2809:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2813:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2814:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2814:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2815:1: '.'
            {
             before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__DecimalExp__Group__2__Impl5629); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2828:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2832:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2833:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__35660);
            rule__DecimalExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__35663);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2840:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2844:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2845:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2845:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2846:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl5690); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2857:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2861:1: ( rule__DecimalExp__Group__4__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2862:2: rule__DecimalExp__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__45719);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2868:1: rule__DecimalExp__Group__4__Impl : ( RULE_EXP ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2872:1: ( ( RULE_EXP ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2873:1: ( RULE_EXP )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2873:1: ( RULE_EXP )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2874:1: RULE_EXP
            {
             before(grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 
            match(input,RULE_EXP,FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl5746); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2895:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2899:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2900:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__05785);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__05788);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2907:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2911:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2912:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2912:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2913:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl5815); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2924:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2928:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2929:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__15844);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2935:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2939:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2940:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2940:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2941:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2942:1: ( rule__FQN__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==32) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2942:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl5871);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2956:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2960:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2961:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__05906);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__05909);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2968:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2972:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2973:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2973:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2974:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,32,FOLLOW_32_in_rule__FQN__Group_1__0__Impl5937); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2987:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2991:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2992:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__15968);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2998:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3002:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3003:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3003:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3004:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl5995); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3020:1: rule__Annotation__TypeAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__Annotation__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3024:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3025:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3025:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3026:1: ( ruleFQN )
            {
             before(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3027:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3028:1: ruleFQN
            {
             before(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeFQNParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__Annotation__TypeAssignment_16037);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3039:1: rule__Annotation__AttributesAssignment_2_1 : ( ruleKeyValue ) ;
    public final void rule__Annotation__AttributesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3043:1: ( ( ruleKeyValue ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3044:1: ( ruleKeyValue )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3044:1: ( ruleKeyValue )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3045:1: ruleKeyValue
            {
             before(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleKeyValue_in_rule__Annotation__AttributesAssignment_2_16072);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3054:1: rule__Annotation__AttributesAssignment_2_2_1 : ( ruleKeyValue ) ;
    public final void rule__Annotation__AttributesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3058:1: ( ( ruleKeyValue ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3059:1: ( ruleKeyValue )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3059:1: ( ruleKeyValue )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3060:1: ruleKeyValue
            {
             before(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_ruleKeyValue_in_rule__Annotation__AttributesAssignment_2_2_16103);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3069:1: rule__KeyValue__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3073:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3074:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3074:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3075:1: RULE_ID
            {
             before(grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__KeyValue__KeyAssignment_06134); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3084:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3088:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3089:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3089:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3090:1: ruleLiteral
            {
             before(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__KeyValue__ValueAssignment_26165);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3105:1: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__SimpleAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3109:1: ( ( ( 'optional' ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3110:1: ( ( 'optional' ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3110:1: ( ( 'optional' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3111:1: ( 'optional' )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3112:1: ( 'optional' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3113:1: 'optional'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,33,FOLLOW_33_in_rule__SimpleAnnotationAttribute__OptionalAssignment_0_06207); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3128:1: rule__SimpleAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3132:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3133:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3133:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3134:1: RULE_ID
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleAnnotationAttribute__NameAssignment_26246); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3143:1: rule__SimpleAnnotationAttribute__TypeAssignment_4 : ( ruleLiteralType ) ;
    public final void rule__SimpleAnnotationAttribute__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3147:1: ( ( ruleLiteralType ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3148:1: ( ruleLiteralType )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3148:1: ( ruleLiteralType )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3149:1: ruleLiteralType
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleLiteralType_in_rule__SimpleAnnotationAttribute__TypeAssignment_46277);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3158:1: rule__EnumAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__EnumAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3162:1: ( ( ( 'optional' ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3163:1: ( ( 'optional' ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3163:1: ( ( 'optional' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3164:1: ( 'optional' )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3165:1: ( 'optional' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3166:1: 'optional'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,33,FOLLOW_33_in_rule__EnumAnnotationAttribute__OptionalAssignment_0_06313); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3181:1: rule__EnumAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EnumAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3185:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3186:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3186:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3187:1: RULE_ID
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EnumAnnotationAttribute__NameAssignment_26352); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3196:1: rule__EnumAnnotationAttribute__ValuesAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3200:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3201:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3201:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3202:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_56383); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3211:1: rule__EnumAnnotationAttribute__ValuesAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3215:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3216:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3216:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3217:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_6_16414); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3226:1: rule__Documentation__LinesAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Documentation__LinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3230:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3231:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3231:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3232:1: RULE_STRING
            {
             before(grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Documentation__LinesAssignment_26445); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3243:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3247:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3248:1: ( ( 'true' ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3248:1: ( ( 'true' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3249:1: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3250:1: ( 'true' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3251:1: 'true'
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            match(input,34,FOLLOW_34_in_rule__BooleanLiteral__IsTrueAssignment_1_16483); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3266:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3270:1: ( ( ruleReal ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3271:1: ( ruleReal )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3271:1: ( ruleReal )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3272:1: ruleReal
            {
             before(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_16522);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3281:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3285:1: ( ( ruleInteger ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3286:1: ( ruleInteger )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3286:1: ( ruleInteger )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3287:1: ruleInteger
            {
             before(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_16553);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3296:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3300:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3301:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3301:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3302:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_16584); 
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
            return "943:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );";
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
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral726 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integer__Alternatives_in_ruleInteger879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal980 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal1043 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Real__Alternatives_in_ruleReal1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal1108 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1177 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp1322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN1412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralType__Alternatives_in_ruleLiteralType1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__OptionalAssignment_0_0_in_rule__SimpleAnnotationAttribute__Alternatives_01534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__SimpleAnnotationAttribute__Alternatives_01553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__OptionalAssignment_0_0_in_rule__EnumAnnotationAttribute__Alternatives_01587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__EnumAnnotationAttribute__Alternatives_01606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives1675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__BooleanLiteral__Alternatives_11708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_11727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives1826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__SignedInteger__Alternatives_01859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__SignedInteger__Alternatives_01879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_rule__Real__Alternatives1913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Decimal__Alternatives_01997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Decimal__Alternatives_02017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DotDecimal__Alternatives_02052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DotDecimal__Alternatives_02072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalDot__Alternatives_02107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalDot__Alternatives_02127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalExp__Alternatives_02162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalExp__Alternatives_02182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__LiteralType__Alternatives2217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__LiteralType__Alternatives2238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__LiteralType__Alternatives2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__LiteralType__Alternatives2280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group__0__Impl_in_rule__Annotation__Group__02313 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Annotation__Group__1_in_rule__Annotation__Group__02316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Annotation__Group__0__Impl2344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group__1__Impl_in_rule__Annotation__Group__12375 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Annotation__Group__2_in_rule__Annotation__Group__12378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__TypeAssignment_1_in_rule__Annotation__Group__1__Impl2405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group__2__Impl_in_rule__Annotation__Group__22435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__0_in_rule__Annotation__Group__2__Impl2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__0__Impl_in_rule__Annotation__Group_2__02499 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__1_in_rule__Annotation__Group_2__02502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Annotation__Group_2__0__Impl2530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__1__Impl_in_rule__Annotation__Group_2__12561 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__2_in_rule__Annotation__Group_2__12564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__AttributesAssignment_2_1_in_rule__Annotation__Group_2__1__Impl2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__2__Impl_in_rule__Annotation__Group_2__22621 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__3_in_rule__Annotation__Group_2__22624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2_2__0_in_rule__Annotation__Group_2__2__Impl2651 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__3__Impl_in_rule__Annotation__Group_2__32682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Annotation__Group_2__3__Impl2710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2_2__0__Impl_in_rule__Annotation__Group_2_2__02749 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2_2__1_in_rule__Annotation__Group_2_2__02752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Annotation__Group_2_2__0__Impl2780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2_2__1__Impl_in_rule__Annotation__Group_2_2__12811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__AttributesAssignment_2_2_1_in_rule__Annotation__Group_2_2__1__Impl2838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__0__Impl_in_rule__KeyValue__Group__02872 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__1_in_rule__KeyValue__Group__02875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__KeyAssignment_0_in_rule__KeyValue__Group__0__Impl2902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__1__Impl_in_rule__KeyValue__Group__12932 = new BitSet(new long[]{0x000000050001C160L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__2_in_rule__KeyValue__Group__12935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__KeyValue__Group__1__Impl2963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__2__Impl_in_rule__KeyValue__Group__22994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__ValueAssignment_2_in_rule__KeyValue__Group__2__Impl3021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__0__Impl_in_rule__SimpleAnnotationAttribute__Group__03060 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__1_in_rule__SimpleAnnotationAttribute__Group__03063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Alternatives_0_in_rule__SimpleAnnotationAttribute__Group__0__Impl3090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__1__Impl_in_rule__SimpleAnnotationAttribute__Group__13120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__2_in_rule__SimpleAnnotationAttribute__Group__13123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SimpleAnnotationAttribute__Group__1__Impl3151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__2__Impl_in_rule__SimpleAnnotationAttribute__Group__23182 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__3_in_rule__SimpleAnnotationAttribute__Group__23185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__NameAssignment_2_in_rule__SimpleAnnotationAttribute__Group__2__Impl3212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__3__Impl_in_rule__SimpleAnnotationAttribute__Group__33242 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__4_in_rule__SimpleAnnotationAttribute__Group__33245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__SimpleAnnotationAttribute__Group__3__Impl3273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__4__Impl_in_rule__SimpleAnnotationAttribute__Group__43304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__TypeAssignment_4_in_rule__SimpleAnnotationAttribute__Group__4__Impl3331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__0__Impl_in_rule__EnumAnnotationAttribute__Group__03371 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__1_in_rule__EnumAnnotationAttribute__Group__03374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Alternatives_0_in_rule__EnumAnnotationAttribute__Group__0__Impl3401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__1__Impl_in_rule__EnumAnnotationAttribute__Group__13431 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__2_in_rule__EnumAnnotationAttribute__Group__13434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__EnumAnnotationAttribute__Group__1__Impl3462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__2__Impl_in_rule__EnumAnnotationAttribute__Group__23493 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__3_in_rule__EnumAnnotationAttribute__Group__23496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__NameAssignment_2_in_rule__EnumAnnotationAttribute__Group__2__Impl3523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__3__Impl_in_rule__EnumAnnotationAttribute__Group__33553 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__4_in_rule__EnumAnnotationAttribute__Group__33556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__EnumAnnotationAttribute__Group__3__Impl3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__4__Impl_in_rule__EnumAnnotationAttribute__Group__43615 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__5_in_rule__EnumAnnotationAttribute__Group__43618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__EnumAnnotationAttribute__Group__4__Impl3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__5__Impl_in_rule__EnumAnnotationAttribute__Group__53677 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__6_in_rule__EnumAnnotationAttribute__Group__53680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_5_in_rule__EnumAnnotationAttribute__Group__5__Impl3707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__6__Impl_in_rule__EnumAnnotationAttribute__Group__63737 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__7_in_rule__EnumAnnotationAttribute__Group__63740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__0_in_rule__EnumAnnotationAttribute__Group__6__Impl3767 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__7__Impl_in_rule__EnumAnnotationAttribute__Group__73798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__EnumAnnotationAttribute__Group__7__Impl3826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__0__Impl_in_rule__EnumAnnotationAttribute__Group_6__03873 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__1_in_rule__EnumAnnotationAttribute__Group_6__03876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__EnumAnnotationAttribute__Group_6__0__Impl3904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__1__Impl_in_rule__EnumAnnotationAttribute__Group_6__13935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_6_1_in_rule__EnumAnnotationAttribute__Group_6__1__Impl3962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__03996 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__03999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__14057 = new BitSet(new long[]{0x0000000080000100L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__14060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Documentation__Group__1__Impl4088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__24119 = new BitSet(new long[]{0x0000000080000100L});
    public static final BitSet FOLLOW_rule__Documentation__Group__3_in_rule__Documentation__Group__24122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__LinesAssignment_2_in_rule__Documentation__Group__2__Impl4149 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_rule__Documentation__Group__3__Impl_in_rule__Documentation__Group__34180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Documentation__Group__3__Impl4208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__04253 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__04256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__14314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl4341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__04375 = new BitSet(new long[]{0x0000000100018060L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__04378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__14436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl4463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__04497 = new BitSet(new long[]{0x0000000000018060L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__04500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__14558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl4585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__04619 = new BitSet(new long[]{0x000000050001C160L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__04622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__14680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl4707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__04741 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__04744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl4771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__14802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl4829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__04862 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__04865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl4892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__14923 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__14926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl4953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__24982 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__24985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Decimal__Group__2__Impl5013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__35044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl5071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__05108 = new BitSet(new long[]{0x0000000100018000L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__05111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl5138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__15169 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__15172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DotDecimal__Group__1__Impl5200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__25231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl5258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__05293 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__05296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl5323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__15354 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__15357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl5384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__25413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DecimalDot__Group__2__Impl5441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__05478 = new BitSet(new long[]{0x0000000100018060L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__05481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl5508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__15539 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__15542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl5569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__25598 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__25601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DecimalExp__Group__2__Impl5629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__35660 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__35663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl5690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__45719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl5746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__05785 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__05788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl5815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__15844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl5871 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__05906 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__05909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__FQN__Group_1__0__Impl5937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__15968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl5995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Annotation__TypeAssignment_16037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_rule__Annotation__AttributesAssignment_2_16072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_rule__Annotation__AttributesAssignment_2_2_16103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__KeyValue__KeyAssignment_06134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__KeyValue__ValueAssignment_26165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__SimpleAnnotationAttribute__OptionalAssignment_0_06207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleAnnotationAttribute__NameAssignment_26246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralType_in_rule__SimpleAnnotationAttribute__TypeAssignment_46277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__EnumAnnotationAttribute__OptionalAssignment_0_06313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EnumAnnotationAttribute__NameAssignment_26352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_56383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_6_16414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Documentation__LinesAssignment_26445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__BooleanLiteral__IsTrueAssignment_1_16483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_16522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_16553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_16584 = new BitSet(new long[]{0x0000000000000002L});

}