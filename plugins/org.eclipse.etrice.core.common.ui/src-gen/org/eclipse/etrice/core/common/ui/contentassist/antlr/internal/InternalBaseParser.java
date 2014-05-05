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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_HEX", "RULE_INT", "RULE_EXP", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'mandatory'", "'false'", "'+'", "'-'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'", "'@'", "'('", "')'", "','", "'='", "'attribute'", "':'", "'{'", "'}'", "'.*'", "'['", "']'", "'.'", "'optional'", "'true'"
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
    public static final int T__35=35;
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


    // $ANTLR start "entryRuleImportedFQN"
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:232:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:233:1: ( ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:234:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN424);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN431); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:241:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:245:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:246:1: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:246:1: ( ( rule__ImportedFQN__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:247:1: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:248:1: ( rule__ImportedFQN__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:248:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN457);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:260:1: entryRuleDocumentation : ruleDocumentation EOF ;
    public final void entryRuleDocumentation() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:261:1: ( ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:262:1: ruleDocumentation EOF
            {
             before(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation484);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getDocumentationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation491); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:269:1: ruleDocumentation : ( ( rule__Documentation__Group__0 ) ) ;
    public final void ruleDocumentation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:273:2: ( ( ( rule__Documentation__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:274:1: ( ( rule__Documentation__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:274:1: ( ( rule__Documentation__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:275:1: ( rule__Documentation__Group__0 )
            {
             before(grammarAccess.getDocumentationAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:276:1: ( rule__Documentation__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:276:2: rule__Documentation__Group__0
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0_in_ruleDocumentation517);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:292:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:293:1: ( ruleLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:294:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral548);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral555); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:301:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:305:2: ( ( ( rule__Literal__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:306:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:306:1: ( ( rule__Literal__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:307:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:308:1: ( rule__Literal__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:308:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral581);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:320:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:321:1: ( ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:322:1: ruleBooleanLiteral EOF
            {
             before(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral608);
            ruleBooleanLiteral();

            state._fsp--;

             after(grammarAccess.getBooleanLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral615); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:329:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:333:2: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:334:1: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:334:1: ( ( rule__BooleanLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:335:1: ( rule__BooleanLiteral__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:336:1: ( rule__BooleanLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:336:2: rule__BooleanLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral641);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:348:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:349:1: ( ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:350:1: ruleNumberLiteral EOF
            {
             before(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral668);
            ruleNumberLiteral();

            state._fsp--;

             after(grammarAccess.getNumberLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral675); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:357:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Alternatives ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:361:2: ( ( ( rule__NumberLiteral__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:362:1: ( ( rule__NumberLiteral__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:362:1: ( ( rule__NumberLiteral__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:363:1: ( rule__NumberLiteral__Alternatives )
            {
             before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:364:1: ( rule__NumberLiteral__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:364:2: rule__NumberLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral701);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:376:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:377:1: ( ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:378:1: ruleRealLiteral EOF
            {
             before(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral728);
            ruleRealLiteral();

            state._fsp--;

             after(grammarAccess.getRealLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral735); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:385:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:389:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:390:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:390:1: ( ( rule__RealLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:391:1: ( rule__RealLiteral__Group__0 )
            {
             before(grammarAccess.getRealLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:392:1: ( rule__RealLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:392:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral761);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:404:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:405:1: ( ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:406:1: ruleIntLiteral EOF
            {
             before(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral788);
            ruleIntLiteral();

            state._fsp--;

             after(grammarAccess.getIntLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral795); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:413:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:417:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:418:1: ( ( rule__IntLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:418:1: ( ( rule__IntLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:419:1: ( rule__IntLiteral__Group__0 )
            {
             before(grammarAccess.getIntLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:420:1: ( rule__IntLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:420:2: rule__IntLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral821);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:432:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:433:1: ( ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:434:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral848);
            ruleStringLiteral();

            state._fsp--;

             after(grammarAccess.getStringLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral855); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:441:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:445:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:446:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:446:1: ( ( rule__StringLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:447:1: ( rule__StringLiteral__Group__0 )
            {
             before(grammarAccess.getStringLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:448:1: ( rule__StringLiteral__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:448:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral881);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:460:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:461:1: ( ruleInteger EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:462:1: ruleInteger EOF
            {
             before(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger908);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger915); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:469:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:473:2: ( ( ( rule__Integer__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:474:1: ( ( rule__Integer__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:474:1: ( ( rule__Integer__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:475:1: ( rule__Integer__Alternatives )
            {
             before(grammarAccess.getIntegerAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:476:1: ( rule__Integer__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:476:2: rule__Integer__Alternatives
            {
            pushFollow(FOLLOW_rule__Integer__Alternatives_in_ruleInteger941);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:488:1: entryRuleSignedInteger : ruleSignedInteger EOF ;
    public final void entryRuleSignedInteger() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:492:1: ( ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:493:1: ruleSignedInteger EOF
            {
             before(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger973);
            ruleSignedInteger();

            state._fsp--;

             after(grammarAccess.getSignedIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger980); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:503:1: ruleSignedInteger : ( ( rule__SignedInteger__Group__0 ) ) ;
    public final void ruleSignedInteger() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:508:2: ( ( ( rule__SignedInteger__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:509:1: ( ( rule__SignedInteger__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:509:1: ( ( rule__SignedInteger__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:510:1: ( rule__SignedInteger__Group__0 )
            {
             before(grammarAccess.getSignedIntegerAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:511:1: ( rule__SignedInteger__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:511:2: rule__SignedInteger__Group__0
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger1010);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:524:1: entryRuleHexadecimal : ruleHexadecimal EOF ;
    public final void entryRuleHexadecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:528:1: ( ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:529:1: ruleHexadecimal EOF
            {
             before(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal1042);
            ruleHexadecimal();

            state._fsp--;

             after(grammarAccess.getHexadecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal1049); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:539:1: ruleHexadecimal : ( RULE_HEX ) ;
    public final void ruleHexadecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:544:2: ( ( RULE_HEX ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:545:1: ( RULE_HEX )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:545:1: ( RULE_HEX )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:546:1: RULE_HEX
            {
             before(grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 
            match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal1079); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:560:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:561:1: ( ruleReal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:562:1: ruleReal EOF
            {
             before(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal1105);
            ruleReal();

            state._fsp--;

             after(grammarAccess.getRealRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal1112); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:569:1: ruleReal : ( ( rule__Real__Alternatives ) ) ;
    public final void ruleReal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:573:2: ( ( ( rule__Real__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:574:1: ( ( rule__Real__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:574:1: ( ( rule__Real__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:575:1: ( rule__Real__Alternatives )
            {
             before(grammarAccess.getRealAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:576:1: ( rule__Real__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:576:2: rule__Real__Alternatives
            {
            pushFollow(FOLLOW_rule__Real__Alternatives_in_ruleReal1138);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:588:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:592:1: ( ruleDecimal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:593:1: ruleDecimal EOF
            {
             before(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal1170);
            ruleDecimal();

            state._fsp--;

             after(grammarAccess.getDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal1177); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:603:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:608:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:609:1: ( ( rule__Decimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:609:1: ( ( rule__Decimal__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:610:1: ( rule__Decimal__Group__0 )
            {
             before(grammarAccess.getDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:611:1: ( rule__Decimal__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:611:2: rule__Decimal__Group__0
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1207);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:624:1: entryRuleDotDecimal : ruleDotDecimal EOF ;
    public final void entryRuleDotDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:628:1: ( ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:629:1: ruleDotDecimal EOF
            {
             before(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1239);
            ruleDotDecimal();

            state._fsp--;

             after(grammarAccess.getDotDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal1246); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:639:1: ruleDotDecimal : ( ( rule__DotDecimal__Group__0 ) ) ;
    public final void ruleDotDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:644:2: ( ( ( rule__DotDecimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:645:1: ( ( rule__DotDecimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:645:1: ( ( rule__DotDecimal__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:646:1: ( rule__DotDecimal__Group__0 )
            {
             before(grammarAccess.getDotDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:647:1: ( rule__DotDecimal__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:647:2: rule__DotDecimal__Group__0
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1276);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:660:1: entryRuleDecimalDot : ruleDecimalDot EOF ;
    public final void entryRuleDecimalDot() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:664:1: ( ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:665:1: ruleDecimalDot EOF
            {
             before(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1308);
            ruleDecimalDot();

            state._fsp--;

             after(grammarAccess.getDecimalDotRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot1315); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:675:1: ruleDecimalDot : ( ( rule__DecimalDot__Group__0 ) ) ;
    public final void ruleDecimalDot() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:680:2: ( ( ( rule__DecimalDot__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:681:1: ( ( rule__DecimalDot__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:681:1: ( ( rule__DecimalDot__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:682:1: ( rule__DecimalDot__Group__0 )
            {
             before(grammarAccess.getDecimalDotAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:683:1: ( rule__DecimalDot__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:683:2: rule__DecimalDot__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1345);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:696:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:700:1: ( ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:701:1: ruleDecimalExp EOF
            {
             before(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1377);
            ruleDecimalExp();

            state._fsp--;

             after(grammarAccess.getDecimalExpRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp1384); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:711:1: ruleDecimalExp : ( ( rule__DecimalExp__Group__0 ) ) ;
    public final void ruleDecimalExp() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:716:2: ( ( ( rule__DecimalExp__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:717:1: ( ( rule__DecimalExp__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:717:1: ( ( rule__DecimalExp__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:718:1: ( rule__DecimalExp__Group__0 )
            {
             before(grammarAccess.getDecimalExpAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:719:1: ( rule__DecimalExp__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:719:2: rule__DecimalExp__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1414);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:732:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:733:1: ( ruleFQN EOF )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:734:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1441);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1448); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:741:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:745:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:746:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:746:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:747:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:748:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:748:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN1474);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:761:1: ruleLiteralType : ( ( rule__LiteralType__Alternatives ) ) ;
    public final void ruleLiteralType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:765:1: ( ( ( rule__LiteralType__Alternatives ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:766:1: ( ( rule__LiteralType__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:766:1: ( ( rule__LiteralType__Alternatives ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:767:1: ( rule__LiteralType__Alternatives )
            {
             before(grammarAccess.getLiteralTypeAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:768:1: ( rule__LiteralType__Alternatives )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:768:2: rule__LiteralType__Alternatives
            {
            pushFollow(FOLLOW_rule__LiteralType__Alternatives_in_ruleLiteralType1511);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:780:1: rule__AnnotationAttribute__Alternatives : ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) );
    public final void rule__AnnotationAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:784:1: ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==34) ) {
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:785:1: ( ruleSimpleAnnotationAttribute )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:785:1: ( ruleSimpleAnnotationAttribute )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:786:1: ruleSimpleAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1547);
                    ruleSimpleAnnotationAttribute();

                    state._fsp--;

                     after(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:791:6: ( ruleEnumAnnotationAttribute )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:791:6: ( ruleEnumAnnotationAttribute )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:792:1: ruleEnumAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1564);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:802:1: rule__SimpleAnnotationAttribute__Alternatives_0 : ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__SimpleAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:806:1: ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==34) ) {
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:807:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:807:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:808:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:809:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:809:2: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__OptionalAssignment_0_0_in_rule__SimpleAnnotationAttribute__Alternatives_01596);
                    rule__SimpleAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:813:6: ( 'mandatory' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:813:6: ( 'mandatory' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:814:1: 'mandatory'
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__SimpleAnnotationAttribute__Alternatives_01615); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:826:1: rule__EnumAnnotationAttribute__Alternatives_0 : ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__EnumAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:830:1: ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==34) ) {
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:831:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:831:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:832:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:833:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:833:2: rule__EnumAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__EnumAnnotationAttribute__OptionalAssignment_0_0_in_rule__EnumAnnotationAttribute__Alternatives_01649);
                    rule__EnumAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:837:6: ( 'mandatory' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:837:6: ( 'mandatory' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:838:1: 'mandatory'
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__EnumAnnotationAttribute__Alternatives_01668); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:852:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:856:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 14:
            case 35:
                {
                alt4=1;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case 15:
            case 16:
            case 33:
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:857:1: ( ruleBooleanLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:857:1: ( ruleBooleanLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:858:1: ruleBooleanLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives1704);
                    ruleBooleanLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:863:6: ( ruleNumberLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:863:6: ( ruleNumberLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:864:1: ruleNumberLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives1721);
                    ruleNumberLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:869:6: ( ruleStringLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:869:6: ( ruleStringLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:870:1: ruleStringLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives1738);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:880:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:884:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            else if ( (LA5_0==35) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:885:1: ( 'false' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:885:1: ( 'false' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:886:1: 'false'
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    match(input,14,FOLLOW_14_in_rule__BooleanLiteral__Alternatives_11771); 
                     after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:893:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:893:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:894:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:895:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:895:2: rule__BooleanLiteral__IsTrueAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_11790);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:904:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:908:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
            int alt6=2;
            switch ( input.LA(1) ) {
            case 15:
                {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_INT) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==33) ) {
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
                else if ( (LA6_1==33) ) {
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

                    if ( (LA6_3==33) ) {
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
                else if ( (LA6_2==33) ) {
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

                if ( (LA6_3==33) ) {
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
            case 33:
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:909:1: ( ruleIntLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:909:1: ( ruleIntLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:910:1: ruleIntLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives1823);
                    ruleIntLiteral();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:915:6: ( ruleRealLiteral )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:915:6: ( ruleRealLiteral )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:916:1: ruleRealLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives1840);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:926:1: rule__Integer__Alternatives : ( ( ruleSignedInteger ) | ( ruleHexadecimal ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:930:1: ( ( ruleSignedInteger ) | ( ruleHexadecimal ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:931:1: ( ruleSignedInteger )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:931:1: ( ruleSignedInteger )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:932:1: ruleSignedInteger
                    {
                     before(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives1872);
                    ruleSignedInteger();

                    state._fsp--;

                     after(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:937:6: ( ruleHexadecimal )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:937:6: ( ruleHexadecimal )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:938:1: ruleHexadecimal
                    {
                     before(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives1889);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:948:1: rule__SignedInteger__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__SignedInteger__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:952:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:953:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:953:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:954:1: '+'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__SignedInteger__Alternatives_01922); 
                     after(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:961:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:961:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:962:1: '-'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__SignedInteger__Alternatives_01942); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:974:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:978:1: ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) )
            int alt9=4;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:979:1: ( ruleDecimal )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:979:1: ( ruleDecimal )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:980:1: ruleDecimal
                    {
                     before(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDecimal_in_rule__Real__Alternatives1976);
                    ruleDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:985:6: ( ruleDotDecimal )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:985:6: ( ruleDotDecimal )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:986:1: ruleDotDecimal
                    {
                     before(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives1993);
                    ruleDotDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:991:6: ( ruleDecimalDot )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:991:6: ( ruleDecimalDot )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:992:1: ruleDecimalDot
                    {
                     before(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives2010);
                    ruleDecimalDot();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:997:6: ( ruleDecimalExp )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:997:6: ( ruleDecimalExp )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:998:1: ruleDecimalExp
                    {
                     before(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives2027);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1008:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1012:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1013:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1013:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1014:1: '+'
                    {
                     before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__Decimal__Alternatives_02060); 
                     after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1021:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1021:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1022:1: '-'
                    {
                     before(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__Decimal__Alternatives_02080); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1034:1: rule__DotDecimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DotDecimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1038:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1039:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1039:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1040:1: '+'
                    {
                     before(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__DotDecimal__Alternatives_02115); 
                     after(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1047:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1047:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1048:1: '-'
                    {
                     before(grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__DotDecimal__Alternatives_02135); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1060:1: rule__DecimalDot__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalDot__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1064:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1065:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1065:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1066:1: '+'
                    {
                     before(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__DecimalDot__Alternatives_02170); 
                     after(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1073:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1073:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1074:1: '-'
                    {
                     before(grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__DecimalDot__Alternatives_02190); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1086:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1090:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1091:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1091:1: ( '+' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1092:1: '+'
                    {
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__DecimalExp__Alternatives_02225); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1099:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1099:6: ( '-' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1100:1: '-'
                    {
                     before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__DecimalExp__Alternatives_02245); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1112:1: rule__LiteralType__Alternatives : ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) );
    public final void rule__LiteralType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1116:1: ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) )
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
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1117:1: ( ( 'ptBoolean' ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1117:1: ( ( 'ptBoolean' ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1118:1: ( 'ptBoolean' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1119:1: ( 'ptBoolean' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1119:3: 'ptBoolean'
                    {
                    match(input,17,FOLLOW_17_in_rule__LiteralType__Alternatives2280); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1124:6: ( ( 'ptInteger' ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1124:6: ( ( 'ptInteger' ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1125:1: ( 'ptInteger' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1126:1: ( 'ptInteger' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1126:3: 'ptInteger'
                    {
                    match(input,18,FOLLOW_18_in_rule__LiteralType__Alternatives2301); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1131:6: ( ( 'ptReal' ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1131:6: ( ( 'ptReal' ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1132:1: ( 'ptReal' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1133:1: ( 'ptReal' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1133:3: 'ptReal'
                    {
                    match(input,19,FOLLOW_19_in_rule__LiteralType__Alternatives2322); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1138:6: ( ( 'ptCharacter' ) )
                    {
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1138:6: ( ( 'ptCharacter' ) )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1139:1: ( 'ptCharacter' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1140:1: ( 'ptCharacter' )
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1140:3: 'ptCharacter'
                    {
                    match(input,20,FOLLOW_20_in_rule__LiteralType__Alternatives2343); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1152:1: rule__Annotation__Group__0 : rule__Annotation__Group__0__Impl rule__Annotation__Group__1 ;
    public final void rule__Annotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1156:1: ( rule__Annotation__Group__0__Impl rule__Annotation__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1157:2: rule__Annotation__Group__0__Impl rule__Annotation__Group__1
            {
            pushFollow(FOLLOW_rule__Annotation__Group__0__Impl_in_rule__Annotation__Group__02376);
            rule__Annotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group__1_in_rule__Annotation__Group__02379);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1164:1: rule__Annotation__Group__0__Impl : ( '@' ) ;
    public final void rule__Annotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1168:1: ( ( '@' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1169:1: ( '@' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1169:1: ( '@' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1170:1: '@'
            {
             before(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__Annotation__Group__0__Impl2407); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1183:1: rule__Annotation__Group__1 : rule__Annotation__Group__1__Impl rule__Annotation__Group__2 ;
    public final void rule__Annotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1187:1: ( rule__Annotation__Group__1__Impl rule__Annotation__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1188:2: rule__Annotation__Group__1__Impl rule__Annotation__Group__2
            {
            pushFollow(FOLLOW_rule__Annotation__Group__1__Impl_in_rule__Annotation__Group__12438);
            rule__Annotation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group__2_in_rule__Annotation__Group__12441);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1195:1: rule__Annotation__Group__1__Impl : ( ( rule__Annotation__TypeAssignment_1 ) ) ;
    public final void rule__Annotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1199:1: ( ( ( rule__Annotation__TypeAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1200:1: ( ( rule__Annotation__TypeAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1200:1: ( ( rule__Annotation__TypeAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1201:1: ( rule__Annotation__TypeAssignment_1 )
            {
             before(grammarAccess.getAnnotationAccess().getTypeAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1202:1: ( rule__Annotation__TypeAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1202:2: rule__Annotation__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__Annotation__TypeAssignment_1_in_rule__Annotation__Group__1__Impl2468);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1212:1: rule__Annotation__Group__2 : rule__Annotation__Group__2__Impl ;
    public final void rule__Annotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1216:1: ( rule__Annotation__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1217:2: rule__Annotation__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Annotation__Group__2__Impl_in_rule__Annotation__Group__22498);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1223:1: rule__Annotation__Group__2__Impl : ( ( rule__Annotation__Group_2__0 )? ) ;
    public final void rule__Annotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1227:1: ( ( ( rule__Annotation__Group_2__0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1228:1: ( ( rule__Annotation__Group_2__0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1228:1: ( ( rule__Annotation__Group_2__0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1229:1: ( rule__Annotation__Group_2__0 )?
            {
             before(grammarAccess.getAnnotationAccess().getGroup_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1230:1: ( rule__Annotation__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1230:2: rule__Annotation__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Annotation__Group_2__0_in_rule__Annotation__Group__2__Impl2525);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1246:1: rule__Annotation__Group_2__0 : rule__Annotation__Group_2__0__Impl rule__Annotation__Group_2__1 ;
    public final void rule__Annotation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1250:1: ( rule__Annotation__Group_2__0__Impl rule__Annotation__Group_2__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1251:2: rule__Annotation__Group_2__0__Impl rule__Annotation__Group_2__1
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2__0__Impl_in_rule__Annotation__Group_2__02562);
            rule__Annotation__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group_2__1_in_rule__Annotation__Group_2__02565);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1258:1: rule__Annotation__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Annotation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1262:1: ( ( '(' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1263:1: ( '(' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1263:1: ( '(' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1264:1: '('
            {
             before(grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,22,FOLLOW_22_in_rule__Annotation__Group_2__0__Impl2593); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1277:1: rule__Annotation__Group_2__1 : rule__Annotation__Group_2__1__Impl rule__Annotation__Group_2__2 ;
    public final void rule__Annotation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1281:1: ( rule__Annotation__Group_2__1__Impl rule__Annotation__Group_2__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1282:2: rule__Annotation__Group_2__1__Impl rule__Annotation__Group_2__2
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2__1__Impl_in_rule__Annotation__Group_2__12624);
            rule__Annotation__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group_2__2_in_rule__Annotation__Group_2__12627);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1289:1: rule__Annotation__Group_2__1__Impl : ( ( rule__Annotation__AttributesAssignment_2_1 ) ) ;
    public final void rule__Annotation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1293:1: ( ( ( rule__Annotation__AttributesAssignment_2_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1294:1: ( ( rule__Annotation__AttributesAssignment_2_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1294:1: ( ( rule__Annotation__AttributesAssignment_2_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1295:1: ( rule__Annotation__AttributesAssignment_2_1 )
            {
             before(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1296:1: ( rule__Annotation__AttributesAssignment_2_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1296:2: rule__Annotation__AttributesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Annotation__AttributesAssignment_2_1_in_rule__Annotation__Group_2__1__Impl2654);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1306:1: rule__Annotation__Group_2__2 : rule__Annotation__Group_2__2__Impl rule__Annotation__Group_2__3 ;
    public final void rule__Annotation__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1310:1: ( rule__Annotation__Group_2__2__Impl rule__Annotation__Group_2__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1311:2: rule__Annotation__Group_2__2__Impl rule__Annotation__Group_2__3
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2__2__Impl_in_rule__Annotation__Group_2__22684);
            rule__Annotation__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group_2__3_in_rule__Annotation__Group_2__22687);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1318:1: rule__Annotation__Group_2__2__Impl : ( ( rule__Annotation__Group_2_2__0 )* ) ;
    public final void rule__Annotation__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1322:1: ( ( ( rule__Annotation__Group_2_2__0 )* ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1323:1: ( ( rule__Annotation__Group_2_2__0 )* )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1323:1: ( ( rule__Annotation__Group_2_2__0 )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1324:1: ( rule__Annotation__Group_2_2__0 )*
            {
             before(grammarAccess.getAnnotationAccess().getGroup_2_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1325:1: ( rule__Annotation__Group_2_2__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==24) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1325:2: rule__Annotation__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Annotation__Group_2_2__0_in_rule__Annotation__Group_2__2__Impl2714);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1335:1: rule__Annotation__Group_2__3 : rule__Annotation__Group_2__3__Impl ;
    public final void rule__Annotation__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1339:1: ( rule__Annotation__Group_2__3__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1340:2: rule__Annotation__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2__3__Impl_in_rule__Annotation__Group_2__32745);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1346:1: rule__Annotation__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Annotation__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1350:1: ( ( ')' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1351:1: ( ')' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1351:1: ( ')' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1352:1: ')'
            {
             before(grammarAccess.getAnnotationAccess().getRightParenthesisKeyword_2_3()); 
            match(input,23,FOLLOW_23_in_rule__Annotation__Group_2__3__Impl2773); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1373:1: rule__Annotation__Group_2_2__0 : rule__Annotation__Group_2_2__0__Impl rule__Annotation__Group_2_2__1 ;
    public final void rule__Annotation__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1377:1: ( rule__Annotation__Group_2_2__0__Impl rule__Annotation__Group_2_2__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1378:2: rule__Annotation__Group_2_2__0__Impl rule__Annotation__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2_2__0__Impl_in_rule__Annotation__Group_2_2__02812);
            rule__Annotation__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Annotation__Group_2_2__1_in_rule__Annotation__Group_2_2__02815);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1385:1: rule__Annotation__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Annotation__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1389:1: ( ( ',' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1390:1: ( ',' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1390:1: ( ',' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1391:1: ','
            {
             before(grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0()); 
            match(input,24,FOLLOW_24_in_rule__Annotation__Group_2_2__0__Impl2843); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1404:1: rule__Annotation__Group_2_2__1 : rule__Annotation__Group_2_2__1__Impl ;
    public final void rule__Annotation__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1408:1: ( rule__Annotation__Group_2_2__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1409:2: rule__Annotation__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Annotation__Group_2_2__1__Impl_in_rule__Annotation__Group_2_2__12874);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1415:1: rule__Annotation__Group_2_2__1__Impl : ( ( rule__Annotation__AttributesAssignment_2_2_1 ) ) ;
    public final void rule__Annotation__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1419:1: ( ( ( rule__Annotation__AttributesAssignment_2_2_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1420:1: ( ( rule__Annotation__AttributesAssignment_2_2_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1420:1: ( ( rule__Annotation__AttributesAssignment_2_2_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1421:1: ( rule__Annotation__AttributesAssignment_2_2_1 )
            {
             before(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_2_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1422:1: ( rule__Annotation__AttributesAssignment_2_2_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1422:2: rule__Annotation__AttributesAssignment_2_2_1
            {
            pushFollow(FOLLOW_rule__Annotation__AttributesAssignment_2_2_1_in_rule__Annotation__Group_2_2__1__Impl2901);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1436:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1440:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1441:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__0__Impl_in_rule__KeyValue__Group__02935);
            rule__KeyValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeyValue__Group__1_in_rule__KeyValue__Group__02938);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1448:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1452:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1453:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1453:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1454:1: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1455:1: ( rule__KeyValue__KeyAssignment_0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1455:2: rule__KeyValue__KeyAssignment_0
            {
            pushFollow(FOLLOW_rule__KeyValue__KeyAssignment_0_in_rule__KeyValue__Group__0__Impl2965);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1465:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1469:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1470:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__1__Impl_in_rule__KeyValue__Group__12995);
            rule__KeyValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeyValue__Group__2_in_rule__KeyValue__Group__12998);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1477:1: rule__KeyValue__Group__1__Impl : ( '=' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1481:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1482:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1482:1: ( '=' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1483:1: '='
            {
             before(grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1()); 
            match(input,25,FOLLOW_25_in_rule__KeyValue__Group__1__Impl3026); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1496:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1500:1: ( rule__KeyValue__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1501:2: rule__KeyValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__2__Impl_in_rule__KeyValue__Group__23057);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1507:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1511:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1512:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1512:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1513:1: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1514:1: ( rule__KeyValue__ValueAssignment_2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1514:2: rule__KeyValue__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__KeyValue__ValueAssignment_2_in_rule__KeyValue__Group__2__Impl3084);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1533:1: rule__SimpleAnnotationAttribute__Group__0 : rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 ;
    public final void rule__SimpleAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1537:1: ( rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1538:2: rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__0__Impl_in_rule__SimpleAnnotationAttribute__Group__03123);
            rule__SimpleAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__1_in_rule__SimpleAnnotationAttribute__Group__03126);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1545:1: rule__SimpleAnnotationAttribute__Group__0__Impl : ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1549:1: ( ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1550:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1550:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1551:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1552:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1552:2: rule__SimpleAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Alternatives_0_in_rule__SimpleAnnotationAttribute__Group__0__Impl3153);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1562:1: rule__SimpleAnnotationAttribute__Group__1 : rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 ;
    public final void rule__SimpleAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1566:1: ( rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1567:2: rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__1__Impl_in_rule__SimpleAnnotationAttribute__Group__13183);
            rule__SimpleAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__2_in_rule__SimpleAnnotationAttribute__Group__13186);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1574:1: rule__SimpleAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1578:1: ( ( 'attribute' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1579:1: ( 'attribute' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1579:1: ( 'attribute' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1580:1: 'attribute'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__SimpleAnnotationAttribute__Group__1__Impl3214); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1593:1: rule__SimpleAnnotationAttribute__Group__2 : rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 ;
    public final void rule__SimpleAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1597:1: ( rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1598:2: rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__2__Impl_in_rule__SimpleAnnotationAttribute__Group__23245);
            rule__SimpleAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__3_in_rule__SimpleAnnotationAttribute__Group__23248);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1605:1: rule__SimpleAnnotationAttribute__Group__2__Impl : ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1609:1: ( ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1610:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1610:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1611:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1612:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1612:2: rule__SimpleAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__NameAssignment_2_in_rule__SimpleAnnotationAttribute__Group__2__Impl3275);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1622:1: rule__SimpleAnnotationAttribute__Group__3 : rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 ;
    public final void rule__SimpleAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1626:1: ( rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1627:2: rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__3__Impl_in_rule__SimpleAnnotationAttribute__Group__33305);
            rule__SimpleAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__4_in_rule__SimpleAnnotationAttribute__Group__33308);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1634:1: rule__SimpleAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1638:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1639:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1639:1: ( ':' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1640:1: ':'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,27,FOLLOW_27_in_rule__SimpleAnnotationAttribute__Group__3__Impl3336); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1653:1: rule__SimpleAnnotationAttribute__Group__4 : rule__SimpleAnnotationAttribute__Group__4__Impl ;
    public final void rule__SimpleAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1657:1: ( rule__SimpleAnnotationAttribute__Group__4__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1658:2: rule__SimpleAnnotationAttribute__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__4__Impl_in_rule__SimpleAnnotationAttribute__Group__43367);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1664:1: rule__SimpleAnnotationAttribute__Group__4__Impl : ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1668:1: ( ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1669:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1669:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1670:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1671:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1671:2: rule__SimpleAnnotationAttribute__TypeAssignment_4
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__TypeAssignment_4_in_rule__SimpleAnnotationAttribute__Group__4__Impl3394);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1691:1: rule__EnumAnnotationAttribute__Group__0 : rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 ;
    public final void rule__EnumAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1695:1: ( rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1696:2: rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__0__Impl_in_rule__EnumAnnotationAttribute__Group__03434);
            rule__EnumAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__1_in_rule__EnumAnnotationAttribute__Group__03437);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1703:1: rule__EnumAnnotationAttribute__Group__0__Impl : ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1707:1: ( ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1708:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1708:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1709:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1710:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1710:2: rule__EnumAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Alternatives_0_in_rule__EnumAnnotationAttribute__Group__0__Impl3464);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1720:1: rule__EnumAnnotationAttribute__Group__1 : rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 ;
    public final void rule__EnumAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1724:1: ( rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1725:2: rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__1__Impl_in_rule__EnumAnnotationAttribute__Group__13494);
            rule__EnumAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__2_in_rule__EnumAnnotationAttribute__Group__13497);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1732:1: rule__EnumAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__EnumAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1736:1: ( ( 'attribute' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1737:1: ( 'attribute' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1737:1: ( 'attribute' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1738:1: 'attribute'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__EnumAnnotationAttribute__Group__1__Impl3525); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1751:1: rule__EnumAnnotationAttribute__Group__2 : rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 ;
    public final void rule__EnumAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1755:1: ( rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1756:2: rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__2__Impl_in_rule__EnumAnnotationAttribute__Group__23556);
            rule__EnumAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__3_in_rule__EnumAnnotationAttribute__Group__23559);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1763:1: rule__EnumAnnotationAttribute__Group__2__Impl : ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1767:1: ( ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1768:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1768:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1769:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1770:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1770:2: rule__EnumAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__NameAssignment_2_in_rule__EnumAnnotationAttribute__Group__2__Impl3586);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1780:1: rule__EnumAnnotationAttribute__Group__3 : rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 ;
    public final void rule__EnumAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1784:1: ( rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1785:2: rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__3__Impl_in_rule__EnumAnnotationAttribute__Group__33616);
            rule__EnumAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__4_in_rule__EnumAnnotationAttribute__Group__33619);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1792:1: rule__EnumAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1796:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1797:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1797:1: ( ':' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1798:1: ':'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,27,FOLLOW_27_in_rule__EnumAnnotationAttribute__Group__3__Impl3647); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1811:1: rule__EnumAnnotationAttribute__Group__4 : rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 ;
    public final void rule__EnumAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1815:1: ( rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1816:2: rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__4__Impl_in_rule__EnumAnnotationAttribute__Group__43678);
            rule__EnumAnnotationAttribute__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__5_in_rule__EnumAnnotationAttribute__Group__43681);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1823:1: rule__EnumAnnotationAttribute__Group__4__Impl : ( '{' ) ;
    public final void rule__EnumAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1827:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1828:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1828:1: ( '{' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1829:1: '{'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__EnumAnnotationAttribute__Group__4__Impl3709); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1842:1: rule__EnumAnnotationAttribute__Group__5 : rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 ;
    public final void rule__EnumAnnotationAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1846:1: ( rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1847:2: rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__5__Impl_in_rule__EnumAnnotationAttribute__Group__53740);
            rule__EnumAnnotationAttribute__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__6_in_rule__EnumAnnotationAttribute__Group__53743);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1854:1: rule__EnumAnnotationAttribute__Group__5__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1858:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1859:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1859:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1860:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1861:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1861:2: rule__EnumAnnotationAttribute__ValuesAssignment_5
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_5_in_rule__EnumAnnotationAttribute__Group__5__Impl3770);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1871:1: rule__EnumAnnotationAttribute__Group__6 : rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 ;
    public final void rule__EnumAnnotationAttribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1875:1: ( rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1876:2: rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__6__Impl_in_rule__EnumAnnotationAttribute__Group__63800);
            rule__EnumAnnotationAttribute__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__7_in_rule__EnumAnnotationAttribute__Group__63803);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1883:1: rule__EnumAnnotationAttribute__Group__6__Impl : ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) ;
    public final void rule__EnumAnnotationAttribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1887:1: ( ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1888:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1888:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1889:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1890:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==24) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1890:2: rule__EnumAnnotationAttribute__Group_6__0
            	    {
            	    pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__0_in_rule__EnumAnnotationAttribute__Group__6__Impl3830);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1900:1: rule__EnumAnnotationAttribute__Group__7 : rule__EnumAnnotationAttribute__Group__7__Impl ;
    public final void rule__EnumAnnotationAttribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1904:1: ( rule__EnumAnnotationAttribute__Group__7__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1905:2: rule__EnumAnnotationAttribute__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__7__Impl_in_rule__EnumAnnotationAttribute__Group__73861);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1911:1: rule__EnumAnnotationAttribute__Group__7__Impl : ( '}' ) ;
    public final void rule__EnumAnnotationAttribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1915:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1916:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1916:1: ( '}' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1917:1: '}'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7()); 
            match(input,29,FOLLOW_29_in_rule__EnumAnnotationAttribute__Group__7__Impl3889); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1946:1: rule__EnumAnnotationAttribute__Group_6__0 : rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 ;
    public final void rule__EnumAnnotationAttribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1950:1: ( rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1951:2: rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__0__Impl_in_rule__EnumAnnotationAttribute__Group_6__03936);
            rule__EnumAnnotationAttribute__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__1_in_rule__EnumAnnotationAttribute__Group_6__03939);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1958:1: rule__EnumAnnotationAttribute__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1962:1: ( ( ',' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1963:1: ( ',' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1963:1: ( ',' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1964:1: ','
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0()); 
            match(input,24,FOLLOW_24_in_rule__EnumAnnotationAttribute__Group_6__0__Impl3967); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1977:1: rule__EnumAnnotationAttribute__Group_6__1 : rule__EnumAnnotationAttribute__Group_6__1__Impl ;
    public final void rule__EnumAnnotationAttribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1981:1: ( rule__EnumAnnotationAttribute__Group_6__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1982:2: rule__EnumAnnotationAttribute__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__1__Impl_in_rule__EnumAnnotationAttribute__Group_6__13998);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1988:1: rule__EnumAnnotationAttribute__Group_6__1__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1992:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1993:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1993:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1994:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1995:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:1995:2: rule__EnumAnnotationAttribute__ValuesAssignment_6_1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_6_1_in_rule__EnumAnnotationAttribute__Group_6__1__Impl4025);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2011:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2015:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2016:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__04061);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__04064);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2023:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2027:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2028:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2028:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2029:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl4091);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2040:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2044:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2045:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__14120);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2051:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2055:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2056:1: ( ( '.*' )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2056:1: ( ( '.*' )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2057:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2058:1: ( '.*' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==30) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2059:2: '.*'
                    {
                    match(input,30,FOLLOW_30_in_rule__ImportedFQN__Group__1__Impl4149); 

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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2074:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2078:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2079:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__04186);
            rule__Documentation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__04189);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2086:1: rule__Documentation__Group__0__Impl : ( () ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2090:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2091:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2091:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2092:1: ()
            {
             before(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2093:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2095:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2105:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2109:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2110:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
            {
            pushFollow(FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__14247);
            rule__Documentation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__14250);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2117:1: rule__Documentation__Group__1__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2121:1: ( ( '[' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2122:1: ( '[' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2122:1: ( '[' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2123:1: '['
            {
             before(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1()); 
            match(input,31,FOLLOW_31_in_rule__Documentation__Group__1__Impl4278); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2136:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl rule__Documentation__Group__3 ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2140:1: ( rule__Documentation__Group__2__Impl rule__Documentation__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2141:2: rule__Documentation__Group__2__Impl rule__Documentation__Group__3
            {
            pushFollow(FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__24309);
            rule__Documentation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__3_in_rule__Documentation__Group__24312);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2148:1: rule__Documentation__Group__2__Impl : ( ( rule__Documentation__LinesAssignment_2 )* ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2152:1: ( ( ( rule__Documentation__LinesAssignment_2 )* ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2153:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2153:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2154:1: ( rule__Documentation__LinesAssignment_2 )*
            {
             before(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2155:1: ( rule__Documentation__LinesAssignment_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_STRING) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2155:2: rule__Documentation__LinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Documentation__LinesAssignment_2_in_rule__Documentation__Group__2__Impl4339);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2165:1: rule__Documentation__Group__3 : rule__Documentation__Group__3__Impl ;
    public final void rule__Documentation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2169:1: ( rule__Documentation__Group__3__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2170:2: rule__Documentation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Documentation__Group__3__Impl_in_rule__Documentation__Group__34370);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2176:1: rule__Documentation__Group__3__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2180:1: ( ( ']' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2181:1: ( ']' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2181:1: ( ']' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2182:1: ']'
            {
             before(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__Documentation__Group__3__Impl4398); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2209:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2213:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2214:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__04443);
            rule__BooleanLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__04446);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2221:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2225:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2226:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2226:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2227:1: ()
            {
             before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2228:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2230:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2240:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2244:1: ( rule__BooleanLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2245:2: rule__BooleanLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__14504);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2251:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2255:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2256:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2256:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2257:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2258:1: ( rule__BooleanLiteral__Alternatives_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2258:2: rule__BooleanLiteral__Alternatives_1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl4531);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2272:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2276:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2277:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__04565);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__04568);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2284:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2288:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2289:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2289:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2290:1: ()
            {
             before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2291:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2293:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2303:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2307:1: ( rule__RealLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2308:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__14626);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2314:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2318:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2319:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2319:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2320:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2321:1: ( rule__RealLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2321:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl4653);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2335:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2339:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2340:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__04687);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__04690);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2347:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2351:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2352:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2352:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2353:1: ()
            {
             before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2354:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2356:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2366:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2370:1: ( rule__IntLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2371:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__14748);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2377:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2381:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2382:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2382:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2383:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2384:1: ( rule__IntLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2384:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl4775);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2398:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2402:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2403:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__04809);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__04812);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2410:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2414:1: ( ( () ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2415:1: ( () )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2415:1: ( () )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2416:1: ()
            {
             before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2417:1: ()
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2419:1: 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2429:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2433:1: ( rule__StringLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2434:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__14870);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2440:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2444:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2445:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2445:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2446:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2447:1: ( rule__StringLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2447:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl4897);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2461:1: rule__SignedInteger__Group__0 : rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 ;
    public final void rule__SignedInteger__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2465:1: ( rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2466:2: rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__04931);
            rule__SignedInteger__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__04934);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2473:1: rule__SignedInteger__Group__0__Impl : ( ( rule__SignedInteger__Alternatives_0 )? ) ;
    public final void rule__SignedInteger__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2477:1: ( ( ( rule__SignedInteger__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2478:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2478:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2479:1: ( rule__SignedInteger__Alternatives_0 )?
            {
             before(grammarAccess.getSignedIntegerAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2480:1: ( rule__SignedInteger__Alternatives_0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=15 && LA20_0<=16)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2480:2: rule__SignedInteger__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl4961);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2490:1: rule__SignedInteger__Group__1 : rule__SignedInteger__Group__1__Impl ;
    public final void rule__SignedInteger__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2494:1: ( rule__SignedInteger__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2495:2: rule__SignedInteger__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__14992);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2501:1: rule__SignedInteger__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__SignedInteger__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2505:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2506:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2506:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2507:1: RULE_INT
            {
             before(grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl5019); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2522:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2526:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2527:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__05052);
            rule__Decimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__05055);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2534:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2538:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2539:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2539:1: ( ( rule__Decimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2540:1: ( rule__Decimal__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2541:1: ( rule__Decimal__Alternatives_0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=15 && LA21_0<=16)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2541:2: rule__Decimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl5082);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2551:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2555:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2556:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__15113);
            rule__Decimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__15116);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2563:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2567:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2568:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2568:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2569:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl5143); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2580:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2584:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2585:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
            {
            pushFollow(FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__25172);
            rule__Decimal__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__25175);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2592:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2596:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2597:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2597:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2598:1: '.'
            {
             before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            match(input,33,FOLLOW_33_in_rule__Decimal__Group__2__Impl5203); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2611:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2615:1: ( rule__Decimal__Group__3__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2616:2: rule__Decimal__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__35234);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2622:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2626:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2627:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2627:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2628:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl5261); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2647:1: rule__DotDecimal__Group__0 : rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 ;
    public final void rule__DotDecimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2651:1: ( rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2652:2: rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__05298);
            rule__DotDecimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__05301);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2659:1: rule__DotDecimal__Group__0__Impl : ( ( rule__DotDecimal__Alternatives_0 )? ) ;
    public final void rule__DotDecimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2663:1: ( ( ( rule__DotDecimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2664:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2664:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2665:1: ( rule__DotDecimal__Alternatives_0 )?
            {
             before(grammarAccess.getDotDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2666:1: ( rule__DotDecimal__Alternatives_0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=15 && LA22_0<=16)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2666:2: rule__DotDecimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl5328);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2676:1: rule__DotDecimal__Group__1 : rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 ;
    public final void rule__DotDecimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2680:1: ( rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2681:2: rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__15359);
            rule__DotDecimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__15362);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2688:1: rule__DotDecimal__Group__1__Impl : ( '.' ) ;
    public final void rule__DotDecimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2692:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2693:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2693:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2694:1: '.'
            {
             before(grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__DotDecimal__Group__1__Impl5390); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2707:1: rule__DotDecimal__Group__2 : rule__DotDecimal__Group__2__Impl ;
    public final void rule__DotDecimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2711:1: ( rule__DotDecimal__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2712:2: rule__DotDecimal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__25421);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2718:1: rule__DotDecimal__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DotDecimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2722:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2723:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2723:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2724:1: RULE_INT
            {
             before(grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl5448); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2741:1: rule__DecimalDot__Group__0 : rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 ;
    public final void rule__DecimalDot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2745:1: ( rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2746:2: rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__05483);
            rule__DecimalDot__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__05486);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2753:1: rule__DecimalDot__Group__0__Impl : ( ( rule__DecimalDot__Alternatives_0 )? ) ;
    public final void rule__DecimalDot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2757:1: ( ( ( rule__DecimalDot__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2758:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2758:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2759:1: ( rule__DecimalDot__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalDotAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2760:1: ( rule__DecimalDot__Alternatives_0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=15 && LA23_0<=16)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2760:2: rule__DecimalDot__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl5513);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2770:1: rule__DecimalDot__Group__1 : rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 ;
    public final void rule__DecimalDot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2774:1: ( rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2775:2: rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__15544);
            rule__DecimalDot__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__15547);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2782:1: rule__DecimalDot__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalDot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2786:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2787:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2787:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2788:1: RULE_INT
            {
             before(grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl5574); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2799:1: rule__DecimalDot__Group__2 : rule__DecimalDot__Group__2__Impl ;
    public final void rule__DecimalDot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2803:1: ( rule__DecimalDot__Group__2__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2804:2: rule__DecimalDot__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__25603);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2810:1: rule__DecimalDot__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalDot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2814:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2815:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2815:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2816:1: '.'
            {
             before(grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 
            match(input,33,FOLLOW_33_in_rule__DecimalDot__Group__2__Impl5631); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2835:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2839:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2840:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__05668);
            rule__DecimalExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__05671);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2847:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2851:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2852:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2852:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2853:1: ( rule__DecimalExp__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2854:1: ( rule__DecimalExp__Alternatives_0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=15 && LA24_0<=16)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2854:2: rule__DecimalExp__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl5698);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2864:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2868:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2869:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__15729);
            rule__DecimalExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__15732);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2876:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2880:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2881:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2881:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2882:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl5759); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2893:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2897:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2898:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__25788);
            rule__DecimalExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__25791);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2905:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2909:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2910:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2910:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2911:1: '.'
            {
             before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            match(input,33,FOLLOW_33_in_rule__DecimalExp__Group__2__Impl5819); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2924:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2928:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2929:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__35850);
            rule__DecimalExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__35853);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2936:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2940:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2941:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2941:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2942:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl5880); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2953:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2957:1: ( rule__DecimalExp__Group__4__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2958:2: rule__DecimalExp__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__45909);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2964:1: rule__DecimalExp__Group__4__Impl : ( RULE_EXP ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2968:1: ( ( RULE_EXP ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2969:1: ( RULE_EXP )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2969:1: ( RULE_EXP )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2970:1: RULE_EXP
            {
             before(grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 
            match(input,RULE_EXP,FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl5936); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2991:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2995:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:2996:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__05975);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__05978);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3003:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3007:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3008:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3008:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3009:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl6005); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3020:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3024:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3025:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__16034);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3031:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3035:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3036:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3036:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3037:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3038:1: ( rule__FQN__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==33) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3038:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl6061);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3052:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3056:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3057:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__06096);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__06099);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3064:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3068:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3069:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3069:1: ( '.' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3070:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,33,FOLLOW_33_in_rule__FQN__Group_1__0__Impl6127); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3083:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3087:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3088:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__16158);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3094:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3098:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3099:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3099:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3100:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl6185); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3116:1: rule__Annotation__TypeAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__Annotation__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3120:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3121:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3121:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3122:1: ( ruleFQN )
            {
             before(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3123:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3124:1: ruleFQN
            {
             before(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeFQNParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__Annotation__TypeAssignment_16227);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3135:1: rule__Annotation__AttributesAssignment_2_1 : ( ruleKeyValue ) ;
    public final void rule__Annotation__AttributesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3139:1: ( ( ruleKeyValue ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3140:1: ( ruleKeyValue )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3140:1: ( ruleKeyValue )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3141:1: ruleKeyValue
            {
             before(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleKeyValue_in_rule__Annotation__AttributesAssignment_2_16262);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3150:1: rule__Annotation__AttributesAssignment_2_2_1 : ( ruleKeyValue ) ;
    public final void rule__Annotation__AttributesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3154:1: ( ( ruleKeyValue ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3155:1: ( ruleKeyValue )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3155:1: ( ruleKeyValue )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3156:1: ruleKeyValue
            {
             before(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_ruleKeyValue_in_rule__Annotation__AttributesAssignment_2_2_16293);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3165:1: rule__KeyValue__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3169:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3170:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3170:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3171:1: RULE_ID
            {
             before(grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__KeyValue__KeyAssignment_06324); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3180:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3184:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3185:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3185:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3186:1: ruleLiteral
            {
             before(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__KeyValue__ValueAssignment_26355);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3201:1: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__SimpleAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3205:1: ( ( ( 'optional' ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3206:1: ( ( 'optional' ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3206:1: ( ( 'optional' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3207:1: ( 'optional' )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3208:1: ( 'optional' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3209:1: 'optional'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,34,FOLLOW_34_in_rule__SimpleAnnotationAttribute__OptionalAssignment_0_06397); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3224:1: rule__SimpleAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3228:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3229:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3229:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3230:1: RULE_ID
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleAnnotationAttribute__NameAssignment_26436); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3239:1: rule__SimpleAnnotationAttribute__TypeAssignment_4 : ( ruleLiteralType ) ;
    public final void rule__SimpleAnnotationAttribute__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3243:1: ( ( ruleLiteralType ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3244:1: ( ruleLiteralType )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3244:1: ( ruleLiteralType )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3245:1: ruleLiteralType
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleLiteralType_in_rule__SimpleAnnotationAttribute__TypeAssignment_46467);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3254:1: rule__EnumAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__EnumAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3258:1: ( ( ( 'optional' ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3259:1: ( ( 'optional' ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3259:1: ( ( 'optional' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3260:1: ( 'optional' )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3261:1: ( 'optional' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3262:1: 'optional'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,34,FOLLOW_34_in_rule__EnumAnnotationAttribute__OptionalAssignment_0_06503); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3277:1: rule__EnumAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EnumAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3281:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3282:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3282:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3283:1: RULE_ID
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EnumAnnotationAttribute__NameAssignment_26542); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3292:1: rule__EnumAnnotationAttribute__ValuesAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3296:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3297:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3297:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3298:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_56573); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3307:1: rule__EnumAnnotationAttribute__ValuesAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3311:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3312:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3312:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3313:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_6_16604); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3324:1: rule__Documentation__LinesAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Documentation__LinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3328:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3329:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3329:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3330:1: RULE_STRING
            {
             before(grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Documentation__LinesAssignment_26637); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3341:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3345:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3346:1: ( ( 'true' ) )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3346:1: ( ( 'true' ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3347:1: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3348:1: ( 'true' )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3349:1: 'true'
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            match(input,35,FOLLOW_35_in_rule__BooleanLiteral__IsTrueAssignment_1_16675); 
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3364:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3368:1: ( ( ruleReal ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3369:1: ( ruleReal )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3369:1: ( ruleReal )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3370:1: ruleReal
            {
             before(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_16714);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3379:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3383:1: ( ( ruleInteger ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3384:1: ( ruleInteger )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3384:1: ( ruleInteger )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3385:1: ruleInteger
            {
             before(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_16745);
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
    // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3394:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3398:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3399:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3399:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.common.ui/src-gen/org/eclipse/etrice/core/common/ui/contentassist/antlr/internal/InternalBase.g:3400:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_16776); 
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
        "\3\6\1\41\1\uffff\1\6\1\uffff\1\7\2\uffff";
    static final String DFA9_maxS =
        "\4\41\1\uffff\1\30\1\uffff\1\30\2\uffff";
    static final String DFA9_acceptS =
        "\4\uffff\1\2\1\uffff\1\3\1\uffff\1\1\1\4";
    static final String DFA9_specialS =
        "\12\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\3\10\uffff\1\1\1\2\20\uffff\1\4",
            "\1\3\32\uffff\1\4",
            "\1\3\32\uffff\1\4",
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
            return "974:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );";
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
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN424 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0_in_ruleDocumentation517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral548 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral608 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral728 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral848 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger908 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integer__Alternatives_in_ruleInteger941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger973 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal1042 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal1105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Real__Alternatives_in_ruleReal1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal1170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1239 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1308 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1377 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralType__Alternatives_in_ruleLiteralType1511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__OptionalAssignment_0_0_in_rule__SimpleAnnotationAttribute__Alternatives_01596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__SimpleAnnotationAttribute__Alternatives_01615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__OptionalAssignment_0_0_in_rule__EnumAnnotationAttribute__Alternatives_01649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__EnumAnnotationAttribute__Alternatives_01668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives1738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__BooleanLiteral__Alternatives_11771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_11790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives1872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives1889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__SignedInteger__Alternatives_01922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__SignedInteger__Alternatives_01942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_rule__Real__Alternatives1976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives1993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Decimal__Alternatives_02060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Decimal__Alternatives_02080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DotDecimal__Alternatives_02115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DotDecimal__Alternatives_02135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalDot__Alternatives_02170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalDot__Alternatives_02190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalExp__Alternatives_02225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DecimalExp__Alternatives_02245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__LiteralType__Alternatives2280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__LiteralType__Alternatives2301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__LiteralType__Alternatives2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__LiteralType__Alternatives2343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group__0__Impl_in_rule__Annotation__Group__02376 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Annotation__Group__1_in_rule__Annotation__Group__02379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Annotation__Group__0__Impl2407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group__1__Impl_in_rule__Annotation__Group__12438 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Annotation__Group__2_in_rule__Annotation__Group__12441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__TypeAssignment_1_in_rule__Annotation__Group__1__Impl2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group__2__Impl_in_rule__Annotation__Group__22498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__0_in_rule__Annotation__Group__2__Impl2525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__0__Impl_in_rule__Annotation__Group_2__02562 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__1_in_rule__Annotation__Group_2__02565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Annotation__Group_2__0__Impl2593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__1__Impl_in_rule__Annotation__Group_2__12624 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__2_in_rule__Annotation__Group_2__12627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__AttributesAssignment_2_1_in_rule__Annotation__Group_2__1__Impl2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__2__Impl_in_rule__Annotation__Group_2__22684 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__3_in_rule__Annotation__Group_2__22687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2_2__0_in_rule__Annotation__Group_2__2__Impl2714 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2__3__Impl_in_rule__Annotation__Group_2__32745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Annotation__Group_2__3__Impl2773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2_2__0__Impl_in_rule__Annotation__Group_2_2__02812 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2_2__1_in_rule__Annotation__Group_2_2__02815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Annotation__Group_2_2__0__Impl2843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__Group_2_2__1__Impl_in_rule__Annotation__Group_2_2__12874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotation__AttributesAssignment_2_2_1_in_rule__Annotation__Group_2_2__1__Impl2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__0__Impl_in_rule__KeyValue__Group__02935 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__1_in_rule__KeyValue__Group__02938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__KeyAssignment_0_in_rule__KeyValue__Group__0__Impl2965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__1__Impl_in_rule__KeyValue__Group__12995 = new BitSet(new long[]{0x0000000A0001C160L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__2_in_rule__KeyValue__Group__12998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__KeyValue__Group__1__Impl3026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__2__Impl_in_rule__KeyValue__Group__23057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__ValueAssignment_2_in_rule__KeyValue__Group__2__Impl3084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__0__Impl_in_rule__SimpleAnnotationAttribute__Group__03123 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__1_in_rule__SimpleAnnotationAttribute__Group__03126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Alternatives_0_in_rule__SimpleAnnotationAttribute__Group__0__Impl3153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__1__Impl_in_rule__SimpleAnnotationAttribute__Group__13183 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__2_in_rule__SimpleAnnotationAttribute__Group__13186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SimpleAnnotationAttribute__Group__1__Impl3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__2__Impl_in_rule__SimpleAnnotationAttribute__Group__23245 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__3_in_rule__SimpleAnnotationAttribute__Group__23248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__NameAssignment_2_in_rule__SimpleAnnotationAttribute__Group__2__Impl3275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__3__Impl_in_rule__SimpleAnnotationAttribute__Group__33305 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__4_in_rule__SimpleAnnotationAttribute__Group__33308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__SimpleAnnotationAttribute__Group__3__Impl3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__4__Impl_in_rule__SimpleAnnotationAttribute__Group__43367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__TypeAssignment_4_in_rule__SimpleAnnotationAttribute__Group__4__Impl3394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__0__Impl_in_rule__EnumAnnotationAttribute__Group__03434 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__1_in_rule__EnumAnnotationAttribute__Group__03437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Alternatives_0_in_rule__EnumAnnotationAttribute__Group__0__Impl3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__1__Impl_in_rule__EnumAnnotationAttribute__Group__13494 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__2_in_rule__EnumAnnotationAttribute__Group__13497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__EnumAnnotationAttribute__Group__1__Impl3525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__2__Impl_in_rule__EnumAnnotationAttribute__Group__23556 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__3_in_rule__EnumAnnotationAttribute__Group__23559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__NameAssignment_2_in_rule__EnumAnnotationAttribute__Group__2__Impl3586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__3__Impl_in_rule__EnumAnnotationAttribute__Group__33616 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__4_in_rule__EnumAnnotationAttribute__Group__33619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__EnumAnnotationAttribute__Group__3__Impl3647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__4__Impl_in_rule__EnumAnnotationAttribute__Group__43678 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__5_in_rule__EnumAnnotationAttribute__Group__43681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__EnumAnnotationAttribute__Group__4__Impl3709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__5__Impl_in_rule__EnumAnnotationAttribute__Group__53740 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__6_in_rule__EnumAnnotationAttribute__Group__53743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_5_in_rule__EnumAnnotationAttribute__Group__5__Impl3770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__6__Impl_in_rule__EnumAnnotationAttribute__Group__63800 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__7_in_rule__EnumAnnotationAttribute__Group__63803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__0_in_rule__EnumAnnotationAttribute__Group__6__Impl3830 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__7__Impl_in_rule__EnumAnnotationAttribute__Group__73861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__EnumAnnotationAttribute__Group__7__Impl3889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__0__Impl_in_rule__EnumAnnotationAttribute__Group_6__03936 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__1_in_rule__EnumAnnotationAttribute__Group_6__03939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__EnumAnnotationAttribute__Group_6__0__Impl3967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__1__Impl_in_rule__EnumAnnotationAttribute__Group_6__13998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_6_1_in_rule__EnumAnnotationAttribute__Group_6__1__Impl4025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__04061 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__04064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl4091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__14120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ImportedFQN__Group__1__Impl4149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__04186 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__04189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__14247 = new BitSet(new long[]{0x0000000100000100L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__14250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Documentation__Group__1__Impl4278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__24309 = new BitSet(new long[]{0x0000000100000100L});
    public static final BitSet FOLLOW_rule__Documentation__Group__3_in_rule__Documentation__Group__24312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__LinesAssignment_2_in_rule__Documentation__Group__2__Impl4339 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_rule__Documentation__Group__3__Impl_in_rule__Documentation__Group__34370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Documentation__Group__3__Impl4398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__04443 = new BitSet(new long[]{0x0000000800004000L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__04446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__14504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl4531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__04565 = new BitSet(new long[]{0x0000000200018060L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__04568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__14626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl4653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__04687 = new BitSet(new long[]{0x0000000000018060L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__04690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__14748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl4775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__04809 = new BitSet(new long[]{0x0000000A0001C160L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__04812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__14870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl4897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__04931 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__04934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl4961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__14992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl5019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__05052 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__05055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl5082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__15113 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__15116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl5143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__25172 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__25175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Decimal__Group__2__Impl5203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__35234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl5261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__05298 = new BitSet(new long[]{0x0000000200018000L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__05301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl5328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__15359 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__15362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__DotDecimal__Group__1__Impl5390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__25421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl5448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__05483 = new BitSet(new long[]{0x0000000000018040L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__05486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl5513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__15544 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__15547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl5574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__25603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__DecimalDot__Group__2__Impl5631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__05668 = new BitSet(new long[]{0x0000000200018060L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__05671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl5698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__15729 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__15732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl5759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__25788 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__25791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__DecimalExp__Group__2__Impl5819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__35850 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__35853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl5880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__45909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl5936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__05975 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__05978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl6005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__16034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl6061 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__06096 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__06099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__FQN__Group_1__0__Impl6127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__16158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl6185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Annotation__TypeAssignment_16227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_rule__Annotation__AttributesAssignment_2_16262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_rule__Annotation__AttributesAssignment_2_2_16293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__KeyValue__KeyAssignment_06324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__KeyValue__ValueAssignment_26355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__SimpleAnnotationAttribute__OptionalAssignment_0_06397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleAnnotationAttribute__NameAssignment_26436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralType_in_rule__SimpleAnnotationAttribute__TypeAssignment_46467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__EnumAnnotationAttribute__OptionalAssignment_0_06503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EnumAnnotationAttribute__NameAssignment_26542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_56573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_6_16604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Documentation__LinesAssignment_26637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__BooleanLiteral__IsTrueAssignment_1_16675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_16714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_16745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_16776 = new BitSet(new long[]{0x0000000000000002L});

}